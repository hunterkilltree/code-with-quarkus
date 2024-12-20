package org.hunterkilltree.app;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain(name = "app1")
public class MainApplication implements QuarkusApplication {
    @Override
    public int run(String... args) {
        System.out.println("This application is running");
        return 0;
    }
}
