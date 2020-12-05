package problems.concurrency.A1114_PrintInOrder;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 我们提供了一个类：
 *
 * public class Foo {
 *  public void first() { print("first"); }
 *  public void second() { print("second"); }
 *  public void third() { print("third"); }
 * }
 * 三个不同的线程将会共用一个Foo实例。
 *
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用 second() 方法
 * 线程 C 将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: "firstsecondthird"
 * 解释: 
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
 * 正确的输出是 "firstsecondthird"。
 * 示例 2:
 *
 * 输入: [1,3,2]
 * 输出: "firstsecondthird"
 * 解释: 
 * 输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。
 * 正确的输出是 "firstsecondthird"。
 * 
 *
 * 提示：
 *
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * 你看到的输入格式主要是为了确保测试的全面性。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ml3426
 * @date 2020/12/06
 */
public class Foo implements IFoo {
    private final CountDownLatch lockSecond = new CountDownLatch(1);
    private final CountDownLatch lockThird = new CountDownLatch(1);

    /**
     * 解 1：利用CountDownLatch，1释放2，2释放3来实现
     *
     * 解答消耗参考:
     * Runtime: 13 ms, 66.92%
     * Memory Usage: 38.1 MB, 68.16%
     */
    public Foo() {
    }

    @Override
    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        lockSecond.countDown();
    }

    @Override
    public void second(Runnable printSecond) throws InterruptedException {

        lockSecond.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        lockThird.countDown();
    }

    @Override
    public void third(Runnable printThird) throws InterruptedException {

        lockThird.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
