/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlhandler.CustomPortletHandlerBase
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.MDAjaxActionResult
 *  net.ibizsys.psrt.srv.wf.service.WFStepService
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pswf.ctrlhandler;

import java.util.ArrayList;
import net.ibizsys.paas.ctrlhandler.CustomPortletHandlerBase;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.psrt.srv.wf.service.WFStepService;
import org.hibernate.SessionFactory;

public abstract class MyRemindWFListPortletHandlerBase
extends CustomPortletHandlerBase {
    protected AjaxActionResult onFetch() throws Exception {
        MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult((AjaxActionResult)mdAjaxActionResult);
        StringBuilderEx sql = new StringBuilderEx();
        sql.append(" select t1.*,t4.WFWORKFLOWID,t4.WFWORKFLOWNAME,t5.WFPLOGICNAME,t5.WFSTEPNAME,t3.USERDATA4,t6.WFUSERNAME from t_srfwfreminder t1  inner join t_srfwfstepactor t2 on t1.WFSTEPACTORID = t2.WFSTEPACTORID  inner join t_srfwfinstance t3 on t2.WFSTEPID = t3.ACTIVESTEPID  inner join T_SRFWFWORKFLOW t4 on t3.WFWORKFLOWID = t4.WFWORKFLOWID  inner join T_SRFWFSTEP t5 on t5.WFSTEPID = t2.WFSTEPID  inner join T_SRFWFUSER t6 on t6.WFUSERID = t1.WFUSERID  where ( t2.ISFINISH IS NULL OR t2.ISFINISH = 0 )  AND (  t3.isclose is null OR  t3.isclose = 0 )   AND t2.ACTORID = ? ");
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(this.getWebContext().getCurUserId());
        WFStepService wfStepService = (WFStepService)ServiceGlobal.getService(WFStepService.class, (SessionFactory)this.getSessionFactory());
        ArrayList list = wfStepService.selectRaw(sql.toString(), sqlParamList);
        for (IEntity iEntity : list) {
            mdAjaxActionResult.getRows().add(DataObject.toJSONObject((IDataObject)iEntity, (boolean)true));
        }
        return mdAjaxActionResult;
    }
}

