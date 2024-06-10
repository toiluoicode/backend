package com.example.demo.Service;

import com.example.demo.Models.Connect;
import com.example.demo.Models.Query;

import java.util.List;

public interface QueryService {
    List<Query> findAll() ;

    boolean saveQuery(Query query) ;

    boolean deleteQuery(String id) ;
    boolean updateQuery(String id, Query updateQuery);

}
