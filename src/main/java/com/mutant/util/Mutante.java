package com.mutant.util;

public class Mutante {

// declaracion de variables estaticas
	private static String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
	private static int n = dna.length;

// inicio de operaciones
	public static void main(String[] args) {
		if (isMutant(armaMatriz(dna)))
			mostrarMatriz(armaMatriz(dna), n);
	}

// armado de matriz a partir de una secuencia de datos strings
	public static char[][] armaMatriz(String[] secuencia) {
		char matriz[][] = new char[n][n];
		int cont = 0;

		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				matriz[x][y] = secuencia[x].charAt(cont);
				cont++;
			}
			cont = 0;
		}
		return matriz;
	}

// metodo para mostrar la matriz por consola
	public static void mostrarMatriz(char[][] matriz, int n) {
		System.out.println("Matriz:");
		String str = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				str += matriz[i][j] + "\t";
			}
			System.out.println(str);
			str = "";
		}
	}

// estudiar matriz
	public static boolean isMutant(char[][] matNxN) {
		char matriz[][] = new char[10][4];
		int mutante = 0;
		int contador = 0;
		for (int i = 0; i < n - 3; i++) {
			for (int j = 0; j < n - 3; j++) {
				matriz[0][0] = matNxN[i][j];
				matriz[0][1] = matNxN[i][j + 1];
				matriz[0][2] = matNxN[i][j + 2];
				matriz[0][3] = matNxN[i][j + 3];

				matriz[1][0] = matNxN[i + 1][j];
				matriz[1][1] = matNxN[i + 1][j + 1];
				matriz[1][2] = matNxN[i + 1][j + 2];
				matriz[1][3] = matNxN[i + 1][j + 3];

				matriz[2][0] = matNxN[i + 2][j];
				matriz[2][1] = matNxN[i + 2][j + 1];
				matriz[2][2] = matNxN[i + 2][j + 2];
				matriz[2][3] = matNxN[i + 2][j + 3];

				matriz[3][0] = matNxN[i + 3][j];
				matriz[3][1] = matNxN[i + 3][j + 1];
				matriz[3][2] = matNxN[i + 3][j + 2];
				matriz[3][3] = matNxN[i + 3][j + 3];

				matriz[4][0] = matNxN[i][j];
				matriz[4][1] = matNxN[i + 1][j];
				matriz[4][2] = matNxN[i + 2][j];
				matriz[4][3] = matNxN[i + 3][j];

				matriz[5][0] = matNxN[i][j + 1];
				matriz[5][1] = matNxN[i + 1][j + 1];
				matriz[5][2] = matNxN[i + 2][j + 1];
				matriz[5][3] = matNxN[i + 3][j + 1];

				matriz[6][0] = matNxN[i][j + 2];
				matriz[6][1] = matNxN[i + 1][j + 2];
				matriz[6][2] = matNxN[i + 2][j + 2];
				matriz[6][3] = matNxN[i + 3][j + 2];

				matriz[7][0] = matNxN[i][j];
				matriz[7][1] = matNxN[i + 1][j + 3];
				matriz[7][2] = matNxN[i + 2][j + 3];
				matriz[7][3] = matNxN[i + 3][j + 3];

				matriz[8][0] = matNxN[i][j];
				matriz[8][1] = matNxN[i + 1][j + 1];
				matriz[8][2] = matNxN[i + 2][j + 2];
				matriz[8][3] = matNxN[i + 3][j + 3];

				matriz[9][0] = matNxN[i][j + 3];
				matriz[9][1] = matNxN[i + 1][j + 2];
				matriz[9][2] = matNxN[i + 2][j + 1];
				matriz[9][3] = matNxN[i + 3][j];
				contador = analizar10x4(matriz);
				if (contador != 0) {
					mutante += contador;
				}
			}
		}
		if (mutante > 1) {
			System.out.println("valor de mutante: " + mutante);
			return true;
		}

		return false;
	}

//analisis de la matriz resultante
	public static int analizar10x4(char[][] matNxN) {
		int contador = 0;
//		 barrido horizontal
		for (int i = 0; i < 10; i++) {
			int j = 0;
			if ((matNxN[i][j] == matNxN[i][j + 1]) && (matNxN[i][j] == matNxN[i][j + 2])
					&& (matNxN[i][j] == matNxN[i][j + 3])) {
				contador++;
				System.out.println(String.valueOf(matNxN[i][j]) + String.valueOf(matNxN[i][j + 1])
						+ String.valueOf(matNxN[i][j + 2]) + String.valueOf(matNxN[i][j + 3]));
			}
		}
		return contador;
	}
}