/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.Func.IPSAppFunc
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Control.Menu.IPSAppMenu
 *  SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 *  net.sf.json.JSON
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Pub.Base;

import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenu;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem;
import SA.SRFDA.PS.Core.Pub.Base.PSCtrlCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PSAppMenuVCPublisherImpl
extends PSCtrlCodePublisherImpl {
    protected IPSAppMenu iPSAppMenu = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSAppMenu = (IPSAppMenu)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        this.iPSAppMenu = (IPSAppMenu)this.iPSControl;
        ArrayList<IPSGenerateCodeResult> itemList = new ArrayList<IPSGenerateCodeResult>();
        Iterator psAppMenuItems = this.iPSAppMenu.getPSAppMenuItems();
        while (psAppMenuItems.hasNext()) {
            IPSAppMenuItem iPSAppMenuItem = (IPSAppMenuItem)psAppMenuItems.next();
            IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(iPSAppMenuItem.getItemType()).getPSPFCtrlPartCodePublisher();
            IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSAppMenu, (Object)iPSAppMenuItem);
            itemList.add(iPSGenerateCodeResult);
            iPSPFCtrlPartCodePublisher.close();
        }
        params.put("items", itemList);
        Iterator menus = this.iPSAppMenu.getPSAppMenuItems();
        JSONArray jsonArr = new JSONArray();
        while (menus.hasNext()) {
            JSONObject jsonObj = new JSONObject();
            IPSAppMenuItem menu = (IPSAppMenuItem)menus.next();
            jsonObj.put("text", (Object)menu.getCaption());
            IPSAppFunc appFunc = menu.getPSAppFunc();
            if (appFunc != null && appFunc.getPSAppView() != null) {
                jsonObj.put("viewurl", (Object)(String.valueOf(appFunc.getPSAppView().getPSAppModule().getCodeName().toLowerCase()) + "_" + appFunc.getPSAppView().getCodeName().toLowerCase()));
                jsonObj.put("viewParams", (Object)appFunc.getOpenViewParam().toString());
            }
            jsonObj.put("name", (Object)menu.getName());
            if (menu.getPSAppMenuItems() != null) {
                jsonObj.put("items", (Object)this.getChildMenus(menu));
            }
            jsonArr.put((JSON)jsonObj);
        }
        params.put("menus", jsonArr.toString());
    }

    private JSONArray getChildMenus(IPSAppMenuItem menuItem) throws Exception {
        JSONArray jsonArr = new JSONArray();
        Iterator menus = menuItem.getPSAppMenuItems();
        while (menus.hasNext()) {
            JSONObject jsonObj = new JSONObject();
            IPSAppMenuItem menu = (IPSAppMenuItem)menus.next();
            jsonObj.put("text", (Object)menu.getCaption());
            IPSAppFunc appFunc = menu.getPSAppFunc();
            if (appFunc != null && appFunc.getPSAppView() != null) {
                jsonObj.put("viewurl", (Object)menu.getCaption());
            }
            jsonObj.put("name", (Object)menu.getName());
            if (menu.getPSAppMenuItems() != null) {
                jsonObj.put("items", (Object)this.getChildMenus(menu));
            }
            jsonArr.put((JSON)jsonObj);
        }
        return jsonArr;
    }

    protected void onClose() {
        this.iPSAppMenu = null;
        super.onClose();
    }
}

