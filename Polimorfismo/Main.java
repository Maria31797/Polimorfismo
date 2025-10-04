public class Main {
    public static void main(String[] args) {
        Vista vista = new Vista();
        Planificador planificador = new Planificador();
        boolean salir = false;
        
        // Procesos de ejemplo
        planificador.agregarProceso(new ProcesoCPU(1, "Compilador", 80));
        planificador.agregarProceso(new ProcesoIO(2, "Lectura Disco", "Disco Duro"));
        planificador.agregarProceso(new Daemon(3, "Syslog", "Registro de eventos"));
        
        System.out.println("=== BIENVENIDO AL SIMULADOR DE PROCESOS ===");
        
        while(!salir) {
            int opcion = vista.mostrarMenuYLeerOpcion();
            
            switch(opcion) {
                case 1:
                    System.out.println("\n--- AGREGAR PROCESO CPU ---");
                    String nombreCPU = vista.pedirNombreProceso();
                    int usoCPU = vista.pedirUsoCPU();
                    ProcesoCPU nuevoCPU = new ProcesoCPU(planificador.getNextPid(), nombreCPU, usoCPU);
                    planificador.agregarProceso(nuevoCPU);
                    System.out.println("✅ Proceso CPU agregado correctamente!");
                    break;
                    
                case 2:
                    System.out.println("\n--- AGREGAR PROCESO I/O ---");
                    String nombreIO = vista.pedirNombreProceso();
                    String dispositivo = vista.pedirDispositivo();
                    ProcesoIO nuevoIO = new ProcesoIO(planificador.getNextPid(), nombreIO, dispositivo);
                    planificador.agregarProceso(nuevoIO);
                    System.out.println("✅ Proceso I/O agregado correctamente!");
                    break;
                    
                case 3:
                    System.out.println("\n--- AGREGAR DAEMON ---");
                    String nombreDaemon = vista.pedirNombreProceso();
                    String servicio = vista.pedirServicio();
                    Daemon nuevoDaemon = new Daemon(planificador.getNextPid(), nombreDaemon, servicio);
                    planificador.agregarProceso(nuevoDaemon);
                    System.out.println("✅ Daemon agregado correctamente!");
                    break;
                    
                case 4:
                    System.out.println("\n=== LISTA DE PROCESOS REGISTRADOS ===");
                    if(planificador.getProcesos().isEmpty()) {
                        System.out.println("No hay procesos registrados.");
                    } else {
                        for(Proceso proceso : planificador.getProcesos()) {
                            System.out.println("🔹 " + proceso.toString());
                        }
                        System.out.println("Total: " + planificador.getProcesos().size() + " procesos");
                    }
                    break;
                    
                case 5:
                    System.out.println("\n=== EJECUTANDO TODOS LOS PROCESOS ===");
                    if(planificador.getProcesos().isEmpty()) {
                        System.out.println("No hay procesos para ejecutar.");
                    } else {
                        for(Proceso proceso : planificador.getProcesos()) {
                            // Polimorfismo: mismo método, comportamiento diferente
                            if(proceso instanceof ProcesoCPU) {
                                System.out.println("🖥️  " + ((ProcesoCPU)proceso).getInfoEjecucion());
                            } else if(proceso instanceof ProcesoIO) {
                                System.out.println("💾 " + ((ProcesoIO)proceso).getInfoEjecucion());
                            } else if(proceso instanceof Daemon) {
                                System.out.println("👻 " + ((Daemon)proceso).getInfoEjecucion());
                            }
                            
                            proceso.ejecutar(); // Ejecución polimórfica
                            
                            System.out.println("✅ Completado!\n");
                        }
                    }
                    break;
                    
                case 6:
                    System.out.println("\n--- REMOVER PROCESO ---");
                    int pid = vista.pedirPID();
                    if(planificador.existeProceso(pid)) {
                        planificador.removerProceso(pid);
                        System.out.println("✅ Proceso con PID " + pid + " removido correctamente.");
                    } else {
                        System.out.println("❌ No se encontró proceso con PID " + pid);
                    }
                    break;
                    
                case 7:
                    salir = true;
                    System.out.println("👋 ¡Hasta luego! Gracias por usar el simulador.");
                    break;
                    
                default:
                    System.out.println("❌ Opción inválida! Por favor seleccione 1-7.");
            }
        }
    }
}