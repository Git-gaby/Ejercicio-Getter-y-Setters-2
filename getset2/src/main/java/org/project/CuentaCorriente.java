package org.project;

import java.util.Locale;
import java.util.Scanner; 

public class CuentaCorriente {
    public static void main(String[] args) {
        double monto;
        
        // Se configura el Scanner para usar el punto decimal (US Locale)
        Scanner scn = new Scanner(System.in).useLocale(Locale.US); 
        
        // Creación de objetos
        Usuario cuenta1 = new Usuario("Juan Perrez", 22000.0);
        Usuario cuenta2 = new Usuario("Diana Prince", 178000.0);

        System.out.println("\n=== BANCO CREATIVO: SISTEMA DE OPERACIONES ===");
        System.out.println("Seleccione una operación:");
        System.out.println(" A = Consultar datos de cuenta");
        System.out.println(" B = Retiros (Máx. $50,000 por operación)");
        System.out.println(" D = Depósitos"); // Opción nueva
        System.out.println(" T = Transferencias");
        System.out.println(" E = Salir");
        System.out.println("=====================================================");
        
        String seleccion = scn.nextLine().toUpperCase();
        
        switch (seleccion) {
            case "A":
                // ... (Lógica de consulta, sin cambios)
                System.out.print("Ingrese el número de cuenta (1: Juan / 2: Diana): ");
                if (scn.hasNextInt()) {
                    int cuen = scn.nextInt();
                    switch(cuen) {
                        case 1:
                            System.out.println(cuenta1.getDatosCuenta());
                            break;
                        case 2:
                            System.out.println(cuenta2.getDatosCuenta());
                            break;
                        default:
                            System.out.println("ERROR: No existe esa cuenta.");
                    }
                } else {
                    System.out.println("ERROR: Entrada inválida. Debe ser 1 o 2.");
                }
                break;
                
            case "B":
                // ... (Lógica de retiro, sin cambios en el main)
                System.out.print("Seleccione una cuenta (1: Juan / 2: Diana): ");
                int cuenRetiro = scn.nextInt();
                
                System.out.print("Ingrese el monto a retirar: ");
                monto = scn.nextDouble();
                
                if (cuenRetiro == 1) {
                    Usuario.setRetiros(cuenta1, monto);
                } else if (cuenRetiro == 2) {
                    Usuario.setRetiros(cuenta2, monto);
                } else {
                    System.out.println("ERROR: Cuenta no válida.");
                }
                break;
                
            case "D": // --- NUEVA LÓGICA DE DEPÓSITO ---
                System.out.print("Seleccione una cuenta para depositar (1: Juan / 2: Diana): ");
                int cuenDeposito = scn.nextInt();
                
                System.out.print("Ingrese el monto a depositar: ");
                monto = scn.nextDouble();
                
                if (cuenDeposito == 1) {
                    Usuario.setDeposito(cuenta1, monto);
                    System.out.println(cuenta1.getDatosCuenta());
                } else if (cuenDeposito == 2) {
                    Usuario.setDeposito(cuenta2, monto);
                    System.out.println(cuenta2.getDatosCuenta());
                } else {
                    System.out.println("ERROR: Cuenta no válida.");
                }
                break;
                
            case "T":
                // ... (Lógica de transferencia, sin cambios)
                System.out.print("Ingrese el monto a transferir (De Juan a Diana): ");
                monto = scn.nextDouble();
                
                Usuario.setTransferencia(cuenta1, cuenta2, monto); 
                
                System.out.println("\n--- ESTADOS DE CUENTA DESPUÉS DE LA TRANSFERENCIA ---");
                System.out.println(cuenta1.getDatosCuenta());
                System.out.println(cuenta2.getDatosCuenta());
                break;
                
            case "E":
                System.out.println("Gracias por usar el Banco Creativo. ¡Hasta pronto!");
                break;
                
            default:
                System.out.println("ERROR: Operación no reconocida. Intente con A, B, D, T o E.");
        }
        scn.close();
    }
}