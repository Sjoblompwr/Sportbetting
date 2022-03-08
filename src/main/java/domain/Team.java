/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.List;
import java.util.stream.Collectors;
import records.TeamRecord;

/**
 * Team object inheriting from the model class. With some added methods for
 * "comfort"
 *
 * @author David Sjöblom
 */
public class Team implements BetObject {

    private final TeamRecord team;
    private final CommonFunctions cf = new CommonFunctions();

    public Team() {
        this(new TeamRecord());
    }

    public Team(TeamRecord record) {
        this.team = record;
    }

    /**
     * get all team table content
     *
     * @return
     */
    public int getId() {
        return cf.getInteger(team, "id");

    }

    public String getName() {
        return cf.getName(team);
    }

    public void setName(String name) throws ExceptionClass {

        cf.setName(name, team, TeamRecord.count().intValue() + 1);
    }

    public boolean insert() {
//        if (this.getId() == 0) {
//            throw new NullPointerException("Team id (name has not been selected) has not been assigned");
//        }
        for (Team t : Team.findAll()) {
            if (this.getName().equals(t.getName())) {
                System.out.println("Team already exist.");
                return false;
            }
        }
        return team.insert();
    }

    /**
     * Attitional stuff to get main to work as is.
     */
    public static List<Team> findAll() {
        List<TeamRecord> teamRecordList = TeamRecord.findAll();
        return teamRecordList.stream().map(record -> new Team(record)).collect(Collectors.toList());
//        return (List<Team>) (List<?>)cf.findAll(team);
    }

    public static Team findById(int x) {
        return new Team(TeamRecord.findById(x));
    }

}
