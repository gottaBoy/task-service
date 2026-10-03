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
import net.ibizsys.modelapi.domain.PSDEAction;
import net.ibizsys.modelapi.domain.PSDEActionParam;
import net.ibizsys.modelapi.domain.PSDEActionVR;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEActionParamDTO;
import net.ibizsys.modelapi.dto.PSDEActionTemplDTO;
import net.ibizsys.modelapi.dto.PSDEActionVRDTO;
import net.ibizsys.modelapi.dto.PSDEDataQueryDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEFGroupDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDEOPPrivDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSubSysSADetailDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.service.IPSDEActionService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEActionServiceImpl
extends PSModelServiceImplBase<PSDEAction, PSDEActionDTO>
implements IPSDEActionService {
    private static final Log log = LogFactory.getLog(PSDEActionServiceImpl.class);

    @Override
    public List<PSDEAction> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEAction get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEAction> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEAction item : list) {
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
    public List<PSDEActionDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEAction> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEActionDTO> dtoList = new ArrayList<PSDEActionDTO>();
            for (PSDEAction item : list) {
                PSDEActionDTO dto = (PSDEActionDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEAction> onListAll() throws Exception {
        ArrayList<PSDEAction> list = new ArrayList<PSDEAction>();
        List<PSDataEntity> psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEAction> items = this.listByPSDataEntity(parent);
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
    protected PSDEAction onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEAction item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEAction)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEActionDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEAction et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEActionName())) {
            return et.getPSDEActionName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEActionDTO dto, PSDEAction t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEActionId(t.getId().replace("/", "."));
        }
        if (t.getActionHolder() != null || !bIgnoreNull) {
            dto.setActionHolder(t.getActionHolder());
        }
        if (t.getActionMode() != null || !bIgnoreNull) {
            dto.setActionMode(t.getActionMode());
        }
        if (t.getActionTag() != null || !bIgnoreNull) {
            dto.setActionTag(t.getActionTag());
        }
        if (t.getActionTag2() != null || !bIgnoreNull) {
            dto.setActionTag2(t.getActionTag2());
        }
        if (t.getActionTag3() != null || !bIgnoreNull) {
            dto.setActionTag3(t.getActionTag3());
        }
        if (t.getActionTag4() != null || !bIgnoreNull) {
            dto.setActionTag4(t.getActionTag4());
        }
        if (t.getActionType() != null || !bIgnoreNull) {
            dto.setActionType(t.getActionType());
        }
        if (t.getAfterCode() != null || !bIgnoreNull) {
            dto.setAfterCode(t.getAfterCode());
        }
        if (t.getBatchActionMode() != null || !bIgnoreNull) {
            dto.setBatchActionMode(t.getBatchActionMode());
        }
        if (t.getBeforeCode() != null || !bIgnoreNull) {
            dto.setBeforeCode(t.getBeforeCode());
        }
        if (t.getCacheCat() != null || !bIgnoreNull) {
            dto.setCacheCat(t.getCacheCat());
        }
        if (t.getCacheScope() != null || !bIgnoreNull) {
            dto.setCacheScope(t.getCacheScope());
        }
        if (t.getCacheTag() != null || !bIgnoreNull) {
            dto.setCacheTag(t.getCacheTag());
        }
        if (t.getCacheTimeout() != null || !bIgnoreNull) {
            dto.setCacheTimeout(t.getCacheTimeout());
        }
        if (t.getCallerObj() != null || !bIgnoreNull) {
            dto.setCallerObj(t.getCallerObj());
        }
        if (t.getCallTimeout() != null || !bIgnoreNull) {
            dto.setCallTimeout(t.getCallTimeout());
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
        if (t.getCustomCode() != null || !bIgnoreNull) {
            dto.setCustomCode(t.getCustomCode());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getEnableAudit() != null || !bIgnoreNull) {
            dto.setEnableAudit(t.getEnableAudit());
        }
        if (t.getEnableCache() != null || !bIgnoreNull) {
            dto.setEnableCache(t.getEnableCache());
        }
        if (t.getExtendMode() != null || !bIgnoreNull) {
            dto.setExtendMode(t.getExtendMode());
        }
        if (t.getFinishFlag() != null || !bIgnoreNull) {
            dto.setFinishFlag(t.getFinishFlag());
        }
        if (t.getInPSDEFGroupId() != null || !bIgnoreNull) {
            dto.setInPSDEFGroupId(t.getInPSDEFGroupId());
        }
        if (t.getInPSDEFGroupName() != null || !bIgnoreNull) {
            dto.setInPSDEFGroupName(t.getInPSDEFGroupName());
        }
        if (t.getInPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setInPSSysDynaModelId(t.getInPSSysDynaModelId());
        }
        if (t.getInPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setInPSSysDynaModelName(t.getInPSSysDynaModelName());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getOutPSDEFGroupId() != null || !bIgnoreNull) {
            dto.setOutPSDEFGroupId(t.getOutPSDEFGroupId());
        }
        if (t.getOutPSDEFGroupName() != null || !bIgnoreNull) {
            dto.setOutPSDEFGroupName(t.getOutPSDEFGroupName());
        }
        if (t.getOutPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setOutPSSysDynaModelId(t.getOutPSSysDynaModelId());
        }
        if (t.getOutPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setOutPSSysDynaModelName(t.getOutPSSysDynaModelName());
        }
        if (t.getOutRefPSDEFGroupId() != null || !bIgnoreNull) {
            dto.setOutRefPSDEFGroupId(t.getOutRefPSDEFGroupId());
        }
        if (t.getOutRefPSDEFGroupName() != null || !bIgnoreNull) {
            dto.setOutRefPSDEFGroupName(t.getOutRefPSDEFGroupName());
        }
        if (t.getOutRefPSDEId() != null || !bIgnoreNull) {
            dto.setOutRefPSDEId(t.getOutRefPSDEId());
        }
        if (t.getOutRefPSDEName() != null || !bIgnoreNull) {
            dto.setOutRefPSDEName(t.getOutRefPSDEName());
        }
        if (t.getParamType() != null || !bIgnoreNull) {
            dto.setParamType(t.getParamType());
        }
        if (t.getPOTime() != null || !bIgnoreNull) {
            dto.setPOTime(t.getPOTime());
        }
        if (t.getPredefinedType() != null || !bIgnoreNull) {
            dto.setPredefinedType(t.getPredefinedType());
        }
        if (t.getPredefinedTypeText() != null || !bIgnoreNull) {
            dto.setPredefinedTypeText(t.getPredefinedTypeText());
        }
        if (t.getPrepareLast() != null || !bIgnoreNull) {
            dto.setPrepareLast(t.getPrepareLast());
        }
        if (t.getPSDEActionName() != null || !bIgnoreNull) {
            dto.setPSDEActionName(t.getPSDEActionName());
        }
        if (t.getPSDEActionTemplId() != null || !bIgnoreNull) {
            dto.setPSDEActionTemplId(t.getPSDEActionTemplId());
        }
        if (t.getPSDEActionTemplName() != null || !bIgnoreNull) {
            dto.setPSDEActionTemplName(t.getPSDEActionTemplName());
        }
        if (t.getPSDEDataQueryId() != null || !bIgnoreNull) {
            dto.setPSDEDataQueryId(t.getPSDEDataQueryId());
        }
        if (t.getPSDEDataQueryName() != null || !bIgnoreNull) {
            dto.setPSDEDataQueryName(t.getPSDEDataQueryName());
        }
        if (t.getPSDEDataSetId() != null || !bIgnoreNull) {
            dto.setPSDEDataSetId(t.getPSDEDataSetId());
        }
        if (t.getPSDEDataSetName() != null || !bIgnoreNull) {
            dto.setPSDEDataSetName(t.getPSDEDataSetName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDELogicId() != null || !bIgnoreNull) {
            dto.setPSDELogicId(t.getPSDELogicId());
        }
        if (t.getPSDELogicName() != null || !bIgnoreNull) {
            dto.setPSDELogicName(t.getPSDELogicName());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setPSDEOPPrivId(t.getPSDEOPPrivId());
        }
        if (t.getPSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setPSDEOPPrivName(t.getPSDEOPPrivName());
        }
        if (t.getPSDESysProcId() != null || !bIgnoreNull) {
            dto.setPSDESysProcId(t.getPSDESysProcId());
        }
        if (t.getPSDESysProcName() != null || !bIgnoreNull) {
            dto.setPSDESysProcName(t.getPSDESysProcName());
        }
        if (t.getPSSubSysSADEId() != null || !bIgnoreNull) {
            dto.setPSSubSysSADEId(t.getPSSubSysSADEId());
        }
        if (t.getPSSubSysSADetailId() != null || !bIgnoreNull) {
            dto.setPSSubSysSADetailId(t.getPSSubSysSADetailId());
        }
        if (t.getPSSubSysSADetailName() != null || !bIgnoreNull) {
            dto.setPSSubSysSADetailName(t.getPSSubSysSADetailName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginId(t.getPSSysPFPluginId());
        }
        if (t.getPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginName(t.getPSSysPFPluginName());
        }
        if (t.getPSSysReqItemId() != null || !bIgnoreNull) {
            dto.setPSSysReqItemId(t.getPSSysReqItemId());
        }
        if (t.getPSSysReqItemName() != null || !bIgnoreNull) {
            dto.setPSSysReqItemName(t.getPSSysReqItemName());
        }
        if (t.getPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginId(t.getPSSysSFPluginId());
        }
        if (t.getPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginName(t.getPSSysSFPluginName());
        }
        if (t.getPSSysTaskId() != null || !bIgnoreNull) {
            dto.setPSSysTaskId(t.getPSSysTaskId());
        }
        if (t.getPSSysTaskName() != null || !bIgnoreNull) {
            dto.setPSSysTaskName(t.getPSSysTaskName());
        }
        if (t.getPubMode() != null || !bIgnoreNull) {
            dto.setPubMode(t.getPubMode());
        }
        if (t.getRawServiceMethod() != null || !bIgnoreNull) {
            dto.setRawServiceMethod(t.getRawServiceMethod());
        }
        if (t.getRawServiceUrl() != null || !bIgnoreNull) {
            dto.setRawServiceUrl(t.getRawServiceUrl());
        }
        if (t.getRequestField() != null || !bIgnoreNull) {
            dto.setRequestField(t.getRequestField());
        }
        if (t.getRequestMethod() != null || !bIgnoreNull) {
            dto.setRequestMethod(t.getRequestMethod());
        }
        if (t.getRequestParamType() != null || !bIgnoreNull) {
            dto.setRequestParamType(t.getRequestParamType());
        }
        if (t.getRequestPath() != null || !bIgnoreNull) {
            dto.setRequestPath(t.getRequestPath());
        }
        if (t.getRetStdDataType() != null || !bIgnoreNull) {
            dto.setRetStdDataType(t.getRetStdDataType());
        }
        if (t.getRetValType() != null || !bIgnoreNull) {
            dto.setRetValType(t.getRetValType());
        }
        if (t.getTestActionMode() != null || !bIgnoreNull) {
            dto.setTestActionMode(t.getTestActionMode());
        }
        if (t.getTestCaseFlag() != null || !bIgnoreNull) {
            dto.setTestCaseFlag(t.getTestCaseFlag());
        }
        if (t.getToDoTask() != null || !bIgnoreNull) {
            dto.setToDoTask(t.getToDoTask());
        }
        if (t.getTSMode() != null || !bIgnoreNull) {
            dto.setTSMode(t.getTSMode());
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
        if (t.getUserParams() != null || !bIgnoreNull) {
            dto.setUserParams(t.getUserParams());
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
        if (StringUtils.hasLength((String)dto.getInPSDEFGroupId())) {
            dto.setInPSDEFGroupId(this.getRealPSModelId(t, dto.getInPSDEFGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getInPSSysDynaModelId())) {
            dto.setInPSSysDynaModelId(this.getRealPSModelId(t, dto.getInPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOutPSDEFGroupId())) {
            dto.setOutPSDEFGroupId(this.getRealPSModelId(t, dto.getOutPSDEFGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOutPSSysDynaModelId())) {
            dto.setOutPSSysDynaModelId(this.getRealPSModelId(t, dto.getOutPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOutRefPSDEFGroupId())) {
            dto.setOutRefPSDEFGroupId(this.getRealPSModelId(t, dto.getOutRefPSDEFGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOutRefPSDEId())) {
            dto.setOutRefPSDEId(this.getRealPSModelId(t, dto.getOutRefPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionTemplId())) {
            dto.setPSDEActionTemplId(this.getRealPSModelId(t, dto.getPSDEActionTemplId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataQueryId())) {
            dto.setPSDEDataQueryId(this.getRealPSModelId(t, dto.getPSDEDataQueryId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataSetId())) {
            dto.setPSDEDataSetId(this.getRealPSModelId(t, dto.getPSDEDataSetId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            dto.setPSDELogicId(this.getRealPSModelId(t, dto.getPSDELogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEOPPrivId())) {
            dto.setPSDEOPPrivId(this.getRealPSModelId(t, dto.getPSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysSADetailId())) {
            dto.setPSSubSysSADetailId(this.getRealPSModelId(t, dto.getPSSubSysSADetailId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            dto.setPSSysReqItemId(this.getRealPSModelId(t, dto.getPSSysReqItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getInPSDEFGroupId())) {
            linkDTO = (PSDEFGroupDTO)PSModelServiceUtil.getInstance().getPSDEFGroupService().getDTO(dto.getInPSDEFGroupId());
            dto.setInPSDEFGroupName(((PSDEFGroupDTO)linkDTO).getPSDEFGroupName());
        } else {
            dto.setInPSDEFGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getInPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getInPSSysDynaModelId());
            dto.setInPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setInPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getOutPSDEFGroupId())) {
            linkDTO = (PSDEFGroupDTO)PSModelServiceUtil.getInstance().getPSDEFGroupService().getDTO(dto.getOutPSDEFGroupId());
            dto.setOutPSDEFGroupName(((PSDEFGroupDTO)linkDTO).getPSDEFGroupName());
        } else {
            dto.setOutPSDEFGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getOutPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getOutPSSysDynaModelId());
            dto.setOutPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setOutPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getOutRefPSDEFGroupId())) {
            linkDTO = (PSDEFGroupDTO)PSModelServiceUtil.getInstance().getPSDEFGroupService().getDTO(dto.getOutRefPSDEFGroupId());
            dto.setOutRefPSDEFGroupName(((PSDEFGroupDTO)linkDTO).getPSDEFGroupName());
        } else {
            dto.setOutRefPSDEFGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getOutRefPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getOutRefPSDEId());
            dto.setOutRefPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setOutRefPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionTemplId())) {
            linkDTO = (PSDEActionTemplDTO)PSModelServiceUtil.getInstance().getPSDEActionTemplService().getDTO(dto.getPSDEActionTemplId());
            dto.setPSDEActionTemplName(((PSDEActionTemplDTO)linkDTO).getPSDEActionTemplName());
        } else {
            dto.setPSDEActionTemplName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataQueryId())) {
            linkDTO = (PSDEDataQueryDTO)PSModelServiceUtil.getInstance().getPSDEDataQueryService().getDTO(dto.getPSDEDataQueryId());
            dto.setPSDEDataQueryName(((PSDEDataQueryDTO)linkDTO).getPSDEDataQueryName());
        } else {
            dto.setPSDEDataQueryName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataSetId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getPSDEDataSetId());
            dto.setPSDEDataSetName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setPSDEDataSetName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
            dto.setPSSubSysSADEId(((PSDataEntityDTO)linkDTO).getPSSubSysSADEId());
        } else {
            dto.setPSDEName(null);
            dto.setPSSubSysSADEId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getPSDELogicId());
            dto.setPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getPSDEOPPrivId());
            dto.setPSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setPSDEOPPrivName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysSADetailId())) {
            linkDTO = (PSSubSysSADetailDTO)PSModelServiceUtil.getInstance().getPSSubSysSADetailService().getDTO(dto.getPSSubSysSADetailId());
            dto.setPSSubSysSADetailName(((PSSubSysSADetailDTO)linkDTO).getPSSubSysSADetailName());
        } else {
            dto.setPSSubSysSADetailName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getPSSysPFPluginId());
            dto.setPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            linkDTO = (PSSysReqItemDTO)PSModelServiceUtil.getInstance().getPSSysReqItemService().getDTO(dto.getPSSysReqItemId());
            dto.setPSSysReqItemName(((PSSysReqItemDTO)linkDTO).getPSSysReqItemName());
        } else {
            dto.setPSSysReqItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getPSSysSFPluginId());
            dto.setPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setPSSysSFPluginName(null);
        }
        List<PSDEActionParam> pSDEActionParamList = PSModelServiceUtil.getInstance().getPSDEActionParamService().listByPSDEAction(t);
        if (pSDEActionParamList != null && pSDEActionParamList.size() > 0) {
            ArrayList<PSDEActionParamDTO> psdeactionparams = new ArrayList<PSDEActionParamDTO>();
            for (PSDEActionParam pSDEActionParam : pSDEActionParamList) {
                dstItem = (PSDEActionParamDTO)PSModelServiceUtil.getInstance().getPSDEActionParamService().toDTO(pSDEActionParam);
                psdeactionparams.add((PSDEActionParamDTO)dstItem);
            }
            dto.setPsdeactionparams(psdeactionparams);
        }
        List<PSDEActionVR> pSDEActionVRList = PSModelServiceUtil.getInstance().getPSDEActionVRService().listByPSDEAction(t);
        if (pSDEActionVRList != null && pSDEActionVRList.size() > 0) {
            ArrayList<PSDEActionVRDTO> psdeactionvrs = new ArrayList<PSDEActionVRDTO>();
            for (PSDEActionVR pSDEActionVR : pSDEActionVRList) {
                dstItem = (PSDEActionVRDTO)PSModelServiceUtil.getInstance().getPSDEActionVRService().toDTO(pSDEActionVR);
                psdeactionvrs.add((PSDEActionVRDTO)dstItem);
            }
            dto.setPsdeactionvrs(psdeactionvrs);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEACTION";
    }

    @Override
    public PSDEAction createDomain() {
        return new PSDEAction();
    }

    @Override
    public PSDEActionDTO createDTO() {
        return new PSDEActionDTO();
    }
}

