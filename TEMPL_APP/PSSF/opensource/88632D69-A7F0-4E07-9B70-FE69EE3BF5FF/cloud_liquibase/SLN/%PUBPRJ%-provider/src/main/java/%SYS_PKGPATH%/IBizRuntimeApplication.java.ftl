<#ibiztemplate>
TARGET=PSSYSTEM
</#ibiztemplate>
package ${pub.getPKGCodeName()};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient(autoRegister=false)
@SpringBootApplication(exclude= SecurityAutoConfiguration.class)
@ComponentScan({"net.ibizsys.central.cloud.core.spring","net.ibizsys.central.plugin.liquibase.spring","${pub.getPKGCodeName()}"})
public class IBizRuntimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(IBizRuntimeApplication.class, args);
    }

}
