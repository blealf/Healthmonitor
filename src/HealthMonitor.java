package Assessment;
/**This program checks the blood pressure, temperature and heart beat rate
 * against the standard values to monitor the health of a patient
 *
 * Each health status tested for have minimum and maximum values.
 * If the value of any is beyond the maximum or minimum,
 * the corresponding alert is set to a condition recorded as a String.
 * But if the values are within range it gives a feedback showing
 * the good condition also as a String.
 *
 * @author p15237108(Blessing Alfred)
 *
 */
public class HealthMonitor {

		//Fields
		//the maximum and minimum values are constant and unchangeable
		private static final int bloodPressureMaximum[] = {140, 90};
		private static final int bloodPressureMinimum[] = {120, 80};
		private static final double temperatureMaximum = 37.20;
		private static final double temperatureMinimum = 36.10;
		private static final int heartBeatMaximum = 100;
		private static final int heartBeatMinimum = 60;


		/*units:
		  the units of the blood pressure and heart beat
		  rate are constant, while that of the temperature
		  can be changed between celsius and Fahrenheit.*/
		private static final String bloodPressureUnit = "mmHG";
		private static final String heartBeatUnit =  "/minute";
		private String temperatureUnit;

		//Alerts
		//stores the condition of the values
		private String bloodPressureAlert;
		private String temperatureAlert;
		private String heartBeatAlert;


		/*the values
		  The blood pressure has a top and bottom value which it stores in the
		  first and second index of its array respectively*/
		private int bloodPressure[] = new int[2];
		private double tempValue;
		private int heartBeatValue;

		//Constructors
		/**Default constructor that initialises the blood pressure, temperature
		 * and heart beat rate with some initial values.
		 */
		public HealthMonitor()
		{
			this(0, 0, 0.0, 0);//calls the custom constructor with some default values
		}


		/**Initialises the health monitor with the given value in the format
		 * (blood pressure top value, blood pressure bottom value,
		 * temperature value, heart beat rate value) and updates the alert.
		 *
		 * @param topValue the top value of the blood pressure.
		 * @param bottomValue the bottom value of the blood pressure.
		 * @param tempValue the temperature value in celsius.
		 * @param heartBeatValue the value of heart beat rate.
		 */
		public HealthMonitor(int topValue, int bottomValue, double tempValue, int heartBeatValue)
		{
			/*Assigns the topValue to the first index of the array bP[]
			  and the bottomValue to the second index of the array bP[].*/
			bloodPressure[0] = topValue;
			bloodPressure[1] = bottomValue;
			this.tempValue = tempValue;
			this.heartBeatValue = heartBeatValue;

			//this sets the temperature to celsius.
			temperatureUnit = "Celsius";

			//calls the alert(or condition) check for the different values
			this.getAlert();
		}

		//METHODS
		/**
		 * Sets the values of the blood pressure and updates the alert.
		 *
		 * @param topValue the top value for the blood pressure.
		 * @param bottomValue the bottom value for the blood pressure.
		 */
		public void setBloodPressure(int topValue, int bottomValue)
		{
			bloodPressure[0] = topValue;
			bloodPressure[1] = bottomValue;
			this.getBloodPressureAlert();

		}

		/**Sets the value for the temperature and updates the alert.
		 *
		 * @param tempValue the value for the temperature.
		 */
		public void setTemperature(double tempValue)
		{
			this.tempValue = tempValue;
			this.getTemparatureAlert();
		}

		/**Sets the heart beat rate value and updates the alert.
		 *
		 * @param heartBeatValue the value for the heart beat rate.
		 */
		public void setHeartBeat(int heartBeatValue)
		{
			this.heartBeatValue = heartBeatValue;
			this.getHeartBeatAlert();

		}



		/**Returns the minimum and maximum values for the blood pressure,
		 * temperature and heart beat rate.
		 *
		 * @return the minimum and maximum values for the blood pressure,
		 * temperature and heart beat rate.
		 */
		public String getAllMinimumAndMaximum()
		{
			return "[Blood pressure maximum: " + bloodPressureMaximum[0] + "/" + bloodPressureMaximum[1] +
					"\nBlood pressure minimum: " + bloodPressureMinimum[0] + "/" + bloodPressureMinimum[1] +
					"\nTemperature maximum: " + temperatureMaximum +
					"\nTemperature mimimum: " + temperatureMinimum +
					"\nHeart beat rate maximum: " + heartBeatMaximum +
					"\nHeart beat rate minimum: " + heartBeatMinimum + "]";
		}

		/**Returns the top and bottom value of the blood pressure
		 * in the format 'topValue/bottomValue'.
		 *
		 * @return the top and bottom values of the blood pressure.
		 */
		public String getBloodPressure()
		{
			return bloodPressure[0] + "/" + bloodPressure[1];

		}

