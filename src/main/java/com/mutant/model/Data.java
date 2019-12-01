package com.mutant.model;

import java.util.List;

public class Data {

	private String title;
	private List<String> group;
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getGroup() {
		return group;
	}

	public void setGroups(List<String> groups) {
		this.group = groups;
	}
	
	public String[] getArregloData() {
		String[] arregloData = new String[this.group.size()];
		return arregloData;
	}
	
	public char[][] getMatrizData() {
		String[] datos = this.getArregloData();
		int n = this.group.size();
		char matriz[][] = new char[n][n];
		int cont = 0;

		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				matriz[x][y] = datos[x].charAt(cont);
				cont++;
			}
			cont = 0;
		}
		return matriz;
	}
}
