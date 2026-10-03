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
import net.ibizsys.modelapi.domain.PSDEOPPriv;
import net.ibizsys.modelapi.domain.PSDER;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSDEOPPrivDTO;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysUniResDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSDEOPPrivService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEOPPrivServiceImpl
extends PSModelServiceImplBase<PSDEOPPriv, PSDEOPPrivDTO>
implements IPSDEOPPrivService {
    private static final Log log = LogFactory.getLog(PSDEOPPrivServiceImpl.class);

    @Override
    public List<PSDEOPPriv> listByPSDER(PSDER parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEOPPriv get(PSDER parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEOPPriv> list = this.listByPSDER(parent);
        if (list != null) {
            for (PSDEOPPriv item : list) {
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
    public List<PSDEOPPrivDTO> listDTOByPSDER(String strParentKey) throws Exception {
        PSDER psder = (PSDER)PSModelServiceUtil.getInstance().getPSDERService().get(strParentKey);
        List<PSDEOPPriv> list = this.listByPSDER(psder);
        if (list != null) {
            ArrayList<PSDEOPPrivDTO> dtoList = new ArrayList<PSDEOPPrivDTO>();
            for (PSDEOPPriv item : list) {
                PSDEOPPrivDTO dto = (PSDEOPPrivDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEOPPriv> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEOPPriv get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEOPPriv> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEOPPriv item : list) {
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
    public List<PSDEOPPrivDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEOPPriv> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEOPPrivDTO> dtoList = new ArrayList<PSDEOPPrivDTO>();
            for (PSDEOPPriv item : list) {
                PSDEOPPrivDTO dto = (PSDEOPPrivDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEOPPriv> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEOPPriv get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEOPPriv> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSDEOPPriv item : list) {
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
    public List<PSDEOPPrivDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSDEOPPriv> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSDEOPPrivDTO> dtoList = new ArrayList<PSDEOPPrivDTO>();
            for (PSDEOPPriv item : list) {
                PSDEOPPrivDTO dto = (PSDEOPPrivDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEOPPriv> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEOPPriv get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEOPPriv> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSDEOPPriv item : list) {
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
    public List<PSDEOPPrivDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSDEOPPriv> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSDEOPPrivDTO> dtoList = new ArrayList<PSDEOPPrivDTO>();
            for (PSDEOPPriv item : list) {
                PSDEOPPrivDTO dto = (PSDEOPPrivDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEOPPriv> onListAll() throws Exception {
        List<PSSystem> pssystems;
        List<PSModule> psmodules;
        List<PSDataEntity> psdataentities;
        ArrayList<PSDEOPPriv> list = new ArrayList<PSDEOPPriv>();
        List<PSDER> psders = PSModelServiceUtil.getInstance().getPSDERService().listAll();
        if (psders != null) {
            for (PSDER parent : psders) {
                List<PSDEOPPriv> items = this.listByPSDER(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll()) != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEOPPriv> items = this.listByPSDataEntity(parent);
                if (items == null) continue;
                list.addAll((Collection<PSDEOPPriv>)items);
            }
        }
        if ((psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll()) != null) {
            for (PSModule parent : psmodules) {
                List<PSDEOPPriv> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSDEOPPriv> items = this.listByPSSystem(parent);
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
    protected PSDEOPPriv onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEOPPriv item;
        PSDEOPPriv item2;
        PSDEOPPriv item3;
        PSDEOPPriv item4;
        PSDER psder = (PSDER)PSModelServiceUtil.getInstance().getPSDERService().get(strParentKey, true);
        if (psder != null && (item4 = this.get(psder, strCurKey, true)) != null) {
            return item4;
        }
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item3 = this.get(psdataentity, strCurKey, true)) != null) {
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
        return (PSDEOPPriv)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEOPPrivDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDERId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDERService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
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
    public String getModelTag(PSDEOPPriv et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEOPPrivName())) {
            return et.getPSDEOPPrivName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEOPPrivDTO dto, PSDEOPPriv t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEOPPrivId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDERValidFlag() != null || !bIgnoreNull) {
            dto.setDERValidFlag(t.getDERValidFlag());
        }
        if (t.getDEValidFlag() != null || !bIgnoreNull) {
            dto.setDEValidFlag(t.getDEValidFlag());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMajorPSDEId() != null || !bIgnoreNull) {
            dto.setMajorPSDEId(t.getMajorPSDEId());
        }
        if (t.getMapPSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setMapPSDEOPPrivId(t.getMapPSDEOPPrivId());
        }
        if (t.getMapPSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setMapPSDEOPPrivName(t.getMapPSDEOPPrivName());
        }
        if (t.getMapSysUniResMode() != null || !bIgnoreNull) {
            dto.setMapSysUniResMode(t.getMapSysUniResMode());
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
        if (t.getPSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setPSDEOPPrivName(t.getPSDEOPPrivName());
        }
        if (t.getPSDERId() != null || !bIgnoreNull) {
            dto.setPSDERId(t.getPSDERId());
        }
        if (t.getPSDERName() != null || !bIgnoreNull) {
            dto.setPSDERName(t.getPSDERName());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getPSSysUniResId() != null || !bIgnoreNull) {
            dto.setPSSysUniResId(t.getPSSysUniResId());
        }
        if (t.getPSSysUniResName() != null || !bIgnoreNull) {
            dto.setPSSysUniResName(t.getPSSysUniResName());
        }
        if (t.getSystemFlag() != null || !bIgnoreNull) {
            dto.setSystemFlag(t.getSystemFlag());
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
        if (StringUtils.hasLength((String)dto.getMapPSDEOPPrivId())) {
            dto.setMapPSDEOPPrivId(this.getRealPSModelId(t, dto.getMapPSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            dto.setPSDERId(this.getRealPSModelId(t, dto.getPSDERId()).replace("/", "."));
        }
        if ("PSDER".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDERId(t.getSrfParent().getId().replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysUniResId())) {
            dto.setPSSysUniResId(this.getRealPSModelId(t, dto.getPSSysUniResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMapPSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getMapPSDEOPPrivId());
            dto.setMapPSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setMapPSDEOPPrivName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setDEValidFlag(((PSDataEntityDTO)linkDTO).getValidFlag());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setDEValidFlag(null);
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getPSDERId());
            dto.setDERValidFlag(((PSDERDTO)linkDTO).getValidFlag());
            dto.setMajorPSDEId(((PSDERDTO)linkDTO).getMajorPSDEId());
            dto.setPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setDERValidFlag(null);
            dto.setMajorPSDEId(null);
            dto.setPSDERName(null);
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
        return "PSDEOPPRIV";
    }

    @Override
    public PSDEOPPriv createDomain() {
        return new PSDEOPPriv();
    }

    @Override
    public PSDEOPPrivDTO createDTO() {
        return new PSDEOPPrivDTO();
    }
}

