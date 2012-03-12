package com.dken.webspider.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dken.webspider.core.HttpClientUtilities;

public class HttpClientUtilitiesTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testRun() {
    	HttpClientUtilities test = new HttpClientUtilities();
			test.sendHTTPRequest();
        fail("Not yet implemented");
    }

}
