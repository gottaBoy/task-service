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
import net.ibizsys.modelapi.domain.PSSubSysSADE;
import net.ibizsys.modelapi.domain.PSSubSysSADetail;
import net.ibizsys.modelapi.domain.PSSubSysSADetailParam;
import net.ibizsys.modelapi.domain.PSSubSysServiceAPI;
import net.ibizsys.modelapi.dto.PSSubSysSADEDTO;
import net.ibizsys.modelapi.dto.PSSubSysSADetailDTO;
import net.ibizsys.modelapi.dto.PSSubSysSADetailParamDTO;
import net.ibizsys.modelapi.dto.PSSubSysServiceAPIDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.service.IPSSubSysSADetailService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSubSysSADetailServiceImpl
extends PSModelServiceImplBase<PSSubSysSADetail, PSSubSysSADetailDTO>
implements IPSSubSysSADetailService {
    private static final Log log = LogFactory.getLog(PSSubSysSADetailServiceImpl.class);

    @Override
    public List<PSSubSysSADetail> listByPSSubSysSADE(PSSubSysSADE parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSubSysSADetail get(PSSubSysSADE parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSubSysSADetail> list = this.listByPSSubSysSADE(parent);
        if (list != null) {
            for (PSSubSysSADetail item : list) {
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
    public List<PSSubSysSADetailDTO> listDTOByPSSubSysSADE(String strParentKey) throws Exception {
        PSSubSysSADE pssubsyssade = (PSSubSysSADE)PSModelServiceUtil.getInstance().getPSSubSysSADEService().get(strParentKey);
        List<PSSubSysSADetail> list = this.listByPSSubSysSADE(pssubsyssade);
        if (list != null) {
            ArrayList<PSSubSysSADetailDTO> dtoList = new ArrayList<PSSubSysSADetailDTO>();
            for (PSSubSysSADetail item : list) {
                PSSubSysSADetailDTO dto = (PSSubSysSADetailDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSubSysSADetail> listByPSSubSysServiceAPI(PSSubSysServiceAPI parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSubSysSADetail get(PSSubSysServiceAPI parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSubSysSADetail> list = this.listByPSSubSysServiceAPI(parent);
        if (list != null) {
            for (PSSubSysSADetail item : list) {
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
    public List<PSSubSysSADetailDTO> listDTOByPSSubSysServiceAPI(String strParentKey) throws Exception {
        PSSubSysServiceAPI pssubsysserviceapi = (PSSubSysServiceAPI)PSModelServiceUtil.getInstance().getPSSubSysServiceAPIService().get(strParentKey);
        List<PSSubSysSADetail> list = this.listByPSSubSysServiceAPI(pssubsysserviceapi);
        if (list != null) {
            ArrayList<PSSubSysSADetailDTO> dtoList = new ArrayList<PSSubSysSADetailDTO>();
            for (PSSubSysSADetail item : list) {
                PSSubSysSADetailDTO dto = (PSSubSysSADetailDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSubSysSADetail> onListAll() throws Exception {
        List<PSSubSysServiceAPI> pssubsysserviceapis;
        ArrayList<PSSubSysSADetail> list = new ArrayList<PSSubSysSADetail>();
        List<PSSubSysSADE> pssubsyssades = PSModelServiceUtil.getInstance().getPSSubSysSADEService().listAll();
        if (pssubsyssades != null) {
            for (PSSubSysSADE parent : pssubsyssades) {
                List<PSSubSysSADetail> items = this.listByPSSubSysSADE(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssubsysserviceapis = PSModelServiceUtil.getInstance().getPSSubSysServiceAPIService().listAll()) != null) {
            for (PSSubSysServiceAPI parent : pssubsysserviceapis) {
                List<PSSubSysSADetail> items = this.listByPSSubSysServiceAPI(parent);
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
    protected PSSubSysSADetail onGet(String strParentKey, String strCurKey) throws Exception {
        PSSubSysSADetail item;
        PSSubSysSADetail item2;
        PSSubSysSADE pssubsyssade = (PSSubSysSADE)PSModelServiceUtil.getInstance().getPSSubSysSADEService().get(strParentKey, true);
        if (pssubsyssade != null && (item2 = this.get(pssubsyssade, strCurKey, true)) != null) {
            return item2;
        }
        PSSubSysServiceAPI pssubsysserviceapi = (PSSubSysServiceAPI)PSModelServiceUtil.getInstance().getPSSubSysServiceAPIService().get(strParentKey, true);
        if (pssubsysserviceapi != null && (item = this.get(pssubsysserviceapi, strCurKey, true)) != null) {
            return item;
        }
        return (PSSubSysSADetail)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSubSysSADetailDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSubSysSADEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSubSysSADEService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSSubSysServiceAPIId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSubSysServiceAPIService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSubSysSADetail et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSubSysSADetailDTO dto, PSSubSysSADetail t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSubSysSADetailId(t.getId().replace("/", "."));
        }
        if (t.getAfterCode() != null || !bIgnoreNull) {
            dto.setAfterCode(t.getAfterCode());
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
        if (t.getDetailId() != null || !bIgnoreNull) {
            dto.setDetailId(t.getDetailId());
        }
        if (t.getDetailParam() != null || !bIgnoreNull) {
            dto.setDetailParam(t.getDetailParam());
        }
        if (t.getDetailParam2() != null || !bIgnoreNull) {
            dto.setDetailParam2(t.getDetailParam2());
        }
        if (t.getDetailParams() != null || !bIgnoreNull) {
            dto.setDetailParams(t.getDetailParams());
        }
        if (t.getDetailTag() != null || !bIgnoreNull) {
            dto.setDetailTag(t.getDetailTag());
        }
        if (t.getDetailTag2() != null || !bIgnoreNull) {
            dto.setDetailTag2(t.getDetailTag2());
        }
        if (t.getDetailType() != null || !bIgnoreNull) {
            dto.setDetailType(t.getDetailType());
        }
        if (t.getInPSSubSysSADEId() != null || !bIgnoreNull) {
            dto.setInPSSubSysSADEId(t.getInPSSubSysSADEId());
        }
        if (t.getInPSSubSysSADEName() != null || !bIgnoreNull) {
            dto.setInPSSubSysSADEName(t.getInPSSubSysSADEName());
        }
        if (t.getInPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setInPSSysDynaModelId(t.getInPSSysDynaModelId());
        }
        if (t.getInPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setInPSSysDynaModelName(t.getInPSSysDynaModelName());
        }
        if (t.getKeyFieldName() != null || !bIgnoreNull) {
            dto.setKeyFieldName(t.getKeyFieldName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMethodCode() != null || !bIgnoreNull) {
            dto.setMethodCode(t.getMethodCode());
        }
        if (t.getNeedResourceKey() != null || !bIgnoreNull) {
            dto.setNeedResourceKey(t.getNeedResourceKey());
        }
        if (t.getNoServiceCodeName() != null || !bIgnoreNull) {
            dto.setNoServiceCodeName(t.getNoServiceCodeName());
        }
        if (t.getOutPSSubSysSADEId() != null || !bIgnoreNull) {
            dto.setOutPSSubSysSADEId(t.getOutPSSubSysSADEId());
        }
        if (t.getOutPSSubSysSADEName() != null || !bIgnoreNull) {
            dto.setOutPSSubSysSADEName(t.getOutPSSubSysSADEName());
        }
        if (t.getOutPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setOutPSSysDynaModelId(t.getOutPSSysDynaModelId());
        }
        if (t.getOutPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setOutPSSysDynaModelName(t.getOutPSSysDynaModelName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDELogicName() != null || !bIgnoreNull) {
            dto.setPSDELogicName(t.getPSDELogicName());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSSubSysSADEId() != null || !bIgnoreNull) {
            dto.setPSSubSysSADEId(t.getPSSubSysSADEId());
        }
        if (t.getPSSubSysSADEName() != null || !bIgnoreNull) {
            dto.setPSSubSysSADEName(t.getPSSubSysSADEName());
        }
        if (t.getPSSubSysSADetailName() != null || !bIgnoreNull) {
            dto.setPSSubSysSADetailName(t.getPSSubSysSADetailName());
        }
        if (t.getPSSubSysServiceAPIId() != null || !bIgnoreNull) {
            dto.setPSSubSysServiceAPIId(t.getPSSubSysServiceAPIId());
        }
        if (t.getPSSubSysServiceAPIName() != null || !bIgnoreNull) {
            dto.setPSSubSysServiceAPIName(t.getPSSubSysServiceAPIName());
        }
        if (t.getPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginId(t.getPSSysSFPluginId());
        }
        if (t.getPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginName(t.getPSSysSFPluginName());
        }
        if (t.getRequestContentType() != null || !bIgnoreNull) {
            dto.setRequestContentType(t.getRequestContentType());
        }
        if (t.getRequestMethod() != null || !bIgnoreNull) {
            dto.setRequestMethod(t.getRequestMethod());
        }
        if (t.getRequestParamType() != null || !bIgnoreNull) {
            dto.setRequestParamType(t.getRequestParamType());
        }
        if (t.getRetPSSubSysSADEId() != null || !bIgnoreNull) {
            dto.setRetPSSubSysSADEId(t.getRetPSSubSysSADEId());
        }
        if (t.getRetPSSubSysSADEName() != null || !bIgnoreNull) {
            dto.setRetPSSubSysSADEName(t.getRetPSSubSysSADEName());
        }
        if (t.getRetStdDataType() != null || !bIgnoreNull) {
            dto.setRetStdDataType(t.getRetStdDataType());
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
        if (StringUtils.hasLength((String)dto.getInPSSubSysSADEId())) {
            dto.setInPSSubSysSADEId(this.getRealPSModelId(t, dto.getInPSSubSysSADEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getInPSSysDynaModelId())) {
            dto.setInPSSysDynaModelId(this.getRealPSModelId(t, dto.getInPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOutPSSubSysSADEId())) {
            dto.setOutPSSubSysSADEId(this.getRealPSModelId(t, dto.getOutPSSubSysSADEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOutPSSysDynaModelId())) {
            dto.setOutPSSysDynaModelId(this.getRealPSModelId(t, dto.getOutPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysSADEId())) {
            dto.setPSSubSysSADEId(this.getRealPSModelId(t, dto.getPSSubSysSADEId()).replace("/", "."));
        }
        if ("PSSUBSYSSADE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSubSysSADEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysServiceAPIId())) {
            dto.setPSSubSysServiceAPIId(this.getRealPSModelId(t, dto.getPSSubSysServiceAPIId()).replace("/", "."));
        }
        if ("PSSUBSYSSERVICEAPI".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSubSysServiceAPIId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRetPSSubSysSADEId())) {
            dto.setRetPSSubSysSADEId(this.getRealPSModelId(t, dto.getRetPSSubSysSADEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getInPSSubSysSADEId())) {
            linkDTO = (PSSubSysSADEDTO)PSModelServiceUtil.getInstance().getPSSubSysSADEService().getDTO(dto.getInPSSubSysSADEId());
            dto.setInPSSubSysSADEName(((PSSubSysSADEDTO)linkDTO).getPSSubSysSADEName());
        } else {
            dto.setInPSSubSysSADEName(null);
        }
        if (StringUtils.hasLength((String)dto.getInPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getInPSSysDynaModelId());
            dto.setInPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setInPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getOutPSSubSysSADEId())) {
            linkDTO = (PSSubSysSADEDTO)PSModelServiceUtil.getInstance().getPSSubSysSADEService().getDTO(dto.getOutPSSubSysSADEId());
            dto.setOutPSSubSysSADEName(((PSSubSysSADEDTO)linkDTO).getPSSubSysSADEName());
        } else {
            dto.setOutPSSubSysSADEName(null);
        }
        if (StringUtils.hasLength((String)dto.getOutPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getOutPSSysDynaModelId());
            dto.setOutPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setOutPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysSADEId())) {
            linkDTO = (PSSubSysSADEDTO)PSModelServiceUtil.getInstance().getPSSubSysSADEService().getDTO(dto.getPSSubSysSADEId());
            dto.setPSSubSysSADEName(((PSSubSysSADEDTO)linkDTO).getPSSubSysSADEName());
        } else {
            dto.setPSSubSysSADEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysServiceAPIId())) {
            linkDTO = (PSSubSysServiceAPIDTO)PSModelServiceUtil.getInstance().getPSSubSysServiceAPIService().getDTO(dto.getPSSubSysServiceAPIId());
            dto.setPSSubSysServiceAPIName(((PSSubSysServiceAPIDTO)linkDTO).getPSSubSysServiceAPIName());
        } else {
            dto.setPSSubSysServiceAPIName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getPSSysSFPluginId());
            dto.setPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setPSSysSFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getRetPSSubSysSADEId())) {
            linkDTO = (PSSubSysSADEDTO)PSModelServiceUtil.getInstance().getPSSubSysSADEService().getDTO(dto.getRetPSSubSysSADEId());
            dto.setRetPSSubSysSADEName(((PSSubSysSADEDTO)linkDTO).getPSSubSysSADEName());
        } else {
            dto.setRetPSSubSysSADEName(null);
        }
        List<PSSubSysSADetailParam> list = PSModelServiceUtil.getInstance().getPSSubSysSADetailParamService().listByPSSubSysSADetail(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSSubSysSADetailParamDTO> pssubsyssadetailparams = new ArrayList<PSSubSysSADetailParamDTO>();
            for (PSSubSysSADetailParam item : list) {
                PSSubSysSADetailParamDTO dstItem = (PSSubSysSADetailParamDTO)PSModelServiceUtil.getInstance().getPSSubSysSADetailParamService().toDTO(item);
                pssubsyssadetailparams.add(dstItem);
            }
            dto.setPssubsyssadetailparams(pssubsyssadetailparams);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSUBSYSSADETAIL";
    }

    @Override
    public PSSubSysSADetail createDomain() {
        return new PSSubSysSADetail();
    }

    @Override
    public PSSubSysSADetailDTO createDTO() {
        return new PSSubSysSADetailDTO();
    }
}

