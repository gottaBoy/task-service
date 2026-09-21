/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.util.freemarker.DataContextMethod
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.freemarker.DataContextMethod;
import net.ibizsys.pscore.srv.PSCoreSysModel;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DEFDataTypeCodeListModel;
import net.ibizsys.pscore.srv.config.entity.PSDEFDataType;
import net.ibizsys.pscore.srv.config.entity.PSVarSampleValue;
import net.ibizsys.pscore.srv.config.service.PSDEFDataTypeService;
import net.ibizsys.pscore.srv.config.service.PSVarSampleValueService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTip;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMTDEF;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMTDEFBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCModelTemplBase;
import net.ibizsys.pscore.srv.service.IPSModelService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemService;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEFieldService
extends PSDEFieldServiceBase
implements IPSModelService<PSDEField> {
    private static final Log log = LogFactory.getLog(PSDEFieldService.class);
    public static final String RESERVERTAG_KEY = "R1";
    public static final String RESERVERTAG_MAJOR = "R2";
    public static final String RESERVERTAG_LOGICVALID = "R3";
    public static final String RESERVERTAG_CREATEMAN = "R4";
    public static final String RESERVERTAG_CREATEDATE = "R5";
    public static final String RESERVERTAG_UPDATEMAN = "R6";
    public static final String RESERVERTAG_UPDATEDATE = "R7";
    public static final String RESERVERTAG_CREATEMANNAME = "R8";
    public static final String RESERVERTAG_UPDATEMANNAME = "R9";
    public static final String RESERVERTAG_INDEXTYPE = "R30";
    public static final String RESERVERTAG_ORGID = "R31";

    public ArrayList<PSDEField> selectByDataEntity(String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEID", (Object)string);
        selectCond.setOrderInfo(" ORDER BY PSDEFIELDNAME ASC");
        return this.select((ISelectCond)selectCond);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void getDraft(PSDEField var1_1) throws Exception {
        block3: {
            super.getDraft(var1_1);
            if (StringHelper.isNullOrEmpty((String)var1_1.getPSDataTypeId())) {
                var2_2 = new PSDEFDataType();
                var2_2.setSessionFactory(this.getSessionFactory());
                var2_2.setPSDEFDataTypeId("TEXT");
                if (var2_2.get(true)) {
                    var1_1.setPSDataTypeId(var2_2.getPSDEFDataTypeId());
                    var1_1.setPSDataTypeName(var2_2.getPSDEFDataTypeName());
                }
            }
            if (!StringHelper.isNullOrEmpty((String)var1_1.getPSDEFieldName()) || StringHelper.isNullOrEmpty((String)var1_1.getPSDEId())) break block3;
            var2_3 = 0;
            do lbl-1000:
            // 3 sources

            {
                var3_4 = new PSDEField();
                var3_4.setPSDEId(var1_1.getPSDEId());
                var3_4.setPSDEFieldName(StringHelper.format((String)"FIELD%1$s", (Object)(++var2_3 == 1 ? "" : Integer.valueOf(var2_3))));
                if (this.select(var3_4, true)) ** GOTO lbl-1000
                var1_1.setPSDEFieldName(var3_4.getPSDEFieldName());
                var3_4.reset();
                var3_4.setPSDEId(var1_1.getPSDEId());
                var3_4.setLogicName(StringHelper.format((String)"\u5c5e\u6027%1$s", (Object)(var2_3 == 1 ? "" : Integer.valueOf(var2_3))));
            } while (this.select(var3_4, true));
            var1_1.setLogicName(var3_4.getLogicName());
        }
    }

    @Override
    protected void onBeforeCreate(PSDEField pSDEField) throws Exception {
        Object object;
        PSDCModelTemplBase pSDCModelTemplBase = null;
        Object object2 = pSDEField.getPSDE();
        boolean bl = false;
        if (DataObject.getBoolValue((Integer)((PSDataEntityBase)object2).getExistingModel(), (boolean)false)) {
            bl = true;
        }
        if (!bl && ((PSDataEntityBase)object2).getPSModule() != null && DataObject.getBoolValue((Integer)((PSDataEntityBase)object2).getPSModule().getSubSysModule(), (boolean)false)) {
            bl = true;
        }
        if (!bl && !StringHelper.isNullOrEmpty((String)((PSSystemBase)(object = ((PSDataEntityBase)object2).getPSSystem())).getPSDevSlnSysId())) {
            pSDCModelTemplBase = PSModelGlobal.getPSDCModelTempl(((PSSystemBase)object).getPSDevSlnSysId());
        }
        if (pSDCModelTemplBase != null) {
            object2 = pSDEField.getPSDEFieldName();
            if (pSDCModelTemplBase.getDEFNameMaxLength() != null && pSDCModelTemplBase.getDEFNameMaxLength() > 0 && ((String)object2).length() > pSDCModelTemplBase.getDEFNameMaxLength()) {
                throw new Exception(StringHelper.format((String)"\u6a21\u578b\u6a21\u677f[%1$s]\u5b9a\u4e49\u5c5e\u6027\u540d\u79f0\u957f\u5ea6\u4e0d\u80fd\u8d85\u8fc7[%2$s]", (Object)pSDCModelTemplBase.getPSDCModelTemplName(), (Object)pSDCModelTemplBase.getDEFNameMaxLength()));
            }
        }
        if (StringHelper.isNullOrEmpty((String)pSDEField.getCodeName())) {
            object2 = this.calcDEFieldCodeName(pSDEField.getPSDEFieldName());
            if (StringHelper.isNullOrEmpty((String)object2) && PSDEFieldService.isEnableCodeNameUpperCamel()) {
                object2 = PSDEFieldService.toUpperCamel(pSDEField.getPSDEFieldName());
            }
            if (StringHelper.isNullOrEmpty((String)object2)) {
                object2 = StringHelper.length((String)pSDEField.getPSDEFieldName()) > 1 ? pSDEField.getPSDEFieldName().substring(0, 1).toUpperCase() + pSDEField.getPSDEFieldName().substring(1).toLowerCase() : pSDEField.getPSDEFieldName().toUpperCase();
            }
            if (!StringHelper.isNullOrEmpty((String)object2)) {
                pSDEField.setCodeName((String)object2);
            }
        }
        if (pSDEField.getDEFType() != null && pSDEField.getDEFType() == 1) {
            int n = DataObject.getIntegerValue((Object)pSDEField.getPSDE().getVirtualFlag(), (Integer)0);
            if (n == 1 || n == 3 || n == 2) {
                throw new Exception(StringHelper.format((String)"\u865a\u62df\u5b9e\u4f53\u4e0d\u80fd\u5efa\u7acb\u7269\u7406\u5c5e\u6027"));
            }
            pSDEField.setTableName(pSDEField.getPSDE().getTableName());
            if (StringHelper.isNullOrEmpty((String)pSDEField.getTableName())) {
                throw new Exception(StringHelper.format((String)"\u7269\u7406\u5c5e\u6027\u8868\u540d\u65e0\u6548"));
            }
            pSDEField.setPhysicalField(1);
            PSDEFDataType pSDEFDataType = new PSDEFDataType();
            pSDEFDataType.setPSDEFDataTypeId(pSDEField.getPSDataTypeId());
            object = (PSDEFDataTypeService)ServiceGlobal.getService(PSDEFDataTypeService.class, (SessionFactory)this.getSessionFactory());
            object.get((IEntity)pSDEFDataType);
            if (pSDEFDataType.getLength() != null && pSDEField.getLength() == null) {
                pSDEField.setLength(pSDEFDataType.getLength());
            }
            if (pSDEFDataType.getPrecision2() != null && pSDEField.getPrecision2() == null) {
                pSDEField.setPrecision2(pSDEFDataType.getPrecision2());
            }
        } else {
            pSDEField.setPhysicalField(0);
        }
        super.onBeforeCreate(pSDEField);
    }

    @Override
    protected void onAfterCreate(PSDEField pSDEField) throws Exception {
        if (pSDEField.isMajorFieldDirty() && DataObject.getBoolValue((Integer)pSDEField.getMajorField(), (boolean)false)) {
            this.reCalcMajorDEField(pSDEField);
        }
        super.onAfterCreate(pSDEField);
    }

    @Override
    protected void onBeforeUpdate(PSDEField pSDEField) throws Exception {
        super.onBeforeUpdate(pSDEField);
    }

    @Override
    protected void onAfterUpdate(PSDEField pSDEField) throws Exception {
        if (pSDEField.isMajorFieldDirty() && DataObject.getBoolValue((Integer)pSDEField.getMajorField(), (boolean)false)) {
            this.reCalcMajorDEField(pSDEField);
        }
        super.onAfterUpdate(pSDEField);
    }

    protected void reCalcMajorDEField(PSDEField pSDEField) throws Exception {
        PSDEField pSDEField2 = new PSDEField();
        pSDEField2.setMajorField(1);
        pSDEField2.setPSDEId(pSDEField.getPSDEId());
        if (!this.select(pSDEField2, true)) {
            return;
        }
        if (StringHelper.compare((String)pSDEField.getPSDEFieldId(), (String)pSDEField2.getPSDEFieldId(), (boolean)true) == 0) {
            return;
        }
        PSDEField pSDEField3 = new PSDEField();
        pSDEField3.setPSDEFieldId(pSDEField2.getPSDEFieldId());
        pSDEField3.setMajorField(0);
        this.update(pSDEField3);
    }

    @Override
    public void makeLinkMode(PSDEField pSDEField) throws Exception {
        this.get((IEntity)pSDEField);
        if (!DataObject.getBoolValue((Integer)pSDEField.getPhysicalField(), (boolean)false)) {
            return;
        }
        if (StringHelper.compare((String)pSDEField.getPSDataTypeId(), (String)"PICKUPDATA", (boolean)true) == 0 || StringHelper.compare((String)pSDEField.getPSDataTypeId(), (String)"PICKUPTEXT", (boolean)true) == 0) {
            String string = pSDEField.getPSDEFieldId();
            pSDEField.reset();
            pSDEField.setPSDEFieldId(string);
            pSDEField.setPhysicalField(0);
            pSDEField.setDEFType(3);
            pSDEField.setTableName(null);
            this.update(pSDEField);
        } else {
            String string = DEFDataTypeCodeListModel.getInstance().getCodeListText(pSDEField.getPSDataTypeId(), true);
            this.sendStudioConsole(true, "WARN", StringHelper.format((String)"\u5c5e\u6027[%1$s]\u7c7b\u578b[%2$s]\uff0c\u65e0\u6cd5\u8bbe\u7f6e\u4e3a\u94fe\u63a5\u6a21\u5f0f\uff0c\u94fe\u63a5\u6a21\u5f0f\u4ec5\u652f\u6301\u7c7b\u578b[\u5916\u952e\u503c\u6587\u672c]\u53ca[\u5916\u952e\u503c\u9644\u52a0\u6570\u636e]", (Object)pSDEField.getPSDEFieldName(), (Object)string), false);
        }
    }

    @Override
    public void makeRealMode(PSDEField pSDEField) throws Exception {
        this.get((IEntity)pSDEField);
        if (DataObject.getBoolValue((Integer)pSDEField.getPhysicalField(), (boolean)false)) {
            return;
        }
        if (StringHelper.compare((String)pSDEField.getPSDataTypeId(), (String)"PICKUPDATA", (boolean)true) == 0 || StringHelper.compare((String)pSDEField.getPSDataTypeId(), (String)"PICKUPTEXT", (boolean)true) == 0) {
            String string = pSDEField.getPSDE().getTableName();
            String string2 = pSDEField.getPSDEFieldId();
            pSDEField.reset();
            pSDEField.setPSDEFieldId(string2);
            pSDEField.setPhysicalField(1);
            pSDEField.setDEFType(1);
            pSDEField.setTableName(string);
            this.update(pSDEField);
        } else {
            String string = DEFDataTypeCodeListModel.getInstance().getCodeListText(pSDEField.getPSDataTypeId(), true);
            this.sendStudioConsole(true, "WARN", StringHelper.format((String)"\u5c5e\u6027[%1$s]\u7c7b\u578b[%2$s]\uff0c\u65e0\u6cd5\u8bbe\u7f6e\u4e3a\u7269\u7406\u6a21\u5f0f\uff0c\u7269\u7406\u6a21\u5f0f\u4ec5\u652f\u6301\u7c7b\u578b[\u5916\u952e\u503c\u6587\u672c]\u53ca[\u5916\u952e\u503c\u9644\u52a0\u6570\u636e]", (Object)pSDEField.getPSDEFieldName(), (Object)string), false);
        }
    }

    @Override
    public void initModel(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            EntityBase entityBase;
            Serializable serializable;
            PSDataEntity pSDataEntity = new PSDataEntity();
            pSDataEntity.proxy((IDataObject)iEntity);
            boolean bl = false;
            if (DataObject.getBoolValue((Integer)pSDataEntity.getExistingModel(), (boolean)false)) {
                this.sendStudioConsole(true, "WARN", StringHelper.format((String)"\u73b0\u6709\u7ed3\u6784\u5b9e\u4f53[%1$s]\u4e0d\u4f1a\u81ea\u52a8\u521d\u59cb\u5316\u9ed8\u8ba4\u5c5e\u6027", (Object)pSDataEntity.getPSDataEntityName()), false);
                bl = true;
            }
            if (!bl && DataObject.getIntegerValue((Object)pSDataEntity.getVirtualFlag(), (Integer)0) > 0) {
                bl = true;
                this.sendStudioConsole(true, "WARN", StringHelper.format((String)"\u865a\u62df\u5b9e\u4f53[%1$s]\u4e0d\u4f1a\u81ea\u52a8\u521d\u59cb\u5316\u9ed8\u8ba4\u5c5e\u6027", (Object)pSDataEntity.getPSDataEntityName()), false);
            }
            if (!bl && !StringHelper.isNullOrEmpty((String)pSDataEntity.getPSSubSysSADEId())) {
                bl = true;
                this.sendStudioConsole(true, "WARN", StringHelper.format((String)"\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53[%1$s]\u4e0d\u4f1a\u81ea\u52a8\u521d\u59cb\u5316\u9ed8\u8ba4\u5c5e\u6027", (Object)pSDataEntity.getPSDataEntityName()), false);
            }
            if (!bl && pSDataEntity.getPSModule() != null && DataObject.getBoolValue((Integer)pSDataEntity.getPSModule().getSubSysModule(), (boolean)false)) {
                bl = true;
                this.sendStudioConsole(true, "WARN", StringHelper.format((String)"\u5b50\u7cfb\u7edf\u5b9e\u4f53[%1$s]\u4e0d\u4f1a\u81ea\u52a8\u521d\u59cb\u5316\u9ed8\u8ba4\u5c5e\u6027", (Object)pSDataEntity.getPSDataEntityName()), false);
            }
            if (!bl) {
                Object object2;
                Serializable serializable2;
                serializable = PSDEFieldService.getCurrentPSSystem((IEntity)pSDataEntity, this.getSessionFactory());
                boolean bl2 = false;
                if (PSCoreSysModel.isEnableFolderKey() && DataObject.getBoolValue((Integer)((PSSystemBase)serializable).getEnableFolderKey(), (boolean)false)) {
                    bl2 = true;
                }
                entityBase = null;
                if (!StringHelper.isNullOrEmpty((String)((PSSystemBase)serializable).getPSDevSlnSysId())) {
                    entityBase = PSModelGlobal.getPSDCModelTempl(((PSSystemBase)serializable).getPSDevSlnSysId());
                }
                String string3 = pSDataEntity.getPSDataEntityName();
                String string4 = pSDataEntity.getLogicName();
                String string5 = pSDataEntity.getCodeName();
                ArrayList<PSDCMTDEF> arrayList = new ArrayList<PSDCMTDEF>();
                PSDCMTDEF pSDCMTDEF = null;
                PSDCMTDEF pSDCMTDEF2 = null;
                HashMap<String, PSDCMTDEF> hashMap = new HashMap<String, PSDCMTDEF>();
                if (entityBase != null) {
                    serializable2 = entityBase.getPSDCMTDEFs();
                    object2 = ((ArrayList)serializable2).iterator();
                    while (object2.hasNext()) {
                        PSDCMTDEF object3 = object2.next();
                        if (DataObject.getBoolValue((Integer)object3.getPKey(), (boolean)false)) {
                            pSDCMTDEF = object3;
                            continue;
                        }
                        if (DataObject.getBoolValue((Integer)object3.getMajorField(), (boolean)false)) {
                            pSDCMTDEF2 = object3;
                            continue;
                        }
                        if (!StringHelper.isNullOrEmpty((String)object3.getPreDefinedType())) {
                            hashMap.put(object3.getPreDefinedType(), object3);
                            continue;
                        }
                        arrayList.add(object3);
                    }
                }
                serializable2 = new PSDEField();
                ((PSDEFieldBase)serializable2).setPSDEId(pSDataEntity.getPSDataEntityId());
                ((PSDEFieldBase)serializable2).setPKey(1);
                if (!this.select(serializable2, true)) {
                    if (pSDCMTDEF != null) {
                        object2 = pSDCMTDEF.getPSDCMTDEFName().replace("_DENAME_", string3);
                        if (!StringHelper.isNullOrEmpty((String)object2) && ((String)object2).indexOf("_") == 0 && ((String)object2).lastIndexOf("_") == ((String)object2).length() - 1 && !StringHelper.isNullOrEmpty((String)(object2 = ((String)object2).substring(1)))) {
                            object2 = ((String)object2).substring(0, ((String)object2).length() - 1);
                        }
                        if (StringHelper.compare((String)object2, (String)pSDCMTDEF.getPSDCMTDEFName(), (boolean)false) == 0) {
                            object2 = string3 + pSDCMTDEF.getPSDCMTDEFName();
                        }
                        ((PSDEFieldBase)serializable2).setPSDEFieldName((String)object2);
                        ((PSDEFieldBase)serializable2).setLength(pSDCMTDEF.getLength());
                        if (!StringHelper.isNullOrEmpty((String)pSDCMTDEF.getLogicName())) {
                            String string6 = pSDCMTDEF.getLogicName().replace("_DENAME_", string4);
                            ((PSDEFieldBase)serializable2).setLogicName(string6);
                        }
                        if (!StringHelper.isNullOrEmpty((String)pSDCMTDEF.getCodeName())) {
                            String string7 = pSDCMTDEF.getCodeName().replace("_DENAME_", string5);
                            ((PSDEFieldBase)serializable2).setCodeName(string7);
                        }
                        if (pSDCMTDEF.getOrderValue() != null) {
                            ((PSDEFieldBase)serializable2).setOrderValue(pSDCMTDEF.getOrderValue());
                        }
                    } else {
                        if (PSDEFieldService.isEnableCodeNameUpperCamel()) {
                            ((PSDEFieldBase)serializable2).setPSDEFieldName(StringHelper.format((String)"%1$s_ID", (Object)string3));
                        } else {
                            ((PSDEFieldBase)serializable2).setPSDEFieldName(StringHelper.format((String)"%1$sID", (Object)string3));
                        }
                        if (StringHelper.isNullOrEmpty((String)((PSDEFieldBase)serializable2).getCodeName())) {
                            ((PSDEFieldBase)serializable2).setCodeName(StringHelper.format((String)"%1$sId", (Object)string5));
                        }
                    }
                    if (StringHelper.isNullOrEmpty((String)((PSDEFieldBase)serializable2).getLogicName())) {
                        ((PSDEFieldBase)serializable2).setLogicName(StringHelper.format((String)"%1$s\u6807\u8bc6", (Object)string4));
                    }
                    ((PSDEFieldBase)serializable2).setPSDataTypeId("GUID");
                    ((PSDEFieldBase)serializable2).setPSDEId(pSDataEntity.getPSDataEntityId());
                    if (bl2) {
                        ((PSDEFieldBase)serializable2).setPSDEFieldId(StringHelper.format((String)"%1$s-%2$s", (Object)((PSDEFieldBase)serializable2).getPSDEId(), (Object)RESERVERTAG_KEY));
                    } else {
                        ((PSDEFieldBase)serializable2).setPSDEFieldId(KeyValueHelper.genUniqueId((String)((PSDEFieldBase)serializable2).getPSDEId(), (String)((PSDEFieldBase)serializable2).getPSDEFieldName()));
                    }
                    if (this.checkKey(serializable2) == 0) {
                        ((PSDEFieldBase)serializable2).setTableName(pSDataEntity.getTableName());
                        ((PSDEFieldBase)serializable2).setDEFType(1);
                        ((PSDEFieldBase)serializable2).setPhysicalField(1);
                        ((PSDEFieldBase)serializable2).setAllowEmpty(0);
                        ((PSDEFieldBase)serializable2).setLength(100);
                        ((PSDEFieldBase)serializable2).setMajorField(0);
                        ((PSDEFieldBase)serializable2).setPKey(1);
                        ((PSDEFieldBase)serializable2).setFKey(0);
                        this.create(serializable2, false);
                    }
                }
                serializable2 = new PSDEField();
                ((PSDEFieldBase)serializable2).setPSDEId(pSDataEntity.getPSDataEntityId());
                ((PSDEFieldBase)serializable2).setMajorField(1);
                if (!this.select(serializable2, true)) {
                    if (pSDCMTDEF2 != null) {
                        object2 = pSDCMTDEF2.getPSDCMTDEFName().replace("_DENAME_", string3);
                        if (!StringHelper.isNullOrEmpty((String)object2) && ((String)object2).indexOf("_") == 0 && ((String)object2).lastIndexOf("_") == ((String)object2).length() - 1 && !StringHelper.isNullOrEmpty((String)(object2 = ((String)object2).substring(1)))) {
                            object2 = ((String)object2).substring(0, ((String)object2).length() - 1);
                        }
                        if (StringHelper.compare((String)object2, (String)pSDCMTDEF2.getPSDCMTDEFName(), (boolean)false) == 0) {
                            object2 = string3 + pSDCMTDEF2.getPSDCMTDEFName();
                        }
                        ((PSDEFieldBase)serializable2).setPSDEFieldName((String)object2);
                        ((PSDEFieldBase)serializable2).setPSDataTypeId(pSDCMTDEF2.getDEFDataType());
                        ((PSDEFieldBase)serializable2).setLength(pSDCMTDEF2.getLength());
                        if (!StringHelper.isNullOrEmpty((String)pSDCMTDEF2.getLogicName())) {
                            String string8 = pSDCMTDEF2.getLogicName().replace("_DENAME_", string4);
                            ((PSDEFieldBase)serializable2).setLogicName(string8);
                        }
                        if (!StringHelper.isNullOrEmpty((String)pSDCMTDEF2.getCodeName())) {
                            String string9 = pSDCMTDEF2.getCodeName().replace("_DENAME_", string5);
                            ((PSDEFieldBase)serializable2).setCodeName(string9);
                        }
                        if (pSDCMTDEF2.getOrderValue() != null) {
                            ((PSDEFieldBase)serializable2).setOrderValue(pSDCMTDEF2.getOrderValue());
                        }
                    } else {
                        if (PSDEFieldService.isEnableCodeNameUpperCamel()) {
                            ((PSDEFieldBase)serializable2).setPSDEFieldName(StringHelper.format((String)"%1$s_NAME", (Object)string3));
                        } else {
                            ((PSDEFieldBase)serializable2).setPSDEFieldName(StringHelper.format((String)"%1$sNAME", (Object)string3));
                        }
                        if (StringHelper.isNullOrEmpty((String)((PSDEFieldBase)serializable2).getCodeName())) {
                            ((PSDEFieldBase)serializable2).setCodeName(StringHelper.format((String)"%1$sName", (Object)string5));
                        }
                    }
                    if (StringHelper.isNullOrEmpty((Object)((PSDEFieldBase)serializable2).getDEFType())) {
                        ((PSDEFieldBase)serializable2).setPSDataTypeId("TEXT");
                        if (((PSDEFieldBase)serializable2).getLength() == null || ((PSDEFieldBase)serializable2).getLength() <= 0) {
                            ((PSDEFieldBase)serializable2).setLength(200);
                        }
                    }
                    if (StringHelper.isNullOrEmpty((String)((PSDEFieldBase)serializable2).getLogicName())) {
                        ((PSDEFieldBase)serializable2).setLogicName(StringHelper.format((String)"%1$s\u540d\u79f0", (Object)string4));
                    }
                    ((PSDEFieldBase)serializable2).setTableName(pSDataEntity.getTableName());
                    ((PSDEFieldBase)serializable2).setDEFType(1);
                    ((PSDEFieldBase)serializable2).setPhysicalField(1);
                    ((PSDEFieldBase)serializable2).setEnableUserInput(3);
                    ((PSDEFieldBase)serializable2).setAllowEmpty(1);
                    ((PSDEFieldBase)serializable2).setPSDEId(pSDataEntity.getPSDataEntityId());
                    if (bl2) {
                        ((PSDEFieldBase)serializable2).setPSDEFieldId(StringHelper.format((String)"%1$s-%2$s", (Object)((PSDEFieldBase)serializable2).getPSDEId(), (Object)RESERVERTAG_MAJOR));
                    } else {
                        ((PSDEFieldBase)serializable2).setPSDEFieldId(KeyValueHelper.genUniqueId((String)((PSDEFieldBase)serializable2).getPSDEId(), (String)((PSDEFieldBase)serializable2).getPSDEFieldName()));
                    }
                    if (this.checkKey(serializable2) == 0) {
                        ((PSDEFieldBase)serializable2).setMajorField(1);
                        ((PSDEFieldBase)serializable2).setPKey(0);
                        ((PSDEFieldBase)serializable2).setFKey(0);
                        this.create(serializable2, false);
                    }
                }
                if (DataObject.getBoolValue((Integer)pSDataEntity.getLogicValid(), (boolean)false)) {
                    serializable2 = new PSDEField();
                    ((PSDEFieldBase)serializable2).setPSDEId(pSDataEntity.getPSDataEntityId());
                    ((PSDEFieldBase)serializable2).setPreDefineType("LOGICVALID");
                    if (!this.select(serializable2, true)) {
                        object2 = (PSDCMTDEF)hashMap.get("LOGICVALID");
                        if (object2 != null) {
                            ((PSDEFieldBase)serializable2).setPSDEFieldName(((PSDCMTDEFBase)object2).getPSDCMTDEFName());
                            ((PSDEFieldBase)serializable2).setCodeName(((PSDCMTDEFBase)object2).getCodeName());
                            ((PSDEFieldBase)serializable2).setLogicName(((PSDCMTDEFBase)object2).getLogicName());
                            ((PSDEFieldBase)serializable2).setPSDataTypeId(((PSDCMTDEFBase)object2).getDEFDataType());
                            ((PSDEFieldBase)serializable2).setLength(((PSDCMTDEFBase)object2).getLength());
                            ((PSDEFieldBase)serializable2).setPreDefineType("LOGICVALID");
                            if (((PSDCMTDEFBase)object2).getOrderValue() != null) {
                                ((PSDEFieldBase)serializable2).setOrderValue(((PSDCMTDEFBase)object2).getOrderValue());
                            }
                        } else {
                            ((PSDEFieldBase)serializable2).setPSDEFieldName("ENABLE");
                            ((PSDEFieldBase)serializable2).setCodeName("Enable");
                            ((PSDEFieldBase)serializable2).setLogicName("\u903b\u8f91\u6709\u6548\u6807\u5fd7");
                            ((PSDEFieldBase)serializable2).setPSDataTypeId("YESNO");
                            ((PSDEFieldBase)serializable2).setLength(8);
                        }
                        ((PSDEFieldBase)serializable2).setPSDEId(pSDataEntity.getPSDataEntityId());
                        ((PSDEFieldBase)serializable2).setTableName(pSDataEntity.getTableName());
                        ((PSDEFieldBase)serializable2).setDEFType(1);
                        ((PSDEFieldBase)serializable2).setPhysicalField(1);
                        ((PSDEFieldBase)serializable2).setAllowEmpty(0);
                        ((PSDEFieldBase)serializable2).setMajorField(0);
                        ((PSDEFieldBase)serializable2).setPKey(0);
                        ((PSDEFieldBase)serializable2).setFKey(0);
                        if (bl2) {
                            ((PSDEFieldBase)serializable2).setPSDEFieldId(StringHelper.format((String)"%1$s-%2$s", (Object)((PSDEFieldBase)serializable2).getPSDEId(), (Object)RESERVERTAG_LOGICVALID));
                        } else {
                            ((PSDEFieldBase)serializable2).setPSDEFieldId(KeyValueHelper.genUniqueId((String)((PSDEFieldBase)serializable2).getPSDEId(), (String)((PSDEFieldBase)serializable2).getPSDEFieldName()));
                        }
                        if (this.checkKey(serializable2) == 0) {
                            this.create(serializable2, false);
                        }
                    }
                }
                if (!StringHelper.isNullOrEmpty((String)pSDataEntity.getIndexDEType())) {
                    serializable2 = new PSDEField();
                    ((PSDEFieldBase)serializable2).setPSDEId(pSDataEntity.getPSDataEntityId());
                    ((PSDEFieldBase)serializable2).setIndexType(1);
                    if (!this.select(serializable2, true)) {
                        if (PSDEFieldService.isEnableCodeNameUpperCamel()) {
                            ((PSDEFieldBase)serializable2).setPSDEFieldName(StringHelper.format((String)"%1$s_TYPE", (Object)string3));
                        } else {
                            ((PSDEFieldBase)serializable2).setPSDEFieldName(StringHelper.format((String)"%1$sTYPE", (Object)string3));
                        }
                        ((PSDEFieldBase)serializable2).setPSDEId(pSDataEntity.getPSDataEntityId());
                        ((PSDEFieldBase)serializable2).setLogicName("\u5206\u7ec4\u7c7b\u578b");
                        ((PSDEFieldBase)serializable2).setCodeName(StringHelper.format((String)"%1$sType", (Object)string5));
                        ((PSDEFieldBase)serializable2).setTableName(pSDataEntity.getTableName());
                        ((PSDEFieldBase)serializable2).setDEFType(1);
                        ((PSDEFieldBase)serializable2).setAllowEmpty(0);
                        ((PSDEFieldBase)serializable2).setPSDataTypeId("SSCODELIST");
                        ((PSDEFieldBase)serializable2).setLength(100);
                        ((PSDEFieldBase)serializable2).setPhysicalField(1);
                        ((PSDEFieldBase)serializable2).setIndexType(1);
                        ((PSDEFieldBase)serializable2).setMajorField(0);
                        ((PSDEFieldBase)serializable2).setPKey(0);
                        ((PSDEFieldBase)serializable2).setFKey(0);
                        if (bl2) {
                            ((PSDEFieldBase)serializable2).setPSDEFieldId(StringHelper.format((String)"%1$s-%2$s", (Object)((PSDEFieldBase)serializable2).getPSDEId(), (Object)RESERVERTAG_INDEXTYPE));
                        } else {
                            ((PSDEFieldBase)serializable2).setPSDEFieldId(KeyValueHelper.genUniqueId((String)((PSDEFieldBase)serializable2).getPSDEId(), (String)((PSDEFieldBase)serializable2).getPSDEFieldName()));
                        }
                        if (this.checkKey(serializable2) == 0) {
                            this.create(serializable2, false);
                        }
                    }
                }
                boolean bl3 = false;
                if (pSDataEntity.isEnableOPNameModelDirty()) {
                    bl3 = DataObject.getBoolValue((Integer)pSDataEntity.getEnableOPNameModel(), (boolean)false);
                } else if (pSDataEntity.getPSSystem() != null) {
                    bl3 = DataObject.getBoolValue((Integer)pSDataEntity.getPSSystem().getEnableOPNameModel(), (boolean)false);
                }
                object2 = new PSDEField();
                ((PSDEFieldBase)object2).setPSDEId(pSDataEntity.getPSDataEntityId());
                ((PSDEFieldBase)object2).setPreDefineType("CREATEMAN");
                if (!this.select(object2, true)) {
                    PSDCMTDEF pSDCMTDEF3 = (PSDCMTDEF)hashMap.remove("CREATEMAN");
                    if (pSDCMTDEF3 != null) {
                        ((PSDEFieldBase)object2).setPSDEFieldName(pSDCMTDEF3.getPSDCMTDEFName());
                        ((PSDEFieldBase)object2).setCodeName(pSDCMTDEF3.getCodeName());
                        ((PSDEFieldBase)object2).setLogicName(pSDCMTDEF3.getLogicName());
                        ((PSDEFieldBase)object2).setPSDataTypeId(pSDCMTDEF3.getDEFDataType());
                        ((PSDEFieldBase)object2).setLength(pSDCMTDEF3.getLength());
                        ((PSDEFieldBase)object2).setPreDefineType("CREATEMAN");
                        if (pSDCMTDEF3.getOrderValue() != null) {
                            ((PSDEFieldBase)object2).setOrderValue(pSDCMTDEF3.getOrderValue());
                        }
                    } else {
                        ((PSDEFieldBase)object2).setLogicName("\u5efa\u7acb\u4eba");
                        ((PSDEFieldBase)object2).setCodeName("CreateMan");
                        if (PSDEFieldService.isEnableCodeNameUpperCamel()) {
                            ((PSDEFieldBase)object2).setPSDEFieldName(StringHelper.format((String)"CREATE_MAN", (Object)string3));
                        } else {
                            ((PSDEFieldBase)object2).setPSDEFieldName(StringHelper.format((String)"CREATEMAN", (Object)string3));
                        }
                        ((PSDEFieldBase)object2).setPSDataTypeId("TEXT");
                        ((PSDEFieldBase)object2).setLength(60);
                    }
                    ((PSDEFieldBase)object2).setPSDEId(pSDataEntity.getPSDataEntityId());
                    ((PSDEFieldBase)object2).setTableName(pSDataEntity.getTableName());
                    ((PSDEFieldBase)object2).setDEFType(1);
                    ((PSDEFieldBase)object2).setPhysicalField(1);
                    ((PSDEFieldBase)object2).setAllowEmpty(0);
                    ((PSDEFieldBase)object2).setMajorField(0);
                    ((PSDEFieldBase)object2).setPKey(0);
                    ((PSDEFieldBase)object2).setFKey(0);
                    if (bl2) {
                        ((PSDEFieldBase)object2).setPSDEFieldId(StringHelper.format((String)"%1$s-%2$s", (Object)((PSDEFieldBase)object2).getPSDEId(), (Object)RESERVERTAG_CREATEMAN));
                    } else {
                        ((PSDEFieldBase)object2).setPSDEFieldId(KeyValueHelper.genUniqueId((String)((PSDEFieldBase)object2).getPSDEId(), (String)((PSDEFieldBase)object2).getPSDEFieldName()));
                    }
                    if (this.checkKey(object2) == 0) {
                        this.create(object2, false);
                    }
                }
                if (bl3) {
                    object2 = new PSDEField();
                    ((PSDEFieldBase)object2).setPSDEId(pSDataEntity.getPSDataEntityId());
                    ((PSDEFieldBase)object2).setPreDefineType("CREATEMANNAME");
                    if (!this.select(object2, true)) {
                        PSDCMTDEF pSDCMTDEF4 = (PSDCMTDEF)hashMap.remove("CREATEMANNAME");
                        if (pSDCMTDEF4 != null) {
                            ((PSDEFieldBase)object2).setPSDEFieldName(pSDCMTDEF4.getPSDCMTDEFName());
                            ((PSDEFieldBase)object2).setCodeName(pSDCMTDEF4.getCodeName());
                            ((PSDEFieldBase)object2).setLogicName(pSDCMTDEF4.getLogicName());
                            ((PSDEFieldBase)object2).setPSDataTypeId(pSDCMTDEF4.getDEFDataType());
                            ((PSDEFieldBase)object2).setLength(pSDCMTDEF4.getLength());
                            ((PSDEFieldBase)object2).setPreDefineType("CREATEMANNAME");
                            if (pSDCMTDEF4.getOrderValue() != null) {
                                ((PSDEFieldBase)object2).setOrderValue(pSDCMTDEF4.getOrderValue());
                            }
                        } else {
                            ((PSDEFieldBase)object2).setLogicName("\u5efa\u7acb\u4eba\u540d\u79f0");
                            ((PSDEFieldBase)object2).setCodeName("CreateManName");
                            if (PSDEFieldService.isEnableCodeNameUpperCamel()) {
                                ((PSDEFieldBase)object2).setPSDEFieldName(StringHelper.format((String)"CREATE_MAN_NAME", (Object)string3));
                            } else {
                                ((PSDEFieldBase)object2).setPSDEFieldName(StringHelper.format((String)"CREATEMANNAME", (Object)string3));
                            }
                            ((PSDEFieldBase)object2).setPSDataTypeId("TEXT");
                            ((PSDEFieldBase)object2).setLength(100);
                        }
                        ((PSDEFieldBase)object2).setPSDEId(pSDataEntity.getPSDataEntityId());
                        ((PSDEFieldBase)object2).setTableName(pSDataEntity.getTableName());
                        ((PSDEFieldBase)object2).setDEFType(1);
                        ((PSDEFieldBase)object2).setPhysicalField(1);
                        ((PSDEFieldBase)object2).setAllowEmpty(1);
                        ((PSDEFieldBase)object2).setMajorField(0);
                        ((PSDEFieldBase)object2).setPKey(0);
                        ((PSDEFieldBase)object2).setFKey(0);
                        if (bl2) {
                            ((PSDEFieldBase)object2).setPSDEFieldId(StringHelper.format((String)"%1$s-%2$s", (Object)((PSDEFieldBase)object2).getPSDEId(), (Object)RESERVERTAG_CREATEMANNAME));
                        } else {
                            ((PSDEFieldBase)object2).setPSDEFieldId(KeyValueHelper.genUniqueId((String)((PSDEFieldBase)object2).getPSDEId(), (String)((PSDEFieldBase)object2).getPSDEFieldName()));
                        }
                        if (this.checkKey(object2) == 0) {
                            this.create(object2, false);
                        }
                    }
                }
                object2 = new PSDEField();
                ((PSDEFieldBase)object2).setPSDEId(pSDataEntity.getPSDataEntityId());
                ((PSDEFieldBase)object2).setPreDefineType("CREATEDATE");
                if (!this.select(object2, true)) {
                    PSDCMTDEF pSDCMTDEF5 = (PSDCMTDEF)hashMap.remove("CREATEDATE");
                    if (pSDCMTDEF5 != null) {
                        ((PSDEFieldBase)object2).setPSDEFieldName(pSDCMTDEF5.getPSDCMTDEFName());
                        ((PSDEFieldBase)object2).setCodeName(pSDCMTDEF5.getCodeName());
                        ((PSDEFieldBase)object2).setLogicName(pSDCMTDEF5.getLogicName());
                        ((PSDEFieldBase)object2).setPSDataTypeId(pSDCMTDEF5.getDEFDataType());
                        ((PSDEFieldBase)object2).setLength(pSDCMTDEF5.getLength());
                        ((PSDEFieldBase)object2).setPreDefineType("CREATEDATE");
                        if (pSDCMTDEF5.getOrderValue() != null) {
                            ((PSDEFieldBase)object2).setOrderValue(pSDCMTDEF5.getOrderValue());
                        }
                    } else {
                        if (PSDEFieldService.isEnableCodeNameUpperCamel()) {
                            ((PSDEFieldBase)object2).setPSDEFieldName(StringHelper.format((String)"CREATE_DATE", (Object)string3));
                        } else {
                            ((PSDEFieldBase)object2).setPSDEFieldName(StringHelper.format((String)"CREATEDATE", (Object)string3));
                        }
                        ((PSDEFieldBase)object2).setLogicName("\u5efa\u7acb\u65f6\u95f4");
                        ((PSDEFieldBase)object2).setCodeName("CreateDate");
                        ((PSDEFieldBase)object2).setPSDataTypeId("DATETIME");
                        ((PSDEFieldBase)object2).setLength(8);
                    }
                    ((PSDEFieldBase)object2).setPSDEId(pSDataEntity.getPSDataEntityId());
                    ((PSDEFieldBase)object2).setTableName(pSDataEntity.getTableName());
                    ((PSDEFieldBase)object2).setDEFType(1);
                    ((PSDEFieldBase)object2).setPhysicalField(1);
                    ((PSDEFieldBase)object2).setAllowEmpty(0);
                    ((PSDEFieldBase)object2).setMajorField(0);
                    ((PSDEFieldBase)object2).setPKey(0);
                    ((PSDEFieldBase)object2).setFKey(0);
                    if (bl2) {
                        ((PSDEFieldBase)object2).setPSDEFieldId(StringHelper.format((String)"%1$s-%2$s", (Object)((PSDEFieldBase)object2).getPSDEId(), (Object)RESERVERTAG_CREATEDATE));
                    } else {
                        ((PSDEFieldBase)object2).setPSDEFieldId(KeyValueHelper.genUniqueId((String)((PSDEFieldBase)object2).getPSDEId(), (String)((PSDEFieldBase)object2).getPSDEFieldName()));
                    }
                    if (this.checkKey(object2) == 0) {
                        this.create(object2, false);
                    }
                }
                object2 = new PSDEField();
                ((PSDEFieldBase)object2).setPSDEId(pSDataEntity.getPSDataEntityId());
                ((PSDEFieldBase)object2).setPreDefineType("UPDATEMAN");
                if (!this.select(object2, true)) {
                    PSDCMTDEF pSDCMTDEF6 = (PSDCMTDEF)hashMap.remove("UPDATEMAN");
                    if (pSDCMTDEF6 != null) {
                        ((PSDEFieldBase)object2).setPSDEFieldName(pSDCMTDEF6.getPSDCMTDEFName());
                        ((PSDEFieldBase)object2).setCodeName(pSDCMTDEF6.getCodeName());
                        ((PSDEFieldBase)object2).setLogicName(pSDCMTDEF6.getLogicName());
                        ((PSDEFieldBase)object2).setPSDataTypeId(pSDCMTDEF6.getDEFDataType());
                        ((PSDEFieldBase)object2).setLength(pSDCMTDEF6.getLength());
                        ((PSDEFieldBase)object2).setPreDefineType("UPDATEMAN");
                        if (pSDCMTDEF6.getOrderValue() != null) {
                            ((PSDEFieldBase)object2).setOrderValue(pSDCMTDEF6.getOrderValue());
                        }
                    } else {
                        if (PSDEFieldService.isEnableCodeNameUpperCamel()) {
                            ((PSDEFieldBase)object2).setPSDEFieldName(StringHelper.format((String)"UPDATE_MAN", (Object)string3));
                        } else {
                            ((PSDEFieldBase)object2).setPSDEFieldName(StringHelper.format((String)"UPDATEMAN", (Object)string3));
                        }
                        ((PSDEFieldBase)object2).setLogicName("\u66f4\u65b0\u4eba");
                        ((PSDEFieldBase)object2).setCodeName("UpdateMan");
                        ((PSDEFieldBase)object2).setPSDataTypeId("TEXT");
                        ((PSDEFieldBase)object2).setLength(60);
                    }
                    ((PSDEFieldBase)object2).setPSDEId(pSDataEntity.getPSDataEntityId());
                    ((PSDEFieldBase)object2).setTableName(pSDataEntity.getTableName());
                    ((PSDEFieldBase)object2).setDEFType(1);
                    ((PSDEFieldBase)object2).setAllowEmpty(0);
                    ((PSDEFieldBase)object2).setMajorField(0);
                    ((PSDEFieldBase)object2).setPKey(0);
                    ((PSDEFieldBase)object2).setFKey(0);
                    if (bl2) {
                        ((PSDEFieldBase)object2).setPSDEFieldId(StringHelper.format((String)"%1$s-%2$s", (Object)((PSDEFieldBase)object2).getPSDEId(), (Object)RESERVERTAG_UPDATEMAN));
                    } else {
                        ((PSDEFieldBase)object2).setPSDEFieldId(KeyValueHelper.genUniqueId((String)((PSDEFieldBase)object2).getPSDEId(), (String)((PSDEFieldBase)object2).getPSDEFieldName()));
                    }
                    if (this.checkKey(object2) == 0) {
                        this.create(object2, false);
                    }
                }
                if (bl3) {
                    object2 = new PSDEField();
                    ((PSDEFieldBase)object2).setPSDEId(pSDataEntity.getPSDataEntityId());
                    ((PSDEFieldBase)object2).setPreDefineType("UPDATEMANNAME");
                    if (!this.select(object2, true)) {
                        PSDCMTDEF pSDCMTDEF7 = (PSDCMTDEF)hashMap.remove("UPDATEMANNAME");
                        if (pSDCMTDEF7 != null) {
                            ((PSDEFieldBase)object2).setPSDEFieldName(pSDCMTDEF7.getPSDCMTDEFName());
                            ((PSDEFieldBase)object2).setCodeName(pSDCMTDEF7.getCodeName());
                            ((PSDEFieldBase)object2).setLogicName(pSDCMTDEF7.getLogicName());
                            ((PSDEFieldBase)object2).setPSDataTypeId(pSDCMTDEF7.getDEFDataType());
                            ((PSDEFieldBase)object2).setLength(pSDCMTDEF7.getLength());
                            ((PSDEFieldBase)object2).setPreDefineType("UPDATEMANNAME");
                            if (pSDCMTDEF7.getOrderValue() != null) {
                                ((PSDEFieldBase)object2).setOrderValue(pSDCMTDEF7.getOrderValue());
                            }
                        } else {
                            ((PSDEFieldBase)object2).setLogicName("\u66f4\u65b0\u4eba\u540d\u79f0");
                            ((PSDEFieldBase)object2).setCodeName("UpdateManName");
                            if (PSDEFieldService.isEnableCodeNameUpperCamel()) {
                                ((PSDEFieldBase)object2).setPSDEFieldName(StringHelper.format((String)"UPDATE_MAN_NAME", (Object)string3));
                            } else {
                                ((PSDEFieldBase)object2).setPSDEFieldName(StringHelper.format((String)"UPDATEMANNAME", (Object)string3));
                            }
                            ((PSDEFieldBase)object2).setPSDataTypeId("TEXT");
                            ((PSDEFieldBase)object2).setLength(100);
                        }
                        ((PSDEFieldBase)object2).setPSDEId(pSDataEntity.getPSDataEntityId());
                        ((PSDEFieldBase)object2).setTableName(pSDataEntity.getTableName());
                        ((PSDEFieldBase)object2).setDEFType(1);
                        ((PSDEFieldBase)object2).setPhysicalField(1);
                        ((PSDEFieldBase)object2).setAllowEmpty(1);
                        ((PSDEFieldBase)object2).setMajorField(0);
                        ((PSDEFieldBase)object2).setPKey(0);
                        ((PSDEFieldBase)object2).setFKey(0);
                        if (bl2) {
                            ((PSDEFieldBase)object2).setPSDEFieldId(StringHelper.format((String)"%1$s-%2$s", (Object)((PSDEFieldBase)object2).getPSDEId(), (Object)RESERVERTAG_UPDATEMANNAME));
                        } else {
                            ((PSDEFieldBase)object2).setPSDEFieldId(KeyValueHelper.genUniqueId((String)((PSDEFieldBase)object2).getPSDEId(), (String)((PSDEFieldBase)object2).getPSDEFieldName()));
                        }
                        if (this.checkKey(object2) == 0) {
                            this.create(object2, false);
                        }
                    }
                }
                object2 = new PSDEField();
                ((PSDEFieldBase)object2).setPSDEId(pSDataEntity.getPSDataEntityId());
                ((PSDEFieldBase)object2).setPreDefineType("UPDATEDATE");
                if (!this.select(object2, true)) {
                    PSDCMTDEF pSDCMTDEF8 = (PSDCMTDEF)hashMap.remove("UPDATEDATE");
                    if (pSDCMTDEF8 != null) {
                        ((PSDEFieldBase)object2).setPSDEFieldName(pSDCMTDEF8.getPSDCMTDEFName());
                        ((PSDEFieldBase)object2).setCodeName(pSDCMTDEF8.getCodeName());
                        ((PSDEFieldBase)object2).setLogicName(pSDCMTDEF8.getLogicName());
                        ((PSDEFieldBase)object2).setPSDataTypeId(pSDCMTDEF8.getDEFDataType());
                        ((PSDEFieldBase)object2).setLength(pSDCMTDEF8.getLength());
                        ((PSDEFieldBase)object2).setPreDefineType("UPDATEDATE");
                        if (pSDCMTDEF8.getOrderValue() != null) {
                            ((PSDEFieldBase)object2).setOrderValue(pSDCMTDEF8.getOrderValue());
                        }
                    } else {
                        if (PSDEFieldService.isEnableCodeNameUpperCamel()) {
                            ((PSDEFieldBase)object2).setPSDEFieldName(StringHelper.format((String)"UPDATE_DATE", (Object)string3));
                        } else {
                            ((PSDEFieldBase)object2).setPSDEFieldName(StringHelper.format((String)"UPDATEDATE", (Object)string3));
                        }
                        ((PSDEFieldBase)object2).setLogicName("\u66f4\u65b0\u65f6\u95f4");
                        ((PSDEFieldBase)object2).setCodeName("UpdateDate");
                        ((PSDEFieldBase)object2).setPSDataTypeId("DATETIME");
                        ((PSDEFieldBase)object2).setLength(8);
                    }
                    ((PSDEFieldBase)object2).setPSDEId(pSDataEntity.getPSDataEntityId());
                    ((PSDEFieldBase)object2).setTableName(pSDataEntity.getTableName());
                    ((PSDEFieldBase)object2).setDEFType(1);
                    ((PSDEFieldBase)object2).setPhysicalField(1);
                    ((PSDEFieldBase)object2).setAllowEmpty(0);
                    ((PSDEFieldBase)object2).setMajorField(0);
                    ((PSDEFieldBase)object2).setPKey(0);
                    ((PSDEFieldBase)object2).setFKey(0);
                    if (bl2) {
                        ((PSDEFieldBase)object2).setPSDEFieldId(StringHelper.format((String)"%1$s-%2$s", (Object)((PSDEFieldBase)object2).getPSDEId(), (Object)RESERVERTAG_UPDATEDATE));
                    } else {
                        ((PSDEFieldBase)object2).setPSDEFieldId(KeyValueHelper.genUniqueId((String)((PSDEFieldBase)object2).getPSDEId(), (String)((PSDEFieldBase)object2).getPSDEFieldName()));
                    }
                    if (this.checkKey(object2) == 0) {
                        this.create(object2, false);
                    }
                }
                if (DataObject.getBoolValue((Integer)pSDataEntity.getEnableOrgModel(), (boolean)false)) {
                    object2 = new PSDEField();
                    ((PSDEFieldBase)object2).setPSDEId(pSDataEntity.getPSDataEntityId());
                    ((PSDEFieldBase)object2).setPreDefineType("ORGID");
                    if (!this.select(object2, true)) {
                        PSDCMTDEF pSDCMTDEF9 = (PSDCMTDEF)hashMap.remove("ORGID");
                        if (pSDCMTDEF9 != null) {
                            ((PSDEFieldBase)object2).setPSDEFieldName(pSDCMTDEF9.getPSDCMTDEFName());
                            ((PSDEFieldBase)object2).setCodeName(pSDCMTDEF9.getCodeName());
                            ((PSDEFieldBase)object2).setLogicName(pSDCMTDEF9.getLogicName());
                            ((PSDEFieldBase)object2).setPSDataTypeId(pSDCMTDEF9.getDEFDataType());
                            ((PSDEFieldBase)object2).setLength(pSDCMTDEF9.getLength());
                            ((PSDEFieldBase)object2).setPreDefineType("ORGID");
                            if (pSDCMTDEF9.getOrderValue() != null) {
                                ((PSDEFieldBase)object2).setOrderValue(pSDCMTDEF9.getOrderValue());
                            }
                        } else {
                            if (PSDEFieldService.isEnableCodeNameUpperCamel()) {
                                ((PSDEFieldBase)object2).setPSDEFieldName(StringHelper.format((String)"ORG_ID"));
                            } else {
                                ((PSDEFieldBase)object2).setPSDEFieldName(StringHelper.format((String)"ORGID"));
                            }
                            ((PSDEFieldBase)object2).setLogicName("\u7ec4\u7ec7\u673a\u6784\u6807\u8bc6");
                            ((PSDEFieldBase)object2).setCodeName("OrgId");
                            ((PSDEFieldBase)object2).setPSDataTypeId("TEXT");
                            ((PSDEFieldBase)object2).setLength(60);
                        }
                        ((PSDEFieldBase)object2).setPSDEId(pSDataEntity.getPSDataEntityId());
                        ((PSDEFieldBase)object2).setTableName(pSDataEntity.getTableName());
                        ((PSDEFieldBase)object2).setDEFType(1);
                        ((PSDEFieldBase)object2).setPhysicalField(1);
                        ((PSDEFieldBase)object2).setAllowEmpty(0);
                        ((PSDEFieldBase)object2).setMajorField(0);
                        ((PSDEFieldBase)object2).setPKey(0);
                        ((PSDEFieldBase)object2).setFKey(0);
                        if (bl2) {
                            ((PSDEFieldBase)object2).setPSDEFieldId(StringHelper.format((String)"%1$s-%2$s", (Object)((PSDEFieldBase)object2).getPSDEId(), (Object)RESERVERTAG_ORGID));
                        } else {
                            ((PSDEFieldBase)object2).setPSDEFieldId(KeyValueHelper.genUniqueId((String)((PSDEFieldBase)object2).getPSDEId(), (String)((PSDEFieldBase)object2).getPSDEFieldName()));
                        }
                        if (this.checkKey(object2) == 0) {
                            this.create(object2, false);
                        }
                    }
                }
                arrayList.addAll(hashMap.values());
                for (PSDCMTDEF pSDCMTDEF10 : arrayList) {
                    PSDEField pSDEField = new PSDEField();
                    pSDEField.setPSDEFieldName(pSDCMTDEF10.getPSDCMTDEFName());
                    pSDEField.setCodeName(pSDCMTDEF10.getCodeName());
                    pSDEField.setLogicName(pSDCMTDEF10.getLogicName());
                    pSDEField.setPSDataTypeId(pSDCMTDEF10.getDEFDataType());
                    pSDEField.setLength(pSDCMTDEF10.getLength());
                    pSDEField.setPreDefineType(pSDCMTDEF10.getPreDefinedType());
                    pSDEField.setPSDEId(pSDataEntity.getPSDataEntityId());
                    pSDEField.setTableName(pSDataEntity.getTableName());
                    pSDEField.setDEFType(1);
                    pSDEField.setPhysicalField(1);
                    pSDEField.setAllowEmpty(1);
                    pSDEField.setMajorField(0);
                    pSDEField.setPKey(0);
                    pSDEField.setFKey(0);
                    if (pSDCMTDEF10.getOrderValue() != null) {
                        pSDEField.setOrderValue(pSDCMTDEF10.getOrderValue());
                    }
                    if (bl2) {
                        PSDEField pSDEField2 = new PSDEField();
                        pSDEField2.setPSDEId(pSDEField.getPSDEId());
                        pSDEField2.setPSDEFieldName(pSDEField.getPSDEFieldName());
                        if (this.selectOne((IEntity)pSDEField2, true)) continue;
                        this.create(pSDEField, false);
                        continue;
                    }
                    pSDEField.setPSDEFieldId(KeyValueHelper.genUniqueId((String)pSDEField.getPSDEId(), (String)pSDEField.getPSDEFieldName()));
                    if (this.checkKey(pSDEField) != 0) continue;
                    this.create(pSDEField, false);
                }
            }
            serializable = this.selectByPSDE(pSDataEntity);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                entityBase = (PSDEField)iterator.next();
                this.initModel(entityBase);
            }
        }
    }

    @Override
    protected void onBeforeRemove(PSDEField pSDEField) throws Exception {
        PSSysDMItemService pSSysDMItemService = (PSSysDMItemService)ServiceGlobal.getService(PSSysDMItemService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        selectCond.set("DBOBJTYPE", (Object)"COLUMN");
        selectCond.set("PSOBJID", (Object)pSDEField.getPSDEFieldId());
        pSSysDMItemService.remove((ISelectCond)selectCond, true);
        selectCond.reset();
        selectCond.set("DBOBJTYPE", (Object)"FKEY");
        selectCond.set("PSOBJID", (Object)pSDEField.getPSDEFieldId());
        pSSysDMItemService.remove((ISelectCond)selectCond, true);
        super.onBeforeRemove(pSDEField);
    }

    @Override
    protected void onResetRefs(PSDEField pSDEField) throws Exception {
    }

    @Override
    protected void onCheckEntity(boolean bl, PSDEField pSDEField, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        if (!bl) {
            String string;
            PSDataEntity pSDataEntity = new PSDataEntity();
            pSDataEntity.setPSDataEntityId(pSDEField.getPSDEId());
            PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
            if (!StringHelper.isNullOrEmpty((String)pSDEField.getCodeName()) && !StringHelper.isNullOrEmpty((String)(string = pSDataEntityService.checkObjCodeName(pSDataEntity, pSDEField, pSDEField.getCodeName())))) {
                entityError.register("CODENAME", "\u4ee3\u7801\u540d\u79f0", "", 3, StringHelper.format((String)"\u4ee3\u7801\u540d\u79f0[%1$s]\u5df2\u7ecf\u88ab%2$s\u4f7f\u7528", (Object)pSDEField.getCodeName(), (Object)string));
            }
        }
        super.onCheckEntity(bl, pSDEField, bl2, bl3, entityError);
    }

    protected String calcDEFieldCodeName(String string) throws Exception {
        Object object = DataContextMethod.getValue((String)"pssystemid", (SessionFactory)this.getSessionFactory());
        if (StringHelper.isNullOrEmpty((Object)object)) {
            object = "2C40DFCD-0DF5-47BF-91A5-C45F810B0001";
        }
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSSYSTEMID", object);
        selectCond.set("PSDEFIELDNAME", (Object)string);
        selectCond.set("CODENAME", SelectCond.ISNOTNULL);
        selectCond.setOrderInfo(" ORDER BY UPDATEDATE DESC");
        selectCond.setFetchFirst(true);
        ArrayList arrayList = this.select((ISelectCond)selectCond);
        if (arrayList.size() > 0) {
            return ((PSDEField)arrayList.get(0)).getCodeName();
        }
        return null;
    }

    protected void onExecuteAction(String string, ArrayList<IEntity> arrayList) throws Exception {
        if (StringHelper.compare((String)string, (String)"AUTOCODENAME", (boolean)true) == 0) {
            this.fillDEFieldsCodeName(arrayList);
            return;
        }
        super.onExecuteAction(string, arrayList);
    }

    protected void fillDEFieldsCodeName(ArrayList<IEntity> arrayList) throws Exception {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (IEntity iEntity : arrayList) {
            PSDEField pSDEField = new PSDEField();
            pSDEField.setPSDEFieldId(DataObject.getStringValue((Object)iEntity.get("PSDEFIELDID")));
            this.get((IEntity)pSDEField);
            if (!StringHelper.isNullOrEmpty((String)pSDEField.getCodeName())) continue;
            String string = (String)hashMap.get(pSDEField.getPSDEFieldName());
            if (string == null) {
                string = this.calcDEFieldCodeName(pSDEField.getPSDEFieldName());
                if (StringHelper.isNullOrEmpty((String)string) && PSDEFieldService.isEnableCodeNameUpperCamel()) {
                    string = PSDEFieldService.toUpperCamel(pSDEField.getPSDEFieldName());
                }
                if (StringHelper.isNullOrEmpty((String)string)) {
                    string = "";
                }
                hashMap.put(pSDEField.getPSDEFieldName(), string);
            }
            if (StringHelper.isNullOrEmpty((String)string)) continue;
            pSDEField.reset();
            pSDEField.setPSDEFieldId(DataObject.getStringValue((Object)iEntity.get("PSDEFIELDID")));
            pSDEField.setCodeName(string);
            this.update(pSDEField, false);
        }
    }

    @Override
    protected void onAutoCodeName(PSDEField pSDEField) throws Exception {
        this.get((IEntity)pSDEField);
        if (StringHelper.isNullOrEmpty((String)pSDEField.getCodeName())) {
            String string = this.calcDEFieldCodeName(pSDEField.getPSDEFieldName());
            if (StringHelper.isNullOrEmpty((String)string) && PSDEFieldService.isEnableCodeNameUpperCamel()) {
                string = PSDEFieldService.toUpperCamel(pSDEField.getPSDEFieldName());
            }
            if (!StringHelper.isNullOrEmpty((String)string)) {
                pSDEField.setCodeName(string);
                this.update(pSDEField, false);
            }
        }
    }

    @Override
    protected void onCreateDefaultInputTip(PSDEField pSDEField) throws Exception {
        this.get((IEntity)pSDEField);
        PSDEFInputTipService pSDEFInputTipService = (PSDEFInputTipService)ServiceGlobal.getService(PSDEFInputTipService.class, (SessionFactory)this.getSessionFactory());
        PSDEFInputTip pSDEFInputTip = new PSDEFInputTip();
        pSDEFInputTip.setPSDEFId(pSDEField.getPSDEFieldId());
        pSDEFInputTip.setDefaultFlag(1);
        if (pSDEFInputTipService.select(pSDEFInputTip, true)) {
            return;
        }
        PSDataEntity pSDataEntity = (PSDataEntity)this.getWebContextCacheEntity("PSDATAENTITY", pSDEField.getPSDEId());
        pSDEFInputTip.reset();
        pSDEFInputTip.setPSDEFInputTipName(StringHelper.format((String)"[%1$s]\u9ed8\u8ba4\u8f93\u5165\u63d0\u793a", (Object)pSDEField.getPSDEFieldName()));
        pSDEFInputTip.setPSDEFId(pSDEField.getPSDEFieldId());
        pSDEFInputTip.setPSDEFName(pSDEField.getPSDEFieldName());
        pSDEFInputTip.setPSDEId(pSDEField.getPSDEId());
        pSDEFInputTip.setPSDEName(pSDEField.getPSDEName());
        pSDEFInputTip.setDefaultFlag(1);
        if (!StringHelper.isNullOrEmpty((String)pSDataEntity.getPSDEFInputTipSetId())) {
            pSDEFInputTip.setPSDEFInputTipSetId(pSDataEntity.getPSDEFInputTipSetId());
            pSDEFInputTip.setUniqueTag(StringHelper.format((String)"%1$s__%2$s", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDEField.getPSDEFieldName()).toUpperCase());
        }
        pSDEFInputTipService.create(pSDEFInputTip);
    }

    @Override
    protected void onCreateDefaultVR(PSDEField pSDEField) throws Exception {
        this.get((IEntity)pSDEField);
        PSDEFValueRule pSDEFValueRule = new PSDEFValueRule();
        pSDEFValueRule.setDefaultMode(1);
        pSDEFValueRule.setSessionFactory(this.getSessionFactory());
        pSDEFValueRule.setPSDEFId(pSDEField.getPSDEFieldId());
        if (pSDEFValueRule.select(true)) {
            return;
        }
        String string = "";
        for (int i = 1; i < 100; ++i) {
            string = "Default";
            if (i >= 2) {
                string = string + Integer.toString(i);
            }
            pSDEFValueRule.reset();
            pSDEFValueRule.setSessionFactory(this.getSessionFactory());
            pSDEFValueRule.setPSDEFId(pSDEField.getPSDEFieldId());
            pSDEFValueRule.setCodeName(string);
            if (!pSDEFValueRule.select(true)) break;
        }
        pSDEFValueRule.reset();
        pSDEFValueRule.setDefaultMode(1);
        pSDEFValueRule.setSessionFactory(this.getSessionFactory());
        pSDEFValueRule.setPSDEId(pSDEField.getPSDEId());
        pSDEFValueRule.setPSDEName(pSDEField.getPSDEName());
        pSDEFValueRule.setPSDEFId(pSDEField.getPSDEFieldId());
        pSDEFValueRule.setPSDEFName(pSDEField.getPSDEFieldName());
        pSDEFValueRule.setCodeName(string);
        pSDEFValueRule.setPSDEFValueRuleName(StringHelper.format((String)"\u9ed8\u8ba4\u89c4\u5219", (Object)pSDEField.getLogicName()));
        pSDEFValueRule.setRuleInfo(StringHelper.format((String)"\u9ed8\u8ba4\u89c4\u5219", (Object)pSDEField.getLogicName()));
        pSDEFValueRule.create();
    }

    @Override
    protected void onAjaxFillDVT(PSDEField pSDEField) throws Exception {
        if (this.getWebContext() == null || this.getWebContext().getCurAjaxActionResult() == null) {
            throw new Exception("\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u4e0d\u6b63\u786e");
        }
        String string = this.getWebContext().getPostValue("srfactionparam");
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        JSONObject jSONObject = JSONObject.fromString((String)string);
        String string2 = jSONObject.optString("srfkey");
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return;
        }
        PSVarSampleValueService pSVarSampleValueService = (PSVarSampleValueService)ServiceGlobal.getService(PSVarSampleValueService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSVarSampleValue pSVarSampleValue = new PSVarSampleValue();
        pSVarSampleValue.setPSVarSampleValueId(string2);
        if (pSVarSampleValueService.get((IEntity)pSVarSampleValue, true)) {
            pSDEField.setDefaultValueType(pSVarSampleValue.getVarType());
            pSDEField.setDefaultValue(pSVarSampleValue.getValue());
        }
    }

    @Override
    protected void onAjaxFillDataType(PSDEField pSDEField) throws Exception {
        if (this.getWebContext() == null || this.getWebContext().getCurAjaxActionResult() == null) {
            throw new Exception("\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u4e0d\u6b63\u786e");
        }
        String string = this.getWebContext().getPostValue("srfactionparam");
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        JSONObject jSONObject = JSONObject.fromString((String)string);
        String string2 = jSONObject.optString("srfkey");
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return;
        }
        String string3 = jSONObject.optString("srfmajortext");
        pSDEField.setPSDataTypeId(string2);
        pSDEField.setPSDataTypeName(string3);
    }

    protected void syncPSDEFDataType(PSDEField pSDEField) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDEField.getPSDataTypeId())) {
            return;
        }
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        PSDEFDataTypeService pSDEFDataTypeService = (PSDEFDataTypeService)ServiceGlobal.getService(PSDEFDataTypeService.class, (SessionFactory)this.getSessionFactory());
        PSDEFDataType pSDEFDataType = new PSDEFDataType();
        pSDEFDataType.setPSDEFDataTypeId(pSDEField.getPSDataTypeId());
        if (pSDEFDataTypeService.get((IEntity)pSDEFDataType, true)) {
            return;
        }
        PSDEFDataTypeService pSDEFDataTypeService2 = (PSDEFDataTypeService)ServiceGlobal.getService(PSDEFDataTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDEFDataType pSDEFDataType2 = new PSDEFDataType();
        pSDEFDataType2.setPSDEFDataTypeId(pSDEField.getPSDataTypeId());
        if (!pSDEFDataTypeService2.get((IEntity)pSDEFDataType2, true)) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5c5e\u6027\u6570\u636e\u7c7b\u578b[%1$s]", (Object)pSDEField.getPSDataTypeId()));
        }
        pSDEFDataType2.setPSUnitId(null);
        pSDEFDataType2.setPSUnitName(null);
        pSDEFDataType2.setPSValueRuleId(null);
        pSDEFDataType2.setPSValueRuleName(null);
        pSDEFDataTypeService.create(pSDEFDataType2);
    }

    @Override
    public ObjectNode exportModelV2(PSDEField pSDEField) throws Exception {
        ObjectNode objectNode = super.exportModelV2(pSDEField);
        if (objectNode != null) {
            objectNode.remove("tablename");
            objectNode.remove("psdetableid");
            objectNode.remove("pssysdbcolumnid");
        }
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string;
        if (PSDEFieldService.isSimpleImportExportMode() && !StringHelper.isNullOrEmpty((String)(string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDERID", null)))) {
            return StringHelper.format((String)"PSDER#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public Object getDataContextValue(PSDEField pSDEField, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = super.getDataContextValue(pSDEField, string, iDataContextParam);
        if (object == null && StringHelper.compare((String)string, (String)"psdefid", (boolean)true) == 0) {
            return pSDEField.getPSDEFieldId();
        }
        return object;
    }
}

