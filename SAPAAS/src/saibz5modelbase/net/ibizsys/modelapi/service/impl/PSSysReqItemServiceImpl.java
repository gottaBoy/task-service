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
import net.ibizsys.modelapi.domain.PSSysReqItem;
import net.ibizsys.modelapi.domain.PSSysReqModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.dto.PSSysReqModuleDTO;
import net.ibizsys.modelapi.dto.PSSysUserCaseDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysReqItemService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysReqItemServiceImpl
extends PSModelServiceImplBase<PSSysReqItem, PSSysReqItemDTO>
implements IPSSysReqItemService {
    private static final Log log = LogFactory.getLog(PSSysReqItemServiceImpl.class);

    @Override
    public List<PSSysReqItem> listByPSSysReqModule(PSSysReqModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysReqItem get(PSSysReqModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysReqItem> list = this.listByPSSysReqModule(parent);
        if (list != null) {
            for (PSSysReqItem item : list) {
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
    public List<PSSysReqItemDTO> listDTOByPSSysReqModule(String strParentKey) throws Exception {
        PSSysReqModule pssysreqmodule = (PSSysReqModule)PSModelServiceUtil.getInstance().getPSSysReqModuleService().get(strParentKey);
        List<PSSysReqItem> list = this.listByPSSysReqModule(pssysreqmodule);
        if (list != null) {
            ArrayList<PSSysReqItemDTO> dtoList = new ArrayList<PSSysReqItemDTO>();
            for (PSSysReqItem item : list) {
                PSSysReqItemDTO dto = (PSSysReqItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysReqItem> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysReqItem get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysReqItem> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSSysReqItem item : list) {
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
    public List<PSSysReqItemDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSSysReqItem> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSSysReqItemDTO> dtoList = new ArrayList<PSSysReqItemDTO>();
            for (PSSysReqItem item : list) {
                PSSysReqItemDTO dto = (PSSysReqItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysReqItem> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysReqItem get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysReqItem> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysReqItem item : list) {
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
    public List<PSSysReqItemDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysReqItem> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysReqItemDTO> dtoList = new ArrayList<PSSysReqItemDTO>();
            for (PSSysReqItem item : list) {
                PSSysReqItemDTO dto = (PSSysReqItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysReqItem> listByPSSysReqItem(PSSysReqItem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysReqItem get(PSSysReqItem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysReqItem> list = this.listByPSSysReqItem(parent);
        if (list != null) {
            for (PSSysReqItem item : list) {
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
    public List<PSSysReqItemDTO> listDTOByPSSysReqItem(String strParentKey) throws Exception {
        PSSysReqItem pssysreqitem = (PSSysReqItem)PSModelServiceUtil.getInstance().getPSSysReqItemService().get(strParentKey);
        List<PSSysReqItem> list = this.listByPSSysReqItem(pssysreqitem);
        if (list != null) {
            ArrayList<PSSysReqItemDTO> dtoList = new ArrayList<PSSysReqItemDTO>();
            for (PSSysReqItem item : list) {
                PSSysReqItemDTO dto = (PSSysReqItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysReqItem> onListAll() throws Exception {
        List<PSSystem> pssystems;
        List<PSModule> psmodules;
        ArrayList<PSSysReqItem> list = new ArrayList<PSSysReqItem>();
        List<PSSysReqModule> pssysreqmodules = PSModelServiceUtil.getInstance().getPSSysReqModuleService().listAll();
        if (pssysreqmodules != null) {
            for (PSSysReqModule parent : pssysreqmodules) {
                List<PSSysReqItem> items = this.listByPSSysReqModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll()) != null) {
            for (PSModule parent : psmodules) {
                List<PSSysReqItem> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysReqItem> items = this.listByPSSystem(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        ArrayList<PSSysReqItem> alllist = new ArrayList<PSSysReqItem>();
        alllist.addAll(list);
        for (PSSysReqItem item : list) {
            List<PSSysReqItem> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSSysReqItem> listAllChild(PSSysReqItem parent) throws Exception {
        List<PSSysReqItem> list = this.listByPSSysReqItem(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSSysReqItem> alllist = new ArrayList<PSSysReqItem>();
        alllist.addAll(list);
        for (PSSysReqItem item : list) {
            List<PSSysReqItem> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSSysReqItem> listAllByPSSysReqModule(PSSysReqModule parent) throws Exception {
        List<PSSysReqItem> list = this.listByPSSysReqModule(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSSysReqItem> alllist = new ArrayList<PSSysReqItem>();
        alllist.addAll(list);
        for (PSSysReqItem item : list) {
            List<PSSysReqItem> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSSysReqItemDTO> listAllDTOByPSSysReqModule(String strParentKey) throws Exception {
        PSSysReqModule pssysreqmodule = (PSSysReqModule)PSModelServiceUtil.getInstance().getPSSysReqModuleService().get(strParentKey);
        List<PSSysReqItem> list = this.listAllByPSSysReqModule(pssysreqmodule);
        if (list != null) {
            ArrayList<PSSysReqItemDTO> dtoList = new ArrayList<PSSysReqItemDTO>();
            for (PSSysReqItem item : list) {
                PSSysReqItemDTO dto = (PSSysReqItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysReqItem> listAllByPSModule(PSModule parent) throws Exception {
        List<PSSysReqItem> list = this.listByPSModule(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSSysReqItem> alllist = new ArrayList<PSSysReqItem>();
        alllist.addAll(list);
        for (PSSysReqItem item : list) {
            List<PSSysReqItem> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSSysReqItemDTO> listAllDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSSysReqItem> list = this.listAllByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSSysReqItemDTO> dtoList = new ArrayList<PSSysReqItemDTO>();
            for (PSSysReqItem item : list) {
                PSSysReqItemDTO dto = (PSSysReqItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysReqItem> listAllByPSSystem(PSSystem parent) throws Exception {
        List<PSSysReqItem> list = this.listByPSSystem(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSSysReqItem> alllist = new ArrayList<PSSysReqItem>();
        alllist.addAll(list);
        for (PSSysReqItem item : list) {
            List<PSSysReqItem> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSSysReqItemDTO> listAllDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysReqItem> list = this.listAllByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysReqItemDTO> dtoList = new ArrayList<PSSysReqItemDTO>();
            for (PSSysReqItem item : list) {
                PSSysReqItemDTO dto = (PSSysReqItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected PSSysReqItem onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysReqItem item;
        PSSysReqItem item2;
        PSSysReqItem item3;
        PSSysReqItem item4;
        PSSysReqModule pssysreqmodule = (PSSysReqModule)PSModelServiceUtil.getInstance().getPSSysReqModuleService().get(strParentKey, true);
        if (pssysreqmodule != null && (item4 = this.get(pssysreqmodule, strCurKey, true)) != null) {
            return item4;
        }
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item3 = this.get(psmodule, strCurKey, true)) != null) {
            return item3;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item2 = this.get(pssystem, strCurKey, true)) != null) {
            return item2;
        }
        PSSysReqItem pssysreqitem = (PSSysReqItem)PSModelServiceUtil.getInstance().getPSSysReqItemService().get(strParentKey, true);
        if (pssysreqitem != null && (item = this.get(pssysreqitem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysReqItem)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysReqItemDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPPSSysReqItemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysReqItemService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSSysReqModuleId();
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
    public String getModelTag(PSSysReqItem et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysReqItemDTO dto, PSSysReqItem t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysReqItemId(t.getId().replace("/", "."));
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
        if (t.getItemSN() != null || !bIgnoreNull) {
            dto.setItemSN(t.getItemSN());
        }
        if (t.getItemTag() != null || !bIgnoreNull) {
            dto.setItemTag(t.getItemTag());
        }
        if (t.getItemTag2() != null || !bIgnoreNull) {
            dto.setItemTag2(t.getItemTag2());
        }
        if (t.getItemType() != null || !bIgnoreNull) {
            dto.setItemType(t.getItemType());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPPSSysReqItemId() != null || !bIgnoreNull) {
            dto.setPPSSysReqItemId(t.getPPSSysReqItemId());
        }
        if (t.getPPSSysReqItemName() != null || !bIgnoreNull) {
            dto.setPPSSysReqItemName(t.getPPSSysReqItemName());
        }
        if (t.getPSDevPrdId() != null || !bIgnoreNull) {
            dto.setPSDevPrdId(t.getPSDevPrdId());
        }
        if (t.getPSDevPrdName() != null || !bIgnoreNull) {
            dto.setPSDevPrdName(t.getPSDevPrdName());
        }
        if (t.getPSDevPrdSpecId() != null || !bIgnoreNull) {
            dto.setPSDevPrdSpecId(t.getPSDevPrdSpecId());
        }
        if (t.getPSDevPrdSpecName() != null || !bIgnoreNull) {
            dto.setPSDevPrdSpecName(t.getPSDevPrdSpecName());
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
        if (t.getPSSysReqItemName() != null || !bIgnoreNull) {
            dto.setPSSysReqItemName(t.getPSSysReqItemName());
        }
        if (t.getPSSysReqModuleId() != null || !bIgnoreNull) {
            dto.setPSSysReqModuleId(t.getPSSysReqModuleId());
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
        if (t.getPSSysUserCaseId() != null || !bIgnoreNull) {
            dto.setPSSysUserCaseId(t.getPSSysUserCaseId());
        }
        if (t.getPSSysUserCaseName() != null || !bIgnoreNull) {
            dto.setPSSysUserCaseName(t.getPSSysUserCaseName());
        }
        if (t.getReqContent() != null || !bIgnoreNull) {
            dto.setReqContent(t.getReqContent());
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
        if (t.getVer() != null || !bIgnoreNull) {
            dto.setVer(t.getVer());
        }
        if (StringUtils.hasLength((String)dto.getPPSSysReqItemId())) {
            dto.setPPSSysReqItemId(this.getRealPSModelId(t, dto.getPPSSysReqItemId()).replace("/", "."));
        }
        if ("PSSYSREQITEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPPSSysReqItemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            dto.setPSModuleId(this.getRealPSModelId(t, dto.getPSModuleId()).replace("/", "."));
        }
        if ("PSMODULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSModuleId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqModuleId())) {
            dto.setPSSysReqModuleId(this.getRealPSModelId(t, dto.getPSSysReqModuleId()).replace("/", "."));
        }
        if ("PSSYSREQMODULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysReqModuleId(t.getSrfParent().getId().replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPPSSysReqItemId())) {
            linkDTO = (PSSysReqItemDTO)PSModelServiceUtil.getInstance().getPSSysReqItemService().getDTO(dto.getPPSSysReqItemId());
            dto.setPPSSysReqItemName(((PSSysReqItemDTO)linkDTO).getPSSysReqItemName());
        } else {
            dto.setPPSSysReqItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            linkDTO = (PSModuleDTO)PSModelServiceUtil.getInstance().getPSModuleService().getDTO(dto.getPSModuleId());
            dto.setPSModuleName(((PSModuleDTO)linkDTO).getPSModuleName());
        } else {
            dto.setPSModuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqModuleId())) {
            linkDTO = (PSSysReqModuleDTO)PSModelServiceUtil.getInstance().getPSSysReqModuleService().getDTO(dto.getPSSysReqModuleId());
            dto.setPSSysReqModuleName(((PSSysReqModuleDTO)linkDTO).getPSSysReqModuleName());
        } else {
            dto.setPSSysReqModuleName(null);
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
        return "PSSYSREQITEM";
    }

    @Override
    public PSSysReqItem createDomain() {
        return new PSSysReqItem();
    }

    @Override
    public PSSysReqItemDTO createDTO() {
        return new PSSysReqItemDTO();
    }
}

