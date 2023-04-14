package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	
	public static BigInteger hashOf(String entity) {	
		
		BigInteger hashint = null;
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		// we use MD5 with 128 bits digest
		
		// compute the hash of the input 'entity'
		
		// convert the hash into hex format
		
		// convert the hex into BigInteger
		
		// return the BigInteger
		
		try {
			
			/*
			 * Vi oppretter en instans av MessageDigest-objektet med MD5-algoritmen.
			 * Vi bruker MessageDigest.getInstance("MD5") for å hente ut MD5-algoritmen.
			 */
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			/*
			 * Vi bruker digest-metoden på MessageDigest-objektet til å hash'e inputstrengen
			 * (entity). Detter gir oss et array av bytes (byte[]).
			 */
			
			byte[] messageDigest = md.digest(entity.getBytes("UTF-8"));
			
			/*
			 * Vi bruker String-format("%032x", new BidInteger(1, hash)) til å konvertere bytene til
			 * en hex string med 32 tegn (fordi MD5 gir oss en 128-biters hash, som er 32 tegn i hex-
			 * format). Dette resulterer i en streng som representerer hash'en som en sekvens av 
			 * heksadesimale tall.
			 */
			
			String hex = String.format("%032x", new BigInteger(1, messageDigest));
			
			/*
			 * Vi bruker BigInteger-konstruktøren til å kovertere hex-strengen til en BigInteger-verdi.
			 */
			
			hashint = new BigInteger(hex, 16);
			
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		/*
		 *  Til slutt returnerer vi BigInteger-verdien.
		 */
		
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		
		// compute the number of bits = bitSize()
		
		// compute the address size = 2 ^ number of bits
		
		// return the address size
		
		/*
		 * Først oppretter vi en 'int' variabel 'numBits' som representerer antall biter i MD5-
		   hashverdien. MD5-algoritmen produserer alltid en 128-bit hashverdi, så vi setter
		   'numBits' til 128.
		 */
		
		int numBits = bitSize();
		
		/*
		 * Deretter beregener koden størrelsen på adressen ved å bruke 'BigInteger'-klassen.
		 * Vi bruker 'BigInteger.valueOf(2)' for å opprette tallet 2 som et 'BigInteger'-
		 * objekt, og vi bruker 'pow(numBits)'-metoden for å heve tallet 2 til potensen
		 * 'numBits'. Dette gir oss 2^128, som er størrelsen på adressen for MD5-algoritmen.
		 */
		
		BigInteger addressSize = BigInteger.valueOf(2).pow(numBits);
		
		/*
		 * Til slutt returnerer vi adressens størrelse som et 'BigInteger'-objekt.
		 */
		
		return addressSize;
	}
	
	public static int bitSize() {
		
		/*
		 * Endret digestlen fra 0 til 16.
		 */
		
		int digestlen = 16;
		
		// find the digest length
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
