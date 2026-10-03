package net.ibizsys.paas.dts;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ISFSAction;

/**
 * 分布事物队列会话工厂会话操作
 * @author Administrator
 *
 */
public class DTSQueueSFSAction implements ISFSAction {

	private static final Log log = LogFactory.getLog(DTSQueueSFSAction.class);
	
	private IDTSQueueModel iDTSQueueModel = null;
	private IEntity iEntity = null;
	
	public DTSQueueSFSAction(IDTSQueueModel iDTSQueueModel,IEntity iEntity){
		this.iDTSQueueModel = iDTSQueueModel;
		this.iEntity = iEntity;
	}

	@Override
	public void commit() {
		try{
			iDTSQueueModel.push(iEntity);
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
