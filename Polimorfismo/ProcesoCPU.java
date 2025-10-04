public class ProcesoCPU extends Proceso {
    private int usoCPU;
    
    public ProcesoCPU(int pid, String nombre, int usoCPU) {
        super(pid, nombre);
        this.usoCPU = usoCPU;
    }
    
    @Override
    public void ejecutar() {
        // Solo hace el trabajo, sin prints
        // El Main se encargará de mostrar los mensajes
        try {
            Thread.sleep(1000); // Simula trabajo sin prints
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public String getInfoEjecucion() {
        return "Ejecutando proceso CPU: " + getNombre() + 
               " - Usando " + usoCPU + "% del CPU para cálculos intensivos";
    }
    
    public int getUsoCPU() {
        return usoCPU;
    }
    
    public void setUsoCPU(int usoCPU) {
        this.usoCPU = usoCPU;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Tipo: CPU, Uso CPU: " + usoCPU + "%";
    }
}