package net.ibizsys.pswf.core;


/**
 * 时间定时处理流程对象
 * @author lionlau
 *
 */
public abstract class WFTimerEventProcessModelBase extends WFProcessModelBase implements IWFTimerEventProcessModel
{

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.WFProcessModelBase#isSuspendProcess()
	 */
	@Override
	public boolean isSuspendProcess()
	{
		return true;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#getWFProcessType()
	 */
	@Override
	public String getWFProcessType()
	{
		return IWFProcessModel.TimerEvent;
	}


	
}
