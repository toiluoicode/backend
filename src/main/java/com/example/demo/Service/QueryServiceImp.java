package com.example.demo.Service;

import com.example.demo.Models.Connect;
import com.example.demo.Models.Query;
import com.example.demo.Repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QueryServiceImp implements QueryService{
    @Autowired
    private QueryRepository queryRepository;
    @Override
    public List<Query> findAll() {
        return queryRepository.findAll();
    }
    @Override
    public boolean saveQuery(Query query) {
        if (query != null) {
            queryRepository.save(query);
            return true;
        }
        return false;
    }
    @Override
    public boolean updateQuery(String id, Query updateQuery) {
        Optional<Query> existingQuery =queryRepository.findById(id);
        if(existingQuery.isPresent()){
            Query queryUpdate=existingQuery.get();
            queryUpdate.setQueryId(updateQuery.getQueryId());
            queryUpdate.setQueryName(updateQuery.getQueryName());
            queryUpdate.setConnectionId(updateQuery.getConnectionId());
            queryUpdate.setSql(updateQuery.getSql());
            queryUpdate.setInputSample(updateQuery.getInputSample());
            queryRepository.save(queryUpdate);
            return true;
        }
        return false;
    }
    @Override
    public boolean deleteQuery(String id) {
        if(queryRepository.existsById(id)){
            queryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
