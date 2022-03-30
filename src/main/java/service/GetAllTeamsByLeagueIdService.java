package service;

import domain.Team;
import java.util.List;

/**
 *
 * @author David Sjöblom
 */
public class GetAllTeamsByLeagueIdService extends BaseService<List<Team>>{

    private int id;
    public GetAllTeamsByLeagueIdService(int id){
        setId(id);
    }
    public void setId(int id){
        if(id < 1){
            throw new IllegalArgumentException("Id must be above 1.");
        }
        this.id = id;
    }
    @Override
    public List<Team> execute() {
        List<Team> list = (List<Team>) getBroker().getTeamBroker()
                .findAllSQL("SELECT * FROM teams WHERE league_id = ?",
                         Integer.toString(id));
        return list;
    }
}
