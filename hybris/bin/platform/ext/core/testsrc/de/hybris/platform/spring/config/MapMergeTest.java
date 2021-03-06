/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.spring.config;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.testframework.TestUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test/MergeDirectives-test-spring.xml")
@UnitTest
public class MapMergeTest
{
	private Map<String, String> stringMap;
	private Map<String, Collection<String>> multiMap;


	@Autowired
	@Qualifier("mergeTestBean")
	private MergeTestBean externalBean;

	@Autowired
	@Qualifier("mergeFieldTestBean")
	private MergeTestBean fieldBean;

	@BeforeClass
	public static void setUp()
	{
		TestUtils.disableFileAnalyzer("expecting errors for invalid mapMergeBeanPostProcessor directives", 100);
	}

	@Before
	public void init()
	{
		stringMap = new HashMap<>();
		stringMap.put("aaa", "111");
		stringMap.put("bbb", "444");
		stringMap.put("ccc", "333");

		multiMap = new HashMap<>();
		multiMap.put("aaa", Arrays.asList("1", "2"));
		multiMap.put("ccc", Arrays.asList("7", "8"));
		multiMap.put("bbb", Arrays.asList("3", "4", "5", "6"));
	}

	@AfterClass
	public static void tearDown()
	{
		TestUtils.enableFileAnalyzer();
	}

	@Test
	public void testExternalStringMapMerge()
	{
		final Map<String, String> map = externalBean.getStringMap();
		Assert.assertEquals(stringMap, map);
	}

	@Test
	public void testFieldStringMapMerge()
	{
		final Map<String, String> map = fieldBean.getStringMap();
		Assert.assertEquals(stringMap, map);
	}

	@Test
	public void testExternalMultiMapMerge()
	{
		final Map<String, Collection<String>> map = externalBean.getMultiMap();
		Assert.assertEquals(multiMap, map);
	}

	@Test
	public void testFieldMultiMapMerge()
	{
		final Map<String, Collection<String>> map = fieldBean.getMultiMap();
		Assert.assertEquals(multiMap, map);
	}

}
