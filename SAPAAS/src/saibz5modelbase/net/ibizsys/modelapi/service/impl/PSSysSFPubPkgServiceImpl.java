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
import net.ibizsys.modelapi.domain.PSSysSFPub;
import net.ibizsys.modelapi.domain.PSSysSFPubPkg;
import net.ibizsys.modelapi.dto.PSSysSFPubDTO;
import net.ibizsys.modelapi.dto.PSSysSFPubPkgDTO;
import net.ibizsys.modelapi.service.IPSSysSFPubPkgService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysSFPubPkgServiceImpl
extends PSModelServiceImplBase<PSSysSFPubPkg, PSSysSFPubPkgDTO>
implements IPSSysSFPubPkgService {
    private static final Log log = LogFactory.getLog(PSSysSFPubPkgServiceImpl.class);

    @Override
    public List<PSSysSFPubPkg> listByPSSysSFPub(PSSysSFPub parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysSFPubPkg get(PSSysSFPub parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysSFPubPkg> list = this.listByPSSysSFPub(parent);
        if (list != null) {
            for (PSSysSFPubPkg item : list) {
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
    public List<PSSysSFPubPkgDTO> listDTOByPSSysSFPub(String strParentKey) throws Exception {
        PSSysSFPub pssyssfpub = (PSSysSFPub)PSModelServiceUtil.getInstance().getPSSysSFPubService().get(strParentKey);
        List<PSSysSFPubPkg> list = this.listByPSSysSFPub(pssyssfpub);
        if (list != null) {
            ArrayList<PSSysSFPubPkgDTO> dtoList = new ArrayList<PSSysSFPubPkgDTO>();
            for (PSSysSFPubPkg item : list) {
                PSSysSFPubPkgDTO dto = (PSSysSFPubPkgDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysSFPubPkg> onListAll() throws Exception {
        ArrayList<PSSysSFPubPkg> list = new ArrayList<PSSysSFPubPkg>();
        List pssyssfpubs = PSModelServiceUtil.getInstance().getPSSysSFPubService().listAll();
        if (pssyssfpubs != null) {
            for (PSSysSFPub parent : pssyssfpubs) {
                List<PSSysSFPubPkg> items = this.listByPSSysSFPub(parent);
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
    protected PSSysSFPubPkg onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysSFPubPkg item;
        PSSysSFPub pssyssfpub = (PSSysSFPub)PSModelServiceUtil.getInstance().getPSSysSFPubService().get(strParentKey, true);
        if (pssyssfpub != null && (item = this.get(pssyssfpub, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysSFPubPkg)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysSFPubPkgDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysSFPubId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysSFPubService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysSFPubPkg et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysSFPubPkgName())) {
            return et.getPSSysSFPubPkgName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysSFPubPkgDTO dto, PSSysSFPubPkg t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysSFPubPkgId(t.getId().replace("/", "."));
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
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPkgParam() != null || !bIgnoreNull) {
            dto.setPkgParam(t.getPkgParam());
        }
        if (t.getPkgParam2() != null || !bIgnoreNull) {
            dto.setPkgParam2(t.getPkgParam2());
        }
        if (t.getPkgParam3() != null || !bIgnoreNull) {
            dto.setPkgParam3(t.getPkgParam3());
        }
        if (t.getPkgParam4() != null || !bIgnoreNull) {
            dto.setPkgParam4(t.getPkgParam4());
        }
        if (t.getPSSFPkgId() != null || !bIgnoreNull) {
            dto.setPSSFPkgId(t.getPSSFPkgId());
        }
        if (t.getPSSFPkgName() != null || !bIgnoreNull) {
            dto.setPSSFPkgName(t.getPSSFPkgName());
        }
        if (t.getPSSFPkgVerId() != null || !bIgnoreNull) {
            dto.setPSSFPkgVerId(t.getPSSFPkgVerId());
        }
        if (t.getPSSFPkgVerName() != null || !bIgnoreNull) {
            dto.setPSSFPkgVerName(t.getPSSFPkgVerName());
        }
        if (t.getPSSysSFPubId() != null || !bIgnoreNull) {
            dto.setPSSysSFPubId(t.getPSSysSFPubId());
        }
        if (t.getPSSysSFPubName() != null || !bIgnoreNull) {
            dto.setPSSysSFPubName(t.getPSSysSFPubName());
        }
        if (t.getPSSysSFPubPkgName() != null || !bIgnoreNull) {
            dto.setPSSysSFPubPkgName(t.getPSSysSFPubPkgName());
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
        if (StringUtils.hasLength((String)dto.getPSSysSFPubId())) {
            dto.setPSSysSFPubId(this.getRealPSModelId(t, dto.getPSSysSFPubId()).replace("/", "."));
        }
        if ("PSSYSSFPUB".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysSFPubId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPubId())) {
            PSSysSFPubDTO linkDTO = (PSSysSFPubDTO)PSModelServiceUtil.getInstance().getPSSysSFPubService().getDTO(dto.getPSSysSFPubId());
            dto.setPSSysSFPubName(linkDTO.getPSSysSFPubName());
        } else {
            dto.setPSSysSFPubName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSSFPUBPKG";
    }

    @Override
    public PSSysSFPubPkg createDomain() {
        return new PSSysSFPubPkg();
    }

    @Override
    public PSSysSFPubPkgDTO createDTO() {
        return new PSSysSFPubPkgDTO();
    }
}

