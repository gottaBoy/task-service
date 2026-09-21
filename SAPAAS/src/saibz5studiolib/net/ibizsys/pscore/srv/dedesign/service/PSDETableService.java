/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETable;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETableServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBColumn;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBScheme;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBTable;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBTableService;
import net.ibizsys.pscore.srv.util.PSDEFDataTypeHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDETableService
extends PSDETableServiceBase {
    private static final Log log = LogFactory.getLog(PSDETableService.class);

    @Override
    protected void onBeforeCreate(PSDETable pSDETable) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDETable.getPSSysDBTableId()) && pSDETable.getPSDE() != null) {
            String string = pSDETable.getPSDE().getDSLink();
            if (StringHelper.isNullOrEmpty((String)string)) {
                string = "DEFAULT";
            }
            PSSysDBSchemeService pSSysDBSchemeService = (PSSysDBSchemeService)ServiceGlobal.getService(PSSysDBSchemeService.class, (SessionFactory)this.getSessionFactory());
            PSSysDBScheme pSSysDBScheme = new PSSysDBScheme();
            pSSysDBScheme.setPSSystemId(pSDETable.getPSDE().getPSSystemId());
            pSSysDBScheme.setDSLink(string);
            if (pSSysDBSchemeService.selectOne((IEntity)pSSysDBScheme, true)) {
                PSSysDBTableService pSSysDBTableService = (PSSysDBTableService)ServiceGlobal.getService(PSSysDBTableService.class, (SessionFactory)this.getSessionFactory());
                PSSysDBTable pSSysDBTable = new PSSysDBTable();
                pSSysDBTable.setPSSysDBTableName(pSDETable.getPSDETableName());
                pSSysDBTable.setPSSysDBSchemeId(pSSysDBScheme.getPSSysDBSchemeId());
                if (pSSysDBTableService.selectOne((IEntity)pSSysDBTable, true)) {
                    pSDETable.setPSSysDBTableId(pSSysDBTable.getPSSysDBTableId());
                    pSDETable.setPSSysDBTableName(pSSysDBTable.getPSSysDBTableName());
                }
            }
        }
        super.onBeforeCreate(pSDETable);
    }

    @Override
    protected void onBeforeRemove(PSDETable pSDETable) throws Exception {
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEField> arrayList = pSDEFieldService.selectByPSDETable(pSDETable);
        for (PSDEField pSDEField : arrayList) {
            PSDEField pSDEField2 = new PSDEField();
            pSDEField2.setPSDEFieldId(pSDEField.getPSDEFieldId());
            pSDEField2.setPSDETableId(null);
            pSDEField2.setPSSysDBColumnId(null);
            pSDEFieldService.sysUpdate(pSDEField2, false);
        }
        super.onBeforeRemove(pSDETable);
    }

    @Override
    protected void onSyncDEFields(PSDETable pSDETable) throws Exception {
        String[] stringArray;
        String string;
        PSSysDBTable pSSysDBTable;
        if (!pSDETable.isFullEntity()) {
            this.get((IEntity)pSDETable);
        }
        if ((pSSysDBTable = pSDETable.getPSSysDBTable()) == null) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53\u6570\u636e\u8868\u672a\u7ed1\u5b9a\u7cfb\u7edf\u6570\u636e\u5e93\u8868\uff0c\u65e0\u6cd5\u540c\u6b65\u5c5e\u6027"));
        }
        PSDataEntity pSDataEntity = pSDETable.getPSDE();
        if (pSDataEntity == null) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53\u6570\u636e\u8868\u672a\u6307\u5b9a\u5b9e\u4f53\uff0c\u65e0\u6cd5\u540c\u6b65\u5c5e\u6027"));
        }
        if (DataObject.getIntegerValue((Object)pSDataEntity.getExistingModel(), (Integer)0) == 0) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53\u4e0d\u662f\u73b0\u6709\u6570\u636e\u7ed3\u6784\u5b9e\u4f53\uff0c\u65e0\u6cd5\u540c\u6b65\u5c5e\u6027"));
        }
        boolean bl = false;
        ArrayList<PSDEField> arrayList = pSDETable.getPSDE().getPSDEFields();
        HashMap<String, PSDEField> hashMap = new HashMap<String, PSDEField>();
        for (PSDEField serializable2 : arrayList) {
            if (StringHelper.isNullOrEmpty((String)serializable2.getPSDEFieldName())) continue;
            hashMap.put(serializable2.getPSDEFieldName().toUpperCase(), serializable2);
            if (DataObject.getIntegerValue((Object)serializable2.getPKey(), (Integer)0) != 1) continue;
            bl = true;
        }
        ArrayList<PSSysDBColumn> arrayList2 = pSSysDBTable.getPSSysDBColumns();
        HashMap<String, PSSysDBColumn> hashMap2 = new HashMap<String, PSSysDBColumn>();
        Object object = arrayList2.iterator();
        while (object.hasNext()) {
            PSSysDBColumn n = (PSSysDBColumn)object.next();
            if (StringHelper.isNullOrEmpty((String)n.getPSSysDBColumnName()) || hashMap.containsKey(string = n.getPSSysDBColumnName().toUpperCase())) continue;
            hashMap2.put(string, n);
        }
        object = new ArrayList();
        int n = DataObject.getIntegerValue((Object)pSDETable.getColInheritMode(), (Integer)1);
        string = pSDETable.getColumns();
        if (!StringHelper.isNullOrEmpty((String)string)) {
            string = string.replace(" ", "").toUpperCase();
            stringArray = (string = string.trim()).split("[;]");
            if (stringArray != null) {
                for (String string2 : stringArray) {
                    if (StringHelper.isNullOrEmpty((String)string2)) continue;
                    if (n == 1) {
                        hashMap2.remove(string2);
                        continue;
                    }
                    PSSysDBColumn pSSysDBColumn = (PSSysDBColumn)hashMap2.get(string2);
                    if (pSSysDBColumn == null) continue;
                    ((ArrayList)object).add(pSSysDBColumn);
                }
            }
        }
        if (n == 1) {
            ((ArrayList)object).addAll(hashMap2.values());
        }
        stringArray = (String[])ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        String[] stringArray2 = ((ArrayList)object).iterator();
        while (stringArray2.hasNext()) {
            PSSysDBColumn pSSysDBColumn = (PSSysDBColumn)stringArray2.next();
            PSDEField pSDEField = new PSDEField();
            pSDEField.setPSDEId(pSDETable.getPSDEId());
            pSDEField.setPSDEName(pSDETable.getPSDEName());
            pSDEField.setPSDETableId(pSDETable.getPSDETableId());
            pSDEField.setPSSysDBColumnId(pSSysDBColumn.getPSSysDBColumnId());
            pSDEField.setDEFType(1);
            pSDEField.setPSDEFieldName(pSSysDBColumn.getPSSysDBColumnName().toUpperCase());
            if (!StringHelper.isNullOrEmpty((String)pSSysDBColumn.getLogicName())) {
                pSDEField.setLogicName(pSSysDBColumn.getLogicName());
            } else {
                pSDEField.setLogicName(pSSysDBColumn.getPSSysDBColumnName());
            }
            if (!StringHelper.isNullOrEmpty((String)pSSysDBColumn.getCodeName())) {
                pSDEField.setCodeName(pSSysDBColumn.getCodeName());
            } else {
                pSDEField.setCodeName(pSSysDBColumn.getPSSysDBColumnName());
            }
            pSDEField.setAllowEmpty(DataObject.getIntegerValue((Object)pSSysDBColumn.getAllowEmpty(), (Integer)1));
            Integer n2 = pSSysDBColumn.getStdDataType();
            if (n2 == null || n2 == 0) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u636e\u5217[%1$s]\u6570\u636e\u7c7b\u578b", (Object)pSSysDBColumn.getPSSysDBColumnName()));
            }
            int n3 = DataObject.getIntegerValue((Object)pSSysDBColumn.getLength(), (Integer)-1);
            int n4 = DataObject.getIntegerValue((Object)pSSysDBColumn.getPrecision2(), (Integer)-1);
            PSDEFDataTypeHelper.fillPSDEField(pSDEField, n2, n3, n4);
            if (!bl && DataObject.getIntegerValue((Object)pSSysDBColumn.getPKey(), (Integer)0) == 1) {
                pSDEField.setPKey(1);
                bl = true;
            }
            try {
                if (DataObject.getBoolValue((Integer)pSSysDBColumn.getFKey(), (boolean)false) && !StringHelper.isNullOrEmpty((String)pSSysDBColumn.getRefPSSysDBTableId())) {
                    PSDETable pSDETable2 = null;
                    PSDETableService pSDETableService = (PSDETableService)ServiceGlobal.getService(PSDETableService.class, (SessionFactory)this.getSessionFactory());
                    PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                    SelectCond selectCond = new SelectCond();
                    selectCond.set("PSSYSDBTABLEID", (Object)pSSysDBColumn.getRefPSSysDBTableId());
                    selectCond.setOrderInfo("ORDER BY PSDETABLENAME");
                    selectCond.setMaxRowCount(1);
                    ArrayList arrayList3 = pSDETableService.select((ISelectCond)selectCond);
                    if (arrayList3.size() > 0) {
                        pSDETable2 = (PSDETable)arrayList3.get(0);
                    }
                    if (pSDETable2 == null) {
                        log.warn((Object)String.format("\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u8868[%1$s]\u76f8\u5173\u7684\u5b9e\u4f53", pSSysDBColumn.getRefPSSysDBTableName()));
                        continue;
                    }
                    PSDER pSDER = new PSDER();
                    pSDER.setDERType("DER1N");
                    pSDER.setMajorPSDEId(pSDETable2.getPSDEId());
                    pSDER.setMajorPSDEName(pSDETable2.getPSDEName());
                    pSDER.setMinorPSDEId(pSDETable.getPSDEId());
                    pSDER.setMinorPSDEName(pSDETable.getPSDEName());
                    pSDER.setDERFieldName(pSSysDBColumn.getPSSysDBColumnName());
                    pSDER.setRemoveActionType(0);
                    pSDERService.create(pSDER);
                    continue;
                }
                stringArray.create(pSDEField);
            }
            catch (Exception exception) {
                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5c5e\u6027[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)pSDEField.getPSDEFieldName(), (Object)exception.getMessage()), exception);
            }
        }
    }
}

