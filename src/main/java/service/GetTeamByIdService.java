package service;

import domain.ExceptionClass;
import domain.Team;

/**
 *
 * @author Dator
 */
public class GetTeamByIdService extends BaseService<Team> {

    private final int id;

    public GetTeamByIdService(int id) {
        if (id < 1) {
            throw new IllegalArgumentException("id needs to be above 0");
        } else {
            this.id = id;
        }
    }

    @Override
    public Team execute() {
        Team team;
        team = (Team) getBroker().getTeamBroker().findById(id);
        return team;
    }

}
