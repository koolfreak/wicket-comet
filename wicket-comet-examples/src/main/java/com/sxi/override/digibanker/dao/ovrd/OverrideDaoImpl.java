/**
 * 
 */
package com.sxi.override.digibanker.dao.ovrd;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sxi.override.digibanker.model.ovrd.OverrideModel;

/**
 * @author Emmanuel Nollase - emanux
 * created 2009 7 21 - 16:03:41
 */
public class OverrideDaoImpl extends HibernateDaoSupport implements OverrideDao
{

    /* (non-Javadoc)
     * @see com.sxi.override.digibanker.dao.OverrideDao#save(com.sxi.override.digibanker.model.ovrd.OverrideModel)
     */
    public void save(OverrideModel overrideModel) throws DataAccessException
    {
	getHibernateTemplate().save(overrideModel);

    }

    public List<OverrideModel> findAll() throws DataAccessException
    {
	// TODO Auto-generated method stub
	return null;
    }

    @SuppressWarnings("unchecked")
    public List<OverrideModel> findOverrides(int first, int count)
	    throws DataAccessException
    {
	final Criteria criteria = this.getSession().createCriteria(OverrideModel.class);
	criteria.add(Restrictions.eq("status", 0));
	criteria.setFirstResult(first).setMaxResults(count);
	return criteria.list();
    }

    public int findOverridesSize() throws DataAccessException
    {
	final Criteria criteria = this.getSession().createCriteria(OverrideModel.class);
	criteria.setProjection(Projections.rowCount());
	return (Integer) criteria.uniqueResult();
    }

    public OverrideModel findByRefNo(String refno) throws DataAccessException
    {
	final Criteria criteria = this.getSession().createCriteria(OverrideModel.class);
	criteria.add(Restrictions.eq("refNo", refno));
	return (OverrideModel) criteria.uniqueResult();
    }

    public void update(OverrideModel overrideModel) throws DataAccessException
    {
	getHibernateTemplate().merge(overrideModel);
    }

}
