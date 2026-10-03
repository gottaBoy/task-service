package net.ibizsys.paas.cache;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.SystemModelObjectBase;
import net.ibizsys.paas.util.StringHelper;

/**
 * 系统统一状态协同对象模型
 * @author Administrator
 *
 */
public abstract class UniStateModelBase extends SystemModelObjectBase implements IUniStateModel {

	/**
	 * 唯一业务标识
	 */
	private String strUniqueTag = null;
	
	
	
	/**
	 * 相关的实体名称
	 */
	private String strDEName = null;
	
	
	
	
	/**
	 * 主键属性
	 */
	private String strKeyField = null;
	
	
	/**
	 * 目录属性
	 */
	private String strFolderField = null;
	
	
	
	/**
	 * 目录2属性
	 */
	private String strFolder2Field = null;
	
	/**
	 * 目录3属性
	 */
	private String strFolder3Field = null;
	
	/**
	 * 状态属性
	 * 
	 */
	private String strStateField = null;
	
	
	/**
	 * 状态2属性
	 */
	private String strState2Field = null;
	
	
	/**
	 * 状态3属性
	 * 
	 */
	private String strState3Field = null;
	
	
	
	/**
	 * 状态4属性
	 * 
	 */
	private String strState4Field = null;
	
	
	
	
	/**
	 * 状态5属性
	 * 
	 */
	private String strState5Field = null;
	
	
	
	
	/**
	 * 状态6属性
	 * 
	 */
	private String strState6Field = null;
	
	
	
	

	/**
	 * 状态7属性
	 * 
	 */
	private String strState7Field = null;
	
	
	
	

	/**
	 * 状态8属性
	 * 
	 */
	private String strState8Field = null;
	
	private HashMap<String, String> stateFieldMap = new HashMap<String, String>();
	private String[] statefields = null;
	private String[] folderfields = null;
	
	private boolean bEnabled = false;
	
	private IUniStateManager iUniStateManager = null;
	
	@Override
	public void init(ISystemModel iSystemModel) throws Exception {
		this.setSystemModel(iSystemModel);
		
		
		stateFieldMap.put(STATE,this.getStateField());
		stateFieldMap.put(STATE2,this.getState2Field());
		stateFieldMap.put(STATE3,this.getState3Field());
		stateFieldMap.put(STATE4,this.getState4Field());
		stateFieldMap.put(STATE5,this.getState5Field());
		stateFieldMap.put(STATE6,this.getState6Field());
		stateFieldMap.put(STATE7,this.getState7Field());
		stateFieldMap.put(STATE8,this.getState8Field());
		
		
		ArrayList<String> stateFieldsList = new ArrayList<String>();
		if(!StringHelper.isNullOrEmpty(this.getStateField())){
			stateFieldsList.add(this.getStateField());
		}
		
		if(!StringHelper.isNullOrEmpty(this.getState2Field())){
			stateFieldsList.add(this.getState2Field());
		}
		
		if(!StringHelper.isNullOrEmpty(this.getState3Field())){
			stateFieldsList.add(this.getState3Field());
		}
		
		if(!StringHelper.isNullOrEmpty(this.getState4Field())){
			stateFieldsList.add(this.getState4Field());
		}
		
		if(!StringHelper.isNullOrEmpty(this.getState5Field())){
			stateFieldsList.add(this.getState5Field());
		}
		
		if(!StringHelper.isNullOrEmpty(this.getState6Field())){
			stateFieldsList.add(this.getState6Field());
		}
		
		if(!StringHelper.isNullOrEmpty(this.getState7Field())){
			stateFieldsList.add(this.getState7Field());
		}
		
		if(!StringHelper.isNullOrEmpty(this.getState8Field())){
			stateFieldsList.add(this.getState8Field());
		}
		
		this.statefields = stateFieldsList.toArray(new String[stateFieldsList.size()]);
		
		ArrayList<String> folderFieldsList = new ArrayList<String>();
		if(!StringHelper.isNullOrEmpty(this.getFolderField())){
			folderFieldsList.add(this.getFolderField());
		}
		if(!StringHelper.isNullOrEmpty(this.getFolder2Field())){
			folderFieldsList.add(this.getFolder2Field());
		}
		if(!StringHelper.isNullOrEmpty(this.getFolder3Field())){
			folderFieldsList.add(this.getFolder3Field());
		}
		
		this.folderfields = folderFieldsList.toArray(new String[folderFieldsList.size()]);
		
		
		this.onInit();
		
		if(this.getSystemModel().getUniStateManager()!=null){
			this.iUniStateManager = this.getSystemModel().getUniStateManager();
			this.iUniStateManager.regUniState(this);
			bEnabled = true;
		}
	}
	
	/**
	 * 设置标识
	 * @param strId
	 */
	public void setId(String strId){
		this.strId = strId;
	}
	
	/**
	 * 设置名称
	 * @param strName
	 */
	public void setName(String strName){
		this.strName = strName;
	}
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IUniState#getUniqueTag()
	 */
	@Override
	public String getUniqueTag() {
		return strUniqueTag;
	}

