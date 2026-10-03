package net.ibizsys.paas.control.grid;

/**
 * 表格编辑项自填模式接口
 * <p>
 * I==>接口,GEI ==>Grid Edit Item 表格编辑项,DEF==>DataEntity Field 实体属性,AC==>AutoComplate 自动填充
 * <p>
 * IGEIDEAC
 * 
 * @author Administrator
 *
 */
public interface IGEIDEACMode {
	/**
	 * 获取对应的实体名称
	 * 
	 * @return
	 */
	String getDEName();

	/**
	 * 获取实体AC模式名称
	 * 
	 * @return
	 */
	String getDEACModeName();

}
