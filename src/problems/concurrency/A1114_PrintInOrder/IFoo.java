package problems.concurrency.A1114_PrintInOrder;

public interface IFoo {
    void first(Runnable printFirst) throws InterruptedException;

    void second(Runnable printSecond) throws InterruptedException;

    void third(Runnable printThird) throws InterruptedException;
}
