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
 * 我被催办的流程工作后台处理对象
 * 
 * @author Administrator
 *
 */
public abstract class MyRemindWFListPortletHandlerBase extends CustomPortletHandlerBase {
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
		sql.append(" select t1.*,t4.WFWORKFLOWID,t4.WFWORKFLOWNAME,t5.WFPLOGICNAME,t5.WFSTEPNAME,t3.USERDATA4,t6.WFUSERNAME from t_srfwfreminder t1 " + " inner join t_srfwfstepactor t2 on t1.WFSTEPACTORID = t2.WFSTEPACTORID " + " inner join t_srfwfinstance t3 on t2.WFSTEPID = t3.ACTIVESTEPID " + " inner join T_SRFWFWORKFLOW t4 on t3.WFWORKFLOWID = t4.WFWORKFLOWID " + " inner join T_SRFWFSTEP t5 on t5.WFSTEPID = t2.WFSTEPID " + " inner join T_SRFWFUSER t6 on t6.WFUSERID = t1.WFUSERID " + " where ( t2.ISFINISH IS NULL OR t2.ISFINISH = 0 )  AND (  t3.isclose is null OR  t3.isclose = 0 )   AND t2.ACTORID = ? ");

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
