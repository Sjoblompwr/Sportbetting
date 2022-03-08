/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.List;
import java.util.stream.Collectors;
import records.ResultRecord;

/**
 * Result object inheriting from the model class. With some added methods for
 * "comfort"
 *
 * @author David Sjöblom
 */
public class Result implements BetObject {
    
    private final ResultRecord result;
    private final CommonFunctions cf = new CommonFunctions();
    
    public Result() {
        this(new ResultRecord());
    }
    
    public Result(ResultRecord record) {
        this.result = record;
    }

    /**
     * get all result table content
     *
     * @return
     */
    public int getId() {
        return cf.getInteger(result, "id");
    }
    
    public int getMatchId() {
        return cf.getInteger(result, "match_id");
    }
    
    public int getTeamOneScore() {
        return cf.getInteger(result, "team_one_score");
    }
    
    public int getTeamTwoScore() {
        return cf.getInteger(result, "team_two_score");
    }
    
    public void setMatchId(int id) {
        cf.setInteger(result, "match_id", id);
    }
    
    public void setTeamOneScore(int score) {
        cf.setInteger(result, "team_one_score", score);
    }
    
    public void setTeamTwoScore(int score) {
        cf.setInteger(result, "team_two_score", score);
    }

    /**
     * Current error handling; null, whitespaces and sport already existing.
     *
     */
    public boolean insert() throws ExceptionClass {
        cf.setInteger(result, "id", ResultRecord.count().intValue() + 1);
//        if (this.getId() == 0) {
//            throw new NullPointerException("Something is wrong with the automatic assigning of id value.");
//        }
        for (Result r : Result.findAll()) {
            if (this.getMatchId() == r.getMatchId()) {
                System.out.println("Match has a result(MatchId already exist)."); 
                return false;
            }
        }
        return result.insert();
    }

    /**
     * Attitional stuff to get main to work as is.
     */
    public static List<Result> findAll() {
        List<ResultRecord> resultRecordList = ResultRecord.findAll();
        return resultRecordList.stream().map(record -> new Result(record)).collect(Collectors.toList());
    }
    
    public static Result findById(int x) {
        return new Result(ResultRecord.findById(x));
    }
    
}
