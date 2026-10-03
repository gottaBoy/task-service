/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.wxdesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenu;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuItem;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuItemServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSWXMenuItemService
extends PSWXMenuItemServiceBase {
    private static final Log log = LogFactory.getLog(PSWXMenuItemService.class);

    @Override
    protected void onBeforeGetDraftTemp(PSWXMenuItem pSWXMenuItem) throws Exception {
        super.onBeforeGetDraftTemp(pSWXMenuItem);
        String string = pSWXMenuItem.getPSWXMenuItemName();
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.fillPSWXMenuItemDefaultName(pSWXMenuItem);
        }
    }

    protected void fillPSWXMenuItemDefaultName(PSWXMenuItem pSWXMenuItem) throws Exception {
        int n = 1;
        String string = "wxmenuitem";
        string = string.toLowerCase();
        PSWXMenu pSWXMenu = new PSWXMenu();
        pSWXMenu.setPSWXMenuId(pSWXMenuItem.getPSWXMenuId());
        ArrayList<PSWXMenuItem> arrayList = null;
        arrayList = pSWXMenu.getPSWXMenuId().indexOf("SRFTEMPKEY:") == 0 ? this.selectTempByPSWXMenu(pSWXMenu) : this.selectByPSWXMenu(pSWXMenu);
        HashMap<String, PSWXMenuItem> hashMap = new HashMap<String, PSWXMenuItem>();
        String object;
        Iterator<PSWXMenuItem> objectIterator = arrayList.iterator();
        while (objectIterator.hasNext()) {
            PSWXMenuItem pSWXMenuItem2 = objectIterator.next();
            hashMap.put(pSWXMenuItem2.getPSWXMenuItemName().toLowerCase(), pSWXMenuItem2);
        }
        while (true) {
            if (!hashMap.containsKey(object = StringHelper.format((String)"%1$s%2$s", (Object)string, (Object)(n == 0 ? "" : Integer.valueOf(n))))) break;
            ++n;
        }
        pSWXMenuItem.setPSWXMenuItemName((String)object);
    }
}

