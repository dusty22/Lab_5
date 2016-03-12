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

import junit.framework.TestCase;
import misc.Util;
import scorekeeping.CrabSaveScore;
import scorekeeping.OverfishingScore;
import scorekeeping.PollutionScore;
import scorekeeping.ScoreKeeper;
import scorekeeping.StatsScreen;

public class ScoreKeepingTests extends TestCase{
	
	public void testCrabSaveScore(){
		CrabSaveScore crabSaveScore = new CrabSaveScore(0, 36.6);
		assertEquals(crabSaveScore.getTrashNum(), 0);
		assertEquals(crabSaveScore.getCalculatedScore(),100);
		CrabSaveScore crabSaveScore1 = new CrabSaveScore(1, 24.4);
		assertEquals(crabSaveScore1.getTrashNum(), 1);
		assertEquals(crabSaveScore1.getTime(), 24.4);
		assertEquals(crabSaveScore1.getCalculatedScore(),79);
	}
	
	public void testOverfishingScore(){
		OverfishingScore overfishingScore = new OverfishingScore(240, 15);
		assertEquals(overfishingScore.getCalculatedScore(), 100);
		OverfishingScore overfishingScore1 = new OverfishingScore(55, 0);
		assertEquals(overfishingScore1.getCalculatedScore(), 10);
		OverfishingScore overfishingScore2 = new OverfishingScore(25, 10);
		assertEquals(overfishingScore2.getCalculatedScore(), 55);
		OverfishingScore overfishingScore3 = new OverfishingScore(125, 10);
		assertEquals(overfishingScore3.getCalculatedScore(), 65);
		OverfishingScore overfishingScore03 = new OverfishingScore(152, 10);
		assertEquals(overfishingScore03.getCalculatedScore(), 70);
		OverfishingScore overfishingScore4 = new OverfishingScore(260, 15);
		assertTrue(overfishingScore4.getDistance()==260);
		assertTrue(overfishingScore4.getnumFishLeft()==15);
		assertTrue(overfishingScore4.getCalculatedScore()==100);
	}
	
	public void testPollutionScore(){
		PollutionScore pollutionScore = new PollutionScore(1);
		PollutionScore pollutionScore0 = new PollutionScore(9);
		PollutionScore pollutionScore1 = new PollutionScore(18);
		PollutionScore pollutionScore2 = new PollutionScore(27);
		PollutionScore pollutionScore3 = new PollutionScore(36);
		PollutionScore pollutionScore4 = new PollutionScore(45);
		PollutionScore pollutionScore5 = new PollutionScore(54);
		PollutionScore pollutionScore6 = new PollutionScore(63);
		PollutionScore pollutionScore7 = new PollutionScore(72);
		PollutionScore pollutionScore8 = new PollutionScore(81);
		assertEquals(pollutionScore.getCalculatedScore(), 10);
		assertEquals(pollutionScore0.getCalculatedScore(), 20);
		assertEquals(pollutionScore1.getCalculatedScore(), 30);
		assertEquals(pollutionScore2.getCalculatedScore(), 40);
		assertEquals(pollutionScore3.getCalculatedScore(), 50);
		assertEquals(pollutionScore4.getCalculatedScore(), 60);
		assertEquals(pollutionScore5.getCalculatedScore(), 70);
		assertEquals(pollutionScore6.getCalculatedScore(), 80);
		assertEquals(pollutionScore7.getCalculatedScore(), 90);
		assertEquals(pollutionScore8.getCalculatedScore(), 100);
	}
	
	
	
	public void testStatScreen(){
		Util.setDistanceToEdge(1000, 1000);
		Util.setCanvasHeight(1000);
		Util.setCanvasWidth(1000);
		Util.setCurrentScaleFactor(1000/2000.0);
		Util.fakeDims();
		ScoreKeeper sc = new ScoreKeeper();
		sc.addCrabSaveScore(new CrabSaveScore(5, 5));
		sc.addPollutionScore(new PollutionScore(5));
		sc.addOverfishingScore(new OverfishingScore(50, 5));
		assertNotNull(sc.getCrabSaveScore());
		assertNotNull(sc.getOverfishingScore());
		assertNotNull(sc.getPollutionScore());
		assertTrue(sc.hasCrabSaveScore());
		assertTrue(sc.hasOverfishingScore());
		assertTrue(sc.hasPollutionScore());
		StatsScreen s = new StatsScreen(sc);
		
		assertFalse(s.isDone());
		s.render(new Graphics2D() {
			
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
	
}
