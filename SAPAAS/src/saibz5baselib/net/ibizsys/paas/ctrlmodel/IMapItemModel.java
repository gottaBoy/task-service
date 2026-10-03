package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.control.map.IMapItem;
import net.ibizsys.paas.control.map.IMapItemDataItem;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.ctrlhandler.IMapItemFetchContext;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDataTable;

/**
 * 地图部件项模型接口
 * 
 * @author Administrator
 *
 */
public interface IMapItemModel extends IModelBase {
	
	/**
	 * 获取地图模型
	 * @return
	 */
	IMapModel getMapModel();
	
	/**
	 * 获取实体名称
	 * 
	 * @return
	 */
	String getDEName();
	
	/**
	 * 填充结果
	 * 
	 * @param iMapItemFetchContext
	 * @param calendarItemList
	 * @param dt
	 * @throws Exception
	 */
	void fillFetchResult(IMapItemFetchContext iMapItemFetchContext, ArrayList<IMapItem> calendarItemList, IDataTable dt) throws Exception;


	/**
	 * 获取图标样式
	 * 
	 * @return
	 */
	String getIconCls();
	
	
	/**
	 * 获取图标路径
	 * @return
	 */
	String getIconPath();
	

	/**
	 * 获取节点类型
	 * 
	 * @return
	 */
	String getItemType();

	
	/**
	 * 获取指定地图项数据项
	 * @param strName
	 * @return
	 * @throws Exception
	 */
	IMapItemDataItem getMapItemDataItem(String strName) throws Exception;
	
	
	/**
	 * 获取地图项数据项集合
	 * @return
	 */
	Iterator<IMapItemDataItem> getMapItemDataItems();
	
	
	/**
	 * 获取实体数据集合名称
	 * 
	 * @return
	 */
	String getDEDataSetName();


	/**
	 * 获取ID属性
	 * 
	 * @return
	 */
	String getIdField();

	/**
	 * 获取文本属性
	 * 
	 * @return
	 */
	String getTextField();

	/**
	 * 获取图标属性
	 * 
	 * @return
	 */
	String getIconField();

	/**
	 * 获取删除的实体行为名称
	 * 
	 * @return
	 */
	String getRemoveDEActionName();

	/**
	 * 获取删除的数据访问行为
	 * 
	 * @return
	 */
	String getRemoveDataAccessAction();

	
	
	/**
	 * 获取上下文数据计算逻辑标识
	 * @return
	 */
	String getActiveDataDELogicId();

	
	/**
	 * 获取提示属性
	 * @return
	 */
	String getTipsField();
	
	
	
	/**
	 * 获取内容属性
	 * @return
	 */
	String getContentField();
	
	
	
	/**
	 * 获取经度属性
	 * @return
	 */
	String getLongitudeField();
	
	
	
	/**
	 * 获取维度属性
	 * @return
	 */
	String getLatitudeField();
	
	
	
	/**
	 * 获取高度属性
	 * @return
	 */
	String getAltitudeField();
	
	
	
	/**
	 * 获取字体颜色属性
	 * @return
	 */
	String getColorField();
	
	
	
	/**
	 * 获取背景颜色属性
	 * @return
	 */
	String getBKColorField();
	
	
	/**
	 * 获取最大项数量
	 * @return
	 */
	int getMaxSize();
	
	
	
	/**
	 * 获取默认字体颜色
	 * @return
	 */
	String getColor();
	
	
	
	/**
	 * 获取默认背景颜色
	 * @return
	 */
	String getBKColor();
	
	
	/**
	 * 获取边框颜色
	 * @return
	 */
	String getBorderColor();
	
	
	/**
	 * 获取边框宽度
	 * @return
	 */
	int getBorderWidth();
	
	
	/**
	 * 获取半径
	 * @return
	 */
	int getRadius();
	
	/**
	 * 填充数据实体对象
	 * 
	 * @param iDataObject 数据实体对象
	 * @param bIgnoreEmpty 是否忽略空检查
	 * @param formItemErrors 表单项错误集合
	 * @return
	 */
	void fillInputValues(IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty) throws Exception;
	
	
	
	
	
	/**
	 * 填充输出数据
	 * @param iDataObject
	 * @param bUpdate
	 * @throws Exception
	 */
	IMapItem getMapItem(IDataObject iDataObject, boolean bUpdate) throws Exception;
}
