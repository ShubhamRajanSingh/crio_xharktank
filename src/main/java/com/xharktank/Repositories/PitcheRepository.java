package com.xharktank.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xharktank.Models.Pitche;


@Repository
public interface PitcheRepository  extends JpaRepository<Pitche,String>{

}

