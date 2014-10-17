package arcanemaster.unit;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

import arcanemaster.unit.combat.Attack;


public class MinionHandler extends DefaultHandler2 {
	
	Document dom;
	
	public void parseXMLFile(String file){
		//get the factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {

			//Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();

			//parse using builder to get DOM representation of the XML file
			dom = db.parse(file);


		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	private void parseDocument(){
		//get the root element
		Element docEle = dom.getDocumentElement();

		//get a nodelist of elements
		NodeList nl = docEle.getElementsByTagName("Employee");
		if(nl != null && nl.getLength() > 0) {
			for(int i = 0 ; i < nl.getLength();i++) {

				//get the employee element
				Element el = (Element)nl.item(i);

				//get the Employee object
				Minion p = getProfession(el);


			}
		}
	}

	/**
	 * 	<?xml version="1.0" encoding="UTF-8"?>
		<Profession name="Warrior" health="25" cost="25" turns="3" class="Fighter">
			<Attack range="1">
				<Melee value="9"></Melee>
			</Attack>
			<Perk name="Basic Armor">
				<Resistance value="20" type="melee"></Resistance>
				<Resistance value="40" type="missile"></Resistance>
			</Perk>
			<Upkeep gold="1" food="1" mana="0"></Upkeep>
			<GameInfo>Common fighters</GameInfo>
			<LoreInfo>To be added...</LoreInfo>
			<Move type="Walker" value="3"></Move>
		</Profession>
	 * @param el
	 * @return
	 */
	private Minion getProfession(Element el) {
		String name = el.getAttribute("name");
		int health  = Integer.parseInt(el.getAttribute("health"));
		int cost    = Integer.parseInt(el.getAttribute("cost"));
		int turns   = Integer.parseInt(el.getAttribute("turns"));
		int sight	= Integer.parseInt(el.getAttribute("sight"));
		String race = el.getAttribute("race");
		String description = getTextValue(el, "GameInfo");
		String lore = getTextValue(el, "LoreInfo");

		
		Minion p = new Minion(name, health, cost, sight, new Cost(), 
										new Attack(), Race.valueOf(race), description, lore);

		return p;
	}

	/**
	 * I take a xml element and the tag name, look for the tag and get
	 * the text content
	 * i.e for <employee><name>John</name></employee> xml snippet if
	 * the Element points to employee node and tagName is 'name' I will return John
	 */
	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}

		return textVal;
	}


	/**
	 * Calls getTextValue and returns a int value
	 */
	private int getIntValue(Element ele, String tagName) {
		//in production application you would catch the exception
		return Integer.parseInt(getTextValue(ele,tagName));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