	/**
	 * 设置统一业务标识
	 * @param strUniqueTag
	 */
	public void setUniqueTag(String strUniqueTag) {
		this.strUniqueTag = strUniqueTag;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IUniState#getDEName()
	 */
	@Override
	public String getDEName() {
		return strDEName;
	}

	/**
	 * 设置实体名称
	 * @param strDEName
	 */
	public void setDEName(String strDEName) {
		this.strDEName = strDEName;
	}

	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IUniState#getKeyField()
	 */
	@Override
	public String getKeyField() {
		return strKeyField;
	}

	/**
	 * 设置键值属性
	 * @param strKeyField
	 */
	public void setKeyField(String strKeyField) {
		this.strKeyField = strKeyField;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IUniState#getFolderField()
	 */
	@Override
	public String getFolderField() {
		return strFolderField;
	}

	
	/**
	 * 设置目录属性
	 * @param strFolderField
	 */
	public void setFolderField(String strFolderField) {
		this.strFolderField = strFolderField;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IUniState#getFolder2Field()
	 */
	@Override
	public String getFolder2Field() {
		return strFolder2Field;
	}

	/**
	 * 设置目录2属性
	 * @param strFolder2Field
	 */
	public void setFolder2Field(String strFolder2Field) {
		this.strFolder2Field = strFolder2Field;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IUniState#getFolder3Field()
	 */
	@Override
	public String getFolder3Field() {
		return strFolder3Field;
	}

	/**
	 * 设置目录2属性
	 * @param strFolder3Field
	 */
	public void setFolder3Field(String strFolder3Field) {
		this.strFolder3Field = strFolder3Field;
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IUniState#getStateField()
	 */
	@Override
	public String getStateField() {
		return strStateField;
	}

	/**
	 * 设置状态属性
	 * @param strStateField
	 */
	public void setStateField(String strStateField) {
		this.strStateField = strStateField;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IUniState#getState2Field()
	 */
	@Override
	public String getState2Field() {
		return strState2Field;
	}

	/**
	 * 设置状态2属性
	 * @param strState2Field
	 */
	public void setState2Field(String strState2Field) {
		this.strState2Field = strState2Field;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IUniState#getState3Field()
	 */
	@Override
	public String getState3Field() {
		return strState3Field;
	}

	/**
	 * 设置状态3属性
	 * @param strState3Field
	 */
	public void setState3Field(String strState3Field) {
		this.strState3Field = strState3Field;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IUniState#getState4Field()
	 */
	@Override
	public String getState4Field() {
		return strState4Field;
	}

	/**
	 * 设置状态4属性
	 * @param strState4Field
	 */
	public void setState4Field(String strState4Field) {
		this.strState4Field = strState4Field;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IUniState#getState5Field()
	 */
	@Override
	public String getState5Field() {
		return strState5Field;
	}

	/**
	 * 设置状态5属性
	 * @param strState5Field
	 */
	public void setState5Field(String strState5Field) {
		this.strState5Field = strState5Field;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IUniState#getState6Field()
	 */
	@Override
	public String getState6Field() {
		return strState6Field;
	}
	
	/**
	 * 设置状态6属性
	 * @param strState6Field
	 */
	public void setState6Field(String strState6Field) {
		this.strState6Field = strState6Field;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IUniState#getState7Field()
	 */
	@Override
	public String getState7Field() {
		return strState7Field;
	}

	/**
	 * 设置状态7属性
	 * @param strState7Field
	 */
	public void setState7Field(String strState7Field) {
		this.strState7Field = strState7Field;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IUniState#getState8Field()
	 */
	@Override
	public String getState8Field() {
		return strState8Field;
	}

	/**
	 * 设置状态8属性
	 * @param strState8Field
	 */
	public void setState8Field(String strState8Field) {
		this.strState8Field = strState8Field;
	}

	

	@Override
	public String[] getFolderFields() {
		return this.folderfields;
	}

	@Override
	public String[] getStateFields() {
		return this.statefields;
	}
	
	@Override
	public boolean contains(Object objKey) throws Exception {
		testEnabled();
		return this.getUniStateManager().containsEntity(this, objKey);
	}

	@Override
	public boolean isEnabled() {
		return this.bEnabled;
	}
	
	
	/**
	 * 获取统一状态管理对象
	 * @return
	 */
	protected IUniStateManager getUniStateManager(){
		return this.iUniStateManager;
	}
	
	protected void testEnabled()throws Exception{
		if(!isEnabled()){
			throw new Exception(StringHelper.format("统一状态对象[%1$s]没有启用",this.getName()));
		}
	}
	

	

	@Override
	public void update(IEntity iEntity) throws Exception{
		testEnabled();
		this.getUniStateManager().updateEntity(this, iEntity);
		
	}
	
	
	
	@Override
	public void remove(Object objKey) throws Exception {
		testEnabled();
		this.getUniStateManager().removeEntity(this, objKey);
	}
}
