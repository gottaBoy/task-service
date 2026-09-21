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
import net.ibizsys.modelapi.domain.PSSysSearchDE;
import net.ibizsys.modelapi.domain.PSSysSearchScheme;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysSearchDEDTO;
import net.ibizsys.modelapi.dto.PSSysSearchDocDTO;
import net.ibizsys.modelapi.dto.PSSysSearchSchemeDTO;
import net.ibizsys.modelapi.service.IPSSysSearchDEService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysSearchDEServiceImpl
extends PSModelServiceImplBase<PSSysSearchDE, PSSysSearchDEDTO>
implements IPSSysSearchDEService {
    private static final Log log = LogFactory.getLog(PSSysSearchDEServiceImpl.class);

    @Override
    public List<PSSysSearchDE> listByPSSysSearchScheme(PSSysSearchScheme parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysSearchDE get(PSSysSearchScheme parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysSearchDE> list = this.listByPSSysSearchScheme(parent);
        if (list != null) {
            for (PSSysSearchDE item : list) {
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
    public List<PSSysSearchDEDTO> listDTOByPSSysSearchScheme(String strParentKey) throws Exception {
        PSSysSearchScheme pssyssearchscheme = (PSSysSearchScheme)PSModelServiceUtil.getInstance().getPSSysSearchSchemeService().get(strParentKey);
        List<PSSysSearchDE> list = this.listByPSSysSearchScheme(pssyssearchscheme);
        if (list != null) {
            ArrayList<PSSysSearchDEDTO> dtoList = new ArrayList<PSSysSearchDEDTO>();
            for (PSSysSearchDE item : list) {
                PSSysSearchDEDTO dto = (PSSysSearchDEDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysSearchDE> onListAll() throws Exception {
        ArrayList<PSSysSearchDE> list = new ArrayList<PSSysSearchDE>();
        List pssyssearchschemes = PSModelServiceUtil.getInstance().getPSSysSearchSchemeService().listAll();
        if (pssyssearchschemes != null) {
            for (PSSysSearchScheme parent : pssyssearchschemes) {
                List<PSSysSearchDE> items = this.listByPSSysSearchScheme(parent);
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
    protected PSSysSearchDE onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysSearchDE item;
        PSSysSearchScheme pssyssearchscheme = (PSSysSearchScheme)PSModelServiceUtil.getInstance().getPSSysSearchSchemeService().get(strParentKey, true);
        if (pssyssearchscheme != null && (item = this.get(pssyssearchscheme, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysSearchDE)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysSearchDEDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysSearchSchemeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysSearchSchemeService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysSearchDE et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysSearchDEDTO dto, PSSysSearchDE t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysSearchDEId(t.getId().replace("/", "."));
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
        if (t.getDETag() != null || !bIgnoreNull) {
            dto.setDETag(t.getDETag());
        }
        if (t.getDETag2() != null || !bIgnoreNull) {
            dto.setDETag2(t.getDETag2());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getNoSQLFlag() != null || !bIgnoreNull) {
            dto.setNoSQLFlag(t.getNoSQLFlag());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSSysSearchDEName() != null || !bIgnoreNull) {
            dto.setPSSysSearchDEName(t.getPSSysSearchDEName());
        }
        if (t.getPSSysSearchDocId() != null || !bIgnoreNull) {
            dto.setPSSysSearchDocId(t.getPSSysSearchDocId());
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
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchDocId())) {
            dto.setPSSysSearchDocId(this.getRealPSModelId(t, dto.getPSSysSearchDocId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchSchemeId())) {
            dto.setPSSysSearchSchemeId(this.getRealPSModelId(t, dto.getPSSysSearchSchemeId()).replace("/", "."));
        }
        if ("PSSYSSEARCHSCHEME".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysSearchSchemeId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchDocId())) {
            linkDTO = (PSSysSearchDocDTO)PSModelServiceUtil.getInstance().getPSSysSearchDocService().getDTO(dto.getPSSysSearchDocId());
            dto.setPSSysSearchDocName(((PSSysSearchDocDTO)linkDTO).getPSSysSearchDocName());
        } else {
            dto.setPSSysSearchDocName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchSchemeId())) {
            linkDTO = (PSSysSearchSchemeDTO)PSModelServiceUtil.getInstance().getPSSysSearchSchemeService().getDTO(dto.getPSSysSearchSchemeId());
            dto.setPSSysSearchSchemeName(((PSSysSearchSchemeDTO)linkDTO).getPSSysSearchSchemeName());
        } else {
            dto.setPSSysSearchSchemeName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSSEARCHDE";
    }

    @Override
    public PSSysSearchDE createDomain() {
        return new PSSysSearchDE();
    }

    @Override
    public PSSysSearchDEDTO createDTO() {
        return new PSSysSearchDEDTO();
    }
}

