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
import net.ibizsys.modelapi.domain.PSDER;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEACModeDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSDERService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDERServiceImpl
extends PSModelServiceImplBase<PSDER, PSDERDTO>
implements IPSDERService {
    private static final Log log = LogFactory.getLog(PSDERServiceImpl.class);

    @Override
    public List<PSDER> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDER get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDER> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDER item : list) {
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
    public List<PSDERDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDER> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDERDTO> dtoList = new ArrayList<PSDERDTO>();
            for (PSDER item : list) {
                PSDERDTO dto = (PSDERDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDER> onListAll() throws Exception {
        ArrayList<PSDER> list = new ArrayList<PSDER>();
        List psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDER> items = this.listByPSDataEntity(parent);
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
    protected PSDER onGet(String strParentKey, String strCurKey) throws Exception {
        PSDER item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDER)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDERDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getMinorPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDER et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDERName())) {
            return et.getPSDERName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDERDTO dto, PSDER t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDERId(t.getId().replace("/", "."));
        }
        if (t.getCloneOrderValue() != null || !bIgnoreNull) {
            dto.setCloneOrderValue(t.getCloneOrderValue());
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
        if (t.getDEFInheritMode() != null || !bIgnoreNull) {
            dto.setDEFInheritMode(t.getDEFInheritMode());
        }
        if (t.getDERFieldLName() != null || !bIgnoreNull) {
            dto.setDERFieldLName(t.getDERFieldLName());
        }
        if (t.getDERFieldName() != null || !bIgnoreNull) {
            dto.setDERFieldName(t.getDERFieldName());
        }
        if (t.getDERSubType() != null || !bIgnoreNull) {
            dto.setDERSubType(t.getDERSubType());
        }
        if (t.getDERType() != null || !bIgnoreNull) {
            dto.setDERType(t.getDERType());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getEnaDEFieldWriteBack() != null || !bIgnoreNull) {
            dto.setEnaDEFieldWriteBack(t.getEnaDEFieldWriteBack());
        }
        if (t.getEnaExtRange() != null || !bIgnoreNull) {
            dto.setEnaExtRange(t.getEnaExtRange());
        }
        if (t.getEnaPDEREQ() != null || !bIgnoreNull) {
            dto.setEnaPDEREQ(t.getEnaPDEREQ());
        }
        if (t.getExportMajorModel() != null || !bIgnoreNull) {
            dto.setExportMajorModel(t.getExportMajorModel());
        }
        if (t.getExportModel() != null || !bIgnoreNull) {
            dto.setExportModel(t.getExportModel());
        }
        if (t.getExportScope() != null || !bIgnoreNull) {
            dto.setExportScope(t.getExportScope());
        }
        if (t.getExportScope2() != null || !bIgnoreNull) {
            dto.setExportScope2(t.getExportScope2());
        }
        if (t.getExportScope3() != null || !bIgnoreNull) {
            dto.setExportScope3(t.getExportScope3());
        }
        if (t.getExportScope4() != null || !bIgnoreNull) {
            dto.setExportScope4(t.getExportScope4());
        }
        if (t.getExportScope5() != null || !bIgnoreNull) {
            dto.setExportScope5(t.getExportScope5());
        }
        if (t.getExportScope6() != null || !bIgnoreNull) {
            dto.setExportScope6(t.getExportScope6());
        }
        if (t.getEXTMajorPSDEFId() != null || !bIgnoreNull) {
            dto.setEXTMajorPSDEFId(t.getEXTMajorPSDEFId());
        }
        if (t.getEXTMajorPSDEFName() != null || !bIgnoreNull) {
            dto.setEXTMajorPSDEFName(t.getEXTMajorPSDEFName());
        }
        if (t.getEXTMinorPSDEFId() != null || !bIgnoreNull) {
            dto.setEXTMinorPSDEFId(t.getEXTMinorPSDEFId());
        }
        if (t.getEXTMinorPSDEFName() != null || !bIgnoreNull) {
            dto.setEXTMinorPSDEFName(t.getEXTMinorPSDEFName());
        }
        if (t.getFKeyName() != null || !bIgnoreNull) {
            dto.setFKeyName(t.getFKeyName());
        }
        if (t.getForeignKey() != null || !bIgnoreNull) {
            dto.setForeignKey(t.getForeignKey());
        }
        if (t.getIgnoreDEFields() != null || !bIgnoreNull) {
            dto.setIgnoreDEFields(t.getIgnoreDEFields());
        }
        if (t.getIndexValue() != null || !bIgnoreNull) {
            dto.setIndexValue(t.getIndexValue());
        }
        if (t.getInheritMode() != null || !bIgnoreNull) {
            dto.setInheritMode(t.getInheritMode());
        }
        if (t.getLinkPSDEViewId() != null || !bIgnoreNull) {
            dto.setLinkPSDEViewId(t.getLinkPSDEViewId());
        }
        if (t.getLinkPSDEViewName() != null || !bIgnoreNull) {
            dto.setLinkPSDEViewName(t.getLinkPSDEViewName());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMajorPSDEId() != null || !bIgnoreNull) {
            dto.setMajorPSDEId(t.getMajorPSDEId());
        }
        if (t.getMajorPSDEName() != null || !bIgnoreNull) {
            dto.setMajorPSDEName(t.getMajorPSDEName());
        }
        if (t.getMajorPSDERId() != null || !bIgnoreNull) {
            dto.setMajorPSDERId(t.getMajorPSDERId());
        }
        if (t.getMajorPSDERName() != null || !bIgnoreNull) {
            dto.setMajorPSDERName(t.getMajorPSDERName());
        }
        if (t.getMasterOrderValue() != null || !bIgnoreNull) {
            dto.setMasterOrderValue(t.getMasterOrderValue());
        }
        if (t.getMasterRS() != null || !bIgnoreNull) {
            dto.setMasterRS(t.getMasterRS());
        }
        if (t.getMDPSDEViewId() != null || !bIgnoreNull) {
            dto.setMDPSDEViewId(t.getMDPSDEViewId());
        }
        if (t.getMDPSDEViewName() != null || !bIgnoreNull) {
            dto.setMDPSDEViewName(t.getMDPSDEViewName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMinorCodeName() != null || !bIgnoreNull) {
            dto.setMinorCodeName(t.getMinorCodeName());
        }
        if (t.getMinorPSDEDSId() != null || !bIgnoreNull) {
            dto.setMinorPSDEDSId(t.getMinorPSDEDSId());
        }
        if (t.getMinorPSDEDSName() != null || !bIgnoreNull) {
            dto.setMinorPSDEDSName(t.getMinorPSDEDSName());
        }
        if (t.getMinorPSDEId() != null || !bIgnoreNull) {
            dto.setMinorPSDEId(t.getMinorPSDEId());
        }
        if (t.getMinorPSDEName() != null || !bIgnoreNull) {
            dto.setMinorPSDEName(t.getMinorPSDEName());
        }
        if (t.getMinorPSDERId() != null || !bIgnoreNull) {
            dto.setMinorPSDERId(t.getMinorPSDERId());
        }
        if (t.getMinorPSDERName() != null || !bIgnoreNull) {
            dto.setMinorPSDERName(t.getMinorPSDERName());
        }
        if (t.getMobLinkPSDEViewId() != null || !bIgnoreNull) {
            dto.setMobLinkPSDEViewId(t.getMobLinkPSDEViewId());
        }
        if (t.getMobLinkPSDEViewName() != null || !bIgnoreNull) {
            dto.setMobLinkPSDEViewName(t.getMobLinkPSDEViewName());
        }
        if (t.getMobMDPSDEViewId() != null || !bIgnoreNull) {
            dto.setMobMDPSDEViewId(t.getMobMDPSDEViewId());
        }
        if (t.getMobMDPSDEViewName() != null || !bIgnoreNull) {
            dto.setMobMDPSDEViewName(t.getMobMDPSDEViewName());
        }
        if (t.getMobSDPSDEViewId() != null || !bIgnoreNull) {
            dto.setMobSDPSDEViewId(t.getMobSDPSDEViewId());
        }
        if (t.getMobSDPSDEViewName() != null || !bIgnoreNull) {
            dto.setMobSDPSDEViewName(t.getMobSDPSDEViewName());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPropertyMap() != null || !bIgnoreNull) {
            dto.setPropertyMap(t.getPropertyMap());
        }
        if (t.getPSDEACModeId() != null || !bIgnoreNull) {
            dto.setPSDEACModeId(t.getPSDEACModeId());
        }
        if (t.getPSDEACModeName() != null || !bIgnoreNull) {
            dto.setPSDEACModeName(t.getPSDEACModeName());
        }
        if (t.getPSDEDataSetId() != null || !bIgnoreNull) {
            dto.setPSDEDataSetId(t.getPSDEDataSetId());
        }
        if (t.getPSDEDataSetName() != null || !bIgnoreNull) {
            dto.setPSDEDataSetName(t.getPSDEDataSetName());
        }
        if (t.getPSDERName() != null || !bIgnoreNull) {
            dto.setPSDERName(t.getPSDERName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getRemoveActionType() != null || !bIgnoreNull) {
            dto.setRemoveActionType(t.getRemoveActionType());
        }
        if (t.getRemoveOrder() != null || !bIgnoreNull) {
            dto.setRemoveOrder(t.getRemoveOrder());
        }
        if (t.getRemoveRejectMsg() != null || !bIgnoreNull) {
            dto.setRemoveRejectMsg(t.getRemoveRejectMsg());
        }
        if (t.getRemoveRejectPSLanResId() != null || !bIgnoreNull) {
            dto.setRemoveRejectPSLanResId(t.getRemoveRejectPSLanResId());
        }
        if (t.getRemoveRejectPSLanResName() != null || !bIgnoreNull) {
            dto.setRemoveRejectPSLanResName(t.getRemoveRejectPSLanResName());
        }
        if (t.getRSPSDEViewId() != null || !bIgnoreNull) {
            dto.setRSPSDEViewId(t.getRSPSDEViewId());
        }
        if (t.getRSPSDEViewName() != null || !bIgnoreNull) {
            dto.setRSPSDEViewName(t.getRSPSDEViewName());
        }
        if (t.getSDPSDEViewID() != null || !bIgnoreNull) {
            dto.setSDPSDEViewID(t.getSDPSDEViewID());
        }
        if (t.getSDPSDEViewName() != null || !bIgnoreNull) {
            dto.setSDPSDEViewName(t.getSDPSDEViewName());
        }
        if (t.getSyncExportModel() != null || !bIgnoreNull) {
            dto.setSyncExportModel(t.getSyncExportModel());
        }
        if (t.getTempOrderValue() != null || !bIgnoreNull) {
            dto.setTempOrderValue(t.getTempOrderValue());
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
        if (StringUtils.hasLength((String)dto.getEXTMajorPSDEFId())) {
            dto.setEXTMajorPSDEFId(this.getRealPSModelId(t, dto.getEXTMajorPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getEXTMinorPSDEFId())) {
            dto.setEXTMinorPSDEFId(this.getRealPSModelId(t, dto.getEXTMinorPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLinkPSDEViewId())) {
            dto.setLinkPSDEViewId(this.getRealPSModelId(t, dto.getLinkPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMajorPSDEId())) {
            dto.setMajorPSDEId(this.getRealPSModelId(t, dto.getMajorPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMajorPSDERId())) {
            dto.setMajorPSDERId(this.getRealPSModelId(t, dto.getMajorPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMDPSDEViewId())) {
            dto.setMDPSDEViewId(this.getRealPSModelId(t, dto.getMDPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMinorPSDEDSId())) {
            dto.setMinorPSDEDSId(this.getRealPSModelId(t, dto.getMinorPSDEDSId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMinorPSDEId())) {
            dto.setMinorPSDEId(this.getRealPSModelId(t, dto.getMinorPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setMinorPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMinorPSDERId())) {
            dto.setMinorPSDERId(this.getRealPSModelId(t, dto.getMinorPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMobLinkPSDEViewId())) {
            dto.setMobLinkPSDEViewId(this.getRealPSModelId(t, dto.getMobLinkPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMobMDPSDEViewId())) {
            dto.setMobMDPSDEViewId(this.getRealPSModelId(t, dto.getMobMDPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMobSDPSDEViewId())) {
            dto.setMobSDPSDEViewId(this.getRealPSModelId(t, dto.getMobSDPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEACModeId())) {
            dto.setPSDEACModeId(this.getRealPSModelId(t, dto.getPSDEACModeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataSetId())) {
            dto.setPSDEDataSetId(this.getRealPSModelId(t, dto.getPSDEDataSetId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRemoveRejectPSLanResId())) {
            dto.setRemoveRejectPSLanResId(this.getRealPSModelId(t, dto.getRemoveRejectPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRSPSDEViewId())) {
            dto.setRSPSDEViewId(this.getRealPSModelId(t, dto.getRSPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getSDPSDEViewID())) {
            dto.setSDPSDEViewID(this.getRealPSModelId(t, dto.getSDPSDEViewID()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getEXTMajorPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getEXTMajorPSDEFId());
            dto.setEXTMajorPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setEXTMajorPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getEXTMinorPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getEXTMinorPSDEFId());
            dto.setEXTMinorPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setEXTMinorPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getLinkPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getLinkPSDEViewId());
            dto.setLinkPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setLinkPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getMajorPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getMajorPSDEId());
            dto.setMajorPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setMajorPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getMajorPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getMajorPSDERId());
            dto.setMajorPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setMajorPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getMDPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getMDPSDEViewId());
            dto.setMDPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setMDPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getMinorPSDEDSId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getMinorPSDEDSId());
            dto.setMinorPSDEDSName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setMinorPSDEDSName(null);
        }
        if (StringUtils.hasLength((String)dto.getMinorPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getMinorPSDEId());
            dto.setMinorPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setMinorPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getMinorPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getMinorPSDERId());
            dto.setMinorPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setMinorPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getMobLinkPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getMobLinkPSDEViewId());
            dto.setMobLinkPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setMobLinkPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getMobMDPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getMobMDPSDEViewId());
            dto.setMobMDPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setMobMDPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getMobSDPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getMobSDPSDEViewId());
            dto.setMobSDPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setMobSDPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEACModeId())) {
            linkDTO = (PSDEACModeDTO)PSModelServiceUtil.getInstance().getPSDEACModeService().getDTO(dto.getPSDEACModeId());
            dto.setPSDEACModeName(((PSDEACModeDTO)linkDTO).getPSDEACModeName());
        } else {
            dto.setPSDEACModeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataSetId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getPSDEDataSetId());
            dto.setPSDEDataSetName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setPSDEDataSetName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(((PSSystemDTO)linkDTO).getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        if (StringUtils.hasLength((String)dto.getRemoveRejectPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getRemoveRejectPSLanResId());
            dto.setRemoveRejectPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setRemoveRejectPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getRSPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getRSPSDEViewId());
            dto.setRSPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setRSPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getSDPSDEViewID())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getSDPSDEViewID());
            dto.setSDPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setSDPSDEViewName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSDER";
    }

    @Override
    public PSDER createDomain() {
        return new PSDER();
    }

    @Override
    public PSDERDTO createDTO() {
        return new PSDERDTO();
    }
}

