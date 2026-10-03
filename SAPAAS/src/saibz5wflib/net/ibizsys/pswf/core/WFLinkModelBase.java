package net.ibizsys.pswf.core;


/**
 * 工作流版本连接基类
 * @author lionlau
 *
 */
public abstract class WFLinkModelBase implements IWFLinkModel
{	
	private String strId = "";
	private String strName = "";
	private String strFrom = "";
	private String strNext = "";
	private String strLogicName = "";
	private IWFVersionModel iWFVersionModel = null;
	private String strSrcEndPoint = "";
	private String strDstEndPoint = "";
	private String strUserData = "";
	private String strUserdata2 = "";
	private int nThreadLinkMode = THREADLINKMODE_MAJOR;
	private String strThreadShowName = "";
	private String strLNLanResTag = null;
	private String strBPMNModelId = "";
	private String strNextCondition = "";
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkModel#init(net.ibizsys.pswf.core.IWFVersionModel)
	 */
	@Override
	public void init(IWFVersionModel iWFVersionModel) throws Exception
	{
		this.iWFVersionModel = iWFVersionModel;
		this.onInit();
	}
	
	/**
	 * 初始化触发
	 * @throws Exception
	 */
	protected void onInit()throws Exception
	{
		
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkModel#getId()
	 */
	@Override
	public String getId()
	{
		return this.strId;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkModel#getName()
	 */
	@Override
	public String getName()
	{
		return this.strName;
	}

	/**
	 * 设置连接标识
	 * @param strId the strId to set
	 */
	protected void setId(String strId)
	{
		this.strId = strId;
	}

	/**
	 * 设置连接名称
	 * @param strName the strName to set
	 */
	protected void setName(String strName)
	{
		this.strName = strName;
	}
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkModel#getWFVersionModel()
	 */
	@Override
	public IWFVersionModel getWFVersionModel()
	{
		return this.iWFVersionModel;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkModel#getNext()
	 */
	@Override
	public String getNext()
	{
		return this.strNext;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkModel#getFrom()
	 */
	@Override
	public String getFrom()
	{
		return this.strFrom;
	}
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkModel#getLogicName()
	 */
	@Override
	public String getLogicName()
	{
		return this.strLogicName;
	}

	/**
	 * 设置起始处理标识
	 * @param strFrom the strFrom to set
	 */
	protected void setFrom(String strFrom)
	{
		this.strFrom = strFrom;
	}

	/**
	 * 设置目标处理标识
	 * @param strNext the strNext to set
	 */
	protected void setNext(String strNext)
	{
		this.strNext = strNext;
	}

	/**
	 * 设置连接的逻辑名称
	 * @param strLogicName the strLogicName to set
	 */
	protected void setLogicName(String strLogicName)
	{
		this.strLogicName = strLogicName;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkModel#getSrcEndPoint()
	 */
	@Override
	public String getSrcEndPoint()
	{
		return this.strSrcEndPoint;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkModel#getDstEndPoint()
	 */
	@Override
	public String getDstEndPoint()
	{
		return this.strDstEndPoint;
	}

	/**
	 * 设置起始处理连接端点（用于绘图）
	 * @param strSrcEndPoint the strSrcEndPoint to set
	 */
	protected void setSrcEndPoint(String strSrcEndPoint)
	{
		this.strSrcEndPoint = strSrcEndPoint;
	}

	/**
	 * 设置目标处理连接端点（用于绘图）
	 * @param strDstEndPoint the strDstEndPoint to set
	 */
	protected void setDstEndPoint(String strDstEndPoint)
	{
		this.strDstEndPoint = strDstEndPoint;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkModel#getUserData()
	 */
	@Override
	public String getUserData()
	{
		return strUserData;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkModel#getUserData2()
	 */
	@Override
	public String getUserData2()
	{
		return strUserdata2;
	}

	/**
	 * 设置连接用户数据
	 * @param strUserData the strUserData to set
	 */
	protected void setUserData(String strUserData)
	{
		this.strUserData = strUserData;
	}

	/**
	 * 设置连接用户数据2
	 * @param strUserdata2 the strUserdata2 to set
	 */
	protected void setUserData2(String strUserdata2)
	{
		this.strUserdata2 = strUserdata2;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkModel#getThreadShowName()
	 */
	@Override
	public String getThreadShowName() {
		return this.strThreadShowName;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkModel#getThreadLinkMode()
	 */
	@Override
	public int getThreadLinkMode() {
		return this.nThreadLinkMode;
	}

	/**
	 * 设置业务连接模式
	 * @param nThreadLinkMode
	 */
	protected void setThreadLinkMode(int nThreadLinkMode) {
		this.nThreadLinkMode = nThreadLinkMode;
	}

	/**
	 * 设置业务连接显示名称
	 * @param strThreadShowName
	 */
	protected void setThreadShowName(String strThreadShowName) {
		this.strThreadShowName = strThreadShowName;
	}

	@Override
	public String getLNLanResTag() {
		return this.strLNLanResTag;
	}
	
	/**
	 * 获取逻辑名称语言标记
	 * @param strLNLanResTag
	 */
	protected void setLNLanResTag(String strLNLanResTag){
		this.strLNLanResTag = strLNLanResTag;
	}

	@Override
	public String getBPMNModelId() {
		return this.strBPMNModelId;
	}
	
	
	/**
	 * 设置BPMN模型标识
	 * @param strBPMNModelId
	 */
	protected void setBPMNModelId(String strBPMNModelId){
		this.strBPMNModelId = strBPMNModelId;
	}
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkModel#getNextCondition()
	 */
	@Override
	public String getNextCondition()
	{
		return strNextCondition;
	}

	/**
	 * 设置下一步的到达条件
	 * @param strNextCondition the strNextCondition to set
	 */
	protected void setNextCondition(String strNextCondition)
	{
		this.strNextCondition = strNextCondition;
	}
}
