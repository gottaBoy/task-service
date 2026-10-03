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
import net.ibizsys.modelapi.domain.PSAppModule;
import net.ibizsys.modelapi.domain.PSAppView;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSACHandlerDTO;
import net.ibizsys.modelapi.dto.PSAppLocalDEDTO;
import net.ibizsys.modelapi.dto.PSAppModuleDTO;
import net.ibizsys.modelapi.dto.PSAppTitleBarDTO;
import net.ibizsys.modelapi.dto.PSAppViewDTO;
import net.ibizsys.modelapi.dto.PSCtrlLogicGroupDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSubViewTypeDTO;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.dto.PSSysUniResDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelDTO;
import net.ibizsys.modelapi.dto.PSViewMsgGroupDTO;
import net.ibizsys.modelapi.service.IPSAppViewService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public abstract class PSAppViewServiceImpl<T extends PSAppView, DTO extends PSAppViewDTO>
extends PSModelServiceImplBase<T, DTO>
implements IPSAppViewService<T, DTO> {
    private static final Log log = LogFactory.getLog(PSAppViewServiceImpl.class);

    @Override
    public List<T> listByPSAppModule(PSAppModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public T get(PSAppModule parent, String strKey, boolean bTryMode) throws Exception {
        List<T> list = this.listByPSAppModule(parent);
        if (list != null) {
            for (T item : list) {
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
    public List<DTO> listDTOByPSAppModule(String strParentKey) throws Exception {
        PSAppModule psappmodule = (PSAppModule)PSModelServiceUtil.getInstance().getPSAppModuleService().get(strParentKey);
        List<T> list = this.listByPSAppModule(psappmodule);
        if (list != null) {
            ArrayList<DTO> dtoList = new ArrayList<DTO>();
            for (T item : list) {
                DTO dto = this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<T> listByPSSysApp(PSSysApp parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public T get(PSSysApp parent, String strKey, boolean bTryMode) throws Exception {
        List<T> list = this.listByPSSysApp(parent);
        if (list != null) {
            for (T item : list) {
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
    public List<DTO> listDTOByPSSysApp(String strParentKey) throws Exception {
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey);
        List<T> list = this.listByPSSysApp(pssysapp);
        if (list != null) {
            ArrayList<DTO> dtoList = new ArrayList<DTO>();
            for (T item : list) {
                DTO dto = this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<T> onListAll() throws Exception {
        List<PSSysApp> pssysapps;
        ArrayList<T> list = new ArrayList<T>();
        List<PSAppModule> psappmodules = PSModelServiceUtil.getInstance().getPSAppModuleService().listAll();
        if (psappmodules != null) {
            for (PSAppModule parent : psappmodules) {
                List<T> items = this.listByPSAppModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssysapps = PSModelServiceUtil.getInstance().getPSSysAppService().listAll()) != null) {
            for (PSSysApp parent : pssysapps) {
                List<T> items = this.listByPSSysApp(parent);
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
    protected T onGet(String strParentKey, String strCurKey) throws Exception {
        T item;
        T item2;
        PSAppModule psappmodule = (PSAppModule)PSModelServiceUtil.getInstance().getPSAppModuleService().get(strParentKey, true);
        if (psappmodule != null && (item2 = this.get(psappmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey, true);
        if (pssysapp != null && (item = this.get(pssysapp, strCurKey, true)) != null) {
            return item;
        }
        return (T)((PSAppView)super.onGet(strParentKey, strCurKey));
    }

    @Override
    public IPSModel getParentModel(DTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = ((PSAppViewDTO)dto).getPSAppModuleId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSAppModuleService().get(strPickupValue, false);
        }
        strPickupValue = ((PSAppViewDTO)dto).getPSSysAppId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysAppService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(T et) throws Exception {
        if (StringUtils.hasLength((String)((PSAppView)et).getPSAppViewName())) {
            return ((PSAppView)et).getPSAppViewName();
        }
        if (StringUtils.hasLength((String)((PSAppView)et).getPSAppViewName())) {
            return ((PSAppView)et).getPSAppViewName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(DTO dto, T t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)((PSModelBase)t).getId())) {
            ((PSAppViewDTO)dto).setPSAppViewId(((PSModelBase)t).getId().replace("/", "."));
        }
        if (((PSAppView)t).getAccUserMode() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setAccUserMode(((PSAppView)t).getAccUserMode());
        }
        if (((PSAppView)t).getAppViewSN() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setAppViewSN(((PSAppView)t).getAppViewSN());
        }
        if (((PSAppView)t).getAppViewState() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setAppViewState(((PSAppView)t).getAppViewState());
        }
        if (((PSAppView)t).getCapPSLanResId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setCapPSLanResId(((PSAppView)t).getCapPSLanResId());
        }
        if (((PSAppView)t).getCapPSLanResName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setCapPSLanResName(((PSAppView)t).getCapPSLanResName());
        }
        if (((PSAppView)t).getCaption() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setCaption(((PSAppView)t).getCaption());
        }
        if (((PSAppView)t).getColor() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setColor(((PSAppView)t).getColor());
        }
        if (((PSAppView)t).getCreateDate() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setCreateDate(((PSAppView)t).getCreateDate());
        }
        if (((PSAppView)t).getCreateMan() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setCreateMan(((PSAppView)t).getCreateMan());
        }
        if (((PSAppView)t).getDynaModelFlag() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setDynaModelFlag(((PSAppView)t).getDynaModelFlag());
        }
        if (((PSAppView)t).getDyncMode() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setDyncMode(((PSAppView)t).getDyncMode());
        }
        if (((PSAppView)t).getEnableViewStyle() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setEnableViewStyle(((PSAppView)t).getEnableViewStyle());
        }
        if (((PSAppView)t).getLayoutPanelMode() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setLayoutPanelMode(((PSAppView)t).getLayoutPanelMode());
        }
        if (((PSAppView)t).getMemo() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setMemo(((PSAppView)t).getMemo());
        }
        if (((PSAppView)t).getModColor() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setModColor(((PSAppView)t).getModColor());
        }
        if (((PSAppView)t).getPreventXSS() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPreventXSS(((PSAppView)t).getPreventXSS());
        }
        if (((PSAppView)t).getPSACHandlerId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSACHandlerId(((PSAppView)t).getPSACHandlerId());
        }
        if (((PSAppView)t).getPSACHandlerName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSACHandlerName(((PSAppView)t).getPSACHandlerName());
        }
        if (((PSAppView)t).getPSAppLocalDEId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSAppLocalDEId(((PSAppView)t).getPSAppLocalDEId());
        }
        if (((PSAppView)t).getPSAppLocalDEName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSAppLocalDEName(((PSAppView)t).getPSAppLocalDEName());
        }
        if (((PSAppView)t).getPSAppModuleId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSAppModuleId(((PSAppView)t).getPSAppModuleId());
        }
        if (((PSAppView)t).getPSAppModuleName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSAppModuleName(((PSAppView)t).getPSAppModuleName());
        }
        if (((PSAppView)t).getPSAppTitleBarId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSAppTitleBarId(((PSAppView)t).getPSAppTitleBarId());
        }
        if (((PSAppView)t).getPSAppTitleBarName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSAppTitleBarName(((PSAppView)t).getPSAppTitleBarName());
        }
        if (((PSAppView)t).getPSAppUtilViewType() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSAppUtilViewType(((PSAppView)t).getPSAppUtilViewType());
        }
        if (((PSAppView)t).getPSAppViewName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSAppViewName(((PSAppView)t).getPSAppViewName());
        }
        if (((PSAppView)t).getPSAppViewType() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSAppViewType(((PSAppView)t).getPSAppViewType());
        }
        if (((PSAppView)t).getPSCtrlLogicGroupId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSCtrlLogicGroupId(((PSAppView)t).getPSCtrlLogicGroupId());
        }
        if (((PSAppView)t).getPSCtrlLogicGroupName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSCtrlLogicGroupName(((PSAppView)t).getPSCtrlLogicGroupName());
        }
        if (((PSAppView)t).getPSDEViewBaseId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSDEViewBaseId(((PSAppView)t).getPSDEViewBaseId());
        }
        if (((PSAppView)t).getPSDEViewBaseName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSDEViewBaseName(((PSAppView)t).getPSDEViewBaseName());
        }
        if (((PSAppView)t).getPSDEViewType() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSDEViewType(((PSAppView)t).getPSDEViewType());
        }
        if (((PSAppView)t).getPSDynaDEViewTemplId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSDynaDEViewTemplId(((PSAppView)t).getPSDynaDEViewTemplId());
        }
        if (((PSAppView)t).getPSDynaDEViewTemplName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSDynaDEViewTemplName(((PSAppView)t).getPSDynaDEViewTemplName());
        }
        if (((PSAppView)t).getPSDynaDEViewType() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSDynaDEViewType(((PSAppView)t).getPSDynaDEViewType());
        }
        if (((PSAppView)t).getPSHelpModuleId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSHelpModuleId(((PSAppView)t).getPSHelpModuleId());
        }
        if (((PSAppView)t).getPSHelpModuleName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSHelpModuleName(((PSAppView)t).getPSHelpModuleName());
        }
        if (((PSAppView)t).getPSPFId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSPFId(((PSAppView)t).getPSPFId());
        }
        if (((PSAppView)t).getPSPFStyleId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSPFStyleId(((PSAppView)t).getPSPFStyleId());
        }
        if (((PSAppView)t).getPSPFStyleName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSPFStyleName(((PSAppView)t).getPSPFStyleName());
        }
        if (((PSAppView)t).getPSSubViewTypeId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSSubViewTypeId(((PSAppView)t).getPSSubViewTypeId());
        }
        if (((PSAppView)t).getPSSubViewTypeName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSSubViewTypeName(((PSAppView)t).getPSSubViewTypeName());
        }
        if (((PSAppView)t).getPSSysAppId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSSysAppId(((PSAppView)t).getPSSysAppId());
        }
        if (((PSAppView)t).getPSSysAppName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSSysAppName(((PSAppView)t).getPSSysAppName());
        }
        if (((PSAppView)t).getPSSysCssId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSSysCssId(((PSAppView)t).getPSSysCssId());
        }
        if (((PSAppView)t).getPSSysCssName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSSysCssName(((PSAppView)t).getPSSysCssName());
        }
        if (((PSAppView)t).getPSSysDynaModelId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSSysDynaModelId(((PSAppView)t).getPSSysDynaModelId());
        }
        if (((PSAppView)t).getPSSysDynaModelName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSSysDynaModelName(((PSAppView)t).getPSSysDynaModelName());
        }
        if (((PSAppView)t).getPSSysImageId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSSysImageId(((PSAppView)t).getPSSysImageId());
        }
        if (((PSAppView)t).getPSSysImageName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSSysImageName(((PSAppView)t).getPSSysImageName());
        }
        if (((PSAppView)t).getPSSysReqItemId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSSysReqItemId(((PSAppView)t).getPSSysReqItemId());
        }
        if (((PSAppView)t).getPSSysReqItemName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSSysReqItemName(((PSAppView)t).getPSSysReqItemName());
        }
        if (((PSAppView)t).getPSSystemId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSSystemId(((PSAppView)t).getPSSystemId());
        }
        if (((PSAppView)t).getPSSysUniResId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSSysUniResId(((PSAppView)t).getPSSysUniResId());
        }
        if (((PSAppView)t).getPSSysUniResName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSSysUniResName(((PSAppView)t).getPSSysUniResName());
        }
        if (((PSAppView)t).getPSSysViewPanelId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSSysViewPanelId(((PSAppView)t).getPSSysViewPanelId());
        }
        if (((PSAppView)t).getPSSysViewPanelName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSSysViewPanelName(((PSAppView)t).getPSSysViewPanelName());
        }
        if (((PSAppView)t).getPSViewEngineId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSViewEngineId(((PSAppView)t).getPSViewEngineId());
        }
        if (((PSAppView)t).getPSViewEngineName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSViewEngineName(((PSAppView)t).getPSViewEngineName());
        }
        if (((PSAppView)t).getPSViewMsgGroupId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSViewMsgGroupId(((PSAppView)t).getPSViewMsgGroupId());
        }
        if (((PSAppView)t).getPSViewMsgGroupName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSViewMsgGroupName(((PSAppView)t).getPSViewMsgGroupName());
        }
        if (((PSAppView)t).getPSViewWizardGroupId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSViewWizardGroupId(((PSAppView)t).getPSViewWizardGroupId());
        }
        if (((PSAppView)t).getPSViewWizardGroupName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setPSViewWizardGroupName(((PSAppView)t).getPSViewWizardGroupName());
        }
        if (((PSAppView)t).getShowCaptionBar() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setShowCaptionBar(((PSAppView)t).getShowCaptionBar());
        }
        if (((PSAppView)t).getSubCapPSLanResId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setSubCapPSLanResId(((PSAppView)t).getSubCapPSLanResId());
        }
        if (((PSAppView)t).getSubCapPSLanResName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setSubCapPSLanResName(((PSAppView)t).getSubCapPSLanResName());
        }
        if (((PSAppView)t).getSubCaption() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setSubCaption(((PSAppView)t).getSubCaption());
        }
        if (((PSAppView)t).getSyncCodeName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setSyncCodeName(((PSAppView)t).getSyncCodeName());
        }
        if (((PSAppView)t).getSysRefFlag() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setSysRefFlag(((PSAppView)t).getSysRefFlag());
        }
        if (((PSAppView)t).getTitle() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setTitle(((PSAppView)t).getTitle());
        }
        if (((PSAppView)t).getTitlePSLanResId() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setTitlePSLanResId(((PSAppView)t).getTitlePSLanResId());
        }
        if (((PSAppView)t).getTitlePSLanResName() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setTitlePSLanResName(((PSAppView)t).getTitlePSLanResName());
        }
        if (((PSAppView)t).getToDoTask() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setToDoTask(((PSAppView)t).getToDoTask());
        }
        if (((PSAppView)t).getUIStyle() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setUIStyle(((PSAppView)t).getUIStyle());
        }
        if (((PSAppView)t).getUpdateDate() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setUpdateDate(((PSAppView)t).getUpdateDate());
        }
        if (((PSAppView)t).getUpdateMan() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setUpdateMan(((PSAppView)t).getUpdateMan());
        }
        if (((PSAppView)t).getUserParams() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setUserParams(((PSAppView)t).getUserParams());
        }
        if (((PSAppView)t).getUserRefFlag() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setUserRefFlag(((PSAppView)t).getUserRefFlag());
        }
        if (((PSAppView)t).getUserTag() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setUserTag(((PSAppView)t).getUserTag());
        }
        if (((PSAppView)t).getUserTag2() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setUserTag2(((PSAppView)t).getUserTag2());
        }
        if (((PSAppView)t).getUserTag3() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setUserTag3(((PSAppView)t).getUserTag3());
        }
        if (((PSAppView)t).getUserTag4() != null || !bIgnoreNull) {
            ((PSAppViewDTO)dto).setUserTag4(((PSAppView)t).getUserTag4());
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getCapPSLanResId())) {
            ((PSAppViewDTO)dto).setCapPSLanResId(this.getRealPSModelId((IPSModel)t, ((PSAppViewDTO)dto).getCapPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSACHandlerId())) {
            ((PSAppViewDTO)dto).setPSACHandlerId(this.getRealPSModelId((IPSModel)t, ((PSAppViewDTO)dto).getPSACHandlerId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSAppLocalDEId())) {
            ((PSAppViewDTO)dto).setPSAppLocalDEId(this.getRealPSModelId((IPSModel)t, ((PSAppViewDTO)dto).getPSAppLocalDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSAppModuleId())) {
            ((PSAppViewDTO)dto).setPSAppModuleId(this.getRealPSModelId((IPSModel)t, ((PSAppViewDTO)dto).getPSAppModuleId()).replace("/", "."));
        }
        if ("PSAPPMODULE".compareTo(((PSModelBase)t).getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)((PSModelBase)t).getSrfParent().getId())) {
            ((PSAppViewDTO)dto).setPSAppModuleId(((PSModelBase)t).getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSAppTitleBarId())) {
            ((PSAppViewDTO)dto).setPSAppTitleBarId(this.getRealPSModelId((IPSModel)t, ((PSAppViewDTO)dto).getPSAppTitleBarId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSCtrlLogicGroupId())) {
            ((PSAppViewDTO)dto).setPSCtrlLogicGroupId(this.getRealPSModelId((IPSModel)t, ((PSAppViewDTO)dto).getPSCtrlLogicGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSDEViewBaseId())) {
            ((PSAppViewDTO)dto).setPSDEViewBaseId(this.getRealPSModelId((IPSModel)t, ((PSAppViewDTO)dto).getPSDEViewBaseId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSSubViewTypeId())) {
            ((PSAppViewDTO)dto).setPSSubViewTypeId(this.getRealPSModelId((IPSModel)t, ((PSAppViewDTO)dto).getPSSubViewTypeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSSysAppId())) {
            ((PSAppViewDTO)dto).setPSSysAppId(this.getRealPSModelId((IPSModel)t, ((PSAppViewDTO)dto).getPSSysAppId()).replace("/", "."));
        }
        if ("PSSYSAPP".compareTo(((PSModelBase)t).getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)((PSModelBase)t).getSrfParent().getId())) {
            ((PSAppViewDTO)dto).setPSSysAppId(((PSModelBase)t).getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSSysCssId())) {
            ((PSAppViewDTO)dto).setPSSysCssId(this.getRealPSModelId((IPSModel)t, ((PSAppViewDTO)dto).getPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSSysDynaModelId())) {
            ((PSAppViewDTO)dto).setPSSysDynaModelId(this.getRealPSModelId((IPSModel)t, ((PSAppViewDTO)dto).getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSSysImageId())) {
            ((PSAppViewDTO)dto).setPSSysImageId(this.getRealPSModelId((IPSModel)t, ((PSAppViewDTO)dto).getPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSSysReqItemId())) {
            ((PSAppViewDTO)dto).setPSSysReqItemId(this.getRealPSModelId((IPSModel)t, ((PSAppViewDTO)dto).getPSSysReqItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSSysUniResId())) {
            ((PSAppViewDTO)dto).setPSSysUniResId(this.getRealPSModelId((IPSModel)t, ((PSAppViewDTO)dto).getPSSysUniResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSSysViewPanelId())) {
            ((PSAppViewDTO)dto).setPSSysViewPanelId(this.getRealPSModelId((IPSModel)t, ((PSAppViewDTO)dto).getPSSysViewPanelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSViewMsgGroupId())) {
            ((PSAppViewDTO)dto).setPSViewMsgGroupId(this.getRealPSModelId((IPSModel)t, ((PSAppViewDTO)dto).getPSViewMsgGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getSubCapPSLanResId())) {
            ((PSAppViewDTO)dto).setSubCapPSLanResId(this.getRealPSModelId((IPSModel)t, ((PSAppViewDTO)dto).getSubCapPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getTitlePSLanResId())) {
            ((PSAppViewDTO)dto).setTitlePSLanResId(this.getRealPSModelId((IPSModel)t, ((PSAppViewDTO)dto).getTitlePSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getCapPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(((PSAppViewDTO)dto).getCapPSLanResId());
            ((PSAppViewDTO)dto).setCapPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            ((PSAppViewDTO)dto).setCapPSLanResName(null);
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSACHandlerId())) {
            linkDTO = (PSACHandlerDTO)PSModelServiceUtil.getInstance().getPSACHandlerService().getDTO(((PSAppViewDTO)dto).getPSACHandlerId());
            ((PSAppViewDTO)dto).setPSACHandlerName(((PSACHandlerDTO)linkDTO).getPSACHandlerName());
        } else {
            ((PSAppViewDTO)dto).setPSACHandlerName(null);
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSAppLocalDEId())) {
            linkDTO = (PSAppLocalDEDTO)PSModelServiceUtil.getInstance().getPSAppLocalDEService().getDTO(((PSAppViewDTO)dto).getPSAppLocalDEId());
            ((PSAppViewDTO)dto).setPSAppLocalDEName(((PSAppLocalDEDTO)linkDTO).getPSAppLocalDEName());
        } else {
            ((PSAppViewDTO)dto).setPSAppLocalDEName(null);
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSAppModuleId())) {
            linkDTO = (PSAppModuleDTO)PSModelServiceUtil.getInstance().getPSAppModuleService().getDTO(((PSAppViewDTO)dto).getPSAppModuleId());
            ((PSAppViewDTO)dto).setModColor(((PSAppModuleDTO)linkDTO).getColor());
            ((PSAppViewDTO)dto).setPSAppModuleName(((PSAppModuleDTO)linkDTO).getPSAppModuleName());
        } else {
            ((PSAppViewDTO)dto).setModColor(null);
            ((PSAppViewDTO)dto).setPSAppModuleName(null);
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSAppTitleBarId())) {
            linkDTO = (PSAppTitleBarDTO)PSModelServiceUtil.getInstance().getPSAppTitleBarService().getDTO(((PSAppViewDTO)dto).getPSAppTitleBarId());
            ((PSAppViewDTO)dto).setPSAppTitleBarName(((PSAppTitleBarDTO)linkDTO).getPSAppTitleBarName());
        } else {
            ((PSAppViewDTO)dto).setPSAppTitleBarName(null);
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSCtrlLogicGroupId())) {
            linkDTO = (PSCtrlLogicGroupDTO)PSModelServiceUtil.getInstance().getPSCtrlLogicGroupService().getDTO(((PSAppViewDTO)dto).getPSCtrlLogicGroupId());
            ((PSAppViewDTO)dto).setPSCtrlLogicGroupName(((PSCtrlLogicGroupDTO)linkDTO).getPSCtrlLogicGroupName());
        } else {
            ((PSAppViewDTO)dto).setPSCtrlLogicGroupName(null);
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSDEViewBaseId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(((PSAppViewDTO)dto).getPSDEViewBaseId());
            ((PSAppViewDTO)dto).setPSDEViewBaseName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
            ((PSAppViewDTO)dto).setPSDEViewType(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseType());
        } else {
            ((PSAppViewDTO)dto).setPSDEViewBaseName(null);
            ((PSAppViewDTO)dto).setPSDEViewType(null);
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSSubViewTypeId())) {
            linkDTO = (PSSubViewTypeDTO)PSModelServiceUtil.getInstance().getPSSubViewTypeService().getDTO(((PSAppViewDTO)dto).getPSSubViewTypeId());
            ((PSAppViewDTO)dto).setPSSubViewTypeName(((PSSubViewTypeDTO)linkDTO).getPSSubViewTypeName());
        } else {
            ((PSAppViewDTO)dto).setPSSubViewTypeName(null);
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSSysAppId())) {
            linkDTO = (PSSysAppDTO)PSModelServiceUtil.getInstance().getPSSysAppService().getDTO(((PSAppViewDTO)dto).getPSSysAppId());
            ((PSAppViewDTO)dto).setPSPFId(((PSSysAppDTO)linkDTO).getPSPFId());
            ((PSAppViewDTO)dto).setPSSysAppName(((PSSysAppDTO)linkDTO).getPSSysAppName());
            ((PSAppViewDTO)dto).setPSSystemId(((PSSysAppDTO)linkDTO).getPSSystemId());
        } else {
            ((PSAppViewDTO)dto).setPSPFId(null);
            ((PSAppViewDTO)dto).setPSSysAppName(null);
            ((PSAppViewDTO)dto).setPSSystemId(null);
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(((PSAppViewDTO)dto).getPSSysCssId());
            ((PSAppViewDTO)dto).setPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            ((PSAppViewDTO)dto).setPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(((PSAppViewDTO)dto).getPSSysDynaModelId());
            ((PSAppViewDTO)dto).setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            ((PSAppViewDTO)dto).setPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSSysImageId())) {
            linkDTO = (PSSysImageDTO)PSModelServiceUtil.getInstance().getPSSysImageService().getDTO(((PSAppViewDTO)dto).getPSSysImageId());
            ((PSAppViewDTO)dto).setPSSysImageName(((PSSysImageDTO)linkDTO).getPSSysImageName());
        } else {
            ((PSAppViewDTO)dto).setPSSysImageName(null);
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSSysReqItemId())) {
            linkDTO = (PSSysReqItemDTO)PSModelServiceUtil.getInstance().getPSSysReqItemService().getDTO(((PSAppViewDTO)dto).getPSSysReqItemId());
            ((PSAppViewDTO)dto).setPSSysReqItemName(((PSSysReqItemDTO)linkDTO).getPSSysReqItemName());
        } else {
            ((PSAppViewDTO)dto).setPSSysReqItemName(null);
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSSysUniResId())) {
            linkDTO = (PSSysUniResDTO)PSModelServiceUtil.getInstance().getPSSysUniResService().getDTO(((PSAppViewDTO)dto).getPSSysUniResId());
            ((PSAppViewDTO)dto).setPSSysUniResName(((PSSysUniResDTO)linkDTO).getPSSysUniResName());
        } else {
            ((PSAppViewDTO)dto).setPSSysUniResName(null);
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSSysViewPanelId())) {
            linkDTO = (PSSysViewPanelDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelService().getDTO(((PSAppViewDTO)dto).getPSSysViewPanelId());
            ((PSAppViewDTO)dto).setPSSysViewPanelName(((PSSysViewPanelDTO)linkDTO).getPSSysViewPanelName());
        } else {
            ((PSAppViewDTO)dto).setPSSysViewPanelName(null);
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getPSViewMsgGroupId())) {
            linkDTO = (PSViewMsgGroupDTO)PSModelServiceUtil.getInstance().getPSViewMsgGroupService().getDTO(((PSAppViewDTO)dto).getPSViewMsgGroupId());
            ((PSAppViewDTO)dto).setPSViewMsgGroupName(((PSViewMsgGroupDTO)linkDTO).getPSViewMsgGroupName());
        } else {
            ((PSAppViewDTO)dto).setPSViewMsgGroupName(null);
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getSubCapPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(((PSAppViewDTO)dto).getSubCapPSLanResId());
            ((PSAppViewDTO)dto).setSubCapPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            ((PSAppViewDTO)dto).setSubCapPSLanResName(null);
        }
        if (StringUtils.hasLength((String)((PSAppViewDTO)dto).getTitlePSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(((PSAppViewDTO)dto).getTitlePSLanResId());
            ((PSAppViewDTO)dto).setTitlePSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            ((PSAppViewDTO)dto).setTitlePSLanResName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }
}
