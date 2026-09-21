/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.service.ServiceGlobal
 */
package net.ibizsys.pscore.srv.util;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.config.entity.PSMIDetail;
import net.ibizsys.pscore.srv.config.entity.PSModelInitStruct;
import net.ibizsys.pscore.srv.config.service.PSMIDetailService;
import net.ibizsys.pscore.srv.config.service.PSModelInitService;

public class PSModelInitGlobal {
    private static HashMap<String, PSModelInitStruct> psModelInitStructMap = null;

    public static synchronized PSModelInitStruct getPSModelInitStruct(String string) throws Exception {
        if (psModelInitStructMap == null) {
            PSModelInitStruct pSModelInitStruct;
            psModelInitStructMap = new HashMap();
            PSModelInitService pSModelInitService = (PSModelInitService)ServiceGlobal.getService(PSModelInitService.class);
            PSMIDetailService pSMIDetailService = (PSMIDetailService)ServiceGlobal.getService(PSMIDetailService.class);
            ArrayList arrayList = pSModelInitService.select((ISelectCond)new SelectCond());
            SelectCond selectCond = new SelectCond();
            selectCond.setOrderInfo("ORDER BY ORDERVALUE");
            ArrayList arrayList2 = pSMIDetailService.select((ISelectCond)selectCond);
            for (EntityBase entityBase : arrayList) {
                pSModelInitStruct = new PSModelInitStruct();
                entityBase.copyTo((IDataObject)pSModelInitStruct, true);
                psModelInitStructMap.put(pSModelInitStruct.getPSModelInitName(), pSModelInitStruct);
            }
            for (EntityBase entityBase : arrayList2) {
                pSModelInitStruct = psModelInitStructMap.get(entityBase.getPSModelInitName());
                pSModelInitStruct.getPSModelInitDetails().add((PSMIDetail)entityBase);
            }
        }
        return psModelInitStructMap.get(string);
    }

    public static synchronized void reset() {
        if (psModelInitStructMap != null) {
            psModelInitStructMap.clear();
            psModelInitStructMap = null;
        }
    }
}

