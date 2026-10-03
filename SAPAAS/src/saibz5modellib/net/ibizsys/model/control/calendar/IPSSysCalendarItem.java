package net.ibizsys.model.control.calendar;

import java.util.Iterator;

import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
/* INTERNAL-BEGIN */

/* INTERNAL-END */

/**
 * 系统日历视图项接口
 * @author Administrator
 *
 */
public interface IPSSysCalendarItem extends IPSCalendarItem{


	/**
	 * 获取系统日历部件
	 * @return
	 */
	IPSSysCalendar getPSSysCalendar();
	
	
	
	/**
	 * 获取数据集合
	 * @return
	 */
	IPSDEDataSet getPSDEDataSet();
	
	
	/**
	 * 获取建立实体行为
	 * @return
	 */
	IPSDEAction getCreatePSDEAction();
	
	
	
	/**
	 * 获取建立实体行为权限标识
	 * @return
	 */
	IPSDEOPPriv getCreatePSDEOPPriv();
	
	
	/**
	 * 获取更新实体行为
	 * @return
	 */
	IPSDEAction getUpdatePSDEAction();
	
	
	
	/**
	 * 获取更新实体行为权限标识
	 * @return
	 */
	IPSDEOPPriv getUpdatePSDEOPPriv();
	
	

	
	
	
	/**
	 * 获取删除实体行为
	 * @return
	 */
	IPSDEAction getRemovePSDEAction();
	
	
	
	/**
	 * 获取删除实体行为权限标识
	 * @return
	 */
	IPSDEOPPriv getRemovePSDEOPPriv();
	
	

	
	
	/**
	 * 获取上下文数据转化逻辑
	 * @return
	 */
	IPSDELogic getActiveDataPSDELogic();
	
	
	
	/**
	 * 获取ID属性对象
	 * 
	 * @return
	 */
	IPSDEField getIdPSDEField();

	/**
	 * 获取文本属性对象
	 * 
	 * @return
	 */
	IPSDEField getTextPSDEField();

	/**
	 * 获取图标属性对象
	 * 
	 * @return
	 */
	IPSDEField getIconPSDEField();

	/**
	 * 获取内容属性对象
	 * 
	 * @return
	 */
	IPSDEField getContentPSDEField();
	
	
	/**
	 * 获取开始时间属性对象
	 * 
	 * @return
	 */
	IPSDEField getBeginTimePSDEField();
	
	
	/**
	 * 获取结束时间属性对象
	 * 
	 * @return
	 */
	IPSDEField getEndTimePSDEField();
	
	
	/**
	 * 获取字体颜色属性对象
	 * 
	 * @return
	 */
	IPSDEField getColorPSDEField();
	
	
	
	/**
	 * 获取背景颜色属性对象
	 * 
	 * @return
	 */
	IPSDEField getBKColorPSDEField();
	
	/**
	 * 获取提示信息属性对象
	 * 
	 * @return
	 */
	IPSDEField getTipsPSDEField();
	
	
	
	/**
	 * 获取日历项相关视图
	 * @return
	 */
	Iterator<IPSSysCalendarItemRV> getPSSysCalendarItemRVs();
}
