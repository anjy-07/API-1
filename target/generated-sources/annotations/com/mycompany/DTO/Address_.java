package com.mycompany.DTO;

import com.mycompany.DTO.Task;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-30T14:55:31")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, Integer> pincode;
    public static volatile SingularAttribute<Address, String> address;
    public static volatile CollectionAttribute<Address, Task> taskCollection;
    public static volatile SingularAttribute<Address, String> city;
    public static volatile SingularAttribute<Address, String> district;
    public static volatile SingularAttribute<Address, String> state;
    public static volatile SingularAttribute<Address, Integer> aid;

}