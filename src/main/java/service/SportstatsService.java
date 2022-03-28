/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import Broker.Broker;
import db.DbConn;

/**
 *
 * @author david
 */
public interface SportstatsService<T> {
    public void init(Broker broker);
    public T execute();
}
