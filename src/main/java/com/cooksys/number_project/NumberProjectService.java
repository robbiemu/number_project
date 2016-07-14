package com.cooksys.number_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.number_project.tx.TXLong;
import com.cooksys.number_project.tx.TXResponse;
import com.cooksys.number_project.tx.TXShort;
import com.cooksys.number_project.model.Number;
import com.cooksys.number_project.model.User;
import com.cooksys.number_project.repository.NumberRepository;
import com.cooksys.number_project.repository.UserRepository;

import static com.cooksys.number_project.Defs.*;

import java.util.HashMap;
import java.util.Map;

@Service
public class NumberProjectService {
	@Autowired
	UserRepository ur;

	@Autowired
	NumberRepository nphard;

	public TXResponse<Integer> enumerate(TXShort txs) {
		Integer i = txs.getNum();
		System.out.println("number to enumerate: " + i);
		if (i==null) { return null; }
		
		Number n =  nphard.findByNindex(i);
		if(n == null) {
			n = new Number();
			n.setNindex(i);
			n.setNnumber(0);
		}

		Integer x = n.increment();
		nphard.save(n);
		
		return new TXResponse<Integer>(NUMBER_TABLE, x);
	}

	public TXResponse<?> registerAndEnumerate(TXLong txl) {
		Integer x = txl.getNum();
		Number n = null;
		if(x != null) {
			n =  nphard.findByNindex(x);
			// skipping if n == null because that would immediately go negative and Michael said not to do that
		
			x = n.decrement();
		} 
		
		User u = new User();
		u.setPassword(txl.getPassword());
		u.setName(txl.getUsername());

		ur.save(u);
		
		if(n != null) {
			nphard.save(n);
			Map<String, Object> result = new HashMap<>();
			result.put(USER_TABLE, u);
			result.put(NUMBER_TABLE, x);
			
			return new TXResponse<Map<String, Object>>(USER_TABLE, result);	
		} else {
			return new TXResponse<Integer>(USER_TABLE, x);	
		}
	}
	
}
