/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.pswx.core.IWXMenuItem
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.WX;

import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.WX.IPSWXMenu;
import SA.SRFDA.PS.Core.WX.IPSWXMenuFunc;
import SA.SRFDA.PS.Core.WX.IPSWXMenuItem;
import SA.SRFDA.PS.Data.PSWXMenuItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.pswx.core.IWXMenuItem;
import net.sf.json.JSONObject;

public class PSWXMenuItemImpl
extends PSObjectImpl
implements IPSWXMenuItem {
    private IPSWXMenu iPSWXMenu = null;
    private IPSWXMenuItem parentPSWXMenuItem = null;
    private PSWXMenuItem psWXMenuItem = null;
    protected IPSWXMenuFunc iPSWXMenuFunc = null;
    protected ArrayList<IPSWXMenuItem> psWXMenuItemList = null;
    protected ArrayList<IWXMenuItem> appMenuItemList = null;
    private String strText = "";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWXMenu iPSWXMenu, IPSWXMenuItem parentPSWXMenuItem, PSWXMenuItem psWXMenuItem) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSWXMenu(iPSWXMenu);
        this.setParentPSWXMenuItem(parentPSWXMenuItem);
        this.setPSWXMenuItemData(psWXMenuItem);
        this.setId(this.psWXMenuItem.getPSWXMENUITEMID());
        this.setName(this.psWXMenuItem.getPSWXMENUITEMNAME());
        String strText = psWXMenuItem.getCAPTION();
        if (StringHelper.IsNullOrEmpty((String)strText)) {
            strText = this.psWXMenuItem.getPSWXMENUFUNCNAME();
        }
        this.setText(strText);
        if (!StringHelper.IsNullOrEmpty((String)this.psWXMenuItem.getPSWXMENUFUNCID())) {
            this.iPSWXMenuFunc = this.getPSWXMenu().getPSWXEntApp() != null ? this.getPSWXMenu().getPSWXEntApp().getPSWXMenuFunc(this.psWXMenuItem.getPSWXMENUFUNCID()) : this.getPSWXMenu().getPSWXAccount().getPSWXMenuFunc(this.psWXMenuItem.getPSWXMENUFUNCID());
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSWXMenuItems();
        if (this.psWXMenuItemList != null) {
            this.appMenuItemList = new ArrayList();
            this.appMenuItemList.addAll(this.psWXMenuItemList);
        }
    }

    protected void onPreparePSWXMenuItems() throws Exception {
        ArrayList<PSWXMenuItem> psWXMenuItemList;
        if (this.psWXMenuItemList != null) {
            this.psWXMenuItemList.clear();
        }
        if ((psWXMenuItemList = this.psWXMenuItem.getChildPSWXMenuItems(false)) == null) {
            return;
        }
        if (this.psWXMenuItemList == null) {
            this.psWXMenuItemList = new ArrayList();
        }
        for (PSWXMenuItem psWXMenuItem : psWXMenuItemList) {
            PSWXMenuItemImpl iPSWXMenuItem = new PSWXMenuItemImpl();
            iPSWXMenuItem.init(this.getDAGlobalHelper(), this.getPSWXMenu(), this, psWXMenuItem);
            this.psWXMenuItemList.add(iPSWXMenuItem);
        }
    }

    @Override
    public IPSWXMenuItem getParentPSWXMenuItem() {
        return this.parentPSWXMenuItem;
    }

    protected void setParentPSWXMenuItem(IPSWXMenuItem parentPSWXMenuItem) {
        this.parentPSWXMenuItem = parentPSWXMenuItem;
    }

    public PSWXMenuItem getPSWXMenuItemData() {
        return this.psWXMenuItem;
    }

    protected void setPSWXMenuItemData(PSWXMenuItem psWXMenuItem) {
        this.psWXMenuItem = psWXMenuItem;
    }

    @Override
    public IPSWXMenuFunc getPSWXMenuFunc() {
        return this.iPSWXMenuFunc;
    }

    @Override
    @PSModelRTMeta(description="\u83dc\u5355\u9879\u96c6\u5408", child=true)
    public Iterator<IPSWXMenuItem> getPSWXMenuItems() {
        if (this.psWXMenuItemList == null) {
            return null;
        }
        return this.psWXMenuItemList.iterator();
    }

    public ArrayList<IWXMenuItem> getItems() {
        return this.appMenuItemList;
    }

    @Override
    public String getWXMenuFuncId() {
        return this.psWXMenuItem.getPSWXMENUFUNCID();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSWXMenu().getPSSysModelInstId();
    }

    @Override
    public IPSWXMenu getPSWXMenu() {
        return this.iPSWXMenu;
    }

    protected void setPSWXMenu(IPSWXMenu iPSWXMenu) {
        this.iPSWXMenu = iPSWXMenu;
        if (this.iPSWXMenu == null) {
            this.iPSWXMenu = null;
        } else if (this.iPSWXMenu instanceof IPSWXMenu) {
            this.iPSWXMenu = this.iPSWXMenu;
        }
    }

    public String getPId() {
        if (this.getParentPSWXMenuItem() != null) {
            return this.getParentPSWXMenuItem().getId();
        }
        return null;
    }

    @PSModelRTMeta(description="\u663e\u793a\u6587\u672c")
    public String getText() {
        return this.strText;
    }

    @PSModelRTMeta(description="\u529f\u80fd\u7c7b\u578b")
    public String getWXFunc() {
        if (this.getPSWXMenuFunc() != null) {
            return this.getPSWXMenuFunc().getWXMenuFuncType();
        }
        return null;
    }

    @PSModelRTMeta(description="\u70b9\u51fb\u6807\u8bb0")
    public String getClickTag() {
        if (this.getPSWXMenuFunc() != null) {
            return this.getPSWXMenuFunc().getClickTag();
        }
        return null;
    }

    protected void setText(String strText) {
        this.strText = strText;
    }

    public JSONObject toJSON() {
        return null;
    }
}

