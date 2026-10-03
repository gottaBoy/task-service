package net.ibizsys.pswf.core;

/**
 * 流程开始处理模型
 * @author lionlau
 *
 */
public abstract class WFStartProcessModelBase extends WFProcessModelBase
{

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.WFProcessModelBase#isStartProcess()
	 */
	@Override
	public boolean isStartProcess()
	{
		return true;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.WFProcessModelBase#getWFProcessType()
	 */
	@Override
	public String getWFProcessType()
	{
		return IWFProcessModel.Start;
	}
}
