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
import net.ibizsys.modelapi.domain.PSSysUserRoleRes;
import net.ibizsys.modelapi.dto.PSSysOPPrivDTO;
import net.ibizsys.modelapi.dto.PSSysUniResDTO;
import net.ibizsys.modelapi.dto.PSSysUserRoleResDTO;
import net.ibizsys.modelapi.service.IPSSysUserRoleResService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysUserRoleResServiceImpl
extends PSModelServiceImplBase<PSSysUserRoleRes, PSSysUserRoleResDTO>
implements IPSSysUserRoleResService {
    private static final Log log = LogFactory.getLog(PSSysUserRoleResServiceImpl.class);

    @Override
    public List<PSSysUserRoleRes> listByPSSysOPPriv(PSSysOPPriv parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysUserRoleRes get(PSSysOPPriv parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysUserRoleRes> list = this.listByPSSysOPPriv(parent);
        if (list != null) {
            for (PSSysUserRoleRes item : list) {
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
    public List<PSSysUserRoleResDTO> listDTOByPSSysOPPriv(String strParentKey) throws Exception {
        PSSysOPPriv pssysoppriv = (PSSysOPPriv)PSModelServiceUtil.getInstance().getPSSysOPPrivService().get(strParentKey);
        List<PSSysUserRoleRes> list = this.listByPSSysOPPriv(pssysoppriv);
        if (list != null) {
            ArrayList<PSSysUserRoleResDTO> dtoList = new ArrayList<PSSysUserRoleResDTO>();
            for (PSSysUserRoleRes item : list) {
                PSSysUserRoleResDTO dto = (PSSysUserRoleResDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysUserRoleRes> onListAll() throws Exception {
        ArrayList<PSSysUserRoleRes> list = new ArrayList<PSSysUserRoleRes>();
        List<PSSysOPPriv> pssysopprivs = PSModelServiceUtil.getInstance().getPSSysOPPrivService().listAll();
        if (pssysopprivs != null) {
            for (PSSysOPPriv parent : pssysopprivs) {
                List<PSSysUserRoleRes> items = this.listByPSSysOPPriv(parent);
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
    protected PSSysUserRoleRes onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysUserRoleRes item;
        PSSysOPPriv pssysoppriv = (PSSysOPPriv)PSModelServiceUtil.getInstance().getPSSysOPPrivService().get(strParentKey, true);
        if (pssysoppriv != null && (item = this.get(pssysoppriv, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysUserRoleRes)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysUserRoleResDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysOPPrivId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysOPPrivService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysUserRoleRes et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysUserRoleResDTO dto, PSSysUserRoleRes t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysUserRoleResId(t.getId().replace("/", "."));
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
        if (t.getPSSysOPPrivId() != null || !bIgnoreNull) {
            dto.setPSSysOPPrivId(t.getPSSysOPPrivId());
        }
        if (t.getPSSysOPPrivName() != null || !bIgnoreNull) {
            dto.setPSSysOPPrivName(t.getPSSysOPPrivName());
        }
        if (t.getPSSysUniResId() != null || !bIgnoreNull) {
            dto.setPSSysUniResId(t.getPSSysUniResId());
        }
        if (t.getPSSysUniResName() != null || !bIgnoreNull) {
            dto.setPSSysUniResName(t.getPSSysUniResName());
        }
        if (t.getPSSysUserRoleResName() != null || !bIgnoreNull) {
            dto.setPSSysUserRoleResName(t.getPSSysUserRoleResName());
        }
        if (t.getResModel() != null || !bIgnoreNull) {
            dto.setResModel(t.getResModel());
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
        if (StringUtils.hasLength((String)dto.getPSSysOPPrivId())) {
            dto.setPSSysOPPrivId(this.getRealPSModelId(t, dto.getPSSysOPPrivId()).replace("/", "."));
        }
        if ("PSSYSOPPRIV".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysOPPrivId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysUniResId())) {
            dto.setPSSysUniResId(this.getRealPSModelId(t, dto.getPSSysUniResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysOPPrivId())) {
            linkDTO = (PSSysOPPrivDTO)PSModelServiceUtil.getInstance().getPSSysOPPrivService().getDTO(dto.getPSSysOPPrivId());
            dto.setPSSysOPPrivName(((PSSysOPPrivDTO)linkDTO).getPSSysOPPrivName());
        } else {
            dto.setPSSysOPPrivName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysUniResId())) {
            linkDTO = (PSSysUniResDTO)PSModelServiceUtil.getInstance().getPSSysUniResService().getDTO(dto.getPSSysUniResId());
            dto.setPSSysUniResName(((PSSysUniResDTO)linkDTO).getPSSysUniResName());
        } else {
            dto.setPSSysUniResName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSUSERROLERES";
    }

    @Override
    public PSSysUserRoleRes createDomain() {
        return new PSSysUserRoleRes();
    }

    @Override
    public PSSysUserRoleResDTO createDTO() {
        return new PSSysUserRoleResDTO();
    }
}

