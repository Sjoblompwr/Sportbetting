/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import org.javalite.activejdbc.Model;
import records.LeagueRecord;

/**
 * League object inheriting from the model class.
 * With some added methods for "comfort"
 * @author David Sjöblom
 */
 public class League implements BetObject{
        private final LeagueRecord league;
        private final CommonFunctions cf = new CommonFunctions();
        public League(){
            this(new LeagueRecord()); // "snyggare" viss att skriva this.league = new LeagueRecord();
        }
        public League(LeagueRecord record){
            this.league = record;
        }
    
        /**
         * get all league table content
         *
         * @return
         */
        public int getId() {
            return Integer.parseInt(league.getString("id"));
        }

        public String getName() {
            return league.getString("name");
        }
        public void setName(String name) throws ExceptionClass{
            cf.setName(name, league, LeagueRecord.count().intValue() + 1);
        }

        public int getSeasonId() {
            return Integer.parseInt(league.getString("season_id"));
        }


    }
