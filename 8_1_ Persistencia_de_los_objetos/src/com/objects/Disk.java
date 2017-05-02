package com.objects;

import java.io.Serializable;

/**
 * @author Tomás Delgado Acosta
 */
public class Disk extends Article implements Serializable {
    private long length;

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }
}
