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
import net.ibizsys.modelapi.domain.PSDEFDLogic;
import net.ibizsys.modelapi.domain.PSDEForm;
import net.ibizsys.modelapi.domain.PSDEFormDetail;
import net.ibizsys.modelapi.dto.PSACHandlerDTO;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSDEACModeDTO;
import net.ibizsys.modelapi.dto.PSDEDRItemDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEDataViewDTO;
import net.ibizsys.modelapi.dto.PSDEFDLogicDTO;
import net.ibizsys.modelapi.dto.PSDEFIUpdateDTO;
import net.ibizsys.modelapi.dto.PSDEFSFItemDTO;
import net.ibizsys.modelapi.dto.PSDEFUIModeDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDEFormDTO;
import net.ibizsys.modelapi.dto.PSDEFormDetailDTO;
import net.ibizsys.modelapi.dto.PSDEFormRFDTO;
import net.ibizsys.modelapi.dto.PSDEGridDTO;
import net.ibizsys.modelapi.dto.PSDEListDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSDEUAGroupDTO;
import net.ibizsys.modelapi.dto.PSDEUIActionDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysCounterDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysDictCatDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysEditorStyleDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysResourceDTO;
import net.ibizsys.modelapi.service.IPSDEFormDetailService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEFormDetailServiceImpl
extends PSModelServiceImplBase<PSDEFormDetail, PSDEFormDetailDTO>
implements IPSDEFormDetailService {
    private static final Log log = LogFactory.getLog(PSDEFormDetailServiceImpl.class);

    @Override
    public List<PSDEFormDetail> listByPSDEFormDetail(PSDEFormDetail parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEFormDetail get(PSDEFormDetail parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEFormDetail> list = this.listByPSDEFormDetail(parent);
        if (list != null) {
            for (PSDEFormDetail item : list) {
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
    public List<PSDEFormDetailDTO> listDTOByPSDEFormDetail(String strParentKey) throws Exception {
        PSDEFormDetail psdeformdetail = (PSDEFormDetail)PSModelServiceUtil.getInstance().getPSDEFormDetailService().get(strParentKey);
        List<PSDEFormDetail> list = this.listByPSDEFormDetail(psdeformdetail);
        if (list != null) {
            ArrayList<PSDEFormDetailDTO> dtoList = new ArrayList<PSDEFormDetailDTO>();
            for (PSDEFormDetail item : list) {
                PSDEFormDetailDTO dto = (PSDEFormDetailDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEFormDetail> listByPSDEForm(PSDEForm parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEFormDetail get(PSDEForm parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEFormDetail> list = this.listByPSDEForm(parent);
        if (list != null) {
            for (PSDEFormDetail item : list) {
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
    public List<PSDEFormDetailDTO> listDTOByPSDEForm(String strParentKey) throws Exception {
        PSDEForm psdeform = (PSDEForm)PSModelServiceUtil.getInstance().getPSDEFormService().get(strParentKey);
        List<PSDEFormDetail> list = this.listByPSDEForm(psdeform);
        if (list != null) {
            ArrayList<PSDEFormDetailDTO> dtoList = new ArrayList<PSDEFormDetailDTO>();
            for (PSDEFormDetail item : list) {
                PSDEFormDetailDTO dto = (PSDEFormDetailDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEFormDetail> onListAll() throws Exception {
        ArrayList<PSDEFormDetail> list = new ArrayList<PSDEFormDetail>();
        List psdeforms = PSModelServiceUtil.getInstance().getPSDEFormService().listAll();
        if (psdeforms != null) {
            for (PSDEForm parent : psdeforms) {
                List<PSDEFormDetail> items = this.listByPSDEForm(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        ArrayList<PSDEFormDetail> alllist = new ArrayList<PSDEFormDetail>();
        alllist.addAll(list);
        for (PSDEFormDetail item : list) {
            List<PSDEFormDetail> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDEFormDetail> listAllChild(PSDEFormDetail parent) throws Exception {
        List<PSDEFormDetail> list = this.listByPSDEFormDetail(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSDEFormDetail> alllist = new ArrayList<PSDEFormDetail>();
        alllist.addAll(list);
        for (PSDEFormDetail item : list) {
            List<PSDEFormDetail> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDEFormDetail> listAllByPSDEForm(PSDEForm parent) throws Exception {
        List<PSDEFormDetail> list = this.listByPSDEForm(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSDEFormDetail> alllist = new ArrayList<PSDEFormDetail>();
        alllist.addAll(list);
        for (PSDEFormDetail item : list) {
            List<PSDEFormDetail> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDEFormDetailDTO> listAllDTOByPSDEForm(String strParentKey) throws Exception {
        PSDEForm psdeform = (PSDEForm)PSModelServiceUtil.getInstance().getPSDEFormService().get(strParentKey);
        List<PSDEFormDetail> list = this.listAllByPSDEForm(psdeform);
        if (list != null) {
            ArrayList<PSDEFormDetailDTO> dtoList = new ArrayList<PSDEFormDetailDTO>();
            for (PSDEFormDetail item : list) {
                PSDEFormDetailDTO dto = (PSDEFormDetailDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected PSDEFormDetail onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEFormDetail item;
        PSDEFormDetail item2;
        PSDEFormDetail psdeformdetail = (PSDEFormDetail)PSModelServiceUtil.getInstance().getPSDEFormDetailService().get(strParentKey, true);
        if (psdeformdetail != null && (item2 = this.get(psdeformdetail, strCurKey, true)) != null) {
            return item2;
        }
        PSDEForm psdeform = (PSDEForm)PSModelServiceUtil.getInstance().getPSDEFormService().get(strParentKey, true);
        if (psdeform != null && (item = this.get(psdeform, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEFormDetail)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEFormDetailDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPPSDEFormDetailId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEFormDetailService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSDEFormId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEFormService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEFormDetail et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEFormDetailName())) {
            return et.getPSDEFormDetailName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEFormDetailDTO dto, PSDEFormDetail t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEFormDetailId(t.getId().replace("/", "."));
        }
        if (t.getAllowEmpty() != null || !bIgnoreNull) {
            dto.setAllowEmpty(t.getAllowEmpty());
        }
        if (t.getBL_Pos() != null || !bIgnoreNull) {
            dto.setBL_Pos(t.getBL_Pos());
        }
        if (t.getBorderStyle() != null || !bIgnoreNull) {
            dto.setBorderStyle(t.getBorderStyle());
        }
        if (t.getBtnActionType() != null || !bIgnoreNull) {
            dto.setBtnActionType(t.getBtnActionType());
        }
        if (t.getBuildInAction() != null || !bIgnoreNull) {
            dto.setBuildInAction(t.getBuildInAction());
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
        if (t.getCodeListConfigMode() != null || !bIgnoreNull) {
            dto.setCodeListConfigMode(t.getCodeListConfigMode());
        }
        if (t.getColAlign() != null || !bIgnoreNull) {
            dto.setColAlign(t.getColAlign());
        }
        if (t.getColId() != null || !bIgnoreNull) {
            dto.setColId(t.getColId());
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
        if (t.getConvertCIText() != null || !bIgnoreNull) {
            dto.setConvertCIText(t.getConvertCIText());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateDV() != null || !bIgnoreNull) {
            dto.setCreateDV(t.getCreateDV());
        }
        if (t.getCreateDVT() != null || !bIgnoreNull) {
            dto.setCreateDVT(t.getCreateDVT());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCtrlColSpan() != null || !bIgnoreNull) {
            dto.setCtrlColSpan(t.getCtrlColSpan());
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
        if (t.getCtrlWidth() != null || !bIgnoreNull) {
            dto.setCtrlWidth(t.getCtrlWidth());
        }
        if (t.getCustomCode() != null || !bIgnoreNull) {
            dto.setCustomCode(t.getCustomCode());
        }
        if (t.getData() != null || !bIgnoreNull) {
            dto.setData(t.getData());
        }
        if (t.getDefaultFlag() != null || !bIgnoreNull) {
            dto.setDefaultFlag(t.getDefaultFlag());
        }
        if (t.getDetailStyle() != null || !bIgnoreNull) {
            dto.setDetailStyle(t.getDetailStyle());
        }
        if (t.getDetailStyleText() != null || !bIgnoreNull) {
            dto.setDetailStyleText(t.getDetailStyleText());
        }
        if (t.getDetailTag() != null || !bIgnoreNull) {
            dto.setDetailTag(t.getDetailTag());
        }
        if (t.getDetailTag2() != null || !bIgnoreNull) {
            dto.setDetailTag2(t.getDetailTag2());
        }
        if (t.getDetailType() != null || !bIgnoreNull) {
            dto.setDetailType(t.getDetailType());
        }
        if (t.getDynaClass() != null || !bIgnoreNull) {
            dto.setDynaClass(t.getDynaClass());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getEditorParams() != null || !bIgnoreNull) {
            dto.setEditorParams(t.getEditorParams());
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
        if (t.getEnableCond() != null || !bIgnoreNull) {
            dto.setEnableCond(t.getEnableCond());
        }
        if (t.getEnableItemPriv() != null || !bIgnoreNull) {
            dto.setEnableItemPriv(t.getEnableItemPriv());
        }
        if (t.getFieldName() != null || !bIgnoreNull) {
            dto.setFieldName(t.getFieldName());
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
        if (t.getFormType() != null || !bIgnoreNull) {
            dto.setFormType(t.getFormType());
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
        if (t.getItemPSACHandlerId() != null || !bIgnoreNull) {
            dto.setItemPSACHandlerId(t.getItemPSACHandlerId());
        }
        if (t.getItemPSACHandlerName() != null || !bIgnoreNull) {
            dto.setItemPSACHandlerName(t.getItemPSACHandlerName());
        }
        if (t.getItemStates() != null || !bIgnoreNull) {
            dto.setItemStates(t.getItemStates());
        }
        if (t.getLabelColSpan() != null || !bIgnoreNull) {
            dto.setLabelColSpan(t.getLabelColSpan());
        }
        if (t.getLabelColSpan2() != null || !bIgnoreNull) {
            dto.setLabelColSpan2(t.getLabelColSpan2());
        }
        if (t.getLabelDynaClass() != null || !bIgnoreNull) {
            dto.setLabelDynaClass(t.getLabelDynaClass());
        }
        if (t.getLabelPos() != null || !bIgnoreNull) {
            dto.setLabelPos(t.getLabelPos());
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
        if (t.getLabelWidth() != null || !bIgnoreNull) {
            dto.setLabelWidth(t.getLabelWidth());
        }
        if (t.getLayoutMode() != null || !bIgnoreNull) {
            dto.setLayoutMode(t.getLayoutMode());
        }
        if (t.getLevelTag() != null || !bIgnoreNull) {
            dto.setLevelTag(t.getLevelTag());
        }
        if (t.getLinkPSDEViewId() != null || !bIgnoreNull) {
            dto.setLinkPSDEViewId(t.getLinkPSDEViewId());
        }
        if (t.getLinkPSDEViewName() != null || !bIgnoreNull) {
            dto.setLinkPSDEViewName(t.getLinkPSDEViewName());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMargin() != null || !bIgnoreNull) {
            dto.setMargin(t.getMargin());
        }
        if (t.getMDCtrlType() != null || !bIgnoreNull) {
            dto.setMDCtrlType(t.getMDCtrlType());
        }
        if (t.getMDPSDEDataViewId() != null || !bIgnoreNull) {
            dto.setMDPSDEDataViewId(t.getMDPSDEDataViewId());
        }
        if (t.getMDPSDEDataViewName() != null || !bIgnoreNull) {
            dto.setMDPSDEDataViewName(t.getMDPSDEDataViewName());
        }
        if (t.getMDPSDEFormId() != null || !bIgnoreNull) {
            dto.setMDPSDEFormId(t.getMDPSDEFormId());
        }
        if (t.getMDPSDEFormName() != null || !bIgnoreNull) {
            dto.setMDPSDEFormName(t.getMDPSDEFormName());
        }
        if (t.getMDPSDEGridId() != null || !bIgnoreNull) {
            dto.setMDPSDEGridId(t.getMDPSDEGridId());
        }
        if (t.getMDPSDEGridName() != null || !bIgnoreNull) {
            dto.setMDPSDEGridName(t.getMDPSDEGridName());
        }
        if (t.getMDPSDEListId() != null || !bIgnoreNull) {
            dto.setMDPSDEListId(t.getMDPSDEListId());
        }
        if (t.getMDPSDEListName() != null || !bIgnoreNull) {
            dto.setMDPSDEListName(t.getMDPSDEListName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMobFlag() != null || !bIgnoreNull) {
            dto.setMobFlag(t.getMobFlag());
        }
        if (t.getModelState() != null || !bIgnoreNull) {
            dto.setModelState(t.getModelState());
        }
        if (t.getNeedCodeListConfig() != null || !bIgnoreNull) {
            dto.setNeedCodeListConfig(t.getNeedCodeListConfig());
        }
        if (t.getNoPrivDM() != null || !bIgnoreNull) {
            dto.setNoPrivDM(t.getNoPrivDM());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPadding() != null || !bIgnoreNull) {
            dto.setPadding(t.getPadding());
        }
        if (t.getPHPSLanResId() != null || !bIgnoreNull) {
            dto.setPHPSLanResId(t.getPHPSLanResId());
        }
        if (t.getPHPSLanResName() != null || !bIgnoreNull) {
            dto.setPHPSLanResName(t.getPHPSLanResName());
        }
        if (t.getPickupPSDEViewId() != null || !bIgnoreNull) {
            dto.setPickupPSDEViewId(t.getPickupPSDEViewId());
        }
        if (t.getPickupPSDEViewName() != null || !bIgnoreNull) {
            dto.setPickupPSDEViewName(t.getPickupPSDEViewName());
        }
        if (t.getPlaceHolder() != null || !bIgnoreNull) {
            dto.setPlaceHolder(t.getPlaceHolder());
        }
        if (t.getPLayoutMode() != null || !bIgnoreNull) {
            dto.setPLayoutMode(t.getPLayoutMode());
        }
        if (t.getPPSDEFormDetailId() != null || !bIgnoreNull) {
            dto.setPPSDEFormDetailId(t.getPPSDEFormDetailId());
        }
        if (t.getPPSDEFormDetailName() != null || !bIgnoreNull) {
            dto.setPPSDEFormDetailName(t.getPPSDEFormDetailName());
        }
        if (t.getPredefinedType() != null || !bIgnoreNull) {
            dto.setPredefinedType(t.getPredefinedType());
        }
        if (t.getPredefinedTypeText() != null || !bIgnoreNull) {
            dto.setPredefinedTypeText(t.getPredefinedTypeText());
        }
        if (t.getPreventXSS() != null || !bIgnoreNull) {
            dto.setPreventXSS(t.getPreventXSS());
        }
        if (t.getPSCodeListId() != null || !bIgnoreNull) {
            dto.setPSCodeListId(t.getPSCodeListId());
        }
        if (t.getPSCodeListName() != null || !bIgnoreNull) {
            dto.setPSCodeListName(t.getPSCodeListName());
        }
        if (t.getPSDEDRItemId() != null || !bIgnoreNull) {
            dto.setPSDEDRItemId(t.getPSDEDRItemId());
        }
        if (t.getPSDEDRItemName() != null || !bIgnoreNull) {
            dto.setPSDEDRItemName(t.getPSDEDRItemName());
        }
        if (t.getPSDEFUIModeId() != null || !bIgnoreNull) {
            dto.setPSDEFUIModeId(t.getPSDEFUIModeId());
        }
        if (t.getPSDEFUIModeName() != null || !bIgnoreNull) {
            dto.setPSDEFUIModeName(t.getPSDEFUIModeName());
        }
        if (t.getPSDEFId() != null || !bIgnoreNull) {
            dto.setPSDEFId(t.getPSDEFId());
        }
        if (t.getPSDEFIUpdateId() != null || !bIgnoreNull) {
            dto.setPSDEFIUpdateId(t.getPSDEFIUpdateId());
        }
        if (t.getPSDEFIUpdateName() != null || !bIgnoreNull) {
            dto.setPSDEFIUpdateName(t.getPSDEFIUpdateName());
        }
        if (t.getPSDEFName() != null || !bIgnoreNull) {
            dto.setPSDEFName(t.getPSDEFName());
        }
        if (t.getPSDEFormDetailName() != null || !bIgnoreNull) {
            dto.setPSDEFormDetailName(t.getPSDEFormDetailName());
        }
        if (t.getPSDEFormId() != null || !bIgnoreNull) {
            dto.setPSDEFormId(t.getPSDEFormId());
        }
        if (t.getPSDEFormName() != null || !bIgnoreNull) {
            dto.setPSDEFormName(t.getPSDEFormName());
        }
        if (t.getPSDEFormRFId() != null || !bIgnoreNull) {
            dto.setPSDEFormRFId(t.getPSDEFormRFId());
        }
        if (t.getPSDEFormRFName() != null || !bIgnoreNull) {
            dto.setPSDEFormRFName(t.getPSDEFormRFName());
        }
        if (t.getPSDEFSFItemId() != null || !bIgnoreNull) {
            dto.setPSDEFSFItemId(t.getPSDEFSFItemId());
        }
        if (t.getPSDEFSFItemName() != null || !bIgnoreNull) {
            dto.setPSDEFSFItemName(t.getPSDEFSFItemName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDELogicId() != null || !bIgnoreNull) {
            dto.setPSDELogicId(t.getPSDELogicId());
        }
        if (t.getPSDELogicName() != null || !bIgnoreNull) {
            dto.setPSDELogicName(t.getPSDELogicName());
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
        if (t.getPSSysDictCatId() != null || !bIgnoreNull) {
            dto.setPSSysDictCatId(t.getPSSysDictCatId());
        }
        if (t.getPSSysDictCatName() != null || !bIgnoreNull) {
            dto.setPSSysDictCatName(t.getPSSysDictCatName());
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
        if (t.getPSSysResourceId() != null || !bIgnoreNull) {
            dto.setPSSysResourceId(t.getPSSysResourceId());
        }
        if (t.getPSSysResourceName() != null || !bIgnoreNull) {
            dto.setPSSysResourceName(t.getPSSysResourceName());
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
        if (t.getRefPSDEFormDetailId() != null || !bIgnoreNull) {
            dto.setRefPSDEFormDetailId(t.getRefPSDEFormDetailId());
        }
        if (t.getRefPSDEFormDetailName() != null || !bIgnoreNull) {
            dto.setRefPSDEFormDetailName(t.getRefPSDEFormDetailName());
        }
        if (t.getRefPSDEFormId() != null || !bIgnoreNull) {
            dto.setRefPSDEFormId(t.getRefPSDEFormId());
        }
        if (t.getRefPSDEId() != null || !bIgnoreNull) {
            dto.setRefPSDEId(t.getRefPSDEId());
        }
        if (t.getRefPSDEName() != null || !bIgnoreNull) {
            dto.setRefPSDEName(t.getRefPSDEName());
        }
        if (t.getRefPSDERId() != null || !bIgnoreNull) {
            dto.setRefPSDERId(t.getRefPSDERId());
        }
        if (t.getRefPSDERName() != null || !bIgnoreNull) {
            dto.setRefPSDERName(t.getRefPSDERName());
        }
        if (t.getRenderMode() != null || !bIgnoreNull) {
            dto.setRenderMode(t.getRenderMode());
        }
        if (t.getRenderModeText() != null || !bIgnoreNull) {
            dto.setRenderModeText(t.getRenderModeText());
        }
        if (t.getResetItemName() != null || !bIgnoreNull) {
            dto.setResetItemName(t.getResetItemName());
        }
        if (t.getRowSpan() != null || !bIgnoreNull) {
            dto.setRowSpan(t.getRowSpan());
        }
        if (t.getShowCaption() != null || !bIgnoreNull) {
            dto.setShowCaption(t.getShowCaption());
        }
        if (t.getShowMoreMode() != null || !bIgnoreNull) {
            dto.setShowMoreMode(t.getShowMoreMode());
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
        if (t.getTitleBarCloseMode() != null || !bIgnoreNull) {
            dto.setTitleBarCloseMode(t.getTitleBarCloseMode());
        }
        if (t.getToggleMode() != null || !bIgnoreNull) {
            dto.setToggleMode(t.getToggleMode());
        }
        if (t.getTooltipInfo() != null || !bIgnoreNull) {
            dto.setTooltipInfo(t.getTooltipInfo());
        }
        if (t.getUCPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setUCPSSysPFPluginId(t.getUCPSSysPFPluginId());
        }
        if (t.getUCPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setUCPSSysPFPluginName(t.getUCPSSysPFPluginName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateDV() != null || !bIgnoreNull) {
            dto.setUpdateDV(t.getUpdateDV());
        }
        if (t.getUpdateDVT() != null || !bIgnoreNull) {
            dto.setUpdateDVT(t.getUpdateDVT());
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
        if (t.getValueItemName() != null || !bIgnoreNull) {
            dto.setValueItemName(t.getValueItemName());
        }
        if (t.getWBDEFMode() != null || !bIgnoreNull) {
            dto.setWBDEFMode(t.getWBDEFMode());
        }
        if (t.getWidth() != null || !bIgnoreNull) {
            dto.setWidth(t.getWidth());
        }
        if (t.getWidthMode() != null || !bIgnoreNull) {
            dto.setWidthMode(t.getWidthMode());
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            dto.setCapPSLanResId(this.getRealPSModelId(t, dto.getCapPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCtrlPSSysCssId())) {
            dto.setCtrlPSSysCssId(this.getRealPSModelId(t, dto.getCtrlPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getItemPSACHandlerId())) {
            dto.setItemPSACHandlerId(this.getRealPSModelId(t, dto.getItemPSACHandlerId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLabelPSSysCssId())) {
            dto.setLabelPSSysCssId(this.getRealPSModelId(t, dto.getLabelPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLinkPSDEViewId())) {
            dto.setLinkPSDEViewId(this.getRealPSModelId(t, dto.getLinkPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMDPSDEDataViewId())) {
            dto.setMDPSDEDataViewId(this.getRealPSModelId(t, dto.getMDPSDEDataViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMDPSDEFormId())) {
            dto.setMDPSDEFormId(this.getRealPSModelId(t, dto.getMDPSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMDPSDEGridId())) {
            dto.setMDPSDEGridId(this.getRealPSModelId(t, dto.getMDPSDEGridId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMDPSDEListId())) {
            dto.setMDPSDEListId(this.getRealPSModelId(t, dto.getMDPSDEListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPHPSLanResId())) {
            dto.setPHPSLanResId(this.getRealPSModelId(t, dto.getPHPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPickupPSDEViewId())) {
            dto.setPickupPSDEViewId(this.getRealPSModelId(t, dto.getPickupPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSDEFormDetailId())) {
            dto.setPPSDEFormDetailId(this.getRealPSModelId(t, dto.getPPSDEFormDetailId()).replace("/", "."));
        }
        if ("PSDEFORMDETAIL".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPPSDEFormDetailId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            dto.setPSCodeListId(this.getRealPSModelId(t, dto.getPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDRItemId())) {
            dto.setPSDEDRItemId(this.getRealPSModelId(t, dto.getPSDEDRItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFUIModeId())) {
            dto.setPSDEFUIModeId(this.getRealPSModelId(t, dto.getPSDEFUIModeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFIUpdateId())) {
            dto.setPSDEFIUpdateId(this.getRealPSModelId(t, dto.getPSDEFIUpdateId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            dto.setPSDEFormId(this.getRealPSModelId(t, dto.getPSDEFormId()).replace("/", "."));
        }
        if ("PSDEFORM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEFormId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormRFId())) {
            dto.setPSDEFormRFId(this.getRealPSModelId(t, dto.getPSDEFormRFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFSFItemId())) {
            dto.setPSDEFSFItemId(this.getRealPSModelId(t, dto.getPSDEFSFItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            dto.setPSDELogicId(this.getRealPSModelId(t, dto.getPSDELogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            dto.setPSDEUAGroupId(this.getRealPSModelId(t, dto.getPSDEUAGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            dto.setPSDEUIActionId(this.getRealPSModelId(t, dto.getPSDEUIActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCounterId())) {
            dto.setPSSysCounterId(this.getRealPSModelId(t, dto.getPSSysCounterId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            dto.setPSSysCssId(this.getRealPSModelId(t, dto.getPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDictCatId())) {
            dto.setPSSysDictCatId(this.getRealPSModelId(t, dto.getPSSysDictCatId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysResourceId())) {
            dto.setPSSysResourceId(this.getRealPSModelId(t, dto.getPSSysResourceId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEACModeId())) {
            dto.setRefPSDEACModeId(this.getRealPSModelId(t, dto.getRefPSDEACModeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEDataSetId())) {
            dto.setRefPSDEDataSetId(this.getRealPSModelId(t, dto.getRefPSDEDataSetId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEFormDetailId())) {
            dto.setRefPSDEFormDetailId(this.getRealPSModelId(t, dto.getRefPSDEFormDetailId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEId())) {
            dto.setRefPSDEId(this.getRealPSModelId(t, dto.getRefPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSDERId())) {
            dto.setRefPSDERId(this.getRealPSModelId(t, dto.getRefPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUCPSSysPFPluginId())) {
            dto.setUCPSSysPFPluginId(this.getRealPSModelId(t, dto.getUCPSSysPFPluginId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getItemPSACHandlerId())) {
            linkDTO = (PSACHandlerDTO)PSModelServiceUtil.getInstance().getPSACHandlerService().getDTO(dto.getItemPSACHandlerId());
            dto.setItemPSACHandlerName(((PSACHandlerDTO)linkDTO).getPSACHandlerName());
        } else {
            dto.setItemPSACHandlerName(null);
        }
        if (StringUtils.hasLength((String)dto.getLabelPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getLabelPSSysCssId());
            dto.setLabelPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setLabelPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getLinkPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getLinkPSDEViewId());
            dto.setLinkPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setLinkPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getMDPSDEDataViewId())) {
            linkDTO = (PSDEDataViewDTO)PSModelServiceUtil.getInstance().getPSDEDataViewService().getDTO(dto.getMDPSDEDataViewId());
            dto.setMDPSDEDataViewName(((PSDEDataViewDTO)linkDTO).getPSDEDataViewName());
        } else {
            dto.setMDPSDEDataViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getMDPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getMDPSDEFormId());
            dto.setMDPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setMDPSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getMDPSDEGridId())) {
            linkDTO = (PSDEGridDTO)PSModelServiceUtil.getInstance().getPSDEGridService().getDTO(dto.getMDPSDEGridId());
            dto.setMDPSDEGridName(((PSDEGridDTO)linkDTO).getPSDEGridName());
        } else {
            dto.setMDPSDEGridName(null);
        }
        if (StringUtils.hasLength((String)dto.getMDPSDEListId())) {
            linkDTO = (PSDEListDTO)PSModelServiceUtil.getInstance().getPSDEListService().getDTO(dto.getMDPSDEListId());
            dto.setMDPSDEListName(((PSDEListDTO)linkDTO).getPSDEListName());
        } else {
            dto.setMDPSDEListName(null);
        }
        if (StringUtils.hasLength((String)dto.getPHPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getPHPSLanResId());
            dto.setPHPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setPHPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPickupPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getPickupPSDEViewId());
            dto.setPickupPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setPickupPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPPSDEFormDetailId())) {
            linkDTO = (PSDEFormDetailDTO)PSModelServiceUtil.getInstance().getPSDEFormDetailService().getDTO(dto.getPPSDEFormDetailId(), true);
            if (linkDTO != null) {
                dto.setPLayoutMode(((PSDEFormDetailDTO)linkDTO).getLayoutMode());
                dto.setPPSDEFormDetailName(((PSDEFormDetailDTO)linkDTO).getPSDEFormDetailName());
            }
        } else {
            dto.setPLayoutMode(null);
            dto.setPPSDEFormDetailName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getPSCodeListId());
            dto.setPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setPSCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDRItemId())) {
            linkDTO = (PSDEDRItemDTO)PSModelServiceUtil.getInstance().getPSDEDRItemService().getDTO(dto.getPSDEDRItemId());
            dto.setPSDEDRItemName(((PSDEDRItemDTO)linkDTO).getPSDEDRItemName());
        } else {
            dto.setPSDEDRItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFUIModeId())) {
            linkDTO = (PSDEFUIModeDTO)PSModelServiceUtil.getInstance().getPSDEFUIModeService().getDTO(dto.getPSDEFUIModeId());
            dto.setPSDEFUIModeName(((PSDEFUIModeDTO)linkDTO).getPSDEFUIModeName());
        } else {
            dto.setPSDEFUIModeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFIUpdateId())) {
            linkDTO = (PSDEFIUpdateDTO)PSModelServiceUtil.getInstance().getPSDEFIUpdateService().getDTO(dto.getPSDEFIUpdateId());
            dto.setPSDEFIUpdateName(((PSDEFIUpdateDTO)linkDTO).getPSDEFIUpdateName());
        } else {
            dto.setPSDEFIUpdateName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getPSDEFormId());
            dto.setFormType(((PSDEFormDTO)linkDTO).getFormType());
            dto.setMobFlag(((PSDEFormDTO)linkDTO).getMobFlag());
            dto.setPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
            dto.setPSDEId(((PSDEFormDTO)linkDTO).getPSDEId());
        } else {
            dto.setFormType(null);
            dto.setMobFlag(null);
            dto.setPSDEFormName(null);
            dto.setPSDEId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormRFId())) {
            linkDTO = (PSDEFormRFDTO)PSModelServiceUtil.getInstance().getPSDEFormRFService().getDTO(dto.getPSDEFormRFId());
            dto.setPSDEFormRFName(((PSDEFormRFDTO)linkDTO).getPSDEFormRFName());
            dto.setRefPSDEFormId(((PSDEFormRFDTO)linkDTO).getMinorPSDEFormId());
        } else {
            dto.setPSDEFormRFName(null);
            dto.setRefPSDEFormId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFSFItemId())) {
            linkDTO = (PSDEFSFItemDTO)PSModelServiceUtil.getInstance().getPSDEFSFItemService().getDTO(dto.getPSDEFSFItemId());
            dto.setPSDEFSFItemName(((PSDEFSFItemDTO)linkDTO).getPSDEFSFItemName());
        } else {
            dto.setPSDEFSFItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getPSDELogicId());
            dto.setPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setPSDELogicName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysDictCatId())) {
            linkDTO = (PSSysDictCatDTO)PSModelServiceUtil.getInstance().getPSSysDictCatService().getDTO(dto.getPSSysDictCatId());
            dto.setPSSysDictCatName(((PSSysDictCatDTO)linkDTO).getPSSysDictCatName());
        } else {
            dto.setPSSysDictCatName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysResourceId())) {
            linkDTO = (PSSysResourceDTO)PSModelServiceUtil.getInstance().getPSSysResourceService().getDTO(dto.getPSSysResourceId());
            dto.setPSSysResourceName(((PSSysResourceDTO)linkDTO).getPSSysResourceName());
        } else {
            dto.setPSSysResourceName(null);
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
        if (StringUtils.hasLength((String)dto.getRefPSDEFormDetailId())) {
            linkDTO = (PSDEFormDetailDTO)PSModelServiceUtil.getInstance().getPSDEFormDetailService().getDTO(dto.getRefPSDEFormDetailId(), true);
            if (linkDTO != null) {
                dto.setRefPSDEFormDetailName(((PSDEFormDetailDTO)linkDTO).getPSDEFormDetailName());
            }
        } else {
            dto.setRefPSDEFormDetailName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getRefPSDEId());
            dto.setRefPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setRefPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getRefPSDERId());
            dto.setRefPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setRefPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getUCPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getUCPSSysPFPluginId());
            dto.setUCPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setUCPSSysPFPluginName(null);
        }
        List<PSModelBase> list = PSModelServiceUtil.getInstance().getPSDEFormDetailService().listByPSDEFormDetail(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDEFormDetailDTO> psdeformdetails = new ArrayList<PSDEFormDetailDTO>();
            for (PSDEFormDetail pSDEFormDetail : list) {
                dstItem = (PSDEFormDetailDTO)PSModelServiceUtil.getInstance().getPSDEFormDetailService().toDTO(pSDEFormDetail);
                psdeformdetails.add((PSDEFormDetailDTO)dstItem);
            }
            dto.setPsdeformdetails(psdeformdetails);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSDEFDLogicService().listByPSDEFormDetail(t)) != null && list.size() > 0) {
            ArrayList<PSDEFDLogicDTO> psdefdlogics = new ArrayList<PSDEFDLogicDTO>();
            for (PSDEFDLogic pSDEFDLogic : list) {
                dstItem = (PSDEFDLogicDTO)PSModelServiceUtil.getInstance().getPSDEFDLogicService().toDTO(pSDEFDLogic);
                psdefdlogics.add((PSDEFDLogicDTO)dstItem);
            }
            dto.setPsdefdlogics(psdefdlogics);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEFORMDETAIL";
    }

    @Override
    public PSDEFormDetail createDomain() {
        return new PSDEFormDetail();
    }

    @Override
    public PSDEFormDetailDTO createDTO() {
        return new PSDEFormDetailDTO();
    }
}

