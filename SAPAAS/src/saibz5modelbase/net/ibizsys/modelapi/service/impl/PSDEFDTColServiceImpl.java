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
import net.ibizsys.modelapi.domain.PSDEFDTCol;
import net.ibizsys.modelapi.domain.PSDEField;
import net.ibizsys.modelapi.dto.PSDEFDTColDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.service.IPSDEFDTColService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEFDTColServiceImpl
extends PSModelServiceImplBase<PSDEFDTCol, PSDEFDTColDTO>
implements IPSDEFDTColService {
    private static final Log log = LogFactory.getLog(PSDEFDTColServiceImpl.class);

    @Override
    public List<PSDEFDTCol> listByPSDEField(PSDEField parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEFDTCol get(PSDEField parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEFDTCol> list = this.listByPSDEField(parent);
        if (list != null) {
            for (PSDEFDTCol item : list) {
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
    public List<PSDEFDTColDTO> listDTOByPSDEField(String strParentKey) throws Exception {
        PSDEField psdefield = (PSDEField)PSModelServiceUtil.getInstance().getPSDEFieldService().get(strParentKey);
        List<PSDEFDTCol> list = this.listByPSDEField(psdefield);
        if (list != null) {
            ArrayList<PSDEFDTColDTO> dtoList = new ArrayList<PSDEFDTColDTO>();
            for (PSDEFDTCol item : list) {
                PSDEFDTColDTO dto = (PSDEFDTColDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEFDTCol> onListAll() throws Exception {
        ArrayList<PSDEFDTCol> list = new ArrayList<PSDEFDTCol>();
        List psdefields = PSModelServiceUtil.getInstance().getPSDEFieldService().listAll();
        if (psdefields != null) {
            for (PSDEField parent : psdefields) {
                List<PSDEFDTCol> items = this.listByPSDEField(parent);
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
    protected PSDEFDTCol onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEFDTCol item;
        PSDEField psdefield = (PSDEField)PSModelServiceUtil.getInstance().getPSDEFieldService().get(strParentKey, true);
        if (psdefield != null && (item = this.get(psdefield, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEFDTCol)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEFDTColDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEFId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEFieldService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEFDTCol et) throws Exception {
        if (StringUtils.hasLength((String)et.getDBType())) {
            return et.getDBType();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEFDTColDTO dto, PSDEFDTCol t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEFDTColId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCustomDataType() != null || !bIgnoreNull) {
            dto.setCustomDataType(t.getCustomDataType());
        }
        if (t.getDataType() != null || !bIgnoreNull) {
            dto.setDataType(t.getDataType());
        }
        if (t.getDBType() != null || !bIgnoreNull) {
            dto.setDBType(t.getDBType());
        }
        if (t.getDefaultValue() != null || !bIgnoreNull) {
            dto.setDefaultValue(t.getDefaultValue());
        }
        if (t.getFormulaFields() != null || !bIgnoreNull) {
            dto.setFormulaFields(t.getFormulaFields());
        }
        if (t.getFormulaFormat() != null || !bIgnoreNull) {
            dto.setFormulaFormat(t.getFormulaFormat());
        }
        if (t.getLength() != null || !bIgnoreNull) {
            dto.setLength(t.getLength());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getNullValOrder() != null || !bIgnoreNull) {
            dto.setNullValOrder(t.getNullValOrder());
        }
        if (t.getPrecision2() != null || !bIgnoreNull) {
            dto.setPrecision2(t.getPrecision2());
        }
        if (t.getPSDEFDTColName() != null || !bIgnoreNull) {
            dto.setPSDEFDTColName(t.getPSDEFDTColName());
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
        if (t.getTableName() != null || !bIgnoreNull) {
            dto.setTableName(t.getTableName());
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
        if (t.getValueFunc2Fields() != null || !bIgnoreNull) {
            dto.setValueFunc2Fields(t.getValueFunc2Fields());
        }
        if (t.getValueFunc2Format() != null || !bIgnoreNull) {
            dto.setValueFunc2Format(t.getValueFunc2Format());
        }
        if (t.getValueFuncFields() != null || !bIgnoreNull) {
            dto.setValueFuncFields(t.getValueFuncFields());
        }
        if (t.getValueFuncFormat() != null || !bIgnoreNull) {
            dto.setValueFuncFormat(t.getValueFuncFormat());
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if ("PSDEFIELD".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEFId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            PSDEFieldDTO linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setPSDEFName(linkDTO.getPSDEFieldName());
            dto.setPSDEId(linkDTO.getPSDEId());
            dto.setPSDEName(linkDTO.getPSDEName());
            dto.setTableName(linkDTO.getTableName());
        } else {
            dto.setPSDEFName(null);
            dto.setPSDEId(null);
            dto.setPSDEName(null);
            dto.setTableName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSDEFDTCOL";
    }

    @Override
    public PSDEFDTCol createDomain() {
        return new PSDEFDTCol();
    }

    @Override
    public PSDEFDTColDTO createDTO() {
        return new PSDEFDTColDTO();
    }
}

