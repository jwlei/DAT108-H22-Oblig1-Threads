package no.hvl.dat108.ex1.task2;

public class PrintUtil {
    private TimeUtil timeUtil;


    public PrintUtil() {
        this.timeUtil = new TimeUtil();
    }

    public void printHamburgerTrayEmpty() {
        System.out.println("[TRAY IS EMPTY] ");
    }

    public void printIsFull() {
        System.out.println(timeUtil.currentTimeStamp() + Thread.currentThread().getName() + " waiting to deliver hamburger to the tray");
    }

    public void printIsEmpty(){
        System.out.print(timeUtil.currentTimeStamp() + Thread.currentThread().getName() + " waiting to collect a hamburger from the tray");
    }

    public void printAddHamburger(Hamburger hamburger){
        System.out.print(timeUtil.currentTimeStamp() + Thread.currentThread().getName() + " adds a [" + hamburger.getId()+"]" + " => ");
    }

    public void printRemoveHamburger(Hamburger deliver){
        System.out.print(timeUtil.currentTimeStamp() + Thread.currentThread().getName() + " collects [" + deliver.getId() + "]" + " <= ");
    }
}
