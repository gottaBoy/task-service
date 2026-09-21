/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.config.service;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.pscore.srv.config.entity.PSSFVerCode;
import net.ibizsys.pscore.srv.config.service.PSSFVerCodeServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSFVerCodeService
extends PSSFVerCodeServiceBase {
    private static final Log log = LogFactory.getLog(PSSFVerCodeService.class);

    @Override
    protected void onFillEntityFullInfo(PSSFVerCode pSSFVerCode, boolean bl) throws Exception {
        if (pSSFVerCode.isEnableCustomTypeCodeDirty() && !DataObject.getBoolValue((Integer)pSSFVerCode.getEnableCustomTypeCode(), (boolean)false) && pSSFVerCode.getPSSFCodeType() != null) {
            pSSFVerCode.setCustomTypeCode(pSSFVerCode.getPSSFCodeType().getTypeCode());
        }
        super.onFillEntityFullInfo(pSSFVerCode, bl);
    }
}

