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
import net.ibizsys.modelapi.domain.PSDEDSDQ;
import net.ibizsys.modelapi.domain.PSDEDSGrpParam;
import net.ibizsys.modelapi.domain.PSDEDSParam;
import net.ibizsys.modelapi.domain.PSDEDataSet;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSDEDSDQDTO;
import net.ibizsys.modelapi.dto.PSDEDSGrpParamDTO;
import net.ibizsys.modelapi.dto.PSDEDSParamDTO;
import net.ibizsys.modelapi.dto.PSDEDataImpDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEFGroupDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDEOPPrivDTO;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSubSysSADetailDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysUniStateDTO;
import net.ibizsys.modelapi.dto.PSSysUserDRDTO;
import net.ibizsys.modelapi.service.IPSDEDataSetService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEDataSetServiceImpl
extends PSModelServiceImplBase<PSDEDataSet, PSDEDataSetDTO>
implements IPSDEDataSetService {
    private static final Log log = LogFactory.getLog(PSDEDataSetServiceImpl.class);

    @Override
    public List<PSDEDataSet> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEDataSet get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEDataSet> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEDataSet item : list) {
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
    public List<PSDEDataSetDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEDataSet> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEDataSetDTO> dtoList = new ArrayList<PSDEDataSetDTO>();
            for (PSDEDataSet item : list) {
                PSDEDataSetDTO dto = (PSDEDataSetDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEDataSet> onListAll() throws Exception {
        ArrayList<PSDEDataSet> list = new ArrayList<PSDEDataSet>();
        List psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEDataSet> items = this.listByPSDataEntity(parent);
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
    protected PSDEDataSet onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEDataSet item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEDataSet)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEDataSetDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEDataSet et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEDataSetName())) {
            return et.getPSDEDataSetName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEDataSetDTO dto, PSDEDataSet t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEDataSetId(t.getId().replace("/", "."));
        }
        if (t.getActionHolder() != null || !bIgnoreNull) {
            dto.setActionHolder(t.getActionHolder());
        }
        if (t.getADPSDELogicId() != null || !bIgnoreNull) {
            dto.setADPSDELogicId(t.getADPSDELogicId());
        }
        if (t.getADPSDELogicName() != null || !bIgnoreNull) {
            dto.setADPSDELogicName(t.getADPSDELogicName());
        }
        if (t.getAfterCode() != null || !bIgnoreNull) {
            dto.setAfterCode(t.getAfterCode());
        }
        if (t.getAggDataPSDERId() != null || !bIgnoreNull) {
            dto.setAggDataPSDERId(t.getAggDataPSDERId());
        }
        if (t.getAggDataPSDERName() != null || !bIgnoreNull) {
            dto.setAggDataPSDERName(t.getAggDataPSDERName());
        }
        if (t.getBeforeCode() != null || !bIgnoreNull) {
            dto.setBeforeCode(t.getBeforeCode());
        }
        if (t.getCacheCat() != null || !bIgnoreNull) {
            dto.setCacheCat(t.getCacheCat());
        }
        if (t.getCacheCheckState() != null || !bIgnoreNull) {
            dto.setCacheCheckState(t.getCacheCheckState());
        }
        if (t.getCacheScope() != null || !bIgnoreNull) {
            dto.setCacheScope(t.getCacheScope());
        }
        if (t.getCacheStatePSDELogicId() != null || !bIgnoreNull) {
            dto.setCacheStatePSDELogicId(t.getCacheStatePSDELogicId());
        }
        if (t.getCacheStatePSDELogicName() != null || !bIgnoreNull) {
            dto.setCacheStatePSDELogicName(t.getCacheStatePSDELogicName());
        }
        if (t.getCacheTag() != null || !bIgnoreNull) {
            dto.setCacheTag(t.getCacheTag());
        }
        if (t.getCacheTimeout() != null || !bIgnoreNull) {
            dto.setCacheTimeout(t.getCacheTimeout());
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
        if (t.getDataSetSN() != null || !bIgnoreNull) {
            dto.setDataSetSN(t.getDataSetSN());
        }
        if (t.getDefaultMode() != null || !bIgnoreNull) {
            dto.setDefaultMode(t.getDefaultMode());
        }
        if (t.getDSTag() != null || !bIgnoreNull) {
            dto.setDSTag(t.getDSTag());
        }
        if (t.getDSTag2() != null || !bIgnoreNull) {
            dto.setDSTag2(t.getDSTag2());
        }
        if (t.getDSTag3() != null || !bIgnoreNull) {
            dto.setDSTag3(t.getDSTag3());
        }
        if (t.getDSTag4() != null || !bIgnoreNull) {
            dto.setDSTag4(t.getDSTag4());
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
        if (t.getEnableGroup() != null || !bIgnoreNull) {
            dto.setEnableGroup(t.getEnableGroup());
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
        if (t.getEnableTempData() != null || !bIgnoreNull) {
            dto.setEnableTempData(t.getEnableTempData());
        }
        if (t.getEnableUserDR() != null || !bIgnoreNull) {
            dto.setEnableUserDR(t.getEnableUserDR());
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
        if (t.getMajorPSDEFId() != null || !bIgnoreNull) {
            dto.setMajorPSDEFId(t.getMajorPSDEFId());
        }
        if (t.getMajorPSDEFName() != null || !bIgnoreNull) {
            dto.setMajorPSDEFName(t.getMajorPSDEFName());
        }
        if (t.getMajorSortDir() != null || !bIgnoreNull) {
            dto.setMajorSortDir(t.getMajorSortDir());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMinorPSDEFId() != null || !bIgnoreNull) {
            dto.setMinorPSDEFId(t.getMinorPSDEFId());
        }
        if (t.getMinorPSDEFName() != null || !bIgnoreNull) {
            dto.setMinorPSDEFName(t.getMinorPSDEFName());
        }
        if (t.getMinorSortDir() != null || !bIgnoreNull) {
            dto.setMinorSortDir(t.getMinorSortDir());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getOrgDR() != null || !bIgnoreNull) {
            dto.setOrgDR(t.getOrgDR());
        }
        if (t.getOutPSDEFGroupId() != null || !bIgnoreNull) {
            dto.setOutPSDEFGroupId(t.getOutPSDEFGroupId());
        }
        if (t.getOutPSDEFGroupName() != null || !bIgnoreNull) {
            dto.setOutPSDEFGroupName(t.getOutPSDEFGroupName());
        }
        if (t.getPageSize() != null || !bIgnoreNull) {
            dto.setPageSize(t.getPageSize());
        }
        if (t.getParamType() != null || !bIgnoreNull) {
            dto.setParamType(t.getParamType());
        }
        if (t.getPOTime() != null || !bIgnoreNull) {
            dto.setPOTime(t.getPOTime());
        }
        if (t.getPredefinedTypeText() != null || !bIgnoreNull) {
            dto.setPredefinedTypeText(t.getPredefinedTypeText());
        }
        if (t.getPredefineType() != null || !bIgnoreNull) {
            dto.setPredefineType(t.getPredefineType());
        }
        if (t.getPSCodeListId() != null || !bIgnoreNull) {
            dto.setPSCodeListId(t.getPSCodeListId());
        }
        if (t.getPSCodeListName() != null || !bIgnoreNull) {
            dto.setPSCodeListName(t.getPSCodeListName());
        }
        if (t.getPSDEDataImpId() != null || !bIgnoreNull) {
            dto.setPSDEDataImpId(t.getPSDEDataImpId());
        }
        if (t.getPSDEDataImpName() != null || !bIgnoreNull) {
            dto.setPSDEDataImpName(t.getPSDEDataImpName());
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
        if (t.getPSSubSysSADEId() != null || !bIgnoreNull) {
            dto.setPSSubSysSADEId(t.getPSSubSysSADEId());
        }
        if (t.getPSSubSysSADetailId() != null || !bIgnoreNull) {
            dto.setPSSubSysSADetailId(t.getPSSubSysSADetailId());
        }
        if (t.getPSSubSysSADetailName() != null || !bIgnoreNull) {
            dto.setPSSubSysSADetailName(t.getPSSubSysSADetailName());
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
        if (t.getPubMode() != null || !bIgnoreNull) {
            dto.setPubMode(t.getPubMode());
        }
        if (t.getRawServiceMethod() != null || !bIgnoreNull) {
            dto.setRawServiceMethod(t.getRawServiceMethod());
        }
        if (t.getRawServiceUrl() != null || !bIgnoreNull) {
            dto.setRawServiceUrl(t.getRawServiceUrl());
        }
        if (t.getRequestMethod() != null || !bIgnoreNull) {
            dto.setRequestMethod(t.getRequestMethod());
        }
        if (t.getRequestPath() != null || !bIgnoreNull) {
            dto.setRequestPath(t.getRequestPath());
        }
        if (t.getRetValType() != null || !bIgnoreNull) {
            dto.setRetValType(t.getRetValType());
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
        if (StringUtils.hasLength((String)dto.getADPSDELogicId())) {
            dto.setADPSDELogicId(this.getRealPSModelId(t, dto.getADPSDELogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getAggDataPSDERId())) {
            dto.setAggDataPSDERId(this.getRealPSModelId(t, dto.getAggDataPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCacheStatePSDELogicId())) {
            dto.setCacheStatePSDELogicId(this.getRealPSModelId(t, dto.getCacheStatePSDELogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getInPSDEFGroupId())) {
            dto.setInPSDEFGroupId(this.getRealPSModelId(t, dto.getInPSDEFGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getInPSSysDynaModelId())) {
            dto.setInPSSysDynaModelId(this.getRealPSModelId(t, dto.getInPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMajorPSDEFId())) {
            dto.setMajorPSDEFId(this.getRealPSModelId(t, dto.getMajorPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMinorPSDEFId())) {
            dto.setMinorPSDEFId(this.getRealPSModelId(t, dto.getMinorPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOutPSDEFGroupId())) {
            dto.setOutPSDEFGroupId(this.getRealPSModelId(t, dto.getOutPSDEFGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            dto.setPSCodeListId(this.getRealPSModelId(t, dto.getPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataImpId())) {
            dto.setPSDEDataImpId(this.getRealPSModelId(t, dto.getPSDEDataImpId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            dto.setPSSysReqItemId(this.getRealPSModelId(t, dto.getPSSysReqItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getADPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getADPSDELogicId());
            dto.setADPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setADPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getAggDataPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getAggDataPSDERId());
            dto.setAggDataPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setAggDataPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getCacheStatePSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getCacheStatePSDELogicId());
            dto.setCacheStatePSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setCacheStatePSDELogicName(null);
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
        if (StringUtils.hasLength((String)dto.getMajorPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getMajorPSDEFId());
            dto.setMajorPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setMajorPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getMinorPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getMinorPSDEFId());
            dto.setMinorPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setMinorPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getOutPSDEFGroupId())) {
            linkDTO = (PSDEFGroupDTO)PSModelServiceUtil.getInstance().getPSDEFGroupService().getDTO(dto.getOutPSDEFGroupId());
            dto.setOutPSDEFGroupName(((PSDEFGroupDTO)linkDTO).getPSDEFGroupName());
        } else {
            dto.setOutPSDEFGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getPSCodeListId());
            dto.setPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setPSCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataImpId())) {
            linkDTO = (PSDEDataImpDTO)PSModelServiceUtil.getInstance().getPSDEDataImpService().getDTO(dto.getPSDEDataImpId());
            dto.setPSDEDataImpName(((PSDEDataImpDTO)linkDTO).getPSDEDataImpName());
        } else {
            dto.setPSDEDataImpName(null);
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
        List<PSModelBase> list = PSModelServiceUtil.getInstance().getPSDEDSParamService().listByPSDEDataSet(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDEDSParamDTO> psdedsparams = new ArrayList<PSDEDSParamDTO>();
            for (PSDEDSParam pSDEDSParam : list) {
                dstItem = (PSDEDSParamDTO)PSModelServiceUtil.getInstance().getPSDEDSParamService().toDTO(pSDEDSParam);
                psdedsparams.add((PSDEDSParamDTO)dstItem);
            }
            dto.setPsdedsparams(psdedsparams);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSDEDSDQService().listByPSDEDataSet(t)) != null && list.size() > 0) {
            ArrayList<PSDEDSDQDTO> psdedsdqs = new ArrayList<PSDEDSDQDTO>();
            for (PSDEDSDQ pSDEDSDQ : list) {
                dstItem = (PSDEDSDQDTO)PSModelServiceUtil.getInstance().getPSDEDSDQService().toDTO(pSDEDSDQ);
                psdedsdqs.add((PSDEDSDQDTO)dstItem);
            }
            dto.setPsdedsdqs(psdedsdqs);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSDEDSGrpParamService().listByPSDEDataSet(t)) != null && list.size() > 0) {
            ArrayList<PSDEDSGrpParamDTO> psdedsgrpparams = new ArrayList<PSDEDSGrpParamDTO>();
            for (PSDEDSGrpParam pSDEDSGrpParam : list) {
                dstItem = (PSDEDSGrpParamDTO)PSModelServiceUtil.getInstance().getPSDEDSGrpParamService().toDTO(pSDEDSGrpParam);
                psdedsgrpparams.add((PSDEDSGrpParamDTO)dstItem);
            }
            dto.setPsdedsgrpparams(psdedsgrpparams);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEDATASET";
    }

    @Override
    public PSDEDataSet createDomain() {
        return new PSDEDataSet();
    }

    @Override
    public PSDEDataSetDTO createDTO() {
        return new PSDEDataSetDTO();
    }
}

