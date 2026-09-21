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
import net.ibizsys.modelapi.domain.PSDEServiceAPI;
import net.ibizsys.modelapi.domain.PSSysServiceAPI;
import net.ibizsys.modelapi.dto.PSDEFGroupDTO;
import net.ibizsys.modelapi.dto.PSDEServiceAPIDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysServiceAPIDTO;
import net.ibizsys.modelapi.service.IPSDEServiceAPIService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEServiceAPIServiceImpl
extends PSModelServiceImplBase<PSDEServiceAPI, PSDEServiceAPIDTO>
implements IPSDEServiceAPIService {
    private static final Log log = LogFactory.getLog(PSDEServiceAPIServiceImpl.class);

    @Override
    public List<PSDEServiceAPI> listByPSSysServiceAPI(PSSysServiceAPI parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEServiceAPI get(PSSysServiceAPI parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEServiceAPI> list = this.listByPSSysServiceAPI(parent);
        if (list != null) {
            for (PSDEServiceAPI item : list) {
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
    public List<PSDEServiceAPIDTO> listDTOByPSSysServiceAPI(String strParentKey) throws Exception {
        PSSysServiceAPI pssysserviceapi = (PSSysServiceAPI)PSModelServiceUtil.getInstance().getPSSysServiceAPIService().get(strParentKey);
        List<PSDEServiceAPI> list = this.listByPSSysServiceAPI(pssysserviceapi);
        if (list != null) {
            ArrayList<PSDEServiceAPIDTO> dtoList = new ArrayList<PSDEServiceAPIDTO>();
            for (PSDEServiceAPI item : list) {
                PSDEServiceAPIDTO dto = (PSDEServiceAPIDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEServiceAPI> onListAll() throws Exception {
        ArrayList<PSDEServiceAPI> list = new ArrayList<PSDEServiceAPI>();
        List pssysserviceapis = PSModelServiceUtil.getInstance().getPSSysServiceAPIService().listAll();
        if (pssysserviceapis != null) {
            for (PSSysServiceAPI parent : pssysserviceapis) {
                List<PSDEServiceAPI> items = this.listByPSSysServiceAPI(parent);
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
    protected PSDEServiceAPI onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEServiceAPI item;
        PSSysServiceAPI pssysserviceapi = (PSSysServiceAPI)PSModelServiceUtil.getInstance().getPSSysServiceAPIService().get(strParentKey, true);
        if (pssysserviceapi != null && (item = this.get(pssysserviceapi, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEServiceAPI)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEServiceAPIDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysServiceAPIId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysServiceAPIService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEServiceAPI et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEServiceAPIName())) {
            return et.getPSDEServiceAPIName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEServiceAPIDTO dto, PSDEServiceAPI t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEServiceAPIId(t.getId().replace("/", "."));
        }
        if (t.getAccCtrlArch() != null || !bIgnoreNull) {
            dto.setAccCtrlArch(t.getAccCtrlArch());
        }
        if (t.getBaseClsParams() != null || !bIgnoreNull) {
            dto.setBaseClsParams(t.getBaseClsParams());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getCodeName2() != null || !bIgnoreNull) {
            dto.setCodeName2(t.getCodeName2());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDataAccMode() != null || !bIgnoreNull) {
            dto.setDataAccMode(t.getDataAccMode());
        }
        if (t.getDEFGroupMode() != null || !bIgnoreNull) {
            dto.setDEFGroupMode(t.getDEFGroupMode());
        }
        if (t.getDELogicName() != null || !bIgnoreNull) {
            dto.setDELogicName(t.getDELogicName());
        }
        if (t.getEnableDataExport() != null || !bIgnoreNull) {
            dto.setEnableDataExport(t.getEnableDataExport());
        }
        if (t.getEnableDataImport() != null || !bIgnoreNull) {
            dto.setEnableDataImport(t.getEnableDataImport());
        }
        if (t.getEnableDEAction() != null || !bIgnoreNull) {
            dto.setEnableDEAction(t.getEnableDEAction());
        }
        if (t.getEnableDEDataSet() != null || !bIgnoreNull) {
            dto.setEnableDEDataSet(t.getEnableDEDataSet());
        }
        if (t.getEnableSelect() != null || !bIgnoreNull) {
            dto.setEnableSelect(t.getEnableSelect());
        }
        if (t.getEnaTempData() != null || !bIgnoreNull) {
            dto.setEnaTempData(t.getEnaTempData());
        }
        if (t.getLNPSLanResId() != null || !bIgnoreNull) {
            dto.setLNPSLanResId(t.getLNPSLanResId());
        }
        if (t.getLNPSLanResName() != null || !bIgnoreNull) {
            dto.setLNPSLanResName(t.getLNPSLanResName());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMajorFlag() != null || !bIgnoreNull) {
            dto.setMajorFlag(t.getMajorFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSDEFGroupId() != null || !bIgnoreNull) {
            dto.setPSDEFGroupId(t.getPSDEFGroupId());
        }
        if (t.getPSDEFGroupName() != null || !bIgnoreNull) {
            dto.setPSDEFGroupName(t.getPSDEFGroupName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDEServiceAPIName() != null || !bIgnoreNull) {
            dto.setPSDEServiceAPIName(t.getPSDEServiceAPIName());
        }
        if (t.getPSSysServiceAPIId() != null || !bIgnoreNull) {
            dto.setPSSysServiceAPIId(t.getPSSysServiceAPIId());
        }
        if (t.getPSSysServiceAPIName() != null || !bIgnoreNull) {
            dto.setPSSysServiceAPIName(t.getPSSysServiceAPIName());
        }
        if (t.getPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginId(t.getPSSysSFPluginId());
        }
        if (t.getPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginName(t.getPSSysSFPluginName());
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
        if (StringUtils.hasLength((String)dto.getLNPSLanResId())) {
            dto.setLNPSLanResId(this.getRealPSModelId(t, dto.getLNPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFGroupId())) {
            dto.setPSDEFGroupId(this.getRealPSModelId(t, dto.getPSDEFGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysServiceAPIId())) {
            dto.setPSSysServiceAPIId(this.getRealPSModelId(t, dto.getPSSysServiceAPIId()).replace("/", "."));
        }
        if ("PSSYSSERVICEAPI".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysServiceAPIId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLNPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getLNPSLanResId());
            dto.setLNPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setLNPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFGroupId())) {
            linkDTO = (PSDEFGroupDTO)PSModelServiceUtil.getInstance().getPSDEFGroupService().getDTO(dto.getPSDEFGroupId());
            dto.setPSDEFGroupName(((PSDEFGroupDTO)linkDTO).getPSDEFGroupName());
        } else {
            dto.setPSDEFGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setDELogicName(((PSDataEntityDTO)linkDTO).getLogicName());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setDELogicName(null);
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysServiceAPIId())) {
            linkDTO = (PSSysServiceAPIDTO)PSModelServiceUtil.getInstance().getPSSysServiceAPIService().getDTO(dto.getPSSysServiceAPIId());
            dto.setPSSysServiceAPIName(((PSSysServiceAPIDTO)linkDTO).getPSSysServiceAPIName());
        } else {
            dto.setPSSysServiceAPIName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getPSSysSFPluginId());
            dto.setPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setPSSysSFPluginName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSDESERVICEAPI";
    }

    @Override
    public PSDEServiceAPI createDomain() {
        return new PSDEServiceAPI();
    }

    @Override
    public PSDEServiceAPIDTO createDTO() {
        return new PSDEServiceAPIDTO();
    }
}

