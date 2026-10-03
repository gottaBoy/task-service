package net.ibizsys.pswf.core;



/**
 * 工作流处理子流程模型
 * @author lionlau
 *
 */
public class WFProcSubWFModel implements IWFProcSubWFModel
{	
	private String strId = "";
	private String strName = "";
	private String strDEName = "";
	private String strWFId = "";
	private String strDEDSName = "";
	private IWFEmbedWFProcessModelBase iWFEmbedWFProcessModelBase = null;
	private boolean bSuspendDefault =false;
	private String strWFVerId = null;
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcSubWFModel#init(net.ibizsys.pswf.core.IWFEmbedWFProcessModelBase)
	 */
	@Override
	public void init(IWFEmbedWFProcessModelBase iWFEmbedWFProcessModelBase) throws Exception
	{
		this.iWFEmbedWFProcessModelBase = iWFEmbedWFProcessModelBase;
		this.onInit();
	}
	
	/**
	 * 初始化
	 * @throws Exception
	 */
	protected void onInit()throws Exception
	{
		
	}

	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#getId()
	 */
	@Override
	public String getId()
	{
		return this.strId;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#getName()
	 */
	@Override
	public String getName()
	{
		return this.strName;
	}

	/**
	 * 设置流程处理标识
	 *  @param strId the strId to set
	 */
	public void setId(String strId)
	{
		this.strId = strId;
	}

	/**
	 * 设置流程处理名称
	 * @param strName the strName to set
	 */
	public void setName(String strName)
	{
		this.strName = strName;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcSubWFModel#getWFEmbedWFProcessModelBase()
	 */
	@Override
	public IWFEmbedWFProcessModelBase getWFEmbedWFProcessModelBase()
	{
		return this.iWFEmbedWFProcessModelBase;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcSubWFModel#getWFModel()
	 */
	@Override
	public IWFModel getWFModel() {
		return null;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcSubWFModel#getWFId()
	 */
	@Override
	public String getWFId() {
		return this.strWFId;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcSubWFModel#getDEName()
	 */
	@Override
	public String getDEName() {
		return this.strDEName;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcSubWFModel#getDEDSName()
	 */
	@Override
	public String getDEDSName() {
		return this.strDEDSName;
	}

	/**
	 * 设置实体模型名称
	 * @param strDEName
	 */
	public void setDEName(String strDEName) {
		this.strDEName = strDEName;
	}

	/**
	 * 设置子流程标识
	 * @param strWFId
	 */
	public void setWFId(String strWFId) {
		this.strWFId = strWFId;
	}

	/**
	 * 设置查询的实体数据集
	 * @param strDEDSName
	 */
	public void setDEDSName(String strDEDSName) {
		this.strDEDSName = strDEDSName;
	}

	@Override
	public boolean isSuspendDefault() {
		return this.bSuspendDefault;
	}

	/**
	 * 设置是否默认挂起子流程
	 * @param bSuspendDefault
	 */
	public void setSuspendDefault(boolean bSuspendDefault){
		this.bSuspendDefault = bSuspendDefault;
	}

	@Override
	public IWFVersionModel getWFVersionModel() {
		return null;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcSubWFModel#getWFVerId()
	 */
	@Override
	public String getWFVerId() {
		return this.strWFVerId;
	}
	
	/**
	 * 设置子流程标识
	 * @param strWFVerId
	 */
	public void setWFVerId(String strWFVerId) {
		this.strWFVerId = strWFVerId;
	}
	
}
