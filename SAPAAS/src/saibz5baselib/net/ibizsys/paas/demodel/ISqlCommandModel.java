package net.ibizsys.paas.demodel;

import net.ibizsys.paas.db.ISqlCommand;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.web.IWebContext;

/**
 * Sql命令模型
 * 
 * @author Administrator
 *
 */
public interface ISqlCommandModel extends ISqlCommand {
	/**
	 * 填充命令参数列表
	 * 
	 * @param iEntity 当前数据对象
	 * @param iWebContext
	 * @param sqlParamList 参数列表
	 * @throws Exception
	 */
	void fillSqlParams(IEntity iEntity, IWebContext iWebContext, SqlParamList sqlParamList) throws Exception;
}
