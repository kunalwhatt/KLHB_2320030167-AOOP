package weather;

public class Main {
    public static void main(String[] args) {
        // Create the weather station
        WeatherStation weatherStation = new WeatherStation();

        // Create observers
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();

        // Register observers
        weatherStation.registerObserver(currentConditionsDisplay);

        // Simulate weather changes and notify observers
        System.out.println("Setting initial weather conditions...");
        weatherStation.setMeasurements(80, 65, 30.4f);

        System.out.println("\nSetting new weather conditions...");
        weatherStation.setMeasurements(70, 55, 29.9f);

        // Unregister an observer
        weatherStation.removeObserver(currentConditionsDisplay);

        System.out.println("\nSetting weather conditions after unregistering observer...");
        weatherStation.setMeasurements(60, 45, 29.5f);
    }
}

