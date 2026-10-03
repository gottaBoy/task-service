package net.ibizsys.pswf.core;


/**
 * 流程操作参数对象
 * @author lionlau
 *
 */
public class WFActionParam
{
	/**
	 * 工作流标识
	 */
	protected String strWorkflowId;
	
	/**
	 * 操作人标识
	 */
	protected String strOpPersonId;
	
	/**
	 * 操作人名称
	 */
	protected String strOpPersonName;
	
	
	protected String strUserData ;
	
	protected String strUserData2 ;
	
	protected String strUserData3 ;
	
	protected String strUserData4 ;
	
	
	

	protected String strConnection;

	protected String strInstanceId ;
	
	protected String strPInstanceId ;
	
	protected String strStepId;

	protected String strDescription ;
	
	
	protected String strCodeListItemValue = "";
	
	
	/**
	 * 用户自定义标记
	 */
	protected String strUserTag = "";
	
	
	/**
	 * 用户自定义标记2
	 */
	protected String strUserTag2 = "";
	
	/**
	 * 是否为测试模式，只进行仿真操作
	 */
	protected boolean bTestMode = false;
	
	/**
	 * 提交嵌入流程
	 */
	protected boolean bSubmitEmbedWF = false;
	
	
	/**
	 * 获取流程模式
	 */
	private String strWFMode = "";
	
	
	private boolean bSuspendMode = false;
	
	private String strWFVersionId = "";
	
	/**
	 * 获取流程模型标识
	 * @return the strWorkflowId
	 */
	public String getWorkflowId()
	{
		return strWorkflowId;
	}

	/**
	 * 设置流程模型标识
	 * @param strWorkflowId the strWorkflowId to set
	 */
	public void setWorkflowId(String strWorkflowId)
	{
		this.strWorkflowId = strWorkflowId;
	}

	/**
	 * 获取当前操作者标识
	 * @return the strOpPersonId
	 */
	public String getOpPersonId()
	{
		return strOpPersonId;
	}

	/**
	 * 设置当前操作者标识
	 * @param strOpPersonId the strOpPersonId to set
	 */
	public void setOpPersonId(String strOpPersonId)
	{
		this.strOpPersonId = strOpPersonId;
	}
	
	/**
	 * 获取当前操作者名称
	 * @return the strOpPersonName
	 */
	public String getOpPersonName()
	{
		return strOpPersonName;
	}

	/**
	 * 设置当前操作者名称
	 * @param strOpPersonName the strOpPersonName to set
	 */
	public void setOpPersonName(String strOpPersonName)
	{
		this.strOpPersonName = strOpPersonName;
	}
	

	/**
	 * 获取当前用户数据
	 * @return the strUserData
	 */
	public String getUserData()
	{
		return strUserData;
	}

	/**
	 * 设置当前用户数据
	 * @param strUserData the strUserData to set
	 */
	public void setUserData(String strUserData)
	{
		this.strUserData = strUserData;
	}

	/**
	 * 获取当前用户数据2
	 * @return the strUserData2
	 */
	public String getUserData2()
	{
		return strUserData2;
	}

	/**
	 * 设置当前用户数据2
	 * @param strUserData2 the strUserData2 to set
	 */
	public void setUserData2(String strUserData2)
	{
		this.strUserData2 = strUserData2;
	}

	/**
	 * 获取当前用户数据3
	 * @return the strUserData3
	 */
	public String getUserData3()
	{
		return strUserData3;
	}

	/**
	 * 设置当前用户数据3
	 * @param strUserData3 the strUserData3 to set
	 */
	public void setUserData3(String strUserData3)
	{
		this.strUserData3 = strUserData3;
	}

	/**
	 * 获取当前用户数据4
	 * @return the strUserData4
	 */
	public String getUserData4()
	{
		return strUserData4;
	}

	/**
	 * 设置当前用户数据4
	 * @param strUserData4 the strUserData4 to set
	 */
	public void setUserData4(String strUserData4)
	{
		this.strUserData4 = strUserData4;
	}

	/**
	 * 获取交互路径标识
	 * @return the strConnection
	 */
	public String getConnection()
	{
		return strConnection;
	}

	/**
	 * 设置交互路径标识
	 * @param strConnection the strConnection to set
	 */
	public void setConnection(String strConnection)
	{
		this.strConnection = strConnection;
	}

	/**
	 * 获取流程实例标识
	 * @return the strInstanceId
	 */
	public String getInstanceId()
	{
		return strInstanceId;
	}

