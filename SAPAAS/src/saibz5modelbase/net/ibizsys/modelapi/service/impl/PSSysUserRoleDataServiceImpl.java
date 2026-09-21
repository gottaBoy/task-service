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
import net.ibizsys.modelapi.domain.PSSysOPPriv;
import net.ibizsys.modelapi.domain.PSSysUserRoleData;
import net.ibizsys.modelapi.dto.PSDEUserRoleDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysOPPrivDTO;
import net.ibizsys.modelapi.dto.PSSysUserRoleDataDTO;
import net.ibizsys.modelapi.service.IPSSysUserRoleDataService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysUserRoleDataServiceImpl
extends PSModelServiceImplBase<PSSysUserRoleData, PSSysUserRoleDataDTO>
implements IPSSysUserRoleDataService {
    private static final Log log = LogFactory.getLog(PSSysUserRoleDataServiceImpl.class);

    @Override
    public List<PSSysUserRoleData> listByPSSysOPPriv(PSSysOPPriv parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysUserRoleData get(PSSysOPPriv parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysUserRoleData> list = this.listByPSSysOPPriv(parent);
        if (list != null) {
            for (PSSysUserRoleData item : list) {
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
    public List<PSSysUserRoleDataDTO> listDTOByPSSysOPPriv(String strParentKey) throws Exception {
        PSSysOPPriv pssysoppriv = (PSSysOPPriv)PSModelServiceUtil.getInstance().getPSSysOPPrivService().get(strParentKey);
        List<PSSysUserRoleData> list = this.listByPSSysOPPriv(pssysoppriv);
        if (list != null) {
            ArrayList<PSSysUserRoleDataDTO> dtoList = new ArrayList<PSSysUserRoleDataDTO>();
            for (PSSysUserRoleData item : list) {
                PSSysUserRoleDataDTO dto = (PSSysUserRoleDataDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysUserRoleData> onListAll() throws Exception {
        ArrayList<PSSysUserRoleData> list = new ArrayList<PSSysUserRoleData>();
        List pssysopprivs = PSModelServiceUtil.getInstance().getPSSysOPPrivService().listAll();
        if (pssysopprivs != null) {
            for (PSSysOPPriv parent : pssysopprivs) {
                List<PSSysUserRoleData> items = this.listByPSSysOPPriv(parent);
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
    protected PSSysUserRoleData onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysUserRoleData item;
        PSSysOPPriv pssysoppriv = (PSSysOPPriv)PSModelServiceUtil.getInstance().getPSSysOPPrivService().get(strParentKey, true);
        if (pssysoppriv != null && (item = this.get(pssysoppriv, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysUserRoleData)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysUserRoleDataDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysOPPrivId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysOPPrivService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysUserRoleData et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysUserRoleDataDTO dto, PSSysUserRoleData t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysUserRoleDataId(t.getId().replace("/", "."));
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
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
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
        if (t.getPSSysUserRoleDataName() != null || !bIgnoreNull) {
            dto.setPSSysUserRoleDataName(t.getPSSysUserRoleDataName());
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
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUserRoleId())) {
            dto.setPSDEUserRoleId(this.getRealPSModelId(t, dto.getPSDEUserRoleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysOPPrivId())) {
            dto.setPSSysOPPrivId(this.getRealPSModelId(t, dto.getPSSysOPPrivId()).replace("/", "."));
        }
        if ("PSSYSOPPRIV".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysOPPrivId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
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
        return "PSSYSUSERROLEDATA";
    }

    @Override
    public PSSysUserRoleData createDomain() {
        return new PSSysUserRoleData();
    }

    @Override
    public PSSysUserRoleDataDTO createDTO() {
        return new PSSysUserRoleDataDTO();
    }
}

