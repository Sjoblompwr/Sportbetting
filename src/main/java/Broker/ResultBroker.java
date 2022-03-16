/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Broker;

import domain.BetObject;
import domain.Result;
import java.util.List;
import java.util.stream.Collectors;
import records.ResultRecord;

/**
 *
 * @author Dator
 */
public class ResultBroker implements BrokerFactory{

    @Override
    public List<Result> findAll() { 
    return ResultRecord.findAll().stream() 
            .map(rec -> new Result((ResultRecord) rec)) 
            .collect(Collectors.toList()); 
    } 
    @Override
    public Result findById(int resultId) { 
        return new Result(ResultRecord.findById(resultId)); 
    } 
     @Override
    public Result create() { 
        return new Result(new ResultRecord());  
    }

    @Override
    public List<Result> findAllSQL(String query, String arg) {
        return Result.findAllSQL(query,arg);
    }

    
}
