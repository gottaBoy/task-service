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
import net.ibizsys.modelapi.domain.PSSysBDModule;
import net.ibizsys.modelapi.domain.PSSysBDScheme;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysBDModuleDTO;
import net.ibizsys.modelapi.dto.PSSysBDSchemeDTO;
import net.ibizsys.modelapi.service.IPSSysBDModuleService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysBDModuleServiceImpl
extends PSModelServiceImplBase<PSSysBDModule, PSSysBDModuleDTO>
implements IPSSysBDModuleService {
    private static final Log log = LogFactory.getLog(PSSysBDModuleServiceImpl.class);

    @Override
    public List<PSSysBDModule> listByPSSysBDScheme(PSSysBDScheme parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysBDModule get(PSSysBDScheme parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysBDModule> list = this.listByPSSysBDScheme(parent);
        if (list != null) {
            for (PSSysBDModule item : list) {
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
    public List<PSSysBDModuleDTO> listDTOByPSSysBDScheme(String strParentKey) throws Exception {
        PSSysBDScheme pssysbdscheme = (PSSysBDScheme)PSModelServiceUtil.getInstance().getPSSysBDSchemeService().get(strParentKey);
        List<PSSysBDModule> list = this.listByPSSysBDScheme(pssysbdscheme);
        if (list != null) {
            ArrayList<PSSysBDModuleDTO> dtoList = new ArrayList<PSSysBDModuleDTO>();
            for (PSSysBDModule item : list) {
                PSSysBDModuleDTO dto = (PSSysBDModuleDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysBDModule> onListAll() throws Exception {
        ArrayList<PSSysBDModule> list = new ArrayList<PSSysBDModule>();
        List<PSSysBDScheme> pssysbdschemes = PSModelServiceUtil.getInstance().getPSSysBDSchemeService().listAll();
        if (pssysbdschemes != null) {
            for (PSSysBDScheme parent : pssysbdschemes) {
                List<PSSysBDModule> items = this.listByPSSysBDScheme(parent);
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
    protected PSSysBDModule onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysBDModule item;
        PSSysBDScheme pssysbdscheme = (PSSysBDScheme)PSModelServiceUtil.getInstance().getPSSysBDSchemeService().get(strParentKey, true);
        if (pssysbdscheme != null && (item = this.get(pssysbdscheme, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysBDModule)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysBDModuleDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysBDSchemeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysBDSchemeService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysBDModule et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysBDModuleDTO dto, PSSysBDModule t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysBDModuleId(t.getId().replace("/", "."));
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
        if (t.getDENames() != null || !bIgnoreNull) {
            dto.setDENames(t.getDENames());
        }
        if (t.getImpDEMode() != null || !bIgnoreNull) {
            dto.setImpDEMode(t.getImpDEMode());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
        }
        if (t.getPSSysBDModuleName() != null || !bIgnoreNull) {
            dto.setPSSysBDModuleName(t.getPSSysBDModuleName());
        }
        if (t.getPSSysBDSchemeId() != null || !bIgnoreNull) {
            dto.setPSSysBDSchemeId(t.getPSSysBDSchemeId());
        }
        if (t.getPSSysBDSchemeName() != null || !bIgnoreNull) {
            dto.setPSSysBDSchemeName(t.getPSSysBDSchemeName());
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
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            dto.setPSModuleId(this.getRealPSModelId(t, dto.getPSModuleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDSchemeId())) {
            dto.setPSSysBDSchemeId(this.getRealPSModelId(t, dto.getPSSysBDSchemeId()).replace("/", "."));
        }
        if ("PSSYSBDSCHEME".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysBDSchemeId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            linkDTO = (PSModuleDTO)PSModelServiceUtil.getInstance().getPSModuleService().getDTO(dto.getPSModuleId());
            dto.setPSModuleName(((PSModuleDTO)linkDTO).getPSModuleName());
        } else {
            dto.setPSModuleName(null);
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
        return "PSSYSBDMODULE";
    }

    @Override
    public PSSysBDModule createDomain() {
        return new PSSysBDModule();
    }

    @Override
    public PSSysBDModuleDTO createDTO() {
        return new PSSysBDModuleDTO();
    }
}

