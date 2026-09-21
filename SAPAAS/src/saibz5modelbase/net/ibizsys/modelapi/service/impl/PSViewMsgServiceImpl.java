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
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.domain.PSViewMsg;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysMsgTemplDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.dto.PSViewMsgDTO;
import net.ibizsys.modelapi.service.IPSViewMsgService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSViewMsgServiceImpl
extends PSModelServiceImplBase<PSViewMsg, PSViewMsgDTO>
implements IPSViewMsgService {
    private static final Log log = LogFactory.getLog(PSViewMsgServiceImpl.class);

    @Override
    public List<PSViewMsg> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSViewMsg get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSViewMsg> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSViewMsg item : list) {
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
    public List<PSViewMsgDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSViewMsg> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSViewMsgDTO> dtoList = new ArrayList<PSViewMsgDTO>();
            for (PSViewMsg item : list) {
                PSViewMsgDTO dto = (PSViewMsgDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSViewMsg> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSViewMsg get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSViewMsg> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSViewMsg item : list) {
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
    public List<PSViewMsgDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSViewMsg> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSViewMsgDTO> dtoList = new ArrayList<PSViewMsgDTO>();
            for (PSViewMsg item : list) {
                PSViewMsgDTO dto = (PSViewMsgDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSViewMsg> onListAll() throws Exception {
        List pssystems;
        ArrayList<PSViewMsg> list = new ArrayList<PSViewMsg>();
        List psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll();
        if (psmodules != null) {
            for (PSModule parent : psmodules) {
                List<PSViewMsg> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSViewMsg> items = this.listByPSSystem(parent);
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
    protected PSViewMsg onGet(String strParentKey, String strCurKey) throws Exception {
        PSViewMsg item;
        PSViewMsg item2;
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item2 = this.get(psmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSViewMsg)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSViewMsgDTO dto) throws Exception {
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
    public String getModelTag(PSViewMsg et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSViewMsgName())) {
            return et.getPSViewMsgName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSViewMsgDTO dto, PSViewMsg t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSViewMsgId(t.getId().replace("/", "."));
        }
        if (t.getCacheScope() != null || !bIgnoreNull) {
            dto.setCacheScope(t.getCacheScope());
        }
        if (t.getCacheTag2PSDEFId() != null || !bIgnoreNull) {
            dto.setCacheTag2PSDEFId(t.getCacheTag2PSDEFId());
        }
        if (t.getCacheTag2PSDEFName() != null || !bIgnoreNull) {
            dto.setCacheTag2PSDEFName(t.getCacheTag2PSDEFName());
        }
        if (t.getCacheTagPSDEFId() != null || !bIgnoreNull) {
            dto.setCacheTagPSDEFId(t.getCacheTagPSDEFId());
        }
        if (t.getCacheTagPSDEFName() != null || !bIgnoreNull) {
            dto.setCacheTagPSDEFName(t.getCacheTagPSDEFName());
        }
        if (t.getCacheTimeout() != null || !bIgnoreNull) {
            dto.setCacheTimeout(t.getCacheTimeout());
        }
        if (t.getClsPSDEFId() != null || !bIgnoreNull) {
            dto.setClsPSDEFId(t.getClsPSDEFId());
        }
        if (t.getClsPSDEFName() != null || !bIgnoreNull) {
            dto.setClsPSDEFName(t.getClsPSDEFName());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getContent() != null || !bIgnoreNull) {
            dto.setContent(t.getContent());
        }
        if (t.getContentPSDEFId() != null || !bIgnoreNull) {
            dto.setContentPSDEFId(t.getContentPSDEFId());
        }
        if (t.getContentPSDEFName() != null || !bIgnoreNull) {
            dto.setContentPSDEFName(t.getContentPSDEFName());
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
        if (t.getDSLink() != null || !bIgnoreNull) {
            dto.setDSLink(t.getDSLink());
        }
        if (t.getDynamicMode() != null || !bIgnoreNull) {
            dto.setDynamicMode(t.getDynamicMode());
        }
        if (t.getEnableCache() != null || !bIgnoreNull) {
            dto.setEnableCache(t.getEnableCache());
        }
        if (t.getEnableRemove() != null || !bIgnoreNull) {
            dto.setEnableRemove(t.getEnableRemove());
        }
        if (t.getGroupPSDEFId() != null || !bIgnoreNull) {
            dto.setGroupPSDEFId(t.getGroupPSDEFId());
        }
        if (t.getGroupPSDEFName() != null || !bIgnoreNull) {
            dto.setGroupPSDEFName(t.getGroupPSDEFName());
        }
        if (t.getIconPSDEFId() != null || !bIgnoreNull) {
            dto.setIconPSDEFId(t.getIconPSDEFId());
        }
        if (t.getIconPSDEFName() != null || !bIgnoreNull) {
            dto.setIconPSDEFName(t.getIconPSDEFName());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMsgGroup() != null || !bIgnoreNull) {
            dto.setMsgGroup(t.getMsgGroup());
        }
        if (t.getMsgPos() != null || !bIgnoreNull) {
            dto.setMsgPos(t.getMsgPos());
        }
        if (t.getMsgPosPSDEFId() != null || !bIgnoreNull) {
            dto.setMsgPosPSDEFId(t.getMsgPosPSDEFId());
        }
        if (t.getMsgPosPSDEFName() != null || !bIgnoreNull) {
            dto.setMsgPosPSDEFName(t.getMsgPosPSDEFName());
        }
        if (t.getMsgType() != null || !bIgnoreNull) {
            dto.setMsgType(t.getMsgType());
        }
        if (t.getMsgTypePSDEFId() != null || !bIgnoreNull) {
            dto.setMsgTypePSDEFId(t.getMsgTypePSDEFId());
        }
        if (t.getMsgTypePSDEFName() != null || !bIgnoreNull) {
            dto.setMsgTypePSDEFName(t.getMsgTypePSDEFName());
        }
        if (t.getOrderValuePSDEFId() != null || !bIgnoreNull) {
            dto.setOrderValuePSDEFId(t.getOrderValuePSDEFId());
        }
        if (t.getOrderValuePSDEFName() != null || !bIgnoreNull) {
            dto.setOrderValuePSDEFName(t.getOrderValuePSDEFName());
        }
        if (t.getPSDEDSId() != null || !bIgnoreNull) {
            dto.setPSDEDSId(t.getPSDEDSId());
        }
        if (t.getPSDEDSName() != null || !bIgnoreNull) {
            dto.setPSDEDSName(t.getPSDEDSName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDELogicId() != null || !bIgnoreNull) {
            dto.setPSDELogicId(t.getPSDELogicId());
        }
        if (t.getPSDELogicName() != null || !bIgnoreNull) {
            dto.setPSDELogicName(t.getPSDELogicName());
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
        if (t.getPSSysCssId() != null || !bIgnoreNull) {
            dto.setPSSysCssId(t.getPSSysCssId());
        }
        if (t.getPSSysCssName() != null || !bIgnoreNull) {
            dto.setPSSysCssName(t.getPSSysCssName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSysImageId() != null || !bIgnoreNull) {
            dto.setPSSysImageId(t.getPSSysImageId());
        }
        if (t.getPSSysImageName() != null || !bIgnoreNull) {
            dto.setPSSysImageName(t.getPSSysImageName());
        }
        if (t.getPSSysMsgTemplId() != null || !bIgnoreNull) {
            dto.setPSSysMsgTemplId(t.getPSSysMsgTemplId());
        }
        if (t.getPSSysMsgTemplName() != null || !bIgnoreNull) {
            dto.setPSSysMsgTemplName(t.getPSSysMsgTemplName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getPSSysViewPanelId() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelId(t.getPSSysViewPanelId());
        }
        if (t.getPSSysViewPanelName() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelName(t.getPSSysViewPanelName());
        }
        if (t.getPSViewMsgName() != null || !bIgnoreNull) {
            dto.setPSViewMsgName(t.getPSViewMsgName());
        }
        if (t.getRemovePSDEFId() != null || !bIgnoreNull) {
            dto.setRemovePSDEFId(t.getRemovePSDEFId());
        }
        if (t.getRemovePSDEFName() != null || !bIgnoreNull) {
            dto.setRemovePSDEFName(t.getRemovePSDEFName());
        }
        if (t.getTimeout() != null || !bIgnoreNull) {
            dto.setTimeout(t.getTimeout());
        }
        if (t.getTitle() != null || !bIgnoreNull) {
            dto.setTitle(t.getTitle());
        }
        if (t.getTitleLanResTagPSDEFId() != null || !bIgnoreNull) {
            dto.setTitleLanResTagPSDEFId(t.getTitleLanResTagPSDEFId());
        }
        if (t.getTitleLanResTagPSDEFName() != null || !bIgnoreNull) {
            dto.setTitleLanResTagPSDEFName(t.getTitleLanResTagPSDEFName());
        }
        if (t.getTitlePSDEFId() != null || !bIgnoreNull) {
            dto.setTitlePSDEFId(t.getTitlePSDEFId());
        }
        if (t.getTitlePSDEFName() != null || !bIgnoreNull) {
            dto.setTitlePSDEFName(t.getTitlePSDEFName());
        }
        if (t.getTitlePSLanResId() != null || !bIgnoreNull) {
            dto.setTitlePSLanResId(t.getTitlePSLanResId());
        }
        if (t.getTitlePSLanResName() != null || !bIgnoreNull) {
            dto.setTitlePSLanResName(t.getTitlePSLanResName());
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
        if (StringUtils.hasLength((String)dto.getCacheTag2PSDEFId())) {
            dto.setCacheTag2PSDEFId(this.getRealPSModelId(t, dto.getCacheTag2PSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCacheTagPSDEFId())) {
            dto.setCacheTagPSDEFId(this.getRealPSModelId(t, dto.getCacheTagPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getClsPSDEFId())) {
            dto.setClsPSDEFId(this.getRealPSModelId(t, dto.getClsPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getContentPSDEFId())) {
            dto.setContentPSDEFId(this.getRealPSModelId(t, dto.getContentPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getContentPSLanResId())) {
            dto.setContentPSLanResId(this.getRealPSModelId(t, dto.getContentPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGroupPSDEFId())) {
            dto.setGroupPSDEFId(this.getRealPSModelId(t, dto.getGroupPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getIconPSDEFId())) {
            dto.setIconPSDEFId(this.getRealPSModelId(t, dto.getIconPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMsgPosPSDEFId())) {
            dto.setMsgPosPSDEFId(this.getRealPSModelId(t, dto.getMsgPosPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMsgTypePSDEFId())) {
            dto.setMsgTypePSDEFId(this.getRealPSModelId(t, dto.getMsgTypePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOrderValuePSDEFId())) {
            dto.setOrderValuePSDEFId(this.getRealPSModelId(t, dto.getOrderValuePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            dto.setPSDEDSId(this.getRealPSModelId(t, dto.getPSDEDSId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            dto.setPSDELogicId(this.getRealPSModelId(t, dto.getPSDELogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            dto.setPSModuleId(this.getRealPSModelId(t, dto.getPSModuleId()).replace("/", "."));
        }
        if ("PSMODULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSModuleId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            dto.setPSSysCssId(this.getRealPSModelId(t, dto.getPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            dto.setPSSysImageId(this.getRealPSModelId(t, dto.getPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysMsgTemplId())) {
            dto.setPSSysMsgTemplId(this.getRealPSModelId(t, dto.getPSSysMsgTemplId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            dto.setPSSysViewPanelId(this.getRealPSModelId(t, dto.getPSSysViewPanelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRemovePSDEFId())) {
            dto.setRemovePSDEFId(this.getRealPSModelId(t, dto.getRemovePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTitleLanResTagPSDEFId())) {
            dto.setTitleLanResTagPSDEFId(this.getRealPSModelId(t, dto.getTitleLanResTagPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTitlePSDEFId())) {
            dto.setTitlePSDEFId(this.getRealPSModelId(t, dto.getTitlePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTitlePSLanResId())) {
            dto.setTitlePSLanResId(this.getRealPSModelId(t, dto.getTitlePSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCacheTag2PSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getCacheTag2PSDEFId());
            dto.setCacheTag2PSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setCacheTag2PSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getCacheTagPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getCacheTagPSDEFId());
            dto.setCacheTagPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setCacheTagPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getClsPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getClsPSDEFId());
            dto.setClsPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setClsPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getContentPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getContentPSDEFId());
            dto.setContentPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setContentPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getContentPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getContentPSLanResId());
            dto.setContentPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setContentPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getGroupPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getGroupPSDEFId());
            dto.setGroupPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setGroupPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getIconPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getIconPSDEFId());
            dto.setIconPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setIconPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getMsgPosPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getMsgPosPSDEFId());
            dto.setMsgPosPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setMsgPosPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getMsgTypePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getMsgTypePSDEFId());
            dto.setMsgTypePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setMsgTypePSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getOrderValuePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getOrderValuePSDEFId());
            dto.setOrderValuePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setOrderValuePSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getPSDEDSId());
            dto.setPSDEDSName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setPSDEDSName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getPSDELogicId());
            dto.setPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            linkDTO = (PSModuleDTO)PSModelServiceUtil.getInstance().getPSModuleService().getDTO(dto.getPSModuleId());
            dto.setPSModuleName(((PSModuleDTO)linkDTO).getPSModuleName());
        } else {
            dto.setPSModuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getPSSysCssId());
            dto.setPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            linkDTO = (PSSysImageDTO)PSModelServiceUtil.getInstance().getPSSysImageService().getDTO(dto.getPSSysImageId());
            dto.setPSSysImageName(((PSSysImageDTO)linkDTO).getPSSysImageName());
        } else {
            dto.setPSSysImageName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysMsgTemplId())) {
            linkDTO = (PSSysMsgTemplDTO)PSModelServiceUtil.getInstance().getPSSysMsgTemplService().getDTO(dto.getPSSysMsgTemplId());
            dto.setPSSysMsgTemplName(((PSSysMsgTemplDTO)linkDTO).getPSSysMsgTemplName());
        } else {
            dto.setPSSysMsgTemplName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(((PSSystemDTO)linkDTO).getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            linkDTO = (PSSysViewPanelDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelService().getDTO(dto.getPSSysViewPanelId());
            dto.setPSSysViewPanelName(((PSSysViewPanelDTO)linkDTO).getPSSysViewPanelName());
        } else {
            dto.setPSSysViewPanelName(null);
        }
        if (StringUtils.hasLength((String)dto.getRemovePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getRemovePSDEFId());
            dto.setRemovePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setRemovePSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getTitleLanResTagPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTitleLanResTagPSDEFId());
            dto.setTitleLanResTagPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTitleLanResTagPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getTitlePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTitlePSDEFId());
            dto.setTitlePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTitlePSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getTitlePSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getTitlePSLanResId());
            dto.setTitlePSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setTitlePSLanResName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSVIEWMSG";
    }

    @Override
    public PSViewMsg createDomain() {
        return new PSViewMsg();
    }

    @Override
    public PSViewMsgDTO createDTO() {
        return new PSViewMsgDTO();
    }
}

