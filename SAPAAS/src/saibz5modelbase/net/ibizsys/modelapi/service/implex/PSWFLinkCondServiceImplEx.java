/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.implex;

import net.ibizsys.modelapi.domain.PSWFLinkCond;
import net.ibizsys.modelapi.dto.PSWFLinkCondDTO;
import net.ibizsys.modelapi.service.impl.PSWFLinkCondServiceImpl;
import org.springframework.util.StringUtils;

public class PSWFLinkCondServiceImplEx
extends PSWFLinkCondServiceImpl {
    @Override
    protected void onFillDTO(PSWFLinkCondDTO dto, PSWFLinkCond t, boolean bIgnoreNull) throws Exception {
        if (!StringUtils.hasLength((String)t.getPSWFVersionId())) {
            t.setPSWFVersionId("<PSWFVERSION>");
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }
}

