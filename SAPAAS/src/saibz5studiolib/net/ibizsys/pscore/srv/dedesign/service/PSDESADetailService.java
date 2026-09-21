/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESADetail;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDESADetailService
extends PSDESADetailServiceBase {
    private static final Log log = LogFactory.getLog(PSDESADetailService.class);

    @Override
    protected void onBeforeCreate(PSDESADetail pSDESADetail) throws Exception {
        this.fillPSDESADetailName(pSDESADetail);
        super.onBeforeCreate(pSDESADetail);
    }

    @Override
    protected void onBeforeUpdate(PSDESADetail pSDESADetail) throws Exception {
        this.fillPSDESADetailName(pSDESADetail);
        super.onBeforeUpdate(pSDESADetail);
    }

    protected void fillPSDESADetailName(PSDESADetail pSDESADetail) throws Exception {
        if (StringHelper.compare((String)pSDESADetail.getDetailType(), (String)"DEACTION", (boolean)true) == 0) {
            if (StringHelper.isNullOrEmpty((String)pSDESADetail.getPSDESADetailName()) && pSDESADetail.getPSDEAction() != null) {
                pSDESADetail.setPSDESADetailName(pSDESADetail.getPSDEAction().getCodeName());
            }
            pSDESADetail.setMethodTag(StringHelper.format((String)"%1$s__%2$s", (Object)"DEACTION", (Object)pSDESADetail.getPSDEActionName()).toUpperCase());
            pSDESADetail.setUniqueTag(StringHelper.format((String)"%1$s__%2$s", (Object)pSDESADetail.getPSDEServiceAPI().getPSDEName(), (Object)pSDESADetail.getMethodTag()).toUpperCase());
            return;
        }
        if (StringHelper.compare((String)pSDESADetail.getDetailType(), (String)"FETCH", (boolean)true) == 0) {
            if (StringHelper.isNullOrEmpty((String)pSDESADetail.getPSDESADetailName()) && pSDESADetail.getPSDEDS() != null) {
                pSDESADetail.setPSDESADetailName("Fetch" + pSDESADetail.getPSDEDS().getCodeName());
            }
            pSDESADetail.setMethodTag(StringHelper.format((String)"%1$s__%2$s", (Object)"FETCH", (Object)pSDESADetail.getPSDEDSName()).toUpperCase());
            pSDESADetail.setUniqueTag(StringHelper.format((String)"%1$s__%2$s", (Object)pSDESADetail.getPSDEServiceAPI().getPSDEName(), (Object)pSDESADetail.getMethodTag()).toUpperCase());
            return;
        }
        if (StringHelper.compare((String)pSDESADetail.getDetailType(), (String)"FETCHTEMP", (boolean)true) == 0) {
            if (StringHelper.isNullOrEmpty((String)pSDESADetail.getPSDESADetailName()) && pSDESADetail.getPSDEDS() != null) {
                pSDESADetail.setPSDESADetailName("FetchTemp" + pSDESADetail.getPSDEDS().getCodeName());
            }
            pSDESADetail.setMethodTag(StringHelper.format((String)"%1$s__%2$s", (Object)"FETCHTEMP", (Object)pSDESADetail.getPSDEDSName()).toUpperCase());
            pSDESADetail.setUniqueTag(StringHelper.format((String)"%1$s__%2$s", (Object)pSDESADetail.getPSDEServiceAPI().getPSDEName(), (Object)pSDESADetail.getMethodTag()).toUpperCase());
            return;
        }
        if (StringHelper.compare((String)pSDESADetail.getDetailType(), (String)"SELECT", (boolean)true) == 0) {
            if (StringHelper.isNullOrEmpty((String)pSDESADetail.getPSDESADetailName())) {
                pSDESADetail.setPSDESADetailName("Select");
            }
            pSDESADetail.setMethodTag(StringHelper.format((String)"%1$s", (Object)"SELECT"));
            pSDESADetail.setUniqueTag(StringHelper.format((String)"%1$s__%2$s", (Object)pSDESADetail.getPSDEServiceAPI().getPSDEName(), (Object)pSDESADetail.getMethodTag()).toUpperCase());
            return;
        }
        if (StringHelper.compare((String)pSDESADetail.getDetailType(), (String)"SELECTTEMP", (boolean)true) == 0) {
            if (StringHelper.isNullOrEmpty((String)pSDESADetail.getPSDESADetailName())) {
                pSDESADetail.setPSDESADetailName("SelectTemp");
            }
            pSDESADetail.setMethodTag(StringHelper.format((String)"%1$s", (Object)"SELECTTEMP"));
            pSDESADetail.setUniqueTag(StringHelper.format((String)"%1$s__%2$s", (Object)pSDESADetail.getPSDEServiceAPI().getPSDEName(), (Object)pSDESADetail.getMethodTag()).toUpperCase());
            return;
        }
    }

    @Override
    protected void onCalcRequestMethod(PSDESADetail pSDESADetail) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSDESADetail.getRequestMethod())) {
            return;
        }
        if (StringHelper.isNullOrEmpty((String)pSDESADetail.getDetailType())) {
            return;
        }
        if (StringHelper.compare((String)pSDESADetail.getDetailType(), (String)"DEACTION", (boolean)false) == 0) {
            if (StringHelper.isNullOrEmpty((String)pSDESADetail.getPSDEActionName())) {
                return;
            }
            String string = pSDESADetail.getPSDEActionName().toUpperCase();
            if (string.indexOf("CREATE") != -1) {
                pSDESADetail.setRequestMethod("POST");
            } else if (string.indexOf("UPDATE") != -1) {
                pSDESADetail.setRequestMethod("PUT");
            } else if (string.indexOf("GET") != -1) {
                pSDESADetail.setRequestMethod("GET");
            } else if (string.indexOf("REMOVE") != -1) {
                pSDESADetail.setRequestMethod("DELETE");
            } else {
                pSDESADetail.setRequestMethod("POST");
            }
        } else {
            pSDESADetail.setRequestMethod("POST");
        }
    }
}

