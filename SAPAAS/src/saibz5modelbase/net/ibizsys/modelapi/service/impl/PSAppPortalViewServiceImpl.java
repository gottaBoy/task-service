/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import net.ibizsys.modelapi.domain.PSAppPVPart;
import net.ibizsys.modelapi.domain.PSAppPortalView;
import net.ibizsys.modelapi.dto.PSAppPVPartDTO;
import net.ibizsys.modelapi.dto.PSAppPortalViewDTO;
import net.ibizsys.modelapi.service.IPSAppPortalViewService;
import net.ibizsys.modelapi.service.impl.PSAppViewServiceImpl;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppPortalViewServiceImpl
extends PSAppViewServiceImpl<PSAppPortalView, PSAppPortalViewDTO>
implements IPSAppPortalViewService {
    private static final Log log = LogFactory.getLog(PSAppPortalViewServiceImpl.class);

    @Override
    public String getModelTag(PSAppPortalView et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppPortalViewDTO dto, PSAppPortalView t, boolean bIgnoreNull) throws Exception {
        List<PSAppPVPart> list;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppPortalViewId(t.getId().replace("/", "."));
        }
        if (t.getColModel() != null || !bIgnoreNull) {
            dto.setColModel(t.getColModel());
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
        if (t.getEnableCustomize() != null || !bIgnoreNull) {
            dto.setEnableCustomize(t.getEnableCustomize());
        }
        if (t.getFlexAlign() != null || !bIgnoreNull) {
            dto.setFlexAlign(t.getFlexAlign());
        }
        if (t.getFlexDir() != null || !bIgnoreNull) {
            dto.setFlexDir(t.getFlexDir());
        }
        if (t.getFlexVAlign() != null || !bIgnoreNull) {
            dto.setFlexVAlign(t.getFlexVAlign());
        }
        if (t.getLayoutMode() != null || !bIgnoreNull) {
            dto.setLayoutMode(t.getLayoutMode());
        }
        if (t.getPSAppPortalViewName() != null || !bIgnoreNull) {
            dto.setPSAppPortalViewName(t.getPSAppPortalViewName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if ((list = PSModelServiceUtil.getInstance().getPSAppPVPartService().listByPSAppPortalView(t)) != null && list.size() > 0) {
            ArrayList<PSAppPVPartDTO> psapppvparts = new ArrayList<PSAppPVPartDTO>();
            for (PSAppPVPart item : list) {
                PSAppPVPartDTO dstItem = (PSAppPVPartDTO)PSModelServiceUtil.getInstance().getPSAppPVPartService().toDTO(item);
                psapppvparts.add(dstItem);
            }
            dto.setPsapppvparts(psapppvparts);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSAPPPORTALVIEW";
    }

    @Override
    public PSAppPortalView createDomain() {
        return new PSAppPortalView();
    }

    @Override
    public PSAppPortalViewDTO createDTO() {
        return new PSAppPortalViewDTO();
    }
}

