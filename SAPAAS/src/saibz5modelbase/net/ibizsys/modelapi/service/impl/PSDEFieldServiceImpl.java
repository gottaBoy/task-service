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
import net.ibizsys.modelapi.domain.PSDEField;
import net.ibizsys.modelapi.domain.PSDER;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSDETableDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSubSysSADEFieldDTO;
import net.ibizsys.modelapi.dto.PSSysDBColumnDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysSampleValueDTO;
import net.ibizsys.modelapi.dto.PSSysSequenceDTO;
import net.ibizsys.modelapi.dto.PSSysTranslatorDTO;
import net.ibizsys.modelapi.dto.PSSysUnitDTO;
import net.ibizsys.modelapi.dto.PSSysValueRuleDTO;
import net.ibizsys.modelapi.service.IPSDEFieldService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEFieldServiceImpl
extends PSModelServiceImplBase<PSDEField, PSDEFieldDTO>
implements IPSDEFieldService {
    private static final Log log = LogFactory.getLog(PSDEFieldServiceImpl.class);

    @Override
    public List<PSDEField> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEField get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEField> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEField item : list) {
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
    public List<PSDEFieldDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEField> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEFieldDTO> dtoList = new ArrayList<PSDEFieldDTO>();
            for (PSDEField item : list) {
                PSDEFieldDTO dto = (PSDEFieldDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEField> listByPSDER(PSDER parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEField get(PSDER parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEField> list = this.listByPSDER(parent);
        if (list != null) {
            for (PSDEField item : list) {
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
    public List<PSDEFieldDTO> listDTOByPSDER(String strParentKey) throws Exception {
        PSDER psder = (PSDER)PSModelServiceUtil.getInstance().getPSDERService().get(strParentKey);
        List<PSDEField> list = this.listByPSDER(psder);
        if (list != null) {
            ArrayList<PSDEFieldDTO> dtoList = new ArrayList<PSDEFieldDTO>();
            for (PSDEField item : list) {
                PSDEFieldDTO dto = (PSDEFieldDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEField> onListAll() throws Exception {
        ArrayList<PSDEField> list = new ArrayList<PSDEField>();
        List psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEField> items = this.listByPSDataEntity(parent);
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
    protected PSDEField onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEField item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEField)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEFieldDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSDERId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDERService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEField et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEFieldName())) {
            return et.getPSDEFieldName();
        }
        if (StringUtils.hasLength((String)et.getPSDEFieldName())) {
            return et.getPSDEFieldName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEFieldDTO dto, PSDEField t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEFieldId(t.getId().replace("/", "."));
        }
        if (t.getAllowEmpty() != null || !bIgnoreNull) {
            dto.setAllowEmpty(t.getAllowEmpty());
        }
        if (t.getAuditInfoFormat() != null || !bIgnoreNull) {
            dto.setAuditInfoFormat(t.getAuditInfoFormat());
        }
        if (t.getBizTag() != null || !bIgnoreNull) {
            dto.setBizTag(t.getBizTag());
        }
        if (t.getCheckRecursion() != null || !bIgnoreNull) {
            dto.setCheckRecursion(t.getCheckRecursion());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getComputeExp() != null || !bIgnoreNull) {
            dto.setComputeExp(t.getComputeExp());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCustomExportScope() != null || !bIgnoreNull) {
            dto.setCustomExportScope(t.getCustomExportScope());
        }
        if (t.getDBValueMode() != null || !bIgnoreNull) {
            dto.setDBValueMode(t.getDBValueMode());
        }
        if (t.getDBValueMode2() != null || !bIgnoreNull) {
            dto.setDBValueMode2(t.getDBValueMode2());
        }
        if (t.getDefaultValue() != null || !bIgnoreNull) {
            dto.setDefaultValue(t.getDefaultValue());
        }
        if (t.getDEFType() != null || !bIgnoreNull) {
            dto.setDEFType(t.getDEFType());
        }
        if (t.getDERPSDEFId() != null || !bIgnoreNull) {
            dto.setDERPSDEFId(t.getDERPSDEFId());
        }
        if (t.getDERPSDEFName() != null || !bIgnoreNull) {
            dto.setDERPSDEFName(t.getDERPSDEFName());
        }
        if (t.getDupCheckMode() != null || !bIgnoreNull) {
            dto.setDupCheckMode(t.getDupCheckMode());
        }
        if (t.getDupCheckValues() != null || !bIgnoreNull) {
            dto.setDupCheckValues(t.getDupCheckValues());
        }
        if (t.getDupCheckPSDEFId() != null || !bIgnoreNull) {
            dto.setDupCheckPSDEFId(t.getDupCheckPSDEFId());
        }
        if (t.getDupCheckPSDEFName() != null || !bIgnoreNull) {
            dto.setDupCheckPSDEFName(t.getDupCheckPSDEFName());
        }
        if (t.getDefaultValueType() != null || !bIgnoreNull) {
            dto.setDefaultValueType(t.getDefaultValueType());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getEnableAudit() != null || !bIgnoreNull) {
            dto.setEnableAudit(t.getEnableAudit());
        }
        if (t.getEnableColPriv() != null || !bIgnoreNull) {
            dto.setEnableColPriv(t.getEnableColPriv());
        }
        if (t.getEnableQS() != null || !bIgnoreNull) {
            dto.setEnableQS(t.getEnableQS());
        }
        if (t.getEnableTempData() != null || !bIgnoreNull) {
            dto.setEnableTempData(t.getEnableTempData());
        }
        if (t.getEnableUserInput() != null || !bIgnoreNull) {
            dto.setEnableUserInput(t.getEnableUserInput());
        }
        if (t.getEnaWriteBack() != null || !bIgnoreNull) {
            dto.setEnaWriteBack(t.getEnaWriteBack());
        }
        if (t.getExportScope() != null || !bIgnoreNull) {
            dto.setExportScope(t.getExportScope());
        }
        if (t.getExtendMode() != null || !bIgnoreNull) {
            dto.setExtendMode(t.getExtendMode());
        }
        if (t.getFieldHolder() != null || !bIgnoreNull) {
            dto.setFieldHolder(t.getFieldHolder());
        }
        if (t.getFieldTag() != null || !bIgnoreNull) {
            dto.setFieldTag(t.getFieldTag());
        }
        if (t.getFieldTag2() != null || !bIgnoreNull) {
            dto.setFieldTag2(t.getFieldTag2());
        }
        if (t.getFKey() != null || !bIgnoreNull) {
            dto.setFKey(t.getFKey());
        }
        if (t.getFormulaFields() != null || !bIgnoreNull) {
            dto.setFormulaFields(t.getFormulaFields());
        }
        if (t.getFormulaFormat() != null || !bIgnoreNull) {
            dto.setFormulaFormat(t.getFormulaFormat());
        }
        if (t.getImportKey() != null || !bIgnoreNull) {
            dto.setImportKey(t.getImportKey());
        }
        if (t.getImportOrder() != null || !bIgnoreNull) {
            dto.setImportOrder(t.getImportOrder());
        }
        if (t.getImportTag() != null || !bIgnoreNull) {
            dto.setImportTag(t.getImportTag());
        }
        if (t.getIndexType() != null || !bIgnoreNull) {
            dto.setIndexType(t.getIndexType());
        }
        if (t.getJSFormat() != null || !bIgnoreNull) {
            dto.setJSFormat(t.getJSFormat());
        }
        if (t.getJsonFormat() != null || !bIgnoreNull) {
            dto.setJsonFormat(t.getJsonFormat());
        }
        if (t.getLength() != null || !bIgnoreNull) {
            dto.setLength(t.getLength());
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
        if (t.getMajorField() != null || !bIgnoreNull) {
            dto.setMajorField(t.getMajorField());
        }
        if (t.getMaxValue() != null || !bIgnoreNull) {
            dto.setMaxValue(t.getMaxValue());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMinStrLength() != null || !bIgnoreNull) {
            dto.setMinStrLength(t.getMinStrLength());
        }
        if (t.getMinValue() != null || !bIgnoreNull) {
            dto.setMinValue(t.getMinValue());
        }
        if (t.getMultiFormField() != null || !bIgnoreNull) {
            dto.setMultiFormField(t.getMultiFormField());
        }
        if (t.getNo2DupChkPSDEFId() != null || !bIgnoreNull) {
            dto.setNo2DupChkPSDEFId(t.getNo2DupChkPSDEFId());
        }
        if (t.getNo2DupChkPSDEFName() != null || !bIgnoreNull) {
            dto.setNo2DupChkPSDEFName(t.getNo2DupChkPSDEFName());
        }
        if (t.getNo3DupChkPSDEFId() != null || !bIgnoreNull) {
            dto.setNo3DupChkPSDEFId(t.getNo3DupChkPSDEFId());
        }
        if (t.getNo3DupChkPSDEFName() != null || !bIgnoreNull) {
            dto.setNo3DupChkPSDEFName(t.getNo3DupChkPSDEFName());
        }
        if (t.getNullValOrder() != null || !bIgnoreNull) {
            dto.setNullValOrder(t.getNullValOrder());
        }
        if (t.getO2MPSDERId() != null || !bIgnoreNull) {
            dto.setO2MPSDERId(t.getO2MPSDERId());
        }
        if (t.getO2MPSDERName() != null || !bIgnoreNull) {
            dto.setO2MPSDERName(t.getO2MPSDERName());
        }
        if (t.getO2OPSDERId() != null || !bIgnoreNull) {
            dto.setO2OPSDERId(t.getO2OPSDERId());
        }
        if (t.getO2OPSDERName() != null || !bIgnoreNull) {
            dto.setO2OPSDERName(t.getO2OPSDERName());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPasteReset() != null || !bIgnoreNull) {
            dto.setPasteReset(t.getPasteReset());
        }
        if (t.getPhysicalField() != null || !bIgnoreNull) {
            dto.setPhysicalField(t.getPhysicalField());
        }
        if (t.getPKey() != null || !bIgnoreNull) {
            dto.setPKey(t.getPKey());
        }
        if (t.getPrecision2() != null || !bIgnoreNull) {
            dto.setPrecision2(t.getPrecision2());
        }
        if (t.getPreDefineType() != null || !bIgnoreNull) {
            dto.setPreDefineType(t.getPreDefineType());
        }
        if (t.getPSCodeListId() != null || !bIgnoreNull) {
            dto.setPSCodeListId(t.getPSCodeListId());
        }
        if (t.getPSCodeListName() != null || !bIgnoreNull) {
            dto.setPSCodeListName(t.getPSCodeListName());
        }
        if (t.getPSDataTypeId() != null || !bIgnoreNull) {
            dto.setPSDataTypeId(t.getPSDataTypeId());
        }
        if (t.getPSDataTypeName() != null || !bIgnoreNull) {
            dto.setPSDataTypeName(t.getPSDataTypeName());
        }
        if (t.getPSDEFieldName() != null || !bIgnoreNull) {
            dto.setPSDEFieldName(t.getPSDEFieldName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDERId() != null || !bIgnoreNull) {
            dto.setPSDERId(t.getPSDERId());
        }
        if (t.getPSDERName() != null || !bIgnoreNull) {
            dto.setPSDERName(t.getPSDERName());
        }
        if (t.getPSDETableId() != null || !bIgnoreNull) {
            dto.setPSDETableId(t.getPSDETableId());
        }
        if (t.getPSSubSysSADEFieldId() != null || !bIgnoreNull) {
            dto.setPSSubSysSADEFieldId(t.getPSSubSysSADEFieldId());
        }
        if (t.getPSSubSysSADEFieldName() != null || !bIgnoreNull) {
            dto.setPSSubSysSADEFieldName(t.getPSSubSysSADEFieldName());
        }
        if (t.getPSSubSysSADEId() != null || !bIgnoreNull) {
            dto.setPSSubSysSADEId(t.getPSSubSysSADEId());
        }
        if (t.getPSSysDBColumnId() != null || !bIgnoreNull) {
            dto.setPSSysDBColumnId(t.getPSSysDBColumnId());
        }
        if (t.getPSSysSampleValueId() != null || !bIgnoreNull) {
            dto.setPSSysSampleValueId(t.getPSSysSampleValueId());
        }
        if (t.getPSSysSampleValueName() != null || !bIgnoreNull) {
            dto.setPSSysSampleValueName(t.getPSSysSampleValueName());
        }
        if (t.getPSSysSequenceId() != null || !bIgnoreNull) {
            dto.setPSSysSequenceId(t.getPSSysSequenceId());
        }
        if (t.getPSSysSequenceName() != null || !bIgnoreNull) {
            dto.setPSSysSequenceName(t.getPSSysSequenceName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSysTranslatorId() != null || !bIgnoreNull) {
            dto.setPSSysTranslatorId(t.getPSSysTranslatorId());
        }
        if (t.getPSSysTranslatorName() != null || !bIgnoreNull) {
            dto.setPSSysTranslatorName(t.getPSSysTranslatorName());
        }
        if (t.getPSSysUnitId() != null || !bIgnoreNull) {
            dto.setPSSysUnitId(t.getPSSysUnitId());
        }
        if (t.getPSSysUnitName() != null || !bIgnoreNull) {
            dto.setPSSysUnitName(t.getPSSysUnitName());
        }
        if (t.getPSSysValueRuleId() != null || !bIgnoreNull) {
            dto.setPSSysValueRuleId(t.getPSSysValueRuleId());
        }
        if (t.getPSSysValueRuleName() != null || !bIgnoreNull) {
            dto.setPSSysValueRuleName(t.getPSSysValueRuleName());
        }
        if (t.getQueryColumn() != null || !bIgnoreNull) {
            dto.setQueryColumn(t.getQueryColumn());
        }
        if (t.getQueryCS() != null || !bIgnoreNull) {
            dto.setQueryCS(t.getQueryCS());
        }
        if (t.getReadOnlyMode() != null || !bIgnoreNull) {
            dto.setReadOnlyMode(t.getReadOnlyMode());
        }
        if (t.getRefPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setRefPSSysDynaModelId(t.getRefPSSysDynaModelId());
        }
        if (t.getRefPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setRefPSSysDynaModelName(t.getRefPSSysDynaModelName());
        }
        if (t.getRestrictedPSDEFId() != null || !bIgnoreNull) {
            dto.setRestrictedPSDEFId(t.getRestrictedPSDEFId());
        }
        if (t.getRestrictedPSDEFName() != null || !bIgnoreNull) {
            dto.setRestrictedPSDEFName(t.getRestrictedPSDEFName());
        }
        if (t.getSequenceMode() != null || !bIgnoreNull) {
            dto.setSequenceMode(t.getSequenceMode());
        }
        if (t.getServiceCodeName() != null || !bIgnoreNull) {
            dto.setServiceCodeName(t.getServiceCodeName());
        }
        if (t.getStateField() != null || !bIgnoreNull) {
            dto.setStateField(t.getStateField());
        }
        if (t.getStdDataType() != null || !bIgnoreNull) {
            dto.setStdDataType(t.getStdDataType());
        }
        if (t.getStringCase() != null || !bIgnoreNull) {
            dto.setStringCase(t.getStringCase());
        }
        if (t.getStrLength() != null || !bIgnoreNull) {
            dto.setStrLength(t.getStrLength());
        }
        if (t.getTableName() != null || !bIgnoreNull) {
            dto.setTableName(t.getTableName());
        }
        if (t.getTableScope() != null || !bIgnoreNull) {
            dto.setTableScope(t.getTableScope());
        }
        if (t.getTestData() != null || !bIgnoreNull) {
            dto.setTestData(t.getTestData());
        }
        if (t.getTranslatorMode() != null || !bIgnoreNull) {
            dto.setTranslatorMode(t.getTranslatorMode());
        }
        if (t.getUnicodeChar() != null || !bIgnoreNull) {
            dto.setUnicodeChar(t.getUnicodeChar());
        }
        if (t.getUnionKeyValue() != null || !bIgnoreNull) {
            dto.setUnionKeyValue(t.getUnionKeyValue());
        }
        if (t.getUnit() != null || !bIgnoreNull) {
            dto.setUnit(t.getUnit());
        }
        if (t.getUnitWidth() != null || !bIgnoreNull) {
            dto.setUnitWidth(t.getUnitWidth());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUpdateOVMode() != null || !bIgnoreNull) {
            dto.setUpdateOVMode(t.getUpdateOVMode());
        }
        if (t.getUserCat() != null || !bIgnoreNull) {
            dto.setUserCat(t.getUserCat());
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
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (t.getValueFormat() != null || !bIgnoreNull) {
            dto.setValueFormat(t.getValueFormat());
        }
        if (t.getValuePSDEFId() != null || !bIgnoreNull) {
            dto.setValuePSDEFId(t.getValuePSDEFId());
        }
        if (t.getValuePSDEFName() != null || !bIgnoreNull) {
            dto.setValuePSDEFName(t.getValuePSDEFName());
        }
        if (t.getViewColLevel() != null || !bIgnoreNull) {
            dto.setViewColLevel(t.getViewColLevel());
        }
        if (StringUtils.hasLength((String)dto.getDERPSDEFId())) {
            dto.setDERPSDEFId(this.getRealPSModelId(t, dto.getDERPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDupCheckPSDEFId())) {
            dto.setDupCheckPSDEFId(this.getRealPSModelId(t, dto.getDupCheckPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLNPSLanResId())) {
            dto.setLNPSLanResId(this.getRealPSModelId(t, dto.getLNPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNo2DupChkPSDEFId())) {
            dto.setNo2DupChkPSDEFId(this.getRealPSModelId(t, dto.getNo2DupChkPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNo3DupChkPSDEFId())) {
            dto.setNo3DupChkPSDEFId(this.getRealPSModelId(t, dto.getNo3DupChkPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getO2MPSDERId())) {
            dto.setO2MPSDERId(this.getRealPSModelId(t, dto.getO2MPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getO2OPSDERId())) {
            dto.setO2OPSDERId(this.getRealPSModelId(t, dto.getO2OPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            dto.setPSCodeListId(this.getRealPSModelId(t, dto.getPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            dto.setPSDERId(this.getRealPSModelId(t, dto.getPSDERId()).replace("/", "."));
        }
        if ("PSDER".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDERId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDETableId())) {
            dto.setPSDETableId(this.getRealPSModelId(t, dto.getPSDETableId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysSADEFieldId())) {
            dto.setPSSubSysSADEFieldId(this.getRealPSModelId(t, dto.getPSSubSysSADEFieldId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDBColumnId())) {
            dto.setPSSysDBColumnId(this.getRealPSModelId(t, dto.getPSSysDBColumnId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSampleValueId())) {
            dto.setPSSysSampleValueId(this.getRealPSModelId(t, dto.getPSSysSampleValueId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSequenceId())) {
            dto.setPSSysSequenceId(this.getRealPSModelId(t, dto.getPSSysSequenceId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysTranslatorId())) {
            dto.setPSSysTranslatorId(this.getRealPSModelId(t, dto.getPSSysTranslatorId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysUnitId())) {
            dto.setPSSysUnitId(this.getRealPSModelId(t, dto.getPSSysUnitId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysValueRuleId())) {
            dto.setPSSysValueRuleId(this.getRealPSModelId(t, dto.getPSSysValueRuleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSSysDynaModelId())) {
            dto.setRefPSSysDynaModelId(this.getRealPSModelId(t, dto.getRefPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRestrictedPSDEFId())) {
            dto.setRestrictedPSDEFId(this.getRealPSModelId(t, dto.getRestrictedPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getValuePSDEFId())) {
            dto.setValuePSDEFId(this.getRealPSModelId(t, dto.getValuePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDERPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getDERPSDEFId());
            dto.setDERPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setDERPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getDupCheckPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getDupCheckPSDEFId());
            dto.setDupCheckPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setDupCheckPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getLNPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getLNPSLanResId());
            dto.setLNPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setLNPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getNo2DupChkPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getNo2DupChkPSDEFId());
            dto.setNo2DupChkPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setNo2DupChkPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getNo3DupChkPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getNo3DupChkPSDEFId());
            dto.setNo3DupChkPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setNo3DupChkPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getO2MPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getO2MPSDERId());
            dto.setO2MPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setO2MPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getO2OPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getO2OPSDERId());
            dto.setO2OPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setO2OPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getPSCodeListId());
            dto.setPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setPSCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
            dto.setPSSubSysSADEId(((PSDataEntityDTO)linkDTO).getPSSubSysSADEId());
            dto.setPSSystemId(((PSDataEntityDTO)linkDTO).getPSSystemId());
        } else {
            dto.setPSDEName(null);
            dto.setPSSubSysSADEId(null);
            dto.setPSSystemId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getPSDERId());
            dto.setPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDETableId())) {
            linkDTO = (PSDETableDTO)PSModelServiceUtil.getInstance().getPSDETableService().getDTO(dto.getPSDETableId(), true);
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysSADEFieldId())) {
            linkDTO = (PSSubSysSADEFieldDTO)PSModelServiceUtil.getInstance().getPSSubSysSADEFieldService().getDTO(dto.getPSSubSysSADEFieldId());
            dto.setPSSubSysSADEFieldName(((PSSubSysSADEFieldDTO)linkDTO).getPSSubSysSADEFieldName());
        } else {
            dto.setPSSubSysSADEFieldName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDBColumnId())) {
            linkDTO = (PSSysDBColumnDTO)PSModelServiceUtil.getInstance().getPSSysDBColumnService().getDTO(dto.getPSSysDBColumnId(), true);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSampleValueId())) {
            linkDTO = (PSSysSampleValueDTO)PSModelServiceUtil.getInstance().getPSSysSampleValueService().getDTO(dto.getPSSysSampleValueId());
            dto.setPSSysSampleValueName(((PSSysSampleValueDTO)linkDTO).getPSSysSampleValueName());
        } else {
            dto.setPSSysSampleValueName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSequenceId())) {
            linkDTO = (PSSysSequenceDTO)PSModelServiceUtil.getInstance().getPSSysSequenceService().getDTO(dto.getPSSysSequenceId());
            dto.setPSSysSequenceName(((PSSysSequenceDTO)linkDTO).getPSSysSequenceName());
        } else {
            dto.setPSSysSequenceName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysTranslatorId())) {
            linkDTO = (PSSysTranslatorDTO)PSModelServiceUtil.getInstance().getPSSysTranslatorService().getDTO(dto.getPSSysTranslatorId());
            dto.setPSSysTranslatorName(((PSSysTranslatorDTO)linkDTO).getPSSysTranslatorName());
        } else {
            dto.setPSSysTranslatorName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysUnitId())) {
            linkDTO = (PSSysUnitDTO)PSModelServiceUtil.getInstance().getPSSysUnitService().getDTO(dto.getPSSysUnitId());
            dto.setPSSysUnitName(((PSSysUnitDTO)linkDTO).getPSSysUnitName());
        } else {
            dto.setPSSysUnitName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysValueRuleId())) {
            linkDTO = (PSSysValueRuleDTO)PSModelServiceUtil.getInstance().getPSSysValueRuleService().getDTO(dto.getPSSysValueRuleId());
            dto.setPSSysValueRuleName(((PSSysValueRuleDTO)linkDTO).getPSSysValueRuleName());
        } else {
            dto.setPSSysValueRuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getRefPSSysDynaModelId());
            dto.setRefPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setRefPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getRestrictedPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getRestrictedPSDEFId());
            dto.setRestrictedPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setRestrictedPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getValuePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getValuePSDEFId());
            dto.setValuePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setValuePSDEFName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSDEFIELD";
    }

    @Override
    public PSDEField createDomain() {
        return new PSDEField();
    }

    @Override
    public PSDEFieldDTO createDTO() {
        return new PSDEFieldDTO();
    }
}

