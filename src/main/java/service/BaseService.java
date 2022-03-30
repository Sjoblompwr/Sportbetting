/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Broker.Broker;

/**
 *
 * @author David Sjöblom
 */
public abstract class BaseService<T> implements SportstatsService<T> {

    private Broker broker;

    @Override
    public final void init(Broker broker) {
        if (broker == null) {
            throw new NullPointerException("Broker may not have been initialized.");
        }
        this.broker = broker;
    }
    
    protected Broker getBroker(){
        return broker;
    }

    @Override
    public abstract T execute();

}
