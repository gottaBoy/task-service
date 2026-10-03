package net.ibizsys.model.control.toolbar;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;


/**
 * 实体工具栏项对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSDEToolbarItem extends IPSModelObject {

	/**
	 * 项类型:实体界面行为
	 */
	public final static String TBITEMTYPE_DEUIACTION = "DEUIACTION";

	/**
	 * 项类型:分割线
	 */
	public final static String TBITEMTYPE_SEPERATOR = "SEPERATOR";

	/**
	 * 项类型:分组项
	 */
	public final static String TBITEMTYPE_ITEMS = "ITEMS";

	/**
	 * 项类型:直接内容项
	 */
	public final static String TBITEMTYPE_RAWITEM = "RAWITEM";


	/**
	 * 显示模式:图标+短词
	 */
	public final static String SHOWMODE_ICONANDSHORTWORD = "ICONANDSHORTWORD";

	/**
	 * 显示模式:图标
	 */
	public final static String SHOWMODE_ICON = "ICON";

	/**
	 * 显示模式:短词
	 */
	public final static String SHOWMODE_SHORTWORD = "SHORTWORD";

	

	/**
	 * 获取标题
	 * 
	 * @return
	 */
	String getCaption();

	/**
	 * 获取分类类型，具体参考 SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItem.TBITEMTYPE_XXX 定义
	 * 
	 * @return
	 */
	String getItemType();

	

	/**
	 * 是否有效
	 * 
	 * @return
	 */
	boolean isValid() throws Exception;

	/**
	 * 获取工具栏对象
	 * 
	 * @return
	 */
	IPSDEToolbar getPSDEToolbar();

	/**
	 * 是否显示标题
	 * 
	 * @return
	 */
	boolean isShowCaption();

	/**
	 * 是否显示图标
	 * 
	 * @return
	 */
	boolean isShowIcon();

	/**
	 * 获取工具提示
	 * 
	 * @return
	 */
	String getTooltip();

	/**
	 * 获取系统图标对象
	 * 
	 * @return
	 */
	IPSSysImage getPSSysImage();

	/**
	 * 获取样式表对象
	 * 
	 * @return
	 */
	IPSSysCss getPSSysCss();

	/**
	 * 获取父工具栏项
	 * 
	 * @return
	 */
	IPSDEToolbarItem getParentPSDEToolbarItem();


	/**
	 * 获取标题语言资源
	 * 
	 * @return
	 */
	IPSLanguageRes getCapPSLanguageRes();

	/**
	 * 获取提示语言资源
	 * 
	 * @return
	 */
	IPSLanguageRes getTooltipPSLanguageRes();
	
	

	
	/**
	 * 获取控件宽度
	 * 
	 * @return
	 */
	double getWidth();

	/**
	 * 获取控件高度
	 * 
	 * @return
	 */
	double getHeight();
}
