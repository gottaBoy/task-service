/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.DBFetchResult
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
package net.ibizsys.pscore.srv.config.service;

import java.io.File;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.PSCoreSysServiceBaseBase;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeFolder;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeTempl;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeType;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleVer;
import net.ibizsys.pscore.srv.config.entity.PSSFVerCode;
import net.ibizsys.pscore.srv.config.entity.PSSFVerCodeBase;
import net.ibizsys.pscore.srv.config.entity.PSSFVerCodeItem;
import net.ibizsys.pscore.srv.config.entity.PSSFVerCodeItemBase;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFCodeTypeService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleVerServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFVerCodeItemService;
import net.ibizsys.pscore.srv.config.service.PSSFVerCodeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSFStyleVerService
extends PSSFStyleVerServiceBase {
    private static final Log log = LogFactory.getLog(PSSFStyleVerService.class);
    public static final String PARAM_PRJFOLDER = "SRFPRJFOLDER";

    @Override
    protected void onPublish(PSSFStyleVer pSSFStyleVer) throws Exception {
        this.executeRemoteCall2All("PUBLISHSTYLE", (IEntity)pSSFStyleVer);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    protected void onImpStyleVer(PSSFStyleVer pSSFStyleVer) throws Exception {
        Serializable serializable;
        Object object;
        Serializable serializable222;
        String string = DataObject.getStringValue((Object)pSSFStyleVer.get(PARAM_PRJFOLDER));
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u5f53\u524d\u6ca1\u6709\u6307\u5b9a\u9879\u76ee\u76ee\u5f55");
        }
        this.get((IEntity)pSSFStyleVer);
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSSFSTYLEID", (Object)pSSFStyleVer.getPSSFStyleId());
        PSSFCodeTypeService pSSFCodeTypeService = (PSSFCodeTypeService)ServiceGlobal.getService(PSSFCodeTypeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList arrayList = pSSFCodeTypeService.select((ISelectCond)selectCond);
        HashMap<String, Serializable> hashMap = new HashMap<String, Serializable>();
        for (Serializable serializable222 : arrayList) {
            if (!DataObject.getBoolValue((Integer)((PSSFCodeTypeBase)serializable222).getValidFlag(), (boolean)true)) continue;
            hashMap.put(((PSSFCodeTypeBase)serializable222).getTypeCode().toUpperCase(), serializable222);
            hashMap.put(((PSSFCodeTypeBase)serializable222).getPSSFCodeTypeId(), serializable222);
        }
        HashMap hashMap2 = new HashMap();
        serializable222 = pSSFStyleVer.getPSSFVerCodes();
        Object object2 = ((ArrayList)serializable222).iterator();
        while (object2.hasNext()) {
            object = (PSSFVerCode)object2.next();
            serializable = (PSSFCodeType)hashMap.get(((PSSFVerCodeBase)object).getPSSFCodeTypeId());
            if (serializable == null) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u670d\u52a1\u4ee3\u7801\u6a21\u677f[%1$s][%2$s]", (Object)((PSSFVerCodeBase)object).getPSSFCodeTypeId(), (Object)((PSSFVerCodeBase)object).getPSSFCodeTypeName()));
            }
            hashMap2.put(((PSSFCodeTypeBase)serializable).getTypeCode().toUpperCase(), object);
        }
        object2 = (PSSFVerCodeService)ServiceGlobal.getService(PSSFVerCodeService.class, (SessionFactory)this.getSessionFactory());
        object = (PSSFVerCodeItemService)ServiceGlobal.getService(PSSFVerCodeItemService.class, (SessionFactory)this.getSessionFactory());
        serializable = new File(string);
        if (!((File)serializable).exists()) {
            ((File)serializable).mkdirs();
        }
        try {
            File[] fileArray;
            for (File file : fileArray = ((File)serializable).listFiles()) {
                if (file.isDirectory()) {
                    Object object3;
                    void var23_33;
                    String string2 = file.getName();
                    PSSFCodeType pSSFCodeType = (PSSFCodeType)hashMap.get(string2.toUpperCase());
                    if (pSSFCodeType == null) {
                        throw new Exception(StringHelper.format((String)"\u5f53\u524d\u670d\u52a1\u4ee3\u7801\u6846\u67b6[%1$s]\u4e0d\u5b58\u5728\u4ee3\u7801\u7c7b\u578b[%2$s]", (Object)pSSFStyleVer.getPSSFStyleName(), (Object)string2.toUpperCase()));
                    }
                    HashMap<String, File> hashMap3 = new HashMap<String, File>();
                    for (File file2 : file.listFiles()) {
                        if (!file2.isFile()) continue;
                        hashMap3.put(file2.getName().toUpperCase(), file2);
                    }
                    Object object4 = "";
                    if (!StringHelper.isNullOrEmpty((String)pSSFCodeType.getFileExt())) {
                        object4 = "." + pSSFCodeType.getFileExt();
                    }
                    File file3 = null;
                    file3 = StringHelper.isNullOrEmpty((String)object4) ? (File)hashMap3.remove("MAIN") : (File)hashMap3.remove("MAIN" + ((String)object4).toUpperCase());
                    if (file3 == null) continue;
                    int n = 0;
                    PSSFVerCode pSSFVerCode = (PSSFVerCode)hashMap2.remove(pSSFCodeType.getTypeCode().toUpperCase());
                    HashMap<String, Object> hashMap4 = new HashMap<String, Object>();
                    if (pSSFVerCode == null) {
                        n = 1;
                        PSSFVerCode pSSFVerCode2 = new PSSFVerCode();
                        pSSFVerCode2.setPSSFVerCodeName(pSSFCodeType.getPSSFCodeTypeName());
                        pSSFVerCode2.setPSSFStyleVerId(pSSFStyleVer.getPSSFStyleVerId());
                        pSSFVerCode2.setPSSFStyleVerName(pSSFStyleVer.getPSSFStyleVerName());
                        pSSFVerCode2.setPSSFCodeTypeId(pSSFCodeType.getPSSFCodeTypeId());
                        pSSFVerCode2.setPSSFCodeTypeName(pSSFCodeType.getPSSFCodeTypeName());
                    }
                    String string3 = PSPFStyleService.readFile(file3.getAbsolutePath());
                    var23_33.setCodeTempl(string3);
                    var23_33.setTemplCode2(string3);
                    if (n != 0) {
                        ((PSCoreSysServiceBaseBase)((Object)object2)).create(var23_33);
                    } else {
                        ((PSCoreSysServiceBaseBase)((Object)object2)).update(var23_33);
                        Iterator iterator = var23_33.getPSSFVerCodeItems();
                        Map.Entry entry = ((ArrayList)((Object)iterator)).iterator();
                        while (entry.hasNext()) {
                            object3 = entry.next();
                            hashMap4.put(((PSSFVerCodeItemBase)object3).getPSSFVerCodeItemName().toUpperCase(), object3);
                        }
                    }
                    for (Map.Entry entry : hashMap3.entrySet()) {
                        object3 = (String)entry.getKey();
                        if (!StringHelper.isNullOrEmpty((String)object4)) {
                            if (((String)object3).indexOf(((String)object4).toUpperCase()) != ((String)object3).length() - ((String)object4).length()) continue;
                            object3 = ((String)object3).substring(0, ((String)object3).length() - ((String)object4).length());
                        }
                        n = 0;
                        PSSFVerCodeItem pSSFVerCodeItem = (PSSFVerCodeItem)hashMap4.remove(object3);
                        if (pSSFVerCodeItem == null) {
                            n = 1;
                            pSSFVerCodeItem = new PSSFVerCodeItem();
                            pSSFVerCodeItem.setPSSFStyleVerId(pSSFStyleVer.getPSSFStyleVerId());
                            pSSFVerCodeItem.setPSSFVerCodeId(var23_33.getPSSFVerCodeId());
                            pSSFVerCodeItem.setPSSFVerCodeItemName((String)object3);
                        }
                        string3 = PSPFStyleService.readFile(((File)entry.getValue()).getAbsolutePath());
                        pSSFVerCodeItem.setTemplCode2(string3);
                        pSSFVerCodeItem.setTemplCode(string3);
                        if (n != 0) {
                            ((PSCoreSysServiceBaseBase)((Object)object)).create(pSSFVerCodeItem);
                            continue;
                        }
                        ((PSCoreSysServiceBaseBase)((Object)object)).update(pSSFVerCodeItem);
                    }
                    for (Map.Entry entry : hashMap4.entrySet()) {
                        object.remove((IEntity)entry.getValue());
                    }
                }
                for (Map.Entry entry : hashMap2.entrySet()) {
                    object2.remove((IEntity)entry.getValue());
                }
            }
            String string4 = pSSFStyleVer.getPSSFStyleVerId();
            pSSFStyleVer.reset();
            pSSFStyleVer.setPSSFStyleVerId(string4);
            pSSFStyleVer.setLastImpTime(new Timestamp(System.currentTimeMillis()));
            pSSFStyleVer.setTemplState(30);
            pSSFStyleVer.setTemplInfo(null);
            this.update(pSSFStyleVer);
        }
        catch (Exception exception) {
            String string4 = pSSFStyleVer.getPSSFStyleVerId();
            pSSFStyleVer.reset();
            pSSFStyleVer.setPSSFStyleVerId(string4);
            pSSFStyleVer.setTemplInfo(exception.getMessage());
            pSSFStyleVer.setTemplState(40);
            this.update(pSSFStyleVer);
        }
    }

    @Override
    protected void onExpStyleVer(PSSFStyleVer pSSFStyleVer) throws Exception {
        String string = DataObject.getStringValue((Object)pSSFStyleVer.get(PARAM_PRJFOLDER));
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u5f53\u524d\u6ca1\u6709\u6307\u5b9a\u9879\u76ee\u76ee\u5f55");
        }
        this.get((IEntity)pSSFStyleVer);
        File file = new File(string);
        if (!file.exists()) {
            file.mkdirs();
        }
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSSFSTYLEVERID", (Object)pSSFStyleVer.getPSSFStyleVerId());
        PSSFVerCodeService pSSFVerCodeService = (PSSFVerCodeService)ServiceGlobal.getService(PSSFVerCodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList arrayList = pSSFVerCodeService.select((ISelectCond)selectCond);
        for (PSSFVerCode pSSFVerCode : arrayList) {
            PSSFCodeType pSSFCodeType = pSSFVerCode.getPSSFCodeType();
            String string2 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string, (Object)File.separator, (Object)pSSFCodeType.getTypeCode());
            file = new File(string2);
            if (!file.exists()) {
                file.mkdirs();
            }
            String string3 = null;
            string3 = StringHelper.isNullOrEmpty((String)pSSFCodeType.getFileExt()) ? StringHelper.format((String)"%1$s", (Object)"MAIN") : StringHelper.format((String)"%1$s.%2$s", (Object)"MAIN", (Object)pSSFCodeType.getFileExt());
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            PSPFStyleService.writeFile(string4, pSSFVerCode.getTemplCode2());
            ArrayList<PSSFVerCodeItem> arrayList2 = pSSFVerCode.getPSSFVerCodeItems();
            for (PSSFVerCodeItem pSSFVerCodeItem : arrayList2) {
                string3 = null;
                string3 = StringHelper.isNullOrEmpty((String)pSSFCodeType.getFileExt()) ? StringHelper.format((String)"%1$s", (Object)pSSFVerCodeItem.getPSSFVerCodeItemName()) : StringHelper.format((String)"%1$s.%2$s", (Object)pSSFVerCodeItem.getPSSFVerCodeItemName(), (Object)pSSFCodeType.getFileExt());
                string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                PSPFStyleService.writeFile(string4, pSSFVerCodeItem.getTemplCode2());
            }
        }
    }

    @Override
    protected void onFixStyleVer(PSSFStyleVer pSSFStyleVer) throws Exception {
        Object object;
        Serializable serializable;
        this.get((IEntity)pSSFStyleVer);
        ArrayList<PSSFVerCode> arrayList = pSSFStyleVer.getPSSFVerCodes();
        HashMap<Object, Serializable> hashMap = new HashMap<Object, Serializable>();
        Object object2 = arrayList.iterator();
        while (object2.hasNext()) {
            serializable = object2.next();
            object = ((PSSFVerCodeBase)serializable).getTypeCode();
            if (DataObject.getBoolValue((Integer)((PSSFVerCodeBase)serializable).getEnableCustomTypeCode(), (boolean)false)) {
                object = ((PSSFVerCodeBase)serializable).getCustomTypeCode();
            }
            hashMap.put(object, serializable);
        }
        for (object2 = pSSFStyleVer.getPSSFStyle(); object2 != null; object2 = ((PSSFStyleBase)object2).getPPSSFStyle()) {
            serializable = ((PSSFStyleBase)object2).getPSSFCodeFolders();
            object = ((ArrayList)serializable).iterator();
            while (object.hasNext()) {
                PSSFCodeFolder pSSFCodeFolder = (PSSFCodeFolder)object.next();
                if (!DataObject.getBoolValue((Integer)pSSFCodeFolder.getPubFlag(), (boolean)false)) continue;
                ArrayList<PSSFCodeType> arrayList2 = pSSFCodeFolder.getPSSFCodeTypes();
                for (PSSFCodeType pSSFCodeType : arrayList2) {
                    if (hashMap.containsKey(pSSFCodeType.getTypeCode()) || !DataObject.getBoolValue((Integer)pSSFCodeType.getValidFlag(), (boolean)true)) continue;
                    PSSFVerCode pSSFVerCode = new PSSFVerCode();
                    pSSFVerCode.setSessionFactory(this.getSessionFactory());
                    pSSFVerCode.setPSSFStyleVerId(pSSFStyleVer.getPSSFStyleVerId());
                    pSSFVerCode.setPSSFStyleVerName(pSSFStyleVer.getPSSFStyleVerName());
                    pSSFVerCode.setPSSFVerCodeName(pSSFCodeType.getPSSFCodeTypeName());
                    pSSFVerCode.setPSSFCodeTypeId(pSSFCodeType.getPSSFCodeTypeId());
                    pSSFVerCode.setPSSFCodeTypeName(pSSFCodeType.getPSSFCodeTypeName());
                    pSSFVerCode.setRealPSSFStyleId(((PSSFStyleBase)object2).getPSSFStyleId());
                    pSSFVerCode.setCustomTypeCode(pSSFCodeType.getTypeCode());
                    pSSFVerCode.setValidFlag(1);
                    pSSFVerCode.setCodeTempl(pSSFCodeType.getCodeTempl());
                    pSSFVerCode.setTemplCode2(pSSFCodeType.getTemplCode2());
                    try {
                        pSSFVerCode.create();
                        ArrayList<PSSFCodeTempl> arrayList3 = pSSFCodeType.getPSSFCodeTempls();
                        for (PSSFCodeTempl pSSFCodeTempl : arrayList3) {
                            if (!DataObject.getBoolValue((Integer)pSSFCodeTempl.getValidFlag(), (boolean)true)) continue;
                            PSSFVerCodeItem pSSFVerCodeItem = new PSSFVerCodeItem();
                            pSSFVerCodeItem.setSessionFactory(this.getSessionFactory());
                            pSSFVerCodeItem.setPSSFVerCodeId(pSSFVerCode.getPSSFVerCodeId());
                            pSSFVerCodeItem.setPSSFVerCodeName(pSSFVerCode.getPSSFVerCodeName());
                            pSSFVerCodeItem.setTemplCode(pSSFCodeTempl.getTemplCode());
                            pSSFVerCodeItem.setTemplCode2(pSSFCodeTempl.getTemplCode2());
                            pSSFVerCodeItem.setPSSFVerCodeItemName(pSSFCodeTempl.getPSSFCodeTemplName());
                            pSSFVerCodeItem.create();
                        }
                        hashMap.put(pSSFCodeType.getTypeCode(), pSSFVerCode);
                    }
                    catch (Exception exception) {
                        throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u7cfb\u7edf\u670d\u52a1\u6269\u5c55\u4ee3\u7801\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
                    }
                }
            }
        }
    }

    @Override
    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSSFStyleVerService pSSFStyleVerService = (PSSFStyleVerService)ServiceGlobal.getService(PSSFStyleVerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSSFStyleVerService.fetchDefault(iDEDataSetFetchContext);
        }
        return super.fetchDefault(iDEDataSetFetchContext);
    }

    @Override
    public DBFetchResult fetchCurDCAndStyle(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSSFStyleVerService pSSFStyleVerService = (PSSFStyleVerService)ServiceGlobal.getService(PSSFStyleVerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSSFStyleVerService.fetchCurDCAndStyle(iDEDataSetFetchContext);
        }
        return super.fetchCurDCAndStyle(iDEDataSetFetchContext);
    }

    @Override
    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSSFStyleVerService pSSFStyleVerService = (PSSFStyleVerService)ServiceGlobal.getService(PSSFStyleVerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSSFStyleVerService.fetchCurDC(iDEDataSetFetchContext);
        }
        return super.fetchCurDC(iDEDataSetFetchContext);
    }

    @Override
    public DBFetchResult fetchCurStyle(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSSFStyleVerService pSSFStyleVerService = (PSSFStyleVerService)ServiceGlobal.getService(PSSFStyleVerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSSFStyleVerService.fetchCurStyle(iDEDataSetFetchContext);
        }
        return super.fetchCurStyle(iDEDataSetFetchContext);
    }
}

