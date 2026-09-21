/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dynasys.service;

import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEFormTempl;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormTemplServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDynaDEFormTemplService
extends PSDynaDEFormTemplServiceBase {
    private static final Log log = LogFactory.getLog(PSDynaDEFormTemplService.class);

    @Override
    public Object getDataContextValue(PSDynaDEFormTempl pSDynaDEFormTempl, String string, IDataContextParam iDataContextParam) throws Exception {
        if (iDataContextParam != null && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFORM", (boolean)true) == 0 && StringHelper.compare((String)string, (String)"psdeid", (boolean)true) == 0 && pSDynaDEFormTempl.getPSDynaDETempl() != null) {
            return pSDynaDEFormTempl.getPSDynaDETempl().getTemplPSDEId();
        }
        return super.getDataContextValue(pSDynaDEFormTempl, string, iDataContextParam);
    }
}

