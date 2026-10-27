package NotificationSystem;

import java.util.ArrayList;


/*============================
  Decorator Design Pattern Components
=============================*/

interface INotification {
    public String getContent();
}

class SimpleNotifcation implements INotification{
    private String text = "";
    public SimpleNotifcation(String msg){
        this.text = msg;
    }
    public String getContent(){
       return text;
    }
}

abstract class INotificationDecorator implements INotification{
    public INotification iNotification;
    public INotificationDecorator (INotification n){
        this.iNotification = n;
    }
}

class TimeStampDecorator extends INotificationDecorator{
    public TimeStampDecorator(INotification n) {
        super(n);
    }
    public String getContent(){
        return "2026-06-30" + iNotification.getContent();
    }
}

class SignatureDecorator extends INotificationDecorator{
    String signature;
    public SignatureDecorator(INotification n, String signature){
        super(n);
        this.signature = signature;

    }
    public String getContent(){
        return iNotification.getContent() + "\n--" + signature;
    }
}


/*============================
  Observer Pattern Components
=============================*/

interface IObserver{
    void update();
}

interface IObservable {
    public void add();
    ArrayList<IObserver> observers = new ArrayList<>();
    public void remove(IObserver o);
    void notifyObservers();
}


