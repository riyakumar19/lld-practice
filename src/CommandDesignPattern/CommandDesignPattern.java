package CommandDesignPattern;

class Fan{
    public boolean fanState;
    public void on(){
        fanState = true;
        System.out.println("Fan Switched On");
    }
    public void off(){
        fanState = false;
        System.out.println("Fan Switched off");
    }
}

class Light{
    public boolean lightState;
    public void on(){
        lightState = true;
        System.out.println("Light Switched On");
    }
    public void off(){
        lightState = false;
        System.out.println("Light Switched off");
    }
}

interface ICommand{

     public void execute();
     public void undo();
}

class LightCommand implements ICommand{
    public Light light;
    public LightCommand(Light light){
        this.light = light;
    }
    public void execute(){
        light.on();
    }

    public void undo() {
        light.off();
    }
}

class FanCommand implements ICommand{
    public Fan Fan;
    public void execute(){
        Fan.on();
    }

    public void undo() {
        Fan.off();
    }
}

class RemoteController{
    int numOfButtons;
    ICommand commands[];
    public RemoteController(int num){
        this.numOfButtons = num;
        this.commands = new ICommand[num];
    }
    public void setCommand(int idx, ICommand command){
        if(idx>=0 && idx<numOfButtons){
            if(this.commands[idx] == null){
                this.commands[idx] = command;
            }
            else {
                System.out.println("this command is already set, unset it first");
            }
        }
    }

    public void pressButton(int idx){
        if(idx>=0 && idx<numOfButtons){
            commands[idx].execute();
        }
    }

    public void undoCommand(int idx){
        if(idx>= 0 && idx<numOfButtons){
            commands[idx].undo();
        }
    }
}
public class CommandDesignPattern {
    public static void main(String[] args){
        RemoteController remote = new RemoteController(3);
        Light light = new Light();
        LightCommand lightCommand = new LightCommand(light);
        FanCommand fanCommand = new FanCommand();
        remote.setCommand(0,lightCommand);
        remote.setCommand(2,fanCommand);
        remote.pressButton(0);

    }
}
