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
import net.ibizsys.modelapi.domain.PSSysContent;
import net.ibizsys.modelapi.domain.PSSysContentCat;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysContentCatDTO;
import net.ibizsys.modelapi.dto.PSSysContentDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysContentService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysContentServiceImpl
extends PSModelServiceImplBase<PSSysContent, PSSysContentDTO>
implements IPSSysContentService {
    private static final Log log = LogFactory.getLog(PSSysContentServiceImpl.class);

    @Override
    public List<PSSysContent> listByPSSysContentCat(PSSysContentCat parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysContent get(PSSysContentCat parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysContent> list = this.listByPSSysContentCat(parent);
        if (list != null) {
            for (PSSysContent item : list) {
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
    public List<PSSysContentDTO> listDTOByPSSysContentCat(String strParentKey) throws Exception {
        PSSysContentCat pssyscontentcat = (PSSysContentCat)PSModelServiceUtil.getInstance().getPSSysContentCatService().get(strParentKey);
        List<PSSysContent> list = this.listByPSSysContentCat(pssyscontentcat);
        if (list != null) {
            ArrayList<PSSysContentDTO> dtoList = new ArrayList<PSSysContentDTO>();
            for (PSSysContent item : list) {
                PSSysContentDTO dto = (PSSysContentDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysContent> onListAll() throws Exception {
        ArrayList<PSSysContent> list = new ArrayList<PSSysContent>();
        List pssyscontentcats = PSModelServiceUtil.getInstance().getPSSysContentCatService().listAll();
        if (pssyscontentcats != null) {
            for (PSSysContentCat parent : pssyscontentcats) {
                List<PSSysContent> items = this.listByPSSysContentCat(parent);
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
    protected PSSysContent onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysContent item;
        PSSysContentCat pssyscontentcat = (PSSysContentCat)PSModelServiceUtil.getInstance().getPSSysContentCatService().get(strParentKey, true);
        if (pssyscontentcat != null && (item = this.get(pssyscontentcat, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysContent)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysContentDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysContentCatId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysContentCatService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysContent et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSSysContentName())) {
            return et.getPSSysContentName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysContentDTO dto, PSSysContent t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysContentId(t.getId().replace("/", "."));
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getContentTag() != null || !bIgnoreNull) {
            dto.setContentTag(t.getContentTag());
        }
        if (t.getContentTag2() != null || !bIgnoreNull) {
            dto.setContentTag2(t.getContentTag2());
        }
        if (t.getContentTag3() != null || !bIgnoreNull) {
            dto.setContentTag3(t.getContentTag3());
        }
        if (t.getContentTag4() != null || !bIgnoreNull) {
            dto.setContentTag4(t.getContentTag4());
        }
        if (t.getContentType() != null || !bIgnoreNull) {
            dto.setContentType(t.getContentType());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getHtmlContent() != null || !bIgnoreNull) {
            dto.setHtmlContent(t.getHtmlContent());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
        }
        if (t.getPSSysContentCatId() != null || !bIgnoreNull) {
            dto.setPSSysContentCatId(t.getPSSysContentCatId());
        }
        if (t.getPSSysContentCatName() != null || !bIgnoreNull) {
            dto.setPSSysContentCatName(t.getPSSysContentCatName());
        }
        if (t.getPSSysContentName() != null || !bIgnoreNull) {
            dto.setPSSysContentName(t.getPSSysContentName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getRawContent() != null || !bIgnoreNull) {
            dto.setRawContent(t.getRawContent());
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
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            dto.setPSModuleId(this.getRealPSModelId(t, dto.getPSModuleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysContentCatId())) {
            dto.setPSSysContentCatId(this.getRealPSModelId(t, dto.getPSSysContentCatId()).replace("/", "."));
        }
        if ("PSSYSCONTENTCAT".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysContentCatId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            linkDTO = (PSModuleDTO)PSModelServiceUtil.getInstance().getPSModuleService().getDTO(dto.getPSModuleId());
            dto.setPSModuleName(((PSModuleDTO)linkDTO).getPSModuleName());
        } else {
            dto.setPSModuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysContentCatId())) {
            linkDTO = (PSSysContentCatDTO)PSModelServiceUtil.getInstance().getPSSysContentCatService().getDTO(dto.getPSSysContentCatId());
            dto.setPSSysContentCatName(((PSSysContentCatDTO)linkDTO).getPSSysContentCatName());
        } else {
            dto.setPSSysContentCatName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
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
        return "PSSYSCONTENT";
    }

    @Override
    public PSSysContent createDomain() {
        return new PSSysContent();
    }

    @Override
    public PSSysContentDTO createDTO() {
        return new PSSysContentDTO();
    }
}

