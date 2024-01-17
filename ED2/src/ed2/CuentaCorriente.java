/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed2;

/**
 *
 * @author luisnavarro
 */
public class CuentaCorriente {

    private double saldo;
    private static int contador = 0;
    public static final double MAXIMO_DESCUBIERTO = 1000;
    public static final double MAXIMO_OPERACION = 2000;

    private int id;
    private String titular;

    public CuentaCorriente() {
        this("desconocido", 0);
    }

    public CuentaCorriente(String t, double saldo) {
        titular = t;
        this.saldo = saldo;
        this.id = ++contador;
    }

    public CuentaCorriente(double saldo) {
        this("desconocido", saldo);
    }

    public void ingresa(double i) {
        if (i < 0) {
            throw new IllegalArgumentException("el parámetro de ingresar no puede ser negativo");
        }
        if (i > MAXIMO_OPERACION) {
            throw new IllegalArgumentException("Np se puede ingresa más de " + MAXIMO_OPERACION);
        }
        saldo += i;
    }

    public void extrae(double e) throws IllegalArgumentException {
        if (e < 0) {
            throw new IllegalArgumentException("el parámetro de extraer no puede ser negativo");
        }
        if (e > MAXIMO_OPERACION) {
            throw new IllegalArgumentException("Np se puede extraer más de " + MAXIMO_OPERACION);
        }

        if (e > saldo + MAXIMO_DESCUBIERTO) {
            throw new IllegalArgumentException("no se pùede sacar más de lo que hay");
        } else {
            saldo -= e;
        }
    }

    public boolean estaAlDescubierto() {
        return (saldo < 0);
    }

    public void tranferir(CuentaCorriente destino, double cantidad) {
        this.extrae(cantidad);
        destino.ingresa(cantidad);

    }

    public String toString() {
        return "Cuenta nº " + id + ", titular: " + titular + ", saldo=" + saldo;
    }

    /*
    @Override
    public String toString() {
        return "CuentaCorriente{" + "saldo=" + saldo + ", id=" + id + '}';
    }
     */
    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the titular
     */
    public String getTitular() {
        return titular;
    }

    /**
     * @param aTitular the titular to set
     */
    public void setTitular(String aTitular) {
        titular = aTitular;
    }

}
