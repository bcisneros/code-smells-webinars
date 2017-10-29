package com.developersdelicias.codesmells.comments.bad;

public class ExplainingBadCode {

    // The number max of process to handle
    private final int NOP = 15;
    // Total of process in memory
    private static int totProc = 0;

    public void handleProcess() {
        // Current Process Identifier
        long currPrId = Thread.currentThread().getId();

        if (totProc > NOP) {
            throw new RuntimeException("No more process can be handle");
        }
    }
}
