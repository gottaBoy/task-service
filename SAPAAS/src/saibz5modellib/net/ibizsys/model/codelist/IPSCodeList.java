package net.ibizsys.model.codelist;

import net.ibizsys.model.IPSModelJsonExporter;
import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.paas.codelist.ICodeList;

/**
 * 系统代码表对象接口
 * @author lionlau
 *
 */
public interface IPSCodeList extends IPSSystemObject,ICodeList,IPSModelJsonExporter
{
	
	/**
	 * 获取静态代码项集合
	 * @return
	 */
	java.util.Iterator<IPSCodeItem> getPSCodeItems()  throws Exception;
	

	
	
	
	
	/**
	 * 获取实体对象
	 * @return
	 */
	IPSDataEntity getPSDataEntity() throws Exception;

	
	
	
	/**
	 * 获取实体数据集合对象
	 * @return
	 */
	IPSDEDataSet getPSDEDataSet() throws Exception;
//	
//	
//	
//	/**
//	 * 获取引用标志
//	 * @return
//	 */
//	boolean getRefFlag();
//	
//	
//	
//	
//	/**
//	 * 代码值是否为数值,如果代码表为数字或模式，则恒为数值
//	 * @return
//	 */
//	boolean isCodeItemValueNumber();
//	
//	
//	
//	
//	
	/**
	 * 获取预置类型
	 * @return
	 */
	String getPredefinedType();
//	
//	
//	
//	/**
//	 * 是否为子系统代码表
//	 * @return
//	 */
//	boolean isSubSysCodeList();
//	
//	
//	/**
//	 * 获取系统模块
//	 * @return
//	 */
//	IPSSystemModule getPSSystemModule();
//	
//	
	/**
	 * 获取文本属性
	 * @return
	 */
	IPSDEField getTextPSDEField() throws Exception;
	
	
	
	/**
	 * 获取值属性
	 * @return
	 */
	IPSDEField getValuePSDEField() throws Exception;
	
	
	/**
	 * 获取二级排序属性
	 * @return
	 */
	IPSDEField getMinorSortPSDEField() throws Exception;
	

	
	/**
	 * 获取二级排序方向
	 * @return
	 */
	String getMinorSortDir();
	
	
	
	/**
	 * 获取图标样式属性
	 * @return
	 */
	IPSDEField getIconClsPSDEField() throws Exception;
	
	
	/**
	 * 获取图标样式(多倍)属性
	 * @return
	 */
	IPSDEField getIconClsXPSDEField() throws Exception;
	
	
	/**
	 * 获取图标路径属性
	 * @return
	 */
	IPSDEField getIconPathPSDEField() throws Exception;
	
	
	/**
	 * 获取图标路径(多倍)属性
	 * @return
	 */
	IPSDEField getIconPathXPSDEField() throws Exception;
//	
//	
//	
//	/**
//	 * 是否为用户引用
//	 * @return
//	 */
//	boolean isUserRef();
//	
//	
//	
//	
	/**
	 * 获取额外的查询条件
	 * @return
	 */
	String getFetchCondition();
	
	
	
	/**
	 * 获取父值属性
	 * @return
	 */
	IPSDEField getPValuePSDEField() throws Exception;
//	
//	
//	/**
//	 * 获取扩展模式，值参考：SA.SRFDA.PS.Core.DataEntity.IPSDataEntity.EXTENDMODE_XXX
//	 * @return
//	 */
//	int getExtendMode();
//	
//	
	/**
	 * 获取空白文本语言资源对象
	 * @return
	 */
	IPSLanguageRes getEmptyTextPSLanguageRes();
	
	
	/**
	 * 是否支持动态系统
	 * @return
	 */
	boolean isEnableDynaSys();
	
	
	/**
	 * 获取禁用值属性
	 * @return
	 */
	IPSDEField getDisablePSDEField() throws Exception;
	
	
	
	
	
}
