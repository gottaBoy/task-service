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
import net.ibizsys.modelapi.domain.PSDESADetail;
import net.ibizsys.modelapi.domain.PSDESADetailParam;
import net.ibizsys.modelapi.domain.PSDESARS;
import net.ibizsys.modelapi.domain.PSDEServiceAPI;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEDataQueryDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEOPPrivDTO;
import net.ibizsys.modelapi.dto.PSDESADetailDTO;
import net.ibizsys.modelapi.dto.PSDESADetailParamDTO;
import net.ibizsys.modelapi.dto.PSDESARSDTO;
import net.ibizsys.modelapi.dto.PSDEServiceAPIDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.service.IPSDESADetailService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDESADetailServiceImpl
extends PSModelServiceImplBase<PSDESADetail, PSDESADetailDTO>
implements IPSDESADetailService {
    private static final Log log = LogFactory.getLog(PSDESADetailServiceImpl.class);

    @Override
    public List<PSDESADetail> listByPSDESARS(PSDESARS parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDESADetail get(PSDESARS parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDESADetail> list = this.listByPSDESARS(parent);
        if (list != null) {
            for (PSDESADetail item : list) {
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
    public List<PSDESADetailDTO> listDTOByPSDESARS(String strParentKey) throws Exception {
        PSDESARS psdesars = (PSDESARS)PSModelServiceUtil.getInstance().getPSDESARSService().get(strParentKey);
        List<PSDESADetail> list = this.listByPSDESARS(psdesars);
        if (list != null) {
            ArrayList<PSDESADetailDTO> dtoList = new ArrayList<PSDESADetailDTO>();
            for (PSDESADetail item : list) {
                PSDESADetailDTO dto = (PSDESADetailDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDESADetail> listByPSDEServiceAPI(PSDEServiceAPI parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDESADetail get(PSDEServiceAPI parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDESADetail> list = this.listByPSDEServiceAPI(parent);
        if (list != null) {
            for (PSDESADetail item : list) {
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
    public List<PSDESADetailDTO> listDTOByPSDEServiceAPI(String strParentKey) throws Exception {
        PSDEServiceAPI psdeserviceapi = (PSDEServiceAPI)PSModelServiceUtil.getInstance().getPSDEServiceAPIService().get(strParentKey);
        List<PSDESADetail> list = this.listByPSDEServiceAPI(psdeserviceapi);
        if (list != null) {
            ArrayList<PSDESADetailDTO> dtoList = new ArrayList<PSDESADetailDTO>();
            for (PSDESADetail item : list) {
                PSDESADetailDTO dto = (PSDESADetailDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDESADetail> onListAll() throws Exception {
        List psdeserviceapis;
        ArrayList<PSDESADetail> list = new ArrayList<PSDESADetail>();
        List psdesars = PSModelServiceUtil.getInstance().getPSDESARSService().listAll();
        if (psdesars != null) {
            for (PSDESARS parent : psdesars) {
                List<PSDESADetail> items = this.listByPSDESARS(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((psdeserviceapis = PSModelServiceUtil.getInstance().getPSDEServiceAPIService().listAll()) != null) {
            for (PSDEServiceAPI parent : psdeserviceapis) {
                List<PSDESADetail> items = this.listByPSDEServiceAPI(parent);
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
    protected PSDESADetail onGet(String strParentKey, String strCurKey) throws Exception {
        PSDESADetail item;
        PSDESADetail item2;
        PSDESARS psdesars = (PSDESARS)PSModelServiceUtil.getInstance().getPSDESARSService().get(strParentKey, true);
        if (psdesars != null && (item2 = this.get(psdesars, strCurKey, true)) != null) {
            return item2;
        }
        PSDEServiceAPI psdeserviceapi = (PSDEServiceAPI)PSModelServiceUtil.getInstance().getPSDEServiceAPIService().get(strParentKey, true);
        if (psdeserviceapi != null && (item = this.get(psdeserviceapi, strCurKey, true)) != null) {
            return item;
        }
        return (PSDESADetail)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDESADetailDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDESARSId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDESARSService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSDEServiceAPIId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEServiceAPIService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDESADetail et) throws Exception {
        if (StringUtils.hasLength((String)et.getUniqueTag())) {
            return et.getUniqueTag();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDESADetailDTO dto, PSDESADetail t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDESADetailId(t.getId().replace("/", "."));
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
        if (t.getDetailParam() != null || !bIgnoreNull) {
            dto.setDetailParam(t.getDetailParam());
        }
        if (t.getDetailParam2() != null || !bIgnoreNull) {
            dto.setDetailParam2(t.getDetailParam2());
        }
        if (t.getDetailType() != null || !bIgnoreNull) {
            dto.setDetailType(t.getDetailType());
        }
        if (t.getInPSDEServiceAPIId() != null || !bIgnoreNull) {
            dto.setInPSDEServiceAPIId(t.getInPSDEServiceAPIId());
        }
        if (t.getInPSDEServiceAPIName() != null || !bIgnoreNull) {
            dto.setInPSDEServiceAPIName(t.getInPSDEServiceAPIName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMethodTag() != null || !bIgnoreNull) {
            dto.setMethodTag(t.getMethodTag());
        }
        if (t.getNeedResourceKey() != null || !bIgnoreNull) {
            dto.setNeedResourceKey(t.getNeedResourceKey());
        }
        if (t.getNoServiceCodeName() != null || !bIgnoreNull) {
            dto.setNoServiceCodeName(t.getNoServiceCodeName());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getOutPSDEServiceAPIId() != null || !bIgnoreNull) {
            dto.setOutPSDEServiceAPIId(t.getOutPSDEServiceAPIId());
        }
        if (t.getOutPSDEServiceAPIName() != null || !bIgnoreNull) {
            dto.setOutPSDEServiceAPIName(t.getOutPSDEServiceAPIName());
        }
        if (t.getParentKeyMode() != null || !bIgnoreNull) {
            dto.setParentKeyMode(t.getParentKeyMode());
        }
        if (t.getPSDEActionId() != null || !bIgnoreNull) {
            dto.setPSDEActionId(t.getPSDEActionId());
        }
        if (t.getPSDEActionName() != null || !bIgnoreNull) {
            dto.setPSDEActionName(t.getPSDEActionName());
        }
        if (t.getPSDEDQId() != null || !bIgnoreNull) {
            dto.setPSDEDQId(t.getPSDEDQId());
        }
        if (t.getPSDEDQName() != null || !bIgnoreNull) {
            dto.setPSDEDQName(t.getPSDEDQName());
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
        if (t.getPSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setPSDEOPPrivId(t.getPSDEOPPrivId());
        }
        if (t.getPSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setPSDEOPPrivName(t.getPSDEOPPrivName());
        }
        if (t.getPSDESADetailName() != null || !bIgnoreNull) {
            dto.setPSDESADetailName(t.getPSDESADetailName());
        }
        if (t.getPSDESARSId() != null || !bIgnoreNull) {
            dto.setPSDESARSId(t.getPSDESARSId());
        }
        if (t.getPSDESARSName() != null || !bIgnoreNull) {
            dto.setPSDESARSName(t.getPSDESARSName());
        }
        if (t.getPSDEServiceAPIId() != null || !bIgnoreNull) {
            dto.setPSDEServiceAPIId(t.getPSDEServiceAPIId());
        }
        if (t.getPSDEServiceAPIName() != null || !bIgnoreNull) {
            dto.setPSDEServiceAPIName(t.getPSDEServiceAPIName());
        }
        if (t.getPSSysServiceAPIId() != null || !bIgnoreNull) {
            dto.setPSSysServiceAPIId(t.getPSSysServiceAPIId());
        }
        if (t.getPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginId(t.getPSSysSFPluginId());
        }
        if (t.getPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginName(t.getPSSysSFPluginName());
        }
        if (t.getRequestField() != null || !bIgnoreNull) {
            dto.setRequestField(t.getRequestField());
        }
        if (t.getRequestMethod() != null || !bIgnoreNull) {
            dto.setRequestMethod(t.getRequestMethod());
        }
        if (t.getRequestParamType() != null || !bIgnoreNull) {
            dto.setRequestParamType(t.getRequestParamType());
        }
        if (t.getRetValType() != null || !bIgnoreNull) {
            dto.setRetValType(t.getRetValType());
        }
        if (t.getServiceUrl() != null || !bIgnoreNull) {
            dto.setServiceUrl(t.getServiceUrl());
        }
        if (t.getUniqueTag() != null || !bIgnoreNull) {
            dto.setUniqueTag(t.getUniqueTag());
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
        if (StringUtils.hasLength((String)dto.getInPSDEServiceAPIId())) {
            dto.setInPSDEServiceAPIId(this.getRealPSModelId(t, dto.getInPSDEServiceAPIId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOutPSDEServiceAPIId())) {
            dto.setOutPSDEServiceAPIId(this.getRealPSModelId(t, dto.getOutPSDEServiceAPIId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            dto.setPSDEActionId(this.getRealPSModelId(t, dto.getPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDQId())) {
            dto.setPSDEDQId(this.getRealPSModelId(t, dto.getPSDEDQId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            dto.setPSDEDSId(this.getRealPSModelId(t, dto.getPSDEDSId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEOPPrivId())) {
            dto.setPSDEOPPrivId(this.getRealPSModelId(t, dto.getPSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDESARSId())) {
            dto.setPSDESARSId(this.getRealPSModelId(t, dto.getPSDESARSId()).replace("/", "."));
        }
        if ("PSDESARS".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDESARSId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEServiceAPIId())) {
            dto.setPSDEServiceAPIId(this.getRealPSModelId(t, dto.getPSDEServiceAPIId()).replace("/", "."));
        }
        if ("PSDESERVICEAPI".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEServiceAPIId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getInPSDEServiceAPIId())) {
            linkDTO = (PSDEServiceAPIDTO)PSModelServiceUtil.getInstance().getPSDEServiceAPIService().getDTO(dto.getInPSDEServiceAPIId());
            dto.setInPSDEServiceAPIName(((PSDEServiceAPIDTO)linkDTO).getPSDEServiceAPIName());
        } else {
            dto.setInPSDEServiceAPIName(null);
        }
        if (StringUtils.hasLength((String)dto.getOutPSDEServiceAPIId())) {
            linkDTO = (PSDEServiceAPIDTO)PSModelServiceUtil.getInstance().getPSDEServiceAPIService().getDTO(dto.getOutPSDEServiceAPIId());
            dto.setOutPSDEServiceAPIName(((PSDEServiceAPIDTO)linkDTO).getPSDEServiceAPIName());
        } else {
            dto.setOutPSDEServiceAPIName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getPSDEActionId());
            dto.setPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDQId())) {
            linkDTO = (PSDEDataQueryDTO)PSModelServiceUtil.getInstance().getPSDEDataQueryService().getDTO(dto.getPSDEDQId());
            dto.setPSDEDQName(((PSDEDataQueryDTO)linkDTO).getPSDEDataQueryName());
        } else {
            dto.setPSDEDQName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getPSDEDSId());
            dto.setPSDEDSName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setPSDEDSName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getPSDEOPPrivId());
            dto.setPSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setPSDEOPPrivName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDESARSId())) {
            linkDTO = (PSDESARSDTO)PSModelServiceUtil.getInstance().getPSDESARSService().getDTO(dto.getPSDESARSId());
            dto.setPSDESARSName(((PSDESARSDTO)linkDTO).getPSDESARSName());
        } else {
            dto.setPSDESARSName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEServiceAPIId())) {
            linkDTO = (PSDEServiceAPIDTO)PSModelServiceUtil.getInstance().getPSDEServiceAPIService().getDTO(dto.getPSDEServiceAPIId());
            dto.setPSDEId(((PSDEServiceAPIDTO)linkDTO).getPSDEId());
            dto.setPSDEServiceAPIName(((PSDEServiceAPIDTO)linkDTO).getPSDEServiceAPIName());
            dto.setPSSysServiceAPIId(((PSDEServiceAPIDTO)linkDTO).getPSSysServiceAPIId());
        } else {
            dto.setPSDEId(null);
            dto.setPSDEServiceAPIName(null);
            dto.setPSSysServiceAPIId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getPSSysSFPluginId());
            dto.setPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setPSSysSFPluginName(null);
        }
        List<PSDESADetailParam> list = PSModelServiceUtil.getInstance().getPSDESADetailParamService().listByPSDESADetail(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDESADetailParamDTO> psdesadetailparams = new ArrayList<PSDESADetailParamDTO>();
            for (PSDESADetailParam item : list) {
                PSDESADetailParamDTO dstItem = (PSDESADetailParamDTO)PSModelServiceUtil.getInstance().getPSDESADetailParamService().toDTO(item);
                psdesadetailparams.add(dstItem);
            }
            dto.setPsdesadetailparams(psdesadetailparams);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDESADETAIL";
    }

    @Override
    public PSDESADetail createDomain() {
        return new PSDESADetail();
    }

    @Override
    public PSDESADetailDTO createDTO() {
        return new PSDESADetailDTO();
    }
}

