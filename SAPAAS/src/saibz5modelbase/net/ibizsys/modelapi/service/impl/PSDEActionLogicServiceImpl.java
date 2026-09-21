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
import net.ibizsys.modelapi.domain.PSDEActionLogic;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEActionLogicDTO;
import net.ibizsys.modelapi.dto.PSDEDataQueryDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEDataSyncDTO;
import net.ibizsys.modelapi.dto.PSDEFValueRuleDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDEMainStateDTO;
import net.ibizsys.modelapi.dto.PSDENotifyDTO;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysDELogicNodeDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysSequenceDTO;
import net.ibizsys.modelapi.dto.PSSysTranslatorDTO;
import net.ibizsys.modelapi.dto.PSSysValueRuleDTO;
import net.ibizsys.modelapi.service.IPSDEActionLogicService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEActionLogicServiceImpl
extends PSModelServiceImplBase<PSDEActionLogic, PSDEActionLogicDTO>
implements IPSDEActionLogicService {
    private static final Log log = LogFactory.getLog(PSDEActionLogicServiceImpl.class);

    @Override
    public List<PSDEActionLogic> listByPSDEAction(PSDEAction parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEActionLogic get(PSDEAction parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEActionLogic> list = this.listByPSDEAction(parent);
        if (list != null) {
            for (PSDEActionLogic item : list) {
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
    public List<PSDEActionLogicDTO> listDTOByPSDEAction(String strParentKey) throws Exception {
        PSDEAction psdeaction = (PSDEAction)PSModelServiceUtil.getInstance().getPSDEActionService().get(strParentKey);
        List<PSDEActionLogic> list = this.listByPSDEAction(psdeaction);
        if (list != null) {
            ArrayList<PSDEActionLogicDTO> dtoList = new ArrayList<PSDEActionLogicDTO>();
            for (PSDEActionLogic item : list) {
                PSDEActionLogicDTO dto = (PSDEActionLogicDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEActionLogic> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEActionLogic get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEActionLogic> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEActionLogic item : list) {
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
    public List<PSDEActionLogicDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEActionLogic> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEActionLogicDTO> dtoList = new ArrayList<PSDEActionLogicDTO>();
            for (PSDEActionLogic item : list) {
                PSDEActionLogicDTO dto = (PSDEActionLogicDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEActionLogic> onListAll() throws Exception {
        ArrayList<PSDEActionLogic> list = new ArrayList<PSDEActionLogic>();
        List psdeactions = PSModelServiceUtil.getInstance().getPSDEActionService().listAll();
        if (psdeactions != null) {
            for (PSDEAction parent : psdeactions) {
                List<PSDEActionLogic> items = this.listByPSDEAction(parent);
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
    protected PSDEActionLogic onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEActionLogic item;
        PSDEAction psdeaction = (PSDEAction)PSModelServiceUtil.getInstance().getPSDEActionService().get(strParentKey, true);
        if (psdeaction != null && (item = this.get(psdeaction, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEActionLogic)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEActionLogicDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEActionId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEActionService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEActionLogic et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEActionLogicDTO dto, PSDEActionLogic t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEActionLogicId(t.getId().replace("/", "."));
        }
        if (t.getAttachMode() != null || !bIgnoreNull) {
            dto.setAttachMode(t.getAttachMode());
        }
        if (t.getCloneParamFlag() != null || !bIgnoreNull) {
            dto.setCloneParamFlag(t.getCloneParamFlag());
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
        if (t.getDstPSDEActionId() != null || !bIgnoreNull) {
            dto.setDstPSDEActionId(t.getDstPSDEActionId());
        }
        if (t.getDstPSDEActionName() != null || !bIgnoreNull) {
            dto.setDstPSDEActionName(t.getDstPSDEActionName());
        }
        if (t.getDstPSDEDataQueryId() != null || !bIgnoreNull) {
            dto.setDstPSDEDataQueryId(t.getDstPSDEDataQueryId());
        }
        if (t.getDstPSDEDataQueryName() != null || !bIgnoreNull) {
            dto.setDstPSDEDataQueryName(t.getDstPSDEDataQueryName());
        }
        if (t.getDstPSDEDataSetId() != null || !bIgnoreNull) {
            dto.setDstPSDEDataSetId(t.getDstPSDEDataSetId());
        }
        if (t.getDstPSDEDataSetName() != null || !bIgnoreNull) {
            dto.setDstPSDEDataSetName(t.getDstPSDEDataSetName());
        }
        if (t.getDstPSDEId() != null || !bIgnoreNull) {
            dto.setDstPSDEId(t.getDstPSDEId());
        }
        if (t.getDstPSDEName() != null || !bIgnoreNull) {
            dto.setDstPSDEName(t.getDstPSDEName());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getErrorCode() != null || !bIgnoreNull) {
            dto.setErrorCode(t.getErrorCode());
        }
        if (t.getErrorMsg() != null || !bIgnoreNull) {
            dto.setErrorMsg(t.getErrorMsg());
        }
        if (t.getErrorPSLanResId() != null || !bIgnoreNull) {
            dto.setErrorPSLanResId(t.getErrorPSLanResId());
        }
        if (t.getErrorPSLanResName() != null || !bIgnoreNull) {
            dto.setErrorPSLanResName(t.getErrorPSLanResName());
        }
        if (t.getExceptionObj() != null || !bIgnoreNull) {
            dto.setExceptionObj(t.getExceptionObj());
        }
        if (t.getIgnoreException() != null || !bIgnoreNull) {
            dto.setIgnoreException(t.getIgnoreException());
        }
        if (t.getInternalLogic() != null || !bIgnoreNull) {
            dto.setInternalLogic(t.getInternalLogic());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getLogicHolder() != null || !bIgnoreNull) {
            dto.setLogicHolder(t.getLogicHolder());
        }
        if (t.getMajorPSDERId() != null || !bIgnoreNull) {
            dto.setMajorPSDERId(t.getMajorPSDERId());
        }
        if (t.getMajorPSDERName() != null || !bIgnoreNull) {
            dto.setMajorPSDERName(t.getMajorPSDERName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMinorPSDERId() != null || !bIgnoreNull) {
            dto.setMinorPSDERId(t.getMinorPSDERId());
        }
        if (t.getMinorPSDERName() != null || !bIgnoreNull) {
            dto.setMinorPSDERName(t.getMinorPSDERName());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPrepareLast() != null || !bIgnoreNull) {
            dto.setPrepareLast(t.getPrepareLast());
        }
        if (t.getPropertyMap() != null || !bIgnoreNull) {
            dto.setPropertyMap(t.getPropertyMap());
        }
        if (t.getPSDEActionId() != null || !bIgnoreNull) {
            dto.setPSDEActionId(t.getPSDEActionId());
        }
        if (t.getPSDEActionLogicName() != null || !bIgnoreNull) {
            dto.setPSDEActionLogicName(t.getPSDEActionLogicName());
        }
        if (t.getPSDEActionName() != null || !bIgnoreNull) {
            dto.setPSDEActionName(t.getPSDEActionName());
        }
        if (t.getPSDEDataSyncId() != null || !bIgnoreNull) {
            dto.setPSDEDataSyncId(t.getPSDEDataSyncId());
        }
        if (t.getPSDEDataSyncName() != null || !bIgnoreNull) {
            dto.setPSDEDataSyncName(t.getPSDEDataSyncName());
        }
        if (t.getPSDEFId() != null || !bIgnoreNull) {
            dto.setPSDEFId(t.getPSDEFId());
        }
        if (t.getPSDEFName() != null || !bIgnoreNull) {
            dto.setPSDEFName(t.getPSDEFName());
        }
        if (t.getPSDEFValueRuleId() != null || !bIgnoreNull) {
            dto.setPSDEFValueRuleId(t.getPSDEFValueRuleId());
        }
        if (t.getPSDEFValueRuleName() != null || !bIgnoreNull) {
            dto.setPSDEFValueRuleName(t.getPSDEFValueRuleName());
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
        if (t.getPSDEMainStateId() != null || !bIgnoreNull) {
            dto.setPSDEMainStateId(t.getPSDEMainStateId());
        }
        if (t.getPSDEMainStateName() != null || !bIgnoreNull) {
            dto.setPSDEMainStateName(t.getPSDEMainStateName());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDENotifyId() != null || !bIgnoreNull) {
            dto.setPSDENotifyId(t.getPSDENotifyId());
        }
        if (t.getPSDENotifyName() != null || !bIgnoreNull) {
            dto.setPSDENotifyName(t.getPSDENotifyName());
        }
        if (t.getPSSysDELogicNodeId() != null || !bIgnoreNull) {
            dto.setPSSysDELogicNodeId(t.getPSSysDELogicNodeId());
        }
        if (t.getPSSysDELogicNodeName() != null || !bIgnoreNull) {
            dto.setPSSysDELogicNodeName(t.getPSSysDELogicNodeName());
        }
        if (t.getPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginId(t.getPSSysPFPluginId());
        }
        if (t.getPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginName(t.getPSSysPFPluginName());
        }
        if (t.getPSSysSequenceId() != null || !bIgnoreNull) {
            dto.setPSSysSequenceId(t.getPSSysSequenceId());
        }
        if (t.getPSSysSequenceName() != null || !bIgnoreNull) {
            dto.setPSSysSequenceName(t.getPSSysSequenceName());
        }
        if (t.getPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginId(t.getPSSysSFPluginId());
        }
        if (t.getPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginName(t.getPSSysSFPluginName());
        }
        if (t.getPSSysTranslatorId() != null || !bIgnoreNull) {
            dto.setPSSysTranslatorId(t.getPSSysTranslatorId());
        }
        if (t.getPSSysTranslatorName() != null || !bIgnoreNull) {
            dto.setPSSysTranslatorName(t.getPSSysTranslatorName());
        }
        if (t.getPSSysValueRuleId() != null || !bIgnoreNull) {
            dto.setPSSysValueRuleId(t.getPSSysValueRuleId());
        }
        if (t.getPSSysValueRuleName() != null || !bIgnoreNull) {
            dto.setPSSysValueRuleName(t.getPSSysValueRuleName());
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
        if (StringUtils.hasLength((String)dto.getDstPSDEActionId())) {
            dto.setDstPSDEActionId(this.getRealPSModelId(t, dto.getDstPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEDataQueryId())) {
            dto.setDstPSDEDataQueryId(this.getRealPSModelId(t, dto.getDstPSDEDataQueryId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEDataSetId())) {
            dto.setDstPSDEDataSetId(this.getRealPSModelId(t, dto.getDstPSDEDataSetId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEId())) {
            dto.setDstPSDEId(this.getRealPSModelId(t, dto.getDstPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getErrorPSLanResId())) {
            dto.setErrorPSLanResId(this.getRealPSModelId(t, dto.getErrorPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMajorPSDERId())) {
            dto.setMajorPSDERId(this.getRealPSModelId(t, dto.getMajorPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMinorPSDERId())) {
            dto.setMinorPSDERId(this.getRealPSModelId(t, dto.getMinorPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            dto.setPSDEActionId(this.getRealPSModelId(t, dto.getPSDEActionId()).replace("/", "."));
        }
        if ("PSDEACTION".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEActionId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataSyncId())) {
            dto.setPSDEDataSyncId(this.getRealPSModelId(t, dto.getPSDEDataSyncId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFValueRuleId())) {
            dto.setPSDEFValueRuleId(this.getRealPSModelId(t, dto.getPSDEFValueRuleId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSDEMainStateId())) {
            dto.setPSDEMainStateId(this.getRealPSModelId(t, dto.getPSDEMainStateId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDENotifyId())) {
            dto.setPSDENotifyId(this.getRealPSModelId(t, dto.getPSDENotifyId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDELogicNodeId())) {
            dto.setPSSysDELogicNodeId(this.getRealPSModelId(t, dto.getPSSysDELogicNodeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSequenceId())) {
            dto.setPSSysSequenceId(this.getRealPSModelId(t, dto.getPSSysSequenceId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysTranslatorId())) {
            dto.setPSSysTranslatorId(this.getRealPSModelId(t, dto.getPSSysTranslatorId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysValueRuleId())) {
            dto.setPSSysValueRuleId(this.getRealPSModelId(t, dto.getPSSysValueRuleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getDstPSDEActionId());
            dto.setDstPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setDstPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEDataQueryId())) {
            linkDTO = (PSDEDataQueryDTO)PSModelServiceUtil.getInstance().getPSDEDataQueryService().getDTO(dto.getDstPSDEDataQueryId());
            dto.setDstPSDEDataQueryName(((PSDEDataQueryDTO)linkDTO).getPSDEDataQueryName());
        } else {
            dto.setDstPSDEDataQueryName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEDataSetId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getDstPSDEDataSetId());
            dto.setDstPSDEDataSetName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setDstPSDEDataSetName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getDstPSDEId());
            dto.setDstPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setDstPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getErrorPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getErrorPSLanResId());
            dto.setErrorPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setErrorPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getMajorPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getMajorPSDERId());
            dto.setMajorPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setMajorPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getMinorPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getMinorPSDERId());
            dto.setMinorPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setMinorPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getPSDEActionId());
            dto.setPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataSyncId())) {
            linkDTO = (PSDEDataSyncDTO)PSModelServiceUtil.getInstance().getPSDEDataSyncService().getDTO(dto.getPSDEDataSyncId());
            dto.setPSDEDataSyncName(((PSDEDataSyncDTO)linkDTO).getPSDEDataSyncName());
        } else {
            dto.setPSDEDataSyncName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFValueRuleId())) {
            linkDTO = (PSDEFValueRuleDTO)PSModelServiceUtil.getInstance().getPSDEFValueRuleService().getDTO(dto.getPSDEFValueRuleId());
            dto.setPSDEFValueRuleName(((PSDEFValueRuleDTO)linkDTO).getPSDEFValueRuleName());
        } else {
            dto.setPSDEFValueRuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getPSDELogicId());
            dto.setPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEMainStateId())) {
            linkDTO = (PSDEMainStateDTO)PSModelServiceUtil.getInstance().getPSDEMainStateService().getDTO(dto.getPSDEMainStateId());
            dto.setPSDEMainStateName(((PSDEMainStateDTO)linkDTO).getPSDEMainStateName());
        } else {
            dto.setPSDEMainStateName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDENotifyId())) {
            linkDTO = (PSDENotifyDTO)PSModelServiceUtil.getInstance().getPSDENotifyService().getDTO(dto.getPSDENotifyId());
            dto.setPSDENotifyName(((PSDENotifyDTO)linkDTO).getPSDENotifyName());
        } else {
            dto.setPSDENotifyName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDELogicNodeId())) {
            linkDTO = (PSSysDELogicNodeDTO)PSModelServiceUtil.getInstance().getPSSysDELogicNodeService().getDTO(dto.getPSSysDELogicNodeId());
            dto.setPSSysDELogicNodeName(((PSSysDELogicNodeDTO)linkDTO).getPSSysDELogicNodeName());
        } else {
            dto.setPSSysDELogicNodeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getPSSysPFPluginId());
            dto.setPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSequenceId())) {
            linkDTO = (PSSysSequenceDTO)PSModelServiceUtil.getInstance().getPSSysSequenceService().getDTO(dto.getPSSysSequenceId());
            dto.setPSSysSequenceName(((PSSysSequenceDTO)linkDTO).getPSSysSequenceName());
        } else {
            dto.setPSSysSequenceName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getPSSysSFPluginId());
            dto.setPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setPSSysSFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysTranslatorId())) {
            linkDTO = (PSSysTranslatorDTO)PSModelServiceUtil.getInstance().getPSSysTranslatorService().getDTO(dto.getPSSysTranslatorId());
            dto.setPSSysTranslatorName(((PSSysTranslatorDTO)linkDTO).getPSSysTranslatorName());
        } else {
            dto.setPSSysTranslatorName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysValueRuleId())) {
            linkDTO = (PSSysValueRuleDTO)PSModelServiceUtil.getInstance().getPSSysValueRuleService().getDTO(dto.getPSSysValueRuleId());
            dto.setPSSysValueRuleName(((PSSysValueRuleDTO)linkDTO).getPSSysValueRuleName());
        } else {
            dto.setPSSysValueRuleName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSDEACTIONLOGIC";
    }

    @Override
    public PSDEActionLogic createDomain() {
        return new PSDEActionLogic();
    }

    @Override
    public PSDEActionLogicDTO createDTO() {
        return new PSDEActionLogicDTO();
    }
}

