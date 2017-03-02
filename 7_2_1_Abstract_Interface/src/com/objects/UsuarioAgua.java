package com.objects;

/**
 * @author Tomás Delgado Acosta
 */
public class UsuarioAgua extends Pokemon implements Agua {
    private String NIC_;
    
    @Override
    public void setNIC(String NIC) {
       NIC_ = NIC + "Pepe";
    }

    @Override
    public String getNIC() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void PistolaAgua() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Nadar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
