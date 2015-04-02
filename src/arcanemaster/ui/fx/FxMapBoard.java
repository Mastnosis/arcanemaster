package arcanemaster.ui.fx;

import java.awt.Point;
import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import arcanemaster.map.MapBoard;
import arcanemaster.map.grid.Grid;
import arcanemaster.map.grid.GridCoordinate;
import arcanemaster.map.grid.Tile;

public class FxMapBoard extends MapBoard {
	
	
	
	public FxMapBoard(Grid grid, int height, int width, boolean wrapX, boolean wrapY, Group group){
		this.height = height;
		this.width = width;
		this.grid = grid;
		wrapsX = wrapX;
		wrapsY = wrapY;
		
		initTiles(group);
	}
	
	private void initTiles(Group group) {
		tiles = new ArrayList<Tile>(height*width);
		for(int i = 0; i < height*width; i++){
			FxTile t = new FxTile(getVertices(i));
			tiles.add(t);
			group.getChildren().add(t.getPolygon());
		}
	}

	@Override
	protected void initTiles() {
		
	}
	
	
	private Point[] getVertices(int i) {
		Point[] p = grid.getVertices(new GridCoordinate(i%width, i/width));
		return p;
	}

	public void draw(GraphicsContext gc){
		for (Tile t : tiles) {
			drawTile(gc, (FxTile) t);
		}
	}
	
	protected void drawTile(GraphicsContext gc, FxTile t){
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
	
//	private Paint getColor(Terrain t){
//		Paint p;
//		switch(){
//		
//		}
//		return p;
//	}
	

}
