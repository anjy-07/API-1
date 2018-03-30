package com.mycompany.DTO;

import com.mycompany.DTO.Action;
import com.mycompany.DTO.Answer;
import com.mycompany.DTO.Task;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-30T14:55:31")
@StaticMetamodel(Visit.class)
public class Visit_ { 

    public static volatile SingularAttribute<Visit, Integer> vid;
    public static volatile SingularAttribute<Visit, String> remarkOfficer;
    public static volatile CollectionAttribute<Visit, Answer> answerCollection;
    public static volatile SingularAttribute<Visit, String> remarkAdmin;
    public static volatile SingularAttribute<Visit, Action> actionId;
    public static volatile SingularAttribute<Visit, String> picture;
    public static volatile SingularAttribute<Visit, BigDecimal> lat;
    public static volatile SingularAttribute<Visit, Task> tid;
    public static volatile SingularAttribute<Visit, BigDecimal> longitude;

}