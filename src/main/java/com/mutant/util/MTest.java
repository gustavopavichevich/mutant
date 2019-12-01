package com.mutant.util;

import java.util.ArrayList;

public class MTest {

	public static void main(String[] args) {
		char[][] ca=new char[4][4];
		ArrayList<char[]> elements = null;
		
		// Matriz de 4x4 harcoded (se recibir� como par�metro c/u de las matrices de 4x4 que "habitan" la gran matriz
		ca[0][0]='A';
		ca[0][1]='A';
		ca[0][2]='C';
		ca[0][3]='G';
		ca[1][0]='C';
		ca[1][1]='A';
		ca[1][2]='C';
		ca[1][3]='C';
		ca[2][0]='C';
		ca[2][1]='T';
		ca[2][2]='G';
		ca[2][3]='A';
		ca[3][0]='G';
		ca[3][1]='G';
		ca[3][2]='G';
		ca[3][3]='G';

		elements = getElements(ca);
		
		System.out.println("Is Mutant?: ");
		System.out.println(isMutant(elements));
	}
	
	/***
	 * Recupera las 10 lineas (horizontales, verticales y diagonales) de la matriz de 4x4 que debe ser analizada
	 * @param matrix	Matriz de 4x4 a analizar.
	 * @return	ArrayList conteniendo las diez lineas a analizar.
	 */
	private static ArrayList<char[]> getElements(char[][] matrix) {
		
		ArrayList<char[]> result = new ArrayList<char[]>();
		char[] element = new char[4];

		// Recupera Lineas
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[i].length;j++)
			{ 
				element[j] = matrix[i][j];
			}
	
			result.add(element);
			element = new char[4];
		}

		// Recupera Columnas
		for(int j=0;j<4;j++)
		{
			for(int i=0;i<4;i++)
			{ 
				element[i] = matrix[i][j];
			}
	
			result.add(element);
			element = new char[4];
		}
		
		// Recupera Diagonales
		char[] diagA = new char[4];
		char[] diagB = new char[4];
		int x = 0;
		for(int i=0;i<4;i++)
		{
			diagA[i] = matrix[i][x];
			diagB[i] = matrix[i][3-x];
			x++;
		}

		result.add(diagA);
		result.add(diagB);
		
		return result;
	}
	
	/***
	 * Chequea las diez lineas a analizar para determinar si el ADN se corresponde a un mutante
	 * @param elements	Las diez lineas a analizar.
	 * @return	Verdadero si es Mutante, Falso si no lo es.
	 */
	private static boolean isMutant(ArrayList<char[]> elements) {
		int matchCount = 0;
		
		for(char[] element : elements) {
			if(isAllCharsEquals(element))
				matchCount++;
			if(matchCount == 2)
				return true;
		}
		
		return false;
	}

	/***
	 * Chequea si todos los caracteres de un elemento son iguales
	 * @param element Elemento (horizontal, vertical o diagonal) a analizar
	 * @return Verdadero si todos los caracteres son iguales, Falso si no lo son
	 */
	private static boolean isAllCharsEquals(char[] element) {
		char character = element[0];
		for(int i=1; i < element.length; i++) {
			if(character != element[i])
				return false;
		}
		return true;
	}
}
