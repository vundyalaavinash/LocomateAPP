package com.locomate.java.proxy;

import java.util.List;
import com.locomate.java.beans.RequestPO;

public interface RequestRideProxy {
	public RequestPO saveRideDetails(RequestPO requestRidePO);	
	public List<RequestPO> list();	
}
