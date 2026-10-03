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
import net.ibizsys.modelapi.domain.PSDETable;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDETableDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysDBTableDTO;
import net.ibizsys.modelapi.service.IPSDETableService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDETableServiceImpl
extends PSModelServiceImplBase<PSDETable, PSDETableDTO>
implements IPSDETableService {
    private static final Log log = LogFactory.getLog(PSDETableServiceImpl.class);

    @Override
    public List<PSDETable> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDETable get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDETable> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDETable item : list) {
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
    public List<PSDETableDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDETable> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDETableDTO> dtoList = new ArrayList<PSDETableDTO>();
            for (PSDETable item : list) {
                PSDETableDTO dto = (PSDETableDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDETable> onListAll() throws Exception {
        ArrayList<PSDETable> list = new ArrayList<PSDETable>();
        List<PSDataEntity> psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDETable> items = this.listByPSDataEntity(parent);
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
    protected PSDETable onGet(String strParentKey, String strCurKey) throws Exception {
        PSDETable item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDETable)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDETableDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDETable et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDETableName())) {
            return et.getPSDETableName();
        }
        if (StringUtils.hasLength((String)et.getPSDETableName())) {
            return et.getPSDETableName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDETableDTO dto, PSDETable t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDETableId(t.getId().replace("/", "."));
        }
        if (t.getColInheritMode() != null || !bIgnoreNull) {
            dto.setColInheritMode(t.getColInheritMode());
        }
        if (t.getColumns() != null || !bIgnoreNull) {
            dto.setColumns(t.getColumns());
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
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDETableName() != null || !bIgnoreNull) {
            dto.setPSDETableName(t.getPSDETableName());
        }
        if (t.getPSSysDBTableId() != null || !bIgnoreNull) {
            dto.setPSSysDBTableId(t.getPSSysDBTableId());
        }
        if (t.getPSSysDBTableName() != null || !bIgnoreNull) {
            dto.setPSSysDBTableName(t.getPSSysDBTableName());
        }
        if (t.getTableType() != null || !bIgnoreNull) {
            dto.setTableType(t.getTableType());
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
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDBTableId())) {
            dto.setPSSysDBTableId(this.getRealPSModelId(t, dto.getPSSysDBTableId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDBTableId())) {
            linkDTO = (PSSysDBTableDTO)PSModelServiceUtil.getInstance().getPSSysDBTableService().getDTO(dto.getPSSysDBTableId());
            dto.setPSSysDBTableName(((PSSysDBTableDTO)linkDTO).getPSSysDBTableName());
        } else {
            dto.setPSSysDBTableName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSDETABLE";
    }

    @Override
    public PSDETable createDomain() {
        return new PSDETable();
    }

    @Override
    public PSDETableDTO createDTO() {
        return new PSDETableDTO();
    }
}

