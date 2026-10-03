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
import net.ibizsys.modelapi.domain.PSSysDBColumn;
import net.ibizsys.modelapi.domain.PSSysDBTable;
import net.ibizsys.modelapi.dto.PSSysDBColumnDTO;
import net.ibizsys.modelapi.dto.PSSysDBTableDTO;
import net.ibizsys.modelapi.service.IPSSysDBColumnService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysDBColumnServiceImpl
extends PSModelServiceImplBase<PSSysDBColumn, PSSysDBColumnDTO>
implements IPSSysDBColumnService {
    private static final Log log = LogFactory.getLog(PSSysDBColumnServiceImpl.class);

    @Override
    public List<PSSysDBColumn> listByPSSysDBTable(PSSysDBTable parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysDBColumn get(PSSysDBTable parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysDBColumn> list = this.listByPSSysDBTable(parent);
        if (list != null) {
            for (PSSysDBColumn item : list) {
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
    public List<PSSysDBColumnDTO> listDTOByPSSysDBTable(String strParentKey) throws Exception {
        PSSysDBTable pssysdbtable = (PSSysDBTable)PSModelServiceUtil.getInstance().getPSSysDBTableService().get(strParentKey);
        List<PSSysDBColumn> list = this.listByPSSysDBTable(pssysdbtable);
        if (list != null) {
            ArrayList<PSSysDBColumnDTO> dtoList = new ArrayList<PSSysDBColumnDTO>();
            for (PSSysDBColumn item : list) {
                PSSysDBColumnDTO dto = (PSSysDBColumnDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysDBColumn> onListAll() throws Exception {
        ArrayList<PSSysDBColumn> list = new ArrayList<PSSysDBColumn>();
        List<PSSysDBTable> pssysdbtables = PSModelServiceUtil.getInstance().getPSSysDBTableService().listAll();
        if (pssysdbtables != null) {
            for (PSSysDBTable parent : pssysdbtables) {
                List<PSSysDBColumn> items = this.listByPSSysDBTable(parent);
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
    protected PSSysDBColumn onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysDBColumn item;
        PSSysDBTable pssysdbtable = (PSSysDBTable)PSModelServiceUtil.getInstance().getPSSysDBTableService().get(strParentKey, true);
        if (pssysdbtable != null && (item = this.get(pssysdbtable, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysDBColumn)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysDBColumnDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysDBTableId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysDBTableService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysDBColumn et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysDBColumnName())) {
            return et.getPSSysDBColumnName();
        }
        if (StringUtils.hasLength((String)et.getPSSysDBColumnName())) {
            return et.getPSSysDBColumnName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysDBColumnDTO dto, PSSysDBColumn t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysDBColumnId(t.getId().replace("/", "."));
        }
        if (t.getAllowEmpty() != null || !bIgnoreNull) {
            dto.setAllowEmpty(t.getAllowEmpty());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getCodeName2() != null || !bIgnoreNull) {
            dto.setCodeName2(t.getCodeName2());
        }
        if (t.getColDesc() != null || !bIgnoreNull) {
            dto.setColDesc(t.getColDesc());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCreateSql() != null || !bIgnoreNull) {
            dto.setCreateSql(t.getCreateSql());
        }
        if (t.getDataType() != null || !bIgnoreNull) {
            dto.setDataType(t.getDataType());
        }
        if (t.getDefaultValue() != null || !bIgnoreNull) {
            dto.setDefaultValue(t.getDefaultValue());
        }
        if (t.getDropSql() != null || !bIgnoreNull) {
            dto.setDropSql(t.getDropSql());
        }
        if (t.getFKey() != null || !bIgnoreNull) {
            dto.setFKey(t.getFKey());
        }
        if (t.getIdentityMode() != null || !bIgnoreNull) {
            dto.setIdentityMode(t.getIdentityMode());
        }
        if (t.getLength() != null || !bIgnoreNull) {
            dto.setLength(t.getLength());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPKey() != null || !bIgnoreNull) {
            dto.setPKey(t.getPKey());
        }
        if (t.getPrecision2() != null || !bIgnoreNull) {
            dto.setPrecision2(t.getPrecision2());
        }
        if (t.getPSSysDBColumnName() != null || !bIgnoreNull) {
            dto.setPSSysDBColumnName(t.getPSSysDBColumnName());
        }
        if (t.getPSSysDBSchemeId() != null || !bIgnoreNull) {
            dto.setPSSysDBSchemeId(t.getPSSysDBSchemeId());
        }
        if (t.getPSSysDBTableId() != null || !bIgnoreNull) {
            dto.setPSSysDBTableId(t.getPSSysDBTableId());
        }
        if (t.getPSSysDBTableName() != null || !bIgnoreNull) {
            dto.setPSSysDBTableName(t.getPSSysDBTableName());
        }
        if (t.getRefPSSysDBColumnId() != null || !bIgnoreNull) {
            dto.setRefPSSysDBColumnId(t.getRefPSSysDBColumnId());
        }
        if (t.getRefPSSysDBColumnName() != null || !bIgnoreNull) {
            dto.setRefPSSysDBColumnName(t.getRefPSSysDBColumnName());
        }
        if (t.getRefPSSysDBTableId() != null || !bIgnoreNull) {
            dto.setRefPSSysDBTableId(t.getRefPSSysDBTableId());
        }
        if (t.getRefPSSysDBTableName() != null || !bIgnoreNull) {
            dto.setRefPSSysDBTableName(t.getRefPSSysDBTableName());
        }
        if (t.getStdDataType() != null || !bIgnoreNull) {
            dto.setStdDataType(t.getStdDataType());
        }
        if (t.getUnsignedMode() != null || !bIgnoreNull) {
            dto.setUnsignedMode(t.getUnsignedMode());
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
        if (StringUtils.hasLength((String)dto.getPSSysDBTableId())) {
            dto.setPSSysDBTableId(this.getRealPSModelId(t, dto.getPSSysDBTableId()).replace("/", "."));
        }
        if ("PSSYSDBTABLE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysDBTableId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSSysDBColumnId())) {
            dto.setRefPSSysDBColumnId(this.getRealPSModelId(t, dto.getRefPSSysDBColumnId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSSysDBTableId())) {
            dto.setRefPSSysDBTableId(this.getRealPSModelId(t, dto.getRefPSSysDBTableId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDBTableId())) {
            linkDTO = (PSSysDBTableDTO)PSModelServiceUtil.getInstance().getPSSysDBTableService().getDTO(dto.getPSSysDBTableId());
            dto.setPSSysDBSchemeId(((PSSysDBTableDTO)linkDTO).getPSSysDBSchemeId());
            dto.setPSSysDBTableName(((PSSysDBTableDTO)linkDTO).getPSSysDBTableName());
        } else {
            dto.setPSSysDBSchemeId(null);
            dto.setPSSysDBTableName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSSysDBColumnId())) {
            linkDTO = (PSSysDBColumnDTO)PSModelServiceUtil.getInstance().getPSSysDBColumnService().getDTO(dto.getRefPSSysDBColumnId(), true);
            if (linkDTO != null) {
                dto.setRefPSSysDBColumnName(((PSSysDBColumnDTO)linkDTO).getPSSysDBColumnName());
            }
        } else {
            dto.setRefPSSysDBColumnName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSSysDBTableId())) {
            linkDTO = (PSSysDBTableDTO)PSModelServiceUtil.getInstance().getPSSysDBTableService().getDTO(dto.getRefPSSysDBTableId(), true);
            if (linkDTO != null) {
                dto.setRefPSSysDBTableName(((PSSysDBTableDTO)linkDTO).getPSSysDBTableName());
            }
        } else {
            dto.setRefPSSysDBTableName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSDBCOLUMN";
    }

    @Override
    public PSSysDBColumn createDomain() {
        return new PSSysDBColumn();
    }

    @Override
    public PSSysDBColumnDTO createDTO() {
        return new PSSysDBColumnDTO();
    }
}

