package net.ibizsys.pswf.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.paas.util.StringHelper;


/**
 * 流程处理模型对象基类
 * @author lionlau
 *
 */
public abstract class WFProcessModelBase implements IWFProcessModel
{	
	private String strId = "";
	private String strName = "";
	private IWFVersionModel iWFVersionModel = null;
	private boolean bAsyncMode = false;
	private ArrayList<IWFLinkModel> wfLinkModelList = new ArrayList<IWFLinkModel>();
	private HashMap<String,IWFLinkModel> wfLinkModelMap = new HashMap<String,IWFLinkModel>();
	private IWFProcess iWFProcess = null;
	private String strWFStepValue = "";
	private int nLeftPos = -1;
	private int nTopPos = -1;
	private String strUserData = "";
	private String strUserdata2 = "";
	
	private int nTimeout = 0;
	private boolean bIsEnableTimeout = false;
	private String strTimeoutField = "";
	private String strTimeoutType = "";
	private String strTimeoutNext = "";
	private String strWorkTimeType = "";
	private int nThreadSN = -1;
	private String strThreadShowName = null;
	private String strNameLanResTag = null;
	private String strTSNLanResTag = null;
	private String strBPMNModelId = "";
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#init(net.ibizsys.pswf.core.IWFVersionModel)
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
		//建立处理对象
		this.iWFProcess = this.createWFProcess();
		this.iWFProcess.init(this);
	}
	
	/**
	 * 建立处理对象
	 * @return
	 * @throws Exception
	 */
	protected IWFProcess createWFProcess()throws Exception
	{
		return new WFProcess();
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
	 * 设置处理标识
	 * @param strId the strId to set
	 */
	protected void setId(String strId)
	{
		this.strId = strId;
	}

	/**
	 * 设置处理名称
	 * @param strName the strName to set
	 */
	protected void setName(String strName)
	{
		this.strName = strName;
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#getWFVersionModel()
	 */
	@Override
	public IWFVersionModel getWFVersionModel()
	{
		return this.iWFVersionModel;
	}

	
	
	/**
	 * 设置是否为异步处理
	 * @param bAsyncMode
	 */
	protected void setAsynchronousProcess(boolean bAsyncMode)
	{
		this.bAsyncMode = bAsyncMode;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#isAsynchronousProcess()
	 */
	public boolean isAsynchronousProcess()
	{
		return bAsyncMode;
	}
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#isSuspendProcess()
	 */
	public boolean isSuspendProcess()
	{
		return false;
	}
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#isTerminalProcess()
	 */
	public boolean isTerminalProcess()
	{
		return false;
	}

	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#isStartProcess()
	 */
	public boolean isStartProcess()
	{
		return false;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#getLogicName()
	 */
	@Override
	public String getLogicName()
	{
		return this.getName();
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#getWFStepValue()
	 */
	@Override
	public String getWFStepValue()
	{
		return strWFStepValue;
	}
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#getWFProcess()
	 */
	@Override
	public IWFProcess getWFProcess()
	{
		return iWFProcess;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#isEnableTimeout()
	 */
	@Override
	public boolean isEnableTimeout()
	{
		return bIsEnableTimeout;
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#isEnableTimeout()
	 */
	public void setIsEnableTimeout(boolean isEnableTimeout){
		bIsEnableTimeout = isEnableTimeout;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#getTimeoutNext()
	 */
	@Override
	public String getTimeoutNext()
	{
		return strTimeoutNext;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#getTimeoutNext()
	 */
	public void setTimeoutNext(String strTimeoutNext)
	{
		this.strTimeoutNext = strTimeoutNext;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#getTimeout()
	 */
	@Override
	public int getTimeout()
	{
		return nTimeout;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#isEnableTimeout()
	 */
	public void setTimeout(int nTimeout) {
		this.nTimeout = nTimeout;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#getTimeoutField()
	 */
	@Override
	public String getTimeoutField()
	{
		return strTimeoutField;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#isEnableTimeout()
	 */
	public void setTimeoutField(String strTimeoutField)
	{
		this.strTimeoutField = strTimeoutField;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#getTimeoutType()
	 */
	@Override
	public String getTimeoutType()
	{
		return strTimeoutType;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#isEnableTimeout()
	 */
	public void setTimeoutType(String strTimeoutType)
	{
		this.strTimeoutType = strTimeoutType;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#getWorkTimeType()
	 */
	@Override
	public String getWorkTimeType()
	{
		return strWorkTimeType;
	}

	/**
	 * 设置工作时间类型
	 * @param strWorkTimeType
	 */
	public void setWorkTimeType(String strWorkTimeType){
		this.strWorkTimeType = strWorkTimeType;
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#registerWFLinkModel(net.ibizsys.pswf.core.IWFLinkModel)
	 */
	@Override
	public void registerWFLinkModel(IWFLinkModel iWFLinkModel) throws Exception
	{
		this.wfLinkModelList.add(iWFLinkModel);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#getWFLinkModels()
	 */
	@Override
	public Iterator<IWFLinkModel> getWFLinkModels() throws Exception
	{
		return this.wfLinkModelList.iterator();
	}

	/**
	 * 设置处理对应的流程步骤值
	 * @param strWFStepValue the strWFStepValue to set
	 */
	protected void setWFStepValue(String strWFStepValue)
	{
		this.strWFStepValue = strWFStepValue;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#getLeftPos()
	 */
	@Override
	public int getLeftPos()
	{
		return nLeftPos;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#getTopPos()
	 */
	@Override
	public int getTopPos()
	{
		return nTopPos;
	}
	
	/**
	 * 设置处理在图例中的左侧位置
	 * @param nLeftPos
	 */
	protected void setLeftPos(int nLeftPos)
	{
		this.nLeftPos = nLeftPos;
	}
	
	/**
	 * 设置处理在图例中的上方位置
	 * @param nTopPos
	 */
	protected void setTopPos(int nTopPos)
	{
		this.nTopPos = nTopPos;
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
	 * 设置流程处理用户数据
	 * @param strUserData the strUserData to set
	 */
	protected void setUserData(String strUserData)
	{
		this.strUserData = strUserData;
	}

	/**
	 * 设置流程处理用户数据2
	 * @param strUserdata2 the strUserdata2 to set
	 */
	protected void setUserData2(String strUserdata2)
	{
		this.strUserdata2 = strUserdata2;
	}

	
	@Override
	@Deprecated
	public String getWorktimeType() {
		return this.strWorkTimeType;
	}
	
	/**
	 * 设置工作时间类型
	 * @param strWorkTimeType
	 */
	@Deprecated
	public void setWorktimeType(String strWorkTimeType){
		this.strWorkTimeType = strWorkTimeType;
	}

	@Override
	public int getThreadSN() {
		return this.nThreadSN;
	}
	
	
	/**
	 * 设置流程主线
	 * @param nThreadSN
	 */
	protected void setThreadSN(int nThreadSN){
		this.nThreadSN = nThreadSN;
	}
	
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#getThreadShowName()
	 */
	@Override
	public String getThreadShowName() {
		return this.strThreadShowName;
	}
	
	
	/**
	 * 设置业务主线显示名称
	 * @param strThreadShowName
	 */
	protected void setThreadShowName(String strThreadShowName){
		this.strThreadShowName = strThreadShowName;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#getNameLanResTag()
	 */
	@Override
	public String getNameLanResTag() {
		return strNameLanResTag;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#getTSNLanResTag()
	 */
	@Override
	public String getTSNLanResTag() {
		return strTSNLanResTag;
	}

	/**
	 * 设置处理名称的语言资源标记
	 * @param strNameLanResTag
	 */
	protected void setNameLanResTag(String strNameLanResTag) {
		this.strNameLanResTag = strNameLanResTag;
	}

	/**
	 * 设置业务主线显示名称的语言资源标记
	 * @param strTSNLanResTag
	 */
	protected void setTSNLanResTag(String strTSNLanResTag) {
		this.strTSNLanResTag = strTSNLanResTag;
	}
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#getWFLinkModel(java.lang.String)
	 */
	@Override
	public IWFLinkModel getWFLinkModel(String strWFLinkId) throws Exception {
		IWFLinkModel iWFLinkModel =  wfLinkModelMap.get(strWFLinkId);
		if(iWFLinkModel == null)
		{
			throw new Exception(StringHelper.format("无法获取指定流程连接模型，标识为[%1$s]",strWFLinkId));
		}
		return iWFLinkModel;
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
}
