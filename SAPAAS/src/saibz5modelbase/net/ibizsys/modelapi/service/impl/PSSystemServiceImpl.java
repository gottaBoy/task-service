/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.impl;

import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSLanguageDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSystemService;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSystemServiceImpl
extends PSModelServiceImplBase<PSSystem, PSSystemDTO>
implements IPSSystemService {
    private static final Log log = LogFactory.getLog(PSSystemServiceImpl.class);

    @Override
    public String getModelTag(PSSystem et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSystemDTO dto, PSSystem t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSystemId(t.getId().replace("/", "."));
        }
        if (t.getAccCtrlArch() != null || !bIgnoreNull) {
            dto.setAccCtrlArch(t.getAccCtrlArch());
        }
        if (t.getAutoCalcDERER() != null || !bIgnoreNull) {
            dto.setAutoCalcDERER(t.getAutoCalcDERER());
        }
        if (t.getBugFixs() != null || !bIgnoreNull) {
            dto.setBugFixs(t.getBugFixs());
        }
        if (t.getCheckModelVer() != null || !bIgnoreNull) {
            dto.setCheckModelVer(t.getCheckModelVer());
        }
        if (t.getCLEmptyText() != null || !bIgnoreNull) {
            dto.setCLEmptyText(t.getCLEmptyText());
        }
        if (t.getCLEmptyTextPSLanResId() != null || !bIgnoreNull) {
            dto.setCLEmptyTextPSLanResId(t.getCLEmptyTextPSLanResId());
        }
        if (t.getCLEmptyTextPSLanResName() != null || !bIgnoreNull) {
            dto.setCLEmptyTextPSLanResName(t.getCLEmptyTextPSLanResName());
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
        if (t.getCtrlAppendDEItems() != null || !bIgnoreNull) {
            dto.setCtrlAppendDEItems(t.getCtrlAppendDEItems());
        }
        if (t.getDBTypes() != null || !bIgnoreNull) {
            dto.setDBTypes(t.getDBTypes());
        }
        if (t.getDEExpMaxRowCnt() != null || !bIgnoreNull) {
            dto.setDEExpMaxRowCnt(t.getDEExpMaxRowCnt());
        }
        if (t.getDEFPSSysDeployId() != null || !bIgnoreNull) {
            dto.setDEFPSSysDeployId(t.getDEFPSSysDeployId());
        }
        if (t.getDEFSFItemWidth() != null || !bIgnoreNull) {
            dto.setDEFSFItemWidth(t.getDEFSFItemWidth());
        }
        if (t.getDEFSortMode() != null || !bIgnoreNull) {
            dto.setDEFSortMode(t.getDEFSortMode());
        }
        if (t.getDEMSActionLogicFlag() != null || !bIgnoreNull) {
            dto.setDEMSActionLogicFlag(t.getDEMSActionLogicFlag());
        }
        if (t.getDomainName() != null || !bIgnoreNull) {
            dto.setDomainName(t.getDomainName());
        }
        if (t.getDTOFormat() != null || !bIgnoreNull) {
            dto.setDTOFormat(t.getDTOFormat());
        }
        if (t.getEnableDBValueMode() != null || !bIgnoreNull) {
            dto.setEnableDBValueMode(t.getEnableDBValueMode());
        }
        if (t.getEnableDEDataVer() != null || !bIgnoreNull) {
            dto.setEnableDEDataVer(t.getEnableDEDataVer());
        }
        if (t.getEnableDEFRestrictedUI() != null || !bIgnoreNull) {
            dto.setEnableDEFRestrictedUI(t.getEnableDEFRestrictedUI());
        }
        if (t.getEnableDERFKey() != null || !bIgnoreNull) {
            dto.setEnableDERFKey(t.getEnableDERFKey());
        }
        if (t.getEnableDynaSys() != null || !bIgnoreNull) {
            dto.setEnableDynaSys(t.getEnableDynaSys());
        }
        if (t.getEnableMultiLan() != null || !bIgnoreNull) {
            dto.setEnableMultiLan(t.getEnableMultiLan());
        }
        if (t.getEnableOPNameModel() != null || !bIgnoreNull) {
            dto.setEnableOPNameModel(t.getEnableOPNameModel());
        }
        if (t.getEnaDefLanResContent() != null || !bIgnoreNull) {
            dto.setEnaDefLanResContent(t.getEnaDefLanResContent());
        }
        if (t.getExtractDefault() != null || !bIgnoreNull) {
            dto.setExtractDefault(t.getExtractDefault());
        }
        if (t.getInitDEDefault() != null || !bIgnoreNull) {
            dto.setInitDEDefault(t.getInitDEDefault());
        }
        if (t.getLanResMaxTag() != null || !bIgnoreNull) {
            dto.setLanResMaxTag(t.getLanResMaxTag());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getModelV2ExpMode() != null || !bIgnoreNull) {
            dto.setModelV2ExpMode(t.getModelV2ExpMode());
        }
        if (t.getNoViewMode() != null || !bIgnoreNull) {
            dto.setNoViewMode(t.getNoViewMode());
        }
        if (t.getPIAutoShowCaption() != null || !bIgnoreNull) {
            dto.setPIAutoShowCaption(t.getPIAutoShowCaption());
        }
        if (t.getPSLanguageId() != null || !bIgnoreNull) {
            dto.setPSLanguageId(t.getPSLanguageId());
        }
        if (t.getPSLanguageName() != null || !bIgnoreNull) {
            dto.setPSLanguageName(t.getPSLanguageName());
        }
        if (t.getPSSFId() != null || !bIgnoreNull) {
            dto.setPSSFId(t.getPSSFId());
        }
        if (t.getPSSFName() != null || !bIgnoreNull) {
            dto.setPSSFName(t.getPSSFName());
        }
        if (t.getPSSysEngineCfgId() != null || !bIgnoreNull) {
            dto.setPSSysEngineCfgId(t.getPSSysEngineCfgId());
        }
        if (t.getPSSysEngineCfgName() != null || !bIgnoreNull) {
            dto.setPSSysEngineCfgName(t.getPSSysEngineCfgName());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getPubDBModelFlag() != null || !bIgnoreNull) {
            dto.setPubDBModelFlag(t.getPubDBModelFlag());
        }
        if (t.getSaaSMode() != null || !bIgnoreNull) {
            dto.setSaaSMode(t.getSaaSMode());
        }
        if (t.getServiceAPIFlag() != null || !bIgnoreNull) {
            dto.setServiceAPIFlag(t.getServiceAPIFlag());
        }
        if (t.getSimActionLogics() != null || !bIgnoreNull) {
            dto.setSimActionLogics(t.getSimActionLogics());
        }
        if (t.getSrcPSSystemId() != null || !bIgnoreNull) {
            dto.setSrcPSSystemId(t.getSrcPSSystemId());
        }
        if (t.getSrcPSSystemName() != null || !bIgnoreNull) {
            dto.setSrcPSSystemName(t.getSrcPSSystemName());
        }
        if (t.getSSDEMSActionLogicFlag() != null || !bIgnoreNull) {
            dto.setSSDEMSActionLogicFlag(t.getSSDEMSActionLogicFlag());
        }
        if (t.getSysFolder() != null || !bIgnoreNull) {
            dto.setSysFolder(t.getSysFolder());
        }
        if (t.getSysRowKey() != null || !bIgnoreNull) {
            dto.setSysRowKey(t.getSysRowKey());
        }
        if (t.getSysType() != null || !bIgnoreNull) {
            dto.setSysType(t.getSysType());
        }
        if (t.getSysVer() != null || !bIgnoreNull) {
            dto.setSysVer(t.getSysVer());
        }
        if (t.getTemplEngine() != null || !bIgnoreNull) {
            dto.setTemplEngine(t.getTemplEngine());
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
        if (t.getViewUARegMode() != null || !bIgnoreNull) {
            dto.setViewUARegMode(t.getViewUARegMode());
        }
        if (StringUtils.hasLength((String)dto.getCLEmptyTextPSLanResId())) {
            dto.setCLEmptyTextPSLanResId(this.getRealPSModelId(t, dto.getCLEmptyTextPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSLanguageId())) {
            dto.setPSLanguageId(this.getRealPSModelId(t, dto.getPSLanguageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getSrcPSSystemId())) {
            dto.setSrcPSSystemId(this.getRealPSModelId(t, dto.getSrcPSSystemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCLEmptyTextPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getCLEmptyTextPSLanResId());
            dto.setCLEmptyTextPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setCLEmptyTextPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSLanguageId())) {
            linkDTO = (PSLanguageDTO)PSModelServiceUtil.getInstance().getPSLanguageService().getDTO(dto.getPSLanguageId());
            dto.setPSLanguageName(((PSLanguageDTO)linkDTO).getPSLanguageName());
        } else {
            dto.setPSLanguageName(null);
        }
        if (StringUtils.hasLength((String)dto.getSrcPSSystemId())) {
            linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getSrcPSSystemId(), true);
            if (linkDTO != null) {
                dto.setSrcPSSystemName(((PSSystemDTO)linkDTO).getPSSystemName());
            }
        } else {
            dto.setSrcPSSystemName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSTEM";
    }

    @Override
    public PSSystem createDomain() {
        return new PSSystem();
    }

    @Override
    public PSSystemDTO createDTO() {
        return new PSSystemDTO();
    }
}

