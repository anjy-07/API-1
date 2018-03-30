package com.mycompany.DTO;

import com.mycompany.DTO.Question;
import com.mycompany.DTO.Visit;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-30T14:55:31")
@StaticMetamodel(Answer.class)
public class Answer_ { 

    public static volatile SingularAttribute<Answer, Visit> vid;
    public static volatile SingularAttribute<Answer, String> answer;
    public static volatile SingularAttribute<Answer, Integer> ansId;
    public static volatile SingularAttribute<Answer, Question> qid;

}