/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.appdesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuItem;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemServiceBase;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class PSAppMenuItemService
extends PSAppMenuItemServiceBase {
    @Override
    protected void onBeforeGetDraftTemp(PSAppMenuItem pSAppMenuItem) throws Exception {
        super.onBeforeGetDraftTemp(pSAppMenuItem);
        String string = pSAppMenuItem.getPSAppMenuItemName();
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.fillPSAppMenuItemDefaultName(pSAppMenuItem);
        }
    }

    protected void fillPSAppMenuItemDefaultName(PSAppMenuItem pSAppMenuItem) throws Exception {
        int n = 1;
        String string = pSAppMenuItem.getAMItemType();
        String string2 = string;
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return;
        }
        string2 = string2.toLowerCase();
        PSAppMenu pSAppMenu = new PSAppMenu();
        pSAppMenu.setPSAppMenuId(pSAppMenuItem.getPSAppMenuId());
        ArrayList<PSAppMenuItem> arrayList = null;
        arrayList = pSAppMenu.getPSAppMenuId().indexOf("SRFTEMPKEY:") == 0 ? this.selectTempByPSAppMenu(pSAppMenu) : this.selectByPSAppMenu(pSAppMenu);
        HashMap<String, PSAppMenuItem> hashMap = new HashMap<String, PSAppMenuItem>();
        Object object = arrayList.iterator();
        while (object.hasNext()) {
            PSAppMenuItem pSAppMenuItem2 = object.next();
            hashMap.put(pSAppMenuItem2.getPSAppMenuItemName().toLowerCase(), pSAppMenuItem2);
        }
        while (true) {
            if (!hashMap.containsKey(object = StringHelper.format((String)"%1$s%2$s", (Object)string2, (Object)(n == 0 ? "" : Integer.valueOf(n))))) break;
            ++n;
        }
        pSAppMenuItem.setPSAppMenuItemName((String)object);
        if (StringHelper.isNullOrEmpty((String)pSAppMenuItem.getCaption()) && StringHelper.compare((String)pSAppMenuItem.getAMItemType(), (String)"MENUITEM", (boolean)false) == 0) {
            pSAppMenuItem.setCaption("\u83dc\u5355\u9879");
        }
    }

    @Override
    protected void onChangeAppFunc(PSAppMenuItem pSAppMenuItem) throws Exception {
        String string = this.getWebContext().getPostValue("srfactionparam");
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        JSONObject jSONObject = JSONObject.fromString((String)string);
        String string2 = jSONObject.optString("psappfuncid");
        String string3 = jSONObject.optString("psappfuncname");
        pSAppMenuItem.setPSAppFuncId(null);
        pSAppMenuItem.setPSAppFuncName(null);
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            pSAppMenuItem.setPSAppFuncId(string2);
            pSAppMenuItem.setPSAppFuncName(string3);
            if (StringHelper.isNullOrEmpty((String)pSAppMenuItem.getPSAppFuncName())) {
                pSAppMenuItem.setSessionFactory(this.getSessionFactory());
                pSAppMenuItem.setPSAppFuncName(pSAppMenuItem.getPSAppFunc().getPSAppFuncName());
            }
        }
    }

    @Override
    protected void onBeforeCreateTemp(PSAppMenuItem pSAppMenuItem) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSAppMenuItem.getPSAppMenuItemName())) {
            this.fillPSAppMenuItemDefaultName(pSAppMenuItem);
        }
        super.onBeforeCreateTemp(pSAppMenuItem);
    }

    @Override
    protected void onCalcPSDEId(PSAppMenuItem pSAppMenuItem) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSAppMenuItem.getPSAppLocalDEId())) {
            pSAppMenuItem.setPSDEId(null);
        } else {
            pSAppMenuItem.setSessionFactory(this.getSessionFactory());
            PSAppLocalDE pSAppLocalDE = pSAppMenuItem.getPSAppLocalDE();
            pSAppMenuItem.setPSDEId(pSAppLocalDE.getPSDEId());
        }
    }
}

