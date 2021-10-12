package main.java.container;

public enum ConfigurationParameters {

    DATABASE_FILE("databaseFile"),
    INTERFACE_CLASS("interface"),
    IMPLEMENTATION_CLASS("implementationClass"),
    COMPONENT_INSTANCE("componentInstance"),
    METHOD_NAME("methodName"),
    METHOD_PARAMETER("methodParameter");

    private final String value;

    ConfigurationParameters(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
