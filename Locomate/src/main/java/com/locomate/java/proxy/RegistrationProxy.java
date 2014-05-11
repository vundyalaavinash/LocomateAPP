package com.locomate.java.proxy;

import java.util.List;

import com.locomate.java.beans.RegistrationPO;


public interface RegistrationProxy {
	public RegistrationPO registerNewUser(RegistrationPO register);
	public List<RegistrationPO> list();
	public void remove(Integer id);
}
