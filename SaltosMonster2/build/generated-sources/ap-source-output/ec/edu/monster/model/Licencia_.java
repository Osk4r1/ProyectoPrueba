package ec.edu.monster.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-16T02:22:53")
@StaticMetamodel(Licencia.class)
public class Licencia_ { 

    public static volatile SingularAttribute<Licencia, Integer> paracaidista_id;
    public static volatile SingularAttribute<Licencia, Integer> licencia_id;
    public static volatile SingularAttribute<Licencia, String> licencia_tipo;
    public static volatile SingularAttribute<Licencia, Integer> cliente_id;
    public static volatile SingularAttribute<Licencia, Date> licencia_caducidad;

}