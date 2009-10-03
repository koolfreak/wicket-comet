/**
 * 
 */
package com.sxi.override.digibanker.dao.ovrd;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.sxi.override.digibanker.model.ovrd.OverrideModel;

/**
 * @author Emmanuel Nollase - emanux
 * created 2009 7 21 - 16:02:49
 */
public interface OverrideDao
{
    void save(OverrideModel overrideModel) throws DataAccessException;
    
    void update(OverrideModel overrideModel) throws DataAccessException;
    
    OverrideModel findByRefNo(String refno) throws DataAccessException;
    
    List<OverrideModel> findAll() throws DataAccessException;
    
    List<OverrideModel> findOverrides(final int first,final int count) throws DataAccessException;
    
    int findOverridesSize() throws DataAccessException;
}
