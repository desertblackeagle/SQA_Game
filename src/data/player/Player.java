package data.player;

import javax.swing.ImageIcon;

public class Player {
	private String name = "";
	private ImageIcon photo;
	private int color, score;
	private int win, lost;
	
	public Player(String name, ImageIcon photo, int color, int score) {
		this.name = name;
		this.photo = photo;
		this.color = color;
		this.score = score;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhoto(ImageIcon photo) {
		this.photo = photo;
	}
	
	public void setColor(int color) {
		this.color = color;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public ImageIcon getPhoto() {
		return photo;
	}
	
	public int getColor() {
		return color;
	}
	
	public int getScore() {
		return score;
	}
}
