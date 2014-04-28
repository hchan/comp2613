package ca.bcit.comp2613.coursematerial.day03;

public class TrafficLightDemo {

	public static void main(String[] args) {
		String[] trafficLights = {"green", "Green", "GREEN", "red"};
		int countOfGreenLights = 0;
		for (int i = 0; i < trafficLights.length; i++) {
			String trafficLight = trafficLights[i];
			if (trafficLight.equals("green")) {
				countOfGreenLights++;
			}
		}
		System.out.println(countOfGreenLights);
	}

}
