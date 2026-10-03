package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.core.IDynaModelJsonExporter;
import net.ibizsys.paas.core.IDynaModelJsonLoader;
import net.ibizsys.paas.ctrlmodel.form.IDynaFormDetailModel;
import net.ibizsys.paas.ctrlmodel.form.IDynaFormPageModel;

/**
 * 动态表单模型对象接口
 * @author Administrator
 *
 */
public interface IDynaFormModel extends IFormModel,IDynaCtrlModel,IDynaModelJsonExporter,IDynaModelJsonLoader {

	/**
	 * 表单分页集合节点
	 */
	public final static String ATTR_PAGES = "pages";
	
	/**
	 * 表单布局模式
	 */
	public final static String ATTR_LAYOUTMODE = "layoutmode";
	
	/**
	 * 表单样式
	 */
	public final static String ATTR_FORMSTYLE = "formstyle";
	
	/**
	 * 表单功能模式
	 */
	public final static String ATTR_FORMFUNCMODE = "formfuncmode";
	
	
	/**
	 * 表单隐藏项集合节点
	 */
	public final static String ATTR_HIDDENS = "hiddens";
	
	
	/**
	 * 获取表单分页对象集合
	 * @return
	 */
	java.util.Iterator<IDynaFormPageModel> getPageModels();
	
	
	/**
	 * 建立对应类型的表单成员对象
	 * @param strType
	 * @return
	 * @throws Exception
	 */
	IDynaFormDetailModel createDynaFormDetailModel(String strType)throws Exception;
	
	
	
	/**
	 * 获取源表单模型对象
	 * @return
	 */
	IFormModel getSourceFormModel();
	
	
	
	
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
	 * 获取表单样式
	 * @return
	 */
	String getFormStyle();
}
