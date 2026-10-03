package net.ibizsys.paas.sysmodel;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;

/**
 * 代码表全局对象
 * 
 * @author lionlau
 *
 */
public class CodeListGlobal {
	private static final Log log = LogFactory.getLog(CodeListGlobal.class);
	private static HashMap<String, ICodeList> codeListMap = new HashMap<String, ICodeList>();
	private static ICodeListGlobalPlugin iCodeListGlobalPlugin = null;

	/**
	 * 注册代码表
	 * 
	 * @param strCodeListClsType
	 * @param iCodeList
	 */
	public static void registerCodeList(String strCodeListClsType, ICodeListModel iCodeList) {
		// log.info(StringHelper.format("注册代码表对象[%1$s][%2$s]",strCodeListClsType,iCodeList));
		
		ICodeListGlobalPlugin iCodeListGlobalPlugin = getPlugin();
		if(iCodeListGlobalPlugin!=null){
			iCodeListGlobalPlugin.registerCodeList(strCodeListClsType, iCodeList);
		}
		else{
			codeListMap.put(strCodeListClsType, iCodeList);
			codeListMap.put(iCodeList.getId(), iCodeList);
		}

	}

	/**
	 * 获取代码表对象
	 * 
	 * @param strCodeListClsType
	 * @return
	 * @throws Exception
	 */
	public static ICodeList getCodeList(Class cls) throws Exception {
		ICodeListGlobalPlugin iCodeListGlobalPlugin = getPlugin();
		if(iCodeListGlobalPlugin!=null){
			return iCodeListGlobalPlugin.getCodeList(cls);
		}
		else
			return getCodeList(cls.getCanonicalName());
	}
	
	/**
	 * 获取代码表对象
	 * 
	 * @param strCodeListClsType
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	public static ICodeList getCodeList(Class cls,boolean bTryMode) throws Exception {
		ICodeListGlobalPlugin iCodeListGlobalPlugin = getPlugin();
		if(iCodeListGlobalPlugin!=null){
			return iCodeListGlobalPlugin.getCodeList(cls,bTryMode);
		}
		else
			return getCodeList(cls.getCanonicalName(),bTryMode);
	}
	

	/**
	 * 获取代码表对象
	 * 
	 * @param strCodeListClsType
	 * @return
	 * @throws Exception
	 */
	public static ICodeList getCodeList(String strCodeListClsType) throws Exception {
		ICodeListGlobalPlugin iCodeListGlobalPlugin = getPlugin();
		if(iCodeListGlobalPlugin!=null){
			return iCodeListGlobalPlugin.getCodeList(strCodeListClsType);
		}
		else{
			return internalGetCodeList(strCodeListClsType);
		}
	}
	
