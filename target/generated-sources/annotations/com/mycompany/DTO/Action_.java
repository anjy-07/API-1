package com.mycompany.DTO;

import com.mycompany.DTO.Visit;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-30T14:55:31")
@StaticMetamodel(Action.class)
public class Action_ { 

    public static volatile CollectionAttribute<Action, Visit> visitCollection;
    public static volatile SingularAttribute<Action, Integer> actionId;
    public static volatile SingularAttribute<Action, String> action;

}