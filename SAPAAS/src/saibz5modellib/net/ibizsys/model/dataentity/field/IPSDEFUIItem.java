package net.ibizsys.model.dataentity.field;

import java.util.Properties;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.res.IPSSysImage;

/**
 * 属性界面项配置对象接口
 * @author lionlau
 *
 */
public interface IPSDEFUIItem extends IPSDEFieldObject,IPSModelObject
{
	/**
	*转换代码表模式：无
	*/
	public final static int OUTPUTCODELISTCONFIGMODE_NONE = 0 ;

	/**
	*转换代码表模式：只输出选择项
	*/
	public final static int OUTPUTCODELISTCONFIGMODE_SELECTEDONLY = 1 ;

	/**
	*转换代码表模式：输出子项
	*/
	public final static int OUTPUTCODELISTCONFIGMODE_INCLUDECHILD = 2 ;
	
	

	
	
	/**
	 * 获取数据项名称
	 * @return
	 */
	String getDataItemName();
	
	
	

	/**
	 * 获取标题
	 * @param strLanguage
	 * @return
	 */
	String getCaption(String strLanguage);
	
	
	
	
	/**
	 * 获取标题语言资源标识
	 * @return
	 */
	String getCapLanResTag();
	
	
//	/**
//	 * 获取标题的语言资源标识
//	 * @return
//	 */
//	IPSLanguageRes getCapPSLanguageRes();
	
	/**
	 * 获取编辑器类型
	 * @return
	 */
	String getEditorType();
	
	
	
	/**
	 * 获取编辑器样式
	 * @return
	 */
	String getEditorStyle();
	
	
	
	/**
	 * 是否允许空输入
	 * @return
	 */
	boolean isAllowEmpty();
	
	
	
	/**
	 * 获取代码表标识
	 * @return
	 */
	String getPSCodeListId();
	 

	/**
	 * 获取引用实体标识
	 * @return
	 */
	String getRefPSDEId();
	
	
	/**
	 * 获取引用实体名称
	 * @return
	 */
	String getRefPSDEName()throws Exception;
	
	
	
	/**
	 * 获取引用的实体（与getRefPSDataEntity() 功能一致）
	 * @return
	 * @throws Exception
	 */
	IPSDataEntity getRefPSDE() throws Exception;
	
	
	
	/**
	 * 获取引用实体自动填充标识
	 * @return
	 */
	String getRefPSDEACModeId();
	
	
	/**
	 * 获取引用实体自动填充名称 
	 * @return
	 */
	String getRefPSDEACModeName() throws Exception;
	
	
	/**
	 * 获取引用的实体自动填充模式
	 * @return
	 * @throws Exception
	 */
	IPSDEACMode getRefPSDEACMode() throws Exception;
	
	/**
	 * 获取引用实体单选选择视图标识
	 * @return
	 */
	String getRefPickupPSDEViewId();
	
	
	/**
	 * 获取引用实体单选选择视图名称
	 * @return
	 */
	String getRefPickupPSDEViewName();
	
	
	
	/**
	 * 获取引用实体多选选择视图标识
	 * @return
	 */
	String getRefMPickupPSDEViewId();
	
	
	/**
	 * 获取引用实体多选选择视图名称
	 * @return
	 */
	String getRefMPickupPSDEViewName();
	
	
	
	/**
	 * 获取引用实体数据链接视图标识
	 * @return
	 */
	String getRefLinkPSDEViewId();
	
	
	/**
	 * 获取引用实体数据链接视图名称
	 * @return
	 */
	String getRefLinkPSDEViewName();
	
	
	
	/**
	 * 获取值格式化
	 * @return
	 */
	String getValueFormat();
	
	
	
	/**
	 * 获取引用的实体对象（与getRefPSDE() 功能一致）
	 * @return
	 */
	IPSDataEntity getRefPSDataEntity();
	
	
	
