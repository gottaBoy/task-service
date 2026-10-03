package net.ibizsys.paas.view;

import java.util.ArrayList;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.IModelBase2;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.ISystemModelObject;

/**
 * 视图消息模型
 * @author Administrator
 *
 */
public interface IViewMsgModel extends IViewMessage,IModelBase2,ISystemModelObject {
	
	/**
	 * 动态模式（静态）
	 */
	final static int DYNAMICMODE_STATIC = 0;

	/**
	 * 动态模式（实体数据集合）
	 */
	final static int DYNAMICMODE_DEDATASET = 1;
	
	
	/**
	 * 视图标识
	 */
	final static String ACTIVEDATA_VIEWID = "SRFVIEWID";
	
	
	/**
	 * 视图类
	 */
	final static String ACTIVEDATA_VIEWCLS = "SRFVIEWCLS";
	
	
	/**
	 * 实体模型标识
	 */
	final static String ACTIVEDATA_DEID = "SRFDEID";
	
	
	/**
	 * 实体模型名称
	 */
	final static String ACTIVEDATA_DENAME = "SRFDENAME";
	
	/**
	 * 数据标识
	 */
	final static String ACTIVEDATA_KEY = "SRFKEY";
	
	
//	/**
//	 * 1：N关系标识
//	 */
//	final static String ACTIVEDATA_DER1NID = "SRFDER1NID";
//
//	/**
//	 * 索引关系标识
//	 */
//	final static String ACTIVEDATA_DERINDEXID = "SRFDERINDEXID";
//
//	/**
//	 * 1:1关系标识
//	 */
//	final static String ACTIVEDATA_DER11ID = "SRFDER11ID";
	
	
	/**
	 * 关系标识（名称）
	 */
	final static String ACTIVEDATA_DERID = "SRFDERID";

	
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
	 * 获取排序值
	 * @return
	 */
	int getOrderValue();
	
	
	/**
	 * 填充视图消息集合
	 * @param iViewController 视图控制器
	 * @param viewMessageList
	 * @return 填充数量
	 * @throws Exception
	 */
	int fillViewMessages(IViewController iViewController,ArrayList<IViewMsgModel> viewMessageList) throws Exception;
}
