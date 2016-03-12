package animation;

import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 * SpriteSheet is a helper class for dealing with spriteSheets. 
 * It loads the image and then can return a sprite at a given row/column
 * @author abraham
 *
 */
public class SpriteSheet implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3078234559033712828L;

	private BufferedImage image;
	
	private int rows,cols,rowHeight,colWidth;
	
	
	private BufferedImage[][] sprites;
	
	/**
	 * Initialized the sprite sheet
	 * @param image the entire sprite sheet to get sprite from
	 * @param rows the number of rows the the sprite sheet
	 * @param cols the number of columns in the sprite sheet
	 * @param rowHeight raw row height
	 * @param colWidth raw row width
	 */
	public SpriteSheet(BufferedImage image,int rows,int cols,int rowHeight,int colWidth){
		this.image=image;
		this.rows =rows;
		this.cols = cols;
		this.rowHeight = rowHeight;
		this.colWidth=colWidth;
		
		sprites = new BufferedImage[rows][cols];
		loadSprites();
		
	}
	
	/**
	 * returns a sprite at the given row,column
	 * @param row the row (starts at 1, not 0!)
	 * @param col the column (starts at 1, not 0!)
	 * @return the sprite you wanted
	 */
	public BufferedImage getSprite(int row,int col){
		return sprites[row-1][col-1];
	}
	
	/**
	 * loads the individuals sprites into the sprites BufferedImage[][]
	 */
	private void loadSprites(){
		int rows2=0;
		int cols2;
		while(rows2<rows){
			cols2=0;
			while(cols2<cols){
				sprites[rows2][cols2] = getSubImage(rows2+1, cols2+1);
				cols2++;
			}
			
			rows2++;
		}
		
		
	}
	
	/**
	 * used in loadSprites() to get subImages
	 * @param row the row 
	 * @param col the column
	 * @return the buffered Image in question
	 */
	private BufferedImage getSubImage(int row, int col){
		
		BufferedImage img = image.getSubimage((col-1) *(colWidth) , ((row-1) * rowHeight), colWidth, rowHeight);
		return img; 
	}
	
	/**
	 * used to load sprites with a crop in case of raster format exceptions
	 * @param row the row	
	 * @param col the columns
	 * @param xCrop xCrop
	 * @param yCrop yCrop
	 * @return
	 */
	@SuppressWarnings("unused")
	private BufferedImage getSubImage(int row, int col,int xCrop, int yCrop){
	
		BufferedImage img = image.getSubimage((col-1) *(colWidth) , ((row-1) * rowHeight), colWidth-xCrop, rowHeight-yCrop);
		return img; 
}

}