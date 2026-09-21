/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlhandler.CounterHandlerBase
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.MDAjaxActionResult
 *  net.ibizsys.paas.web.WebConfig
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.psrt.srv.wf.service.WFWorkListService
 *  net.sf.json.JSONObject
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.psportal.core.ctrlhandler;

import java.util.ArrayList;
import java.util.Random;
import net.ibizsys.paas.ctrlhandler.CounterHandlerBase;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.wf.service.WFWorkListService;
import net.sf.json.JSONObject;
import org.hibernate.SessionFactory;

public class PortalCounterHandler
extends CounterHandlerBase {
    protected AjaxActionResult onFetch() throws Exception {
        MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
        String strCounterParam = WebContext.getCounterParam((IWebContext)this.getWebContext());
        if (StringHelper.isNullOrEmpty((String)strCounterParam)) {
            throw new Exception(StringHelper.format((String)"\u8ba1\u6570\u5668\u53c2\u6570\u65e0\u6548"));
        }
        JSONObject dataObject = mdAjaxActionResult.getData(true);
        Random random = new Random();
        dataObject.put("MESSAGE", random.nextInt(20));
        dataObject.put("NOTIFICATION", random.nextInt(20));
        StringBuilderEx sql = new StringBuilderEx();
        if (WebConfig.getCurrent().isLowCaseSql()) {
            sql.append("select t1.cancelflag,t1.cancelinform,t1.createdate,t1.createman,t1.originalwfuserid,t1.originalwfusername,t1.updatedate,t1.updateman,t1.userdata,t1.userdata2,t1.userdata3,t1.userdata4,t1.userdatainfo,t1.wfactorid,t1.wfinstanceid,t1.wfinstancename,t1.wflanrestag,t1.wfstepid,t1.wfsteplanrestag,t1.wfstepname,t1.wfworkflowid,t1.wfworkflowname,t1.wfworklistid,t1.wfworklistname,t1.workinform  from t_srfwfworklist t1 where t1.wfactorid=? and t1.cancelflag = 0 order by t1.createdate ");
        } else {
            sql.append("select t1.*  FROM T_SRFWFWORKLIST t1 where t1.wfactorid=? and t1.cancelflag = 0 order by t1.createdate ");
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(this.getWebContext().getCurUserId());
        WFWorkListService wfStepService = (WFWorkListService)ServiceGlobal.getService(WFWorkListService.class, (SessionFactory)this.getViewController().getSessionFactory());
        ArrayList list = wfStepService.selectRaw(sql.toString(), sqlParamList);
        ArrayList<JSONObject> wfTaskList = new ArrayList<JSONObject>();
        for (IEntity iEntity : list) {
            wfTaskList.add(DataObject.toJSONObject((IDataObject)iEntity, (boolean)true));
        }
        JSONObject jsonWFTask = new JSONObject();
        jsonWFTask.put("items", (Object)wfTaskList.toArray());
        jsonWFTask.put("totalrow", wfTaskList.size());
        dataObject.put("WFTASK", (Object)jsonWFTask);
        return mdAjaxActionResult;
    }
}

