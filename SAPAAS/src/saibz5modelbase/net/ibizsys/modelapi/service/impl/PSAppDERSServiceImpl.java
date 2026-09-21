/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.impl;

import net.ibizsys.modelapi.domain.PSAppDERS;
import net.ibizsys.modelapi.dto.PSAppDERSDTO;
import net.ibizsys.modelapi.dto.PSAppLocalDEDTO;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.service.IPSAppDERSService;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppDERSServiceImpl
extends PSModelServiceImplBase<PSAppDERS, PSAppDERSDTO>
implements IPSAppDERSService {
    private static final Log log = LogFactory.getLog(PSAppDERSServiceImpl.class);

    @Override
    public String getModelTag(PSAppDERS et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSAppDERSName())) {
            return et.getPSAppDERSName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppDERSDTO dto, PSAppDERS t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppDERSId(t.getId().replace("/", "."));
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
        if (t.getCPSAppLocalDEId() != null || !bIgnoreNull) {
            dto.setCPSAppLocalDEId(t.getCPSAppLocalDEId());
        }
        if (t.getCPSAppLocalDEName() != null || !bIgnoreNull) {
            dto.setCPSAppLocalDEName(t.getCPSAppLocalDEName());
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
        if (t.getPPSAppLocalDEId() != null || !bIgnoreNull) {
            dto.setPPSAppLocalDEId(t.getPPSAppLocalDEId());
        }
        if (t.getPPSAppLocalDEName() != null || !bIgnoreNull) {
            dto.setPPSAppLocalDEName(t.getPPSAppLocalDEName());
        }
        if (t.getPSAppDERSName() != null || !bIgnoreNull) {
            dto.setPSAppDERSName(t.getPSAppDERSName());
        }
        if (t.getPSDERId() != null || !bIgnoreNull) {
            dto.setPSDERId(t.getPSDERId());
        }
        if (t.getPSDERName() != null || !bIgnoreNull) {
            dto.setPSDERName(t.getPSDERName());
        }
        if (t.getPSSysAppId() != null || !bIgnoreNull) {
            dto.setPSSysAppId(t.getPSSysAppId());
        }
        if (t.getPSSysAppName() != null || !bIgnoreNull) {
            dto.setPSSysAppName(t.getPSSysAppName());
        }
        if (t.getRSViewMode() != null || !bIgnoreNull) {
            dto.setRSViewMode(t.getRSViewMode());
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
        if (t.getUserTag() != null || !bIgnoreNull) {
            dto.setUserTag(t.getUserTag());
        }
        if (t.getUserTag2() != null || !bIgnoreNull) {
            dto.setUserTag2(t.getUserTag2());
        }
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (StringUtils.hasLength((String)dto.getCPSAppLocalDEId())) {
            dto.setCPSAppLocalDEId(this.getRealPSModelId(t, dto.getCPSAppLocalDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSAppLocalDEId())) {
            dto.setPPSAppLocalDEId(this.getRealPSModelId(t, dto.getPPSAppLocalDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            dto.setPSDERId(this.getRealPSModelId(t, dto.getPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            dto.setPSSysAppId(this.getRealPSModelId(t, dto.getPSSysAppId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCPSAppLocalDEId())) {
            linkDTO = (PSAppLocalDEDTO)PSModelServiceUtil.getInstance().getPSAppLocalDEService().getDTO(dto.getCPSAppLocalDEId());
            dto.setCPSAppLocalDEName(((PSAppLocalDEDTO)linkDTO).getPSAppLocalDEName());
        } else {
            dto.setCPSAppLocalDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPPSAppLocalDEId())) {
            linkDTO = (PSAppLocalDEDTO)PSModelServiceUtil.getInstance().getPSAppLocalDEService().getDTO(dto.getPPSAppLocalDEId());
            dto.setPPSAppLocalDEName(((PSAppLocalDEDTO)linkDTO).getPSAppLocalDEName());
        } else {
            dto.setPPSAppLocalDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getPSDERId());
            dto.setPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            linkDTO = (PSSysAppDTO)PSModelServiceUtil.getInstance().getPSSysAppService().getDTO(dto.getPSSysAppId());
            dto.setPSSysAppName(((PSSysAppDTO)linkDTO).getPSSysAppName());
        } else {
            dto.setPSSysAppName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSAPPDERS";
    }

    @Override
    public PSAppDERS createDomain() {
        return new PSAppDERS();
    }

    @Override
    public PSAppDERSDTO createDTO() {
        return new PSAppDERSDTO();
    }
}

