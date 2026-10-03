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
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.dto.PSDEFInputTipSetDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSubSysSADEDTO;
import net.ibizsys.modelapi.dto.PSSubSysServiceAPIDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysModelGroupDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSDataEntityService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDataEntityServiceImpl
extends PSModelServiceImplBase<PSDataEntity, PSDataEntityDTO>
implements IPSDataEntityService {
    private static final Log log = LogFactory.getLog(PSDataEntityServiceImpl.class);

    @Override
    public List<PSDataEntity> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDataEntity get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDataEntity> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSDataEntity item : list) {
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
    public List<PSDataEntityDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSDataEntity> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSDataEntityDTO> dtoList = new ArrayList<PSDataEntityDTO>();
            for (PSDataEntity item : list) {
                PSDataEntityDTO dto = (PSDataEntityDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDataEntity> onListAll() throws Exception {
        ArrayList<PSDataEntity> list = new ArrayList<PSDataEntity>();
        List<PSModule> psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll();
        if (psmodules != null) {
            for (PSModule parent : psmodules) {
                List<PSDataEntity> items = this.listByPSModule(parent);
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
    protected PSDataEntity onGet(String strParentKey, String strCurKey) throws Exception {
        PSDataEntity item;
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item = this.get(psmodule, strCurKey, true)) != null) {
            return item;
        }
        return (PSDataEntity)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDataEntityDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSModuleId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSModuleService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDataEntity et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDataEntityName())) {
            return et.getPSDataEntityName();
        }
        if (StringUtils.hasLength((String)et.getPSDataEntityName())) {
            return et.getPSDataEntityName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDataEntityDTO dto, PSDataEntity t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDataEntityId(t.getId().replace("/", "."));
        }
        if (t.getAccCtrlArch() != null || !bIgnoreNull) {
            dto.setAccCtrlArch(t.getAccCtrlArch());
        }
        if (t.getAuditMode() != null || !bIgnoreNull) {
            dto.setAuditMode(t.getAuditMode());
        }
        if (t.getBaseClsParams() != null || !bIgnoreNull) {
            dto.setBaseClsParams(t.getBaseClsParams());
        }
        if (t.getBizTag() != null || !bIgnoreNull) {
            dto.setBizTag(t.getBizTag());
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
        if (t.getDataAccMode() != null || !bIgnoreNull) {
            dto.setDataAccMode(t.getDataAccMode());
        }
        if (t.getDataChgLogMode() != null || !bIgnoreNull) {
            dto.setDataChgLogMode(t.getDataChgLogMode());
        }
        if (t.getDataImpExpFlag() != null || !bIgnoreNull) {
            dto.setDataImpExpFlag(t.getDataImpExpFlag());
        }
        if (t.getDBTabSpace() != null || !bIgnoreNull) {
            dto.setDBTabSpace(t.getDBTabSpace());
        }
        if (t.getDECat() != null || !bIgnoreNull) {
            dto.setDECat(t.getDECat());
        }
        if (t.getDEHolder() != null || !bIgnoreNull) {
            dto.setDEHolder(t.getDEHolder());
        }
        if (t.getDELockFlag() != null || !bIgnoreNull) {
            dto.setDELockFlag(t.getDELockFlag());
        }
        if (t.getDESN() != null || !bIgnoreNull) {
            dto.setDESN(t.getDESN());
        }
        if (t.getDETag() != null || !bIgnoreNull) {
            dto.setDETag(t.getDETag());
        }
        if (t.getDETag2() != null || !bIgnoreNull) {
            dto.setDETag2(t.getDETag2());
        }
        if (t.getDEType() != null || !bIgnoreNull) {
            dto.setDEType(t.getDEType());
        }
        if (t.getDSLink() != null || !bIgnoreNull) {
            dto.setDSLink(t.getDSLink());
        }
        if (t.getDynamicMode() != null || !bIgnoreNull) {
            dto.setDynamicMode(t.getDynamicMode());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getEnableAudit() != null || !bIgnoreNull) {
            dto.setEnableAudit(t.getEnableAudit());
        }
        if (t.getEnableDataVer() != null || !bIgnoreNull) {
            dto.setEnableDataVer(t.getEnableDataVer());
        }
        if (t.getEnableDEAction() != null || !bIgnoreNull) {
            dto.setEnableDEAction(t.getEnableDEAction());
        }
        if (t.getEnableDEDataSet() != null || !bIgnoreNull) {
            dto.setEnableDEDataSet(t.getEnableDEDataSet());
        }
        if (t.getEnableDynaSys() != null || !bIgnoreNull) {
            dto.setEnableDynaSys(t.getEnableDynaSys());
        }
        if (t.getEnableEntityCache() != null || !bIgnoreNull) {
            dto.setEnableEntityCache(t.getEnableEntityCache());
        }
        if (t.getEnableMob() != null || !bIgnoreNull) {
            dto.setEnableMob(t.getEnableMob());
        }
        if (t.getEnableOPNameModel() != null || !bIgnoreNull) {
            dto.setEnableOPNameModel(t.getEnableOPNameModel());
        }
        if (t.getEnableOrgModel() != null || !bIgnoreNull) {
            dto.setEnableOrgModel(t.getEnableOrgModel());
        }
        if (t.getEnableSelect() != null || !bIgnoreNull) {
            dto.setEnableSelect(t.getEnableSelect());
        }
        if (t.getEnableWFModel() != null || !bIgnoreNull) {
            dto.setEnableWFModel(t.getEnableWFModel());
        }
        if (t.getEnaMultiForm() != null || !bIgnoreNull) {
            dto.setEnaMultiForm(t.getEnaMultiForm());
        }
        if (t.getEnaTempData() != null || !bIgnoreNull) {
            dto.setEnaTempData(t.getEnaTempData());
        }
        if (t.getEntityCacheTimeout() != null || !bIgnoreNull) {
            dto.setEntityCacheTimeout(t.getEntityCacheTimeout());
        }
        if (t.getExistingModel() != null || !bIgnoreNull) {
            dto.setExistingModel(t.getExistingModel());
        }
        if (t.getExTableName() != null || !bIgnoreNull) {
            dto.setExTableName(t.getExTableName());
        }
        if (t.getIndexDEType() != null || !bIgnoreNull) {
            dto.setIndexDEType(t.getIndexDEType());
        }
        if (t.getKeyRule() != null || !bIgnoreNull) {
            dto.setKeyRule(t.getKeyRule());
        }
        if (t.getLNPSLanResId() != null || !bIgnoreNull) {
            dto.setLNPSLanResId(t.getLNPSLanResId());
        }
        if (t.getLNPSLanResName() != null || !bIgnoreNull) {
            dto.setLNPSLanResName(t.getLNPSLanResName());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getLogicInvalidValue() != null || !bIgnoreNull) {
            dto.setLogicInvalidValue(t.getLogicInvalidValue());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getLogicValid() != null || !bIgnoreNull) {
            dto.setLogicValid(t.getLogicValid());
        }
        if (t.getLogicValidValue() != null || !bIgnoreNull) {
            dto.setLogicValidValue(t.getLogicValidValue());
        }
        if (t.getMaxEntityCacheCnt() != null || !bIgnoreNull) {
            dto.setMaxEntityCacheCnt(t.getMaxEntityCacheCnt());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getModColor() != null || !bIgnoreNull) {
            dto.setModColor(t.getModColor());
        }
        if (t.getModelImpExpFlag() != null || !bIgnoreNull) {
            dto.setModelImpExpFlag(t.getModelImpExpFlag());
        }
        if (t.getModelState() != null || !bIgnoreNull) {
            dto.setModelState(t.getModelState());
        }
        if (t.getMSActionLogicFlag() != null || !bIgnoreNull) {
            dto.setMSActionLogicFlag(t.getMSActionLogicFlag());
        }
        if (t.getNoViewMode() != null || !bIgnoreNull) {
            dto.setNoViewMode(t.getNoViewMode());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDataEntityName() != null || !bIgnoreNull) {
            dto.setPSDataEntityName(t.getPSDataEntityName());
        }
        if (t.getPSDEFInputTipSetId() != null || !bIgnoreNull) {
            dto.setPSDEFInputTipSetId(t.getPSDEFInputTipSetId());
        }
        if (t.getPSDEFInputTipSetName() != null || !bIgnoreNull) {
            dto.setPSDEFInputTipSetName(t.getPSDEFInputTipSetName());
        }
        if (t.getPSDynaDETemplId() != null || !bIgnoreNull) {
            dto.setPSDynaDETemplId(t.getPSDynaDETemplId());
        }
        if (t.getPSDynaDETemplName() != null || !bIgnoreNull) {
            dto.setPSDynaDETemplName(t.getPSDynaDETemplName());
        }
        if (t.getPSHelpModuleId() != null || !bIgnoreNull) {
            dto.setPSHelpModuleId(t.getPSHelpModuleId());
        }
        if (t.getPSHelpModuleName() != null || !bIgnoreNull) {
            dto.setPSHelpModuleName(t.getPSHelpModuleName());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
        }
        if (t.getPSSubSysSADEId() != null || !bIgnoreNull) {
            dto.setPSSubSysSADEId(t.getPSSubSysSADEId());
        }
        if (t.getPSSubSysSADEName() != null || !bIgnoreNull) {
            dto.setPSSubSysSADEName(t.getPSSubSysSADEName());
        }
        if (t.getPSSubSysServiceAPIId() != null || !bIgnoreNull) {
            dto.setPSSubSysServiceAPIId(t.getPSSubSysServiceAPIId());
        }
        if (t.getPSSubSysServiceAPIName() != null || !bIgnoreNull) {
            dto.setPSSubSysServiceAPIName(t.getPSSubSysServiceAPIName());
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
        if (t.getPSSysModelGroupId() != null || !bIgnoreNull) {
            dto.setPSSysModelGroupId(t.getPSSysModelGroupId());
        }
        if (t.getPSSysModelGroupName() != null || !bIgnoreNull) {
            dto.setPSSysModelGroupName(t.getPSSysModelGroupName());
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
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getReadOnlyMode() != null || !bIgnoreNull) {
            dto.setReadOnlyMode(t.getReadOnlyMode());
        }
        if (t.getRemoveFlag() != null || !bIgnoreNull) {
            dto.setRemoveFlag(t.getRemoveFlag());
        }
        if (t.getSaaSMode() != null || !bIgnoreNull) {
            dto.setSaaSMode(t.getSaaSMode());
        }
        if (t.getServiceAPIFlag() != null || !bIgnoreNull) {
            dto.setServiceAPIFlag(t.getServiceAPIFlag());
        }
        if (t.getServiceCodeName() != null || !bIgnoreNull) {
            dto.setServiceCodeName(t.getServiceCodeName());
        }
        if (t.getStorageMode() != null || !bIgnoreNull) {
            dto.setStorageMode(t.getStorageMode());
        }
        if (t.getSubSysModule() != null || !bIgnoreNull) {
            dto.setSubSysModule(t.getSubSysModule());
        }
        if (t.getSystemFlag() != null || !bIgnoreNull) {
            dto.setSystemFlag(t.getSystemFlag());
        }
        if (t.getTableName() != null || !bIgnoreNull) {
            dto.setTableName(t.getTableName());
        }
        if (t.getTestCaseFlag() != null || !bIgnoreNull) {
            dto.setTestCaseFlag(t.getTestCaseFlag());
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
        if (t.getUserAction() != null || !bIgnoreNull) {
            dto.setUserAction(t.getUserAction());
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
        if (t.getViewLevel() != null || !bIgnoreNull) {
            dto.setViewLevel(t.getViewLevel());
        }
        if (t.getViewName() != null || !bIgnoreNull) {
            dto.setViewName(t.getViewName());
        }
        if (t.getViewName2() != null || !bIgnoreNull) {
            dto.setViewName2(t.getViewName2());
        }
        if (t.getViewName3() != null || !bIgnoreNull) {
            dto.setViewName3(t.getViewName3());
        }
        if (t.getViewName4() != null || !bIgnoreNull) {
            dto.setViewName4(t.getViewName4());
        }
        if (t.getVirtualFlag() != null || !bIgnoreNull) {
            dto.setVirtualFlag(t.getVirtualFlag());
        }
        if (t.getVKeySeparator() != null || !bIgnoreNull) {
            dto.setVKeySeparator(t.getVKeySeparator());
        }
        if (StringUtils.hasLength((String)dto.getLNPSLanResId())) {
            dto.setLNPSLanResId(this.getRealPSModelId(t, dto.getLNPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFInputTipSetId())) {
            dto.setPSDEFInputTipSetId(this.getRealPSModelId(t, dto.getPSDEFInputTipSetId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            dto.setPSModuleId(this.getRealPSModelId(t, dto.getPSModuleId()).replace("/", "."));
        }
        if ("PSMODULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSModuleId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysSADEId())) {
            dto.setPSSubSysSADEId(this.getRealPSModelId(t, dto.getPSSubSysSADEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysServiceAPIId())) {
            dto.setPSSubSysServiceAPIId(this.getRealPSModelId(t, dto.getPSSubSysServiceAPIId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            dto.setPSSysImageId(this.getRealPSModelId(t, dto.getPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysModelGroupId())) {
            dto.setPSSysModelGroupId(this.getRealPSModelId(t, dto.getPSSysModelGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            dto.setPSSysReqItemId(this.getRealPSModelId(t, dto.getPSSysReqItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLNPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getLNPSLanResId());
            dto.setLNPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setLNPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFInputTipSetId())) {
            linkDTO = (PSDEFInputTipSetDTO)PSModelServiceUtil.getInstance().getPSDEFInputTipSetService().getDTO(dto.getPSDEFInputTipSetId());
            dto.setPSDEFInputTipSetName(((PSDEFInputTipSetDTO)linkDTO).getPSDEFInputTipSetName());
        } else {
            dto.setPSDEFInputTipSetName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            linkDTO = (PSModuleDTO)PSModelServiceUtil.getInstance().getPSModuleService().getDTO(dto.getPSModuleId());
            dto.setModColor(((PSModuleDTO)linkDTO).getColor());
            dto.setPSModuleName(((PSModuleDTO)linkDTO).getPSModuleName());
            dto.setSubSysModule(((PSModuleDTO)linkDTO).getSubSysModule());
        } else {
            dto.setModColor(null);
            dto.setPSModuleName(null);
            dto.setSubSysModule(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysSADEId())) {
            linkDTO = (PSSubSysSADEDTO)PSModelServiceUtil.getInstance().getPSSubSysSADEService().getDTO(dto.getPSSubSysSADEId());
            dto.setPSSubSysSADEName(((PSSubSysSADEDTO)linkDTO).getPSSubSysSADEName());
        } else {
            dto.setPSSubSysSADEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysServiceAPIId())) {
            linkDTO = (PSSubSysServiceAPIDTO)PSModelServiceUtil.getInstance().getPSSubSysServiceAPIService().getDTO(dto.getPSSubSysServiceAPIId());
            dto.setPSSubSysServiceAPIName(((PSSubSysServiceAPIDTO)linkDTO).getPSSubSysServiceAPIName());
        } else {
            dto.setPSSubSysServiceAPIName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysModelGroupId())) {
            linkDTO = (PSSysModelGroupDTO)PSModelServiceUtil.getInstance().getPSSysModelGroupService().getDTO(dto.getPSSysModelGroupId());
            dto.setPSSysModelGroupName(((PSSysModelGroupDTO)linkDTO).getPSSysModelGroupName());
        } else {
            dto.setPSSysModelGroupName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(((PSSystemDTO)linkDTO).getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSDATAENTITY";
    }

    @Override
    public PSDataEntity createDomain() {
        return new PSDataEntity();
    }

    @Override
    public PSDataEntityDTO createDTO() {
        return new PSDataEntityDTO();
    }
}

