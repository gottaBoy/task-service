package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;

import net.ibizsys.paas.control.map.IMapItem;
import net.ibizsys.paas.ctrlmodel.IMapModel;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 地图视图绘制器接口
 * 
 * @author Administrator
 * 
 */
public interface IMapRender extends IMDCtrlRender {

	/**
	 * 获取传入的地图项类型
	 * @param iWebContext
	 * @return
	 * @throws Exception
	 */
	String getItemType(IWebContext iWebContext) throws Exception;
	
	
	/**
	 * 获取传入的地图项标识
	 * @param iWebContext
	 * @return
	 * @throws Exception
	 */
	String getItemId(IWebContext iWebContext) throws Exception;
	
	
	/**
	 * 填充数据获取结果
	 * @param iMapModel
	 * @param fetchResult
	 * @param calendarItemList
	 * @throws Exception
	 */
	void fillFetchResult(IMapModel iMapModel, MDAjaxActionResult fetchResult, ArrayList<IMapItem> calendarItemList) throws Exception;
	
	
	
	
	
	/**
	 * 填充数据获取结果
	 * @param iMapModel
	 * @param fetchResult
	 * @param iMapItem
	 * @throws Exception
	 */
	void fillItemResult(IMapModel iMapModel, MDAjaxActionResult fetchResult, IMapItem iMapItem) throws Exception;
}
