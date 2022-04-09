package com.xharktank.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xharktank.Models.Offer;
import com.xharktank.Repositories.OfferRepository;



@Service
public class OfferService {

	@Autowired
	private OfferRepository offerRepo;
	
	
	public Offer saveOffer(Offer offer) {
		return offerRepo.save(offer);
	}
	
}
