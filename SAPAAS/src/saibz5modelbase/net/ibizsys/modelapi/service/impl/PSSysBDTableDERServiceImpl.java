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
import net.ibizsys.modelapi.domain.PSSysBDTable;
import net.ibizsys.modelapi.domain.PSSysBDTableDER;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSSysBDTableDERDTO;
import net.ibizsys.modelapi.dto.PSSysBDTableDTO;
import net.ibizsys.modelapi.service.IPSSysBDTableDERService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysBDTableDERServiceImpl
extends PSModelServiceImplBase<PSSysBDTableDER, PSSysBDTableDERDTO>
implements IPSSysBDTableDERService {
    private static final Log log = LogFactory.getLog(PSSysBDTableDERServiceImpl.class);

    @Override
    public List<PSSysBDTableDER> listByPSSysBDTable(PSSysBDTable parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysBDTableDER get(PSSysBDTable parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysBDTableDER> list = this.listByPSSysBDTable(parent);
        if (list != null) {
            for (PSSysBDTableDER item : list) {
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
    public List<PSSysBDTableDERDTO> listDTOByPSSysBDTable(String strParentKey) throws Exception {
        PSSysBDTable pssysbdtable = (PSSysBDTable)PSModelServiceUtil.getInstance().getPSSysBDTableService().get(strParentKey);
        List<PSSysBDTableDER> list = this.listByPSSysBDTable(pssysbdtable);
        if (list != null) {
            ArrayList<PSSysBDTableDERDTO> dtoList = new ArrayList<PSSysBDTableDERDTO>();
            for (PSSysBDTableDER item : list) {
                PSSysBDTableDERDTO dto = (PSSysBDTableDERDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysBDTableDER> onListAll() throws Exception {
        ArrayList<PSSysBDTableDER> list = new ArrayList<PSSysBDTableDER>();
        List<PSSysBDTable> pssysbdtables = PSModelServiceUtil.getInstance().getPSSysBDTableService().listAll();
        if (pssysbdtables != null) {
            for (PSSysBDTable parent : pssysbdtables) {
                List<PSSysBDTableDER> items = this.listByPSSysBDTable(parent);
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
    protected PSSysBDTableDER onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysBDTableDER item;
        PSSysBDTable pssysbdtable = (PSSysBDTable)PSModelServiceUtil.getInstance().getPSSysBDTableService().get(strParentKey, true);
        if (pssysbdtable != null && (item = this.get(pssysbdtable, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysBDTableDER)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysBDTableDERDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysBDTableId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysBDTableService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysBDTableDER et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysBDTableDERName())) {
            return et.getPSSysBDTableDERName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysBDTableDERDTO dto, PSSysBDTableDER t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysBDTableDERId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDERLevel() != null || !bIgnoreNull) {
            dto.setDERLevel(t.getDERLevel());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSDERId() != null || !bIgnoreNull) {
            dto.setPSDERId(t.getPSDERId());
        }
        if (t.getPSDERName() != null || !bIgnoreNull) {
            dto.setPSDERName(t.getPSDERName());
        }
        if (t.getPSSysBDTableDERName() != null || !bIgnoreNull) {
            dto.setPSSysBDTableDERName(t.getPSSysBDTableDERName());
        }
        if (t.getPSSysBDTableId() != null || !bIgnoreNull) {
            dto.setPSSysBDTableId(t.getPSSysBDTableId());
        }
        if (t.getPSSysBDTableName() != null || !bIgnoreNull) {
            dto.setPSSysBDTableName(t.getPSSysBDTableName());
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
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            dto.setPSDERId(this.getRealPSModelId(t, dto.getPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDTableId())) {
            dto.setPSSysBDTableId(this.getRealPSModelId(t, dto.getPSSysBDTableId()).replace("/", "."));
        }
        if ("PSSYSBDTABLE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysBDTableId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getPSDERId());
            dto.setPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setPSDERName(null);
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
        return "PSSYSBDTABLEDER";
    }

    @Override
    public PSSysBDTableDER createDomain() {
        return new PSSysBDTableDER();
    }

    @Override
    public PSSysBDTableDERDTO createDTO() {
        return new PSSysBDTableDERDTO();
    }
}

