package net.ibizsys.pswf.core;

/**
 * 实体行为流程处理模型接口
 * @author lionlau
 *
 */
public interface IWFDEActionProcessModel  extends IWFProcessModel
{
	/**
	 * 获取操作参数集合
	 * @return
	 */
	java.util.Iterator<IWFDEActionProcessParamModel> getWFDEActionProcessParamModels();
	
	
	
	/**
	 * 获取实体操作名称
	 * @return
	 */
	String getDEActionName();
	
	

}
