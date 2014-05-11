package com.locomate.java.proxy.Impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.locomate.java.beans.PostRidePO;
import com.locomate.java.beans.RegistrationPO;
import com.locomate.java.beans.RequestPO;
import com.locomate.java.proxy.PostRideProxy;

@Component
public class PostRideProxyImpl implements PostRideProxy{

	
	@Autowired
    private static SessionFactory sessionFactory;

    @Autowired
    public  PostRideProxyImpl(SessionFactory sessionFactory) {
    	PostRideProxyImpl.sessionFactory = sessionFactory;
	}
	
    @Transactional
	public PostRidePO saveRideDetails(PostRidePO postRidePO) {
		Session session = sessionFactory.getCurrentSession();
        session.save(postRidePO);
        session.flush();
		return postRidePO;
	}

    @SuppressWarnings("unchecked")
	@Transactional
	public List<PostRidePO> list() {
		Session session = sessionFactory.getCurrentSession();
        List<PostRidePO> registrationdetails = null;
        try {
        	registrationdetails = (List<PostRidePO>)session.createQuery("from PostRidePO order by idoffer desc").list();
        	System.out.println(""+registrationdetails.size());
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return registrationdetails;
	}
    
    @SuppressWarnings("unchecked")
	@Transactional
	public List<PostRidePO> list(String source, String destination) {
		Session session = sessionFactory.getCurrentSession();
        List<PostRidePO> registrationdetails = null;
        try {
        	registrationdetails = (List<PostRidePO>)session.createQuery("from PostRidePO where fromAddress like '%"+source+"%' and toAddress like '%"+destination+"%'").list();
        	System.out.println(""+registrationdetails.size());
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return registrationdetails;
	}

    @Transactional
	public PostRidePO get(Long id) {
		Session session = sessionFactory.getCurrentSession();
        return (PostRidePO)session.get(PostRidePO.class, id);
	}
    
}
