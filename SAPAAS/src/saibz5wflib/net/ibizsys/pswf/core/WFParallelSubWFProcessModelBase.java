package net.ibizsys.pswf.core;


/**
 * 并行子流程处理模型
 * @author lionlau
 *
 */
public abstract class WFParallelSubWFProcessModelBase  extends WFEmbedWFProcessModelBaseBase implements IWFParallelSubWFProcessModel
{

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.WFProcessModelBase#getWFProcessType()
	 */
	@Override
	public String getWFProcessType()
	{
		return IWFProcessModel.Parallel;
	}
}

