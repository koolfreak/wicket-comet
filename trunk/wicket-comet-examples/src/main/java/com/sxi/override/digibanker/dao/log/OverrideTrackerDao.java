/**
 * 
 */
package com.sxi.override.digibanker.dao.log;

import org.springframework.dao.DataAccessException;

import com.sxi.override.digibanker.model.ovrd.OverrideDetail;
import com.sxi.override.digibanker.model.ovrd.OverrideHeader;

/**
 * @author Emmanuel Nollase - emanux
 * created 2009 7 21 - 18:54:10
 */
public interface OverrideTrackerDao
{

    void save(OverrideHeader header) throws DataAccessException;
    
    void save(OverrideDetail detail) throws DataAccessException;
    
    void update(OverrideDetail detail) throws DataAccessException;
    
    void update(OverrideHeader header) throws DataAccessException;
    
    OverrideHeader findOvrdHdByRefNo(String refNo) throws DataAccessException;
    
    OverrideDetail findOvrdDtlByOvrdKey(String ovrdKey) throws DataAccessException;
    
    Integer supervisorCheck(String user,String headerId) throws DataAccessException;
}
