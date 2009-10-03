/**
 * 
 */
package com.sxi.cometd.pages.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.safehaus.uuid.UUIDGenerator;

/**
 * @author Emmanuel Nollase - emanux
 * created 2009 7 23 - 13:21:42
 */
public final class OverrideGenerator
{

    private final static SimpleDateFormat FORMAT = new SimpleDateFormat();
    
    public static String generateOvrdTransaction(String funcCd)
    {
	StringBuilder build = new StringBuilder();
	build.append("OVRD").append('-').append(funcCd).append('-');
	FORMAT.applyPattern("MMddyy-hhmmss");
	build.append(FORMAT.format(new Date())).append('-');
	build.append(RandomStringUtils.randomAlphanumeric(5).toUpperCase());
	
	return build.toString();
    }
    
    public static String generateOvrdKey()
    {
	return UUIDGenerator.getInstance().generateRandomBasedUUID().toString();
    }
    
    private OverrideGenerator(){}
}
