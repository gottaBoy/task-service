/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.impl;

import net.ibizsys.modelapi.domain.PSAppDynaDEView;
import net.ibizsys.modelapi.dto.PSAppDynaDEViewDTO;
import net.ibizsys.modelapi.service.IPSAppDynaDEViewService;
import net.ibizsys.modelapi.service.impl.PSAppViewServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppDynaDEViewServiceImpl
extends PSAppViewServiceImpl<PSAppDynaDEView, PSAppDynaDEViewDTO>
implements IPSAppDynaDEViewService {
    private static final Log log = LogFactory.getLog(PSAppDynaDEViewServiceImpl.class);

    @Override
    public String getModelTag(PSAppDynaDEView et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDynaDEViewTemplId())) {
            return et.getPSDynaDEViewTemplId();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppDynaDEViewDTO dto, PSAppDynaDEView t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppDynaDEViewId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getPSAppDynaDEViewName() != null || !bIgnoreNull) {
            dto.setPSAppDynaDEViewName(t.getPSAppDynaDEViewName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSAPPDYNADEVIEW";
    }

    @Override
    public PSAppDynaDEView createDomain() {
        return new PSAppDynaDEView();
    }

    @Override
    public PSAppDynaDEViewDTO createDTO() {
        return new PSAppDynaDEViewDTO();
    }
}

