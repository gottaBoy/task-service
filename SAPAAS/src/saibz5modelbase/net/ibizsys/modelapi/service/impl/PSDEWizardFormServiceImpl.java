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
import net.ibizsys.modelapi.domain.PSDEWizard;
import net.ibizsys.modelapi.domain.PSDEWizardForm;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEFormDTO;
import net.ibizsys.modelapi.dto.PSDEWizardDTO;
import net.ibizsys.modelapi.dto.PSDEWizardFormDTO;
import net.ibizsys.modelapi.dto.PSDEWizardStepDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.service.IPSDEWizardFormService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEWizardFormServiceImpl
extends PSModelServiceImplBase<PSDEWizardForm, PSDEWizardFormDTO>
implements IPSDEWizardFormService {
    private static final Log log = LogFactory.getLog(PSDEWizardFormServiceImpl.class);

    @Override
    public List<PSDEWizardForm> listByPSDEWizard(PSDEWizard parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEWizardForm get(PSDEWizard parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEWizardForm> list = this.listByPSDEWizard(parent);
        if (list != null) {
            for (PSDEWizardForm item : list) {
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
    public List<PSDEWizardFormDTO> listDTOByPSDEWizard(String strParentKey) throws Exception {
        PSDEWizard psdewizard = (PSDEWizard)PSModelServiceUtil.getInstance().getPSDEWizardService().get(strParentKey);
        List<PSDEWizardForm> list = this.listByPSDEWizard(psdewizard);
        if (list != null) {
            ArrayList<PSDEWizardFormDTO> dtoList = new ArrayList<PSDEWizardFormDTO>();
            for (PSDEWizardForm item : list) {
                PSDEWizardFormDTO dto = (PSDEWizardFormDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEWizardForm> onListAll() throws Exception {
        ArrayList<PSDEWizardForm> list = new ArrayList<PSDEWizardForm>();
        List<PSDEWizard> psdewizards = PSModelServiceUtil.getInstance().getPSDEWizardService().listAll();
        if (psdewizards != null) {
            for (PSDEWizard parent : psdewizards) {
                List<PSDEWizardForm> items = this.listByPSDEWizard(parent);
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
    protected PSDEWizardForm onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEWizardForm item;
        PSDEWizard psdewizard = (PSDEWizard)PSModelServiceUtil.getInstance().getPSDEWizardService().get(strParentKey, true);
        if (psdewizard != null && (item = this.get(psdewizard, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEWizardForm)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEWizardFormDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEWizardId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEWizardService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEWizardForm et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEWizardFormDTO dto, PSDEWizardForm t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEWizardFormId(t.getId().replace("/", "."));
        }
        if (t.getCMPSLanResId() != null || !bIgnoreNull) {
            dto.setCMPSLanResId(t.getCMPSLanResId());
        }
        if (t.getCMPSLanResId2() != null || !bIgnoreNull) {
            dto.setCMPSLanResId2(t.getCMPSLanResId2());
        }
        if (t.getCMPSLanResName() != null || !bIgnoreNull) {
            dto.setCMPSLanResName(t.getCMPSLanResName());
        }
        if (t.getCMPSLanResName2() != null || !bIgnoreNull) {
            dto.setCMPSLanResName2(t.getCMPSLanResName2());
        }
        if (t.getConfirmInfo() != null || !bIgnoreNull) {
            dto.setConfirmInfo(t.getConfirmInfo());
        }
        if (t.getConfirmInfo2() != null || !bIgnoreNull) {
            dto.setConfirmInfo2(t.getConfirmInfo2());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getFinishEnableLogic() != null || !bIgnoreNull) {
            dto.setFinishEnableLogic(t.getFinishEnableLogic());
        }
        if (t.getFirstForm() != null || !bIgnoreNull) {
            dto.setFirstForm(t.getFirstForm());
        }
        if (t.getFormTag() != null || !bIgnoreNull) {
            dto.setFormTag(t.getFormTag());
        }
        if (t.getLoadPSDEActionId() != null || !bIgnoreNull) {
            dto.setLoadPSDEActionId(t.getLoadPSDEActionId());
        }
        if (t.getLoadPSDEActionName() != null || !bIgnoreNull) {
            dto.setLoadPSDEActionName(t.getLoadPSDEActionName());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getNextEnableLogic() != null || !bIgnoreNull) {
            dto.setNextEnableLogic(t.getNextEnableLogic());
        }
        if (t.getPrevEnableLogic() != null || !bIgnoreNull) {
            dto.setPrevEnableLogic(t.getPrevEnableLogic());
        }
        if (t.getPrevPSDEActionId() != null || !bIgnoreNull) {
            dto.setPrevPSDEActionId(t.getPrevPSDEActionId());
        }
        if (t.getPrevPSDEActionName() != null || !bIgnoreNull) {
            dto.setPrevPSDEActionName(t.getPrevPSDEActionName());
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
        if (t.getPSDEWizardFormName() != null || !bIgnoreNull) {
            dto.setPSDEWizardFormName(t.getPSDEWizardFormName());
        }
        if (t.getPSDEWizardId() != null || !bIgnoreNull) {
            dto.setPSDEWizardId(t.getPSDEWizardId());
        }
        if (t.getPSDEWizardName() != null || !bIgnoreNull) {
            dto.setPSDEWizardName(t.getPSDEWizardName());
        }
        if (t.getPSDEWizardStepId() != null || !bIgnoreNull) {
            dto.setPSDEWizardStepId(t.getPSDEWizardStepId());
        }
        if (t.getPSDEWizardStepName() != null || !bIgnoreNull) {
            dto.setPSDEWizardStepName(t.getPSDEWizardStepName());
        }
        if (t.getSavePSDEActionId() != null || !bIgnoreNull) {
            dto.setSavePSDEActionId(t.getSavePSDEActionId());
        }
        if (t.getSavePSDEActionName() != null || !bIgnoreNull) {
            dto.setSavePSDEActionName(t.getSavePSDEActionName());
        }
        if (t.getStepActions() != null || !bIgnoreNull) {
            dto.setStepActions(t.getStepActions());
        }
        if (t.getStepOrderValue() != null || !bIgnoreNull) {
            dto.setStepOrderValue(t.getStepOrderValue());
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
        if (StringUtils.hasLength((String)dto.getCMPSLanResId())) {
            dto.setCMPSLanResId(this.getRealPSModelId(t, dto.getCMPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCMPSLanResId2())) {
            dto.setCMPSLanResId2(this.getRealPSModelId(t, dto.getCMPSLanResId2()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLoadPSDEActionId())) {
            dto.setLoadPSDEActionId(this.getRealPSModelId(t, dto.getLoadPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPrevPSDEActionId())) {
            dto.setPrevPSDEActionId(this.getRealPSModelId(t, dto.getPrevPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            dto.setPSDEFormId(this.getRealPSModelId(t, dto.getPSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEWizardId())) {
            dto.setPSDEWizardId(this.getRealPSModelId(t, dto.getPSDEWizardId()).replace("/", "."));
        }
        if ("PSDEWIZARD".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEWizardId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEWizardStepId())) {
            dto.setPSDEWizardStepId(this.getRealPSModelId(t, dto.getPSDEWizardStepId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getSavePSDEActionId())) {
            dto.setSavePSDEActionId(this.getRealPSModelId(t, dto.getSavePSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCMPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getCMPSLanResId());
            dto.setCMPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setCMPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getCMPSLanResId2())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getCMPSLanResId2());
            dto.setCMPSLanResName2(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setCMPSLanResName2(null);
        }
        if (StringUtils.hasLength((String)dto.getLoadPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getLoadPSDEActionId());
            dto.setLoadPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setLoadPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPrevPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getPrevPSDEActionId());
            dto.setPrevPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setPrevPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getPSDEFormId());
            dto.setPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setPSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEWizardId())) {
            linkDTO = (PSDEWizardDTO)PSModelServiceUtil.getInstance().getPSDEWizardService().getDTO(dto.getPSDEWizardId());
            dto.setPSDEId(((PSDEWizardDTO)linkDTO).getPSDEId());
            dto.setPSDEWizardName(((PSDEWizardDTO)linkDTO).getPSDEWizardName());
        } else {
            dto.setPSDEId(null);
            dto.setPSDEWizardName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEWizardStepId())) {
            linkDTO = (PSDEWizardStepDTO)PSModelServiceUtil.getInstance().getPSDEWizardStepService().getDTO(dto.getPSDEWizardStepId());
            dto.setPSDEWizardStepName(((PSDEWizardStepDTO)linkDTO).getPSDEWizardStepName());
            dto.setStepOrderValue(((PSDEWizardStepDTO)linkDTO).getOrderValue());
        } else {
            dto.setPSDEWizardStepName(null);
            dto.setStepOrderValue(null);
        }
        if (StringUtils.hasLength((String)dto.getSavePSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getSavePSDEActionId());
            dto.setSavePSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setSavePSDEActionName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEWIZARDFORM";
    }

    @Override
    public PSDEWizardForm createDomain() {
        return new PSDEWizardForm();
    }

    @Override
    public PSDEWizardFormDTO createDTO() {
        return new PSDEWizardFormDTO();
    }
}

