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
import net.ibizsys.modelapi.domain.PSCodeItem;
import net.ibizsys.modelapi.domain.PSCodeList;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSCodeItemDTO;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSCodeListService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSCodeListServiceImpl
extends PSModelServiceImplBase<PSCodeList, PSCodeListDTO>
implements IPSCodeListService {
    private static final Log log = LogFactory.getLog(PSCodeListServiceImpl.class);

    @Override
    public List<PSCodeList> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSCodeList get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSCodeList> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSCodeList item : list) {
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
    public List<PSCodeListDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSCodeList> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSCodeListDTO> dtoList = new ArrayList<PSCodeListDTO>();
            for (PSCodeList item : list) {
                PSCodeListDTO dto = (PSCodeListDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSCodeList> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSCodeList get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSCodeList> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSCodeList item : list) {
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
    public List<PSCodeListDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSCodeList> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSCodeListDTO> dtoList = new ArrayList<PSCodeListDTO>();
            for (PSCodeList item : list) {
                PSCodeListDTO dto = (PSCodeListDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSCodeList> onListAll() throws Exception {
        List<PSSystem> pssystems;
        ArrayList<PSCodeList> list = new ArrayList<PSCodeList>();
        List<PSModule> psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll();
        if (psmodules != null) {
            for (PSModule parent : psmodules) {
                List<PSCodeList> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSCodeList> items = this.listByPSSystem(parent);
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
    protected PSCodeList onGet(String strParentKey, String strCurKey) throws Exception {
        PSCodeList item;
        PSCodeList item2;
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item2 = this.get(psmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSCodeList)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSCodeListDTO dto) throws Exception {
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
    public String getModelTag(PSCodeList et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSCodeListDTO dto, PSCodeList t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSCodeListId(t.getId().replace("/", "."));
        }
        if (t.getBeginValuePSDEFId() != null || !bIgnoreNull) {
            dto.setBeginValuePSDEFId(t.getBeginValuePSDEFId());
        }
        if (t.getBeginValuePSDEFName() != null || !bIgnoreNull) {
            dto.setBeginValuePSDEFName(t.getBeginValuePSDEFName());
        }
        if (t.getBKColorPSDEFId() != null || !bIgnoreNull) {
            dto.setBKColorPSDEFId(t.getBKColorPSDEFId());
        }
        if (t.getBKColorPSDEFName() != null || !bIgnoreNull) {
            dto.setBKColorPSDEFName(t.getBKColorPSDEFName());
        }
        if (t.getCacheCat() != null || !bIgnoreNull) {
            dto.setCacheCat(t.getCacheCat());
        }
        if (t.getCacheTag() != null || !bIgnoreNull) {
            dto.setCacheTag(t.getCacheTag());
        }
        if (t.getCacheTimeout() != null || !bIgnoreNull) {
            dto.setCacheTimeout(t.getCacheTimeout());
        }
        if (t.getClsPSDEFId() != null || !bIgnoreNull) {
            dto.setClsPSDEFId(t.getClsPSDEFId());
        }
        if (t.getClsPSDEFName() != null || !bIgnoreNull) {
            dto.setClsPSDEFName(t.getClsPSDEFName());
        }
        if (t.getCLType() != null || !bIgnoreNull) {
            dto.setCLType(t.getCLType());
        }
        if (t.getCodeListSN() != null || !bIgnoreNull) {
            dto.setCodeListSN(t.getCodeListSN());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getColorPSDEFId() != null || !bIgnoreNull) {
            dto.setColorPSDEFId(t.getColorPSDEFId());
        }
        if (t.getColorPSDEFName() != null || !bIgnoreNull) {
            dto.setColorPSDEFName(t.getColorPSDEFName());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCustomCond() != null || !bIgnoreNull) {
            dto.setCustomCond(t.getCustomCond());
        }
        if (t.getDataPSDEFId() != null || !bIgnoreNull) {
            dto.setDataPSDEFId(t.getDataPSDEFId());
        }
        if (t.getDataPSDEFName() != null || !bIgnoreNull) {
            dto.setDataPSDEFName(t.getDataPSDEFName());
        }
        if (t.getDisablePSDEFId() != null || !bIgnoreNull) {
            dto.setDisablePSDEFId(t.getDisablePSDEFId());
        }
        if (t.getDisablePSDEFName() != null || !bIgnoreNull) {
            dto.setDisablePSDEFName(t.getDisablePSDEFName());
        }
        if (t.getDSConditions() != null || !bIgnoreNull) {
            dto.setDSConditions(t.getDSConditions());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getDynaSysRefMode() != null || !bIgnoreNull) {
            dto.setDynaSysRefMode(t.getDynaSysRefMode());
        }
        if (t.getEmptyText() != null || !bIgnoreNull) {
            dto.setEmptyText(t.getEmptyText());
        }
        if (t.getEmptyTextPSLanResId() != null || !bIgnoreNull) {
            dto.setEmptyTextPSLanResId(t.getEmptyTextPSLanResId());
        }
        if (t.getEmptyTextPSLanResName() != null || !bIgnoreNull) {
            dto.setEmptyTextPSLanResName(t.getEmptyTextPSLanResName());
        }
        if (t.getEnableCache() != null || !bIgnoreNull) {
            dto.setEnableCache(t.getEnableCache());
        }
        if (t.getEnableDynaSys() != null || !bIgnoreNull) {
            dto.setEnableDynaSys(t.getEnableDynaSys());
        }
        if (t.getEndValuePSDEFId() != null || !bIgnoreNull) {
            dto.setEndValuePSDEFId(t.getEndValuePSDEFId());
        }
        if (t.getEndValuePSDEFName() != null || !bIgnoreNull) {
            dto.setEndValuePSDEFName(t.getEndValuePSDEFName());
        }
        if (t.getExtendMode() != null || !bIgnoreNull) {
            dto.setExtendMode(t.getExtendMode());
        }
        if (t.getIconClsPSDEFId() != null || !bIgnoreNull) {
            dto.setIconClsPSDEFId(t.getIconClsPSDEFId());
        }
        if (t.getIconClsPSDEFName() != null || !bIgnoreNull) {
            dto.setIconClsPSDEFName(t.getIconClsPSDEFName());
        }
        if (t.getIconClsXPSDEFId() != null || !bIgnoreNull) {
            dto.setIconClsXPSDEFId(t.getIconClsXPSDEFId());
        }
        if (t.getIconClsXPSDEFName() != null || !bIgnoreNull) {
            dto.setIconClsXPSDEFName(t.getIconClsXPSDEFName());
        }
        if (t.getIconPathPSDEFId() != null || !bIgnoreNull) {
            dto.setIconPathPSDEFId(t.getIconPathPSDEFId());
        }
        if (t.getIconPathPSDEFName() != null || !bIgnoreNull) {
            dto.setIconPathPSDEFName(t.getIconPathPSDEFName());
        }
        if (t.getIconPathXPSDEFId() != null || !bIgnoreNull) {
            dto.setIconPathXPSDEFId(t.getIconPathXPSDEFId());
        }
        if (t.getIconPathXPSDEFName() != null || !bIgnoreNull) {
            dto.setIconPathXPSDEFName(t.getIconPathXPSDEFName());
        }
        if (t.getIncBeginValue() != null || !bIgnoreNull) {
            dto.setIncBeginValue(t.getIncBeginValue());
        }
        if (t.getIncEndValue() != null || !bIgnoreNull) {
            dto.setIncEndValue(t.getIncEndValue());
        }
        if (t.getLinkPSDEViewId() != null || !bIgnoreNull) {
            dto.setLinkPSDEViewId(t.getLinkPSDEViewId());
        }
        if (t.getLinkPSDEViewName() != null || !bIgnoreNull) {
            dto.setLinkPSDEViewName(t.getLinkPSDEViewName());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMinorSortDir() != null || !bIgnoreNull) {
            dto.setMinorSortDir(t.getMinorSortDir());
        }
        if (t.getMinorSortPSDEFId() != null || !bIgnoreNull) {
            dto.setMinorSortPSDEFId(t.getMinorSortPSDEFId());
        }
        if (t.getMinorSortPSDEFName() != null || !bIgnoreNull) {
            dto.setMinorSortPSDEFName(t.getMinorSortPSDEFName());
        }
        if (t.getModColor() != null || !bIgnoreNull) {
            dto.setModColor(t.getModColor());
        }
        if (t.getNoValueEmpty() != null || !bIgnoreNull) {
            dto.setNoValueEmpty(t.getNoValueEmpty());
        }
        if (t.getNumberItem() != null || !bIgnoreNull) {
            dto.setNumberItem(t.getNumberItem());
        }
        if (t.getOrMode() != null || !bIgnoreNull) {
            dto.setOrMode(t.getOrMode());
        }
        if (t.getPredefinedType() != null || !bIgnoreNull) {
            dto.setPredefinedType(t.getPredefinedType());
        }
        if (t.getPSCodeListName() != null || !bIgnoreNull) {
            dto.setPSCodeListName(t.getPSCodeListName());
        }
        if (t.getPSCodeListTemplId() != null || !bIgnoreNull) {
            dto.setPSCodeListTemplId(t.getPSCodeListTemplId());
        }
        if (t.getPSCodeListTemplName() != null || !bIgnoreNull) {
            dto.setPSCodeListTemplName(t.getPSCodeListTemplName());
        }
        if (t.getPSDEDSId() != null || !bIgnoreNull) {
            dto.setPSDEDSId(t.getPSDEDSId());
        }
        if (t.getPSDEDSName() != null || !bIgnoreNull) {
            dto.setPSDEDSName(t.getPSDEDSName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDynaCodeListId() != null || !bIgnoreNull) {
            dto.setPSDynaCodeListId(t.getPSDynaCodeListId());
        }
        if (t.getPSDynaCodeListName() != null || !bIgnoreNull) {
            dto.setPSDynaCodeListName(t.getPSDynaCodeListName());
        }
        if (t.getPSDynaInstName() != null || !bIgnoreNull) {
            dto.setPSDynaInstName(t.getPSDynaInstName());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginId(t.getPSSysPFPluginId());
        }
        if (t.getPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginName(t.getPSSysPFPluginName());
        }
        if (t.getPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginId(t.getPSSysSFPluginId());
        }
        if (t.getPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginName(t.getPSSysSFPluginName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getPValuePSDEFId() != null || !bIgnoreNull) {
            dto.setPValuePSDEFId(t.getPValuePSDEFId());
        }
        if (t.getPValuePSDEFName() != null || !bIgnoreNull) {
            dto.setPValuePSDEFName(t.getPValuePSDEFName());
        }
        if (t.getSeperator() != null || !bIgnoreNull) {
            dto.setSeperator(t.getSeperator());
        }
        if (t.getSysRefFlag() != null || !bIgnoreNull) {
            dto.setSysRefFlag(t.getSysRefFlag());
        }
        if (t.getTextPSDEFId() != null || !bIgnoreNull) {
            dto.setTextPSDEFId(t.getTextPSDEFId());
        }
        if (t.getTextPSDEFName() != null || !bIgnoreNull) {
            dto.setTextPSDEFName(t.getTextPSDEFName());
        }
        if (t.getThresholdGroupFlag() != null || !bIgnoreNull) {
            dto.setThresholdGroupFlag(t.getThresholdGroupFlag());
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
        if (t.getUserData() != null || !bIgnoreNull) {
            dto.setUserData(t.getUserData());
        }
        if (t.getUserData2() != null || !bIgnoreNull) {
            dto.setUserData2(t.getUserData2());
        }
        if (t.getUserParams() != null || !bIgnoreNull) {
            dto.setUserParams(t.getUserParams());
        }
        if (t.getUserRefFlag() != null || !bIgnoreNull) {
            dto.setUserRefFlag(t.getUserRefFlag());
        }
        if (t.getUserScope() != null || !bIgnoreNull) {
            dto.setUserScope(t.getUserScope());
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
        if (t.getValuePSDEFId() != null || !bIgnoreNull) {
            dto.setValuePSDEFId(t.getValuePSDEFId());
        }
        if (t.getValuePSDEFName() != null || !bIgnoreNull) {
            dto.setValuePSDEFName(t.getValuePSDEFName());
        }
        if (t.getValueSeperator() != null || !bIgnoreNull) {
            dto.setValueSeperator(t.getValueSeperator());
        }
        if (StringUtils.hasLength((String)dto.getBeginValuePSDEFId())) {
            dto.setBeginValuePSDEFId(this.getRealPSModelId(t, dto.getBeginValuePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getBKColorPSDEFId())) {
            dto.setBKColorPSDEFId(this.getRealPSModelId(t, dto.getBKColorPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getClsPSDEFId())) {
            dto.setClsPSDEFId(this.getRealPSModelId(t, dto.getClsPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getColorPSDEFId())) {
            dto.setColorPSDEFId(this.getRealPSModelId(t, dto.getColorPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDataPSDEFId())) {
            dto.setDataPSDEFId(this.getRealPSModelId(t, dto.getDataPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDisablePSDEFId())) {
            dto.setDisablePSDEFId(this.getRealPSModelId(t, dto.getDisablePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getEmptyTextPSLanResId())) {
            dto.setEmptyTextPSLanResId(this.getRealPSModelId(t, dto.getEmptyTextPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getEndValuePSDEFId())) {
            dto.setEndValuePSDEFId(this.getRealPSModelId(t, dto.getEndValuePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getIconClsPSDEFId())) {
            dto.setIconClsPSDEFId(this.getRealPSModelId(t, dto.getIconClsPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getIconClsXPSDEFId())) {
            dto.setIconClsXPSDEFId(this.getRealPSModelId(t, dto.getIconClsXPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getIconPathPSDEFId())) {
            dto.setIconPathPSDEFId(this.getRealPSModelId(t, dto.getIconPathPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getIconPathXPSDEFId())) {
            dto.setIconPathXPSDEFId(this.getRealPSModelId(t, dto.getIconPathXPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLinkPSDEViewId())) {
            dto.setLinkPSDEViewId(this.getRealPSModelId(t, dto.getLinkPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMinorSortPSDEFId())) {
            dto.setMinorSortPSDEFId(this.getRealPSModelId(t, dto.getMinorSortPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            dto.setPSDEDSId(this.getRealPSModelId(t, dto.getPSDEDSId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPValuePSDEFId())) {
            dto.setPValuePSDEFId(this.getRealPSModelId(t, dto.getPValuePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTextPSDEFId())) {
            dto.setTextPSDEFId(this.getRealPSModelId(t, dto.getTextPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getValuePSDEFId())) {
            dto.setValuePSDEFId(this.getRealPSModelId(t, dto.getValuePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getBeginValuePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getBeginValuePSDEFId());
            dto.setBeginValuePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setBeginValuePSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getBKColorPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getBKColorPSDEFId());
            dto.setBKColorPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setBKColorPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getClsPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getClsPSDEFId());
            dto.setClsPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setClsPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getColorPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getColorPSDEFId());
            dto.setColorPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setColorPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getDataPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getDataPSDEFId());
            dto.setDataPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setDataPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getDisablePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getDisablePSDEFId());
            dto.setDisablePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setDisablePSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getEmptyTextPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getEmptyTextPSLanResId());
            dto.setEmptyTextPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setEmptyTextPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getEndValuePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getEndValuePSDEFId());
            dto.setEndValuePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setEndValuePSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getIconClsPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getIconClsPSDEFId());
            dto.setIconClsPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setIconClsPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getIconClsXPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getIconClsXPSDEFId());
            dto.setIconClsXPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setIconClsXPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getIconPathPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getIconPathPSDEFId());
            dto.setIconPathPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setIconPathPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getIconPathXPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getIconPathXPSDEFId());
            dto.setIconPathXPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setIconPathXPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getLinkPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getLinkPSDEViewId());
            dto.setLinkPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setLinkPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getMinorSortPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getMinorSortPSDEFId());
            dto.setMinorSortPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setMinorSortPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getPSDEDSId());
            dto.setPSDEDSName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setPSDEDSName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            linkDTO = (PSModuleDTO)PSModelServiceUtil.getInstance().getPSModuleService().getDTO(dto.getPSModuleId());
            dto.setModColor(((PSModuleDTO)linkDTO).getColor());
            dto.setPSModuleName(((PSModuleDTO)linkDTO).getPSModuleName());
        } else {
            dto.setModColor(null);
            dto.setPSModuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getPSSysPFPluginId());
            dto.setPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getPSSysSFPluginId());
            dto.setPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setPSSysSFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(((PSSystemDTO)linkDTO).getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPValuePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPValuePSDEFId());
            dto.setPValuePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setPValuePSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getTextPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTextPSDEFId());
            dto.setTextPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTextPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getValuePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getValuePSDEFId());
            dto.setValuePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setValuePSDEFName(null);
        }
        List<PSCodeItem> list = PSModelServiceUtil.getInstance().getPSCodeItemService().listByPSCodeList(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSCodeItemDTO> pscodeitems = new ArrayList<PSCodeItemDTO>();
            for (PSCodeItem item : list) {
                PSCodeItemDTO dstItem = (PSCodeItemDTO)PSModelServiceUtil.getInstance().getPSCodeItemService().toDTO(item);
                pscodeitems.add(dstItem);
            }
            dto.setPscodeitems(pscodeitems);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSCODELIST";
    }

    @Override
    public PSCodeList createDomain() {
        return new PSCodeList();
    }

    @Override
    public PSCodeListDTO createDTO() {
        return new PSCodeListDTO();
    }
}

