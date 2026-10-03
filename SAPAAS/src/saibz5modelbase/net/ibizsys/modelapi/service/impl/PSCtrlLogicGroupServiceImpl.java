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
import java.util.Collection;
import java.util.List;
import net.ibizsys.modelapi.domain.PSCtrlLogicGroup;
import net.ibizsys.modelapi.domain.PSCtrlLogicGrpDetail;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSCtrlLogicGroupDTO;
import net.ibizsys.modelapi.dto.PSCtrlLogicGrpDetailDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSCtrlLogicGroupService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSCtrlLogicGroupServiceImpl
extends PSModelServiceImplBase<PSCtrlLogicGroup, PSCtrlLogicGroupDTO>
implements IPSCtrlLogicGroupService {
    private static final Log log = LogFactory.getLog(PSCtrlLogicGroupServiceImpl.class);

    @Override
    public List<PSCtrlLogicGroup> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSCtrlLogicGroup get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSCtrlLogicGroup> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSCtrlLogicGroup item : list) {
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
    public List<PSCtrlLogicGroupDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSCtrlLogicGroup> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSCtrlLogicGroupDTO> dtoList = new ArrayList<PSCtrlLogicGroupDTO>();
            for (PSCtrlLogicGroup item : list) {
                PSCtrlLogicGroupDTO dto = (PSCtrlLogicGroupDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSCtrlLogicGroup> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSCtrlLogicGroup get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSCtrlLogicGroup> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSCtrlLogicGroup item : list) {
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
    public List<PSCtrlLogicGroupDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSCtrlLogicGroup> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSCtrlLogicGroupDTO> dtoList = new ArrayList<PSCtrlLogicGroupDTO>();
            for (PSCtrlLogicGroup item : list) {
                PSCtrlLogicGroupDTO dto = (PSCtrlLogicGroupDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSCtrlLogicGroup> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSCtrlLogicGroup get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSCtrlLogicGroup> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSCtrlLogicGroup item : list) {
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
    public List<PSCtrlLogicGroupDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSCtrlLogicGroup> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSCtrlLogicGroupDTO> dtoList = new ArrayList<PSCtrlLogicGroupDTO>();
            for (PSCtrlLogicGroup item : list) {
                PSCtrlLogicGroupDTO dto = (PSCtrlLogicGroupDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSCtrlLogicGroup> onListAll() throws Exception {
        List<PSSystem> pssystems;
        List<PSModule> psmodules;
        ArrayList<PSCtrlLogicGroup> list = new ArrayList<PSCtrlLogicGroup>();
        List<PSDataEntity> psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSCtrlLogicGroup> items = this.listByPSDataEntity(parent);
                if (items == null) continue;
                list.addAll((Collection<PSCtrlLogicGroup>)items);
            }
        }
        if ((psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll()) != null) {
            for (PSModule parent : psmodules) {
                List<PSCtrlLogicGroup> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSCtrlLogicGroup> items = this.listByPSSystem(parent);
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
    protected PSCtrlLogicGroup onGet(String strParentKey, String strCurKey) throws Exception {
        PSCtrlLogicGroup item;
        PSCtrlLogicGroup item2;
        PSCtrlLogicGroup item3;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item3 = this.get(psdataentity, strCurKey, true)) != null) {
            return item3;
        }
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item2 = this.get(psmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSCtrlLogicGroup)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSCtrlLogicGroupDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
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
    public String getModelTag(PSCtrlLogicGroup et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSCtrlLogicGroupName())) {
            return et.getPSCtrlLogicGroupName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSCtrlLogicGroupDTO dto, PSCtrlLogicGroup t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSCtrlLogicGroupId(t.getId().replace("/", "."));
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
        if (t.getCtrlType() != null || !bIgnoreNull) {
            dto.setCtrlType(t.getCtrlType());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPPSCtrlLogicGroupId() != null || !bIgnoreNull) {
            dto.setPPSCtrlLogicGroupId(t.getPPSCtrlLogicGroupId());
        }
        if (t.getPPSCtrlLogicGroupName() != null || !bIgnoreNull) {
            dto.setPPSCtrlLogicGroupName(t.getPPSCtrlLogicGroupName());
        }
        if (t.getPSCtrlLogicGroupName() != null || !bIgnoreNull) {
            dto.setPSCtrlLogicGroupName(t.getPSCtrlLogicGroupName());
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
        if (StringUtils.hasLength((String)dto.getPPSCtrlLogicGroupId())) {
            dto.setPPSCtrlLogicGroupId(this.getRealPSModelId(t, dto.getPPSCtrlLogicGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPPSCtrlLogicGroupId())) {
            linkDTO = (PSCtrlLogicGroupDTO)PSModelServiceUtil.getInstance().getPSCtrlLogicGroupService().getDTO(dto.getPPSCtrlLogicGroupId());
            dto.setPPSCtrlLogicGroupName(((PSCtrlLogicGroupDTO)linkDTO).getPSCtrlLogicGroupName());
        } else {
            dto.setPPSCtrlLogicGroupName(null);
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
        List<PSCtrlLogicGrpDetail> list = PSModelServiceUtil.getInstance().getPSCtrlLogicGrpDetailService().listByPSCtrlLogicGroup(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSCtrlLogicGrpDetailDTO> psctrllogicgrpdetails = new ArrayList<PSCtrlLogicGrpDetailDTO>();
            for (PSCtrlLogicGrpDetail item : list) {
                PSCtrlLogicGrpDetailDTO dstItem = (PSCtrlLogicGrpDetailDTO)PSModelServiceUtil.getInstance().getPSCtrlLogicGrpDetailService().toDTO(item);
                psctrllogicgrpdetails.add(dstItem);
            }
            dto.setPsctrllogicgrpdetails(psctrllogicgrpdetails);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSCTRLLOGICGROUP";
    }

    @Override
    public PSCtrlLogicGroup createDomain() {
        return new PSCtrlLogicGroup();
    }

    @Override
    public PSCtrlLogicGroupDTO createDTO() {
        return new PSCtrlLogicGroupDTO();
    }
}

