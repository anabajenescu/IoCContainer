package main.java.container;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.Class.forName;
import static java.util.Objects.requireNonNull;
import static main.java.container.ConfigurationParameters.*;
import static main.java.container.ConfigurationParameters.METHOD_NAME;

public class HomemadeContainer {

    private final String configurationFile;

    private String componentDatabaseFile;
    private String componentInterfaceClass;
    private String componentImplementationClass;
    private String componentInstanceClass;
    private String componentMethodName;
    private String methodParameter;

    public HomemadeContainer(final String configurationFile) {
        this.configurationFile = requireNonNull(configurationFile);
        parseConfigFile();
    }

    private void parseConfigFile() {
        FileReader input;

        try {
            input = new FileReader(configurationFile);
            BufferedReader bufferedReader = new BufferedReader(input);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split("="); //todo rename array
                instantiateConfigParams(array);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void instantiateConfigParams(String[] array) { //todo rename array
        if (array[0].equals(DATABASE_FILE.name())) {
            componentDatabaseFile = array[1];
        } else if (array[0].equals(INTERFACE_CLASS.name())) {
            componentInterfaceClass = array[1];
        } else if (array[0].equals(IMPLEMENTATION_CLASS.name())) {
            componentImplementationClass = array[1];
        } else if (array[0].equals(COMPONENT_INSTANCE.name())) {
            componentInstanceClass = array[1];
        } else if (array[0].equals(METHOD_NAME.name())) {
            componentMethodName = array[1];
        } else if (array[0].equals(METHOD_PARAMETER.name())) {
            methodParameter = array[1];
        }
    }

    public void invoke() {
        try {
            Class<?> componentImplementation = forName(componentImplementationClass);
            Class<?> componentInstance = forName(componentInstanceClass);
            Class<?> componentInterface = forName(componentInterfaceClass);

            Constructor<?> componentImplementationConstructor = componentImplementation.getConstructor(String.class);
            Object componentImplementationInstance = componentImplementationConstructor.newInstance(componentDatabaseFile);

            Constructor<?> componentInstanceConstructor = componentInstance.getConstructor(componentInterface);
            Object instance = componentInstanceConstructor.newInstance(componentImplementationInstance);

            Method method = componentInstance.getDeclaredMethod(componentMethodName, String.class);
            method.invoke(instance, methodParameter);

        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }
}
