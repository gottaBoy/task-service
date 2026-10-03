package net.ibizsys.paas.view;

import java.util.ArrayList;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.ISystemModelObject;


/**
 * 视图消息组模型
 * 
 * @author Administrator
 *
 */
public interface IViewMsgGroupModel extends IViewMsgGroup,ISystemModelObject {

	/**
	 * 初始化
	 * @param iSystemModel
	 */
	void init(ISystemModel iSystemModel)  throws Exception;
	
	/**
	 * 获取唯一标记
	 * @return
	 */
	String getUniqueTag();
	
	
	/**
	 * 注册视图消息模型
	 * 
	 * @param iViewMsgModel
	 * @throws Exception
	 */
	void registerViewMsgModel(IViewMsgModel iViewMsgModel) throws Exception;


	
	
	/**
	 * 填充视图消息集合
	 * 
	 * @param viewMessageList
	 * @param iViewController 
	 * @throws Exception
	 */
	void fillViewMessages(IViewController iViewController,ArrayList<IViewMessage> viewMessageList) throws Exception;

}
