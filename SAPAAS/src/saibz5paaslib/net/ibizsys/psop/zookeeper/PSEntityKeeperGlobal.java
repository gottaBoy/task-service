package net.ibizsys.psop.zookeeper;

import java.util.HashMap;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 数据对象管理全局类
 * @author Administrator
 *
 */
public class PSEntityKeeperGlobal {

	private static final Log log = LogFactory.getLog(PSEntityKeeperGlobal.class);
	
	static PSEntityKeeperGlobal psEntityKeeperGlobal = null;
	
	public static synchronized PSEntityKeeperGlobal getCurrent() throws Exception {
		if (psEntityKeeperGlobal == null) {
			PSEntityKeeperGlobal item = new PSEntityKeeperGlobal();
			psEntityKeeperGlobal = item;
		}
		return psEntityKeeperGlobal;
	}
	
	protected HashMap<String, PSEntityStruct> psEntityStructMap = new HashMap<String, PSEntityStruct>();
	
	/**
	 * 注册要监控的数据对象
	 * @param strEntityName
	 * @param strEntityKey
	 * @param fields
	 * @param strCat
	 * @throws Exception
	 */
	public void registerPSEntity(String strEntityName,String strEntityKey,String[] fields)throws Exception{
		registerPSEntity(strEntityName,strEntityKey,fields,null);
	}
	
	
	/**
	 * 注册要监控的数据对象
	 * @param strEntityName
	 * @param strEntityKey
	 * @param fields
	 * @param strCat
	 * @throws Exception
	 */
	public void registerPSEntity(String strEntityName,String strEntityKey,String[] fields,String strCat)throws Exception{
		registerPSEntity(strEntityName,strEntityKey,null,fields,strCat);
	}
	
	/**
	 * 注册要监控的数据对象
	 * @param strEntityName
	 * @param strEntityKey
	 * @param fields
	 * @param strCat
	 * @throws Exception
	 */
	public void registerPSEntity(String strEntityName,String strEntityKey,String[] folders,String[] fields,String strCat)throws Exception{
		PSEntityStruct psEntityStruct = new PSEntityStruct();
		psEntityStruct.setEntityName(strEntityName);
		psEntityStruct.setKeyName(strEntityKey);
		psEntityStruct.setFolders(folders);
		psEntityStruct.setFields(fields);
		psEntityStruct.setCat(strCat);
		synchronized(psEntityStructMap){
			if(!psEntityStructMap.containsKey(strEntityName))
				psEntityStructMap.put(strEntityName, psEntityStruct);
		}
	}
	
	
	
	
	
	/**
	 * 更新数据实体
	 * @param strEntityName
	 * @param iEntity
	 * @param bCreate
	 * @throws Exception
	 */
	public void updatePSEntity(String strEntityName,IEntity iEntity,boolean bCreate)throws Exception{
		PSEntityStruct psEntityStruct = null;
		
		psEntityStruct = psEntityStructMap.get(strEntityName);
		if(psEntityStruct==null){
			throw new Exception(StringHelper.format("数据对象[%1$s]还未注册",strEntityName));
		}
		
		psEntityStruct.updatePSEntity(iEntity, bCreate);
	}
	
	
	/**
	 * 检查是否有指定数据实体
	 * @param strEntityName
	 * @param iEntity
	 * @throws Exception
	 */
	public boolean hasPSEntity(String strEntityName,IEntity iEntity)throws Exception{
		PSEntityStruct psEntityStruct = null;
		
		psEntityStruct = psEntityStructMap.get(strEntityName);
		if(psEntityStruct==null){
			throw new Exception(StringHelper.format("数据对象[%1$s]还未注册",strEntityName));
		}
		
		return psEntityStruct.hasPSEntity(iEntity);
	}
	
	
	/**
	 * 检查是否有指定数据实体
	 * @param strEntityName
	 * @param objKey
	 * @throws Exception
	 */
	public boolean hasPSEntity(String strEntityName,Object objKey)throws Exception{
		PSEntityStruct psEntityStruct = null;
		
		psEntityStruct = psEntityStructMap.get(strEntityName);
		if(psEntityStruct==null){
			throw new Exception(StringHelper.format("数据对象[%1$s]还未注册",strEntityName));
		}
		
		return psEntityStruct.hasPSEntity(objKey);
	}
	
	
	
	/**
	 * @param strEntityName
	 * @param iEntity
	 * @param bUpdateNow 重新拿 
	 * @return
	 * @throws Exception
	 */
	public boolean getPSEntity(String strEntityName,IEntity iEntity)throws Exception{
		return getPSEntity(strEntityName,iEntity,false);
	}
	
	/**
	 * 获取数据对象
	 * @param strEntityName
	 * @param iEntity
	 * @param bUpdateNow 重新拿 
	 * @return
	 * @throws Exception
	 */
	public boolean getPSEntity(String strEntityName,IEntity iEntity,boolean bUpdateNow)throws Exception{
		PSEntityStruct psEntityStruct = null;
		psEntityStruct = psEntityStructMap.get(strEntityName);
		if(psEntityStruct==null){
			throw new Exception(StringHelper.format("数据对象[%1$s]还未注册",strEntityName));
		}
		return psEntityStruct.getPSEntity(iEntity,bUpdateNow);
	}
	
	
	/**
	 * 移除数据实体
	 * @param strEntityName
	 * @param iEntity
	 */
	public void removePSEntity(String strEntityName,IEntity iEntity)throws Exception{
		PSEntityStruct psEntityStruct = null;
		psEntityStruct = psEntityStructMap.get(strEntityName);
		if(psEntityStruct==null){
			throw new Exception(StringHelper.format("数据对象[%1$s]还未注册",strEntityName));
		}
		psEntityStruct.removePSEntity(iEntity);
	}
	
	/**
	 * 移除数据实体
	 * @param strEntityName
	 * @param objKeyValue
	 */
	public void removePSEntity(String strEntityName,Object objKeyValue)throws Exception{
		PSEntityStruct psEntityStruct = null;
		psEntityStruct = psEntityStructMap.get(strEntityName);
		if(psEntityStruct==null){
			throw new Exception(StringHelper.format("数据对象[%1$s]还未注册",strEntityName));
		}
		psEntityStruct.removePSEntity(objKeyValue);
	}
	
	/**
	 * 判断是否已经注册了实体对象
	 * @param strEntityName
	 * @return
	 */
	public boolean isRegisterPSEntity(String strEntityName){
		return psEntityStructMap.containsKey(strEntityName);
	}
	
	/**
	 * 判断指定数据实体是否已经连接
	 * @param strEntityName
	 * @throws Exception
	 */
	public boolean isPSEntityEnabled(String strEntityName)throws Exception{
		PSEntityStruct psEntityStruct = null;
		
		psEntityStruct = psEntityStructMap.get(strEntityName);
		if(psEntityStruct==null){
			throw new Exception(StringHelper.format("数据对象[%1$s]还未注册",strEntityName));
		}
		
		return PSZooKeeper.getInstance(psEntityStruct.getCat()).isConnected();
	}
	
}
