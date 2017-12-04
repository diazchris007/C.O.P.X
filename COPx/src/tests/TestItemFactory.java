package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;
import logic.ItemChargePotion;
import logic.ItemFactory;
import logic.ItemGreenPotion;
import logic.ItemHpPotion;
import logic.ItemManaPotion;
import logic.ItemShield;
import logic.ItemSword5;

public class TestItemFactory {
	//This code needed since the player constructor tries to initialize an Image object 
		@BeforeClass
		public static void initJFX() throws InterruptedException {
		    Thread t = new Thread("JavaFX Dummy Thread") {
		    		@Override
		        public void run() {
		            Application.launch(DummyApp.class, new String[0]);
		        }
		    };
		    t.setDaemon(true);
		    t.start();
		    Thread.sleep(1000);
		}
		
	@Test
	public void testGetItemSword5() {
		ItemSword5 s= new ItemSword5();
		
		assertTrue(ItemFactory.getItem("Sword5") instanceof ItemSword5);
	}
	@Test
	public void testGetItemSheild() {
		assertTrue(ItemFactory.getItem("Shield") instanceof ItemShield);
	}
	@Test
	public void testGetItemGreen() {
		assertTrue(ItemFactory.getItem("Green Potion") instanceof ItemGreenPotion );
	}
	@Test
	public void testGetItemCharge() {
		assertTrue(ItemFactory.getItem("Charge Potion") instanceof ItemChargePotion);
	}
	@Test
	public void testGetItemHp() {
		assertTrue(ItemFactory.getItem("Hp Potion") instanceof ItemHpPotion);
	}
	@Test
	public void testGetItemMana() {
		assertTrue(ItemFactory.getItem("Mana potion") instanceof ItemManaPotion);
	}

}
