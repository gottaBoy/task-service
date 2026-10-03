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
import net.ibizsys.modelapi.domain.PSSysDynaModel;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelCatDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysDynaModelService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysDynaModelServiceImpl
extends PSModelServiceImplBase<PSSysDynaModel, PSSysDynaModelDTO>
implements IPSSysDynaModelService {
    private static final Log log = LogFactory.getLog(PSSysDynaModelServiceImpl.class);

    @Override
    public List<PSSysDynaModel> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysDynaModel get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysDynaModel> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSSysDynaModel item : list) {
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
    public List<PSSysDynaModelDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSSysDynaModel> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSSysDynaModelDTO> dtoList = new ArrayList<PSSysDynaModelDTO>();
            for (PSSysDynaModel item : list) {
                PSSysDynaModelDTO dto = (PSSysDynaModelDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysDynaModel> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysDynaModel get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysDynaModel> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysDynaModel item : list) {
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
    public List<PSSysDynaModelDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysDynaModel> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysDynaModelDTO> dtoList = new ArrayList<PSSysDynaModelDTO>();
            for (PSSysDynaModel item : list) {
                PSSysDynaModelDTO dto = (PSSysDynaModelDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysDynaModel> onListAll() throws Exception {
        List<PSSystem> pssystems;
        ArrayList<PSSysDynaModel> list = new ArrayList<PSSysDynaModel>();
        List<PSModule> psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll();
        if (psmodules != null) {
            for (PSModule parent : psmodules) {
                List<PSSysDynaModel> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysDynaModel> items = this.listByPSSystem(parent);
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
    protected PSSysDynaModel onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysDynaModel item;
        PSSysDynaModel item2;
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item2 = this.get(psmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysDynaModel)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysDynaModelDTO dto) throws Exception {
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
    public String getModelTag(PSSysDynaModel et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSSysDynaModelName())) {
            return et.getPSSysDynaModelName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysDynaModelDTO dto, PSSysDynaModel t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysDynaModelId(t.getId().replace("/", "."));
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
        if (t.getDefaultFlag() != null || !bIgnoreNull) {
            dto.setDefaultFlag(t.getDefaultFlag());
        }
        if (t.getDTOCodeName() != null || !bIgnoreNull) {
            dto.setDTOCodeName(t.getDTOCodeName());
        }
        if (t.getDynaModel() != null || !bIgnoreNull) {
            dto.setDynaModel(t.getDynaModel());
        }
        if (t.getDynaModel2() != null || !bIgnoreNull) {
            dto.setDynaModel2(t.getDynaModel2());
        }
        if (t.getDynaModelFmt() != null || !bIgnoreNull) {
            dto.setDynaModelFmt(t.getDynaModelFmt());
        }
        if (t.getDynaModelUsage() != null || !bIgnoreNull) {
            dto.setDynaModelUsage(t.getDynaModelUsage());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getModelTag() != null || !bIgnoreNull) {
            dto.setModelTag(t.getModelTag());
        }
        if (t.getModelTag2() != null || !bIgnoreNull) {
            dto.setModelTag2(t.getModelTag2());
        }
        if (t.getModelTag3() != null || !bIgnoreNull) {
            dto.setModelTag3(t.getModelTag3());
        }
        if (t.getModelTag4() != null || !bIgnoreNull) {
            dto.setModelTag4(t.getModelTag4());
        }
        if (t.getPPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPPSSysDynaModelId(t.getPPSSysDynaModelId());
        }
        if (t.getPPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPPSSysDynaModelName(t.getPPSSysDynaModelName());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
        }
        if (t.getPSSysDynaModelCatId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelCatId(t.getPSSysDynaModelCatId());
        }
        if (t.getPSSysDynaModelCatName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelCatName(t.getPSSysDynaModelCatName());
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
        if (StringUtils.hasLength((String)dto.getPPSSysDynaModelId())) {
            dto.setPPSSysDynaModelId(this.getRealPSModelId(t, dto.getPPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            dto.setPSModuleId(this.getRealPSModelId(t, dto.getPSModuleId()).replace("/", "."));
        }
        if ("PSMODULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSModuleId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelCatId())) {
            dto.setPSSysDynaModelCatId(this.getRealPSModelId(t, dto.getPSSysDynaModelCatId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPPSSysDynaModelId());
            dto.setPPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            linkDTO = (PSModuleDTO)PSModelServiceUtil.getInstance().getPSModuleService().getDTO(dto.getPSModuleId());
            dto.setPSModuleName(((PSModuleDTO)linkDTO).getPSModuleName());
        } else {
            dto.setPSModuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelCatId())) {
            linkDTO = (PSSysDynaModelCatDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelCatService().getDTO(dto.getPSSysDynaModelCatId());
            dto.setPSSysDynaModelCatName(((PSSysDynaModelCatDTO)linkDTO).getPSSysDynaModelCatName());
        } else {
            dto.setPSSysDynaModelCatName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(((PSSystemDTO)linkDTO).getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSDYNAMODEL";
    }

    @Override
    public PSSysDynaModel createDomain() {
        return new PSSysDynaModel();
    }

    @Override
    public PSSysDynaModelDTO createDTO() {
        return new PSSysDynaModelDTO();
    }
}

