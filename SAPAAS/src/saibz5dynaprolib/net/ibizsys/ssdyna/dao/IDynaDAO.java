package net.ibizsys.ssdyna.dao;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.saas.dao.ISaaSDAO;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;

/**
 * SaaS实体DAO对象接口
 * @author Administrator
 *
 * @param <ET>
 */
public interface IDynaDAO<ET extends IEntity> extends ISaaSDAO<ET> {

	/**
	 * 是否为动态实体模板模式
	 * @return
	 */
	boolean isDynaDETemplMode();

}
