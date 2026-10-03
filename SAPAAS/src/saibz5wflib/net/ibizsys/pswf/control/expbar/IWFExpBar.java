package net.ibizsys.pswf.control.expbar;

import net.ibizsys.paas.control.expbar.IExpBar;

/**
 * 工作流导航栏接口
 * 
 * @author lionlau
 *
 */
public interface IWFExpBar extends IExpBar {
	/**
	 * 工作流数据分组,我的数据
	 */
	final static String SECTION_MYDATA = "MY";

	/**
	 * 工作流数据分组,全部数据
	 */
	final static String SECTION_ALLDATA = "ALL";

	/**
	 * 工作流数据分组，我的流程工作
	 */
	final static String SECTION_MYWFWORK = "MYWFWORK";

	/**
	 * 工作流数据分组，处理中
	 */
	final static String SECTION_PROCESSING = "PROCESSING";

}
