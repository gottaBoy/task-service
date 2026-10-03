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
import net.ibizsys.modelapi.domain.PSSysReqModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysReqModuleDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysReqModuleService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysReqModuleServiceImpl
extends PSModelServiceImplBase<PSSysReqModule, PSSysReqModuleDTO>
implements IPSSysReqModuleService {
    private static final Log log = LogFactory.getLog(PSSysReqModuleServiceImpl.class);

    @Override
    public List<PSSysReqModule> listByPSSysReqModule(PSSysReqModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysReqModule get(PSSysReqModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysReqModule> list = this.listByPSSysReqModule(parent);
        if (list != null) {
            for (PSSysReqModule item : list) {
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
    public List<PSSysReqModuleDTO> listDTOByPSSysReqModule(String strParentKey) throws Exception {
        PSSysReqModule pssysreqmodule = (PSSysReqModule)PSModelServiceUtil.getInstance().getPSSysReqModuleService().get(strParentKey);
        List<PSSysReqModule> list = this.listByPSSysReqModule(pssysreqmodule);
        if (list != null) {
            ArrayList<PSSysReqModuleDTO> dtoList = new ArrayList<PSSysReqModuleDTO>();
            for (PSSysReqModule item : list) {
                PSSysReqModuleDTO dto = (PSSysReqModuleDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysReqModule> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysReqModule get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysReqModule> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSSysReqModule item : list) {
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
    public List<PSSysReqModuleDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSSysReqModule> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSSysReqModuleDTO> dtoList = new ArrayList<PSSysReqModuleDTO>();
            for (PSSysReqModule item : list) {
                PSSysReqModuleDTO dto = (PSSysReqModuleDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysReqModule> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysReqModule get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysReqModule> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysReqModule item : list) {
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
    public List<PSSysReqModuleDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysReqModule> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysReqModuleDTO> dtoList = new ArrayList<PSSysReqModuleDTO>();
            for (PSSysReqModule item : list) {
                PSSysReqModuleDTO dto = (PSSysReqModuleDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysReqModule> onListAll() throws Exception {
        List<PSSystem> pssystems;
        ArrayList<PSSysReqModule> list = new ArrayList<PSSysReqModule>();
        List<PSModule> psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll();
        if (psmodules != null) {
            for (PSModule parent : psmodules) {
                List<PSSysReqModule> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysReqModule> items = this.listByPSSystem(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        ArrayList<PSSysReqModule> alllist = new ArrayList<PSSysReqModule>();
        alllist.addAll(list);
        for (PSSysReqModule item : list) {
            List<PSSysReqModule> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSSysReqModule> listAllChild(PSSysReqModule parent) throws Exception {
        List<PSSysReqModule> list = this.listByPSSysReqModule(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSSysReqModule> alllist = new ArrayList<PSSysReqModule>();
        alllist.addAll(list);
        for (PSSysReqModule item : list) {
            List<PSSysReqModule> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSSysReqModule> listAllByPSModule(PSModule parent) throws Exception {
        List<PSSysReqModule> list = this.listByPSModule(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSSysReqModule> alllist = new ArrayList<PSSysReqModule>();
        alllist.addAll(list);
        for (PSSysReqModule item : list) {
            List<PSSysReqModule> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSSysReqModuleDTO> listAllDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSSysReqModule> list = this.listAllByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSSysReqModuleDTO> dtoList = new ArrayList<PSSysReqModuleDTO>();
            for (PSSysReqModule item : list) {
                PSSysReqModuleDTO dto = (PSSysReqModuleDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysReqModule> listAllByPSSystem(PSSystem parent) throws Exception {
        List<PSSysReqModule> list = this.listByPSSystem(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSSysReqModule> alllist = new ArrayList<PSSysReqModule>();
        alllist.addAll(list);
        for (PSSysReqModule item : list) {
            List<PSSysReqModule> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSSysReqModuleDTO> listAllDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysReqModule> list = this.listAllByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysReqModuleDTO> dtoList = new ArrayList<PSSysReqModuleDTO>();
            for (PSSysReqModule item : list) {
                PSSysReqModuleDTO dto = (PSSysReqModuleDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected PSSysReqModule onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysReqModule item;
        PSSysReqModule item2;
        PSSysReqModule item3;
        PSSysReqModule pssysreqmodule = (PSSysReqModule)PSModelServiceUtil.getInstance().getPSSysReqModuleService().get(strParentKey, true);
        if (pssysreqmodule != null && (item3 = this.get(pssysreqmodule, strCurKey, true)) != null) {
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
        return (PSSysReqModule)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysReqModuleDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPPSSysReqModuleId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysReqModuleService().get(strPickupValue, false);
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
    public String getModelTag(PSSysReqModule et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysReqModuleDTO dto, PSSysReqModule t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysReqModuleId(t.getId().replace("/", "."));
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
        if (t.getModuleSN() != null || !bIgnoreNull) {
            dto.setModuleSN(t.getModuleSN());
        }
        if (t.getModuleTag() != null || !bIgnoreNull) {
            dto.setModuleTag(t.getModuleTag());
        }
        if (t.getModuleTag2() != null || !bIgnoreNull) {
            dto.setModuleTag2(t.getModuleTag2());
        }
        if (t.getModuleTag3() != null || !bIgnoreNull) {
            dto.setModuleTag3(t.getModuleTag3());
        }
        if (t.getModuleTag4() != null || !bIgnoreNull) {
            dto.setModuleTag4(t.getModuleTag4());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPPSSysReqModuleId() != null || !bIgnoreNull) {
            dto.setPPSSysReqModuleId(t.getPPSSysReqModuleId());
        }
        if (t.getPPSSysReqModuleName() != null || !bIgnoreNull) {
            dto.setPPSSysReqModuleName(t.getPPSSysReqModuleName());
        }
        if (t.getPSDevPrdId() != null || !bIgnoreNull) {
            dto.setPSDevPrdId(t.getPSDevPrdId());
        }
        if (t.getPSDevPrdName() != null || !bIgnoreNull) {
            dto.setPSDevPrdName(t.getPSDevPrdName());
        }
        if (t.getPSDevPrdVerId() != null || !bIgnoreNull) {
            dto.setPSDevPrdVerId(t.getPSDevPrdVerId());
        }
        if (t.getPSDevPrdVerName() != null || !bIgnoreNull) {
            dto.setPSDevPrdVerName(t.getPSDevPrdVerName());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
        }
        if (t.getPSSysReqModuleName() != null || !bIgnoreNull) {
            dto.setPSSysReqModuleName(t.getPSSysReqModuleName());
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
        if (StringUtils.hasLength((String)dto.getPPSSysReqModuleId())) {
            dto.setPPSSysReqModuleId(this.getRealPSModelId(t, dto.getPPSSysReqModuleId()).replace("/", "."));
        }
        if ("PSSYSREQMODULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPPSSysReqModuleId(t.getSrfParent().getId().replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPPSSysReqModuleId())) {
            linkDTO = (PSSysReqModuleDTO)PSModelServiceUtil.getInstance().getPSSysReqModuleService().getDTO(dto.getPPSSysReqModuleId());
            dto.setPPSSysReqModuleName(((PSSysReqModuleDTO)linkDTO).getPSSysReqModuleName());
        } else {
            dto.setPPSSysReqModuleName(null);
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
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSREQMODULE";
    }

    @Override
    public PSSysReqModule createDomain() {
        return new PSSysReqModule();
    }

    @Override
    public PSSysReqModuleDTO createDTO() {
        return new PSSysReqModuleDTO();
    }
}

