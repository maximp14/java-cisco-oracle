package com.util;

import com.controller.CheckCSV;

public class CheckCSVThread extends Thread {

    private CheckCSV checkCSV;

    public CheckCSVThread(){
        this.checkCSV = new CheckCSV();
    }

    @Override
    public void run() {
        this.checkCSV.readFile();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
