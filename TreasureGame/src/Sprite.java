

import java.awt.Image;

/**
 * Parent class for sprites.
 * 
 * Adapted from zetcode.com
 * 
 * @author Rodney Earl
 * @version 1.0
 */
public class Sprite implements Commons{

	/**
	 * Contains the x coordinates of the sprite.
	 */
	public int x;
	/**
	 * Contains the y coordinates of the sprite.
	 */
	public int y;
	/**
	 * Contains the image of the sprite.
	 */
	protected Image image;
	
	/**
	 * Constructor for a sprite.
	 * @param xPos Initialized x coordinate for a sprite.
	 * @param yPos Initialized y coordinate for a sprite.
	 * @param image Initialized image for a sprite.
	 */
	public Sprite(int xPos, int yPos){
		
		x = xPos;
		y = yPos;
	}
	
	/**
	 * Accessor for x coordinate.
	 * @return X coordinate for the sprite.
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * Accessor for y coordinate.
	 * @return Y coordinate for the sprite.
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * Accessor for the image.
	 * @return Image for the sprite.
	 */
	public Image getImage(){
		return image;
	}
	
	/**
	 * Mutator for the x coordinate.
	 * @param xPos New x coordinate for the sprite.
	 */
	public void setX(int xPos){
		x = xPos;
	}

	/**
	 * Mutator for the y coordinate.
	 * @param yPos New y coordinate for the sprite.
	 */
	public void setY(int yPos){
		y = yPos;
	}

	/**
	 * Mutator for the image.
	 * @param image New image for the sprite.
	 */
	public void setImage(Image image){
		this.image = image;
	}

	/**
	 * Method to check if object is above the current sprite.
	 * @param object The object that might be directly above the sprite.
	 * @return True if object is above the sprite, false otherwise.
	 */
	public boolean isTopCollision(Sprite object){
		
		if((this.getY() - SPRITE_WIDTH) == object.getY() &&
				this.getX() == object.getX())
			return true;
		else
			return false;
	}
	
	/**
	 * Method to check if object is to the right of the current sprite.
	 * @param object The object that might be directly to the right of the sprite.
	 * @return True if object is to the right of the sprite, false otherwise.
	 */
	public boolean isRightCollision(Sprite object){
		
		if((this.getX() + SPRITE_WIDTH) == object.getX() &&
				this.getY() == object.getY())
			return true;
		else
			return false;
	}
	
	/**
	 * Method to check if object is below the current sprite.
	 * @param object The object that might be directly below the sprite.
	 * @return True if object is below the sprite, false otherwise.
	 */
	public boolean isBottomCollision(Sprite object){
		
		if((this.getY() + SPRITE_WIDTH) == object.getY() &&
				this.getX() == object.getX())
			return true;
		else
			return false;
	}
	
	/**
	 * Method to check if object is to the left of the current sprite.
	 * @param object The object that might be directly to the left of the sprite.
	 * @return True if object is to the left of the sprite, false otherwise.
	 */
	public boolean isLeftCollision(Sprite object){
		
		if((this.getX() - SPRITE_WIDTH) == object.getX() &&
				this.getY() == object.getY())
			return true;
		else
			return false;
	}
}
