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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionLogic;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEActionLogicService
extends PSDEActionLogicServiceBase {
    private static final Log log = LogFactory.getLog(PSDEActionLogicService.class);

    @Override
    public Object getDataContextValue(PSDEActionLogic pSDEActionLogic, String string, IDataContextParam iDataContextParam) throws Exception {
        if (iDataContextParam != null && StringHelper.compare((String)string, (String)"psdeid", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"psdeaction", (boolean)true) == 0) {
            if (StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"psdeactionname", (boolean)true) == 0) {
                return pSDEActionLogic.getPSDEId();
            }
            if (StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"dstpsdeactionname", (boolean)true) == 0) {
                return pSDEActionLogic.getDstPSDEId();
            }
        }
        return super.getDataContextValue(pSDEActionLogic, string, iDataContextParam);
    }
}

