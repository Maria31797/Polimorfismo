public class ProcesoIO extends Proceso {
    private String dispositivo;
    
    public ProcesoIO(int pid, String nombre, String dispositivo) {
        super(pid, nombre);
        this.dispositivo = dispositivo;
    }
    
    @Override
    public void ejecutar() {
        // Solo hace el trabajo, sin prints
        try {
            Thread.sleep(1500); // Simula espera de I/O sin prints
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public String getInfoEjecucion() {
        return "Ejecutando proceso I/O: " + getNombre() + 
               " - Esperando dispositivo: " + dispositivo;
    }
    
    public String getDispositivo() {
        return dispositivo;
    }
    
    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Tipo: I/O, Dispositivo: " + dispositivo;
    }
}