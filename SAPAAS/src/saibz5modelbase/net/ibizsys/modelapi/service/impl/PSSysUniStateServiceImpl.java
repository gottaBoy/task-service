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
import net.ibizsys.modelapi.domain.PSSysUniState;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysUniStateDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysUniStateService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysUniStateServiceImpl
extends PSModelServiceImplBase<PSSysUniState, PSSysUniStateDTO>
implements IPSSysUniStateService {
    private static final Log log = LogFactory.getLog(PSSysUniStateServiceImpl.class);

    @Override
    public List<PSSysUniState> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysUniState get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysUniState> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSSysUniState item : list) {
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
    public List<PSSysUniStateDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSSysUniState> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSSysUniStateDTO> dtoList = new ArrayList<PSSysUniStateDTO>();
            for (PSSysUniState item : list) {
                PSSysUniStateDTO dto = (PSSysUniStateDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysUniState> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysUniState get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysUniState> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysUniState item : list) {
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
    public List<PSSysUniStateDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysUniState> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysUniStateDTO> dtoList = new ArrayList<PSSysUniStateDTO>();
            for (PSSysUniState item : list) {
                PSSysUniStateDTO dto = (PSSysUniStateDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysUniState> onListAll() throws Exception {
        List<PSSystem> pssystems;
        ArrayList<PSSysUniState> list = new ArrayList<PSSysUniState>();
        List<PSModule> psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll();
        if (psmodules != null) {
            for (PSModule parent : psmodules) {
                List<PSSysUniState> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysUniState> items = this.listByPSSystem(parent);
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
    protected PSSysUniState onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysUniState item;
        PSSysUniState item2;
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item2 = this.get(psmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysUniState)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysUniStateDTO dto) throws Exception {
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
    public String getModelTag(PSSysUniState et) throws Exception {
        if (StringUtils.hasLength((String)et.getUniqueTag())) {
            return et.getUniqueTag();
        }
        if (StringUtils.hasLength((String)et.getPSSysUniStateName())) {
            return et.getPSSysUniStateName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysUniStateDTO dto, PSSysUniState t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysUniStateId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDEDefaultFlag() != null || !bIgnoreNull) {
            dto.setDEDefaultFlag(t.getDEDefaultFlag());
        }
        if (t.getKey2PSDEFId() != null || !bIgnoreNull) {
            dto.setKey2PSDEFId(t.getKey2PSDEFId());
        }
        if (t.getKey2PSDEFName() != null || !bIgnoreNull) {
            dto.setKey2PSDEFName(t.getKey2PSDEFName());
        }
        if (t.getKey3PSDEFId() != null || !bIgnoreNull) {
            dto.setKey3PSDEFId(t.getKey3PSDEFId());
        }
        if (t.getKey3PSDEFName() != null || !bIgnoreNull) {
            dto.setKey3PSDEFName(t.getKey3PSDEFName());
        }
        if (t.getKey4PSDEFId() != null || !bIgnoreNull) {
            dto.setKey4PSDEFId(t.getKey4PSDEFId());
        }
        if (t.getKey4PSDEFName() != null || !bIgnoreNull) {
            dto.setKey4PSDEFName(t.getKey4PSDEFName());
        }
        if (t.getKeyPSDEFId() != null || !bIgnoreNull) {
            dto.setKeyPSDEFId(t.getKeyPSDEFId());
        }
        if (t.getKeyPSDEFName() != null || !bIgnoreNull) {
            dto.setKeyPSDEFName(t.getKeyPSDEFName());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
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
        if (t.getPSSysUniStateName() != null || !bIgnoreNull) {
            dto.setPSSysUniStateName(t.getPSSysUniStateName());
        }
        if (t.getState2PSDEFId() != null || !bIgnoreNull) {
            dto.setState2PSDEFId(t.getState2PSDEFId());
        }
        if (t.getState2PSDEFName() != null || !bIgnoreNull) {
            dto.setState2PSDEFName(t.getState2PSDEFName());
        }
        if (t.getState3PSDEFId() != null || !bIgnoreNull) {
            dto.setState3PSDEFId(t.getState3PSDEFId());
        }
        if (t.getState3PSDEFName() != null || !bIgnoreNull) {
            dto.setState3PSDEFName(t.getState3PSDEFName());
        }
        if (t.getState4PSDEFId() != null || !bIgnoreNull) {
            dto.setState4PSDEFId(t.getState4PSDEFId());
        }
        if (t.getState4PSDEFName() != null || !bIgnoreNull) {
            dto.setState4PSDEFName(t.getState4PSDEFName());
        }
        if (t.getState5PSDEFId() != null || !bIgnoreNull) {
            dto.setState5PSDEFId(t.getState5PSDEFId());
        }
        if (t.getState5PSDEFName() != null || !bIgnoreNull) {
            dto.setState5PSDEFName(t.getState5PSDEFName());
        }
        if (t.getState6PSDEFId() != null || !bIgnoreNull) {
            dto.setState6PSDEFId(t.getState6PSDEFId());
        }
        if (t.getState6PSDEFName() != null || !bIgnoreNull) {
            dto.setState6PSDEFName(t.getState6PSDEFName());
        }
        if (t.getState7PSDEFId() != null || !bIgnoreNull) {
            dto.setState7PSDEFId(t.getState7PSDEFId());
        }
        if (t.getState7PSDEFName() != null || !bIgnoreNull) {
            dto.setState7PSDEFName(t.getState7PSDEFName());
        }
        if (t.getState8PSDEFId() != null || !bIgnoreNull) {
            dto.setState8PSDEFId(t.getState8PSDEFId());
        }
        if (t.getState8PSDEFName() != null || !bIgnoreNull) {
            dto.setState8PSDEFName(t.getState8PSDEFName());
        }
        if (t.getStatePSDEFId() != null || !bIgnoreNull) {
            dto.setStatePSDEFId(t.getStatePSDEFId());
        }
        if (t.getStatePSDEFName() != null || !bIgnoreNull) {
            dto.setStatePSDEFName(t.getStatePSDEFName());
        }
        if (t.getUniqueTag() != null || !bIgnoreNull) {
            dto.setUniqueTag(t.getUniqueTag());
        }
        if (t.getUniStateType() != null || !bIgnoreNull) {
            dto.setUniStateType(t.getUniStateType());
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
        if (StringUtils.hasLength((String)dto.getKey2PSDEFId())) {
            dto.setKey2PSDEFId(this.getRealPSModelId(t, dto.getKey2PSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getKey3PSDEFId())) {
            dto.setKey3PSDEFId(this.getRealPSModelId(t, dto.getKey3PSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getKey4PSDEFId())) {
            dto.setKey4PSDEFId(this.getRealPSModelId(t, dto.getKey4PSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getKeyPSDEFId())) {
            dto.setKeyPSDEFId(this.getRealPSModelId(t, dto.getKeyPSDEFId()).replace("/", "."));
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
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getState2PSDEFId())) {
            dto.setState2PSDEFId(this.getRealPSModelId(t, dto.getState2PSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getState3PSDEFId())) {
            dto.setState3PSDEFId(this.getRealPSModelId(t, dto.getState3PSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getState4PSDEFId())) {
            dto.setState4PSDEFId(this.getRealPSModelId(t, dto.getState4PSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getState5PSDEFId())) {
            dto.setState5PSDEFId(this.getRealPSModelId(t, dto.getState5PSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getState6PSDEFId())) {
            dto.setState6PSDEFId(this.getRealPSModelId(t, dto.getState6PSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getState7PSDEFId())) {
            dto.setState7PSDEFId(this.getRealPSModelId(t, dto.getState7PSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getState8PSDEFId())) {
            dto.setState8PSDEFId(this.getRealPSModelId(t, dto.getState8PSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getStatePSDEFId())) {
            dto.setStatePSDEFId(this.getRealPSModelId(t, dto.getStatePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getKey2PSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getKey2PSDEFId());
            dto.setKey2PSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setKey2PSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getKey3PSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getKey3PSDEFId());
            dto.setKey3PSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setKey3PSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getKey4PSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getKey4PSDEFId());
            dto.setKey4PSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setKey4PSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getKeyPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getKeyPSDEFId());
            dto.setKeyPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setKeyPSDEFName(null);
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
        if (StringUtils.hasLength((String)dto.getState2PSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getState2PSDEFId());
            dto.setState2PSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setState2PSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getState3PSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getState3PSDEFId());
            dto.setState3PSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setState3PSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getState4PSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getState4PSDEFId());
            dto.setState4PSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setState4PSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getState5PSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getState5PSDEFId());
            dto.setState5PSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setState5PSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getState6PSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getState6PSDEFId());
            dto.setState6PSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setState6PSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getState7PSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getState7PSDEFId());
            dto.setState7PSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setState7PSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getState8PSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getState8PSDEFId());
            dto.setState8PSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setState8PSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getStatePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getStatePSDEFId());
            dto.setStatePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setStatePSDEFName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSUNISTATE";
    }

    @Override
    public PSSysUniState createDomain() {
        return new PSSysUniState();
    }

    @Override
    public PSSysUniStateDTO createDTO() {
        return new PSSysUniStateDTO();
    }
}

