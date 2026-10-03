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
import net.ibizsys.modelapi.domain.PSSysPFPlugin;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysPFPluginService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysPFPluginServiceImpl
extends PSModelServiceImplBase<PSSysPFPlugin, PSSysPFPluginDTO>
implements IPSSysPFPluginService {
    private static final Log log = LogFactory.getLog(PSSysPFPluginServiceImpl.class);

    @Override
    public List<PSSysPFPlugin> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysPFPlugin get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysPFPlugin> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSSysPFPlugin item : list) {
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
    public List<PSSysPFPluginDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSSysPFPlugin> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSSysPFPluginDTO> dtoList = new ArrayList<PSSysPFPluginDTO>();
            for (PSSysPFPlugin item : list) {
                PSSysPFPluginDTO dto = (PSSysPFPluginDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysPFPlugin> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysPFPlugin get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysPFPlugin> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysPFPlugin item : list) {
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
    public List<PSSysPFPluginDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysPFPlugin> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysPFPluginDTO> dtoList = new ArrayList<PSSysPFPluginDTO>();
            for (PSSysPFPlugin item : list) {
                PSSysPFPluginDTO dto = (PSSysPFPluginDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysPFPlugin> onListAll() throws Exception {
        List<PSSystem> pssystems;
        ArrayList<PSSysPFPlugin> list = new ArrayList<PSSysPFPlugin>();
        List<PSModule> psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll();
        if (psmodules != null) {
            for (PSModule parent : psmodules) {
                List<PSSysPFPlugin> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysPFPlugin> items = this.listByPSSystem(parent);
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
    protected PSSysPFPlugin onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysPFPlugin item;
        PSSysPFPlugin item2;
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item2 = this.get(psmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysPFPlugin)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysPFPluginDTO dto) throws Exception {
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
    public String getModelTag(PSSysPFPlugin et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysPFPluginDTO dto, PSSysPFPlugin t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysPFPluginId(t.getId().replace("/", "."));
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
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getExtendStyleOnly() != null || !bIgnoreNull) {
            dto.setExtendStyleOnly(t.getExtendStyleOnly());
        }
        if (t.getKeywords() != null || !bIgnoreNull) {
            dto.setKeywords(t.getKeywords());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPluginDesc() != null || !bIgnoreNull) {
            dto.setPluginDesc(t.getPluginDesc());
        }
        if (t.getPluginModel() != null || !bIgnoreNull) {
            dto.setPluginModel(t.getPluginModel());
        }
        if (t.getPluginParams() != null || !bIgnoreNull) {
            dto.setPluginParams(t.getPluginParams());
        }
        if (t.getPluginTag() != null || !bIgnoreNull) {
            dto.setPluginTag(t.getPluginTag());
        }
        if (t.getPluginType() != null || !bIgnoreNull) {
            dto.setPluginType(t.getPluginType());
        }
        if (t.getPreviewHtml() != null || !bIgnoreNull) {
            dto.setPreviewHtml(t.getPreviewHtml());
        }
        if (t.getPreviewPSNDFileId() != null || !bIgnoreNull) {
            dto.setPreviewPSNDFileId(t.getPreviewPSNDFileId());
        }
        if (t.getPreviewUrl() != null || !bIgnoreNull) {
            dto.setPreviewUrl(t.getPreviewUrl());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
        }
        if (t.getPSPFPluginId() != null || !bIgnoreNull) {
            dto.setPSPFPluginId(t.getPSPFPluginId());
        }
        if (t.getPSPFPluginName() != null || !bIgnoreNull) {
            dto.setPSPFPluginName(t.getPSPFPluginName());
        }
        if (t.getPSSysFileId() != null || !bIgnoreNull) {
            dto.setPSSysFileId(t.getPSSysFileId());
        }
        if (t.getPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginName(t.getPSSysPFPluginName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getRepDefault() != null || !bIgnoreNull) {
            dto.setRepDefault(t.getRepDefault());
        }
        if (t.getRTObjectMode() != null || !bIgnoreNull) {
            dto.setRTObjectMode(t.getRTObjectMode());
        }
        if (t.getRTObjectName() != null || !bIgnoreNull) {
            dto.setRTObjectName(t.getRTObjectName());
        }
        if (t.getRTObjectRepo() != null || !bIgnoreNull) {
            dto.setRTObjectRepo(t.getRTObjectRepo());
        }
        if (t.getStudioIcon() != null || !bIgnoreNull) {
            dto.setStudioIcon(t.getStudioIcon());
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
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            dto.setPSModuleId(this.getRealPSModelId(t, dto.getPSModuleId()).replace("/", "."));
        }
        if ("PSMODULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSModuleId(t.getSrfParent().getId().replace("/", "."));
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
        return "PSSYSPFPLUGIN";
    }

    @Override
    public PSSysPFPlugin createDomain() {
        return new PSSysPFPlugin();
    }

    @Override
    public PSSysPFPluginDTO createDTO() {
        return new PSSysPFPluginDTO();
    }
}

