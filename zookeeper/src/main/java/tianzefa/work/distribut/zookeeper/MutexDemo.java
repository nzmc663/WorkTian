package tianzefa.work.distribut.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author tzf 2020/11/12
 */
public class MutexDemo {

    public static void main(String[] args) {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .connectString("121.36.167.82:2181")
                .sessionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000,3))
                .connectionTimeoutMs(4000).build();
        curatorFramework.start();
        InterProcessLock lock = new InterProcessMutex(curatorFramework,"/locks");
        for (int i=0;i<10;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+">尝试抢占锁");
                try {
                    lock.acquire();
                    System.out.println(Thread.currentThread().getName()+">成功获取到锁");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(4000);
                    lock.release();
                    System.out.println(Thread.currentThread().getName()+">释放锁成功");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            },"t"+i).start();
        }
    }
}
