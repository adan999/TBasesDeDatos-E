package com.uabc.database.example.examplejpa.components;

import com.uabc.database.example.examplejpa.entity.Log;
import com.uabc.database.example.examplejpa.model.LogModel;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component("logConverter")
public class LogConverter {
    public Log convertToLogModel2Log(LogModel logModel) throws Exception{
        Log log = new Log();
        Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(logModel.getDate());
        log.setId(logModel.getId());
        log.setDate(fecha);
        log.setDetails(logModel.getDetails());
        log.setUsername(logModel.getUsername());
        log.setUrl(logModel.getUrl());
        return log;
    }

    public LogModel convertToLog2LogModel(Log log){
        LogModel logModel = new LogModel();
        logModel.setId(log.getId());
        logModel.setDate(log.getDate().toString());
        logModel.setDetails(log.getDetails());
        logModel.setUsername(log.getUsername());
        logModel.setUrl(log.getUrl());
        return logModel;
    }
}