		/**Returns the temperature value.
		 *
		 * @return the value of the temperature.
		 */
		public double getTemperature()
		{
			return tempValue;
		}

		/**Returns the heart beat rate value.
		 *
		 * @return the value of the heart beat rate.
		 */
		public int getHeartBeat()
		{
			return heartBeatValue;
		}

		/**Increases the temperature value by one and updates the alert.
		 *
		 */
		public void increaseTemperature()
		{
			tempValue++;
			this.getTemparatureAlert();
		}

		/**Decreases the temperature value by one and updates the alert.
		 *
		 */
		public void decreaseTemperature()
		{
			tempValue--;
			this.getTemparatureAlert();
		}

		/**Increases the current temperature value by the value provided
		 * in the parameter and updates the alert.
		 *
		 * @param increase the value to increase the current temperature by.
		 */
		public void increaseTemperature(double increase)
		{
			this.tempValue += increase;
			this.getTemparatureAlert();
		}

		/**Decreases the current temperature value by the value provided
		 * in the parameter and updates the alert.
		 *
		 * @param decrease the value to decrease the temperature by.
		 */
		public void decreaseTemperature(double decrease)
		{
			this.tempValue -= decrease;
			this.getTemparatureAlert();
		}

		/**Increases the heart beat rate by one and updates the alert.
		 *
		 */
		public void increaseHeartBeat()
		{
			heartBeatValue++;
			this.getHeartBeatAlert();
		}

		/**Decreases the heart beat rate by one and updates the alert.
		 *
		 */
		public void decreaseHeartBeat()
		{
			heartBeatValue--;
			this.getHeartBeatAlert();
		}

		/**Increases the current value of the heart beat rate
		 * by the value provided in the parameter and updates the alert.
		 *
		 * @param increase the value to increase the current heart beat rate by.
		 */
		public void increaseHeartBeat(int increase)
		{
			this.heartBeatValue += increase;
			this.getHeartBeatAlert();
		}

		/**Decreases the current value of the heart beat rate
		 * by the value provided in the parameter and updates the alert.
		 *
		 * @param decrease the value to decrease the current heart beat rate by.
		 */
		public void decreaseHeartBeat(int decrease)
		{
			this.heartBeatValue -= decrease;
			this.getHeartBeatAlert();
		}

		/**Increases the current value of both the top and bottom values
		 * of the blood pressure by one and updates the alert.
		 *
		 */
		public void increaseBloodPressure()
		{
			/*scans through the blood pressure top
			and bottom values an increase them by one*/
			for(int i = 0; i < bloodPressure.length; i++)
			{
				bloodPressure[i]++;
			}
			this.getBloodPressureAlert();
		}

		/**Decreases the current value of both the top and bottom values
		 * of the blood pressure by one and updates the alert.
		 *
		 */
		public void decreaseBloodPressure()
		{
			/*scans through the blood pressure top
			and bottom values an decrease them by one*/
			for(int i = 0; i < bloodPressure.length; i++)
			{
				bloodPressure[i]--;
			}
			getBloodPressureAlert();
		}

		/**Increases the current value of both the top and bottom values
		 * of the blood pressure by the values provided in the parameter
		 * and updates the alert.
		 *
		 * @param topValueIncrease
		 * @param bottomValueIncrease
		 */
		public void increaseBloodPressure(int topValueIncrease, int bottomValueIncrease)
		{
			bloodPressure[0] += topValueIncrease;
			bloodPressure[1] += bottomValueIncrease;
			getBloodPressureAlert();
		}

		/**Increases the current value of both the top and bottom values
		 * of the blood pressure by the values provided in the parameter
		 * and updates the alert.
		 *
		 * @param topValueDecrease
		 * @param bottomValueDecrease
		 */
		public void decreaseBloodPressure(int topValueDecrease, int bottomValueDecrease)
		{
			bloodPressure[0] -= topValueDecrease;
			bloodPressure[1] -= bottomValueDecrease;
			getBloodPressureAlert();
		}



		//Converts from celsius to fahrenheit
		/**Converts the value of the temperature from celsius
		 * to fahrenheit and changed=s the unit from celcius to fahrenheit.
		 *
		 */
		public void toFahrenheit()
		{
			tempValue = (tempValue*(9/5)) + 32;
			temperatureUnit = "Fahrenheit";
		}

		/**Returns the alert condition for the current blood pressure values.
		 *
		 * @return the alert condition for the current blood pressure values.
		 */
		public String getBloodPressureAlert()
		{
			if (bloodPressure[0] > bloodPressureMaximum[0] || bloodPressure[1] > bloodPressureMaximum[1])
			{
				return bloodPressureAlert = "Blood pressure is TOO HIGH!!!!";
			}
				if (bloodPressure[0] < bloodPressureMinimum[0] || bloodPressure[1] < bloodPressureMinimum[1])
				{
					return bloodPressureAlert = "Blood pressure is TOO LOW!!!";
				}
					if (bloodPressure[0] < bloodPressureMaximum[0] && bloodPressure[1] > bloodPressureMaximum[0] || bloodPressure[0] > bloodPressureMinimum[0] || bloodPressure[1] > bloodPressureMinimum[1])
					{
						return bloodPressureAlert = "Blood pressure is still within range. Congrats!";
					}
			return bloodPressureAlert;
		}

