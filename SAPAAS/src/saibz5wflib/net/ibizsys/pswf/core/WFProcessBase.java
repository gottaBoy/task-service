package net.ibizsys.pswf.core;

import net.ibizsys.paas.logic.ICondition;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.DefaultValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;

/**
 * 流程处理基对象
 * @author lionlau
 *
 */
public abstract class WFProcessBase implements IWFProcess
{
	private IWFProcessModel iWFProcessModel = null;

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcess#init(net.ibizsys.pswf.core.IWFProcessModel)
	 */
	@Override
	public void init(IWFProcessModel iWFProcessModel) throws Exception
	{
		this.iWFProcessModel = iWFProcessModel;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcess#execute(net.ibizsys.pswf.core.IWFActionContext)
	 */
	@Override
	public void execute(IWFActionContext iWFActionContext) throws Exception
	{
		java.util.Iterator<IWFLinkModel> wfLinkModels = this.getWFProcessModel().getWFLinkModels();
		if(wfLinkModels!=null){
			while(wfLinkModels.hasNext())
			{
				IWFLinkModel iWFLinkModel = wfLinkModels.next();
				if(iWFLinkModel instanceof IWFRouteLinkModel)
				{
					if(this.testWFRouteLinkModel((IWFRouteLinkModel)iWFLinkModel, iWFActionContext))
					{
						iWFActionContext.setCurNext(iWFLinkModel.getNext());
						break;
					}
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcess#executeBefore(net.ibizsys.pswf.core.IWFActionContext)
	 */
	@Override
	public void executeBefore(IWFActionContext iWFActionContext) throws Exception
	{
		
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcess#executeAfter(net.ibizsys.pswf.core.IWFActionContext)
	 */
	@Override
	public void executeAfter(IWFActionContext iWFActionContext) throws Exception
	{
		
	}

	/**
	 * 获取对应的流程处理模型
	 * @return the iWFProcessModel
	 */
	public IWFProcessModel getWFProcessModel()
	{
		return iWFProcessModel;
	}

	/**
	 * 测试路由连接
	 * @param iWFRouteLinkModel
	 * @param iWFActionContext
	 * @return
	 * @throws Exception
	 */
	protected boolean testWFRouteLinkModel(IWFRouteLinkModel iWFRouteLinkModel,IWFActionContext iWFActionContext) throws Exception
	{
		if(iWFRouteLinkModel.isDefault())
			return true;
		
		IWFLinkGroupCondModel iWFLinkGroupCondModel = iWFRouteLinkModel.getWFLinkGroupCondModel();
		return testWFLinkGroupCondModel(iWFLinkGroupCondModel,iWFActionContext);
	}
	
	/**
	 * 判断连接单项条件
	 * @param iWFLinkSingleCondModel
	 * @param iWFActionContext
	 * @return
	 * @throws Exception
	 */
	protected boolean testWFLinkSingleCondModel(IWFLinkSingleCondModel iWFLinkSingleCondModel,IWFActionContext iWFActionContext) throws Exception
	{
		String strOP = iWFLinkSingleCondModel.getCondOP();
		Object objSrcValue =iWFActionContext.getActiveEntity().get(iWFLinkSingleCondModel.getFieldName());
		if(StringHelper.compare(strOP, ICondition.CONDOP_ISNULL, true)==0)
		{
			return objSrcValue == null;
		}
		
		if(StringHelper.compare(strOP, ICondition.CONDOP_ISNOTNULL, true)==0)
		{
			return objSrcValue != null;
		}
		
		int nDataType = DataTypeHelper.getObjectDataType(objSrcValue);
		Object objDstValue = DefaultValueHelper.getValue(WebContext.getCurrent(), iWFLinkSingleCondModel.getParamType(), iWFLinkSingleCondModel.getParamValue(),nDataType,iWFActionContext.getActiveEntity());
		long nRet = 	DataTypeHelper.compare(nDataType,objSrcValue,objDstValue);
		if(StringHelper.compare(strOP, ICondition.CONDOP_EQ, true)==0)
		{
			return nRet == 0;
		}
		
		if(StringHelper.compare(strOP, ICondition.CONDOP_NOTEQ, true)==0)
		{
			return nRet != 0;
		}
		
		if(StringHelper.compare(strOP, ICondition.CONDOP_GT, true)==0)
		{
			return nRet > 0;
		}
		
		if(StringHelper.compare(strOP, ICondition.CONDOP_GTANDEQ, true)==0)
		{
			return nRet >= 0;
		}
		
		
		if(StringHelper.compare(strOP, ICondition.CONDOP_LT, true)==0)
		{
			return nRet < 0;
		}
		
		if(StringHelper.compare(strOP, ICondition.CONDOP_LTANDEQ, true)==0)
		{
			return nRet <= 0;
		}
		
		throw new Exception(StringHelper.format("无法识别的表达式[%1$s]",strOP));
	}
	
	/**
	 * 判断连接组条件
	 * @param iWFLinkGroupCondModel
	 * @param iWFActionContext
	 * @return
	 * @throws Exception
	 */
	protected boolean testWFLinkGroupCondModel(IWFLinkGroupCondModel iWFLinkGroupCondModel,IWFActionContext iWFActionContext) throws Exception
	{
		boolean bAndMode = (StringHelper.compare(iWFLinkGroupCondModel.getGroupOP(),ICondition.CONDOP_AND,true) == 0);
		java.util.Iterator<IWFLinkCondModel> wfLinkCondModels = iWFLinkGroupCondModel.getWFLinkCondModels();
		if(wfLinkCondModels == null)
			return true;
		
		boolean bRet = false;
		if(bAndMode)
			bRet =true;
		boolean bHasChild = false;
		while(wfLinkCondModels.hasNext())
		{
			bHasChild = true;
			IWFLinkCondModel iWFLinkCondModel = wfLinkCondModels.next();
			if(iWFLinkCondModel instanceof IWFLinkGroupCondModel)
			{
				if(testWFLinkGroupCondModel((IWFLinkGroupCondModel)iWFLinkCondModel,iWFActionContext))
				{
					if(!bAndMode)
					{
						bRet = true;
						break;
					}
				}
				else
				{
					if(bAndMode)
					{
						bRet = false;
						break;
					}
				}
			}
			else
				if(iWFLinkCondModel instanceof IWFLinkSingleCondModel)
				{
					if(testWFLinkSingleCondModel((IWFLinkSingleCondModel)iWFLinkCondModel,iWFActionContext))
					{
						if(!bAndMode)
						{
							bRet = true;
							break;
						}
					}
					else
					{
						if(bAndMode)
						{
							bRet = false;
							break;
						}
					}
				}
		}
		
		
		if(!bHasChild){
			bRet = true;
		}
		
		if(iWFLinkGroupCondModel.isNotMode())
			return !bRet;
		else
			return bRet;
	}
	
	
	
}
