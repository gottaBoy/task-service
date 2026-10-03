package net.ibizsys.paas.demodel;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.util.StringHelper;

/**
 * 实体模型全局对象
 * 
 * @author lionlau
 *
 */
public class DEModelGlobal {
	private static final Log log = LogFactory.getLog(DEModelGlobal.class);
	private static HashMap<String, IDataEntityModel> demodelMap = new HashMap<String, IDataEntityModel>();
	private static HashMap<String, String> deModelRuntimeMap = new HashMap<String, String>();
	
	/**
	 * 注册实体模型
	 * 
	 * @param iDEModel
	 */
	public static void registerDEModel(IDataEntityModel iDEModel) {
		demodelMap.put(iDEModel.getId(), iDEModel);
		demodelMap.put(iDEModel.getName(), iDEModel);
	}

	/**
	 * 注册实体模型
	 * 
	 * @param strDEModelClsType
	 * @param iDEModel
	 */
	public static void registerDEModel(String strDEModelClsType, IDataEntityModel iDEModel) {
		// log.info(StringHelper.format("注册实体模型对象[%1$s][%2$s]",strDEModelClsType,iDEModel));
		demodelMap.put(strDEModelClsType, iDEModel);
		demodelMap.put(iDEModel.getId(), iDEModel);
		demodelMap.put(iDEModel.getName(), iDEModel);

		// if(demodelMap.containsKey(iDEModel.getName()))
		// {
		// log.warn(StringHelper.format("系统中已注册名称为[%1$s]的实体",iDEModel.getName()));
		// }
		// else
		// demodelMap.put(iDEModel.getName(), iDEModel);
	}

	/**
	 * 获取实体模型
	 * 
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public static IDataEntityModel getDEModel(Class cls) throws Exception {
		return getDEModel(cls.getCanonicalName());
	}

	/**
	 * 获取实体模型
	 * 
	 * @param strDEModelClsType
	 * @return
	 * @throws Exception
	 */
	public static IDataEntityModel getDEModel(String strDEModelClsType) throws Exception {
		IDataEntityModel iDEModel = demodelMap.get(strDEModelClsType);
		if (iDEModel == null) throw new Exception(StringHelper.format("无法获取指定实体模型[%1$s]", strDEModelClsType));
		return iDEModel;
	}
	
	/**
	 * 获取实体模型
	 * 
	 * @param strDEModelClsType
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	public static IDataEntityModel getDEModel(String strDEModelClsType,boolean bTryMode) throws Exception {
		IDataEntityModel iDEModel = demodelMap.get(strDEModelClsType);
		if (iDEModel == null){
			if(bTryMode)
				return null;
			throw new Exception(StringHelper.format("无法获取指定实体模型[%1$s]", strDEModelClsType));
		}
		return iDEModel;
	}
	
	
	/**
	 * 设置实体模型运行时标识
	 * @param strDEModelId
	 * @param runtimeId
	 * @throws Exception
	 */
	public static void setDEModelRuntimeId(String strDEModelId,Object runtimeId)throws Exception{
		IDataEntityModel iDEModel = getDEModel(strDEModelId);
		if(iDEModel!=null){
			iDEModel.setRuntimeId(runtimeId);
		}
		deModelRuntimeMap.put(runtimeId.toString(), strDEModelId);
	}
	
	
	/**
	 * 通过运行时标识获取实体模型
	 * @param runtimeId
	 * @return
	 * @throws Exception
	 */
	public static IDataEntityModel getDEModelByRuntimeId(Object runtimeId) throws Exception
	{
		String strRuntimeId = runtimeId.toString();
		String strRealId = deModelRuntimeMap.get(strRuntimeId);
		if(strRealId == null){
			return getDEModel(strRuntimeId);
		}
		else{
			return getDEModel(strRealId);
		}
	}
	
	
	/**
	 * 是否存在指定实体模型
	 * @param strDEName
	 * @return
	 */
	public static boolean containsDEModel(String strDEName){
		IDataEntityModel iDEModel = demodelMap.get(strDEName);
		return iDEModel!=null;
	}
}
