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
import java.util.Collection;
import java.util.List;
import net.ibizsys.modelapi.domain.PSACHandler;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSACHandlerDTO;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEOPPrivDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.dto.PSSysUniStateDTO;
import net.ibizsys.modelapi.dto.PSSysUserDRDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSACHandlerService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSACHandlerServiceImpl
extends PSModelServiceImplBase<PSACHandler, PSACHandlerDTO>
implements IPSACHandlerService {
    private static final Log log = LogFactory.getLog(PSACHandlerServiceImpl.class);

    @Override
    public List<PSACHandler> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSACHandler get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSACHandler> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSACHandler item : list) {
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
    public List<PSACHandlerDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSACHandler> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSACHandlerDTO> dtoList = new ArrayList<PSACHandlerDTO>();
            for (PSACHandler item : list) {
                PSACHandlerDTO dto = (PSACHandlerDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSACHandler> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSACHandler get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSACHandler> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSACHandler item : list) {
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
    public List<PSACHandlerDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSACHandler> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSACHandlerDTO> dtoList = new ArrayList<PSACHandlerDTO>();
            for (PSACHandler item : list) {
                PSACHandlerDTO dto = (PSACHandlerDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSACHandler> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSACHandler get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSACHandler> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSACHandler item : list) {
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
    public List<PSACHandlerDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSACHandler> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSACHandlerDTO> dtoList = new ArrayList<PSACHandlerDTO>();
            for (PSACHandler item : list) {
                PSACHandlerDTO dto = (PSACHandlerDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSACHandler> onListAll() throws Exception {
        List pssystems;
        List psmodules;
        ArrayList<PSACHandler> list = new ArrayList<PSACHandler>();
        List psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSACHandler> items = this.listByPSDataEntity(parent);
                if (items == null) continue;
                list.addAll((Collection<PSACHandler>)items);
            }
        }
        if ((psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll()) != null) {
            for (PSModule parent : psmodules) {
                List<PSACHandler> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSACHandler> items = this.listByPSSystem(parent);
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
    protected PSACHandler onGet(String strParentKey, String strCurKey) throws Exception {
        PSACHandler item;
        PSACHandler item2;
        PSACHandler item3;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item3 = this.get(psdataentity, strCurKey, true)) != null) {
            return item3;
        }
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item2 = this.get(psmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSACHandler)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSACHandlerDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSModuleId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSModuleService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSSystemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSystemService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSACHandler et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSACHandlerDTO dto, PSACHandler t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSACHandlerId(t.getId().replace("/", "."));
        }
        if (t.getCacheScope() != null || !bIgnoreNull) {
            dto.setCacheScope(t.getCacheScope());
        }
        if (t.getCacheTimeout() != null || !bIgnoreNull) {
            dto.setCacheTimeout(t.getCacheTimeout());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getCopyPSDEActionId() != null || !bIgnoreNull) {
            dto.setCopyPSDEActionId(t.getCopyPSDEActionId());
        }
        if (t.getCopyPSDEActionName() != null || !bIgnoreNull) {
            dto.setCopyPSDEActionName(t.getCopyPSDEActionName());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCreatePSDEActionId() != null || !bIgnoreNull) {
            dto.setCreatePSDEActionId(t.getCreatePSDEActionId());
        }
        if (t.getCreatePSDEActionName() != null || !bIgnoreNull) {
            dto.setCreatePSDEActionName(t.getCreatePSDEActionName());
        }
        if (t.getCreatePSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setCreatePSDEOPPrivId(t.getCreatePSDEOPPrivId());
        }
        if (t.getCreatePSDEOPPrivIName() != null || !bIgnoreNull) {
            dto.setCreatePSDEOPPrivIName(t.getCreatePSDEOPPrivIName());
        }
        if (t.getCreateTimeout() != null || !bIgnoreNull) {
            dto.setCreateTimeout(t.getCreateTimeout());
        }
        if (t.getCtrlType() != null || !bIgnoreNull) {
            dto.setCtrlType(t.getCtrlType());
        }
        if (t.getCustomCond() != null || !bIgnoreNull) {
            dto.setCustomCond(t.getCustomCond());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getEnableCache() != null || !bIgnoreNull) {
            dto.setEnableCache(t.getEnableCache());
        }
        if (t.getEnableOrgDR() != null || !bIgnoreNull) {
            dto.setEnableOrgDR(t.getEnableOrgDR());
        }
        if (t.getEnableSecBC() != null || !bIgnoreNull) {
            dto.setEnableSecBC(t.getEnableSecBC());
        }
        if (t.getEnableSecDR() != null || !bIgnoreNull) {
            dto.setEnableSecDR(t.getEnableSecDR());
        }
        if (t.getEnableUserDR() != null || !bIgnoreNull) {
            dto.setEnableUserDR(t.getEnableUserDR());
        }
        if (t.getExportPSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setExportPSDEOPPrivId(t.getExportPSDEOPPrivId());
        }
        if (t.getExportPSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setExportPSDEOPPrivName(t.getExportPSDEOPPrivName());
        }
        if (t.getFetchTimeout() != null || !bIgnoreNull) {
            dto.setFetchTimeout(t.getFetchTimeout());
        }
        if (t.getFinishFlag() != null || !bIgnoreNull) {
            dto.setFinishFlag(t.getFinishFlag());
        }
        if (t.getGetDraftPSDEActionId() != null || !bIgnoreNull) {
            dto.setGetDraftPSDEActionId(t.getGetDraftPSDEActionId());
        }
        if (t.getGetDraftPSDEActionName() != null || !bIgnoreNull) {
            dto.setGetDraftPSDEActionName(t.getGetDraftPSDEActionName());
        }
        if (t.getGetPSDEActionId() != null || !bIgnoreNull) {
            dto.setGetPSDEActionId(t.getGetPSDEActionId());
        }
        if (t.getGetPSDEActionName() != null || !bIgnoreNull) {
            dto.setGetPSDEActionName(t.getGetPSDEActionName());
        }
        if (t.getGetTimeout() != null || !bIgnoreNull) {
            dto.setGetTimeout(t.getGetTimeout());
        }
        if (t.getHandlerObj() != null || !bIgnoreNull) {
            dto.setHandlerObj(t.getHandlerObj());
        }
        if (t.getHandlerObj2() != null || !bIgnoreNull) {
            dto.setHandlerObj2(t.getHandlerObj2());
        }
        if (t.getHandlerParams() != null || !bIgnoreNull) {
            dto.setHandlerParams(t.getHandlerParams());
        }
        if (t.getHandlerTag() != null || !bIgnoreNull) {
            dto.setHandlerTag(t.getHandlerTag());
        }
        if (t.getHandlerTag2() != null || !bIgnoreNull) {
            dto.setHandlerTag2(t.getHandlerTag2());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrgDR() != null || !bIgnoreNull) {
            dto.setOrgDR(t.getOrgDR());
        }
        if (t.getPSACHandlerName() != null || !bIgnoreNull) {
            dto.setPSACHandlerName(t.getPSACHandlerName());
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
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
        }
        if (t.getPSSFACHandlerId() != null || !bIgnoreNull) {
            dto.setPSSFACHandlerId(t.getPSSFACHandlerId());
        }
        if (t.getPSSFACHandlerName() != null || !bIgnoreNull) {
            dto.setPSSFACHandlerName(t.getPSSFACHandlerName());
        }
        if (t.getPSSFId() != null || !bIgnoreNull) {
            dto.setPSSFId(t.getPSSFId());
        }
        if (t.getPSSFName() != null || !bIgnoreNull) {
            dto.setPSSFName(t.getPSSFName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSysReqItemId() != null || !bIgnoreNull) {
            dto.setPSSysReqItemId(t.getPSSysReqItemId());
        }
        if (t.getPSSysReqItemName() != null || !bIgnoreNull) {
            dto.setPSSysReqItemName(t.getPSSysReqItemName());
        }
        if (t.getPSSysTaskId() != null || !bIgnoreNull) {
            dto.setPSSysTaskId(t.getPSSysTaskId());
        }
        if (t.getPSSysTaskName() != null || !bIgnoreNull) {
            dto.setPSSysTaskName(t.getPSSysTaskName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getPSSysUniStateId() != null || !bIgnoreNull) {
            dto.setPSSysUniStateId(t.getPSSysUniStateId());
        }
        if (t.getPSSysUniStateName() != null || !bIgnoreNull) {
            dto.setPSSysUniStateName(t.getPSSysUniStateName());
        }
        if (t.getPSSysUserDRId() != null || !bIgnoreNull) {
            dto.setPSSysUserDRId(t.getPSSysUserDRId());
        }
        if (t.getPSSysUserDRId2() != null || !bIgnoreNull) {
            dto.setPSSysUserDRId2(t.getPSSysUserDRId2());
        }
        if (t.getPSSysUserDRName() != null || !bIgnoreNull) {
            dto.setPSSysUserDRName(t.getPSSysUserDRName());
        }
        if (t.getPSSysUserDRName2() != null || !bIgnoreNull) {
            dto.setPSSysUserDRName2(t.getPSSysUserDRName2());
        }
        if (t.getReadPSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setReadPSDEOPPrivId(t.getReadPSDEOPPrivId());
        }
        if (t.getReadPSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setReadPSDEOPPrivName(t.getReadPSDEOPPrivName());
        }
        if (t.getRemovePSDEActionId() != null || !bIgnoreNull) {
            dto.setRemovePSDEActionId(t.getRemovePSDEActionId());
        }
        if (t.getRemovePSDEActionName() != null || !bIgnoreNull) {
            dto.setRemovePSDEActionName(t.getRemovePSDEActionName());
        }
        if (t.getRemovePSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setRemovePSDEOPPrivId(t.getRemovePSDEOPPrivId());
        }
        if (t.getRemovePSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setRemovePSDEOPPrivName(t.getRemovePSDEOPPrivName());
        }
        if (t.getRemoveTimeout() != null || !bIgnoreNull) {
            dto.setRemoveTimeout(t.getRemoveTimeout());
        }
        if (t.getSecBC() != null || !bIgnoreNull) {
            dto.setSecBC(t.getSecBC());
        }
        if (t.getSecDR() != null || !bIgnoreNull) {
            dto.setSecDR(t.getSecDR());
        }
        if (t.getSysUserDR2Param() != null || !bIgnoreNull) {
            dto.setSysUserDR2Param(t.getSysUserDR2Param());
        }
        if (t.getSysUserDRParam() != null || !bIgnoreNull) {
            dto.setSysUserDRParam(t.getSysUserDRParam());
        }
        if (t.getTempMode() != null || !bIgnoreNull) {
            dto.setTempMode(t.getTempMode());
        }
        if (t.getToDoTask() != null || !bIgnoreNull) {
            dto.setToDoTask(t.getToDoTask());
        }
        if (t.getUniStateField() != null || !bIgnoreNull) {
            dto.setUniStateField(t.getUniStateField());
        }
        if (t.getUniStateKeyValue() != null || !bIgnoreNull) {
            dto.setUniStateKeyValue(t.getUniStateKeyValue());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUpdatePSDEActionId() != null || !bIgnoreNull) {
            dto.setUpdatePSDEActionId(t.getUpdatePSDEActionId());
        }
        if (t.getUpdatePSDEActionName() != null || !bIgnoreNull) {
            dto.setUpdatePSDEActionName(t.getUpdatePSDEActionName());
        }
        if (t.getUpdatePSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setUpdatePSDEOPPrivId(t.getUpdatePSDEOPPrivId());
        }
        if (t.getUpdatePSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setUpdatePSDEOPPrivName(t.getUpdatePSDEOPPrivName());
        }
        if (t.getUpdateTimeout() != null || !bIgnoreNull) {
            dto.setUpdateTimeout(t.getUpdateTimeout());
        }
        if (t.getUser2PSDEActionId() != null || !bIgnoreNull) {
            dto.setUser2PSDEActionId(t.getUser2PSDEActionId());
        }
        if (t.getUser2PSDEActionName() != null || !bIgnoreNull) {
            dto.setUser2PSDEActionName(t.getUser2PSDEActionName());
        }
        if (t.getUser2PSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setUser2PSDEOPPrivId(t.getUser2PSDEOPPrivId());
        }
        if (t.getUser2PSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setUser2PSDEOPPrivName(t.getUser2PSDEOPPrivName());
        }
        if (t.getUserCat() != null || !bIgnoreNull) {
            dto.setUserCat(t.getUserCat());
        }
        if (t.getUserParams() != null || !bIgnoreNull) {
            dto.setUserParams(t.getUserParams());
        }
        if (t.getUserPSDEActionId() != null || !bIgnoreNull) {
            dto.setUserPSDEActionId(t.getUserPSDEActionId());
        }
        if (t.getUserPSDEActionName() != null || !bIgnoreNull) {
            dto.setUserPSDEActionName(t.getUserPSDEActionName());
        }
        if (t.getUserPSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setUserPSDEOPPrivId(t.getUserPSDEOPPrivId());
        }
        if (t.getUserPSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setUserPSDEOPPrivName(t.getUserPSDEOPPrivName());
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
        if (StringUtils.hasLength((String)dto.getCopyPSDEActionId())) {
            dto.setCopyPSDEActionId(this.getRealPSModelId(t, dto.getCopyPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCreatePSDEActionId())) {
            dto.setCreatePSDEActionId(this.getRealPSModelId(t, dto.getCreatePSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCreatePSDEOPPrivId())) {
            dto.setCreatePSDEOPPrivId(this.getRealPSModelId(t, dto.getCreatePSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getExportPSDEOPPrivId())) {
            dto.setExportPSDEOPPrivId(this.getRealPSModelId(t, dto.getExportPSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGetDraftPSDEActionId())) {
            dto.setGetDraftPSDEActionId(this.getRealPSModelId(t, dto.getGetDraftPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGetPSDEActionId())) {
            dto.setGetPSDEActionId(this.getRealPSModelId(t, dto.getGetPSDEActionId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            dto.setPSModuleId(this.getRealPSModelId(t, dto.getPSModuleId()).replace("/", "."));
        }
        if ("PSMODULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSModuleId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            dto.setPSSysReqItemId(this.getRealPSModelId(t, dto.getPSSysReqItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysUniStateId())) {
            dto.setPSSysUniStateId(this.getRealPSModelId(t, dto.getPSSysUniStateId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysUserDRId())) {
            dto.setPSSysUserDRId(this.getRealPSModelId(t, dto.getPSSysUserDRId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysUserDRId2())) {
            dto.setPSSysUserDRId2(this.getRealPSModelId(t, dto.getPSSysUserDRId2()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getReadPSDEOPPrivId())) {
            dto.setReadPSDEOPPrivId(this.getRealPSModelId(t, dto.getReadPSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRemovePSDEActionId())) {
            dto.setRemovePSDEActionId(this.getRealPSModelId(t, dto.getRemovePSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRemovePSDEOPPrivId())) {
            dto.setRemovePSDEOPPrivId(this.getRealPSModelId(t, dto.getRemovePSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUpdatePSDEActionId())) {
            dto.setUpdatePSDEActionId(this.getRealPSModelId(t, dto.getUpdatePSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUpdatePSDEOPPrivId())) {
            dto.setUpdatePSDEOPPrivId(this.getRealPSModelId(t, dto.getUpdatePSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUser2PSDEActionId())) {
            dto.setUser2PSDEActionId(this.getRealPSModelId(t, dto.getUser2PSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUser2PSDEOPPrivId())) {
            dto.setUser2PSDEOPPrivId(this.getRealPSModelId(t, dto.getUser2PSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUserPSDEActionId())) {
            dto.setUserPSDEActionId(this.getRealPSModelId(t, dto.getUserPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUserPSDEOPPrivId())) {
            dto.setUserPSDEOPPrivId(this.getRealPSModelId(t, dto.getUserPSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCopyPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getCopyPSDEActionId());
            dto.setCopyPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setCopyPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getCreatePSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getCreatePSDEActionId());
            dto.setCreatePSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setCreatePSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getCreatePSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getCreatePSDEOPPrivId());
            dto.setCreatePSDEOPPrivIName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setCreatePSDEOPPrivIName(null);
        }
        if (StringUtils.hasLength((String)dto.getExportPSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getExportPSDEOPPrivId());
            dto.setExportPSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setExportPSDEOPPrivName(null);
        }
        if (StringUtils.hasLength((String)dto.getGetDraftPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getGetDraftPSDEActionId());
            dto.setGetDraftPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setGetDraftPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getGetPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getGetPSDEActionId());
            dto.setGetPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setGetPSDEActionName(null);
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
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            linkDTO = (PSModuleDTO)PSModelServiceUtil.getInstance().getPSModuleService().getDTO(dto.getPSModuleId());
            dto.setPSModuleName(((PSModuleDTO)linkDTO).getPSModuleName());
        } else {
            dto.setPSModuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            linkDTO = (PSSysReqItemDTO)PSModelServiceUtil.getInstance().getPSSysReqItemService().getDTO(dto.getPSSysReqItemId());
            dto.setPSSysReqItemName(((PSSysReqItemDTO)linkDTO).getPSSysReqItemName());
        } else {
            dto.setPSSysReqItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(((PSSystemDTO)linkDTO).getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysUniStateId())) {
            linkDTO = (PSSysUniStateDTO)PSModelServiceUtil.getInstance().getPSSysUniStateService().getDTO(dto.getPSSysUniStateId());
            dto.setPSSysUniStateName(((PSSysUniStateDTO)linkDTO).getPSSysUniStateName());
        } else {
            dto.setPSSysUniStateName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysUserDRId())) {
            linkDTO = (PSSysUserDRDTO)PSModelServiceUtil.getInstance().getPSSysUserDRService().getDTO(dto.getPSSysUserDRId());
            dto.setPSSysUserDRName(((PSSysUserDRDTO)linkDTO).getPSSysUserDRName());
        } else {
            dto.setPSSysUserDRName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysUserDRId2())) {
            linkDTO = (PSSysUserDRDTO)PSModelServiceUtil.getInstance().getPSSysUserDRService().getDTO(dto.getPSSysUserDRId2());
            dto.setPSSysUserDRName2(((PSSysUserDRDTO)linkDTO).getPSSysUserDRName());
        } else {
            dto.setPSSysUserDRName2(null);
        }
        if (StringUtils.hasLength((String)dto.getReadPSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getReadPSDEOPPrivId());
            dto.setReadPSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setReadPSDEOPPrivName(null);
        }
        if (StringUtils.hasLength((String)dto.getRemovePSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getRemovePSDEActionId());
            dto.setRemovePSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setRemovePSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getRemovePSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getRemovePSDEOPPrivId());
            dto.setRemovePSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setRemovePSDEOPPrivName(null);
        }
        if (StringUtils.hasLength((String)dto.getUpdatePSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getUpdatePSDEActionId());
            dto.setUpdatePSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setUpdatePSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getUpdatePSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getUpdatePSDEOPPrivId());
            dto.setUpdatePSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setUpdatePSDEOPPrivName(null);
        }
        if (StringUtils.hasLength((String)dto.getUser2PSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getUser2PSDEActionId());
            dto.setUser2PSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setUser2PSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getUser2PSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getUser2PSDEOPPrivId());
            dto.setUser2PSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setUser2PSDEOPPrivName(null);
        }
        if (StringUtils.hasLength((String)dto.getUserPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getUserPSDEActionId());
            dto.setUserPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setUserPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getUserPSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getUserPSDEOPPrivId());
            dto.setUserPSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setUserPSDEOPPrivName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSACHANDLER";
    }

    @Override
    public PSACHandler createDomain() {
        return new PSACHandler();
    }

    @Override
    public PSACHandlerDTO createDTO() {
        return new PSACHandlerDTO();
    }
}

