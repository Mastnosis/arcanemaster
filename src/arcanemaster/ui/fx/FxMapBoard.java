package arcanemaster.ui.fx;

import java.awt.Point;
import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import arcanemaster.map.ArcaneTile;
import arcanemaster.map.MapBoard;
import arcanemaster.map.Terrain;
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
	
	public FxMapBoard(Grid grid, int height, int width, boolean wrapX, boolean wrapY) {
		this.height = height;
		this.width = width;
		this.grid = grid;
		wrapsX = wrapX;
		wrapsY = wrapY;
		initTiles();
	}

	private void initTiles(Group group) {
		tiles = new ArrayList<ArcaneTile>(height*width);
		for(int i = 0; i < height*width; i++){
			FxTile t = new FxTile(getVertices(i));
			tiles.add(t);
			group.getChildren().add(t.getPolygon());
		}
	}
	
	@Override
	protected void initTiles(){
		tiles = new ArrayList<ArcaneTile>(height*width);
		for(int i = 0; i < height*width; i++){
			FxTile t = new FxTile(getVertices(i));
			tiles.add(t);
		}
	}

	
	public FxTile[] allTiles(){
		return tiles.toArray(new FxTile[tiles.size()]);
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
	
	protected void drawTile(FxTile t){
		Paint p = Color.WHITE;
		switch(t.getTerrain().getElevation()){
		case DEEP: p = Color.DARKBLUE;
			break;
		case WATER: p = Color.LIGHTBLUE;
			break;
		case PLAINS: p = Color.GREEN;
			break;
		case HILLS: p = Color.DARKOLIVEGREEN;
			break;
		case MOUNTAINS: p = Color.AZURE;
			break;
		case HIGH: p = Color.GREY;
			break;
		default: p = Color.BLACK;
			break;
		}
		t.getPolygon().setFill(p);
	}
	
	protected void updateTiles(){
		for (FxTile t : allTiles()) {
			drawTile(t);
		}
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
	

	

}
