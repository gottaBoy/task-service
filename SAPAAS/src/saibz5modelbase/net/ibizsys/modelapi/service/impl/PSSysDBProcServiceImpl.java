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
import net.ibizsys.modelapi.domain.PSSysDBProc;
import net.ibizsys.modelapi.domain.PSSysDBScheme;
import net.ibizsys.modelapi.dto.PSSysDBProcDTO;
import net.ibizsys.modelapi.dto.PSSysDBSchemeDTO;
import net.ibizsys.modelapi.service.IPSSysDBProcService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysDBProcServiceImpl
extends PSModelServiceImplBase<PSSysDBProc, PSSysDBProcDTO>
implements IPSSysDBProcService {
    private static final Log log = LogFactory.getLog(PSSysDBProcServiceImpl.class);

    @Override
    public List<PSSysDBProc> listByPSSysDBScheme(PSSysDBScheme parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysDBProc get(PSSysDBScheme parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysDBProc> list = this.listByPSSysDBScheme(parent);
        if (list != null) {
            for (PSSysDBProc item : list) {
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
    public List<PSSysDBProcDTO> listDTOByPSSysDBScheme(String strParentKey) throws Exception {
        PSSysDBScheme pssysdbscheme = (PSSysDBScheme)PSModelServiceUtil.getInstance().getPSSysDBSchemeService().get(strParentKey);
        List<PSSysDBProc> list = this.listByPSSysDBScheme(pssysdbscheme);
        if (list != null) {
            ArrayList<PSSysDBProcDTO> dtoList = new ArrayList<PSSysDBProcDTO>();
            for (PSSysDBProc item : list) {
                PSSysDBProcDTO dto = (PSSysDBProcDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysDBProc> onListAll() throws Exception {
        ArrayList<PSSysDBProc> list = new ArrayList<PSSysDBProc>();
        List pssysdbschemes = PSModelServiceUtil.getInstance().getPSSysDBSchemeService().listAll();
        if (pssysdbschemes != null) {
            for (PSSysDBScheme parent : pssysdbschemes) {
                List<PSSysDBProc> items = this.listByPSSysDBScheme(parent);
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
    protected PSSysDBProc onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysDBProc item;
        PSSysDBScheme pssysdbscheme = (PSSysDBScheme)PSModelServiceUtil.getInstance().getPSSysDBSchemeService().get(strParentKey, true);
        if (pssysdbscheme != null && (item = this.get(pssysdbscheme, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysDBProc)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysDBProcDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysDBSchemeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysDBSchemeService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysDBProc et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysDBProcName())) {
            return et.getPSSysDBProcName();
        }
        if (StringUtils.hasLength((String)et.getPSSysDBProcName())) {
            return et.getPSSysDBProcName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysDBProcDTO dto, PSSysDBProc t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysDBProcId(t.getId().replace("/", "."));
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
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getProcDesc() != null || !bIgnoreNull) {
            dto.setProcDesc(t.getProcDesc());
        }
        if (t.getPSSysDBProcName() != null || !bIgnoreNull) {
            dto.setPSSysDBProcName(t.getPSSysDBProcName());
        }
        if (t.getPSSysDBSchemeId() != null || !bIgnoreNull) {
            dto.setPSSysDBSchemeId(t.getPSSysDBSchemeId());
        }
        if (t.getPSSysDBSchemeName() != null || !bIgnoreNull) {
            dto.setPSSysDBSchemeName(t.getPSSysDBSchemeName());
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
        if (StringUtils.hasLength((String)dto.getPSSysDBSchemeId())) {
            PSSysDBSchemeDTO linkDTO = (PSSysDBSchemeDTO)PSModelServiceUtil.getInstance().getPSSysDBSchemeService().getDTO(dto.getPSSysDBSchemeId());
            dto.setPSSysDBSchemeName(linkDTO.getPSSysDBSchemeName());
        } else {
            dto.setPSSysDBSchemeName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSDBPROC";
    }

    @Override
    public PSSysDBProc createDomain() {
        return new PSSysDBProc();
    }

    @Override
    public PSSysDBProcDTO createDTO() {
        return new PSSysDBProcDTO();
    }
}

