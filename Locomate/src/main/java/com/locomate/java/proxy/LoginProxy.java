package com.locomate.java.proxy;

import java.util.List;

import org.springframework.ui.Model;

import com.locomate.java.beans.RegistrationPO;

public interface LoginProxy {
	 public  List<RegistrationPO> list();
	 public RegistrationPO getUser(String username);
}
