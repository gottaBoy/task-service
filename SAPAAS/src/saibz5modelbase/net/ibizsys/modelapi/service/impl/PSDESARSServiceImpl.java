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
import net.ibizsys.modelapi.domain.PSDESARS;
import net.ibizsys.modelapi.domain.PSSysServiceAPI;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSDESARSDTO;
import net.ibizsys.modelapi.dto.PSDEServiceAPIDTO;
import net.ibizsys.modelapi.dto.PSSysServiceAPIDTO;
import net.ibizsys.modelapi.service.IPSDESARSService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDESARSServiceImpl
extends PSModelServiceImplBase<PSDESARS, PSDESARSDTO>
implements IPSDESARSService {
    private static final Log log = LogFactory.getLog(PSDESARSServiceImpl.class);

    @Override
    public List<PSDESARS> listByPSSysServiceAPI(PSSysServiceAPI parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDESARS get(PSSysServiceAPI parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDESARS> list = this.listByPSSysServiceAPI(parent);
        if (list != null) {
            for (PSDESARS item : list) {
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
    public List<PSDESARSDTO> listDTOByPSSysServiceAPI(String strParentKey) throws Exception {
        PSSysServiceAPI pssysserviceapi = (PSSysServiceAPI)PSModelServiceUtil.getInstance().getPSSysServiceAPIService().get(strParentKey);
        List<PSDESARS> list = this.listByPSSysServiceAPI(pssysserviceapi);
        if (list != null) {
            ArrayList<PSDESARSDTO> dtoList = new ArrayList<PSDESARSDTO>();
            for (PSDESARS item : list) {
                PSDESARSDTO dto = (PSDESARSDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDESARS> onListAll() throws Exception {
        ArrayList<PSDESARS> list = new ArrayList<PSDESARS>();
        List pssysserviceapis = PSModelServiceUtil.getInstance().getPSSysServiceAPIService().listAll();
        if (pssysserviceapis != null) {
            for (PSSysServiceAPI parent : pssysserviceapis) {
                List<PSDESARS> items = this.listByPSSysServiceAPI(parent);
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
    protected PSDESARS onGet(String strParentKey, String strCurKey) throws Exception {
        PSDESARS item;
        PSSysServiceAPI pssysserviceapi = (PSSysServiceAPI)PSModelServiceUtil.getInstance().getPSSysServiceAPIService().get(strParentKey, true);
        if (pssysserviceapi != null && (item = this.get(pssysserviceapi, strCurKey, true)) != null) {
            return item;
        }
        return (PSDESARS)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDESARSDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysServiceAPIId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysServiceAPIService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDESARS et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDESARSName())) {
            return et.getPSDESARSName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDESARSDTO dto, PSDESARS t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDESARSId(t.getId().replace("/", "."));
        }
        if (t.getActionRSMode() != null || !bIgnoreNull) {
            dto.setActionRSMode(t.getActionRSMode());
        }
        if (t.getArrayFlag() != null || !bIgnoreNull) {
            dto.setArrayFlag(t.getArrayFlag());
        }
        if (t.getChildFilter() != null || !bIgnoreNull) {
            dto.setChildFilter(t.getChildFilter());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getCodeName2() != null || !bIgnoreNull) {
            dto.setCodeName2(t.getCodeName2());
        }
        if (t.getCPSDEId() != null || !bIgnoreNull) {
            dto.setCPSDEId(t.getCPSDEId());
        }
        if (t.getCPSDEServiceAPIId() != null || !bIgnoreNull) {
            dto.setCPSDEServiceAPIId(t.getCPSDEServiceAPIId());
        }
        if (t.getCPSDEServiceAPIName() != null || !bIgnoreNull) {
            dto.setCPSDEServiceAPIName(t.getCPSDEServiceAPIName());
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
        if (t.getDataRSMode() != null || !bIgnoreNull) {
            dto.setDataRSMode(t.getDataRSMode());
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
        if (t.getExportModel() != null || !bIgnoreNull) {
            dto.setExportModel(t.getExportModel());
        }
        if (t.getExportScope() != null || !bIgnoreNull) {
            dto.setExportScope(t.getExportScope());
        }
        if (t.getExportScope2() != null || !bIgnoreNull) {
            dto.setExportScope2(t.getExportScope2());
        }
        if (t.getExportScope3() != null || !bIgnoreNull) {
            dto.setExportScope3(t.getExportScope3());
        }
        if (t.getExportScope4() != null || !bIgnoreNull) {
            dto.setExportScope4(t.getExportScope4());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPPSDEId() != null || !bIgnoreNull) {
            dto.setPPSDEId(t.getPPSDEId());
        }
        if (t.getPPSDEServiceAPIId() != null || !bIgnoreNull) {
            dto.setPPSDEServiceAPIId(t.getPPSDEServiceAPIId());
        }
        if (t.getPPSDEServiceAPIName() != null || !bIgnoreNull) {
            dto.setPPSDEServiceAPIName(t.getPPSDEServiceAPIName());
        }
        if (t.getPSDERId() != null || !bIgnoreNull) {
            dto.setPSDERId(t.getPSDERId());
        }
        if (t.getPSDERName() != null || !bIgnoreNull) {
            dto.setPSDERName(t.getPSDERName());
        }
        if (t.getPSDESARSName() != null || !bIgnoreNull) {
            dto.setPSDESARSName(t.getPSDESARSName());
        }
        if (t.getPSSysServiceAPIId() != null || !bIgnoreNull) {
            dto.setPSSysServiceAPIId(t.getPSSysServiceAPIId());
        }
        if (t.getPSSysServiceAPIName() != null || !bIgnoreNull) {
            dto.setPSSysServiceAPIName(t.getPSSysServiceAPIName());
        }
        if (t.getSyncExportModel() != null || !bIgnoreNull) {
            dto.setSyncExportModel(t.getSyncExportModel());
        }
        if (t.getTempOrderValue() != null || !bIgnoreNull) {
            dto.setTempOrderValue(t.getTempOrderValue());
        }
        if (t.getTypeFilter() != null || !bIgnoreNull) {
            dto.setTypeFilter(t.getTypeFilter());
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
        if (StringUtils.hasLength((String)dto.getCPSDEServiceAPIId())) {
            dto.setCPSDEServiceAPIId(this.getRealPSModelId(t, dto.getCPSDEServiceAPIId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSDEServiceAPIId())) {
            dto.setPPSDEServiceAPIId(this.getRealPSModelId(t, dto.getPPSDEServiceAPIId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            dto.setPSDERId(this.getRealPSModelId(t, dto.getPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysServiceAPIId())) {
            dto.setPSSysServiceAPIId(this.getRealPSModelId(t, dto.getPSSysServiceAPIId()).replace("/", "."));
        }
        if ("PSSYSSERVICEAPI".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysServiceAPIId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCPSDEServiceAPIId())) {
            linkDTO = (PSDEServiceAPIDTO)PSModelServiceUtil.getInstance().getPSDEServiceAPIService().getDTO(dto.getCPSDEServiceAPIId());
            dto.setCPSDEId(((PSDEServiceAPIDTO)linkDTO).getPSDEId());
            dto.setCPSDEServiceAPIName(((PSDEServiceAPIDTO)linkDTO).getPSDEServiceAPIName());
        } else {
            dto.setCPSDEId(null);
            dto.setCPSDEServiceAPIName(null);
        }
        if (StringUtils.hasLength((String)dto.getPPSDEServiceAPIId())) {
            linkDTO = (PSDEServiceAPIDTO)PSModelServiceUtil.getInstance().getPSDEServiceAPIService().getDTO(dto.getPPSDEServiceAPIId());
            dto.setPPSDEId(((PSDEServiceAPIDTO)linkDTO).getPSDEId());
            dto.setPPSDEServiceAPIName(((PSDEServiceAPIDTO)linkDTO).getPSDEServiceAPIName());
        } else {
            dto.setPPSDEId(null);
            dto.setPPSDEServiceAPIName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getPSDERId());
            dto.setPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysServiceAPIId())) {
            linkDTO = (PSSysServiceAPIDTO)PSModelServiceUtil.getInstance().getPSSysServiceAPIService().getDTO(dto.getPSSysServiceAPIId());
            dto.setPSSysServiceAPIName(((PSSysServiceAPIDTO)linkDTO).getPSSysServiceAPIName());
        } else {
            dto.setPSSysServiceAPIName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSDESARS";
    }

    @Override
    public PSDESARS createDomain() {
        return new PSDESARS();
    }

    @Override
    public PSDESARSDTO createDTO() {
        return new PSDESARSDTO();
    }
}

