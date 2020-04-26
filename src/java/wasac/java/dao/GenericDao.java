/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wasac.java.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;



/**
 *
 * @author Yves
 */
public class GenericDao<X> {
    public void Create(X x){
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(x);
        s.getTransaction().commit();
        s.close();
    }
    
     public void Update(X x){
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(x);
        s.getTransaction().commit();
        s.close();
    }
     
      public void Delete(X x){
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(x);
        s.getTransaction().commit();
        s.close();
    }
      
      public List<X> findAll(Class kls){
        Session s = HibernateUtil.getSessionFactory().openSession();
          Query q = s.createQuery("From " + kls.getName());
          List<X> li = q.list();
          s.close();
          return li;
      }
      
      public X findById(Class kls,int id){
        Session s = HibernateUtil.getSessionFactory().openSession();
        X x = (X) s.get(kls, id);
        s.close();
        return x;
      }
      
}
