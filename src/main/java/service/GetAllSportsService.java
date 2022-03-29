/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Broker.Broker;
import db.DbConn;
import domain.Sport;
import java.util.List;

/**
 *
 * @author David Sjöblom
 */
public class GetAllSportsService extends BaseService<List<Sport>> {

    @Override
    public List<Sport> execute() {
        List<Sport> list = (List<Sport>) this.getBroker().getSportBroker().findAll();
        return list;
    }
}
