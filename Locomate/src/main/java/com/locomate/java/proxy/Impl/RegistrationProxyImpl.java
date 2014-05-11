package com.locomate.java.proxy.Impl;

 
import java.util.List;
 
 






import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.locomate.java.beans.RegistrationPO;
import com.locomate.java.proxy.RegistrationProxy;
@Component
@Repository
public class RegistrationProxyImpl implements RegistrationProxy {
     
    @Autowired
    private static SessionFactory sessionFactory;

    @Autowired
    public  RegistrationProxyImpl(SessionFactory sessionFactory) {
    	 RegistrationProxyImpl.sessionFactory = sessionFactory;
	}
    
    @Transactional
    public RegistrationPO registerNewUser(RegistrationPO register) {
        Session session = sessionFactory.getCurrentSession();
        session.save(register);
		return register;
    }
     
    @SuppressWarnings("unchecked")
	@Transactional
    public List<RegistrationPO> list() {
        Session session = sessionFactory.getCurrentSession();
        List<RegistrationPO> registrationdetails = null;
        try {
        	registrationdetails = (List<RegistrationPO>)session.createQuery("from RegistrationPO order by ").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return registrationdetails;
    }    
     
    @Transactional
    public RegistrationPO get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (RegistrationPO)session.get(RegistrationPO.class, id);
    }
 
    @Transactional
    public void remove(Integer id) {
        Session session = sessionFactory.getCurrentSession();        
        RegistrationPO document = (RegistrationPO)session.get(RegistrationPO.class, id);         
        session.delete(document);
    }
}