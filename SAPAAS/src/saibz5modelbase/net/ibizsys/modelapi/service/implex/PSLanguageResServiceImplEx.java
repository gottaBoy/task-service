/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service.implex;

import net.ibizsys.modelapi.domain.PSLanguageRes;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.service.impl.PSLanguageResServiceImpl;

public class PSLanguageResServiceImplEx
extends PSLanguageResServiceImpl {
    @Override
    protected void onFillDTO(PSLanguageResDTO dto, PSLanguageRes t, boolean bIgnoreNull) throws Exception {
        t.setPSDEFId(null);
        t.setPSDEId(null);
        t.setPSAppViewId(null);
        t.setPSDEViewBaseId(null);
        t.setPSWFId(null);
        t.setPSWFVersionId(null);
        t.setPSSysAppId(null);
        t.setPSSysLanResId(null);
        dto.setPSDEFId(null);
        dto.setPSDEId(null);
        dto.setPSAppViewId(null);
        dto.setPSDEViewBaseId(null);
        dto.setPSWFId(null);
        dto.setPSWFVersionId(null);
        dto.setPSSysAppId(null);
        dto.setPSSysLanResId(null);
        super.onFillDTO(dto, t, bIgnoreNull);
    }
}

