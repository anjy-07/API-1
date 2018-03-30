package com.mycompany.DTO;

import com.mycompany.DTO.Question;
import com.mycompany.DTO.Task;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-30T14:55:31")
@StaticMetamodel(Programme.class)
public class Programme_ { 

    public static volatile CollectionAttribute<Programme, Question> questionCollection;
    public static volatile CollectionAttribute<Programme, Task> taskCollection;
    public static volatile SingularAttribute<Programme, String> name;
    public static volatile SingularAttribute<Programme, String> launchdate;
    public static volatile SingularAttribute<Programme, String> description;
    public static volatile SingularAttribute<Programme, Integer> pid;

}