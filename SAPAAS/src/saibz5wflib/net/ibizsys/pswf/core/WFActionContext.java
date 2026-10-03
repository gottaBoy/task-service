package net.ibizsys.pswf.core;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFStep;
import net.ibizsys.psrt.srv.wf.entity.WFStepActor;

/**
 * 流程操作上下文对象
 * @author lionlau
 *
 */
public class WFActionContext implements IWFActionContext2
{	
	private WFActionParam wfActionParam = null;
	private String strOpPersonId = null;
	private String strOpPersonName = null;
	private IEntity activeEntity = null;
	private IWFVersionModel iWFVersionModel = null;
	private IWFModel iWFModel = null;
	private boolean bThreadMode = false;
	private WFStep activeWFStep = null;
	private WFInstance activeWFInstance = null;
	private int nMaxLoopCount = 100;
	private String strCurNext = "";
	private IWFProcessModel curWFProcessModel = null;
	private boolean bFinishInteractiveProcess = false;
	
	private HashMap<String, String> nextIAStepActorMap = new HashMap<String, String> ();

	private HashMap<String, Object> attributes = null;
	
	private StringBuilderEx runInfo = new StringBuilderEx();
	
	private String strUserTag = "";
	
	private String strUserTag2 = "";
	
	private boolean bEnableNextIAStepActors = false;
	
	/**
	 * 撤回步骤的用户列表
	 */
	private ArrayList<WFStepActor> rollbackStepActors = new ArrayList<WFStepActor>();
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFActionContext#getWFActionParam()
	 */
	@Override
	public WFActionParam getWFActionParam()
	{
		return this.wfActionParam;
	}


