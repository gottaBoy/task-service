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
import net.ibizsys.modelapi.domain.PSSysUserCaseRS;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysActorDTO;
import net.ibizsys.modelapi.dto.PSSysUserCaseDTO;
import net.ibizsys.modelapi.dto.PSSysUserCaseRSDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysUserCaseRSService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysUserCaseRSServiceImpl
extends PSModelServiceImplBase<PSSysUserCaseRS, PSSysUserCaseRSDTO>
implements IPSSysUserCaseRSService {
    private static final Log log = LogFactory.getLog(PSSysUserCaseRSServiceImpl.class);

    @Override
    public List<PSSysUserCaseRS> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysUserCaseRS get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysUserCaseRS> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSSysUserCaseRS item : list) {
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
    public List<PSSysUserCaseRSDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSSysUserCaseRS> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSSysUserCaseRSDTO> dtoList = new ArrayList<PSSysUserCaseRSDTO>();
            for (PSSysUserCaseRS item : list) {
                PSSysUserCaseRSDTO dto = (PSSysUserCaseRSDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysUserCaseRS> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysUserCaseRS get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysUserCaseRS> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysUserCaseRS item : list) {
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
    public List<PSSysUserCaseRSDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysUserCaseRS> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysUserCaseRSDTO> dtoList = new ArrayList<PSSysUserCaseRSDTO>();
            for (PSSysUserCaseRS item : list) {
                PSSysUserCaseRSDTO dto = (PSSysUserCaseRSDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysUserCaseRS> onListAll() throws Exception {
        List<PSSystem> pssystems;
        ArrayList<PSSysUserCaseRS> list = new ArrayList<PSSysUserCaseRS>();
        List<PSModule> psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll();
        if (psmodules != null) {
            for (PSModule parent : psmodules) {
                List<PSSysUserCaseRS> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysUserCaseRS> items = this.listByPSSystem(parent);
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
    protected PSSysUserCaseRS onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysUserCaseRS item;
        PSSysUserCaseRS item2;
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item2 = this.get(psmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysUserCaseRS)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysUserCaseRSDTO dto) throws Exception {
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
    public String getModelTag(PSSysUserCaseRS et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysUserCaseRSDTO dto, PSSysUserCaseRS t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysUserCaseRSId(t.getId().replace("/", "."));
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getContent() != null || !bIgnoreNull) {
            dto.setContent(t.getContent());
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
        if (t.getPPSSysActorId() != null || !bIgnoreNull) {
            dto.setPPSSysActorId(t.getPPSSysActorId());
        }
        if (t.getPPSSysActorName() != null || !bIgnoreNull) {
            dto.setPPSSysActorName(t.getPPSSysActorName());
        }
        if (t.getPPSSysUserCaseId() != null || !bIgnoreNull) {
            dto.setPPSSysUserCaseId(t.getPPSSysUserCaseId());
        }
        if (t.getPPSSysUserCaseName() != null || !bIgnoreNull) {
            dto.setPPSSysUserCaseName(t.getPPSSysUserCaseName());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
        }
        if (t.getPSSysActorId() != null || !bIgnoreNull) {
            dto.setPSSysActorId(t.getPSSysActorId());
        }
        if (t.getPSSysActorName() != null || !bIgnoreNull) {
            dto.setPSSysActorName(t.getPSSysActorName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getPSSysUserCaseId() != null || !bIgnoreNull) {
            dto.setPSSysUserCaseId(t.getPSSysUserCaseId());
        }
        if (t.getPSSysUserCaseName() != null || !bIgnoreNull) {
            dto.setPSSysUserCaseName(t.getPSSysUserCaseName());
        }
        if (t.getPSSysUserCaseRSName() != null || !bIgnoreNull) {
            dto.setPSSysUserCaseRSName(t.getPSSysUserCaseRSName());
        }
        if (t.getRSMode() != null || !bIgnoreNull) {
            dto.setRSMode(t.getRSMode());
        }
        if (t.getRSType() != null || !bIgnoreNull) {
            dto.setRSType(t.getRSType());
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
        if (StringUtils.hasLength((String)dto.getPPSSysActorId())) {
            dto.setPPSSysActorId(this.getRealPSModelId(t, dto.getPPSSysActorId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSSysUserCaseId())) {
            dto.setPPSSysUserCaseId(this.getRealPSModelId(t, dto.getPPSSysUserCaseId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            dto.setPSModuleId(this.getRealPSModelId(t, dto.getPSModuleId()).replace("/", "."));
        }
        if ("PSMODULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSModuleId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysActorId())) {
            dto.setPSSysActorId(this.getRealPSModelId(t, dto.getPSSysActorId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysUserCaseId())) {
            dto.setPSSysUserCaseId(this.getRealPSModelId(t, dto.getPSSysUserCaseId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSSysActorId())) {
            linkDTO = (PSSysActorDTO)PSModelServiceUtil.getInstance().getPSSysActorService().getDTO(dto.getPPSSysActorId());
            dto.setPPSSysActorName(((PSSysActorDTO)linkDTO).getPSSysActorName());
        } else {
            dto.setPPSSysActorName(null);
        }
        if (StringUtils.hasLength((String)dto.getPPSSysUserCaseId())) {
            linkDTO = (PSSysUserCaseDTO)PSModelServiceUtil.getInstance().getPSSysUserCaseService().getDTO(dto.getPPSSysUserCaseId());
            dto.setPPSSysUserCaseName(((PSSysUserCaseDTO)linkDTO).getPSSysUserCaseName());
        } else {
            dto.setPPSSysUserCaseName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            linkDTO = (PSModuleDTO)PSModelServiceUtil.getInstance().getPSModuleService().getDTO(dto.getPSModuleId());
            dto.setPSModuleName(((PSModuleDTO)linkDTO).getPSModuleName());
        } else {
            dto.setPSModuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysActorId())) {
            linkDTO = (PSSysActorDTO)PSModelServiceUtil.getInstance().getPSSysActorService().getDTO(dto.getPSSysActorId());
            dto.setPSSysActorName(((PSSysActorDTO)linkDTO).getPSSysActorName());
        } else {
            dto.setPSSysActorName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(((PSSystemDTO)linkDTO).getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysUserCaseId())) {
            linkDTO = (PSSysUserCaseDTO)PSModelServiceUtil.getInstance().getPSSysUserCaseService().getDTO(dto.getPSSysUserCaseId());
            dto.setPSSysUserCaseName(((PSSysUserCaseDTO)linkDTO).getPSSysUserCaseName());
        } else {
            dto.setPSSysUserCaseName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSUSERCASERS";
    }

    @Override
    public PSSysUserCaseRS createDomain() {
        return new PSSysUserCaseRS();
    }

    @Override
    public PSSysUserCaseRSDTO createDTO() {
        return new PSSysUserCaseRSDTO();
    }
}

