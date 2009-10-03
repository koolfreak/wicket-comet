/**
 * 
 */
package com.sxi.override.digibanker.service.ovrd;

import java.util.List;

import com.sxi.cometd.pages.utils.OverrideEntryParams;
import com.sxi.override.digibanker.model.ovrd.OverrideBean;
import com.sxi.override.digibanker.model.ovrd.OverrideModel;
import com.sxi.override.digibanker.service.BaseService;

/**
 * @author Emmanuel Nollase - emanux created 2009 7 21 - 12:42:39
 */
public interface OverrideService extends BaseService
{

    void update(OverrideModel model);
    
    List<OverrideBean> numberOfOverrides(final int numOvrd);
    
    OverrideModel findByRefNo(String refno);
    
    boolean save(final OverrideModel overrideModel,final OverrideEntryParams entryParams);
    
    List<OverrideModel> findOverrides(final int first,final int count);
    
    int findOverridesSize();
}
