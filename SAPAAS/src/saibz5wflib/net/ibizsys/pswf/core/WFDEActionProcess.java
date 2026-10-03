package net.ibizsys.pswf.core;

import net.ibizsys.paas.db.IProcParam;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.DefaultValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;

/**
 * 流程实体操作处理对象
 * @author lionlau
 *
 */
public class WFDEActionProcess extends WFProcessBase
{
	/**
	 * 获取实体行为处理模型
	 * @return
	 */
	public IWFDEActionProcessModel getWFDEActionProcessModel()
	{
		return (IWFDEActionProcessModel)this.getWFProcessModel();
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.WFProcessBase#execute(net.ibizsys.pswf.core.IWFActionContext)
	 */
	@Override
	public void execute(IWFActionContext iWFActionContext) throws Exception
	{
		if(!StringHelper.isNullOrEmpty(getWFDEActionProcessModel().getDEActionName()))
		{
			String strDataKey = iWFActionContext.getWFActionParam().getUserData();
			String strDEName = iWFActionContext.getWFActionParam().getUserData4();
			
			
			IDataEntityModel iDataEntityModel = iWFActionContext.getWFModel().getSystemModel().getDataEntityModel(strDEName);
			IService iService = iDataEntityModel.getService();
			IEntity iEntity =  iWFActionContext.getActiveEntity();// iDataEntityModel.createEntity();
			//iEntity.set(iDataEntityModel.getKeyDEField().getName(), strDataKey);
			iEntity.set(IProcParam.TAG_PERSONID, iWFActionContext.getOpPersonId());
			//循环设置参数
			java.util.Iterator<IWFDEActionProcessParamModel> wfDEActionProcessParamModels =  getWFDEActionProcessModel().getWFDEActionProcessParamModels();
			while(wfDEActionProcessParamModels.hasNext())
			{
				IWFDEActionProcessParamModel iWFDEActionProcessParamModel = wfDEActionProcessParamModels.next();
				iEntity.set(iWFDEActionProcessParamModel.getDstField(), getSrcValue(iWFDEActionProcessParamModel));
			}
			
			if(StringHelper.isNullOrEmpty(getWFDEActionProcessModel().getDEActionName()))
			{
				iService.updateWFInfo(IService.UPDATEWFINFOMODE_UPDATESTATE, iWFActionContext, iEntity);
			}
			else
			{
				iService.executeAction(getWFDEActionProcessModel().getDEActionName(),iEntity);
			}
		}
		
		super.execute(iWFActionContext);
	}
	
	
	/**
	 * 获取源值
	 * @param iWFDEActionProcessParamModel
	 * @return
	 * @throws Exception
	 */
	protected String getSrcValue(IWFDEActionProcessParamModel iWFDEActionProcessParamModel)throws Exception
	{
		return DefaultValueHelper.getValue(WebContext.getCurrent(), iWFDEActionProcessParamModel.getSrcValueType(), iWFDEActionProcessParamModel.getSrcValue());
	}
}
