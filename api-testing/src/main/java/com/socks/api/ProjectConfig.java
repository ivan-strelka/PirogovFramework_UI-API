package com.socks.api;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:config.properties"})
public interface ProjectConfig extends Config {

//    String env();

    //    @Key("{env}.baseURL") -  будет ссылаться на парамет -Denv=test или -Dprod
    String baseURL();

    @DefaultValue("en")
    String locale();

    boolean logging();


}
