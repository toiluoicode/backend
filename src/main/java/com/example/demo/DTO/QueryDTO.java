package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QueryDTO {
    private String query;
    private String collection;
    private String form;

    public QueryDTO(  @JsonProperty("query")String query) {
        this.query = query;
    }
    @JsonProperty("query")
    public String getQuery() {
        return query;
    }

    public QueryDTO(String query,String collection, String form) {
        this.query = query;
        this.collection = collection;
        this.form = form;
    }


    public String getCollection() {
        return collection;
    }


    public String getForm() {
        return form;
    }



//    public QueryDTO(String query, String collection) {
//        this.query = query;
//        this.collection = collection;
//    }
//
//    public String getCollection() {
//        return collection;
//    }
}
