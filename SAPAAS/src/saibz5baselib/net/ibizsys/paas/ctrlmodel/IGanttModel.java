package net.ibizsys.paas.ctrlmodel;

import java.util.Iterator;

import net.ibizsys.paas.control.gantt.IGanttItem;
import net.ibizsys.paas.ctrlhandler.IGanttItemFetchContext;


/**
 * 甘特部件模型接口
 * 
 * @author lionlau
 *
 */
public interface IGanttModel extends ICtrlModel {
	
	
	/**
	 * 节点分隔符号
	 */
	static final String ITEM_SEPARATOR = ";";
	
	
	/**
	 * 获取指定甘特项模型
	 * @param strGanttItemModelId
	 * @return
	 * @throws Exception
	 */
	IGanttItemModel getGanttItemModel(String strGanttItemModelId) throws Exception;
	
	
	
	/**
	 * 获取甘特项模型集合
	 * @return
	 */
	Iterator<IGanttItemModel> getGanttItemModels();
	
	
	
	/**
	 * 是否输出指定甘特项
	 * @param iGanttItemFetchContext
	 * @param iGanttItem
	 * @return
	 * @throws Exception
	 */
	boolean isOutputGanttItem(IGanttItemFetchContext iGanttItemFetchContext, IGanttItem iGanttItem) throws Exception ;
	
	
	
	
	/**
	 * 是否输出指定甘特项模型
	 * @param iGanttItemFetchContext
	 * @param iGanttItem
	 * @return
	 * @throws Exception
	 */
	boolean isOutputGanttItemModel(IGanttItemFetchContext iGanttItemFetchContext, IGanttItemModel iGanttItemModel) throws Exception ;
}
