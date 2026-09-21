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
import net.ibizsys.modelapi.domain.PSSysMsgQueue;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysMsgQueueDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysUtilDEDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysMsgQueueService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysMsgQueueServiceImpl
extends PSModelServiceImplBase<PSSysMsgQueue, PSSysMsgQueueDTO>
implements IPSSysMsgQueueService {
    private static final Log log = LogFactory.getLog(PSSysMsgQueueServiceImpl.class);

    @Override
    public List<PSSysMsgQueue> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysMsgQueue get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysMsgQueue> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSSysMsgQueue item : list) {
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
    public List<PSSysMsgQueueDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSSysMsgQueue> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSSysMsgQueueDTO> dtoList = new ArrayList<PSSysMsgQueueDTO>();
            for (PSSysMsgQueue item : list) {
                PSSysMsgQueueDTO dto = (PSSysMsgQueueDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysMsgQueue> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysMsgQueue get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysMsgQueue> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysMsgQueue item : list) {
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
    public List<PSSysMsgQueueDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysMsgQueue> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysMsgQueueDTO> dtoList = new ArrayList<PSSysMsgQueueDTO>();
            for (PSSysMsgQueue item : list) {
                PSSysMsgQueueDTO dto = (PSSysMsgQueueDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysMsgQueue> onListAll() throws Exception {
        List pssystems;
        ArrayList<PSSysMsgQueue> list = new ArrayList<PSSysMsgQueue>();
        List psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll();
        if (psmodules != null) {
            for (PSModule parent : psmodules) {
                List<PSSysMsgQueue> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysMsgQueue> items = this.listByPSSystem(parent);
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
    protected PSSysMsgQueue onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysMsgQueue item;
        PSSysMsgQueue item2;
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item2 = this.get(psmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysMsgQueue)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysMsgQueueDTO dto) throws Exception {
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
    public String getModelTag(PSSysMsgQueue et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSSysMsgQueueName())) {
            return et.getPSSysMsgQueueName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysMsgQueueDTO dto, PSSysMsgQueue t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysMsgQueueId(t.getId().replace("/", "."));
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getContentPSDEFId() != null || !bIgnoreNull) {
            dto.setContentPSDEFId(t.getContentPSDEFId());
        }
        if (t.getContentPSDEFName() != null || !bIgnoreNull) {
            dto.setContentPSDEFName(t.getContentPSDEFName());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDDContentPSDEFId() != null || !bIgnoreNull) {
            dto.setDDContentPSDEFId(t.getDDContentPSDEFId());
        }
        if (t.getDDContentPSDEFName() != null || !bIgnoreNull) {
            dto.setDDContentPSDEFName(t.getDDContentPSDEFName());
        }
        if (t.getFilePSDEFId() != null || !bIgnoreNull) {
            dto.setFilePSDEFId(t.getFilePSDEFId());
        }
        if (t.getFilePSDEFName() != null || !bIgnoreNull) {
            dto.setFilePSDEFName(t.getFilePSDEFName());
        }
        if (t.getIMContentPSDEFId() != null || !bIgnoreNull) {
            dto.setIMContentPSDEFId(t.getIMContentPSDEFId());
        }
        if (t.getIMContentPSDEFName() != null || !bIgnoreNull) {
            dto.setIMContentPSDEFName(t.getIMContentPSDEFName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMobTaskUrlPSDEFId() != null || !bIgnoreNull) {
            dto.setMobTaskUrlPSDEFId(t.getMobTaskUrlPSDEFId());
        }
        if (t.getMobTaskUrlPSDEFName() != null || !bIgnoreNull) {
            dto.setMobTaskUrlPSDEFName(t.getMobTaskUrlPSDEFName());
        }
        if (t.getMsgQueueTag() != null || !bIgnoreNull) {
            dto.setMsgQueueTag(t.getMsgQueueTag());
        }
        if (t.getMsgQueueTag2() != null || !bIgnoreNull) {
            dto.setMsgQueueTag2(t.getMsgQueueTag2());
        }
        if (t.getMsgQueueType() != null || !bIgnoreNull) {
            dto.setMsgQueueType(t.getMsgQueueType());
        }
        if (t.getMsgTypePSDEFId() != null || !bIgnoreNull) {
            dto.setMsgTypePSDEFId(t.getMsgTypePSDEFId());
        }
        if (t.getMsgTypePSDEFName() != null || !bIgnoreNull) {
            dto.setMsgTypePSDEFName(t.getMsgTypePSDEFName());
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
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSysMsgQueueName() != null || !bIgnoreNull) {
            dto.setPSSysMsgQueueName(t.getPSSysMsgQueueName());
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
        if (t.getPSSysUtilDEId() != null || !bIgnoreNull) {
            dto.setPSSysUtilDEId(t.getPSSysUtilDEId());
        }
        if (t.getPSSysUtilDEName() != null || !bIgnoreNull) {
            dto.setPSSysUtilDEName(t.getPSSysUtilDEName());
        }
        if (t.getQueueParams() != null || !bIgnoreNull) {
            dto.setQueueParams(t.getQueueParams());
        }
        if (t.getSendTimePSDEFId() != null || !bIgnoreNull) {
            dto.setSendTimePSDEFId(t.getSendTimePSDEFId());
        }
        if (t.getSendTimePSDEFName() != null || !bIgnoreNull) {
            dto.setSendTimePSDEFName(t.getSendTimePSDEFName());
        }
        if (t.getSMSContentPSDEFId() != null || !bIgnoreNull) {
            dto.setSMSContentPSDEFId(t.getSMSContentPSDEFId());
        }
        if (t.getSMSContentPSDEFName() != null || !bIgnoreNull) {
            dto.setSMSContentPSDEFName(t.getSMSContentPSDEFName());
        }
        if (t.getStatePSDEFId() != null || !bIgnoreNull) {
            dto.setStatePSDEFId(t.getStatePSDEFId());
        }
        if (t.getStatePSDEFName() != null || !bIgnoreNull) {
            dto.setStatePSDEFName(t.getStatePSDEFName());
        }
        if (t.getTag2PSDEFId() != null || !bIgnoreNull) {
            dto.setTag2PSDEFId(t.getTag2PSDEFId());
        }
        if (t.getTag2PSDEFName() != null || !bIgnoreNull) {
            dto.setTag2PSDEFName(t.getTag2PSDEFName());
        }
        if (t.getTagPSDEFId() != null || !bIgnoreNull) {
            dto.setTagPSDEFId(t.getTagPSDEFId());
        }
        if (t.getTagPSDEFName() != null || !bIgnoreNull) {
            dto.setTagPSDEFName(t.getTagPSDEFName());
        }
        if (t.getTargetPSDEFId() != null || !bIgnoreNull) {
            dto.setTargetPSDEFId(t.getTargetPSDEFId());
        }
        if (t.getTargetPSDEFName() != null || !bIgnoreNull) {
            dto.setTargetPSDEFName(t.getTargetPSDEFName());
        }
        if (t.getTargetTypePSDEFId() != null || !bIgnoreNull) {
            dto.setTargetTypePSDEFId(t.getTargetTypePSDEFId());
        }
        if (t.getTargetTypePSDEFName() != null || !bIgnoreNull) {
            dto.setTargetTypePSDEFName(t.getTargetTypePSDEFName());
        }
        if (t.getTaskUrlPSDEFId() != null || !bIgnoreNull) {
            dto.setTaskUrlPSDEFId(t.getTaskUrlPSDEFId());
        }
        if (t.getTaskUrlPSDEFName() != null || !bIgnoreNull) {
            dto.setTaskUrlPSDEFName(t.getTaskUrlPSDEFName());
        }
        if (t.getTitlePSDEFId() != null || !bIgnoreNull) {
            dto.setTitlePSDEFId(t.getTitlePSDEFId());
        }
        if (t.getTitlePSDEFName() != null || !bIgnoreNull) {
            dto.setTitlePSDEFName(t.getTitlePSDEFName());
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
        if (t.getWXContentPSDEFId() != null || !bIgnoreNull) {
            dto.setWXContentPSDEFId(t.getWXContentPSDEFId());
        }
        if (t.getWXContentPSDEFName() != null || !bIgnoreNull) {
            dto.setWXContentPSDEFName(t.getWXContentPSDEFName());
        }
        if (StringUtils.hasLength((String)dto.getContentPSDEFId())) {
            dto.setContentPSDEFId(this.getRealPSModelId(t, dto.getContentPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDDContentPSDEFId())) {
            dto.setDDContentPSDEFId(this.getRealPSModelId(t, dto.getDDContentPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getFilePSDEFId())) {
            dto.setFilePSDEFId(this.getRealPSModelId(t, dto.getFilePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getIMContentPSDEFId())) {
            dto.setIMContentPSDEFId(this.getRealPSModelId(t, dto.getIMContentPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMobTaskUrlPSDEFId())) {
            dto.setMobTaskUrlPSDEFId(this.getRealPSModelId(t, dto.getMobTaskUrlPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMsgTypePSDEFId())) {
            dto.setMsgTypePSDEFId(this.getRealPSModelId(t, dto.getMsgTypePSDEFId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysUtilDEId())) {
            dto.setPSSysUtilDEId(this.getRealPSModelId(t, dto.getPSSysUtilDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getSendTimePSDEFId())) {
            dto.setSendTimePSDEFId(this.getRealPSModelId(t, dto.getSendTimePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getSMSContentPSDEFId())) {
            dto.setSMSContentPSDEFId(this.getRealPSModelId(t, dto.getSMSContentPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getStatePSDEFId())) {
            dto.setStatePSDEFId(this.getRealPSModelId(t, dto.getStatePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTag2PSDEFId())) {
            dto.setTag2PSDEFId(this.getRealPSModelId(t, dto.getTag2PSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTagPSDEFId())) {
            dto.setTagPSDEFId(this.getRealPSModelId(t, dto.getTagPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTargetPSDEFId())) {
            dto.setTargetPSDEFId(this.getRealPSModelId(t, dto.getTargetPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTargetTypePSDEFId())) {
            dto.setTargetTypePSDEFId(this.getRealPSModelId(t, dto.getTargetTypePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTaskUrlPSDEFId())) {
            dto.setTaskUrlPSDEFId(this.getRealPSModelId(t, dto.getTaskUrlPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTitlePSDEFId())) {
            dto.setTitlePSDEFId(this.getRealPSModelId(t, dto.getTitlePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getWXContentPSDEFId())) {
            dto.setWXContentPSDEFId(this.getRealPSModelId(t, dto.getWXContentPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getContentPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getContentPSDEFId());
            dto.setContentPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setContentPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getDDContentPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getDDContentPSDEFId());
            dto.setDDContentPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setDDContentPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getFilePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getFilePSDEFId());
            dto.setFilePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setFilePSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getIMContentPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getIMContentPSDEFId());
            dto.setIMContentPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setIMContentPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getMobTaskUrlPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getMobTaskUrlPSDEFId());
            dto.setMobTaskUrlPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setMobTaskUrlPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getMsgTypePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getMsgTypePSDEFId());
            dto.setMsgTypePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setMsgTypePSDEFName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysUtilDEId())) {
            linkDTO = (PSSysUtilDEDTO)PSModelServiceUtil.getInstance().getPSSysUtilDEService().getDTO(dto.getPSSysUtilDEId());
            dto.setPSSysUtilDEName(((PSSysUtilDEDTO)linkDTO).getPSSysUtilDEName());
        } else {
            dto.setPSSysUtilDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getSendTimePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getSendTimePSDEFId());
            dto.setSendTimePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setSendTimePSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getSMSContentPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getSMSContentPSDEFId());
            dto.setSMSContentPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setSMSContentPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getStatePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getStatePSDEFId());
            dto.setStatePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setStatePSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getTag2PSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTag2PSDEFId());
            dto.setTag2PSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTag2PSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getTagPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTagPSDEFId());
            dto.setTagPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTagPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getTargetPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTargetPSDEFId());
            dto.setTargetPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTargetPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getTargetTypePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTargetTypePSDEFId());
            dto.setTargetTypePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTargetTypePSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getTaskUrlPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTaskUrlPSDEFId());
            dto.setTaskUrlPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTaskUrlPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getTitlePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTitlePSDEFId());
            dto.setTitlePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTitlePSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getWXContentPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getWXContentPSDEFId());
            dto.setWXContentPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setWXContentPSDEFName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSMSGQUEUE";
    }

    @Override
    public PSSysMsgQueue createDomain() {
        return new PSSysMsgQueue();
    }

    @Override
    public PSSysMsgQueueDTO createDTO() {
        return new PSSysMsgQueueDTO();
    }
}

