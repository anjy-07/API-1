package com.mycompany.DTO;

import com.mycompany.DTO.Officer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-30T14:55:31")
@StaticMetamodel(Login.class)
public class Login_ { 

    public static volatile SingularAttribute<Login, String> password;
    public static volatile SingularAttribute<Login, String> tokenId;
    public static volatile SingularAttribute<Login, Officer> officer;
    public static volatile SingularAttribute<Login, Integer> oid;

}