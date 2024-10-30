package models;

/**
 * interface for any moving object, includes layout for necessary
 * functions that characters have
 * 
 * @author williamcheng
 */
public interface Model {
	int xPos = 0;
	int yPos = 0;
	String name = "";
	
	
	void moveRight();
	void moveLeft();
	void jump();
	int xPos();
	int yPos();
	void setName(String name);
	String getName();
}