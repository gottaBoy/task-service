package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.control.IPSAjaxControlParam;

/**
 * 数据看版参数对象接口
 * @author lionlau
 *
 */
public interface IPSDashboardParam extends IPSAjaxControlParam
{
	/**
	 * 获取列模型
	 * @return
	 */
	double[] getColumnModels();
}
