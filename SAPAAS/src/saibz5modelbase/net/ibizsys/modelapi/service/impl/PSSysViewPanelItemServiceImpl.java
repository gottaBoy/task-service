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
import net.ibizsys.modelapi.domain.PSPanelItemLogic;
import net.ibizsys.modelapi.domain.PSSysViewPanel;
import net.ibizsys.modelapi.domain.PSSysViewPanelItem;
import net.ibizsys.modelapi.dto.PSACHandlerDTO;
import net.ibizsys.modelapi.dto.PSAppMenuDTO;
import net.ibizsys.modelapi.dto.PSAppViewDTO;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSCtrlLogicGroupDTO;
import net.ibizsys.modelapi.dto.PSDEACModeDTO;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEChartDTO;
import net.ibizsys.modelapi.dto.PSDEDRItemDTO;
import net.ibizsys.modelapi.dto.PSDEDataRelationDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEDataViewDTO;
import net.ibizsys.modelapi.dto.PSDEFormDTO;
import net.ibizsys.modelapi.dto.PSDEGridDTO;
import net.ibizsys.modelapi.dto.PSDEListDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDEReportDTO;
import net.ibizsys.modelapi.dto.PSDEToolbarDTO;
import net.ibizsys.modelapi.dto.PSDETreeViewDTO;
import net.ibizsys.modelapi.dto.PSDEUAGroupDTO;
import net.ibizsys.modelapi.dto.PSDEUIActionDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDEWizardDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSPanelItemLogicDTO;
import net.ibizsys.modelapi.dto.PSSysCalendarDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysDashboardDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysEditorStyleDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysMapViewDTO;
import net.ibizsys.modelapi.dto.PSSysPDTViewDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysResourceDTO;
import net.ibizsys.modelapi.dto.PSSysSearchBarDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelItemDTO;
import net.ibizsys.modelapi.service.IPSSysViewPanelItemService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysViewPanelItemServiceImpl
extends PSModelServiceImplBase<PSSysViewPanelItem, PSSysViewPanelItemDTO>
implements IPSSysViewPanelItemService {
    private static final Log log = LogFactory.getLog(PSSysViewPanelItemServiceImpl.class);

    @Override
    public List<PSSysViewPanelItem> listByPSSysViewPanelItem(PSSysViewPanelItem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysViewPanelItem get(PSSysViewPanelItem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysViewPanelItem> list = this.listByPSSysViewPanelItem(parent);
        if (list != null) {
            for (PSSysViewPanelItem item : list) {
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
    public List<PSSysViewPanelItemDTO> listDTOByPSSysViewPanelItem(String strParentKey) throws Exception {
        PSSysViewPanelItem pssysviewpanelitem = (PSSysViewPanelItem)PSModelServiceUtil.getInstance().getPSSysViewPanelItemService().get(strParentKey);
        List<PSSysViewPanelItem> list = this.listByPSSysViewPanelItem(pssysviewpanelitem);
        if (list != null) {
            ArrayList<PSSysViewPanelItemDTO> dtoList = new ArrayList<PSSysViewPanelItemDTO>();
            for (PSSysViewPanelItem item : list) {
                PSSysViewPanelItemDTO dto = (PSSysViewPanelItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysViewPanelItem> listByPSSysViewPanel(PSSysViewPanel parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysViewPanelItem get(PSSysViewPanel parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysViewPanelItem> list = this.listByPSSysViewPanel(parent);
        if (list != null) {
            for (PSSysViewPanelItem item : list) {
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
    public List<PSSysViewPanelItemDTO> listDTOByPSSysViewPanel(String strParentKey) throws Exception {
        PSSysViewPanel pssysviewpanel = (PSSysViewPanel)PSModelServiceUtil.getInstance().getPSSysViewPanelService().get(strParentKey);
        List<PSSysViewPanelItem> list = this.listByPSSysViewPanel(pssysviewpanel);
        if (list != null) {
            ArrayList<PSSysViewPanelItemDTO> dtoList = new ArrayList<PSSysViewPanelItemDTO>();
            for (PSSysViewPanelItem item : list) {
                PSSysViewPanelItemDTO dto = (PSSysViewPanelItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysViewPanelItem> onListAll() throws Exception {
        ArrayList<PSSysViewPanelItem> list = new ArrayList<PSSysViewPanelItem>();
        List pssysviewpanels = PSModelServiceUtil.getInstance().getPSSysViewPanelService().listAll();
        if (pssysviewpanels != null) {
            for (PSSysViewPanel parent : pssysviewpanels) {
                List<PSSysViewPanelItem> items = this.listByPSSysViewPanel(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        ArrayList<PSSysViewPanelItem> alllist = new ArrayList<PSSysViewPanelItem>();
        alllist.addAll(list);
        for (PSSysViewPanelItem item : list) {
            List<PSSysViewPanelItem> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSSysViewPanelItem> listAllChild(PSSysViewPanelItem parent) throws Exception {
        List<PSSysViewPanelItem> list = this.listByPSSysViewPanelItem(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSSysViewPanelItem> alllist = new ArrayList<PSSysViewPanelItem>();
        alllist.addAll(list);
        for (PSSysViewPanelItem item : list) {
            List<PSSysViewPanelItem> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSSysViewPanelItem> listAllByPSSysViewPanel(PSSysViewPanel parent) throws Exception {
        List<PSSysViewPanelItem> list = this.listByPSSysViewPanel(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSSysViewPanelItem> alllist = new ArrayList<PSSysViewPanelItem>();
        alllist.addAll(list);
        for (PSSysViewPanelItem item : list) {
            List<PSSysViewPanelItem> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSSysViewPanelItemDTO> listAllDTOByPSSysViewPanel(String strParentKey) throws Exception {
        PSSysViewPanel pssysviewpanel = (PSSysViewPanel)PSModelServiceUtil.getInstance().getPSSysViewPanelService().get(strParentKey);
        List<PSSysViewPanelItem> list = this.listAllByPSSysViewPanel(pssysviewpanel);
        if (list != null) {
            ArrayList<PSSysViewPanelItemDTO> dtoList = new ArrayList<PSSysViewPanelItemDTO>();
            for (PSSysViewPanelItem item : list) {
                PSSysViewPanelItemDTO dto = (PSSysViewPanelItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected PSSysViewPanelItem onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysViewPanelItem item;
        PSSysViewPanelItem item2;
        PSSysViewPanelItem pssysviewpanelitem = (PSSysViewPanelItem)PSModelServiceUtil.getInstance().getPSSysViewPanelItemService().get(strParentKey, true);
        if (pssysviewpanelitem != null && (item2 = this.get(pssysviewpanelitem, strCurKey, true)) != null) {
            return item2;
        }
        PSSysViewPanel pssysviewpanel = (PSSysViewPanel)PSModelServiceUtil.getInstance().getPSSysViewPanelService().get(strParentKey, true);
        if (pssysviewpanel != null && (item = this.get(pssysviewpanel, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysViewPanelItem)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysViewPanelItemDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPPSSysViewPanelItemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysViewPanelItemService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSSysViewPanelId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysViewPanelService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysViewPanelItem et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysViewPanelItemName())) {
            return et.getPSSysViewPanelItemName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysViewPanelItemDTO dto, PSSysViewPanelItem t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysViewPanelItemId(t.getId().replace("/", "."));
        }
        if (t.getADPSDELogicId() != null || !bIgnoreNull) {
            dto.setADPSDELogicId(t.getADPSDELogicId());
        }
        if (t.getADPSDELogicName() != null || !bIgnoreNull) {
            dto.setADPSDELogicName(t.getADPSDELogicName());
        }
        if (t.getAL_Pos() != null || !bIgnoreNull) {
            dto.setAL_Pos(t.getAL_Pos());
        }
        if (t.getBL_Pos() != null || !bIgnoreNull) {
            dto.setBL_Pos(t.getBL_Pos());
        }
        if (t.getBorderStyle() != null || !bIgnoreNull) {
            dto.setBorderStyle(t.getBorderStyle());
        }
        if (t.getBottomPos() != null || !bIgnoreNull) {
            dto.setBottomPos(t.getBottomPos());
        }
        if (t.getBtnActionType() != null || !bIgnoreNull) {
            dto.setBtnActionType(t.getBtnActionType());
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
        if (t.getCaptionPos() != null || !bIgnoreNull) {
            dto.setCaptionPos(t.getCaptionPos());
        }
        if (t.getChild_Col_LG() != null || !bIgnoreNull) {
            dto.setChild_Col_LG(t.getChild_Col_LG());
        }
        if (t.getChild_Col_MD() != null || !bIgnoreNull) {
            dto.setChild_Col_MD(t.getChild_Col_MD());
        }
        if (t.getChild_Col_SM() != null || !bIgnoreNull) {
            dto.setChild_Col_SM(t.getChild_Col_SM());
        }
        if (t.getChild_Col_XS() != null || !bIgnoreNull) {
            dto.setChild_Col_XS(t.getChild_Col_XS());
        }
        if (t.getColId() != null || !bIgnoreNull) {
            dto.setColId(t.getColId());
        }
        if (t.getCollapsibleFlag() != null || !bIgnoreNull) {
            dto.setCollapsibleFlag(t.getCollapsibleFlag());
        }
        if (t.getColModel() != null || !bIgnoreNull) {
            dto.setColModel(t.getColModel());
        }
        if (t.getColSpan() != null || !bIgnoreNull) {
            dto.setColSpan(t.getColSpan());
        }
        if (t.getCol_LG() != null || !bIgnoreNull) {
            dto.setCol_LG(t.getCol_LG());
        }
        if (t.getCol_LG_OS() != null || !bIgnoreNull) {
            dto.setCol_LG_OS(t.getCol_LG_OS());
        }
        if (t.getCol_MD() != null || !bIgnoreNull) {
            dto.setCol_MD(t.getCol_MD());
        }
        if (t.getCol_MD_OS() != null || !bIgnoreNull) {
            dto.setCol_MD_OS(t.getCol_MD_OS());
        }
        if (t.getCol_SM() != null || !bIgnoreNull) {
            dto.setCol_SM(t.getCol_SM());
        }
        if (t.getCol_SM_OS() != null || !bIgnoreNull) {
            dto.setCol_SM_OS(t.getCol_SM_OS());
        }
        if (t.getCol_Width() != null || !bIgnoreNull) {
            dto.setCol_Width(t.getCol_Width());
        }
        if (t.getCol_XS() != null || !bIgnoreNull) {
            dto.setCol_XS(t.getCol_XS());
        }
        if (t.getCol_XS_OS() != null || !bIgnoreNull) {
            dto.setCol_XS_OS(t.getCol_XS_OS());
        }
        if (t.getContentType() != null || !bIgnoreNull) {
            dto.setContentType(t.getContentType());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCtrlDynaClass() != null || !bIgnoreNull) {
            dto.setCtrlDynaClass(t.getCtrlDynaClass());
        }
        if (t.getCtrlHeight() != null || !bIgnoreNull) {
            dto.setCtrlHeight(t.getCtrlHeight());
        }
        if (t.getCtrlPSSysCssId() != null || !bIgnoreNull) {
            dto.setCtrlPSSysCssId(t.getCtrlPSSysCssId());
        }
        if (t.getCtrlPSSysCssName() != null || !bIgnoreNull) {
            dto.setCtrlPSSysCssName(t.getCtrlPSSysCssName());
        }
        if (t.getCtrlRawCssStyle() != null || !bIgnoreNull) {
            dto.setCtrlRawCssStyle(t.getCtrlRawCssStyle());
        }
        if (t.getCtrlType() != null || !bIgnoreNull) {
            dto.setCtrlType(t.getCtrlType());
        }
        if (t.getCtrlWidth() != null || !bIgnoreNull) {
            dto.setCtrlWidth(t.getCtrlWidth());
        }
        if (t.getCustomCode() != null || !bIgnoreNull) {
            dto.setCustomCode(t.getCustomCode());
        }
        if (t.getCustomMode() != null || !bIgnoreNull) {
            dto.setCustomMode(t.getCustomMode());
        }
        if (t.getDataPanelMode() != null || !bIgnoreNull) {
            dto.setDataPanelMode(t.getDataPanelMode());
        }
        if (t.getDataSource() != null || !bIgnoreNull) {
            dto.setDataSource(t.getDataSource());
        }
        if (t.getDataSourceText() != null || !bIgnoreNull) {
            dto.setDataSourceText(t.getDataSourceText());
        }
        if (t.getDetailStyle() != null || !bIgnoreNull) {
            dto.setDetailStyle(t.getDetailStyle());
        }
        if (t.getDetailStyleText() != null || !bIgnoreNull) {
            dto.setDetailStyleText(t.getDetailStyleText());
        }
        if (t.getDynaClass() != null || !bIgnoreNull) {
            dto.setDynaClass(t.getDynaClass());
        }
        if (t.getEditorType() != null || !bIgnoreNull) {
            dto.setEditorType(t.getEditorType());
        }
        if (t.getEditorTypeName() != null || !bIgnoreNull) {
            dto.setEditorTypeName(t.getEditorTypeName());
        }
        if (t.getEmptyCaption() != null || !bIgnoreNull) {
            dto.setEmptyCaption(t.getEmptyCaption());
        }
        if (t.getEnableAnchor() != null || !bIgnoreNull) {
            dto.setEnableAnchor(t.getEnableAnchor());
        }
        if (t.getFieldName() != null || !bIgnoreNull) {
            dto.setFieldName(t.getFieldName());
        }
        if (t.getFieldStates() != null || !bIgnoreNull) {
            dto.setFieldStates(t.getFieldStates());
        }
        if (t.getFlexAlign() != null || !bIgnoreNull) {
            dto.setFlexAlign(t.getFlexAlign());
        }
        if (t.getFlexDir() != null || !bIgnoreNull) {
            dto.setFlexDir(t.getFlexDir());
        }
        if (t.getFlexGrow() != null || !bIgnoreNull) {
            dto.setFlexGrow(t.getFlexGrow());
        }
        if (t.getFlexVAlign() != null || !bIgnoreNull) {
            dto.setFlexVAlign(t.getFlexVAlign());
        }
        if (t.getGetDataTimer() != null || !bIgnoreNull) {
            dto.setGetDataTimer(t.getGetDataTimer());
        }
        if (t.getGridRowId() != null || !bIgnoreNull) {
            dto.setGridRowId(t.getGridRowId());
        }
        if (t.getHAlign() != null || !bIgnoreNull) {
            dto.setHAlign(t.getHAlign());
        }
        if (t.getHAlignSelf() != null || !bIgnoreNull) {
            dto.setHAlignSelf(t.getHAlignSelf());
        }
        if (t.getHeight() != null || !bIgnoreNull) {
            dto.setHeight(t.getHeight());
        }
        if (t.getHeightMode() != null || !bIgnoreNull) {
            dto.setHeightMode(t.getHeightMode());
        }
        if (t.getHtmlContent() != null || !bIgnoreNull) {
            dto.setHtmlContent(t.getHtmlContent());
        }
        if (t.getHtmlPageUrl() != null || !bIgnoreNull) {
            dto.setHtmlPageUrl(t.getHtmlPageUrl());
        }
        if (t.getIconAlign() != null || !bIgnoreNull) {
            dto.setIconAlign(t.getIconAlign());
        }
        if (t.getIgnoreInput() != null || !bIgnoreNull) {
            dto.setIgnoreInput(t.getIgnoreInput());
        }
        if (t.getItemParam() != null || !bIgnoreNull) {
            dto.setItemParam(t.getItemParam());
        }
        if (t.getItemParam10() != null || !bIgnoreNull) {
            dto.setItemParam10(t.getItemParam10());
        }
        if (t.getItemParam11() != null || !bIgnoreNull) {
            dto.setItemParam11(t.getItemParam11());
        }
        if (t.getItemParam12() != null || !bIgnoreNull) {
            dto.setItemParam12(t.getItemParam12());
        }
        if (t.getItemParam2() != null || !bIgnoreNull) {
            dto.setItemParam2(t.getItemParam2());
        }
        if (t.getItemParam3() != null || !bIgnoreNull) {
            dto.setItemParam3(t.getItemParam3());
        }
        if (t.getItemParam4() != null || !bIgnoreNull) {
            dto.setItemParam4(t.getItemParam4());
        }
        if (t.getItemParam5() != null || !bIgnoreNull) {
            dto.setItemParam5(t.getItemParam5());
        }
        if (t.getItemParam6() != null || !bIgnoreNull) {
            dto.setItemParam6(t.getItemParam6());
        }
        if (t.getItemParam7() != null || !bIgnoreNull) {
            dto.setItemParam7(t.getItemParam7());
        }
        if (t.getItemParam8() != null || !bIgnoreNull) {
            dto.setItemParam8(t.getItemParam8());
        }
        if (t.getItemParam9() != null || !bIgnoreNull) {
            dto.setItemParam9(t.getItemParam9());
        }
        if (t.getItemParams() != null || !bIgnoreNull) {
            dto.setItemParams(t.getItemParams());
        }
        if (t.getItemType() != null || !bIgnoreNull) {
            dto.setItemType(t.getItemType());
        }
        if (t.getLabelDynaClass() != null || !bIgnoreNull) {
            dto.setLabelDynaClass(t.getLabelDynaClass());
        }
        if (t.getLabelPSSysCssId() != null || !bIgnoreNull) {
            dto.setLabelPSSysCssId(t.getLabelPSSysCssId());
        }
        if (t.getLabelPSSysCssName() != null || !bIgnoreNull) {
            dto.setLabelPSSysCssName(t.getLabelPSSysCssName());
        }
        if (t.getLabelRawCssStyle() != null || !bIgnoreNull) {
            dto.setLabelRawCssStyle(t.getLabelRawCssStyle());
        }
        if (t.getLayoutMode() != null || !bIgnoreNull) {
            dto.setLayoutMode(t.getLayoutMode());
        }
        if (t.getLeftPos() != null || !bIgnoreNull) {
            dto.setLeftPos(t.getLeftPos());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMobFlag() != null || !bIgnoreNull) {
            dto.setMobFlag(t.getMobFlag());
        }
        if (t.getOpenPSAppViewId() != null || !bIgnoreNull) {
            dto.setOpenPSAppViewId(t.getOpenPSAppViewId());
        }
        if (t.getOpenPSAppViewName() != null || !bIgnoreNull) {
            dto.setOpenPSAppViewName(t.getOpenPSAppViewName());
        }
        if (t.getOpenPSDEViewId() != null || !bIgnoreNull) {
            dto.setOpenPSDEViewId(t.getOpenPSDEViewId());
        }
        if (t.getOpenPSDEViewName() != null || !bIgnoreNull) {
            dto.setOpenPSDEViewName(t.getOpenPSDEViewName());
        }
        if (t.getOpenPSSysPDTViewId() != null || !bIgnoreNull) {
            dto.setOpenPSSysPDTViewId(t.getOpenPSSysPDTViewId());
        }
        if (t.getOpenPSSysPDTViewName() != null || !bIgnoreNull) {
            dto.setOpenPSSysPDTViewName(t.getOpenPSSysPDTViewName());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getOrientationMode() != null || !bIgnoreNull) {
            dto.setOrientationMode(t.getOrientationMode());
        }
        if (t.getPHPSLanResId() != null || !bIgnoreNull) {
            dto.setPHPSLanResId(t.getPHPSLanResId());
        }
        if (t.getPHPSLanResName() != null || !bIgnoreNull) {
            dto.setPHPSLanResName(t.getPHPSLanResName());
        }
        if (t.getPlaceHolder() != null || !bIgnoreNull) {
            dto.setPlaceHolder(t.getPlaceHolder());
        }
        if (t.getPLayoutMode() != null || !bIgnoreNull) {
            dto.setPLayoutMode(t.getPLayoutMode());
        }
        if (t.getPPSSysViewPanelItemId() != null || !bIgnoreNull) {
            dto.setPPSSysViewPanelItemId(t.getPPSSysViewPanelItemId());
        }
        if (t.getPPSSysViewPanelItemName() != null || !bIgnoreNull) {
            dto.setPPSSysViewPanelItemName(t.getPPSSysViewPanelItemName());
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
        if (t.getPSAppMenuId() != null || !bIgnoreNull) {
            dto.setPSAppMenuId(t.getPSAppMenuId());
        }
        if (t.getPSAppMenuName() != null || !bIgnoreNull) {
            dto.setPSAppMenuName(t.getPSAppMenuName());
        }
        if (t.getPSCodeListId() != null || !bIgnoreNull) {
            dto.setPSCodeListId(t.getPSCodeListId());
        }
        if (t.getPSCodeListName() != null || !bIgnoreNull) {
            dto.setPSCodeListName(t.getPSCodeListName());
        }
        if (t.getPSCtrlId() != null || !bIgnoreNull) {
            dto.setPSCtrlId(t.getPSCtrlId());
        }
        if (t.getPSCtrlLogicGroupId() != null || !bIgnoreNull) {
            dto.setPSCtrlLogicGroupId(t.getPSCtrlLogicGroupId());
        }
        if (t.getPSCtrlLogicGroupName() != null || !bIgnoreNull) {
            dto.setPSCtrlLogicGroupName(t.getPSCtrlLogicGroupName());
        }
        if (t.getPSCtrlName() != null || !bIgnoreNull) {
            dto.setPSCtrlName(t.getPSCtrlName());
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
        if (t.getPSDEDRItemId() != null || !bIgnoreNull) {
            dto.setPSDEDRItemId(t.getPSDEDRItemId());
        }
        if (t.getPSDEDRItemName() != null || !bIgnoreNull) {
            dto.setPSDEDRItemName(t.getPSDEDRItemName());
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
        if (t.getPSDELogicId() != null || !bIgnoreNull) {
            dto.setPSDELogicId(t.getPSDELogicId());
        }
        if (t.getPSDELogicName() != null || !bIgnoreNull) {
            dto.setPSDELogicName(t.getPSDELogicName());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDEPanelId() != null || !bIgnoreNull) {
            dto.setPSDEPanelId(t.getPSDEPanelId());
        }
        if (t.getPSDEPanelName() != null || !bIgnoreNull) {
            dto.setPSDEPanelName(t.getPSDEPanelName());
        }
        if (t.getPSDEReportId() != null || !bIgnoreNull) {
            dto.setPSDEReportId(t.getPSDEReportId());
        }
        if (t.getPSDEReportName() != null || !bIgnoreNull) {
            dto.setPSDEReportName(t.getPSDEReportName());
        }
        if (t.getPSDESearchFormId() != null || !bIgnoreNull) {
            dto.setPSDESearchFormId(t.getPSDESearchFormId());
        }
        if (t.getPSDESearchFormName() != null || !bIgnoreNull) {
            dto.setPSDESearchFormName(t.getPSDESearchFormName());
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
        if (t.getPSDEUIActionId() != null || !bIgnoreNull) {
            dto.setPSDEUIActionId(t.getPSDEUIActionId());
        }
        if (t.getPSDEUIActionName() != null || !bIgnoreNull) {
            dto.setPSDEUIActionName(t.getPSDEUIActionName());
        }
        if (t.getPSDEViewBaseId() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseId(t.getPSDEViewBaseId());
        }
        if (t.getPSDEViewBaseName() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseName(t.getPSDEViewBaseName());
        }
        if (t.getPSDEWizardId() != null || !bIgnoreNull) {
            dto.setPSDEWizardId(t.getPSDEWizardId());
        }
        if (t.getPSDEWizardName() != null || !bIgnoreNull) {
            dto.setPSDEWizardName(t.getPSDEWizardName());
        }
        if (t.getPSSysCalendarId() != null || !bIgnoreNull) {
            dto.setPSSysCalendarId(t.getPSSysCalendarId());
        }
        if (t.getPSSysCalendarName() != null || !bIgnoreNull) {
            dto.setPSSysCalendarName(t.getPSSysCalendarName());
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
        if (t.getPSSysEditorStyleId() != null || !bIgnoreNull) {
            dto.setPSSysEditorStyleId(t.getPSSysEditorStyleId());
        }
        if (t.getPSSysEditorStyleName() != null || !bIgnoreNull) {
            dto.setPSSysEditorStyleName(t.getPSSysEditorStyleName());
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
        if (t.getPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginId(t.getPSSysPFPluginId());
        }
        if (t.getPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginName(t.getPSSysPFPluginName());
        }
        if (t.getPSSysResourceId() != null || !bIgnoreNull) {
            dto.setPSSysResourceId(t.getPSSysResourceId());
        }
        if (t.getPSSysResourceName() != null || !bIgnoreNull) {
            dto.setPSSysResourceName(t.getPSSysResourceName());
        }
        if (t.getPSSysSearchBarId() != null || !bIgnoreNull) {
            dto.setPSSysSearchBarId(t.getPSSysSearchBarId());
        }
        if (t.getPSSysSearchBarName() != null || !bIgnoreNull) {
            dto.setPSSysSearchBarName(t.getPSSysSearchBarName());
        }
        if (t.getPSSysViewPanelId() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelId(t.getPSSysViewPanelId());
        }
        if (t.getPSSysViewPanelItemName() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelItemName(t.getPSSysViewPanelItemName());
        }
        if (t.getPSSysViewPanelName() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelName(t.getPSSysViewPanelName());
        }
        if (t.getRawContent() != null || !bIgnoreNull) {
            dto.setRawContent(t.getRawContent());
        }
        if (t.getRawCssStyle() != null || !bIgnoreNull) {
            dto.setRawCssStyle(t.getRawCssStyle());
        }
        if (t.getRawServiceMethod() != null || !bIgnoreNull) {
            dto.setRawServiceMethod(t.getRawServiceMethod());
        }
        if (t.getRawServiceUrl() != null || !bIgnoreNull) {
            dto.setRawServiceUrl(t.getRawServiceUrl());
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
        if (t.getRefLinkPSDEViewId() != null || !bIgnoreNull) {
            dto.setRefLinkPSDEViewId(t.getRefLinkPSDEViewId());
        }
        if (t.getRefLinkPSDEViewName() != null || !bIgnoreNull) {
            dto.setRefLinkPSDEViewName(t.getRefLinkPSDEViewName());
        }
        if (t.getRefPickupPSDEViewId() != null || !bIgnoreNull) {
            dto.setRefPickupPSDEViewId(t.getRefPickupPSDEViewId());
        }
        if (t.getRefPickupPSDEViewName() != null || !bIgnoreNull) {
            dto.setRefPickupPSDEViewName(t.getRefPickupPSDEViewName());
        }
        if (t.getRefPSDEACModeId() != null || !bIgnoreNull) {
            dto.setRefPSDEACModeId(t.getRefPSDEACModeId());
        }
        if (t.getRefPSDEACModeName() != null || !bIgnoreNull) {
            dto.setRefPSDEACModeName(t.getRefPSDEACModeName());
        }
        if (t.getRefPSDEDataSetId() != null || !bIgnoreNull) {
            dto.setRefPSDEDataSetId(t.getRefPSDEDataSetId());
        }
        if (t.getRefPSDEDataSetName() != null || !bIgnoreNull) {
            dto.setRefPSDEDataSetName(t.getRefPSDEDataSetName());
        }
        if (t.getRefPSDEId() != null || !bIgnoreNull) {
            dto.setRefPSDEId(t.getRefPSDEId());
        }
        if (t.getRefPSDEName() != null || !bIgnoreNull) {
            dto.setRefPSDEName(t.getRefPSDEName());
        }
        if (t.getRenderMode() != null || !bIgnoreNull) {
            dto.setRenderMode(t.getRenderMode());
        }
        if (t.getRenderModeText() != null || !bIgnoreNull) {
            dto.setRenderModeText(t.getRenderModeText());
        }
        if (t.getRightPos() != null || !bIgnoreNull) {
            dto.setRightPos(t.getRightPos());
        }
        if (t.getRowSpan() != null || !bIgnoreNull) {
            dto.setRowSpan(t.getRowSpan());
        }
        if (t.getShowCaption() != null || !bIgnoreNull) {
            dto.setShowCaption(t.getShowCaption());
        }
        if (t.getSpacingBottom() != null || !bIgnoreNull) {
            dto.setSpacingBottom(t.getSpacingBottom());
        }
        if (t.getSpacingLeft() != null || !bIgnoreNull) {
            dto.setSpacingLeft(t.getSpacingLeft());
        }
        if (t.getSpacingRight() != null || !bIgnoreNull) {
            dto.setSpacingRight(t.getSpacingRight());
        }
        if (t.getSpacingTop() != null || !bIgnoreNull) {
            dto.setSpacingTop(t.getSpacingTop());
        }
        if (t.getSwapMode() != null || !bIgnoreNull) {
            dto.setSwapMode(t.getSwapMode());
        }
        if (t.getTabIndex() != null || !bIgnoreNull) {
            dto.setTabIndex(t.getTabIndex());
        }
        if (t.getTargetId() != null || !bIgnoreNull) {
            dto.setTargetId(t.getTargetId());
        }
        if (t.getTargetName() != null || !bIgnoreNull) {
            dto.setTargetName(t.getTargetName());
        }
        if (t.getTargetType() != null || !bIgnoreNull) {
            dto.setTargetType(t.getTargetType());
        }
        if (t.getTitleBarCloseMode() != null || !bIgnoreNull) {
            dto.setTitleBarCloseMode(t.getTitleBarCloseMode());
        }
        if (t.getToggleMode() != null || !bIgnoreNull) {
            dto.setToggleMode(t.getToggleMode());
        }
        if (t.getTooltipInfo() != null || !bIgnoreNull) {
            dto.setTooltipInfo(t.getTooltipInfo());
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
        if (t.getVAlign() != null || !bIgnoreNull) {
            dto.setVAlign(t.getVAlign());
        }
        if (t.getVAlignSelf() != null || !bIgnoreNull) {
            dto.setVAlignSelf(t.getVAlignSelf());
        }
        if (t.getValueFormat() != null || !bIgnoreNull) {
            dto.setValueFormat(t.getValueFormat());
        }
        if (t.getWidth() != null || !bIgnoreNull) {
            dto.setWidth(t.getWidth());
        }
        if (t.getWidthMode() != null || !bIgnoreNull) {
            dto.setWidthMode(t.getWidthMode());
        }
        if (StringUtils.hasLength((String)dto.getADPSDELogicId())) {
            dto.setADPSDELogicId(this.getRealPSModelId(t, dto.getADPSDELogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            dto.setCapPSLanResId(this.getRealPSModelId(t, dto.getCapPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCtrlPSSysCssId())) {
            dto.setCtrlPSSysCssId(this.getRealPSModelId(t, dto.getCtrlPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLabelPSSysCssId())) {
            dto.setLabelPSSysCssId(this.getRealPSModelId(t, dto.getLabelPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOpenPSAppViewId())) {
            dto.setOpenPSAppViewId(this.getRealPSModelId(t, dto.getOpenPSAppViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOpenPSDEViewId())) {
            dto.setOpenPSDEViewId(this.getRealPSModelId(t, dto.getOpenPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOpenPSSysPDTViewId())) {
            dto.setOpenPSSysPDTViewId(this.getRealPSModelId(t, dto.getOpenPSSysPDTViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPHPSLanResId())) {
            dto.setPHPSLanResId(this.getRealPSModelId(t, dto.getPHPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSSysViewPanelItemId())) {
            dto.setPPSSysViewPanelItemId(this.getRealPSModelId(t, dto.getPPSSysViewPanelItemId()).replace("/", "."));
        }
        if ("PSSYSVIEWPANELITEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPPSSysViewPanelItemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSACHandlerId())) {
            dto.setPSACHandlerId(this.getRealPSModelId(t, dto.getPSACHandlerId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppMenuId())) {
            dto.setPSAppMenuId(this.getRealPSModelId(t, dto.getPSAppMenuId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            dto.setPSCodeListId(this.getRealPSModelId(t, dto.getPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlLogicGroupId())) {
            dto.setPSCtrlLogicGroupId(this.getRealPSModelId(t, dto.getPSCtrlLogicGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            dto.setPSDEActionId(this.getRealPSModelId(t, dto.getPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEChartId())) {
            dto.setPSDEChartId(this.getRealPSModelId(t, dto.getPSDEChartId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSDEDRItemId())) {
            dto.setPSDEDRItemId(this.getRealPSModelId(t, dto.getPSDEDRItemId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            dto.setPSDELogicId(this.getRealPSModelId(t, dto.getPSDELogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEPanelId())) {
            dto.setPSDEPanelId(this.getRealPSModelId(t, dto.getPSDEPanelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEReportId())) {
            dto.setPSDEReportId(this.getRealPSModelId(t, dto.getPSDEReportId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDESearchFormId())) {
            dto.setPSDESearchFormId(this.getRealPSModelId(t, dto.getPSDESearchFormId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            dto.setPSDEUIActionId(this.getRealPSModelId(t, dto.getPSDEUIActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            dto.setPSDEViewBaseId(this.getRealPSModelId(t, dto.getPSDEViewBaseId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEWizardId())) {
            dto.setPSDEWizardId(this.getRealPSModelId(t, dto.getPSDEWizardId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCalendarId())) {
            dto.setPSSysCalendarId(this.getRealPSModelId(t, dto.getPSSysCalendarId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysEditorStyleId())) {
            dto.setPSSysEditorStyleId(this.getRealPSModelId(t, dto.getPSSysEditorStyleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            dto.setPSSysImageId(this.getRealPSModelId(t, dto.getPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysMapViewId())) {
            dto.setPSSysMapViewId(this.getRealPSModelId(t, dto.getPSSysMapViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysResourceId())) {
            dto.setPSSysResourceId(this.getRealPSModelId(t, dto.getPSSysResourceId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchBarId())) {
            dto.setPSSysSearchBarId(this.getRealPSModelId(t, dto.getPSSysSearchBarId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            dto.setPSSysViewPanelId(this.getRealPSModelId(t, dto.getPSSysViewPanelId()).replace("/", "."));
        }
        if ("PSSYSVIEWPANEL".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysViewPanelId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefLinkPSDEViewId())) {
            dto.setRefLinkPSDEViewId(this.getRealPSModelId(t, dto.getRefLinkPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPickupPSDEViewId())) {
            dto.setRefPickupPSDEViewId(this.getRealPSModelId(t, dto.getRefPickupPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEACModeId())) {
            dto.setRefPSDEACModeId(this.getRealPSModelId(t, dto.getRefPSDEACModeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEDataSetId())) {
            dto.setRefPSDEDataSetId(this.getRealPSModelId(t, dto.getRefPSDEDataSetId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEId())) {
            dto.setRefPSDEId(this.getRealPSModelId(t, dto.getRefPSDEId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getCtrlPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getCtrlPSSysCssId());
            dto.setCtrlPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setCtrlPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getLabelPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getLabelPSSysCssId());
            dto.setLabelPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setLabelPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getOpenPSAppViewId())) {
            linkDTO = (PSAppViewDTO)PSModelServiceUtil.getInstance().getPSAppViewService().getDTO(dto.getOpenPSAppViewId());
            dto.setOpenPSAppViewName(((PSAppViewDTO)linkDTO).getPSAppViewName());
        } else {
            dto.setOpenPSAppViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getOpenPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getOpenPSDEViewId());
            dto.setOpenPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setOpenPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getOpenPSSysPDTViewId())) {
            linkDTO = (PSSysPDTViewDTO)PSModelServiceUtil.getInstance().getPSSysPDTViewService().getDTO(dto.getOpenPSSysPDTViewId());
            dto.setOpenPSSysPDTViewName(((PSSysPDTViewDTO)linkDTO).getPSSysPDTViewName());
        } else {
            dto.setOpenPSSysPDTViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPHPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getPHPSLanResId());
            dto.setPHPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setPHPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPPSSysViewPanelItemId())) {
            linkDTO = (PSSysViewPanelItemDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelItemService().getDTO(dto.getPPSSysViewPanelItemId());
            dto.setPLayoutMode(((PSSysViewPanelItemDTO)linkDTO).getLayoutMode());
            dto.setPPSSysViewPanelItemName(((PSSysViewPanelItemDTO)linkDTO).getPSSysViewPanelItemName());
        } else {
            dto.setPLayoutMode(null);
            dto.setPPSSysViewPanelItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSACHandlerId())) {
            linkDTO = (PSACHandlerDTO)PSModelServiceUtil.getInstance().getPSACHandlerService().getDTO(dto.getPSACHandlerId());
            dto.setPSACHandlerName(((PSACHandlerDTO)linkDTO).getPSACHandlerName());
        } else {
            dto.setPSACHandlerName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSAppMenuId())) {
            linkDTO = (PSAppMenuDTO)PSModelServiceUtil.getInstance().getPSAppMenuService().getDTO(dto.getPSAppMenuId());
            dto.setPSAppMenuName(((PSAppMenuDTO)linkDTO).getPSAppMenuName());
        } else {
            dto.setPSAppMenuName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getPSCodeListId());
            dto.setPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setPSCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlLogicGroupId())) {
            linkDTO = (PSCtrlLogicGroupDTO)PSModelServiceUtil.getInstance().getPSCtrlLogicGroupService().getDTO(dto.getPSCtrlLogicGroupId());
            dto.setPSCtrlLogicGroupName(((PSCtrlLogicGroupDTO)linkDTO).getPSCtrlLogicGroupName());
        } else {
            dto.setPSCtrlLogicGroupName(null);
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
        if (StringUtils.hasLength((String)dto.getPSDEDRItemId())) {
            linkDTO = (PSDEDRItemDTO)PSModelServiceUtil.getInstance().getPSDEDRItemService().getDTO(dto.getPSDEDRItemId());
            dto.setPSDEDRItemName(((PSDEDRItemDTO)linkDTO).getPSDEDRItemName());
        } else {
            dto.setPSDEDRItemName(null);
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
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getPSDELogicId());
            dto.setPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEPanelId())) {
            linkDTO = (PSSysViewPanelDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelService().getDTO(dto.getPSDEPanelId());
            dto.setPSDEPanelName(((PSSysViewPanelDTO)linkDTO).getPSSysViewPanelName());
        } else {
            dto.setPSDEPanelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEReportId())) {
            linkDTO = (PSDEReportDTO)PSModelServiceUtil.getInstance().getPSDEReportService().getDTO(dto.getPSDEReportId());
            dto.setPSDEReportName(((PSDEReportDTO)linkDTO).getPSDEReportName());
        } else {
            dto.setPSDEReportName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDESearchFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getPSDESearchFormId());
            dto.setPSDESearchFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setPSDESearchFormName(null);
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
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            linkDTO = (PSDEUIActionDTO)PSModelServiceUtil.getInstance().getPSDEUIActionService().getDTO(dto.getPSDEUIActionId());
            dto.setPSDEUIActionName(((PSDEUIActionDTO)linkDTO).getPSDEUIActionName());
        } else {
            dto.setPSDEUIActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getPSDEViewBaseId());
            dto.setPSDEViewBaseName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setPSDEViewBaseName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysEditorStyleId())) {
            linkDTO = (PSSysEditorStyleDTO)PSModelServiceUtil.getInstance().getPSSysEditorStyleService().getDTO(dto.getPSSysEditorStyleId());
            dto.setPSSysEditorStyleName(((PSSysEditorStyleDTO)linkDTO).getPSSysEditorStyleName());
        } else {
            dto.setPSSysEditorStyleName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getPSSysPFPluginId());
            dto.setPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysResourceId())) {
            linkDTO = (PSSysResourceDTO)PSModelServiceUtil.getInstance().getPSSysResourceService().getDTO(dto.getPSSysResourceId());
            dto.setPSSysResourceName(((PSSysResourceDTO)linkDTO).getPSSysResourceName());
        } else {
            dto.setPSSysResourceName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchBarId())) {
            linkDTO = (PSSysSearchBarDTO)PSModelServiceUtil.getInstance().getPSSysSearchBarService().getDTO(dto.getPSSysSearchBarId());
            dto.setPSSysSearchBarName(((PSSysSearchBarDTO)linkDTO).getPSSysSearchBarName());
        } else {
            dto.setPSSysSearchBarName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            linkDTO = (PSSysViewPanelDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelService().getDTO(dto.getPSSysViewPanelId());
            dto.setMobFlag(((PSSysViewPanelDTO)linkDTO).getMobFlag());
            dto.setPSSysViewPanelName(((PSSysViewPanelDTO)linkDTO).getPSSysViewPanelName());
        } else {
            dto.setMobFlag(null);
            dto.setPSSysViewPanelName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefLinkPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getRefLinkPSDEViewId());
            dto.setRefLinkPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setRefLinkPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPickupPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getRefPickupPSDEViewId());
            dto.setRefPickupPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setRefPickupPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEACModeId())) {
            linkDTO = (PSDEACModeDTO)PSModelServiceUtil.getInstance().getPSDEACModeService().getDTO(dto.getRefPSDEACModeId());
            dto.setRefPSDEACModeName(((PSDEACModeDTO)linkDTO).getPSDEACModeName());
        } else {
            dto.setRefPSDEACModeName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEDataSetId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getRefPSDEDataSetId());
            dto.setRefPSDEDataSetName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setRefPSDEDataSetName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getRefPSDEId());
            dto.setRefPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setRefPSDEName(null);
        }
        List<PSModelBase> list = PSModelServiceUtil.getInstance().getPSSysViewPanelItemService().listByPSSysViewPanelItem(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSSysViewPanelItemDTO> pssysviewpanelitems = new ArrayList<PSSysViewPanelItemDTO>();
            for (PSSysViewPanelItem pSSysViewPanelItem : list) {
                dstItem = (PSSysViewPanelItemDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelItemService().toDTO(pSSysViewPanelItem);
                pssysviewpanelitems.add((PSSysViewPanelItemDTO)dstItem);
            }
            dto.setPssysviewpanelitems(pssysviewpanelitems);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSPanelItemLogicService().listByPSSysViewPanelItem(t)) != null && list.size() > 0) {
            ArrayList<PSPanelItemLogicDTO> pspanelitemlogics = new ArrayList<PSPanelItemLogicDTO>();
            for (PSPanelItemLogic pSPanelItemLogic : list) {
                dstItem = (PSPanelItemLogicDTO)PSModelServiceUtil.getInstance().getPSPanelItemLogicService().toDTO(pSPanelItemLogic);
                pspanelitemlogics.add((PSPanelItemLogicDTO)dstItem);
            }
            dto.setPspanelitemlogics(pspanelitemlogics);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSVIEWPANELITEM";
    }

    @Override
    public PSSysViewPanelItem createDomain() {
        return new PSSysViewPanelItem();
    }

    @Override
    public PSSysViewPanelItemDTO createDTO() {
        return new PSSysViewPanelItemDTO();
    }
}

