package net.ibizsys.model.control.list;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.core.IPSModelObject;

/**
 * 列表项对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSListItem extends IPSModelObject {
	
	/**
	 * 列表项代码表数据转换模式：前台，直接送代码值至应用前端，由应用自行处理
	 */
	public final static String CLCONVERTMODE_FRONT = "FRONT";

	/**
	 * 列表项代码表数据转换模式：后台，由后台处理将代码值转换为文本直接送至前台。
	 */
	public final static String CLCONVERTMODE_BACKEND = "BACKEND";

	/**
	 * 定义列表项类型：文本项
	 */
	public final static String ITEMTYPE_TEXTITEM = "TEXTITEM";

	/**
	 * 定义列表项类型：操作项
	 */
	public final static String ITEMTYPE_ACTIONITEM = "ACTIONITEM";

	/**
	 * 定义列表项类型：数据项
	 */
	public final static String ITEMTYPE_DATAITEM = "DATAITEM";

	/**
	 * 定义水平对齐：左对齐
	 */
	public final static String ALIGN_LEFT = "LEFT";

	/**
	 * 定义水平对齐：居中
	 */
	public final static String ALIGN_CENTER = "CENTER";

	/**
	 * 定义水平对齐：右对齐
	 */
	public final static String ALIGN_RIGHT = "RIGHT";

	/**
	 * 获取标题
	 * 
	 * @return
	 */
	String getCaption();

//	/**
//	 * 获取标题语言资源对象
//	 * 
//	 * @return
//	 */
//	IPSLanguageRes getCapPSLanguageRes();

	/**
	 * 获取项类型，值参考 SA.SRFDA.PS.Core.Control.List.IPSListItem.ITEMTYPE_XXX 定义
	 * 
	 * @return
	 */
	String getItemType();

	/**
	 * 获取项位置
	 * 
	 * @return
	 */
	int getItemPos();

	/**
	 * 获取列表对象
	 * 
	 * @return
	 */
	IPSList getPSList();

	/**
	 * 获取数据字段集合
	 * 
	 * @return
	 */
	String[] getFields();

	/**
	 * 是否支持排序
	 * 
	 * @return
	 */
	boolean isEnableSort();

	/**
	 * 获取代码表
	 * 
	 * @return
	 */
	IPSCodeList getPSCodeList();

//	/**
//	 * 获取绘制插件
//	 * 
//	 * @return
//	 */
//	IPSSysPFPlugin getRenderPSSysPFPlugin();

	/**
	 * 获取宽度字符串
	 * 
	 * @return
	 */
	String getWidthString();

	/**
	 * 是否为隐藏数据项
	 * 
	 * @return
	 */
	boolean isHiddenDataItem();

	/**
	 * 获取水平对齐方式，值参考 SA.SRFDA.PS.Core.Control.List.IPSListItem.ALIGN_XXX 定义
	 * 
	 * @return
	 */
	String getAlign();

	/**
	 * 获取代码表转换模式，值参考 SA.SRFDA.PS.Core.Control.List.IPSListItem.CLCONVERTMODE_XXX
	 * 定义
	 * 
	 * @return
	 */
	String getCLConvertMode();

	/**
	 * 是否启用项权限控制
	 * 
	 * @return
	 */
	boolean isEnableItemPriv();

	/**
	 * 获取项权限标识
	 * 
	 * @return
	 */
	String getItemPrivId();
}
