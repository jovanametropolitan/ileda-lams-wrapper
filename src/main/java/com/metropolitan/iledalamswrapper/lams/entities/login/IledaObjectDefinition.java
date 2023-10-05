package com.metropolitan.iledalamswrapper.lams.entities.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IledaObjectDefinition {
    private  String type = "http://id.tincanapi.com/activitytype/lms";
    private  IledaObjectDefinitionName name = new IledaObjectDefinitionName();
}
