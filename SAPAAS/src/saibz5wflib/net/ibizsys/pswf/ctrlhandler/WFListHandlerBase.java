/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSetCond
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEDataSetCond
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.core.IDEWF
 *  net.ibizsys.paas.ctrlhandler.ListHandlerBase
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFProcessModel
 *  net.ibizsys.pswf.core.IWFService
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  net.ibizsys.pswf.core.WFActionParam
 */
package net.ibizsys.pswf.ctrlhandler;

import java.util.ArrayList;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.ctrlhandler.ListHandlerBase;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pswf.controller.IWFDEViewController;
import net.ibizsys.pswf.controller.IWFViewController;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFProcessModel;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.pswf.core.WFActionParam;

public abstract class WFListHandlerBase
extends ListHandlerBase {
    protected IDEWF getDEWF() {
        if (this.getViewController() instanceof IWFDEViewController) {
            return ((IWFDEViewController)this.getViewController()).getDEWF();
        }
        return null;
    }

    protected boolean isWFIAMode() {
        if (this.getViewController() instanceof IWFViewController) {
            return ((IWFViewController)this.getViewController()).isWFIAMode();
        }
        return false;
    }

    protected String getWFStepValue() {
        if (this.getViewController() instanceof IWFViewController) {
            return ((IWFViewController)this.getViewController()).getWFStepValue();
        }
        return "";
    }

    protected IWFModel getWFModel() {
        if (this.getViewController() instanceof IWFViewController) {
            return ((IWFViewController)this.getViewController()).getWFModel();
        }
        return null;
    }

    protected IWFVersionModel getWFVersionModel() {
        return this.getWFModel().getLastWFVersionModel();
    }

    protected void onFillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        String strWFInstFieldExp;
        super.onFillDEDataSetFetchContext(deDataSetFetchContextImpl);
        if (this.isWFIAMode() && !StringHelper.isNullOrEmpty((String)(strWFInstFieldExp = this.getDEWF().getWFInstField()))) {
            StringBuilderEx script = new StringBuilderEx();
            script.append(" INNER JOIN T_SRFWFINSTANCE wf1 ON ${srfdefieldexp('%1$s')} = wf1.WFINSTANCEID ", (Object)strWFInstFieldExp);
            script.append(" INNER JOIN T_SRFWFSTEPACTOR wf2 ON wf1.ACTIVESTEPID = wf2.WFSTEPID ");
            script.append(" LEFT JOIN T_SRFWFSTEPDATA wf3 ON wf2.WFSTEPID = wf3.WFSTEPID AND wf2.ACTORID=wf3.ACTORID AND wf3.CONNECTIONNAME<>'SRFWFRESUBMIT' AND wf3.CONNECTIONNAME<>'SRFWFTIMEOUT'", (Object)strWFInstFieldExp);
            deDataSetFetchContextImpl.setJoinScript(script.toString());
        }
    }

    protected void onFillFetchURLConditions(ArrayList<IDEDataSetCond> userConditions) throws Exception {
        super.onFillFetchURLConditions(userConditions);
        this.onFillFetchWFConditions(userConditions);
    }

    protected void onFillFetchWFConditions(ArrayList<IDEDataSetCond> userConditions) throws Exception {
        String strUDStateValue;
        DEDataSetCond deDataSetCondImpl;
        String strWFStateValue;
        String strWFStepValue = WebContext.getWFStep((IWebContext)this.getWebContext());
        if (this.isWFIAMode() && !StringHelper.isNullOrEmpty((String)this.getWFStepValue())) {
            strWFStepValue = this.getWFStepValue();
        }
        if (!StringHelper.isNullOrEmpty((String)strWFStepValue) && !StringHelper.isNullOrEmpty((String)this.getDEWF().getWFStepField())) {
            IDEField iDEFieldModel = this.getDEModel().getDEField(this.getDEWF().getWFStepField(), false);
            DEDataSetCond deDataSetCondImpl2 = new DEDataSetCond();
            deDataSetCondImpl2.setCondType("DEFIELD");
            deDataSetCondImpl2.setCondOp("EQ");
            deDataSetCondImpl2.setDEFName(iDEFieldModel.getName());
            deDataSetCondImpl2.setCondValue(strWFStepValue);
            userConditions.add((IDEDataSetCond)deDataSetCondImpl2);
        }
        if (!StringHelper.isNullOrEmpty((String)(strWFStateValue = WebContext.getWFState((IWebContext)this.getWebContext()))) && !StringHelper.isNullOrEmpty((String)this.getDEWF().getWFStateField())) {
            IDEField iDEFieldModel = this.getDEModel().getDEField(this.getDEWF().getWFStateField(), false);
            deDataSetCondImpl = new DEDataSetCond();
            deDataSetCondImpl.setCondType("DEFIELD");
            deDataSetCondImpl.setCondOp("EQ");
            deDataSetCondImpl.setDEFName(iDEFieldModel.getName());
            deDataSetCondImpl.setCondValue(strWFStateValue);
            userConditions.add((IDEDataSetCond)deDataSetCondImpl);
        }
        if (!StringHelper.isNullOrEmpty((String)(strUDStateValue = WebContext.getWFUDState((IWebContext)this.getWebContext()))) && !StringHelper.isNullOrEmpty((String)this.getDEWF().getUDStateField())) {
            IDEField iDEFieldModel = this.getDEModel().getDEField(this.getDEWF().getUDStateField(), false);
            DEDataSetCond deDataSetCondImpl3 = new DEDataSetCond();
            deDataSetCondImpl3.setCondType("DEFIELD");
            deDataSetCondImpl3.setCondOp("EQ");
            deDataSetCondImpl3.setDEFName(iDEFieldModel.getName());
            deDataSetCondImpl3.setCondValue(strUDStateValue);
            userConditions.add((IDEDataSetCond)deDataSetCondImpl3);
        }
        if (this.isWFIAMode()) {
            deDataSetCondImpl = new DEDataSetCond();
            deDataSetCondImpl.setCondType("CUSTOM");
            deDataSetCondImpl.setCustomCond(StringHelper.format((String)"wf1.WFWORKFLOWID='%1$s'", (Object)this.getDEWF().getWorkflowId()));
            userConditions.add((IDEDataSetCond)deDataSetCondImpl);
            deDataSetCondImpl = new DEDataSetCond();
            deDataSetCondImpl.setCondType("CUSTOM");
            deDataSetCondImpl.setCustomCond(StringHelper.format((String)"wf2.ACTORID='%1$s'", (Object)this.getWebContext().getCurUserId()));
            userConditions.add((IDEDataSetCond)deDataSetCondImpl);
            deDataSetCondImpl = new DEDataSetCond();
            deDataSetCondImpl.setCondType("CUSTOM");
            deDataSetCondImpl.setCustomCond(StringHelper.format((String)"wf3.ACTORID IS NULL"));
            userConditions.add((IDEDataSetCond)deDataSetCondImpl);
        }
    }

    protected AjaxActionResult onProcessAction(String strAction) throws Exception {
        if (StringHelper.compare((String)strAction, (String)"wfsubmit", (boolean)true) == 0) {
            return this.onWFSubmit();
        }
        return super.onProcessAction(strAction);
    }

    protected AjaxActionResult onWFSubmit() throws Exception {
        AjaxActionResult ajaxActionResult = new AjaxActionResult();
        String strKeys = WebContext.getKeys((IWebContext)this.getWebContext());
        if (StringHelper.isNullOrEmpty((String)strKeys)) {
            strKeys = WebContext.getKey((IWebContext)this.getWebContext());
        }
        if (StringHelper.isNullOrEmpty((String)strKeys)) {
            ajaxActionResult.setRetCode(4);
            return ajaxActionResult;
        }
        String strIATag = WebContext.getWFIATag((IWebContext)this.getWebContext());
        String[] keys = strKeys.split("[;]");
        IWFService iWFService = this.getWFModel().getWFService();
        IWFProcessModel iWFProcessModel = this.getWFModel().getLastWFVersionModel().getWFProcessModelByWFStepValue(this.getWFStepValue(), false);
        String[] stringArray = keys;
        int n = keys.length;
        int n2 = 0;
        while (n2 < n) {
            String strKey = stringArray[n2];
            WFActionParam wfActionParam = new WFActionParam();
            wfActionParam.setUserData(strKey);
            wfActionParam.setUserData4(this.getDEModel().getId());
            wfActionParam.setOpPersonId(this.getWebContext().getCurUserId());
            wfActionParam.setStepId(iWFProcessModel.getId());
            wfActionParam.setConnection(strIATag);
            wfActionParam.setWFMode(this.getWebContext().getWFMode());
            iWFService.submit(wfActionParam);
            ++n2;
        }
        return ajaxActionResult;
    }

    protected void fillDEDataSetFetchDataRange(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        if (this.isWFIAMode()) {
            return;
        }
        super.fillDEDataSetFetchDataRange(deDataSetFetchContextImpl);
    }
}

