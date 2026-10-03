package net.ibizsys.model.control.form;

/**
 * 实体搜索表单参数对象接口
 * @author Administrator
 *
 */
public interface IPSDESearchFormParam extends IPSDEFormParam {

	/**
	 * 是否支持高级搜索
	 * @return
	 */
	Boolean isEnableAdvanceSearch();
}
