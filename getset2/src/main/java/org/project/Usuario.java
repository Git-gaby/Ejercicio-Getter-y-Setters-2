package org.project;


import java.util.Random;

public class Usuario {
    
    // Atributos privados
    private String titular;
    private long numero_cuenta;
    private double saldo;
    private final double LIMITE_RETIRO = 50000.0; // Nuevo: Límite de retiro por transacción

    // Constructor (sin cambios)
    public Usuario(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
        Random aleatorio = new Random();
        this.numero_cuenta = Math.abs(aleatorio.nextLong());
    }
    
    // --- NUEVO MÉTODO: DEPOSITAR ---
    /**
     * Realiza un depósito en la cuenta del cliente.
     */
    public static void setDeposito(Usuario cliente, double cantidad) {
        if (cantidad > 0) {
            cliente.saldo += cantidad;
            System.out.println("Depósito de " + cantidad + " exitoso. Saldo actual: " + cliente.saldo);
        } else {
            System.out.println("ERROR: La cantidad a depositar debe ser positiva.");
        }
    }
    
    // --- MÉTODO EXISTENTE: RETIRAR (CON LÍMITE) ---
    /**
     * Realiza un retiro de la cuenta del cliente con un límite de $50,000.
     */
    public static void setRetiros(Usuario cliente, double cantidad) {
        if (cantidad > cliente.LIMITE_RETIRO) {
            System.out.println("ALERTA: No se puede retirar más de $" + cliente.LIMITE_RETIRO + " en una sola transacción.");
            return;
        }
        
        if (cliente.saldo >= cantidad) {
            cliente.saldo -= cantidad;
            System.out.println("Retiro de " + cantidad + " exitoso. Saldo actual: " + cliente.saldo);
        } else {
            System.out.println("ERROR: Saldo insuficiente para el retiro de " + cantidad);
        }
    }

    // --- MÉTODO EXISTENTE: TRANSFERENCIA (sin cambios lógicos) ---
    public static void setTransferencia(Usuario titu1, Usuario titu2, double cantidad) {
        if (titu1.saldo >= cantidad) {
            titu1.saldo -= cantidad;
            titu2.saldo += cantidad;
            System.out.println("Transferencia de " + cantidad + " exitosa.");
        } else {
             System.out.println("ERROR: Saldo insuficiente en la cuenta de " + titu1.titular + ".");
        }
    }
    
    // --- MÉTODO EXISTENTE: GET DATOS (con toque creativo) ---
    public String getDatosCuenta() {
        String mensajeCreativo;
        
        if (this.saldo >= 100000) {
            mensajeCreativo = "¡Felicidades! Tienes un saldo envidiable. Eres un cliente Premium.";
        } else if (this.saldo >= 50000) {
            mensajeCreativo = "¡Buen trabajo! Tu salud financiera es estable.";
        } else if (this.saldo > 0) {
            mensajeCreativo = "Consejo: Continúa ahorrando para alcanzar tus metas.";
        } else {
            mensajeCreativo = "¡Atención! Tu saldo es bajo o cero. Considera un depósito.";
        }
        
        return "---  DATOS DE CUENTA  ---\n" +
               "Titular: " + titular + "\n" + 
               "Número de cuenta: " + numero_cuenta + "\n" +
               "Saldo: " + String.format("%.2f", saldo) + "\n" +
               "-------------------------------\n" + 
               mensajeCreativo;
    }
    
    // Getter extra (sin cambios)
    public double getSaldo() {
        return this.saldo;
    }
}