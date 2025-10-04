public class Daemon extends Proceso {
    private String servicio;
    
    public Daemon(int pid, String nombre, String servicio) {
        super(pid, nombre);
        this.servicio = servicio;
    }
    
    @Override
    public void ejecutar() {
        // Solo hace el trabajo, sin prints
        try {
            Thread.sleep(2000); // Simula servicio sin prints
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public String getInfoEjecucion() {
        return "Ejecutando Daemon: " + getNombre() + 
               " - Proporcionando servicio: " + servicio;
    }
    
    public String getServicio() {
        return servicio;
    }
    
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Tipo: Daemon, Servicio: " + servicio;
    }
}