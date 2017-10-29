package com.developersdelicias.codesmells.comments.bad;

public class ExplainingBadCode {

    private final int MAX_NUMBER_OF_PROCESS_TO_HANDLE = 15;
    private static int totalOfProcessInMemory = 0;

    public void handleProcess() {
        long currentProcessId = Thread.currentThread().getId();

        if (totalOfProcessInMemory > MAX_NUMBER_OF_PROCESS_TO_HANDLE) {
            throw new RuntimeException("No more process can be handle");
        }
    }
}
