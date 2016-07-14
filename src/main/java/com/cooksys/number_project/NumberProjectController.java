package com.cooksys.number_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.number_project.tx.TXLong;
import com.cooksys.number_project.tx.TXResponse;
import com.cooksys.number_project.tx.TXShort;

@RestController
//@CrossOrigin(methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PATCH, RequestMethod.PUT})
@CrossOrigin(methods = RequestMethod.POST)
public class NumberProjectController {
	@Autowired
	NumberProjectService npcomplete;

	@RequestMapping(value="/short", method=RequestMethod.POST)
	public TXResponse<Integer> postNumber(@RequestBody TXShort txs) {
		return npcomplete.enumerate(txs);
	}
	
	@RequestMapping(value="/long", method=RequestMethod.POST)
	public TXResponse<?> postNumberWithUser(@RequestBody TXLong txl) {
		return npcomplete.registerAndEnumerate(txl);
	}
}
