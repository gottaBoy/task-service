/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDBIdxField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDBIdxFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDBIndex;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDBIdxFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDBIndexServiceBase;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEDBIndexService
extends PSDEDBIndexServiceBase {
    private static final Log log = LogFactory.getLog(PSDEDBIndexService.class);

    @Override
    protected void onAfterCreate(PSDEDBIndex pSDEDBIndex) throws Exception {
        super.onAfterCreate(pSDEDBIndex);
    }

    @Override
    protected void onAfterUpdate(PSDEDBIndex pSDEDBIndex) throws Exception {
        super.onAfterUpdate(pSDEDBIndex);
    }

    protected void rebuildPSDEDBIdxFields(PSDEDBIndex pSDEDBIndex) throws Exception {
        String string;
        PSDEDBIdxField field;
        String string2;
        String string3;
        PSDEDBIdxFieldService pSDEDBIdxFieldService = (PSDEDBIdxFieldService)ServiceGlobal.getService(PSDEDBIdxFieldService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDBIdxField> arrayList = pSDEDBIdxFieldService.selectByPSDEDBIndex(pSDEDBIndex);
        HashMap<String, PSDEDBIdxField> hashMap = new HashMap<String, PSDEDBIdxField>();
        HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
        for (PSDEDBIdxField object22 : arrayList) {
            hashMap.put(object22.getPSDEFId(), object22);
        }
        String string32 = pSDEDBIndex.getIndexFields();
        if (!StringHelper.isNullOrEmpty((String)string32)) {
            JSONArray jSONArray = JSONArray.fromString((String)string32);
            for (int i = 0; i < jSONArray.length(); ++i) {
                JSONObject jSONObject = (JSONObject)jSONArray.get(i);
                string3 = jSONObject.getString("srfkey");
                string2 = jSONObject.getString("srfmajortext");
                field = hashMap.remove(string3);
                if (field != null) {
                    if (DataObject.getBoolValue((Integer)field.getIncMode(), (boolean)false)) {
                        field.setIncMode(0);
                        pSDEDBIdxFieldService.update(field);
                    }
                } else {
                    field = new PSDEDBIdxField();
                    field.setPSDEFId(string3);
                    field.setPSDEFName(string2);
                    field.setPSDEDBIndexId(pSDEDBIndex.getPSDEDBIndexId());
                    field.setPSDEDBIndexName(pSDEDBIndex.getPSDEDBIndexName());
                    field.setIncMode(0);
                    field.setPSDEDBIdxFieldName(string2);
                    pSDEDBIdxFieldService.create(field);
                }
                hashMap2.put(field.getPSDEFId(), field);
            }
        }
        if (!StringHelper.isNullOrEmpty((String)(string = pSDEDBIndex.getIncFields()))) {
            JSONArray jSONArray = JSONArray.fromString((String)string);
            for (int i = 0; i < jSONArray.length(); ++i) {
                JSONObject jSONObject = (JSONObject)jSONArray.get(i);
                string2 = jSONObject.getString("srfkey");
                String fieldName = jSONObject.getString("srfmajortext");
                if (hashMap2.containsKey(string2)) {
                    throw new Exception(StringHelper.format((String)"\u5305\u542b\u5c5e\u6027[%1$s]\u5df2\u5b58\u5728\u7d22\u5f15\u5c5e\u6027\u4e2d", (Object)fieldName));
                }
                PSDEDBIdxField pSDEDBIdxField = (PSDEDBIdxField)hashMap.remove(string2);
                if (pSDEDBIdxField != null) {
                    if (!DataObject.getBoolValue((Integer)pSDEDBIdxField.getIncMode(), (boolean)false)) {
                        pSDEDBIdxField.setIncMode(1);
                        pSDEDBIdxFieldService.update(pSDEDBIdxField);
                    }
                } else {
                    pSDEDBIdxField = new PSDEDBIdxField();
                    pSDEDBIdxField.setPSDEFId(string2);
                    pSDEDBIdxField.setPSDEFName(fieldName);
                    pSDEDBIdxField.setPSDEDBIndexId(pSDEDBIndex.getPSDEDBIndexId());
                    pSDEDBIdxField.setPSDEDBIndexName(pSDEDBIndex.getPSDEDBIndexName());
                    pSDEDBIdxField.setIncMode(1);
                    pSDEDBIdxField.setPSDEDBIdxFieldName(fieldName);
                    pSDEDBIdxFieldService.create(pSDEDBIdxField);
                }
                hashMap2.put(pSDEDBIdxField.getPSDEFId(), pSDEDBIdxField);
            }
        }
        for (PSDEDBIdxField pSDEDBIdxField : hashMap.values()) {
            pSDEDBIdxFieldService.remove(pSDEDBIdxField);
        }
    }

    protected void onAfterUpdateTempMajor(PSDEDBIndex pSDEDBIndex) throws Exception {
        super.onAfterUpdateTempMajor(pSDEDBIndex);
        PSDEDBIdxFieldService pSDEDBIdxFieldService = (PSDEDBIdxFieldService)ServiceGlobal.getService(PSDEDBIdxFieldService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDBIdxField> arrayList = pSDEDBIdxFieldService.selectByPSDEDBIndex(pSDEDBIndex);
        String string = "";
        for (PSDEDBIdxField pSDEDBIdxField : arrayList) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + '\u3001';
            }
            string = string + pSDEDBIdxField.getPSDEDBIdxFieldName();
        }
        pSDEDBIndex.setIndexFields(string);
        this.internalUpdate(pSDEDBIndex);
        this.get(pSDEDBIndex);
    }
}