	/**
	 * 设置流程实例标识
	 * @param strInstanceId the strInstanceId to set
	 */
	public void setInstanceId(String strInstanceId)
	{
		this.strInstanceId = strInstanceId;
	}

	
	/**
	 * 获取父流程实例标识
	 * @return the strPInstanceId
	 */
	public String getPInstanceId()
	{
		return strPInstanceId;
	}

	/**
	 *  设置父流程实例标识
	 * @param strPInstanceId the strPInstanceId to set
	 */
	public void setPInstanceId(String strPInstanceId)
	{
		this.strPInstanceId = strPInstanceId;
	}
	
	/**
	 * 获取流程步骤标识
	 * @return the strStepId
	 */
	public String getStepId()
	{
		return strStepId;
	}

	/**
	 * 设置流程步骤标识
	 * @param strStepId the strStepId to set
	 */
	public void setStepId(String strStepId)
	{
		this.strStepId = strStepId;
	}

	/**
	 * 获取流程交互操作描述信息
	 * @return the strDescription
	 */
	public String getDescription()
	{
		return strDescription;
	}

	/**
	 * 设置流程交互操作描述信息
	 * @param strDescription the strDescription to set
	 */
	public void setDescription(String strDescription)
	{
		this.strDescription = strDescription;
	}

	/**
	 * 获取代码项值
	 * @return the strCodeListItemValue
	 */
	public String getCodeListItemValue()
	{
		return strCodeListItemValue;
	}

	/**
	 * 设置代码项值
	 * @param strCodeListItemValue the strCodeListItemValue to set
	 */
	public void setCodeListItemValue(String strCodeListItemValue)
	{
		this.strCodeListItemValue = strCodeListItemValue;
	}

	
	
	/**
	 * 设置操作结果
	 * @return the strCodeListItemValue
	 */
	public String getActionResult()
	{
		return strCodeListItemValue;
	}

	/**
	 * 获取操作结果
	 * @param strCodeListItemValue the strCodeListItemValue to set
	 */
	public void setActionResult(String strCodeListItemValue)
	{
		this.strCodeListItemValue = strCodeListItemValue;
	}
	
	
	/**
	 * 获取用户操作标记
	 * @return the strUserTag
	 */
	public String getUserTag()
	{
		return strUserTag;
	}

	

	/**
	 * 设置用户操作标记
	 * @param strUserTag the strUserTag to set
	 */
	public void setUserTag(String strUserTag)
	{
		this.strUserTag = strUserTag;
	}

	/**
	 * 获取用户操作标记2
	 * @return the strUserTag2
	 */
	public String getUserTag2()
	{
		return strUserTag2;
	}
	
	/**
	 * 设置用户操作标记2
	 * @param strUserTag2 the strUserTag2 to set
	 */
	public void setUserTag2(String strUserTag2)
	{
		this.strUserTag2 = strUserTag2;
	}

	/**
	 * 获取是否为测试模式
	 * @return the bTestMode
	 */
	public boolean isTestMode()
	{
		return bTestMode;
	}

	/**
	 * 设置是否为测试模式
	 * @param bTestMode the bTestMode to set
	 */
	public void setTestMode(boolean bTestMode)
	{
		this.bTestMode = bTestMode;
	}

	/**
	 * 获取是否为提交嵌入流程
	 * @return the bSubmitEmbedWF
	 */
	public boolean isSubmitEmbedWF()
	{
		return bSubmitEmbedWF;
	}

	/**
	 * 设置是否为提交嵌入流程
	 * @param bSubmitEmbedWF the bSubmitEmbedWF to set
	 */
	public void setSubmitEmbedWF(boolean bSubmitEmbedWF)
	{
		this.bSubmitEmbedWF = bSubmitEmbedWF;
	}
	
	
	/**
	 * 获取流程模式
	 * @return the bWFMode
	 */
	public String getWFMode()
	{
		return strWFMode;
	}

	/**
	 * 设置流程模式
	 * @param strWFMode the strWFMode to set
	 */
	public void setWFMode(String strWFMode)
	{
		this.strWFMode = strWFMode;
	}

	/**
	 * 是否为挂起模式
	 * @return
	 */
	public boolean isSuspendMode() {
		return bSuspendMode;
	}

	/**
	 * 设置是否为挂起模式
	 * @param bSuspendMode
	 */
	public void setSuspendMode(boolean bSuspendMode) {
		this.bSuspendMode = bSuspendMode;
	}
	
	/**
	 * 设置流程版本标识
	 * @param strWFVersionId
	 */
	public void setWFVersionId(String strWFVersionId){
		this.strWFVersionId = strWFVersionId;
	}
	
	
	/**
	 * 获取流程版本标识
	 * @return
	 */
	public String getWFVersionId(){
		return this.strWFVersionId;
	}
	
}
