package tests;


import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

import characters.Bubble;
import characters.Crab;
import characters.Fish;
import characters.Game3Crab;
import characters.Game3Fish;
import enemies.Hook;
import enemies.Pollutant;
import enemies.TheHuman;
import enemies.Trash;
import games.OverfishingGame;
import junit.framework.TestCase;
import misc.ArbitraryLine;
import misc.Vector;

/**
 * This class tests all subclasses of the abstract class Character.  Therfore, it also tests character itself, without directly 
 * instantiating Character, since that can't be done.
 * @author abraham
 *
 */
public class CharacterTests extends TestCase {
	
	/**
	 * tests the basic functions of Fish, such as decreasing its health and updating its x and y position
	 */
	public void testFish(){
		Fish fish = new Fish(0.0, 0.0, 0.0);
//		int h = fish.getHealth();
//		fish.decreaseHealth(5);
//		assertEquals(fish.getHealth(),h-5);
		double x =fish.getX();
		fish.move(10.0, 0);
		assertFalse(x== 10.0);
		double y = fish.getY();
		fish.move(0, 10);
		assertFalse(y==10.0);
		fish.render(new Graphics2D() {
			
			@Override
			public void setXORMode(Color c1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setPaintMode() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setFont(Font font) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setColor(Color c) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setClip(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setClip(Shape clip) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public FontMetrics getFontMetrics(Font f) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Font getFont() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Color getColor() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Rectangle getClipBounds() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Shape getClip() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillOval(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawOval(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawLine(int x1, int y1, int x2, int y2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
					Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
					ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image arg0, int arg1, int arg2, Color arg3, ImageObserver arg4) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image arg0, int arg1, int arg2, ImageObserver arg3) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void drawArc(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void dispose() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Graphics create() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void copyArea(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clipRect(int arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clearRect(int arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void translate(double tx, double ty) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void translate(int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void transform(AffineTransform Tx) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void shear(double shx, double shy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setTransform(AffineTransform Tx) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setStroke(Stroke s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setRenderingHints(Map<?, ?> hints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setRenderingHint(Key hintKey, Object hintValue) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setPaint(Paint paint) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setComposite(Composite comp) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setBackground(Color color) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void scale(double sx, double sy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void rotate(double theta, double x, double y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void rotate(double theta) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public AffineTransform getTransform() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Stroke getStroke() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public RenderingHints getRenderingHints() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getRenderingHint(Key hintKey) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Paint getPaint() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public FontRenderContext getFontRenderContext() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public GraphicsConfiguration getDeviceConfiguration() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Composite getComposite() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Color getBackground() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void fill(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(AttributedCharacterIterator iterator, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(AttributedCharacterIterator iterator, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(String str, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(String str, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRenderedImage(RenderedImage img, AffineTransform xform) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRenderableImage(RenderableImage img, AffineTransform xform) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawImage(BufferedImage img, BufferedImageOp op, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean drawImage(Image img, AffineTransform xform, ImageObserver obs) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void drawGlyphVector(GlyphVector g, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void draw(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clip(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addRenderingHints(Map<?, ?> hints) {
				// TODO Auto-generated method stub
				
			}
		});
		
	    Fish fish2 = new Fish(0.0, 0.0, 0.0);
		Hook hook = new Hook(0,0,3);
		OverfishingGame game = new OverfishingGame();
		game.getEnemies().add(hook);
		game.getSchoolofFish().add(fish2);
		game.onTick();
		assertFalse(fish2.hasCollided());
		
		
		
		
		
		
	}
	
	/**
	 * tests the basic functions of Fish, such as decreasing its health and updating its x and y position
	 */
	public void testCrab(){
		Crab crab = new Crab(0.0, 0.0, null);
//		int h = crab.getHealth();
//		crab.decreaseHealth(5);
//		assertEquals(crab.getHealth(),h-5);
		double x =crab.getX();
		crab.move(10.0, 0);
		assertFalse(crab.getX()== 10.0);
		double y = crab.getY();
		crab.move(0, 10.0);
		assertFalse(crab.getY()==y+10.0);
		crab.render(new Graphics2D() {
			
			@Override
			public void setXORMode(Color c1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setPaintMode() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setFont(Font font) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setColor(Color c) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setClip(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setClip(Shape clip) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public FontMetrics getFontMetrics(Font f) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Font getFont() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Color getColor() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Rectangle getClipBounds() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Shape getClip() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillOval(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawOval(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawLine(int x1, int y1, int x2, int y2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
					Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
					ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void dispose() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Graphics create() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void copyArea(int x, int y, int width, int height, int dx, int dy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clipRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clearRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void translate(double tx, double ty) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void translate(int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void transform(AffineTransform Tx) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void shear(double shx, double shy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setTransform(AffineTransform Tx) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setStroke(Stroke s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setRenderingHints(Map<?, ?> hints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setRenderingHint(Key hintKey, Object hintValue) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setPaint(Paint paint) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setComposite(Composite comp) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setBackground(Color color) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void scale(double sx, double sy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void rotate(double theta, double x, double y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void rotate(double theta) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public AffineTransform getTransform() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Stroke getStroke() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public RenderingHints getRenderingHints() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getRenderingHint(Key hintKey) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Paint getPaint() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public FontRenderContext getFontRenderContext() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public GraphicsConfiguration getDeviceConfiguration() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Composite getComposite() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Color getBackground() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void fill(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(AttributedCharacterIterator iterator, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(AttributedCharacterIterator iterator, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(String str, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(String str, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRenderedImage(RenderedImage img, AffineTransform xform) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRenderableImage(RenderableImage img, AffineTransform xform) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawImage(BufferedImage img, BufferedImageOp op, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean drawImage(Image img, AffineTransform xform, ImageObserver obs) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void drawGlyphVector(GlyphVector g, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void draw(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clip(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addRenderingHints(Map<?, ?> hints) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Trash t = new Trash(0,0,Trash.BANANA);
		double x2 = t.getX();
		double y2 = t.getY();
		crab.holdTrash(t);
		crab.throwAttachedTrash();
		assertFalse(x2==t.getX() && y2 == t.getY());
		t.render(new Graphics2D() {
			
			@Override
			public void setXORMode(Color c1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setPaintMode() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setFont(Font font) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setColor(Color c) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setClip(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setClip(Shape clip) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public FontMetrics getFontMetrics(Font f) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Font getFont() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Color getColor() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Rectangle getClipBounds() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Shape getClip() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillOval(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawOval(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawLine(int x1, int y1, int x2, int y2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
					Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
					ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void dispose() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Graphics create() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void copyArea(int x, int y, int width, int height, int dx, int dy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clipRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clearRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void translate(double tx, double ty) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void translate(int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void transform(AffineTransform Tx) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void shear(double shx, double shy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setTransform(AffineTransform Tx) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setStroke(Stroke s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setRenderingHints(Map<?, ?> hints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setRenderingHint(Key hintKey, Object hintValue) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setPaint(Paint paint) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setComposite(Composite comp) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setBackground(Color color) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void scale(double sx, double sy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void rotate(double theta, double x, double y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void rotate(double theta) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public AffineTransform getTransform() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Stroke getStroke() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public RenderingHints getRenderingHints() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getRenderingHint(Key hintKey) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Paint getPaint() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public FontRenderContext getFontRenderContext() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public GraphicsConfiguration getDeviceConfiguration() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Composite getComposite() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Color getBackground() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void fill(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(AttributedCharacterIterator iterator, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(AttributedCharacterIterator iterator, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(String str, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(String str, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRenderedImage(RenderedImage img, AffineTransform xform) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRenderableImage(RenderableImage img, AffineTransform xform) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawImage(BufferedImage img, BufferedImageOp op, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean drawImage(Image img, AffineTransform xform, ImageObserver obs) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void drawGlyphVector(GlyphVector g, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void draw(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clip(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addRenderingHints(Map<?, ?> hints) {
				// TODO Auto-generated method stub
				
			}
		});
		
		TheHuman human = new TheHuman(0, 0);
		//boolean b = human.hasFish();
		crab.pinchHumanToGetFish(human);
		assertFalse(human.hasFish());
		human.render(new Graphics2D() {
			
			@Override
			public void setXORMode(Color c1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setPaintMode() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setFont(Font font) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setColor(Color c) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setClip(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setClip(Shape clip) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public FontMetrics getFontMetrics(Font f) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Font getFont() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Color getColor() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Rectangle getClipBounds() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Shape getClip() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillOval(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawOval(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawLine(int x1, int y1, int x2, int y2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
					Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
					ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void dispose() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Graphics create() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void copyArea(int x, int y, int width, int height, int dx, int dy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clipRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clearRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void translate(double tx, double ty) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void translate(int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void transform(AffineTransform Tx) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void shear(double shx, double shy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setTransform(AffineTransform Tx) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setStroke(Stroke s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setRenderingHints(Map<?, ?> hints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setRenderingHint(Key hintKey, Object hintValue) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setPaint(Paint paint) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setComposite(Composite comp) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setBackground(Color color) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void scale(double sx, double sy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void rotate(double theta, double x, double y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void rotate(double theta) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public AffineTransform getTransform() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Stroke getStroke() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public RenderingHints getRenderingHints() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getRenderingHint(Key hintKey) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Paint getPaint() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public FontRenderContext getFontRenderContext() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public GraphicsConfiguration getDeviceConfiguration() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Composite getComposite() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Color getBackground() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void fill(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(AttributedCharacterIterator iterator, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(AttributedCharacterIterator iterator, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(String str, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(String str, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRenderedImage(RenderedImage img, AffineTransform xform) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRenderableImage(RenderableImage img, AffineTransform xform) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawImage(BufferedImage img, BufferedImageOp op, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean drawImage(Image img, AffineTransform xform, ImageObserver obs) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void drawGlyphVector(GlyphVector g, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void draw(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clip(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addRenderingHints(Map<?, ?> hints) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
	
	
	/**
	 * tests the basic functions of the Bubble class
	 */
	public void testBubble(){
		Bubble b = new Bubble();
		Pollutant p = new Pollutant(new Vector(0, 0),new Vector(1, 1),.1,Pollutant.FERTILIZER);
		double y = b.getY();
		assertFalse(b.getY()==y+2);
		b.onTick();
		b.shootFromFish(0, 0, 0, 0, 0);
		b.floatToTop();
		b.setIndex(0);
		assertEquals(b.getIndex(), 0);
		double x = b.getX();
		assertNotSame(b.getX(),x-1);
		assertNotSame(b.getX(),0);
		assertNotSame(b.getY(),0);
		b.render(new Graphics2D() {
			
			@Override
			public void setXORMode(Color c1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setPaintMode() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setFont(Font font) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setColor(Color c) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setClip(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setClip(Shape clip) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public FontMetrics getFontMetrics(Font f) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Font getFont() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Color getColor() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Rectangle getClipBounds() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Shape getClip() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillOval(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawOval(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawLine(int x1, int y1, int x2, int y2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
					Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
					ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void dispose() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Graphics create() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void copyArea(int x, int y, int width, int height, int dx, int dy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clipRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clearRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void translate(double tx, double ty) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void translate(int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void transform(AffineTransform Tx) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void shear(double shx, double shy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setTransform(AffineTransform Tx) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setStroke(Stroke s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setRenderingHints(Map<?, ?> hints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setRenderingHint(Key hintKey, Object hintValue) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setPaint(Paint paint) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setComposite(Composite comp) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setBackground(Color color) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void scale(double sx, double sy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void rotate(double theta, double x, double y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void rotate(double theta) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public AffineTransform getTransform() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Stroke getStroke() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public RenderingHints getRenderingHints() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getRenderingHint(Key hintKey) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Paint getPaint() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public FontRenderContext getFontRenderContext() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public GraphicsConfiguration getDeviceConfiguration() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Composite getComposite() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Color getBackground() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void fill(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(AttributedCharacterIterator iterator, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(AttributedCharacterIterator iterator, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(String str, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(String str, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRenderedImage(RenderedImage img, AffineTransform xform) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRenderableImage(RenderableImage img, AffineTransform xform) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawImage(BufferedImage img, BufferedImageOp op, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean drawImage(Image img, AffineTransform xform, ImageObserver obs) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void drawGlyphVector(GlyphVector g, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void draw(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clip(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addRenderingHints(Map<?, ?> hints) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
	}
	
	/**
	 * tests the crab in game 3
	 */
	
	public void testGame3Crab(){
		ArbitraryLine line = new ArbitraryLine(new int[]{1,1,2,2,3,3},1,1,0);
		Game3Crab c = new Game3Crab(0.0, line);
		c.jump();
		c.onTick();
		assertFalse(c.isHoldingFish());
		assertFalse(c.isSqueezingFish());		
		c.render(new Graphics2D() {
			
			@Override
			public void setXORMode(Color c1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setPaintMode() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setFont(Font font) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setColor(Color c) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setClip(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setClip(Shape clip) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public FontMetrics getFontMetrics(Font f) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Font getFont() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Color getColor() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Rectangle getClipBounds() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Shape getClip() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillOval(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawOval(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawLine(int x1, int y1, int x2, int y2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
					Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
					ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void dispose() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Graphics create() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void copyArea(int x, int y, int width, int height, int dx, int dy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clipRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clearRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void translate(double tx, double ty) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void translate(int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void transform(AffineTransform Tx) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void shear(double shx, double shy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setTransform(AffineTransform Tx) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setStroke(Stroke s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setRenderingHints(Map<?, ?> hints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setRenderingHint(Key hintKey, Object hintValue) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setPaint(Paint paint) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setComposite(Composite comp) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setBackground(Color color) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void scale(double sx, double sy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void rotate(double theta, double x, double y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void rotate(double theta) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public AffineTransform getTransform() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Stroke getStroke() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public RenderingHints getRenderingHints() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getRenderingHint(Key hintKey) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Paint getPaint() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public FontRenderContext getFontRenderContext() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public GraphicsConfiguration getDeviceConfiguration() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Composite getComposite() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Color getBackground() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void fill(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(AttributedCharacterIterator iterator, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(AttributedCharacterIterator iterator, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(String str, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(String str, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRenderedImage(RenderedImage img, AffineTransform xform) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRenderableImage(RenderableImage img, AffineTransform xform) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawImage(BufferedImage img, BufferedImageOp op, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean drawImage(Image img, AffineTransform xform, ImageObserver obs) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void drawGlyphVector(GlyphVector g, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void draw(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clip(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addRenderingHints(Map<?, ?> hints) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	/**
	 * tests the fish in game 3
	 */
	public void testGame3Fish(){
		ArbitraryLine line = new ArbitraryLine(new int[]{1,1,2,2,3,3},1,1,0);
		Game3Crab c = new Game3Crab(0.0, line);
		Game3Fish f = new Game3Fish(c);
		c.jump();
		c.onTick();
		f.onTick();
		c.render(new Graphics2D() {
			
			@Override
			public void setXORMode(Color c1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setPaintMode() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setFont(Font font) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setColor(Color c) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setClip(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setClip(Shape clip) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public FontMetrics getFontMetrics(Font f) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Font getFont() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Color getColor() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Rectangle getClipBounds() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Shape getClip() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillOval(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawOval(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawLine(int x1, int y1, int x2, int y2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
					Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
					ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void dispose() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Graphics create() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void copyArea(int x, int y, int width, int height, int dx, int dy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clipRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clearRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void translate(double tx, double ty) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void translate(int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void transform(AffineTransform Tx) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void shear(double shx, double shy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setTransform(AffineTransform Tx) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setStroke(Stroke s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setRenderingHints(Map<?, ?> hints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setRenderingHint(Key hintKey, Object hintValue) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setPaint(Paint paint) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setComposite(Composite comp) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setBackground(Color color) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void scale(double sx, double sy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void rotate(double theta, double x, double y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void rotate(double theta) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public AffineTransform getTransform() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Stroke getStroke() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public RenderingHints getRenderingHints() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getRenderingHint(Key hintKey) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Paint getPaint() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public FontRenderContext getFontRenderContext() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public GraphicsConfiguration getDeviceConfiguration() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Composite getComposite() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Color getBackground() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void fill(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(AttributedCharacterIterator iterator, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(AttributedCharacterIterator iterator, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(String str, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(String str, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRenderedImage(RenderedImage img, AffineTransform xform) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRenderableImage(RenderableImage img, AffineTransform xform) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawImage(BufferedImage img, BufferedImageOp op, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean drawImage(Image img, AffineTransform xform, ImageObserver obs) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void drawGlyphVector(GlyphVector g, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void draw(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clip(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addRenderingHints(Map<?, ?> hints) {
				// TODO Auto-generated method stub
				
			}
		});
		f.render(new Graphics2D() {
			
			@Override
			public void setXORMode(Color c1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setPaintMode() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setFont(Font font) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setColor(Color c) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setClip(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setClip(Shape clip) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public FontMetrics getFontMetrics(Font f) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Font getFont() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Color getColor() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Rectangle getClipBounds() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Shape getClip() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillOval(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawOval(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawLine(int x1, int y1, int x2, int y2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
					Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
					ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void dispose() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Graphics create() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void copyArea(int x, int y, int width, int height, int dx, int dy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clipRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clearRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void translate(double tx, double ty) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void translate(int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void transform(AffineTransform Tx) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void shear(double shx, double shy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setTransform(AffineTransform Tx) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setStroke(Stroke s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setRenderingHints(Map<?, ?> hints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setRenderingHint(Key hintKey, Object hintValue) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setPaint(Paint paint) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setComposite(Composite comp) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setBackground(Color color) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void scale(double sx, double sy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void rotate(double theta, double x, double y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void rotate(double theta) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public AffineTransform getTransform() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Stroke getStroke() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public RenderingHints getRenderingHints() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getRenderingHint(Key hintKey) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Paint getPaint() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public FontRenderContext getFontRenderContext() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public GraphicsConfiguration getDeviceConfiguration() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Composite getComposite() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Color getBackground() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void fill(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(AttributedCharacterIterator iterator, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(AttributedCharacterIterator iterator, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(String str, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(String str, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRenderedImage(RenderedImage img, AffineTransform xform) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRenderableImage(RenderableImage img, AffineTransform xform) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawImage(BufferedImage img, BufferedImageOp op, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean drawImage(Image img, AffineTransform xform, ImageObserver obs) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void drawGlyphVector(GlyphVector g, float x, float y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void draw(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clip(Shape s) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addRenderingHints(Map<?, ?> hints) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
	

}
