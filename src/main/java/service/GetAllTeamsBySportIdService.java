/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.League;
import domain.Season;
import domain.Team;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Sjöblom
 */
public class GetAllTeamsBySportIdService extends BaseService<List<Team>> {

    private int id;

    public GetAllTeamsBySportIdService(int id) {
        if (id < 1) {
            throw new IllegalArgumentException("Id must be above 0.");
        }
        this.id = id;
    }

    @Override
    public List<Team> execute() {

        GetAllSeasonsBySportIdService getAllSeasonsBySportId
                = new GetAllSeasonsBySportIdService(id);
        getAllSeasonsBySportId.init(getBroker());
        List<Season> seasons = getAllSeasonsBySportId.execute();

        List<League> leagues = new ArrayList<>();
        List<Team> teams = new ArrayList<>();

        GetAllLeaguesBySeasonIdService getAllLeaguesBySeasonId
                = new GetAllLeaguesBySeasonIdService(id);
        getAllLeaguesBySeasonId.init(getBroker());

        for (Season s : seasons) {
            getAllLeaguesBySeasonId.setId(s.getId());
            leagues.addAll(getAllLeaguesBySeasonId.execute());
        }

        GetAllTeamsByLeagueIdService getAllTeamsByLeagueId
                = new GetAllTeamsByLeagueIdService(id);
        getAllTeamsByLeagueId.init(getBroker());
        for (League l : leagues) {
            getAllTeamsByLeagueId.setId(l.getId());
            teams.addAll(getAllTeamsByLeagueId.execute());
        }

        return teams;
    }

}
