package com.example.demo.Service;

import com.example.demo.Models.Connect;

import java.util.List;

public interface ConnectService {
    List<Connect> findAll();
    boolean addConnect( Connect connect);
    boolean updateConnect(String id, Connect updateConnect);
    boolean deleteConnect(String id);

}
