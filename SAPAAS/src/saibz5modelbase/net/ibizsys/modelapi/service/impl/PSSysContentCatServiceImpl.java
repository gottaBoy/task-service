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
import net.ibizsys.modelapi.domain.PSSysContentCat;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysContentCatDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysContentCatService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysContentCatServiceImpl
extends PSModelServiceImplBase<PSSysContentCat, PSSysContentCatDTO>
implements IPSSysContentCatService {
    private static final Log log = LogFactory.getLog(PSSysContentCatServiceImpl.class);

    @Override
    public List<PSSysContentCat> listByPSSysContentCat(PSSysContentCat parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysContentCat get(PSSysContentCat parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysContentCat> list = this.listByPSSysContentCat(parent);
        if (list != null) {
            for (PSSysContentCat item : list) {
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
    public List<PSSysContentCatDTO> listDTOByPSSysContentCat(String strParentKey) throws Exception {
        PSSysContentCat pssyscontentcat = (PSSysContentCat)PSModelServiceUtil.getInstance().getPSSysContentCatService().get(strParentKey);
        List<PSSysContentCat> list = this.listByPSSysContentCat(pssyscontentcat);
        if (list != null) {
            ArrayList<PSSysContentCatDTO> dtoList = new ArrayList<PSSysContentCatDTO>();
            for (PSSysContentCat item : list) {
                PSSysContentCatDTO dto = (PSSysContentCatDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysContentCat> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysContentCat get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysContentCat> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSSysContentCat item : list) {
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
    public List<PSSysContentCatDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSSysContentCat> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSSysContentCatDTO> dtoList = new ArrayList<PSSysContentCatDTO>();
            for (PSSysContentCat item : list) {
                PSSysContentCatDTO dto = (PSSysContentCatDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysContentCat> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysContentCat get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysContentCat> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysContentCat item : list) {
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
    public List<PSSysContentCatDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysContentCat> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysContentCatDTO> dtoList = new ArrayList<PSSysContentCatDTO>();
            for (PSSysContentCat item : list) {
                PSSysContentCatDTO dto = (PSSysContentCatDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysContentCat> onListAll() throws Exception {
        List<PSSystem> pssystems;
        ArrayList<PSSysContentCat> list = new ArrayList<PSSysContentCat>();
        List<PSModule> psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll();
        if (psmodules != null) {
            for (PSModule parent : psmodules) {
                List<PSSysContentCat> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysContentCat> items = this.listByPSSystem(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        ArrayList<PSSysContentCat> alllist = new ArrayList<PSSysContentCat>();
        alllist.addAll(list);
        for (PSSysContentCat item : list) {
            List<PSSysContentCat> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSSysContentCat> listAllChild(PSSysContentCat parent) throws Exception {
        List<PSSysContentCat> list = this.listByPSSysContentCat(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSSysContentCat> alllist = new ArrayList<PSSysContentCat>();
        alllist.addAll(list);
        for (PSSysContentCat item : list) {
            List<PSSysContentCat> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSSysContentCat> listAllByPSModule(PSModule parent) throws Exception {
        List<PSSysContentCat> list = this.listByPSModule(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSSysContentCat> alllist = new ArrayList<PSSysContentCat>();
        alllist.addAll(list);
        for (PSSysContentCat item : list) {
            List<PSSysContentCat> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSSysContentCatDTO> listAllDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSSysContentCat> list = this.listAllByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSSysContentCatDTO> dtoList = new ArrayList<PSSysContentCatDTO>();
            for (PSSysContentCat item : list) {
                PSSysContentCatDTO dto = (PSSysContentCatDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysContentCat> listAllByPSSystem(PSSystem parent) throws Exception {
        List<PSSysContentCat> list = this.listByPSSystem(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSSysContentCat> alllist = new ArrayList<PSSysContentCat>();
        alllist.addAll(list);
        for (PSSysContentCat item : list) {
            List<PSSysContentCat> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSSysContentCatDTO> listAllDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysContentCat> list = this.listAllByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysContentCatDTO> dtoList = new ArrayList<PSSysContentCatDTO>();
            for (PSSysContentCat item : list) {
                PSSysContentCatDTO dto = (PSSysContentCatDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected PSSysContentCat onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysContentCat item;
        PSSysContentCat item2;
        PSSysContentCat item3;
        PSSysContentCat pssyscontentcat = (PSSysContentCat)PSModelServiceUtil.getInstance().getPSSysContentCatService().get(strParentKey, true);
        if (pssyscontentcat != null && (item3 = this.get(pssyscontentcat, strCurKey, true)) != null) {
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
        return (PSSysContentCat)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysContentCatDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPPSSysContentCatId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysContentCatService().get(strPickupValue, false);
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
    public String getModelTag(PSSysContentCat et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSSysContentCatName())) {
            return et.getPSSysContentCatName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysContentCatDTO dto, PSSysContentCat t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysContentCatId(t.getId().replace("/", "."));
        }
        if (t.getCatTag() != null || !bIgnoreNull) {
            dto.setCatTag(t.getCatTag());
        }
        if (t.getCatTag2() != null || !bIgnoreNull) {
            dto.setCatTag2(t.getCatTag2());
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
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPPSSysContentCatId() != null || !bIgnoreNull) {
            dto.setPPSSysContentCatId(t.getPPSSysContentCatId());
        }
        if (t.getPPSSysContentCatName() != null || !bIgnoreNull) {
            dto.setPPSSysContentCatName(t.getPPSSysContentCatName());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
        }
        if (t.getPSSysContentCatName() != null || !bIgnoreNull) {
            dto.setPSSysContentCatName(t.getPSSysContentCatName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
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
        if (StringUtils.hasLength((String)dto.getPPSSysContentCatId())) {
            dto.setPPSSysContentCatId(this.getRealPSModelId(t, dto.getPPSSysContentCatId()).replace("/", "."));
        }
        if ("PSSYSCONTENTCAT".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPPSSysContentCatId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            dto.setPSModuleId(this.getRealPSModelId(t, dto.getPSModuleId()).replace("/", "."));
        }
        if ("PSMODULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSModuleId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSSysContentCatId())) {
            linkDTO = (PSSysContentCatDTO)PSModelServiceUtil.getInstance().getPSSysContentCatService().getDTO(dto.getPPSSysContentCatId());
            dto.setPPSSysContentCatName(((PSSysContentCatDTO)linkDTO).getPSSysContentCatName());
        } else {
            dto.setPPSSysContentCatName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            linkDTO = (PSModuleDTO)PSModelServiceUtil.getInstance().getPSModuleService().getDTO(dto.getPSModuleId());
            dto.setPSModuleName(((PSModuleDTO)linkDTO).getPSModuleName());
        } else {
            dto.setPSModuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
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
        return "PSSYSCONTENTCAT";
    }

    @Override
    public PSSysContentCat createDomain() {
        return new PSSysContentCat();
    }

    @Override
    public PSSysContentCatDTO createDTO() {
        return new PSSysContentCatDTO();
    }
}

