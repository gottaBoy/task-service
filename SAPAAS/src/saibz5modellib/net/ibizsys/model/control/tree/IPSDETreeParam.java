package net.ibizsys.model.control.tree;

import net.ibizsys.model.control.IPSMDAjaxControlParam;
import net.ibizsys.paas.control.tree.ITreeHandlerParam;

/**
 * 实体树部件参数对象接口
 * @author lionlau
 *
 */
public interface IPSDETreeParam extends IPSMDAjaxControlParam,ITreeHandlerParam
{
	/**
	 * 获取实体树视图标识
	 * @return
	 */
	String getPSDETreeId();
	

}
