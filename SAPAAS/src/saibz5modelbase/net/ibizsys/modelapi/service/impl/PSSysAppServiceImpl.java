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
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSCtrlLogicGroupDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysSFPubDTO;
import net.ibizsys.modelapi.dto.PSSysServiceAPIDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.dto.PSViewMsgGroupDTO;
import net.ibizsys.modelapi.service.IPSSysAppService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysAppServiceImpl
extends PSModelServiceImplBase<PSSysApp, PSSysAppDTO>
implements IPSSysAppService {
    private static final Log log = LogFactory.getLog(PSSysAppServiceImpl.class);

    @Override
    public List<PSSysApp> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysApp get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysApp> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSSysApp item : list) {
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
    public List<PSSysAppDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSSysApp> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSSysAppDTO> dtoList = new ArrayList<PSSysAppDTO>();
            for (PSSysApp item : list) {
                PSSysAppDTO dto = (PSSysAppDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysApp> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysApp get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysApp> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysApp item : list) {
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
    public List<PSSysAppDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysApp> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysAppDTO> dtoList = new ArrayList<PSSysAppDTO>();
            for (PSSysApp item : list) {
                PSSysAppDTO dto = (PSSysAppDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysApp> onListAll() throws Exception {
        List pssystems;
        ArrayList<PSSysApp> list = new ArrayList<PSSysApp>();
        List psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll();
        if (psmodules != null) {
            for (PSModule parent : psmodules) {
                List<PSSysApp> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysApp> items = this.listByPSSystem(parent);
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
    protected PSSysApp onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysApp item;
        PSSysApp item2;
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item2 = this.get(psmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysApp)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysAppDTO dto) throws Exception {
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
    public String getModelTag(PSSysApp et) throws Exception {
        if (StringUtils.hasLength((String)et.getAppPKGName())) {
            return et.getAppPKGName();
        }
        if (StringUtils.hasLength((String)et.getPSSysAppName())) {
            return et.getPSSysAppName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysAppDTO dto, PSSysApp t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysAppId(t.getId().replace("/", "."));
        }
        if (t.getACMinChars() != null || !bIgnoreNull) {
            dto.setACMinChars(t.getACMinChars());
        }
        if (t.getAppFolder() != null || !bIgnoreNull) {
            dto.setAppFolder(t.getAppFolder());
        }
        if (t.getAppMode() != null || !bIgnoreNull) {
            dto.setAppMode(t.getAppMode());
        }
        if (t.getAppPKGName() != null || !bIgnoreNull) {
            dto.setAppPKGName(t.getAppPKGName());
        }
        if (t.getAppSN() != null || !bIgnoreNull) {
            dto.setAppSN(t.getAppSN());
        }
        if (t.getAppTag() != null || !bIgnoreNull) {
            dto.setAppTag(t.getAppTag());
        }
        if (t.getAppTag2() != null || !bIgnoreNull) {
            dto.setAppTag2(t.getAppTag2());
        }
        if (t.getAppTag3() != null || !bIgnoreNull) {
            dto.setAppTag3(t.getAppTag3());
        }
        if (t.getAppTag4() != null || !bIgnoreNull) {
            dto.setAppTag4(t.getAppTag4());
        }
        if (t.getAutoAddAppView() != null || !bIgnoreNull) {
            dto.setAutoAddAppView(t.getAutoAddAppView());
        }
        if (t.getBottomInfo() != null || !bIgnoreNull) {
            dto.setBottomInfo(t.getBottomInfo());
        }
        if (t.getBtnNoPrivDM() != null || !bIgnoreNull) {
            dto.setBtnNoPrivDM(t.getBtnNoPrivDM());
        }
        if (t.getCaption() != null || !bIgnoreNull) {
            dto.setCaption(t.getCaption());
        }
        if (t.getCodeFolder() != null || !bIgnoreNull) {
            dto.setCodeFolder(t.getCodeFolder());
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
        if (t.getDefaultPub() != null || !bIgnoreNull) {
            dto.setDefaultPub(t.getDefaultPub());
        }
        if (t.getDEPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setDEPSSysSFPluginId(t.getDEPSSysSFPluginId());
        }
        if (t.getDEPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setDEPSSysSFPluginName(t.getDEPSSysSFPluginName());
        }
        if (t.getEnableC12ToC24() != null || !bIgnoreNull) {
            dto.setEnableC12ToC24(t.getEnableC12ToC24());
        }
        if (t.getEnableDynaSys() != null || !bIgnoreNull) {
            dto.setEnableDynaSys(t.getEnableDynaSys());
        }
        if (t.getEnableStoryBoard() != null || !bIgnoreNull) {
            dto.setEnableStoryBoard(t.getEnableStoryBoard());
        }
        if (t.getEnaLocalService() != null || !bIgnoreNull) {
            dto.setEnaLocalService(t.getEnaLocalService());
        }
        if (t.getFIEmptyText() != null || !bIgnoreNull) {
            dto.setFIEmptyText(t.getFIEmptyText());
        }
        if (t.getFINoPrivDM() != null || !bIgnoreNull) {
            dto.setFINoPrivDM(t.getFINoPrivDM());
        }
        if (t.getFIUpdatePrivTag() != null || !bIgnoreNull) {
            dto.setFIUpdatePrivTag(t.getFIUpdatePrivTag());
        }
        if (t.getGCNoPrivDM() != null || !bIgnoreNull) {
            dto.setGCNoPrivDM(t.getGCNoPrivDM());
        }
        if (t.getGridColEnableFilter() != null || !bIgnoreNull) {
            dto.setGridColEnableFilter(t.getGridColEnableFilter());
        }
        if (t.getGridColEnableLink() != null || !bIgnoreNull) {
            dto.setGridColEnableLink(t.getGridColEnableLink());
        }
        if (t.getGridEnableCustomized() != null || !bIgnoreNull) {
            dto.setGridEnableCustomized(t.getGridEnableCustomized());
        }
        if (t.getGridForceFit() != null || !bIgnoreNull) {
            dto.setGridForceFit(t.getGridForceFit());
        }
        if (t.getGridRowActiveMode() != null || !bIgnoreNull) {
            dto.setGridRowActiveMode(t.getGridRowActiveMode());
        }
        if (t.getHeaderInfo() != null || !bIgnoreNull) {
            dto.setHeaderInfo(t.getHeaderInfo());
        }
        if (t.getIconFile() != null || !bIgnoreNull) {
            dto.setIconFile(t.getIconFile());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMainMenuSide() != null || !bIgnoreNull) {
            dto.setMainMenuSide(t.getMainMenuSide());
        }
        if (t.getMDCtrlEmptyText() != null || !bIgnoreNull) {
            dto.setMDCtrlEmptyText(t.getMDCtrlEmptyText());
        }
        if (t.getMDCtrlEmptyTextPSLanResId() != null || !bIgnoreNull) {
            dto.setMDCtrlEmptyTextPSLanResId(t.getMDCtrlEmptyTextPSLanResId());
        }
        if (t.getMDCtrlEmptyTextPSLanResName() != null || !bIgnoreNull) {
            dto.setMDCtrlEmptyTextPSLanResName(t.getMDCtrlEmptyTextPSLanResName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrientationMode() != null || !bIgnoreNull) {
            dto.setOrientationMode(t.getOrientationMode());
        }
        if (t.getPFStyleParam() != null || !bIgnoreNull) {
            dto.setPFStyleParam(t.getPFStyleParam());
        }
        if (t.getPreventXSS() != null || !bIgnoreNull) {
            dto.setPreventXSS(t.getPreventXSS());
        }
        if (t.getPSAppTypeId() != null || !bIgnoreNull) {
            dto.setPSAppTypeId(t.getPSAppTypeId());
        }
        if (t.getPSAppTypeName() != null || !bIgnoreNull) {
            dto.setPSAppTypeName(t.getPSAppTypeName());
        }
        if (t.getPSCtrlLogicGroupId() != null || !bIgnoreNull) {
            dto.setPSCtrlLogicGroupId(t.getPSCtrlLogicGroupId());
        }
        if (t.getPSCtrlLogicGroupName() != null || !bIgnoreNull) {
            dto.setPSCtrlLogicGroupName(t.getPSCtrlLogicGroupName());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
        }
        if (t.getPSPFCDNId() != null || !bIgnoreNull) {
            dto.setPSPFCDNId(t.getPSPFCDNId());
        }
        if (t.getPSPFCDNName() != null || !bIgnoreNull) {
            dto.setPSPFCDNName(t.getPSPFCDNName());
        }
        if (t.getPSPFId() != null || !bIgnoreNull) {
            dto.setPSPFId(t.getPSPFId());
        }
        if (t.getPSPFName() != null || !bIgnoreNull) {
            dto.setPSPFName(t.getPSPFName());
        }
        if (t.getPSPFStyleId() != null || !bIgnoreNull) {
            dto.setPSPFStyleId(t.getPSPFStyleId());
        }
        if (t.getPSPFStyleName() != null || !bIgnoreNull) {
            dto.setPSPFStyleName(t.getPSPFStyleName());
        }
        if (t.getPSStudioThemeId() != null || !bIgnoreNull) {
            dto.setPSStudioThemeId(t.getPSStudioThemeId());
        }
        if (t.getPSStudioThemeName() != null || !bIgnoreNull) {
            dto.setPSStudioThemeName(t.getPSStudioThemeName());
        }
        if (t.getPSSysAppName() != null || !bIgnoreNull) {
            dto.setPSSysAppName(t.getPSSysAppName());
        }
        if (t.getPSSysCssId() != null || !bIgnoreNull) {
            dto.setPSSysCssId(t.getPSSysCssId());
        }
        if (t.getPSSysCssName() != null || !bIgnoreNull) {
            dto.setPSSysCssName(t.getPSSysCssName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSysImageId() != null || !bIgnoreNull) {
            dto.setPSSysImageId(t.getPSSysImageId());
        }
        if (t.getPSSysImageName() != null || !bIgnoreNull) {
            dto.setPSSysImageName(t.getPSSysImageName());
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
        if (t.getPSSysSFPubId() != null || !bIgnoreNull) {
            dto.setPSSysSFPubId(t.getPSSysSFPubId());
        }
        if (t.getPSSysSFPubName() != null || !bIgnoreNull) {
            dto.setPSSysSFPubName(t.getPSSysSFPubName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getPSViewMsgGroupId() != null || !bIgnoreNull) {
            dto.setPSViewMsgGroupId(t.getPSViewMsgGroupId());
        }
        if (t.getPSViewMsgGroupName() != null || !bIgnoreNull) {
            dto.setPSViewMsgGroupName(t.getPSViewMsgGroupName());
        }
        if (t.getPubRefViewOnly() != null || !bIgnoreNull) {
            dto.setPubRefViewOnly(t.getPubRefViewOnly());
        }
        if (t.getPubSysRefViewOnly() != null || !bIgnoreNull) {
            dto.setPubSysRefViewOnly(t.getPubSysRefViewOnly());
        }
        if (t.getRemoveFlag() != null || !bIgnoreNull) {
            dto.setRemoveFlag(t.getRemoveFlag());
        }
        if (t.getServiceCodeName() != null || !bIgnoreNull) {
            dto.setServiceCodeName(t.getServiceCodeName());
        }
        if (t.getStartPageFile() != null || !bIgnoreNull) {
            dto.setStartPageFile(t.getStartPageFile());
        }
        if (t.getSubCaption() != null || !bIgnoreNull) {
            dto.setSubCaption(t.getSubCaption());
        }
        if (t.getTitle() != null || !bIgnoreNull) {
            dto.setTitle(t.getTitle());
        }
        if (t.getUACLogin() != null || !bIgnoreNull) {
            dto.setUACLogin(t.getUACLogin());
        }
        if (t.getUIStyle() != null || !bIgnoreNull) {
            dto.setUIStyle(t.getUIStyle());
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
        if (t.getUserParams() != null || !bIgnoreNull) {
            dto.setUserParams(t.getUserParams());
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
        if (StringUtils.hasLength((String)dto.getDEPSSysSFPluginId())) {
            dto.setDEPSSysSFPluginId(this.getRealPSModelId(t, dto.getDEPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMDCtrlEmptyTextPSLanResId())) {
            dto.setMDCtrlEmptyTextPSLanResId(this.getRealPSModelId(t, dto.getMDCtrlEmptyTextPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlLogicGroupId())) {
            dto.setPSCtrlLogicGroupId(this.getRealPSModelId(t, dto.getPSCtrlLogicGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            dto.setPSModuleId(this.getRealPSModelId(t, dto.getPSModuleId()).replace("/", "."));
        }
        if ("PSMODULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSModuleId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            dto.setPSSysCssId(this.getRealPSModelId(t, dto.getPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            dto.setPSSysImageId(this.getRealPSModelId(t, dto.getPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysServiceAPIId())) {
            dto.setPSSysServiceAPIId(this.getRealPSModelId(t, dto.getPSSysServiceAPIId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPubId())) {
            dto.setPSSysSFPubId(this.getRealPSModelId(t, dto.getPSSysSFPubId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSViewMsgGroupId())) {
            dto.setPSViewMsgGroupId(this.getRealPSModelId(t, dto.getPSViewMsgGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDEPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getDEPSSysSFPluginId());
            dto.setDEPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setDEPSSysSFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getMDCtrlEmptyTextPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getMDCtrlEmptyTextPSLanResId());
            dto.setMDCtrlEmptyTextPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setMDCtrlEmptyTextPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlLogicGroupId())) {
            linkDTO = (PSCtrlLogicGroupDTO)PSModelServiceUtil.getInstance().getPSCtrlLogicGroupService().getDTO(dto.getPSCtrlLogicGroupId());
            dto.setPSCtrlLogicGroupName(((PSCtrlLogicGroupDTO)linkDTO).getPSCtrlLogicGroupName());
        } else {
            dto.setPSCtrlLogicGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            linkDTO = (PSModuleDTO)PSModelServiceUtil.getInstance().getPSModuleService().getDTO(dto.getPSModuleId());
            dto.setPSModuleName(((PSModuleDTO)linkDTO).getPSModuleName());
        } else {
            dto.setPSModuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getPSSysCssId());
            dto.setPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            linkDTO = (PSSysImageDTO)PSModelServiceUtil.getInstance().getPSSysImageService().getDTO(dto.getPSSysImageId());
            dto.setPSSysImageName(((PSSysImageDTO)linkDTO).getPSSysImageName());
        } else {
            dto.setPSSysImageName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysSFPubId())) {
            linkDTO = (PSSysSFPubDTO)PSModelServiceUtil.getInstance().getPSSysSFPubService().getDTO(dto.getPSSysSFPubId());
            dto.setPSSysSFPubName(((PSSysSFPubDTO)linkDTO).getPSSysSFPubName());
        } else {
            dto.setPSSysSFPubName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(((PSSystemDTO)linkDTO).getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSViewMsgGroupId())) {
            linkDTO = (PSViewMsgGroupDTO)PSModelServiceUtil.getInstance().getPSViewMsgGroupService().getDTO(dto.getPSViewMsgGroupId());
            dto.setPSViewMsgGroupName(((PSViewMsgGroupDTO)linkDTO).getPSViewMsgGroupName());
        } else {
            dto.setPSViewMsgGroupName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSAPP";
    }

    @Override
    public PSSysApp createDomain() {
        return new PSSysApp();
    }

    @Override
    public PSSysAppDTO createDTO() {
        return new PSSysAppDTO();
    }
}

