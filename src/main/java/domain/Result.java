/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.List;
import java.util.stream.Collectors;
import records.ResultRecord;

/**
 * Result object , getting database connection throught the Record input. Which
 * Should extend Model.
 *
 * @author David Sjöblom
 */
public class Result implements BetObject {


    
    private final ResultRecord result;
    
    /**
     *
     */
    public Result() {
        this(new ResultRecord());
    }
    
    /**
     *
     * @param record
     */
    public Result(ResultRecord record) {
        this.result = record;
    }

    /**
     * get all result table content
     *
     * @return
     */
    public int getId() {
        return CommonFunctions.getInteger(result, "id");
    }
    
    /**
     *
     * @return
     */
    public int getMatchId() {
        return CommonFunctions.getInteger(result, "match_id");
    }
    
    /**
     *
     * @return
     */
    public int getTeamOneScore() {
        return CommonFunctions.getInteger(result, "team_one_score");
    }
    
    /**
     *
     * @return
     */
    public int getTeamTwoScore() {
        return CommonFunctions.getInteger(result, "team_two_score");
    }
    
    /**
     *
     * @param id
     */
    public void setMatchId(int id) {
        CommonFunctions.setInteger(result, "match_id", id);
    }
    
    /**
     *
     * @param score
     */
    public void setTeamOneScore(int score) {
        CommonFunctions.setInteger(result, "team_one_score", score);
    }
    
    /**
     *
     * @param score
     */
    public void setTeamTwoScore(int score) {
        CommonFunctions.setInteger(result, "team_two_score", score);
    }

    /**
     * Current error handling; null, whitespaces and result already existing.
     *
     * @return 
     * @throws domain.ExceptionClass 
     */
    public boolean insert() throws ExceptionClass {
        CommonFunctions.setInteger(result, "id", ResultRecord.count().intValue() + 1);
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
     * @return 
     */
    public static List<Result> findAll() {
        List<ResultRecord> resultRecordList = ResultRecord.findAll();
        return resultRecordList.stream().map(record -> new Result(record)).collect(Collectors.toList());
    }
    
    public static List<Result> findAllSQL(String query, String arg) {
        List<ResultRecord> resultRecordList = ResultRecord.findBySQL(query, arg);
        return resultRecordList.stream().map(record->new Result(record)).collect(Collectors.toList());
    } 
    /**
     *
     * @param x
     * @return
     */
    public static Result findById(int x) {
        return new Result(ResultRecord.findById(x));
    }
    
}
