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
import net.ibizsys.modelapi.domain.PSSysSearchDoc;
import net.ibizsys.modelapi.domain.PSSysSearchScheme;
import net.ibizsys.modelapi.dto.PSSysSearchDocDTO;
import net.ibizsys.modelapi.dto.PSSysSearchSchemeDTO;
import net.ibizsys.modelapi.service.IPSSysSearchDocService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysSearchDocServiceImpl
extends PSModelServiceImplBase<PSSysSearchDoc, PSSysSearchDocDTO>
implements IPSSysSearchDocService {
    private static final Log log = LogFactory.getLog(PSSysSearchDocServiceImpl.class);

    @Override
    public List<PSSysSearchDoc> listByPSSysSearchScheme(PSSysSearchScheme parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysSearchDoc get(PSSysSearchScheme parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysSearchDoc> list = this.listByPSSysSearchScheme(parent);
        if (list != null) {
            for (PSSysSearchDoc item : list) {
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
    public List<PSSysSearchDocDTO> listDTOByPSSysSearchScheme(String strParentKey) throws Exception {
        PSSysSearchScheme pssyssearchscheme = (PSSysSearchScheme)PSModelServiceUtil.getInstance().getPSSysSearchSchemeService().get(strParentKey);
        List<PSSysSearchDoc> list = this.listByPSSysSearchScheme(pssyssearchscheme);
        if (list != null) {
            ArrayList<PSSysSearchDocDTO> dtoList = new ArrayList<PSSysSearchDocDTO>();
            for (PSSysSearchDoc item : list) {
                PSSysSearchDocDTO dto = (PSSysSearchDocDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysSearchDoc> onListAll() throws Exception {
        ArrayList<PSSysSearchDoc> list = new ArrayList<PSSysSearchDoc>();
        List<PSSysSearchScheme> pssyssearchschemes = PSModelServiceUtil.getInstance().getPSSysSearchSchemeService().listAll();
        if (pssyssearchschemes != null) {
            for (PSSysSearchScheme parent : pssyssearchschemes) {
                List<PSSysSearchDoc> items = this.listByPSSysSearchScheme(parent);
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
    protected PSSysSearchDoc onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysSearchDoc item;
        PSSysSearchScheme pssyssearchscheme = (PSSysSearchScheme)PSModelServiceUtil.getInstance().getPSSysSearchSchemeService().get(strParentKey, true);
        if (pssyssearchscheme != null && (item = this.get(pssyssearchscheme, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysSearchDoc)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysSearchDocDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysSearchSchemeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysSearchSchemeService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysSearchDoc et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysSearchDocName())) {
            return et.getPSSysSearchDocName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysSearchDocDTO dto, PSSysSearchDoc t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysSearchDocId(t.getId().replace("/", "."));
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
        if (t.getDocTag() != null || !bIgnoreNull) {
            dto.setDocTag(t.getDocTag());
        }
        if (t.getDocTag2() != null || !bIgnoreNull) {
            dto.setDocTag2(t.getDocTag2());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSSysSearchDocName() != null || !bIgnoreNull) {
            dto.setPSSysSearchDocName(t.getPSSysSearchDocName());
        }
        if (t.getPSSysSearchSchemeId() != null || !bIgnoreNull) {
            dto.setPSSysSearchSchemeId(t.getPSSysSearchSchemeId());
        }
        if (t.getPSSysSearchSchemeName() != null || !bIgnoreNull) {
            dto.setPSSysSearchSchemeName(t.getPSSysSearchSchemeName());
        }
        if (t.getReplicas() != null || !bIgnoreNull) {
            dto.setReplicas(t.getReplicas());
        }
        if (t.getShards() != null || !bIgnoreNull) {
            dto.setShards(t.getShards());
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
        if (StringUtils.hasLength((String)dto.getPSSysSearchSchemeId())) {
            dto.setPSSysSearchSchemeId(this.getRealPSModelId(t, dto.getPSSysSearchSchemeId()).replace("/", "."));
        }
        if ("PSSYSSEARCHSCHEME".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysSearchSchemeId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchSchemeId())) {
            PSSysSearchSchemeDTO linkDTO = (PSSysSearchSchemeDTO)PSModelServiceUtil.getInstance().getPSSysSearchSchemeService().getDTO(dto.getPSSysSearchSchemeId());
            dto.setPSSysSearchSchemeName(linkDTO.getPSSysSearchSchemeName());
        } else {
            dto.setPSSysSearchSchemeName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSSEARCHDOC";
    }

    @Override
    public PSSysSearchDoc createDomain() {
        return new PSSysSearchDoc();
    }

    @Override
    public PSSysSearchDocDTO createDTO() {
        return new PSSysSearchDocDTO();
    }
}

