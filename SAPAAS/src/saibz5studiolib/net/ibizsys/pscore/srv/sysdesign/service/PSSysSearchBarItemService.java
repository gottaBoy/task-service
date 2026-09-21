/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSearchBarItem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarItemServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysSearchBarItemService
extends PSSysSearchBarItemServiceBase {
    private static final Log log = LogFactory.getLog(PSSysSearchBarItemService.class);

    @Override
    public void getDraft(PSSysSearchBarItem pSSysSearchBarItem) throws Exception {
        super.getDraft(pSSysSearchBarItem);
        if (StringHelper.isNullOrEmpty((String)pSSysSearchBarItem.getPSDEId()) && pSSysSearchBarItem.getPSSysSearchBar() != null) {
            pSSysSearchBarItem.setPSDEId(pSSysSearchBarItem.getPSSysSearchBar().getPSDEId());
        }
    }

    @Override
    public void getDraftTemp(PSSysSearchBarItem pSSysSearchBarItem) throws Exception {
        super.getDraftTemp(pSSysSearchBarItem);
        if (StringHelper.isNullOrEmpty((String)pSSysSearchBarItem.getPSDEId()) && pSSysSearchBarItem.getPSSysSearchBar() != null) {
            pSSysSearchBarItem.setPSDEId(pSSysSearchBarItem.getPSSysSearchBar().getPSDEId());
        }
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysSearchBarItem pSSysSearchBarItem, boolean bl) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        if (StringHelper.isNullOrEmpty((String)pSSysSearchBarItem.getPSSysSearchBarItemName())) {
            if (StringHelper.isNullOrEmpty((String)pSSysSearchBarItem.getItemType())) {
                hashMap.put("PSSYSSEARCHBARITEMNAME", "item");
            } else {
                hashMap.put("PSSYSSEARCHBARITEMNAME", pSSysSearchBarItem.getItemType().toLowerCase());
            }
        }
        return hashMap;
    }
}

