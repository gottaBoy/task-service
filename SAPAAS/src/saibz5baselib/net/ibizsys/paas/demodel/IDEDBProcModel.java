package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEDBSysProcAction;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.web.IWebContext;

/**
 * 实体数据库存储过程模型接口
 * 
 * @author Administrator
 *
 */
public interface IDEDBProcModel extends IDEDBSysProcAction {
	/**
	 * 填充过程参数
	 * 
	 * @param strDBType
	 * @param iEntity
	 * @param iWebContext
	 * @param sqlParamList
	 * @throws Exception
	 */
	void fillSqlParams(String strDBType, IEntity iEntity, IWebContext iWebContext, SqlParamList sqlParamList) throws Exception;

}
