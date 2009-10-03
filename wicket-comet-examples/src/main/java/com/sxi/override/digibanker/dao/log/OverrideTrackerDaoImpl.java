/**
 * 
 */
package com.sxi.override.digibanker.dao.log;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sxi.override.digibanker.model.ovrd.OverrideDetail;
import com.sxi.override.digibanker.model.ovrd.OverrideHeader;

/**
 * @author Emmanuel Nollase - emanux
 * created 2009 7 21 - 18:54:41
 */
public class OverrideTrackerDaoImpl extends HibernateDaoSupport implements
	OverrideTrackerDao
{

    public void save(OverrideHeader header)
    {
	getHibernateTemplate().save(header);
    }

    public void save(OverrideDetail detail)
    {
	getHibernateTemplate().save(detail);
    }

    public void update(OverrideDetail detail) throws DataAccessException
    {
	getHibernateTemplate().merge(detail);
    }

    public void update(OverrideHeader header) throws DataAccessException
    {
	getHibernateTemplate().merge(header);
    }

    public OverrideHeader findOvrdHdByRefNo(String refNo)
	    throws DataAccessException
    {
	final Criteria criteria = this.getSession().createCriteria(OverrideHeader.class);
	criteria.add(Restrictions.eq("refNo", refNo));
	return (OverrideHeader) criteria.uniqueResult();
    }

    public Integer supervisorCheck(String user, String headerId)
	    throws DataAccessException
    {
	
	final Criteria criteria = this.getSession().createCriteria(OverrideDetail.class);
	criteria.setProjection(Projections.rowCount());
	
	if(user != null)
	{
	    criteria.add(Restrictions.eq("userId", user));
	}
	
	criteria.add(Restrictions.eq("ovrdHdrId.id", headerId));
	
	return (Integer) criteria.uniqueResult();
	
    }

    public OverrideDetail findOvrdDtlByOvrdKey(String ovrdKey)
	    throws DataAccessException
    {
	final Criteria criteria = this.getSession().createCriteria(OverrideDetail.class);
	criteria.add(Restrictions.eq("ovrdKey", ovrdKey));
	return (OverrideDetail) criteria.uniqueResult();
    }

}
