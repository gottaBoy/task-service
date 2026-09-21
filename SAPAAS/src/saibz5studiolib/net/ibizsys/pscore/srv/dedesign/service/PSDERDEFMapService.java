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
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERDEFMap;
import net.ibizsys.pscore.srv.dedesign.service.PSDERDEFMapServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDERDEFMapService
extends PSDERDEFMapServiceBase {
    private static final Log log = LogFactory.getLog(PSDERDEFMapService.class);

    @Override
    public Object getDataContextValue(PSDERDEFMap pSDERDEFMap, String string, IDataContextParam iDataContextParam) throws Exception {
        if (iDataContextParam != null && (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATAQUERY", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"psdeid", (boolean)true) == 0) && pSDERDEFMap.getPSDER() != null) {
            return pSDERDEFMap.getPSDER().getMinorPSDEId();
        }
        return super.getDataContextValue(pSDERDEFMap, string, iDataContextParam);
    }
}

