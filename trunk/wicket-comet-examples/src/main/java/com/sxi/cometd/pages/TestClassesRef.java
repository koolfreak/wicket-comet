/**
 * 
 */
package com.sxi.cometd.pages;

import com.sxi.override.digibanker.model.BaseModel;
import com.sxi.override.digibanker.model.TestTransaction;

/**
 * @author Emmanuel Nollase - emanux
 * created 2009 7 21 - 17:15:29
 */
public class TestClassesRef
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
	TestTransaction txn = new TestTransaction();
	printClass(txn);

    }

    public static void printClass(BaseModel baseModel)
    {
	String clazz = baseModel.getClass().getCanonicalName();
	System.out.println(clazz);
    }
    
    
}
