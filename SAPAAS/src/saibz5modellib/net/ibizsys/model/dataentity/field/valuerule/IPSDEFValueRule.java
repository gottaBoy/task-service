package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.field.IPSDEFieldObject;
import net.ibizsys.paas.core.valuerule.IDEFValueRule;


/**
 * 实体属性值规则对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSDEFValueRule extends IPSDEFieldObject, IDEFValueRule,IPSModelObject {
	

	/**
	 * 是否为默认规则
	 * 
	 * @return
	 */
	boolean isDefaultMode();

//	/**
//	 * 获取代码名称
//	 * 
//	 * @return
//	 */
//	String getCodeName();

	/**
	 * 获取值规则类型
	 * 
	 * @return
	 */
	String getTypeDetail();

	/**
	 * 获取规则信息
	 * 
	 * @return
	 */
	String getRuleInfo();

	/**
	 * 获取条件对象
	 * 
	 * @return
	 */
	IPSDEFVRGroupCondition getPSDEFVRGroupCondition();
//
//	/**
//	 * 获取规则关联的属性
//	 * 
//	 * @return
//	 */
//	java.util.Iterator<IPSDEField> getRelatedPSDEFields();

	/**
	 * 是否为默认检查
	 * 
	 * @return
	 */
	boolean isCheckDefault();
	
	
	
	/**
	 * 获取全部值规则条件
	 * @return
	 */
	java.util.Iterator<IPSDEFVRCondition> getAllPSDEFVRConditions();
}
