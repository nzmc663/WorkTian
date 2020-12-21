package tianzefa.work.distribut.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.util.concurrent.CountDownLatch;

/**
 * 演示代码
 *
 * @author tzf 2020/11/12
 */
public class CuratorDemo {

    public static void main(String[] args) {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .connectString("121.36.167.82:2181")
                .sessionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000,3))
                .connectionTimeoutMs(4000).build();

        curatorFramework.start();//启动
//        create(curatorFramework);
        operatorWithAsync(curatorFramework);
    }

    private static String create(CuratorFramework curatorFramework) {
        try {
            curatorFramework.create()
                    .creatingParentsIfNeeded()
                    .withMode(CreateMode.PERSISTENT)
                    .forPath("/firstDemo","test".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String update(CuratorFramework curatorFramework) {
        try {
            curatorFramework.setData()
                    .forPath("/firstDemo","test22222".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String operatorWithAsync(CuratorFramework curatorFramework) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            curatorFramework.create()
                    .creatingParentsIfNeeded()
                    .withMode(CreateMode.PERSISTENT)
                    .inBackground((v1,v2)->{
                        System.out.println(Thread.currentThread().getName()+":"+v2.getResultCode());
                        System.out.println("ing");
                        countDownLatch.countDown();
                    })
                    .forPath("/firstDem4","test".getBytes());
            System.out.println("before");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            countDownLatch.await();
            System.out.println("after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
