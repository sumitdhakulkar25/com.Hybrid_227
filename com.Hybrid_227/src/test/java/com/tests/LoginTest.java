package com.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class LoginTest extends BaseClass {
	
	@BeforeSuite
	public void setup()throws Exception {
		initilization();
		reportInit();
	}
    @Test
    public void test01() {
    	Assert.assertEquals(driver.getTitle(), "123");
    }
    @Test
    public void test02() {
    	Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
    }
    @Test
    public void test03() {
    	throw new SkipException("shiping a testcase");
    }
}
