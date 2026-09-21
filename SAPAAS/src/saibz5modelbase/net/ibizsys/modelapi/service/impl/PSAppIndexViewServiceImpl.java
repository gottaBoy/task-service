/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.impl;

import net.ibizsys.modelapi.domain.PSAppIndexView;
import net.ibizsys.modelapi.dto.PSAppIndexViewDTO;
import net.ibizsys.modelapi.dto.PSAppMenuDTO;
import net.ibizsys.modelapi.dto.PSAppViewDTO;
import net.ibizsys.modelapi.dto.PSSysCounterDTO;
import net.ibizsys.modelapi.service.IPSAppIndexViewService;
import net.ibizsys.modelapi.service.impl.PSAppViewServiceImpl;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppIndexViewServiceImpl
extends PSAppViewServiceImpl<PSAppIndexView, PSAppIndexViewDTO>
implements IPSAppIndexViewService {
    private static final Log log = LogFactory.getLog(PSAppIndexViewServiceImpl.class);

    @Override
    public String getModelTag(PSAppIndexView et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppIndexViewDTO dto, PSAppIndexView t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppIndexViewId(t.getId().replace("/", "."));
        }
        if (t.getAppIconPath() != null || !bIgnoreNull) {
            dto.setAppIconPath(t.getAppIconPath());
        }
        if (t.getAppIconPath2() != null || !bIgnoreNull) {
            dto.setAppIconPath2(t.getAppIconPath2());
        }
        if (t.getAppSwitchMode() != null || !bIgnoreNull) {
            dto.setAppSwitchMode(t.getAppSwitchMode());
        }
        if (t.getBlankMode() != null || !bIgnoreNull) {
            dto.setBlankMode(t.getBlankMode());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDefaultPage() != null || !bIgnoreNull) {
            dto.setDefaultPage(t.getDefaultPage());
        }
        if (t.getDefPSAppViewId() != null || !bIgnoreNull) {
            dto.setDefPSAppViewId(t.getDefPSAppViewId());
        }
        if (t.getDefPSAppViewName() != null || !bIgnoreNull) {
            dto.setDefPSAppViewName(t.getDefPSAppViewName());
        }
        if (t.getEnableCounter() != null || !bIgnoreNull) {
            dto.setEnableCounter(t.getEnableCounter());
        }
        if (t.getMainMenuSide() != null || !bIgnoreNull) {
            dto.setMainMenuSide(t.getMainMenuSide());
        }
        if (t.getPSAppIndexViewName() != null || !bIgnoreNull) {
            dto.setPSAppIndexViewName(t.getPSAppIndexViewName());
        }
        if (t.getPSAppMenuId() != null || !bIgnoreNull) {
            dto.setPSAppMenuId(t.getPSAppMenuId());
        }
        if (t.getPSAppMenuName() != null || !bIgnoreNull) {
            dto.setPSAppMenuName(t.getPSAppMenuName());
        }
        if (t.getPSSysCounterId() != null || !bIgnoreNull) {
            dto.setPSSysCounterId(t.getPSSysCounterId());
        }
        if (t.getPSSysCounterName() != null || !bIgnoreNull) {
            dto.setPSSysCounterName(t.getPSSysCounterName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (StringUtils.hasLength((String)dto.getDefPSAppViewId())) {
            dto.setDefPSAppViewId(this.getRealPSModelId(t, dto.getDefPSAppViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppMenuId())) {
            dto.setPSAppMenuId(this.getRealPSModelId(t, dto.getPSAppMenuId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCounterId())) {
            dto.setPSSysCounterId(this.getRealPSModelId(t, dto.getPSSysCounterId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDefPSAppViewId())) {
            linkDTO = (PSAppViewDTO)PSModelServiceUtil.getInstance().getPSAppViewService().getDTO(dto.getDefPSAppViewId());
            dto.setDefPSAppViewName(((PSAppViewDTO)linkDTO).getPSAppViewName());
        } else {
            dto.setDefPSAppViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSAppMenuId())) {
            linkDTO = (PSAppMenuDTO)PSModelServiceUtil.getInstance().getPSAppMenuService().getDTO(dto.getPSAppMenuId());
            dto.setPSAppMenuName(((PSAppMenuDTO)linkDTO).getPSAppMenuName());
        } else {
            dto.setPSAppMenuName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysCounterId())) {
            linkDTO = (PSSysCounterDTO)PSModelServiceUtil.getInstance().getPSSysCounterService().getDTO(dto.getPSSysCounterId());
            dto.setPSSysCounterName(((PSSysCounterDTO)linkDTO).getPSSysCounterName());
        } else {
            dto.setPSSysCounterName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSAPPINDEXVIEW";
    }

    @Override
    public PSAppIndexView createDomain() {
        return new PSAppIndexView();
    }

    @Override
    public PSAppIndexViewDTO createDTO() {
        return new PSAppIndexViewDTO();
    }
}

