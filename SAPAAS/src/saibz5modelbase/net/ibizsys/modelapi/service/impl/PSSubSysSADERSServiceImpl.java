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
import net.ibizsys.modelapi.domain.PSSubSysSADERS;
import net.ibizsys.modelapi.domain.PSSubSysServiceAPI;
import net.ibizsys.modelapi.dto.PSSubSysSADEDTO;
import net.ibizsys.modelapi.dto.PSSubSysSADERSDTO;
import net.ibizsys.modelapi.dto.PSSubSysServiceAPIDTO;
import net.ibizsys.modelapi.service.IPSSubSysSADERSService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSubSysSADERSServiceImpl
extends PSModelServiceImplBase<PSSubSysSADERS, PSSubSysSADERSDTO>
implements IPSSubSysSADERSService {
    private static final Log log = LogFactory.getLog(PSSubSysSADERSServiceImpl.class);

    @Override
    public List<PSSubSysSADERS> listByPSSubSysServiceAPI(PSSubSysServiceAPI parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSubSysSADERS get(PSSubSysServiceAPI parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSubSysSADERS> list = this.listByPSSubSysServiceAPI(parent);
        if (list != null) {
            for (PSSubSysSADERS item : list) {
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
    public List<PSSubSysSADERSDTO> listDTOByPSSubSysServiceAPI(String strParentKey) throws Exception {
        PSSubSysServiceAPI pssubsysserviceapi = (PSSubSysServiceAPI)PSModelServiceUtil.getInstance().getPSSubSysServiceAPIService().get(strParentKey);
        List<PSSubSysSADERS> list = this.listByPSSubSysServiceAPI(pssubsysserviceapi);
        if (list != null) {
            ArrayList<PSSubSysSADERSDTO> dtoList = new ArrayList<PSSubSysSADERSDTO>();
            for (PSSubSysSADERS item : list) {
                PSSubSysSADERSDTO dto = (PSSubSysSADERSDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSubSysSADERS> onListAll() throws Exception {
        ArrayList<PSSubSysSADERS> list = new ArrayList<PSSubSysSADERS>();
        List pssubsysserviceapis = PSModelServiceUtil.getInstance().getPSSubSysServiceAPIService().listAll();
        if (pssubsysserviceapis != null) {
            for (PSSubSysServiceAPI parent : pssubsysserviceapis) {
                List<PSSubSysSADERS> items = this.listByPSSubSysServiceAPI(parent);
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
    protected PSSubSysSADERS onGet(String strParentKey, String strCurKey) throws Exception {
        PSSubSysSADERS item;
        PSSubSysServiceAPI pssubsysserviceapi = (PSSubSysServiceAPI)PSModelServiceUtil.getInstance().getPSSubSysServiceAPIService().get(strParentKey, true);
        if (pssubsysserviceapi != null && (item = this.get(pssubsysserviceapi, strCurKey, true)) != null) {
            return item;
        }
        return (PSSubSysSADERS)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSubSysSADERSDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSubSysServiceAPIId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSubSysServiceAPIService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSubSysSADERS et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSubSysSADERSName())) {
            return et.getPSSubSysSADERSName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSubSysSADERSDTO dto, PSSubSysSADERS t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSubSysSADERSId(t.getId().replace("/", "."));
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
        if (t.getCPSSubSysSADEId() != null || !bIgnoreNull) {
            dto.setCPSSubSysSADEId(t.getCPSSubSysSADEId());
        }
        if (t.getCPSSubSysSADEName() != null || !bIgnoreNull) {
            dto.setCPSSubSysSADEName(t.getCPSSubSysSADEName());
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
        if (t.getPPSSubSysSADEId() != null || !bIgnoreNull) {
            dto.setPPSSubSysSADEId(t.getPPSSubSysSADEId());
        }
        if (t.getPPSSubSysSADEName() != null || !bIgnoreNull) {
            dto.setPPSSubSysSADEName(t.getPPSSubSysSADEName());
        }
        if (t.getPSSubSysSADERSName() != null || !bIgnoreNull) {
            dto.setPSSubSysSADERSName(t.getPSSubSysSADERSName());
        }
        if (t.getPSSubSysServiceAPIId() != null || !bIgnoreNull) {
            dto.setPSSubSysServiceAPIId(t.getPSSubSysServiceAPIId());
        }
        if (t.getPSSubSysServiceAPIName() != null || !bIgnoreNull) {
            dto.setPSSubSysServiceAPIName(t.getPSSubSysServiceAPIName());
        }
        if (t.getRSTag() != null || !bIgnoreNull) {
            dto.setRSTag(t.getRSTag());
        }
        if (t.getRSTag2() != null || !bIgnoreNull) {
            dto.setRSTag2(t.getRSTag2());
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
        if (StringUtils.hasLength((String)dto.getCPSSubSysSADEId())) {
            dto.setCPSSubSysSADEId(this.getRealPSModelId(t, dto.getCPSSubSysSADEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSSubSysSADEId())) {
            dto.setPPSSubSysSADEId(this.getRealPSModelId(t, dto.getPPSSubSysSADEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysServiceAPIId())) {
            dto.setPSSubSysServiceAPIId(this.getRealPSModelId(t, dto.getPSSubSysServiceAPIId()).replace("/", "."));
        }
        if ("PSSUBSYSSERVICEAPI".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSubSysServiceAPIId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCPSSubSysSADEId())) {
            linkDTO = (PSSubSysSADEDTO)PSModelServiceUtil.getInstance().getPSSubSysSADEService().getDTO(dto.getCPSSubSysSADEId());
            dto.setCPSSubSysSADEName(((PSSubSysSADEDTO)linkDTO).getPSSubSysSADEName());
        } else {
            dto.setCPSSubSysSADEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPPSSubSysSADEId())) {
            linkDTO = (PSSubSysSADEDTO)PSModelServiceUtil.getInstance().getPSSubSysSADEService().getDTO(dto.getPPSSubSysSADEId());
            dto.setPPSSubSysSADEName(((PSSubSysSADEDTO)linkDTO).getPSSubSysSADEName());
        } else {
            dto.setPPSSubSysSADEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysServiceAPIId())) {
            linkDTO = (PSSubSysServiceAPIDTO)PSModelServiceUtil.getInstance().getPSSubSysServiceAPIService().getDTO(dto.getPSSubSysServiceAPIId());
            dto.setPSSubSysServiceAPIName(((PSSubSysServiceAPIDTO)linkDTO).getPSSubSysServiceAPIName());
        } else {
            dto.setPSSubSysServiceAPIName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSUBSYSSADERS";
    }

    @Override
    public PSSubSysSADERS createDomain() {
        return new PSSubSysSADERS();
    }

    @Override
    public PSSubSysSADERSDTO createDTO() {
        return new PSSubSysSADERSDTO();
    }
}

