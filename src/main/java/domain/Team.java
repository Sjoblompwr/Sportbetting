/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import org.javalite.activejdbc.Model;
import records.TeamRecord;

/**
 * Team object inheriting from the model class. With some added methods for
 * "comfort"
 *
 * @author David Sjöblom
 */
public class Team {
    private final TeamRecord team;
    public Team(){
        this(new TeamRecord());
    }
    public Team(TeamRecord record){
        this.team = record;
    }
    /**
     * get all team table content
     *
     * @return
     */
    public int getTeamID() {
        return Integer.parseInt(team.getString("id"));
    }

    public String getTeamName() {
        return team.getString("name");
    }

}
