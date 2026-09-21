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
import net.ibizsys.modelapi.domain.PSMobAppPack;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSMobAppPackDTO;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.service.IPSMobAppPackService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSMobAppPackServiceImpl
extends PSModelServiceImplBase<PSMobAppPack, PSMobAppPackDTO>
implements IPSMobAppPackService {
    private static final Log log = LogFactory.getLog(PSMobAppPackServiceImpl.class);

    @Override
    public List<PSMobAppPack> listByPSSysApp(PSSysApp parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSMobAppPack get(PSSysApp parent, String strKey, boolean bTryMode) throws Exception {
        List<PSMobAppPack> list = this.listByPSSysApp(parent);
        if (list != null) {
            for (PSMobAppPack item : list) {
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
    public List<PSMobAppPackDTO> listDTOByPSSysApp(String strParentKey) throws Exception {
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey);
        List<PSMobAppPack> list = this.listByPSSysApp(pssysapp);
        if (list != null) {
            ArrayList<PSMobAppPackDTO> dtoList = new ArrayList<PSMobAppPackDTO>();
            for (PSMobAppPack item : list) {
                PSMobAppPackDTO dto = (PSMobAppPackDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSMobAppPack> onListAll() throws Exception {
        ArrayList<PSMobAppPack> list = new ArrayList<PSMobAppPack>();
        List pssysapps = PSModelServiceUtil.getInstance().getPSSysAppService().listAll();
        if (pssysapps != null) {
            for (PSSysApp parent : pssysapps) {
                List<PSMobAppPack> items = this.listByPSSysApp(parent);
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
    protected PSMobAppPack onGet(String strParentKey, String strCurKey) throws Exception {
        PSMobAppPack item;
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey, true);
        if (pssysapp != null && (item = this.get(pssysapp, strCurKey, true)) != null) {
            return item;
        }
        return (PSMobAppPack)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSMobAppPackDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysAppId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysAppService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSMobAppPack et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSMobAppPackName())) {
            return et.getPSMobAppPackName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSMobAppPackDTO dto, PSMobAppPack t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSMobAppPackId(t.getId().replace("/", "."));
        }
        if (t.getAndroidPermissions() != null || !bIgnoreNull) {
            dto.setAndroidPermissions(t.getAndroidPermissions());
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
        if (t.getEnableAndroid() != null || !bIgnoreNull) {
            dto.setEnableAndroid(t.getEnableAndroid());
        }
        if (t.getEnableEncryption() != null || !bIgnoreNull) {
            dto.setEnableEncryption(t.getEnableEncryption());
        }
        if (t.getEnableIOS() != null || !bIgnoreNull) {
            dto.setEnableIOS(t.getEnableIOS());
        }
        if (t.getIOSDevices() != null || !bIgnoreNull) {
            dto.setIOSDevices(t.getIOSDevices());
        }
        if (t.getIOSPrivacies() != null || !bIgnoreNull) {
            dto.setIOSPrivacies(t.getIOSPrivacies());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOSType() != null || !bIgnoreNull) {
            dto.setOSType(t.getOSType());
        }
        if (t.getOSTypes() != null || !bIgnoreNull) {
            dto.setOSTypes(t.getOSTypes());
        }
        if (t.getPackType() != null || !bIgnoreNull) {
            dto.setPackType(t.getPackType());
        }
        if (t.getPkgName() != null || !bIgnoreNull) {
            dto.setPkgName(t.getPkgName());
        }
        if (t.getPSDCMobPackCertId() != null || !bIgnoreNull) {
            dto.setPSDCMobPackCertId(t.getPSDCMobPackCertId());
        }
        if (t.getPSDCMobPackCertName() != null || !bIgnoreNull) {
            dto.setPSDCMobPackCertName(t.getPSDCMobPackCertName());
        }
        if (t.getPSMobAppPackName() != null || !bIgnoreNull) {
            dto.setPSMobAppPackName(t.getPSMobAppPackName());
        }
        if (t.getPSSysAppId() != null || !bIgnoreNull) {
            dto.setPSSysAppId(t.getPSSysAppId());
        }
        if (t.getPSSysAppName() != null || !bIgnoreNull) {
            dto.setPSSysAppName(t.getPSSysAppName());
        }
        if (t.getServiceUrl() != null || !bIgnoreNull) {
            dto.setServiceUrl(t.getServiceUrl());
        }
        if (t.getTDCnt() != null || !bIgnoreNull) {
            dto.setTDCnt(t.getTDCnt());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUserParams() != null || !bIgnoreNull) {
            dto.setUserParams(t.getUserParams());
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
        if (t.getVersion() != null || !bIgnoreNull) {
            dto.setVersion(t.getVersion());
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            dto.setPSSysAppId(this.getRealPSModelId(t, dto.getPSSysAppId()).replace("/", "."));
        }
        if ("PSSYSAPP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysAppId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            PSSysAppDTO linkDTO = (PSSysAppDTO)PSModelServiceUtil.getInstance().getPSSysAppService().getDTO(dto.getPSSysAppId());
            dto.setPSSysAppName(linkDTO.getPSSysAppName());
        } else {
            dto.setPSSysAppName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSMOBAPPPACK";
    }

    @Override
    public PSMobAppPack createDomain() {
        return new PSMobAppPack();
    }

    @Override
    public PSMobAppPackDTO createDTO() {
        return new PSMobAppPackDTO();
    }
}

