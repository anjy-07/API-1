package com.mycompany.DTO;

import com.mycompany.DTO.Login;
import com.mycompany.DTO.Office;
import com.mycompany.DTO.Task;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-30T14:55:31")
@StaticMetamodel(Officer.class)
public class Officer_ { 

    public static volatile SingularAttribute<Officer, String> rtd;
    public static volatile CollectionAttribute<Officer, Task> taskCollection;
    public static volatile SingularAttribute<Officer, Office> officeId;
    public static volatile SingularAttribute<Officer, Integer> mobile;
    public static volatile SingularAttribute<Officer, String> name;
    public static volatile SingularAttribute<Officer, Integer> aadharCard;
    public static volatile SingularAttribute<Officer, String> emailId;
    public static volatile SingularAttribute<Officer, Integer> oid;
    public static volatile SingularAttribute<Officer, String> designation;
    public static volatile SingularAttribute<Officer, Login> login;
    public static volatile SingularAttribute<Officer, String> doj;
    public static volatile SingularAttribute<Officer, String> adminRights;

}