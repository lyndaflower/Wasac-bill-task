/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wasac.java.model;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import wasac.java.dao.GenericDao;
import wasac.java.domain.Bill;

/**
 *
 * @author Henriette
 */
@ManagedBean(name = "bm")
@RequestScoped
public class BillModel {

    /**
     * Creates a new instance of BillModel
     */
    private Bill bill = new Bill();
    private List<Bill> bills = new GenericDao<Bill>().findAll(Bill.class);

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

   
    
    
    
          public List<String> getECategories(){
    List<String>categoryList = new ArrayList<>();
    for(ECategory c : ECategory.values()){
    categoryList.add(c.toString());
    }
    return categoryList;
    }
    public BillModel() {
    }
    
    private  int sum;
    private int print;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getPrint() {
        return print;
    }

    public void setPrint(int print) {
        this.print = print;
    }
    
    public void registerCalculator(){
        GenericDao<Bill> gd = new GenericDao<>();
        sum = bill.getEnd_numbers() - bill.getStart_numbers();
        if(bill.getCategory().equals("Public_tap")){     
            print = sum * 323;
           bill.setAmount(print);
           gd.Create(bill);
        }else if(bill.getCategory().equals("Residential")){
                if(sum > 0 && sum <= 5){
                  print = sum * 340;
                  bill.setAmount(print);
           gd.Create(bill);
                }else
                if(sum >=6 && sum <= 20){
                 print = sum * 720;
                 bill.setAmount(print);
                 gd.Create(bill);
                }else
                 if(sum >=21 && sum <= 50){
                 print = sum * 845;
                 bill.setAmount(print);
                 gd.Create(bill);
                }else
                 if(sum > 50){
                 print = sum * 877;
                 bill.setAmount(print);
                 gd.Create(bill);
                 }else{
                 System.out.println("OOPS!!! What went wrong!");
                 }
                
        }else if(bill.getCategory().equals("Non_Residential")){
             if(sum > 0 && sum <=50){
                 print = sum * 877;
                 bill.setAmount(print);
                 gd.Create(bill);
                 }else
             if(sum > 50){
                 print = sum * 895;
                 bill.setAmount(print);
                 gd.Create(bill);
             }else{
             System.out.println("OOPS....something went wrong");
             }
        }else if(bill.getCategory().equals("Industries")){
                print = sum * 736;
                bill.setAmount(print);
                gd.Create(bill);
        }else{
        System.out.println("OOPs!!Something went wrong");
        }
       
    }
    
}
