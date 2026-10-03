package net.ibizsys.psba.core;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.util.StringHelper;

/**
 * 大数据架构模型全局对象
 * 
 * @author Administrator
 *
 */
public class BASchemeModelGlobal {
	private static final Log log = LogFactory.getLog(BASchemeModelGlobal.class);
	private static HashMap<String, IBASchemeModel> baSchemeModelMap = new HashMap<String, IBASchemeModel>();

	/**
	 * 注册大数据架构模型
	 * 
	 * @param strBASchemeModelClsType
	 * @param iBASchemeModel
	 */
	public static void registerBASchemeModel(String strBASchemeModelClsType, IBASchemeModel iBASchemeModel) {
		baSchemeModelMap.put(strBASchemeModelClsType, iBASchemeModel);
		baSchemeModelMap.put(iBASchemeModel.getId(), iBASchemeModel);
	}

	/**
	 * 获取大数据架构模型
	 * 
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public static IBASchemeModel getBASchemeModel(Class cls) throws Exception {
		return getBASchemeModel(cls.getCanonicalName());
	}

	/**
	 * 获取大数据架构模型
	 * 
	 * @param strBASchemeModelClsType
	 * @return
	 * @throws Exception
	 */
	public static IBASchemeModel getBASchemeModel(String strBASchemeModelClsType) throws Exception {
		IBASchemeModel iBASchemeModel = baSchemeModelMap.get(strBASchemeModelClsType);
		if (iBASchemeModel == null) throw new Exception(StringHelper.format("无法获取指定大数据架构模型[%1$s]", strBASchemeModelClsType));
		return iBASchemeModel;
	}
}
