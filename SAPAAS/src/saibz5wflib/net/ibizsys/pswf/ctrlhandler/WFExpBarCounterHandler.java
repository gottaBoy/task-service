package net.ibizsys.pswf.ctrlhandler;

import java.util.ArrayList;

import net.ibizsys.paas.ctrlhandler.CounterHandlerBase;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.IDEWFModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.wf.service.WFStepService;
import net.ibizsys.pswf.core.IWFModel;
import net.sf.json.JSONObject;

/**
 * 流程导航栏计数器处理对象
 * 
 * @author Administrator
 *
 */
public class WFExpBarCounterHandler extends CounterHandlerBase {
	public final static String COUNTER_SQL = " select wfstepname ,COUNT(*) AS CNT from \r\n " + "		(  	SELECT t2.wfstepname  FROM T_SRFWFWORKLIST t1 \r\n " + "		inner join t_srfwfstep t2 on t1.wfstepid = t2.wfstepid \r\n  " + "		 WHERE t1.CANCELFLAG = 0 and t1.WFACTORID=? AND t1.WFWORKFLOWID=? AND t1.USERDATA4=?   \r\n" + "		 ) a GROUP BY wfstepname ";
	
	//工作流计数新模式（t_srfwfworklist中有记录WFStepValue）
	public final static String COUNTER_SQLEX = " select wfstepname ,COUNT(*) AS CNT from \r\n " + "		(  	SELECT t1.wfstepvalue wfstepname  FROM T_SRFWFWORKLIST t1 \r\n " + "		 WHERE t1.CANCELFLAG = 0 and t1.WFACTORID=? AND t1.WFWORKFLOWID=? AND t1.USERDATA4=?   \r\n" + "		 ) a GROUP BY wfstepname ";

	public final static String COUNTER_SQL2 = " select wfstepname ,wfworkflowid,pwfstepname,COUNT(*) AS CNT from " + "	( 	SELECT t2.wfstepname,t1.wfworkflowid,t5.wfstepname as pwfstepname  FROM T_SRFWFWORKLIST t1 " + "	inner join t_srfwfinstance t3 on t3.wfinstanceid = t1.wfinstanceid" + "	inner join t_srfwfinstance t4 on t3.pwfinstanceid = t4.wfinstanceid" + "	inner join t_srfwfstep t2 on t1.wfstepid = t2.wfstepid " + "   inner join t_srfwfstep t5 on t4.activestepid = t5.wfstepid" + "	 WHERE t3.PARALLELINST=1 AND  t1.CANCELFLAG = 0 and t1.WFACTORID=? AND t4.WFWORKFLOWID=? AND t4.USERDATA4=? " + "	) a GROUP BY wfstepname,wfworkflowid,pwfstepname  ";

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.CounterHandlerBase#onFetch()
	 */
	@Override
	protected AjaxActionResult onFetch() throws Exception {
		MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();

		String strCounterParam = WebContext.getCounterParam(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strCounterParam)) {
			throw new Exception(StringHelper.format("计数器参数无效"));
		}

		JSONObject jo = JSONObject.fromString(strCounterParam);
		String strDEID = jo.optString("srfdeid");
		String strWFID = jo.optString("srfwfid");

		IWFModel iWFModel = this.getSystemModel().getWFModel(strWFID);
		IDataEntityModel iDEModel = this.getSystemModel().getDataEntityModel(strDEID);
		IDEWFModel iDEWFModel = (IDEWFModel) iDEModel.getDEWF(strWFID);

		// 修改标示
		strDEID = iDEModel.getId();

		SqlParamList sqlParamList = new SqlParamList();
		sqlParamList.addString(this.getWebContext().getCurUserId());
		sqlParamList.addString(strWFID);
		sqlParamList.addString(strDEID);

		// 进行数据查询
		WFStepService wfStepService = (WFStepService) ServiceGlobal.getService(WFStepService.class,this.getSessionFactory());
		ArrayList<IEntity> list = null;
		
		if(StringHelper.compare(iWFModel.getWFEngineCat() , IWFModel.WFENGINETYPE_ACTIVITI, true) == 0){
			//Activiti引擎采用新模式查询工作流记录
			list = wfStepService.selectRaw(COUNTER_SQLEX, sqlParamList);
		} else{
			list = wfStepService.selectRaw(COUNTER_SQL, sqlParamList);
		}
			
		ArrayList<IEntity> list2 = null;
		if (iWFModel.getLastWFVersionModel().hasWFParallelSubWFProcessModel()) {
			list2 = wfStepService.selectRaw(COUNTER_SQL2, sqlParamList);
		}

		int nTotal = 0;

		JSONObject jsonObject = mdAjaxActionResult.getData(true);

		for (IEntity dataEntity : list) {
			String strWFStepName = DataObject.getStringValue(dataEntity.get("WFSTEPNAME"), "");
			if (StringHelper.compare(strWFStepName, "WFSTEPNAME", true) == 0) continue;

			// String strPWFStepName = DataObject.getStringValue(dataEntity.get("PWFSTEPNAME"),"");
			// if (StringHelper.compare(strPWFStepName, "WFSTEPNAME", true) == 0)
			// continue;

			jsonObject.put("V" + strWFStepName, DataObject.getIntegerValue(dataEntity, "CNT", 0));

			// String strDESUBWFID = DataObject.getStringValue(dataEntity.get("DESUBWFID"),"");
			// if (StringHelper.isNullOrEmpty(strDESUBWFID))
			// {
			// jsonObject.put("V" + strWFStepName, DataObject.getIntegerValue(dataEntity,"CNT",0));
			// }
			// else
			// {
			// jsonObject.put("V" + strPWFStepName + "_" + strDESUBWFID + "_" + strWFStepName, DataObject.getIntegerValue(dataEntity,"CNT",0));
			// }

			nTotal += DataObject.getIntegerValue(dataEntity, "CNT", 0);
		}

		if (list2 != null) {
			for (IEntity dataEntity : list2) {
				String strWFStepName = DataObject.getStringValue(dataEntity.get("WFSTEPNAME"), "");
				if (StringHelper.compare(strWFStepName, "WFSTEPNAME", true) == 0) continue;

				String strPWFStepName = DataObject.getStringValue(dataEntity.get("PWFSTEPNAME"), "");
				if (StringHelper.compare(strPWFStepName, "WFSTEPNAME", true) == 0) continue;

				String strWFWorkflowId = DataObject.getStringValue(dataEntity.get("WFWORKFLOWID"), "");

				jsonObject.put("V" + strPWFStepName + "_" + strWFWorkflowId.replace(":", "_") + "_" + strWFStepName, DataObject.getIntegerValue(dataEntity, "CNT", 0));

				nTotal += DataObject.getIntegerValue(dataEntity, "CNT", 0);
			}

		}

		jsonObject.put("V", nTotal);

		return mdAjaxActionResult;
	}

}
