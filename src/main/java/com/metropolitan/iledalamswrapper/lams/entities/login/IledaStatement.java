package com.metropolitan.iledalamswrapper.lams.entities.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IledaStatement {
    private static String priority = "MEDIUM";
    private IledaActor actor;
    private IledaVerb verb;
    private IledaObject object = new IledaObject();
    private String timestamp;
}
