package net.ibizsys.pswf.core;

/**
 * 流程结束处理模型
 * @author lionlau
 *
 */
public abstract class WFEndProcessModelBase extends WFProcessModelBase implements IWFEndProcessModel
{
	private String strExitStateValue = "";
	
	@Override
	public String getExitStateValue() {
		return this.strExitStateValue;
	}
	
	/**
	 * 设置退出状态值
	 * @param strExitStateValue
	 */
	public void setExitStateValue(String strExitStateValue) {
		this.strExitStateValue = strExitStateValue;
	}
	
	


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.WFProcessModelBase#isTerminalProcess()
	 */
	@Override
	public boolean isTerminalProcess()
	{
		return true;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.WFProcessModelBase#getWFProcessType()
	 */
	@Override
	public String getWFProcessType()
	{
		return IWFProcessModel.End;
	}
	
	
	

}
