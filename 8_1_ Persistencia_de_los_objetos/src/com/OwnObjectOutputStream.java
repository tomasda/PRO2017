package com;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * @author Tomás Delgado Acosta
 */
public class OwnObjectOutputStream extends ObjectOutputStream implements Serializable{
    public OwnObjectOutputStream(OutputStream out) throws IOException{
        super(out);
    }
    public OwnObjectOutputStream() throws IOException,SecurityException{
        super();
    }
    @Override
    protected void writeStreamHeader() throws IOException{
        reset();
    }
}
