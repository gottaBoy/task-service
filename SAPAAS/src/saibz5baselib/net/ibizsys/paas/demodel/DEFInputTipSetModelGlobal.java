package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 属性输入提示集合全局对象
 * 
 * @author lionlau
 *
 */
public class DEFInputTipSetModelGlobal {
	
	private static final Log log = LogFactory.getLog(DEFInputTipSetModelGlobal.class);
	private static HashMap<String, IDEFInputTipSetModel> defInputTipSetMap = new HashMap<String, IDEFInputTipSetModel>();

	/**
	 * 注册属性输入提示集合
	 * 
	 * @param strDEFInputTipSetClsType
	 * @param iDEFInputTipSet
	 */
	public static void registerDEFInputTipSet(String strDEFInputTipSetClsType, IDEFInputTipSetModel iDEFInputTipSet) {
		defInputTipSetMap.put(strDEFInputTipSetClsType, iDEFInputTipSet);
		defInputTipSetMap.put(iDEFInputTipSet.getId(), iDEFInputTipSet);
	}

	/**
	 * 获取属性输入提示集合对象
	 * 
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public static IDEFInputTipSetModel getDEFInputTipSet(Class cls) throws Exception {
		return getDEFInputTipSet(cls.getCanonicalName());
	}

	/**
	 * 获取属性输入提示集合对象
	 * 
	 * @param strDEFInputTipSetClsType
	 * @return
	 * @throws Exception
	 */
	public static IDEFInputTipSetModel getDEFInputTipSet(String strDEFInputTipSetClsType) throws Exception {
		return defInputTipSetMap.get(strDEFInputTipSetClsType);
	}

	
	/**
	 * 重新加载属性输入提示集合对象
	 */
	public static void reloadAllDEFInputTipSets(){
		ArrayList<IDEFInputTipSetModel> list = new ArrayList<IDEFInputTipSetModel>();
		list.addAll(defInputTipSetMap.values());
		for(IDEFInputTipSetModel iDEFInputTipSetModel:list){
			iDEFInputTipSetModel.resetAll();
		}
	}
}
