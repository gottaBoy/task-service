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
import net.ibizsys.modelapi.domain.PSDEDBIdxField;
import net.ibizsys.modelapi.domain.PSDEDBIndex;
import net.ibizsys.modelapi.dto.PSDEDBIdxFieldDTO;
import net.ibizsys.modelapi.dto.PSDEDBIndexDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.service.IPSDEDBIdxFieldService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEDBIdxFieldServiceImpl
extends PSModelServiceImplBase<PSDEDBIdxField, PSDEDBIdxFieldDTO>
implements IPSDEDBIdxFieldService {
    private static final Log log = LogFactory.getLog(PSDEDBIdxFieldServiceImpl.class);

    @Override
    public List<PSDEDBIdxField> listByPSDEDBIndex(PSDEDBIndex parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEDBIdxField get(PSDEDBIndex parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEDBIdxField> list = this.listByPSDEDBIndex(parent);
        if (list != null) {
            for (PSDEDBIdxField item : list) {
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
    public List<PSDEDBIdxFieldDTO> listDTOByPSDEDBIndex(String strParentKey) throws Exception {
        PSDEDBIndex psdedbindex = (PSDEDBIndex)PSModelServiceUtil.getInstance().getPSDEDBIndexService().get(strParentKey);
        List<PSDEDBIdxField> list = this.listByPSDEDBIndex(psdedbindex);
        if (list != null) {
            ArrayList<PSDEDBIdxFieldDTO> dtoList = new ArrayList<PSDEDBIdxFieldDTO>();
            for (PSDEDBIdxField item : list) {
                PSDEDBIdxFieldDTO dto = (PSDEDBIdxFieldDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEDBIdxField> onListAll() throws Exception {
        ArrayList<PSDEDBIdxField> list = new ArrayList<PSDEDBIdxField>();
        List psdedbindices = PSModelServiceUtil.getInstance().getPSDEDBIndexService().listAll();
        if (psdedbindices != null) {
            for (PSDEDBIndex parent : psdedbindices) {
                List<PSDEDBIdxField> items = this.listByPSDEDBIndex(parent);
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
    protected PSDEDBIdxField onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEDBIdxField item;
        PSDEDBIndex psdedbindex = (PSDEDBIndex)PSModelServiceUtil.getInstance().getPSDEDBIndexService().get(strParentKey, true);
        if (psdedbindex != null && (item = this.get(psdedbindex, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEDBIdxField)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEDBIdxFieldDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEDBIndexId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEDBIndexService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEDBIdxField et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEDBIdxFieldName())) {
            return et.getPSDEDBIdxFieldName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEDBIdxFieldDTO dto, PSDEDBIdxField t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEDBIdxFieldId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getIncMode() != null || !bIgnoreNull) {
            dto.setIncMode(t.getIncMode());
        }
        if (t.getIndexLength() != null || !bIgnoreNull) {
            dto.setIndexLength(t.getIndexLength());
        }
        if (t.getPSDEDBIdxFieldName() != null || !bIgnoreNull) {
            dto.setPSDEDBIdxFieldName(t.getPSDEDBIdxFieldName());
        }
        if (t.getPSDEDBIndexId() != null || !bIgnoreNull) {
            dto.setPSDEDBIndexId(t.getPSDEDBIndexId());
        }
        if (t.getPSDEDBIndexName() != null || !bIgnoreNull) {
            dto.setPSDEDBIndexName(t.getPSDEDBIndexName());
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
        if (t.getSortDir() != null || !bIgnoreNull) {
            dto.setSortDir(t.getSortDir());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (StringUtils.hasLength((String)dto.getPSDEDBIndexId())) {
            dto.setPSDEDBIndexId(this.getRealPSModelId(t, dto.getPSDEDBIndexId()).replace("/", "."));
        }
        if ("PSDEDBINDEX".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEDBIndexId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDBIndexId())) {
            linkDTO = (PSDEDBIndexDTO)PSModelServiceUtil.getInstance().getPSDEDBIndexService().getDTO(dto.getPSDEDBIndexId());
            dto.setPSDEDBIndexName(((PSDEDBIndexDTO)linkDTO).getPSDEDBIndexName());
        } else {
            dto.setPSDEDBIndexName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
            dto.setPSDEId(((PSDEFieldDTO)linkDTO).getPSDEId());
        } else {
            dto.setPSDEFName(null);
            dto.setPSDEId(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEDBIDXFIELD";
    }

    @Override
    public PSDEDBIdxField createDomain() {
        return new PSDEDBIdxField();
    }

    @Override
    public PSDEDBIdxFieldDTO createDTO() {
        return new PSDEDBIdxFieldDTO();
    }
}

