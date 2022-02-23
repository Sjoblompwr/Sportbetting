/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;


import records.ResultRecord;

/**
 * Result object inheriting from the model class. With some added methods for
 * "comfort"
 *
 * @author David Sjöblom
 */
public class Result {
    private final ResultRecord result;
    public Result(){
        this(new ResultRecord());
    }
    public Result(ResultRecord record){
        this.result = record;
    }
    /**
     * get all result table content
     *
     * @return
     */
    public int getResultID() {
        return Integer.parseInt(result.getString("id"));
    }

    public int getResultMatchID() {
        return Integer.parseInt(result.getString("match_id"));
    }

    public int getResultTeamOneScore() {
        return Integer.parseInt(result.getString("team_one_score"));
    }

    public int getResultTeamTwoScore() {
        return Integer.parseInt(result.getString("team_two_score"));
    }

}
