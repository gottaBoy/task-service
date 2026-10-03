/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.IPSModelV2Service;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGroupDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGroupDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGroupServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelAttr;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEGroupService
extends PSDEGroupServiceBase {
    private static final Log log = LogFactory.getLog(PSDEGroupService.class);

    @Override
    protected void onInitModel(PSDEGroup pSDEGroup) throws Exception {
        this.get(pSDEGroup);
        if (StringHelper.isNullOrEmpty((String)pSDEGroup.getLogicMode()) || StringHelper.compare((String)pSDEGroup.getLogicMode(), (String)"INITMODEL", (boolean)false) == 0) {
            Object object;
            PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
            if (!StringHelper.isNullOrEmpty((String)pSDEGroup.getInitPSSysDynaModelId())) {
                pSSysDynaModel.setPSSysDynaModelId(pSDEGroup.getInitPSSysDynaModelId());
                if (!pSSysDynaModelService.get(pSSysDynaModel, true)) {
                    this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u5b9e\u4f53\u7ec4[%1$s]\u65e0\u6cd5\u6ce8\u5165\u6a21\u578b\uff0c\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u52a8\u6001\u6a21\u578b[%2$s]", (Object)pSDEGroup.getPSDEGroupName(), (Object)pSDEGroup.getInitPSSysDynaModelId()), false);
                    return;
                }
            } else {
                object = pSDEGroup.getUserTag();
                if (StringHelper.isNullOrEmpty((String)object)) {
                    this.sendStudioConsole(true, "WARN", StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u521d\u59cb\u5316\u6a21\u578b"), false);
                    return;
                }
                String string = this.getCurrentPSSystemId(pSDEGroup);
                if (StringHelper.isNullOrEmpty((String)string)) {
                    log.warn((Object)StringHelper.format((String)"\u5f53\u524d\u7cfb\u7edf\u6807\u8bc6\u65e0\u6548"));
                    return;
                }
                pSSysDynaModel.setPSSystemId(string);
                pSSysDynaModel.setCodeName((String)object);
                if (!pSSysDynaModelService.select(pSSysDynaModel, true)) {
                    this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u5b9e\u4f53\u7ec4[%1$s]\u65e0\u6cd5\u6ce8\u5165\u6a21\u578b\uff0c\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u52a8\u6001\u6a21\u578b[%2$s]", (Object)pSDEGroup.getPSDEGroupName(), (Object)object), false);
                    return;
                }
            }
            ArrayList<PSSysDynaModelAttr> attrs = new ArrayList<PSSysDynaModelAttr>();
            attrs.addAll(pSSysDynaModel.getPSSysDynaModelAttrs());
            Collections.sort(attrs, new Comparator<PSSysDynaModelAttr>(){

                @Override
                public int compare(PSSysDynaModelAttr pSSysDynaModelAttr, PSSysDynaModelAttr pSSysDynaModelAttr2) {
                    return StringHelper.compare((String)pSSysDynaModelAttr.getPSSysDynaModelAttrName(), (String)pSSysDynaModelAttr2.getPSSysDynaModelAttrName(), (boolean)false);
                }
            });
            for (PSDEGroupDetail pSDEGroupDetail : pSDEGroup.getPSDEGroupDetails()) {
                if (this.initDEModel(pSDEGroupDetail, attrs, pSSysDynaModel)) continue;
                return;
            }
            return;
        }
        if (StringHelper.compare((String)pSDEGroup.getLogicMode(), (String)"SYNCMODEL", (boolean)false) == 0) {
            this.syncSameStorageDEModel(pSDEGroup);
            return;
        }
    }

    protected boolean initDEModel(PSDEGroupDetail pSDEGroupDetail, ArrayList<PSSysDynaModelAttr> arrayList, PSSysDynaModel pSSysDynaModel) throws Exception {
        this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5f00\u59cb\u6ce8\u5165\u5b9e\u4f53\u6a21\u578b[%1$s]", (Object)pSDEGroupDetail.getPSDEName()), false);
        for (PSSysDynaModelAttr pSSysDynaModelAttr : arrayList) {
            if (StringHelper.isNullOrEmpty((String)pSSysDynaModelAttr.getPSSysDynaModelAttrName()) || !DataObject.getBoolValue((Integer)pSSysDynaModelAttr.getValidFlag(), (boolean)true)) continue;
            String[] stringArray = pSSysDynaModelAttr.getPSSysDynaModelAttrName().trim().split("[/]");
            if (stringArray.length < 3) {
                this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u52a8\u6001\u6a21\u578b\u5c5e\u6027[%1$s]\u683c\u5f0f\u4e0d\u6b63\u786e\uff0c\u65e0\u6cd5\u8fdb\u884c\u6a21\u578b\u6ce8\u5165", (Object)pSSysDynaModelAttr.getPSSysDynaModelAttrName()), false);
                return false;
            }
            if (!PSModelV2Helper.containsModelV2(stringArray[1])) {
                this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6a21\u578b\u7c7b\u578b[%1$s]", (Object)stringArray[1]), false);
                return false;
            }
            if (StringHelper.isNullOrEmpty((String)stringArray[2])) {
                this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6a21\u578b\u6807\u8bc6[%1$s]", (Object)stringArray[2]), false);
                return false;
            }
            ObjectNode objectNode = null;
            try {
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)pSSysDynaModelAttr.getAttrValue());
            }
            catch (Exception exception) {
                this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u52a8\u6001\u6a21\u578b\u5c5e\u6027[%1$s]\u503c\u4e0d\u6b63\u786e\uff0c%2$s", (Object)pSSysDynaModelAttr.getPSSysDynaModelAttrName(), (Object)exception.getMessage()), false);
                return false;
            }
            try {
                IDataEntityModel iDataEntityModel = this.getSystemModel().getDataEntityModel(stringArray[1], false);
                IPSModelV2Service iPSModelV2Service = (IPSModelV2Service)iDataEntityModel.getService(this.getSessionFactory());
                IEntity iEntity = iDataEntityModel.createEntity();
                if (!iPSModelV2Service.setModelV2ResScope(iEntity, "PSDATAENTITY", pSDEGroupDetail.getPSDEId())) {
                    this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u6a21\u578b[%1$s]\u4e0d\u5728\u5b9e\u4f53\u7684\u5bfc\u5165\u8303\u56f4\u4e2d", (Object)stringArray[1]), false);
                    return false;
                }
                if (iDataEntityModel.getDEField("CODENAME", true) != null) {
                    iEntity.set("CODENAME", (Object)stringArray[2]);
                } else {
                    iEntity.set(iDataEntityModel.getKeyDEField().getName(), (Object)stringArray[2]);
                }
                if (iPSModelV2Service.select(iEntity, true)) {
                    this.sendStudioConsole(true, "WARN", StringHelper.format((String)"\u6a21\u578b[%1$s][%2$s]\u5df2\u7ecf\u5b58\u5728\uff0c\u5ffd\u7565\u6ce8\u5165", (Object)stringArray[1], (Object)stringArray[2]), false);
                    continue;
                }
                iPSModelV2Service.importModelV2(iEntity, objectNode);
                this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u6ce8\u5165\u6a21\u578b[%1$s][%2$s]\u6210\u529f", (Object)stringArray[1], (Object)stringArray[2]), false);
            }
            catch (Exception exception) {
                this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u5904\u7406\u52a8\u6001\u6a21\u578b\u5c5e\u6027[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)pSSysDynaModelAttr.getPSSysDynaModelAttrName(), (Object)exception.getMessage()), false);
                return false;
            }
        }
        return true;
    }

    protected void syncSameStorageDEModel(PSDEGroup pSDEGroup) throws Exception {
        PSDEGroupDetailService pSDEGroupDetailService = (PSDEGroupDetailService)ServiceGlobal.getService(PSDEGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGroupDetail> arrayList = pSDEGroupDetailService.selectByPSDEGroup(pSDEGroup, "ORDER BY ORDERVALUE");
        if (arrayList.size() == 0) {
            this.sendStudioConsole(true, "WARN", StringHelper.format((String)"\u5b9e\u4f53\u7ec4[%1$s]\u672a\u5305\u542b\u4efb\u4f55\u6210\u5458\uff0c\u5ffd\u7565\u540c\u6b65", (Object)pSDEGroup.getPSDEGroupName()), false);
            return;
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        PSDataEntity pSDataEntity = pSDEGroup.getPSDE();
        if (pSDataEntity != null) {
            this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5b9e\u4f53\u7ec4[%1$s]\u9009\u62e9\u6240\u5c5e\u5b9e\u4f53[%2$s]\u4f5c\u4e3a\u57fa\u51c6\u5b9e\u4f53", (Object)pSDEGroup.getPSDEGroupName(), (Object)pSDataEntity.getPSDataEntityName()), false);
            if (!StringHelper.isNullOrEmpty((String)pSDEGroup.getLogicParam())) {
                String[] stringArray;
                for (String string : stringArray = pSDEGroup.getLogicParam().toUpperCase().split("[;]")) {
                    hashMap.put(string, "");
                }
            }
        } else {
            pSDataEntity = arrayList.remove(0).getPSDE();
            this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5b9e\u4f53\u7ec4[%1$s]\u9009\u62e9\u9996\u6210\u5458[%2$s]\u4f5c\u4e3a\u57fa\u51c6\u5b9e\u4f53", (Object)pSDEGroup.getPSDEGroupName(), (Object)pSDataEntity.getPSDataEntityName()), false);
            if (arrayList.size() == 0) {
                this.sendStudioConsole(true, "WARN", StringHelper.format((String)"\u5b9e\u4f53\u7ec4[%1$s]\u672a\u5305\u542b\u5176\u5b83\u6210\u5458\uff0c\u5ffd\u7565\u540c\u6b65", (Object)pSDEGroup.getPSDEGroupName()), false);
                return;
            }
        }
        for (PSDEGroupDetail pSDEGroupDetail : arrayList) {
            if (DataObject.getIntegerValue((Object)pSDEGroupDetail.getValidFlag(), (Integer)1) != 1 || this.syncSameStorageDEModel(pSDEGroup, pSDataEntity, hashMap, pSDEGroupDetail)) continue;
            return;
        }
    }

    protected boolean syncSameStorageDEModel(PSDEGroup pSDEGroup, PSDataEntity pSDataEntity, Map<String, String> map, PSDEGroupDetail pSDEGroupDetail) throws Exception {
        PSDER pSDER;
        int n;
        Object object;
        if (pSDEGroupDetail.getPSDE() == null) {
            this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u5b9e\u4f53\u7ec4\u6210\u5458[%1$s]\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53", (Object)pSDEGroupDetail.getPSDEGroupDetailName()), false);
            return false;
        }
        this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5f00\u59cb\u540c\u6b65\u5b9e\u4f53[%1$s]", (Object)pSDEGroupDetail.getPSDEName()), false);
        ArrayList<PSDEField> arrayList = pSDataEntity.getPSDEFields();
        ArrayList<PSDEField> arrayList2 = pSDEGroupDetail.getPSDE().getPSDEFields();
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        Object object2 = null;
        Object object3 = null;
        Object object4 = null;
        for (PSDEField field : arrayList2) {
            object = field;
            hashMap.put(((PSDEFieldBase)object).getPSDEFieldName(), object);
            int n2 = DataObject.getIntegerValue((Object)((PSDEFieldBase)object).getPKey(), (Integer)0);
            if (n2 == 1) {
                object2 = object;
            } else if (n2 == 2) {
                object3 = object;
            }
            if ((n = DataObject.getIntegerValue((Object)((PSDEFieldBase)object).getMajorField(), (Integer)0).intValue()) != 1) continue;
            object4 = object;
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEGroupDetail.getDetailParam())) {
            for (String object6 : pSDEGroupDetail.getDetailParam().toUpperCase().split("[;]")) {
                hashMap.put(object6, null);
            }
        }
        PSDEFieldService object5 = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEField pSDEField : arrayList) {
            if (hashMap.containsKey(pSDEField.getPSDEFieldName()) || map != null && map.containsKey(pSDEField.getPSDEFieldName()) || !StringHelper.isNullOrEmpty((String)pSDEField.getPSDERId()) || !StringHelper.isNullOrEmpty((String)pSDEField.getO2MPSDERId())) continue;
            n = DataObject.getIntegerValue((Object)pSDEField.getPKey(), (Integer)0);
            if (n == 1 && object2 != null) {
                hashMap.put(pSDEField.getPSDEFieldName(), object2);
                continue;
            }
            if (n == 2 && object3 != null) {
                hashMap.put(pSDEField.getPSDEFieldName(), object3);
                continue;
            }
            int n3 = DataObject.getIntegerValue((Object)pSDEField.getMajorField(), (Integer)0);
            if (n3 == 1 && object4 == null) {
                hashMap.put(pSDEField.getPSDEFieldName(), object4);
                continue;
            }
            PSDEField pSDEField2 = new PSDEField();
            pSDEField.copyTo((IDataObject)pSDEField2, false);
            pSDEField2.resetPSDEFieldId();
            pSDEField2.setPSDEId(pSDEGroupDetail.getPSDE().getPSDataEntityId());
            pSDEField2.setPSDEName(pSDEGroupDetail.getPSDE().getPSDataEntityName());
            try {
                ((PSCoreSysServiceBase)object5).create(pSDEField2, false);
                hashMap.put(pSDEField2.getPSDEFieldName(), pSDEField2);
            }
            catch (Exception exception) {
                this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u5c5e\u6027[%2$s]\u9519\u8bef\uff0c%3$s", (Object)pSDEGroupDetail.getPSDE().getPSDataEntityName(), (Object)pSDEField.getPSDEFieldName(), (Object)exception.getMessage()), false);
            }
        }
        object = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDER> arrayList3 = pSDataEntity.getMinorPSDERs();
        ArrayList<PSDER> arrayList4 = pSDEGroupDetail.getPSDE().getMinorPSDERs();
        HashMap<String, PSDER> hashMap2 = new HashMap<String, PSDER>();
        for (PSDER pSDER2 : arrayList4) {
            if (StringHelper.isNullOrEmpty((String)pSDER2.getDERFieldName()) || StringHelper.compare((String)pSDER2.getDERType(), (String)"DER1N", (boolean)false) != 0) continue;
            hashMap2.put(pSDER2.getDERFieldName().toUpperCase(), pSDER2);
        }
        for (PSDER pSDER3 : arrayList3) {
            if (StringHelper.isNullOrEmpty((String)pSDER3.getDERFieldName()) || StringHelper.compare((String)pSDER3.getDERType(), (String)"DER1N", (boolean)false) != 0) continue;
            if (hashMap2.containsKey(pSDER3.getDERFieldName().toUpperCase())) {
                hashMap2.put(pSDER3.getPSDERId(), (PSDER)hashMap2.get(pSDER3.getDERFieldName().toUpperCase()));
                continue;
            }
            if (hashMap.containsKey(pSDER3.getDERFieldName().toUpperCase()) || map != null && map.containsKey(pSDER3.getDERFieldName().toUpperCase())) continue;
            pSDER = new PSDER();
            pSDER3.copyTo((IDataObject)pSDER, false);
            pSDER.resetPSDERId();
            pSDER.resetPSDERName();
            pSDER.setMinorPSDEId(pSDEGroupDetail.getPSDE().getPSDataEntityId());
            pSDER.setMinorPSDEName(pSDEGroupDetail.getPSDE().getPSDataEntityName());
            try {
                ((PSCoreSysServiceBase)object).create(pSDER, true);
                hashMap2.put(pSDER.getDERFieldName().toUpperCase(), pSDER);
                hashMap2.put(pSDER3.getPSDERId(), pSDER);
                hashMap.put(pSDER3.getDERFieldName().toUpperCase(), null);
            }
            catch (Exception exception) {
                this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u5173\u7cfb[%2$s]\u9519\u8bef\uff0c%3$s", (Object)pSDEGroupDetail.getPSDE().getPSDataEntityName(), (Object)pSDER3.getPSDERName(), (Object)exception.getMessage()), false);
            }
        }
        for (PSDEField pSDEField : arrayList) {
            if (hashMap.containsKey(pSDEField.getPSDEFieldName()) || map != null && map.containsKey(pSDEField.getPSDEFieldName()) || StringHelper.isNullOrEmpty((String)pSDEField.getPSDERId()) || (pSDER = (PSDER)hashMap2.get(pSDEField.getPSDERId())) == null) continue;
            PSDEField pSDEField2 = new PSDEField();
            pSDEField.copyTo((IDataObject)pSDEField2, false);
            pSDEField2.resetPSDEFieldId();
            pSDEField2.setPSDEId(pSDEGroupDetail.getPSDE().getPSDataEntityId());
            pSDEField2.setPSDEName(pSDEGroupDetail.getPSDE().getPSDataEntityName());
            pSDEField2.setPSDERId(pSDER.getPSDERId());
            pSDEField2.setPSDERName(pSDER.getPSDERName());
            try {
                ((PSCoreSysServiceBase)object5).create(pSDEField2, false);
                hashMap.put(pSDEField2.getPSDEFieldName(), pSDEField2);
            }
            catch (Exception exception) {
                this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u5c5e\u6027[%2$s]\u9519\u8bef\uff0c%3$s", (Object)pSDEGroupDetail.getPSDE().getPSDataEntityName(), (Object)pSDEField.getPSDEFieldName(), (Object)exception.getMessage()), false);
            }
        }
        return true;
    }
}
