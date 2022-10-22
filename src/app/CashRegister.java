package app;

import java.util.Scanner;

public class CashRegister {

	public static void main(String[] args) {
		makeChange();
	}

	public static void makeChange() {
		Scanner sc = new Scanner(System.in);
		int twenties = 0;
		int tens = 0;
		int fives = 0;
		int ones = 0;
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		int pennies = 0;

		System.out.println("Please enter the transaction cost: ");
		double total = rounder(sc.nextDouble());

		System.out.println("Please enter the cash amount tendered: ");
		double payment = rounder(sc.nextDouble());
		double change = payment - total;
		String changeGiven = "Amount: " + total + ". Tendered: " + payment + ". Change: ";

		while (change > 0) {
			rounder(change);
			if (change / 20 >= 1) {
				twenties += 1;
				change -= 20;
				change = rounder(change);
			} else if (change / 10 >= 1) {
				tens += 1;
				change -= 10;
				change = rounder(change);
			} else if (change / 5 >= 1) {
				fives += 1;
				change -= 5;
				change = rounder(change);
			} else if (change / 1 >= 1) {
				ones++;
				change -= 1;
				change = rounder(change);
			} else if (change / .25 >= 1) {
				quarters++;
				change -= .25;
				change = rounder(change);
			} else if (change / .10 >= 1) {
				dimes++;
				change -= .10;
				change = rounder(change);
			} else if (change / .05 >= 1) {
				nickels++;
				change -= .05;
				change = rounder(change);
			} else if (change / .01 >= 1) {
				pennies++;
				change -= .01;
				change = rounder(change);
			}
		}

		if (twenties > 1) {
			changeGiven += twenties + " twenty dollar bills";
		} else if (twenties == 1) {
			changeGiven += "1 twenty dollar bill";
		}
		if (tens > 1 && twenties >= 1) { // FINISH ACCOUNTING FOR COMMAS
			changeGiven += ", " + tens + " ten dollar bills";
		} else if (tens > 1) {
			changeGiven += tens + "ten dollar bills";
		} else if (tens == 1 && twenties >= 1) {
			changeGiven += ", 1 ten dollar bill";
		} else if (tens == 1) {
			changeGiven += "1 ten dollar bill";
		}
		if (fives > 1 && (tens >= 1 || twenties >= 1)) {
			changeGiven += ", " + fives + " five dollar bills";
		} else if (fives > 1) {
			changeGiven += fives + " five dollar bills";
		} else if (fives == 1 && (tens >= 1 || twenties >= 1)) {
			changeGiven += ", 1 five dollar bill";
		} else if (fives == 1) {
			changeGiven += "1 five dollar bill";
		}
		if (ones > 1 && (twenties >= 1 || tens >= 1 || fives >= 1)) {
			changeGiven += ", " + ones + " one dollar bills";
		} else if (ones > 1) {
			changeGiven += ones + " one dollar bills";
		} else if (ones == 1 && (twenties >= 1 || tens >= 1 || fives >= 1)) {
			changeGiven += ", 1 one dollar bill";
		} else if (ones == 1) {
			changeGiven += "1 one dollar bills";
		}
		if (quarters > 1 && (twenties >= 1 || tens >= 1 || fives >= 1 || ones >= 1)) {
			changeGiven += ", " + quarters + " quarters";
		} else if (quarters > 1) {
			changeGiven += quarters + " quarters";
		} else if (quarters == 1 && (twenties >= 1 || tens >= 1 || fives >= 1 || ones >= 1)) {
			changeGiven += ", 1 quarter";
		} else if (quarters == 1) {
			changeGiven += "1 quarter";
		}
		if (dimes > 1 && (twenties >= 1 || tens >= 1 || fives >= 1 || ones >= 1 || quarters >= 1)) {
			changeGiven += ", " + dimes + " dimes";
		} else if (dimes > 1) {
			changeGiven += dimes + " dimes";
		} else if (dimes == 1 && (twenties >= 1 || tens >= 1 || fives >= 1 || ones >= 1 || quarters >= 1)) {
			changeGiven += ", 1 dime";
		} else if (dimes == 1) {
			changeGiven += "1 dime";
		}
		if (nickels > 1 && (twenties >= 1 || tens >= 1 || fives >= 1 || ones >= 1 || quarters >= 1 || dimes >= 1)) {
			changeGiven += ", " + nickels + " nickels";
		} else if (nickels > 1) {
			changeGiven += nickels + " nickels";
		} else if (nickels == 1
				&& (twenties >= 1 || tens >= 1 || fives >= 1 || ones >= 1 || quarters >= 1 || dimes >= 1)) {
			changeGiven += ", 1 nickel";
		} else if (nickels == 1) {
			changeGiven += "1 nickel";
		}
		if (pennies > 1 && (twenties >= 1 || tens >= 1 || fives >= 1 || ones >= 1 || quarters >= 1 || dimes >= 1
				|| nickels >= 1)) {
			changeGiven += ", " + pennies + " pennies.";
		} else if (pennies > 1) {
			changeGiven += pennies + " pennies.";
		} else if (pennies == 1 && (twenties >= 1 || tens >= 1 || fives >= 1 || ones >= 1 || quarters >= 1 || dimes >= 1
				|| nickels >= 1)) {
			changeGiven += ", 1 penny.";
		} else if (pennies == 1) {
			changeGiven += "1 penny.";
		}

		if (total > payment) {
			System.out.println("Insufficient Payment.");
		} else if (payment == total) {
			System.out.println("Exact Change Given. Transaction complete.");
		} else if (total < payment) {
			System.out.println(changeGiven);
		}
		sc.close();
	}

	public static double rounder(double x) { // Rounds double to two decimals
		x = Math.round(x * 100.0) / 100.0;
		return x;
	}
}