	/**
	 * 获取引用的实体结果集合
	 * @return
	 */
	String getRefPSDEDataSetId();
	
	
	/**
	 * 获取引用的实体结果集合
	 * @return
	 */
	String getRefPSDEDataSetName() throws Exception;
	
	
	/**
	 * 获取引用的实体结果集合上下文逻辑
	 * @return
	 */
	String getRefActiveDataPSDELogicId();
	
	
	/**
	 * 获取引用的实体结果集合上下文逻辑
	 * @return
	 */
	String getRefActiveDataPSDELogicName() throws Exception;
	
	
	/**
	 * 获取引用的实体数据集合上下文逻辑
	 * @return
	 * @throws Exception
	 */
	IPSDELogic getRefActiveDataPSDELogic() throws Exception;
	
	
	/**
	 * 获取引用的实体数据集合对象
	 * @return
	 * @throws Exception
	 */
	IPSDEDataSet getRefPSDEDataSet() throws Exception;
	
	
	/**
	 * 是否引用临时数据
	 * @return
	 */
	boolean isRefTempData();
	
	
	/**
	 * 获取建立时默认值类型
	 * @return
	 */
	String getCreateDVT();
	
	

	/**
	 * 获取建立时默认值
	 * @return
	 */
	String getCreateDV();
	
	
	
	
	/**
	 * 获取更新时默认值类型
	 * @return
	 */
	String getUpdateDVT();
	
	

	/**
	 * 获取更新时默认值
	 * @return
	 */
	String getUpdateDV();
	
	
	
	/**
	 * 获取编辑器参数
	 * @return
	 */
	Properties getEditorParams();
	
	
	
	/**
	 * @param strEditorParam
	 * @param nDefault
	 * @return
	 */
	int getEditorParam(String strEditorParam,int nDefault);
	
	
	
	/**
	 * @param strEditorParam
	 * @param strDefault
	 * @return
	 */
	String getEditorParam(String strEditorParam,String strDefault);
	
	
	
	/**
	 * @param strEditorParam
	 * @param strDefault
	 * @return
	 */
	double getEditorParam(String strEditorParam,double fDefault);
	
	
	
	
	/**
	 * @param strEditorParam
	 * @param strDefault
	 * @return
	 */
	boolean getEditorParam(String strEditorParam,boolean bDefault);
	
	
	
	
	
	/**
	 * 获取系统值规则
	 * @return
	 */
	String getPSSysValueRuleId();
	
	
	/**
	 * 获取忽略输入
	 * @return
	 */
	int getIgnoreInput();
	
	
	/**
	 * 是否需要代码表配置
	 * @return
	 */
	boolean isNeedCodeListConfig();
	
	
	
	
	/**
	 * 获取输出代码表模型
	 * @return
	 */
	int getOutputCodeListConfigMode();
	
	
	/**
	 * 获取空白占位内容
	 * @return
	 */
	String getPlaceHolder();
	
	
	
	/**
	 * 获取界面项图片资源
	 * @return
	 */
	IPSSysImage getPSSysImage();
	
	
	/**
	 * 是否支持重置项
	 * @return
	 */
	boolean isEnableResetItemName();
	
	
	/**
	 * 获取重置项名称
	 * @return
	 */
	String getResetItemName();
	
	

	/**
	 * 获取单位名称
	 * @return
	 */
	String getUnitName();
	
	
	/**
	 * 获取单位名称宽度
	 * @return
	 */
	int getUnitNameWidth();
	
	
//	/**
//	 * 获取属性输入提示
//	 * @return
//	 */
//	IPSDEFInputTip getPSDEFInputTip();
	
	
	/**
	 * 是否启用单位名称
	 * @return
	 */
	boolean isEnableUnitName();
	
	
	
//	/**
//	 * 获取系统单位对象
//	 * @return
//	 */
//	IPSSysUnit getPSSysUnit();
	
	
	
	/**
	 * 获取单位语言资源标识
	 * @return
	 */
	String getUnitLanResTag();
	
	
	
//	/**
//	 * 获取单位的语言资源对象
//	 * @return
//	 */
//	IPSLanguageRes getUnitPSLanguageRes();
//	
//	
//	
//	
//	/**
//	 * 获取输入提示语言资源对象
//	 * @return
//	 */
//	IPSLanguageRes getPHPSLanguageRes();
//	
	
	
	
	/**
	 * 获取输入提示语言资源标识
	 * @return
	 */
	String getPHLanResTag();
	
	
	/**
	 * 获取异步处理对象标识
	 * @return
	 */
	String getPSAjaxHandlerId();
}
