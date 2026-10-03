/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.wfdesign.service;

import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.codelist.WFProcParamValueTypeCodeListModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcParam;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcParamServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSWFProcParamService
extends PSWFProcParamServiceBase {
    private static final Log log = LogFactory.getLog(PSWFProcParamService.class);

    @Override
    protected void onBeforeCreateTemp(PSWFProcParam pSWFProcParam) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSWFProcParam.getPSWFProcParamName())) {
            pSWFProcParam.setPSWFProcParamName(this.calcWFProcParamName(pSWFProcParam));
        }
        super.onBeforeCreateTemp(pSWFProcParam);
    }

    @Override
    protected void onBeforeUpdateTemp(PSWFProcParam pSWFProcParam) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSWFProcParam.getPSWFProcParamName())) {
            pSWFProcParam.setPSWFProcParamName(this.calcWFProcParamName(pSWFProcParam));
        }
        super.onBeforeUpdateTemp(pSWFProcParam);
    }

    protected String calcWFProcParamName(PSWFProcParam pSWFProcParam) throws Exception {
        Object object;
        String string = pSWFProcParam.getCustomDstDEFName();
        if (StringHelper.isNullOrEmpty((String)string)) {
            string = pSWFProcParam.getPSDEFName();
        }
        String string2 = "";
        if (!StringHelper.isNullOrEmpty((String)pSWFProcParam.getSrcValueType())) {
            object = (WFProcParamValueTypeCodeListModel)CodeListGlobal.getCodeList(WFProcParamValueTypeCodeListModel.class);
            string2 = ((WFProcParamValueTypeCodeListModel)object).getCodeListText(pSWFProcParam.getSrcValueType(), true);
        }
        object = pSWFProcParam.getSrcValue();
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return StringHelper.format((String)"[%1$s]==>[%2$s]", (Object)string, (Object)object);
        }
        return StringHelper.format((String)"[%1$s]==>[%2$s](%3$s)", (Object)string, (Object)string2, (Object)object);
    }
}

