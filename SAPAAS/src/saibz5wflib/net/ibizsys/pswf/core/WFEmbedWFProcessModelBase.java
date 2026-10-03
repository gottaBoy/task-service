package net.ibizsys.pswf.core;


/**
 * 嵌套子流程处理模型 
 * @author lionlau
 *
 */
public abstract class WFEmbedWFProcessModelBase extends WFEmbedWFProcessModelBaseBase implements IWFEmbedWFProcessModel
{
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.WFProcessModelBase#getWFProcessType()
	 */
	@Override
	public String getWFProcessType()
	{
		return IWFProcessModel.Embed;
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.WFEmbedWFProcessModelBaseBase#isSuspendProcess()
	 */
	@Override
	public boolean isSuspendProcess()
	{
		return true;
	}

	
	
}
