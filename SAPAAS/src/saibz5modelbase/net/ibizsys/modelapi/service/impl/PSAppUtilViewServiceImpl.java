/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.impl;

import net.ibizsys.modelapi.domain.PSAppUtilView;
import net.ibizsys.modelapi.dto.PSAppMenuDTO;
import net.ibizsys.modelapi.dto.PSAppUtilViewDTO;
import net.ibizsys.modelapi.service.IPSAppUtilViewService;
import net.ibizsys.modelapi.service.impl.PSAppViewServiceImpl;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppUtilViewServiceImpl
extends PSAppViewServiceImpl<PSAppUtilView, PSAppUtilViewDTO>
implements IPSAppUtilViewService {
    private static final Log log = LogFactory.getLog(PSAppUtilViewServiceImpl.class);

    @Override
    public String getModelTag(PSAppUtilView et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppUtilViewDTO dto, PSAppUtilView t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppUtilViewId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getErrCode() != null || !bIgnoreNull) {
            dto.setErrCode(t.getErrCode());
        }
        if (t.getPSAppMenuId() != null || !bIgnoreNull) {
            dto.setPSAppMenuId(t.getPSAppMenuId());
        }
        if (t.getPSAppMenuName() != null || !bIgnoreNull) {
            dto.setPSAppMenuName(t.getPSAppMenuName());
        }
        if (t.getPSAppUtilViewName() != null || !bIgnoreNull) {
            dto.setPSAppUtilViewName(t.getPSAppUtilViewName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (StringUtils.hasLength((String)dto.getPSAppMenuId())) {
            dto.setPSAppMenuId(this.getRealPSModelId(t, dto.getPSAppMenuId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppMenuId())) {
            PSAppMenuDTO linkDTO = (PSAppMenuDTO)PSModelServiceUtil.getInstance().getPSAppMenuService().getDTO(dto.getPSAppMenuId());
            dto.setPSAppMenuName(linkDTO.getPSAppMenuName());
        } else {
            dto.setPSAppMenuName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSAPPUTILVIEW";
    }

    @Override
    public PSAppUtilView createDomain() {
        return new PSAppUtilView();
    }

    @Override
    public PSAppUtilViewDTO createDTO() {
        return new PSAppUtilViewDTO();
    }
}

