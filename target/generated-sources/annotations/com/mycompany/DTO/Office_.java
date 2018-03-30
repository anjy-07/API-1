package com.mycompany.DTO;

import com.mycompany.DTO.Officer;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-30T14:55:31")
@StaticMetamodel(Office.class)
public class Office_ { 

    public static volatile SingularAttribute<Office, Integer> pincode;
    public static volatile SingularAttribute<Office, String> address;
    public static volatile SingularAttribute<Office, Integer> officeId;
    public static volatile SingularAttribute<Office, String> city;
    public static volatile SingularAttribute<Office, String> district;
    public static volatile SingularAttribute<Office, String> state;
    public static volatile CollectionAttribute<Office, Officer> officerCollection;

}