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
import net.ibizsys.modelapi.domain.PSSysBIAggColumn;
import net.ibizsys.modelapi.domain.PSSysBIAggTable;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSSysBIAggColumnDTO;
import net.ibizsys.modelapi.dto.PSSysBIAggTableDTO;
import net.ibizsys.modelapi.dto.PSSysBICubeDimensionDTO;
import net.ibizsys.modelapi.dto.PSSysBICubeMeasureDTO;
import net.ibizsys.modelapi.service.IPSSysBIAggColumnService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysBIAggColumnServiceImpl
extends PSModelServiceImplBase<PSSysBIAggColumn, PSSysBIAggColumnDTO>
implements IPSSysBIAggColumnService {
    private static final Log log = LogFactory.getLog(PSSysBIAggColumnServiceImpl.class);

    @Override
    public List<PSSysBIAggColumn> listByPSSysBIAggTable(PSSysBIAggTable parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysBIAggColumn get(PSSysBIAggTable parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysBIAggColumn> list = this.listByPSSysBIAggTable(parent);
        if (list != null) {
            for (PSSysBIAggColumn item : list) {
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
    public List<PSSysBIAggColumnDTO> listDTOByPSSysBIAggTable(String strParentKey) throws Exception {
        PSSysBIAggTable pssysbiaggtable = (PSSysBIAggTable)PSModelServiceUtil.getInstance().getPSSysBIAggTableService().get(strParentKey);
        List<PSSysBIAggColumn> list = this.listByPSSysBIAggTable(pssysbiaggtable);
        if (list != null) {
            ArrayList<PSSysBIAggColumnDTO> dtoList = new ArrayList<PSSysBIAggColumnDTO>();
            for (PSSysBIAggColumn item : list) {
                PSSysBIAggColumnDTO dto = (PSSysBIAggColumnDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysBIAggColumn> onListAll() throws Exception {
        ArrayList<PSSysBIAggColumn> list = new ArrayList<PSSysBIAggColumn>();
        List<PSSysBIAggTable> pssysbiaggtables = PSModelServiceUtil.getInstance().getPSSysBIAggTableService().listAll();
        if (pssysbiaggtables != null) {
            for (PSSysBIAggTable parent : pssysbiaggtables) {
                List<PSSysBIAggColumn> items = this.listByPSSysBIAggTable(parent);
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
    protected PSSysBIAggColumn onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysBIAggColumn item;
        PSSysBIAggTable pssysbiaggtable = (PSSysBIAggTable)PSModelServiceUtil.getInstance().getPSSysBIAggTableService().get(strParentKey, true);
        if (pssysbiaggtable != null && (item = this.get(pssysbiaggtable, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysBIAggColumn)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysBIAggColumnDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysBIAggTableId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysBIAggTableService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysBIAggColumn et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSSysBIAggColumnName())) {
            return et.getPSSysBIAggColumnName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysBIAggColumnDTO dto, PSSysBIAggColumn t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysBIAggColumnId(t.getId().replace("/", "."));
        }
        if (t.getBIAggColumnTag() != null || !bIgnoreNull) {
            dto.setBIAggColumnTag(t.getBIAggColumnTag());
        }
        if (t.getBIAggColumnTag2() != null || !bIgnoreNull) {
            dto.setBIAggColumnTag2(t.getBIAggColumnTag2());
        }
        if (t.getBIAggColumnType() != null || !bIgnoreNull) {
            dto.setBIAggColumnType(t.getBIAggColumnType());
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
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
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
        if (t.getPSSysBIAggColumnName() != null || !bIgnoreNull) {
            dto.setPSSysBIAggColumnName(t.getPSSysBIAggColumnName());
        }
        if (t.getPSSysBIAggTableId() != null || !bIgnoreNull) {
            dto.setPSSysBIAggTableId(t.getPSSysBIAggTableId());
        }
        if (t.getPSSysBIAggTableName() != null || !bIgnoreNull) {
            dto.setPSSysBIAggTableName(t.getPSSysBIAggTableName());
        }
        if (t.getPSSysBICubeDimensionId() != null || !bIgnoreNull) {
            dto.setPSSysBICubeDimensionId(t.getPSSysBICubeDimensionId());
        }
        if (t.getPSSysBICubeDimensionName() != null || !bIgnoreNull) {
            dto.setPSSysBICubeDimensionName(t.getPSSysBICubeDimensionName());
        }
        if (t.getPSSysBICubeId() != null || !bIgnoreNull) {
            dto.setPSSysBICubeId(t.getPSSysBICubeId());
        }
        if (t.getPSSysBICubeMeasureId() != null || !bIgnoreNull) {
            dto.setPSSysBICubeMeasureId(t.getPSSysBICubeMeasureId());
        }
        if (t.getPSSysBICubeMeasureName() != null || !bIgnoreNull) {
            dto.setPSSysBICubeMeasureName(t.getPSSysBICubeMeasureName());
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
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBIAggTableId())) {
            dto.setPSSysBIAggTableId(this.getRealPSModelId(t, dto.getPSSysBIAggTableId()).replace("/", "."));
        }
        if ("PSSYSBIAGGTABLE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysBIAggTableId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBICubeDimensionId())) {
            dto.setPSSysBICubeDimensionId(this.getRealPSModelId(t, dto.getPSSysBICubeDimensionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBICubeMeasureId())) {
            dto.setPSSysBICubeMeasureId(this.getRealPSModelId(t, dto.getPSSysBICubeMeasureId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBIAggTableId())) {
            linkDTO = (PSSysBIAggTableDTO)PSModelServiceUtil.getInstance().getPSSysBIAggTableService().getDTO(dto.getPSSysBIAggTableId());
            dto.setPSDEId(((PSSysBIAggTableDTO)linkDTO).getPSDEId());
            dto.setPSSysBIAggTableName(((PSSysBIAggTableDTO)linkDTO).getPSSysBIAggTableName());
            dto.setPSSysBICubeId(((PSSysBIAggTableDTO)linkDTO).getPSSysBICubeId());
        } else {
            dto.setPSDEId(null);
            dto.setPSSysBIAggTableName(null);
            dto.setPSSysBICubeId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBICubeDimensionId())) {
            linkDTO = (PSSysBICubeDimensionDTO)PSModelServiceUtil.getInstance().getPSSysBICubeDimensionService().getDTO(dto.getPSSysBICubeDimensionId());
            dto.setPSSysBICubeDimensionName(((PSSysBICubeDimensionDTO)linkDTO).getPSSysBICubeDimensionName());
        } else {
            dto.setPSSysBICubeDimensionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBICubeMeasureId())) {
            linkDTO = (PSSysBICubeMeasureDTO)PSModelServiceUtil.getInstance().getPSSysBICubeMeasureService().getDTO(dto.getPSSysBICubeMeasureId());
            dto.setPSSysBICubeMeasureName(((PSSysBICubeMeasureDTO)linkDTO).getPSSysBICubeMeasureName());
        } else {
            dto.setPSSysBICubeMeasureName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSBIAGGCOLUMN";
    }

    @Override
    public PSSysBIAggColumn createDomain() {
        return new PSSysBIAggColumn();
    }

    @Override
    public PSSysBIAggColumnDTO createDTO() {
        return new PSSysBIAggColumnDTO();
    }
}

