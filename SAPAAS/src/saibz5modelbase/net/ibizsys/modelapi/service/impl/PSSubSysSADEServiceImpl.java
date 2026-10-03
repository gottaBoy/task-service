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
import net.ibizsys.modelapi.domain.PSSubSysServiceAPI;
import net.ibizsys.modelapi.dto.PSSubSysSADEDTO;
import net.ibizsys.modelapi.dto.PSSubSysServiceAPIDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.service.IPSSubSysSADEService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSubSysSADEServiceImpl
extends PSModelServiceImplBase<PSSubSysSADE, PSSubSysSADEDTO>
implements IPSSubSysSADEService {
    private static final Log log = LogFactory.getLog(PSSubSysSADEServiceImpl.class);

    @Override
    public List<PSSubSysSADE> listByPSSubSysServiceAPI(PSSubSysServiceAPI parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSubSysSADE get(PSSubSysServiceAPI parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSubSysSADE> list = this.listByPSSubSysServiceAPI(parent);
        if (list != null) {
            for (PSSubSysSADE item : list) {
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
    public List<PSSubSysSADEDTO> listDTOByPSSubSysServiceAPI(String strParentKey) throws Exception {
        PSSubSysServiceAPI pssubsysserviceapi = (PSSubSysServiceAPI)PSModelServiceUtil.getInstance().getPSSubSysServiceAPIService().get(strParentKey);
        List<PSSubSysSADE> list = this.listByPSSubSysServiceAPI(pssubsysserviceapi);
        if (list != null) {
            ArrayList<PSSubSysSADEDTO> dtoList = new ArrayList<PSSubSysSADEDTO>();
            for (PSSubSysSADE item : list) {
                PSSubSysSADEDTO dto = (PSSubSysSADEDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSubSysSADE> onListAll() throws Exception {
        ArrayList<PSSubSysSADE> list = new ArrayList<PSSubSysSADE>();
        List<PSSubSysServiceAPI> pssubsysserviceapis = PSModelServiceUtil.getInstance().getPSSubSysServiceAPIService().listAll();
        if (pssubsysserviceapis != null) {
            for (PSSubSysServiceAPI parent : pssubsysserviceapis) {
                List<PSSubSysSADE> items = this.listByPSSubSysServiceAPI(parent);
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
    protected PSSubSysSADE onGet(String strParentKey, String strCurKey) throws Exception {
        PSSubSysSADE item;
        PSSubSysServiceAPI pssubsysserviceapi = (PSSubSysServiceAPI)PSModelServiceUtil.getInstance().getPSSubSysServiceAPIService().get(strParentKey, true);
        if (pssubsysserviceapi != null && (item = this.get(pssubsysserviceapi, strCurKey, true)) != null) {
            return item;
        }
        return (PSSubSysSADE)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSubSysSADEDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSubSysServiceAPIId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSubSysServiceAPIService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSubSysSADE et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSubSysSADEName())) {
            return et.getPSSubSysSADEName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSubSysSADEDTO dto, PSSubSysSADE t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSubSysSADEId(t.getId().replace("/", "."));
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
        if (t.getDEParams() != null || !bIgnoreNull) {
            dto.setDEParams(t.getDEParams());
        }
        if (t.getDETag() != null || !bIgnoreNull) {
            dto.setDETag(t.getDETag());
        }
        if (t.getDETag2() != null || !bIgnoreNull) {
            dto.setDETag2(t.getDETag2());
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
        if (t.getMethodCode() != null || !bIgnoreNull) {
            dto.setMethodCode(t.getMethodCode());
        }
        if (t.getPredefinedType() != null || !bIgnoreNull) {
            dto.setPredefinedType(t.getPredefinedType());
        }
        if (t.getPSSubSysSADEName() != null || !bIgnoreNull) {
            dto.setPSSubSysSADEName(t.getPSSubSysSADEName());
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
        if (t.getSyncModelMode() != null || !bIgnoreNull) {
            dto.setSyncModelMode(t.getSyncModelMode());
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
        if (StringUtils.hasLength((String)dto.getPSSubSysServiceAPIId())) {
            dto.setPSSubSysServiceAPIId(this.getRealPSModelId(t, dto.getPSSubSysServiceAPIId()).replace("/", "."));
        }
        if ("PSSUBSYSSERVICEAPI".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSubSysServiceAPIId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
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
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSUBSYSSADE";
    }

    @Override
    public PSSubSysSADE createDomain() {
        return new PSSubSysSADE();
    }

    @Override
    public PSSubSysSADEDTO createDTO() {
        return new PSSubSysSADEDTO();
    }
}

