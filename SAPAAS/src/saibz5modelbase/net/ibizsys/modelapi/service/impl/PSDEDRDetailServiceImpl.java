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
import net.ibizsys.modelapi.domain.PSDEDRDetail;
import net.ibizsys.modelapi.domain.PSDEDataRelation;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEDRDetailDTO;
import net.ibizsys.modelapi.dto.PSDEDRGroupDTO;
import net.ibizsys.modelapi.dto.PSDEDRItemDTO;
import net.ibizsys.modelapi.dto.PSDEDataRelationDTO;
import net.ibizsys.modelapi.dto.PSDEOPPrivDTO;
import net.ibizsys.modelapi.dto.PSDETreeViewDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysPDTViewDTO;
import net.ibizsys.modelapi.service.IPSDEDRDetailService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEDRDetailServiceImpl
extends PSModelServiceImplBase<PSDEDRDetail, PSDEDRDetailDTO>
implements IPSDEDRDetailService {
    private static final Log log = LogFactory.getLog(PSDEDRDetailServiceImpl.class);

    @Override
    public List<PSDEDRDetail> listByPSDEDataRelation(PSDEDataRelation parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEDRDetail get(PSDEDataRelation parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEDRDetail> list = this.listByPSDEDataRelation(parent);
        if (list != null) {
            for (PSDEDRDetail item : list) {
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
    public List<PSDEDRDetailDTO> listDTOByPSDEDataRelation(String strParentKey) throws Exception {
        PSDEDataRelation psdedatarelation = (PSDEDataRelation)PSModelServiceUtil.getInstance().getPSDEDataRelationService().get(strParentKey);
        List<PSDEDRDetail> list = this.listByPSDEDataRelation(psdedatarelation);
        if (list != null) {
            ArrayList<PSDEDRDetailDTO> dtoList = new ArrayList<PSDEDRDetailDTO>();
            for (PSDEDRDetail item : list) {
                PSDEDRDetailDTO dto = (PSDEDRDetailDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEDRDetail> onListAll() throws Exception {
        ArrayList<PSDEDRDetail> list = new ArrayList<PSDEDRDetail>();
        List psdedatarelations = PSModelServiceUtil.getInstance().getPSDEDataRelationService().listAll();
        if (psdedatarelations != null) {
            for (PSDEDataRelation parent : psdedatarelations) {
                List<PSDEDRDetail> items = this.listByPSDEDataRelation(parent);
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
    protected PSDEDRDetail onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEDRDetail item;
        PSDEDataRelation psdedatarelation = (PSDEDataRelation)PSModelServiceUtil.getInstance().getPSDEDataRelationService().get(strParentKey, true);
        if (psdedatarelation != null && (item = this.get(psdedatarelation, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEDRDetail)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEDRDetailDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEDRId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEDataRelationService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEDRDetail et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEDRDetailName())) {
            return et.getPSDEDRDetailName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEDRDetailDTO dto, PSDEDRDetail t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEDRDetailId(t.getId().replace("/", "."));
        }
        if (t.getCapPSLanResId() != null || !bIgnoreNull) {
            dto.setCapPSLanResId(t.getCapPSLanResId());
        }
        if (t.getCapPSLanResName() != null || !bIgnoreNull) {
            dto.setCapPSLanResName(t.getCapPSLanResName());
        }
        if (t.getCaption() != null || !bIgnoreNull) {
            dto.setCaption(t.getCaption());
        }
        if (t.getCounterId() != null || !bIgnoreNull) {
            dto.setCounterId(t.getCounterId());
        }
        if (t.getCounterMode() != null || !bIgnoreNull) {
            dto.setCounterMode(t.getCounterMode());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDetailType() != null || !bIgnoreNull) {
            dto.setDetailType(t.getDetailType());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getEnableMode() != null || !bIgnoreNull) {
            dto.setEnableMode(t.getEnableMode());
        }
        if (t.getGroupOrderValue() != null || !bIgnoreNull) {
            dto.setGroupOrderValue(t.getGroupOrderValue());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDEDRDetailName() != null || !bIgnoreNull) {
            dto.setPSDEDRDetailName(t.getPSDEDRDetailName());
        }
        if (t.getPSDEDRGroupId() != null || !bIgnoreNull) {
            dto.setPSDEDRGroupId(t.getPSDEDRGroupId());
        }
        if (t.getPSDEDRGroupName() != null || !bIgnoreNull) {
            dto.setPSDEDRGroupName(t.getPSDEDRGroupName());
        }
        if (t.getPSDEDRId() != null || !bIgnoreNull) {
            dto.setPSDEDRId(t.getPSDEDRId());
        }
        if (t.getPSDEDRItemId() != null || !bIgnoreNull) {
            dto.setPSDEDRItemId(t.getPSDEDRItemId());
        }
        if (t.getPSDEDRItemName() != null || !bIgnoreNull) {
            dto.setPSDEDRItemName(t.getPSDEDRItemName());
        }
        if (t.getPSDEDRName() != null || !bIgnoreNull) {
            dto.setPSDEDRName(t.getPSDEDRName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setPSDEOPPrivId(t.getPSDEOPPrivId());
        }
        if (t.getPSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setPSDEOPPrivName(t.getPSDEOPPrivName());
        }
        if (t.getPSDETreeViewId() != null || !bIgnoreNull) {
            dto.setPSDETreeViewId(t.getPSDETreeViewId());
        }
        if (t.getPSDETreeViewName() != null || !bIgnoreNull) {
            dto.setPSDETreeViewName(t.getPSDETreeViewName());
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
        if (t.getPSSysPDTViewId() != null || !bIgnoreNull) {
            dto.setPSSysPDTViewId(t.getPSSysPDTViewId());
        }
        if (t.getPSSysPDTViewName() != null || !bIgnoreNull) {
            dto.setPSSysPDTViewName(t.getPSSysPDTViewName());
        }
        if (t.getTestCustomCode() != null || !bIgnoreNull) {
            dto.setTestCustomCode(t.getTestCustomCode());
        }
        if (t.getTestCustomMode() != null || !bIgnoreNull) {
            dto.setTestCustomMode(t.getTestCustomMode());
        }
        if (t.getTestPSDEActionId() != null || !bIgnoreNull) {
            dto.setTestPSDEActionId(t.getTestPSDEActionId());
        }
        if (t.getTestPSDEActionName() != null || !bIgnoreNull) {
            dto.setTestPSDEActionName(t.getTestPSDEActionName());
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
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            dto.setCapPSLanResId(this.getRealPSModelId(t, dto.getCapPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDRGroupId())) {
            dto.setPSDEDRGroupId(this.getRealPSModelId(t, dto.getPSDEDRGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDRId())) {
            dto.setPSDEDRId(this.getRealPSModelId(t, dto.getPSDEDRId()).replace("/", "."));
        }
        if ("PSDEDATARELATION".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEDRId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDRItemId())) {
            dto.setPSDEDRItemId(this.getRealPSModelId(t, dto.getPSDEDRItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEOPPrivId())) {
            dto.setPSDEOPPrivId(this.getRealPSModelId(t, dto.getPSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDETreeViewId())) {
            dto.setPSDETreeViewId(this.getRealPSModelId(t, dto.getPSDETreeViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            dto.setPSSysCssId(this.getRealPSModelId(t, dto.getPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            dto.setPSSysImageId(this.getRealPSModelId(t, dto.getPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPDTViewId())) {
            dto.setPSSysPDTViewId(this.getRealPSModelId(t, dto.getPSSysPDTViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTestPSDEActionId())) {
            dto.setTestPSDEActionId(this.getRealPSModelId(t, dto.getTestPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTipPSLanResId())) {
            dto.setTipPSLanResId(this.getRealPSModelId(t, dto.getTipPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getCapPSLanResId());
            dto.setCapPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setCapPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDRGroupId())) {
            linkDTO = (PSDEDRGroupDTO)PSModelServiceUtil.getInstance().getPSDEDRGroupService().getDTO(dto.getPSDEDRGroupId());
            dto.setGroupOrderValue(((PSDEDRGroupDTO)linkDTO).getOrderValue());
            dto.setPSDEDRGroupName(((PSDEDRGroupDTO)linkDTO).getPSDEDRGroupName());
        } else {
            dto.setGroupOrderValue(null);
            dto.setPSDEDRGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDRId())) {
            linkDTO = (PSDEDataRelationDTO)PSModelServiceUtil.getInstance().getPSDEDataRelationService().getDTO(dto.getPSDEDRId());
            dto.setPSDEDRName(((PSDEDataRelationDTO)linkDTO).getPSDEDataRelationName());
            dto.setPSDEId(((PSDEDataRelationDTO)linkDTO).getPSDEId());
        } else {
            dto.setPSDEDRName(null);
            dto.setPSDEId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDRItemId())) {
            linkDTO = (PSDEDRItemDTO)PSModelServiceUtil.getInstance().getPSDEDRItemService().getDTO(dto.getPSDEDRItemId());
            dto.setPSDEDRItemName(((PSDEDRItemDTO)linkDTO).getPSDEDRItemName());
        } else {
            dto.setPSDEDRItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getPSDEOPPrivId());
            dto.setPSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setPSDEOPPrivName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDETreeViewId())) {
            linkDTO = (PSDETreeViewDTO)PSModelServiceUtil.getInstance().getPSDETreeViewService().getDTO(dto.getPSDETreeViewId());
            dto.setPSDETreeViewName(((PSDETreeViewDTO)linkDTO).getPSDETreeViewName());
        } else {
            dto.setPSDETreeViewName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysPDTViewId())) {
            linkDTO = (PSSysPDTViewDTO)PSModelServiceUtil.getInstance().getPSSysPDTViewService().getDTO(dto.getPSSysPDTViewId());
            dto.setPSSysPDTViewName(((PSSysPDTViewDTO)linkDTO).getPSSysPDTViewName());
        } else {
            dto.setPSSysPDTViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getTestPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getTestPSDEActionId());
            dto.setTestPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setTestPSDEActionName(null);
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
        return "PSDEDRDETAIL";
    }

    @Override
    public PSDEDRDetail createDomain() {
        return new PSDEDRDetail();
    }

    @Override
    public PSDEDRDetailDTO createDTO() {
        return new PSDEDRDetailDTO();
    }
}

