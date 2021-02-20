package ec.edu.monster.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-16T02:22:53")
@StaticMetamodel(Paracaidista.class)
public class Paracaidista_ { 

    public static volatile SingularAttribute<Paracaidista, Integer> paracaidista_id;
    public static volatile SingularAttribute<Paracaidista, Integer> paracaidista_numsaltos;
    public static volatile SingularAttribute<Paracaidista, String> paracaidista_tipo;
    public static volatile SingularAttribute<Paracaidista, String> paracaidista_escuela;
    public static volatile SingularAttribute<Paracaidista, Integer> persona_id;
    public static volatile SingularAttribute<Paracaidista, String> paracaidista_foto;
    public static volatile SingularAttribute<Paracaidista, Integer> cliente_id;
    public static volatile SingularAttribute<Paracaidista, Date> paracaidista_fechasalto;

}