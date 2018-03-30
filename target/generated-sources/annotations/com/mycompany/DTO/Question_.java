package com.mycompany.DTO;

import com.mycompany.DTO.Answer;
import com.mycompany.DTO.Programme;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-30T14:55:31")
@StaticMetamodel(Question.class)
public class Question_ { 

    public static volatile SingularAttribute<Question, String> question;
    public static volatile CollectionAttribute<Question, Answer> answerCollection;
    public static volatile SingularAttribute<Question, String> format;
    public static volatile SingularAttribute<Question, String> description;
    public static volatile SingularAttribute<Question, Programme> pid;
    public static volatile SingularAttribute<Question, Integer> qid;
    public static volatile SingularAttribute<Question, String> visitType;

}