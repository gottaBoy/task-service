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

public abstract class MyWFWorkListPortletHandlerBase
extends CustomPortletHandlerBase {
    protected AjaxActionResult onFetch() throws Exception {
        MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult((AjaxActionResult)mdAjaxActionResult);
        StringBuilderEx sql = new StringBuilderEx();
        sql.append("select t3.WFWORKFLOWID,t3.WFWORKFLOWNAME,t1.WFPLOGICNAME,t4.ACTORID,t1.WFSTEPNAME,t2.USERDATA4 from T_SRFWFSTEP t1 INNER JOIN t_SRFWFINSTANCE t2 on  t2.ACTIVESTEPID = t1.WFSTEPID AND ( t2.ISCLOSE IS NULL OR t2.ISCLOSE=0) INNER JOIN T_SRFWFWORKFLOW t3 on t2.WFWORKFLOWID = t3.WFWORKFLOWID  INNER JOIN T_SRFWFSTEPACTOR t4 on  t4.WFSTEPID = t1.WFSTEPID  LEFT JOIN T_SRFWFSTEPDATA t5 ON (t5.ACTORID=T4.ACTORID and  t5.WFSTEPID = t2.ACTIVESTEPID AND  t5.CONNECTIONNAME<>'SRFWFRESUBMIT' AND t5.CONNECTIONNAME <> 'SRFWFTIMEOUT') where t5.WFSTEPDATAID IS NULL AND t4.ACTORID=? ");
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

