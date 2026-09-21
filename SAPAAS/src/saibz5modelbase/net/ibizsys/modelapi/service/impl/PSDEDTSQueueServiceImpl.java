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
import net.ibizsys.modelapi.domain.PSDEDTSQueue;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEDTSQueueDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSDEDTSQueueService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEDTSQueueServiceImpl
extends PSModelServiceImplBase<PSDEDTSQueue, PSDEDTSQueueDTO>
implements IPSDEDTSQueueService {
    private static final Log log = LogFactory.getLog(PSDEDTSQueueServiceImpl.class);

    @Override
    public List<PSDEDTSQueue> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEDTSQueue get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEDTSQueue> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEDTSQueue item : list) {
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
    public List<PSDEDTSQueueDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEDTSQueue> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEDTSQueueDTO> dtoList = new ArrayList<PSDEDTSQueueDTO>();
            for (PSDEDTSQueue item : list) {
                PSDEDTSQueueDTO dto = (PSDEDTSQueueDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEDTSQueue> onListAll() throws Exception {
        ArrayList<PSDEDTSQueue> list = new ArrayList<PSDEDTSQueue>();
        List psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEDTSQueue> items = this.listByPSDataEntity(parent);
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
    protected PSDEDTSQueue onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEDTSQueue item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEDTSQueue)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEDTSQueueDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEDTSQueue et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEDTSQueueDTO dto, PSDEDTSQueue t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEDTSQueueId(t.getId().replace("/", "."));
        }
        if (t.getCancelledState() != null || !bIgnoreNull) {
            dto.setCancelledState(t.getCancelledState());
        }
        if (t.getCancelledStateText() != null || !bIgnoreNull) {
            dto.setCancelledStateText(t.getCancelledStateText());
        }
        if (t.getCancelPSDEActionId() != null || !bIgnoreNull) {
            dto.setCancelPSDEActionId(t.getCancelPSDEActionId());
        }
        if (t.getCancelPSDEActionName() != null || !bIgnoreNull) {
            dto.setCancelPSDEActionName(t.getCancelPSDEActionName());
        }
        if (t.getCancelTimeout() != null || !bIgnoreNull) {
            dto.setCancelTimeout(t.getCancelTimeout());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreatedState() != null || !bIgnoreNull) {
            dto.setCreatedState(t.getCreatedState());
        }
        if (t.getCreatedStateText() != null || !bIgnoreNull) {
            dto.setCreatedStateText(t.getCreatedStateText());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDefaultFlag() != null || !bIgnoreNull) {
            dto.setDefaultFlag(t.getDefaultFlag());
        }
        if (t.getErrorPSDEFId() != null || !bIgnoreNull) {
            dto.setErrorPSDEFId(t.getErrorPSDEFId());
        }
        if (t.getErrorPSDEFName() != null || !bIgnoreNull) {
            dto.setErrorPSDEFName(t.getErrorPSDEFName());
        }
        if (t.getFailedState() != null || !bIgnoreNull) {
            dto.setFailedState(t.getFailedState());
        }
        if (t.getFailedStateText() != null || !bIgnoreNull) {
            dto.setFailedStateText(t.getFailedStateText());
        }
        if (t.getFinishedState() != null || !bIgnoreNull) {
            dto.setFinishedState(t.getFinishedState());
        }
        if (t.getFinishedStateText() != null || !bIgnoreNull) {
            dto.setFinishedStateText(t.getFinishedStateText());
        }
        if (t.getFinishPSDEActionId() != null || !bIgnoreNull) {
            dto.setFinishPSDEActionId(t.getFinishPSDEActionId());
        }
        if (t.getFinishPSDEActionName() != null || !bIgnoreNull) {
            dto.setFinishPSDEActionName(t.getFinishPSDEActionName());
        }
        if (t.getHistoryPSDEId() != null || !bIgnoreNull) {
            dto.setHistoryPSDEId(t.getHistoryPSDEId());
        }
        if (t.getHistoryPSDEName() != null || !bIgnoreNull) {
            dto.setHistoryPSDEName(t.getHistoryPSDEName());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getProcessingState() != null || !bIgnoreNull) {
            dto.setProcessingState(t.getProcessingState());
        }
        if (t.getProcessingStateText() != null || !bIgnoreNull) {
            dto.setProcessingStateText(t.getProcessingStateText());
        }
        if (t.getPSDEDTSQueueName() != null || !bIgnoreNull) {
            dto.setPSDEDTSQueueName(t.getPSDEDTSQueueName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginId(t.getPSSysSFPluginId());
        }
        if (t.getPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginName(t.getPSSysSFPluginName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getPushPSDEActionId() != null || !bIgnoreNull) {
            dto.setPushPSDEActionId(t.getPushPSDEActionId());
        }
        if (t.getPushPSDEActionName() != null || !bIgnoreNull) {
            dto.setPushPSDEActionName(t.getPushPSDEActionName());
        }
        if (t.getQueueParams() != null || !bIgnoreNull) {
            dto.setQueueParams(t.getQueueParams());
        }
        if (t.getRefreshPSDEActionId() != null || !bIgnoreNull) {
            dto.setRefreshPSDEActionId(t.getRefreshPSDEActionId());
        }
        if (t.getRefreshPSDEActionName() != null || !bIgnoreNull) {
            dto.setRefreshPSDEActionName(t.getRefreshPSDEActionName());
        }
        if (t.getRefreshTimer() != null || !bIgnoreNull) {
            dto.setRefreshTimer(t.getRefreshTimer());
        }
        if (t.getStatePSDEFId() != null || !bIgnoreNull) {
            dto.setStatePSDEFId(t.getStatePSDEFId());
        }
        if (t.getStatePSDEFName() != null || !bIgnoreNull) {
            dto.setStatePSDEFName(t.getStatePSDEFName());
        }
        if (t.getTimePSDEFId() != null || !bIgnoreNull) {
            dto.setTimePSDEFId(t.getTimePSDEFId());
        }
        if (t.getTimePSDEFName() != null || !bIgnoreNull) {
            dto.setTimePSDEFName(t.getTimePSDEFName());
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
        if (StringUtils.hasLength((String)dto.getCancelPSDEActionId())) {
            dto.setCancelPSDEActionId(this.getRealPSModelId(t, dto.getCancelPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getErrorPSDEFId())) {
            dto.setErrorPSDEFId(this.getRealPSModelId(t, dto.getErrorPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getFinishPSDEActionId())) {
            dto.setFinishPSDEActionId(this.getRealPSModelId(t, dto.getFinishPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getHistoryPSDEId())) {
            dto.setHistoryPSDEId(this.getRealPSModelId(t, dto.getHistoryPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPushPSDEActionId())) {
            dto.setPushPSDEActionId(this.getRealPSModelId(t, dto.getPushPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefreshPSDEActionId())) {
            dto.setRefreshPSDEActionId(this.getRealPSModelId(t, dto.getRefreshPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getStatePSDEFId())) {
            dto.setStatePSDEFId(this.getRealPSModelId(t, dto.getStatePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTimePSDEFId())) {
            dto.setTimePSDEFId(this.getRealPSModelId(t, dto.getTimePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCancelPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getCancelPSDEActionId());
            dto.setCancelPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setCancelPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getErrorPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getErrorPSDEFId());
            dto.setErrorPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setErrorPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getFinishPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getFinishPSDEActionId());
            dto.setFinishPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setFinishPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getHistoryPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getHistoryPSDEId());
            dto.setHistoryPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setHistoryPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getPSSysSFPluginId());
            dto.setPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setPSSysSFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(((PSSystemDTO)linkDTO).getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPushPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getPushPSDEActionId());
            dto.setPushPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setPushPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefreshPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getRefreshPSDEActionId());
            dto.setRefreshPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setRefreshPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getStatePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getStatePSDEFId());
            dto.setStatePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setStatePSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getTimePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTimePSDEFId());
            dto.setTimePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTimePSDEFName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSDEDTSQUEUE";
    }

    @Override
    public PSDEDTSQueue createDomain() {
        return new PSDEDTSQueue();
    }

    @Override
    public PSDEDTSQueueDTO createDTO() {
        return new PSDEDTSQueueDTO();
    }
}

