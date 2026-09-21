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
import net.ibizsys.modelapi.domain.PSDEChart;
import net.ibizsys.modelapi.domain.PSDEChartParam;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSDEChartAxesDTO;
import net.ibizsys.modelapi.dto.PSDEChartDTO;
import net.ibizsys.modelapi.dto.PSDEChartParamDTO;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.service.IPSDEChartParamService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEChartParamServiceImpl
extends PSModelServiceImplBase<PSDEChartParam, PSDEChartParamDTO>
implements IPSDEChartParamService {
    private static final Log log = LogFactory.getLog(PSDEChartParamServiceImpl.class);

    @Override
    public List<PSDEChartParam> listByPSDEChart(PSDEChart parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEChartParam get(PSDEChart parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEChartParam> list = this.listByPSDEChart(parent);
        if (list != null) {
            for (PSDEChartParam item : list) {
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
    public List<PSDEChartParamDTO> listDTOByPSDEChart(String strParentKey) throws Exception {
        PSDEChart psdechart = (PSDEChart)PSModelServiceUtil.getInstance().getPSDEChartService().get(strParentKey);
        List<PSDEChartParam> list = this.listByPSDEChart(psdechart);
        if (list != null) {
            ArrayList<PSDEChartParamDTO> dtoList = new ArrayList<PSDEChartParamDTO>();
            for (PSDEChartParam item : list) {
                PSDEChartParamDTO dto = (PSDEChartParamDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEChartParam> onListAll() throws Exception {
        ArrayList<PSDEChartParam> list = new ArrayList<PSDEChartParam>();
        List psdecharts = PSModelServiceUtil.getInstance().getPSDEChartService().listAll();
        if (psdecharts != null) {
            for (PSDEChart parent : psdecharts) {
                List<PSDEChartParam> items = this.listByPSDEChart(parent);
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
    protected PSDEChartParam onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEChartParam item;
        PSDEChart psdechart = (PSDEChart)PSModelServiceUtil.getInstance().getPSDEChartService().get(strParentKey, true);
        if (psdechart != null && (item = this.get(psdechart, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEChartParam)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEChartParamDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEChartId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEChartService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEChartParam et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEChartParamName())) {
            return et.getPSDEChartParamName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEChartParamDTO dto, PSDEChartParam t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEChartParamId(t.getId().replace("/", "."));
        }
        if (t.getBarCategoryGap() != null || !bIgnoreNull) {
            dto.setBarCategoryGap(t.getBarCategoryGap());
        }
        if (t.getBarGap() != null || !bIgnoreNull) {
            dto.setBarGap(t.getBarGap());
        }
        if (t.getBarMaxWidth() != null || !bIgnoreNull) {
            dto.setBarMaxWidth(t.getBarMaxWidth());
        }
        if (t.getBarMinHeight() != null || !bIgnoreNull) {
            dto.setBarMinHeight(t.getBarMinHeight());
        }
        if (t.getBarMinWidth() != null || !bIgnoreNull) {
            dto.setBarMinWidth(t.getBarMinWidth());
        }
        if (t.getBarWidth() != null || !bIgnoreNull) {
            dto.setBarWidth(t.getBarWidth());
        }
        if (t.getBottomPos() != null || !bIgnoreNull) {
            dto.setBottomPos(t.getBottomPos());
        }
        if (t.getBoxWidths() != null || !bIgnoreNull) {
            dto.setBoxWidths(t.getBoxWidths());
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
        if (t.getCenter() != null || !bIgnoreNull) {
            dto.setCenter(t.getCenter());
        }
        if (t.getChartType() != null || !bIgnoreNull) {
            dto.setChartType(t.getChartType());
        }
        if (t.getClockWise() != null || !bIgnoreNull) {
            dto.setClockWise(t.getClockWise());
        }
        if (t.getCoordinateSystem() != null || !bIgnoreNull) {
            dto.setCoordinateSystem(t.getCoordinateSystem());
        }
        if (t.getCoordinateSystemId() != null || !bIgnoreNull) {
            dto.setCoordinateSystemId(t.getCoordinateSystemId());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCSPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setCSPSSysDynaModelId(t.getCSPSSysDynaModelId());
        }
        if (t.getCSPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setCSPSSysDynaModelName(t.getCSPSSysDynaModelName());
        }
        if (t.getCSPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setCSPSSysPFPluginId(t.getCSPSSysPFPluginId());
        }
        if (t.getCSPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setCSPSSysPFPluginName(t.getCSPSSysPFPluginName());
        }
        if (t.getDataField() != null || !bIgnoreNull) {
            dto.setDataField(t.getDataField());
        }
        if (t.getDynaClass() != null || !bIgnoreNull) {
            dto.setDynaClass(t.getDynaClass());
        }
        if (t.getEndAngle() != null || !bIgnoreNull) {
            dto.setEndAngle(t.getEndAngle());
        }
        if (t.getExtField() != null || !bIgnoreNull) {
            dto.setExtField(t.getExtField());
        }
        if (t.getExtField2() != null || !bIgnoreNull) {
            dto.setExtField2(t.getExtField2());
        }
        if (t.getExtField3() != null || !bIgnoreNull) {
            dto.setExtField3(t.getExtField3());
        }
        if (t.getExtField4() != null || !bIgnoreNull) {
            dto.setExtField4(t.getExtField4());
        }
        if (t.getFunnelAlign() != null || !bIgnoreNull) {
            dto.setFunnelAlign(t.getFunnelAlign());
        }
        if (t.getHeight() != null || !bIgnoreNull) {
            dto.setHeight(t.getHeight());
        }
        if (t.getLeftPos() != null || !bIgnoreNull) {
            dto.setLeftPos(t.getLeftPos());
        }
        if (t.getMapType() != null || !bIgnoreNull) {
            dto.setMapType(t.getMapType());
        }
        if (t.getMaxSize() != null || !bIgnoreNull) {
            dto.setMaxSize(t.getMaxSize());
        }
        if (t.getMaxValue() != null || !bIgnoreNull) {
            dto.setMaxValue(t.getMaxValue());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMinAngle() != null || !bIgnoreNull) {
            dto.setMinAngle(t.getMinAngle());
        }
        if (t.getMinShowLabelAngle() != null || !bIgnoreNull) {
            dto.setMinShowLabelAngle(t.getMinShowLabelAngle());
        }
        if (t.getMinSize() != null || !bIgnoreNull) {
            dto.setMinSize(t.getMinSize());
        }
        if (t.getMinValue() != null || !bIgnoreNull) {
            dto.setMinValue(t.getMinValue());
        }
        if (t.getNavViewFilter() != null || !bIgnoreNull) {
            dto.setNavViewFilter(t.getNavViewFilter());
        }
        if (t.getNavViewParam() != null || !bIgnoreNull) {
            dto.setNavViewParam(t.getNavViewParam());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDEChartId() != null || !bIgnoreNull) {
            dto.setPSDEChartId(t.getPSDEChartId());
        }
        if (t.getPSDEChartName() != null || !bIgnoreNull) {
            dto.setPSDEChartName(t.getPSDEChartName());
        }
        if (t.getPSDEChartParamName() != null || !bIgnoreNull) {
            dto.setPSDEChartParamName(t.getPSDEChartParamName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDERId() != null || !bIgnoreNull) {
            dto.setPSDERId(t.getPSDERId());
        }
        if (t.getPSDERName() != null || !bIgnoreNull) {
            dto.setPSDERName(t.getPSDERName());
        }
        if (t.getPSDEViewBaseId() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseId(t.getPSDEViewBaseId());
        }
        if (t.getPSDEViewBaseName() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseName(t.getPSDEViewBaseName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginId(t.getPSSysPFPluginId());
        }
        if (t.getPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginName(t.getPSSysPFPluginName());
        }
        if (t.getRadius() != null || !bIgnoreNull) {
            dto.setRadius(t.getRadius());
        }
        if (t.getRightPos() != null || !bIgnoreNull) {
            dto.setRightPos(t.getRightPos());
        }
        if (t.getRoseType() != null || !bIgnoreNull) {
            dto.setRoseType(t.getRoseType());
        }
        if (t.getSampleData() != null || !bIgnoreNull) {
            dto.setSampleData(t.getSampleData());
        }
        if (t.getSeriesField() != null || !bIgnoreNull) {
            dto.setSeriesField(t.getSeriesField());
        }
        if (t.getSeriesLayoutBy() != null || !bIgnoreNull) {
            dto.setSeriesLayoutBy(t.getSeriesLayoutBy());
        }
        if (t.getSeriesParam() != null || !bIgnoreNull) {
            dto.setSeriesParam(t.getSeriesParam());
        }
        if (t.getSeriesParam10() != null || !bIgnoreNull) {
            dto.setSeriesParam10(t.getSeriesParam10());
        }
        if (t.getSeriesParam11() != null || !bIgnoreNull) {
            dto.setSeriesParam11(t.getSeriesParam11());
        }
        if (t.getSeriesParam12() != null || !bIgnoreNull) {
            dto.setSeriesParam12(t.getSeriesParam12());
        }
        if (t.getSeriesParam2() != null || !bIgnoreNull) {
            dto.setSeriesParam2(t.getSeriesParam2());
        }
        if (t.getSeriesParam3() != null || !bIgnoreNull) {
            dto.setSeriesParam3(t.getSeriesParam3());
        }
        if (t.getSeriesParam4() != null || !bIgnoreNull) {
            dto.setSeriesParam4(t.getSeriesParam4());
        }
        if (t.getSeriesParam5() != null || !bIgnoreNull) {
            dto.setSeriesParam5(t.getSeriesParam5());
        }
        if (t.getSeriesParam6() != null || !bIgnoreNull) {
            dto.setSeriesParam6(t.getSeriesParam6());
        }
        if (t.getSeriesParam7() != null || !bIgnoreNull) {
            dto.setSeriesParam7(t.getSeriesParam7());
        }
        if (t.getSeriesParam8() != null || !bIgnoreNull) {
            dto.setSeriesParam8(t.getSeriesParam8());
        }
        if (t.getSeriesParam9() != null || !bIgnoreNull) {
            dto.setSeriesParam9(t.getSeriesParam9());
        }
        if (t.getSFPSCodeListId() != null || !bIgnoreNull) {
            dto.setSFPSCodeListId(t.getSFPSCodeListId());
        }
        if (t.getSFPSCodeListName() != null || !bIgnoreNull) {
            dto.setSFPSCodeListName(t.getSFPSCodeListName());
        }
        if (t.getSortDir() != null || !bIgnoreNull) {
            dto.setSortDir(t.getSortDir());
        }
        if (t.getSplitNumber() != null || !bIgnoreNull) {
            dto.setSplitNumber(t.getSplitNumber());
        }
        if (t.getStack() != null || !bIgnoreNull) {
            dto.setStack(t.getStack());
        }
        if (t.getStartAngle() != null || !bIgnoreNull) {
            dto.setStartAngle(t.getStartAngle());
        }
        if (t.getStep() != null || !bIgnoreNull) {
            dto.setStep(t.getStep());
        }
        if (t.getTagField() != null || !bIgnoreNull) {
            dto.setTagField(t.getTagField());
        }
        if (t.getTimeGroup() != null || !bIgnoreNull) {
            dto.setTimeGroup(t.getTimeGroup());
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
        if (t.getWidth() != null || !bIgnoreNull) {
            dto.setWidth(t.getWidth());
        }
        if (t.getXField() != null || !bIgnoreNull) {
            dto.setXField(t.getXField());
        }
        if (t.getXFPSCodeListId() != null || !bIgnoreNull) {
            dto.setXFPSCodeListId(t.getXFPSCodeListId());
        }
        if (t.getXFPSCodeListName() != null || !bIgnoreNull) {
            dto.setXFPSCodeListName(t.getXFPSCodeListName());
        }
        if (t.getXPSDEChartAxesId() != null || !bIgnoreNull) {
            dto.setXPSDEChartAxesId(t.getXPSDEChartAxesId());
        }
        if (t.getXPSDEChartAxesName() != null || !bIgnoreNull) {
            dto.setXPSDEChartAxesName(t.getXPSDEChartAxesName());
        }
        if (t.getYField() != null || !bIgnoreNull) {
            dto.setYField(t.getYField());
        }
        if (t.getYPSDEChartAxesId() != null || !bIgnoreNull) {
            dto.setYPSDEChartAxesId(t.getYPSDEChartAxesId());
        }
        if (t.getYPSDEChartAxesName() != null || !bIgnoreNull) {
            dto.setYPSDEChartAxesName(t.getYPSDEChartAxesName());
        }
        if (t.getZField() != null || !bIgnoreNull) {
            dto.setZField(t.getZField());
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            dto.setCapPSLanResId(this.getRealPSModelId(t, dto.getCapPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCSPSSysDynaModelId())) {
            dto.setCSPSSysDynaModelId(this.getRealPSModelId(t, dto.getCSPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCSPSSysPFPluginId())) {
            dto.setCSPSSysPFPluginId(this.getRealPSModelId(t, dto.getCSPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEChartId())) {
            dto.setPSDEChartId(this.getRealPSModelId(t, dto.getPSDEChartId()).replace("/", "."));
        }
        if ("PSDECHART".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEChartId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            dto.setPSDERId(this.getRealPSModelId(t, dto.getPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            dto.setPSDEViewBaseId(this.getRealPSModelId(t, dto.getPSDEViewBaseId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getSFPSCodeListId())) {
            dto.setSFPSCodeListId(this.getRealPSModelId(t, dto.getSFPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getXFPSCodeListId())) {
            dto.setXFPSCodeListId(this.getRealPSModelId(t, dto.getXFPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getXPSDEChartAxesId())) {
            dto.setXPSDEChartAxesId(this.getRealPSModelId(t, dto.getXPSDEChartAxesId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getYPSDEChartAxesId())) {
            dto.setYPSDEChartAxesId(this.getRealPSModelId(t, dto.getYPSDEChartAxesId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getCapPSLanResId());
            dto.setCapPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setCapPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getCSPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getCSPSSysDynaModelId());
            dto.setCSPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setCSPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getCSPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getCSPSSysPFPluginId());
            dto.setCSPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setCSPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEChartId())) {
            linkDTO = (PSDEChartDTO)PSModelServiceUtil.getInstance().getPSDEChartService().getDTO(dto.getPSDEChartId());
            dto.setPSDEChartName(((PSDEChartDTO)linkDTO).getPSDEChartName());
            dto.setPSDEId(((PSDEChartDTO)linkDTO).getPSDEId());
        } else {
            dto.setPSDEChartName(null);
            dto.setPSDEId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getPSDERId());
            dto.setPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getPSDEViewBaseId());
            dto.setPSDEViewBaseName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setPSDEViewBaseName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getPSSysPFPluginId());
            dto.setPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getSFPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getSFPSCodeListId());
            dto.setSFPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setSFPSCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getXFPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getXFPSCodeListId());
            dto.setXFPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setXFPSCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getXPSDEChartAxesId())) {
            linkDTO = (PSDEChartAxesDTO)PSModelServiceUtil.getInstance().getPSDEChartAxesService().getDTO(dto.getXPSDEChartAxesId());
            dto.setXPSDEChartAxesName(((PSDEChartAxesDTO)linkDTO).getPSDEChartAxesName());
        } else {
            dto.setXPSDEChartAxesName(null);
        }
        if (StringUtils.hasLength((String)dto.getYPSDEChartAxesId())) {
            linkDTO = (PSDEChartAxesDTO)PSModelServiceUtil.getInstance().getPSDEChartAxesService().getDTO(dto.getYPSDEChartAxesId());
            dto.setYPSDEChartAxesName(((PSDEChartAxesDTO)linkDTO).getPSDEChartAxesName());
        } else {
            dto.setYPSDEChartAxesName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDECHARTPARAM";
    }

    @Override
    public PSDEChartParam createDomain() {
        return new PSDEChartParam();
    }

    @Override
    public PSDEChartParamDTO createDTO() {
        return new PSDEChartParamDTO();
    }
}

