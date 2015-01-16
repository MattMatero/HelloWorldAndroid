package com.example.helloworld;

public class WorldGen {
	String planetName;
	int planetMass;
	double planetGravity;
	int planetColonies;
	long planetPopulation;
	int planetBases;
	int planetMilitary;
	boolean planetProtected;
	
	public WorldGen(String name, int mass, double gravity){
		planetName = name;
		planetMass = mass;
		planetGravity = gravity;
		planetColonies = 0;
		planetPopulation = 0;
		planetBases = 0;
		planetMilitary = 0;
		planetProtected = false;
	}
	
	
	
	//Following add methods will add to current object attributes
	public void addBases(int bases){
		planetBases += bases;
	}
	public void addPopulation(int pop){
		planetPopulation += pop;
	}
	
	public void addColonies(int colonies){
		planetColonies += colonies;
	}
	
	public void addMilitary(int military){
		planetMilitary += military;
	}
	
	
	//following methods will get or set object attributes
	public String getPlanetName() {
		return planetName;
	}
	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}
	public int getPlanetMass() {
		return planetMass;
	}
	public void setPlanetMass(int planetMass) {
		this.planetMass = planetMass;
	}
	public double getPlanetGravity() {
		return planetGravity;
	}
	public void setPlanetGravity(double planetGravity) {
		this.planetGravity = planetGravity;
	}
	public int getPlanetColonies() {
		return planetColonies;
	}
	public void setPlanetColonies(int planetColonies) {
		this.planetColonies = planetColonies;
	}
	public long getPlanetPopulation() {
		return planetPopulation;
	}
	public void setPlanetPopulation(long planetPopulation) {
		this.planetPopulation = planetPopulation;
	}
	public int getPlanetBases() {
		return planetBases;
	}
	public void setPlanetBases(int planetBases) {
		this.planetBases = planetBases;
	}
	public int getPlanetMilitary() {
		return planetMilitary;
	}
	public void setPlanetMilitary(int planetMilitary) {
		this.planetMilitary = planetMilitary;
	}
	public boolean isPlanetProtected() {
		return planetProtected;
	}
	public void setPlanetProtected(boolean planetProtected) {
		this.planetProtected = planetProtected;
	}
	
	public void toggleFF(){
		if(planetProtected == false){
			planetProtected = true;
		}else{
			planetProtected = false;
		}
	}
}
