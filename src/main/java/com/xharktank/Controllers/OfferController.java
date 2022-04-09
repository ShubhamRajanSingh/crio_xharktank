package com.xharktank.Controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xharktank.Models.Offer;
import com.xharktank.Models.Pitche;
import com.xharktank.Services.OfferService;
import com.xharktank.Services.PitcheService;

@RestController
public class OfferController {

	@Autowired
	private OfferService offerService;

	@Autowired
	private PitcheService pitcheService;

	@RequestMapping(method = RequestMethod.POST, value = "/pitches/{pitchId}/makeOffer")
	public Map<String, String> saveOffer(@PathVariable("pitchId") String pitchId,
			@RequestBody Map<String, Object> offer, HttpServletResponse response) {
		HashMap<String, String> map = new HashMap<>();

		Pitche p = pitcheService.getPitchById(pitchId);
		if (p == null) {

			response.setStatus(404);
			return null;
		}
		try {
			if (offer.containsKey("investor") && offer.containsKey("amount") && offer.containsKey("equity")
					&& offer.containsKey("comment") && offer.get("investor") != null && offer.get("amount") != null
					&& offer.get("equity") != null && offer.get("comment") != null
					&& Float.parseFloat(offer.get("amount").toString()) >= 0
					&& Float.parseFloat(offer.get("equity").toString()) >= 0
					&& Float.parseFloat(offer.get("equity").toString()) <= 100) {

				Offer o = new Offer();
				o.setAmount(Float.parseFloat(offer.get("amount").toString()));
				o.setComment(offer.get("comment").toString());
				o.setEquity(Float.parseFloat(offer.get("equity").toString()));
				o.setInvestor(offer.get("investor").toString());
				o.setPitchId(p);
				Offer off = offerService.saveOffer(o);

				response.setStatus(201);
				map.put("id", o.getId());

				return map;

			} else {

				response.setStatus(400);
				return null;
			}

		} catch (Exception e) {

			response.setStatus(400);
			return null;
		}
	}

}
