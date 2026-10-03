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
import net.ibizsys.modelapi.domain.PSLanguage;
import net.ibizsys.modelapi.domain.PSLanguageItem;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.dto.PSLanguageDTO;
import net.ibizsys.modelapi.dto.PSLanguageItemDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSLanguageItemService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSLanguageItemServiceImpl
extends PSModelServiceImplBase<PSLanguageItem, PSLanguageItemDTO>
implements IPSLanguageItemService {
    private static final Log log = LogFactory.getLog(PSLanguageItemServiceImpl.class);

    @Override
    public List<PSLanguageItem> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSLanguageItem get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSLanguageItem> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSLanguageItem item : list) {
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
    public List<PSLanguageItemDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSLanguageItem> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSLanguageItemDTO> dtoList = new ArrayList<PSLanguageItemDTO>();
            for (PSLanguageItem item : list) {
                PSLanguageItemDTO dto = (PSLanguageItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSLanguageItem> listByPSLanguage(PSLanguage parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSLanguageItem get(PSLanguage parent, String strKey, boolean bTryMode) throws Exception {
        List<PSLanguageItem> list = this.listByPSLanguage(parent);
        if (list != null) {
            for (PSLanguageItem item : list) {
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
    public List<PSLanguageItemDTO> listDTOByPSLanguage(String strParentKey) throws Exception {
        PSLanguage pslanguage = (PSLanguage)PSModelServiceUtil.getInstance().getPSLanguageService().get(strParentKey);
        List<PSLanguageItem> list = this.listByPSLanguage(pslanguage);
        if (list != null) {
            ArrayList<PSLanguageItemDTO> dtoList = new ArrayList<PSLanguageItemDTO>();
            for (PSLanguageItem item : list) {
                PSLanguageItemDTO dto = (PSLanguageItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSLanguageItem> onListAll() throws Exception {
        List<PSLanguage> pslanguages;
        ArrayList<PSLanguageItem> list = new ArrayList<PSLanguageItem>();
        List<PSModule> psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll();
        if (psmodules != null) {
            for (PSModule parent : psmodules) {
                List<PSLanguageItem> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pslanguages = PSModelServiceUtil.getInstance().getPSLanguageService().listAll()) != null) {
            for (PSLanguage parent : pslanguages) {
                List<PSLanguageItem> items = this.listByPSLanguage(parent);
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
    protected PSLanguageItem onGet(String strParentKey, String strCurKey) throws Exception {
        PSLanguageItem item;
        PSLanguageItem item2;
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item2 = this.get(psmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSLanguage pslanguage = (PSLanguage)PSModelServiceUtil.getInstance().getPSLanguageService().get(strParentKey, true);
        if (pslanguage != null && (item = this.get(pslanguage, strCurKey, true)) != null) {
            return item;
        }
        return (PSLanguageItem)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSLanguageItemDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSModuleId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSModuleService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSLanguageId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSLanguageService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSLanguageItem et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSLanguageItemName())) {
            return et.getPSLanguageItemName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSLanguageItemDTO dto, PSLanguageItem t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSLanguageItemId(t.getId().replace("/", "."));
        }
        if (t.getContent() != null || !bIgnoreNull) {
            dto.setContent(t.getContent());
        }
        if (t.getContent2() != null || !bIgnoreNull) {
            dto.setContent2(t.getContent2());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDefContent() != null || !bIgnoreNull) {
            dto.setDefContent(t.getDefContent());
        }
        if (t.getLanResTag() != null || !bIgnoreNull) {
            dto.setLanResTag(t.getLanResTag());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSLanguageId() != null || !bIgnoreNull) {
            dto.setPSLanguageId(t.getPSLanguageId());
        }
        if (t.getPSLanguageItemName() != null || !bIgnoreNull) {
            dto.setPSLanguageItemName(t.getPSLanguageItemName());
        }
        if (t.getPSLanguageName() != null || !bIgnoreNull) {
            dto.setPSLanguageName(t.getPSLanguageName());
        }
        if (t.getPSLanguageResId() != null || !bIgnoreNull) {
            dto.setPSLanguageResId(t.getPSLanguageResId());
        }
        if (t.getPSLanguageResName() != null || !bIgnoreNull) {
            dto.setPSLanguageResName(t.getPSLanguageResName());
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
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (StringUtils.hasLength((String)dto.getPSLanguageId())) {
            dto.setPSLanguageId(this.getRealPSModelId(t, dto.getPSLanguageId()).replace("/", "."));
        }
        if ("PSLANGUAGE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSLanguageId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSLanguageResId())) {
            dto.setPSLanguageResId(this.getRealPSModelId(t, dto.getPSLanguageResId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSLanguageId())) {
            linkDTO = (PSLanguageDTO)PSModelServiceUtil.getInstance().getPSLanguageService().getDTO(dto.getPSLanguageId());
            dto.setPSLanguageName(((PSLanguageDTO)linkDTO).getPSLanguageName());
        } else {
            dto.setPSLanguageName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSLanguageResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getPSLanguageResId());
            dto.setDefContent(((PSLanguageResDTO)linkDTO).getContent());
            dto.setLanResTag(((PSLanguageResDTO)linkDTO).getLanResTag());
            dto.setPSLanguageResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setDefContent(null);
            dto.setLanResTag(null);
            dto.setPSLanguageResName(null);
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
        return "PSLANGUAGEITEM";
    }

    @Override
    public PSLanguageItem createDomain() {
        return new PSLanguageItem();
    }

    @Override
    public PSLanguageItemDTO createDTO() {
        return new PSLanguageItemDTO();
    }
}

