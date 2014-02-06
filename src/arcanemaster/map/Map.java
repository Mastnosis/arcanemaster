package arcanemaster.map;

import java.util.*;

import arcanemaster.unit.Movement;
import arcanemaster.unit.Unit;

public class Map {
	
	int horizontalsize;
	int verticalsize;
	
	boolean horizontalwrap = false;
	boolean verticalwrap = false;
	
	List<Tile> tiles;
	
	public Map(){
		this(20, 10, false, false);
	}
	
	public Map(int horizontal, int vertical, boolean wrapH, boolean wrapV){
		horizontalsize = horizontal;
		verticalsize = vertical;
		horizontalwrap = wrapH;
		verticalwrap = wrapV;
		initMap();
	}
	
	private void initMap(){
		tiles = new ArrayList<Tile>(horizontalsize*verticalsize);
		for(Tile t: tiles){
			t = new Tile();
		}
	}
	
	public LinkedList<Tile> getNeighbors(int h, int v){
		int offset = 1;  // even rows have above and below neighbors shifted one towards the negative
		if (v %2 == 1){	// check for odd rows
			offset = 0;
		}
		LinkedList <Tile> neighbors = new LinkedList<Tile>();  // edge tiles my have less than 6 neighbors otherwise a fixed array would be preferrable
		neighbors.add(getTile(h +1, v ));
		neighbors.add(getTile(h -1, v));
		neighbors.add(getTile(h - offset, v+1));
		neighbors.add(getTile(h +1 -offset, v+1));
		neighbors.add(getTile(h - offset, v-1));
		neighbors.add(getTile(h +1 -offset, v-1));
		for (Tile t: neighbors){
			if(t == null){
				neighbors.remove(t);	// get rid of all the null values so we don't have to deal with them in pathing calculations
			}
		}
		return neighbors;
	}
	
	public Tile getTile(int h, int v){
		int index = h + h*v;
		if (index < 0 || index >= tiles.size()){
			return null;
		}
		return tiles.get(h + h*v);
	}
	
	public LinkedList<Tile> getShortestPath(Unit traveler, int originX, int originY, int destX, int destY){
		int origindex = originX + horizontalsize*originY;
		int destindex = destX + horizontalsize*destY;
		Tile currenttile = tiles.get(origindex);
				
		// create a list of all tiles and the movement cost to each
		HashMap<Tile,Integer> costs = new HashMap<Tile, Integer>();
		LinkedList<Tile> unvisited = new LinkedList<Tile>(tiles);
		// LinkedList<Tile> visited = new LinkedList<Tile>();
		
		// set all costs to MAXINT
		for(Tile t: unvisited){
			costs.put(t, Integer.MAX_VALUE);
		}
		
		// set movement cost to original hex to 0
		costs.put(currenttile, 0);
		
		boolean complete = false;
		
		while(!complete){
			// calculate the cost of moving to all neighbors
			for(Tile t: currenttile.getNeighbors()){
				if (unvisited.contains(t)){
					int turndelay = calculateDelay(costs.get(currenttile), t.costToEnter(traveler.getMovement()), traveler.getMovement());  //this needs to be calculated to account for insufficient remaining move points in a turn
					int movecost = costs.get(currenttile) + t.costToEnter(traveler) + turndelay;
					if (movecost < costs.get(t)){
						costs.put(t, movecost);
					}
				}
			}

			// mark current tile visited
			unvisited.remove(currenttile);
			
			// break while if destination has been reached.
			if(currenttile.equals(tiles.get(destindex))){
				complete = true;
			}

			// get tile with lowest move cost and set as currenttile
			int lowest = Integer.MAX_VALUE;
			currenttile = unvisited.element();  // grab the first element
			for(Tile t: unvisited){
				if (costs.get(t)< lowest){
					currenttile = t;
				}
			}
			// break loop if destination is unreachable
			if(costs.get(currenttile) == Integer.MAX_VALUE){
				complete = true;
			}
		}
		
		
		return determineOptimalPath(costs, tiles.get(destindex));
	}
	
	/*
	 * This method is required to account for movement costs where there is
	 * insufficient movement remaining in the current turn to enter the new hex.
	 * If the previous hex is occupied then it's cost must also be added since the unit must
	 * move in one complete motion.  It must wait until it can move through the occupied hex
	 * and into the target hex without interruption.
	 */
	private int calculateDelay(Tile currenttile, Tile t, Movement move) {
		int delay = 0;
		/*
		 * calculate the number of movement points remaining in the turn after 
		 * moving to the current tile which may happen over multiple turns.
		 */
		
		if (t.isOccupied()){
			if (0 == move.getMovementPerTurn()-(move.getRemainingMove() - ))
		}
		int m = 0;
		if (m < t.costToEnter(u)){
			if(t.isOccupied()){
				m += currenttile.costToEnter(u);
			}
			return m;
		}
		return 0;
	}

	private LinkedList<Tile> determineOptimalPath(HashMap<Tile, Integer> movementcosts, Tile destination){
		LinkedList<Tile> path = new LinkedList<Tile>();
		path.add(destination);
		Tile next = destination;
		while(movementcosts.get(next) <= 0){
			for(Tile t: next.getNeighbors()){
				
			}
		}
		return path;
	}

}
