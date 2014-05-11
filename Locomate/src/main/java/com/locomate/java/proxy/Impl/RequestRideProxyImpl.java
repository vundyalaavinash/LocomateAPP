package com.locomate.java.proxy.Impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.locomate.java.beans.RegistrationPO;
import com.locomate.java.beans.RequestPO;
import com.locomate.java.proxy.RequestRideProxy;

@Component
public class RequestRideProxyImpl implements RequestRideProxy{

	
	@Autowired
    private static SessionFactory sessionFactory;

    @Autowired
    public  RequestRideProxyImpl(SessionFactory sessionFactory) {
    	RequestRideProxyImpl.sessionFactory = sessionFactory;
	}
	
    @Transactional
	public RequestPO saveRideDetails(RequestPO requestRidePO) {
		Session session = sessionFactory.getCurrentSession();
        session.save(requestRidePO);
        session.flush();
		return requestRidePO;
	}

    @Transactional
	public List<RequestPO> list() {
		Session session = sessionFactory.getCurrentSession();
        List<RequestPO> registrationdetails = null;
        try {
        	registrationdetails = (List<RequestPO>)session.createQuery("from RequestPO order by idrequests desc").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return registrationdetails;
	}	
}
