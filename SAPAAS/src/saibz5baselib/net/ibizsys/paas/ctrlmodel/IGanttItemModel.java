package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.control.gantt.IGanttItem;
import net.ibizsys.paas.control.gantt.IGanttItemDataItem;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.ctrlhandler.IGanttItemFetchContext;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDataTable;

/**
 * 甘特部件项模型接口
 * 
 * @author Administrator
 *
 */
public interface IGanttItemModel extends IModelBase {
	
	/**
	 * 获取甘特模型
	 * @return
	 */
	IGanttModel getGanttModel();
	
	/**
	 * 获取实体名称
	 * 
	 * @return
	 */
	String getDEName();
	
	/**
	 * 填充结果
	 * 
	 * @param iGanttItemFetchContext
	 * @param calendarItemList
	 * @param dt
	 * @throws Exception
	 */
	void fillFetchResult(IGanttItemFetchContext iGanttItemFetchContext, ArrayList<IGanttItem> calendarItemList, IDataTable dt) throws Exception;


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
	 * 获取指定甘特项数据项
	 * @param strName
	 * @return
	 * @throws Exception
	 */
	IGanttItemDataItem getGanttItemDataItem(String strName) throws Exception;
	
	
	/**
	 * 获取甘特项数据项集合
	 * @return
	 */
	Iterator<IGanttItemDataItem> getGanttItemDataItems();
	
	
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
	 * 获取建立的实体行为名称
	 * 
	 * @return
	 */
	String getCreateDEActionName();

	/**
	 * 获取建立的数据访问行为
	 * 
	 * @return
	 */
	String getCreateDataAccessAction();
	
	
	/**
	 * 获取更新的实体行为名称
	 * 
	 * @return
	 */
	String getUpdateDEActionName();

	/**
	 * 获取更新的数据访问行为
	 * 
	 * @return
	 */
	String getUpdateDataAccessAction();
	
	
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
	 * 获取开始时间属性
	 * @return
	 */
	String getBeginTimeField();
	
	
	
	/**
	 * 获取结束时间属性
	 * @return
	 */
	String getEndTimeField();
	
	
	
	
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
	 * 获取父ID属性
	 * 
	 * @return
	 */
	String getPIdField();
	
	/**
	 * 获取排序值属性
	 * @return
	 */
	String getOrderValueField();
	
	/**
	 * 获取级别属性
	 * @return
	 */
	String getLevelField();
	
	/**
	 * 获取总量属性
	 * @return
	 */
	String getTotalField();
	
	/**
	 * 获取完成量属性
	 * @return
	 */
	String getFinishField();
	
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
	IGanttItem getGanttItem(IDataObject iDataObject, boolean bUpdate) throws Exception;
}
