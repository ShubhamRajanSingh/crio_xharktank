package com.xharktank.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xharktank.Models.Offer;


@Repository
public interface OfferRepository extends JpaRepository<Offer, String> {

}
