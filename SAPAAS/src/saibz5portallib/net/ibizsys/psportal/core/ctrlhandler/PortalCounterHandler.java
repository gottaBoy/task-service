package net.ibizsys.psportal.core.ctrlhandler;

import java.util.ArrayList;
import java.util.Random;

import net.ibizsys.paas.ctrlhandler.CounterHandlerBase;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.wf.service.WFWorkListService;
import net.sf.json.JSONObject;

/**
 * 我的门户计数器处理对象
 * @author Administrator
 *
 */
public class PortalCounterHandler extends CounterHandlerBase
{
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlhandler.CounterHandlerBase#onFetch()
	 */
	@Override
	protected AjaxActionResult onFetch() throws Exception
	{
		MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
		
		String strCounterParam = WebContext.getCounterParam(this.getWebContext());
		if(StringHelper.isNullOrEmpty(strCounterParam))
		{
			throw new Exception(StringHelper.format("计数器参数无效"));
		}
		
		JSONObject dataObject = mdAjaxActionResult.getData(true);
		
		//流程任务
		
		Random random = new Random();
		
		//新消息
		dataObject.put("MESSAGE",random.nextInt(20));
				
		//提醒
		dataObject.put("NOTIFICATION", random.nextInt(20));
		
		//我的工作清单
		StringBuilderEx sql = new StringBuilderEx();
		
		if(WebConfig.getCurrent().isLowCaseSql()) {
			sql.append("select t1.cancelflag,t1.cancelinform,t1.createdate,t1.createman,t1.originalwfuserid,t1.originalwfusername,t1.updatedate,t1.updateman,t1.userdata,t1.userdata2,t1.userdata3,t1.userdata4,t1.userdatainfo,t1.wfactorid,t1.wfinstanceid,t1.wfinstancename,t1.wflanrestag,t1.wfstepid,t1.wfsteplanrestag,t1.wfstepname,t1.wfworkflowid,t1.wfworkflowname,t1.wfworklistid,t1.wfworklistname,t1.workinform  from t_srfwfworklist t1 where t1.wfactorid=? and t1.cancelflag = 0 order by t1.createdate ") ;
		}else {
			sql.append("select t1.*  FROM T_SRFWFWORKLIST t1 where t1.wfactorid=? and t1.cancelflag = 0 order by t1.createdate ") ;
		}
		
//		sql.append("select t3.WFWORKFLOWID,t3.WFWORKFLOWNAME,t1.WFPLOGICNAME,t4.ACTORID,t1.WFSTEPNAME,t2.USERDATA4 from T_SRFWFSTEP t1 INNER JOIN t_SRFWFINSTANCE t2 on  t2.ACTIVESTEPID = t1.WFSTEPID AND ( t2.ISCLOSE IS NULL OR t2.ISCLOSE=0) "+
//			"INNER JOIN T_SRFWFWORKFLOW t3 on t2.WFWORKFLOWID = t3.WFWORKFLOWID  "+
//			"INNER JOIN T_SRFWFSTEPACTOR t4 on  t4.WFSTEPID = t1.WFSTEPID  "+
//			"LEFT JOIN T_SRFWFSTEPDATA t5 ON (t5.ACTORID=T4.ACTORID and  t5.WFSTEPID = t2.ACTIVESTEPID AND  t5.CONNECTIONNAME<>'SRFWFRESUBMIT' AND t5.CONNECTIONNAME <> 'SRFWFTIMEOUT') "+ 
//			"where t5.WFSTEPDATAID IS NULL AND t4.ACTORID=? " );
		
		SqlParamList sqlParamList = new SqlParamList();
		sqlParamList.addString(this.getWebContext().getCurUserId());

		// 进行数据查询
		WFWorkListService wfStepService = (WFWorkListService)ServiceGlobal.getService(WFWorkListService.class,this.getViewController().getSessionFactory());
		ArrayList<IEntity> list = wfStepService.selectRaw(sql.toString(), sqlParamList);
		
		ArrayList wfTaskList = new ArrayList();
		for(IEntity iEntity:list)
		{
			wfTaskList.add(DataObject.toJSONObject(iEntity, true));
		}
		
		
		JSONObject jsonWFTask = new JSONObject();
		jsonWFTask.put("items", wfTaskList.toArray());
		jsonWFTask.put("totalrow", wfTaskList.size());
		dataObject.put("WFTASK",jsonWFTask);
		
		return mdAjaxActionResult;
	}

}
