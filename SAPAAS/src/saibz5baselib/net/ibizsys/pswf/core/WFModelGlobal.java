package net.ibizsys.pswf.core;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.util.StringHelper;

/**
 * 流程模型全局对象
 * @author Administrator
 *
 */
public class WFModelGlobal
{
	private static final Log log = LogFactory.getLog(WFModelGlobal.class);
	private static HashMap<String, IWFModel> wfmodelMap = new HashMap<String, IWFModel>();
	private static HashMap<String, String> wfModelRuntimeMap = new HashMap<String, String>();
	
	/**
	 * 注册流程模型
	 * @param strWFModelClsType
	 * @param iWFModel
	 */
	public static void registerWFModel(String strWFModelClsType,IWFModel iWFModel)
	{
		wfmodelMap.put(strWFModelClsType, iWFModel);
		wfmodelMap.put(iWFModel.getId(), iWFModel);
	}
	
	
	/**
	 * 获取流程模型
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public static IWFModel getWFModel(Class cls) throws Exception
	{
		return getWFModel(cls.getCanonicalName());
	}
	
	/**
	 *  获取流程模型
	 * @param strWFModelClsType
	 * @return
	 * @throws Exception
	 */
	public static IWFModel getWFModel(String strWFModelClsType) throws Exception
	{
		IWFModel iWFModel = wfmodelMap.get(strWFModelClsType);
		if(iWFModel == null)
			throw new Exception(StringHelper.format("无法获取指定流程模型[%1$s]",strWFModelClsType));
		return iWFModel;
	}
	
	
	/**
	 * 获取流程模型
	 * @param cls
	 * @param bTryMode 
	 * @return
	 * @throws Exception
	 */
	public static IWFModel getWFModel(Class cls,boolean bTryMode) throws Exception
	{
		return getWFModel(cls.getCanonicalName(),bTryMode);
	}
	
	/**
	 *  获取流程模型
	 * @param strWFModelClsType
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	public static IWFModel getWFModel(String strWFModelClsType,boolean bTryMode) throws Exception
	{
		IWFModel iWFModel = wfmodelMap.get(strWFModelClsType);
		if(iWFModel == null && !bTryMode)
			throw new Exception(StringHelper.format("无法获取指定流程模型[%1$s]",strWFModelClsType));
		return iWFModel;
	}
	
	
	/**
	 * 设置工作流模型运行时标识
	 * @param strWFModelId
	 * @param runtimeId
	 * @throws Exception
	 */
	public static void setWFModelRuntimeId(String strWFModelId,Object runtimeId)throws Exception{
		IWFModel iWFModel = getWFModel(strWFModelId);
		if(iWFModel!=null){
			iWFModel.setRuntimeId(runtimeId);
		}
		wfModelRuntimeMap.put(runtimeId.toString(), strWFModelId);
	}
	
	
	/**
	 * 通过运行时标识获取工作流模型
	 * @param runtimeId
	 * @return
	 * @throws Exception
	 */
	public static IWFModel getWFModelByRuntimeId(Object runtimeId) throws Exception
	{
		String strRuntimeId = runtimeId.toString();
		String strRealId = wfModelRuntimeMap.get(strRuntimeId);
		if(strRealId == null){
			return getWFModel(strRuntimeId);
		}
		else{
			return getWFModel(strRealId);
		}
	}
}
