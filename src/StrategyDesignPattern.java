interface WalkableRobot{
    void walk();
}

class walkingRobot implements WalkableRobot{
    public void walk(){
        System.out.println("robot is able to walk");
    }
}

class noWalkRobot implements WalkableRobot{
    public void walk(){
        System.out.println("Robot cannot walk");
    }
}

interface talakablerobot{
    void talk();
}

class talkingRobot implements talakablerobot{
    @Override
    public void talk() {
        System.out.println("Robot can talk");
    }
}

class noTalkRobot implements talakablerobot{
    @Override
    public void talk() {
        System.out.println("robot cannot talk");
    }
}

interface flyableRobot{
    void fly();
}

class flyingRobot implements flyableRobot{
    @Override
    public void fly() {
        System.out.println("Robot can fly");
    }
}

class noFlyRobot implements flyableRobot{
    @Override
    public void fly() {
        System.out.println("Robot cannot fly");
    }
}

class Robot {
    private WalkableRobot walkBehavior;
    public talakablerobot talkBehavior;
    public flyableRobot flyBehavior;

    public Robot(WalkableRobot w, talakablerobot t, flyableRobot f) {
        this.walkBehavior = w;
        this.talkBehavior = t;
        this.flyBehavior = f;
    }
    public void walk(){
        this.walkBehavior.walk();
    }
    public void talk(){
        this.talkBehavior.talk();
    }
    public void fly(){
        this.flyBehavior.fly();
    }

    public void projection(){
        System.out.println("Something");
    }
}

public class StrategyDesignPattern{
    public static void main(String[] args) {
        Robot r1 = new Robot(new noWalkRobot(), new noTalkRobot(), new flyingRobot());
        r1.fly();
        r1.walk();
        r1.talk();
    }
}



