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
import net.ibizsys.modelapi.domain.PSAppLocalDE;
import net.ibizsys.modelapi.domain.PSAppModule;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppLocalDEDTO;
import net.ibizsys.modelapi.dto.PSAppModuleDTO;
import net.ibizsys.modelapi.dto.PSDEFGroupDTO;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSDEServiceAPIDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysServiceAPIDTO;
import net.ibizsys.modelapi.service.IPSAppLocalDEService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppLocalDEServiceImpl
extends PSModelServiceImplBase<PSAppLocalDE, PSAppLocalDEDTO>
implements IPSAppLocalDEService {
    private static final Log log = LogFactory.getLog(PSAppLocalDEServiceImpl.class);

    @Override
    public List<PSAppLocalDE> listByPSAppModule(PSAppModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSAppLocalDE get(PSAppModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSAppLocalDE> list = this.listByPSAppModule(parent);
        if (list != null) {
            for (PSAppLocalDE item : list) {
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
    public List<PSAppLocalDEDTO> listDTOByPSAppModule(String strParentKey) throws Exception {
        PSAppModule psappmodule = (PSAppModule)PSModelServiceUtil.getInstance().getPSAppModuleService().get(strParentKey);
        List<PSAppLocalDE> list = this.listByPSAppModule(psappmodule);
        if (list != null) {
            ArrayList<PSAppLocalDEDTO> dtoList = new ArrayList<PSAppLocalDEDTO>();
            for (PSAppLocalDE item : list) {
                PSAppLocalDEDTO dto = (PSAppLocalDEDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSAppLocalDE> listByPSSysApp(PSSysApp parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSAppLocalDE get(PSSysApp parent, String strKey, boolean bTryMode) throws Exception {
        List<PSAppLocalDE> list = this.listByPSSysApp(parent);
        if (list != null) {
            for (PSAppLocalDE item : list) {
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
    public List<PSAppLocalDEDTO> listDTOByPSSysApp(String strParentKey) throws Exception {
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey);
        List<PSAppLocalDE> list = this.listByPSSysApp(pssysapp);
        if (list != null) {
            ArrayList<PSAppLocalDEDTO> dtoList = new ArrayList<PSAppLocalDEDTO>();
            for (PSAppLocalDE item : list) {
                PSAppLocalDEDTO dto = (PSAppLocalDEDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSAppLocalDE> onListAll() throws Exception {
        List<PSSysApp> pssysapps;
        ArrayList<PSAppLocalDE> list = new ArrayList<PSAppLocalDE>();
        List<PSAppModule> psappmodules = PSModelServiceUtil.getInstance().getPSAppModuleService().listAll();
        if (psappmodules != null) {
            for (PSAppModule parent : psappmodules) {
                List<PSAppLocalDE> items = this.listByPSAppModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssysapps = PSModelServiceUtil.getInstance().getPSSysAppService().listAll()) != null) {
            for (PSSysApp parent : pssysapps) {
                List<PSAppLocalDE> items = this.listByPSSysApp(parent);
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
    protected PSAppLocalDE onGet(String strParentKey, String strCurKey) throws Exception {
        PSAppLocalDE item;
        PSAppLocalDE item2;
        PSAppModule psappmodule = (PSAppModule)PSModelServiceUtil.getInstance().getPSAppModuleService().get(strParentKey, true);
        if (psappmodule != null && (item2 = this.get(psappmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey, true);
        if (pssysapp != null && (item = this.get(pssysapp, strCurKey, true)) != null) {
            return item;
        }
        return (PSAppLocalDE)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSAppLocalDEDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSAppModuleId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSAppModuleService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSSysAppId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysAppService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSAppLocalDE et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSAppLocalDEName())) {
            return et.getPSAppLocalDEName();
        }
        if (StringUtils.hasLength((String)et.getPSDEId())) {
            return et.getPSDEId();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppLocalDEDTO dto, PSAppLocalDE t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppLocalDEId(t.getId().replace("/", "."));
        }
        if (t.getAccCtrlArch() != null || !bIgnoreNull) {
            dto.setAccCtrlArch(t.getAccCtrlArch());
        }
        if (t.getAutoAddMethodMode() != null || !bIgnoreNull) {
            dto.setAutoAddMethodMode(t.getAutoAddMethodMode());
        }
        if (t.getAutoAddViewMode() != null || !bIgnoreNull) {
            dto.setAutoAddViewMode(t.getAutoAddViewMode());
        }
        if (t.getBaseClsParams() != null || !bIgnoreNull) {
            dto.setBaseClsParams(t.getBaseClsParams());
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
        if (t.getCustomUserAction() != null || !bIgnoreNull) {
            dto.setCustomUserAction(t.getCustomUserAction());
        }
        if (t.getDataAccMode() != null || !bIgnoreNull) {
            dto.setDataAccMode(t.getDataAccMode());
        }
        if (t.getDECodeName() != null || !bIgnoreNull) {
            dto.setDECodeName(t.getDECodeName());
        }
        if (t.getDefaultFlag() != null || !bIgnoreNull) {
            dto.setDefaultFlag(t.getDefaultFlag());
        }
        if (t.getDEFGroupMode() != null || !bIgnoreNull) {
            dto.setDEFGroupMode(t.getDEFGroupMode());
        }
        if (t.getDELogicName() != null || !bIgnoreNull) {
            dto.setDELogicName(t.getDELogicName());
        }
        if (t.getEnableStorage() != null || !bIgnoreNull) {
            dto.setEnableStorage(t.getEnableStorage());
        }
        if (t.getLinkPSDEViewId() != null || !bIgnoreNull) {
            dto.setLinkPSDEViewId(t.getLinkPSDEViewId());
        }
        if (t.getLinkPSDEViewName() != null || !bIgnoreNull) {
            dto.setLinkPSDEViewName(t.getLinkPSDEViewName());
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
        if (t.getMajorFlag() != null || !bIgnoreNull) {
            dto.setMajorFlag(t.getMajorFlag());
        }
        if (t.getMDPSDEViewId() != null || !bIgnoreNull) {
            dto.setMDPSDEViewId(t.getMDPSDEViewId());
        }
        if (t.getMDPSDEViewName() != null || !bIgnoreNull) {
            dto.setMDPSDEViewName(t.getMDPSDEViewName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPPSAppLocalDEId() != null || !bIgnoreNull) {
            dto.setPPSAppLocalDEId(t.getPPSAppLocalDEId());
        }
        if (t.getPPSAppLocalDEName() != null || !bIgnoreNull) {
            dto.setPPSAppLocalDEName(t.getPPSAppLocalDEName());
        }
        if (t.getPSAppLocalDEName() != null || !bIgnoreNull) {
            dto.setPSAppLocalDEName(t.getPSAppLocalDEName());
        }
        if (t.getPSAppModuleId() != null || !bIgnoreNull) {
            dto.setPSAppModuleId(t.getPSAppModuleId());
        }
        if (t.getPSAppModuleName() != null || !bIgnoreNull) {
            dto.setPSAppModuleName(t.getPSAppModuleName());
        }
        if (t.getPSDEFGroupId() != null || !bIgnoreNull) {
            dto.setPSDEFGroupId(t.getPSDEFGroupId());
        }
        if (t.getPSDEFGroupName() != null || !bIgnoreNull) {
            dto.setPSDEFGroupName(t.getPSDEFGroupName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDERId() != null || !bIgnoreNull) {
            dto.setPSDERId(t.getPSDERId());
        }
        if (t.getPSDERName() != null || !bIgnoreNull) {
            dto.setPSDERName(t.getPSDERName());
        }
        if (t.getPSDEServiceAPIId() != null || !bIgnoreNull) {
            dto.setPSDEServiceAPIId(t.getPSDEServiceAPIId());
        }
        if (t.getPSDEServiceAPIName() != null || !bIgnoreNull) {
            dto.setPSDEServiceAPIName(t.getPSDEServiceAPIName());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSSysAppId() != null || !bIgnoreNull) {
            dto.setPSSysAppId(t.getPSSysAppId());
        }
        if (t.getPSSysAppName() != null || !bIgnoreNull) {
            dto.setPSSysAppName(t.getPSSysAppName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
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
        if (t.getSDPSDEViewID() != null || !bIgnoreNull) {
            dto.setSDPSDEViewID(t.getSDPSDEViewID());
        }
        if (t.getSDPSDEViewName() != null || !bIgnoreNull) {
            dto.setSDPSDEViewName(t.getSDPSDEViewName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUserAction() != null || !bIgnoreNull) {
            dto.setUserAction(t.getUserAction());
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
        if (StringUtils.hasLength((String)dto.getLinkPSDEViewId())) {
            dto.setLinkPSDEViewId(this.getRealPSModelId(t, dto.getLinkPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLNPSLanResId())) {
            dto.setLNPSLanResId(this.getRealPSModelId(t, dto.getLNPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMDPSDEViewId())) {
            dto.setMDPSDEViewId(this.getRealPSModelId(t, dto.getMDPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSAppLocalDEId())) {
            dto.setPPSAppLocalDEId(this.getRealPSModelId(t, dto.getPPSAppLocalDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppModuleId())) {
            dto.setPSAppModuleId(this.getRealPSModelId(t, dto.getPSAppModuleId()).replace("/", "."));
        }
        if ("PSAPPMODULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSAppModuleId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFGroupId())) {
            dto.setPSDEFGroupId(this.getRealPSModelId(t, dto.getPSDEFGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            dto.setPSDERId(this.getRealPSModelId(t, dto.getPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEServiceAPIId())) {
            dto.setPSDEServiceAPIId(this.getRealPSModelId(t, dto.getPSDEServiceAPIId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            dto.setPSSysAppId(this.getRealPSModelId(t, dto.getPSSysAppId()).replace("/", "."));
        }
        if ("PSSYSAPP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysAppId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysServiceAPIId())) {
            dto.setPSSysServiceAPIId(this.getRealPSModelId(t, dto.getPSSysServiceAPIId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getSDPSDEViewID())) {
            dto.setSDPSDEViewID(this.getRealPSModelId(t, dto.getSDPSDEViewID()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLinkPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getLinkPSDEViewId());
            dto.setLinkPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setLinkPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getLNPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getLNPSLanResId());
            dto.setLNPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setLNPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getMDPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getMDPSDEViewId());
            dto.setMDPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setMDPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPPSAppLocalDEId())) {
            linkDTO = (PSAppLocalDEDTO)PSModelServiceUtil.getInstance().getPSAppLocalDEService().getDTO(dto.getPPSAppLocalDEId());
            dto.setPPSAppLocalDEName(((PSAppLocalDEDTO)linkDTO).getPSAppLocalDEName());
        } else {
            dto.setPPSAppLocalDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSAppModuleId())) {
            linkDTO = (PSAppModuleDTO)PSModelServiceUtil.getInstance().getPSAppModuleService().getDTO(dto.getPSAppModuleId());
            dto.setPSAppModuleName(((PSAppModuleDTO)linkDTO).getPSAppModuleName());
        } else {
            dto.setPSAppModuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFGroupId())) {
            linkDTO = (PSDEFGroupDTO)PSModelServiceUtil.getInstance().getPSDEFGroupService().getDTO(dto.getPSDEFGroupId());
            dto.setPSDEFGroupName(((PSDEFGroupDTO)linkDTO).getPSDEFGroupName());
        } else {
            dto.setPSDEFGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setDECodeName(((PSDataEntityDTO)linkDTO).getCodeName());
            dto.setDELogicName(((PSDataEntityDTO)linkDTO).getLogicName());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
            dto.setPSModuleId(((PSDataEntityDTO)linkDTO).getPSModuleId());
        } else {
            dto.setDECodeName(null);
            dto.setDELogicName(null);
            dto.setPSDEName(null);
            dto.setPSModuleId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getPSDERId());
            dto.setPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEServiceAPIId())) {
            linkDTO = (PSDEServiceAPIDTO)PSModelServiceUtil.getInstance().getPSDEServiceAPIService().getDTO(dto.getPSDEServiceAPIId());
            dto.setPSDEServiceAPIName(((PSDEServiceAPIDTO)linkDTO).getPSDEServiceAPIName());
        } else {
            dto.setPSDEServiceAPIName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            linkDTO = (PSSysAppDTO)PSModelServiceUtil.getInstance().getPSSysAppService().getDTO(dto.getPSSysAppId());
            dto.setPSSysAppName(((PSSysAppDTO)linkDTO).getPSSysAppName());
        } else {
            dto.setPSSysAppName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
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
        if (StringUtils.hasLength((String)dto.getSDPSDEViewID())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getSDPSDEViewID());
            dto.setSDPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setSDPSDEViewName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSAPPLOCALDE";
    }

    @Override
    public PSAppLocalDE createDomain() {
        return new PSAppLocalDE();
    }

    @Override
    public PSAppLocalDEDTO createDTO() {
        return new PSAppLocalDEDTO();
    }
}

