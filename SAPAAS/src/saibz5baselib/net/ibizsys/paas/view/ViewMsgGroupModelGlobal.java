package net.ibizsys.paas.view;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 视图消息组全局对象
 * 
 * @author lionlau
 *
 */
public class ViewMsgGroupModelGlobal {
	private static final Log log = LogFactory.getLog(ViewMsgGroupModelGlobal.class);
	private static HashMap<String, IViewMsgGroupModel> viewMsgGroupMap = new HashMap<String, IViewMsgGroupModel>();

	/**
	 * 注册视图消息组
	 * 
	 * @param strViewMsgGroupClsType
	 * @param iViewMsgGroup
	 */
	public static void registerViewMsgGroup(String strViewMsgGroupClsType, IViewMsgGroupModel iViewMsgGroup) {
		viewMsgGroupMap.put(strViewMsgGroupClsType, iViewMsgGroup);
		viewMsgGroupMap.put(iViewMsgGroup.getId(), iViewMsgGroup);
	}

	/**
	 * 获取视图消息组对象
	 * 
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public static IViewMsgGroupModel getViewMsgGroup(Class cls) throws Exception {
		return getViewMsgGroup(cls.getCanonicalName());
	}

	/**
	 * 获取视图消息组对象
	 * 
	 * @param strViewMsgGroupClsType
	 * @return
	 * @throws Exception
	 */
	public static IViewMsgGroupModel getViewMsgGroup(String strViewMsgGroupClsType) throws Exception {
		return viewMsgGroupMap.get(strViewMsgGroupClsType);
	}

}
