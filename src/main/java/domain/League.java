/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import org.javalite.activejdbc.Model;

/**
 * League object inheriting from the model class.
 * With some added methods for "comfort"
 * @author David Sjöblom
 */
 public class League extends Model {

        /**
         * get all league table content
         *
         * @return
         */
        public int getLeagueID() {
            return Integer.parseInt(getString("id"));
        }

        public String getLeagueName() {
            return getString("name");
        }

        public int getSeasonId() {
            return Integer.parseInt(getString("season_id"));
        }
    }
