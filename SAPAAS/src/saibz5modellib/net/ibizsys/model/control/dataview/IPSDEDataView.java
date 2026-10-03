package net.ibizsys.model.control.dataview;

import java.util.Iterator;

import net.ibizsys.model.control.IPSMDAjaxControl;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.paas.control.dataview.IDataView;

/**
 * 实体数据视图对象接口
 * @author lionlau
 *
 */
public interface IPSDEDataView extends IPSMDAjaxControl,IDataView
{
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.grid.IDataView#getDataViewDataItems()
	 */
	Iterator<IPSDEDataViewDataItem> getPSDEDataViewDataItems();

	
	/**
	 * 是否支持分页工具栏
	 * @return
	 */
	boolean isEnablePagingBar();
	
	
	
	/**
	 * 获取分页大小
	 * @return
	 */
	int getPagingSize();
	
	
	
	/**
	 * 是否为单项选择
	 * @return
	 */
	boolean isSingleSelect();
	
	
//	/**
//	 * 获取数据视图绘制器
//	 * @return
//	 */
//	IPSSysPFPlugin getPSSysPFPlugin();
//	
//	
//	
//	/**
//	 * 获取数据视图项绘制器
//	 * @return
//	 */
//	IPSSysPFPlugin getItemPSSysPFPlugin();
	
	
	/**
	 * 获取二级排序属性
	 * @return
	 */
	IPSDEField getMinorSortPSDEF();
	

	
	/**
	 * 获取二级排序方向
	 * @return
	 */
	String getMinorSortDir();
	
	
	/**
	 * 禁用排序
	 * @return
	 */
	boolean isNoSort();
	
	
	
	/**
	 * 是否附加实体数据项
	 * @return
	 */
	boolean isAppendDEItems();
	
	
	/**
	 * 获取部件数据集合
	 * @return
	 */
	IPSDEDataSet getPSDEDataSet();
	
	
	
//	/**
//	 * 获取无值显示内容语言资源对象
//	 * @return
//	 */
//	IPSLanguageRes getEmptyTextPSLanguageRes();
	
	
	/**
	 * 获取无值显示内容
	 * @return
	 */
	String getEmptyText();
	
	
//	/**
//	 * 获取项的系统布局面板
//	 * @return
//	 */
//	IPSSysLayoutPanel getItemPSSysLayoutPanel();
}
