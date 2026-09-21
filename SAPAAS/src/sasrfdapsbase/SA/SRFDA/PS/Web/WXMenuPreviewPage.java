/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Web;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.WX.IPSWXAccount;
import SA.SRFDA.PS.Core.WX.IPSWXEntApp;
import SA.SRFDA.PS.Core.WX.IPSWXMenuItem;
import SA.SRFDA.PS.Core.WX.PSWXMenuImpl;
import SA.SRFDA.PS.Data.PSWXMenu;
import SA.SRFDA.PS.Web.DECtrlPreviewPage;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;

public class WXMenuPreviewPage
extends DECtrlPreviewPage {
    public WXMenuPreviewPage() {
        this.setJSCache(false);
    }

    @Override
    protected boolean PreparePageEnv() {
        boolean bRet = super.PreparePageEnv();
        if (!bRet) {
            return false;
        }
        try {
            String strPSDevSlnSysId = this.getWebContext().GetParamValue("PSDEVSLNSYSID");
            String strPSSystemId = this.getWebContext().GetParamValue("PSSYSTEMID");
            IPSSystem iPSSystem = this.getPSSystem(strPSDevSlnSysId, strPSSystemId);
            String strPSWXMenuId = this.getWebContext().GetParamValue("PSWXMENUID");
            PSWXMenu psWXMenu = new PSWXMenu();
            CallResult callResult = this.getPSModelHelper(iPSSystem.getPSSysModelInstId()).getPSWXMenu(strPSWXMenuId, psWXMenu);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5fae\u4fe1\u83dc\u5355"));
            }
            IPSWXAccount iPSWXAccount = iPSSystem.getPSWXAccount(psWXMenu.getPSWXACCOUNTID());
            IPSWXEntApp iPSWXEntApp = null;
            if (!StringHelper.IsNullOrEmpty((String)psWXMenu.getPSWXENTAPPID())) {
                iPSWXEntApp = iPSWXAccount.getPSWXEntApp(psWXMenu.getPSWXENTAPPID());
            }
            PSWXMenuImpl iPSWXMenu = new PSWXMenuImpl();
            iPSWXMenu.init(this.getDAGlobalHelper(), iPSWXAccount, iPSWXEntApp, psWXMenu);
            this.sb.Append("{xtype:'toolbar',items: [");
            Iterator<IPSWXMenuItem> psWXMenuItems = iPSWXMenu.getPSWXMenuItems();
            if (psWXMenuItems != null) {
                boolean bFirst = true;
                while (psWXMenuItems.hasNext()) {
                    IPSWXMenuItem iPSWXMenuItem = psWXMenuItems.next();
                    if (bFirst) {
                        bFirst = false;
                    } else {
                        this.sb.Append(",");
                    }
                    this.sb.Append("{text:'%1$s'", (Object)iPSWXMenuItem.getText().replace("'", "\\'"));
                    if (iPSWXMenuItem.getPSWXMenuItems() != null) {
                        this.sb.Append(",menu:[");
                        boolean bFirst2 = true;
                        Iterator<IPSWXMenuItem> psWXMenuItems2 = iPSWXMenuItem.getPSWXMenuItems();
                        while (psWXMenuItems2.hasNext()) {
                            IPSWXMenuItem iPSWXMenuItem2 = psWXMenuItems2.next();
                            if (bFirst2) {
                                bFirst2 = false;
                            } else {
                                this.sb.Append(",");
                            }
                            this.sb.Append("{text:'%1$s'}", (Object)iPSWXMenuItem2.getText().replace("'", "\\'"));
                        }
                        this.sb.Append("]");
                    }
                    this.sb.Append("}");
                }
            }
            this.sb.Append("]}");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            this.PageLog((Object)this, 1, ex.getMessage());
            this.OutputAlertMsg(ex.getMessage(), false);
            return false;
        }
        return true;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
    }
}

