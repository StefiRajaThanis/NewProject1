package org.test;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import uicomp.BaseClass;

public class TestngRunner extends BaseClass {

	@BeforeSuite
	public void browserlaunch() {
		System.out.println("Browser launhced successfully");
	}
	@Test
	public void urlLuanch() {
		System.out.println("URL launched");
	}
}
