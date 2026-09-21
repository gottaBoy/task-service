/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.impl;

import net.ibizsys.modelapi.domain.PSAppDEView;
import net.ibizsys.modelapi.dto.PSAppDEViewDTO;
import net.ibizsys.modelapi.service.IPSAppDEViewService;
import net.ibizsys.modelapi.service.impl.PSAppViewServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppDEViewServiceImpl
extends PSAppViewServiceImpl<PSAppDEView, PSAppDEViewDTO>
implements IPSAppDEViewService {
    private static final Log log = LogFactory.getLog(PSAppDEViewServiceImpl.class);

    @Override
    public String getModelTag(PSAppDEView et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSAppDEViewName())) {
            return et.getPSAppDEViewName();
        }
        if (StringUtils.hasLength((String)et.getPSDEViewBaseId())) {
            return et.getPSDEViewBaseId();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppDEViewDTO dto, PSAppDEView t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppDEViewId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getPSAppDEViewName() != null || !bIgnoreNull) {
            dto.setPSAppDEViewName(t.getPSAppDEViewName());
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
        return "PSAPPDEVIEW";
    }

    @Override
    public PSAppDEView createDomain() {
        return new PSAppDEView();
    }

    @Override
    public PSAppDEViewDTO createDTO() {
        return new PSAppDEViewDTO();
    }
}

