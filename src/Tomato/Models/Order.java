//package Tomato.Models;
//
//import Tomato.Strategies.PaymentStrategy;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public abstract class Order {
//
//    private static int nextId = 0;
//    protected int orderId;
//    protected User user;
//    protected Restaurant restaurant;
//    protected ArrayList<MenuItem> orderItems = new ArrayList<>();
//    protected PaymentStrategy ps;
//    protected String scheduled;
//
//    public Order() {
//        this.user = null;
//        this.restaurant = null;
//        this.ps = null;
//        this.orderId = ++nextId;
//        this.scheduled = "";
//    }
//
//    public boolean processPayment(){
//        if(ps==null){
//            System.out.println("please select a payment method!");
//        }
//        else{
//            return ps.pay();
//        }
//    }
//    public abstract String getType();
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setRestaurant(Restaurant r) {
//        restaurant = r;
//    }
//
//    public Restaurant getRestaurant() {
//        return restaurant;
//    }
//
//    public List<MenuItem> getItems() {
//        return orderItems;
//    }
//
//    public void setPaymentStrategy(PaymentStrategy p) {
//        ps = p;
//    }
//
//    public void setScheduled(String s) {
//        scheduled = s;
//    }
//
//    public String getScheduled() {
//        return scheduled;
//    }
//
//
//}
