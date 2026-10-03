package net.ibizsys.paas.service;

import java.util.HashMap;

import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;

/**
 * 复制会话管理
 * 
 * @author lionlau
 *
 */
public class CloneSession {
	protected HashMap<String, HashMap<Object, IEntity>> classEntityMap = new HashMap<String, HashMap<Object, IEntity>>();
	private String strOwner = "";
	private boolean bFromSource = false;
	private IEntity sourceObject = null;

	/**
	 * 获取克隆的数据对象
	 * 
	 * @param strDEName
	 * @param objKey
	 * @return
	 */
	public IEntity getEntity(String strDEName, Object objKey) {
		HashMap<Object, IEntity> entityMap = classEntityMap.get(strDEName);
		if (entityMap != null) {
			return entityMap.get(objKey);
		}
		return null;
	}

	public void setEntity(String strDEName, Object objKey, IEntity iEntity) throws Exception {
		setEntity(DEModelGlobal.getDEModel(strDEName),objKey,iEntity);
	}
	/**
	 * 设置克隆的数据对象
	 * 
	 * @param iDataEntityModel
	 * @param objKey
	 * @param iEntity
	 * @throws Exception
	 */
	public void setEntity(IDataEntityModel iDataEntityModel, Object objKey, IEntity iEntity) throws Exception {
		String strDEName = iDataEntityModel.getName();
		HashMap<Object, IEntity> entityMap = classEntityMap.get(strDEName);
		if (entityMap == null) {
			entityMap = new HashMap<Object, IEntity>();
			classEntityMap.put(strDEName, entityMap);
		}
		entityMap.put(objKey, iEntity);

		IDataEntityModel inheritDEModel = iDataEntityModel.getInheritDEModel();
		if (inheritDEModel == null) return;

		IEntity iEntity2 = inheritDEModel.createEntity();
		iEntity.copyTo(iEntity2, false);
		iEntity2.set(inheritDEModel.getKeyDEField().getName(), iEntity.get(iDataEntityModel.getKeyDEField().getName()));
		iEntity2.set(inheritDEModel.getMajorDEField().getName(), iEntity.get(iDataEntityModel.getMajorDEField().getName()));
		setEntity(inheritDEModel, objKey, iEntity2);
	}

	/**
	 * 设置所有者
	 * 
	 * @return
	 */
	public void setOwner(String strOwner) {
		this.strOwner = strOwner;
	}

	/**
	 * 获取所有者
	 * 
	 * @return
	 */
	public String getOwner() {
		return this.strOwner;
	}

	/**
	 * 设置是否从源克隆
	 * 
	 * @param bFromSource
	 */
	public void setFromSource(boolean bFromSource) {
		this.bFromSource = bFromSource;
	}

	/**
	 * 是否从源克隆
	 * 
	 * @return
	 */
	public boolean isFromSource() {
		return this.bFromSource;
	}

	/**
	 * 设置源复制对象
	 * 
	 * @param sourceObject
	 */
	public void setSourceObject(IEntity sourceObject) {
		this.sourceObject = sourceObject;
	}

	/**
	 * 获取源复制对象
	 * 
	 * @return
	 */
	public IEntity getSourceObject() {
		return this.sourceObject;
	}

}
