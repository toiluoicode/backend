package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QueryDTO {
    private String query;

    public QueryDTO(  @JsonProperty("query")String query) {
        this.query = query;
    }
    @JsonProperty("query")
    public String getQuery() {
        return query;
    }
}
