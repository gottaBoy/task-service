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
 * 我的工作清单后台处理对象
 * 
 * @author Administrator
 *
 */
public abstract class MyWFWork2ListPortletHandlerBase extends CustomPortletHandlerBase {
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
		sql.append("select t3.WFWORKFLOWID,t3.WFWORKFLOWNAME,t1.WFPLOGICNAME,t4.ACTORID,t1.WFSTEPNAME,t2.USERDATA4 from T_SRFWFSTEP t1 INNER JOIN t_SRFWFINSTANCE t2 on  t2.ACTIVESTEPID = t1.WFSTEPID AND ( t2.ISCLOSE IS NULL OR t2.ISCLOSE=0) " + "INNER JOIN T_SRFWFWORKFLOW t3 on t2.WFWORKFLOWID = t3.WFWORKFLOWID  " + "INNER JOIN T_SRFWFSTEPACTOR t4 on  t4.WFSTEPID = t1.WFSTEPID  " + "LEFT JOIN T_SRFWFSTEPDATA t5 ON (t5.ACTORID=T4.ACTORID and  t5.WFSTEPID = t2.ACTIVESTEPID AND  t5.CONNECTIONNAME<>'SRFWFRESUBMIT' AND t5.CONNECTIONNAME <> 'SRFWFTIMEOUT') " + "where t5.WFSTEPDATAID IS NULL AND t4.ACTORID=? ");

		SqlParamList sqlParamList = new SqlParamList();
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
