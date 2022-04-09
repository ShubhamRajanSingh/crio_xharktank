package com.xharktank.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xharktank.Models.Pitche;
import com.xharktank.Services.PitcheService;

@RestController
public class PitcheController {

	@Autowired
	private PitcheService pitcheService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public Map<String,String> norReply() {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/favicon.ico")
	public Map<String,String> norReplyFavicon() {
		return null;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/pitches")
	public Map<String, String> savePitche(@RequestBody Map<String, Object> pitche, HttpServletResponse response) {
		HashMap<String, String> map = new HashMap<>();

		
		
		try {
		if (pitche.containsKey("entrepreneur") && pitche.containsKey("pitchTitle") && pitche.containsKey("pitchIdea")
				&& pitche.containsKey("askAmount") && pitche.containsKey("equity") && pitche.get("entrepreneur") != null
				&& pitche.get("pitchTitle") != null && pitche.get("pitchIdea") != null
				&& pitche.get("askAmount") != null && pitche.get("equity") != null
				&& Float.parseFloat(pitche.get("askAmount").toString()) >= 0
				&& Float.parseFloat(pitche.get("equity").toString()) <= 100
				&& Float.parseFloat(pitche.get("equity").toString()) >= 0) {

			Pitche p = new Pitche();
			p.setEntrepreneur(pitche.get("entrepreneur").toString());
			p.setPitchTitle(pitche.get("pitchTitle").toString());
			p.setPitchIdea(pitche.get("pitchIdea").toString());
			p.setAskAmount(Float.parseFloat(pitche.get("askAmount").toString()));
			p.setEquity(Float.parseFloat(pitche.get("equity").toString()));

			Pitche pitch = pitcheService.savePitch(p);

			map.put("id", pitch.getId());

			response.setStatus(201);

			return map;
		} else {
			response.setStatus(400);
			return null;

		}}catch(Exception e) {
			response.setStatus(400);
			return null;
			
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/pitches")
	public List<Pitche> getPitche(HttpServletResponse response) {
		response.setStatus(200);
		return pitcheService.getAllPitches();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/pitches/{pitchId}")
	public Pitche getPitcheById(@PathVariable("pitchId") String pitchId,HttpServletResponse response) {
		Pitche pitche=pitcheService.getPitchById(pitchId);
		if(pitche==null) {
			response.setStatus(404);
			return null;
		}
		response.setStatus(200);
		return pitcheService.getPitchById(pitchId);
	}

}
