package com.developersdelicias.codesmells.comments.bad;

public class MandatedComments {

    /**
     * Creates Url
     * @return
     */
    public String createUrl() {
        return protocol() + port() + hostname();
    }

    /**
     * Gets the protocol
     * @return
     */
    private String protocol() {
        return null;
    }

    /**
     * Gets the port
     * @return
     */

    private String port() {
        return null;
    }

    /**
     * Gets the hostname
     * @return
     */

    private String hostname() {
        return null;
    }
}
