package net.ibizsys.paas.db;

/**
 * 数据库命令接口
 * 
 * @author lionlau
 *
 */
public interface ISqlCommand {
	/**
	 * 获取Sql
	 * 
	 * @return
	 */
	String getSql();

	/**
	 * 获取参数
	 * 
	 * @return
	 */
	java.util.Iterator<IProcParam> getProcParams();
}
