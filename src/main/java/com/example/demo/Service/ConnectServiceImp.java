package com.example.demo.Service;

import com.example.demo.Models.Connect;
import com.example.demo.Repository.ConnectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ConnectServiceImp implements ConnectService{
    @Autowired
    ConnectRepository connectRepository;
    @Override
    public List<Connect> findAll() {
        return this.connectRepository.findAll();
    }

    @Override
    public boolean addConnect(Connect connect) {
        if(connect !=null) {
            connectRepository.save(connect);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateConnect(String id, Connect updateConnect) {
        Optional<Connect> existingConnect =connectRepository.findById(id);
        if(existingConnect.isPresent()){
            Connect connectUpdate=existingConnect.get();
            connectUpdate.setTenKN(updateConnect.getTenKN());
            connectUpdate.setURL(updateConnect.getURL());
            connectUpdate.setUser(updateConnect.getUser());
            connectUpdate.setPassword(updateConnect.getPassword());
            connectRepository.save(connectUpdate);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteConnect(String id) {
        if(connectRepository.existsById(id)){
            connectRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
