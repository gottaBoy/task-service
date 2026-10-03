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
import net.ibizsys.modelapi.domain.PSDEOPPrivRole;
import net.ibizsys.modelapi.domain.PSDEUserRole;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSSysOPPriv;
import net.ibizsys.modelapi.dto.PSDEDataQueryDTO;
import net.ibizsys.modelapi.dto.PSDEOPPrivDTO;
import net.ibizsys.modelapi.dto.PSDEOPPrivRoleDTO;
import net.ibizsys.modelapi.dto.PSDEUserRoleDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysOPPrivDTO;
import net.ibizsys.modelapi.service.IPSDEOPPrivRoleService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEOPPrivRoleServiceImpl
extends PSModelServiceImplBase<PSDEOPPrivRole, PSDEOPPrivRoleDTO>
implements IPSDEOPPrivRoleService {
    private static final Log log = LogFactory.getLog(PSDEOPPrivRoleServiceImpl.class);

    @Override
    public List<PSDEOPPrivRole> listByPSDEUserRole(PSDEUserRole parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEOPPrivRole get(PSDEUserRole parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEOPPrivRole> list = this.listByPSDEUserRole(parent);
        if (list != null) {
            for (PSDEOPPrivRole item : list) {
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
    public List<PSDEOPPrivRoleDTO> listDTOByPSDEUserRole(String strParentKey) throws Exception {
        PSDEUserRole psdeuserrole = (PSDEUserRole)PSModelServiceUtil.getInstance().getPSDEUserRoleService().get(strParentKey);
        List<PSDEOPPrivRole> list = this.listByPSDEUserRole(psdeuserrole);
        if (list != null) {
            ArrayList<PSDEOPPrivRoleDTO> dtoList = new ArrayList<PSDEOPPrivRoleDTO>();
            for (PSDEOPPrivRole item : list) {
                PSDEOPPrivRoleDTO dto = (PSDEOPPrivRoleDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEOPPrivRole> listByPSSysOPPriv(PSSysOPPriv parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEOPPrivRole get(PSSysOPPriv parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEOPPrivRole> list = this.listByPSSysOPPriv(parent);
        if (list != null) {
            for (PSDEOPPrivRole item : list) {
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
    public List<PSDEOPPrivRoleDTO> listDTOByPSSysOPPriv(String strParentKey) throws Exception {
        PSSysOPPriv pssysoppriv = (PSSysOPPriv)PSModelServiceUtil.getInstance().getPSSysOPPrivService().get(strParentKey);
        List<PSDEOPPrivRole> list = this.listByPSSysOPPriv(pssysoppriv);
        if (list != null) {
            ArrayList<PSDEOPPrivRoleDTO> dtoList = new ArrayList<PSDEOPPrivRoleDTO>();
            for (PSDEOPPrivRole item : list) {
                PSDEOPPrivRoleDTO dto = (PSDEOPPrivRoleDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEOPPrivRole> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEOPPrivRole get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEOPPrivRole> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEOPPrivRole item : list) {
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
    public List<PSDEOPPrivRoleDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEOPPrivRole> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEOPPrivRoleDTO> dtoList = new ArrayList<PSDEOPPrivRoleDTO>();
            for (PSDEOPPrivRole item : list) {
                PSDEOPPrivRoleDTO dto = (PSDEOPPrivRoleDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEOPPrivRole> onListAll() throws Exception {
        List<PSDataEntity> psdataentities;
        List<PSSysOPPriv> pssysopprivs;
        ArrayList<PSDEOPPrivRole> list = new ArrayList<PSDEOPPrivRole>();
        List<PSDEUserRole> psdeuserroles = PSModelServiceUtil.getInstance().getPSDEUserRoleService().listAll();
        if (psdeuserroles != null) {
            for (PSDEUserRole parent : psdeuserroles) {
                List<PSDEOPPrivRole> items = this.listByPSDEUserRole(parent);
                if (items == null) continue;
                list.addAll((Collection<PSDEOPPrivRole>)items);
            }
        }
        if ((pssysopprivs = PSModelServiceUtil.getInstance().getPSSysOPPrivService().listAll()) != null) {
            for (PSSysOPPriv parent : pssysopprivs) {
                List<PSDEOPPrivRole> items = this.listByPSSysOPPriv(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll()) != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEOPPrivRole> items = this.listByPSDataEntity(parent);
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
    protected PSDEOPPrivRole onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEOPPrivRole item;
        PSDEOPPrivRole item2;
        PSDEOPPrivRole item3;
        PSDEUserRole psdeuserrole = (PSDEUserRole)PSModelServiceUtil.getInstance().getPSDEUserRoleService().get(strParentKey, true);
        if (psdeuserrole != null && (item3 = this.get(psdeuserrole, strCurKey, true)) != null) {
            return item3;
        }
        PSSysOPPriv pssysoppriv = (PSSysOPPriv)PSModelServiceUtil.getInstance().getPSSysOPPrivService().get(strParentKey, true);
        if (pssysoppriv != null && (item2 = this.get(pssysoppriv, strCurKey, true)) != null) {
            return item2;
        }
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEOPPrivRole)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEOPPrivRoleDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEUserRoleId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEUserRoleService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSSysOPPrivId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysOPPrivService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEOPPrivRole et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEOPPrivRoleName())) {
            return et.getPSDEOPPrivRoleName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEOPPrivRoleDTO dto, PSDEOPPrivRole t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEOPPrivRoleId(t.getId().replace("/", "."));
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
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSDEDQId() != null || !bIgnoreNull) {
            dto.setPSDEDQId(t.getPSDEDQId());
        }
        if (t.getPSDEDQName() != null || !bIgnoreNull) {
            dto.setPSDEDQName(t.getPSDEDQName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setPSDEOPPrivId(t.getPSDEOPPrivId());
        }
        if (t.getPSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setPSDEOPPrivName(t.getPSDEOPPrivName());
        }
        if (t.getPSDEOPPrivRoleName() != null || !bIgnoreNull) {
            dto.setPSDEOPPrivRoleName(t.getPSDEOPPrivRoleName());
        }
        if (t.getPSDEUserRoleId() != null || !bIgnoreNull) {
            dto.setPSDEUserRoleId(t.getPSDEUserRoleId());
        }
        if (t.getPSDEUserRoleName() != null || !bIgnoreNull) {
            dto.setPSDEUserRoleName(t.getPSDEUserRoleName());
        }
        if (t.getPSSysOPPrivId() != null || !bIgnoreNull) {
            dto.setPSSysOPPrivId(t.getPSSysOPPrivId());
        }
        if (t.getPSSysOPPrivName() != null || !bIgnoreNull) {
            dto.setPSSysOPPrivName(t.getPSSysOPPrivName());
        }
        if (t.getRoleType() != null || !bIgnoreNull) {
            dto.setRoleType(t.getRoleType());
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
        if (StringUtils.hasLength((String)dto.getPSDEDQId())) {
            dto.setPSDEDQId(this.getRealPSModelId(t, dto.getPSDEDQId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEOPPrivId())) {
            dto.setPSDEOPPrivId(this.getRealPSModelId(t, dto.getPSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUserRoleId())) {
            dto.setPSDEUserRoleId(this.getRealPSModelId(t, dto.getPSDEUserRoleId()).replace("/", "."));
        }
        if ("PSDEUSERROLE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEUserRoleId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysOPPrivId())) {
            dto.setPSSysOPPrivId(this.getRealPSModelId(t, dto.getPSSysOPPrivId()).replace("/", "."));
        }
        if ("PSSYSOPPRIV".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysOPPrivId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDQId())) {
            linkDTO = (PSDEDataQueryDTO)PSModelServiceUtil.getInstance().getPSDEDataQueryService().getDTO(dto.getPSDEDQId());
            dto.setPSDEDQName(((PSDEDataQueryDTO)linkDTO).getPSDEDataQueryName());
        } else {
            dto.setPSDEDQName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getPSDEOPPrivId());
            dto.setPSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setPSDEOPPrivName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEUserRoleId())) {
            linkDTO = (PSDEUserRoleDTO)PSModelServiceUtil.getInstance().getPSDEUserRoleService().getDTO(dto.getPSDEUserRoleId());
            dto.setPSDEUserRoleName(((PSDEUserRoleDTO)linkDTO).getPSDEUserRoleName());
        } else {
            dto.setPSDEUserRoleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysOPPrivId())) {
            linkDTO = (PSSysOPPrivDTO)PSModelServiceUtil.getInstance().getPSSysOPPrivService().getDTO(dto.getPSSysOPPrivId());
            dto.setPSSysOPPrivName(((PSSysOPPrivDTO)linkDTO).getPSSysOPPrivName());
        } else {
            dto.setPSSysOPPrivName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSDEOPPRIVROLE";
    }

    @Override
    public PSDEOPPrivRole createDomain() {
        return new PSDEOPPrivRole();
    }

    @Override
    public PSDEOPPrivRoleDTO createDTO() {
        return new PSDEOPPrivRoleDTO();
    }
}

