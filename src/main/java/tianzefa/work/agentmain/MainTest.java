package tianzefa.work.agentmain;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainTest {

    public static void main(String[] args) throws IOException {
       new Timer().schedule(new TimerTask() {
           @Override
           public void run() {
               Test test = new Test();
               System.out.println(test.getTestNumber()+","+test.getTest2Number());
           }
       },1000,3000);
        System.in.read();
    }

}
