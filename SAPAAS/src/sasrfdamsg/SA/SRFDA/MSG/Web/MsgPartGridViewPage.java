/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.GridViewPage
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.MSG.Web;

import SA.SRFDA.MSG.Common.MsgFolders;
import SA.SRFDA.MSG.Ctrl.DataGrid.MsgDataGridActionHelper;
import SA.SRFDA.MSG.Web.JSGear.MsgDataGridNewEditJSGear;
import SA.SRFDA.Web.Default.GridViewPage;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;

public class MsgPartGridViewPage
extends GridViewPage {
    private String strMsgFolder = "";

    protected boolean PreparePageEnv() {
        this.getWebContext().SetParamValue("PAGE.DATAGRID.CHECKMODE", "false");
        this.getWebContext().SetParamValue("SRFDEID", "DE0071");
        this.strMsgFolder = this.getWebContext().GetParamValue("SRFMSGFOLDER");
        if (StringHelper.IsNullOrEmpty((String)this.strMsgFolder)) {
            this.strMsgFolder = "INBOX";
        }
        String strGridViewId = "DATAGRID_DE0071_003";
        if (StringHelper.Compare((String)this.strMsgFolder, (String)"INBOX", (boolean)true) == 0) {
            strGridViewId = "DATAGRID_DE0071_003";
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
        if (StringHelper.Compare((String)this.strMsgFolder, (String)"DRAFT", (boolean)true) == 0) {
            MsgDataGridNewEditJSGear.Load((SRFDAPage)this, this.dataGrid);
        } else {
            MsgDataGridNewEditJSGear.Load((SRFDAPage)this, this.dataGrid);
        }
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
        return "SRFMSG.TB_DEFAULT";
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
}

