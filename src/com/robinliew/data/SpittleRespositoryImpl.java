package com.robinliew.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.robinliew.domain.Spitter;
import com.robinliew.domain.Spittle;

@Component
public class SpittleRespositoryImpl implements SpittleRepository {

	private List<Spittle> spittles=new ArrayList<Spittle>();
	
	private List<Spitter> spitters=new ArrayList<Spitter>();
	
	@Override
	public List<Spittle> findSpittles(long max, int count) {
		for(int i=0;i<count;i++){
			spittles.add(new Spittle("Spittle "+i, new Date(),0.0,0.0));
		}
		return spittles;
	}

	@Override
	public Spittle findOne(long spittleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Spitter spitter) {
		spitters.add(spitter);
	}

	@Override
	public Spitter findByUsername(String username) {
		Spitter s=null;
		if(spitters!=null){
			for(Spitter spitter:spitters){
				if(spitter.getUsername().equals(username)){
					s = spitter;
				}
			}
		}
		return s;
	}
	
	
}
