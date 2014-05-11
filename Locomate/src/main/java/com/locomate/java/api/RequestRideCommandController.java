package com.locomate.java.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.locomate.java.beans.ErrorJsonPO;
import com.locomate.java.beans.PostRidePO;
import com.locomate.java.beans.RequestPO;
import com.locomate.java.proxy.RequestRideProxy;

@Controller
@RequestMapping("/api/requestride")
public class RequestRideCommandController {

	@Autowired
	private RequestRideProxy requestProxy;

	@Autowired
	private RequestPO requestPo;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String list(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "frequency", required = true) String frequency,
			@RequestParam(value = "from", required = true) String from,
			@RequestParam(value = "to", required = true) String to,
			@RequestParam(value = "startdate", required = true) String startdate,
			@RequestParam(value = "time", required = true) String time,
			@RequestParam(value = "days", required = true) String days)
			throws IOException {

		Gson gson = new Gson();
		String dateEntires[] = startdate.split("/");
		String timeEntires[] = startdate.split(":");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, Integer.parseInt(dateEntires[0]));
		cal.set(Calendar.MONTH, Integer.parseInt(dateEntires[1]) - 1);
		cal.set(Calendar.YEAR, Integer.parseInt(dateEntires[2]));
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeEntires[0]));
		cal.set(Calendar.MINUTE, Integer.parseInt(timeEntires[1]));
		Calendar createdOn = Calendar.getInstance();
		requestPo = new RequestPO(username, from, to, frequency, cal, days,
				createdOn);
		try {
			requestPo = requestProxy.saveRideDetails(requestPo);
			requestPo.setStatus("Success");
			return gson.toJson(requestPo);
		} catch (Exception ex) {
			ErrorJsonPO error = new ErrorJsonPO();
			error.setMessage(ex.getMessage());
			return gson.toJson(error);
		}

	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String getAllList()throws IOException {
		ArrayList<RequestPO> all = new ArrayList<RequestPO>();
		Gson gson = new Gson();
		try {
			all = (ArrayList<RequestPO>) requestProxy.list();
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

}
