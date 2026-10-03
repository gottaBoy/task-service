package net.ibizsys.pswf.core;

/**
 * 流程路由连接模型
 * @author lionlau
 *
 */
public abstract class WFRouteLinkModelBase extends WFLinkModelBase implements IWFRouteLinkModel
{
	private RootWFLinkGroupCondModel rootWFLinkGroupCondModel = new RootWFLinkGroupCondModel();
	
	private boolean bDefault = false;

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFRouteLinkModel#isDefault()
	 */
	@Override
	public boolean isDefault()
	{
		return this.bDefault;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFRouteLinkModel#getRootWFLinkGroupCondModel()
	 */
	public RootWFLinkGroupCondModel getRootWFLinkGroupCondModel()
	{
		return this.rootWFLinkGroupCondModel;
	}



	/**
	 * 设置默认
	 * @param bDefault the bDefault to set
	 */
	public void setDefault(boolean bDefault)
	{
		this.bDefault = bDefault;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFRouteLinkModel#getWFLinkGroupCondModel()
	 */
	@Override
	public IWFLinkGroupCondModel getWFLinkGroupCondModel()
	{
		return this.rootWFLinkGroupCondModel;
	}

}
