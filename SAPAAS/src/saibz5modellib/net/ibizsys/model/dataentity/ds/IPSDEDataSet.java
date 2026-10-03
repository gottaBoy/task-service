package net.ibizsys.model.dataentity.ds;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.paas.core.IDEDataSet;


/**
 * 实体数据集合对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSDEDataSet extends IPSDataEntityObject, IDEDataSet {
	

//	/**
//	 * 获取代码名称
//	 * 
//	 * @return
//	 */
//	String getCodeName();
//
//	/**
//	 * 获取结果集代码
//	 * 
//	 * @param strDBType
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEDataSetCode getPSDEDataSetCode(String strDBType) throws Exception;

	/**
	 * 获取数据查询集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSDEDataQuery> getPSDEDataQueries();

	/**
	 * 获取数据集合分组参数集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSDEDataSetGroupParam> getPSDEDataSetGroupParams();

	/**
	 * 是否为默认数据集合
	 * 
	 * @return
	 */
	boolean isDefaultMode();



	/**
	 * 获取预定义类型
	 * 
	 * @return
	 */
	String getPredefinedType();

	/**
	 * 获取指定数据集合分组参数对象
	 * 
	 * @param strName
	 * @param bTry
	 * @return
	 * @throws Exception
	 */
	IPSDEDataSetGroupParam getPSDEDataSetGroupParam(String strName, boolean bTry) throws Exception;

	/**
	 * 获取系统代码表
	 * 
	 * @return
	 */
	IPSCodeList getPSCodeList();

//	/**
//	 * 获取扩展模式具体参考 SA.SRFDA.PS.Core.DataEntity.IPSDataEntity.EXTENDMODE_XXX 定义。
//	 * 
//	 * @return
//	 */
//	int getExtendMode();
//
	/**
	 * 获取逻辑名称
	 * 
	 * @return
	 */
	String getLogicName();
//
//	/**
//	 * 获取系统自定义权限数据范围
//	 * 
//	 * @return
//	 */
//	IPSSysUserDR getPSSysUserDR();
//
//	/**
//	 * 获取系统自定义权限数据范围2
//	 * 
//	 * @return
//	 */
//	IPSSysUserDR getPSSysUserDR2();
//
	/**
	 * 获取一级排序属性
	 * 
	 * @return
	 */
	IPSDEField getMajorSortPSDEField();

	/**
	 * 获取二级排序属性
	 * 
	 * @return
	 */
	IPSDEField getMinorSortPSDEField();
//
//	/**
//	 * 获取数据集合缓存统一状态同步对象
//	 * 
//	 * @return
//	 */
//	IPSSysUniState getPSSysUniState();
//
//	/**
//	 * 获取缓存状态计算逻辑
//	 * 
//	 * @return
//	 */
//	IPSDELogic getCacheStatePSDELogic();
//
//	
//	/**
//	 * 获取是否默认发布服务接口
//	 * @return
//	 */
//	boolean isPubServiceDefault();
//	
//	
//	
//	/**
//	 * 获取RESTful接口设置
//	 * @return
//	 */
//	IPSRESTfulAPI getPSRESTfulAPI();
//	
//	
//	
	/**
	 * 获取上下文数据计算逻辑
	 * @return
	 */
	IPSDELogic getActiveDataPSDELogic();
	
	
	
	/**
	 * 是否支持临时数据
	 * @return
	 */
	boolean isEnableTempData();
}
