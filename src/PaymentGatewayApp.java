import java.util.Random;

class PaymentRequest{
    String sender;
    String reciever;
    String currency;
    double amount;

    public PaymentRequest(String sender, String reciever, double amt, String curr) {
        this.sender   = sender;
        this.reciever = reciever;
        this.amount   = amt;
        this.currency = curr;
    }
}

interface IBankingSystem{
     boolean processPayment(double amount);
}

class PaytmBankingSystem implements IBankingSystem{
    Random rand = new Random();
   public boolean processPayment(double amount){
        int ran = rand.nextInt(100);
         return ran<80;
    }
}

class RazorpayBankingSystem implements IBankingSystem{
    Random rand = new Random();
   public boolean processPayment(double amount){
        int ran = rand.nextInt(100);
        return ran<90;
}
}

abstract class IPaymentGateway{
    IBankingSystem ibs;
    PaymentRequest pr;
    public boolean processPayment(){
        if(!validate(pr)) return false;
        if(!initiate(pr)) return false;
        if(!confirm(pr))  return false;
        return true;
    }

    protected abstract boolean validate(PaymentRequest pr);
    protected abstract boolean initiate(PaymentRequest pr);
    protected abstract boolean confirm(PaymentRequest pr);
}

class PaytmGateway extends IPaymentGateway{
    public PaytmGateway(){
        this.ibs = new PaytmBankingSystem();

    }

}







public class PaymentGatewayApp {
}
