package org.example;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.util.stream.Stream;

public class Application {

    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) throws LifecycleException {
        final int port = defaultPortIfNull(args);

        final Tomcat tomcat = new Tomcat();
        tomcat.setConnector(createConnector(port));
        // ToDo : WebApp 폴더 구현 필요
        final var docBase = new File("mvcStudy/src/main/").getAbsolutePath();

        tomcat.addWebapp("", docBase);
        tomcat.start();
        tomcat.getServer().await();
    }

    private static Connector createConnector(int port) {
        final Connector connector = new Connector();
        connector.setPort(port);
        connector.setProperty("bindOnInit", "false");
        return connector;
    }

    private static int defaultPortIfNull(String[] args) {
        return Stream.of(args)
                .findFirst()
                .map(Integer :: parseInt)
                .orElse(DEFAULT_PORT);
    }
}