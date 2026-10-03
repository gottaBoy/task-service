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
import net.ibizsys.modelapi.domain.PSDEDQCode;
import net.ibizsys.modelapi.domain.PSDEDataQuery;
import net.ibizsys.modelapi.dto.PSDEDQCodeDTO;
import net.ibizsys.modelapi.dto.PSDEDataQueryDTO;
import net.ibizsys.modelapi.service.IPSDEDQCodeService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEDQCodeServiceImpl
extends PSModelServiceImplBase<PSDEDQCode, PSDEDQCodeDTO>
implements IPSDEDQCodeService {
    private static final Log log = LogFactory.getLog(PSDEDQCodeServiceImpl.class);

    @Override
    public List<PSDEDQCode> listByPSDEDataQuery(PSDEDataQuery parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEDQCode get(PSDEDataQuery parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEDQCode> list = this.listByPSDEDataQuery(parent);
        if (list != null) {
            for (PSDEDQCode item : list) {
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
    public List<PSDEDQCodeDTO> listDTOByPSDEDataQuery(String strParentKey) throws Exception {
        PSDEDataQuery psdedataquery = (PSDEDataQuery)PSModelServiceUtil.getInstance().getPSDEDataQueryService().get(strParentKey);
        List<PSDEDQCode> list = this.listByPSDEDataQuery(psdedataquery);
        if (list != null) {
            ArrayList<PSDEDQCodeDTO> dtoList = new ArrayList<PSDEDQCodeDTO>();
            for (PSDEDQCode item : list) {
                PSDEDQCodeDTO dto = (PSDEDQCodeDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEDQCode> onListAll() throws Exception {
        ArrayList<PSDEDQCode> list = new ArrayList<PSDEDQCode>();
        List<PSDEDataQuery> psdedataqueries = PSModelServiceUtil.getInstance().getPSDEDataQueryService().listAll();
        if (psdedataqueries != null) {
            for (PSDEDataQuery parent : psdedataqueries) {
                List<PSDEDQCode> items = this.listByPSDEDataQuery(parent);
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
    protected PSDEDQCode onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEDQCode item;
        PSDEDataQuery psdedataquery = (PSDEDataQuery)PSModelServiceUtil.getInstance().getPSDEDataQueryService().get(strParentKey, true);
        if (psdedataquery != null && (item = this.get(psdedataquery, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEDQCode)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEDQCodeDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEDQId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEDataQueryService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEDQCode et) throws Exception {
        if (StringUtils.hasLength((String)et.getDBType())) {
            return et.getDBType();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEDQCodeDTO dto, PSDEDQCode t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEDQCodeId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDBType() != null || !bIgnoreNull) {
            dto.setDBType(t.getDBType());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSDEDQCodeName() != null || !bIgnoreNull) {
            dto.setPSDEDQCodeName(t.getPSDEDQCodeName());
        }
        if (t.getPSDEDQId() != null || !bIgnoreNull) {
            dto.setPSDEDQId(t.getPSDEDQId());
        }
        if (t.getPSDEDQName() != null || !bIgnoreNull) {
            dto.setPSDEDQName(t.getPSDEDQName());
        }
        if (t.getQueryCode() != null || !bIgnoreNull) {
            dto.setQueryCode(t.getQueryCode());
        }
        if (t.getQueryCodeTemp() != null || !bIgnoreNull) {
            dto.setQueryCodeTemp(t.getQueryCodeTemp());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUserQueryCode() != null || !bIgnoreNull) {
            dto.setUserQueryCode(t.getUserQueryCode());
        }
        if (t.getUserQueryCode2() != null || !bIgnoreNull) {
            dto.setUserQueryCode2(t.getUserQueryCode2());
        }
        if (StringUtils.hasLength((String)dto.getPSDEDQId())) {
            dto.setPSDEDQId(this.getRealPSModelId(t, dto.getPSDEDQId()).replace("/", "."));
        }
        if ("PSDEDATAQUERY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEDQId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDQId())) {
            PSDEDataQueryDTO linkDTO = (PSDEDataQueryDTO)PSModelServiceUtil.getInstance().getPSDEDataQueryService().getDTO(dto.getPSDEDQId());
            dto.setPSDEDQName(linkDTO.getPSDEDataQueryName());
        } else {
            dto.setPSDEDQName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSDEDQCODE";
    }

    @Override
    public PSDEDQCode createDomain() {
        return new PSDEDQCode();
    }

    @Override
    public PSDEDQCodeDTO createDTO() {
        return new PSDEDQCodeDTO();
    }
}

