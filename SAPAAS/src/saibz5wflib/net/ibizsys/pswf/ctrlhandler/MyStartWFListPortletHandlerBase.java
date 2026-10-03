package net.ibizsys.pswf.ctrlhandler;

import java.util.ArrayList;

import net.ibizsys.paas.ctrlhandler.CustomPortletHandlerBase;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.psrt.srv.wf.service.WFStepService;

/**
 * 我发起的流程工作后台处理对象
 * 
 * @author Administrator
 *
 */
public abstract class MyStartWFListPortletHandlerBase extends CustomPortletHandlerBase {
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.PortletHandlerBase#onFetch()
	 */
	@Override
	protected AjaxActionResult onFetch() throws Exception {
		MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);

		StringBuilderEx sql = new StringBuilderEx();
		sql.append("select * from ( " + " select t3.WFSTEPACTORID,t3.ACTORID,t3.CREATEDATE,t5.WFUSERNAME,t2.WFPLOGICNAME,t3.WFSTEPACTORNAME,t2.WFSTEPID," + " SUM (CASE WHEN t3.REMINDERCOUNT IS NULL THEN 0 ELSE t3.REMINDERCOUNT END   ) OVER (PARTITION BY t1.ACTIVESTEPID, t3.WFSTEPACTORNAME) AS REMINDERCOUNT ," + " ROW_NUMBER() OVER (PARTITION BY t1.ACTIVESTEPID, t3.WFSTEPACTORNAME ORDER By t5.WFUSERNAME ASC ) as ROWNUMBER," + " t1.WFINSTANCEID,t1.WFINSTANCENAME from t_SRFWFINSTANCE t1" + " INNER JOIN T_SRFWFSTEP t2 ON t1.ACTIVESTEPID =  t2.WFSTEPID " + " INNER JOIN T_SRFWFSTEPACTOR t3 ON t3.WFSTEPID = t2.WFSTEPID " + " INNER JOIN T_SRFWFUSER t5 ON t5.WFUSERID = t3.ACTORID " + " LEFT JOIN T_SRFWFSTEPDATA t4 ON t4.ACTORID = t3.ACTORID AND t4.WFSTEPID = t2.WFSTEPID" + " where (t1.ISCLOSE IS NULL OR t1.ISCLOSE = 0) AND t4.WFSTEPDATAID IS NULL AND t1.CREATEMAN=? and t3.ACTORID<> ? " + " ) b ");

		SqlParamList sqlParamList = new SqlParamList();
		sqlParamList.addString(this.getWebContext().getCurUserId());
		sqlParamList.addString(this.getWebContext().getCurUserId());

		// 进行数据查询
		WFStepService wfStepService = (WFStepService) ServiceGlobal.getService(WFStepService.class,this.getSessionFactory());
		ArrayList<IEntity> list = wfStepService.selectRaw(sql.toString(), sqlParamList);

		for (IEntity iEntity : list) {
			mdAjaxActionResult.getRows().add(DataObject.toJSONObject(iEntity, true));
		}
		return mdAjaxActionResult;
	}
}
