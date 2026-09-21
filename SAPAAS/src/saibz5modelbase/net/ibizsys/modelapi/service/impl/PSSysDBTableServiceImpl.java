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
import net.ibizsys.modelapi.domain.PSSysDBScheme;
import net.ibizsys.modelapi.domain.PSSysDBTable;
import net.ibizsys.modelapi.dto.PSSysDBSchemeDTO;
import net.ibizsys.modelapi.dto.PSSysDBTableDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysDBTableService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysDBTableServiceImpl
extends PSModelServiceImplBase<PSSysDBTable, PSSysDBTableDTO>
implements IPSSysDBTableService {
    private static final Log log = LogFactory.getLog(PSSysDBTableServiceImpl.class);

    @Override
    public List<PSSysDBTable> listByPSSysDBScheme(PSSysDBScheme parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysDBTable get(PSSysDBScheme parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysDBTable> list = this.listByPSSysDBScheme(parent);
        if (list != null) {
            for (PSSysDBTable item : list) {
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
    public List<PSSysDBTableDTO> listDTOByPSSysDBScheme(String strParentKey) throws Exception {
        PSSysDBScheme pssysdbscheme = (PSSysDBScheme)PSModelServiceUtil.getInstance().getPSSysDBSchemeService().get(strParentKey);
        List<PSSysDBTable> list = this.listByPSSysDBScheme(pssysdbscheme);
        if (list != null) {
            ArrayList<PSSysDBTableDTO> dtoList = new ArrayList<PSSysDBTableDTO>();
            for (PSSysDBTable item : list) {
                PSSysDBTableDTO dto = (PSSysDBTableDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysDBTable> onListAll() throws Exception {
        ArrayList<PSSysDBTable> list = new ArrayList<PSSysDBTable>();
        List pssysdbschemes = PSModelServiceUtil.getInstance().getPSSysDBSchemeService().listAll();
        if (pssysdbschemes != null) {
            for (PSSysDBScheme parent : pssysdbschemes) {
                List<PSSysDBTable> items = this.listByPSSysDBScheme(parent);
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
    protected PSSysDBTable onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysDBTable item;
        PSSysDBScheme pssysdbscheme = (PSSysDBScheme)PSModelServiceUtil.getInstance().getPSSysDBSchemeService().get(strParentKey, true);
        if (pssysdbscheme != null && (item = this.get(pssysdbscheme, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysDBTable)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysDBTableDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysDBSchemeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysDBSchemeService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysDBTable et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysDBTableName())) {
            return et.getPSSysDBTableName();
        }
        if (StringUtils.hasLength((String)et.getPSSysDBTableName())) {
            return et.getPSSysDBTableName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysDBTableDTO dto, PSSysDBTable t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysDBTableId(t.getId().replace("/", "."));
        }
        if (t.getAutoExtendModel() != null || !bIgnoreNull) {
            dto.setAutoExtendModel(t.getAutoExtendModel());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getCodeName2() != null || !bIgnoreNull) {
            dto.setCodeName2(t.getCodeName2());
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
        if (t.getDropSql() != null || !bIgnoreNull) {
            dto.setDropSql(t.getDropSql());
        }
        if (t.getDSLink() != null || !bIgnoreNull) {
            dto.setDSLink(t.getDSLink());
        }
        if (t.getExistingModel() != null || !bIgnoreNull) {
            dto.setExistingModel(t.getExistingModel());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSSysDBSchemeId() != null || !bIgnoreNull) {
            dto.setPSSysDBSchemeId(t.getPSSysDBSchemeId());
        }
        if (t.getPSSysDBSchemeName() != null || !bIgnoreNull) {
            dto.setPSSysDBSchemeName(t.getPSSysDBSchemeName());
        }
        if (t.getPSSysDBTableName() != null || !bIgnoreNull) {
            dto.setPSSysDBTableName(t.getPSSysDBTableName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getTabDesc() != null || !bIgnoreNull) {
            dto.setTabDesc(t.getTabDesc());
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
        if (StringUtils.hasLength((String)dto.getPSSysDBSchemeId())) {
            dto.setPSSysDBSchemeId(this.getRealPSModelId(t, dto.getPSSysDBSchemeId()).replace("/", "."));
        }
        if ("PSSYSDBSCHEME".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysDBSchemeId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDBSchemeId())) {
            linkDTO = (PSSysDBSchemeDTO)PSModelServiceUtil.getInstance().getPSSysDBSchemeService().getDTO(dto.getPSSysDBSchemeId());
            dto.setDSLink(((PSSysDBSchemeDTO)linkDTO).getDSLink());
            dto.setPSSysDBSchemeName(((PSSysDBSchemeDTO)linkDTO).getPSSysDBSchemeName());
        } else {
            dto.setDSLink(null);
            dto.setPSSysDBSchemeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(((PSSystemDTO)linkDTO).getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSDBTABLE";
    }

    @Override
    public PSSysDBTable createDomain() {
        return new PSSysDBTable();
    }

    @Override
    public PSSysDBTableDTO createDTO() {
        return new PSSysDBTableDTO();
    }
}

