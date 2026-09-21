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
import net.ibizsys.modelapi.domain.PSDEOPPrivRole;
import net.ibizsys.modelapi.domain.PSDEUserRole;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEOPPrivRoleDTO;
import net.ibizsys.modelapi.dto.PSDEUserRoleDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysUserDRDTO;
import net.ibizsys.modelapi.service.IPSDEUserRoleService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEUserRoleServiceImpl
extends PSModelServiceImplBase<PSDEUserRole, PSDEUserRoleDTO>
implements IPSDEUserRoleService {
    private static final Log log = LogFactory.getLog(PSDEUserRoleServiceImpl.class);

    @Override
    public List<PSDEUserRole> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEUserRole get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEUserRole> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEUserRole item : list) {
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
    public List<PSDEUserRoleDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEUserRole> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEUserRoleDTO> dtoList = new ArrayList<PSDEUserRoleDTO>();
            for (PSDEUserRole item : list) {
                PSDEUserRoleDTO dto = (PSDEUserRoleDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEUserRole> onListAll() throws Exception {
        ArrayList<PSDEUserRole> list = new ArrayList<PSDEUserRole>();
        List psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEUserRole> items = this.listByPSDataEntity(parent);
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
    protected PSDEUserRole onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEUserRole item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEUserRole)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEUserRoleDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEUserRole et) throws Exception {
        if (StringUtils.hasLength((String)et.getUserRoleTag())) {
            return et.getUserRoleTag();
        }
        if (StringUtils.hasLength((String)et.getPSDEUserRoleName())) {
            return et.getPSDEUserRoleName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEUserRoleDTO dto, PSDEUserRole t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEUserRoleId(t.getId().replace("/", "."));
        }
        if (t.getAllDataFlag() != null || !bIgnoreNull) {
            dto.setAllDataFlag(t.getAllDataFlag());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCustomCond() != null || !bIgnoreNull) {
            dto.setCustomCond(t.getCustomCond());
        }
        if (t.getDefaultFlag() != null || !bIgnoreNull) {
            dto.setDefaultFlag(t.getDefaultFlag());
        }
        if (t.getEnableOrgDR() != null || !bIgnoreNull) {
            dto.setEnableOrgDR(t.getEnableOrgDR());
        }
        if (t.getEnableSecBC() != null || !bIgnoreNull) {
            dto.setEnableSecBC(t.getEnableSecBC());
        }
        if (t.getEnableSecDR() != null || !bIgnoreNull) {
            dto.setEnableSecDR(t.getEnableSecDR());
        }
        if (t.getEnableUserDR() != null || !bIgnoreNull) {
            dto.setEnableUserDR(t.getEnableUserDR());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrgDR() != null || !bIgnoreNull) {
            dto.setOrgDR(t.getOrgDR());
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
        if (t.getPSDEUserRoleName() != null || !bIgnoreNull) {
            dto.setPSDEUserRoleName(t.getPSDEUserRoleName());
        }
        if (t.getPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginId(t.getPSSysSFPluginId());
        }
        if (t.getPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginName(t.getPSSysSFPluginName());
        }
        if (t.getPSSysUserDRId() != null || !bIgnoreNull) {
            dto.setPSSysUserDRId(t.getPSSysUserDRId());
        }
        if (t.getPSSysUserDRId2() != null || !bIgnoreNull) {
            dto.setPSSysUserDRId2(t.getPSSysUserDRId2());
        }
        if (t.getPSSysUserDRName() != null || !bIgnoreNull) {
            dto.setPSSysUserDRName(t.getPSSysUserDRName());
        }
        if (t.getPSSysUserDRName2() != null || !bIgnoreNull) {
            dto.setPSSysUserDRName2(t.getPSSysUserDRName2());
        }
        if (t.getSecBC() != null || !bIgnoreNull) {
            dto.setSecBC(t.getSecBC());
        }
        if (t.getSecDR() != null || !bIgnoreNull) {
            dto.setSecDR(t.getSecDR());
        }
        if (t.getSystemFlag() != null || !bIgnoreNull) {
            dto.setSystemFlag(t.getSystemFlag());
        }
        if (t.getSysUserDR2Param() != null || !bIgnoreNull) {
            dto.setSysUserDR2Param(t.getSysUserDR2Param());
        }
        if (t.getSysUserDRParam() != null || !bIgnoreNull) {
            dto.setSysUserDRParam(t.getSysUserDRParam());
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
        if (t.getUserRoleTag() != null || !bIgnoreNull) {
            dto.setUserRoleTag(t.getUserRoleTag());
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
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysUserDRId())) {
            dto.setPSSysUserDRId(this.getRealPSModelId(t, dto.getPSSysUserDRId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysUserDRId2())) {
            dto.setPSSysUserDRId2(this.getRealPSModelId(t, dto.getPSSysUserDRId2()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getPSSysSFPluginId());
            dto.setPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setPSSysSFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysUserDRId())) {
            linkDTO = (PSSysUserDRDTO)PSModelServiceUtil.getInstance().getPSSysUserDRService().getDTO(dto.getPSSysUserDRId());
            dto.setPSSysUserDRName(((PSSysUserDRDTO)linkDTO).getPSSysUserDRName());
        } else {
            dto.setPSSysUserDRName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysUserDRId2())) {
            linkDTO = (PSSysUserDRDTO)PSModelServiceUtil.getInstance().getPSSysUserDRService().getDTO(dto.getPSSysUserDRId2());
            dto.setPSSysUserDRName2(((PSSysUserDRDTO)linkDTO).getPSSysUserDRName());
        } else {
            dto.setPSSysUserDRName2(null);
        }
        List<PSDEOPPrivRole> list = PSModelServiceUtil.getInstance().getPSDEOPPrivRoleService().listByPSDEUserRole(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDEOPPrivRoleDTO> psdeopprivroles = new ArrayList<PSDEOPPrivRoleDTO>();
            for (PSDEOPPrivRole item : list) {
                PSDEOPPrivRoleDTO dstItem = (PSDEOPPrivRoleDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivRoleService().toDTO(item);
                psdeopprivroles.add(dstItem);
            }
            dto.setPsdeopprivroles(psdeopprivroles);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSDEUSERROLE";
    }

    @Override
    public PSDEUserRole createDomain() {
        return new PSDEUserRole();
    }

    @Override
    public PSDEUserRoleDTO createDTO() {
        return new PSDEUserRoleDTO();
    }
}

