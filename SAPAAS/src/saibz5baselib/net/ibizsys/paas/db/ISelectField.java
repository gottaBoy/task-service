package net.ibizsys.paas.db;

/**
 * 查询字段对象接口
 * 
 * @author Administrator
 *
 */
public interface ISelectField {

	/**
	 * 获取字段名称
	 * 
	 * @return
	 */
	String getName();

	/**
	 * 获取别名
	 * 
	 * @return
	 */
	String getAlias();

	/**
	 * 获取函数名称，值参考 net.ibizsys.paas.db.IDBDialect.FUNC_XXX 定义
	 * 
	 * @return
	 */
	String getFunc();
}
