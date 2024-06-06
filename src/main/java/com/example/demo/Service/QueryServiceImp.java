package com.example.demo.Service;

import com.example.demo.Models.Query;
import com.example.demo.Repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public boolean deleteQuery(String id) {
        if(queryRepository.existsById(id)){
            queryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
