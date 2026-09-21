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
import net.ibizsys.modelapi.domain.PSSysEAIElement;
import net.ibizsys.modelapi.domain.PSSysEAIElementAttr;
import net.ibizsys.modelapi.domain.PSSysEAIElementRE;
import net.ibizsys.modelapi.domain.PSSysEAIScheme;
import net.ibizsys.modelapi.dto.PSSysEAIElementAttrDTO;
import net.ibizsys.modelapi.dto.PSSysEAIElementDTO;
import net.ibizsys.modelapi.dto.PSSysEAIElementREDTO;
import net.ibizsys.modelapi.dto.PSSysEAISchemeDTO;
import net.ibizsys.modelapi.service.IPSSysEAIElementService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysEAIElementServiceImpl
extends PSModelServiceImplBase<PSSysEAIElement, PSSysEAIElementDTO>
implements IPSSysEAIElementService {
    private static final Log log = LogFactory.getLog(PSSysEAIElementServiceImpl.class);

    @Override
    public List<PSSysEAIElement> listByPSSysEAIScheme(PSSysEAIScheme parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysEAIElement get(PSSysEAIScheme parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysEAIElement> list = this.listByPSSysEAIScheme(parent);
        if (list != null) {
            for (PSSysEAIElement item : list) {
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
    public List<PSSysEAIElementDTO> listDTOByPSSysEAIScheme(String strParentKey) throws Exception {
        PSSysEAIScheme pssyseaischeme = (PSSysEAIScheme)PSModelServiceUtil.getInstance().getPSSysEAISchemeService().get(strParentKey);
        List<PSSysEAIElement> list = this.listByPSSysEAIScheme(pssyseaischeme);
        if (list != null) {
            ArrayList<PSSysEAIElementDTO> dtoList = new ArrayList<PSSysEAIElementDTO>();
            for (PSSysEAIElement item : list) {
                PSSysEAIElementDTO dto = (PSSysEAIElementDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysEAIElement> onListAll() throws Exception {
        ArrayList<PSSysEAIElement> list = new ArrayList<PSSysEAIElement>();
        List pssyseaischemes = PSModelServiceUtil.getInstance().getPSSysEAISchemeService().listAll();
        if (pssyseaischemes != null) {
            for (PSSysEAIScheme parent : pssyseaischemes) {
                List<PSSysEAIElement> items = this.listByPSSysEAIScheme(parent);
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
    protected PSSysEAIElement onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysEAIElement item;
        PSSysEAIScheme pssyseaischeme = (PSSysEAIScheme)PSModelServiceUtil.getInstance().getPSSysEAISchemeService().get(strParentKey, true);
        if (pssyseaischeme != null && (item = this.get(pssyseaischeme, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysEAIElement)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysEAIElementDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysEAISchemeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysEAISchemeService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysEAIElement et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSSysEAIElementName())) {
            return et.getPSSysEAIElementName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysEAIElementDTO dto, PSSysEAIElement t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysEAIElementId(t.getId().replace("/", "."));
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
        if (t.getEAIElementTag() != null || !bIgnoreNull) {
            dto.setEAIElementTag(t.getEAIElementTag());
        }
        if (t.getEAIElementTag2() != null || !bIgnoreNull) {
            dto.setEAIElementTag2(t.getEAIElementTag2());
        }
        if (t.getEAIElementType() != null || !bIgnoreNull) {
            dto.setEAIElementType(t.getEAIElementType());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderMode() != null || !bIgnoreNull) {
            dto.setOrderMode(t.getOrderMode());
        }
        if (t.getPSSysEAIElementName() != null || !bIgnoreNull) {
            dto.setPSSysEAIElementName(t.getPSSysEAIElementName());
        }
        if (t.getPSSysEAISchemeId() != null || !bIgnoreNull) {
            dto.setPSSysEAISchemeId(t.getPSSysEAISchemeId());
        }
        if (t.getPSSysEAISchemeName() != null || !bIgnoreNull) {
            dto.setPSSysEAISchemeName(t.getPSSysEAISchemeName());
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
        if (StringUtils.hasLength((String)dto.getPSSysEAISchemeId())) {
            dto.setPSSysEAISchemeId(this.getRealPSModelId(t, dto.getPSSysEAISchemeId()).replace("/", "."));
        }
        if ("PSSYSEAISCHEME".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysEAISchemeId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysEAISchemeId())) {
            PSSysEAISchemeDTO linkDTO = (PSSysEAISchemeDTO)PSModelServiceUtil.getInstance().getPSSysEAISchemeService().getDTO(dto.getPSSysEAISchemeId());
            dto.setPSSysEAISchemeName(linkDTO.getPSSysEAISchemeName());
        } else {
            dto.setPSSysEAISchemeName(null);
        }
        List<PSModelBase> list = PSModelServiceUtil.getInstance().getPSSysEAIElementAttrService().listByPSSysEAIElement(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSSysEAIElementAttrDTO> pssyseaielementattrs = new ArrayList<PSSysEAIElementAttrDTO>();
            for (PSSysEAIElementAttr pSSysEAIElementAttr : list) {
                dstItem = (PSSysEAIElementAttrDTO)PSModelServiceUtil.getInstance().getPSSysEAIElementAttrService().toDTO(pSSysEAIElementAttr);
                pssyseaielementattrs.add((PSSysEAIElementAttrDTO)dstItem);
            }
            dto.setPssyseaielementattrs(pssyseaielementattrs);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSSysEAIElementREService().listByPSSysEAIElement(t)) != null && list.size() > 0) {
            ArrayList<PSSysEAIElementREDTO> pssyseaielementres = new ArrayList<PSSysEAIElementREDTO>();
            for (PSSysEAIElementRE pSSysEAIElementRE : list) {
                dstItem = (PSSysEAIElementREDTO)PSModelServiceUtil.getInstance().getPSSysEAIElementREService().toDTO(pSSysEAIElementRE);
                pssyseaielementres.add((PSSysEAIElementREDTO)dstItem);
            }
            dto.setPssyseaielementres(pssyseaielementres);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSEAIELEMENT";
    }

    @Override
    public PSSysEAIElement createDomain() {
        return new PSSysEAIElement();
    }

    @Override
    public PSSysEAIElementDTO createDTO() {
        return new PSSysEAIElementDTO();
    }
}

