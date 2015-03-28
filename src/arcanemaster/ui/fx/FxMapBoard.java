package arcanemaster.ui.fx;

import java.awt.Point;
import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import arcanemaster.map.MapBoard;
import arcanemaster.map.grid.Grid;
import arcanemaster.map.grid.Tile;

public class FxMapBoard extends MapBoard {
	
	public FxMapBoard(Grid grid, int height, int width, boolean wrapX, boolean wrapY){
		this.height = height;
		this.width = width;
		this.grid = grid;
		wrapsX = wrapX;
		wrapsY = wrapY;
		initTiles();
	}
	
	@Override
	protected void initTiles() {
		tiles = new ArrayList<Tile>(height*width);
		for(int i = 0; i < height*width; i++){
			tiles.add(new FxTile());
		}
	}
	
	
	public void draw(GraphicsContext gc){
		for (Tile t : tiles) {
			drawTile(gc, t);
		}
	}
	
	protected void drawTile(GraphicsContext gc, Tile t){
		Point[] points = grid.getVertices(getCoordinate(t));
		gc.fillPolygon(getXvert(points), getYvert(points), points.length);
	}
	
	private double[] getXvert(Point[] points){
		double[] px = new double[points.length];
		for (int i = 0; i < points.length; i++){
			px[i]= (double)points[i].x;
		}
		return px;
	}
	
	private double[] getYvert(Point[] points){
		double[] py = new double[points.length];
		for (int i = 0; i < points.length; i++){
			py[i]= (double)points[i].y;
		}
		return py;
	}
	
	private Paint getColor(Terrain t){
		Paint p;
		switch(){
		
		}
		return p;
	}
	

}
