package ec.edu.monster.model;

import ec.edu.monster.model.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-16T02:22:53")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Integer> cliente_edad;
    public static volatile SingularAttribute<Cliente, Persona> persona;
    public static volatile SingularAttribute<Cliente, String> cliente_correo;
    public static volatile SingularAttribute<Cliente, String> cliente_telefono;
    public static volatile SingularAttribute<Cliente, Integer> cliente_id;

}