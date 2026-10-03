package net.ibizsys.psop.zookeeper;

import java.util.HashMap;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;

/**
 * 数据对象结构
 * @author Administrator
 *
 */
public class PSEntityStruct {

	String strEntityName = null;
	String [] folders = null;
	String strKeyName = null;
	String[] fields  = null;
	String strCat = null;
	String strPath = null;
	
	private HashMap<String,PSEntityKeeper> psEntityKeeperMap = new HashMap<String,PSEntityKeeper>();
	
	/**
	 * 获取实体名称
	 * @return
	 */
	public String getEntityName() {
		return strEntityName;
	}
	
	
	/**
	 * 设置实体名称
	 * @param strEntityName
	 */
	public void setEntityName(String strEntityName) {
		this.strEntityName = strEntityName;
		strPath = StringHelper.format("/%1$s",this.strEntityName);
	}
	
	
	/**
	 * 获取实体的主键名称
	 * @return
	 */
	public String getKeyName() {
		return strKeyName;
	}
	
	
	/**
	 * 设置实体的主键名称
	 * @param strKeyName
	 */
	public void setKeyName(String strKeyName) {
		this.strKeyName = strKeyName;
	}
	
	
	/**
	 * 获取实体的额外目录字段
	 * @return
	 */
	public String[] getFolders() {
		return folders;
	}
	
	
	/**
	 * 设置实体的额外目录字段
	 * @param folders
	 */
	public void setFolders(String[] folders) {
		this.folders = folders;
	}
	
	
	
	/**
	 * 获取实体的关注字段
	 * @return
	 */
	public String[] getFields() {
		return fields;
	}
	
	
	/**
	 * 设置实体的关注字段
	 * @param fields
	 */
	public void setFields(String[] fields) {
		this.fields = fields;
	}
	
	
	/**
	 * 获取ZooKeeper分类
	 * @return
	 */
	public String getCat() {
		return strCat;
	}
	
	/**
	 * 设置ZooKeeper分类
	 * @return
	 */
	public void setCat(String strCat) {
		this.strCat = strCat;
	}
	
	
	/**
	 * 获取目录
	 * @return
	 */
	public String getPath(){
		return strPath;
	}
	
	
	
	public boolean getPSEntity(IEntity iEntity,boolean bUpdateNow)throws Exception{
		String strKeyValue = DataObject.getStringValue(iEntity.get(this.getKeyName()), null);
		if(StringHelper.isNullOrEmpty(strKeyValue)){
			throw new Exception("未指定数据主键");
		}
		
		PSEntityKeeper psEntityKeeper = psEntityKeeperMap.get(strKeyValue);
		if(psEntityKeeper == null)
			return false;
		
		psEntityKeeper.getPSEntity(iEntity, bUpdateNow);
		return true;
	}
	
	
	public void updatePSEntity(IEntity iEntity,boolean bCreate)throws Exception{
		String strKeyValue = DataObject.getStringValue(iEntity.get(this.getKeyName()), null);
		if(StringHelper.isNullOrEmpty(strKeyValue)){
			throw new Exception("未指定数据主键");
		}
		
		PSEntityKeeper psEntityKeeper = psEntityKeeperMap.get(strKeyValue);
		if(psEntityKeeper == null)
		{
			if(bCreate){
				psEntityKeeper = new PSEntityKeeper(PSZooKeeper.getInstance(this.getCat()),this,iEntity);
				psEntityKeeperMap.put(strKeyValue, psEntityKeeper);
			}
			return;
		}
		
		psEntityKeeper.updatePSEntity(iEntity);
	}

	
	/**
	 * 是否包含指定数据对象
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	public boolean hasPSEntity(IEntity iEntity)throws Exception{
		String strKeyValue = DataObject.getStringValue(iEntity.get(this.getKeyName()), null);
		if(StringHelper.isNullOrEmpty(strKeyValue)){
			throw new Exception("未指定数据主键");
		}	
		PSEntityKeeper psEntityKeeper = psEntityKeeperMap.get(strKeyValue);
		return psEntityKeeper!=null;
	}
	
	
	/**
	 * 是否包含指定数据对象
	 * @param objValue
	 * @return
	 * @throws Exception
	 */
	public boolean hasPSEntity(Object objValue)throws Exception{
		String strKeyValue = DataObject.getStringValue(objValue, null);
		if(StringHelper.isNullOrEmpty(strKeyValue)){
			throw new Exception("未指定数据主键");
		}	
		PSEntityKeeper psEntityKeeper = psEntityKeeperMap.get(strKeyValue);
		return psEntityKeeper!=null;
	}
	
	
	public void removePSEntity(IEntity iEntity)throws Exception{
		String strKeyValue = DataObject.getStringValue(iEntity.get(this.getKeyName()), null);
		if(StringHelper.isNullOrEmpty(strKeyValue)){
			throw new Exception("未指定数据主键");
		}
		removePSEntity(strKeyValue);
	}
	
	public void removePSEntity(Object objValue)throws Exception{
		String strKeyValue = DataObject.getStringValue(objValue, null);
		if(StringHelper.isNullOrEmpty(strKeyValue)){
			throw new Exception("未指定数据主键");
		}	
		PSEntityKeeper psEntityKeeper = psEntityKeeperMap.remove(strKeyValue);
		if(psEntityKeeper == null)
		{
			return;
		}
		
		psEntityKeeper.close();
	}
	
	
}
