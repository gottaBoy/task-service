package net.ibizsys.model.app.view;

import net.ibizsys.model.IPSModelJsonExporter;
import net.ibizsys.model.core.IPSModelObject;

import com.fasterxml.jackson.databind.node.ObjectNode;


/**
 * 应用视图引用对象接口
 * @author lionlau
 *
 */
public interface IPSAppViewRef extends IPSModelObject,IPSModelJsonExporter
{

	
	/**
	 * 获取当前视图
	 * @return
	 */
	IPSAppView getPSAppView();
	
	
	
	/**
	 * 获取引用视图标识
	 * @return
	 */
	String getRefPSAppViewId();
	
	
	
	/**
	 * 获取引用视图对象
	 * @return
	 */
	IPSAppView getRefPSAppView() throws Exception;
	
	
	/**
	 * 获取视图打开方式
	 * @return
	 */
	String getOpenMode();
	
	
	
	/**
	 * 获取嵌入标识
	 * @return
	 */
	String getEmbedId();
	
	
	
	/**
	 * 获取界面高度
	 * @return
	 */
	int getHeight();

	
	
	/**
	 * 获取界面宽度
	 * @return
	 */
	int getWidth();
	
	
	
	/**
	 * 获取附加的视图参数
	 * @param bCreate 不存在时是否创建
	 * @return
	 */
	ObjectNode getViewParam(boolean bCreate);
	
	
	/**
	 * 获取附加的视图参数
	 * @return
	 */
	ObjectNode getViewParam();
	
	
	/**
	 * 获取附加的视图参数，与getViewParam相同
	 * @param bCreate 不存在时是否创建
	 * @return
	 */
	ObjectNode getViewParamJO(boolean bCreate);
	
	
	/**
	 * 获取附加的视图参数，与getViewParam相同
	 * @return
	 */
	ObjectNode getViewParamJO();
	
	
	/**
	 * 获取引用视图父模式Json对象
	 * @param bCreate 不存在时是否创建
	 * @return
	 */
	ObjectNode getParentModeJO(boolean bCreate);
	
	
	/**
	 * 获取引用视图父模式Json对象
	 * @return
	 */
	ObjectNode getParentModeJO();
	
	/**
	 * 获取引用视图父数据Json对象
	 * @param bCreate 不存在时是否创建
	 * @return
	 */
	ObjectNode getParentDataJO(boolean bCreate);
	
	/**
	 * 获取引用视图父数据Json对象
	 * @return
	 */
	ObjectNode getParentDataJO();
	
	
	/**
	 * 获取实际的视图标题
	 * @return
	 */
	String getRealTitle()throws Exception;
	
	
	
	/**
	 * 获取实际的视图宽度
	 * @param nDefault
	 * @return
	 * @throws Exception
	 */
	int getRealWidth(int nDefault)throws Exception;
	
	
	
	/**
	 * 获取实际的视图高度
	 * @param nDefault
	 * @return
	 * @throws Exception
	 */
	int getRealHeight(int nDefault)throws Exception;
	
	
	
	
	/**
	 * 获取实际的视图打开模式
	 * @return
	 * @throws Exception
	 */
	String getRealOpenMode()throws Exception;
	
	
//	/**
//	 * 获取抬头语言资源
//	 * @return
//	 */
//	IPSLanguageRes getTitlePSLanguageRes();
//	
//	
//	
//	/**
//	 * 获取抬头语言资源
//	 * @return
//	 */
//	IPSLanguageRes getRealTitlePSLanguageRes() throws Exception;
	
	
	
	/**
	 * 获取抬头语言资源标识
	 * @return
	 */
	String getRealTitleLanResTag()throws Exception;
	
	
	
	
	/**
	 * 获取引用模式说明
	 * @return
	 */
	String getRefModeDesc();
	
	

}
