package weather;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WeatherStationTest {
    private WeatherStation weatherStation;
    private CurrentConditionsDisplay currentConditionsDisplay;

    @Before
    public void setUp() {
        weatherStation = new WeatherStation();
        currentConditionsDisplay = new CurrentConditionsDisplay();
        weatherStation.registerObserver(currentConditionsDisplay);
    }

    @Test
    public void testObserverGetsNotification() {
        weatherStation.setMeasurements(80, 65, 30.4f);
        // Use a mechanism to verify output; here we assume display() updates some state we can verify
        // For simplicity, let's assume you modify CurrentConditionsDisplay to hold the latest values for assertion
        assertEquals(80, currentConditionsDisplay.getTemperature(), 0.01);
        assertEquals(65, currentConditionsDisplay.getHumidity(), 0.01);
    }

    @Test
    public void testObserverDoesNotReceiveNotificationWhenUnregistered() {
        weatherStation.removeObserver(currentConditionsDisplay);
        weatherStation.setMeasurements(70, 50, 29.2f);
        // No notification should be received; ensure the previous values are not updated
        assertNotEquals(70, currentConditionsDisplay.getTemperature(), 0.01);
        assertNotEquals(50, currentConditionsDisplay.getHumidity(), 0.01);
    }
}

