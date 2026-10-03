package net.ibizsys.model.dataentity.ds;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.paas.core.IDEDataQueryCode;


/**
 * 实体数据查询代码对象接口
 * 
 * @author Administrator
 *
 */
public interface IPSDEDataQueryCode extends IPSModelObject, IDEDataQueryCode {
	
	/**
	 * 获取数据查询
	 * 
	 * @return
	 */
	IPSDEDataQuery getPSDEDataQuery();

	/**
	 * 获取表达式集合
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEDataQueryCodeExp> getPSDEDataQueryCodeExps() throws Exception;

	/**
	 * 获取条件集合
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEDataQueryCodeCond> getPSDEDataQueryCodeConds() throws Exception;

	
}
