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
import net.ibizsys.modelapi.domain.PSSysBDScheme;
import net.ibizsys.modelapi.domain.PSSysBDTable;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysBDModuleDTO;
import net.ibizsys.modelapi.dto.PSSysBDPartDTO;
import net.ibizsys.modelapi.dto.PSSysBDSchemeDTO;
import net.ibizsys.modelapi.dto.PSSysBDTableDTO;
import net.ibizsys.modelapi.service.IPSSysBDTableService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysBDTableServiceImpl
extends PSModelServiceImplBase<PSSysBDTable, PSSysBDTableDTO>
implements IPSSysBDTableService {
    private static final Log log = LogFactory.getLog(PSSysBDTableServiceImpl.class);

    @Override
    public List<PSSysBDTable> listByPSSysBDScheme(PSSysBDScheme parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysBDTable get(PSSysBDScheme parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysBDTable> list = this.listByPSSysBDScheme(parent);
        if (list != null) {
            for (PSSysBDTable item : list) {
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
    public List<PSSysBDTableDTO> listDTOByPSSysBDScheme(String strParentKey) throws Exception {
        PSSysBDScheme pssysbdscheme = (PSSysBDScheme)PSModelServiceUtil.getInstance().getPSSysBDSchemeService().get(strParentKey);
        List<PSSysBDTable> list = this.listByPSSysBDScheme(pssysbdscheme);
        if (list != null) {
            ArrayList<PSSysBDTableDTO> dtoList = new ArrayList<PSSysBDTableDTO>();
            for (PSSysBDTable item : list) {
                PSSysBDTableDTO dto = (PSSysBDTableDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysBDTable> onListAll() throws Exception {
        ArrayList<PSSysBDTable> list = new ArrayList<PSSysBDTable>();
        List pssysbdschemes = PSModelServiceUtil.getInstance().getPSSysBDSchemeService().listAll();
        if (pssysbdschemes != null) {
            for (PSSysBDScheme parent : pssysbdschemes) {
                List<PSSysBDTable> items = this.listByPSSysBDScheme(parent);
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
    protected PSSysBDTable onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysBDTable item;
        PSSysBDScheme pssysbdscheme = (PSSysBDScheme)PSModelServiceUtil.getInstance().getPSSysBDSchemeService().get(strParentKey, true);
        if (pssysbdscheme != null && (item = this.get(pssysbdscheme, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysBDTable)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysBDTableDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysBDSchemeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysBDSchemeService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysBDTable et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysBDTableName())) {
            return et.getPSSysBDTableName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysBDTableDTO dto, PSSysBDTable t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysBDTableId(t.getId().replace("/", "."));
        }
        if (t.getBDTableType() != null || !bIgnoreNull) {
            dto.setBDTableType(t.getBDTableType());
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
        if (t.getInheritPSDEId() != null || !bIgnoreNull) {
            dto.setInheritPSDEId(t.getInheritPSDEId());
        }
        if (t.getInheritPSDEName() != null || !bIgnoreNull) {
            dto.setInheritPSDEName(t.getInheritPSDEName());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMinorPSDEId() != null || !bIgnoreNull) {
            dto.setMinorPSDEId(t.getMinorPSDEId());
        }
        if (t.getMinorPSDEName() != null || !bIgnoreNull) {
            dto.setMinorPSDEName(t.getMinorPSDEName());
        }
        if (t.getModelVer() != null || !bIgnoreNull) {
            dto.setModelVer(t.getModelVer());
        }
        if (t.getPickupDEFName() != null || !bIgnoreNull) {
            dto.setPickupDEFName(t.getPickupDEFName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDERId() != null || !bIgnoreNull) {
            dto.setPSDERId(t.getPSDERId());
        }
        if (t.getPSDERName() != null || !bIgnoreNull) {
            dto.setPSDERName(t.getPSDERName());
        }
        if (t.getPSSysBDModuleId() != null || !bIgnoreNull) {
            dto.setPSSysBDModuleId(t.getPSSysBDModuleId());
        }
        if (t.getPSSysBDModuleName() != null || !bIgnoreNull) {
            dto.setPSSysBDModuleName(t.getPSSysBDModuleName());
        }
        if (t.getPSSysBDPartId() != null || !bIgnoreNull) {
            dto.setPSSysBDPartId(t.getPSSysBDPartId());
        }
        if (t.getPSSysBDPartName() != null || !bIgnoreNull) {
            dto.setPSSysBDPartName(t.getPSSysBDPartName());
        }
        if (t.getPSSysBDSchemeId() != null || !bIgnoreNull) {
            dto.setPSSysBDSchemeId(t.getPSSysBDSchemeId());
        }
        if (t.getPSSysBDSchemeName() != null || !bIgnoreNull) {
            dto.setPSSysBDSchemeName(t.getPSSysBDSchemeName());
        }
        if (t.getPSSysBDTableName() != null || !bIgnoreNull) {
            dto.setPSSysBDTableName(t.getPSSysBDTableName());
        }
        if (t.getTypeValue() != null || !bIgnoreNull) {
            dto.setTypeValue(t.getTypeValue());
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
        if (StringUtils.hasLength((String)dto.getInheritPSDEId())) {
            dto.setInheritPSDEId(this.getRealPSModelId(t, dto.getInheritPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMinorPSDEId())) {
            dto.setMinorPSDEId(this.getRealPSModelId(t, dto.getMinorPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            dto.setPSDERId(this.getRealPSModelId(t, dto.getPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDModuleId())) {
            dto.setPSSysBDModuleId(this.getRealPSModelId(t, dto.getPSSysBDModuleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDPartId())) {
            dto.setPSSysBDPartId(this.getRealPSModelId(t, dto.getPSSysBDPartId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDSchemeId())) {
            dto.setPSSysBDSchemeId(this.getRealPSModelId(t, dto.getPSSysBDSchemeId()).replace("/", "."));
        }
        if ("PSSYSBDSCHEME".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysBDSchemeId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getInheritPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getInheritPSDEId());
            dto.setInheritPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setInheritPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getMinorPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getMinorPSDEId());
            dto.setMinorPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setMinorPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getPSDERId());
            dto.setPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDModuleId())) {
            linkDTO = (PSSysBDModuleDTO)PSModelServiceUtil.getInstance().getPSSysBDModuleService().getDTO(dto.getPSSysBDModuleId());
            dto.setPSSysBDModuleName(((PSSysBDModuleDTO)linkDTO).getPSSysBDModuleName());
        } else {
            dto.setPSSysBDModuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDPartId())) {
            linkDTO = (PSSysBDPartDTO)PSModelServiceUtil.getInstance().getPSSysBDPartService().getDTO(dto.getPSSysBDPartId());
            dto.setPSSysBDPartName(((PSSysBDPartDTO)linkDTO).getPSSysBDPartName());
        } else {
            dto.setPSSysBDPartName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDSchemeId())) {
            linkDTO = (PSSysBDSchemeDTO)PSModelServiceUtil.getInstance().getPSSysBDSchemeService().getDTO(dto.getPSSysBDSchemeId());
            dto.setPSSysBDSchemeName(((PSSysBDSchemeDTO)linkDTO).getPSSysBDSchemeName());
        } else {
            dto.setPSSysBDSchemeName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSBDTABLE";
    }

    @Override
    public PSSysBDTable createDomain() {
        return new PSSysBDTable();
    }

    @Override
    public PSSysBDTableDTO createDTO() {
        return new PSSysBDTableDTO();
    }
}