	/**
	 * 设置操作参数
	 * @param wfActionParam
	 */
	public void setWFActionParam(WFActionParam wfActionParam)
	{
		this.wfActionParam = wfActionParam;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFActionContext#getOpPersonId()
	 */
	@Override
	public String getOpPersonId()
	{
		if(StringHelper.isNullOrEmpty(strOpPersonId))
			return this.getWFActionParam().getOpPersonId();
		return strOpPersonId;
	}

	/**
	 * 设置当前用户标识
	 * @param strOpPersonId the strOpPersonId to set
	 */
	public void setOpPersonId(String strOpPersonId)
	{
		this.strOpPersonId = strOpPersonId;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFActionContext#getOpPersonName()
	 */
	@Override
	public String getOpPersonName()
	{
		if(StringHelper.isNullOrEmpty(strOpPersonName))
			return this.getWFActionParam().getOpPersonName();
		return strOpPersonName;
	}

	/**
	 * 设置当前用户标识
	 * @param strOpPersonName the strOpPersonName to set
	 */
	public void setOpPersonName(String strOpPersonName)
	{
		this.strOpPersonName = strOpPersonName;
	}
	
	
	/**
	 * 获取当前的数据对象
	 * @return
	 */
	@Override
	public 	IEntity getActiveEntity()
	{
		return this.activeEntity;
	}

	/**
	 * 设置当前的数据对象
	 * @param activeEntity the activeEntity to set
	 */
	public void setActiveEntity(IEntity activeEntity)
	{
		this.activeEntity = activeEntity;
	}
	
	/**
	 * 获取当前的流程版本模型
	 * @return
	 */
	@Override
	public IWFVersionModel getWFVersionModel()
	{
		return this.iWFVersionModel;
	}

	/**
	 * 设置当前的流程版本模型
	 * @param iWFVersionModel the iWFVersionModel to set
	 */
	public void setWFVersionModel(IWFVersionModel iWFVersionModel)
	{
		this.iWFVersionModel = iWFVersionModel;
	}

	/**
	 * 获取是否在线程模式中
	 * @return the bThreadMode
	 */
	@Override
	public boolean isThreadMode()
	{
		return bThreadMode;
	}

	/**
	 * 设置是否在线程模式中
	 * @param bThreadMode the bThreadMode to set
	 */
	public void setThreadMode(boolean bThreadMode)
	{
		this.bThreadMode = bThreadMode;
	}

	/**
	 * 获取当前的流程步骤
	 * @return the activeWFStep
	 */
	public WFStep getActiveWFStep()
	{
		return activeWFStep;
	}

	/**
	 * 设置当前的流程步骤
	 * @param activeWFStep the activeWFStep to set
	 */
	public void setActiveWFStep(WFStep activeWFStep)
	{
		this.activeWFStep = activeWFStep;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFActionContext2#getActiveWFInstance()
	 */
	@Override
	public WFInstance getActiveWFInstance()
	{
		return activeWFInstance;
	}

	/**
	 * 设置当前流程实例
	 * @param activeWFInstance the activeWFInstance to set
	 */
	public void setActiveWFInstance(WFInstance activeWFInstance)
	{
		this.activeWFInstance = activeWFInstance;
	}
	
	/**
	 * 获取最大的流程处理递归次数
	 * @return the nMaxLoopCount
	 */
	public int getMaxLoopCount()
	{
		return nMaxLoopCount;
	}


	/**
	 * 设置最大的流程处理递归次数
	 * @param maxLoopCount
	 */
	public void setMaxLoopCount(int maxLoopCount)
	{
		this.nMaxLoopCount = maxLoopCount;
	}

	/**
	 * 获取下一步连接目标
	 * @return the strCurNext
	 */
	public String getCurNext()
	{
		return strCurNext;
	}

	/**
	 * 设置下一步连接目标
	 * @param strCurNext the strCurNext to set
	 */
	public void setCurNext(String strCurNext)
	{
		this.strCurNext = strCurNext;
	}

	/**
	 * 获取当前处理模型
	 * @return the curWFProcessModel
	 */
	public IWFProcessModel getCurWFProcessModel()
	{
		return curWFProcessModel;
	}

	/**
	 * 设置当前处理模型
	 * @param curWFProcessModel the curWFProcessModel to set
	 */
	public void setCurWFProcessModel(IWFProcessModel curWFProcessModel)
	{
		this.curWFProcessModel = curWFProcessModel;
	}

	/**
	 * 获取是否完成交互处理
	 * @return the bFinishInteractiveProcess
	 */
	public boolean isFinishInteractiveProcess()
	{
		return bFinishInteractiveProcess;
	}

	/**
	 * 设置是否完成交互处理
	 * @param bFinishInteractiveProcess the bFinishInteractiveProcess to set
	 */
	public void setFinishInteractiveProcess(boolean bFinishInteractiveProcess)
	{
		this.bFinishInteractiveProcess = bFinishInteractiveProcess;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFActionContext#getAttribute(java.lang.String)
	 */
	public Object getAttribute(String strName)
	{
		if (attributes == null)
		{
			return null;
		}
		return attributes.get(strName);
	}

	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFActionContext#setAttribute(java.lang.String, java.lang.Object)
	 */
	public void setAttribute(String strName, Object objValue)
	{
		if (attributes == null)
		{
			attributes = new HashMap<String, Object>();
		}
		attributes.put(strName, objValue);
	}
	
	

	/**
	 * 附加返回信息
	 * @param strInfo
	 */
	public void appendReturnInfo(String strInfo)
	{
		if (!StringHelper.isNullOrEmpty(runInfo.toString()))
			runInfo.append("\r\n");
		runInfo.append(strInfo);
	}
	
	/**
	 * 获取返回信息字符串构建对象
	 * @return
	 */
	public StringBuilderEx getReturnInfoSB()
	{
		return this.runInfo;
	}

	/**
	 * 获取用户标记数据
	 * @return the strUserTag
	 */
	public String getUserTag()
	{
		return strUserTag;
	}

	/**
	 * 设置用户标记数据
	 * @param strUserTag the strUserTag to set
	 */
	public void setUserTag(String strUserTag)
	{
		this.strUserTag = strUserTag;
	}

	/**
	 * 获取用户标记数据2
	 * @return the strUserTag2
	 */
	public String getUserTag2()
	{
		return strUserTag2;
	}

	/**
	 * 设置用户标记数据2
	 * @param strUserTag2 the strUserTag2 to set
	 */
	public void setUserTag2(String strUserTag2)
	{
		this.strUserTag2 = strUserTag2;
	}
	
	/**
	 * 获取下一步操作者Map
	 * @return
	 */
	public HashMap<String, String> getNextIAStepActorMap()
	{
		return this.nextIAStepActorMap;
	}
	
	
	/**
	 * 建立流程操作结果对象
	 * @return
	 */
	public WFActionResult createWFActionResult()
	{
		WFActionResult wfActionResult = new WFActionResult();
		if(this.getActiveWFInstance()!=null)
		{
			wfActionResult.setInstanceId(this.getActiveWFInstance().getWFInstanceId());
		}
		wfActionResult.setReturnInfo(this.getReturnInfoSB().toString());
		return wfActionResult;
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFActionContext#getActiveWFInstanceId()
	 */
	public String getActiveWFInstanceId()
	{
		return this.getActiveWFInstance().getWFInstanceId(); 
	}
	
	
	/**
	 * 获取回滚的步骤操作者集合
	 * @return
	 */
	public ArrayList<WFStepActor> getRollbackStepActors()
	{
		return this.rollbackStepActors;
	}
	
	/**
	 * 获取是否启用下一步交互用户计算模式
	 * @return
	 */
	public boolean isEnableNextIAStepActors()
	{
		return this.bEnableNextIAStepActors;
	}


	/**
	 * 设置是否启用下一步交互用户计算模式
	 * @param bEnableNextIAStepActors the bEnableNextIAStepActors to set
	 */
	public void setEnableNextIAStepActors(boolean bEnableNextIAStepActors)
	{
		this.bEnableNextIAStepActors = bEnableNextIAStepActors;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFActionContext#getWFModel()
	 */
	@Override
	public IWFModel getWFModel()
	{
		return this.iWFModel;
	}
	
	
	/**
	 * 设置流程模型
	 * @param iWFModel
	 */
	public void setWFModel(IWFModel iWFModel)
	{
		this.iWFModel = iWFModel;
	}
	
	
	
	
	
}
