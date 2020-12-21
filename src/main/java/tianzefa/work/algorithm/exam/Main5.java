package tianzefa.work.algorithm.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main5 {

    public static void main(String[] args) {
        Test test  = new Test();
        test.addListener((v1)->{System.out.println(v1.myName());});
        test.doSomething();
    }

    static class Test{
        private List<Listener> listeners = new ArrayList<>();
        public void addListener(Listener listener){
            if (Objects.nonNull(listener)){
                listeners.add(listener);
            }
        }
        public void doSomething(){
            //TODO 业务逻辑
            for (Listener listener : listeners){
                //发布事件、通知
                listener.onEnvet(()->"test");
            }
        }
    }

    interface Listener{
        void onEnvet(Envet envet);
    }

    interface  Envet{
        String myName();
    }

}
