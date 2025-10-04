import java.util.*;

public class Vista {
    private Scanner scanner;
    
    public Vista() {
        scanner = new Scanner(System.in);
    }
    
    public int mostrarMenuYLeerOpcion() {
        System.out.println("\n=== SIMULADOR DE SISTEMA OPERATIVO ===");
        System.out.println("1. Agregar proceso CPU");
        System.out.println("2. Agregar proceso I/O");
        System.out.println("3. Agregar Daemon");
        System.out.println("4. Listar procesos");
        System.out.println("5. Ejecutar todos los procesos");
        System.out.println("6. Remover proceso");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
        return leerOpcion();
    }
    
    public String pedirNombreProceso() {
        System.out.print("Nombre del proceso: ");
        return leerTexto();
    }
    
    public int pedirUsoCPU() {
        System.out.print("Uso de CPU (%): ");
        return leerOpcion();
    }
    
    public String pedirDispositivo() {
        System.out.print("Dispositivo: ");
        return leerTexto();
    }
    
    public String pedirServicio() {
        System.out.print("Servicio: ");
        return leerTexto();
    }
    
    public int pedirPID() {
        System.out.print("PID del proceso a remover: ");
        return leerOpcion();
    }
    
    // Estos métodos son privados ahora
    private int leerOpcion() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }
    
    private String leerTexto() {
        scanner.nextLine();
        return scanner.nextLine();
    }
}