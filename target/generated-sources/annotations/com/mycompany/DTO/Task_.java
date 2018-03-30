package com.mycompany.DTO;

import com.mycompany.DTO.Address;
import com.mycompany.DTO.Officer;
import com.mycompany.DTO.Programme;
import com.mycompany.DTO.Status;
import com.mycompany.DTO.Visit;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-30T14:55:31")
@StaticMetamodel(Task.class)
public class Task_ { 

    public static volatile CollectionAttribute<Task, Visit> visitCollection;
    public static volatile SingularAttribute<Task, Status> statusId;
    public static volatile SingularAttribute<Task, String> description;
    public static volatile SingularAttribute<Task, String> setDate;
    public static volatile SingularAttribute<Task, Programme> pid;
    public static volatile SingularAttribute<Task, Officer> oid;
    public static volatile SingularAttribute<Task, String> deadline;
    public static volatile SingularAttribute<Task, Address> aid;
    public static volatile SingularAttribute<Task, Integer> tid;
    public static volatile SingularAttribute<Task, String> visitType;

}