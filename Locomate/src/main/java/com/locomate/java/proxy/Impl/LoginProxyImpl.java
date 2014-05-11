package com.locomate.java.proxy.Impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.locomate.java.beans.RegistrationPO;
import com.locomate.java.proxy.LoginProxy;

import org.springframework.stereotype.Component;
@Component
public class LoginProxyImpl implements LoginProxy  {

    @Autowired
    private static SessionFactory sessionFactory;

    @Autowired
    public LoginProxyImpl(SessionFactory sessionFactory) {
    	LoginProxyImpl.sessionFactory = sessionFactory;
	}
    /*@Transactional
    public User LoginUser(RegistrationPO user) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("........."+user.getUserName());
        System.out.println("........."+user.getUserPassword());
        
        session.save(user);
		return user;
    }*/

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<RegistrationPO> list() {
		 Session session = sessionFactory.getCurrentSession();
		    List<RegistrationPO> users = null;
		    try {	        	
		    	users = (List<RegistrationPO>)session.createQuery("from RegistrationPO").list();	        	
		} catch (HibernateException e) {
		    e.printStackTrace();
		}
		return users;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
    public RegistrationPO getUser(String username) {
        Session session = sessionFactory.getCurrentSession();
        RegistrationPO registrationdetails = null;
        try {
        	Query query = session.createQuery("from RegistrationPO where username=?");        	
        	query.setString(0, username);
        	query.setCacheable(true);
        	List<RegistrationPO> l = query.list();
        	if (l.size()>0){
        		return l.get(0);
        	}
        } catch (HibernateException e) {        	
            e.printStackTrace();
        }
        return registrationdetails;
    }
}
	

	
