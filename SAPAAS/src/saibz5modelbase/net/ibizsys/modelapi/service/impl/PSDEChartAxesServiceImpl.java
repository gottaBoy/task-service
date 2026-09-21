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
import net.ibizsys.modelapi.domain.PSDEChartAxes;
import net.ibizsys.modelapi.dto.PSDEChartAxesDTO;
import net.ibizsys.modelapi.dto.PSDEChartDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.service.IPSDEChartAxesService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEChartAxesServiceImpl
extends PSModelServiceImplBase<PSDEChartAxes, PSDEChartAxesDTO>
implements IPSDEChartAxesService {
    private static final Log log = LogFactory.getLog(PSDEChartAxesServiceImpl.class);

    @Override
    public List<PSDEChartAxes> listByPSDEChart(PSDEChart parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEChartAxes get(PSDEChart parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEChartAxes> list = this.listByPSDEChart(parent);
        if (list != null) {
            for (PSDEChartAxes item : list) {
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
    public List<PSDEChartAxesDTO> listDTOByPSDEChart(String strParentKey) throws Exception {
        PSDEChart psdechart = (PSDEChart)PSModelServiceUtil.getInstance().getPSDEChartService().get(strParentKey);
        List<PSDEChartAxes> list = this.listByPSDEChart(psdechart);
        if (list != null) {
            ArrayList<PSDEChartAxesDTO> dtoList = new ArrayList<PSDEChartAxesDTO>();
            for (PSDEChartAxes item : list) {
                PSDEChartAxesDTO dto = (PSDEChartAxesDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEChartAxes> onListAll() throws Exception {
        ArrayList<PSDEChartAxes> list = new ArrayList<PSDEChartAxes>();
        List psdecharts = PSModelServiceUtil.getInstance().getPSDEChartService().listAll();
        if (psdecharts != null) {
            for (PSDEChart parent : psdecharts) {
                List<PSDEChartAxes> items = this.listByPSDEChart(parent);
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
    protected PSDEChartAxes onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEChartAxes item;
        PSDEChart psdechart = (PSDEChart)PSModelServiceUtil.getInstance().getPSDEChartService().get(strParentKey, true);
        if (psdechart != null && (item = this.get(psdechart, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEChartAxes)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEChartAxesDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEChartId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEChartService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEChartAxes et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEChartAxesName())) {
            return et.getPSDEChartAxesName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEChartAxesDTO dto, PSDEChartAxes t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEChartAxesId(t.getId().replace("/", "."));
        }
        if (t.getAxesData() != null || !bIgnoreNull) {
            dto.setAxesData(t.getAxesData());
        }
        if (t.getAxesData2() != null || !bIgnoreNull) {
            dto.setAxesData2(t.getAxesData2());
        }
        if (t.getAxesMaxValue() != null || !bIgnoreNull) {
            dto.setAxesMaxValue(t.getAxesMaxValue());
        }
        if (t.getAxesMinValue() != null || !bIgnoreNull) {
            dto.setAxesMinValue(t.getAxesMinValue());
        }
        if (t.getAxesPos() != null || !bIgnoreNull) {
            dto.setAxesPos(t.getAxesPos());
        }
        if (t.getAxesType() != null || !bIgnoreNull) {
            dto.setAxesType(t.getAxesType());
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
        if (t.getCoordinateSystemId() != null || !bIgnoreNull) {
            dto.setCoordinateSystemId(t.getCoordinateSystemId());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDataShowMode() != null || !bIgnoreNull) {
            dto.setDataShowMode(t.getDataShowMode());
        }
        if (t.getDynaClass() != null || !bIgnoreNull) {
            dto.setDynaClass(t.getDynaClass());
        }
        if (t.getFields() != null || !bIgnoreNull) {
            dto.setFields(t.getFields());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDEChartAxesName() != null || !bIgnoreNull) {
            dto.setPSDEChartAxesName(t.getPSDEChartAxesName());
        }
        if (t.getPSDEChartId() != null || !bIgnoreNull) {
            dto.setPSDEChartId(t.getPSDEChartId());
        }
        if (t.getPSDEChartName() != null || !bIgnoreNull) {
            dto.setPSDEChartName(t.getPSDEChartName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
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
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            dto.setCapPSLanResId(this.getRealPSModelId(t, dto.getCapPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEChartId())) {
            dto.setPSDEChartId(this.getRealPSModelId(t, dto.getPSDEChartId()).replace("/", "."));
        }
        if ("PSDECHART".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEChartId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getCapPSLanResId());
            dto.setCapPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setCapPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEChartId())) {
            linkDTO = (PSDEChartDTO)PSModelServiceUtil.getInstance().getPSDEChartService().getDTO(dto.getPSDEChartId());
            dto.setPSDEChartName(((PSDEChartDTO)linkDTO).getPSDEChartName());
            dto.setPSDEId(((PSDEChartDTO)linkDTO).getPSDEId());
        } else {
            dto.setPSDEChartName(null);
            dto.setPSDEId(null);
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
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDECHARTAXES";
    }

    @Override
    public PSDEChartAxes createDomain() {
        return new PSDEChartAxes();
    }

    @Override
    public PSDEChartAxesDTO createDTO() {
        return new PSDEChartAxesDTO();
    }
}

