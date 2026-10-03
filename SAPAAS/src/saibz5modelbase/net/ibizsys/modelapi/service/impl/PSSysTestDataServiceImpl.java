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
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysTDItem;
import net.ibizsys.modelapi.domain.PSSysTestData;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSDEMainStateDTO;
import net.ibizsys.modelapi.dto.PSDESampleDataDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysTDItemDTO;
import net.ibizsys.modelapi.dto.PSSysTestDataDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysTestDataService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysTestDataServiceImpl
extends PSModelServiceImplBase<PSSysTestData, PSSysTestDataDTO>
implements IPSSysTestDataService {
    private static final Log log = LogFactory.getLog(PSSysTestDataServiceImpl.class);

    @Override
    public List<PSSysTestData> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysTestData get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysTestData> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSSysTestData item : list) {
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
    public List<PSSysTestDataDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSSysTestData> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSSysTestDataDTO> dtoList = new ArrayList<PSSysTestDataDTO>();
            for (PSSysTestData item : list) {
                PSSysTestDataDTO dto = (PSSysTestDataDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysTestData> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysTestData get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysTestData> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSSysTestData item : list) {
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
    public List<PSSysTestDataDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSSysTestData> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSSysTestDataDTO> dtoList = new ArrayList<PSSysTestDataDTO>();
            for (PSSysTestData item : list) {
                PSSysTestDataDTO dto = (PSSysTestDataDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysTestData> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysTestData get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysTestData> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysTestData item : list) {
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
    public List<PSSysTestDataDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysTestData> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysTestDataDTO> dtoList = new ArrayList<PSSysTestDataDTO>();
            for (PSSysTestData item : list) {
                PSSysTestDataDTO dto = (PSSysTestDataDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysTestData> onListAll() throws Exception {
        ArrayList<PSSysTestData> list = new ArrayList<PSSysTestData>();
        List<PSDataEntity> psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSSysTestData> items = this.listByPSDataEntity(parent);
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
    protected PSSysTestData onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysTestData item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysTestData)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysTestDataDTO dto) throws Exception {
        String strPickupValue = null;
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
    public String getModelTag(PSSysTestData et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysTestDataDTO dto, PSSysTestData t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysTestDataId(t.getId().replace("/", "."));
        }
        if (t.getBaseMode() != null || !bIgnoreNull) {
            dto.setBaseMode(t.getBaseMode());
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
        if (t.getCustomCode() != null || !bIgnoreNull) {
            dto.setCustomCode(t.getCustomCode());
        }
        if (t.getData() != null || !bIgnoreNull) {
            dto.setData(t.getData());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMainPSSysTDId() != null || !bIgnoreNull) {
            dto.setMainPSSysTDId(t.getMainPSSysTDId());
        }
        if (t.getMainPSSysTDName() != null || !bIgnoreNull) {
            dto.setMainPSSysTDName(t.getMainPSSysTDName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEMainStateId() != null || !bIgnoreNull) {
            dto.setPSDEMainStateId(t.getPSDEMainStateId());
        }
        if (t.getPSDEMainStateName() != null || !bIgnoreNull) {
            dto.setPSDEMainStateName(t.getPSDEMainStateName());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDESampleDataId() != null || !bIgnoreNull) {
            dto.setPSDESampleDataId(t.getPSDESampleDataId());
        }
        if (t.getPSDESampleDataName() != null || !bIgnoreNull) {
            dto.setPSDESampleDataName(t.getPSDESampleDataName());
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
        if (t.getPSSysTestDataName() != null || !bIgnoreNull) {
            dto.setPSSysTestDataName(t.getPSSysTestDataName());
        }
        if (t.getRandomCount() != null || !bIgnoreNull) {
            dto.setRandomCount(t.getRandomCount());
        }
        if (t.getTestDataTag() != null || !bIgnoreNull) {
            dto.setTestDataTag(t.getTestDataTag());
        }
        if (t.getTestDataTag2() != null || !bIgnoreNull) {
            dto.setTestDataTag2(t.getTestDataTag2());
        }
        if (t.getTestDataType() != null || !bIgnoreNull) {
            dto.setTestDataType(t.getTestDataType());
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
        if (t.getUserFlag() != null || !bIgnoreNull) {
            dto.setUserFlag(t.getUserFlag());
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
        if (StringUtils.hasLength((String)dto.getMainPSSysTDId())) {
            dto.setMainPSSysTDId(this.getRealPSModelId(t, dto.getMainPSSysTDId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEMainStateId())) {
            dto.setPSDEMainStateId(this.getRealPSModelId(t, dto.getPSDEMainStateId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDESampleDataId())) {
            dto.setPSDESampleDataId(this.getRealPSModelId(t, dto.getPSDESampleDataId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getMainPSSysTDId())) {
            linkDTO = (PSSysTestDataDTO)PSModelServiceUtil.getInstance().getPSSysTestDataService().getDTO(dto.getMainPSSysTDId());
            dto.setMainPSSysTDName(((PSSysTestDataDTO)linkDTO).getPSSysTestDataName());
        } else {
            dto.setMainPSSysTDName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEMainStateId())) {
            linkDTO = (PSDEMainStateDTO)PSModelServiceUtil.getInstance().getPSDEMainStateService().getDTO(dto.getPSDEMainStateId());
            dto.setPSDEMainStateName(((PSDEMainStateDTO)linkDTO).getPSDEMainStateName());
        } else {
            dto.setPSDEMainStateName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDESampleDataId())) {
            linkDTO = (PSDESampleDataDTO)PSModelServiceUtil.getInstance().getPSDESampleDataService().getDTO(dto.getPSDESampleDataId());
            dto.setPSDESampleDataName(((PSDESampleDataDTO)linkDTO).getPSDESampleDataName());
        } else {
            dto.setPSDESampleDataName(null);
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
        List<PSSysTDItem> list = PSModelServiceUtil.getInstance().getPSSysTDItemService().listByPSSysTestData(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSSysTDItemDTO> pssystditems = new ArrayList<PSSysTDItemDTO>();
            for (PSSysTDItem item : list) {
                PSSysTDItemDTO dstItem = (PSSysTDItemDTO)PSModelServiceUtil.getInstance().getPSSysTDItemService().toDTO(item);
                pssystditems.add(dstItem);
            }
            dto.setPssystditems(pssystditems);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSTESTDATA";
    }

    @Override
    public PSSysTestData createDomain() {
        return new PSSysTestData();
    }

    @Override
    public PSSysTestDataDTO createDTO() {
        return new PSSysTestDataDTO();
    }
}

