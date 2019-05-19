package com.nezopont.repository;

import com.nezopont.entity.TvChanels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TvChanelsRep extends JpaRepository<TvChanels,Long> {

    @Override
    List<TvChanels> findAll();



}
