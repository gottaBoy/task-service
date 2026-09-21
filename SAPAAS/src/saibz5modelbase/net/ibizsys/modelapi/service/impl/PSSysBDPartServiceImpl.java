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
import net.ibizsys.modelapi.domain.PSSysBDPart;
import net.ibizsys.modelapi.domain.PSSysBDScheme;
import net.ibizsys.modelapi.dto.PSSysBDPartDTO;
import net.ibizsys.modelapi.dto.PSSysBDSchemeDTO;
import net.ibizsys.modelapi.service.IPSSysBDPartService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysBDPartServiceImpl
extends PSModelServiceImplBase<PSSysBDPart, PSSysBDPartDTO>
implements IPSSysBDPartService {
    private static final Log log = LogFactory.getLog(PSSysBDPartServiceImpl.class);

    @Override
    public List<PSSysBDPart> listByPSSysBDScheme(PSSysBDScheme parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysBDPart get(PSSysBDScheme parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysBDPart> list = this.listByPSSysBDScheme(parent);
        if (list != null) {
            for (PSSysBDPart item : list) {
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
    public List<PSSysBDPartDTO> listDTOByPSSysBDScheme(String strParentKey) throws Exception {
        PSSysBDScheme pssysbdscheme = (PSSysBDScheme)PSModelServiceUtil.getInstance().getPSSysBDSchemeService().get(strParentKey);
        List<PSSysBDPart> list = this.listByPSSysBDScheme(pssysbdscheme);
        if (list != null) {
            ArrayList<PSSysBDPartDTO> dtoList = new ArrayList<PSSysBDPartDTO>();
            for (PSSysBDPart item : list) {
                PSSysBDPartDTO dto = (PSSysBDPartDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysBDPart> onListAll() throws Exception {
        ArrayList<PSSysBDPart> list = new ArrayList<PSSysBDPart>();
        List pssysbdschemes = PSModelServiceUtil.getInstance().getPSSysBDSchemeService().listAll();
        if (pssysbdschemes != null) {
            for (PSSysBDScheme parent : pssysbdschemes) {
                List<PSSysBDPart> items = this.listByPSSysBDScheme(parent);
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
    protected PSSysBDPart onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysBDPart item;
        PSSysBDScheme pssysbdscheme = (PSSysBDScheme)PSModelServiceUtil.getInstance().getPSSysBDSchemeService().get(strParentKey, true);
        if (pssysbdscheme != null && (item = this.get(pssysbdscheme, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysBDPart)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysBDPartDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysBDSchemeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysBDSchemeService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysBDPart et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysBDPartDTO dto, PSSysBDPart t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysBDPartId(t.getId().replace("/", "."));
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
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
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
        if (StringUtils.hasLength((String)dto.getPSSysBDSchemeId())) {
            dto.setPSSysBDSchemeId(this.getRealPSModelId(t, dto.getPSSysBDSchemeId()).replace("/", "."));
        }
        if ("PSSYSBDSCHEME".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysBDSchemeId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDSchemeId())) {
            PSSysBDSchemeDTO linkDTO = (PSSysBDSchemeDTO)PSModelServiceUtil.getInstance().getPSSysBDSchemeService().getDTO(dto.getPSSysBDSchemeId());
            dto.setPSSysBDSchemeName(linkDTO.getPSSysBDSchemeName());
        } else {
            dto.setPSSysBDSchemeName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSBDPART";
    }

    @Override
    public PSSysBDPart createDomain() {
        return new PSSysBDPart();
    }

    @Override
    public PSSysBDPartDTO createDTO() {
        return new PSSysBDPartDTO();
    }
}

