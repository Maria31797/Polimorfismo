import java.util.*;

public class Planificador {
    private ArrayList<Proceso> procesos;
    private int nextPid;
    
    public Planificador() {
        procesos = new ArrayList<>();
        nextPid = 1;
    }
    
    public void agregarProceso(Proceso proceso) {
        procesos.add(proceso);
    }
    
    public ArrayList<Proceso> getProcesos() {
        return procesos;
    }
    
    public void removerProceso(int pid) {
        for(int i = 0; i < procesos.size(); i++) {
            if(procesos.get(i).getPid() == pid) {
                procesos.remove(i);
                return;
            }
        }
    }
    
    public boolean existeProceso(int pid) {
        for(Proceso proceso : procesos) {
            if(proceso.getPid() == pid) {
                return true;
            }
        }
        return false;
    }
    
    public int getNextPid() {
        return nextPid++;
    }
}