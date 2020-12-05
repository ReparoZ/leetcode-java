package testcase.concurrency.A1114_PrintInOrder;

import problems.concurrency.A1114_PrintInOrder.Foo;
import problems.concurrency.A1114_PrintInOrder.Foo2;
import problems.concurrency.A1114_PrintInOrder.IFoo;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * A1114_PrintInOrder
 *
 * @author steven.zmj
 * @date 2020/12/05
 */
public class TestCase {

    static String actualValue = "";

    public static void main(String[] args) throws InterruptedException {
//        final IFoo foo = new Foo();
        final IFoo foo = new Foo2();
        test(new int[] {1, 2, 3}, "firstsecondthird", foo);
        test(new int[] {1, 3, 2}, "firstsecondthird", foo);
        test(new int[] {3, 2, 1}, "firstsecondthird", foo);
    }

    private static void test(int[] order, String expectedResult, IFoo foo) throws InterruptedException {
        new Thread(new InnerRunnable(foo, order[0])).start();
        TimeUnit.MILLISECONDS.sleep(500);
        new Thread(new InnerRunnable(foo, order[1])).start();
        TimeUnit.MILLISECONDS.sleep(500);
        new Thread(new InnerRunnable(foo, order[2])).start();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println(String.format("param is %s, ", Arrays.toString(order)) +
                (actualValue.equals(expectedResult) ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
        actualValue = "";
    }

    public static class InnerRunnable implements Runnable {
        final int order;
        final IFoo foo;

        public InnerRunnable(IFoo foo, int order) {
            this.foo = foo;
            this.order = order;
        }

        @Override
        public void run() {
            if (order == 1) {
                try {
                    foo.first(() -> actualValue += "first");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (order == 2) {
                try {
                    foo.second(() -> actualValue += "second");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (order == 3) {
                try {
                    foo.third(() -> actualValue += "third");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
