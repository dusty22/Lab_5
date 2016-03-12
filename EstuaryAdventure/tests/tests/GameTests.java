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
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.RenderingHints.Key;
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

import games.CrabSaveGame;
import games.OverfishingGame;
import games.PollutionGame;
import junit.framework.TestCase;
import main.EstuaryAdventureMain;
import misc.Util;

/**
 * Tests all subclasses of Game
 * @author abraham
 *
 */
public class GameTests extends TestCase{
	
	/**
	 * tests the start and stopping mechanism of the Game class, and other aspects specifically related to the
	 * Overfishing Game.
	 */
	public void testStartStop(){
		
		
	}
	/**
	 * test the overfishing game
	 */
	public void testOverfishing(){
		EstuaryAdventureMain e = new EstuaryAdventureMain();
		Util.fakeDims();
		OverfishingGame game = new OverfishingGame();
		int i =10000;
		while(i>0){
			game.onTick();
			i--;
		}
		game.render(new Graphics2D() {
			
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
			public boolean drawImage(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8,
					Color arg9, ImageObserver arg10) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8,
					ImageObserver arg9) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image arg0, int arg1, int arg2, int arg3, int arg4, Color arg5, ImageObserver arg6) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image arg0, int arg1, int arg2, int arg3, int arg4, ImageObserver arg5) {
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
	}
	
	public void testCrabSaveGame(){
		Util.fakeDims();
		EstuaryAdventureMain e = new EstuaryAdventureMain();
		CrabSaveGame game = new CrabSaveGame();
		int i =10000;
		while(i>0){
			game.onTick();
			i--;
			if(i==5000){
				game.getTrash().clear();
			}
		}
		game.doEndAnimation();
		
		
		game.render(new Graphics2D() {
			
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
	public void testPollutionGame(){
		Util.fakeDims();
		EstuaryAdventureMain e = new EstuaryAdventureMain();
		PollutionGame game = new PollutionGame();
		int i =10000;
		while(i>0){
			game.onTick();
			i--;
		}
		
		game.render(new Graphics2D() {
			
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
