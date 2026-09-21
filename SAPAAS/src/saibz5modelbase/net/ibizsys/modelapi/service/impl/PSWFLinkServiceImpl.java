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
import net.ibizsys.modelapi.domain.PSWFLink;
import net.ibizsys.modelapi.domain.PSWFLinkCond;
import net.ibizsys.modelapi.domain.PSWFLinkRole;
import net.ibizsys.modelapi.domain.PSWFVersion;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSDEFormDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSWFLinkCondDTO;
import net.ibizsys.modelapi.dto.PSWFLinkDTO;
import net.ibizsys.modelapi.dto.PSWFLinkRoleDTO;
import net.ibizsys.modelapi.dto.PSWFProcessDTO;
import net.ibizsys.modelapi.dto.PSWFRoleDTO;
import net.ibizsys.modelapi.dto.PSWFVersionDTO;
import net.ibizsys.modelapi.dto.PSWorkflowDTO;
import net.ibizsys.modelapi.service.IPSWFLinkService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSWFLinkServiceImpl
extends PSModelServiceImplBase<PSWFLink, PSWFLinkDTO>
implements IPSWFLinkService {
    private static final Log log = LogFactory.getLog(PSWFLinkServiceImpl.class);

    @Override
    public List<PSWFLink> listByPSWFVersion(PSWFVersion parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWFLink get(PSWFVersion parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWFLink> list = this.listByPSWFVersion(parent);
        if (list != null) {
            for (PSWFLink item : list) {
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
    public List<PSWFLinkDTO> listDTOByPSWFVersion(String strParentKey) throws Exception {
        PSWFVersion pswfversion = (PSWFVersion)PSModelServiceUtil.getInstance().getPSWFVersionService().get(strParentKey);
        List<PSWFLink> list = this.listByPSWFVersion(pswfversion);
        if (list != null) {
            ArrayList<PSWFLinkDTO> dtoList = new ArrayList<PSWFLinkDTO>();
            for (PSWFLink item : list) {
                PSWFLinkDTO dto = (PSWFLinkDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSWFLink> onListAll() throws Exception {
        ArrayList<PSWFLink> list = new ArrayList<PSWFLink>();
        List pswfversions = PSModelServiceUtil.getInstance().getPSWFVersionService().listAll();
        if (pswfversions != null) {
            for (PSWFVersion parent : pswfversions) {
                List<PSWFLink> items = this.listByPSWFVersion(parent);
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
    protected PSWFLink onGet(String strParentKey, String strCurKey) throws Exception {
        PSWFLink item;
        PSWFVersion pswfversion = (PSWFVersion)PSModelServiceUtil.getInstance().getPSWFVersionService().get(strParentKey, true);
        if (pswfversion != null && (item = this.get(pswfversion, strCurKey, true)) != null) {
            return item;
        }
        return (PSWFLink)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSWFLinkDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSWFVersionId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWFVersionService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSWFLink et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSWFLinkDTO dto, PSWFLink t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSWFLinkId(t.getId().replace("/", "."));
        }
        if (t.getActionField() != null || !bIgnoreNull) {
            dto.setActionField(t.getActionField());
        }
        if (t.getActionPSCodeListId() != null || !bIgnoreNull) {
            dto.setActionPSCodeListId(t.getActionPSCodeListId());
        }
        if (t.getActionPSCodeListName() != null || !bIgnoreNull) {
            dto.setActionPSCodeListName(t.getActionPSCodeListName());
        }
        if (t.getActorFields() != null || !bIgnoreNull) {
            dto.setActorFields(t.getActorFields());
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
        if (t.getCustomCond() != null || !bIgnoreNull) {
            dto.setCustomCond(t.getCustomCond());
        }
        if (t.getCustomCondFlag() != null || !bIgnoreNull) {
            dto.setCustomCondFlag(t.getCustomCondFlag());
        }
        if (t.getDefaultLink() != null || !bIgnoreNull) {
            dto.setDefaultLink(t.getDefaultLink());
        }
        if (t.getDstEndPoint() != null || !bIgnoreNull) {
            dto.setDstEndPoint(t.getDstEndPoint());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getEnable() != null || !bIgnoreNull) {
            dto.setEnable(t.getEnable());
        }
        if (t.getEnableMobile() != null || !bIgnoreNull) {
            dto.setEnableMobile(t.getEnableMobile());
        }
        if (t.getFormCodeName() != null || !bIgnoreNull) {
            dto.setFormCodeName(t.getFormCodeName());
        }
        if (t.getFromPSWFProcId() != null || !bIgnoreNull) {
            dto.setFromPSWFProcId(t.getFromPSWFProcId());
        }
        if (t.getFromPSWFProcName() != null || !bIgnoreNull) {
            dto.setFromPSWFProcName(t.getFromPSWFProcName());
        }
        if (t.getLabel() != null || !bIgnoreNull) {
            dto.setLabel(t.getLabel());
        }
        if (t.getLNPSLanResId() != null || !bIgnoreNull) {
            dto.setLNPSLanResId(t.getLNPSLanResId());
        }
        if (t.getLNPSLanResName() != null || !bIgnoreNull) {
            dto.setLNPSLanResName(t.getLNPSLanResName());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMemoField() != null || !bIgnoreNull) {
            dto.setMemoField(t.getMemoField());
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
        if (t.getMobPSDEViewId() != null || !bIgnoreNull) {
            dto.setMobPSDEViewId(t.getMobPSDEViewId());
        }
        if (t.getMobPSDEViewName() != null || !bIgnoreNull) {
            dto.setMobPSDEViewName(t.getMobPSDEViewName());
        }
        if (t.getMobViewCodeName() != null || !bIgnoreNull) {
            dto.setMobViewCodeName(t.getMobViewCodeName());
        }
        if (t.getModelId() != null || !bIgnoreNull) {
            dto.setModelId(t.getModelId());
        }
        if (t.getNextCond() != null || !bIgnoreNull) {
            dto.setNextCond(t.getNextCond());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
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
        if (t.getPSDEViewBaseId() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseId(t.getPSDEViewBaseId());
        }
        if (t.getPSDEViewBaseName() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseName(t.getPSDEViewBaseName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSWFDEId() != null || !bIgnoreNull) {
            dto.setPSWFDEId(t.getPSWFDEId());
        }
        if (t.getPSWFId() != null || !bIgnoreNull) {
            dto.setPSWFId(t.getPSWFId());
        }
        if (t.getPSWFLinkName() != null || !bIgnoreNull) {
            dto.setPSWFLinkName(t.getPSWFLinkName());
        }
        if (t.getPSWFName() != null || !bIgnoreNull) {
            dto.setPSWFName(t.getPSWFName());
        }
        if (t.getPSWFRoleId() != null || !bIgnoreNull) {
            dto.setPSWFRoleId(t.getPSWFRoleId());
        }
        if (t.getPSWFRoleName() != null || !bIgnoreNull) {
            dto.setPSWFRoleName(t.getPSWFRoleName());
        }
        if (t.getPSWFVersionId() != null || !bIgnoreNull) {
            dto.setPSWFVersionId(t.getPSWFVersionId());
        }
        if (t.getPSWFVersionName() != null || !bIgnoreNull) {
            dto.setPSWFVersionName(t.getPSWFVersionName());
        }
        if (t.getShapeParams() != null || !bIgnoreNull) {
            dto.setShapeParams(t.getShapeParams());
        }
        if (t.getSomeRoleFlag() != null || !bIgnoreNull) {
            dto.setSomeRoleFlag(t.getSomeRoleFlag());
        }
        if (t.getSrcEndPoint() != null || !bIgnoreNull) {
            dto.setSrcEndPoint(t.getSrcEndPoint());
        }
        if (t.getThreadFlag() != null || !bIgnoreNull) {
            dto.setThreadFlag(t.getThreadFlag());
        }
        if (t.getThreadName() != null || !bIgnoreNull) {
            dto.setThreadName(t.getThreadName());
        }
        if (t.getTipPSLanResId() != null || !bIgnoreNull) {
            dto.setTipPSLanResId(t.getTipPSLanResId());
        }
        if (t.getTipPSLanResName() != null || !bIgnoreNull) {
            dto.setTipPSLanResName(t.getTipPSLanResName());
        }
        if (t.getToPSWFProcId() != null || !bIgnoreNull) {
            dto.setToPSWFProcId(t.getToPSWFProcId());
        }
        if (t.getToPSWFProcName() != null || !bIgnoreNull) {
            dto.setToPSWFProcName(t.getToPSWFProcName());
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
        if (t.getUserData() != null || !bIgnoreNull) {
            dto.setUserData(t.getUserData());
        }
        if (t.getUserData2() != null || !bIgnoreNull) {
            dto.setUserData2(t.getUserData2());
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
        if (t.getViewCodeName() != null || !bIgnoreNull) {
            dto.setViewCodeName(t.getViewCodeName());
        }
        if (t.getWFEngineType() != null || !bIgnoreNull) {
            dto.setWFEngineType(t.getWFEngineType());
        }
        if (t.getWFLinkType() != null || !bIgnoreNull) {
            dto.setWFLinkType(t.getWFLinkType());
        }
        if (StringUtils.hasLength((String)dto.getActionPSCodeListId())) {
            dto.setActionPSCodeListId(this.getRealPSModelId(t, dto.getActionPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getFromPSWFProcId())) {
            dto.setFromPSWFProcId(this.getRealPSModelId(t, dto.getFromPSWFProcId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLNPSLanResId())) {
            dto.setLNPSLanResId(this.getRealPSModelId(t, dto.getLNPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMobPSDEFormId())) {
            dto.setMobPSDEFormId(this.getRealPSModelId(t, dto.getMobPSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMobPSDEViewId())) {
            dto.setMobPSDEViewId(this.getRealPSModelId(t, dto.getMobPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            dto.setPSDEFormId(this.getRealPSModelId(t, dto.getPSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            dto.setPSDEViewBaseId(this.getRealPSModelId(t, dto.getPSDEViewBaseId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFId())) {
            dto.setPSWFId(this.getRealPSModelId(t, dto.getPSWFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFRoleId())) {
            dto.setPSWFRoleId(this.getRealPSModelId(t, dto.getPSWFRoleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFVersionId())) {
            dto.setPSWFVersionId(this.getRealPSModelId(t, dto.getPSWFVersionId()).replace("/", "."));
        }
        if ("PSWFVERSION".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWFVersionId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTipPSLanResId())) {
            dto.setTipPSLanResId(this.getRealPSModelId(t, dto.getTipPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getToPSWFProcId())) {
            dto.setToPSWFProcId(this.getRealPSModelId(t, dto.getToPSWFProcId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getActionPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getActionPSCodeListId());
            dto.setActionPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setActionPSCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getFromPSWFProcId())) {
            linkDTO = (PSWFProcessDTO)PSModelServiceUtil.getInstance().getPSWFProcessService().getDTO(dto.getFromPSWFProcId());
            dto.setFromPSWFProcName(((PSWFProcessDTO)linkDTO).getPSWFProcessName());
            dto.setPSDEId(((PSWFProcessDTO)linkDTO).getPSDEId());
            dto.setPSWFDEId(((PSWFProcessDTO)linkDTO).getPSWFDEId());
        } else {
            dto.setFromPSWFProcName(null);
            dto.setPSDEId(null);
            dto.setPSWFDEId(null);
        }
        if (StringUtils.hasLength((String)dto.getLNPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getLNPSLanResId());
            dto.setLNPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setLNPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getMobPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getMobPSDEFormId());
            dto.setMobFormCodeName(((PSDEFormDTO)linkDTO).getCodeName());
            dto.setMobPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setMobFormCodeName(null);
            dto.setMobPSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getMobPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getMobPSDEViewId());
            dto.setMobPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
            dto.setMobViewCodeName(((PSDEViewBaseDTO)linkDTO).getCodeName());
        } else {
            dto.setMobPSDEViewName(null);
            dto.setMobViewCodeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getPSDEFormId());
            dto.setFormCodeName(((PSDEFormDTO)linkDTO).getCodeName());
            dto.setPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setFormCodeName(null);
            dto.setPSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getPSDEViewBaseId());
            dto.setPSDEViewBaseName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
            dto.setViewCodeName(((PSDEViewBaseDTO)linkDTO).getCodeName());
        } else {
            dto.setPSDEViewBaseName(null);
            dto.setViewCodeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFId())) {
            linkDTO = (PSWorkflowDTO)PSModelServiceUtil.getInstance().getPSWorkflowService().getDTO(dto.getPSWFId());
            dto.setPSWFName(((PSWorkflowDTO)linkDTO).getPSWorkflowName());
        } else {
            dto.setPSWFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFRoleId())) {
            linkDTO = (PSWFRoleDTO)PSModelServiceUtil.getInstance().getPSWFRoleService().getDTO(dto.getPSWFRoleId());
            dto.setPSWFRoleName(((PSWFRoleDTO)linkDTO).getPSWFRoleName());
        } else {
            dto.setPSWFRoleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFVersionId())) {
            linkDTO = (PSWFVersionDTO)PSModelServiceUtil.getInstance().getPSWFVersionService().getDTO(dto.getPSWFVersionId());
            dto.setPSSystemId(((PSWFVersionDTO)linkDTO).getPSSystemId());
            dto.setPSWFVersionName(((PSWFVersionDTO)linkDTO).getPSWFVersionName());
            dto.setWFEngineType(((PSWFVersionDTO)linkDTO).getWFEngineType());
        } else {
            dto.setPSSystemId(null);
            dto.setPSWFVersionName(null);
            dto.setWFEngineType(null);
        }
        if (StringUtils.hasLength((String)dto.getTipPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getTipPSLanResId());
            dto.setTipPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setTipPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getToPSWFProcId())) {
            linkDTO = (PSWFProcessDTO)PSModelServiceUtil.getInstance().getPSWFProcessService().getDTO(dto.getToPSWFProcId());
            dto.setToPSWFProcName(((PSWFProcessDTO)linkDTO).getPSWFProcessName());
        } else {
            dto.setToPSWFProcName(null);
        }
        List<PSModelBase> list = PSModelServiceUtil.getInstance().getPSWFLinkRoleService().listByPSWFLink(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSWFLinkRoleDTO> pswflinkroles = new ArrayList<PSWFLinkRoleDTO>();
            for (PSWFLinkRole pSWFLinkRole : list) {
                dstItem = (PSWFLinkRoleDTO)PSModelServiceUtil.getInstance().getPSWFLinkRoleService().toDTO(pSWFLinkRole);
                pswflinkroles.add((PSWFLinkRoleDTO)dstItem);
            }
            dto.setPswflinkroles(pswflinkroles);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSWFLinkCondService().listByPSWFLink(t)) != null && list.size() > 0) {
            ArrayList<PSWFLinkCondDTO> pswflinkconds = new ArrayList<PSWFLinkCondDTO>();
            for (PSWFLinkCond pSWFLinkCond : list) {
                dstItem = (PSWFLinkCondDTO)PSModelServiceUtil.getInstance().getPSWFLinkCondService().toDTO(pSWFLinkCond);
                pswflinkconds.add((PSWFLinkCondDTO)dstItem);
            }
            dto.setPswflinkconds(pswflinkconds);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSWFLINK";
    }

    @Override
    public PSWFLink createDomain() {
        return new PSWFLink();
    }

    @Override
    public PSWFLinkDTO createDTO() {
        return new PSWFLinkDTO();
    }
}

