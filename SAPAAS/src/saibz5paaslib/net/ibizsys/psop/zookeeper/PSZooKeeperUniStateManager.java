package net.ibizsys.psop.zookeeper;

import net.ibizsys.paas.cache.IUniState;
import net.ibizsys.paas.cache.IUniStateManager;
import net.ibizsys.paas.cache.IUniStateModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.util.StringHelper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ZooKeeper 统一状态协同器
 * @author Administrator
 *
 */
public class PSZooKeeperUniStateManager implements IUniStateManager {
	
	
	private static final Log log = LogFactory.getLog(PSZooKeeperUniStateManager.class);
	
	//private PSEntityKeeperGlobal psEntityKeeperGlobal = new PSEntityKeeperGlobal();
	
	
	@Override
	public void regUniState(IUniState iUniState) throws Exception {
		IUniStateModel iUniStateModel = (IUniStateModel)iUniState;
		PSEntityKeeperGlobal.getCurrent().registerPSEntity(iUniStateModel.getId(), iUniStateModel.getKeyField(),iUniStateModel.getFolderFields(),iUniStateModel.getStateFields(),null);
	}


	@Override
	public void unregUniState(IUniState iUniState) throws Exception {
		throw new Exception("没有实现");
		//PSEntityKeeperGlobal.getCurrent().
	}


	@Override
	public boolean containsUniState(IUniState iUniState) throws Exception {
		return PSEntityKeeperGlobal.getCurrent().isRegisterPSEntity(iUniState.getId());
	}


	@Override
	public boolean getEntity(IUniState iUniState, IEntity iEntity) throws Exception {
		return PSEntityKeeperGlobal.getCurrent().getPSEntity(iUniState.getId(), iEntity);
	}


	@Override
	public boolean getEntity(IUniState iUniState, IEntity iEntity, boolean bForceUpdate) throws Exception {
		return PSEntityKeeperGlobal.getCurrent().getPSEntity(iUniState.getId(), iEntity,bForceUpdate);
	}


	@Override
	public Object getEntityState(IUniState iUniState, Object objKey, String strStateField) throws Exception {
		return getEntityState(iUniState,objKey,strStateField,false);
	}


	@Override
	public Object getEntityState(IUniState iUniState, Object objKey, String strStateField, boolean bForceUpdate) throws Exception {
		SimpleEntity simpleEntity = new SimpleEntity();
		simpleEntity.set(iUniState.getKeyField(), objKey);
		if(PSEntityKeeperGlobal.getCurrent().getPSEntity(iUniState.getId(),  simpleEntity,bForceUpdate)){
			if(StringHelper.isNullOrEmpty(strStateField)){
				return simpleEntity.get(iUniState.getStateField());
			}
			else{
				return simpleEntity.get(strStateField);
			}
		}
		return null;
	}


	@Override
	public boolean containsEntity(IUniState iUniState, IEntity iEntity) throws Exception {
		return PSEntityKeeperGlobal.getCurrent().hasPSEntity(iUniState.getId(), iEntity);
	}


	@Override
	public boolean containsEntity(IUniState iUniState, Object objKey) throws Exception {
		return PSEntityKeeperGlobal.getCurrent().hasPSEntity(iUniState.getId(), objKey);
	}


	@Override
	public void removeEntity(IUniState iUniState, IEntity iEntity) throws Exception {
		PSEntityKeeperGlobal.getCurrent().removePSEntity(iUniState.getId(), iEntity);
	}


	@Override
	public void removeEntity(IUniState iUniState, Object objKey) throws Exception {
		PSEntityKeeperGlobal.getCurrent().removePSEntity(iUniState.getId(),  objKey);
	}


	@Override
	public void updateEntity(IUniState iUniState, IEntity iEntity) throws Exception {
		PSEntityKeeperGlobal.getCurrent().updatePSEntity(iUniState.getId(), iEntity, true);
	}

}
