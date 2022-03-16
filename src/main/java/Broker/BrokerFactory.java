/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Broker;

import domain.BetObject;
import java.util.List;

/**
 *
 * @author Dator
 */
public interface BrokerFactory {

    public BetObject findById(int id);
    public List<? extends BetObject> findAllSQL(String query,String arg);
    public BetObject create();
    public List<? extends BetObject> findAll();

}
