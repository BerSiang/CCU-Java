package com.vincent;

/**
 * EasterTester
 *
 * @author Vincent Huang
 *
 */

/**
 * 本程式用於展示Easter類別的calculateEaster方法
 *
 *@see Easter
 *
 */
public class EasterTester {
	public static void main(String[] args) {
		String easterStr1 = Easter.calculateEaster(2001);
		String easterStr2 = Easter.calculateEaster(2012);
		String easterStr3 = Easter.calculateEaster(10);
		String easterStr4 = Easter.calculateEaster(211);

		System.out.println(easterStr1 + "\n");
		System.out.println(easterStr2 + "\n");
		System.out.println(easterStr3 + "\n");
		System.out.println(easterStr4);
	}
}