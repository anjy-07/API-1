package com.mycompany.DTO;

import com.mycompany.DTO.Task;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-30T14:55:31")
@StaticMetamodel(Status.class)
public class Status_ { 

    public static volatile CollectionAttribute<Status, Task> taskCollection;
    public static volatile SingularAttribute<Status, Integer> statusId;
    public static volatile SingularAttribute<Status, String> status;

}