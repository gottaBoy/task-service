/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.implex;

import net.ibizsys.modelapi.domain.PSDEViewBase;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.service.impl.PSDEViewBaseServiceImpl;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.springframework.util.StringUtils;

public class PSDEViewBaseServiceImplEx
extends PSDEViewBaseServiceImpl {
    @Override
    protected void onFillDTO(PSDEViewBaseDTO dto, PSDEViewBase t, boolean bIgnoreNull) throws Exception {
        super.onFillDTO(dto, t, bIgnoreNull);
        if ("DEREDIRECTVIEW".equals(dto.getPSDEViewBaseType()) && StringUtils.hasLength((String)dto.getViewParam7())) {
            dto.setViewParam7(this.getRealPSModelId(t, dto.getViewParam7()).replace("/", "."));
            if (PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getViewParam7(), true) == null) {
                dto.setViewParam7(null);
            }
        }
    }
}

