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
import net.ibizsys.modelapi.domain.PSThreshold;
import net.ibizsys.modelapi.domain.PSThresholdGroup;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSThresholdDTO;
import net.ibizsys.modelapi.dto.PSThresholdGroupDTO;
import net.ibizsys.modelapi.service.IPSThresholdService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSThresholdServiceImpl
extends PSModelServiceImplBase<PSThreshold, PSThresholdDTO>
implements IPSThresholdService {
    private static final Log log = LogFactory.getLog(PSThresholdServiceImpl.class);

    @Override
    public List<PSThreshold> listByPSThresholdGroup(PSThresholdGroup parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSThreshold get(PSThresholdGroup parent, String strKey, boolean bTryMode) throws Exception {
        List<PSThreshold> list = this.listByPSThresholdGroup(parent);
        if (list != null) {
            for (PSThreshold item : list) {
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
    public List<PSThresholdDTO> listDTOByPSThresholdGroup(String strParentKey) throws Exception {
        PSThresholdGroup psthresholdgroup = (PSThresholdGroup)PSModelServiceUtil.getInstance().getPSThresholdGroupService().get(strParentKey);
        List<PSThreshold> list = this.listByPSThresholdGroup(psthresholdgroup);
        if (list != null) {
            ArrayList<PSThresholdDTO> dtoList = new ArrayList<PSThresholdDTO>();
            for (PSThreshold item : list) {
                PSThresholdDTO dto = (PSThresholdDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSThreshold> onListAll() throws Exception {
        ArrayList<PSThreshold> list = new ArrayList<PSThreshold>();
        List<PSThresholdGroup> psthresholdgroups = PSModelServiceUtil.getInstance().getPSThresholdGroupService().listAll();
        if (psthresholdgroups != null) {
            for (PSThresholdGroup parent : psthresholdgroups) {
                List<PSThreshold> items = this.listByPSThresholdGroup(parent);
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
    protected PSThreshold onGet(String strParentKey, String strCurKey) throws Exception {
        PSThreshold item;
        PSThresholdGroup psthresholdgroup = (PSThresholdGroup)PSModelServiceUtil.getInstance().getPSThresholdGroupService().get(strParentKey, true);
        if (psthresholdgroup != null && (item = this.get(psthresholdgroup, strCurKey, true)) != null) {
            return item;
        }
        return (PSThreshold)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSThresholdDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSThresholdGroupId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSThresholdGroupService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSThreshold et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSThresholdName())) {
            return et.getPSThresholdName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSThresholdDTO dto, PSThreshold t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSThresholdId(t.getId().replace("/", "."));
        }
        if (t.getBeginValue() != null || !bIgnoreNull) {
            dto.setBeginValue(t.getBeginValue());
        }
        if (t.getBKColor() != null || !bIgnoreNull) {
            dto.setBKColor(t.getBKColor());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getColor() != null || !bIgnoreNull) {
            dto.setColor(t.getColor());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getData() != null || !bIgnoreNull) {
            dto.setData(t.getData());
        }
        if (t.getEndValue() != null || !bIgnoreNull) {
            dto.setEndValue(t.getEndValue());
        }
        if (t.getIncBeginValue() != null || !bIgnoreNull) {
            dto.setIncBeginValue(t.getIncBeginValue());
        }
        if (t.getIncEndValue() != null || !bIgnoreNull) {
            dto.setIncEndValue(t.getIncEndValue());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSSysCssId() != null || !bIgnoreNull) {
            dto.setPSSysCssId(t.getPSSysCssId());
        }
        if (t.getPSSysCssName() != null || !bIgnoreNull) {
            dto.setPSSysCssName(t.getPSSysCssName());
        }
        if (t.getPSSysImageId() != null || !bIgnoreNull) {
            dto.setPSSysImageId(t.getPSSysImageId());
        }
        if (t.getPSSysImageName() != null || !bIgnoreNull) {
            dto.setPSSysImageName(t.getPSSysImageName());
        }
        if (t.getPSThresholdGroupId() != null || !bIgnoreNull) {
            dto.setPSThresholdGroupId(t.getPSThresholdGroupId());
        }
        if (t.getPSThresholdGroupName() != null || !bIgnoreNull) {
            dto.setPSThresholdGroupName(t.getPSThresholdGroupName());
        }
        if (t.getPSThresholdName() != null || !bIgnoreNull) {
            dto.setPSThresholdName(t.getPSThresholdName());
        }
        if (t.getTextPSLanResId() != null || !bIgnoreNull) {
            dto.setTextPSLanResId(t.getTextPSLanResId());
        }
        if (t.getTextPSLanResName() != null || !bIgnoreNull) {
            dto.setTextPSLanResName(t.getTextPSLanResName());
        }
        if (t.getThresholdTag() != null || !bIgnoreNull) {
            dto.setThresholdTag(t.getThresholdTag());
        }
        if (t.getThresholdTag2() != null || !bIgnoreNull) {
            dto.setThresholdTag2(t.getThresholdTag2());
        }
        if (t.getTipPSLanResId() != null || !bIgnoreNull) {
            dto.setTipPSLanResId(t.getTipPSLanResId());
        }
        if (t.getTipPSLanResName() != null || !bIgnoreNull) {
            dto.setTipPSLanResName(t.getTipPSLanResName());
        }
        if (t.getTooltipInfo() != null || !bIgnoreNull) {
            dto.setTooltipInfo(t.getTooltipInfo());
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
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            dto.setPSSysCssId(this.getRealPSModelId(t, dto.getPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            dto.setPSSysImageId(this.getRealPSModelId(t, dto.getPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSThresholdGroupId())) {
            dto.setPSThresholdGroupId(this.getRealPSModelId(t, dto.getPSThresholdGroupId()).replace("/", "."));
        }
        if ("PSTHRESHOLDGROUP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSThresholdGroupId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTextPSLanResId())) {
            dto.setTextPSLanResId(this.getRealPSModelId(t, dto.getTextPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTipPSLanResId())) {
            dto.setTipPSLanResId(this.getRealPSModelId(t, dto.getTipPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getPSSysCssId());
            dto.setPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            linkDTO = (PSSysImageDTO)PSModelServiceUtil.getInstance().getPSSysImageService().getDTO(dto.getPSSysImageId());
            dto.setPSSysImageName(((PSSysImageDTO)linkDTO).getPSSysImageName());
        } else {
            dto.setPSSysImageName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSThresholdGroupId())) {
            linkDTO = (PSThresholdGroupDTO)PSModelServiceUtil.getInstance().getPSThresholdGroupService().getDTO(dto.getPSThresholdGroupId());
            dto.setPSThresholdGroupName(((PSThresholdGroupDTO)linkDTO).getPSThresholdGroupName());
        } else {
            dto.setPSThresholdGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getTextPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getTextPSLanResId());
            dto.setTextPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setTextPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getTipPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getTipPSLanResId());
            dto.setTipPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setTipPSLanResName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSTHRESHOLD";
    }

    @Override
    public PSThreshold createDomain() {
        return new PSThreshold();
    }

    @Override
    public PSThresholdDTO createDTO() {
        return new PSThresholdDTO();
    }
}