	/**
	 * 获取代码表对象
	 * 
	 * @param strCodeListClsType
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	public static ICodeList getCodeList(String strCodeListClsType,boolean bTryMode) throws Exception {
		ICodeListGlobalPlugin iCodeListGlobalPlugin = getPlugin();
		if(iCodeListGlobalPlugin!=null){
			return iCodeListGlobalPlugin.getCodeList(strCodeListClsType,bTryMode);
		}
		else{
			return internalGetCodeList(strCodeListClsType,bTryMode);
		}
	}
	
	/**
	 * 获取代码表对象
	 * 
	 * @param cls
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	public static ICodeList getCodeList(Class cls, SessionFactory sessionFactory) throws Exception {
		ICodeListGlobalPlugin iCodeListGlobalPlugin = getPlugin();
		if(iCodeListGlobalPlugin!=null){
			return iCodeListGlobalPlugin.getCodeList(cls.getCanonicalName(), sessionFactory);
		}
		else{
			return getCodeList(cls.getCanonicalName(), sessionFactory);
		}
	}
	

	/**
	 * 获取代码表对象
	 * 
	 * @param cls
	 * @param sessionFactory
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	public static ICodeList getCodeList(Class cls, SessionFactory sessionFactory,boolean bTryMode) throws Exception {
		ICodeListGlobalPlugin iCodeListGlobalPlugin = getPlugin();
		if(iCodeListGlobalPlugin!=null){
			return iCodeListGlobalPlugin.getCodeList(cls.getCanonicalName(), sessionFactory,bTryMode);
		}
		else{
			return getCodeList(cls.getCanonicalName(), sessionFactory,bTryMode);
		}
	}

	/**
	 * 获取代码表对象
	 * 
	 * @param strCodeListClsType
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	public static ICodeList getCodeList(String strCodeListClsType, SessionFactory sessionFactory) throws Exception {
		ICodeListGlobalPlugin iCodeListGlobalPlugin = getPlugin();
		if(iCodeListGlobalPlugin!=null){
			return iCodeListGlobalPlugin.getCodeList(strCodeListClsType, sessionFactory);
		}
		else{
			ICodeList iCodeList = internalGetCodeList(strCodeListClsType, sessionFactory);
			if (iCodeList.isUserScope() && WebContext.getCurrent() != null) {
				return WebContext.getCurrent().getUserCodeList(iCodeList);
			}
			return iCodeList;
		}
	}
	
	/**
	 * 获取代码表对象
	 * 
	 * @param strCodeListClsType
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	public static ICodeList getCodeList(String strCodeListClsType, SessionFactory sessionFactory,boolean bTryMode) throws Exception {
		ICodeListGlobalPlugin iCodeListGlobalPlugin = getPlugin();
		if(iCodeListGlobalPlugin!=null){
			return iCodeListGlobalPlugin.getCodeList(strCodeListClsType, sessionFactory,bTryMode);
		}
		else{
			ICodeList iCodeList = internalGetCodeList(strCodeListClsType, sessionFactory,bTryMode);
			if(iCodeList == null)
				return iCodeList;
			if (iCodeList.isUserScope() && WebContext.getCurrent() != null) {
				return WebContext.getCurrent().getUserCodeList(iCodeList);
			}
			return iCodeList;
		}
	}

	/**
	 * 获取代码表对象
	 * 
	 * @param strCodeListClsType
	 * @return
	 * @throws Exception
	 */
	private static ICodeList internalGetCodeList(String strCodeListClsType, SessionFactory sessionFactory) throws Exception {
		if (sessionFactory == null) {
			return getCodeList(strCodeListClsType);
		}

		String strFullKeyId = StringHelper.format("%1$s|%2$s", strCodeListClsType, sessionFactory.toString());
		synchronized (codeListMap) {
			ICodeList iCodeList = codeListMap.get(strFullKeyId);
			if (iCodeList != null) return iCodeList;

			iCodeList = codeListMap.get(strCodeListClsType);
			if (iCodeList == null) throw new Exception(StringHelper.format("无法获取指定代码表[%1$s]", strCodeListClsType));

			// 建立新对象
			ICodeList newCodeList = iCodeList.getClass().newInstance();
			if (newCodeList instanceof ICodeListModel) {
				((ICodeListModel) newCodeList).from((ICodeListModel) iCodeList);
				((ICodeListModel) newCodeList).setSessionFactory(sessionFactory);
			}
			codeListMap.put(strFullKeyId, newCodeList);
			return newCodeList;
		}
	}

	
	/**
	 * 获取代码表对象
	 * 
	 * @param strCodeListClsType
	 * @param sessionFactory
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	private static ICodeList internalGetCodeList(String strCodeListClsType, SessionFactory sessionFactory,boolean bTryMode) throws Exception {
		if (sessionFactory == null) {
			return getCodeList(strCodeListClsType,bTryMode);
		}

		String strFullKeyId = StringHelper.format("%1$s|%2$s", strCodeListClsType, sessionFactory.toString());
		synchronized (codeListMap) {
			ICodeList iCodeList = codeListMap.get(strFullKeyId);
			if (iCodeList != null) return iCodeList;

			iCodeList = codeListMap.get(strCodeListClsType);
			if (iCodeList == null){
				if(bTryMode)
					return iCodeList;
				throw new Exception(StringHelper.format("无法获取指定代码表[%1$s]", strCodeListClsType));
			}

			// 建立新对象
			ICodeList newCodeList = iCodeList.getClass().newInstance();
			if (newCodeList instanceof ICodeListModel) {
				((ICodeListModel) newCodeList).from((ICodeListModel) iCodeList);
				((ICodeListModel) newCodeList).setSessionFactory(sessionFactory);
			}
			codeListMap.put(strFullKeyId, newCodeList);
			return newCodeList;
		}
	}
	
	/**
	 * 获取代码表对象
	 * 
	 * @param strCodeListClsType
	 * @return
	 * @throws Exception
	 */
	private static ICodeList internalGetCodeList(String strCodeListClsType,boolean bTryMode) throws Exception {
		synchronized (codeListMap) {
			ICodeList iCodeList = codeListMap.get(strCodeListClsType);
			if (iCodeList == null){
				if(bTryMode){
					return null;
				}
				throw new Exception(StringHelper.format("无法获取指定代码表[%1$s]", strCodeListClsType));
			}
			if (iCodeList.isUserScope() && WebContext.getCurrent() != null) {
				return WebContext.getCurrent().getUserCodeList(iCodeList);
			}
			return iCodeList;
		}
	}
	
	/**
	 * 获取代码表对象
	 * 
	 * @param strCodeListClsType
	 * @return
	 * @throws Exception
	 */
	private static ICodeList internalGetCodeList(String strCodeListClsType) throws Exception {
		synchronized (codeListMap) {
			ICodeList iCodeList = codeListMap.get(strCodeListClsType);
			if (iCodeList == null){
				throw new Exception(StringHelper.format("无法获取指定代码表[%1$s]", strCodeListClsType));
			}
			if (iCodeList.isUserScope() && WebContext.getCurrent() != null) {
				return WebContext.getCurrent().getUserCodeList(iCodeList);
			}
			return iCodeList;
		}
	}

	/**
	 * 获取系统全部码表对象
	 * 
	 * @return
	 */
	public static java.util.Iterator<ICodeList> getAllCodelists() {
		ICodeListGlobalPlugin iCodeListGlobalPlugin = getPlugin();
		if(iCodeListGlobalPlugin!=null){
			return iCodeListGlobalPlugin.getAllCodelists();
		}
		else
			return codeListMap.values().iterator();
	}
	
	
	/**
	 * 设置插件
	 * @param iCodeListGlobalPlugin
	 */
	public static void setPlugin(ICodeListGlobalPlugin iCodeListGlobalPlugin){
		CodeListGlobal.iCodeListGlobalPlugin = iCodeListGlobalPlugin;
	}
	
	public static ICodeListGlobalPlugin getPlugin(){
		return CodeListGlobal.iCodeListGlobalPlugin; 
	}
}
