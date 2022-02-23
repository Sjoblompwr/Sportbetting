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
 public class League {
        private final LeagueRecord league;
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
        public int getLeagueID() {
            return Integer.parseInt(league.getString("id"));
        }

        public String getLeagueName() {
            return league.getString("name");
        }

        public int getSeasonId() {
            return Integer.parseInt(league.getString("season_id"));
        }
    }
