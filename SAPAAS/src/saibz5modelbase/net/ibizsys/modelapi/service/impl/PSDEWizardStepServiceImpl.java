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
import net.ibizsys.modelapi.domain.PSDEWizardStep;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEFormDTO;
import net.ibizsys.modelapi.dto.PSDEWizardDTO;
import net.ibizsys.modelapi.dto.PSDEWizardStepDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.service.IPSDEWizardStepService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEWizardStepServiceImpl
extends PSModelServiceImplBase<PSDEWizardStep, PSDEWizardStepDTO>
implements IPSDEWizardStepService {
    private static final Log log = LogFactory.getLog(PSDEWizardStepServiceImpl.class);

    @Override
    public List<PSDEWizardStep> listByPSDEWizard(PSDEWizard parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEWizardStep get(PSDEWizard parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEWizardStep> list = this.listByPSDEWizard(parent);
        if (list != null) {
            for (PSDEWizardStep item : list) {
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
    public List<PSDEWizardStepDTO> listDTOByPSDEWizard(String strParentKey) throws Exception {
        PSDEWizard psdewizard = (PSDEWizard)PSModelServiceUtil.getInstance().getPSDEWizardService().get(strParentKey);
        List<PSDEWizardStep> list = this.listByPSDEWizard(psdewizard);
        if (list != null) {
            ArrayList<PSDEWizardStepDTO> dtoList = new ArrayList<PSDEWizardStepDTO>();
            for (PSDEWizardStep item : list) {
                PSDEWizardStepDTO dto = (PSDEWizardStepDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEWizardStep> onListAll() throws Exception {
        ArrayList<PSDEWizardStep> list = new ArrayList<PSDEWizardStep>();
        List psdewizards = PSModelServiceUtil.getInstance().getPSDEWizardService().listAll();
        if (psdewizards != null) {
            for (PSDEWizard parent : psdewizards) {
                List<PSDEWizardStep> items = this.listByPSDEWizard(parent);
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
    protected PSDEWizardStep onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEWizardStep item;
        PSDEWizard psdewizard = (PSDEWizard)PSModelServiceUtil.getInstance().getPSDEWizardService().get(strParentKey, true);
        if (psdewizard != null && (item = this.get(psdewizard, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEWizardStep)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEWizardStepDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEWizardId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEWizardService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEWizardStep et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEWizardStepName())) {
            return et.getPSDEWizardStepName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEWizardStepDTO dto, PSDEWizardStep t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEWizardStepId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getEnableLink() != null || !bIgnoreNull) {
            dto.setEnableLink(t.getEnableLink());
        }
        if (t.getEnableLogic() != null || !bIgnoreNull) {
            dto.setEnableLogic(t.getEnableLogic());
        }
        if (t.getInitPSDEActionId() != null || !bIgnoreNull) {
            dto.setInitPSDEActionId(t.getInitPSDEActionId());
        }
        if (t.getInitPSDEActionName() != null || !bIgnoreNull) {
            dto.setInitPSDEActionName(t.getInitPSDEActionName());
        }
        if (t.getLNPSLanResId() != null || !bIgnoreNull) {
            dto.setLNPSLanResId(t.getLNPSLanResId());
        }
        if (t.getLNPSLanResName() != null || !bIgnoreNull) {
            dto.setLNPSLanResName(t.getLNPSLanResName());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getNextPSDEActionId() != null || !bIgnoreNull) {
            dto.setNextPSDEActionId(t.getNextPSDEActionId());
        }
        if (t.getNextPSDEActionName() != null || !bIgnoreNull) {
            dto.setNextPSDEActionName(t.getNextPSDEActionName());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
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
        if (t.getPSDEWizardId() != null || !bIgnoreNull) {
            dto.setPSDEWizardId(t.getPSDEWizardId());
        }
        if (t.getPSDEWizardName() != null || !bIgnoreNull) {
            dto.setPSDEWizardName(t.getPSDEWizardName());
        }
        if (t.getPSDEWizardStepName() != null || !bIgnoreNull) {
            dto.setPSDEWizardStepName(t.getPSDEWizardStepName());
        }
        if (t.getPSSysCssId() != null || !bIgnoreNull) {
            dto.setPSSysCssId(t.getPSSysCssId());
        }
        if (t.getPSSysCssName() != null || !bIgnoreNull) {
            dto.setPSSysCssName(t.getPSSysCssName());
        }
        if (t.getPSSysImageId() != null || !bIgnoreNull) {
            dto.setPSSysImageId(t.getPSSysImageId());
        }
        if (t.getPSSysImageName() != null || !bIgnoreNull) {
            dto.setPSSysImageName(t.getPSSysImageName());
        }
        if (t.getStepAction() != null || !bIgnoreNull) {
            dto.setStepAction(t.getStepAction());
        }
        if (t.getStepTag() != null || !bIgnoreNull) {
            dto.setStepTag(t.getStepTag());
        }
        if (t.getSubTitle() != null || !bIgnoreNull) {
            dto.setSubTitle(t.getSubTitle());
        }
        if (t.getSubTitlePSLanResId() != null || !bIgnoreNull) {
            dto.setSubTitlePSLanResId(t.getSubTitlePSLanResId());
        }
        if (t.getSubTitlePSLanResName() != null || !bIgnoreNull) {
            dto.setSubTitlePSLanResName(t.getSubTitlePSLanResName());
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
        if (t.getVisibleLogic() != null || !bIgnoreNull) {
            dto.setVisibleLogic(t.getVisibleLogic());
        }
        if (StringUtils.hasLength((String)dto.getInitPSDEActionId())) {
            dto.setInitPSDEActionId(this.getRealPSModelId(t, dto.getInitPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLNPSLanResId())) {
            dto.setLNPSLanResId(this.getRealPSModelId(t, dto.getLNPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNextPSDEActionId())) {
            dto.setNextPSDEActionId(this.getRealPSModelId(t, dto.getNextPSDEActionId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            dto.setPSSysCssId(this.getRealPSModelId(t, dto.getPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            dto.setPSSysImageId(this.getRealPSModelId(t, dto.getPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getSubTitlePSLanResId())) {
            dto.setSubTitlePSLanResId(this.getRealPSModelId(t, dto.getSubTitlePSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getInitPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getInitPSDEActionId());
            dto.setInitPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setInitPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getLNPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getLNPSLanResId());
            dto.setLNPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setLNPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getNextPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getNextPSDEActionId());
            dto.setNextPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setNextPSDEActionName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getPSSysCssId());
            dto.setPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            linkDTO = (PSSysImageDTO)PSModelServiceUtil.getInstance().getPSSysImageService().getDTO(dto.getPSSysImageId());
            dto.setPSSysImageName(((PSSysImageDTO)linkDTO).getPSSysImageName());
        } else {
            dto.setPSSysImageName(null);
        }
        if (StringUtils.hasLength((String)dto.getSubTitlePSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getSubTitlePSLanResId());
            dto.setSubTitlePSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setSubTitlePSLanResName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEWIZARDSTEP";
    }

    @Override
    public PSDEWizardStep createDomain() {
        return new PSDEWizardStep();
    }

    @Override
    public PSDEWizardStepDTO createDTO() {
        return new PSDEWizardStepDTO();
    }
}

