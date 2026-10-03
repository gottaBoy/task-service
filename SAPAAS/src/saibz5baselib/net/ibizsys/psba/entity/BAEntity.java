package net.ibizsys.psba.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psba.core.IBATableModel;
import net.ibizsys.psba.dao.BASelectContext;

/**
 * 大数据架构数据对象
 * 
 * @author Administrator
 *
 */
public class BAEntity extends EntityBase implements IBAEntity {

	private String strRowKey = null;
	private java.sql.Timestamp createDate = null;
	private java.sql.Timestamp updateDate = null;
	private HashMap<String, ISimpleDataObject> familyMap = null;
	private Object familyMapLock = new Object();
	
	private final static String BAHPREFIX = "BAH$";

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.entity.IBAEntity#getRowKey()
	 */
	@Override
	public String getRowKey() {
		return strRowKey;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.entity.IBAEntity#setRowKey(java.lang.String)
	 */
	@Override
	public void setRowKey(String strRowKey) {
		this.strRowKey = strRowKey;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.entity.IBAEntity#getCreateDate()
	 */
	@Override
	public Timestamp getCreateDate() {
		return createDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.entity.IBAEntity#getUpdateDate()
	 */
	@Override
	public Timestamp getUpdateDate() {
		return updateDate;
	}

	@Override
	public ISimpleDataObject getFamily(String strFamily) throws Exception {
		return getFamily(strFamily, false);
	}

	@Override
	public ISimpleDataObject getFamily(String strFamily, boolean bCreateIfNotExists) throws Exception {

		synchronized (familyMapLock) {
			if (familyMap == null) {
				if (bCreateIfNotExists) {
					familyMap = new HashMap<String, ISimpleDataObject>();
				} else
					return null;
			}
			ISimpleDataObject iEntity = familyMap.get(strFamily);
			if (iEntity == null && bCreateIfNotExists) {
				iEntity = createFamily(strFamily);
				familyMap.put(strFamily, iEntity);
			}
			return iEntity;
		}
	}

	@Override
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public void setFamily(String strFamily, ISimpleDataObject iEntity) {
		synchronized (familyMapLock) {
			if (familyMap == null) {
				if (iEntity == null) return;
				familyMap = new HashMap<String, ISimpleDataObject>();
			}
			if (iEntity == null) {
				familyMap.remove(strFamily);
			} else {
				familyMap.put(strFamily, iEntity);
			}
		}
	}

	@Override
	public Iterator<String> getFamilyNames() {
		synchronized (familyMapLock) {
			if (familyMap == null) return null;
			return familyMap.keySet().iterator();
		}
	}

	@Override
	public ArrayList<IBAEntity> children(String strChildName) throws Exception {
		
		BASelectContext baSelectContext = new BASelectContext();
		return children(strChildName,baSelectContext);
	}
	
	
	

	@Override
	public ArrayList<IBAEntity> children(String strChildName, BASelectContext iBASelectContext) throws Exception {
		
		IBAEntityActionHelper iBAEntityActionHelper  = this.getBAActionHelper(true);
		if(StringHelper.isNullOrEmpty(this.getRowKey())){
			throw new Exception("没有指定行键值");
		}
		iBASelectContext.setRowKeyPrefix(this.getRowKey());
		IBATableModel iBATableModel =(IBATableModel)	iBAEntityActionHelper.getBASchemeModel().getBATable(strChildName, false);
		return iBAEntityActionHelper.getBASchemeModel().getBADAO(iBATableModel).executeSelectCmd(iBASelectContext);
	}

	/**
	 * 建立列族数据对象
	 * 
	 * @param strFamily
	 * @return
	 * @throws Exception
	 */
	protected IEntity createFamily(String strFamily) throws Exception {
		return new SimpleEntity();
	}
	
	@Override
	public void set(String strFamily, String strParamName, Object objValue) throws Exception {
		set(strFamily,  strParamName,  objValue,-1);
	}

	@Override
	public void set(String strFamily, String strParamName, Object objValue,long nTimeStamp) throws Exception {
		ISimpleDataObject iEntity = this.getFamily(strFamily, true);
		if (iEntity instanceof IDataObject) {
			IDataObject iDataObject = (IDataObject) iEntity;
			
			if(nTimeStamp !=-1){
				String strHistoryKey = BAHPREFIX+strParamName;
				Object objBAHistory = iDataObject.get(strHistoryKey);
				BAColumnHistory baColumnHistory = null;
				if(objBAHistory==null){
					baColumnHistory = new   BAColumnHistory();
					iDataObject.set(strHistoryKey, baColumnHistory);
				}
				else{
					if(!(objBAHistory instanceof BAColumnHistory)){
						throw new Exception("对象类型不正确");
					}
					
					baColumnHistory = (BAColumnHistory)objBAHistory;
				}
				
				baColumnHistory.setValue(nTimeStamp, objValue);
				//拿出最后的值
				objValue = baColumnHistory.getLastValue();
			}
			
			iDataObject.set(strParamName, objValue);
		} else {
			throw new Exception("数据类型不正确");
		}
	}
	
	

	@Override
	public IBAColumnHistory getBAColumnHistory(String strFamily, String strParamName) throws Exception {
		ISimpleDataObject iEntity = this.getFamily(strFamily, false);
		if(iEntity == null)
			return null;
	
		String strHistoryKey = BAHPREFIX+strParamName;
		Object objBAHistory = iEntity.get(strHistoryKey);
		if(objBAHistory==null){
			return null;
		}
		
		if(!(objBAHistory instanceof BAColumnHistory)){
			throw new Exception("对象类型不正确");
		}
		
		return (IBAColumnHistory)objBAHistory;
	}

	@Override
	public Object get(String strFamily, String strParamName) throws Exception {
		ISimpleDataObject iEntity = this.getFamily(strFamily);
		if (iEntity == null) return null;
		return iEntity.get(strParamName);
	}

	@Override
	public boolean isNull(String strFamily, String strParamName) throws Exception {
		ISimpleDataObject iEntity = this.getFamily(strFamily);
		if (iEntity == null) return true;
		return iEntity.isNull(strParamName);
	}

	@Override
	public boolean contains(String strFamily, String strParamName) throws Exception {
		ISimpleDataObject iEntity = this.getFamily(strFamily);
		if (iEntity == null) return false;
		return iEntity.contains(strParamName);
	}

	/**
	 * 获取BA操作辅助对象
	 * @param bMust 是否必须存在
	 * @return
	 */
	protected IBAEntityActionHelper getBAActionHelper(boolean bMust)throws Exception{
		IEntityActionHelper iEntityActionHelper = this.getActionHelper(bMust);
		if(iEntityActionHelper!=null)
		{
			if(iEntityActionHelper instanceof IBAEntityActionHelper){
				return (IBAEntityActionHelper)iEntityActionHelper;
			}
			throw new Exception("操作辅助对象类型不正确");
			
		}
		return null;
	}

	@Override
	public void create(String[] families) throws Exception {
		this.getBAActionHelper(true).create(this, families);
	}

	@Override
	public void update(String[] families) throws Exception {
		this.getBAActionHelper(true).create(this, families);
	}

	@Override
	public void save(String[] families) throws Exception {
		this.getBAActionHelper(true).create(this, families);
	}

	@Override
	public boolean get(String[] families, boolean bTryMode) throws Exception {
		return this.getBAActionHelper(true).get(this,families,bTryMode);
	}

	@Override
	public void get(String[] families) throws Exception {
		 this.getBAActionHelper(true).get(this,families,false);
	}
	
	
	
}
