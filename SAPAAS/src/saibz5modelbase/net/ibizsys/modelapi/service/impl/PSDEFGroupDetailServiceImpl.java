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
import net.ibizsys.modelapi.domain.PSDEFGroup;
import net.ibizsys.modelapi.domain.PSDEFGroupDetail;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSDEFGroupDTO;
import net.ibizsys.modelapi.dto.PSDEFGroupDetailDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysValueRuleDTO;
import net.ibizsys.modelapi.service.IPSDEFGroupDetailService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEFGroupDetailServiceImpl
extends PSModelServiceImplBase<PSDEFGroupDetail, PSDEFGroupDetailDTO>
implements IPSDEFGroupDetailService {
    private static final Log log = LogFactory.getLog(PSDEFGroupDetailServiceImpl.class);

    @Override
    public List<PSDEFGroupDetail> listByPSDEFGroup(PSDEFGroup parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEFGroupDetail get(PSDEFGroup parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEFGroupDetail> list = this.listByPSDEFGroup(parent);
        if (list != null) {
            for (PSDEFGroupDetail item : list) {
                String strTag = item.getSrfTag();
                if (!StringUtils.hasLength((String)strTag)) {
                    item.init();
                    strTag = this.getModelTag(item);
                }
                if (strKey.compareTo(strTag) != 0) continue;
                return item;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u6807\u8bb0\u4e3a[%1$s]", strKey));
    }

    @Override
    public List<PSDEFGroupDetailDTO> listDTOByPSDEFGroup(String strParentKey) throws Exception {
        PSDEFGroup psdefgroup = (PSDEFGroup)PSModelServiceUtil.getInstance().getPSDEFGroupService().get(strParentKey);
        List<PSDEFGroupDetail> list = this.listByPSDEFGroup(psdefgroup);
        if (list != null) {
            ArrayList<PSDEFGroupDetailDTO> dtoList = new ArrayList<PSDEFGroupDetailDTO>();
            for (PSDEFGroupDetail item : list) {
                PSDEFGroupDetailDTO dto = (PSDEFGroupDetailDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEFGroupDetail> onListAll() throws Exception {
        ArrayList<PSDEFGroupDetail> list = new ArrayList<PSDEFGroupDetail>();
        List psdefgroups = PSModelServiceUtil.getInstance().getPSDEFGroupService().listAll();
        if (psdefgroups != null) {
            for (PSDEFGroup parent : psdefgroups) {
                List<PSDEFGroupDetail> items = this.listByPSDEFGroup(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        return list;
    }

    @Override
    protected PSDEFGroupDetail onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEFGroupDetail item;
        PSDEFGroup psdefgroup = (PSDEFGroup)PSModelServiceUtil.getInstance().getPSDEFGroupService().get(strParentKey, true);
        if (psdefgroup != null && (item = this.get(psdefgroup, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEFGroupDetail)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEFGroupDetailDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEFGroupId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEFGroupService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEFGroupDetail et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEFGroupDetailName())) {
            return et.getPSDEFGroupDetailName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEFGroupDetailDTO dto, PSDEFGroupDetail t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEFGroupDetailId(t.getId().replace("/", "."));
        }
        if (t.getAllowEmpty() != null || !bIgnoreNull) {
            dto.setAllowEmpty(t.getAllowEmpty());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getCodeName2() != null || !bIgnoreNull) {
            dto.setCodeName2(t.getCodeName2());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDefaultValue() != null || !bIgnoreNull) {
            dto.setDefaultValue(t.getDefaultValue());
        }
        if (t.getDetailParam() != null || !bIgnoreNull) {
            dto.setDetailParam(t.getDetailParam());
        }
        if (t.getDetailParam2() != null || !bIgnoreNull) {
            dto.setDetailParam2(t.getDetailParam2());
        }
        if (t.getDefaultValueType() != null || !bIgnoreNull) {
            dto.setDefaultValueType(t.getDefaultValueType());
        }
        if (t.getEnableUserInput() != null || !bIgnoreNull) {
            dto.setEnableUserInput(t.getEnableUserInput());
        }
        if (t.getJsonFormat() != null || !bIgnoreNull) {
            dto.setJsonFormat(t.getJsonFormat());
        }
        if (t.getLNPSLanResId() != null || !bIgnoreNull) {
            dto.setLNPSLanResId(t.getLNPSLanResId());
        }
        if (t.getLNPSLanResName() != null || !bIgnoreNull) {
            dto.setLNPSLanResName(t.getLNPSLanResName());
        }
        if (t.getMaxValue() != null || !bIgnoreNull) {
            dto.setMaxValue(t.getMaxValue());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMinStrLength() != null || !bIgnoreNull) {
            dto.setMinStrLength(t.getMinStrLength());
        }
        if (t.getMinValue() != null || !bIgnoreNull) {
            dto.setMinValue(t.getMinValue());
        }
        if (t.getModifyUserInput() != null || !bIgnoreNull) {
            dto.setModifyUserInput(t.getModifyUserInput());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPrecision2() != null || !bIgnoreNull) {
            dto.setPrecision2(t.getPrecision2());
        }
        if (t.getPSCodeListId() != null || !bIgnoreNull) {
            dto.setPSCodeListId(t.getPSCodeListId());
        }
        if (t.getPSCodeListName() != null || !bIgnoreNull) {
            dto.setPSCodeListName(t.getPSCodeListName());
        }
        if (t.getPSDEFGroupDetailName() != null || !bIgnoreNull) {
            dto.setPSDEFGroupDetailName(t.getPSDEFGroupDetailName());
        }
        if (t.getPSDEFGroupId() != null || !bIgnoreNull) {
            dto.setPSDEFGroupId(t.getPSDEFGroupId());
        }
        if (t.getPSDEFGroupName() != null || !bIgnoreNull) {
            dto.setPSDEFGroupName(t.getPSDEFGroupName());
        }
        if (t.getPSDEFId() != null || !bIgnoreNull) {
            dto.setPSDEFId(t.getPSDEFId());
        }
        if (t.getPSDEFName() != null || !bIgnoreNull) {
            dto.setPSDEFName(t.getPSDEFName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSSysValueRuleId() != null || !bIgnoreNull) {
            dto.setPSSysValueRuleId(t.getPSSysValueRuleId());
        }
        if (t.getPSSysValueRuleName() != null || !bIgnoreNull) {
            dto.setPSSysValueRuleName(t.getPSSysValueRuleName());
        }
        if (t.getSearchModes() != null || !bIgnoreNull) {
            dto.setSearchModes(t.getSearchModes());
        }
        if (t.getStrLength() != null || !bIgnoreNull) {
            dto.setStrLength(t.getStrLength());
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
        if (StringUtils.hasLength((String)dto.getLNPSLanResId())) {
            dto.setLNPSLanResId(this.getRealPSModelId(t, dto.getLNPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            dto.setPSCodeListId(this.getRealPSModelId(t, dto.getPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFGroupId())) {
            dto.setPSDEFGroupId(this.getRealPSModelId(t, dto.getPSDEFGroupId()).replace("/", "."));
        }
        if ("PSDEFGROUP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEFGroupId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysValueRuleId())) {
            dto.setPSSysValueRuleId(this.getRealPSModelId(t, dto.getPSSysValueRuleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLNPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getLNPSLanResId());
            dto.setLNPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setLNPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getPSCodeListId());
            dto.setPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setPSCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFGroupId())) {
            linkDTO = (PSDEFGroupDTO)PSModelServiceUtil.getInstance().getPSDEFGroupService().getDTO(dto.getPSDEFGroupId());
            dto.setPSDEFGroupName(((PSDEFGroupDTO)linkDTO).getPSDEFGroupName());
            dto.setPSDEId(((PSDEFGroupDTO)linkDTO).getPSDEId());
        } else {
            dto.setPSDEFGroupName(null);
            dto.setPSDEId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysValueRuleId())) {
            linkDTO = (PSSysValueRuleDTO)PSModelServiceUtil.getInstance().getPSSysValueRuleService().getDTO(dto.getPSSysValueRuleId());
            dto.setPSSysValueRuleName(((PSSysValueRuleDTO)linkDTO).getPSSysValueRuleName());
        } else {
            dto.setPSSysValueRuleName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEFGROUPDETAIL";
    }

    @Override
    public PSDEFGroupDetail createDomain() {
        return new PSDEFGroupDetail();
    }

    @Override
    public PSDEFGroupDetailDTO createDTO() {
        return new PSDEFGroupDetailDTO();
    }
}

