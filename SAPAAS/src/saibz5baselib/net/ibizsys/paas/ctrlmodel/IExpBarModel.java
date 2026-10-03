package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.expbar.ExpBarRootItem;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 导航栏部件模型接口
 * 
 * @author lionlau
 *
 */
public interface IExpBarModel extends ICtrlModel {
	/**
	 * 分区名称
	 */
	public final static String CTRLPARAM_SECTIONNAME = "SECTION.NAME";

	/**
	 * 填充数据返回结果
	 * 
	 * @param fetchResult
	 * @throws Exception
	 */
	void fillFetchResult(MDAjaxActionResult fetchResult) throws Exception;

	/**
	 * 获取根项
	 * 
	 * @return
	 */
	ExpBarRootItem getRootItem();
}
