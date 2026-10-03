/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataRelation;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEDRDetailService
extends PSDEDRDetailServiceBase {
    private static final Log log = LogFactory.getLog(PSDEDRDetailService.class);

    @Override
    public void getDraftTempFrom(PSDEDRDetail pSDEDRDetail) throws Exception {
        super.getDraftTempFrom(pSDEDRDetail);
        pSDEDRDetail.setPSDEDRDetailName(null);
        this.fillPSDEDRDetailDefaultName(pSDEDRDetail);
    }

    @Override
    protected void onBeforeGetDraft(PSDEDRDetail pSDEDRDetail) throws Exception {
        super.onBeforeGetDraft(pSDEDRDetail);
        String string = pSDEDRDetail.getPSDEDRDetailName();
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.fillPSDEDRDetailDefaultName(pSDEDRDetail);
        }
    }

    @Override
    protected void onBeforeGetDraftTemp(PSDEDRDetail pSDEDRDetail) throws Exception {
        super.onBeforeGetDraftTemp(pSDEDRDetail);
        String string = pSDEDRDetail.getPSDEDRDetailName();
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.fillPSDEDRDetailDefaultName(pSDEDRDetail);
        }
    }

    protected void fillPSDEDRDetailDefaultName(PSDEDRDetail pSDEDRDetail) throws Exception {
        int n = 1;
        String string = "dritem";
        PSDEDataRelation pSDEDataRelation = new PSDEDataRelation();
        pSDEDataRelation.setPSDEDataRelationId(pSDEDRDetail.getPSDEDRId());
        ArrayList<PSDEDRDetail> arrayList = null;
        arrayList = pSDEDataRelation.getPSDEDataRelationId().indexOf("SRFTEMPKEY:") == 0 ? this.selectTempByPSDEDR(pSDEDataRelation) : this.selectByPSDEDR(pSDEDataRelation);
        HashMap<String, PSDEDRDetail> hashMap = new HashMap<String, PSDEDRDetail>();
        for (PSDEDRDetail pSDEDRDetail2 : arrayList) {
            if (StringHelper.isNullOrEmpty((String)pSDEDRDetail2.getPSDEDRDetailName())) continue;
            hashMap.put(pSDEDRDetail2.getPSDEDRDetailName().toLowerCase(), pSDEDRDetail2);
        }
        String name;
        while (true) {
            name = StringHelper.format((String)"%1$s%2$s", (Object)string, (Object)(n == 0 ? "" : Integer.valueOf(n)));
            if (!hashMap.containsKey(name)) break;
            ++n;
        }
        pSDEDRDetail.setPSDEDRDetailName(name);
    }

    @Override
    protected void onBeforeCreateTemp(PSDEDRDetail pSDEDRDetail) throws Exception {
        String string = pSDEDRDetail.getPSDEDRDetailName();
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.fillPSDEDRDetailDefaultName(pSDEDRDetail);
        }
        super.onBeforeCreateTemp(pSDEDRDetail);
    }

    @Override
    protected void onBeforeUpdateTemp(PSDEDRDetail pSDEDRDetail) throws Exception {
        String string = pSDEDRDetail.getPSDEDRDetailName();
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.fillPSDEDRDetailDefaultName(pSDEDRDetail);
        }
        super.onBeforeUpdateTemp(pSDEDRDetail);
    }

    @Override
    protected void onAfterCreate(PSDEDRDetail pSDEDRDetail) throws Exception {
        super.onAfterCreate(pSDEDRDetail);
    }

    @Override
    protected void onAfterRemove(PSDEDRDetail pSDEDRDetail) throws Exception {
        super.onAfterRemove(pSDEDRDetail);
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        return true;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    @Override
    protected void onChangeDRItem(PSDEDRDetail pSDEDRDetail) throws Exception {
        String string = this.getWebContext().getPostValue("srfactionparam");
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        JSONObject jSONObject = JSONObject.fromString((String)string);
        String string2 = jSONObject.optString("psdedritemid");
        String string3 = jSONObject.optString("psdedritemname");
        pSDEDRDetail.setPSDEDRItemId("");
        pSDEDRDetail.setPSDEDRItemName("");
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            pSDEDRDetail.setPSDEDRItemId(string2);
            pSDEDRDetail.setPSDEDRItemName(string3);
            if (StringHelper.isNullOrEmpty((String)pSDEDRDetail.getPSDEDRItemName())) {
                pSDEDRDetail.setSessionFactory(this.getSessionFactory());
                pSDEDRDetail.setPSDEDRItemName(pSDEDRDetail.getPSDEDRItem().getPSDEDRItemName());
            }
        }
    }
}
