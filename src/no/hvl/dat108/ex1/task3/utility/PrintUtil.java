package no.hvl.dat108.ex1.task3.utility;

import no.hvl.dat108.ex1.task3.models.Hamburger;

public class PrintUtil {
    private TimeUtil timeUtil;


    public PrintUtil() {
        this.timeUtil = new TimeUtil();
    }

    public void printHamburgerTrayEmpty() {
        System.out.print("[TRAY IS EMPTY] ");
    }

    public void printAddHamburger(Hamburger hamburger){
        System.out.print(timeUtil.currentTimeStamp() + Thread.currentThread().getName() + " adds a [" + hamburger.getId()+"]" + " => ");
    }

    public void printRemoveHamburger(Hamburger hamburger){
        System.out.print(timeUtil.currentTimeStamp() + Thread.currentThread().getName() + " collects [" + hamburger.getId() + "]" + " <= ");
    }
}
