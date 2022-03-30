/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.Season;
import java.util.List;

/**
 * Return list of seasons based on sport_id
 *
 * @author David Sjöblom
 */
public class GetAllSeasonsBySportIdService extends BaseService<List<Season>> {

    private int id;

    public GetAllSeasonsBySportIdService(int id) {
        setId(id);
    }

    public void setId(int id) {
        if (id < 1) {
            throw new IllegalArgumentException("Id must be above 0.");
        }
    }

    @Override
    public List<Season> execute() {
        List<Season> list = (List<Season>) getBroker().getSeasonBroker()
                .findAllSQL("SELECT * FROM seasons WHERE sport_id = ?", Integer.toString(id));
        return list;
    }
}
