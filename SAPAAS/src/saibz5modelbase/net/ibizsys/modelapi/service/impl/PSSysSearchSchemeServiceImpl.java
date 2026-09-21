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
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysModelGroup;
import net.ibizsys.modelapi.domain.PSSysSearchScheme;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSubSysServiceAPIDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysModelGroupDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysSearchSchemeDTO;
import net.ibizsys.modelapi.dto.PSSysServiceAPIDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysSearchSchemeService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysSearchSchemeServiceImpl
extends PSModelServiceImplBase<PSSysSearchScheme, PSSysSearchSchemeDTO>
implements IPSSysSearchSchemeService {
    private static final Log log = LogFactory.getLog(PSSysSearchSchemeServiceImpl.class);

    @Override
    public List<PSSysSearchScheme> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysSearchScheme get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysSearchScheme> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSSysSearchScheme item : list) {
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
    public List<PSSysSearchSchemeDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSSysSearchScheme> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSSysSearchSchemeDTO> dtoList = new ArrayList<PSSysSearchSchemeDTO>();
            for (PSSysSearchScheme item : list) {
                PSSysSearchSchemeDTO dto = (PSSysSearchSchemeDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysSearchScheme> listByPSSysModelGroup(PSSysModelGroup parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysSearchScheme get(PSSysModelGroup parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysSearchScheme> list = this.listByPSSysModelGroup(parent);
        if (list != null) {
            for (PSSysSearchScheme item : list) {
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
    public List<PSSysSearchSchemeDTO> listDTOByPSSysModelGroup(String strParentKey) throws Exception {
        PSSysModelGroup pssysmodelgroup = (PSSysModelGroup)PSModelServiceUtil.getInstance().getPSSysModelGroupService().get(strParentKey);
        List<PSSysSearchScheme> list = this.listByPSSysModelGroup(pssysmodelgroup);
        if (list != null) {
            ArrayList<PSSysSearchSchemeDTO> dtoList = new ArrayList<PSSysSearchSchemeDTO>();
            for (PSSysSearchScheme item : list) {
                PSSysSearchSchemeDTO dto = (PSSysSearchSchemeDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysSearchScheme> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysSearchScheme get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysSearchScheme> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysSearchScheme item : list) {
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
    public List<PSSysSearchSchemeDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysSearchScheme> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysSearchSchemeDTO> dtoList = new ArrayList<PSSysSearchSchemeDTO>();
            for (PSSysSearchScheme item : list) {
                PSSysSearchSchemeDTO dto = (PSSysSearchSchemeDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysSearchScheme> onListAll() throws Exception {
        List pssystems;
        List pssysmodelgroups;
        ArrayList<PSSysSearchScheme> list = new ArrayList<PSSysSearchScheme>();
        List psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll();
        if (psmodules != null) {
            for (PSModule parent : psmodules) {
                List<PSSysSearchScheme> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll((Collection<PSSysSearchScheme>)items);
            }
        }
        if ((pssysmodelgroups = PSModelServiceUtil.getInstance().getPSSysModelGroupService().listAll()) != null) {
            for (PSSysModelGroup parent : pssysmodelgroups) {
                List<PSSysSearchScheme> items = this.listByPSSysModelGroup(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysSearchScheme> items = this.listByPSSystem(parent);
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
    protected PSSysSearchScheme onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysSearchScheme item;
        PSSysSearchScheme item2;
        PSSysSearchScheme item3;
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item3 = this.get(psmodule, strCurKey, true)) != null) {
            return item3;
        }
        PSSysModelGroup pssysmodelgroup = (PSSysModelGroup)PSModelServiceUtil.getInstance().getPSSysModelGroupService().get(strParentKey, true);
        if (pssysmodelgroup != null && (item2 = this.get(pssysmodelgroup, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysSearchScheme)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysSearchSchemeDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSModuleId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSModuleService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSSysModelGroupId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysModelGroupService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSSystemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSystemService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysSearchScheme et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSSysSearchSchemeName())) {
            return et.getPSSysSearchSchemeName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysSearchSchemeDTO dto, PSSysSearchScheme t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysSearchSchemeId(t.getId().replace("/", "."));
        }
        if (t.getAuthClientId() != null || !bIgnoreNull) {
            dto.setAuthClientId(t.getAuthClientId());
        }
        if (t.getAuthClientSecret() != null || !bIgnoreNull) {
            dto.setAuthClientSecret(t.getAuthClientSecret());
        }
        if (t.getAuthMode() != null || !bIgnoreNull) {
            dto.setAuthMode(t.getAuthMode());
        }
        if (t.getAuthParam() != null || !bIgnoreNull) {
            dto.setAuthParam(t.getAuthParam());
        }
        if (t.getAuthParam2() != null || !bIgnoreNull) {
            dto.setAuthParam2(t.getAuthParam2());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getCodeName2() != null || !bIgnoreNull) {
            dto.setCodeName2(t.getCodeName2());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDocReplicas() != null || !bIgnoreNull) {
            dto.setDocReplicas(t.getDocReplicas());
        }
        if (t.getDocShards() != null || !bIgnoreNull) {
            dto.setDocShards(t.getDocShards());
        }
        if (t.getEnableServiceAPI() != null || !bIgnoreNull) {
            dto.setEnableServiceAPI(t.getEnableServiceAPI());
        }
        if (t.getEnableSubSysServiceAPI() != null || !bIgnoreNull) {
            dto.setEnableSubSysServiceAPI(t.getEnableSubSysServiceAPI());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
        }
        if (t.getPSSubSysServiceAPIId() != null || !bIgnoreNull) {
            dto.setPSSubSysServiceAPIId(t.getPSSubSysServiceAPIId());
        }
        if (t.getPSSubSysServiceAPIName() != null || !bIgnoreNull) {
            dto.setPSSubSysServiceAPIName(t.getPSSubSysServiceAPIName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSysModelGroupId() != null || !bIgnoreNull) {
            dto.setPSSysModelGroupId(t.getPSSysModelGroupId());
        }
        if (t.getPSSysModelGroupName() != null || !bIgnoreNull) {
            dto.setPSSysModelGroupName(t.getPSSysModelGroupName());
        }
        if (t.getPSSysSearchSchemeName() != null || !bIgnoreNull) {
            dto.setPSSysSearchSchemeName(t.getPSSysSearchSchemeName());
        }
        if (t.getPSSysServiceAPIId() != null || !bIgnoreNull) {
            dto.setPSSysServiceAPIId(t.getPSSysServiceAPIId());
        }
        if (t.getPSSysServiceAPIName() != null || !bIgnoreNull) {
            dto.setPSSysServiceAPIName(t.getPSSysServiceAPIName());
        }
        if (t.getPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginId(t.getPSSysSFPluginId());
        }
        if (t.getPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginName(t.getPSSysSFPluginName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getSchemeParams() != null || !bIgnoreNull) {
            dto.setSchemeParams(t.getSchemeParams());
        }
        if (t.getSchemeTag() != null || !bIgnoreNull) {
            dto.setSchemeTag(t.getSchemeTag());
        }
        if (t.getSchemeTag2() != null || !bIgnoreNull) {
            dto.setSchemeTag2(t.getSchemeTag2());
        }
        if (t.getSearchEngineType() != null || !bIgnoreNull) {
            dto.setSearchEngineType(t.getSearchEngineType());
        }
        if (t.getServiceCodeName() != null || !bIgnoreNull) {
            dto.setServiceCodeName(t.getServiceCodeName());
        }
        if (t.getServiceParam() != null || !bIgnoreNull) {
            dto.setServiceParam(t.getServiceParam());
        }
        if (t.getServiceParam2() != null || !bIgnoreNull) {
            dto.setServiceParam2(t.getServiceParam2());
        }
        if (t.getServicePath() != null || !bIgnoreNull) {
            dto.setServicePath(t.getServicePath());
        }
        if (t.getSubSysServiceCodeName() != null || !bIgnoreNull) {
            dto.setSubSysServiceCodeName(t.getSubSysServiceCodeName());
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
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            dto.setPSModuleId(this.getRealPSModelId(t, dto.getPSModuleId()).replace("/", "."));
        }
        if ("PSMODULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSModuleId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysServiceAPIId())) {
            dto.setPSSubSysServiceAPIId(this.getRealPSModelId(t, dto.getPSSubSysServiceAPIId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysModelGroupId())) {
            dto.setPSSysModelGroupId(this.getRealPSModelId(t, dto.getPSSysModelGroupId()).replace("/", "."));
        }
        if ("PSSYSMODELGROUP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysModelGroupId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysServiceAPIId())) {
            dto.setPSSysServiceAPIId(this.getRealPSModelId(t, dto.getPSSysServiceAPIId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            linkDTO = (PSModuleDTO)PSModelServiceUtil.getInstance().getPSModuleService().getDTO(dto.getPSModuleId());
            dto.setPSModuleName(((PSModuleDTO)linkDTO).getPSModuleName());
        } else {
            dto.setPSModuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysServiceAPIId())) {
            linkDTO = (PSSubSysServiceAPIDTO)PSModelServiceUtil.getInstance().getPSSubSysServiceAPIService().getDTO(dto.getPSSubSysServiceAPIId());
            dto.setPSSubSysServiceAPIName(((PSSubSysServiceAPIDTO)linkDTO).getPSSubSysServiceAPIName());
        } else {
            dto.setPSSubSysServiceAPIName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysModelGroupId())) {
            linkDTO = (PSSysModelGroupDTO)PSModelServiceUtil.getInstance().getPSSysModelGroupService().getDTO(dto.getPSSysModelGroupId());
            dto.setPSSysModelGroupName(((PSSysModelGroupDTO)linkDTO).getPSSysModelGroupName());
        } else {
            dto.setPSSysModelGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysServiceAPIId())) {
            linkDTO = (PSSysServiceAPIDTO)PSModelServiceUtil.getInstance().getPSSysServiceAPIService().getDTO(dto.getPSSysServiceAPIId());
            dto.setPSSysServiceAPIName(((PSSysServiceAPIDTO)linkDTO).getPSSysServiceAPIName());
        } else {
            dto.setPSSysServiceAPIName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getPSSysSFPluginId());
            dto.setPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setPSSysSFPluginName(null);
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
        return "PSSYSSEARCHSCHEME";
    }

    @Override
    public PSSysSearchScheme createDomain() {
        return new PSSysSearchScheme();
    }

    @Override
    public PSSysSearchSchemeDTO createDTO() {
        return new PSSysSearchSchemeDTO();
    }
}

