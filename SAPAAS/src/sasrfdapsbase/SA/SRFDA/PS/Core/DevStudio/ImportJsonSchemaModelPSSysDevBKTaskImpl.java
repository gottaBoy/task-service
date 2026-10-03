/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.core.type.TypeReference
 *  com.fasterxml.jackson.databind.DeserializationFeature
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.codelist.DEFieldTypeCodeListModel
 *  net.ibizsys.pscore.srv.core.IPSDEFieldModel
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEField
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSModule
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel
 *  net.ibizsys.pscore.srv.sysdesign.service.PSModuleService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  net.ibizsys.pscore.srv.util.jsonschema.media.ObjectSchema
 *  net.ibizsys.pscore.srv.util.jsonschema.media.Schema
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.ImportSysDynaModelPSSysDevBKTaskImplBase;
import SA.SRFramework.Utility.StringHelper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.codelist.DEFieldTypeCodeListModel;
import net.ibizsys.pscore.srv.core.IPSDEFieldModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import net.ibizsys.pscore.srv.util.jsonschema.media.ObjectSchema;
import net.ibizsys.pscore.srv.util.jsonschema.media.Schema;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class ImportJsonSchemaModelPSSysDevBKTaskImpl
extends ImportSysDynaModelPSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(ImportJsonSchemaModelPSSysDevBKTaskImpl.class);
    public static final TypeReference<Map<String, ObjectSchema>> JsonSchemaMapType = new TypeReference<Map<String, ObjectSchema>>(){};

    @Override
    protected String onImportPSSysDynaModel(PSSysDynaModel psSysDynaModel) throws Exception {
        String strDynaModel = psSysDynaModel.getDynaModel();
        if (StringHelper.IsNullOrEmpty((String)strDynaModel)) {
            throw new Exception("\u672a\u4f20\u5165\u6a21\u578b");
        }
        PSModule psModule = psSysDynaModel.getPSModule();
        if (psModule == null) {
            SelectCond selectCond = new SelectCond();
            selectCond.setIsNull("PSSYSMODELGROUPID");
            selectCond.set("DEFAULTFLAG", (Object)1);
            PSModuleService psModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
            ArrayList psModuleList = psModuleService.select((ISelectCond)selectCond);
            if (psModuleList != null && psModuleList.size() > 0) {
                psModule = (PSModule)psModuleList.get(0);
            }
            if (psModule == null) {
                throw new Exception("\u672a\u914d\u7f6e\u9ed8\u8ba4\u7cfb\u7edf\u6a21\u5757");
            }
        }
        ObjectMapper MAPPER = new ObjectMapper();
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Map<String, ObjectSchema> map = MAPPER.readValue(strDynaModel, JsonSchemaMapType);
        StringBuilder sb = new StringBuilder();
        PSSysModelInstGlobal.active((String)this.getPSSysModelInstId());
        for (Map.Entry entry : map.entrySet()) {
            sb.append(String.format("\u5f00\u59cb\u5bfc\u5165JsonSchema\u5bf9\u8c61[%1$s]\r\n", entry.getKey()));
            String strInfo = this.importJsonSchema((String)entry.getKey(), (ObjectSchema)entry.getValue(), psModule);
            if (StringHelper.IsNullOrEmpty((String)strInfo)) continue;
            sb.append(strInfo);
        }
        return sb.toString();
    }

    protected String importJsonSchema(String strName, ObjectSchema objectSchema, PSModule psModule) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)strName)) {
            throw new Exception("\u4f20\u5165\u5b9e\u4f53\u6807\u8bc6\u65e0\u6548");
        }
        strName = strName.toUpperCase();
        StringBuilder sb = new StringBuilder();
        SelectCond selectCond = new SelectCond();
        selectCond.setIsNull("PSSYSMODELGROUPID");
        selectCond.set("PSDATAENTITYNAME", (Object)strName);
        PSDataEntity psDataEntity = null;
        PSDataEntityService psDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSDEFieldService psDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        ArrayList psDataEntityList = psDataEntityService.select((ISelectCond)selectCond);
        if (psDataEntityList != null && psDataEntityList.size() > 0) {
            psDataEntity = (PSDataEntity)psDataEntityList.get(0);
        }
        ArrayList<PSDEField> psDEFieldList = null;
        if (psDataEntity == null) {
            sb.append(String.format("\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\uff0c\u6267\u884c\u65b0\u5efa\u64cd\u4f5c\r\n", strName));
            psDataEntity = new PSDataEntity();
            psDataEntity.setLogicName(strName);
            if (!StringHelper.IsNullOrEmpty((String)objectSchema.getTitle())) {
                psDataEntity.setLogicName(objectSchema.getTitle());
            }
            if (!StringHelper.IsNullOrEmpty((String)objectSchema.getDescription())) {
                psDataEntity.setMemo(objectSchema.getDescription());
            }
            if (objectSchema.getExtensions() != null) {
                this.fillExtensions((IEntity)psDataEntity, objectSchema.getExtensions(), (IDataEntityModel)psDataEntityService.getDEModel());
            }
            psDataEntity.setExistingModel(Integer.valueOf(1));
            psDataEntity.setPSSystemId(psModule.getPSSystemId());
            psDataEntity.setPSModuleId(psModule.getPSModuleId());
            psDataEntity.setPSModuleName(psModule.getPSModuleName());
            psDataEntity.setPSDataEntityName(strName);
            psDataEntityService.create(psDataEntity);
            psDEFieldList = new ArrayList<PSDEField>();
        } else {
            sb.append(String.format("\u5b9e\u4f53[%1$s]\u5df2\u5b58\u5728\uff0c\u6267\u884c\u66f4\u65b0\u64cd\u4f5c\r\n", strName));
            psDEFieldList = psDataEntity.getPSDEFields();
        }
        LinkedHashMap<String, PSDEField> psDEFieldMap = new LinkedHashMap<String, PSDEField>();
        for (PSDEField psDEField : psDEFieldList) {
            psDEFieldMap.put(psDEField.getPSDEFieldName(), psDEField);
        }
        Map<String, Schema> propertits = objectSchema.getProperties();
        if (propertits != null) {
            for (Map.Entry entry : propertits.entrySet()) {
                Map fieldExtensions;
                String strInfo;
                String strFieldName = (String)entry.getKey();
                if (StringHelper.IsNullOrEmpty((String)strFieldName)) continue;
                if (psDEFieldMap.containsKey(strFieldName = strFieldName.toUpperCase())) {
                    sb.append(String.format("\u5c5e\u6027[%1$s]\u5df2\u5b58\u5728\r\n", strFieldName));
                    continue;
                }
                sb.append(String.format("\u5c5e\u6027[%1$s]\u4e0d\u5b58\u5728\uff0c\u6267\u884c\u65b0\u5efa\u64cd\u4f5c\r\n", strFieldName));
                PSDEField psDEField = new PSDEField();
                psDEField.setPSDEFieldName(strFieldName);
                psDEField.setDEFType(DEFieldTypeCodeListModel.PHISICAL);
                psDEField.setLogicName(strFieldName);
                psDEField.setCodeName((String)entry.getKey());
                if (!StringHelper.IsNullOrEmpty((String)((Schema)entry.getValue()).getTitle())) {
                    psDEField.setLogicName(((Schema)entry.getValue()).getTitle());
                }
                if (!StringHelper.IsNullOrEmpty((String)((Schema)entry.getValue()).getDescription())) {
                    psDEField.setMemo(((Schema)entry.getValue()).getDescription());
                }
                if (!StringHelper.IsNullOrEmpty((String)(strInfo = this.fillPSDEFieldDataType(psDEField, (Schema)entry.getValue())))) {
                    sb.append(String.format("%1$s\r\n", strInfo));
                }
                if ((fieldExtensions = ((Schema)entry.getValue()).getExtensions()) != null) {
                    this.fillExtensions((IEntity)psDEField, fieldExtensions, (IDataEntityModel)psDEFieldService.getDEModel());
                }
                if (StringHelper.IsNullOrEmpty((String)psDEField.getPSDataTypeId())) {
                    sb.append(String.format("\u5c5e\u6027\u672a\u63d0\u4f9b\u6570\u636e\u7c7b\u578b\uff0c\u5ffd\u7565\u5efa\u7acb\r\n", new Object[0]));
                    continue;
                }
                psDEField.setPSDEFieldName(strFieldName);
                psDEField.setPSDEId(psDataEntity.getPSDataEntityId());
                psDEFieldService.create(psDEField);
            }
        }
        return sb.toString();
    }

    protected String fillPSDEFieldDataType(PSDEField psDEField, Schema schema) throws Exception {
        if ("string".equals(schema.getType())) {
            psDEField.setPSDataTypeId("TEXT");
            if (schema.getMaxLength() != null && schema.getMaxLength() > 0) {
                psDEField.setLength(schema.getMaxLength());
            }
            if (schema.getMinLength() != null && schema.getMinLength() > 0) {
                psDEField.setMinStrLength(schema.getMinLength());
            }
            return null;
        }
        if ("integer".equals(schema.getType())) {
            psDEField.setPSDataTypeId("INT");
            return null;
        }
        if ("number".equals(schema.getType())) {
            psDEField.setPSDataTypeId("DECIMAL");
            return null;
        }
        return String.format("\u672a\u652f\u6301\u7684\u7c7b\u578b[%1$s]", schema.getType());
    }

    protected void fillExtensions(IEntity iEntity, Map<String, Object> map, IDataEntityModel iDEModel) throws Exception {
        Iterator deFields = iDEModel.getDEFields();
        if (deFields != null) {
            while (deFields.hasNext()) {
                IPSDEFieldModel iPSDEFieldModel = (IPSDEFieldModel)deFields.next();
                String strServiceCodeName = iPSDEFieldModel.getServiceCodeName();
                if (map.containsKey(strServiceCodeName.toLowerCase())) {
                    iEntity.set(iPSDEFieldModel.getName(), map.get(strServiceCodeName.toLowerCase()));
                    continue;
                }
                if (map.containsKey(iPSDEFieldModel.getCodeName().toLowerCase())) {
                    iEntity.set(iPSDEFieldModel.getName(), map.get(iPSDEFieldModel.getCodeName().toLowerCase()));
                    continue;
                }
                if (!map.containsKey(iPSDEFieldModel.getName().toLowerCase())) continue;
                iEntity.set(iPSDEFieldModel.getName(), map.get(iPSDEFieldModel.getName().toLowerCase()));
            }
        }
    }
}
