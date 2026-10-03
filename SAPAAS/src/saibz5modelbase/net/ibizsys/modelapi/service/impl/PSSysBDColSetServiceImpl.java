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
import net.ibizsys.modelapi.domain.PSSysBDColSet;
import net.ibizsys.modelapi.domain.PSSysBDTable;
import net.ibizsys.modelapi.dto.PSSysBDColSetDTO;
import net.ibizsys.modelapi.dto.PSSysBDTableDTO;
import net.ibizsys.modelapi.service.IPSSysBDColSetService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysBDColSetServiceImpl
extends PSModelServiceImplBase<PSSysBDColSet, PSSysBDColSetDTO>
implements IPSSysBDColSetService {
    private static final Log log = LogFactory.getLog(PSSysBDColSetServiceImpl.class);

    @Override
    public List<PSSysBDColSet> listByPSSysBDTable(PSSysBDTable parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysBDColSet get(PSSysBDTable parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysBDColSet> list = this.listByPSSysBDTable(parent);
        if (list != null) {
            for (PSSysBDColSet item : list) {
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
    public List<PSSysBDColSetDTO> listDTOByPSSysBDTable(String strParentKey) throws Exception {
        PSSysBDTable pssysbdtable = (PSSysBDTable)PSModelServiceUtil.getInstance().getPSSysBDTableService().get(strParentKey);
        List<PSSysBDColSet> list = this.listByPSSysBDTable(pssysbdtable);
        if (list != null) {
            ArrayList<PSSysBDColSetDTO> dtoList = new ArrayList<PSSysBDColSetDTO>();
            for (PSSysBDColSet item : list) {
                PSSysBDColSetDTO dto = (PSSysBDColSetDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysBDColSet> onListAll() throws Exception {
        ArrayList<PSSysBDColSet> list = new ArrayList<PSSysBDColSet>();
        List<PSSysBDTable> pssysbdtables = PSModelServiceUtil.getInstance().getPSSysBDTableService().listAll();
        if (pssysbdtables != null) {
            for (PSSysBDTable parent : pssysbdtables) {
                List<PSSysBDColSet> items = this.listByPSSysBDTable(parent);
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
    protected PSSysBDColSet onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysBDColSet item;
        PSSysBDTable pssysbdtable = (PSSysBDTable)PSModelServiceUtil.getInstance().getPSSysBDTableService().get(strParentKey, true);
        if (pssysbdtable != null && (item = this.get(pssysbdtable, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysBDColSet)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysBDColSetDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysBDTableId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysBDTableService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysBDColSet et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysBDColSetName())) {
            return et.getPSSysBDColSetName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysBDColSetDTO dto, PSSysBDColSet t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysBDColSetId(t.getId().replace("/", "."));
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
        if (t.getDefaultFlag() != null || !bIgnoreNull) {
            dto.setDefaultFlag(t.getDefaultFlag());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSSysBDColSetName() != null || !bIgnoreNull) {
            dto.setPSSysBDColSetName(t.getPSSysBDColSetName());
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
        if (StringUtils.hasLength((String)dto.getPSSysBDTableId())) {
            dto.setPSSysBDTableId(this.getRealPSModelId(t, dto.getPSSysBDTableId()).replace("/", "."));
        }
        if ("PSSYSBDTABLE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysBDTableId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDTableId())) {
            PSSysBDTableDTO linkDTO = (PSSysBDTableDTO)PSModelServiceUtil.getInstance().getPSSysBDTableService().getDTO(dto.getPSSysBDTableId());
            dto.setPSSysBDTableName(linkDTO.getPSSysBDTableName());
        } else {
            dto.setPSSysBDTableName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSBDCOLSET";
    }

    @Override
    public PSSysBDColSet createDomain() {
        return new PSSysBDColSet();
    }

    @Override
    public PSSysBDColSetDTO createDTO() {
        return new PSSysBDColSetDTO();
    }
}

