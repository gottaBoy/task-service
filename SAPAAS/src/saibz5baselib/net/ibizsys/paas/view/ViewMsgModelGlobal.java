package net.ibizsys.paas.view;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 视图消息全局对象
 * 
 * @author lionlau
 *
 */
public class ViewMsgModelGlobal {
	private static final Log log = LogFactory.getLog(ViewMsgModelGlobal.class);
	private static HashMap<String, IViewMsgModel> viewMsgMap = new HashMap<String, IViewMsgModel>();

	/**
	 * 注册视图消息
	 * 
	 * @param strViewMsgClsType
	 * @param iViewMsg
	 */
	public static void registerViewMsg(String strViewMsgClsType, IViewMsgModel iViewMsg) {
		viewMsgMap.put(strViewMsgClsType, iViewMsg);
		viewMsgMap.put(iViewMsg.getId(), iViewMsg);
	}

	/**
	 * 获取视图消息对象
	 * 
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public static IViewMsgModel getViewMsg(Class cls) throws Exception {
		return getViewMsg(cls.getCanonicalName());
	}

	/**
	 * 获取视图消息对象
	 * 
	 * @param strViewMsgClsType
	 * @return
	 * @throws Exception
	 */
	public static IViewMsgModel getViewMsg(String strViewMsgClsType) throws Exception {
		return viewMsgMap.get(strViewMsgClsType);
	}
	
	
	/**
	 * 重新加载消息
	 */
	public static void reloadAllViewMsgs(){
		ArrayList<IViewMsgModel> list = new ArrayList<IViewMsgModel>();
		list.addAll(viewMsgMap.values());
		for(IViewMsgModel iViewMsgModel:list){
			if(iViewMsgModel instanceof IDEDataSetViewMsgModel){
				((IDEDataSetViewMsgModel)iViewMsgModel).resetCache();
			}
		}
	}

}
