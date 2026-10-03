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
import net.ibizsys.modelapi.domain.PSSysMsgTempl;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysMsgTemplDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysMsgTemplService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysMsgTemplServiceImpl
extends PSModelServiceImplBase<PSSysMsgTempl, PSSysMsgTemplDTO>
implements IPSSysMsgTemplService {
    private static final Log log = LogFactory.getLog(PSSysMsgTemplServiceImpl.class);

    @Override
    public List<PSSysMsgTempl> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysMsgTempl get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysMsgTempl> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSSysMsgTempl item : list) {
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
    public List<PSSysMsgTemplDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSSysMsgTempl> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSSysMsgTemplDTO> dtoList = new ArrayList<PSSysMsgTemplDTO>();
            for (PSSysMsgTempl item : list) {
                PSSysMsgTemplDTO dto = (PSSysMsgTemplDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysMsgTempl> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysMsgTempl get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysMsgTempl> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysMsgTempl item : list) {
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
    public List<PSSysMsgTemplDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysMsgTempl> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysMsgTemplDTO> dtoList = new ArrayList<PSSysMsgTemplDTO>();
            for (PSSysMsgTempl item : list) {
                PSSysMsgTemplDTO dto = (PSSysMsgTemplDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysMsgTempl> onListAll() throws Exception {
        List<PSSystem> pssystems;
        ArrayList<PSSysMsgTempl> list = new ArrayList<PSSysMsgTempl>();
        List<PSModule> psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll();
        if (psmodules != null) {
            for (PSModule parent : psmodules) {
                List<PSSysMsgTempl> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysMsgTempl> items = this.listByPSSystem(parent);
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
    protected PSSysMsgTempl onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysMsgTempl item;
        PSSysMsgTempl item2;
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item2 = this.get(psmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysMsgTempl)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysMsgTemplDTO dto) throws Exception {
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
    public String getModelTag(PSSysMsgTempl et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSSysMsgTemplName())) {
            return et.getPSSysMsgTemplName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysMsgTemplDTO dto, PSSysMsgTempl t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysMsgTemplId(t.getId().replace("/", "."));
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
        if (t.getContentType() != null || !bIgnoreNull) {
            dto.setContentType(t.getContentType());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDDContent() != null || !bIgnoreNull) {
            dto.setDDContent(t.getDDContent());
        }
        if (t.getDDPSLanResId() != null || !bIgnoreNull) {
            dto.setDDPSLanResId(t.getDDPSLanResId());
        }
        if (t.getDDPSLanResName() != null || !bIgnoreNull) {
            dto.setDDPSLanResName(t.getDDPSLanResName());
        }
        if (t.getIMContent() != null || !bIgnoreNull) {
            dto.setIMContent(t.getIMContent());
        }
        if (t.getIMPSLanResId() != null || !bIgnoreNull) {
            dto.setIMPSLanResId(t.getIMPSLanResId());
        }
        if (t.getIMPSLanResName() != null || !bIgnoreNull) {
            dto.setIMPSLanResName(t.getIMPSLanResName());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMailGroupSend() != null || !bIgnoreNull) {
            dto.setMailGroupSend(t.getMailGroupSend());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMobTaskUrl() != null || !bIgnoreNull) {
            dto.setMobTaskUrl(t.getMobTaskUrl());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSysMsgTemplName() != null || !bIgnoreNull) {
            dto.setPSSysMsgTemplName(t.getPSSysMsgTemplName());
        }
        if (t.getPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginId(t.getPSSysSFPluginId());
        }
        if (t.getPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginName(t.getPSSysSFPluginName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getSMSContent() != null || !bIgnoreNull) {
            dto.setSMSContent(t.getSMSContent());
        }
        if (t.getSMSPSLanResId() != null || !bIgnoreNull) {
            dto.setSMSPSLanResId(t.getSMSPSLanResId());
        }
        if (t.getSMSPSLanResName() != null || !bIgnoreNull) {
            dto.setSMSPSLanResName(t.getSMSPSLanResName());
        }
        if (t.getSubject() != null || !bIgnoreNull) {
            dto.setSubject(t.getSubject());
        }
        if (t.getSubPSLanResId() != null || !bIgnoreNull) {
            dto.setSubPSLanResId(t.getSubPSLanResId());
        }
        if (t.getSubPSLanResName() != null || !bIgnoreNull) {
            dto.setSubPSLanResName(t.getSubPSLanResName());
        }
        if (t.getTaskUrl() != null || !bIgnoreNull) {
            dto.setTaskUrl(t.getTaskUrl());
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
        if (t.getWCContent() != null || !bIgnoreNull) {
            dto.setWCContent(t.getWCContent());
        }
        if (t.getWXPSLanResId() != null || !bIgnoreNull) {
            dto.setWXPSLanResId(t.getWXPSLanResId());
        }
        if (t.getWXPSLanResName() != null || !bIgnoreNull) {
            dto.setWXPSLanResName(t.getWXPSLanResName());
        }
        if (StringUtils.hasLength((String)dto.getContentPSLanResId())) {
            dto.setContentPSLanResId(this.getRealPSModelId(t, dto.getContentPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDDPSLanResId())) {
            dto.setDDPSLanResId(this.getRealPSModelId(t, dto.getDDPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getIMPSLanResId())) {
            dto.setIMPSLanResId(this.getRealPSModelId(t, dto.getIMPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            dto.setPSModuleId(this.getRealPSModelId(t, dto.getPSModuleId()).replace("/", "."));
        }
        if ("PSMODULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSModuleId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getSMSPSLanResId())) {
            dto.setSMSPSLanResId(this.getRealPSModelId(t, dto.getSMSPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getSubPSLanResId())) {
            dto.setSubPSLanResId(this.getRealPSModelId(t, dto.getSubPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getWXPSLanResId())) {
            dto.setWXPSLanResId(this.getRealPSModelId(t, dto.getWXPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getContentPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getContentPSLanResId());
            dto.setContentPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setContentPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getDDPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getDDPSLanResId());
            dto.setDDPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setDDPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getIMPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getIMPSLanResId());
            dto.setIMPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setIMPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            linkDTO = (PSModuleDTO)PSModelServiceUtil.getInstance().getPSModuleService().getDTO(dto.getPSModuleId());
            dto.setPSModuleName(((PSModuleDTO)linkDTO).getPSModuleName());
        } else {
            dto.setPSModuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getPSSysSFPluginId());
            dto.setPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setPSSysSFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(((PSSystemDTO)linkDTO).getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        if (StringUtils.hasLength((String)dto.getSMSPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getSMSPSLanResId());
            dto.setSMSPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setSMSPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getSubPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getSubPSLanResId());
            dto.setSubPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setSubPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getWXPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getWXPSLanResId());
            dto.setWXPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setWXPSLanResName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSMSGTEMPL";
    }

    @Override
    public PSSysMsgTempl createDomain() {
        return new PSSysMsgTempl();
    }

    @Override
    public PSSysMsgTemplDTO createDTO() {
        return new PSSysMsgTemplDTO();
    }
}

