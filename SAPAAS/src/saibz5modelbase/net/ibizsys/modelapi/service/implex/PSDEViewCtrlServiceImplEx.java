/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.implex;

import net.ibizsys.modelapi.domain.PSDEViewCtrl;
import net.ibizsys.modelapi.dto.PSDEViewCtrlDTO;
import net.ibizsys.modelapi.service.impl.PSDEViewCtrlServiceImpl;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.springframework.util.StringUtils;

public class PSDEViewCtrlServiceImplEx
extends PSDEViewCtrlServiceImpl {
    @Override
    protected void onFillDTO(PSDEViewCtrlDTO dto, PSDEViewCtrl t, boolean bIgnoreNull) throws Exception {
        super.onFillDTO(dto, t, bIgnoreNull);
        if ("TABVIEWPANEL".equals(dto.getPSDEViewCtrlType()) && StringUtils.hasLength((String)dto.getCtrlParam2())) {
            dto.setCtrlParam2(this.getRealPSModelId(t, dto.getCtrlParam2()).replace("/", "."));
            if (PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getCtrlParam2(), true) == null) {
                dto.setCtrlParam2(null);
            }
        }
    }
}

