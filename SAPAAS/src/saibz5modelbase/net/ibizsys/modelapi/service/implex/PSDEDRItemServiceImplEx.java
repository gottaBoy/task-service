/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.implex;

import net.ibizsys.modelapi.domain.PSDEDRItem;
import net.ibizsys.modelapi.dto.PSDEDRItemDTO;
import net.ibizsys.modelapi.service.impl.PSDEDRItemServiceImpl;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.springframework.util.StringUtils;

public class PSDEDRItemServiceImplEx
extends PSDEDRItemServiceImpl {
    @Override
    protected void onFillDTO(PSDEDRItemDTO dto, PSDEDRItem t, boolean bIgnoreNull) throws Exception {
        super.onFillDTO(dto, t, bIgnoreNull);
        if (StringUtils.hasLength((String)dto.getViewPSDEId())) {
            dto.setViewPSDEId(this.getRealPSModelId(t, dto.getViewPSDEId()).replace("/", "."));
            if (PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getViewPSDEId(), true) == null) {
                dto.setViewPSDEId(null);
            }
        }
    }
}

