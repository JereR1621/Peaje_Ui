package peaje;

import java.util.ArrayList;

public class Main {
    
    

    public static void main(String[] args) {
        
        
        ArrayList<Peaje> peajes = new ArrayList<>();
        peajes.add(new Peaje("Peaje Norte", "Departamento A"));
        peajes.add(new Peaje("Peaje Sur", "Departamento B"));
        
        new FormularioPeaje(peajes);
        

        
        /* 
        //codigo antiguo
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.println("Seleccione el tipo de vehículo para cobrar el peaje:");
            System.out.println("1. Moto (5000)");
            System.out.println("2. Carro (10000)");
            System.out.println("3. Camión (5000 por eje)");
            System.out.println("4. Imprimir boletas");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    
                    System.out.print("Ingrese la placa de la moto: ");
                    String placaMoto = scanner.nextLine();
                    moto moto = new moto(placaMoto);
                    Boleta boletaMoto = new Boleta("Moto", 5000,placaMoto);
                    
                    peaje.ingresar_boleta(boletaMoto);
                    
                    break;

                case 2:
                    
                    System.out.print("Ingrese la placa del carro: ");
                    String placaCarro = scanner.nextLine();
                    carro carro = new carro(placaCarro);
                    Boleta boletaCarro = new Boleta("Carro", 10000,placaCarro);
                    peaje.ingresar_boleta(boletaCarro);
                    
                    break;

                case 3:
                    // Camión
                    System.out.print("Ingrese la placa del camión: ");
                    String placaCamion = scanner.nextLine();
                    System.out.print("Ingrese el número de ejes: ");
                    int nEjes = scanner.nextInt();
                    scanner.nextLine(); 
                    Camion camion = new Camion(nEjes, placaCamion);
                    int totalCamion = 5000 * nEjes;
                    
                    Boleta boletaCamion = new Boleta("Camión", totalCamion,placaCamion);
                    
                    
                    
                    peaje.ingresar_boleta(boletaCamion);
                  
                    break;

                case 4:
                    peaje.imprimir();
                    break;

                case 5:
                    
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        scanner.close();
        */
    }
    
    
    
}