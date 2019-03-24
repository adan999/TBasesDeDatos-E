package com.uabc.database.example.examplejpa.services.impl;

import com.uabc.database.example.examplejpa.components.LogConverter;
import com.uabc.database.example.examplejpa.entity.Log;
import com.uabc.database.example.examplejpa.model.LogModel;
import com.uabc.database.example.examplejpa.respository.LogRepository;
import com.uabc.database.example.examplejpa.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("logServiceImpl")
public class LogServiceImpl implements LogService {
    @Autowired
    @Qualifier("logRepository")
    private LogRepository logRepository;

    @Autowired
    @Qualifier("logConverter")
    private LogConverter logConverter;


    @Override
    public LogModel addLog(LogModel logModel) throws Exception {
        //Aquí nos pide una entidad, por lo tanto tenemos que transformar el logModel a entidad
        Log temp=logConverter.convertToLogModel2Log(logModel);
        Log log = logRepository.save(temp);
        return logConverter.convertToLog2LogModel(log);
    }

    @Override
    public List<LogModel> listAllLogs() {
        List<Log> logs = logRepository.findAll();
        List<LogModel> logModel = new ArrayList();
        for(Log log : logs){
            logModel.add(logConverter.convertToLog2LogModel(log));

        }
        return logModel;
    }

    @Override
    public Log findLogById(int id) {
        return logRepository.findById(id);
    }

    public LogModel findLogByIdModel(int id){
        return logConverter.convertToLog2LogModel(findLogById(id));
    }

    @Override
    public void removeLog(int id) {
        Log log  = findLogById(id);
        if(log != null){
            logRepository.delete(findLogById(id));
        }
    }

}
