package net.ibizsys.paas.cache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ISFSAction;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.StringHelper;

/**
 * 统一状态事物会话工厂会话操作
 * @author Administrator
 *
 */
public class UniStateSFSAction implements ISFSAction {

	private static final Log log = LogFactory.getLog(UniStateSFSAction.class);
	
	private IUniStateModel iUniStateModel = null;
	private IEntity iEntity = null;
	private String strAction = null;
	
	public UniStateSFSAction(IUniStateModel iUniStateModel,IEntity iEntity,String strAction){
		this.iUniStateModel = iUniStateModel;
		this.iEntity = iEntity;
		this.strAction = strAction;
	}

	@Override
	public void commit() {
		try{
			if(StringHelper.compare(this.strAction, IService.ACTION_UPDATE, false) == 0){
				iUniStateModel.update(iEntity);
				return;
			}
			
			if(StringHelper.compare(this.strAction, IService.ACTION_REMOVE, false) == 0){
				iUniStateModel.remove(iEntity.get(iUniStateModel.getKeyField()));
				return;
			}
		}
		catch(Exception ex){
			log.error(ex);
		}
	}

	@Override
	public void rollback() {
		try{
			
		}
		catch(Exception ex){
			log.error(ex);
		}
	}
	
	
	
	
	
	
}
