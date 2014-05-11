package com.locomate.java.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.locomate.java.beans.*;
import com.locomate.java.proxy.PostRideProxy;

@Controller
@RequestMapping("/api/offerride")
public class PostRideCommandController {

	@Autowired
	private PostRideProxy postRideProxy;
	
	@Autowired
	private ObjectCollectionPO objectCollectionPO;
	
	
	@Autowired
	private PostRidePO postRidePo;
	
	@Autowired
	private PostRidePO blank;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String list(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "frequency", required = true) String frequency,
			@RequestParam(value = "from", required = true) String from,
			@RequestParam(value = "to", required = true) String to,
			@RequestParam(value = "startdate", required = true) String startdate,
			@RequestParam(value = "time", required = true) String time,
			@RequestParam(value = "days", required = true) String days,
			@RequestParam(value = "amount", required = true) double amount,
			@RequestParam(value = "instructions", required = true) String instructions,
			@RequestParam(value = "pickuppoints", required = true) String pickup,
			@RequestParam(value = "availableseats", required = true) int availableseats,
			@RequestParam(value = "carnumber", required = true) String vehiclenumber,
			@RequestParam(value = "carmodel", required = true) String vehiclemodel)
			throws IOException {

		Gson gson = new Gson();
		String dateEntires[] = startdate.split("/");
		String timeEntires[] = time.split(":");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, Integer.parseInt(dateEntires[0]));
		cal.set(Calendar.MONTH, Integer.parseInt(dateEntires[1]) - 1);
		cal.set(Calendar.YEAR, Integer.parseInt(dateEntires[2]));
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeEntires[0]));
		cal.set(Calendar.MINUTE, Integer.parseInt(timeEntires[1]));
		Calendar createdOn = Calendar.getInstance();
		postRidePo = new PostRidePO(username, from, to, frequency, cal, days,
				amount, instructions, availableseats, vehiclenumber,
				vehiclemodel, createdOn);

		try {
			postRidePo = postRideProxy.saveRideDetails(postRidePo);
			postRidePo.setStatus("success");
			return gson.toJson(postRidePo);
		} catch (Exception ex) {
			ErrorJsonPO error = new ErrorJsonPO();
			error.setMessage(ex.getMessage());
			return gson.toJson(error);
		}

	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String getAllList()throws IOException {
		ArrayList<PostRidePO> all = new ArrayList<PostRidePO>();
		Gson gson = new Gson();
		try {
			all = (ArrayList<PostRidePO>) postRideProxy.list();
			if (all.size() == 0){
				return "{\"status\": \"success\", \"results\":[]}";
			}
			else{
				return "{\"status\": \"success\", \"results\":"+gson.toJson(all)+"}";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			ErrorJsonPO error = new ErrorJsonPO();
			error.setMessage("Error : "+ex.getMessage());
			return gson.toJson(error);
		}
		
	}
	
	@RequestMapping(value = "/{source}/{destination}" , method=RequestMethod.GET)
	@ResponseBody
    public String getAllList(@PathVariable String source,@PathVariable String destination) throws IOException {
		ArrayList<PostRidePO> all = new ArrayList<PostRidePO>();
		Gson gson = new Gson();
		try {
			all = (ArrayList<PostRidePO>) postRideProxy.list(source,destination);
			if (all.size() == 0){
				return "{\"status\": \"success\", \"results\":[]}";
			}
			else{
				return "{\"status\": \"success\", \"results\":"+gson.toJson(all)+"}";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			ErrorJsonPO error = new ErrorJsonPO();
			error.setMessage("Error : "+ex.getMessage());
			return gson.toJson(error);
		} 
    }
	
	@RequestMapping(value = "/{rid}" , method=RequestMethod.GET)
	@ResponseBody
    public String getPostRide(@PathVariable String rid) throws IOException {
		PostRidePO postride;
		Gson gson = new Gson();
		try {
			postride = postRideProxy.get(Long.parseLong(rid));
			if (postride == null){
				ErrorJsonPO error = new ErrorJsonPO();
				error.setMessage("Ride Details not Found");
				return gson.toJson(error);
			}
			else{
				postride.setStatus("success");
				return gson.toJson(postride);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			ErrorJsonPO error = new ErrorJsonPO();
			error.setMessage("Error : "+ex.getMessage());
			return gson.toJson(error);
		} 
    }

}
