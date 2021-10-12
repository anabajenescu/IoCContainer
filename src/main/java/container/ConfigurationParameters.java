package main.java.container;

public enum ConfigurationParameters {

    DATABASE_FILE("databaseFile"),
    INTERFACE_CLASS("interface"),
    IMPLEMENTATION_CLASS("implementationClass"),
    COMPONENT_INSTANCE("componentInstance"),
    METHOD_NAME("methodName"),
    METHOD_PARAMETER("methodParameter");

    private ConfigurationParameters(final String value) {
    }
}
