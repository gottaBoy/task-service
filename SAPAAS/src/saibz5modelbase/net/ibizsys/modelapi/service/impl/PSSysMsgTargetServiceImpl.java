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
import net.ibizsys.modelapi.domain.PSSysMsgTarget;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysMsgTargetDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysUtilDEDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysMsgTargetService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysMsgTargetServiceImpl
extends PSModelServiceImplBase<PSSysMsgTarget, PSSysMsgTargetDTO>
implements IPSSysMsgTargetService {
    private static final Log log = LogFactory.getLog(PSSysMsgTargetServiceImpl.class);

    @Override
    public List<PSSysMsgTarget> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysMsgTarget get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysMsgTarget> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSSysMsgTarget item : list) {
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
    public List<PSSysMsgTargetDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSSysMsgTarget> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSSysMsgTargetDTO> dtoList = new ArrayList<PSSysMsgTargetDTO>();
            for (PSSysMsgTarget item : list) {
                PSSysMsgTargetDTO dto = (PSSysMsgTargetDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysMsgTarget> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysMsgTarget get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysMsgTarget> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysMsgTarget item : list) {
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
    public List<PSSysMsgTargetDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysMsgTarget> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysMsgTargetDTO> dtoList = new ArrayList<PSSysMsgTargetDTO>();
            for (PSSysMsgTarget item : list) {
                PSSysMsgTargetDTO dto = (PSSysMsgTargetDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysMsgTarget> onListAll() throws Exception {
        List<PSSystem> pssystems;
        ArrayList<PSSysMsgTarget> list = new ArrayList<PSSysMsgTarget>();
        List<PSModule> psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll();
        if (psmodules != null) {
            for (PSModule parent : psmodules) {
                List<PSSysMsgTarget> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysMsgTarget> items = this.listByPSSystem(parent);
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
    protected PSSysMsgTarget onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysMsgTarget item;
        PSSysMsgTarget item2;
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item2 = this.get(psmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysMsgTarget)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysMsgTargetDTO dto) throws Exception {
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
    public String getModelTag(PSSysMsgTarget et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSSysMsgTargetName())) {
            return et.getPSSysMsgTargetName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysMsgTargetDTO dto, PSSysMsgTarget t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysMsgTargetId(t.getId().replace("/", "."));
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
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMsgTargetTag() != null || !bIgnoreNull) {
            dto.setMsgTargetTag(t.getMsgTargetTag());
        }
        if (t.getMsgTargetTag2() != null || !bIgnoreNull) {
            dto.setMsgTargetTag2(t.getMsgTargetTag2());
        }
        if (t.getMsgTargetType() != null || !bIgnoreNull) {
            dto.setMsgTargetType(t.getMsgTargetType());
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
        if (t.getPSSysMsgTargetName() != null || !bIgnoreNull) {
            dto.setPSSysMsgTargetName(t.getPSSysMsgTargetName());
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
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            dto.setPSDEDSId(this.getRealPSModelId(t, dto.getPSDEDSId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getTargetPSDEFId())) {
            dto.setTargetPSDEFId(this.getRealPSModelId(t, dto.getTargetPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTargetTypePSDEFId())) {
            dto.setTargetTypePSDEFId(this.getRealPSModelId(t, dto.getTargetTypePSDEFId()).replace("/", "."));
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
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSMSGTARGET";
    }

    @Override
    public PSSysMsgTarget createDomain() {
        return new PSSysMsgTarget();
    }

    @Override
    public PSSysMsgTargetDTO createDTO() {
        return new PSSysMsgTargetDTO();
    }
}

