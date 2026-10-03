package net.ibizsys.paas.cache;

import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.StringHelper;

/**
 * 实体统一状态模型对象
 * @author Administrator
 *
 */
public class DEUniStateModel extends UniStateModelBase {

	private IService iService = null;
	private IDataEntityModel iDEModel = null;
	
	@Override
	protected void onInit() throws Exception {
		this.iDEModel = this.getSystemModel().getDataEntityModel(this.getDEName());
		this.iService = this.iDEModel.getService();
				
		super.onInit();
	}

	

	

	

	@Override
	public IEntity update(Object objKey) throws Exception {
		this.testEnabled();
		IEntity iEntity = iDEModel.createEntity();
		iEntity.set(iDEModel.getKeyDEField().getName(), objKey);
		this.iService.get(iEntity);
		this.update(iEntity);
		return iEntity;
	}



	@Override
	public IEntity get(Object objKey, boolean bForceUpdate) throws Exception {
		this.testEnabled();
		if(this.getUniStateManager().containsEntity(this, objKey)){
			IEntity iEntity = this.iDEModel.createEntity();
			iEntity.set(iDEModel.getKeyDEField().getName(), objKey);
			if(this.getUniStateManager().getEntity(this, iEntity,bForceUpdate))
				return iEntity;
			return null;
		}
		else{
			//不存在
			return update(objKey);
		}
	}





	@Override
	public IEntity get(Object objKey) throws Exception {
		this.testEnabled();
		if(this.getUniStateManager().containsEntity(this, objKey)){
			IEntity iEntity = this.iDEModel.createEntity();
			iEntity.set(iDEModel.getKeyDEField().getName(), objKey);
			if(this.getUniStateManager().getEntity(this, iEntity))
				return iEntity;
			return null;
		}
		else{
			//不存在
			return update(objKey);
		}
	}





	@Override
	public Object get(Object objKey, String strStateField) throws Exception {
		this.testEnabled();
		if(StringHelper.isNullOrEmpty(strStateField)){
			if(this.getUniStateManager().containsEntity(this, objKey)){
				return this.getUniStateManager().getEntityState(this, objKey, this.getStateField());
			}
			return update(objKey).get(this.getStateField());
		}
		else{
			if(this.getUniStateManager().containsEntity(this, objKey)){
				return this.getUniStateManager().getEntityState(this, objKey, strStateField);
			}
			return update(objKey).get(strStateField);
		}
		
	}





	@Override
	public Object get(Object objKey, String strStateField, boolean bForceUpdate) throws Exception {
		this.testEnabled();
		if(StringHelper.isNullOrEmpty(strStateField)){
			if(this.getUniStateManager().containsEntity(this, objKey)){
				return this.getUniStateManager().getEntityState(this, objKey, this.getStateField(),bForceUpdate);
			}
			return update(objKey).get(this.getStateField());
		}
		else{
			if(this.getUniStateManager().containsEntity(this, objKey)){
				return this.getUniStateManager().getEntityState(this, objKey, strStateField,bForceUpdate);
			}
			return update(objKey).get(strStateField);
		}
	}







	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IUniState#getUniStateType()
	 */
	@Override
	public String getUniStateType() {
		return UNISTATETYPE_DE;
	}



	
	
}
