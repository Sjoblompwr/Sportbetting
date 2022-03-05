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
    public int getTeamID() {
        return cf.getInteger(team, "id");

    }

    public String getName() {
        return team.getString("name");
    }
//    //Can implement error handling from sport
//    public void setName(String name)throws ExceptionClass {
//        
//        name = name.trim();
//        name = CommonFunctions.excessWhitespaceRemover(name);
//        
//            if (name.isBlank()) {
//                throw new ExceptionClass("Input may not only be whitespaces.");
//            }
//            if (!name.matches("[a-zA-Z]+")) {
//                throw new ExceptionClass("Use of invalid characters.");
//            }
//            
//            team.set("name", name);
//            team.set("id", TeamRecord.count().intValue() + 1); // This causes error in the testing phase. But works in practice, trust me :)
//    }

    public void setName(String name) throws ExceptionClass {

        cf.setName(name, team, TeamRecord.count().intValue() + 1);
    }

    /**
     * Current error handling; null, whitespaces and sport already existing.
     *
     */
    public boolean insert() {
        if (this.getName() == null) {
            throw new NullPointerException("Sport name has not been assigned");
        }

        for (Team t : Team.findAll()) {
            if (this.getName().equals(t.getName())) {
                System.out.println("Team already exist."); //Should probebly be some sort of exception instead.
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

    public void saveit() {
        team.set("id", TeamRecord.count().intValue() + 1);
        team.save();
    }

}
