/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wasac.java.Main;

import org.hibernate.Session;
import wasac.java.dao.HibernateUtil;
import wasac.java.domain.Bill;
import wasac.java.model.BillModel;
import wasac.java.model.ECategory;

/**
 *
 * @author Henriette
 */
public class MainClass {
    public static void main(String[] args) {
//       Bill bill = new Bill();
//       bill.setStart_numbers(13);
//       bill.setEnd_numbers(23);
//       
//       int sum;
//       int print;
//       
//       sum = bill.getEnd_numbers() - bill.getStart_numbers();
//       print = sum * 323;
//       bill.setAmount(print);
//       System.out.println(bill.getAmount());
       Session s = HibernateUtil.getSessionFactory().openSession();
       s.close();
    }
}
