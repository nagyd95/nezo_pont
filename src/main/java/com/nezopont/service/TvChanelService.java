package com.nezopont.service;

import com.nezopont.entity.TvChanels;
import com.nezopont.repository.TvChanelsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvChanelService {
    @Autowired
    public TvChanelsRep tvChanelsRep;

    @Autowired
    public void setMoviesReposit(TvChanelsRep tvChanelsRep) {
        this.tvChanelsRep = tvChanelsRep;
    }

    public List<TvChanels> findAllChanel(){
        return tvChanelsRep.findAll();
    }


}
