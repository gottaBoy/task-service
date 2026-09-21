/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.service.ActionSession
 *  net.ibizsys.paas.service.ActionSessionManager
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Menu;

import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItemType;
import SA.SRFDA.PS.Core.Control.Menu.PSAppMenuItemImplBase;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Data.PSAppMenuItem;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSAppMenuItem", typevalues={"APPMENUREF"})
public class PSAppMenuAMRefImpl
extends PSAppMenuItemImplBase
implements IPSAppMenuItem {
    private static final Log log = LogFactory.getLog(PSAppMenuAMRefImpl.class);

    @Override
    protected void onPreparePSAppMenuItems() throws Exception {
        String strRefPSAppMenuId;
        if (this.psAppMenuItemList != null) {
            this.psAppMenuItemList.clear();
        }
        if (StringHelper.IsNullOrEmpty((String)(strRefPSAppMenuId = this.psAppMenuItem.getREFPSAPPMENUID()))) {
            return;
        }
        if (StringHelper.Compare((String)strRefPSAppMenuId, (String)this.psAppMenuItem.getPSAPPMENUID(), (boolean)true) == 0) {
            throw new Exception(StringHelper.Format((String)"\u5e94\u7528\u83dc\u5355[%1$s]\u4e0d\u80fd\u5f15\u7528\u81ea\u8eab", (Object)this.getPSAppMenuModel().getName()));
        }
        boolean bOpenActionSession = false;
        ActionSession recursionSession = ActionSessionManager.getCurrentSession();
        if (recursionSession == null) {
            bOpenActionSession = true;
            recursionSession = ActionSessionManager.openSession((String)this.getPSAppMenuModel().getName());
        }
        try {
            if (!recursionSession.registerRecursion(strRefPSAppMenuId, (Object)"")) {
                return;
            }
            Vector<PSAppMenuItem> psAppMenuItemList = new Vector<PSAppMenuItem>();
            CallResult callResult = this.getPSModelHelper().getPSAppMenuItems(strRefPSAppMenuId, psAppMenuItemList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u83dc\u5355\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
            }
            HashMap<String, PSAppMenuItem> psAppMenuItemMap = new HashMap<String, PSAppMenuItem>();
            for (PSAppMenuItem psAppMenuItem : psAppMenuItemList) {
                if (!psAppMenuItem.isENABLEMODENull() && !psAppMenuItem.getENABLEMODE()) continue;
                psAppMenuItemMap.put(psAppMenuItem.getPSAPPMENUITEMID(), psAppMenuItem);
            }
            int nTopMenuItemCount = 0;
            for (PSAppMenuItem psAppMenuItem : psAppMenuItemList) {
                if (!psAppMenuItem.isENABLEMODENull() && !psAppMenuItem.getENABLEMODE()) continue;
                if (!StringHelper.IsNullOrEmpty((String)psAppMenuItem.getPPSAPPMENUITEMID())) {
                    PSAppMenuItem parentPSAppMenuItem = (PSAppMenuItem)((Object)psAppMenuItemMap.get(psAppMenuItem.getPPSAPPMENUITEMID()));
                    if (parentPSAppMenuItem == null) {
                        this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u83dc\u5355\u7236\u9879[%1$s]\uff0c\u5ffd\u7565\u6b64\u6a21\u578b", (Object)psAppMenuItem.getPPSAPPMENUITEMID()), "PSAPPMENUITEM", "REMOVE", psAppMenuItem.getPSAPPMENUITEMID());
                        continue;
                    }
                    parentPSAppMenuItem.getChildPSAppMenuItems(true).add(psAppMenuItem);
                    continue;
                }
                ++nTopMenuItemCount;
            }
            for (PSAppMenuItem psAppMenuItem : psAppMenuItemList) {
                if (!psAppMenuItem.isENABLEMODENull() && !psAppMenuItem.getENABLEMODE() || !StringHelper.IsNullOrEmpty((String)psAppMenuItem.getPPSAPPMENUITEMID())) continue;
                if (nTopMenuItemCount > 1) {
                    IPSAppMenuItemType iPSAppMenuItemType = this.getPSModelStorage().getPSAppMenuItemType(psAppMenuItem.getAMITEMTYPE());
                    IPSAppMenuItem iPSAppMenuItem = iPSAppMenuItemType.createPSAppMenuItem(psAppMenuItem);
                    iPSAppMenuItem.init(this.getDAGlobalHelper(), this.getPSAppMenu(), this, psAppMenuItem);
                    this.psAppMenuItemList.add(iPSAppMenuItem);
                    continue;
                }
                ArrayList<PSAppMenuItem> psAppMenuItemList2 = psAppMenuItem.getChildPSAppMenuItems(false);
                if (psAppMenuItemList2 == null || psAppMenuItemList2.size() == 0) {
                    IPSAppMenuItemType iPSAppMenuItemType = this.getPSModelStorage().getPSAppMenuItemType(psAppMenuItem.getAMITEMTYPE());
                    IPSAppMenuItem iPSAppMenuItem = iPSAppMenuItemType.createPSAppMenuItem(psAppMenuItem);
                    iPSAppMenuItem.init(this.getDAGlobalHelper(), this.getPSAppMenu(), this, psAppMenuItem);
                    this.psAppMenuItemList.add(iPSAppMenuItem);
                    continue;
                }
                for (PSAppMenuItem psAppMenuItem2 : psAppMenuItemList2) {
                    if (!psAppMenuItem2.isENABLEMODENull() && !psAppMenuItem2.getENABLEMODE()) continue;
                    IPSAppMenuItemType iPSAppMenuItemType = this.getPSModelStorage().getPSAppMenuItemType(psAppMenuItem.getAMITEMTYPE());
                    IPSAppMenuItem iPSAppMenuItem = iPSAppMenuItemType.createPSAppMenuItem(psAppMenuItem);
                    iPSAppMenuItem.init(this.getDAGlobalHelper(), this.getPSAppMenu(), this, psAppMenuItem2);
                    this.psAppMenuItemList.add(iPSAppMenuItem);
                }
            }
            if (bOpenActionSession) {
                ActionSessionManager.closeSession();
            }
        }
        catch (Exception ex) {
            if (bOpenActionSession) {
                ActionSessionManager.closeSession();
            }
            throw ex;
        }
    }
}

