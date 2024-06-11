package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "query")
public class Query {
    @Id
    private String queryId;
    private String connectionId;
    private String queryName;
    private String sql;
    private String inputSample;

    public Query(String queryId, String connectionId, String queryName, String sql, String inputSample) {
        this.queryId = queryId;
        this.connectionId = connectionId;
        this.queryName = queryName;
        this.sql = sql;
        this.inputSample = inputSample;
    }

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getInputSample() {
        return inputSample;
    }

    public void setInputSample(String inputSample) {
        this.inputSample = inputSample;
    }
}
