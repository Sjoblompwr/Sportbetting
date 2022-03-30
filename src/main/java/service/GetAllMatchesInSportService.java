/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.League;
import domain.Match;
import domain.Season;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Gets all Season by SportId & gets all Leagues with every SeasonId If leagues
 * exist, return matches otherwise null.
 *
 * @author David Sjöblom
 */
public class GetAllMatchesInSportService extends BaseService<List<Match>> {

    private int id;

    public GetAllMatchesInSportService(int id) {
        setId(id);
    }

    public void setId(int id) {
        if (id < 1) {
            throw new IllegalArgumentException("Id must be above 0.");
        }
        this.id = id;
    }

    @Override
    public List<Match> execute() {
        List<Season> seasons;
        List<League> leagues = new ArrayList<>();
        List<Match> matches = new ArrayList<>();

        GetAllSeasonsBySportIdService getAllSeasonsBySportId = new GetAllSeasonsBySportIdService(id);
        getAllSeasonsBySportId.init(getBroker());
        seasons = getAllSeasonsBySportId.execute();

        GetAllLeaguesBySeasonIdService getAllLeaguesBySeasonId = new GetAllLeaguesBySeasonIdService(id);
        getAllLeaguesBySeasonId.init(getBroker());
        for (Season s : seasons) {
            getAllLeaguesBySeasonId.setId(s.getId());
            leagues.addAll(getAllLeaguesBySeasonId.execute());
        }
        //Avoid opening db if input is zero/null.
        if (!leagues.isEmpty()) {
            for (League l : leagues) {
                matches.addAll((Collection<? extends Match>) getBroker().getMatchBroker().findAllSQL("SELECT * FROM matches WHERE league_id = ?", Integer.toString(l.getId())));
            }
        }
        return matches;
    }
}
