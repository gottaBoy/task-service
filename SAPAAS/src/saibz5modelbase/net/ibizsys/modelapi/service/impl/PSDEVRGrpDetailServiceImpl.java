/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.impl;

import net.ibizsys.modelapi.domain.PSDEVRGrpDetail;
import net.ibizsys.modelapi.dto.PSDEFValueRuleDTO;
import net.ibizsys.modelapi.dto.PSDEVRGroupDTO;
import net.ibizsys.modelapi.dto.PSDEVRGrpDetailDTO;
import net.ibizsys.modelapi.service.IPSDEVRGrpDetailService;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEVRGrpDetailServiceImpl
extends PSModelServiceImplBase<PSDEVRGrpDetail, PSDEVRGrpDetailDTO>
implements IPSDEVRGrpDetailService {
    private static final Log log = LogFactory.getLog(PSDEVRGrpDetailServiceImpl.class);

    @Override
    public String getModelTag(PSDEVRGrpDetail et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEVRGrpDetailDTO dto, PSDEVRGrpDetail t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEVRGrpDetailId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDetailParam() != null || !bIgnoreNull) {
            dto.setDetailParam(t.getDetailParam());
        }
        if (t.getDetailParam2() != null || !bIgnoreNull) {
            dto.setDetailParam2(t.getDetailParam2());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDEFValueRuleId() != null || !bIgnoreNull) {
            dto.setPSDEFValueRuleId(t.getPSDEFValueRuleId());
        }
        if (t.getPSDEFValueRuleName() != null || !bIgnoreNull) {
            dto.setPSDEFValueRuleName(t.getPSDEFValueRuleName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEVRGroupId() != null || !bIgnoreNull) {
            dto.setPSDEVRGroupId(t.getPSDEVRGroupId());
        }
        if (t.getPSDEVRGroupName() != null || !bIgnoreNull) {
            dto.setPSDEVRGroupName(t.getPSDEVRGroupName());
        }
        if (t.getPSDEVRGrpDetailName() != null || !bIgnoreNull) {
            dto.setPSDEVRGrpDetailName(t.getPSDEVRGrpDetailName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUserCat() != null || !bIgnoreNull) {
            dto.setUserCat(t.getUserCat());
        }
        if (t.getUserTag() != null || !bIgnoreNull) {
            dto.setUserTag(t.getUserTag());
        }
        if (t.getUserTag2() != null || !bIgnoreNull) {
            dto.setUserTag2(t.getUserTag2());
        }
        if (t.getUserTag3() != null || !bIgnoreNull) {
            dto.setUserTag3(t.getUserTag3());
        }
        if (t.getUserTag4() != null || !bIgnoreNull) {
            dto.setUserTag4(t.getUserTag4());
        }
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (StringUtils.hasLength((String)dto.getPSDEFValueRuleId())) {
            dto.setPSDEFValueRuleId(this.getRealPSModelId(t, dto.getPSDEFValueRuleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEVRGroupId())) {
            dto.setPSDEVRGroupId(this.getRealPSModelId(t, dto.getPSDEVRGroupId()).replace("/", "."));
        } else {
            dto.setPSDEVRGroupId(this.getRealPSModelId(t, "<PSDEVRGROUP>").replace("/", "."));
        }
        if ("PSDEVRGROUP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEVRGroupId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFValueRuleId())) {
            linkDTO = (PSDEFValueRuleDTO)PSModelServiceUtil.getInstance().getPSDEFValueRuleService().getDTO(dto.getPSDEFValueRuleId());
            dto.setPSDEFValueRuleName(((PSDEFValueRuleDTO)linkDTO).getPSDEFValueRuleName());
        } else {
            dto.setPSDEFValueRuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEVRGroupId())) {
            linkDTO = (PSDEVRGroupDTO)PSModelServiceUtil.getInstance().getPSDEVRGroupService().getDTO(dto.getPSDEVRGroupId());
            dto.setPSDEId(((PSDEVRGroupDTO)linkDTO).getPSDEId());
            dto.setPSDEVRGroupName(((PSDEVRGroupDTO)linkDTO).getPSDEVRGroupName());
        } else {
            dto.setPSDEId(null);
            dto.setPSDEVRGroupName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEVRGRPDETAIL";
    }

    @Override
    public PSDEVRGrpDetail createDomain() {
        return new PSDEVRGrpDetail();
    }

    @Override
    public PSDEVRGrpDetailDTO createDTO() {
        return new PSDEVRGrpDetailDTO();
    }
}

