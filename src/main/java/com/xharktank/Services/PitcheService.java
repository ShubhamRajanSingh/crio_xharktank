package com.xharktank.Services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xharktank.Models.Pitche;
import com.xharktank.Repositories.PitcheRepository;

@Service
public class PitcheService  {
	
	@Autowired
	private PitcheRepository  pitchRepo;
	
	
	public Pitche savePitch(Pitche pitche){
		
		
		return pitchRepo.save(pitche);
	}
	
	public Pitche getPitchById(String id) {
		
		return pitchRepo.findById(id).orElse(null);
	}
	
	public List<Pitche> getAllPitches(){
		List<Pitche> pitches=pitchRepo.findAll();
		Collections.reverse(pitches);
		return pitches;
	}

	

}
