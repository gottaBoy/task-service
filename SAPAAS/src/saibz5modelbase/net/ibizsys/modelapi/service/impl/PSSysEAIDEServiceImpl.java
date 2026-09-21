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
import net.ibizsys.modelapi.domain.PSSysEAIDE;
import net.ibizsys.modelapi.domain.PSSysEAIDEField;
import net.ibizsys.modelapi.domain.PSSysEAIDER;
import net.ibizsys.modelapi.domain.PSSysEAIScheme;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysEAIDEDTO;
import net.ibizsys.modelapi.dto.PSSysEAIDEFieldDTO;
import net.ibizsys.modelapi.dto.PSSysEAIDERDTO;
import net.ibizsys.modelapi.dto.PSSysEAIElementDTO;
import net.ibizsys.modelapi.dto.PSSysEAISchemeDTO;
import net.ibizsys.modelapi.service.IPSSysEAIDEService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysEAIDEServiceImpl
extends PSModelServiceImplBase<PSSysEAIDE, PSSysEAIDEDTO>
implements IPSSysEAIDEService {
    private static final Log log = LogFactory.getLog(PSSysEAIDEServiceImpl.class);

    @Override
    public List<PSSysEAIDE> listByPSSysEAIScheme(PSSysEAIScheme parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysEAIDE get(PSSysEAIScheme parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysEAIDE> list = this.listByPSSysEAIScheme(parent);
        if (list != null) {
            for (PSSysEAIDE item : list) {
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
    public List<PSSysEAIDEDTO> listDTOByPSSysEAIScheme(String strParentKey) throws Exception {
        PSSysEAIScheme pssyseaischeme = (PSSysEAIScheme)PSModelServiceUtil.getInstance().getPSSysEAISchemeService().get(strParentKey);
        List<PSSysEAIDE> list = this.listByPSSysEAIScheme(pssyseaischeme);
        if (list != null) {
            ArrayList<PSSysEAIDEDTO> dtoList = new ArrayList<PSSysEAIDEDTO>();
            for (PSSysEAIDE item : list) {
                PSSysEAIDEDTO dto = (PSSysEAIDEDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysEAIDE> onListAll() throws Exception {
        ArrayList<PSSysEAIDE> list = new ArrayList<PSSysEAIDE>();
        List pssyseaischemes = PSModelServiceUtil.getInstance().getPSSysEAISchemeService().listAll();
        if (pssyseaischemes != null) {
            for (PSSysEAIScheme parent : pssyseaischemes) {
                List<PSSysEAIDE> items = this.listByPSSysEAIScheme(parent);
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
    protected PSSysEAIDE onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysEAIDE item;
        PSSysEAIScheme pssyseaischeme = (PSSysEAIScheme)PSModelServiceUtil.getInstance().getPSSysEAISchemeService().get(strParentKey, true);
        if (pssyseaischeme != null && (item = this.get(pssyseaischeme, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysEAIDE)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysEAIDEDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysEAISchemeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysEAISchemeService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysEAIDE et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSSysEAIDEName())) {
            return et.getPSSysEAIDEName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysEAIDEDTO dto, PSSysEAIDE t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysEAIDEId(t.getId().replace("/", "."));
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
        if (t.getEAIDETag() != null || !bIgnoreNull) {
            dto.setEAIDETag(t.getEAIDETag());
        }
        if (t.getEAIDETag2() != null || !bIgnoreNull) {
            dto.setEAIDETag2(t.getEAIDETag2());
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
        if (t.getPSSysEAIDEName() != null || !bIgnoreNull) {
            dto.setPSSysEAIDEName(t.getPSSysEAIDEName());
        }
        if (t.getPSSysEAIElementId() != null || !bIgnoreNull) {
            dto.setPSSysEAIElementId(t.getPSSysEAIElementId());
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
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysEAIElementId())) {
            dto.setPSSysEAIElementId(this.getRealPSModelId(t, dto.getPSSysEAIElementId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysEAISchemeId())) {
            dto.setPSSysEAISchemeId(this.getRealPSModelId(t, dto.getPSSysEAISchemeId()).replace("/", "."));
        }
        if ("PSSYSEAISCHEME".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysEAISchemeId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysEAIElementId())) {
            linkDTO = (PSSysEAIElementDTO)PSModelServiceUtil.getInstance().getPSSysEAIElementService().getDTO(dto.getPSSysEAIElementId());
            dto.setPSSysEAIElementName(((PSSysEAIElementDTO)linkDTO).getPSSysEAIElementName());
        } else {
            dto.setPSSysEAIElementName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysEAISchemeId())) {
            linkDTO = (PSSysEAISchemeDTO)PSModelServiceUtil.getInstance().getPSSysEAISchemeService().getDTO(dto.getPSSysEAISchemeId());
            dto.setPSSysEAISchemeName(((PSSysEAISchemeDTO)linkDTO).getPSSysEAISchemeName());
        } else {
            dto.setPSSysEAISchemeName(null);
        }
        List<PSModelBase> list = PSModelServiceUtil.getInstance().getPSSysEAIDEFieldService().listByPSSysEAIDE(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSSysEAIDEFieldDTO> pssyseaidefields = new ArrayList<PSSysEAIDEFieldDTO>();
            for (PSSysEAIDEField pSSysEAIDEField : list) {
                dstItem = (PSSysEAIDEFieldDTO)PSModelServiceUtil.getInstance().getPSSysEAIDEFieldService().toDTO(pSSysEAIDEField);
                pssyseaidefields.add((PSSysEAIDEFieldDTO)dstItem);
            }
            dto.setPssyseaidefields(pssyseaidefields);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSSysEAIDERService().listByPSSysEAIDE(t)) != null && list.size() > 0) {
            ArrayList<PSSysEAIDERDTO> pssyseaiders = new ArrayList<PSSysEAIDERDTO>();
            for (PSSysEAIDER pSSysEAIDER : list) {
                dstItem = (PSSysEAIDERDTO)PSModelServiceUtil.getInstance().getPSSysEAIDERService().toDTO(pSSysEAIDER);
                pssyseaiders.add((PSSysEAIDERDTO)dstItem);
            }
            dto.setPssyseaiders(pssyseaiders);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSEAIDE";
    }

    @Override
    public PSSysEAIDE createDomain() {
        return new PSSysEAIDE();
    }

    @Override
    public PSSysEAIDEDTO createDTO() {
        return new PSSysEAIDEDTO();
    }
}

