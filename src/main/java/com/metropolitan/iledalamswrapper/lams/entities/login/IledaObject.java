package com.metropolitan.iledalamswrapper.lams.entities.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IledaObject {
    private String id = "http://lams.metropolitan.ac.rs:8080/lams/";
    private  IledaObjectDefinition definition = new IledaObjectDefinition();
    private String objectType = "Activity";

}
