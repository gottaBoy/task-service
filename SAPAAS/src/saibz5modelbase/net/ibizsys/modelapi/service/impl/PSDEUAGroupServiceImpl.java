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
import net.ibizsys.modelapi.domain.PSDEUAGroup;
import net.ibizsys.modelapi.domain.PSDEUAGroupDetail;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.domain.PSWFVersion;
import net.ibizsys.modelapi.domain.PSWorkflow;
import net.ibizsys.modelapi.dto.PSDEUAGroupDTO;
import net.ibizsys.modelapi.dto.PSDEUAGroupDetailDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.dto.PSWFProcessDTO;
import net.ibizsys.modelapi.dto.PSWFVersionDTO;
import net.ibizsys.modelapi.dto.PSWorkflowDTO;
import net.ibizsys.modelapi.service.IPSDEUAGroupService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEUAGroupServiceImpl
extends PSModelServiceImplBase<PSDEUAGroup, PSDEUAGroupDTO>
implements IPSDEUAGroupService {
    private static final Log log = LogFactory.getLog(PSDEUAGroupServiceImpl.class);

    @Override
    public List<PSDEUAGroup> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEUAGroup get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEUAGroup> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEUAGroup item : list) {
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
    public List<PSDEUAGroupDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEUAGroup> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEUAGroupDTO> dtoList = new ArrayList<PSDEUAGroupDTO>();
            for (PSDEUAGroup item : list) {
                PSDEUAGroupDTO dto = (PSDEUAGroupDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEUAGroup> listByPSWFVersion(PSWFVersion parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEUAGroup get(PSWFVersion parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEUAGroup> list = this.listByPSWFVersion(parent);
        if (list != null) {
            for (PSDEUAGroup item : list) {
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
    public List<PSDEUAGroupDTO> listDTOByPSWFVersion(String strParentKey) throws Exception {
        PSWFVersion pswfversion = (PSWFVersion)PSModelServiceUtil.getInstance().getPSWFVersionService().get(strParentKey);
        List<PSDEUAGroup> list = this.listByPSWFVersion(pswfversion);
        if (list != null) {
            ArrayList<PSDEUAGroupDTO> dtoList = new ArrayList<PSDEUAGroupDTO>();
            for (PSDEUAGroup item : list) {
                PSDEUAGroupDTO dto = (PSDEUAGroupDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEUAGroup> listByPSWorkflow(PSWorkflow parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEUAGroup get(PSWorkflow parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEUAGroup> list = this.listByPSWorkflow(parent);
        if (list != null) {
            for (PSDEUAGroup item : list) {
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
    public List<PSDEUAGroupDTO> listDTOByPSWorkflow(String strParentKey) throws Exception {
        PSWorkflow psworkflow = (PSWorkflow)PSModelServiceUtil.getInstance().getPSWorkflowService().get(strParentKey);
        List<PSDEUAGroup> list = this.listByPSWorkflow(psworkflow);
        if (list != null) {
            ArrayList<PSDEUAGroupDTO> dtoList = new ArrayList<PSDEUAGroupDTO>();
            for (PSDEUAGroup item : list) {
                PSDEUAGroupDTO dto = (PSDEUAGroupDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEUAGroup> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEUAGroup get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEUAGroup> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSDEUAGroup item : list) {
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
    public List<PSDEUAGroupDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSDEUAGroup> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSDEUAGroupDTO> dtoList = new ArrayList<PSDEUAGroupDTO>();
            for (PSDEUAGroup item : list) {
                PSDEUAGroupDTO dto = (PSDEUAGroupDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEUAGroup> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEUAGroup get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEUAGroup> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSDEUAGroup item : list) {
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
    public List<PSDEUAGroupDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSDEUAGroup> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSDEUAGroupDTO> dtoList = new ArrayList<PSDEUAGroupDTO>();
            for (PSDEUAGroup item : list) {
                PSDEUAGroupDTO dto = (PSDEUAGroupDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEUAGroup> onListAll() throws Exception {
        List pssystems;
        List psmodules;
        List psworkflows;
        List pswfversions;
        ArrayList<PSDEUAGroup> list = new ArrayList<PSDEUAGroup>();
        List psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEUAGroup> items = this.listByPSDataEntity(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pswfversions = PSModelServiceUtil.getInstance().getPSWFVersionService().listAll()) != null) {
            for (PSWFVersion parent : pswfversions) {
                List<PSDEUAGroup> items = this.listByPSWFVersion(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((psworkflows = PSModelServiceUtil.getInstance().getPSWorkflowService().listAll()) != null) {
            for (PSWorkflow parent : psworkflows) {
                List<PSDEUAGroup> items = this.listByPSWorkflow(parent);
                if (items == null) continue;
                list.addAll((Collection<PSDEUAGroup>)items);
            }
        }
        if ((psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll()) != null) {
            for (PSModule parent : psmodules) {
                List<PSDEUAGroup> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSDEUAGroup> items = this.listByPSSystem(parent);
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
    protected PSDEUAGroup onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEUAGroup item;
        PSDEUAGroup item2;
        PSDEUAGroup item3;
        PSDEUAGroup item4;
        PSDEUAGroup item5;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item5 = this.get(psdataentity, strCurKey, true)) != null) {
            return item5;
        }
        PSWFVersion pswfversion = (PSWFVersion)PSModelServiceUtil.getInstance().getPSWFVersionService().get(strParentKey, true);
        if (pswfversion != null && (item4 = this.get(pswfversion, strCurKey, true)) != null) {
            return item4;
        }
        PSWorkflow psworkflow = (PSWorkflow)PSModelServiceUtil.getInstance().getPSWorkflowService().get(strParentKey, true);
        if (psworkflow != null && (item3 = this.get(psworkflow, strCurKey, true)) != null) {
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
        return (PSDEUAGroup)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEUAGroupDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSWFVersionId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWFVersionService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSWFId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWorkflowService().get(strPickupValue, false);
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
    public String getModelTag(PSDEUAGroup et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEUAGroupDTO dto, PSDEUAGroup t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEUAGroupId(t.getId().replace("/", "."));
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
        if (t.getPSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupName(t.getPSDEUAGroupName());
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
        if (t.getPSWFId() != null || !bIgnoreNull) {
            dto.setPSWFId(t.getPSWFId());
        }
        if (t.getPSWFName() != null || !bIgnoreNull) {
            dto.setPSWFName(t.getPSWFName());
        }
        if (t.getPSWFProcessId() != null || !bIgnoreNull) {
            dto.setPSWFProcessId(t.getPSWFProcessId());
        }
        if (t.getPSWFProcessName() != null || !bIgnoreNull) {
            dto.setPSWFProcessName(t.getPSWFProcessName());
        }
        if (t.getPSWFVersionId() != null || !bIgnoreNull) {
            dto.setPSWFVersionId(t.getPSWFVersionId());
        }
        if (t.getPSWFVersionName() != null || !bIgnoreNull) {
            dto.setPSWFVersionName(t.getPSWFVersionName());
        }
        if (t.getUAGroupParam() != null || !bIgnoreNull) {
            dto.setUAGroupParam(t.getUAGroupParam());
        }
        if (t.getUAGTag() != null || !bIgnoreNull) {
            dto.setUAGTag(t.getUAGTag());
        }
        if (t.getUAGTag2() != null || !bIgnoreNull) {
            dto.setUAGTag2(t.getUAGTag2());
        }
        if (t.getUAGTag3() != null || !bIgnoreNull) {
            dto.setUAGTag3(t.getUAGTag3());
        }
        if (t.getUAGTag4() != null || !bIgnoreNull) {
            dto.setUAGTag4(t.getUAGTag4());
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
        if (StringUtils.hasLength((String)dto.getPSWFId())) {
            dto.setPSWFId(this.getRealPSModelId(t, dto.getPSWFId()).replace("/", "."));
        }
        if ("PSWORKFLOW".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWFId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFProcessId())) {
            dto.setPSWFProcessId(this.getRealPSModelId(t, dto.getPSWFProcessId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFVersionId())) {
            dto.setPSWFVersionId(this.getRealPSModelId(t, dto.getPSWFVersionId()).replace("/", "."));
        }
        if ("PSWFVERSION".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWFVersionId(t.getSrfParent().getId().replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSWFId())) {
            linkDTO = (PSWorkflowDTO)PSModelServiceUtil.getInstance().getPSWorkflowService().getDTO(dto.getPSWFId());
            dto.setPSWFName(((PSWorkflowDTO)linkDTO).getPSWorkflowName());
        } else {
            dto.setPSWFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFProcessId())) {
            linkDTO = (PSWFProcessDTO)PSModelServiceUtil.getInstance().getPSWFProcessService().getDTO(dto.getPSWFProcessId(), true);
        }
        if (StringUtils.hasLength((String)dto.getPSWFVersionId())) {
            linkDTO = (PSWFVersionDTO)PSModelServiceUtil.getInstance().getPSWFVersionService().getDTO(dto.getPSWFVersionId());
            dto.setPSWFVersionName(((PSWFVersionDTO)linkDTO).getPSWFVersionName());
        } else {
            dto.setPSWFVersionName(null);
        }
        List<PSDEUAGroupDetail> list = PSModelServiceUtil.getInstance().getPSDEUAGroupDetailService().listByPSDEUAGroup(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDEUAGroupDetailDTO> psdeuagrpdetails = new ArrayList<PSDEUAGroupDetailDTO>();
            for (PSDEUAGroupDetail item : list) {
                PSDEUAGroupDetailDTO dstItem = (PSDEUAGroupDetailDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupDetailService().toDTO(item);
                psdeuagrpdetails.add(dstItem);
            }
            dto.setPsdeuagrpdetails(psdeuagrpdetails);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEUAGROUP";
    }

    @Override
    public PSDEUAGroup createDomain() {
        return new PSDEUAGroup();
    }

    @Override
    public PSDEUAGroupDTO createDTO() {
        return new PSDEUAGroupDTO();
    }
}

