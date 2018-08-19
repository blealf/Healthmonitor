package Assessment;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * the HealthMonitorTest class is a test class for the HealthMonitor class.
 * Each method available in the HealthMonitor class is tested, values are varied 
 * and re-tested to ensure the proper functioning of the class.
 */
public class HealthTest {

	public static void main(String[] args) throws FileNotFoundException {
		// a variable to store the number of patients to be monitored
		int numOfPatients;

		//create an ArrayList to hold details of patients
		ArrayList<HealthMonitor> patients = new ArrayList<>();

		//Create a new scanner object to read from standard output
		Scanner sc = new Scanner(System.in);

		//prompts the user to enter the number of patients to be monitored
		System.out.println("Welcome:");
		System.out.println("This is the HealtMonitor test class........\n");
		System.out.println("Enter number of patients to be monitored :  ");
		numOfPatients = sc.nextInt();

		/*adds a number of new patient to the list determined
		  by the number of patients entered above*/
		for (int i = 1; i <= numOfPatients; i++)
		{
			//accepts values from the user and assigns it to variables
			System.out.println("for patient " + (i) + ": \n");
			System.out.println("Enter blood pressure top value: ");
			int bPTopValue = sc.nextInt();
			System.out.println("Enter blood pressure bottom value: ");
			int bPBottomValue = sc.nextInt();
			System.out.println("Enter temperature value: ");
			double temperature = sc.nextDouble();
			System.out.println("Enter heart beat value: ");
			int heartBeat = sc.nextInt();

			//the variables are used to create a new monitor object added to the list
			patients.add(new HealthMonitor(bPTopValue, bPBottomValue, temperature, heartBeat));
		}

		//create two health monitor objects to effectively test the methods

		//using the default constructor
		HealthMonitor patient1 = new HealthMonitor();

		//using the custom constructor
		HealthMonitor patient2 = new HealthMonitor(120, 82, 37.0, 72);

		//print out the number of patient in the list in order/number of patient
		patients.forEach(p -> System.out.println("patient" + (patients.indexOf(p)+1) + "= " + p));

//		//stream
//		patients.stream().filter(p.getAlert);

		//testing methods
		//testing the set and methods
		patient1.setBloodPressure(120, 100);
		patient1.setHeartBeat(40);
		System.out.println("Testing the getHeartBeat() method. Expected: 40");
		System.out.println("Actual: " + patient1.getHeartBeat());
		patient1.setTemperature(49);
		System.out.println("Testing the getTemperature() method. Expected: 49.0");
		System.out.println("Actual: " + patient1.getTemperature());
		patient2.setBloodPressure(110, 70);
		System.out.println("Testing the get blood pressure method. Expected: 110/70");
		System.out.println("Actual: " + patient2.getBloodPressure() + "\n");

		//testing the alert methods
		System.out.println("testing the getAlert method. Expected Blood pressure is too high "
				+ "Temperature is too high Heart Beat rate is too low");
		System.out.println("Actual: \n" + patient1.getAlert());
		System.out.println("testing the getTemperatureAlert method alone. Expected: Temperature is okay. Keep it up!! ");
		System.out.println("Actual: " + patient2.getTemparatureAlert());
		System.out.println("testing the getHeartBeatAlert method alone. Expected: heart beat rate is too low");
		System.out.println("Actual: " + patient1.getHeartBeatAlert());
		System.out.println("testing the getBloodPressureAlert. Expected: blood pressure is too high");
		System.out.println("Actual: " +  patient1.getBloodPressureAlert());
		//
		//		patients.get(2).getTemparatureAlert();

		//testing the increase and decrease blood pressure methods
		//		patients.get(1).increaseBloodPressure();
		//		patients.get(1).increaseBloodPressure(2, 5);
		patient1.increaseBloodPressure();
		System.out.println("testing the increaseBloodPressure method. Expected: 121/101");
		System.out.println("Actual: " + patient1.getBloodPressure());
		patient1.increaseBloodPressure(10, 5);
		System.out.println("testint the increaseBloodPressure method with a parameter. Expected: 131/106");
		System.out.println("Actual: " + patient1.getBloodPressure());
		patient1.decreaseBloodPressure();
		System.out.println("testing the decreaseBloodPressure method. Expected: 130/105");
		System.out.println("Actual: " + patient1.getBloodPressure());
		patient1.decreaseBloodPressure(4, 8);
		System.out.println("testing the decreaseBloodPressure method with parameters. Expected: 126/97");
		System.out.println("Actual: " + patient1.getBloodPressure());
		patient2.increaseHeartBeat();

		//heart beat
		System.out.println("testing the increaseheartBeat method. Expected: 73");
		System.out.println("Actual: " + patient2.getHeartBeat());
		patient2.increaseHeartBeat(3);
		System.out.println("testing the increaseHeartBeat method with parameters. Expected: 76");
		System.out.println("Actual: " +  patient2.getHeartBeat());
		patient2.decreaseHeartBeat();
		System.out.println("testing the decreaseheartBeat method. Expected: 75");
		System.out.println("Actual: " + patient2.getHeartBeat());
		patient2.decreaseHeartBeat(5);
		System.out.println("testing the decreaseHeartBeat method with parameter. Expected: 70");
		System.out.println("Actual: " + patient2.getHeartBeat());
		patient1.increaseTemperature();

		//temperature
		System.out.println("testing the increaseTemperature method. Expected: 50.0");
		System.out.println("Actual: " +  patient1.getTemperature());
		patient1.increaseTemperature(7);
		System.out.println("testing the increaseTemperatureMethod with parameter. Expected: 57.0");
		System.out.println("Actual: " +  patient1.getTemperature());
		patient1.decreaseTemperature();
		System.out.println("testing the decreaseTemperature method. Expected: 56.0");
		System.out.println("Actual: " + patient1.getTemperature());
		patient1.decreaseTemperature(6);
		System.out.println("testing the decreaseTemperature method with parameter. Expected 50.0");
		System.out.println("Actual: " + patient1.getTemperature() + "\n");

		//further testing the methods
		patient1.increaseHeartBeat(60);
		System.out.println("Futher testing the heart beat alert method. Expected: on the high edge");
		System.out.println("Actual: " + patient1.getHeartBeatAlert() + "\n");

		System.out.println("Testing the to fahrenheit method. Expects 50 for celsius and 82 for fahrenheit.");

		System.out.println("Temperature in celsius is: " + patient1.getTemperature());

		patient1.toFahrenheit();
		System.out.println("Actual: ");
		System.out.println("Temperature in fahrenheit is: " + patient1.getTemperature() + "\n");


		//testing the toString method
		System.out.println("Testing the toString method. "
				+ "Expects fahrenheit for patient1 temperature unit");
		System.out.println("patient1: " + patient1 + "\n");
		System.out.println("patient2: " + patient2 + "\n");

		//testing the equals method
		HealthMonitor p1 = patient1;
		System.out.println("Testing the equals method. Expected: true ");
		HealthMonitor pp1 = new HealthMonitor(126, 97, 50.0, 40);
		HealthMonitor pp2 = new HealthMonitor(126, 97, 50.0, 40);
		System.out.println("Actual: " + patient1.equals(p1));

		System.out.println("Equals '==' method will return false and"
				+ "\nthe'.equals()' overriden method will return true.' ");
		System.out.println("== : " + (pp2 == pp1));
		System.out.println(".equals() :  " + (pp2.equals(pp1)));
		System.out.println("the two are not equal. false is expected: " + (pp1.equals(patient2)));

		//further testing the.equals() method.
		System.out.println("Change the bottom value of one of the equal objects.");
		pp1.setBloodPressure(126, 98);
		System.out.println("false is expected. " + "\nActual: " + (pp1.equals(pp2)) + "\n");
		
		//get the minimum and maximum
		System.out.println("This method [getAllMinimumAndMaximum()] will return all "
				+ "\nthe minimum and maximum values for the "
				+ "\nBlodd pressure, Temperature, and Heart beat.");
		System.out.println("Testing......" + patient1.getAllMinimumAndMaximum());

		//closes the Scanner object sc.
		sc.close();

		//create a new PrintWriter object to write to file HealthMonitor.txt.
		PrintWriter pw = new PrintWriter("HealthMonitorOutput.txt");
		pw.println("****************           **");
		pw.println("******************       **");
		pw.println("**  HEALTH    ******   **");
		pw.println("**  MONITOR   ********");
		pw.println("**  PRINTING  ************");
		pw.println("**            ************");
		pw.println("***********************************");
		pw.println("***********************************");

		//prints the number of patient in the list in order/number of patient to the specified file
		patients.forEach(p -> pw.println("ArrayList patient" + (patients.indexOf(p) + 1) + ": " + p.toString()
						+ System.getProperty("line.separator")));
		pw.println();
		pw.println("patient1: " + patient1 + "\n");
		pw.println("patient2: " + patient2);

		pw.println();
		pw.println("------------------------------------");
		pw.println("            THANKS                  ");
		pw.println("            CHEERS                  ");
		pw.println("------------------------------------");
		pw.println("[[[[[[[[[[[[[[[[[[]]]]]]]]]]]]]]]]]]");


		//flushes the content above to the file
		pw.flush();

		//closes the PrintWriter object pw.
		pw.close();



	}

}
