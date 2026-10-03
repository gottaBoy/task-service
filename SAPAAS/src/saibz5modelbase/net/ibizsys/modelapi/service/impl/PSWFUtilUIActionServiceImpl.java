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
import net.ibizsys.modelapi.domain.PSSysWFSetting;
import net.ibizsys.modelapi.domain.PSWFUtilUIAction;
import net.ibizsys.modelapi.domain.PSWFVersion;
import net.ibizsys.modelapi.domain.PSWorkflow;
import net.ibizsys.modelapi.dto.PSDEUIActionDTO;
import net.ibizsys.modelapi.dto.PSSysWFSettingDTO;
import net.ibizsys.modelapi.dto.PSWFUtilUIActionDTO;
import net.ibizsys.modelapi.dto.PSWFVersionDTO;
import net.ibizsys.modelapi.dto.PSWorkflowDTO;
import net.ibizsys.modelapi.service.IPSWFUtilUIActionService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSWFUtilUIActionServiceImpl
extends PSModelServiceImplBase<PSWFUtilUIAction, PSWFUtilUIActionDTO>
implements IPSWFUtilUIActionService {
    private static final Log log = LogFactory.getLog(PSWFUtilUIActionServiceImpl.class);

    @Override
    public List<PSWFUtilUIAction> listByPSWFVersion(PSWFVersion parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWFUtilUIAction get(PSWFVersion parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWFUtilUIAction> list = this.listByPSWFVersion(parent);
        if (list != null) {
            for (PSWFUtilUIAction item : list) {
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
    public List<PSWFUtilUIActionDTO> listDTOByPSWFVersion(String strParentKey) throws Exception {
        PSWFVersion pswfversion = (PSWFVersion)PSModelServiceUtil.getInstance().getPSWFVersionService().get(strParentKey);
        List<PSWFUtilUIAction> list = this.listByPSWFVersion(pswfversion);
        if (list != null) {
            ArrayList<PSWFUtilUIActionDTO> dtoList = new ArrayList<PSWFUtilUIActionDTO>();
            for (PSWFUtilUIAction item : list) {
                PSWFUtilUIActionDTO dto = (PSWFUtilUIActionDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSWFUtilUIAction> listByPSWorkflow(PSWorkflow parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWFUtilUIAction get(PSWorkflow parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWFUtilUIAction> list = this.listByPSWorkflow(parent);
        if (list != null) {
            for (PSWFUtilUIAction item : list) {
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
    public List<PSWFUtilUIActionDTO> listDTOByPSWorkflow(String strParentKey) throws Exception {
        PSWorkflow psworkflow = (PSWorkflow)PSModelServiceUtil.getInstance().getPSWorkflowService().get(strParentKey);
        List<PSWFUtilUIAction> list = this.listByPSWorkflow(psworkflow);
        if (list != null) {
            ArrayList<PSWFUtilUIActionDTO> dtoList = new ArrayList<PSWFUtilUIActionDTO>();
            for (PSWFUtilUIAction item : list) {
                PSWFUtilUIActionDTO dto = (PSWFUtilUIActionDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSWFUtilUIAction> listByPSSysWFSetting(PSSysWFSetting parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWFUtilUIAction get(PSSysWFSetting parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWFUtilUIAction> list = this.listByPSSysWFSetting(parent);
        if (list != null) {
            for (PSWFUtilUIAction item : list) {
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
    public List<PSWFUtilUIActionDTO> listDTOByPSSysWFSetting(String strParentKey) throws Exception {
        PSSysWFSetting pssyswfsetting = (PSSysWFSetting)PSModelServiceUtil.getInstance().getPSSysWFSettingService().get(strParentKey);
        List<PSWFUtilUIAction> list = this.listByPSSysWFSetting(pssyswfsetting);
        if (list != null) {
            ArrayList<PSWFUtilUIActionDTO> dtoList = new ArrayList<PSWFUtilUIActionDTO>();
            for (PSWFUtilUIAction item : list) {
                PSWFUtilUIActionDTO dto = (PSWFUtilUIActionDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSWFUtilUIAction> onListAll() throws Exception {
        List<PSSysWFSetting> pssyswfsettings;
        List<PSWorkflow> psworkflows;
        ArrayList<PSWFUtilUIAction> list = new ArrayList<PSWFUtilUIAction>();
        List<PSWFVersion> pswfversions = PSModelServiceUtil.getInstance().getPSWFVersionService().listAll();
        if (pswfversions != null) {
            for (PSWFVersion parent : pswfversions) {
                List<PSWFUtilUIAction> items = this.listByPSWFVersion(parent);
                if (items == null) continue;
                list.addAll((Collection<PSWFUtilUIAction>)items);
            }
        }
        if ((psworkflows = PSModelServiceUtil.getInstance().getPSWorkflowService().listAll()) != null) {
            for (PSWorkflow parent : psworkflows) {
                List<PSWFUtilUIAction> items = this.listByPSWorkflow(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssyswfsettings = PSModelServiceUtil.getInstance().getPSSysWFSettingService().listAll()) != null) {
            for (PSSysWFSetting parent : pssyswfsettings) {
                List<PSWFUtilUIAction> items = this.listByPSSysWFSetting(parent);
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
    protected PSWFUtilUIAction onGet(String strParentKey, String strCurKey) throws Exception {
        PSWFUtilUIAction item;
        PSWFUtilUIAction item2;
        PSWFUtilUIAction item3;
        PSWFVersion pswfversion = (PSWFVersion)PSModelServiceUtil.getInstance().getPSWFVersionService().get(strParentKey, true);
        if (pswfversion != null && (item3 = this.get(pswfversion, strCurKey, true)) != null) {
            return item3;
        }
        PSWorkflow psworkflow = (PSWorkflow)PSModelServiceUtil.getInstance().getPSWorkflowService().get(strParentKey, true);
        if (psworkflow != null && (item2 = this.get(psworkflow, strCurKey, true)) != null) {
            return item2;
        }
        PSSysWFSetting pssyswfsetting = (PSSysWFSetting)PSModelServiceUtil.getInstance().getPSSysWFSettingService().get(strParentKey, true);
        if (pssyswfsetting != null && (item = this.get(pssyswfsetting, strCurKey, true)) != null) {
            return item;
        }
        return (PSWFUtilUIAction)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSWFUtilUIActionDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSWFVersionId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWFVersionService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSWorkflowId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWorkflowService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSSysWFSettingId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysWFSettingService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSWFUtilUIAction et) throws Exception {
        if (StringUtils.hasLength((String)et.getUtilType())) {
            return et.getUtilType();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSWFUtilUIActionDTO dto, PSWFUtilUIAction t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSWFUtilUIActionId(t.getId().replace("/", "."));
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
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSDEUIActionId() != null || !bIgnoreNull) {
            dto.setPSDEUIActionId(t.getPSDEUIActionId());
        }
        if (t.getPSDEUIActionName() != null || !bIgnoreNull) {
            dto.setPSDEUIActionName(t.getPSDEUIActionName());
        }
        if (t.getPSSysWFSettingId() != null || !bIgnoreNull) {
            dto.setPSSysWFSettingId(t.getPSSysWFSettingId());
        }
        if (t.getPSSysWFSettingName() != null || !bIgnoreNull) {
            dto.setPSSysWFSettingName(t.getPSSysWFSettingName());
        }
        if (t.getPSWFUtilUIActionName() != null || !bIgnoreNull) {
            dto.setPSWFUtilUIActionName(t.getPSWFUtilUIActionName());
        }
        if (t.getPSWFVersionId() != null || !bIgnoreNull) {
            dto.setPSWFVersionId(t.getPSWFVersionId());
        }
        if (t.getPSWFVersionName() != null || !bIgnoreNull) {
            dto.setPSWFVersionName(t.getPSWFVersionName());
        }
        if (t.getPSWorkflowId() != null || !bIgnoreNull) {
            dto.setPSWorkflowId(t.getPSWorkflowId());
        }
        if (t.getPSWorkflowName() != null || !bIgnoreNull) {
            dto.setPSWorkflowName(t.getPSWorkflowName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUtilType() != null || !bIgnoreNull) {
            dto.setUtilType(t.getUtilType());
        }
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            dto.setPSDEUIActionId(this.getRealPSModelId(t, dto.getPSDEUIActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysWFSettingId())) {
            dto.setPSSysWFSettingId(this.getRealPSModelId(t, dto.getPSSysWFSettingId()).replace("/", "."));
        }
        if ("PSSYSWFSETTING".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysWFSettingId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFVersionId())) {
            dto.setPSWFVersionId(this.getRealPSModelId(t, dto.getPSWFVersionId()).replace("/", "."));
        }
        if ("PSWFVERSION".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWFVersionId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWorkflowId())) {
            dto.setPSWorkflowId(this.getRealPSModelId(t, dto.getPSWorkflowId()).replace("/", "."));
        }
        if ("PSWORKFLOW".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWorkflowId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            linkDTO = (PSDEUIActionDTO)PSModelServiceUtil.getInstance().getPSDEUIActionService().getDTO(dto.getPSDEUIActionId());
            dto.setPSDEUIActionName(((PSDEUIActionDTO)linkDTO).getPSDEUIActionName());
        } else {
            dto.setPSDEUIActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysWFSettingId())) {
            linkDTO = (PSSysWFSettingDTO)PSModelServiceUtil.getInstance().getPSSysWFSettingService().getDTO(dto.getPSSysWFSettingId());
            dto.setPSSysWFSettingName(((PSSysWFSettingDTO)linkDTO).getPSSysWFSettingName());
        } else {
            dto.setPSSysWFSettingName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFVersionId())) {
            linkDTO = (PSWFVersionDTO)PSModelServiceUtil.getInstance().getPSWFVersionService().getDTO(dto.getPSWFVersionId());
            dto.setPSWFVersionName(((PSWFVersionDTO)linkDTO).getPSWFVersionName());
        } else {
            dto.setPSWFVersionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWorkflowId())) {
            linkDTO = (PSWorkflowDTO)PSModelServiceUtil.getInstance().getPSWorkflowService().getDTO(dto.getPSWorkflowId());
            dto.setPSWorkflowName(((PSWorkflowDTO)linkDTO).getPSWorkflowName());
        } else {
            dto.setPSWorkflowName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSWFUTILUIACTION";
    }

    @Override
    public PSWFUtilUIAction createDomain() {
        return new PSWFUtilUIAction();
    }

    @Override
    public PSWFUtilUIActionDTO createDTO() {
        return new PSWFUtilUIActionDTO();
    }
}

