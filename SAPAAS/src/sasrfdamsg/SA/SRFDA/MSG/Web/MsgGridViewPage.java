/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.GridViewPage
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Script.DataGridJSHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.MSG.Web;

import SA.SRFDA.MSG.Common.MsgFolders;
import SA.SRFDA.MSG.Ctrl.DataGrid.MsgDataGridActionHelper;
import SA.SRFDA.MSG.Web.JSGear.MsgDataGridNewEditJSGear;
import SA.SRFDA.MSG.Web.JSGear.MsgDataGridNewEditPageHelper;
import SA.SRFDA.Web.Default.GridViewPage;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;
import net.sf.json.JSONObject;

public class MsgGridViewPage
extends GridViewPage {
    private String strMsgFolder = "";

    public MsgGridViewPage() {
        this.setResourceId("");
    }

    protected boolean PreparePageEnv() {
        this.getWebContext().SetParamValue("SRFDEID", "DE0071");
        this.strMsgFolder = this.getWebContext().GetParamValue("SRFMSGFOLDER");
        if (StringHelper.IsNullOrEmpty((String)this.strMsgFolder)) {
            this.strMsgFolder = "INBOX";
        }
        String strGridViewId = "DATAGRID_DE0071_001";
        if (StringHelper.Compare((String)this.strMsgFolder, (String)"INBOX", (boolean)true) == 0) {
            strGridViewId = "DATAGRID_DE0071_002";
        }
        this.strMsgFolder = this.strMsgFolder.toUpperCase();
        this.getWebContext().SetParamValue("SRFGRIDVIEW", strGridViewId);
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.setPageParam("MSGFOLDER", this.strMsgFolder);
        return true;
    }

    protected void OnInit() {
        super.OnInit();
        this.LoadMsgDataGridNewEditGear();
        StringBuilderEx script = new StringBuilderEx();
        script.Append("var _URL='%1$s';\r\n", (Object)this.OnGetMsgInfoViewPath());
        script.Append("_URL += Ext.urlEncode(%1$s);\r\n", (Object)DataGridJSHelper.getSelectedRecordKeys((String)this.dataGrid.getUniqueID()));
        script.Append("Ext.getDom('if_summary').src = _URL;\r\n");
        String strScript = script.toString();
        script.Reset();
        script.Append(DataGridJSHelper.getOnRowSelectedEventScript((String)this.dataGrid.getUniqueID(), (String)strScript));
        script.Append(DataGridJSHelper.getOnRowSelectedCancelEventScript((String)this.dataGrid.getUniqueID(), (String)strScript));
        this.RegisterOnReadyScript(3, script.toString());
    }

    protected void LoadMsgDataGridNewEditGear() {
        boolean bDGNew = true;
        boolean bDGEdit = true;
        boolean bDGDBClkEdit = true;
        if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            if (StringHelper.Compare((String)this.strMsgFolder, (String)"DRAFT", (boolean)true) == 0) {
                MsgDataGridNewEditJSGear.Load((SRFDAPage)this, this.dataGrid);
            } else {
                MsgDataGridNewEditJSGear.Load((SRFDAPage)this, this.dataGrid);
            }
        } else {
            if (bDGNew) {
                this.newPageInfo = new JSONObject();
            }
            if (bDGEdit) {
                this.editPageInfo = new JSONObject();
                this.editPageInfo.put("dbclkedit", bDGDBClkEdit);
            }
            MsgDataGridNewEditPageHelper.Calc((SRFDAPage)this, this.dataGrid, this.newPageInfo, this.editPageInfo, this.bInfoMode);
        }
    }

    protected String OnGetMsgInfoViewPath() {
        return this.getWebContext().getWebExConfig().GetValue("SRFMSG", "INFOVIEWPATH", "../srfmessage/msginfoview.jsp?");
    }

    protected boolean IsLoadDataGridNewEditJSGear() {
        return false;
    }

    protected String GetDataGridActionHelper() {
        return MsgDataGridActionHelper.class.getName();
    }

    protected boolean OnGetGVTheme() {
        return false;
    }

    protected int OnGetCaptionWidth() {
        return 80;
    }

    protected String OnGetGridViewToolbarConfigId() {
        String strExt = "";
        if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
            strExt = "_PM_" + this.getPageModel();
        }
        if (StringHelper.Compare((String)this.strMsgFolder, (String)"DRAFT", (boolean)true) == 0) {
            return "SRFMSG.TB_DRAFT" + strExt;
        }
        if (StringHelper.Compare((String)this.strMsgFolder, (String)"REMOVE", (boolean)true) == 0) {
            return "SRFMSG.TB_REMOVE" + strExt;
        }
        return "SRFMSG.TB_DEFAULT" + strExt;
    }

    protected String OnGetPageCaption() {
        return MsgFolders.GetFolderTitle(this.strMsgFolder);
    }

    protected String OnGetPageIcon(boolean bSmall) {
        return MsgFolders.GetFolderIcon(this.strMsgFolder);
    }

    public boolean IsRenderCustomSummaryArea() {
        return false;
    }

    public boolean IsBottomSummary() {
        return false;
    }

    public boolean IsRightSummary() {
        return true;
    }

    public boolean IsRenderSummaryPageList() {
        return false;
    }

    public boolean IsRenderCaption() {
        return true;
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        this.gridViewModel.setSummaryPage(this.OnGetMsgInfoViewPath());
        return true;
    }
}

