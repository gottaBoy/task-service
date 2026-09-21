/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper
 *  SA.SRFDA.Ctrl.IDAQueryModelUserContext
 *  SA.SRFramework.Utility.StringHelper
 *  SRFWF.Ctrl.Data.WFInstance
 */
package SA.SRFDA.WF.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFDA.Ctrl.IDAQueryModelUserContext;
import SA.SRFramework.Utility.StringHelper;
import SRFWF.Ctrl.Data.WFInstance;
import java.util.Vector;

public class WFStepActorDGActionHelper
extends BaseDADataGridActionHelper {
    protected WFInstance wfInst = null;

    protected boolean OnBeforeProcess() {
        this.wfInst = (WFInstance)this.getPage().getPageParam("WFINSTANCE");
        return super.OnBeforeProcess();
    }

    protected boolean OnGetUserDP() {
        return false;
    }

    protected String GetDAModelQueryScript(BaseDAQueryModelHelper daQueryModelHelper) {
        IDEFHelper wfStepDEFHelper;
        String strSql = super.GetDAModelQueryScript(daQueryModelHelper);
        if (this.getWebContext().getGlobalHelper().getDAModelVersion() >= 11071100 && (wfStepDEFHelper = daQueryModelHelper.GetMajorDEHelper().GetDEFHelper("WFSTEPID")) != null) {
            ILinkDEFHelper pickupDEFHelper;
            int nAlias;
            String strWFStepAlias = "";
            if (wfStepDEFHelper instanceof ILinkDEFHelper && (nAlias = daQueryModelHelper.GetMajorDERAlias((pickupDEFHelper = (ILinkDEFHelper)wfStepDEFHelper).GetDERId())) != -1) {
                strWFStepAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 1));
            }
            if (!StringHelper.IsNullOrEmpty((String)strWFStepAlias)) {
                strSql = String.valueOf(strSql) + StringHelper.Format((String)"  INNER JOIN T_SRFWFINSTANCE wf1 ON wf1.WFINSTANCEID = %1$s.WFINSTANCEID and wf1.ACTIVESTEPID = %1$s.WFSTEPID  ", (Object)strWFStepAlias);
            }
        }
        return strSql;
    }

    protected void FillDAQueryModelHelperCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        super.FillDAQueryModelHelperCondition(userConditions, daQueryModelHelper);
        if (this.getWebContext().getGlobalHelper().getDAModelVersion() >= 11071100) {
            userConditions.add(StringHelper.Format((String)"wf1.WFINSTANCEID = '%1$s' OR wf1.PWFINSTANCEID = '%1$s'", (Object)this.wfInst.getWFINSTANCEID()));
        } else {
            IDEFHelper iDEFHelper = this.getPage().getDEHelper().GetDEFHelper("WFSTEPID");
            String strCondition = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, "", "=", this.wfInst.getACTIVESTEPID());
            if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                userConditions.add(strCondition);
            }
        }
    }
}

