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
    public int getResultID() {
        return cf.getInteger(result, "id");
    }

    public int getResultMatchID() {
        return cf.getInteger(result, "match_id");
    }

    public int getResultTeamOneScore() {
        return cf.getInteger(result, "team_one_score");
    }

    public int getResultTeamTwoScore() {
        return cf.getInteger(result, "team_two_score");
    }

    public void setMatchId(int id) {
        result.set("match_id", id);
    }

    public void setTeamOneScore(int score) {
        result.set("team_one_score", score);
    }

    public void setTeamTwoScore(int score) {
        result.set("team_two_score", score);
    }

}
