package net.ibizsys.paas.ctrlmodel;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.util.StringHelper;

/**
 * 控件模型全局对象
 * 
 * @author Administrator
 *
 */
public class CtrlModelGlobal {
	private static final Log log = LogFactory.getLog(CtrlModelGlobal.class);
	private static HashMap<String, ICtrlModel> ctrlModelMap = new HashMap<String, ICtrlModel>();

	/**
	 * 注册控件模型
	 * 
	 * @param strCtrlModelClsType
	 * @param iCtrlModel
	 */
	public static void registerCtrlModel(String strCtrlModelClsType, ICtrlModel iCtrlModel) {
		ctrlModelMap.put(strCtrlModelClsType, iCtrlModel);
	}

	/**
	 * 获取控件模型
	 * 
	 * @param strCtrlModelClsType
	 * @return
	 * @throws Exception
	 */
	public static ICtrlModel getCtrlModel(String strCtrlModelClsType) throws Exception {
		ICtrlModel iCtrlModel = ctrlModelMap.get(strCtrlModelClsType);
		if (iCtrlModel == null) throw new Exception(StringHelper.format("无法获取指定控件模型[%1$s]", strCtrlModelClsType));
		return iCtrlModel;
	}

}
