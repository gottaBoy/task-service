package net.ibizsys.psrt.srv.wf.demodel.wfreminder;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.DEDataAccMgr;
import net.ibizsys.paas.security.DataAccessActions;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

/**
 * 工作流催办数据访问能力 
 * @author Administrator
 *
 */
public class WFReminderDEDataAccMgr extends DEDataAccMgr
{
	public WFReminderDEDataAccMgr()
	{
		
	}
	
	
	
	
	/*
	 * (non-Javadoc)
	 * @see SA.SRFDA.Security.IDEDataAccMgr#Test(SA.SRFDA.Web.SRFDAWebContext,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	protected CallResult internalTest(IWebContext webContext, String strCurPersonId, IEntity dataEntity, String strAction,boolean bCache) throws Exception
	{
		
		CallResult callResult = new CallResult();
		callResult.setRetCode(Errors.OK);
		if(StringHelper.compare(strAction, DataAccessActions.CREATE, true)==0)
		{
			return callResult;
		}
		
		if(StringHelper.compare(strAction, DataAccessActions.READ, true)==0)
		{
			return callResult;
		}
		
		callResult.setRetCode(Errors.ACCESSDENY);
		if(StringHelper.compare(strAction, DataAccessActions.UPDATE, true)==0)
		{
			callResult.setErrorInfo("流程催办数据不能被更新");
			return callResult;
		}
		
		if(StringHelper.compare(strAction, DataAccessActions.DELETE, true)==0)
		{
			callResult.setErrorInfo("流程催办数据不能被删除");
			return callResult;
		}
		
		return callResult;
	}
}
