package com.locomate.java.proxy;

import java.util.List;

import com.locomate.java.beans.PostRidePO;
import com.locomate.java.beans.RegistrationPO;

public interface PostRideProxy {
	public PostRidePO saveRideDetails(PostRidePO postRidePO);
	public List<PostRidePO> list();
	public List<PostRidePO> list(String source,String destination);
	public PostRidePO get(Long id);
}
