package ec.edu.monster.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-16T02:22:53")
@StaticMetamodel(Vuelosalto.class)
public class Vuelosalto_ { 

    public static volatile SingularAttribute<Vuelosalto, String> horario_hora;
    public static volatile SingularAttribute<Vuelosalto, Integer> salto_id;
    public static volatile SingularAttribute<Vuelosalto, String> vuelo_avion;
    public static volatile SingularAttribute<Vuelosalto, Integer> vuelo_tandem;
    public static volatile SingularAttribute<Vuelosalto, Date> horario_fecha;
    public static volatile SingularAttribute<Vuelosalto, Integer> vuelo_libre;
    public static volatile SingularAttribute<Vuelosalto, Integer> disponible;

}