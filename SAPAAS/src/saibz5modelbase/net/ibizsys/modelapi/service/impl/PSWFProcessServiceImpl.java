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
import net.ibizsys.modelapi.domain.PSWFProcParam;
import net.ibizsys.modelapi.domain.PSWFProcRole;
import net.ibizsys.modelapi.domain.PSWFProcSubWF;
import net.ibizsys.modelapi.domain.PSWFProcess;
import net.ibizsys.modelapi.domain.PSWFVersion;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEFGroupDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDEFormDTO;
import net.ibizsys.modelapi.dto.PSDEUAGroupDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysMsgTemplDTO;
import net.ibizsys.modelapi.dto.PSWFDEDTO;
import net.ibizsys.modelapi.dto.PSWFProcParamDTO;
import net.ibizsys.modelapi.dto.PSWFProcRoleDTO;
import net.ibizsys.modelapi.dto.PSWFProcSubWFDTO;
import net.ibizsys.modelapi.dto.PSWFProcessDTO;
import net.ibizsys.modelapi.dto.PSWFVersionDTO;
import net.ibizsys.modelapi.dto.PSWFWorkTimeDTO;
import net.ibizsys.modelapi.dto.PSWorkflowDTO;
import net.ibizsys.modelapi.service.IPSWFProcessService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSWFProcessServiceImpl
extends PSModelServiceImplBase<PSWFProcess, PSWFProcessDTO>
implements IPSWFProcessService {
    private static final Log log = LogFactory.getLog(PSWFProcessServiceImpl.class);

    @Override
    public List<PSWFProcess> listByPSWFVersion(PSWFVersion parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWFProcess get(PSWFVersion parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWFProcess> list = this.listByPSWFVersion(parent);
        if (list != null) {
            for (PSWFProcess item : list) {
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
    public List<PSWFProcessDTO> listDTOByPSWFVersion(String strParentKey) throws Exception {
        PSWFVersion pswfversion = (PSWFVersion)PSModelServiceUtil.getInstance().getPSWFVersionService().get(strParentKey);
        List<PSWFProcess> list = this.listByPSWFVersion(pswfversion);
        if (list != null) {
            ArrayList<PSWFProcessDTO> dtoList = new ArrayList<PSWFProcessDTO>();
            for (PSWFProcess item : list) {
                PSWFProcessDTO dto = (PSWFProcessDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSWFProcess> onListAll() throws Exception {
        ArrayList<PSWFProcess> list = new ArrayList<PSWFProcess>();
        List<PSWFVersion> pswfversions = PSModelServiceUtil.getInstance().getPSWFVersionService().listAll();
        if (pswfversions != null) {
            for (PSWFVersion parent : pswfversions) {
                List<PSWFProcess> items = this.listByPSWFVersion(parent);
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
    protected PSWFProcess onGet(String strParentKey, String strCurKey) throws Exception {
        PSWFProcess item;
        PSWFVersion pswfversion = (PSWFVersion)PSModelServiceUtil.getInstance().getPSWFVersionService().get(strParentKey, true);
        if (pswfversion != null && (item = this.get(pswfversion, strCurKey, true)) != null) {
            return item;
        }
        return (PSWFProcess)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSWFProcessDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSWFVersionId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWFVersionService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSWFProcess et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSWFProcessDTO dto, PSWFProcess t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSWFProcessId(t.getId().replace("/", "."));
        }
        if (t.getAsyncMode() != null || !bIgnoreNull) {
            dto.setAsyncMode(t.getAsyncMode());
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
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getEditFields() != null || !bIgnoreNull) {
            dto.setEditFields(t.getEditFields());
        }
        if (t.getEditFlag() != null || !bIgnoreNull) {
            dto.setEditFlag(t.getEditFlag());
        }
        if (t.getEditPSDEFGroupId() != null || !bIgnoreNull) {
            dto.setEditPSDEFGroupId(t.getEditPSDEFGroupId());
        }
        if (t.getEditPSDEFGroupName() != null || !bIgnoreNull) {
            dto.setEditPSDEFGroupName(t.getEditPSDEFGroupName());
        }
        if (t.getEmbedPSDEDSId() != null || !bIgnoreNull) {
            dto.setEmbedPSDEDSId(t.getEmbedPSDEDSId());
        }
        if (t.getEmbedPSDEDSName() != null || !bIgnoreNull) {
            dto.setEmbedPSDEDSName(t.getEmbedPSDEDSName());
        }
        if (t.getEmbedPSDEId() != null || !bIgnoreNull) {
            dto.setEmbedPSDEId(t.getEmbedPSDEId());
        }
        if (t.getEmbedPSWFDEId() != null || !bIgnoreNull) {
            dto.setEmbedPSWFDEId(t.getEmbedPSWFDEId());
        }
        if (t.getEmbedPSWFDEName() != null || !bIgnoreNull) {
            dto.setEmbedPSWFDEName(t.getEmbedPSWFDEName());
        }
        if (t.getEmbedPSWFId() != null || !bIgnoreNull) {
            dto.setEmbedPSWFId(t.getEmbedPSWFId());
        }
        if (t.getEmbedPSWFName() != null || !bIgnoreNull) {
            dto.setEmbedPSWFName(t.getEmbedPSWFName());
        }
        if (t.getEnable() != null || !bIgnoreNull) {
            dto.setEnable(t.getEnable());
        }
        if (t.getEnableMobile() != null || !bIgnoreNull) {
            dto.setEnableMobile(t.getEnableMobile());
        }
        if (t.getEnableTimeout() != null || !bIgnoreNull) {
            dto.setEnableTimeout(t.getEnableTimeout());
        }
        if (t.getExitStateName() != null || !bIgnoreNull) {
            dto.setExitStateName(t.getExitStateName());
        }
        if (t.getExitStateValue() != null || !bIgnoreNull) {
            dto.setExitStateValue(t.getExitStateValue());
        }
        if (t.getFormCodeName() != null || !bIgnoreNull) {
            dto.setFormCodeName(t.getFormCodeName());
        }
        if (t.getHeight() != null || !bIgnoreNull) {
            dto.setHeight(t.getHeight());
        }
        if (t.getIconPath() != null || !bIgnoreNull) {
            dto.setIconPath(t.getIconPath());
        }
        if (t.getLeftPos() != null || !bIgnoreNull) {
            dto.setLeftPos(t.getLeftPos());
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
        if (t.getMobPSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setMobPSDEUAGroupId(t.getMobPSDEUAGroupId());
        }
        if (t.getMobPSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setMobPSDEUAGroupName(t.getMobPSDEUAGroupName());
        }
        if (t.getMobPSDEViewId() != null || !bIgnoreNull) {
            dto.setMobPSDEViewId(t.getMobPSDEViewId());
        }
        if (t.getMobPSDEViewName() != null || !bIgnoreNull) {
            dto.setMobPSDEViewName(t.getMobPSDEViewName());
        }
        if (t.getMobPSDynaDEViewTemplId() != null || !bIgnoreNull) {
            dto.setMobPSDynaDEViewTemplId(t.getMobPSDynaDEViewTemplId());
        }
        if (t.getMobUAGroupCodeName() != null || !bIgnoreNull) {
            dto.setMobUAGroupCodeName(t.getMobUAGroupCodeName());
        }
        if (t.getMobUtil2FormCodeName() != null || !bIgnoreNull) {
            dto.setMobUtil2FormCodeName(t.getMobUtil2FormCodeName());
        }
        if (t.getMobUtil2PSDEFormId() != null || !bIgnoreNull) {
            dto.setMobUtil2PSDEFormId(t.getMobUtil2PSDEFormId());
        }
        if (t.getMobUtil2PSDEFormName() != null || !bIgnoreNull) {
            dto.setMobUtil2PSDEFormName(t.getMobUtil2PSDEFormName());
        }
        if (t.getMobUtil3FormCodeName() != null || !bIgnoreNull) {
            dto.setMobUtil3FormCodeName(t.getMobUtil3FormCodeName());
        }
        if (t.getMobUtil3PSDEFormId() != null || !bIgnoreNull) {
            dto.setMobUtil3PSDEFormId(t.getMobUtil3PSDEFormId());
        }
        if (t.getMobUtil3PSDEFormName() != null || !bIgnoreNull) {
            dto.setMobUtil3PSDEFormName(t.getMobUtil3PSDEFormName());
        }
        if (t.getMobUtil4FormCodeName() != null || !bIgnoreNull) {
            dto.setMobUtil4FormCodeName(t.getMobUtil4FormCodeName());
        }
        if (t.getMobUtil4PSDEFormId() != null || !bIgnoreNull) {
            dto.setMobUtil4PSDEFormId(t.getMobUtil4PSDEFormId());
        }
        if (t.getMobUtil4PSDEFormName() != null || !bIgnoreNull) {
            dto.setMobUtil4PSDEFormName(t.getMobUtil4PSDEFormName());
        }
        if (t.getMobUtil5FormCodeName() != null || !bIgnoreNull) {
            dto.setMobUtil5FormCodeName(t.getMobUtil5FormCodeName());
        }
        if (t.getMobUtil5PSDEFormId() != null || !bIgnoreNull) {
            dto.setMobUtil5PSDEFormId(t.getMobUtil5PSDEFormId());
        }
        if (t.getMobUtil5PSDEFormName() != null || !bIgnoreNull) {
            dto.setMobUtil5PSDEFormName(t.getMobUtil5PSDEFormName());
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
        if (t.getMobWFEditViewType() != null || !bIgnoreNull) {
            dto.setMobWFEditViewType(t.getMobWFEditViewType());
        }
        if (t.getModelId() != null || !bIgnoreNull) {
            dto.setModelId(t.getModelId());
        }
        if (t.getMsgType() != null || !bIgnoreNull) {
            dto.setMsgType(t.getMsgType());
        }
        if (t.getMultiInstMode() != null || !bIgnoreNull) {
            dto.setMultiInstMode(t.getMultiInstMode());
        }
        if (t.getNamePSLanResId() != null || !bIgnoreNull) {
            dto.setNamePSLanResId(t.getNamePSLanResId());
        }
        if (t.getNamePSLanResName() != null || !bIgnoreNull) {
            dto.setNamePSLanResName(t.getNamePSLanResName());
        }
        if (t.getNormalProcType() != null || !bIgnoreNull) {
            dto.setNormalProcType(t.getNormalProcType());
        }
        if (t.getPredefinedActions() != null || !bIgnoreNull) {
            dto.setPredefinedActions(t.getPredefinedActions());
        }
        if (t.getPSDEActionId() != null || !bIgnoreNull) {
            dto.setPSDEActionId(t.getPSDEActionId());
        }
        if (t.getPSDEActionName() != null || !bIgnoreNull) {
            dto.setPSDEActionName(t.getPSDEActionName());
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
        if (t.getPSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupId(t.getPSDEUAGroupId());
        }
        if (t.getPSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupName(t.getPSDEUAGroupName());
        }
        if (t.getPSDEViewBaseId() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseId(t.getPSDEViewBaseId());
        }
        if (t.getPSDEViewBaseName() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseName(t.getPSDEViewBaseName());
        }
        if (t.getPSDynaDEViewTemplId() != null || !bIgnoreNull) {
            dto.setPSDynaDEViewTemplId(t.getPSDynaDEViewTemplId());
        }
        if (t.getPSSysMsgTemplId() != null || !bIgnoreNull) {
            dto.setPSSysMsgTemplId(t.getPSSysMsgTemplId());
        }
        if (t.getPSSysMsgTemplName() != null || !bIgnoreNull) {
            dto.setPSSysMsgTemplName(t.getPSSysMsgTemplName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSWFDEId() != null || !bIgnoreNull) {
            dto.setPSWFDEId(t.getPSWFDEId());
        }
        if (t.getPSWFDEName() != null || !bIgnoreNull) {
            dto.setPSWFDEName(t.getPSWFDEName());
        }
        if (t.getPSWFId() != null || !bIgnoreNull) {
            dto.setPSWFId(t.getPSWFId());
        }
        if (t.getPSWFName() != null || !bIgnoreNull) {
            dto.setPSWFName(t.getPSWFName());
        }
        if (t.getPSWFProcessName() != null || !bIgnoreNull) {
            dto.setPSWFProcessName(t.getPSWFProcessName());
        }
        if (t.getPSWFVersionId() != null || !bIgnoreNull) {
            dto.setPSWFVersionId(t.getPSWFVersionId());
        }
        if (t.getPSWFVersionName() != null || !bIgnoreNull) {
            dto.setPSWFVersionName(t.getPSWFVersionName());
        }
        if (t.getPSWFWorkTimeId() != null || !bIgnoreNull) {
            dto.setPSWFWorkTimeId(t.getPSWFWorkTimeId());
        }
        if (t.getPSWFWorkTimeName() != null || !bIgnoreNull) {
            dto.setPSWFWorkTimeName(t.getPSWFWorkTimeName());
        }
        if (t.getRefPSWFVersionId() != null || !bIgnoreNull) {
            dto.setRefPSWFVersionId(t.getRefPSWFVersionId());
        }
        if (t.getRefPSWFVersionName() != null || !bIgnoreNull) {
            dto.setRefPSWFVersionName(t.getRefPSWFVersionName());
        }
        if (t.getSendInform() != null || !bIgnoreNull) {
            dto.setSendInform(t.getSendInform());
        }
        if (t.getShapeParams() != null || !bIgnoreNull) {
            dto.setShapeParams(t.getShapeParams());
        }
        if (t.getThreadName() != null || !bIgnoreNull) {
            dto.setThreadName(t.getThreadName());
        }
        if (t.getThreadSN() != null || !bIgnoreNull) {
            dto.setThreadSN(t.getThreadSN());
        }
        if (t.getTimeout() != null || !bIgnoreNull) {
            dto.setTimeout(t.getTimeout());
        }
        if (t.getTimeoutPSDEFId() != null || !bIgnoreNull) {
            dto.setTimeoutPSDEFId(t.getTimeoutPSDEFId());
        }
        if (t.getTimeoutPSDEFName() != null || !bIgnoreNull) {
            dto.setTimeoutPSDEFName(t.getTimeoutPSDEFName());
        }
        if (t.getTimeoutType() != null || !bIgnoreNull) {
            dto.setTimeoutType(t.getTimeoutType());
        }
        if (t.getTopPos() != null || !bIgnoreNull) {
            dto.setTopPos(t.getTopPos());
        }
        if (t.getUAGroupCodeName() != null || !bIgnoreNull) {
            dto.setUAGroupCodeName(t.getUAGroupCodeName());
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
        if (t.getUtil2FormCodeName() != null || !bIgnoreNull) {
            dto.setUtil2FormCodeName(t.getUtil2FormCodeName());
        }
        if (t.getUtil2PSDEFormId() != null || !bIgnoreNull) {
            dto.setUtil2PSDEFormId(t.getUtil2PSDEFormId());
        }
        if (t.getUtil2PSDEFormName() != null || !bIgnoreNull) {
            dto.setUtil2PSDEFormName(t.getUtil2PSDEFormName());
        }
        if (t.getUtil3FormCodeName() != null || !bIgnoreNull) {
            dto.setUtil3FormCodeName(t.getUtil3FormCodeName());
        }
        if (t.getUtil3PSDEFormId() != null || !bIgnoreNull) {
            dto.setUtil3PSDEFormId(t.getUtil3PSDEFormId());
        }
        if (t.getUtil3PSDEFormName() != null || !bIgnoreNull) {
            dto.setUtil3PSDEFormName(t.getUtil3PSDEFormName());
        }
        if (t.getUtil4FormCodeName() != null || !bIgnoreNull) {
            dto.setUtil4FormCodeName(t.getUtil4FormCodeName());
        }
        if (t.getUtil4PSDEFormId() != null || !bIgnoreNull) {
            dto.setUtil4PSDEFormId(t.getUtil4PSDEFormId());
        }
        if (t.getUtil4PSDEFormName() != null || !bIgnoreNull) {
            dto.setUtil4PSDEFormName(t.getUtil4PSDEFormName());
        }
        if (t.getUtil5FormCodeName() != null || !bIgnoreNull) {
            dto.setUtil5FormCodeName(t.getUtil5FormCodeName());
        }
        if (t.getUtil5PSDEFormId() != null || !bIgnoreNull) {
            dto.setUtil5PSDEFormId(t.getUtil5PSDEFormId());
        }
        if (t.getUtil5PSDEFormName() != null || !bIgnoreNull) {
            dto.setUtil5PSDEFormName(t.getUtil5PSDEFormName());
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
        if (t.getWFEditViewType() != null || !bIgnoreNull) {
            dto.setWFEditViewType(t.getWFEditViewType());
        }
        if (t.getWFEngineType() != null || !bIgnoreNull) {
            dto.setWFEngineType(t.getWFEngineType());
        }
        if (t.getWFProcessType() != null || !bIgnoreNull) {
            dto.setWFProcessType(t.getWFProcessType());
        }
        if (t.getWFStepName() != null || !bIgnoreNull) {
            dto.setWFStepName(t.getWFStepName());
        }
        if (t.getWFStepValue() != null || !bIgnoreNull) {
            dto.setWFStepValue(t.getWFStepValue());
        }
        if (t.getWidth() != null || !bIgnoreNull) {
            dto.setWidth(t.getWidth());
        }
        if (StringUtils.hasLength((String)dto.getEditPSDEFGroupId())) {
            dto.setEditPSDEFGroupId(this.getRealPSModelId(t, dto.getEditPSDEFGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getEmbedPSDEDSId())) {
            dto.setEmbedPSDEDSId(this.getRealPSModelId(t, dto.getEmbedPSDEDSId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getEmbedPSWFDEId())) {
            dto.setEmbedPSWFDEId(this.getRealPSModelId(t, dto.getEmbedPSWFDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getEmbedPSWFId())) {
            dto.setEmbedPSWFId(this.getRealPSModelId(t, dto.getEmbedPSWFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMobPSDEFormId())) {
            dto.setMobPSDEFormId(this.getRealPSModelId(t, dto.getMobPSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMobPSDEUAGroupId())) {
            dto.setMobPSDEUAGroupId(this.getRealPSModelId(t, dto.getMobPSDEUAGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMobPSDEViewId())) {
            dto.setMobPSDEViewId(this.getRealPSModelId(t, dto.getMobPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMobUtil2PSDEFormId())) {
            dto.setMobUtil2PSDEFormId(this.getRealPSModelId(t, dto.getMobUtil2PSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMobUtil3PSDEFormId())) {
            dto.setMobUtil3PSDEFormId(this.getRealPSModelId(t, dto.getMobUtil3PSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMobUtil4PSDEFormId())) {
            dto.setMobUtil4PSDEFormId(this.getRealPSModelId(t, dto.getMobUtil4PSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMobUtil5PSDEFormId())) {
            dto.setMobUtil5PSDEFormId(this.getRealPSModelId(t, dto.getMobUtil5PSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMobUtilPSDEFormId())) {
            dto.setMobUtilPSDEFormId(this.getRealPSModelId(t, dto.getMobUtilPSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNamePSLanResId())) {
            dto.setNamePSLanResId(this.getRealPSModelId(t, dto.getNamePSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            dto.setPSDEActionId(this.getRealPSModelId(t, dto.getPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            dto.setPSDEFormId(this.getRealPSModelId(t, dto.getPSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            dto.setPSDEUAGroupId(this.getRealPSModelId(t, dto.getPSDEUAGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            dto.setPSDEViewBaseId(this.getRealPSModelId(t, dto.getPSDEViewBaseId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysMsgTemplId())) {
            dto.setPSSysMsgTemplId(this.getRealPSModelId(t, dto.getPSSysMsgTemplId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFDEId())) {
            dto.setPSWFDEId(this.getRealPSModelId(t, dto.getPSWFDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFId())) {
            dto.setPSWFId(this.getRealPSModelId(t, dto.getPSWFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFVersionId())) {
            dto.setPSWFVersionId(this.getRealPSModelId(t, dto.getPSWFVersionId()).replace("/", "."));
        }
        if ("PSWFVERSION".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWFVersionId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFWorkTimeId())) {
            dto.setPSWFWorkTimeId(this.getRealPSModelId(t, dto.getPSWFWorkTimeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSWFVersionId())) {
            dto.setRefPSWFVersionId(this.getRealPSModelId(t, dto.getRefPSWFVersionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTimeoutPSDEFId())) {
            dto.setTimeoutPSDEFId(this.getRealPSModelId(t, dto.getTimeoutPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtil2PSDEFormId())) {
            dto.setUtil2PSDEFormId(this.getRealPSModelId(t, dto.getUtil2PSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtil3PSDEFormId())) {
            dto.setUtil3PSDEFormId(this.getRealPSModelId(t, dto.getUtil3PSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtil4PSDEFormId())) {
            dto.setUtil4PSDEFormId(this.getRealPSModelId(t, dto.getUtil4PSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtil5PSDEFormId())) {
            dto.setUtil5PSDEFormId(this.getRealPSModelId(t, dto.getUtil5PSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDEFormId())) {
            dto.setUtilPSDEFormId(this.getRealPSModelId(t, dto.getUtilPSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getEditPSDEFGroupId())) {
            linkDTO = (PSDEFGroupDTO)PSModelServiceUtil.getInstance().getPSDEFGroupService().getDTO(dto.getEditPSDEFGroupId());
            dto.setEditPSDEFGroupName(((PSDEFGroupDTO)linkDTO).getPSDEFGroupName());
        } else {
            dto.setEditPSDEFGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getEmbedPSDEDSId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getEmbedPSDEDSId());
            dto.setEmbedPSDEDSName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setEmbedPSDEDSName(null);
        }
        if (StringUtils.hasLength((String)dto.getEmbedPSWFDEId())) {
            linkDTO = (PSWFDEDTO)PSModelServiceUtil.getInstance().getPSWFDEService().getDTO(dto.getEmbedPSWFDEId());
            dto.setEmbedPSDEId(((PSWFDEDTO)linkDTO).getPSDEId());
            dto.setEmbedPSWFDEName(((PSWFDEDTO)linkDTO).getPSWFDEName());
        } else {
            dto.setEmbedPSDEId(null);
            dto.setEmbedPSWFDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getEmbedPSWFId())) {
            linkDTO = (PSWorkflowDTO)PSModelServiceUtil.getInstance().getPSWorkflowService().getDTO(dto.getEmbedPSWFId());
            dto.setEmbedPSWFName(((PSWorkflowDTO)linkDTO).getPSWorkflowName());
        } else {
            dto.setEmbedPSWFName(null);
        }
        if (StringUtils.hasLength((String)dto.getMobPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getMobPSDEFormId());
            dto.setMobFormCodeName(((PSDEFormDTO)linkDTO).getCodeName());
            dto.setMobPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setMobFormCodeName(null);
            dto.setMobPSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getMobPSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getMobPSDEUAGroupId());
            dto.setMobPSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
            dto.setMobUAGroupCodeName(((PSDEUAGroupDTO)linkDTO).getCodeName());
        } else {
            dto.setMobPSDEUAGroupName(null);
            dto.setMobUAGroupCodeName(null);
        }
        if (StringUtils.hasLength((String)dto.getMobPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getMobPSDEViewId());
            dto.setMobPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
            dto.setMobPSDynaDEViewTemplId(((PSDEViewBaseDTO)linkDTO).getPSDynaDEViewTemplId());
        } else {
            dto.setMobPSDEViewName(null);
            dto.setMobPSDynaDEViewTemplId(null);
        }
        if (StringUtils.hasLength((String)dto.getMobUtil2PSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getMobUtil2PSDEFormId());
            dto.setMobUtil2FormCodeName(((PSDEFormDTO)linkDTO).getCodeName());
            dto.setMobUtil2PSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setMobUtil2FormCodeName(null);
            dto.setMobUtil2PSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getMobUtil3PSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getMobUtil3PSDEFormId());
            dto.setMobUtil3FormCodeName(((PSDEFormDTO)linkDTO).getCodeName());
            dto.setMobUtil3PSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setMobUtil3FormCodeName(null);
            dto.setMobUtil3PSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getMobUtil4PSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getMobUtil4PSDEFormId());
            dto.setMobUtil4FormCodeName(((PSDEFormDTO)linkDTO).getCodeName());
            dto.setMobUtil4PSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setMobUtil4FormCodeName(null);
            dto.setMobUtil4PSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getMobUtil5PSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getMobUtil5PSDEFormId());
            dto.setMobUtil5FormCodeName(((PSDEFormDTO)linkDTO).getCodeName());
            dto.setMobUtil5PSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setMobUtil5FormCodeName(null);
            dto.setMobUtil5PSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getMobUtilPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getMobUtilPSDEFormId());
            dto.setMobUtilFormCodeName(((PSDEFormDTO)linkDTO).getCodeName());
            dto.setMobUtilPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setMobUtilFormCodeName(null);
            dto.setMobUtilPSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getNamePSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getNamePSLanResId());
            dto.setNamePSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setNamePSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getPSDEActionId());
            dto.setPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getPSDEFormId());
            dto.setFormCodeName(((PSDEFormDTO)linkDTO).getCodeName());
            dto.setPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setFormCodeName(null);
            dto.setPSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getPSDEUAGroupId());
            dto.setPSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
            dto.setUAGroupCodeName(((PSDEUAGroupDTO)linkDTO).getCodeName());
        } else {
            dto.setPSDEUAGroupName(null);
            dto.setUAGroupCodeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getPSDEViewBaseId());
            dto.setPSDEViewBaseName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
            dto.setPSDynaDEViewTemplId(((PSDEViewBaseDTO)linkDTO).getPSDynaDEViewTemplId());
        } else {
            dto.setPSDEViewBaseName(null);
            dto.setPSDynaDEViewTemplId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysMsgTemplId())) {
            linkDTO = (PSSysMsgTemplDTO)PSModelServiceUtil.getInstance().getPSSysMsgTemplService().getDTO(dto.getPSSysMsgTemplId());
            dto.setPSSysMsgTemplName(((PSSysMsgTemplDTO)linkDTO).getPSSysMsgTemplName());
        } else {
            dto.setPSSysMsgTemplName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFDEId())) {
            linkDTO = (PSWFDEDTO)PSModelServiceUtil.getInstance().getPSWFDEService().getDTO(dto.getPSWFDEId());
            dto.setPSDEId(((PSWFDEDTO)linkDTO).getPSDEId());
            dto.setPSWFDEName(((PSWFDEDTO)linkDTO).getPSWFDEName());
        } else {
            dto.setPSDEId(null);
            dto.setPSWFDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFId())) {
            linkDTO = (PSWorkflowDTO)PSModelServiceUtil.getInstance().getPSWorkflowService().getDTO(dto.getPSWFId());
            dto.setPSWFName(((PSWorkflowDTO)linkDTO).getPSWorkflowName());
        } else {
            dto.setPSWFName(null);
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
        if (StringUtils.hasLength((String)dto.getPSWFWorkTimeId())) {
            linkDTO = (PSWFWorkTimeDTO)PSModelServiceUtil.getInstance().getPSWFWorkTimeService().getDTO(dto.getPSWFWorkTimeId());
            dto.setPSWFWorkTimeName(((PSWFWorkTimeDTO)linkDTO).getPSWFWorkTimeName());
        } else {
            dto.setPSWFWorkTimeName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSWFVersionId())) {
            linkDTO = (PSWFVersionDTO)PSModelServiceUtil.getInstance().getPSWFVersionService().getDTO(dto.getRefPSWFVersionId());
            dto.setRefPSWFVersionName(((PSWFVersionDTO)linkDTO).getPSWFVersionName());
        } else {
            dto.setRefPSWFVersionName(null);
        }
        if (StringUtils.hasLength((String)dto.getTimeoutPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTimeoutPSDEFId());
            dto.setTimeoutPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTimeoutPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getUtil2PSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getUtil2PSDEFormId());
            dto.setUtil2FormCodeName(((PSDEFormDTO)linkDTO).getCodeName());
            dto.setUtil2PSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setUtil2FormCodeName(null);
            dto.setUtil2PSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getUtil3PSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getUtil3PSDEFormId());
            dto.setUtil3FormCodeName(((PSDEFormDTO)linkDTO).getCodeName());
            dto.setUtil3PSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setUtil3FormCodeName(null);
            dto.setUtil3PSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getUtil4PSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getUtil4PSDEFormId());
            dto.setUtil4FormCodeName(((PSDEFormDTO)linkDTO).getCodeName());
            dto.setUtil4PSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setUtil4FormCodeName(null);
            dto.setUtil4PSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getUtil5PSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getUtil5PSDEFormId());
            dto.setUtil5FormCodeName(((PSDEFormDTO)linkDTO).getCodeName());
            dto.setUtil5PSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setUtil5FormCodeName(null);
            dto.setUtil5PSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getUtilPSDEFormId());
            dto.setUtilFormCodeName(((PSDEFormDTO)linkDTO).getCodeName());
            dto.setUtilPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setUtilFormCodeName(null);
            dto.setUtilPSDEFormName(null);
        }
        List<PSWFProcRole> pSWFProcRoleList = PSModelServiceUtil.getInstance().getPSWFProcRoleService().listByPSWFProcess(t);
        if (pSWFProcRoleList != null && pSWFProcRoleList.size() > 0) {
            ArrayList<PSWFProcRoleDTO> pswfprocroles = new ArrayList<PSWFProcRoleDTO>();
            for (PSWFProcRole pSWFProcRole : pSWFProcRoleList) {
                dstItem = (PSWFProcRoleDTO)PSModelServiceUtil.getInstance().getPSWFProcRoleService().toDTO(pSWFProcRole);
                pswfprocroles.add((PSWFProcRoleDTO)dstItem);
            }
            dto.setPswfprocroles(pswfprocroles);
        }
        List<PSWFProcSubWF> pSWFProcSubWFList = PSModelServiceUtil.getInstance().getPSWFProcSubWFService().listByPSWFProcess(t);
        if (pSWFProcSubWFList != null && pSWFProcSubWFList.size() > 0) {
            ArrayList<PSWFProcSubWFDTO> pswfprocsubwfs = new ArrayList<PSWFProcSubWFDTO>();
            for (PSWFProcSubWF pSWFProcSubWF : pSWFProcSubWFList) {
                dstItem = (PSWFProcSubWFDTO)PSModelServiceUtil.getInstance().getPSWFProcSubWFService().toDTO(pSWFProcSubWF);
                pswfprocsubwfs.add((PSWFProcSubWFDTO)dstItem);
            }
            dto.setPswfprocsubwfs(pswfprocsubwfs);
        }
        List<PSWFProcParam> pSWFProcParamList = PSModelServiceUtil.getInstance().getPSWFProcParamService().listByPSWFProcess(t);
        if (pSWFProcParamList != null && pSWFProcParamList.size() > 0) {
            ArrayList<PSWFProcParamDTO> pswfprocparams = new ArrayList<PSWFProcParamDTO>();
            for (PSWFProcParam pSWFProcParam : pSWFProcParamList) {
                dstItem = (PSWFProcParamDTO)PSModelServiceUtil.getInstance().getPSWFProcParamService().toDTO(pSWFProcParam);
                pswfprocparams.add((PSWFProcParamDTO)dstItem);
            }
            dto.setPswfprocparams(pswfprocparams);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSWFPROCESS";
    }

    @Override
    public PSWFProcess createDomain() {
        return new PSWFProcess();
    }

    @Override
    public PSWFProcessDTO createDTO() {
        return new PSWFProcessDTO();
    }
}

