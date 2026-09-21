/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.impl;

import net.ibizsys.modelapi.domain.PSAppPanelView;
import net.ibizsys.modelapi.dto.PSAppPanelViewDTO;
import net.ibizsys.modelapi.service.IPSAppPanelViewService;
import net.ibizsys.modelapi.service.impl.PSAppViewServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppPanelViewServiceImpl
extends PSAppViewServiceImpl<PSAppPanelView, PSAppPanelViewDTO>
implements IPSAppPanelViewService {
    private static final Log log = LogFactory.getLog(PSAppPanelViewServiceImpl.class);

    @Override
    public String getModelTag(PSAppPanelView et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppPanelViewDTO dto, PSAppPanelView t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppPanelViewId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getLayoutMode() != null || !bIgnoreNull) {
            dto.setLayoutMode(t.getLayoutMode());
        }
        if (t.getPanelStyle() != null || !bIgnoreNull) {
            dto.setPanelStyle(t.getPanelStyle());
        }
        if (t.getPanelWidth() != null || !bIgnoreNull) {
            dto.setPanelWidth(t.getPanelWidth());
        }
        if (t.getPSAppPanelViewName() != null || !bIgnoreNull) {
            dto.setPSAppPanelViewName(t.getPSAppPanelViewName());
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
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSAPPPANELVIEW";
    }

    @Override
    public PSAppPanelView createDomain() {
        return new PSAppPanelView();
    }

    @Override
    public PSAppPanelViewDTO createDTO() {
        return new PSAppPanelViewDTO();
    }
}

