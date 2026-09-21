/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.BaseDataEntityEx
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Script.DataGridJSHelper
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Default.GridViewPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.JSGear.DataGridNewEditJSGear;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.BaseDataEntityEx;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;

public class NavFrameGridPage
extends GridViewPage {
    protected String strMajorPageDEId = "";

    @Override
    protected String GetDefaultPageDataEntityId() {
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        if (StringHelper.Length((String)this.getWebContext().GetParamValue("MINORDEID")) > 0) {
            this.strPageDataEntityId = this.getWebContext().GetParamValue("MINORDEID");
            this.strMajorPageDEId = this.getWebContext().getSRFPDEID();
            this.getWebContext().SetParamValue("SRFDEID", this.strPageDataEntityId);
        }
        return this.strPageDataEntityId;
    }

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        IDEHelper majorDEHelper = null;
        if (StringHelper.Length((String)this.getWebContext().GetParamValue("MINORDEFIELDS")) > 0) {
            majorDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper(this.strMajorPageDEId);
            BaseDataEntityEx obj = new BaseDataEntityEx();
            String strPID = this.getWebContext().GetParamValue(majorDEHelper.GetKeyDEFHelper().getName());
            if (StringHelper.IsNullOrEmpty((String)strPID)) {
                strPID = this.getWebContext().GetParamValue("SRFPARENTDATA");
            }
            obj.SetParamValue(majorDEHelper.GetKeyDEFHelper().getName(), (Object)strPID);
            CallResult callResult = majorDEHelper.GetDEDataCtrl(this.getWebContext().getCurUserId(), (ISRFDAWebContext)this.getWebContext()).Get((BaseDataEntity)obj);
            if (callResult.getRetCode() == 0) {
                String[] arrDEFields = this.getWebContext().GetParamValue("MINORDEFIELDS").split(",");
                int i = 0;
                while (i < arrDEFields.length) {
                    String strMinorDEField = arrDEFields[i];
                    if (StringHelper.Length((String)strMinorDEField) > 0) {
                        String[] arrDEField = strMinorDEField.split("\\|");
                        String strMinorDEDEFNAME = "";
                        String strMajorDEDEFNAME = "";
                        if (arrDEField.length >= 1) {
                            strMinorDEDEFNAME = arrDEField[0];
                        }
                        if (arrDEField.length >= 2) {
                            strMajorDEDEFNAME = arrDEField[1];
                        }
                        if (StringHelper.Length((String)strMajorDEDEFNAME) == 0) {
                            strMajorDEDEFNAME = strMinorDEDEFNAME;
                        }
                        if (StringHelper.Length((String)strMinorDEDEFNAME) != 0) {
                            if (this.getDEHelper().GetDEFHelper(strMinorDEDEFNAME) != null && this.getDEHelper().GetDEFHelper(strMinorDEDEFNAME).IsLinkDEField()) {
                                ILinkDEFHelper linkDEFHelper = (ILinkDEFHelper)this.getDEHelper().GetDEFHelper(strMinorDEDEFNAME);
                                if (linkDEFHelper != null) {
                                    this.getWebContext().SetParamValue("SRFDERID", linkDEFHelper.GetDERId());
                                    this.getWebContext().SetParamValue(linkDEFHelper.GetRelatedDEFHelper().getName(), obj.GetParamStringValue(strMajorDEDEFNAME, ""));
                                }
                            } else {
                                this.getWebContext().SetParamValue(strMinorDEDEFNAME, obj.GetParamStringValue(strMajorDEDEFNAME, ""));
                            }
                        }
                    }
                    ++i;
                }
            }
        }
        return true;
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        boolean bDGNew = true;
        boolean bDGEdit = true;
        boolean bDGDBClkEdit = false;
        this.LoadDataGridNewEditGear(bDGNew, bDGEdit, bDGDBClkEdit);
        if (StringHelper.Compare((String)this.getWebContext().GetParamValue("SELECTMODE"), (String)"S", (boolean)true) == 0) {
            StringBuilderEx script = new StringBuilderEx();
            script.Append(DataGridJSHelper.getOnRowSelectedEventScript((String)this.dataGrid.getUniqueID(), (String)StringHelper.Format((String)"parent._SELECTROW=%1$s;", (Object)DataGridJSHelper.getSelectedRecord((String)this.dataGrid.getUniqueID()))));
            script.Append(DataGridJSHelper.getOnRowSelectedCancelEventScript((String)this.dataGrid.getUniqueID(), (String)StringHelper.Format((String)"parent._SELECTROW=null;")));
            this.RegisterOnReadyScript(3, script.toString());
            this.RegisterOnReadyScript(3, DataGridJSHelper.getOnRowDbClickedEventScript((String)this.dataGrid.getUniqueID(), (String)"parent.selectvalue();"));
        } else if (StringHelper.Compare((String)this.getWebContext().GetParamValue("SELECTMODE"), (String)"MS", (boolean)true) == 0) {
            StringBuilderEx script = new StringBuilderEx();
            script.Append("try{parent._TOTALGRID=$P.grid['%1$s'];parent._TOTALSTORE=$P.store['%1$s'];}catch(e){}", (Object)this.dataGrid.getUniqueID());
            script.Append("try{$P.store['%1$s'].on('load',parent.totalstoreloaded);}catch(e){}", (Object)this.dataGrid.getUniqueID());
            this.RegisterOnReadyScript(3, script.toString());
        } else {
            DataGridNewEditJSGear.Load(this, this.dataGrid);
        }
    }

    @Override
    protected boolean IsLoadDataGridNewEditJSGear() {
        return false;
    }

    @Override
    protected boolean OnGetPickupMode() {
        if (StringHelper.Compare((String)this.getWebContext().GetParamValue("SELECTMODE"), (String)"S", (boolean)true) == 0) {
            return true;
        }
        return StringHelper.Compare((String)this.getWebContext().GetParamValue("SELECTMODE"), (String)"MS", (boolean)true) == 0;
    }

    @Override
    protected boolean OnGetSPAutoExpand() {
        boolean bSPAutoExpand = false;
        if (StringHelper.Compare((String)this.getWebContext().GetParamValue("SELECTMODE"), (String)"S", (boolean)true) == 0 || StringHelper.Compare((String)this.getWebContext().GetParamValue("SELECTMODE"), (String)"MS", (boolean)true) == 0) {
            bSPAutoExpand = true;
        }
        if (this.ppGridView != null && !this.ppGridView.IsParamNull("SPAUTOEXPAND")) {
            bSPAutoExpand = this.ppGridView.getSPAUTOEXPAND();
        }
        return this.getPageParam("PAGE.SP.AUTOEXPAND", bSPAutoExpand);
    }
}

