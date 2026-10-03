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
import net.ibizsys.modelapi.domain.PSSysBICube;
import net.ibizsys.modelapi.domain.PSSysBICubeMeasure;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSSysBICubeDTO;
import net.ibizsys.modelapi.dto.PSSysBICubeMeasureDTO;
import net.ibizsys.modelapi.dto.PSThresholdGroupDTO;
import net.ibizsys.modelapi.service.IPSSysBICubeMeasureService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysBICubeMeasureServiceImpl
extends PSModelServiceImplBase<PSSysBICubeMeasure, PSSysBICubeMeasureDTO>
implements IPSSysBICubeMeasureService {
    private static final Log log = LogFactory.getLog(PSSysBICubeMeasureServiceImpl.class);

    @Override
    public List<PSSysBICubeMeasure> listByPSSysBICube(PSSysBICube parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysBICubeMeasure get(PSSysBICube parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysBICubeMeasure> list = this.listByPSSysBICube(parent);
        if (list != null) {
            for (PSSysBICubeMeasure item : list) {
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
    public List<PSSysBICubeMeasureDTO> listDTOByPSSysBICube(String strParentKey) throws Exception {
        PSSysBICube pssysbicube = (PSSysBICube)PSModelServiceUtil.getInstance().getPSSysBICubeService().get(strParentKey);
        List<PSSysBICubeMeasure> list = this.listByPSSysBICube(pssysbicube);
        if (list != null) {
            ArrayList<PSSysBICubeMeasureDTO> dtoList = new ArrayList<PSSysBICubeMeasureDTO>();
            for (PSSysBICubeMeasure item : list) {
                PSSysBICubeMeasureDTO dto = (PSSysBICubeMeasureDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysBICubeMeasure> onListAll() throws Exception {
        ArrayList<PSSysBICubeMeasure> list = new ArrayList<PSSysBICubeMeasure>();
        List<PSSysBICube> pssysbicubes = PSModelServiceUtil.getInstance().getPSSysBICubeService().listAll();
        if (pssysbicubes != null) {
            for (PSSysBICube parent : pssysbicubes) {
                List<PSSysBICubeMeasure> items = this.listByPSSysBICube(parent);
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
    protected PSSysBICubeMeasure onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysBICubeMeasure item;
        PSSysBICube pssysbicube = (PSSysBICube)PSModelServiceUtil.getInstance().getPSSysBICubeService().get(strParentKey, true);
        if (pssysbicube != null && (item = this.get(pssysbicube, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysBICubeMeasure)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysBICubeMeasureDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysBICubeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysBICubeService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysBICubeMeasure et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSSysBICubeMeasureName())) {
            return et.getPSSysBICubeMeasureName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysBICubeMeasureDTO dto, PSSysBICubeMeasure t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysBICubeMeasureId(t.getId().replace("/", "."));
        }
        if (t.getBICubeMeasureTag() != null || !bIgnoreNull) {
            dto.setBICubeMeasureTag(t.getBICubeMeasureTag());
        }
        if (t.getBICubeMeasureTag2() != null || !bIgnoreNull) {
            dto.setBICubeMeasureTag2(t.getBICubeMeasureTag2());
        }
        if (t.getBIMeasureType() != null || !bIgnoreNull) {
            dto.setBIMeasureType(t.getBIMeasureType());
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
        if (t.getHiddenDataItem() != null || !bIgnoreNull) {
            dto.setHiddenDataItem(t.getHiddenDataItem());
        }
        if (t.getMeasureFormula() != null || !bIgnoreNull) {
            dto.setMeasureFormula(t.getMeasureFormula());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDEFId() != null || !bIgnoreNull) {
            dto.setPSDEFId(t.getPSDEFId());
        }
        if (t.getPSDEFName() != null || !bIgnoreNull) {
            dto.setPSDEFName(t.getPSDEFName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSSysBICubeId() != null || !bIgnoreNull) {
            dto.setPSSysBICubeId(t.getPSSysBICubeId());
        }
        if (t.getPSSysBICubeMeasureName() != null || !bIgnoreNull) {
            dto.setPSSysBICubeMeasureName(t.getPSSysBICubeMeasureName());
        }
        if (t.getPSSysBICubeName() != null || !bIgnoreNull) {
            dto.setPSSysBICubeName(t.getPSSysBICubeName());
        }
        if (t.getPSSysBISchemeId() != null || !bIgnoreNull) {
            dto.setPSSysBISchemeId(t.getPSSysBISchemeId());
        }
        if (t.getPSThresholdGroupId() != null || !bIgnoreNull) {
            dto.setPSThresholdGroupId(t.getPSThresholdGroupId());
        }
        if (t.getPSThresholdGroupName() != null || !bIgnoreNull) {
            dto.setPSThresholdGroupName(t.getPSThresholdGroupName());
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
        if (t.getValueFormat() != null || !bIgnoreNull) {
            dto.setValueFormat(t.getValueFormat());
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBICubeId())) {
            dto.setPSSysBICubeId(this.getRealPSModelId(t, dto.getPSSysBICubeId()).replace("/", "."));
        }
        if ("PSSYSBICUBE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysBICubeId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSThresholdGroupId())) {
            dto.setPSThresholdGroupId(this.getRealPSModelId(t, dto.getPSThresholdGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBICubeId())) {
            linkDTO = (PSSysBICubeDTO)PSModelServiceUtil.getInstance().getPSSysBICubeService().getDTO(dto.getPSSysBICubeId());
            dto.setPSDEId(((PSSysBICubeDTO)linkDTO).getPSDEId());
            dto.setPSSysBICubeName(((PSSysBICubeDTO)linkDTO).getPSSysBICubeName());
            dto.setPSSysBISchemeId(((PSSysBICubeDTO)linkDTO).getPSSysBISchemeId());
        } else {
            dto.setPSDEId(null);
            dto.setPSSysBICubeName(null);
            dto.setPSSysBISchemeId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSThresholdGroupId())) {
            linkDTO = (PSThresholdGroupDTO)PSModelServiceUtil.getInstance().getPSThresholdGroupService().getDTO(dto.getPSThresholdGroupId());
            dto.setPSThresholdGroupName(((PSThresholdGroupDTO)linkDTO).getPSThresholdGroupName());
        } else {
            dto.setPSThresholdGroupName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSBICUBEMEASURE";
    }

    @Override
    public PSSysBICubeMeasure createDomain() {
        return new PSSysBICubeMeasure();
    }

    @Override
    public PSSysBICubeMeasureDTO createDTO() {
        return new PSSysBICubeMeasureDTO();
    }
}

