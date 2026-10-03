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
import net.ibizsys.modelapi.domain.PSDEMSAction;
import net.ibizsys.modelapi.domain.PSDEMSOPPriv;
import net.ibizsys.modelapi.domain.PSDEMainState;
import net.ibizsys.modelapi.domain.PSDEMainStateRS;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEDataQueryDTO;
import net.ibizsys.modelapi.dto.PSDEFormDTO;
import net.ibizsys.modelapi.dto.PSDEMSActionDTO;
import net.ibizsys.modelapi.dto.PSDEMSOPPrivDTO;
import net.ibizsys.modelapi.dto.PSDEMainStateDTO;
import net.ibizsys.modelapi.dto.PSDEMainStateRSDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.service.IPSDEMainStateService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEMainStateServiceImpl
extends PSModelServiceImplBase<PSDEMainState, PSDEMainStateDTO>
implements IPSDEMainStateService {
    private static final Log log = LogFactory.getLog(PSDEMainStateServiceImpl.class);

    @Override
    public List<PSDEMainState> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEMainState get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEMainState> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEMainState item : list) {
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
    public List<PSDEMainStateDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEMainState> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEMainStateDTO> dtoList = new ArrayList<PSDEMainStateDTO>();
            for (PSDEMainState item : list) {
                PSDEMainStateDTO dto = (PSDEMainStateDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEMainState> onListAll() throws Exception {
        ArrayList<PSDEMainState> list = new ArrayList<PSDEMainState>();
        List<PSDataEntity> psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEMainState> items = this.listByPSDataEntity(parent);
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
    protected PSDEMainState onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEMainState item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEMainState)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEMainStateDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEMainState et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEMainStateName())) {
            return et.getPSDEMainStateName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEMainStateDTO dto, PSDEMainState t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEMainStateId(t.getId().replace("/", "."));
        }
        if (t.getAllowMode() != null || !bIgnoreNull) {
            dto.setAllowMode(t.getAllowMode());
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
        if (t.getDEActionDenyMsg() != null || !bIgnoreNull) {
            dto.setDEActionDenyMsg(t.getDEActionDenyMsg());
        }
        if (t.getDEActionDMPSLanResId() != null || !bIgnoreNull) {
            dto.setDEActionDMPSLanResId(t.getDEActionDMPSLanResId());
        }
        if (t.getDEActionDMPSLanResName() != null || !bIgnoreNull) {
            dto.setDEActionDMPSLanResName(t.getDEActionDMPSLanResName());
        }
        if (t.getDefaultMode() != null || !bIgnoreNull) {
            dto.setDefaultMode(t.getDefaultMode());
        }
        if (t.getDEOPPrivDenyMsg() != null || !bIgnoreNull) {
            dto.setDEOPPrivDenyMsg(t.getDEOPPrivDenyMsg());
        }
        if (t.getDEOPPrivDMPSLanResId() != null || !bIgnoreNull) {
            dto.setDEOPPrivDMPSLanResId(t.getDEOPPrivDMPSLanResId());
        }
        if (t.getDEOPPrivDMPSLanResName() != null || !bIgnoreNull) {
            dto.setDEOPPrivDMPSLanResName(t.getDEOPPrivDMPSLanResName());
        }
        if (t.getEditViewType() != null || !bIgnoreNull) {
            dto.setEditViewType(t.getEditViewType());
        }
        if (t.getEnableViewActions() != null || !bIgnoreNull) {
            dto.setEnableViewActions(t.getEnableViewActions());
        }
        if (t.getEnterPSDEActionId() != null || !bIgnoreNull) {
            dto.setEnterPSDEActionId(t.getEnterPSDEActionId());
        }
        if (t.getEnterPSDEActionName() != null || !bIgnoreNull) {
            dto.setEnterPSDEActionName(t.getEnterPSDEActionName());
        }
        if (t.getEnterStateMode() != null || !bIgnoreNull) {
            dto.setEnterStateMode(t.getEnterStateMode());
        }
        if (t.getFieldAllowMode() != null || !bIgnoreNull) {
            dto.setFieldAllowMode(t.getFieldAllowMode());
        }
        if (t.getFormCodeName() != null || !bIgnoreNull) {
            dto.setFormCodeName(t.getFormCodeName());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMobEditViewType() != null || !bIgnoreNull) {
            dto.setMobEditViewType(t.getMobEditViewType());
        }
        if (t.getMobFormCodeName() != null || !bIgnoreNull) {
            dto.setMobFormCodeName(t.getMobFormCodeName());
        }
        if (t.getMobPSDEFormId() != null || !bIgnoreNull) {
            dto.setMobPSDEFormId(t.getMobPSDEFormId());
        }
        if (t.getMobPSDEFormName() != null || !bIgnoreNull) {
            dto.setMobPSDEFormName(t.getMobPSDEFormName());
        }
        if (t.getMobQuickFormCodeName() != null || !bIgnoreNull) {
            dto.setMobQuickFormCodeName(t.getMobQuickFormCodeName());
        }
        if (t.getMobQuickPSDEFormId() != null || !bIgnoreNull) {
            dto.setMobQuickPSDEFormId(t.getMobQuickPSDEFormId());
        }
        if (t.getMobQuickPSDEFormName() != null || !bIgnoreNull) {
            dto.setMobQuickPSDEFormName(t.getMobQuickPSDEFormName());
        }
        if (t.getMobUtilFormCodeName() != null || !bIgnoreNull) {
            dto.setMobUtilFormCodeName(t.getMobUtilFormCodeName());
        }
        if (t.getMobUtilPSDEFormId() != null || !bIgnoreNull) {
            dto.setMobUtilPSDEFormId(t.getMobUtilPSDEFormId());
        }
        if (t.getMobUtilPSDEFormName() != null || !bIgnoreNull) {
            dto.setMobUtilPSDEFormName(t.getMobUtilPSDEFormName());
        }
        if (t.getMSTag() != null || !bIgnoreNull) {
            dto.setMSTag(t.getMSTag());
        }
        if (t.getMSValue() != null || !bIgnoreNull) {
            dto.setMSValue(t.getMSValue());
        }
        if (t.getMSValue2() != null || !bIgnoreNull) {
            dto.setMSValue2(t.getMSValue2());
        }
        if (t.getMSValue2Text() != null || !bIgnoreNull) {
            dto.setMSValue2Text(t.getMSValue2Text());
        }
        if (t.getMSValue3() != null || !bIgnoreNull) {
            dto.setMSValue3(t.getMSValue3());
        }
        if (t.getMSValue3Text() != null || !bIgnoreNull) {
            dto.setMSValue3Text(t.getMSValue3Text());
        }
        if (t.getMSValueText() != null || !bIgnoreNull) {
            dto.setMSValueText(t.getMSValueText());
        }
        if (t.getOPPrivAllowMode() != null || !bIgnoreNull) {
            dto.setOPPrivAllowMode(t.getOPPrivAllowMode());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDEDQId() != null || !bIgnoreNull) {
            dto.setPSDEDQId(t.getPSDEDQId());
        }
        if (t.getPSDEDQName() != null || !bIgnoreNull) {
            dto.setPSDEDQName(t.getPSDEDQName());
        }
        if (t.getPSDEFormId() != null || !bIgnoreNull) {
            dto.setPSDEFormId(t.getPSDEFormId());
        }
        if (t.getPSDEFormName() != null || !bIgnoreNull) {
            dto.setPSDEFormName(t.getPSDEFormName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEMainStateName() != null || !bIgnoreNull) {
            dto.setPSDEMainStateName(t.getPSDEMainStateName());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSSysCssId() != null || !bIgnoreNull) {
            dto.setPSSysCssId(t.getPSSysCssId());
        }
        if (t.getPSSysCssName() != null || !bIgnoreNull) {
            dto.setPSSysCssName(t.getPSSysCssName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSysImageId() != null || !bIgnoreNull) {
            dto.setPSSysImageId(t.getPSSysImageId());
        }
        if (t.getPSSysImageName() != null || !bIgnoreNull) {
            dto.setPSSysImageName(t.getPSSysImageName());
        }
        if (t.getQuickFormCodeName() != null || !bIgnoreNull) {
            dto.setQuickFormCodeName(t.getQuickFormCodeName());
        }
        if (t.getQuickPSDEFormId() != null || !bIgnoreNull) {
            dto.setQuickPSDEFormId(t.getQuickPSDEFormId());
        }
        if (t.getQuickPSDEFormName() != null || !bIgnoreNull) {
            dto.setQuickPSDEFormName(t.getQuickPSDEFormName());
        }
        if (t.getTextPSLanResId() != null || !bIgnoreNull) {
            dto.setTextPSLanResId(t.getTextPSLanResId());
        }
        if (t.getTextPSLanResName() != null || !bIgnoreNull) {
            dto.setTextPSLanResName(t.getTextPSLanResName());
        }
        if (t.getTipPSLanResId() != null || !bIgnoreNull) {
            dto.setTipPSLanResId(t.getTipPSLanResId());
        }
        if (t.getTipPSLanResName() != null || !bIgnoreNull) {
            dto.setTipPSLanResName(t.getTipPSLanResName());
        }
        if (t.getToDoTask() != null || !bIgnoreNull) {
            dto.setToDoTask(t.getToDoTask());
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
        if (t.getUtilFormCodeName() != null || !bIgnoreNull) {
            dto.setUtilFormCodeName(t.getUtilFormCodeName());
        }
        if (t.getUtilPSDEFormId() != null || !bIgnoreNull) {
            dto.setUtilPSDEFormId(t.getUtilPSDEFormId());
        }
        if (t.getUtilPSDEFormName() != null || !bIgnoreNull) {
            dto.setUtilPSDEFormName(t.getUtilPSDEFormName());
        }
        if (t.getViewActions() != null || !bIgnoreNull) {
            dto.setViewActions(t.getViewActions());
        }
        if (t.getWFStateMode() != null || !bIgnoreNull) {
            dto.setWFStateMode(t.getWFStateMode());
        }
        if (StringUtils.hasLength((String)dto.getDEActionDMPSLanResId())) {
            dto.setDEActionDMPSLanResId(this.getRealPSModelId(t, dto.getDEActionDMPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDEOPPrivDMPSLanResId())) {
            dto.setDEOPPrivDMPSLanResId(this.getRealPSModelId(t, dto.getDEOPPrivDMPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getEnterPSDEActionId())) {
            dto.setEnterPSDEActionId(this.getRealPSModelId(t, dto.getEnterPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMobPSDEFormId())) {
            dto.setMobPSDEFormId(this.getRealPSModelId(t, dto.getMobPSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMobQuickPSDEFormId())) {
            dto.setMobQuickPSDEFormId(this.getRealPSModelId(t, dto.getMobQuickPSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMobUtilPSDEFormId())) {
            dto.setMobUtilPSDEFormId(this.getRealPSModelId(t, dto.getMobUtilPSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDQId())) {
            dto.setPSDEDQId(this.getRealPSModelId(t, dto.getPSDEDQId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            dto.setPSDEFormId(this.getRealPSModelId(t, dto.getPSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            dto.setPSSysCssId(this.getRealPSModelId(t, dto.getPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            dto.setPSSysImageId(this.getRealPSModelId(t, dto.getPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getQuickPSDEFormId())) {
            dto.setQuickPSDEFormId(this.getRealPSModelId(t, dto.getQuickPSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTextPSLanResId())) {
            dto.setTextPSLanResId(this.getRealPSModelId(t, dto.getTextPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTipPSLanResId())) {
            dto.setTipPSLanResId(this.getRealPSModelId(t, dto.getTipPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDEFormId())) {
            dto.setUtilPSDEFormId(this.getRealPSModelId(t, dto.getUtilPSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDEActionDMPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getDEActionDMPSLanResId());
            dto.setDEActionDMPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setDEActionDMPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getDEOPPrivDMPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getDEOPPrivDMPSLanResId());
            dto.setDEOPPrivDMPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setDEOPPrivDMPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getEnterPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getEnterPSDEActionId());
            dto.setEnterPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setEnterPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getMobPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getMobPSDEFormId());
            dto.setMobFormCodeName(((PSDEFormDTO)linkDTO).getCodeName());
            dto.setMobPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setMobFormCodeName(null);
            dto.setMobPSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getMobQuickPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getMobQuickPSDEFormId());
            dto.setMobQuickFormCodeName(((PSDEFormDTO)linkDTO).getCodeName());
            dto.setMobQuickPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setMobQuickFormCodeName(null);
            dto.setMobQuickPSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getMobUtilPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getMobUtilPSDEFormId());
            dto.setMobUtilFormCodeName(((PSDEFormDTO)linkDTO).getCodeName());
            dto.setMobUtilPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setMobUtilFormCodeName(null);
            dto.setMobUtilPSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDQId())) {
            linkDTO = (PSDEDataQueryDTO)PSModelServiceUtil.getInstance().getPSDEDataQueryService().getDTO(dto.getPSDEDQId());
            dto.setPSDEDQName(((PSDEDataQueryDTO)linkDTO).getPSDEDataQueryName());
        } else {
            dto.setPSDEDQName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getPSDEFormId());
            dto.setFormCodeName(((PSDEFormDTO)linkDTO).getCodeName());
            dto.setPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setFormCodeName(null);
            dto.setPSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getPSSysCssId());
            dto.setPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            linkDTO = (PSSysImageDTO)PSModelServiceUtil.getInstance().getPSSysImageService().getDTO(dto.getPSSysImageId());
            dto.setPSSysImageName(((PSSysImageDTO)linkDTO).getPSSysImageName());
        } else {
            dto.setPSSysImageName(null);
        }
        if (StringUtils.hasLength((String)dto.getQuickPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getQuickPSDEFormId());
            dto.setQuickFormCodeName(((PSDEFormDTO)linkDTO).getCodeName());
            dto.setQuickPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setQuickFormCodeName(null);
            dto.setQuickPSDEFormName(null);
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
        if (StringUtils.hasLength((String)dto.getUtilPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getUtilPSDEFormId());
            dto.setUtilFormCodeName(((PSDEFormDTO)linkDTO).getCodeName());
            dto.setUtilPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setUtilFormCodeName(null);
            dto.setUtilPSDEFormName(null);
        }
        List<PSDEMSOPPriv> pSDEMSOPPrivList = PSModelServiceUtil.getInstance().getPSDEMSOPPrivService().listByPSDEMainState(t);
        if (pSDEMSOPPrivList != null && pSDEMSOPPrivList.size() > 0) {
            ArrayList<PSDEMSOPPrivDTO> psdemsopprivs = new ArrayList<PSDEMSOPPrivDTO>();
            for (PSDEMSOPPriv pSDEMSOPPriv : pSDEMSOPPrivList) {
                dstItem = (PSDEMSOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEMSOPPrivService().toDTO(pSDEMSOPPriv);
                psdemsopprivs.add((PSDEMSOPPrivDTO)dstItem);
            }
            dto.setPsdemsopprivs(psdemsopprivs);
        }
        List<PSDEMSAction> pSDEMSActionList = PSModelServiceUtil.getInstance().getPSDEMSActionService().listByPSDEMainState(t);
        if (pSDEMSActionList != null && pSDEMSActionList.size() > 0) {
            ArrayList<PSDEMSActionDTO> psdemsactions = new ArrayList<PSDEMSActionDTO>();
            for (PSDEMSAction pSDEMSAction : pSDEMSActionList) {
                dstItem = (PSDEMSActionDTO)PSModelServiceUtil.getInstance().getPSDEMSActionService().toDTO(pSDEMSAction);
                psdemsactions.add((PSDEMSActionDTO)dstItem);
            }
            dto.setPsdemsactions(psdemsactions);
        }
        List<PSDEMainStateRS> pSDEMainStateRSList = PSModelServiceUtil.getInstance().getPSDEMainStateRSService().listByPSDEMainState(t);
        if (pSDEMainStateRSList != null && pSDEMainStateRSList.size() > 0) {
            ArrayList<PSDEMainStateRSDTO> psdemainstaters = new ArrayList<PSDEMainStateRSDTO>();
            for (PSDEMainStateRS pSDEMainStateRS : pSDEMainStateRSList) {
                dstItem = (PSDEMainStateRSDTO)PSModelServiceUtil.getInstance().getPSDEMainStateRSService().toDTO(pSDEMainStateRS);
                psdemainstaters.add((PSDEMainStateRSDTO)dstItem);
            }
            dto.setPsdemainstaters(psdemainstaters);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEMAINSTATE";
    }

    @Override
    public PSDEMainState createDomain() {
        return new PSDEMainState();
    }

    @Override
    public PSDEMainStateDTO createDTO() {
        return new PSDEMainStateDTO();
    }
}

