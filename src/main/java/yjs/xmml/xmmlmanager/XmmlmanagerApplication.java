package yjs.xmml.xmmlmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class XmmlmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(XmmlmanagerApplication.class, args);
    }

}
