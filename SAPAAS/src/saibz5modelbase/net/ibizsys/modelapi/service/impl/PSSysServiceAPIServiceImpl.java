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
import net.ibizsys.modelapi.domain.PSSysServiceAPI;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSDEOPPrivDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysSAHandlerDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysServiceAPIDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysServiceAPIService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysServiceAPIServiceImpl
extends PSModelServiceImplBase<PSSysServiceAPI, PSSysServiceAPIDTO>
implements IPSSysServiceAPIService {
    private static final Log log = LogFactory.getLog(PSSysServiceAPIServiceImpl.class);

    @Override
    public List<PSSysServiceAPI> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysServiceAPI get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysServiceAPI> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSSysServiceAPI item : list) {
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
    public List<PSSysServiceAPIDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSSysServiceAPI> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSSysServiceAPIDTO> dtoList = new ArrayList<PSSysServiceAPIDTO>();
            for (PSSysServiceAPI item : list) {
                PSSysServiceAPIDTO dto = (PSSysServiceAPIDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysServiceAPI> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysServiceAPI get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysServiceAPI> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysServiceAPI item : list) {
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
    public List<PSSysServiceAPIDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysServiceAPI> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysServiceAPIDTO> dtoList = new ArrayList<PSSysServiceAPIDTO>();
            for (PSSysServiceAPI item : list) {
                PSSysServiceAPIDTO dto = (PSSysServiceAPIDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysServiceAPI> onListAll() throws Exception {
        List pssystems;
        ArrayList<PSSysServiceAPI> list = new ArrayList<PSSysServiceAPI>();
        List psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll();
        if (psmodules != null) {
            for (PSModule parent : psmodules) {
                List<PSSysServiceAPI> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysServiceAPI> items = this.listByPSSystem(parent);
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
    protected PSSysServiceAPI onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysServiceAPI item;
        PSSysServiceAPI item2;
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item2 = this.get(psmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysServiceAPI)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysServiceAPIDTO dto) throws Exception {
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
    public String getModelTag(PSSysServiceAPI et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSSysServiceAPIName())) {
            return et.getPSSysServiceAPIName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysServiceAPIDTO dto, PSSysServiceAPI t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysServiceAPIId(t.getId().replace("/", "."));
        }
        if (t.getAPILevel() != null || !bIgnoreNull) {
            dto.setAPILevel(t.getAPILevel());
        }
        if (t.getAPIMode() != null || !bIgnoreNull) {
            dto.setAPIMode(t.getAPIMode());
        }
        if (t.getAPITag() != null || !bIgnoreNull) {
            dto.setAPITag(t.getAPITag());
        }
        if (t.getAPITag2() != null || !bIgnoreNull) {
            dto.setAPITag2(t.getAPITag2());
        }
        if (t.getAPIType() != null || !bIgnoreNull) {
            dto.setAPIType(t.getAPIType());
        }
        if (t.getAuthCheckTokenUri() != null || !bIgnoreNull) {
            dto.setAuthCheckTokenUri(t.getAuthCheckTokenUri());
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
        if (t.getAuthParam3() != null || !bIgnoreNull) {
            dto.setAuthParam3(t.getAuthParam3());
        }
        if (t.getAuthParam4() != null || !bIgnoreNull) {
            dto.setAuthParam4(t.getAuthParam4());
        }
        if (t.getBaseClsParams() != null || !bIgnoreNull) {
            dto.setBaseClsParams(t.getBaseClsParams());
        }
        if (t.getCfgPSModelStorageId() != null || !bIgnoreNull) {
            dto.setCfgPSModelStorageId(t.getCfgPSModelStorageId());
        }
        if (t.getCfgTag() != null || !bIgnoreNull) {
            dto.setCfgTag(t.getCfgTag());
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
        if (t.getDefaultPort() != null || !bIgnoreNull) {
            dto.setDefaultPort(t.getDefaultPort());
        }
        if (t.getDefaultPSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setDefaultPSDEOPPrivId(t.getDefaultPSDEOPPrivId());
        }
        if (t.getDefaultPSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setDefaultPSDEOPPrivName(t.getDefaultPSDEOPPrivName());
        }
        if (t.getDefCreateReqMethod() != null || !bIgnoreNull) {
            dto.setDefCreateReqMethod(t.getDefCreateReqMethod());
        }
        if (t.getDefDEActionReqMethod() != null || !bIgnoreNull) {
            dto.setDefDEActionReqMethod(t.getDefDEActionReqMethod());
        }
        if (t.getDefDEDataSetReqMethod() != null || !bIgnoreNull) {
            dto.setDefDEDataSetReqMethod(t.getDefDEDataSetReqMethod());
        }
        if (t.getDefDeleteReqMethod() != null || !bIgnoreNull) {
            dto.setDefDeleteReqMethod(t.getDefDeleteReqMethod());
        }
        if (t.getDefGetReqMethod() != null || !bIgnoreNull) {
            dto.setDefGetReqMethod(t.getDefGetReqMethod());
        }
        if (t.getDefNeedResourceKey() != null || !bIgnoreNull) {
            dto.setDefNeedResourceKey(t.getDefNeedResourceKey());
        }
        if (t.getDefSelectReqMethod() != null || !bIgnoreNull) {
            dto.setDefSelectReqMethod(t.getDefSelectReqMethod());
        }
        if (t.getDefUpdateReqMethod() != null || !bIgnoreNull) {
            dto.setDefUpdateReqMethod(t.getDefUpdateReqMethod());
        }
        if (t.getDEPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setDEPSSysSFPluginId(t.getDEPSSysSFPluginId());
        }
        if (t.getDEPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setDEPSSysSFPluginName(t.getDEPSSysSFPluginName());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPredefinedType() != null || !bIgnoreNull) {
            dto.setPredefinedType(t.getPredefinedType());
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
        if (t.getPSSysSAHandlerId() != null || !bIgnoreNull) {
            dto.setPSSysSAHandlerId(t.getPSSysSAHandlerId());
        }
        if (t.getPSSysSAHandlerName() != null || !bIgnoreNull) {
            dto.setPSSysSAHandlerName(t.getPSSysSAHandlerName());
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
        if (t.getResetDefActionCodeName() != null || !bIgnoreNull) {
            dto.setResetDefActionCodeName(t.getResetDefActionCodeName());
        }
        if (t.getServiceCodeName() != null || !bIgnoreNull) {
            dto.setServiceCodeName(t.getServiceCodeName());
        }
        if (t.getServiceDTOFlag() != null || !bIgnoreNull) {
            dto.setServiceDTOFlag(t.getServiceDTOFlag());
        }
        if (t.getServiceParam() != null || !bIgnoreNull) {
            dto.setServiceParam(t.getServiceParam());
        }
        if (t.getServiceParam2() != null || !bIgnoreNull) {
            dto.setServiceParam2(t.getServiceParam2());
        }
        if (t.getServiceParam3() != null || !bIgnoreNull) {
            dto.setServiceParam3(t.getServiceParam3());
        }
        if (t.getServiceParam4() != null || !bIgnoreNull) {
            dto.setServiceParam4(t.getServiceParam4());
        }
        if (t.getServiceParams() != null || !bIgnoreNull) {
            dto.setServiceParams(t.getServiceParams());
        }
        if (t.getServiceType() != null || !bIgnoreNull) {
            dto.setServiceType(t.getServiceType());
        }
        if (t.getUniqueTag() != null || !bIgnoreNull) {
            dto.setUniqueTag(t.getUniqueTag());
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
        if (t.getVer() != null || !bIgnoreNull) {
            dto.setVer(t.getVer());
        }
        if (StringUtils.hasLength((String)dto.getDefaultPSDEOPPrivId())) {
            dto.setDefaultPSDEOPPrivId(this.getRealPSModelId(t, dto.getDefaultPSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDEPSSysSFPluginId())) {
            dto.setDEPSSysSFPluginId(this.getRealPSModelId(t, dto.getDEPSSysSFPluginId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysSAHandlerId())) {
            dto.setPSSysSAHandlerId(this.getRealPSModelId(t, dto.getPSSysSAHandlerId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getDefaultPSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getDefaultPSDEOPPrivId());
            dto.setDefaultPSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setDefaultPSDEOPPrivName(null);
        }
        if (StringUtils.hasLength((String)dto.getDEPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getDEPSSysSFPluginId());
            dto.setDEPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setDEPSSysSFPluginName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysSAHandlerId())) {
            linkDTO = (PSSysSAHandlerDTO)PSModelServiceUtil.getInstance().getPSSysSAHandlerService().getDTO(dto.getPSSysSAHandlerId());
            dto.setPSSysSAHandlerName(((PSSysSAHandlerDTO)linkDTO).getPSSysSAHandlerName());
        } else {
            dto.setPSSysSAHandlerName(null);
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
        return "PSSYSSERVICEAPI";
    }

    @Override
    public PSSysServiceAPI createDomain() {
        return new PSSysServiceAPI();
    }

    @Override
    public PSSysServiceAPIDTO createDTO() {
        return new PSSysServiceAPIDTO();
    }
}

