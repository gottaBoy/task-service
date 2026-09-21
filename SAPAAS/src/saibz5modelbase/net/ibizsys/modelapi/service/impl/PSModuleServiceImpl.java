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
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysModelGroup;
import net.ibizsys.modelapi.domain.PSSysRef;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysModelGroupDTO;
import net.ibizsys.modelapi.dto.PSSysRefDTO;
import net.ibizsys.modelapi.dto.PSSysSFPubDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSModuleService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSModuleServiceImpl
extends PSModelServiceImplBase<PSModule, PSModuleDTO>
implements IPSModuleService {
    private static final Log log = LogFactory.getLog(PSModuleServiceImpl.class);

    @Override
    public List<PSModule> listByPSSysModelGroup(PSSysModelGroup parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSModule get(PSSysModelGroup parent, String strKey, boolean bTryMode) throws Exception {
        List<PSModule> list = this.listByPSSysModelGroup(parent);
        if (list != null) {
            for (PSModule item : list) {
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
    public List<PSModuleDTO> listDTOByPSSysModelGroup(String strParentKey) throws Exception {
        PSSysModelGroup pssysmodelgroup = (PSSysModelGroup)PSModelServiceUtil.getInstance().getPSSysModelGroupService().get(strParentKey);
        List<PSModule> list = this.listByPSSysModelGroup(pssysmodelgroup);
        if (list != null) {
            ArrayList<PSModuleDTO> dtoList = new ArrayList<PSModuleDTO>();
            for (PSModule item : list) {
                PSModuleDTO dto = (PSModuleDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSModule> listByPSSysRef(PSSysRef parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSModule get(PSSysRef parent, String strKey, boolean bTryMode) throws Exception {
        List<PSModule> list = this.listByPSSysRef(parent);
        if (list != null) {
            for (PSModule item : list) {
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
    public List<PSModuleDTO> listDTOByPSSysRef(String strParentKey) throws Exception {
        PSSysRef pssysref = (PSSysRef)PSModelServiceUtil.getInstance().getPSSysRefService().get(strParentKey);
        List<PSModule> list = this.listByPSSysRef(pssysref);
        if (list != null) {
            ArrayList<PSModuleDTO> dtoList = new ArrayList<PSModuleDTO>();
            for (PSModule item : list) {
                PSModuleDTO dto = (PSModuleDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSModule> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSModule get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSModule> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSModule item : list) {
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
    public List<PSModuleDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSModule> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSModuleDTO> dtoList = new ArrayList<PSModuleDTO>();
            for (PSModule item : list) {
                PSModuleDTO dto = (PSModuleDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSModule> onListAll() throws Exception {
        List pssystems;
        List pssysrefs;
        ArrayList<PSModule> list = new ArrayList<PSModule>();
        List pssysmodelgroups = PSModelServiceUtil.getInstance().getPSSysModelGroupService().listAll();
        if (pssysmodelgroups != null) {
            for (PSSysModelGroup parent : pssysmodelgroups) {
                List<PSModule> items = this.listByPSSysModelGroup(parent);
                if (items == null) continue;
                list.addAll((Collection<PSModule>)items);
            }
        }
        if ((pssysrefs = PSModelServiceUtil.getInstance().getPSSysRefService().listAll()) != null) {
            for (PSSysRef parent : pssysrefs) {
                List<PSModule> items = this.listByPSSysRef(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSModule> items = this.listByPSSystem(parent);
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
    protected PSModule onGet(String strParentKey, String strCurKey) throws Exception {
        PSModule item;
        PSModule item2;
        PSModule item3;
        PSSysModelGroup pssysmodelgroup = (PSSysModelGroup)PSModelServiceUtil.getInstance().getPSSysModelGroupService().get(strParentKey, true);
        if (pssysmodelgroup != null && (item3 = this.get(pssysmodelgroup, strCurKey, true)) != null) {
            return item3;
        }
        PSSysRef pssysref = (PSSysRef)PSModelServiceUtil.getInstance().getPSSysRefService().get(strParentKey, true);
        if (pssysref != null && (item2 = this.get(pssysref, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSModule)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSModuleDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysModelGroupId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysModelGroupService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSSysRefId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysRefService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSSystemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSystemService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSModule et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSModuleDTO dto, PSModule t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSModuleId(t.getId().replace("/", "."));
        }
        if (t.getClsPkgParams() != null || !bIgnoreNull) {
            dto.setClsPkgParams(t.getClsPkgParams());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getColor() != null || !bIgnoreNull) {
            dto.setColor(t.getColor());
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
        if (t.getDSLink() != null || !bIgnoreNull) {
            dto.setDSLink(t.getDSLink());
        }
        if (t.getDTOFormat() != null || !bIgnoreNull) {
            dto.setDTOFormat(t.getDTOFormat());
        }
        if (t.getDynaInstMode() != null || !bIgnoreNull) {
            dto.setDynaInstMode(t.getDynaInstMode());
        }
        if (t.getDynaInstTag() != null || !bIgnoreNull) {
            dto.setDynaInstTag(t.getDynaInstTag());
        }
        if (t.getDynaInstTag2() != null || !bIgnoreNull) {
            dto.setDynaInstTag2(t.getDynaInstTag2());
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
        if (t.getModTag() != null || !bIgnoreNull) {
            dto.setModTag(t.getModTag());
        }
        if (t.getModTag2() != null || !bIgnoreNull) {
            dto.setModTag2(t.getModTag2());
        }
        if (t.getModTag3() != null || !bIgnoreNull) {
            dto.setModTag3(t.getModTag3());
        }
        if (t.getModTag4() != null || !bIgnoreNull) {
            dto.setModTag4(t.getModTag4());
        }
        if (t.getModuleSN() != null || !bIgnoreNull) {
            dto.setModuleSN(t.getModuleSN());
        }
        if (t.getNoViewMode() != null || !bIgnoreNull) {
            dto.setNoViewMode(t.getNoViewMode());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPKGCodeName() != null || !bIgnoreNull) {
            dto.setPKGCodeName(t.getPKGCodeName());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
        }
        if (t.getPSSysModelGroupId() != null || !bIgnoreNull) {
            dto.setPSSysModelGroupId(t.getPSSysModelGroupId());
        }
        if (t.getPSSysModelGroupName() != null || !bIgnoreNull) {
            dto.setPSSysModelGroupName(t.getPSSysModelGroupName());
        }
        if (t.getPSSysRefId() != null || !bIgnoreNull) {
            dto.setPSSysRefId(t.getPSSysRefId());
        }
        if (t.getPSSysRefName() != null || !bIgnoreNull) {
            dto.setPSSysRefName(t.getPSSysRefName());
        }
        if (t.getPSSysSFPubId() != null || !bIgnoreNull) {
            dto.setPSSysSFPubId(t.getPSSysSFPubId());
        }
        if (t.getPSSysSFPubName() != null || !bIgnoreNull) {
            dto.setPSSysSFPubName(t.getPSSysSFPubName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getServiceAPIFlag() != null || !bIgnoreNull) {
            dto.setServiceAPIFlag(t.getServiceAPIFlag());
        }
        if (t.getShortTag() != null || !bIgnoreNull) {
            dto.setShortTag(t.getShortTag());
        }
        if (t.getSubSysModule() != null || !bIgnoreNull) {
            dto.setSubSysModule(t.getSubSysModule());
        }
        if (t.getSysRefType() != null || !bIgnoreNull) {
            dto.setSysRefType(t.getSysRefType());
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
        if (t.getUserParams() != null || !bIgnoreNull) {
            dto.setUserParams(t.getUserParams());
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
        if (t.getUtilParams() != null || !bIgnoreNull) {
            dto.setUtilParams(t.getUtilParams());
        }
        if (t.getUtilTag() != null || !bIgnoreNull) {
            dto.setUtilTag(t.getUtilTag());
        }
        if (t.getUtilType() != null || !bIgnoreNull) {
            dto.setUtilType(t.getUtilType());
        }
        if (StringUtils.hasLength((String)dto.getPSSysModelGroupId())) {
            dto.setPSSysModelGroupId(this.getRealPSModelId(t, dto.getPSSysModelGroupId()).replace("/", "."));
        }
        if ("PSSYSMODELGROUP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysModelGroupId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysRefId())) {
            dto.setPSSysRefId(this.getRealPSModelId(t, dto.getPSSysRefId()).replace("/", "."));
        }
        if ("PSSYSREF".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysRefId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPubId())) {
            dto.setPSSysSFPubId(this.getRealPSModelId(t, dto.getPSSysSFPubId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysModelGroupId())) {
            linkDTO = (PSSysModelGroupDTO)PSModelServiceUtil.getInstance().getPSSysModelGroupService().getDTO(dto.getPSSysModelGroupId());
            dto.setPSSysModelGroupName(((PSSysModelGroupDTO)linkDTO).getPSSysModelGroupName());
        } else {
            dto.setPSSysModelGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysRefId())) {
            linkDTO = (PSSysRefDTO)PSModelServiceUtil.getInstance().getPSSysRefService().getDTO(dto.getPSSysRefId());
            dto.setPSSysRefName(((PSSysRefDTO)linkDTO).getPSSysRefName());
        } else {
            dto.setPSSysRefName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPubId())) {
            linkDTO = (PSSysSFPubDTO)PSModelServiceUtil.getInstance().getPSSysSFPubService().getDTO(dto.getPSSysSFPubId());
            dto.setPSSysSFPubName(((PSSysSFPubDTO)linkDTO).getPSSysSFPubName());
        } else {
            dto.setPSSysSFPubName(null);
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
        return "PSMODULE";
    }

    @Override
    public PSModule createDomain() {
        return new PSModule();
    }

    @Override
    public PSModuleDTO createDTO() {
        return new PSModuleDTO();
    }
}

