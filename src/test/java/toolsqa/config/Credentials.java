package toolsqa.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/credentials.properties"})
public interface Credentials extends Config {

    String login();
    String password();
}
