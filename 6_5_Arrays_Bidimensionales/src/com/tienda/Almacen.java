package com.tienda;
/**
 * @author Tomás Delgado Acosta
 */
public class Almacen {
    private ObjetoUnidad[][] zapatos;
    private Caracteristica[] modelo;
    private Caracteristica[] color;
    private Caracteristica[] moda;
    StringBuffer data;

    public ObjetoUnidad[][] getZapatos() {
        return zapatos;
    }

    public void setZapatos(ObjetoUnidad[][] zapatos) {
        this.zapatos = zapatos;
    }
    public Caracteristica[] getModelo() {
        return modelo;
    }

    public void setModelo(Caracteristica[] modelo) {
        this.modelo = modelo;
    }

    public Caracteristica[] getColor() {
        return color;
    }

    public void setColor(Caracteristica[] color) {
        this.color = color;
    }

    public Caracteristica[] getModa() {
        return moda;
    }

    public void setModa(Caracteristica[] moda) {
        this.moda = moda;
    }
    

    public Almacen() {
    }
    
    public Almacen(int x, int y){
        zapatos = new ObjetoUnidad[x][y];
        modelo = new Caracteristica[x];
        color = new Caracteristica[y];
        moda = new Caracteristica[x*y];
    }

    public ObjetoUnidad getZapatos(int x, int y) {
        return zapatos[x][y];
    }

    public void setZapatos(int x, int y, ObjetoUnidad z) {
        this.zapatos[x][y] = z;
    }
    
    public int getX(){
        return zapatos.length; 
    }
    public int getY(int x){
        return zapatos[x].length;
    }
    
    public void toString_(){
        int x = zapatos.length;
        int y = zapatos[1].length;
        StringBuffer a = new StringBuffer();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                a.append(getZapatos(i, j).getCantidad());
                a.append(" ");
            }
            a.append("\n");
        }
        System.out.println(a);
    }
    public void toStringColor_(){
    data = new StringBuffer();
        for (Caracteristica color1 : color) {
            data.append(" Color= ").append(color1.getValor()).append(" Caracter= ").append(color1.getNombreColumna()).append("\n");
        }
        System.out.println(data);
    }
    
    public void toStringModelo_(){
    data = new StringBuffer();
        for (Caracteristica modelo1 : modelo) {
            data.append(" Modelo= ").append(modelo1.getValor()).append("\n");
        }
        System.out.println(data);
    }
    
    public void toStringAlmacen(){
        data = new StringBuffer();
        data.append("\t\t");
            for (int i = 0; i < color.length; i++) {
                data.append("\t").append(color[i].getNombreColumna());
            }
            data.append("\n");
            for (int i = 0; i < zapatos.length; i++) {
                data.append("\t").append(modelo[i].getValor()).append("\t");
                if (modelo[i].getValor().length()<8){
                    data.append("\t");
                }
                for (int j = 0; j < zapatos[i].length; j++) {
                    data.append(getZapatos(i, j).getCantidad());
                    data.append("\t");
                }
                data.append("\n");
            }
        
        System.out.println(data);
    }
    
    public Caracteristica getColor(int i) {
        return this.color[i];
    }

    public void setColor(int i, Caracteristica color) {
        this.color[i] = color;
    }

    public void setModelo(int i, Caracteristica modelo) {
        this.modelo[i]=modelo;
    }
    public Caracteristica getModelo(int i){
        return this.modelo[i];
    }

    public Caracteristica getModa(int i) {
        return this.moda[i];
    }

    public void setModa(int i,Caracteristica moda_) {
        this.moda[i] = moda_;
    }
}
