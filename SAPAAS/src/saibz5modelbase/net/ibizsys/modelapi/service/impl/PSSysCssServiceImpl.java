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
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysCss;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysCssCatDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysCssService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysCssServiceImpl
extends PSModelServiceImplBase<PSSysCss, PSSysCssDTO>
implements IPSSysCssService {
    private static final Log log = LogFactory.getLog(PSSysCssServiceImpl.class);

    @Override
    public List<PSSysCss> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysCss get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysCss> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSSysCss item : list) {
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
    public List<PSSysCssDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSSysCss> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSSysCssDTO> dtoList = new ArrayList<PSSysCssDTO>();
            for (PSSysCss item : list) {
                PSSysCssDTO dto = (PSSysCssDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysCss> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysCss get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysCss> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysCss item : list) {
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
    public List<PSSysCssDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysCss> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysCssDTO> dtoList = new ArrayList<PSSysCssDTO>();
            for (PSSysCss item : list) {
                PSSysCssDTO dto = (PSSysCssDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysCss> onListAll() throws Exception {
        List<PSSystem> pssystems;
        ArrayList<PSSysCss> list = new ArrayList<PSSysCss>();
        List<PSModule> psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll();
        if (psmodules != null) {
            for (PSModule parent : psmodules) {
                List<PSSysCss> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysCss> items = this.listByPSSystem(parent);
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
    protected PSSysCss onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysCss item;
        PSSysCss item2;
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item2 = this.get(psmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysCss)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysCssDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSModuleId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSModuleService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSSystemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSystemService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysCss et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSSysCssName())) {
            return et.getPSSysCssName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysCssDTO dto, PSSysCss t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysCssId(t.getId().replace("/", "."));
        }
        if (t.getBKColor() != null || !bIgnoreNull) {
            dto.setBKColor(t.getBKColor());
        }
        if (t.getBorder() != null || !bIgnoreNull) {
            dto.setBorder(t.getBorder());
        }
        if (t.getBorderColor() != null || !bIgnoreNull) {
            dto.setBorderColor(t.getBorderColor());
        }
        if (t.getBorderStyle() != null || !bIgnoreNull) {
            dto.setBorderStyle(t.getBorderStyle());
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
        if (t.getCSSName() != null || !bIgnoreNull) {
            dto.setCSSName(t.getCSSName());
        }
        if (t.getCSSStyle() != null || !bIgnoreNull) {
            dto.setCSSStyle(t.getCSSStyle());
        }
        if (t.getCssStyle2() != null || !bIgnoreNull) {
            dto.setCssStyle2(t.getCssStyle2());
        }
        if (t.getFontColor() != null || !bIgnoreNull) {
            dto.setFontColor(t.getFontColor());
        }
        if (t.getFontFamily() != null || !bIgnoreNull) {
            dto.setFontFamily(t.getFontFamily());
        }
        if (t.getFontSize() != null || !bIgnoreNull) {
            dto.setFontSize(t.getFontSize());
        }
        if (t.getFontStyle() != null || !bIgnoreNull) {
            dto.setFontStyle(t.getFontStyle());
        }
        if (t.getHAlign() != null || !bIgnoreNull) {
            dto.setHAlign(t.getHAlign());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMargin() != null || !bIgnoreNull) {
            dto.setMargin(t.getMargin());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOwnerId() != null || !bIgnoreNull) {
            dto.setOwnerId(t.getOwnerId());
        }
        if (t.getOwnerTag() != null || !bIgnoreNull) {
            dto.setOwnerTag(t.getOwnerTag());
        }
        if (t.getOwnerType() != null || !bIgnoreNull) {
            dto.setOwnerType(t.getOwnerType());
        }
        if (t.getPadding() != null || !bIgnoreNull) {
            dto.setPadding(t.getPadding());
        }
        if (t.getPSCssTemplId() != null || !bIgnoreNull) {
            dto.setPSCssTemplId(t.getPSCssTemplId());
        }
        if (t.getPSCssTemplName() != null || !bIgnoreNull) {
            dto.setPSCssTemplName(t.getPSCssTemplName());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
        }
        if (t.getPSSysCssCatId() != null || !bIgnoreNull) {
            dto.setPSSysCssCatId(t.getPSSysCssCatId());
        }
        if (t.getPSSysCssCatName() != null || !bIgnoreNull) {
            dto.setPSSysCssCatName(t.getPSSysCssCatName());
        }
        if (t.getPSSysCssName() != null || !bIgnoreNull) {
            dto.setPSSysCssName(t.getPSSysCssName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getPublicFlag() != null || !bIgnoreNull) {
            dto.setPublicFlag(t.getPublicFlag());
        }
        if (t.getSampleContent() != null || !bIgnoreNull) {
            dto.setSampleContent(t.getSampleContent());
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
        if (t.getVAlign() != null || !bIgnoreNull) {
            dto.setVAlign(t.getVAlign());
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            dto.setPSModuleId(this.getRealPSModelId(t, dto.getPSModuleId()).replace("/", "."));
        }
        if ("PSMODULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSModuleId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssCatId())) {
            dto.setPSSysCssCatId(this.getRealPSModelId(t, dto.getPSSysCssCatId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            linkDTO = (PSModuleDTO)PSModelServiceUtil.getInstance().getPSModuleService().getDTO(dto.getPSModuleId());
            dto.setPSModuleName(((PSModuleDTO)linkDTO).getPSModuleName());
        } else {
            dto.setPSModuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssCatId())) {
            linkDTO = (PSSysCssCatDTO)PSModelServiceUtil.getInstance().getPSSysCssCatService().getDTO(dto.getPSSysCssCatId());
            dto.setPSSysCssCatName(((PSSysCssCatDTO)linkDTO).getPSSysCssCatName());
        } else {
            dto.setPSSysCssCatName(null);
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
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSCSS";
    }

    @Override
    public PSSysCss createDomain() {
        return new PSSysCss();
    }

    @Override
    public PSSysCssDTO createDTO() {
        return new PSSysCssDTO();
    }
}

