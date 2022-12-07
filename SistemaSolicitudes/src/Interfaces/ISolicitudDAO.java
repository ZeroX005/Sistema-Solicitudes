package Interfaces;

import java.util.List;

public interface ISolicitudDAO<Objeto> {

    public List<Objeto> listar();
    
    public List<Objeto> listarEst (int idEst);
    
    public List<Objeto> filtrar(String cad);

    public boolean crear(Objeto obj);

    public boolean ModificarJF(Objeto obj);
    
    public boolean atenderSolicitudJF(Objeto obj);

    public boolean cierreSolicitudJF(Objeto obj);
    
    public boolean ModificarCliente (Objeto obj);
    
    public boolean atenderSolicitud(Objeto obj);

    public boolean cierreSolicitud(Objeto obj);

    public boolean eliminar(Object x);

    public Objeto leer(Object x);


}
