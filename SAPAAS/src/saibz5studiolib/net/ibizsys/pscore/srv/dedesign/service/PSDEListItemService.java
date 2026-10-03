/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEList;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListItem;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.util.PSModelFolderKeyHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEListItemService
extends PSDEListItemServiceBase {
    private static final Log log = LogFactory.getLog(PSDEListItemService.class);

    @Override
    protected String getEntityFolderKeyValue(PSDEListItem pSDEListItem, PSSystem pSSystem) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSDEListItem.getPSDEDataViewId())) {
            return PSModelFolderKeyHelper.getModelKey(pSDEListItem, pSSystem, "PSDEDATAVIEWITEM", "D", this.getSessionFactory());
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEListItem.getPSDEListId())) {
            return PSModelFolderKeyHelper.getModelKey(pSDEListItem, pSSystem, "PSDELISTITEM", "L", this.getSessionFactory());
        }
        return super.getEntityFolderKeyValue(pSDEListItem, pSSystem);
    }

    @Override
    protected void onBeforeCreateTemp(PSDEListItem pSDEListItem) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDEListItem.getPSDEListItemName())) {
            this.fillPSDEListItemDefaultName(pSDEListItem);
        }
        super.onBeforeCreateTemp(pSDEListItem);
    }

    protected void fillPSDEListItemDefaultName(PSDEListItem pSDEListItem) throws Exception {
        Serializable serializable;
        int n = 1;
        String string = null;
        if (!StringHelper.isNullOrEmpty((String)pSDEListItem.getPSDEListId())) {
            string = "listitem";
        } else if (!StringHelper.isNullOrEmpty((String)pSDEListItem.getPSDEDataViewId())) {
            string = "dataviewitem";
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        string = string.toLowerCase();
        ArrayList<PSDEListItem> arrayList = null;
        if (!StringHelper.isNullOrEmpty((String)pSDEListItem.getPSDEListId())) {
            serializable = new PSDEList();
            ((PSDEListBase)serializable).setPSDEListId(pSDEListItem.getPSDEListId());
            arrayList = ((PSDEListBase)serializable).getPSDEListId().indexOf("SRFTEMPKEY:") == 0 ? this.selectTempByPSDEList((PSDEListBase)serializable) : this.selectByPSDEList((PSDEListBase)serializable);
        } else if (!StringHelper.isNullOrEmpty((String)pSDEListItem.getPSDEDataViewId())) {
            serializable = new PSDEDataView();
            ((PSDEDataViewBase)serializable).setPSDEDataViewId(pSDEListItem.getPSDEDataViewId());
            arrayList = ((PSDEDataViewBase)serializable).getPSDEDataViewId().indexOf("SRFTEMPKEY:") == 0 ? this.selectTempByPSDEDataView((PSDEDataViewBase)serializable) : this.selectByPSDEDataView((PSDEDataViewBase)serializable);
        }
        HashMap<String, PSDEListItem> existingNames = new HashMap<String, PSDEListItem>();
        for (PSDEListItem pSDEListItem2 : arrayList) {
            if (StringHelper.isNullOrEmpty((String)pSDEListItem2.getPSDEListItemName())) continue;
            existingNames.put(pSDEListItem2.getPSDEListItemName().toLowerCase(), pSDEListItem2);
        }
        String listItemName;
        while (true) {
            listItemName = StringHelper.format((String)"%1$s%2$s", (Object)string, (Object)(n == 0 ? "" : Integer.valueOf(n)));
            if (!existingNames.containsKey(listItemName)) break;
            ++n;
        }
        pSDEListItem.setPSDEListItemName(listItemName);
    }

    @Override
    public boolean fillModelV2Key(PSDEListItem pSDEListItem, ObjectNode objectNode, String string, String string2, boolean bl) throws Exception {
        boolean bl2 = super.fillModelV2Key(pSDEListItem, objectNode, string, string2, bl);
        if (bl2) {
            return true;
        }
        if (bl) {
            String string3 = pSDEListItem.getPSDEListId();
            if (!StringHelper.isNullOrEmpty((String)string3)) {
                pSDEListItem.setPSDEListItemId(KeyValueHelper.genUniqueId((String)"PSDELIST", (String)string3, (String)pSDEListItem.getPSDEListItemName()));
                return true;
            }
            String string4 = pSDEListItem.getPSDEDataViewId();
            if (!StringHelper.isNullOrEmpty((String)string4)) {
                pSDEListItem.setPSDEListItemId(KeyValueHelper.genUniqueId((String)"PSDEDATAVIEW", (String)string4, (String)pSDEListItem.getPSDEListItemName()));
                return true;
            }
        }
        return bl2;
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEListItem pSDEListItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return !StringHelper.isNullOrEmpty((String)pSDEListItem.getPSDEListId());
        }
        return super.testCompileCurModelV2(pSDEListItem, objectNode, string, string2, n);
    }
}
