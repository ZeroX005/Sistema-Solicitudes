package Interfaces;

import java.util.ArrayList;
import java.util.List;

public interface IUsuarioTIDAO<Objeto> {

    public Objeto autenticar(Object x1, Object x2);

    public boolean estadoconexion(Object x, Object y);

    public ArrayList consultaTecnico();
    
    public Objeto tecnicoAsignado();

}
