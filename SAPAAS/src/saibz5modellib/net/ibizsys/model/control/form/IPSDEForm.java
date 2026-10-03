package net.ibizsys.model.control.form;

import java.util.Iterator;

import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.paas.control.form.IForm;

/**
 * 实体表单接口对象
 * @author lionlau
 *
 */
public interface IPSDEForm extends IPSAjaxControl,IForm
{
	//定义功能模式代码表

	/**
	 *表单预置功能类型：流程操作表单
	 */
	public final static String FORMFUNCMODE_WFACTION = "WFACTION" ;
	
	/**
	 *表单预置功能类型：向导表单
	 */
	public final static String FORMFUNCMODE_WIZARDFORM = "WIZARDFORM" ;
	
	

	//定义表单样式代码表

	/**
	*	表单样式：搜索栏
	*/
	public final static String FORMSTYLE_SEARCHBAR = "SEARCHBAR" ;

	/**
	*表单样式：搜索栏2
	*/
	public final static String FORMSTYLE_SEARCHBAR2 = "SEARCHBAR2" ;

	/**
	*表单样式：移动端搜索栏
	*/
	public final static String FORMSTYLE_MOBSEARCHBAR = "MOBSEARCHBAR" ;

	/**
	*表单样式：移动端搜索栏2
	*/
	public final static String FORMSTYLE_MOBSEARCHBAR2 = "MOBSEARCHBAR2" ;

	
	
	/**
	 * 获取表单分页集合
	 * @return
	 */
	Iterator<IPSDEFormPage> getPSDEFormPages();
	

	
	/**
	 * 获取表单分页数量
	 * @return
	 */
	int getPSDEFormPageCount();
	
	
	/**
	 * 获取指定表单分页对象
	 * @param nIndex
	 * @return
	 */
	IPSDEFormPage getPSDEFormPage(int nIndex)throws Exception;
	
	
	/**
	 * 获取表单项对象集合
	 * @return
	 */
	Iterator<IPSDEFormItem> getPSDEFormItems();
	
	
	
	/**
	 * 获取表单成员对象集合
	 * @return
	 */
	Iterator<IPSDEFormDetail> getPSDEFormDetails();
	
	
	
	/**
	 * 获取指定表单项
	 * @param strPSDEFormItemId
	 * @return
	 * @throws Exception
	 */
	IPSDEFormItem getPSDEFormItem(String strPSDEFormItemId)throws Exception;
	
	
	/**
	 * 获取默认的标签宽度
	 * @return
	 */
	int getDefaultLabelWidth();
	
	
	
	/**
	 * 是否显示分页头部
	 * @return
	 */
	boolean isNoTabHeader();
	
	
	
	
	/**
	 * 获取表单宽度
	 * @return
	 */
	double getFormWidth();
	
	
	
	
	/**
	 * 获取表单关系部件对象集合
	 * @return
	 */
	Iterator<IPSDEFormDRUIPart> getPSDEFormDRUIParts();
	
	
	
//	/**
//	 * 获取表单默认分组外边距
//	 * @param 是否显示标题
//	 * @return
//	 */
//	IPSThickness getDefaultGroupMargin(boolean bShowCaption);
//	
//	
//	
//	/**
//	 * 获取表单默认分组外边距
//	 * @param 是否显示标题
//	 * @return
//	 */
//	IPSThickness getDefaultGroupPadding(boolean bShowCaption);
	
	
	/**
	 * 获取表单项更新处理集合
	 * @return
	 */
	java.util.Iterator<IPSDEFormItemUpdate> getPSDEFormItemUpdates();
	
	
	/**
	 * 获取指定的表单项更新
	 * @param strPSDEFormItemUpdateId
	 * @return
	 * @throws Exception
	 */
	IPSDEFormItemUpdate getPSDEFormItemUpdate(String strPSDEFormItemUpdateId) throws Exception;
	
	
//	/**
//	 * 获取应用技术类型
//	 * @return
//	 */
//	String getPFType();
	
	
	/**
	 * 获取首列标签列数量
	 * @return
	 */
	int getFirstLabelColSpan();
	
	

	
	/**
	 * 获取默认的标签单元格合并数量
	 * @return
	 */
	int getLabelColSpan();
	
	
	
	/**
	 * 获取默认的控件单元格合并数量
	 * @return
	 */
	int getCtrlColSpan();
	
	
	
	/**
	 * 获取布局模式
	 * @return
	 */
	String getLayoutMode();
	
	
	
	/**
	 * 获取表单功能模式
	 * @return
	 */
	String getFormFuncMode();
	
	
	/**
	 * 获取表单项值规则处理集合
	 * @return
	 */
	java.util.Iterator<IPSDEFormItemVR> getPSDEFormItemVRs();
	
	
	/**
	 * 获取指定的表单项值规则
	 * @param strPSDEFormItemVRId
	 * @return
	 * @throws Exception
	 */
	IPSDEFormItemVR getPSDEFormItemVR(String strPSDEFormItemVRId) throws Exception;
	
	
	/**
	 * 获取表单样式，值参考 SA.SRFDA.PS.Core.Control.Form.IPSDEForm.FORMSTYLE_XXX 定义
	 * @return
	 */
	String getFormStyle();
}
