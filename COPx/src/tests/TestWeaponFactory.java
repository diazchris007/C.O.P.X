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
import logic.WeaponFactory;
import logic.WeaponMace;
import logic.WeaponRifle;
import logic.WeaponRocketLauncher;
import logic.WeaponStaff;
import logic.WeaponSword1;
import logic.WeaponSword2;

public class TestWeaponFactory {
	//This code needed since the constructor tries to initialize an Image object 
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
		public void testGet() {
			ItemSword5 s= new ItemSword5();
			
			assertTrue(WeaponFactory.getWeapon("Rocket Launcher") instanceof WeaponRocketLauncher);
		}
		@Test
		public void testGetItemSword1() {
			assertTrue(WeaponFactory.getWeapon("sword1") instanceof WeaponSword1);		}
		@Test
		public void testGetItemSword2() {
			assertTrue(WeaponFactory.getWeapon("sword2") instanceof WeaponSword2);		}
		@Test
		public void testGetItemMace() {
			assertTrue(WeaponFactory.getWeapon("mace") instanceof WeaponMace);		}
		@Test
		public void testGetItemStaff() {
			assertTrue(WeaponFactory.getWeapon("staff") instanceof WeaponStaff);		}
		@Test
		public void testGetWeeponRifle() {
			assertTrue(WeaponFactory.getWeapon("rifle") instanceof WeaponRifle);		}

}
