/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Broker.Broker;
import db.DbConn;

/**
 *
 * @author David Sjöblom
 */
public abstract class BaseService<T> implements SportstatsService<T> {

    protected Broker broker;

    @Override
    public void init(Broker broker) {
        if (broker == null) {
            throw new NullPointerException("Broker has not been initialized. (null)");
        }
        this.broker = broker;
    }

    @Override
    public abstract T execute();

}
