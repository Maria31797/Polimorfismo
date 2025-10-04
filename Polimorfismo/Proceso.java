
public abstract class Proceso {
    private int pid;
    private String nombre;
    
    public Proceso(int pid, String nombre) {
        this.pid = pid;
        this.nombre = nombre;
    }
    
    public abstract void ejecutar();
    
    public int getPid() {
        return pid;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return "PID: " + pid + ", Nombre: " + nombre;
    }
}