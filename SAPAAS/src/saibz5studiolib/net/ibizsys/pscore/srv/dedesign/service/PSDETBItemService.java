/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETBItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDETBItemService
extends PSDETBItemServiceBase {
    private static final Log log = LogFactory.getLog(PSDETBItemService.class);

    @Override
    protected void onBeforeGetDraftTemp(PSDETBItem pSDETBItem) throws Exception {
        super.onBeforeGetDraftTemp(pSDETBItem);
        String string = pSDETBItem.getPSDETBItemName();
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.fillPSDETBItemDefaultName(pSDETBItem);
        }
    }

    protected void fillPSDETBItemDefaultName(PSDETBItem pSDETBItem) throws Exception {
        int n = 1;
        String string = pSDETBItem.getTBItemType();
        String string2 = string;
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return;
        }
        string2 = string2.toLowerCase();
        PSDEToolbar pSDEToolbar = new PSDEToolbar();
        pSDEToolbar.setPSDEToolbarId(pSDETBItem.getPSDEToolbarId());
        ArrayList<PSDETBItem> arrayList = null;
        arrayList = pSDEToolbar.getPSDEToolbarId().indexOf("SRFTEMPKEY:") == 0 ? this.selectTempByPSDEToolbar(pSDEToolbar) : this.selectByPSDEToolbar(pSDEToolbar);
        HashMap<String, PSDETBItem> hashMap = new HashMap<String, PSDETBItem>();
        Object object = arrayList.iterator();
        while (object.hasNext()) {
            PSDETBItem pSDETBItem2 = object.next();
            hashMap.put(pSDETBItem2.getPSDETBItemName().toLowerCase(), pSDETBItem2);
        }
        while (true) {
            if (!hashMap.containsKey(object = StringHelper.format((String)"%1$s%2$s", (Object)string2, (Object)(n == 0 ? "" : Integer.valueOf(n))))) break;
            ++n;
        }
        pSDETBItem.setPSDETBItemName((String)object);
    }

    @Override
    protected void onBeforeCreateTemp(PSDETBItem pSDETBItem) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDETBItem.getPSDETBItemName())) {
            this.fillPSDETBItemDefaultName(pSDETBItem);
        }
        super.onBeforeCreateTemp(pSDETBItem);
    }

    public void getTemp(PSDETBItem pSDETBItem) throws Exception {
        super.getTemp((IEntity)pSDETBItem);
        if (StringHelper.compare((String)pSDETBItem.getTBItemType(), (String)"RAWITEM", (boolean)false) == 0 && StringHelper.isNullOrEmpty((String)pSDETBItem.getContentType())) {
            pSDETBItem.setContentType("RAW");
        }
    }

    public void get(PSDETBItem pSDETBItem) throws Exception {
        super.get((IEntity)pSDETBItem);
        if (StringHelper.compare((String)pSDETBItem.getTBItemType(), (String)"RAWITEM", (boolean)false) == 0 && StringHelper.isNullOrEmpty((String)pSDETBItem.getContentType())) {
            pSDETBItem.setContentType("RAW");
        }
    }

    @Override
    public String getModelV2Tag(PSDETBItem pSDETBItem) {
        Matcher matcher;
        if (!StringHelper.isNullOrEmpty((String)pSDETBItem.getPSDETBItemName()) && (matcher = codeNamePattern.matcher(pSDETBItem.getPSDETBItemName())).matches()) {
            return pSDETBItem.getPSDETBItemName();
        }
        return super.getModelV2Tag(pSDETBItem);
    }
}

