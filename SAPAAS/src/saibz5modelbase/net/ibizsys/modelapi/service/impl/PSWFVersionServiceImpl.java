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
import net.ibizsys.modelapi.domain.PSWFLink;
import net.ibizsys.modelapi.domain.PSWFLinkCond;
import net.ibizsys.modelapi.domain.PSWFProcess;
import net.ibizsys.modelapi.domain.PSWFVersion;
import net.ibizsys.modelapi.domain.PSWorkflow;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.dto.PSSysWFModeDTO;
import net.ibizsys.modelapi.dto.PSWFLinkCondDTO;
import net.ibizsys.modelapi.dto.PSWFLinkDTO;
import net.ibizsys.modelapi.dto.PSWFProcessDTO;
import net.ibizsys.modelapi.dto.PSWFVersionDTO;
import net.ibizsys.modelapi.dto.PSWorkflowDTO;
import net.ibizsys.modelapi.service.IPSWFVersionService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSWFVersionServiceImpl
extends PSModelServiceImplBase<PSWFVersion, PSWFVersionDTO>
implements IPSWFVersionService {
    private static final Log log = LogFactory.getLog(PSWFVersionServiceImpl.class);

    @Override
    public List<PSWFVersion> listByPSWorkflow(PSWorkflow parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWFVersion get(PSWorkflow parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWFVersion> list = this.listByPSWorkflow(parent);
        if (list != null) {
            for (PSWFVersion item : list) {
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
    public List<PSWFVersionDTO> listDTOByPSWorkflow(String strParentKey) throws Exception {
        PSWorkflow psworkflow = (PSWorkflow)PSModelServiceUtil.getInstance().getPSWorkflowService().get(strParentKey);
        List<PSWFVersion> list = this.listByPSWorkflow(psworkflow);
        if (list != null) {
            ArrayList<PSWFVersionDTO> dtoList = new ArrayList<PSWFVersionDTO>();
            for (PSWFVersion item : list) {
                PSWFVersionDTO dto = (PSWFVersionDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSWFVersion> onListAll() throws Exception {
        ArrayList<PSWFVersion> list = new ArrayList<PSWFVersion>();
        List psworkflows = PSModelServiceUtil.getInstance().getPSWorkflowService().listAll();
        if (psworkflows != null) {
            for (PSWorkflow parent : psworkflows) {
                List<PSWFVersion> items = this.listByPSWorkflow(parent);
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
    protected PSWFVersion onGet(String strParentKey, String strCurKey) throws Exception {
        PSWFVersion item;
        PSWorkflow psworkflow = (PSWorkflow)PSModelServiceUtil.getInstance().getPSWorkflowService().get(strParentKey, true);
        if (psworkflow != null && (item = this.get(psworkflow, strCurKey, true)) != null) {
            return item;
        }
        return (PSWFVersion)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSWFVersionDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSWFId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWorkflowService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSWFVersion et) throws Exception {
        if (et.getWFVersion() != null) {
            return et.getWFVersion().toString();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSWFVersionDTO dto, PSWFVersion t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSWFVersionId(t.getId().replace("/", "."));
        }
        if (t.getActivitiModel() != null || !bIgnoreNull) {
            dto.setActivitiModel(t.getActivitiModel());
        }
        if (t.getBPMNModel() != null || !bIgnoreNull) {
            dto.setBPMNModel(t.getBPMNModel());
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
        if (t.getDynaSysRefMode() != null || !bIgnoreNull) {
            dto.setDynaSysRefMode(t.getDynaSysRefMode());
        }
        if (t.getDynaWFVer() != null || !bIgnoreNull) {
            dto.setDynaWFVer(t.getDynaWFVer());
        }
        if (t.getEnable() != null || !bIgnoreNull) {
            dto.setEnable(t.getEnable());
        }
        if (t.getEnableDynaSys() != null || !bIgnoreNull) {
            dto.setEnableDynaSys(t.getEnableDynaSys());
        }
        if (t.getEnableLog() != null || !bIgnoreNull) {
            dto.setEnableLog(t.getEnableLog());
        }
        if (t.getLastBackDataTag() != null || !bIgnoreNull) {
            dto.setLastBackDataTag(t.getLastBackDataTag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSDynaInstName() != null || !bIgnoreNull) {
            dto.setPSDynaInstName(t.getPSDynaInstName());
        }
        if (t.getPSDynaWFVerId() != null || !bIgnoreNull) {
            dto.setPSDynaWFVerId(t.getPSDynaWFVerId());
        }
        if (t.getPSDynaWFVerInstId() != null || !bIgnoreNull) {
            dto.setPSDynaWFVerInstId(t.getPSDynaWFVerInstId());
        }
        if (t.getPSDynaWFVerInstName() != null || !bIgnoreNull) {
            dto.setPSDynaWFVerInstName(t.getPSDynaWFVerInstName());
        }
        if (t.getPSDynaWFVerName() != null || !bIgnoreNull) {
            dto.setPSDynaWFVerName(t.getPSDynaWFVerName());
        }
        if (t.getPSSysReqItemId() != null || !bIgnoreNull) {
            dto.setPSSysReqItemId(t.getPSSysReqItemId());
        }
        if (t.getPSSysReqItemName() != null || !bIgnoreNull) {
            dto.setPSSysReqItemName(t.getPSSysReqItemName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSysWFModeId() != null || !bIgnoreNull) {
            dto.setPSSysWFModeId(t.getPSSysWFModeId());
        }
        if (t.getPSSysWFModeName() != null || !bIgnoreNull) {
            dto.setPSSysWFModeName(t.getPSSysWFModeName());
        }
        if (t.getPSWFId() != null || !bIgnoreNull) {
            dto.setPSWFId(t.getPSWFId());
        }
        if (t.getPSWFName() != null || !bIgnoreNull) {
            dto.setPSWFName(t.getPSWFName());
        }
        if (t.getPSWFVersionName() != null || !bIgnoreNull) {
            dto.setPSWFVersionName(t.getPSWFVersionName());
        }
        if (t.getRemoveFlag() != null || !bIgnoreNull) {
            dto.setRemoveFlag(t.getRemoveFlag());
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
        if (t.getVerTag() != null || !bIgnoreNull) {
            dto.setVerTag(t.getVerTag());
        }
        if (t.getVerTag2() != null || !bIgnoreNull) {
            dto.setVerTag2(t.getVerTag2());
        }
        if (t.getWFEngineType() != null || !bIgnoreNull) {
            dto.setWFEngineType(t.getWFEngineType());
        }
        if (t.getWFMode() != null || !bIgnoreNull) {
            dto.setWFMode(t.getWFMode());
        }
        if (t.getWFStepPSCodeListId() != null || !bIgnoreNull) {
            dto.setWFStepPSCodeListId(t.getWFStepPSCodeListId());
        }
        if (t.getWFStepPSCodeListName() != null || !bIgnoreNull) {
            dto.setWFStepPSCodeListName(t.getWFStepPSCodeListName());
        }
        if (t.getWFVerMode() != null || !bIgnoreNull) {
            dto.setWFVerMode(t.getWFVerMode());
        }
        if (t.getWFVersion() != null || !bIgnoreNull) {
            dto.setWFVersion(t.getWFVersion());
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            dto.setPSSysReqItemId(this.getRealPSModelId(t, dto.getPSSysReqItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysWFModeId())) {
            dto.setPSSysWFModeId(this.getRealPSModelId(t, dto.getPSSysWFModeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFId())) {
            dto.setPSWFId(this.getRealPSModelId(t, dto.getPSWFId()).replace("/", "."));
        }
        if ("PSWORKFLOW".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWFId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getWFStepPSCodeListId())) {
            dto.setWFStepPSCodeListId(this.getRealPSModelId(t, dto.getWFStepPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            linkDTO = (PSSysReqItemDTO)PSModelServiceUtil.getInstance().getPSSysReqItemService().getDTO(dto.getPSSysReqItemId());
            dto.setPSSysReqItemName(((PSSysReqItemDTO)linkDTO).getPSSysReqItemName());
        } else {
            dto.setPSSysReqItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysWFModeId())) {
            linkDTO = (PSSysWFModeDTO)PSModelServiceUtil.getInstance().getPSSysWFModeService().getDTO(dto.getPSSysWFModeId());
            dto.setPSSysWFModeName(((PSSysWFModeDTO)linkDTO).getPSSysWFModeName());
            dto.setWFMode(((PSSysWFModeDTO)linkDTO).getWFMode());
        } else {
            dto.setPSSysWFModeName(null);
            dto.setWFMode(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFId())) {
            linkDTO = (PSWorkflowDTO)PSModelServiceUtil.getInstance().getPSWorkflowService().getDTO(dto.getPSWFId());
            dto.setPSSystemId(((PSWorkflowDTO)linkDTO).getPSSystemId());
            dto.setPSWFName(((PSWorkflowDTO)linkDTO).getPSWorkflowName());
            dto.setWFEngineType(((PSWorkflowDTO)linkDTO).getWFEngineType());
        } else {
            dto.setPSSystemId(null);
            dto.setPSWFName(null);
            dto.setWFEngineType(null);
        }
        if (StringUtils.hasLength((String)dto.getWFStepPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getWFStepPSCodeListId());
            dto.setWFStepPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setWFStepPSCodeListName(null);
        }
        List<PSModelBase> list = PSModelServiceUtil.getInstance().getPSWFProcessService().listByPSWFVersion(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSWFProcessDTO> pswfprocesses = new ArrayList<PSWFProcessDTO>();
            for (PSWFProcess pSWFProcess : list) {
                dstItem = (PSWFProcessDTO)PSModelServiceUtil.getInstance().getPSWFProcessService().toDTO(pSWFProcess);
                pswfprocesses.add((PSWFProcessDTO)dstItem);
            }
            dto.setPswfprocesses(pswfprocesses);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSWFLinkService().listByPSWFVersion(t)) != null && list.size() > 0) {
            ArrayList<PSWFLinkDTO> pswflinks = new ArrayList<PSWFLinkDTO>();
            for (PSWFLink pSWFLink : list) {
                dstItem = (PSWFLinkDTO)PSModelServiceUtil.getInstance().getPSWFLinkService().toDTO(pSWFLink);
                pswflinks.add((PSWFLinkDTO)dstItem);
            }
            dto.setPswflinks(pswflinks);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSWFLinkCondService().listByPSWFVersion(t)) != null && list.size() > 0) {
            ArrayList<PSWFLinkCondDTO> pswflinkconds = new ArrayList<PSWFLinkCondDTO>();
            for (PSWFLinkCond pSWFLinkCond : list) {
                dstItem = (PSWFLinkCondDTO)PSModelServiceUtil.getInstance().getPSWFLinkCondService().toDTO(pSWFLinkCond);
                pswflinkconds.add((PSWFLinkCondDTO)dstItem);
            }
            dto.setPswflinkconds(pswflinkconds);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSWFVERSION";
    }

    @Override
    public PSWFVersion createDomain() {
        return new PSWFVersion();
    }

    @Override
    public PSWFVersionDTO createDTO() {
        return new PSWFVersionDTO();
    }
}

