package arcanemaster.ui.fx;

import java.awt.Point;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import arcanemaster.map.MapBoard;
import arcanemaster.map.grid.Grid;
import arcanemaster.map.grid.GridCoordinate;
import arcanemaster.map.grid.HexGrid;


public class FxArcaneMaster extends Application {
	
	private static final int HEIGHT = 10;
	private static final int WIDTH = 12;
	private Grid grid = new HexGrid();
	
	private MapBoard.Size size = MapBoard.Size.SMALL;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Arcane Master");
        Group root = new Group();
        
       
//        for (int i = 0; i < HEIGHT*WIDTH; i++){
//        	Polygon p = getPoly(i);
//        	root.getChildren().add(p);
//        }
        
       // Canvas canvas = new Canvas(1280, 720);
       // GraphicsContext gc = canvas.getGraphicsContext2D();
        FxMapBoard map = new FxMapBoard(new HexGrid(), size.dimensionY(), size.dimensionX(), false, false, root);
        //map.draw(gc);
        // drawShapes(gc);
        // root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
	}

	private Polygon getPoly(int index) {
		Polygon p = new Polygon();
		int x = index%WIDTH;
		int y = index/WIDTH;
		p.getPoints().addAll(getVerticesAsDouble(grid.getVertices(new GridCoordinate(x,y))));
		return p;
	}
	
	private Double[] getVerticesAsDouble(Point[] points){
		Double[] vertices = new Double[points.length*2];
		for (int i = 0; i < points.length; i++){
			vertices[i*2]= (double)points[i].x;
			vertices[i*2+1] = (double)points[i].y;
		}
		return vertices;
	}

//	private void drawShapes(GraphicsContext gc) {
//		gc.setFill(Color.GREEN);
//        gc.setStroke(Color.BLUE);
//        gc.setLineWidth(5);
////        gc.strokeLine(40, 10, 10, 40);
////        gc.fillOval(10, 60, 30, 30);
////        gc.strokeOval(60, 60, 30, 30);
////        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
////        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
////        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
////        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
////        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
////        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
////        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
////        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
////        gc.fillPolygon(new double[]{10, 40, 10, 40},
////                       new double[]{210, 210, 240, 240}, 4);
////        gc.strokePolygon(new double[]{60, 90, 60, 90},
////                         new double[]{210, 210, 240, 240}, 4);
////        gc.strokePolyline(new double[]{110, 140, 110, 140},
////                          new double[]{210, 210, 240, 240}, 4);
////		HexGrid hg = new HexGrid();
////		Point[] points = hg.getVertices(new GridCoordinate(0,0));
////		for (Point point : points) {
////			System.out.println(point.toString());
////		}
//		for(int i = 0; i < 10; i++){
//			for(int j = 0; j < 10; j++){
//				printHex(gc, i, j);
//			}
//		}
//		
//		
//		
////		gc.fillPolygon(getXvert(points), getYvert(points), 6);
//		gc.setFill(Color.RED);
//		for(int i = 0; i < 10;i++){
//			printHex(gc, i, 1);
//		}
////		points = hg.getVertices(new GridCoordinate(0,1));
////		gc.fillPolygon(getXvert(points), getYvert(points), 6);
//		
//		
//	}
//	
//	private void printHex(GraphicsContext gc, int x, int y){
//		Point[] points = HexGrid.getVertices(x, y);
//		gc.fillPolygon(getXvert(points), getYvert(points), 6);
//	}
//	
//	private double[] getXvert(Point[] points){
//		double[] px = new double[points.length];
//		for (int i = 0; i < points.length; i++){
//			px[i]= (double)points[i].x;
//		}
//		return px;
//	}
//	
//	private double[] getYvert(Point[] points){
//		double[] py = new double[points.length];
//		for (int i = 0; i < points.length; i++){
//			py[i]= (double)points[i].y;
//		}
//		return py;
//	}

}
