/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExGridFetchResult
 */
package SA.SRFDA.WF.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExGridFetchResult;
import java.util.Vector;

public class WFStepDataDGActionHelper
extends BaseDADataGridActionHelper {
    protected IDEHelper iUserDataDEHelper = null;
    protected String strActiveWFInstId = "";
    protected String strActiveUserData = "";
    protected String strWFInstAlias = "";
    protected boolean bShowAllWFStepData = false;

    protected boolean OnBeforeProcess() {
        if (!super.OnBeforeProcess()) {
            return false;
        }
        String strPDEID = this.getWebContext().getSRFPDEID();
        if (!StringHelper.IsNullOrEmpty((String)strPDEID)) {
            this.iUserDataDEHelper = this.getPage().getDAModelStorage().FindDEHelper(strPDEID);
            if (this.iUserDataDEHelper == null) {
                this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strPDEID));
                return false;
            }
            if (!StringHelper.IsNullOrEmpty((String)this.iUserDataDEHelper.GetDEWF().getWFINSTDEFID())) {
                this.strActiveUserData = this.getWebContext().GetParamValue(this.iUserDataDEHelper.GetKeyDEFHelper().getName());
                if (StringHelper.IsNullOrEmpty((String)this.strActiveUserData)) {
                    this.strActiveUserData = this.getWebContext().GetPostValue(this.iUserDataDEHelper.GetKeyDEFHelper().getName().toLowerCase());
                }
                if (StringHelper.IsNullOrEmpty((String)this.strActiveUserData)) {
                    this.strActiveUserData = "SRFNADATA_2E26C985-08C8-4874-B14E-C091751C43C9";
                    this.strActiveWFInstId = "SRFNADATA_2E26C985-08C8-4874-B14E-C091751C43C9";
                } else {
                    BaseDataEntity dataEntity = new BaseDataEntity();
                    dataEntity.SetParamValue(this.iUserDataDEHelper.GetKeyDEFHelper().getName(), this.iUserDataDEHelper.GetKeyDEFHelper().GetDEFValue(this.strActiveUserData));
                    IDEDataCtrl iUserDataDataCtrl = this.getPage().GetDEDataCtrl(this.iUserDataDEHelper.getId());
                    if (iUserDataDataCtrl == null) {
                        this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u8f85\u52a9\u5bf9\u8c61", (Object)strPDEID));
                        return false;
                    }
                    CallResult callResult = iUserDataDataCtrl.Get(dataEntity);
                    if (callResult.IsError()) {
                        this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]\u5931\u8d25\uff0c%3$s", (Object)strPDEID, (Object)this.strActiveUserData, (Object)callResult.getErrorInfo()));
                        return false;
                    }
                    IDEFHelper wfInstDEFHelper = this.iUserDataDEHelper.GetDEFHelper(this.iUserDataDEHelper.GetDEWF().getWFINSTDEFID());
                    if (wfInstDEFHelper == null) {
                        this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strPDEID, (Object)this.iUserDataDEHelper.GetDEWF().getWFINSTDEFID()));
                        return false;
                    }
                    this.strActiveWFInstId = dataEntity.GetParamStringValue(wfInstDEFHelper.getName(), "");
                }
            }
        }
        this.bShowAllWFStepData = this.getWebContext().getWebExConfig().GetValue("SRFDA.WF", "SHOWALLWFSTEPDATA", false);
        return true;
    }

    protected boolean OnGetUserDP() {
        return false;
    }

    protected String GetDAModelQueryScript(BaseDAQueryModelHelper daQueryModelHelper) {
        String strSql = super.GetDAModelQueryScript(daQueryModelHelper);
        if (this.getWebContext().getGlobalHelper().getDAModelVersion() >= 11071100) {
            IDEFHelper wfInstDEFHelper = daQueryModelHelper.GetMajorDEHelper().GetDEFHelper("WFINSTANCEID");
            if (wfInstDEFHelper == null) {
                this.strWFInstAlias = "wf1";
                strSql = String.valueOf(strSql) + " LEFT JOIN T_SRFWFINSTANCE wf1 ON t1.WFINSTANCEID = wf1.WFINSTANCEID  ";
            } else {
                ILinkDEFHelper pickupDEFHelper;
                int nAlias;
                this.strWFInstAlias = "";
                if (wfInstDEFHelper instanceof ILinkDEFHelper && (nAlias = daQueryModelHelper.GetMajorDERAlias((pickupDEFHelper = (ILinkDEFHelper)wfInstDEFHelper).GetDERId())) != -1) {
                    this.strWFInstAlias = StringHelper.Format((String)"t%1$s", (Object)(nAlias + 1));
                }
                if (StringHelper.IsNullOrEmpty((String)this.strWFInstAlias)) {
                    this.strWFInstAlias = "wf1";
                    strSql = String.valueOf(strSql) + " LEFT JOIN T_SRFWFINSTANCE wf1 ON t1.WFINSTANCEID = wf1.WFINSTANCEID  ";
                }
            }
        }
        return strSql;
    }

    protected void FillDAQueryModelHelperCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        super.FillDAQueryModelHelperCondition(userConditions, daQueryModelHelper);
        if (this.getWebContext().getGlobalHelper().getDAModelVersion() >= 11071100) {
            userConditions.add(StringHelper.Format((String)"%2$s.USERDATA = '%1$s'", (Object)this.strActiveUserData, (Object)this.strWFInstAlias));
            userConditions.add(StringHelper.Format((String)"%2$s.USERDATA4 = '%1$s'", (Object)this.iUserDataDEHelper.getId(), (Object)this.strWFInstAlias));
            if (!this.bShowAllWFStepData && !StringHelper.IsNullOrEmpty((String)this.strActiveWFInstId)) {
                userConditions.add(StringHelper.Format((String)"%2$s.WFINSTANCEID = '%1$s' OR %2$s.PWFINSTANCEID = '%1$s'", (Object)this.strActiveWFInstId, (Object)this.strWFInstAlias));
            }
        }
    }

    protected void SelectAndFillFetchResult(String strCountSQL, String strPagingSQL, Vector<CallParam> list, SRFExGridFetchResult fetchResult) {
        if (this.iUserDataDEHelper != null) {
            for (CallParam callParam : list) {
                if (StringHelper.Compare((String)callParam.getParamName(), (String)"DEID", (boolean)true) == 0) {
                    callParam.setValue((Object)this.iUserDataDEHelper.getId());
                    continue;
                }
                if (StringHelper.Compare((String)callParam.getParamName(), (String)"USERDATA", (boolean)true) != 0) continue;
                callParam.setValue((Object)this.strActiveUserData);
            }
        }
        super.SelectAndFillFetchResult(strCountSQL, strPagingSQL, list, fetchResult);
    }

    protected CallResult SelectAndExport(String strPagingSQL, Vector<CallParam> list, String strExportType) {
        if (this.iUserDataDEHelper != null) {
            for (CallParam callParam : list) {
                if (StringHelper.Compare((String)callParam.getParamName(), (String)"DEID", (boolean)true) == 0) {
                    callParam.setValue((Object)this.iUserDataDEHelper.getId());
                    continue;
                }
                if (StringHelper.Compare((String)callParam.getParamName(), (String)"USERDATA", (boolean)true) != 0) continue;
                callParam.setValue((Object)this.strActiveUserData);
            }
        }
        return super.SelectAndExport(strPagingSQL, list, strExportType);
    }
}

