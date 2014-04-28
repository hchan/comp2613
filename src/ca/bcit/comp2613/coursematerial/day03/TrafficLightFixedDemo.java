package ca.bcit.comp2613.coursematerial.day03;

public class TrafficLightFixedDemo {

	public static void main(String[] args) {
		TrafficLight[] trafficLights = { TrafficLight.GREEN,
				TrafficLight.GREEN, TrafficLight.GREEN, TrafficLight.RED };
		int countOfGreenLights = 0;
		for (int i = 0; i < trafficLights.length; i++) {
			TrafficLight trafficLight = trafficLights[i];
			if (trafficLight == TrafficLight.GREEN) {
				countOfGreenLights++;
			}
		}
		System.out.println(countOfGreenLights);
		//checkTrafficLightWithEquals (trafficLights);
	}

	private static void checkTrafficLightWithEquals(TrafficLight[] trafficLights) {
		int countOfGreenLights = 0;
		for (int i = 0; i < trafficLights.length; i++) {
			TrafficLight trafficLight = trafficLights[i];
			if (trafficLight.equals(TrafficLight.GREEN)) {
				// if in double of what equals does ... check the source code (high light and then
				// F3 or CTRL-LeftMouse)
				countOfGreenLights++;
			}
		}
		System.out.println(countOfGreenLights);
	}

}
