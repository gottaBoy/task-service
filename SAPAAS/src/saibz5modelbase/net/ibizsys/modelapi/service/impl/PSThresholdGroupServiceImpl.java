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
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.domain.PSThreshold;
import net.ibizsys.modelapi.domain.PSThresholdGroup;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.dto.PSThresholdDTO;
import net.ibizsys.modelapi.dto.PSThresholdGroupDTO;
import net.ibizsys.modelapi.service.IPSThresholdGroupService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSThresholdGroupServiceImpl
extends PSModelServiceImplBase<PSThresholdGroup, PSThresholdGroupDTO>
implements IPSThresholdGroupService {
    private static final Log log = LogFactory.getLog(PSThresholdGroupServiceImpl.class);

    @Override
    public List<PSThresholdGroup> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSThresholdGroup get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSThresholdGroup> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSThresholdGroup item : list) {
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
    public List<PSThresholdGroupDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSThresholdGroup> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSThresholdGroupDTO> dtoList = new ArrayList<PSThresholdGroupDTO>();
            for (PSThresholdGroup item : list) {
                PSThresholdGroupDTO dto = (PSThresholdGroupDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSThresholdGroup> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSThresholdGroup get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSThresholdGroup> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSThresholdGroup item : list) {
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
    public List<PSThresholdGroupDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSThresholdGroup> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSThresholdGroupDTO> dtoList = new ArrayList<PSThresholdGroupDTO>();
            for (PSThresholdGroup item : list) {
                PSThresholdGroupDTO dto = (PSThresholdGroupDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSThresholdGroup> onListAll() throws Exception {
        List pssystems;
        ArrayList<PSThresholdGroup> list = new ArrayList<PSThresholdGroup>();
        List psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll();
        if (psmodules != null) {
            for (PSModule parent : psmodules) {
                List<PSThresholdGroup> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSThresholdGroup> items = this.listByPSSystem(parent);
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
    protected PSThresholdGroup onGet(String strParentKey, String strCurKey) throws Exception {
        PSThresholdGroup item;
        PSThresholdGroup item2;
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item2 = this.get(psmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSThresholdGroup)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSThresholdGroupDTO dto) throws Exception {
        String strPickupValue = null;
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
    public String getModelTag(PSThresholdGroup et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSThresholdGroupName())) {
            return et.getPSThresholdGroupName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSThresholdGroupDTO dto, PSThresholdGroup t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSThresholdGroupId(t.getId().replace("/", "."));
        }
        if (t.getBeginValuePSDEFId() != null || !bIgnoreNull) {
            dto.setBeginValuePSDEFId(t.getBeginValuePSDEFId());
        }
        if (t.getBeginValuePSDEFName() != null || !bIgnoreNull) {
            dto.setBeginValuePSDEFName(t.getBeginValuePSDEFName());
        }
        if (t.getBKColorPSDEFId() != null || !bIgnoreNull) {
            dto.setBKColorPSDEFId(t.getBKColorPSDEFId());
        }
        if (t.getBKColorPSDEFName() != null || !bIgnoreNull) {
            dto.setBKColorPSDEFName(t.getBKColorPSDEFName());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getColorPSDEFId() != null || !bIgnoreNull) {
            dto.setColorPSDEFId(t.getColorPSDEFId());
        }
        if (t.getColorPSDEFName() != null || !bIgnoreNull) {
            dto.setColorPSDEFName(t.getColorPSDEFName());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCustomCond() != null || !bIgnoreNull) {
            dto.setCustomCond(t.getCustomCond());
        }
        if (t.getDataPSDEFId() != null || !bIgnoreNull) {
            dto.setDataPSDEFId(t.getDataPSDEFId());
        }
        if (t.getDataPSDEFName() != null || !bIgnoreNull) {
            dto.setDataPSDEFName(t.getDataPSDEFName());
        }
        if (t.getEndValuePSDEFId() != null || !bIgnoreNull) {
            dto.setEndValuePSDEFId(t.getEndValuePSDEFId());
        }
        if (t.getEndValuePSDEFName() != null || !bIgnoreNull) {
            dto.setEndValuePSDEFName(t.getEndValuePSDEFName());
        }
        if (t.getIconClsPSDEFId() != null || !bIgnoreNull) {
            dto.setIconClsPSDEFId(t.getIconClsPSDEFId());
        }
        if (t.getIconClsPSDEFName() != null || !bIgnoreNull) {
            dto.setIconClsPSDEFName(t.getIconClsPSDEFName());
        }
        if (t.getIncBeginValue() != null || !bIgnoreNull) {
            dto.setIncBeginValue(t.getIncBeginValue());
        }
        if (t.getIncEndValue() != null || !bIgnoreNull) {
            dto.setIncEndValue(t.getIncEndValue());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSDEDSId() != null || !bIgnoreNull) {
            dto.setPSDEDSId(t.getPSDEDSId());
        }
        if (t.getPSDEDSName() != null || !bIgnoreNull) {
            dto.setPSDEDSName(t.getPSDEDSName());
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
        if (t.getPSThresholdGroupName() != null || !bIgnoreNull) {
            dto.setPSThresholdGroupName(t.getPSThresholdGroupName());
        }
        if (t.getTextPSDEFId() != null || !bIgnoreNull) {
            dto.setTextPSDEFId(t.getTextPSDEFId());
        }
        if (t.getTextPSDEFName() != null || !bIgnoreNull) {
            dto.setTextPSDEFName(t.getTextPSDEFName());
        }
        if (t.getThresholdGroupTag() != null || !bIgnoreNull) {
            dto.setThresholdGroupTag(t.getThresholdGroupTag());
        }
        if (t.getThresholdGroupTag2() != null || !bIgnoreNull) {
            dto.setThresholdGroupTag2(t.getThresholdGroupTag2());
        }
        if (t.getThresholdGroupType() != null || !bIgnoreNull) {
            dto.setThresholdGroupType(t.getThresholdGroupType());
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
        if (StringUtils.hasLength((String)dto.getBeginValuePSDEFId())) {
            dto.setBeginValuePSDEFId(this.getRealPSModelId(t, dto.getBeginValuePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getBKColorPSDEFId())) {
            dto.setBKColorPSDEFId(this.getRealPSModelId(t, dto.getBKColorPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getColorPSDEFId())) {
            dto.setColorPSDEFId(this.getRealPSModelId(t, dto.getColorPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDataPSDEFId())) {
            dto.setDataPSDEFId(this.getRealPSModelId(t, dto.getDataPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getEndValuePSDEFId())) {
            dto.setEndValuePSDEFId(this.getRealPSModelId(t, dto.getEndValuePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getIconClsPSDEFId())) {
            dto.setIconClsPSDEFId(this.getRealPSModelId(t, dto.getIconClsPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            dto.setPSDEDSId(this.getRealPSModelId(t, dto.getPSDEDSId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTextPSDEFId())) {
            dto.setTextPSDEFId(this.getRealPSModelId(t, dto.getTextPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getBeginValuePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getBeginValuePSDEFId());
            dto.setBeginValuePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setBeginValuePSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getBKColorPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getBKColorPSDEFId());
            dto.setBKColorPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setBKColorPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getColorPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getColorPSDEFId());
            dto.setColorPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setColorPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getDataPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getDataPSDEFId());
            dto.setDataPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setDataPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getEndValuePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getEndValuePSDEFId());
            dto.setEndValuePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setEndValuePSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getIconClsPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getIconClsPSDEFId());
            dto.setIconClsPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setIconClsPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getPSDEDSId());
            dto.setPSDEDSName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setPSDEDSName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(((PSSystemDTO)linkDTO).getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        if (StringUtils.hasLength((String)dto.getTextPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTextPSDEFId());
            dto.setTextPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTextPSDEFName(null);
        }
        List<PSThreshold> list = PSModelServiceUtil.getInstance().getPSThresholdService().listByPSThresholdGroup(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSThresholdDTO> psthresholds = new ArrayList<PSThresholdDTO>();
            for (PSThreshold item : list) {
                PSThresholdDTO dstItem = (PSThresholdDTO)PSModelServiceUtil.getInstance().getPSThresholdService().toDTO(item);
                psthresholds.add(dstItem);
            }
            dto.setPsthresholds(psthresholds);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSTHRESHOLDGROUP";
    }

    @Override
    public PSThresholdGroup createDomain() {
        return new PSThresholdGroup();
    }

    @Override
    public PSThresholdGroupDTO createDTO() {
        return new PSThresholdGroupDTO();
    }
}

