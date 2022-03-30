/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.League;
import domain.Season;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Sjöblom
 */
public class GetAllLeaguesBySportIdService extends BaseService<List<League>> {

    private int id;

    public GetAllLeaguesBySportIdService(int id) {
        setId(id);
    }

    public void setId(int id) {
        if (id < 1) {
            throw new IllegalArgumentException("Id must be above 0.");
        }
        this.id = id;
    }

    @Override
    public List<League> execute() {
        List<Season> seasons;
        List<League> leagues = new ArrayList<>();

        GetAllSeasonsBySportIdService getAllSeasonsBySportId = new GetAllSeasonsBySportIdService(id);
        getAllSeasonsBySportId.init(getBroker());
        seasons = getAllSeasonsBySportId.execute();

        GetAllLeaguesBySeasonIdService getAllLeaguesBySeasonId = new GetAllLeaguesBySeasonIdService(id);
        getAllLeaguesBySeasonId.init(getBroker());
        for (Season s : seasons) {
            getAllLeaguesBySeasonId.setId(s.getId());
            leagues.addAll(getAllLeaguesBySeasonId.execute());
        }

        return leagues;
    }

}
