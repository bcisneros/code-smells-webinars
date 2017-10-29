package com.developersdelicias.codesmells.comments.good;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class WarningOfConsequences {

    // SimpleDateFormat is not thread safe, so we need to create each instance independently
    private static SimpleDateFormat createFormat() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yy");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        return format;
    }
}
