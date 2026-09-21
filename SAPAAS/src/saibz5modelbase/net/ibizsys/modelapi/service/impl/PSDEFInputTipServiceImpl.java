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
import net.ibizsys.modelapi.domain.PSDEFInputTip;
import net.ibizsys.modelapi.domain.PSDEField;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.dto.PSDEFInputTipDTO;
import net.ibizsys.modelapi.dto.PSDEFInputTipSetDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSDEFInputTipService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEFInputTipServiceImpl
extends PSModelServiceImplBase<PSDEFInputTip, PSDEFInputTipDTO>
implements IPSDEFInputTipService {
    private static final Log log = LogFactory.getLog(PSDEFInputTipServiceImpl.class);

    @Override
    public List<PSDEFInputTip> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEFInputTip get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEFInputTip> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSDEFInputTip item : list) {
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
    public List<PSDEFInputTipDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSDEFInputTip> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSDEFInputTipDTO> dtoList = new ArrayList<PSDEFInputTipDTO>();
            for (PSDEFInputTip item : list) {
                PSDEFInputTipDTO dto = (PSDEFInputTipDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEFInputTip> listByPSDEField(PSDEField parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEFInputTip get(PSDEField parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEFInputTip> list = this.listByPSDEField(parent);
        if (list != null) {
            for (PSDEFInputTip item : list) {
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
    public List<PSDEFInputTipDTO> listDTOByPSDEField(String strParentKey) throws Exception {
        PSDEField psdefield = (PSDEField)PSModelServiceUtil.getInstance().getPSDEFieldService().get(strParentKey);
        List<PSDEFInputTip> list = this.listByPSDEField(psdefield);
        if (list != null) {
            ArrayList<PSDEFInputTipDTO> dtoList = new ArrayList<PSDEFInputTipDTO>();
            for (PSDEFInputTip item : list) {
                PSDEFInputTipDTO dto = (PSDEFInputTipDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEFInputTip> onListAll() throws Exception {
        List psdefields;
        ArrayList<PSDEFInputTip> list = new ArrayList<PSDEFInputTip>();
        List psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll();
        if (psmodules != null) {
            for (PSModule parent : psmodules) {
                List<PSDEFInputTip> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((psdefields = PSModelServiceUtil.getInstance().getPSDEFieldService().listAll()) != null) {
            for (PSDEField parent : psdefields) {
                List<PSDEFInputTip> items = this.listByPSDEField(parent);
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
    protected PSDEFInputTip onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEFInputTip item;
        PSDEFInputTip item2;
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item2 = this.get(psmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSDEField psdefield = (PSDEField)PSModelServiceUtil.getInstance().getPSDEFieldService().get(strParentKey, true);
        if (psdefield != null && (item = this.get(psdefield, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEFInputTip)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEFInputTipDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEFId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEFieldService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSModuleId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSModuleService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEFInputTip et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEFInputTipDTO dto, PSDEFInputTip t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEFInputTipId(t.getId().replace("/", "."));
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getContent() != null || !bIgnoreNull) {
            dto.setContent(t.getContent());
        }
        if (t.getContentPSLanResId() != null || !bIgnoreNull) {
            dto.setContentPSLanResId(t.getContentPSLanResId());
        }
        if (t.getContentPSLanResName() != null || !bIgnoreNull) {
            dto.setContentPSLanResName(t.getContentPSLanResName());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDefaultFlag() != null || !bIgnoreNull) {
            dto.setDefaultFlag(t.getDefaultFlag());
        }
        if (t.getEnableClose() != null || !bIgnoreNull) {
            dto.setEnableClose(t.getEnableClose());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMoreUrl() != null || !bIgnoreNull) {
            dto.setMoreUrl(t.getMoreUrl());
        }
        if (t.getPSDEFId() != null || !bIgnoreNull) {
            dto.setPSDEFId(t.getPSDEFId());
        }
        if (t.getPSDEFInputTipName() != null || !bIgnoreNull) {
            dto.setPSDEFInputTipName(t.getPSDEFInputTipName());
        }
        if (t.getPSDEFInputTipSetId() != null || !bIgnoreNull) {
            dto.setPSDEFInputTipSetId(t.getPSDEFInputTipSetId());
        }
        if (t.getPSDEFInputTipSetName() != null || !bIgnoreNull) {
            dto.setPSDEFInputTipSetName(t.getPSDEFInputTipSetName());
        }
        if (t.getPSDEFName() != null || !bIgnoreNull) {
            dto.setPSDEFName(t.getPSDEFName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
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
        if (t.getTipMode() != null || !bIgnoreNull) {
            dto.setTipMode(t.getTipMode());
        }
        if (t.getUniqueTag() != null || !bIgnoreNull) {
            dto.setUniqueTag(t.getUniqueTag());
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
        if (StringUtils.hasLength((String)dto.getContentPSLanResId())) {
            dto.setContentPSLanResId(this.getRealPSModelId(t, dto.getContentPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if ("PSDEFIELD".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEFId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFInputTipSetId())) {
            dto.setPSDEFInputTipSetId(this.getRealPSModelId(t, dto.getPSDEFInputTipSetId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            dto.setPSModuleId(this.getRealPSModelId(t, dto.getPSModuleId()).replace("/", "."));
        }
        if ("PSMODULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSModuleId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getContentPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getContentPSLanResId());
            dto.setContentPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setContentPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFInputTipSetId())) {
            linkDTO = (PSDEFInputTipSetDTO)PSModelServiceUtil.getInstance().getPSDEFInputTipSetService().getDTO(dto.getPSDEFInputTipSetId());
            dto.setPSDEFInputTipSetName(((PSDEFInputTipSetDTO)linkDTO).getPSDEFInputTipSetName());
        } else {
            dto.setPSDEFInputTipSetName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            linkDTO = (PSModuleDTO)PSModelServiceUtil.getInstance().getPSModuleService().getDTO(dto.getPSModuleId());
            dto.setPSModuleName(((PSModuleDTO)linkDTO).getPSModuleName());
        } else {
            dto.setPSModuleName(null);
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
        return "PSDEFINPUTTIP";
    }

    @Override
    public PSDEFInputTip createDomain() {
        return new PSDEFInputTip();
    }

    @Override
    public PSDEFInputTipDTO createDTO() {
        return new PSDEFInputTipDTO();
    }
}

