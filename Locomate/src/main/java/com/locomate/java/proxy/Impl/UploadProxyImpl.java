package com.locomate.java.proxy.Impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.locomate.java.beans.UploadFilePO;
import com.locomate.java.proxy.UploadProxy;

@Component
@Repository
public class UploadProxyImpl implements UploadProxy{
	 @Autowired
	    private static SessionFactory sessionFactory;

	    @Autowired
	    public   UploadProxyImpl(SessionFactory sessionFactory) {
	    	UploadProxyImpl.sessionFactory = sessionFactory;
		}
	    @Transactional
	public UploadFilePO saveImage(UploadFilePO uploadfile){
		 Session session = sessionFactory.getCurrentSession();
		
			session.save(uploadfile);
		
		return uploadfile;
	}
	
	public UploadFilePO getImage(Long imageid){
		 Session session = sessionFactory.getCurrentSession();
	        return (UploadFilePO)session.get(UploadFilePO.class, imageid);
	}
}


