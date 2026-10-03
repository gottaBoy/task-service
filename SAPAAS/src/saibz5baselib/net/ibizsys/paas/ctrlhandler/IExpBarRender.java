package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;

import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.ctrlmodel.IExpBarModel;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 
 * 导航栏后台处理绘制器接口
 * 
 * @author Administrator
 *
 */
public interface IExpBarRender extends ICtrlRender {
	/**
	 * 获取填充结果
	 * 
	 * @param IExpBarModel
	 * @param fetchResult
	 * @throws Exception
	 */
	void fillFetchResult(IExpBarModel iExpBarModel, MDAjaxActionResult fetchResult) throws Exception;

	/**
	 * 获取填充结果
	 * 
	 * @param treeNodeList
	 * @param fetchResult
	 * @throws Exception
	 */
	void fillFetchResult(ArrayList<ITreeNode> treeNodeList, MDAjaxActionResult fetchResult) throws Exception;
}
