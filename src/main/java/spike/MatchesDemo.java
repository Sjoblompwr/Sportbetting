/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import db.DbConn;
import domain.League;
import domain.Match;
import domain.Result;
import domain.Season;
import domain.Sport;
import domain.Team;
import java.util.List;
import java.util.Random;

/**
 * Some examples of database interaction through activejdbc functions. Aswell as
 * some example console output. System is build around a sport system involving
 * the classes match,result, season,sport and team. Error handling is not
 * properly implemented and code is meant to work as is with changes may result
 * in program failure.
 * Latest changes: 2022-02-14
 * @author David Sjöblom
 */
public class MatchesDemo {

    public static void main(String[] args) {
        DbConn dbConn = DbConn.getInstance();
        dbConn.open();
        Match match = new Match();
        Result result = new Result();
        League league = new League();
        Season season = new Season();
        Sport sport = new Sport();
        Team team = new Team();

        boolean insertSuccessBool = false;
        //Create a sport
        try {
            sport.set("id", 1);
            sport.set("name", "Hockey");

            insertSuccessBool = sport.insert();
            if (insertSuccessBool) {
                System.out.println("Sport added to database");
            }
        } catch (Exception e) {
        }
        //Create Season
        try {
            season.set("id", 1);
            season.set("year", "2000");
            season.set("sport_id", 1);

            insertSuccessBool = season.insert();
            if (insertSuccessBool) {
                System.out.println("Season added to database");
            }
        } catch (Exception e) {

        }
        //Create League
        try {
            league.set("id", 1);
            league.set("name", "Knatteligan");
            league.set("season_id", 1);

            insertSuccessBool = league.insert();
            if (insertSuccessBool) {
                System.out.println("League added to database");
            }
        } catch (Exception e) {

        }
        //Create two teams
        try {
            team.set("id", 1);
            team.set("name", "Ducks");

            insertSuccessBool = team.insert();
            if (insertSuccessBool) {
                System.out.println("Team 1 added to database");
            }

            team.set("id", 2);
            team.set("name", "Horses");

            insertSuccessBool = team.insert();
            if (insertSuccessBool) {
                System.out.println("Team 2 added to database");
            }
        } catch (Exception e) {

        }
        //Inserting 'i' matches between same teams
        try {
            for (int i = 0; i < 10; i++) {
                //   if (!(i == matchIns.getLongId())) {
                match.set("id", i + 1);
                match.set("league_id", 1);
                match.set("team_one_id", 1);
                match.set("team_two_id", 2);

                insertSuccessBool = match.insert();
                if (insertSuccessBool) {
                    System.out.println("Match added to database");
                }
            }
        } catch (Exception e) {

        }
        //Creating some random results for the 2 teams
        try {
            Random rand = new Random();
            for (int i = 0; i < 8; i++) {
                result.set("id", i + 1);
                result.set("match_id", i + 1);
                result.set("team_one_score", rand.nextInt(11));
                result.set("team_two_score", rand.nextInt(11));

                insertSuccessBool = result.insert();
                if (insertSuccessBool) {
                    System.out.println("Result in database");
                }

            }
        } catch (Exception e) {

        }
        /**
         * Following code block is test code for console output, some with
         * database interaction and some with hardcoded input.
         */
        sport = Sport.findById(1);
        System.out.println(sport.getSportName());

        List<Team> teamList = Team.find("name = ?", "Ducks");
        List<Match> matchList = Match.find("team_one_id = ? ", teamList.get(0).getTeamID());
        //Collecting all games where team_one_id, "Ducks" has lost.
        List<Result> resultList = Result.where("team_one_score < team_two_score && match_id > 0 && match_id <= ?", matchList.get(matchList.size() - 1).getMatchID());

        for (Team t : teamList) {
            System.out.println("Ducks id:" + t.getTeamID());
        }
        for (Match m : matchList) {
            System.out.println("Match id:" + m.getMatchID());
        }
        for (Result r : resultList) {
            System.out.println("Ducks " + r.getResultTeamOneScore() + "-" + r.getResultTeamTwoScore() + " Horses");
        }
        //Collectiong all games where team_one_id, "Ducks" has won.
        resultList = Result.where("team_one_score > team_two_score && match_id > 0 && match_id <= ?", matchList.get(matchList.size() - 1).getMatchID());
        for (Result r : resultList) {
            System.out.println("Ducks " + r.getResultTeamOneScore() + "-" + r.getResultTeamTwoScore() + " Horses");
        }
        //Collecting all games where team_one_id, "Ducks" have tied.
        resultList = Result.where("team_one_score = team_two_score && match_id > 0 && match_id <= ?", matchList.get(matchList.size() - 1).getMatchID());
        System.out.printf("Number of tie games: %d\n", resultList.size());
        for (Result r : resultList) {
            System.out.printf("Which had the score: %s %d : %d %s\n", (String) Team.find("id = ?", 1).get(0).getString("name"), r.getResultTeamOneScore(), r.getResultTeamTwoScore(), (String) Team.find("id = ?", 2).get(0).getString("name"));
        }
        dbConn.close();

    }
}
