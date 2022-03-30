/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.League;
import java.util.List;

/**
 *
 * @author David Sjöblom
 */
public class GetAllLeaguesBySeasonIdService extends BaseService<List<League>>{

    private int id;
    
    public GetAllLeaguesBySeasonIdService(int id){
        setId(id);
    }
    public void setId(int id){
        if(id < 0){
            throw new IllegalArgumentException("Id must be above 0.");
        }
        this.id = id;
    }
    @Override
    public List<League> execute() {
        List<League> list = (List<League>) getBroker().getLeagueBroker()
                .findAllSQL("SELECT * FROM leagues WHERE season_id = ?", Integer.toString(id));
        return list;
    }
}
