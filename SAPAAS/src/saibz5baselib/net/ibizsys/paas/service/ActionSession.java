package net.ibizsys.paas.service;

import java.util.HashMap;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;

/**
 * 操作会话管理对象
 * 
 * @author lionlau
 *
 */
public class ActionSession {
	
	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(ActionSession.class);
	/**
	 * 递归操作数据Map
	 */
	private HashMap<String, String> recursionDataMap = new HashMap<String, String>();

	/**
	 * 操作参数
	 */
	private HashMap<String, Object> actionParamMap = new HashMap<String, Object>();

	private String strName = "";

	private StringBuilderEx actionInfoSB = new StringBuilderEx();
	
	private IEntity envEntity = null;

	private ActionSession childActionSession = null;
	
	private int nLevel = 0;
	
	public ActionSession(){
		
	}
	
	protected ActionSession( ActionSession parentActionSession,int nLevel){
		try{
			this.nLevel = nLevel;
			//克隆环境变量
			if(parentActionSession.getEnvEntity(false) != null){
				this.envEntity =  new SimpleEntity();
				parentActionSession.getEnvEntity(false).copyTo(this.envEntity, false);
			}
		}
		catch(Exception ex){
			log.error(ex);
		}
		
	}
	
	
	/**
	 * 开启子会话
	 * @param strName
	 * @return
	 */
	public ActionSession openChildSession(String strName) {
		if(this.childActionSession == null){
			this.childActionSession = new ActionSession(this,nLevel+1);
			this.childActionSession.setName(strName);
			return this.childActionSession;
		}
		else{
			return this.childActionSession.openChildSession(strName);
		}
	}
	
	/**
	 * 关闭子会话
	 */
	public int closeChildSession(){
		if(this.childActionSession==null)
			return -1;
		
		int nLastLevel = this.childActionSession.closeChildSession();
		if(nLastLevel == -1){
			this.childActionSession = null;
			return this.nLevel;
		}
		
		return nLastLevel;
	}
	

	/**
	 * 获取当前会话
	 * @return
	 */
	public ActionSession getCurrentSession(){
		if(this.childActionSession==null)
			return this;
		return this.childActionSession.getCurrentSession();
	}
	
	
	/**
	 * 获取名称
	 * 
	 * @return
	 */
	public String getName() {
		return this.strName;
	}

	/**
	 * 设置名称
	 * 
	 * @param strName
	 */
	public void setName(String strName) {
		this.strName = strName;
	}

	/**
	 * 注册递归操作
	 * 
	 * @param strDEId
	 * @param objKeyValue
	 * @return
	 */
	public boolean registerRecursion(String strDEId, Object objKeyValue) {
		String strRecursionTag = StringHelper.format("%1$s||%2$s", strDEId, objKeyValue);
		if (recursionDataMap.containsKey(strRecursionTag)) {
			return false;
		}
		recursionDataMap.put(strRecursionTag, "");
		return true;
	}
	
	
	/**
	 * 注销递归操作
	 * @param strDEId
	 * @param objKeyValue
	 */
	public void unregisterRecursion(String strDEId, Object objKeyValue) {
		String strRecursionTag = StringHelper.format("%1$s||%2$s", strDEId, objKeyValue);
		recursionDataMap.remove(strRecursionTag);
	}
	

	/**
	 * 注册递归操作
	 * 
	 * @param strActionType 操作类型
	 * @param strDEId
	 * @param objKeyValue
	 * @return
	 */
	public boolean registerRecursion(String strActionType, String strDEId, Object objKeyValue) {
		String strRecursionTag = StringHelper.format("%1$s||%2$s||%3$s", strActionType, strDEId, objKeyValue);
		if (recursionDataMap.containsKey(strRecursionTag)) {
			return false;
		}
		recursionDataMap.put(strRecursionTag, "");
		return true;
	}
	
	/**
	 * 注销递归操作
	 * @param strActionType
	 * @param strDEId
	 * @param objKeyValue
	 */
	public void unregisterRecursion(String strActionType, String strDEId, Object objKeyValue) {
		String strRecursionTag = StringHelper.format("%1$s||%2$s||%3$s", strActionType, strDEId, objKeyValue);
		recursionDataMap.remove(strRecursionTag);
	}
	
	
	
	/**
	 * 注册递归操作
	 * 
	 * @param strActionType 操作类型
	 * @param strDEId
	 * @param objKeyValue
	 * @param objTag 
	 * @return
	 */
	public boolean registerRecursion(String strActionType, String strDEId, Object objKeyValue,Object objTag) {
		String strRecursionTag = StringHelper.format("%1$s||%2$s||%3$s||%4$s", strActionType, strDEId, objKeyValue,objTag);
		if (recursionDataMap.containsKey(strRecursionTag)) {
			return false;
		}
		recursionDataMap.put(strRecursionTag, "");
		return true;
	}
	
	/**
	 * 注销递归操作
	 * 
	 * @param strActionType 操作类型
	 * @param strDEId
	 * @param objKeyValue
	 * @param objTag 
	 * @return
	 */
	public void unregisterRecursion(String strActionType, String strDEId, Object objKeyValue,Object objTag) {
		String strRecursionTag = StringHelper.format("%1$s||%2$s||%3$s||%4$s", strActionType, strDEId, objKeyValue,objTag);
		recursionDataMap.remove(strRecursionTag);
	}

	/**
	 * 附加操作信息
	 * 
	 * @param strInfo
	 */
	public void appendActionInfo(String strInfo) {
		actionInfoSB.append(strInfo);
	}

	/**
	 * 获取操作信息
	 * 
	 * @return
	 */
	public String getActionInfo() {
		return this.actionInfoSB.toString();
	}

	/**
	 * 设置操作参数
	 * 
	 * @param strName
	 * @param objValue
	 */
	public void setActionParam(String strName, Object objValue) {
		actionParamMap.put(strName, objValue);
	}

	/**
	 * 移除操作参数
	 * 
	 * @param strName
	 * @return
	 */
	public Object removeActionParam(String strName) {
		return actionParamMap.remove(strName);
	}
	
	
	
	/**
	 * 判断是否存在指定操作参数
	 * @param strName
	 * @return
	 */
	public boolean containsActionParam(String strName){
		return actionParamMap.containsKey(strName);
	}

	/**
	 * 获取操作参数
	 * 
	 * @param strName
	 * @return
	 */
	public Object getActionParam(String strName) {
		return actionParamMap.get(strName);
	}
	
	
	/**
	 * 获取当前环境变量
	 * @param bIfCreate 不存在是否建立
	 * @return
	 */
	public IEntity getEnvEntity(boolean bIfCreate){
		if(this.envEntity == null){
			if(bIfCreate)
				this.envEntity = new SimpleEntity();
		}
		return this.envEntity;
	}
	
	
	/**
	 * 获取当前环境变量
	 * @return
	 */
	public IEntity getEnvEntity(){
		return getEnvEntity(false);
	}
	
	
	/**
	 * 重置当前环境变量
	 */
	public void resetEnvEntity(){
		this.envEntity = null;
	}
	
	/**
	 * 获取操作会话层级
	 * @return
	 */
	public int getLevel(){
		return this.nLevel;
	}
}
