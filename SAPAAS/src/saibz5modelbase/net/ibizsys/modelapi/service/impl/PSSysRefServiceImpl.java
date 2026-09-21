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
import net.ibizsys.modelapi.domain.PSSysRef;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysRefDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysRefService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysRefServiceImpl
extends PSModelServiceImplBase<PSSysRef, PSSysRefDTO>
implements IPSSysRefService {
    private static final Log log = LogFactory.getLog(PSSysRefServiceImpl.class);

    @Override
    public List<PSSysRef> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysRef get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysRef> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysRef item : list) {
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
    public List<PSSysRefDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysRef> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysRefDTO> dtoList = new ArrayList<PSSysRefDTO>();
            for (PSSysRef item : list) {
                PSSysRefDTO dto = (PSSysRefDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysRef> onListAll() throws Exception {
        ArrayList<PSSysRef> list = new ArrayList<PSSysRef>();
        List pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll();
        if (pssystems != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysRef> items = this.listByPSSystem(parent);
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
    protected PSSysRef onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysRef item;
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysRef)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysRefDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSystemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSystemService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysRef et) throws Exception {
        if (StringUtils.hasLength((String)et.getRealSysId())) {
            return et.getRealSysId();
        }
        if (StringUtils.hasLength((String)et.getRealSysId())) {
            return et.getRealSysId();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysRefDTO dto, PSSysRef t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysRefId(t.getId().replace("/", "."));
        }
        if (t.getClsPkgParams() != null || !bIgnoreNull) {
            dto.setClsPkgParams(t.getClsPkgParams());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDCDomainName() != null || !bIgnoreNull) {
            dto.setDCDomainName(t.getDCDomainName());
        }
        if (t.getDevSlnCodeName() != null || !bIgnoreNull) {
            dto.setDevSlnCodeName(t.getDevSlnCodeName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDevSlnSysId() != null || !bIgnoreNull) {
            dto.setPSDevSlnSysId(t.getPSDevSlnSysId());
        }
        if (t.getPSDevSlnSysName() != null || !bIgnoreNull) {
            dto.setPSDevSlnSysName(t.getPSDevSlnSysName());
        }
        if (t.getPSDevSlnSysSrvId() != null || !bIgnoreNull) {
            dto.setPSDevSlnSysSrvId(t.getPSDevSlnSysSrvId());
        }
        if (t.getPSDevSlnSysSrvName() != null || !bIgnoreNull) {
            dto.setPSDevSlnSysSrvName(t.getPSDevSlnSysSrvName());
        }
        if (t.getPSSubSysId() != null || !bIgnoreNull) {
            dto.setPSSubSysId(t.getPSSubSysId());
        }
        if (t.getPSSubSysName() != null || !bIgnoreNull) {
            dto.setPSSubSysName(t.getPSSubSysName());
        }
        if (t.getPSSysRefName() != null || !bIgnoreNull) {
            dto.setPSSysRefName(t.getPSSysRefName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getRealSysId() != null || !bIgnoreNull) {
            dto.setRealSysId(t.getRealSysId());
        }
        if (t.getRefParam() != null || !bIgnoreNull) {
            dto.setRefParam(t.getRefParam());
        }
        if (t.getRefParam2() != null || !bIgnoreNull) {
            dto.setRefParam2(t.getRefParam2());
        }
        if (t.getRefParams() != null || !bIgnoreNull) {
            dto.setRefParams(t.getRefParams());
        }
        if (t.getSFFWFlag() != null || !bIgnoreNull) {
            dto.setSFFWFlag(t.getSFFWFlag());
        }
        if (t.getSrvCodeName() != null || !bIgnoreNull) {
            dto.setSrvCodeName(t.getSrvCodeName());
        }
        if (t.getSysCodeName() != null || !bIgnoreNull) {
            dto.setSysCodeName(t.getSysCodeName());
        }
        if (t.getSysName() != null || !bIgnoreNull) {
            dto.setSysName(t.getSysName());
        }
        if (t.getSysPkgName() != null || !bIgnoreNull) {
            dto.setSysPkgName(t.getSysPkgName());
        }
        if (t.getSysRefType() != null || !bIgnoreNull) {
            dto.setSysRefType(t.getSysRefType());
        }
        if (t.getSysVCName() != null || !bIgnoreNull) {
            dto.setSysVCName(t.getSysVCName());
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
        if (t.getVersion() != null || !bIgnoreNull) {
            dto.setVersion(t.getVersion());
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            PSSystemDTO linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(linkDTO.getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSREF";
    }

    @Override
    public PSSysRef createDomain() {
        return new PSSysRef();
    }

    @Override
    public PSSysRefDTO createDTO() {
        return new PSSysRefDTO();
    }
}

