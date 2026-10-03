package net.ibizsys.model.control.form;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;


/**
 * 表单项成员对象接口
 * 
 * @author Administrator
 *
 */
public interface IPSDEFormDetail extends IPSModelObject {
	/**
	 * 表单成员类型：表单分页
	 */
	final String DETAILTYPE_FORMPAGE = "FORMPAGE";

	/**
	 * 表单成员类型：分页部件
	 */
	final String DETAILTYPE_TABPANEL = "TABPANEL";

	/**
	 * 表单成员类型：分页面板
	 */
	final String DETAILTYPE_TABPAGE = "TABPAGE";

	/**
	 * 表单成员类型：表单项
	 */
	final String DETAILTYPE_FORMITEM = "FORMITEM";

	/**
	 * 表单成员类型：用户控件
	 */
	final String DETAILTYPE_USERCONTROL = "USERCONTROL";

	/**
	 * 表单成员类型：表单部件
	 */
	final String DETAILTYPE_FORMPART = "FORMPART";

	/**
	 * 表单成员类型：分组面板
	 */
	final String DETAILTYPE_GROUPPANEL = "GROUPPANEL";

	/**
	 * 表单成员类型：数据关系界面
	 */
	final String DETAILTYPE_DRUIPART = "DRUIPART";

	/**
	 * 表单成员类型：按钮
	 */
	final String DETAILTYPE_BUTTON = "BUTTON";

	/**
	 * 表单成员类型：直接内容
	 */
	final String DETAILTYPE_RAWITEM = "RAWITEM";

	// 定义内置样式代码表

	/**
	 * 默认样式
	 */
	final static String DETAILSTYLE_DEFAULT = "DEFAULT";

	/**
	 * 样式2
	 */
	final static String DETAILSTYLE_STYLE2 = "STYLE2";

	/**
	 * 样式3
	 */
	final static String DETAILSTYLE_STYLE3 = "STYLE3";

	/**
	 * 样式4
	 */
	final static String DETAILSTYLE_STYLE4 = "STYLE4";

	// 定义位置边缘布局位置代码表

	/**
	 * 边缘布局位置：上方
	 */
	final static String BORERLAYOUTPOS_NORTH = "NORTH";

	/**
	 * 边缘布局位置：左侧
	 */
	final static String BORERLAYOUTPOS_WEST = "WEST";

	/**
	 * 边缘布局位置：右侧
	 */
	final static String BORERLAYOUTPOS_EAST = "EAST";

	/**
	 * 边缘布局位置：下方
	 */
	final static String BORERLAYOUTPOS_SOUTH = "SOUTH";

	/**
	 * 边缘布局位置：中间
	 */
	final static String BORERLAYOUTPOS_CENTER = "CENTER";

	

	/**
	 * 获取代码名称
	 * 
	 * @return
	 */
	String getCodeName();

	

	/**
	 * 获取部件唯一标识
	 * 
	 * @return
	 */
	String getUniqueId();

	/**
	 * 获取父对象
	 * 
	 * @return
	 */
	IPSDEFormDetail getParentPSDEFormDetail();

	/**
	 * 获取标题
	 * 
	 * @return
	 */
	String getCaption();

	/**
	 * 是否显示标题
	 * 
	 * @return
	 */
	boolean isShowCaption();

//	/**
//	 * 获取内边距
//	 * 
//	 * @return
//	 */
//	IPSThickness getPadding();
//
//	/**
//	 * 获取外边距
//	 * 
//	 * @return
//	 */
//	IPSThickness getMargin();

	/**
	 * 获取实体表单对象
	 * 
	 * @return
	 */
	IPSDEForm getPSDEForm();

	

	/**
	 * 获取表单成员类型，值参考 SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail.DETAILTYPE_XXX
	 * 定义
	 * 
	 * @return
	 */
	String getDetailType();

	/**
	 * 获取内容宽度
	 * 
	 * @return
	 */
	double getContentWidth();

	/**
	 * 获取内容高度
	 * 
	 * @return
	 */
	double getContentHeight();

	/**
	 * 获取宽度
	 * 
	 * @return
	 */
	double getWidth();

	/**
	 * 获取高度
	 * 
	 * @return
	 */
	double getHeight();

	

	/**
	 * 父容器布局模式
	 * 
	 * @return
	 */
	String getParentLayoutMode();

	/**
	 * 获取表单成员逻辑
	 * 
	 * @param strCat
	 * @return
	 * @throws Exception
	 */
	IPSDEFDGroupLogic getPSDEFDGroupLogic(String strCat) throws Exception;

	/**
	 * 获取CSS样式
	 * 
	 * @return
	 */
	String getCssStyle();

	/**
	 * 获取当前单元格列扩展数量
	 * 
	 * @return
	 */
	int getColSpan() throws Exception;

	/**
	 * 获取当前单元格行扩展数量
	 * 
	 * @return
	 */
	int getRowSpan() throws Exception;

	/**
	 * 
	 * @return
	 */
	int getColXS();

	/**
	 * @return
	 */
	int getColSM();

	/**
	 * @return
	 */
	int getColMD();

	/**
	 * @return
	 */
	int getColLG();

	/**
	 * @return
	 */
	int getColXSOffset();

	/**
	 * @return
	 */
	int getColSMOffset();

	/**
	 * @return
	 */
	int getColMDOffset();

	/**
	 * 获取列偏移（大型界面）
	 * 
	 * @return
	 */
	int getColLGOffset();

	/**
	 * 获取列布局的CSS
	 * 
	 * @return
	 */
	String getColCssClass();

	/**
	 * 获取表单成员的系统样式，一般用于容器样式
	 * 
	 * @return
	 */
	IPSSysCss getPSSysCss();

	/**
	 * 获取系统图片资源
	 * 
	 * @return
	 */
	IPSSysImage getPSSysImage();

//	/**
//	 * 获取系统计数器
//	 * 
//	 * @return
//	 */
//	IPSSysCounter getPSSysCounter();
//


	/**
	 * 获取标题系统样式
	 * 
	 * @return
	 */
	IPSSysCss getLabelPSSysCss();

	/**
	 * 获取标题语言资源对象
	 * 
	 * @return
	 */
	IPSLanguageRes getCapPSLanguageRes();

	/**
	 * 获取标题语言资源标识
	 * 
	 * @return
	 */
	String getCapLanResTag();

	/**
	 * 获取固定列宽
	 * 
	 * @return
	 */
	int getColWidth();

	/**
	 * 获取根成员对象，一般为表单分页对象
	 * 
	 * @return
	 */
	IPSDEFormDetail getRootPSDEFormDetail();

	/**
	 * 获取用户标记
	 * 
	 * @return
	 */
	String getUserTag();

	/**
	 * 获取用户标记2
	 * 
	 * @return
	 */
	String getUserTag2();

	/**
	 * 获取成员样式，值参考 SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail.DETAILSTYLE_XXX
	 * 定义
	 * 
	 * @return
	 */
	String getDetailStyle();

	/**
	 * 获取边框布局位置，值参考 SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail.BORERLAYOUTPOS_XXX 定义
	 * 
	 * @return
	 */
	String getBorderLayoutPos();

	
	

}
