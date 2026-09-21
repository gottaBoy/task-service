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
import net.ibizsys.modelapi.domain.PSDEDataSync;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEDataSyncDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysDataSyncAgentDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.service.IPSDEDataSyncService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEDataSyncServiceImpl
extends PSModelServiceImplBase<PSDEDataSync, PSDEDataSyncDTO>
implements IPSDEDataSyncService {
    private static final Log log = LogFactory.getLog(PSDEDataSyncServiceImpl.class);

    @Override
    public List<PSDEDataSync> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEDataSync get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEDataSync> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEDataSync item : list) {
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
    public List<PSDEDataSyncDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEDataSync> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEDataSyncDTO> dtoList = new ArrayList<PSDEDataSyncDTO>();
            for (PSDEDataSync item : list) {
                PSDEDataSyncDTO dto = (PSDEDataSyncDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEDataSync> onListAll() throws Exception {
        ArrayList<PSDEDataSync> list = new ArrayList<PSDEDataSync>();
        List psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEDataSync> items = this.listByPSDataEntity(parent);
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
    protected PSDEDataSync onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEDataSync item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEDataSync)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEDataSyncDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEDataSync et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEDataSyncDTO dto, PSDEDataSync t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEDataSyncId(t.getId().replace("/", "."));
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
        if (t.getDENames() != null || !bIgnoreNull) {
            dto.setDENames(t.getDENames());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getEventType() != null || !bIgnoreNull) {
            dto.setEventType(t.getEventType());
        }
        if (t.getExportFull() != null || !bIgnoreNull) {
            dto.setExportFull(t.getExportFull());
        }
        if (t.getImportPSDEActionId() != null || !bIgnoreNull) {
            dto.setImportPSDEActionId(t.getImportPSDEActionId());
        }
        if (t.getImportPSDEActionName() != null || !bIgnoreNull) {
            dto.setImportPSDEActionName(t.getImportPSDEActionName());
        }
        if (t.getInCustomCode() != null || !bIgnoreNull) {
            dto.setInCustomCode(t.getInCustomCode());
        }
        if (t.getInCustomMode() != null || !bIgnoreNull) {
            dto.setInCustomMode(t.getInCustomMode());
        }
        if (t.getInPSDEActionId() != null || !bIgnoreNull) {
            dto.setInPSDEActionId(t.getInPSDEActionId());
        }
        if (t.getInPSDEActionName() != null || !bIgnoreNull) {
            dto.setInPSDEActionName(t.getInPSDEActionName());
        }
        if (t.getInPSDEDataSetId() != null || !bIgnoreNull) {
            dto.setInPSDEDataSetId(t.getInPSDEDataSetId());
        }
        if (t.getInPSDEDataSetName() != null || !bIgnoreNull) {
            dto.setInPSDEDataSetName(t.getInPSDEDataSetName());
        }
        if (t.getInPSSysDataSyncAgentId() != null || !bIgnoreNull) {
            dto.setInPSSysDataSyncAgentId(t.getInPSSysDataSyncAgentId());
        }
        if (t.getInPSSysDataSyncAgentName() != null || !bIgnoreNull) {
            dto.setInPSSysDataSyncAgentName(t.getInPSSysDataSyncAgentName());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOutCustomCode() != null || !bIgnoreNull) {
            dto.setOutCustomCode(t.getOutCustomCode());
        }
        if (t.getOutCustomMode() != null || !bIgnoreNull) {
            dto.setOutCustomMode(t.getOutCustomMode());
        }
        if (t.getOutMode() != null || !bIgnoreNull) {
            dto.setOutMode(t.getOutMode());
        }
        if (t.getOutPSDEActionId() != null || !bIgnoreNull) {
            dto.setOutPSDEActionId(t.getOutPSDEActionId());
        }
        if (t.getOutPSDEActionName() != null || !bIgnoreNull) {
            dto.setOutPSDEActionName(t.getOutPSDEActionName());
        }
        if (t.getOutPSDEDataSetId() != null || !bIgnoreNull) {
            dto.setOutPSDEDataSetId(t.getOutPSDEDataSetId());
        }
        if (t.getOutPSDEDataSetName() != null || !bIgnoreNull) {
            dto.setOutPSDEDataSetName(t.getOutPSDEDataSetName());
        }
        if (t.getOutPSSysDataSyncAgentId() != null || !bIgnoreNull) {
            dto.setOutPSSysDataSyncAgentId(t.getOutPSSysDataSyncAgentId());
        }
        if (t.getOutPSSysDataSyncAgentName() != null || !bIgnoreNull) {
            dto.setOutPSSysDataSyncAgentName(t.getOutPSSysDataSyncAgentName());
        }
        if (t.getOutTimer() != null || !bIgnoreNull) {
            dto.setOutTimer(t.getOutTimer());
        }
        if (t.getPSDEDataSyncName() != null || !bIgnoreNull) {
            dto.setPSDEDataSyncName(t.getPSDEDataSyncName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
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
        if (t.getSyncDir() != null || !bIgnoreNull) {
            dto.setSyncDir(t.getSyncDir());
        }
        if (t.getSyncExport() != null || !bIgnoreNull) {
            dto.setSyncExport(t.getSyncExport());
        }
        if (t.getTimerMode() != null || !bIgnoreNull) {
            dto.setTimerMode(t.getTimerMode());
        }
        if (t.getToDoTask() != null || !bIgnoreNull) {
            dto.setToDoTask(t.getToDoTask());
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
        if (StringUtils.hasLength((String)dto.getImportPSDEActionId())) {
            dto.setImportPSDEActionId(this.getRealPSModelId(t, dto.getImportPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getInPSDEActionId())) {
            dto.setInPSDEActionId(this.getRealPSModelId(t, dto.getInPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getInPSDEDataSetId())) {
            dto.setInPSDEDataSetId(this.getRealPSModelId(t, dto.getInPSDEDataSetId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getInPSSysDataSyncAgentId())) {
            dto.setInPSSysDataSyncAgentId(this.getRealPSModelId(t, dto.getInPSSysDataSyncAgentId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOutPSDEActionId())) {
            dto.setOutPSDEActionId(this.getRealPSModelId(t, dto.getOutPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOutPSDEDataSetId())) {
            dto.setOutPSDEDataSetId(this.getRealPSModelId(t, dto.getOutPSDEDataSetId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOutPSSysDataSyncAgentId())) {
            dto.setOutPSSysDataSyncAgentId(this.getRealPSModelId(t, dto.getOutPSSysDataSyncAgentId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            dto.setPSSysReqItemId(this.getRealPSModelId(t, dto.getPSSysReqItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getImportPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getImportPSDEActionId());
            dto.setImportPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setImportPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getInPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getInPSDEActionId());
            dto.setInPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setInPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getInPSDEDataSetId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getInPSDEDataSetId());
            dto.setInPSDEDataSetName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setInPSDEDataSetName(null);
        }
        if (StringUtils.hasLength((String)dto.getInPSSysDataSyncAgentId())) {
            linkDTO = (PSSysDataSyncAgentDTO)PSModelServiceUtil.getInstance().getPSSysDataSyncAgentService().getDTO(dto.getInPSSysDataSyncAgentId());
            dto.setInPSSysDataSyncAgentName(((PSSysDataSyncAgentDTO)linkDTO).getPSSysDataSyncAgentName());
        } else {
            dto.setInPSSysDataSyncAgentName(null);
        }
        if (StringUtils.hasLength((String)dto.getOutPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getOutPSDEActionId());
            dto.setOutPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setOutPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getOutPSDEDataSetId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getOutPSDEDataSetId());
            dto.setOutPSDEDataSetName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setOutPSDEDataSetName(null);
        }
        if (StringUtils.hasLength((String)dto.getOutPSSysDataSyncAgentId())) {
            linkDTO = (PSSysDataSyncAgentDTO)PSModelServiceUtil.getInstance().getPSSysDataSyncAgentService().getDTO(dto.getOutPSSysDataSyncAgentId());
            dto.setOutPSSysDataSyncAgentName(((PSSysDataSyncAgentDTO)linkDTO).getPSSysDataSyncAgentName());
        } else {
            dto.setOutPSSysDataSyncAgentName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
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
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSDEDATASYNC";
    }

    @Override
    public PSDEDataSync createDomain() {
        return new PSDEDataSync();
    }

    @Override
    public PSDEDataSyncDTO createDTO() {
        return new PSDEDataSyncDTO();
    }
}

