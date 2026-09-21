/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlhandler.CounterHandlerBase
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.demodel.IDEWFModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.MDAjaxActionResult
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.psrt.srv.wf.service.WFStepService
 *  net.ibizsys.pswf.core.IWFModel
 *  net.sf.json.JSONObject
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pswf.ctrlhandler;

import java.util.ArrayList;
import net.ibizsys.paas.ctrlhandler.CounterHandlerBase;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.IDEWFModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.wf.service.WFStepService;
import net.ibizsys.pswf.core.IWFModel;
import net.sf.json.JSONObject;
import org.hibernate.SessionFactory;

public class WFExpBarCounterHandler
extends CounterHandlerBase {
    public static final String COUNTER_SQL = " select wfstepname ,COUNT(*) AS CNT from \r\n \t\t(  \tSELECT t2.wfstepname  FROM T_SRFWFWORKLIST t1 \r\n \t\tinner join t_srfwfstep t2 on t1.wfstepid = t2.wfstepid \r\n  \t\t WHERE t1.CANCELFLAG = 0 and t1.WFACTORID=? AND t1.WFWORKFLOWID=? AND t1.USERDATA4=?   \r\n\t\t ) a GROUP BY wfstepname ";
    public static final String COUNTER_SQLEX = " select wfstepname ,COUNT(*) AS CNT from \r\n \t\t(  \tSELECT t1.wfstepvalue wfstepname  FROM T_SRFWFWORKLIST t1 \r\n \t\t WHERE t1.CANCELFLAG = 0 and t1.WFACTORID=? AND t1.WFWORKFLOWID=? AND t1.USERDATA4=?   \r\n\t\t ) a GROUP BY wfstepname ";
    public static final String COUNTER_SQL2 = " select wfstepname ,wfworkflowid,pwfstepname,COUNT(*) AS CNT from \t( \tSELECT t2.wfstepname,t1.wfworkflowid,t5.wfstepname as pwfstepname  FROM T_SRFWFWORKLIST t1 \tinner join t_srfwfinstance t3 on t3.wfinstanceid = t1.wfinstanceid\tinner join t_srfwfinstance t4 on t3.pwfinstanceid = t4.wfinstanceid\tinner join t_srfwfstep t2 on t1.wfstepid = t2.wfstepid    inner join t_srfwfstep t5 on t4.activestepid = t5.wfstepid\t WHERE t3.PARALLELINST=1 AND  t1.CANCELFLAG = 0 and t1.WFACTORID=? AND t4.WFWORKFLOWID=? AND t4.USERDATA4=? \t) a GROUP BY wfstepname,wfworkflowid,pwfstepname  ";

    protected AjaxActionResult onFetch() throws Exception {
        String strWFStepName;
        MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
        String strCounterParam = WebContext.getCounterParam((IWebContext)this.getWebContext());
        if (StringHelper.isNullOrEmpty((String)strCounterParam)) {
            throw new Exception(StringHelper.format((String)"\u8ba1\u6570\u5668\u53c2\u6570\u65e0\u6548"));
        }
        JSONObject jo = JSONObject.fromString((String)strCounterParam);
        String strDEID = jo.optString("srfdeid");
        String strWFID = jo.optString("srfwfid");
        IWFModel iWFModel = this.getSystemModel().getWFModel(strWFID);
        IDataEntityModel iDEModel = this.getSystemModel().getDataEntityModel(strDEID);
        IDEWFModel iDEWFModel = (IDEWFModel)iDEModel.getDEWF(strWFID);
        strDEID = iDEModel.getId();
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(this.getWebContext().getCurUserId());
        sqlParamList.addString(strWFID);
        sqlParamList.addString(strDEID);
        WFStepService wfStepService = (WFStepService)ServiceGlobal.getService(WFStepService.class, (SessionFactory)this.getSessionFactory());
        ArrayList list = null;
        list = StringHelper.compare((String)iWFModel.getWFEngineCat(), (String)"ACTIVITI", (boolean)true) == 0 ? wfStepService.selectRaw(COUNTER_SQLEX, sqlParamList) : wfStepService.selectRaw(COUNTER_SQL, sqlParamList);
        ArrayList list2 = null;
        if (iWFModel.getLastWFVersionModel().hasWFParallelSubWFProcessModel()) {
            list2 = wfStepService.selectRaw(COUNTER_SQL2, sqlParamList);
        }
        int nTotal = 0;
        JSONObject jsonObject = mdAjaxActionResult.getData(true);
        for (IEntity dataEntity : list) {
            strWFStepName = DataObject.getStringValue((Object)dataEntity.get("WFSTEPNAME"), (String)"");
            if (StringHelper.compare((String)strWFStepName, (String)"WFSTEPNAME", (boolean)true) == 0) continue;
            jsonObject.put("V" + strWFStepName, DataObject.getIntegerValue((IDataObject)dataEntity, (String)"CNT", (int)0));
            nTotal += DataObject.getIntegerValue((IDataObject)dataEntity, (String)"CNT", (int)0);
        }
        if (list2 != null) {
            for (IEntity dataEntity : list2) {
                String strPWFStepName;
                strWFStepName = DataObject.getStringValue((Object)dataEntity.get("WFSTEPNAME"), (String)"");
                if (StringHelper.compare((String)strWFStepName, (String)"WFSTEPNAME", (boolean)true) == 0 || StringHelper.compare((String)(strPWFStepName = DataObject.getStringValue((Object)dataEntity.get("PWFSTEPNAME"), (String)"")), (String)"WFSTEPNAME", (boolean)true) == 0) continue;
                String strWFWorkflowId = DataObject.getStringValue((Object)dataEntity.get("WFWORKFLOWID"), (String)"");
                jsonObject.put("V" + strPWFStepName + "_" + strWFWorkflowId.replace(":", "_") + "_" + strWFStepName, DataObject.getIntegerValue((IDataObject)dataEntity, (String)"CNT", (int)0));
                nTotal += DataObject.getIntegerValue((IDataObject)dataEntity, (String)"CNT", (int)0);
            }
        }
        jsonObject.put("V", nTotal);
        return mdAjaxActionResult;
    }
}

