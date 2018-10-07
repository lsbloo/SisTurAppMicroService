package com.apps4society.utilidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="haversine_dist")
public class Haversine {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	
	@NotNull
	@Column(name="latitude_pont_1")
	private double latitude_ponto1;
	
	@NotNull
	@Column(name="latitude_ponto2")
	private double latitude_ponto2;
	
	@NotNull
	@Column(name="longitude_ponto1")
	private double longitude_ponto1;
	
	@NotNull
	@Column(name="longitude_ponto2")
	private double longitude_ponto2;
	
	public double getLatitude_ponto1() {
		return latitude_ponto1;
	}
	public void setLatitude_ponto1(double latitude_ponto1) {
		this.latitude_ponto1 = latitude_ponto1;
	}
	public double getLongitude_ponto2() {
		return longitude_ponto2;
	}
	public void setLongitude_ponto2(double longitude_ponto2) {
		this.longitude_ponto2 = longitude_ponto2;
	}
	public double getLongitude_ponto1() {
		return longitude_ponto1;
	}
	public void setLongitude_ponto1(double longitude_ponto1) {
		this.longitude_ponto1 = longitude_ponto1;
	}
	public double getLatitude_ponto2() {
		return latitude_ponto2;
	}
	public void setLatitude_ponto2(double latitude_ponto2) {
		this.latitude_ponto2 = latitude_ponto2;
	}
	
	public Haversine() {
		
	}
	
	public Haversine(Double latitude_pont1 , Double latitude_pont2 ,Double longitude_pont1,Double longitude_pont2) {
		/*
		 * Default Construtor
		 */
		this.latitude_ponto1=latitude_pont1;
		this.latitude_ponto2=latitude_pont2;
		this.longitude_ponto1=longitude_pont1;
		this.longitude_ponto2=longitude_pont2;
		
	}
	
	
	public double distancia(Double lat1, Double lat2,Double long1, Double long2,Double el1,Double el2) {
		/* Calcula a distancia entre um ponto (latitude,longitude) a outro (latitude,longitude);
		 * E1, E2. pode passar como 0 e 0
		 */
		final int R = 6371;

	    Double latDistance = deg2rad(lat2 - lat1);
	    Double lonDistance = deg2rad(long1 - long2);
	    Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    double height = el1 - el2;
	    distance = Math.pow(distance, 2) + Math.pow(height, 2);
	    return Math.sqrt(distance);
	}
	
	private double deg2rad(double deg) {
	    return (deg * Math.PI / 180.0);
	}

}
