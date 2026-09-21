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
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSCtrlLogicGroupDTO;
import net.ibizsys.modelapi.dto.PSDEDRDetailDTO;
import net.ibizsys.modelapi.dto.PSDEDataRelationDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysCounterDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSWFDEDTO;
import net.ibizsys.modelapi.service.IPSDEDataRelationService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEDataRelationServiceImpl
extends PSModelServiceImplBase<PSDEDataRelation, PSDEDataRelationDTO>
implements IPSDEDataRelationService {
    private static final Log log = LogFactory.getLog(PSDEDataRelationServiceImpl.class);

    @Override
    public List<PSDEDataRelation> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEDataRelation get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEDataRelation> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEDataRelation item : list) {
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
    public List<PSDEDataRelationDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEDataRelation> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEDataRelationDTO> dtoList = new ArrayList<PSDEDataRelationDTO>();
            for (PSDEDataRelation item : list) {
                PSDEDataRelationDTO dto = (PSDEDataRelationDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEDataRelation> onListAll() throws Exception {
        ArrayList<PSDEDataRelation> list = new ArrayList<PSDEDataRelation>();
        List psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEDataRelation> items = this.listByPSDataEntity(parent);
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
    protected PSDEDataRelation onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEDataRelation item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEDataRelation)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEDataRelationDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEDataRelation et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSDEDataRelationName())) {
            return et.getPSDEDataRelationName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEDataRelationDTO dto, PSDEDataRelation t, boolean bIgnoreNull) throws Exception {
        List<PSDEDRDetail> list;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEDataRelationId(t.getId().replace("/", "."));
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDRTag() != null || !bIgnoreNull) {
            dto.setDRTag(t.getDRTag());
        }
        if (t.getDRTag2() != null || !bIgnoreNull) {
            dto.setDRTag2(t.getDRTag2());
        }
        if (t.getDRTag3() != null || !bIgnoreNull) {
            dto.setDRTag3(t.getDRTag3());
        }
        if (t.getDRTag4() != null || !bIgnoreNull) {
            dto.setDRTag4(t.getDRTag4());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getFormCapPSLanResId() != null || !bIgnoreNull) {
            dto.setFormCapPSLanResId(t.getFormCapPSLanResId());
        }
        if (t.getFormCapPSLanResName() != null || !bIgnoreNull) {
            dto.setFormCapPSLanResName(t.getFormCapPSLanResName());
        }
        if (t.getFormCaption() != null || !bIgnoreNull) {
            dto.setFormCaption(t.getFormCaption());
        }
        if (t.getFormPSDEViewBaseId() != null || !bIgnoreNull) {
            dto.setFormPSDEViewBaseId(t.getFormPSDEViewBaseId());
        }
        if (t.getFormPSDEViewBaseName() != null || !bIgnoreNull) {
            dto.setFormPSDEViewBaseName(t.getFormPSDEViewBaseName());
        }
        if (t.getFormPSSysImageId() != null || !bIgnoreNull) {
            dto.setFormPSSysImageId(t.getFormPSSysImageId());
        }
        if (t.getFormPSSysImageName() != null || !bIgnoreNull) {
            dto.setFormPSSysImageName(t.getFormPSSysImageName());
        }
        if (t.getHideEditItem() != null || !bIgnoreNull) {
            dto.setHideEditItem(t.getHideEditItem());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSCtrlLogicGroupId() != null || !bIgnoreNull) {
            dto.setPSCtrlLogicGroupId(t.getPSCtrlLogicGroupId());
        }
        if (t.getPSCtrlLogicGroupName() != null || !bIgnoreNull) {
            dto.setPSCtrlLogicGroupName(t.getPSCtrlLogicGroupName());
        }
        if (t.getPSDEDataRelationName() != null || !bIgnoreNull) {
            dto.setPSDEDataRelationName(t.getPSDEDataRelationName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSSysCounterId() != null || !bIgnoreNull) {
            dto.setPSSysCounterId(t.getPSSysCounterId());
        }
        if (t.getPSSysCounterName() != null || !bIgnoreNull) {
            dto.setPSSysCounterName(t.getPSSysCounterName());
        }
        if (t.getPSWFDEId() != null || !bIgnoreNull) {
            dto.setPSWFDEId(t.getPSWFDEId());
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
        if (StringUtils.hasLength((String)dto.getFormCapPSLanResId())) {
            dto.setFormCapPSLanResId(this.getRealPSModelId(t, dto.getFormCapPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getFormPSDEViewBaseId())) {
            dto.setFormPSDEViewBaseId(this.getRealPSModelId(t, dto.getFormPSDEViewBaseId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getFormPSSysImageId())) {
            dto.setFormPSSysImageId(this.getRealPSModelId(t, dto.getFormPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlLogicGroupId())) {
            dto.setPSCtrlLogicGroupId(this.getRealPSModelId(t, dto.getPSCtrlLogicGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCounterId())) {
            dto.setPSSysCounterId(this.getRealPSModelId(t, dto.getPSSysCounterId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFDEId())) {
            dto.setPSWFDEId(this.getRealPSModelId(t, dto.getPSWFDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getFormCapPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getFormCapPSLanResId());
            dto.setFormCapPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setFormCapPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getFormPSDEViewBaseId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getFormPSDEViewBaseId());
            dto.setFormPSDEViewBaseName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setFormPSDEViewBaseName(null);
        }
        if (StringUtils.hasLength((String)dto.getFormPSSysImageId())) {
            linkDTO = (PSSysImageDTO)PSModelServiceUtil.getInstance().getPSSysImageService().getDTO(dto.getFormPSSysImageId());
            dto.setFormPSSysImageName(((PSSysImageDTO)linkDTO).getPSSysImageName());
        } else {
            dto.setFormPSSysImageName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlLogicGroupId())) {
            linkDTO = (PSCtrlLogicGroupDTO)PSModelServiceUtil.getInstance().getPSCtrlLogicGroupService().getDTO(dto.getPSCtrlLogicGroupId());
            dto.setPSCtrlLogicGroupName(((PSCtrlLogicGroupDTO)linkDTO).getPSCtrlLogicGroupName());
        } else {
            dto.setPSCtrlLogicGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysCounterId())) {
            linkDTO = (PSSysCounterDTO)PSModelServiceUtil.getInstance().getPSSysCounterService().getDTO(dto.getPSSysCounterId());
            dto.setPSSysCounterName(((PSSysCounterDTO)linkDTO).getPSSysCounterName());
        } else {
            dto.setPSSysCounterName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFDEId())) {
            linkDTO = (PSWFDEDTO)PSModelServiceUtil.getInstance().getPSWFDEService().getDTO(dto.getPSWFDEId(), true);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSDEDRDetailService().listByPSDEDataRelation(t)) != null && list.size() > 0) {
            ArrayList<PSDEDRDetailDTO> psdedrdetails = new ArrayList<PSDEDRDetailDTO>();
            for (PSDEDRDetail item : list) {
                PSDEDRDetailDTO dstItem = (PSDEDRDetailDTO)PSModelServiceUtil.getInstance().getPSDEDRDetailService().toDTO(item);
                psdedrdetails.add(dstItem);
            }
            dto.setPsdedrdetails(psdedrdetails);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEDATARELATION";
    }

    @Override
    public PSDEDataRelation createDomain() {
        return new PSDEDataRelation();
    }

    @Override
    public PSDEDataRelationDTO createDTO() {
        return new PSDEDataRelationDTO();
    }
}

