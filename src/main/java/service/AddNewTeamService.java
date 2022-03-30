/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.ExceptionClass;
import domain.Team;

/**
 *
 * @author David Sjöblom
 */
public class AddNewTeamService extends BaseService<Boolean> {

    private int sport_id;
    private int season_id;
    private int league_id;
    private String name;

    public AddNewTeamService(int sport_id, int season_id, int league_id, String name) {
        setId(sport_id, "sport");
        setId(season_id, "season");
        setId(league_id, "league");
        setName(name);
    }

    @Override
    public Boolean execute() {
        Team team = (Team) getBroker().getTeamBroker().create();
        try {
            team.setName(name);
        } catch (ExceptionClass ex) {
            throw new IllegalArgumentException(ex.toString());
        }
        team.setLeagueId(league_id);
        boolean bool = team.insert();
        return bool;
    }

    /**
     *
     * @param id
     * @param table must be league,sport,season otherwise there will be no
     * input.
     */
    public void setId(int id, String table) {
        table.toLowerCase();
        if (id < 1) {
            throw new IllegalArgumentException("Ids must be above 0.");
        }
        switch (table) {
            case "league":
                this.league_id = id;
            case "sport":
                this.sport_id = id;
            case "season":
                this.season_id = id;
        }
    }

    public void setName(String name) {
        this.name = name;
    }
}
