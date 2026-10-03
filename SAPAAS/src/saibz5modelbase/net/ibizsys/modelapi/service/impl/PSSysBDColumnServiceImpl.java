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
import net.ibizsys.modelapi.domain.PSSysBDColumn;
import net.ibizsys.modelapi.domain.PSSysBDTable;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysBDColSetDTO;
import net.ibizsys.modelapi.dto.PSSysBDColumnDTO;
import net.ibizsys.modelapi.dto.PSSysBDTableDEDTO;
import net.ibizsys.modelapi.dto.PSSysBDTableDTO;
import net.ibizsys.modelapi.service.IPSSysBDColumnService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysBDColumnServiceImpl
extends PSModelServiceImplBase<PSSysBDColumn, PSSysBDColumnDTO>
implements IPSSysBDColumnService {
    private static final Log log = LogFactory.getLog(PSSysBDColumnServiceImpl.class);

    @Override
    public List<PSSysBDColumn> listByPSSysBDTable(PSSysBDTable parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysBDColumn get(PSSysBDTable parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysBDColumn> list = this.listByPSSysBDTable(parent);
        if (list != null) {
            for (PSSysBDColumn item : list) {
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
    public List<PSSysBDColumnDTO> listDTOByPSSysBDTable(String strParentKey) throws Exception {
        PSSysBDTable pssysbdtable = (PSSysBDTable)PSModelServiceUtil.getInstance().getPSSysBDTableService().get(strParentKey);
        List<PSSysBDColumn> list = this.listByPSSysBDTable(pssysbdtable);
        if (list != null) {
            ArrayList<PSSysBDColumnDTO> dtoList = new ArrayList<PSSysBDColumnDTO>();
            for (PSSysBDColumn item : list) {
                PSSysBDColumnDTO dto = (PSSysBDColumnDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysBDColumn> onListAll() throws Exception {
        ArrayList<PSSysBDColumn> list = new ArrayList<PSSysBDColumn>();
        List<PSSysBDTable> pssysbdtables = PSModelServiceUtil.getInstance().getPSSysBDTableService().listAll();
        if (pssysbdtables != null) {
            for (PSSysBDTable parent : pssysbdtables) {
                List<PSSysBDColumn> items = this.listByPSSysBDTable(parent);
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
    protected PSSysBDColumn onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysBDColumn item;
        PSSysBDTable pssysbdtable = (PSSysBDTable)PSModelServiceUtil.getInstance().getPSSysBDTableService().get(strParentKey, true);
        if (pssysbdtable != null && (item = this.get(pssysbdtable, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysBDColumn)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysBDColumnDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysBDTableId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysBDTableService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysBDColumn et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysBDColumnName())) {
            return et.getPSSysBDColumnName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysBDColumnDTO dto, PSSysBDColumn t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysBDColumnId(t.getId().replace("/", "."));
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
        if (t.getFullColName() != null || !bIgnoreNull) {
            dto.setFullColName(t.getFullColName());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
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
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSSysBDColSetId() != null || !bIgnoreNull) {
            dto.setPSSysBDColSetId(t.getPSSysBDColSetId());
        }
        if (t.getPSSysBDColSetName() != null || !bIgnoreNull) {
            dto.setPSSysBDColSetName(t.getPSSysBDColSetName());
        }
        if (t.getPSSysBDColumnName() != null || !bIgnoreNull) {
            dto.setPSSysBDColumnName(t.getPSSysBDColumnName());
        }
        if (t.getPSSysBDTableDEId() != null || !bIgnoreNull) {
            dto.setPSSysBDTableDEId(t.getPSSysBDTableDEId());
        }
        if (t.getPSSysBDTableDEName() != null || !bIgnoreNull) {
            dto.setPSSysBDTableDEName(t.getPSSysBDTableDEName());
        }
        if (t.getPSSysBDTableId() != null || !bIgnoreNull) {
            dto.setPSSysBDTableId(t.getPSSysBDTableId());
        }
        if (t.getPSSysBDTableName() != null || !bIgnoreNull) {
            dto.setPSSysBDTableName(t.getPSSysBDTableName());
        }
        if (t.getUnionKeyValue() != null || !bIgnoreNull) {
            dto.setUnionKeyValue(t.getUnionKeyValue());
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
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDColSetId())) {
            dto.setPSSysBDColSetId(this.getRealPSModelId(t, dto.getPSSysBDColSetId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDTableDEId())) {
            dto.setPSSysBDTableDEId(this.getRealPSModelId(t, dto.getPSSysBDTableDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDTableId())) {
            dto.setPSSysBDTableId(this.getRealPSModelId(t, dto.getPSSysBDTableId()).replace("/", "."));
        }
        if ("PSSYSBDTABLE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysBDTableId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDColSetId())) {
            linkDTO = (PSSysBDColSetDTO)PSModelServiceUtil.getInstance().getPSSysBDColSetService().getDTO(dto.getPSSysBDColSetId());
            dto.setPSSysBDColSetName(((PSSysBDColSetDTO)linkDTO).getPSSysBDColSetName());
        } else {
            dto.setPSSysBDColSetName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDTableDEId())) {
            linkDTO = (PSSysBDTableDEDTO)PSModelServiceUtil.getInstance().getPSSysBDTableDEService().getDTO(dto.getPSSysBDTableDEId());
            dto.setPSSysBDTableDEName(((PSSysBDTableDEDTO)linkDTO).getPSSysBDTableDEName());
        } else {
            dto.setPSSysBDTableDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDTableId())) {
            linkDTO = (PSSysBDTableDTO)PSModelServiceUtil.getInstance().getPSSysBDTableService().getDTO(dto.getPSSysBDTableId());
            dto.setPSSysBDTableName(((PSSysBDTableDTO)linkDTO).getPSSysBDTableName());
        } else {
            dto.setPSSysBDTableName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSBDCOLUMN";
    }

    @Override
    public PSSysBDColumn createDomain() {
        return new PSSysBDColumn();
    }

    @Override
    public PSSysBDColumnDTO createDTO() {
        return new PSSysBDColumnDTO();
    }
}