		//this method gives an alert based on the value of the temperature
		/**Returns the alert condition for the current temperature value.
		 *
		 * @return the alert condition for the current temperature value.
		 */
		public String getTemparatureAlert()
		{
			if (tempValue > temperatureMaximum)
			{
				return temperatureAlert = "Temperature is too high";
			}
				if (tempValue < temperatureMinimum)
				{
					return temperatureAlert = "Temperature is too low";
				}

					if (tempValue < temperatureMaximum || tempValue > temperatureMinimum)
					{
						return temperatureAlert = "Temperature is okay. Keep it up!";
					}
			return temperatureAlert;

		}

		//
		/**Returns the alert condition for the current heart beat rate value.
		 *
		 * @return the alert condition for the current heart beat rate value.
		 */
		public String getHeartBeatAlert()
		{
			if (heartBeatValue == heartBeatMaximum )
			{
				return heartBeatAlert = "!!!On the  High edge!!!";
			}

				if (heartBeatValue > heartBeatMaximum)
				{
					return heartBeatAlert = "Heart Beat rate is too high!!!!";
				}
					if (  heartBeatValue > 40 && heartBeatValue < heartBeatMinimum)
					{
						return heartBeatAlert = "Heart Beat rate is quite low please watch out!!";
					}
						if (heartBeatValue < heartBeatMinimum)
						{
							return heartBeatAlert = "Heart Beat rate is too low!!!!";
						}

							if (heartBeatValue < heartBeatMaximum && heartBeatValue > heartBeatMinimum ||
									heartBeatValue == heartBeatMinimum)
							{
								return heartBeatAlert = "Heart Beat rate is okay. Bon!";
							}

			return heartBeatAlert;

		}

		/**Returns the alert of the blood pressure, temperature and
		 * heart beat rate.
		 *
		 * @return the alert of the blood pressure, temperature and
		 * heart beat rate.
		 */
		public String getAlert()
		{
			return this.getBloodPressureAlert() + "\n" +
			this.getTemparatureAlert() + "\n" +
			this.getHeartBeatAlert();
		}

		/**Returns a textual representation of the blood pressure,
		 * temperature and heart beat rate values units and corresponding alerts.
		 *
		 * @return a textual representation of the values, their units and their alerts
		 */
		@Override
		public String toString()
		{
			return "HealthMonitor:[Blood pressure: " + bloodPressure[0] + "/" +
					bloodPressure[1] + "" + bloodPressureUnit + " Condition: " + bloodPressureAlert +
					"\nTemperature: " + tempValue + "" + temperatureUnit + " Condition: " + temperatureAlert +
					"\nHeart Beat Rate: " + heartBeatValue + "" + heartBeatUnit + " Condition: " + heartBeatAlert +
					"]";

		}

		/**compares this HealthMonitor object to the specified object.
		 * The result is true if and only if the argument is not null
		 * and is a HealthMonitor object that has the same blood pressure,
		 * temperature and heart beat rate values as the object.
		 *
		 *@param obj the object to compare this HealthMonitor object against
		 *
		 *@return true if the given object represents an HealthMonitor object
		 *equivalent to this HealthMonitor object, and false if otherwise.
		 */
		@Override
		public boolean equals(Object obj)
		{
			// test if obj is a HealthMonitor, and not null
			if((this.getClass() != obj.getClass()) || obj == null)
				return false;

			/* compare blood pressure, temperature and heart beat rate
			values using the == operator as they are primitive types*/
			HealthMonitor other = (HealthMonitor) obj; //cast to a HealthMonitor object.
			Boolean equal=false; //create a boolean equal.
			//the temperature and heart beat are first compared.
			if(this.tempValue == other.tempValue && this.heartBeatValue == other.heartBeatValue){
				
				// a for loop is used to compare each element in the array for equality
					for(int i=0; i < this.bloodPressure.length; i++){
						if(this.bloodPressure[i] == other.bloodPressure[i]){
							equal = true; //if each of the two elements are equal, returns true.
						}
						else{
							equal = false;//if any is false, equal is set back to false
							return equal;//it returns false.
						}
					}
				}
			

			return equal; // the equal status is returned
			//return this.tempValue == other.tempValue &&
					//this.heartBeatValue == other.heartBeatValue &&
					//this.bloodPressure.equals(other.bloodPressure) ;

		}



}
