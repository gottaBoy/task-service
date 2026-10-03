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
import net.ibizsys.modelapi.domain.PSDEViewBase;
import net.ibizsys.modelapi.domain.PSDEViewCtrl;
import net.ibizsys.modelapi.dto.PSACHandlerDTO;
import net.ibizsys.modelapi.dto.PSCtrlLogicGroupDTO;
import net.ibizsys.modelapi.dto.PSCtrlMsgDTO;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEChartDTO;
import net.ibizsys.modelapi.dto.PSDEDataExpDTO;
import net.ibizsys.modelapi.dto.PSDEDataImpDTO;
import net.ibizsys.modelapi.dto.PSDEDataRelationDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEDataViewDTO;
import net.ibizsys.modelapi.dto.PSDEFormDTO;
import net.ibizsys.modelapi.dto.PSDEGridDTO;
import net.ibizsys.modelapi.dto.PSDEListDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDEOPPrivDTO;
import net.ibizsys.modelapi.dto.PSDEReportDTO;
import net.ibizsys.modelapi.dto.PSDEToolbarDTO;
import net.ibizsys.modelapi.dto.PSDETreeViewDTO;
import net.ibizsys.modelapi.dto.PSDEUAGroupDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDEViewCtrlDTO;
import net.ibizsys.modelapi.dto.PSDEWizardDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysCalendarDTO;
import net.ibizsys.modelapi.dto.PSSysCounterDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysDashboardDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysMapViewDTO;
import net.ibizsys.modelapi.dto.PSSysMsgTemplDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysSearchBarDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelDTO;
import net.ibizsys.modelapi.service.IPSDEViewCtrlService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEViewCtrlServiceImpl
extends PSModelServiceImplBase<PSDEViewCtrl, PSDEViewCtrlDTO>
implements IPSDEViewCtrlService {
    private static final Log log = LogFactory.getLog(PSDEViewCtrlServiceImpl.class);

    @Override
    public List<PSDEViewCtrl> listByPSDEViewBase(PSDEViewBase parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEViewCtrl get(PSDEViewBase parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEViewCtrl> list = this.listByPSDEViewBase(parent);
        if (list != null) {
            for (PSDEViewCtrl item : list) {
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
    public List<PSDEViewCtrlDTO> listDTOByPSDEViewBase(String strParentKey) throws Exception {
        PSDEViewBase psdeviewbase = (PSDEViewBase)PSModelServiceUtil.getInstance().getPSDEViewBaseService().get(strParentKey);
        List<PSDEViewCtrl> list = this.listByPSDEViewBase(psdeviewbase);
        if (list != null) {
            ArrayList<PSDEViewCtrlDTO> dtoList = new ArrayList<PSDEViewCtrlDTO>();
            for (PSDEViewCtrl item : list) {
                PSDEViewCtrlDTO dto = (PSDEViewCtrlDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEViewCtrl> onListAll() throws Exception {
        ArrayList<PSDEViewCtrl> list = new ArrayList<PSDEViewCtrl>();
        List<PSDEViewBase> psdeviewbases = PSModelServiceUtil.getInstance().getPSDEViewBaseService().listAll();
        if (psdeviewbases != null) {
            for (PSDEViewBase parent : psdeviewbases) {
                List<PSDEViewCtrl> items = this.listByPSDEViewBase(parent);
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
    protected PSDEViewCtrl onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEViewCtrl item;
        PSDEViewBase psdeviewbase = (PSDEViewBase)PSModelServiceUtil.getInstance().getPSDEViewBaseService().get(strParentKey, true);
        if (psdeviewbase != null && (item = this.get(psdeviewbase, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEViewCtrl)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEViewCtrlDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEViewBaseId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEViewBaseService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEViewCtrl et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEViewCtrlName())) {
            return et.getPSDEViewCtrlName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEViewCtrlDTO dto, PSDEViewCtrl t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEViewCtrlId(t.getId().replace("/", "."));
        }
        if (t.getADPSDELogicId() != null || !bIgnoreNull) {
            dto.setADPSDELogicId(t.getADPSDELogicId());
        }
        if (t.getADPSDELogicName() != null || !bIgnoreNull) {
            dto.setADPSDELogicName(t.getADPSDELogicName());
        }
        if (t.getBottomPos() != null || !bIgnoreNull) {
            dto.setBottomPos(t.getBottomPos());
        }
        if (t.getBtnActionType() != null || !bIgnoreNull) {
            dto.setBtnActionType(t.getBtnActionType());
        }
        if (t.getBusyIndicator() != null || !bIgnoreNull) {
            dto.setBusyIndicator(t.getBusyIndicator());
        }
        if (t.getCapPSLanResId() != null || !bIgnoreNull) {
            dto.setCapPSLanResId(t.getCapPSLanResId());
        }
        if (t.getCapPSLanResName() != null || !bIgnoreNull) {
            dto.setCapPSLanResName(t.getCapPSLanResName());
        }
        if (t.getCaption() != null || !bIgnoreNull) {
            dto.setCaption(t.getCaption());
        }
        if (t.getConfigInfo() != null || !bIgnoreNull) {
            dto.setConfigInfo(t.getConfigInfo());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCtrlParam() != null || !bIgnoreNull) {
            dto.setCtrlParam(t.getCtrlParam());
        }
        if (t.getCtrlParam10() != null || !bIgnoreNull) {
            dto.setCtrlParam10(t.getCtrlParam10());
        }
        if (t.getCtrlParam11() != null || !bIgnoreNull) {
            dto.setCtrlParam11(t.getCtrlParam11());
        }
        if (t.getCtrlParam12() != null || !bIgnoreNull) {
            dto.setCtrlParam12(t.getCtrlParam12());
        }
        if (t.getCtrlParam2() != null || !bIgnoreNull) {
            dto.setCtrlParam2(t.getCtrlParam2());
        }
        if (t.getCtrlParam3() != null || !bIgnoreNull) {
            dto.setCtrlParam3(t.getCtrlParam3());
        }
        if (t.getCtrlParam4() != null || !bIgnoreNull) {
            dto.setCtrlParam4(t.getCtrlParam4());
        }
        if (t.getCtrlParam5() != null || !bIgnoreNull) {
            dto.setCtrlParam5(t.getCtrlParam5());
        }
        if (t.getCtrlParam6() != null || !bIgnoreNull) {
            dto.setCtrlParam6(t.getCtrlParam6());
        }
        if (t.getCtrlParam7() != null || !bIgnoreNull) {
            dto.setCtrlParam7(t.getCtrlParam7());
        }
        if (t.getCtrlParam8() != null || !bIgnoreNull) {
            dto.setCtrlParam8(t.getCtrlParam8());
        }
        if (t.getCtrlParam9() != null || !bIgnoreNull) {
            dto.setCtrlParam9(t.getCtrlParam9());
        }
        if (t.getCtrlParams() != null || !bIgnoreNull) {
            dto.setCtrlParams(t.getCtrlParams());
        }
        if (t.getCustomCond() != null || !bIgnoreNull) {
            dto.setCustomCond(t.getCustomCond());
        }
        if (t.getDefaultFlag() != null || !bIgnoreNull) {
            dto.setDefaultFlag(t.getDefaultFlag());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getEnableDynaSys() != null || !bIgnoreNull) {
            dto.setEnableDynaSys(t.getEnableDynaSys());
        }
        if (t.getEnableItemPriv() != null || !bIgnoreNull) {
            dto.setEnableItemPriv(t.getEnableItemPriv());
        }
        if (t.getEnableViewActions() != null || !bIgnoreNull) {
            dto.setEnableViewActions(t.getEnableViewActions());
        }
        if (t.getHeight() != null || !bIgnoreNull) {
            dto.setHeight(t.getHeight());
        }
        if (t.getLeftPos() != null || !bIgnoreNull) {
            dto.setLeftPos(t.getLeftPos());
        }
        if (t.getLocalMode() != null || !bIgnoreNull) {
            dto.setLocalMode(t.getLocalMode());
        }
        if (t.getMargin() != null || !bIgnoreNull) {
            dto.setMargin(t.getMargin());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMultiSelect() != null || !bIgnoreNull) {
            dto.setMultiSelect(t.getMultiSelect());
        }
        if (t.getNO2PSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setNO2PSDEUAGroupId(t.getNO2PSDEUAGroupId());
        }
        if (t.getNO2PSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setNO2PSDEUAGroupName(t.getNO2PSDEUAGroupName());
        }
        if (t.getNO3PSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setNO3PSDEUAGroupId(t.getNO3PSDEUAGroupId());
        }
        if (t.getNO3PSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setNO3PSDEUAGroupName(t.getNO3PSDEUAGroupName());
        }
        if (t.getNO4PSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setNO4PSDEUAGroupId(t.getNO4PSDEUAGroupId());
        }
        if (t.getNO4PSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setNO4PSDEUAGroupName(t.getNO4PSDEUAGroupName());
        }
        if (t.getNO5PSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setNO5PSDEUAGroupId(t.getNO5PSDEUAGroupId());
        }
        if (t.getNO5PSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setNO5PSDEUAGroupName(t.getNO5PSDEUAGroupName());
        }
        if (t.getNO6PSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setNO6PSDEUAGroupId(t.getNO6PSDEUAGroupId());
        }
        if (t.getNO6PSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setNO6PSDEUAGroupName(t.getNO6PSDEUAGroupName());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPadding() != null || !bIgnoreNull) {
            dto.setPadding(t.getPadding());
        }
        if (t.getPredefinedType() != null || !bIgnoreNull) {
            dto.setPredefinedType(t.getPredefinedType());
        }
        if (t.getPredefinedTypeText() != null || !bIgnoreNull) {
            dto.setPredefinedTypeText(t.getPredefinedTypeText());
        }
        if (t.getPSACHandlerId() != null || !bIgnoreNull) {
            dto.setPSACHandlerId(t.getPSACHandlerId());
        }
        if (t.getPSACHandlerName() != null || !bIgnoreNull) {
            dto.setPSACHandlerName(t.getPSACHandlerName());
        }
        if (t.getPSCtrlLogicGroupId() != null || !bIgnoreNull) {
            dto.setPSCtrlLogicGroupId(t.getPSCtrlLogicGroupId());
        }
        if (t.getPSCtrlLogicGroupName() != null || !bIgnoreNull) {
            dto.setPSCtrlLogicGroupName(t.getPSCtrlLogicGroupName());
        }
        if (t.getPSCtrlMsgId() != null || !bIgnoreNull) {
            dto.setPSCtrlMsgId(t.getPSCtrlMsgId());
        }
        if (t.getPSCtrlMsgName() != null || !bIgnoreNull) {
            dto.setPSCtrlMsgName(t.getPSCtrlMsgName());
        }
        if (t.getPSDEActionId() != null || !bIgnoreNull) {
            dto.setPSDEActionId(t.getPSDEActionId());
        }
        if (t.getPSDEActionName() != null || !bIgnoreNull) {
            dto.setPSDEActionName(t.getPSDEActionName());
        }
        if (t.getPSDEChartId() != null || !bIgnoreNull) {
            dto.setPSDEChartId(t.getPSDEChartId());
        }
        if (t.getPSDEChartName() != null || !bIgnoreNull) {
            dto.setPSDEChartName(t.getPSDEChartName());
        }
        if (t.getPSDEDataExpId() != null || !bIgnoreNull) {
            dto.setPSDEDataExpId(t.getPSDEDataExpId());
        }
        if (t.getPSDEDataExpName() != null || !bIgnoreNull) {
            dto.setPSDEDataExpName(t.getPSDEDataExpName());
        }
        if (t.getPSDEDataImpId() != null || !bIgnoreNull) {
            dto.setPSDEDataImpId(t.getPSDEDataImpId());
        }
        if (t.getPSDEDataImpName() != null || !bIgnoreNull) {
            dto.setPSDEDataImpName(t.getPSDEDataImpName());
        }
        if (t.getPSDEDataSetId() != null || !bIgnoreNull) {
            dto.setPSDEDataSetId(t.getPSDEDataSetId());
        }
        if (t.getPSDEDataSetName() != null || !bIgnoreNull) {
            dto.setPSDEDataSetName(t.getPSDEDataSetName());
        }
        if (t.getPSDEDataViewId() != null || !bIgnoreNull) {
            dto.setPSDEDataViewId(t.getPSDEDataViewId());
        }
        if (t.getPSDEDataViewName() != null || !bIgnoreNull) {
            dto.setPSDEDataViewName(t.getPSDEDataViewName());
        }
        if (t.getPSDEDRId() != null || !bIgnoreNull) {
            dto.setPSDEDRId(t.getPSDEDRId());
        }
        if (t.getPSDEDRName() != null || !bIgnoreNull) {
            dto.setPSDEDRName(t.getPSDEDRName());
        }
        if (t.getPSDEFormId() != null || !bIgnoreNull) {
            dto.setPSDEFormId(t.getPSDEFormId());
        }
        if (t.getPSDEFormName() != null || !bIgnoreNull) {
            dto.setPSDEFormName(t.getPSDEFormName());
        }
        if (t.getPSDEGridId() != null || !bIgnoreNull) {
            dto.setPSDEGridId(t.getPSDEGridId());
        }
        if (t.getPSDEGridName() != null || !bIgnoreNull) {
            dto.setPSDEGridName(t.getPSDEGridName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEListId() != null || !bIgnoreNull) {
            dto.setPSDEListId(t.getPSDEListId());
        }
        if (t.getPSDEListName() != null || !bIgnoreNull) {
            dto.setPSDEListName(t.getPSDEListName());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setPSDEOPPrivId(t.getPSDEOPPrivId());
        }
        if (t.getPSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setPSDEOPPrivName(t.getPSDEOPPrivName());
        }
        if (t.getPSDEReportId() != null || !bIgnoreNull) {
            dto.setPSDEReportId(t.getPSDEReportId());
        }
        if (t.getPSDEReportName() != null || !bIgnoreNull) {
            dto.setPSDEReportName(t.getPSDEReportName());
        }
        if (t.getPSDEToolbarId() != null || !bIgnoreNull) {
            dto.setPSDEToolbarId(t.getPSDEToolbarId());
        }
        if (t.getPSDEToolbarName() != null || !bIgnoreNull) {
            dto.setPSDEToolbarName(t.getPSDEToolbarName());
        }
        if (t.getPSDETreeViewId() != null || !bIgnoreNull) {
            dto.setPSDETreeViewId(t.getPSDETreeViewId());
        }
        if (t.getPSDETreeViewName() != null || !bIgnoreNull) {
            dto.setPSDETreeViewName(t.getPSDETreeViewName());
        }
        if (t.getPSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupId(t.getPSDEUAGroupId());
        }
        if (t.getPSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupName(t.getPSDEUAGroupName());
        }
        if (t.getPSDEViewBaseId() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseId(t.getPSDEViewBaseId());
        }
        if (t.getPSDEViewBaseName() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseName(t.getPSDEViewBaseName());
        }
        if (t.getPSDEViewCtrlName() != null || !bIgnoreNull) {
            dto.setPSDEViewCtrlName(t.getPSDEViewCtrlName());
        }
        if (t.getPSDEViewCtrlType() != null || !bIgnoreNull) {
            dto.setPSDEViewCtrlType(t.getPSDEViewCtrlType());
        }
        if (t.getPSDEViewId() != null || !bIgnoreNull) {
            dto.setPSDEViewId(t.getPSDEViewId());
        }
        if (t.getPSDEViewName() != null || !bIgnoreNull) {
            dto.setPSDEViewName(t.getPSDEViewName());
        }
        if (t.getPSDEWizardId() != null || !bIgnoreNull) {
            dto.setPSDEWizardId(t.getPSDEWizardId());
        }
        if (t.getPSDEWizardName() != null || !bIgnoreNull) {
            dto.setPSDEWizardName(t.getPSDEWizardName());
        }
        if (t.getPSPFId() != null || !bIgnoreNull) {
            dto.setPSPFId(t.getPSPFId());
        }
        if (t.getPSPFName() != null || !bIgnoreNull) {
            dto.setPSPFName(t.getPSPFName());
        }
        if (t.getPSSysCalendarId() != null || !bIgnoreNull) {
            dto.setPSSysCalendarId(t.getPSSysCalendarId());
        }
        if (t.getPSSysCalendarName() != null || !bIgnoreNull) {
            dto.setPSSysCalendarName(t.getPSSysCalendarName());
        }
        if (t.getPSSysCounterId() != null || !bIgnoreNull) {
            dto.setPSSysCounterId(t.getPSSysCounterId());
        }
        if (t.getPSSysCounterName() != null || !bIgnoreNull) {
            dto.setPSSysCounterName(t.getPSSysCounterName());
        }
        if (t.getPSSysCssId() != null || !bIgnoreNull) {
            dto.setPSSysCssId(t.getPSSysCssId());
        }
        if (t.getPSSysCssName() != null || !bIgnoreNull) {
            dto.setPSSysCssName(t.getPSSysCssName());
        }
        if (t.getPSSysDashboardId() != null || !bIgnoreNull) {
            dto.setPSSysDashboardId(t.getPSSysDashboardId());
        }
        if (t.getPSSysDashboardName() != null || !bIgnoreNull) {
            dto.setPSSysDashboardName(t.getPSSysDashboardName());
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
        if (t.getPSSysMapViewId() != null || !bIgnoreNull) {
            dto.setPSSysMapViewId(t.getPSSysMapViewId());
        }
        if (t.getPSSysMapViewName() != null || !bIgnoreNull) {
            dto.setPSSysMapViewName(t.getPSSysMapViewName());
        }
        if (t.getPSSysMsgTemplId() != null || !bIgnoreNull) {
            dto.setPSSysMsgTemplId(t.getPSSysMsgTemplId());
        }
        if (t.getPSSysMsgTemplName() != null || !bIgnoreNull) {
            dto.setPSSysMsgTemplName(t.getPSSysMsgTemplName());
        }
        if (t.getPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginId(t.getPSSysPFPluginId());
        }
        if (t.getPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginName(t.getPSSysPFPluginName());
        }
        if (t.getPSSysSearchBarId() != null || !bIgnoreNull) {
            dto.setPSSysSearchBarId(t.getPSSysSearchBarId());
        }
        if (t.getPSSysSearchBarName() != null || !bIgnoreNull) {
            dto.setPSSysSearchBarName(t.getPSSysSearchBarName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSysViewPanelId() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelId(t.getPSSysViewPanelId());
        }
        if (t.getPSSysViewPanelName() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelName(t.getPSSysViewPanelName());
        }
        if (t.getReadOnlyMode() != null || !bIgnoreNull) {
            dto.setReadOnlyMode(t.getReadOnlyMode());
        }
        if (t.getRefCtrl2Name() != null || !bIgnoreNull) {
            dto.setRefCtrl2Name(t.getRefCtrl2Name());
        }
        if (t.getRefCtrl2Usage() != null || !bIgnoreNull) {
            dto.setRefCtrl2Usage(t.getRefCtrl2Usage());
        }
        if (t.getRefCtrl2UsageText() != null || !bIgnoreNull) {
            dto.setRefCtrl2UsageText(t.getRefCtrl2UsageText());
        }
        if (t.getRefCtrlName() != null || !bIgnoreNull) {
            dto.setRefCtrlName(t.getRefCtrlName());
        }
        if (t.getRefCtrlUsage() != null || !bIgnoreNull) {
            dto.setRefCtrlUsage(t.getRefCtrlUsage());
        }
        if (t.getRefCtrlUsageText() != null || !bIgnoreNull) {
            dto.setRefCtrlUsageText(t.getRefCtrlUsageText());
        }
        if (t.getRightPos() != null || !bIgnoreNull) {
            dto.setRightPos(t.getRightPos());
        }
        if (t.getSubPSACHandlerId() != null || !bIgnoreNull) {
            dto.setSubPSACHandlerId(t.getSubPSACHandlerId());
        }
        if (t.getSubPSACHandlerName() != null || !bIgnoreNull) {
            dto.setSubPSACHandlerName(t.getSubPSACHandlerName());
        }
        if (t.getTopPos() != null || !bIgnoreNull) {
            dto.setTopPos(t.getTopPos());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUserTag() != null || !bIgnoreNull) {
            dto.setUserTag(t.getUserTag());
        }
        if (t.getUserTag2() != null || !bIgnoreNull) {
            dto.setUserTag2(t.getUserTag2());
        }
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (t.getWidth() != null || !bIgnoreNull) {
            dto.setWidth(t.getWidth());
        }
        if (StringUtils.hasLength((String)dto.getADPSDELogicId())) {
            dto.setADPSDELogicId(this.getRealPSModelId(t, dto.getADPSDELogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            dto.setCapPSLanResId(this.getRealPSModelId(t, dto.getCapPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNO2PSDEUAGroupId())) {
            dto.setNO2PSDEUAGroupId(this.getRealPSModelId(t, dto.getNO2PSDEUAGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNO3PSDEUAGroupId())) {
            dto.setNO3PSDEUAGroupId(this.getRealPSModelId(t, dto.getNO3PSDEUAGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNO4PSDEUAGroupId())) {
            dto.setNO4PSDEUAGroupId(this.getRealPSModelId(t, dto.getNO4PSDEUAGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNO5PSDEUAGroupId())) {
            dto.setNO5PSDEUAGroupId(this.getRealPSModelId(t, dto.getNO5PSDEUAGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNO6PSDEUAGroupId())) {
            dto.setNO6PSDEUAGroupId(this.getRealPSModelId(t, dto.getNO6PSDEUAGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSACHandlerId())) {
            dto.setPSACHandlerId(this.getRealPSModelId(t, dto.getPSACHandlerId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlLogicGroupId())) {
            dto.setPSCtrlLogicGroupId(this.getRealPSModelId(t, dto.getPSCtrlLogicGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlMsgId())) {
            dto.setPSCtrlMsgId(this.getRealPSModelId(t, dto.getPSCtrlMsgId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            dto.setPSDEActionId(this.getRealPSModelId(t, dto.getPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEChartId())) {
            dto.setPSDEChartId(this.getRealPSModelId(t, dto.getPSDEChartId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataExpId())) {
            dto.setPSDEDataExpId(this.getRealPSModelId(t, dto.getPSDEDataExpId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataImpId())) {
            dto.setPSDEDataImpId(this.getRealPSModelId(t, dto.getPSDEDataImpId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataSetId())) {
            dto.setPSDEDataSetId(this.getRealPSModelId(t, dto.getPSDEDataSetId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataViewId())) {
            dto.setPSDEDataViewId(this.getRealPSModelId(t, dto.getPSDEDataViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDRId())) {
            dto.setPSDEDRId(this.getRealPSModelId(t, dto.getPSDEDRId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            dto.setPSDEFormId(this.getRealPSModelId(t, dto.getPSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEGridId())) {
            dto.setPSDEGridId(this.getRealPSModelId(t, dto.getPSDEGridId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEListId())) {
            dto.setPSDEListId(this.getRealPSModelId(t, dto.getPSDEListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEOPPrivId())) {
            dto.setPSDEOPPrivId(this.getRealPSModelId(t, dto.getPSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEReportId())) {
            dto.setPSDEReportId(this.getRealPSModelId(t, dto.getPSDEReportId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEToolbarId())) {
            dto.setPSDEToolbarId(this.getRealPSModelId(t, dto.getPSDEToolbarId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDETreeViewId())) {
            dto.setPSDETreeViewId(this.getRealPSModelId(t, dto.getPSDETreeViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            dto.setPSDEUAGroupId(this.getRealPSModelId(t, dto.getPSDEUAGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            dto.setPSDEViewBaseId(this.getRealPSModelId(t, dto.getPSDEViewBaseId()).replace("/", "."));
        }
        if ("PSDEVIEWBASE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEViewBaseId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewId())) {
            dto.setPSDEViewId(this.getRealPSModelId(t, dto.getPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEWizardId())) {
            dto.setPSDEWizardId(this.getRealPSModelId(t, dto.getPSDEWizardId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCalendarId())) {
            dto.setPSSysCalendarId(this.getRealPSModelId(t, dto.getPSSysCalendarId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCounterId())) {
            dto.setPSSysCounterId(this.getRealPSModelId(t, dto.getPSSysCounterId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            dto.setPSSysCssId(this.getRealPSModelId(t, dto.getPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDashboardId())) {
            dto.setPSSysDashboardId(this.getRealPSModelId(t, dto.getPSSysDashboardId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            dto.setPSSysImageId(this.getRealPSModelId(t, dto.getPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysMapViewId())) {
            dto.setPSSysMapViewId(this.getRealPSModelId(t, dto.getPSSysMapViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysMsgTemplId())) {
            dto.setPSSysMsgTemplId(this.getRealPSModelId(t, dto.getPSSysMsgTemplId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchBarId())) {
            dto.setPSSysSearchBarId(this.getRealPSModelId(t, dto.getPSSysSearchBarId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            dto.setPSSysViewPanelId(this.getRealPSModelId(t, dto.getPSSysViewPanelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getSubPSACHandlerId())) {
            dto.setSubPSACHandlerId(this.getRealPSModelId(t, dto.getSubPSACHandlerId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getADPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getADPSDELogicId());
            dto.setADPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setADPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getCapPSLanResId());
            dto.setCapPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setCapPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getNO2PSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getNO2PSDEUAGroupId());
            dto.setNO2PSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setNO2PSDEUAGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getNO3PSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getNO3PSDEUAGroupId());
            dto.setNO3PSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setNO3PSDEUAGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getNO4PSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getNO4PSDEUAGroupId());
            dto.setNO4PSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setNO4PSDEUAGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getNO5PSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getNO5PSDEUAGroupId());
            dto.setNO5PSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setNO5PSDEUAGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getNO6PSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getNO6PSDEUAGroupId());
            dto.setNO6PSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setNO6PSDEUAGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSACHandlerId())) {
            linkDTO = (PSACHandlerDTO)PSModelServiceUtil.getInstance().getPSACHandlerService().getDTO(dto.getPSACHandlerId());
            dto.setPSACHandlerName(((PSACHandlerDTO)linkDTO).getPSACHandlerName());
        } else {
            dto.setPSACHandlerName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlLogicGroupId())) {
            linkDTO = (PSCtrlLogicGroupDTO)PSModelServiceUtil.getInstance().getPSCtrlLogicGroupService().getDTO(dto.getPSCtrlLogicGroupId());
            dto.setPSCtrlLogicGroupName(((PSCtrlLogicGroupDTO)linkDTO).getPSCtrlLogicGroupName());
        } else {
            dto.setPSCtrlLogicGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlMsgId())) {
            linkDTO = (PSCtrlMsgDTO)PSModelServiceUtil.getInstance().getPSCtrlMsgService().getDTO(dto.getPSCtrlMsgId());
            dto.setPSCtrlMsgName(((PSCtrlMsgDTO)linkDTO).getPSCtrlMsgName());
        } else {
            dto.setPSCtrlMsgName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getPSDEActionId());
            dto.setPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEChartId())) {
            linkDTO = (PSDEChartDTO)PSModelServiceUtil.getInstance().getPSDEChartService().getDTO(dto.getPSDEChartId());
            dto.setPSDEChartName(((PSDEChartDTO)linkDTO).getPSDEChartName());
        } else {
            dto.setPSDEChartName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataExpId())) {
            linkDTO = (PSDEDataExpDTO)PSModelServiceUtil.getInstance().getPSDEDataExpService().getDTO(dto.getPSDEDataExpId());
            dto.setPSDEDataExpName(((PSDEDataExpDTO)linkDTO).getPSDEDataExpName());
        } else {
            dto.setPSDEDataExpName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataImpId())) {
            linkDTO = (PSDEDataImpDTO)PSModelServiceUtil.getInstance().getPSDEDataImpService().getDTO(dto.getPSDEDataImpId());
            dto.setPSDEDataImpName(((PSDEDataImpDTO)linkDTO).getPSDEDataImpName());
        } else {
            dto.setPSDEDataImpName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataSetId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getPSDEDataSetId());
            dto.setPSDEDataSetName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setPSDEDataSetName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataViewId())) {
            linkDTO = (PSDEDataViewDTO)PSModelServiceUtil.getInstance().getPSDEDataViewService().getDTO(dto.getPSDEDataViewId());
            dto.setPSDEDataViewName(((PSDEDataViewDTO)linkDTO).getPSDEDataViewName());
        } else {
            dto.setPSDEDataViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDRId())) {
            linkDTO = (PSDEDataRelationDTO)PSModelServiceUtil.getInstance().getPSDEDataRelationService().getDTO(dto.getPSDEDRId());
            dto.setPSDEDRName(((PSDEDataRelationDTO)linkDTO).getPSDEDataRelationName());
        } else {
            dto.setPSDEDRName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getPSDEFormId());
            dto.setPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setPSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEGridId())) {
            linkDTO = (PSDEGridDTO)PSModelServiceUtil.getInstance().getPSDEGridService().getDTO(dto.getPSDEGridId());
            dto.setPSDEGridName(((PSDEGridDTO)linkDTO).getPSDEGridName());
        } else {
            dto.setPSDEGridName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEListId())) {
            linkDTO = (PSDEListDTO)PSModelServiceUtil.getInstance().getPSDEListService().getDTO(dto.getPSDEListId());
            dto.setPSDEListName(((PSDEListDTO)linkDTO).getPSDEListName());
        } else {
            dto.setPSDEListName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getPSDEOPPrivId());
            dto.setPSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setPSDEOPPrivName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEReportId())) {
            linkDTO = (PSDEReportDTO)PSModelServiceUtil.getInstance().getPSDEReportService().getDTO(dto.getPSDEReportId());
            dto.setPSDEReportName(((PSDEReportDTO)linkDTO).getPSDEReportName());
        } else {
            dto.setPSDEReportName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEToolbarId())) {
            linkDTO = (PSDEToolbarDTO)PSModelServiceUtil.getInstance().getPSDEToolbarService().getDTO(dto.getPSDEToolbarId());
            dto.setPSDEToolbarName(((PSDEToolbarDTO)linkDTO).getPSDEToolbarName());
        } else {
            dto.setPSDEToolbarName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDETreeViewId())) {
            linkDTO = (PSDETreeViewDTO)PSModelServiceUtil.getInstance().getPSDETreeViewService().getDTO(dto.getPSDETreeViewId());
            dto.setPSDETreeViewName(((PSDETreeViewDTO)linkDTO).getPSDETreeViewName());
        } else {
            dto.setPSDETreeViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getPSDEUAGroupId());
            dto.setPSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setPSDEUAGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getPSDEViewBaseId());
            dto.setPSDEViewBaseName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
            dto.setPSSystemId(((PSDEViewBaseDTO)linkDTO).getPSSystemId());
        } else {
            dto.setPSDEViewBaseName(null);
            dto.setPSSystemId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getPSDEViewId());
            dto.setPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEWizardId())) {
            linkDTO = (PSDEWizardDTO)PSModelServiceUtil.getInstance().getPSDEWizardService().getDTO(dto.getPSDEWizardId());
            dto.setPSDEWizardName(((PSDEWizardDTO)linkDTO).getPSDEWizardName());
        } else {
            dto.setPSDEWizardName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysCalendarId())) {
            linkDTO = (PSSysCalendarDTO)PSModelServiceUtil.getInstance().getPSSysCalendarService().getDTO(dto.getPSSysCalendarId());
            dto.setPSSysCalendarName(((PSSysCalendarDTO)linkDTO).getPSSysCalendarName());
        } else {
            dto.setPSSysCalendarName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysCounterId())) {
            linkDTO = (PSSysCounterDTO)PSModelServiceUtil.getInstance().getPSSysCounterService().getDTO(dto.getPSSysCounterId());
            dto.setPSSysCounterName(((PSSysCounterDTO)linkDTO).getPSSysCounterName());
        } else {
            dto.setPSSysCounterName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getPSSysCssId());
            dto.setPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDashboardId())) {
            linkDTO = (PSSysDashboardDTO)PSModelServiceUtil.getInstance().getPSSysDashboardService().getDTO(dto.getPSSysDashboardId());
            dto.setPSSysDashboardName(((PSSysDashboardDTO)linkDTO).getPSSysDashboardName());
        } else {
            dto.setPSSysDashboardName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysMapViewId())) {
            linkDTO = (PSSysMapViewDTO)PSModelServiceUtil.getInstance().getPSSysMapViewService().getDTO(dto.getPSSysMapViewId());
            dto.setPSSysMapViewName(((PSSysMapViewDTO)linkDTO).getPSSysMapViewName());
        } else {
            dto.setPSSysMapViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysMsgTemplId())) {
            linkDTO = (PSSysMsgTemplDTO)PSModelServiceUtil.getInstance().getPSSysMsgTemplService().getDTO(dto.getPSSysMsgTemplId());
            dto.setPSSysMsgTemplName(((PSSysMsgTemplDTO)linkDTO).getPSSysMsgTemplName());
        } else {
            dto.setPSSysMsgTemplName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getPSSysPFPluginId());
            dto.setPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchBarId())) {
            linkDTO = (PSSysSearchBarDTO)PSModelServiceUtil.getInstance().getPSSysSearchBarService().getDTO(dto.getPSSysSearchBarId());
            dto.setPSSysSearchBarName(((PSSysSearchBarDTO)linkDTO).getPSSysSearchBarName());
        } else {
            dto.setPSSysSearchBarName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            linkDTO = (PSSysViewPanelDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelService().getDTO(dto.getPSSysViewPanelId());
            dto.setPSSysViewPanelName(((PSSysViewPanelDTO)linkDTO).getPSSysViewPanelName());
        } else {
            dto.setPSSysViewPanelName(null);
        }
        if (StringUtils.hasLength((String)dto.getSubPSACHandlerId())) {
            linkDTO = (PSACHandlerDTO)PSModelServiceUtil.getInstance().getPSACHandlerService().getDTO(dto.getSubPSACHandlerId());
            dto.setSubPSACHandlerName(((PSACHandlerDTO)linkDTO).getPSACHandlerName());
        } else {
            dto.setSubPSACHandlerName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEVIEWCTRL";
    }

    @Override
    public PSDEViewCtrl createDomain() {
        return new PSDEViewCtrl();
    }

    @Override
    public PSDEViewCtrlDTO createDTO() {
        return new PSDEViewCtrlDTO();
    }
}

