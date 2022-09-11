package no.hvl.dat108.ex1.task2.utility;

import no.hvl.dat108.ex1.task2.models.Hamburger;

public class PrintUtil {
    private TimeUtil timeUtil;


    public PrintUtil() {
        this.timeUtil = new TimeUtil();
    }

    public void printHamburgerTrayEmpty() {
        System.out.print("[TRAY IS EMPTY] ");
    }

    public void printIsFull() {
        System.out.print(timeUtil.currentTimeStamp() + Thread.currentThread().getName() + " waiting to deliver hamburger to the tray ");
    }

    public void printIsEmpty(){
        System.out.print(timeUtil.currentTimeStamp() + Thread.currentThread().getName() + " waiting to collect a hamburger from the tray ");
    }

    public void printAddHamburger(Hamburger hamburger){
        System.out.print(timeUtil.currentTimeStamp() + Thread.currentThread().getName() + " adds [" + hamburger.getId()+"]" + " => ");
    }

    public void printRemoveHamburger(Hamburger deliver){
        System.out.print(timeUtil.currentTimeStamp() + Thread.currentThread().getName() + " collects [" + deliver.getId() + "]" + " <= ");
    }
}
