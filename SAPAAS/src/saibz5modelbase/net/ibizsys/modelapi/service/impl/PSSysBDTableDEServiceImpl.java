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
import net.ibizsys.modelapi.domain.PSSysBDTableDE;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysBDColSetDTO;
import net.ibizsys.modelapi.dto.PSSysBDTableDEDTO;
import net.ibizsys.modelapi.dto.PSSysBDTableDTO;
import net.ibizsys.modelapi.service.IPSSysBDTableDEService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysBDTableDEServiceImpl
extends PSModelServiceImplBase<PSSysBDTableDE, PSSysBDTableDEDTO>
implements IPSSysBDTableDEService {
    private static final Log log = LogFactory.getLog(PSSysBDTableDEServiceImpl.class);

    @Override
    public List<PSSysBDTableDE> listByPSSysBDTable(PSSysBDTable parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysBDTableDE get(PSSysBDTable parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysBDTableDE> list = this.listByPSSysBDTable(parent);
        if (list != null) {
            for (PSSysBDTableDE item : list) {
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
    public List<PSSysBDTableDEDTO> listDTOByPSSysBDTable(String strParentKey) throws Exception {
        PSSysBDTable pssysbdtable = (PSSysBDTable)PSModelServiceUtil.getInstance().getPSSysBDTableService().get(strParentKey);
        List<PSSysBDTableDE> list = this.listByPSSysBDTable(pssysbdtable);
        if (list != null) {
            ArrayList<PSSysBDTableDEDTO> dtoList = new ArrayList<PSSysBDTableDEDTO>();
            for (PSSysBDTableDE item : list) {
                PSSysBDTableDEDTO dto = (PSSysBDTableDEDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysBDTableDE> onListAll() throws Exception {
        ArrayList<PSSysBDTableDE> list = new ArrayList<PSSysBDTableDE>();
        List pssysbdtables = PSModelServiceUtil.getInstance().getPSSysBDTableService().listAll();
        if (pssysbdtables != null) {
            for (PSSysBDTable parent : pssysbdtables) {
                List<PSSysBDTableDE> items = this.listByPSSysBDTable(parent);
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
    protected PSSysBDTableDE onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysBDTableDE item;
        PSSysBDTable pssysbdtable = (PSSysBDTable)PSModelServiceUtil.getInstance().getPSSysBDTableService().get(strParentKey, true);
        if (pssysbdtable != null && (item = this.get(pssysbdtable, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysBDTableDE)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysBDTableDEDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysBDTableId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysBDTableService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysBDTableDE et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysBDTableDEDTO dto, PSSysBDTableDE t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysBDTableDEId(t.getId().replace("/", "."));
        }
        if (t.getAddColMode() != null || !bIgnoreNull) {
            dto.setAddColMode(t.getAddColMode());
        }
        if (t.getColFilter() != null || !bIgnoreNull) {
            dto.setColFilter(t.getColFilter());
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
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
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
        if (t.getPSSysBDSchemeId() != null || !bIgnoreNull) {
            dto.setPSSysBDSchemeId(t.getPSSysBDSchemeId());
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
        if (t.getRowKeyFormat() != null || !bIgnoreNull) {
            dto.setRowKeyFormat(t.getRowKeyFormat());
        }
        if (t.getRowKeyParams() != null || !bIgnoreNull) {
            dto.setRowKeyParams(t.getRowKeyParams());
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
        if (StringUtils.hasLength((String)dto.getPSSysBDColSetId())) {
            dto.setPSSysBDColSetId(this.getRealPSModelId(t, dto.getPSSysBDColSetId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDTableId())) {
            dto.setPSSysBDTableId(this.getRealPSModelId(t, dto.getPSSysBDTableId()).replace("/", "."));
        }
        if ("PSSYSBDTABLE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysBDTableId(t.getSrfParent().getId().replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysBDTableId())) {
            linkDTO = (PSSysBDTableDTO)PSModelServiceUtil.getInstance().getPSSysBDTableService().getDTO(dto.getPSSysBDTableId());
            dto.setPSSysBDSchemeId(((PSSysBDTableDTO)linkDTO).getPSSysBDSchemeId());
            dto.setPSSysBDTableName(((PSSysBDTableDTO)linkDTO).getPSSysBDTableName());
        } else {
            dto.setPSSysBDSchemeId(null);
            dto.setPSSysBDTableName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSBDTABLEDE";
    }

    @Override
    public PSSysBDTableDE createDomain() {
        return new PSSysBDTableDE();
    }

    @Override
    public PSSysBDTableDEDTO createDTO() {
        return new PSSysBDTableDEDTO();
    }
}

