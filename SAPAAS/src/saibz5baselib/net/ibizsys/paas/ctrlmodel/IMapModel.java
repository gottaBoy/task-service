package net.ibizsys.paas.ctrlmodel;

import java.util.Iterator;

import net.ibizsys.paas.control.map.IMapItem;
import net.ibizsys.paas.ctrlhandler.IMapItemFetchContext;


/**
 * 地图部件模型接口
 * 
 * @author lionlau
 *
 */
public interface IMapModel extends ICtrlModel {
	
	
	/**
	 * 节点分隔符号
	 */
	static final String ITEM_SEPARATOR = ";";
	
	
	/**
	 * 获取指定地图项模型
	 * @param strMapItemModelId
	 * @return
	 * @throws Exception
	 */
	IMapItemModel getMapItemModel(String strMapItemModelId) throws Exception;
	
	
	
	/**
	 * 获取地图项模型集合
	 * @return
	 */
	Iterator<IMapItemModel> getMapItemModels();
	
	
	
	/**
	 * 是否输出指定地图项
	 * @param iMapItemFetchContext
	 * @param iMapItem
	 * @return
	 * @throws Exception
	 */
	boolean isOutputMapItem(IMapItemFetchContext iMapItemFetchContext, IMapItem iMapItem) throws Exception ;
	
	
	
	
	/**
	 * 是否输出指定地图项模型
	 * @param iMapItemFetchContext
	 * @param iMapItem
	 * @return
	 * @throws Exception
	 */
	boolean isOutputMapItemModel(IMapItemFetchContext iMapItemFetchContext, IMapItemModel iMapItemModel) throws Exception ;
}
