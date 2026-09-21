/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.pswx.core.IWXEntApp
 *  net.ibizsys.pswx.core.IWXMenuItem
 *  net.ibizsys.pswx.core.WXMenuRootItem
 */
package SA.SRFDA.PS.Core.WX;

import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.WX.IPSWXAccount;
import SA.SRFDA.PS.Core.WX.IPSWXEntApp;
import SA.SRFDA.PS.Core.WX.IPSWXMenu;
import SA.SRFDA.PS.Core.WX.IPSWXMenuItem;
import SA.SRFDA.PS.Core.WX.PSWXAccountObjectImpl;
import SA.SRFDA.PS.Core.WX.PSWXMenuItemImpl;
import SA.SRFDA.PS.Data.PSWXMenu;
import SA.SRFDA.PS.Data.PSWXMenuItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Vector;
import net.ibizsys.pswx.core.IWXEntApp;
import net.ibizsys.pswx.core.IWXMenuItem;
import net.ibizsys.pswx.core.WXMenuRootItem;

public class PSWXMenuImpl
extends PSWXAccountObjectImpl
implements IPSWXMenu {
    protected PSWXMenu psWXMenu;
    protected ArrayList<IPSWXMenuItem> psWXMenuItemList = new ArrayList();
    protected WXMenuRootItem appMenuRootItem = new WXMenuRootItem();
    protected boolean bDefaultMenu = false;
    private IPSWXEntApp iPSWXEntApp = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWXAccount iPSWXAccount, IPSWXEntApp iPSWXEntApp, PSWXMenu psWXMenu) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSWXAccount(iPSWXAccount);
        this.iPSWXEntApp = iPSWXEntApp;
        this.psWXMenu = psWXMenu;
        this.setPSObjectData(this.psWXMenu);
        this.setId(this.psWXMenu.getPSWXMENUID());
        this.setName(this.psWXMenu.getPSWXMENUNAME());
        this.iPSWXEntApp = iPSWXEntApp;
        if (!this.psWXMenu.isDEFAULTFLAGNull()) {
            this.bDefaultMenu = this.psWXMenu.getDEFAULTFLAG();
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        this.onPreparePSWXMenuItems();
    }

    protected void onPreparePSWXMenuItems() throws Exception {
        this.psWXMenuItemList.clear();
        Vector<PSWXMenuItem> psWXMenuItemList = new Vector<PSWXMenuItem>();
        CallResult callResult = this.getPSModelHelper().getPSWXMenuItems(this.getId(), psWXMenuItemList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5fae\u4fe1\u83dc\u5355\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        LinkedHashMap<String, PSWXMenuItem> psWXMenuItemMap = new LinkedHashMap<String, PSWXMenuItem>();
        for (PSWXMenuItem psWXMenuItem : psWXMenuItemList) {
            psWXMenuItemMap.put(psWXMenuItem.getPSWXMENUITEMID(), psWXMenuItem);
        }
        for (PSWXMenuItem psWXMenuItem : psWXMenuItemList) {
            PSWXMenuItem parentPSWXMenuItem;
            if (StringHelper.IsNullOrEmpty((String)psWXMenuItem.getPPSWXMENUITEMID()) || (parentPSWXMenuItem = (PSWXMenuItem)((Object)psWXMenuItemMap.get(psWXMenuItem.getPPSWXMENUITEMID()))) == null) continue;
            parentPSWXMenuItem.getChildPSWXMenuItems(true).add(psWXMenuItem);
        }
        for (PSWXMenuItem psWXMenuItem : psWXMenuItemList) {
            if (!StringHelper.IsNullOrEmpty((String)psWXMenuItem.getPPSWXMENUITEMID())) continue;
            PSWXMenuItemImpl iPSWXMenuItem = new PSWXMenuItemImpl();
            iPSWXMenuItem.init(this.getDAGlobalHelper(), this, null, psWXMenuItem);
            this.psWXMenuItemList.add(iPSWXMenuItem);
            this.appMenuRootItem.getItems().add(iPSWXMenuItem);
        }
    }

    @Override
    @PSModelRTMeta(description="\u83dc\u5355\u9879\u96c6\u5408", child=true)
    public Iterator<IPSWXMenuItem> getPSWXMenuItems() {
        return this.psWXMenuItemList.iterator();
    }

    public Iterator<IWXMenuItem> getWXMenuItems() {
        return this.appMenuRootItem.getItems().iterator();
    }

    @Override
    public String getModelType() {
        return "PSWXMENU";
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u83dc\u5355", ignoredumpvalues="false")
    public boolean isDefaultMenu() {
        return this.bDefaultMenu;
    }

    @Override
    public IPSWXEntApp getPSWXEntApp() {
        return this.iPSWXEntApp;
    }

    public IWXEntApp getWXEntApp() {
        return this.getPSWXEntApp();
    }

    @Override
    public WXMenuRootItem getRootItem() {
        return this.appMenuRootItem;
    }

    @Override
    protected String onGetDynaModelFolder() {
        return super.onGetDynaModelFolder();
    }
}

