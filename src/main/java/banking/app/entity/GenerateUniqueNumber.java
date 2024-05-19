package banking.app.entity;

import java.util.Random;
import java.util.UUID;

public class GenerateUniqueNumber {
	public String generateAccountNumber() {
		long timestamp = System.currentTimeMillis();

		// Generate a random number between 1000000000 and 9999999999
		Random random = new Random();
		int randomNumber = random.nextInt(900000000) + 1000000000;

		String uniqueNumber = String.valueOf(timestamp) + String.valueOf(randomNumber);
		uniqueNumber = uniqueNumber.substring(0, 10);

		return uniqueNumber;
	}

	public String generateTransitionID() {
		long timestamp = System.currentTimeMillis();

		// Generate a random number between 1000000000 and 9999999999
		Random random = new Random();
		int randomNumber = random.nextInt(900000000) + 1000000;

		String uniqueNumber = String.valueOf(timestamp) + String.valueOf(randomNumber);
		uniqueNumber = uniqueNumber.substring(0, 10);

		return uniqueNumber;
	}

	public String generateCardNumber() {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		// Ensure the number is 16 digits
		for (int i = 0; i < 16; i++) {
			sb.append(random.nextInt(10)); // Generates random digit between 0 and 9
		}
		return sb.toString();
	}

	public int generateCvvNumber() {
		Random random = new Random();
		int uniqueNumber = 100 + random.nextInt(900);
		return uniqueNumber;

	}

}
