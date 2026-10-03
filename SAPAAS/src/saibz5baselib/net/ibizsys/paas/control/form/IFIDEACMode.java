package net.ibizsys.paas.control.form;

/**
 * 表单项自动填充模式接口
 * 
 * @author Administrator
 *
 */
public interface IFIDEACMode {
	/**
	 * 获取对应的实体名称
	 * 
	 * @return
	 */
	String getDEName();

	/**
	 * AC模式名称
	 * 
	 * @return
	 */
	String getDEACModeName();

}
