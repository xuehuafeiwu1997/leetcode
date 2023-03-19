package stringdemo;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁测试demo
 * 参考链接:https://blog.51cto.com/u_15932265/5993399
 *
 * @author xmy
 * @date 2023/3/19 5:03 下午
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {

    }
}

class ReadWriteLockTest {
    private int number = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();
}
