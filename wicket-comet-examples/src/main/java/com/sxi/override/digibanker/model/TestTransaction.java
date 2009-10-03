/**
 * 
 */
package com.sxi.override.digibanker.model;

/**
 * @author Emmanuel Nollase - emanux
 * created 2009 7 21 - 12:54:33
 */
public class TestTransaction extends BaseModel
{

    private String tranCode;
    private String tranType;
    private Double tranAmt;
    private String tranDscp;
    
    public String getTranCode()
    {
        return tranCode;
    }
    public void setTranCode(String tranCode)
    {
        this.tranCode = tranCode;
    }
    public String getTranType()
    {
        return tranType;
    }
    public void setTranType(String tranType)
    {
        this.tranType = tranType;
    }
    public Double getTranAmt()
    {
        return tranAmt;
    }
    public void setTranAmt(Double tranAmt)
    {
        this.tranAmt = tranAmt;
    }
    public String getTranDscp()
    {
        return tranDscp;
    }
    public void setTranDscp(String tranDscp)
    {
        this.tranDscp = tranDscp;
    }
    
}
