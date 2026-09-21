/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.config.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.PSCoreSysServiceBaseBase;
import net.ibizsys.pscore.srv.codelist.EditorContainersCodeListModel;
import net.ibizsys.pscore.srv.config.entity.PSCtrlType;
import net.ibizsys.pscore.srv.config.entity.PSCtrlTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSEditorType;
import net.ibizsys.pscore.srv.config.entity.PSEditorTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFAppTempl;
import net.ibizsys.pscore.srv.config.entity.PSPFAppTemplBase;
import net.ibizsys.pscore.srv.config.entity.PSPFCTDetail;
import net.ibizsys.pscore.srv.config.entity.PSPFCodeFolder;
import net.ibizsys.pscore.srv.config.entity.PSPFCodeFolderBase;
import net.ibizsys.pscore.srv.config.entity.PSPFCtrlTempl;
import net.ibizsys.pscore.srv.config.entity.PSPFCtrlTemplBase;
import net.ibizsys.pscore.srv.config.entity.PSPFEditorTempl;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCodeBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleCode;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleCodeBase;
import net.ibizsys.pscore.srv.config.entity.PSPFViewTempl;
import net.ibizsys.pscore.srv.config.entity.PSPFViewTemplBase;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeBase;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeService;
import net.ibizsys.pscore.srv.config.service.PSEditorTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFAppTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFCTDetailService;
import net.ibizsys.pscore.srv.config.service.PSPFCodeFolderService;
import net.ibizsys.pscore.srv.config.service.PSPFCtrlTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFEditorTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleCodeService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFViewTemplService;
import net.ibizsys.pscore.srv.config.service.PSViewTypeService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSPFStyleService
extends PSPFStyleServiceBase {
    private static final Log log = LogFactory.getLog(PSPFStyleService.class);
    public static final String PARAM_PRJFOLDER = "SRFPRJFOLDER";

    @Override
    protected void onBeforeCreate(PSPFStyle pSPFStyle) throws Exception {
        Object object;
        if (pSPFStyle.isPSDevCenterIdDirty() && !StringHelper.isNullOrEmpty((String)pSPFStyle.getPSDevCenterId())) {
            pSPFStyle.setPubMode(2);
            object = StringHelper.format((String)"%1$s@%2$s", (Object)pSPFStyle.getPSDevCenter().getDomainName(), (Object)pSPFStyle.getDCStyleCode());
            pSPFStyle.setStyleCode(((String)object).toUpperCase());
        }
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && !StringHelper.isNullOrEmpty((String)pSPFStyle.getPSDevCenterSVNId())) {
            object = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
            pSDevCenterSVN.setPSDevCenterSVNId(pSPFStyle.getPSDevCenterSVNId());
            pSDevCenterSVN.setRefObjType("PSPFSTYLE");
            pSDevCenterSVN.setRefObjId(pSPFStyle.getPSPFStyleId());
            pSDevCenterSVN.setRefObjName(pSPFStyle.getPSPFStyleName());
            ((PSDevCenterSVNServiceBase)object).bind(pSDevCenterSVN);
        }
        super.onBeforeCreate(pSPFStyle);
    }

    @Override
    protected void onBeforeUpdate(PSPFStyle pSPFStyle) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && pSPFStyle.isPSDevCenterSVNIdDirty()) {
            PSPFStyle pSPFStyle2 = (PSPFStyle)this.getLast((IEntity)pSPFStyle);
            if (StringHelper.isNullOrEmpty((String)pSPFStyle.getPSDevCenterSVNId())) {
                if (!StringHelper.isNullOrEmpty((String)pSPFStyle2.getPSDevCenterSVNId())) {
                    PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                    PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                    pSDevCenterSVN.setPSDevCenterSVNId(pSPFStyle2.getPSDevCenterSVNId());
                    pSDevCenterSVN.setRefObjType("PSPFSTYLE");
                    pSDevCenterSVN.setRefObjId(pSPFStyle2.getPSPFStyleId());
                    pSDevCenterSVN.setRefObjName(pSPFStyle2.getPSPFStyleName());
                    pSDevCenterSVNService.unbind(pSDevCenterSVN);
                }
            } else if (StringHelper.compare((String)pSPFStyle.getPSDevCenterSVNId(), (String)pSPFStyle2.getPSDevCenterSVNId(), (boolean)false) != 0) {
                PSDevCenterSVN pSDevCenterSVN;
                PSDevCenterSVNService pSDevCenterSVNService;
                if (!StringHelper.isNullOrEmpty((String)pSPFStyle2.getPSDevCenterSVNId())) {
                    pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                    pSDevCenterSVN = new PSDevCenterSVN();
                    pSDevCenterSVN.setPSDevCenterSVNId(pSPFStyle2.getPSDevCenterSVNId());
                    pSDevCenterSVN.setRefObjType("PSPFSTYLE");
                    pSDevCenterSVN.setRefObjId(pSPFStyle2.getPSPFStyleId());
                    pSDevCenterSVN.setRefObjName(pSPFStyle2.getPSPFStyleName());
                    pSDevCenterSVNService.unbind(pSDevCenterSVN);
                }
                if (!StringHelper.isNullOrEmpty((String)pSPFStyle.getPSDevCenterSVNId())) {
                    pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                    pSDevCenterSVN = new PSDevCenterSVN();
                    pSDevCenterSVN.setPSDevCenterSVNId(pSPFStyle.getPSDevCenterSVNId());
                    pSDevCenterSVN.setRefObjType("PSPFSTYLE");
                    pSDevCenterSVN.setRefObjId(pSPFStyle.getPSPFStyleId());
                    if (StringHelper.isNullOrEmpty((String)pSPFStyle.getPSPFStyleName())) {
                        pSDevCenterSVN.setRefObjName(pSPFStyle2.getPSPFStyleName());
                    } else {
                        pSDevCenterSVN.setRefObjName(pSPFStyle.getPSPFStyleName());
                    }
                    pSDevCenterSVNService.bind(pSDevCenterSVN);
                }
            }
        }
        super.onBeforeUpdate(pSPFStyle);
    }

    @Override
    protected void onBeforeRemove(PSPFStyle pSPFStyle) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            PSPFStyle pSPFStyle2 = (PSPFStyle)this.getLast((IEntity)pSPFStyle);
            if (StringHelper.isNullOrEmpty((String)pSPFStyle.getPSDevCenterSVNId()) && !StringHelper.isNullOrEmpty((String)pSPFStyle2.getPSDevCenterSVNId())) {
                PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                pSDevCenterSVN.setPSDevCenterSVNId(pSPFStyle2.getPSDevCenterSVNId());
                pSDevCenterSVN.setRefObjType("PSPFSTYLE");
                pSDevCenterSVN.setRefObjId(pSPFStyle2.getPSPFStyleId());
                pSDevCenterSVN.setRefObjName(pSPFStyle2.getPSPFStyleName());
                pSDevCenterSVNService.unbind(pSDevCenterSVN);
            }
        }
        super.onBeforeRemove(pSPFStyle);
    }

    @Override
    protected void onPublish(PSPFStyle pSPFStyle) throws Exception {
        this.executeRemoteCall2All("PUBLISHSTYLE", (IEntity)pSPFStyle);
    }

    @Override
    protected void onCheckEntity(boolean bl, PSPFStyle pSPFStyle, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        if (!bl) {
            for (PSPFStyle pSPFStyle2 = pSPFStyle.getTemplPSPFStyle(); pSPFStyle2 != null; pSPFStyle2 = pSPFStyle2.getTemplPSPFStyle()) {
                if (StringHelper.compare((String)pSPFStyle2.getPSPFStyleId(), (String)pSPFStyle.getPSPFStyleId(), (boolean)false) != 0) continue;
                throw new Exception("\u6a21\u677f\u6837\u5f0f\u5b58\u5728\u9012\u5f52");
            }
        }
        super.onCheckEntity(bl, pSPFStyle, bl2, bl3, entityError);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    protected void onImpStyle(PSPFStyle pSPFStyle) throws Exception {
        String string = DataObject.getStringValue((Object)pSPFStyle.get(PARAM_PRJFOLDER));
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u5f53\u524d\u6ca1\u6709\u6307\u5b9a\u9879\u76ee\u76ee\u5f55");
        }
        this.get((IEntity)pSPFStyle);
        PSPF pSPF = pSPFStyle.getPSPF();
        ArrayList<PSPFPubCode> arrayList = pSPF.getPSPFPubCodes();
        HashMap<String, PSPFPubCode> hashMap = new HashMap<String, PSPFPubCode>();
        HashMap<String, PSPFPubCode> hashMap2 = new HashMap<String, PSPFPubCode>();
        for (PSPFPubCode object2 : arrayList) {
            hashMap.put(object2.getPSPFPubCodeId(), object2);
            if (StringHelper.compare((String)object2.getTargetType(), (String)"VIEW", (boolean)false) != 0) continue;
            hashMap2.put(StringHelper.format((String)"%1$s%2$s", (Object)object2.getPSPFPubCodeName(), (Object)object2.getCodeEXT()).toUpperCase(), object2);
        }
        try {
            void var17_46;
            EntityBase entityBase;
            Object object;
            ArrayList<PSPFCTDetail> arrayList2;
            Object object2;
            Object object3;
            void var17_42;
            Serializable serializable;
            Object object4;
            Object object52;
            Object object6;
            void var16_33;
            Object object7;
            Object object82;
            Object object12 = (PSPFStyleCodeService)ServiceGlobal.getService(PSPFStyleCodeService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSPFStyleCode> arrayList3 = pSPFStyle.getPSPFStyleCodes();
            ArrayList<PSPFEditorTempl> arrayList4 = new HashMap<String, PSPFStyleCode>();
            for (Object object82 : arrayList3) {
                ((HashMap)((Object)arrayList4)).put(((PSPFStyleCodeBase)object82).getPSPFStyleCodeName().toUpperCase(), object82);
            }
            Object object9 = StringHelper.format((String)"%1$s%2$smacro", (Object)string, (Object)File.separator);
            object82 = new File((String)object9);
            if (!((File)object82).exists()) {
                ((File)object82).mkdirs();
            }
            File file = new File((String)object9);
            Object object10 = object7 = file.listFiles();
            int n = ((File[])object10).length;
            boolean bl = false;
            while (var16_33 < n) {
                File file2 = object10[var16_33];
                if (file2.isFile() && ((String)(object6 = file2.getName().toUpperCase())).indexOf(".TXT") == ((String)object6).length() - 4) {
                    object52 = PSPFStyleService.readFile(file2.getAbsolutePath());
                    object4 = ((String)object6).substring(0, ((String)object6).length() - 4);
                    serializable = (PSPFStyleCode)((HashMap)((Object)arrayList4)).get(object4);
                    if (serializable != null) {
                        ((HashMap)((Object)arrayList4)).remove(object4);
                        if (StringHelper.compare((String)object52, (String)((PSPFStyleCodeBase)serializable).getStyleCode(), (boolean)false) != 0) {
                            ((PSPFStyleCodeBase)serializable).setStyleCode((String)object52);
                            EntityBase.setIgnoreCheck((IEntity)serializable, (boolean)false);
                            ((PSCoreSysServiceBaseBase)((Object)object12)).update(serializable);
                        }
                    } else {
                        serializable = new PSPFStyleCode();
                        ((PSPFStyleCodeBase)serializable).setStyleCode((String)object52);
                        ((PSPFStyleCodeBase)serializable).setPSPFStyleId(pSPFStyle.getPSPFStyleId());
                        ((PSPFStyleCodeBase)serializable).setPSPFStyleName(pSPFStyle.getPSPFStyleName());
                        ((PSPFStyleCodeBase)serializable).setPSPFStyleCodeName((String)object4);
                        EntityBase.setIgnoreCheck((IEntity)serializable, (boolean)false);
                        ((PSCoreSysServiceBaseBase)((Object)object12)).create(serializable);
                    }
                }
                ++var16_33;
            }
            object10 = ((HashMap)((Object)arrayList4)).entrySet().iterator();
            while (object10.hasNext()) {
                Map.Entry entry = (Map.Entry)object10.next();
                log.debug((Object)StringHelper.format((String)"\u79fb\u9664\u6837\u5f0f\u5b8f\u6570\u636e[%1$s]", (Object)((PSPFStyleCode)entry.getValue()).getPSPFStyleCodeName()));
                object12.remove((IEntity)entry.getValue());
            }
            object12 = (PSViewTypeService)ServiceGlobal.getService(PSViewTypeService.class, (SessionFactory)this.getSessionFactory());
            PSPFViewTemplService pSPFViewTemplService = (PSPFViewTemplService)ServiceGlobal.getService(PSPFViewTemplService.class, (SessionFactory)this.getSessionFactory());
            arrayList4 = pSPFStyle.getPSPFViewTempls();
            object9 = new HashMap<String, PSPFViewTempl>();
            for (PSPFViewTempl pSPFViewTempl : arrayList4) {
                ((HashMap)object9).put(pSPFViewTempl.getPSPFViewTemplId(), pSPFViewTempl);
            }
            object82 = StringHelper.format((String)"%1$s%2$sview", (Object)string, (Object)File.separator);
            File file3 = new File((String)object82);
            if (!file3.exists()) {
                file3.mkdirs();
            }
            object7 = new File((String)object82);
            Object object11 = object10 = ((File)object7).listFiles();
            int n2 = ((Object)object11).length;
            boolean bl2 = false;
            while (var17_42 < n2) {
                object6 = object11[var17_42];
                if (((File)object6).isDirectory()) {
                    void var24_62;
                    object52 = ((File)object6).getName();
                    object4 = new PSViewType();
                    ((PSViewTypeBase)object4).setPSViewTypeId((String)object52);
                    if (!object12.get((IEntity)object4, true)) {
                        throw new Exception(StringHelper.format((String)"\u4e91\u5e73\u53f0\u4e0d\u5b58\u5728\u89c6\u56fe\u7c7b\u578b[%1$s]", (Object)object52));
                    }
                    serializable = new HashMap();
                    object3 = ((File)object6).listFiles();
                    int n3 = ((File[])object3).length;
                    boolean bl3 = false;
                    while (var24_62 < n3) {
                        File file4 = object3[var24_62];
                        if (file4.isFile()) {
                            ((HashMap)serializable).put(file4.getName().toUpperCase(), file4);
                        }
                        ++var24_62;
                    }
                    for (Map.Entry entry : hashMap2.entrySet()) {
                        void var25_71;
                        File file5 = (File)((HashMap)serializable).get(entry.getKey());
                        String string2 = "";
                        if (file5 != null) {
                            String string3 = PSPFStyleService.readFile(file5.getAbsolutePath());
                        }
                        PSPFViewTempl pSPFViewTempl = new PSPFViewTempl();
                        pSPFViewTempl.setPSPFId(pSPF.getPSPFId());
                        pSPFViewTempl.setPSPFName(pSPF.getPSPFName());
                        pSPFViewTempl.setPSPFPubCodeId(((PSPFPubCode)entry.getValue()).getPSPFPubCodeId());
                        pSPFViewTempl.setPSPFPubCodeName(((PSPFPubCode)entry.getValue()).getPSPFPubCodeName());
                        pSPFViewTempl.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
                        pSPFViewTempl.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
                        pSPFViewTempl.setPSViewTypeId(((PSViewTypeBase)object4).getPSViewTypeId());
                        pSPFViewTempl.setPSViewTypeName(((PSViewTypeBase)object4).getPSViewTypeName());
                        pSPFViewTempl.setTemplCode2((String)var25_71);
                        pSPFViewTemplService.fillEntityKeyValue(pSPFViewTempl, false);
                        if (pSPFViewTemplService.checkKey(pSPFViewTempl) == 0) {
                            for (object2 = pSPFStyle.getTemplPSPFStyle(); object2 != null; object2 = ((PSPFStyleBase)object2).getTemplPSPFStyle()) {
                                PSPFViewTempl pSPFViewTempl2 = new PSPFViewTempl();
                                pSPFViewTempl2.setPSPFId(pSPF.getPSPFId());
                                pSPFViewTempl2.setPSPFName(pSPF.getPSPFName());
                                pSPFViewTempl2.setPSPFPubCodeId(((PSPFPubCode)entry.getValue()).getPSPFPubCodeId());
                                pSPFViewTempl2.setPSPFPubCodeName(((PSPFPubCode)entry.getValue()).getPSPFPubCodeName());
                                pSPFViewTempl2.setPSPFStyleId(((PSPFStyleBase)object2).getPSPFStyleId());
                                pSPFViewTempl2.setPSPFStyleName(((PSPFStyleBase)object2).getPSPFStyleName());
                                pSPFViewTempl2.setPSViewTypeId(((PSViewTypeBase)object4).getPSViewTypeId());
                                pSPFViewTempl2.setPSViewTypeName(((PSViewTypeBase)object4).getPSViewTypeName());
                                pSPFViewTemplService.fillEntityKeyValue(pSPFViewTempl2, false);
                                if (!pSPFViewTemplService.get((IEntity)pSPFViewTempl2, true)) continue;
                                pSPFViewTempl.setPubObj(pSPFViewTempl2.getPubObj());
                                pSPFViewTempl.setLogicName(pSPFViewTempl2.getLogicName());
                                break;
                            }
                            EntityBase.setIgnoreCheck((IEntity)pSPFViewTempl, (boolean)false);
                            pSPFViewTemplService.create(pSPFViewTempl);
                        } else {
                            EntityBase.setIgnoreCheck((IEntity)pSPFViewTempl, (boolean)false);
                            pSPFViewTemplService.update(pSPFViewTempl);
                        }
                        ((HashMap)object9).remove(pSPFViewTempl.getPSPFViewTemplId());
                    }
                }
                ++var17_42;
            }
            for (Map.Entry entry : ((HashMap)object9).entrySet()) {
                log.debug((Object)StringHelper.format((String)"\u79fb\u9664\u89c6\u56fe\u6a21\u677f[%1$s]", (Object)((PSPFViewTempl)entry.getValue()).getPSPFViewTemplName()));
                pSPFViewTemplService.remove((IEntity)entry.getValue());
            }
            object12 = (PSCtrlTypeService)ServiceGlobal.getService(PSCtrlTypeService.class, (SessionFactory)this.getSessionFactory());
            PSPFCtrlTemplService pSPFCtrlTemplService = (PSPFCtrlTemplService)ServiceGlobal.getService(PSPFCtrlTemplService.class, (SessionFactory)this.getSessionFactory());
            arrayList4 = (PSPFCTDetailService)ServiceGlobal.getService(PSPFCTDetailService.class, (SessionFactory)this.getSessionFactory());
            object9 = pSPFStyle.getPSPFCtrlTempls();
            object82 = new HashMap<String, Object>();
            Iterator iterator = ((ArrayList)object9).iterator();
            while (iterator.hasNext()) {
                object7 = (PSPFCtrlTempl)iterator.next();
                ((HashMap)object82).put(((PSPFCtrlTemplBase)object7).getPSPFCtrlTemplId(), object7);
            }
            String string4 = StringHelper.format((String)"%1$s%2$sctrl", (Object)string, (Object)File.separator);
            object7 = new File(string4);
            if (!((File)object7).exists()) {
                ((File)object7).mkdirs();
            }
            object10 = new File(string4);
            object11 = ((File)object10).listFiles();
            for (Object object52 : object11) {
                void var25_73;
                if (!((File)object52).isDirectory()) continue;
                object4 = ((File)object52).getName();
                serializable = new PSCtrlType();
                ((PSCtrlTypeBase)serializable).setPSCtrlTypeId((String)object4);
                if (!object12.get((IEntity)serializable, true)) {
                    throw new Exception(StringHelper.format((String)"\u4e91\u5e73\u53f0\u4e0d\u5b58\u5728\u90e8\u4ef6\u7c7b\u578b[%1$s]", (Object)object4));
                }
                object3 = new HashMap();
                File[] fileArray = ((File)object52).listFiles();
                int n4 = fileArray.length;
                boolean bl4 = false;
                while (var25_73 < n4) {
                    File file6 = fileArray[var25_73];
                    if (file6.isFile()) {
                        ((HashMap)object3).put(file6.getName().toUpperCase(), file6);
                    }
                    ++var25_73;
                }
                for (Map.Entry entry : hashMap2.entrySet()) {
                    void var28_99;
                    void var26_87;
                    void var25_76;
                    String string5 = "";
                    String string6 = "";
                    object2 = "";
                    String string7 = "";
                    File file7 = (File)((HashMap)object3).remove(entry.getKey());
                    if (file7 != null) {
                        String string8 = PSPFStyleService.readFile(file7.getAbsolutePath());
                    }
                    if ((file7 = (File)((HashMap)object3).remove(StringHelper.format((String)"%1$s_CODE2%2$s", (Object)((PSPFPubCode)entry.getValue()).getPSPFPubCodeName(), (Object)((PSPFPubCode)entry.getValue()).getCodeEXT()).toUpperCase())) != null) {
                        String string9 = PSPFStyleService.readFile(file7.getAbsolutePath());
                    }
                    if ((file7 = (File)((HashMap)object3).remove(StringHelper.format((String)"%1$s_CODE3%2$s", (Object)((PSPFPubCode)entry.getValue()).getPSPFPubCodeName(), (Object)((PSPFPubCode)entry.getValue()).getCodeEXT()).toUpperCase())) != null) {
                        object2 = PSPFStyleService.readFile(file7.getAbsolutePath());
                    }
                    if ((file7 = (File)((HashMap)object3).remove(StringHelper.format((String)"%1$s_CODE4%2$s", (Object)((PSPFPubCode)entry.getValue()).getPSPFPubCodeName(), (Object)((PSPFPubCode)entry.getValue()).getCodeEXT()).toUpperCase())) != null) {
                        String string10 = PSPFStyleService.readFile(file7.getAbsolutePath());
                    }
                    if (StringHelper.isNullOrEmpty((String)var25_76) && StringHelper.isNullOrEmpty((String)var26_87) && StringHelper.isNullOrEmpty((String)object2) && StringHelper.isNullOrEmpty((String)var28_99)) continue;
                    PSPFCtrlTempl pSPFCtrlTempl = new PSPFCtrlTempl();
                    pSPFCtrlTempl.setPSPFId(pSPF.getPSPFId());
                    pSPFCtrlTempl.setPSPFName(pSPF.getPSPFName());
                    pSPFCtrlTempl.setPSPFPubCodeId(((PSPFPubCode)entry.getValue()).getPSPFPubCodeId());
                    pSPFCtrlTempl.setPSPFPubCodeName(((PSPFPubCode)entry.getValue()).getPSPFPubCodeName());
                    pSPFCtrlTempl.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
                    pSPFCtrlTempl.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
                    pSPFCtrlTempl.setPSCtrlTypeId(((PSCtrlTypeBase)serializable).getPSCtrlTypeId());
                    pSPFCtrlTempl.setPSCtrlTypeName(((PSCtrlTypeBase)serializable).getPSCtrlTypeName());
                    pSPFCtrlTempl.setTemplCode((String)var25_76);
                    pSPFCtrlTempl.setTemplCode2((String)var26_87);
                    pSPFCtrlTempl.setTemplCode3((String)object2);
                    pSPFCtrlTempl.setTemplCode4((String)var28_99);
                    pSPFCtrlTemplService.fillEntityKeyValue(pSPFCtrlTempl, false);
                    boolean bl5 = false;
                    arrayList2 = null;
                    if (pSPFCtrlTemplService.checkKey(pSPFCtrlTempl) == 0) {
                        for (object = pSPFStyle.getTemplPSPFStyle(); object != null; object = ((PSPFStyleBase)object).getTemplPSPFStyle()) {
                            entityBase = new PSPFCtrlTempl();
                            entityBase.setPSPFId(pSPF.getPSPFId());
                            entityBase.setPSPFName(pSPF.getPSPFName());
                            entityBase.setPSPFPubCodeId(((PSPFPubCode)entry.getValue()).getPSPFPubCodeId());
                            entityBase.setPSPFPubCodeName(((PSPFPubCode)entry.getValue()).getPSPFPubCodeName());
                            entityBase.setPSPFStyleId(((PSPFStyleBase)object).getPSPFStyleId());
                            entityBase.setPSPFStyleName(((PSPFStyleBase)object).getPSPFStyleName());
                            entityBase.setPSCtrlTypeId(((PSCtrlTypeBase)serializable).getPSCtrlTypeId());
                            entityBase.setPSCtrlTypeName(((PSCtrlTypeBase)serializable).getPSCtrlTypeName());
                            pSPFCtrlTemplService.fillEntityKeyValue(entityBase, false);
                            if (!pSPFCtrlTemplService.get((IEntity)entityBase, true)) continue;
                            pSPFCtrlTempl.setPubObj(entityBase.getPubObj());
                            pSPFCtrlTempl.setLogicName(entityBase.getLogicName());
                            arrayList2 = pSPFCtrlTempl.getPSPFCTDetails();
                            break;
                        }
                        EntityBase.setIgnoreCheck((IEntity)pSPFCtrlTempl, (boolean)false);
                        pSPFCtrlTemplService.create(pSPFCtrlTempl);
                        bl5 = true;
                    } else {
                        EntityBase.setIgnoreCheck((IEntity)pSPFCtrlTempl, (boolean)false);
                        pSPFCtrlTemplService.update(pSPFCtrlTempl);
                        arrayList2 = pSPFCtrlTempl.getPSPFCTDetails();
                    }
                    ((HashMap)object82).remove(pSPFCtrlTempl.getPSPFCtrlTemplId());
                    if (arrayList2 == null) continue;
                    object = arrayList2.iterator();
                    while (object.hasNext()) {
                        void var28_103;
                        void var26_91;
                        void var25_80;
                        entityBase = (PSPFCTDetail)object.next();
                        if (bl5) {
                            entityBase.setPSPFCtrlTemplId(pSPFCtrlTempl.getPSPFCtrlTemplId());
                            entityBase.setPSPFCtrlTemplName(pSPFCtrlTempl.getPSPFCtrlTemplName());
                            entityBase.resetPSPFCTDetailId();
                        }
                        String string11 = "";
                        String string12 = "";
                        object2 = "";
                        String string13 = "";
                        file7 = (File)((HashMap)object3).remove(StringHelper.format((String)"%1$s_%3$s%2$s", (Object)((PSPFPubCode)entry.getValue()).getPSPFPubCodeName(), (Object)((PSPFPubCode)entry.getValue()).getCodeEXT(), (Object)entityBase.getPSPFCTDetailName()).toUpperCase());
                        if (file7 != null) {
                            String string14 = PSPFStyleService.readFile(file7.getAbsolutePath());
                        }
                        if ((file7 = (File)((HashMap)object3).remove(StringHelper.format((String)"%1$s_%3$s_CODE2%2$s", (Object)((PSPFPubCode)entry.getValue()).getPSPFPubCodeName(), (Object)((PSPFPubCode)entry.getValue()).getCodeEXT(), (Object)entityBase.getPSPFCTDetailName()).toUpperCase())) != null) {
                            String string15 = PSPFStyleService.readFile(file7.getAbsolutePath());
                        }
                        if ((file7 = (File)((HashMap)object3).remove(StringHelper.format((String)"%1$s_%3$s_CODE3%2$s", (Object)((PSPFPubCode)entry.getValue()).getPSPFPubCodeName(), (Object)((PSPFPubCode)entry.getValue()).getCodeEXT(), (Object)entityBase.getPSPFCTDetailName()).toUpperCase())) != null) {
                            object2 = PSPFStyleService.readFile(file7.getAbsolutePath());
                        }
                        if ((file7 = (File)((HashMap)object3).remove(StringHelper.format((String)"%1$s_%3$s_CODE4%2$s", (Object)((PSPFPubCode)entry.getValue()).getPSPFPubCodeName(), (Object)((PSPFPubCode)entry.getValue()).getCodeEXT(), (Object)entityBase.getPSPFCTDetailName()).toUpperCase())) != null) {
                            String string16 = PSPFStyleService.readFile(file7.getAbsolutePath());
                        }
                        entityBase.setTemplCode((String)var25_80);
                        entityBase.setTemplCode2((String)var26_91);
                        entityBase.setTemplCode3((String)object2);
                        entityBase.setTemplCode4((String)var28_103);
                        if (bl5) {
                            EntityBase.setIgnoreCheck((IEntity)entityBase, (boolean)false);
                            ((PSCoreSysServiceBaseBase)((Object)arrayList4)).create((EntityBase)entityBase);
                            continue;
                        }
                        EntityBase.setIgnoreCheck((IEntity)entityBase, (boolean)false);
                        ((PSCoreSysServiceBaseBase)((Object)arrayList4)).update((EntityBase)entityBase);
                    }
                }
            }
            for (Map.Entry entry : ((HashMap)object82).entrySet()) {
                log.debug((Object)StringHelper.format((String)"\u79fb\u9664\u90e8\u4ef6\u6a21\u677f[%1$s]", (Object)((PSPFCtrlTempl)entry.getValue()).getPSPFCtrlTemplName()));
                pSPFCtrlTemplService.remove((IEntity)entry.getValue());
            }
            object12 = (PSEditorTypeService)ServiceGlobal.getService(PSEditorTypeService.class, (SessionFactory)this.getSessionFactory());
            PSPFEditorTemplService pSPFEditorTemplService = (PSPFEditorTemplService)ServiceGlobal.getService(PSPFEditorTemplService.class, (SessionFactory)this.getSessionFactory());
            arrayList4 = pSPFStyle.getPSPFEditorTempls();
            object9 = new HashMap();
            for (PSPFEditorTempl pSPFEditorTempl : arrayList4) {
                ((HashMap)object9).put(pSPFEditorTempl.getPSPFEditorTemplId(), pSPFEditorTempl);
            }
            object82 = StringHelper.format((String)"%1$s%2$seditor", (Object)string, (Object)File.separator);
            File file8 = new File((String)object82);
            if (!file8.exists()) {
                file8.mkdirs();
            }
            object7 = new File((String)object82);
            object11 = object10 = ((File)object7).listFiles();
            int n5 = ((File[])object11).length;
            boolean bl6 = false;
            while (var17_46 < n5) {
                File file9 = object11[var17_46];
                if (file9.isDirectory()) {
                    object52 = file9.getName();
                    object4 = new PSEditorType();
                    ((PSEditorTypeBase)object4).setPSEditorTypeId((String)object52);
                    if (!object12.get((IEntity)object4, true)) {
                        throw new Exception(StringHelper.format((String)"\u4e91\u5e73\u53f0\u4e0d\u5b58\u5728\u7f16\u8f91\u5668\u7c7b\u578b[%1$s]", (Object)object52));
                    }
                    for (Serializable serializable2 : file9.listFiles()) {
                        if (!((File)serializable2).isDirectory()) continue;
                        String string17 = ((File)serializable2).getName();
                        if (StringHelper.compare((String)string17, (String)"FORMITEM", (boolean)false) != 0 && StringHelper.compare((String)string17, (String)"GRIDCOLUMN", (boolean)false) != 0) {
                            throw new Exception(StringHelper.format((String)"\u4e91\u5e73\u53f0\u4e0d\u5b58\u5728\u7f16\u8f91\u5668\u5e94\u7528\u573a\u5408\u7c7b\u578b[%1$s]", (Object)((File)serializable2).getName()));
                        }
                        HashMap<String, File> hashMap3 = new HashMap<String, File>();
                        for (File file10 : ((File)serializable2).listFiles()) {
                            if (!file10.isFile()) continue;
                            hashMap3.put(file10.getName().toUpperCase(), file10);
                        }
                        for (Map.Entry entry : hashMap2.entrySet()) {
                            void var30_115;
                            String string18 = "";
                            String string19 = "";
                            String string20 = "";
                            arrayList2 = "";
                            object = (File)hashMap3.remove(entry.getKey());
                            if (object != null) {
                                string18 = PSPFStyleService.readFile(((File)object).getAbsolutePath());
                            }
                            if ((object = (File)hashMap3.remove(StringHelper.format((String)"%1$s_CODE2%2$s", (Object)((PSPFPubCode)entry.getValue()).getPSPFPubCodeName(), (Object)((PSPFPubCode)entry.getValue()).getCodeEXT()).toUpperCase())) != null) {
                                String string21 = PSPFStyleService.readFile(((File)object).getAbsolutePath());
                            }
                            if ((object = (File)hashMap3.remove(StringHelper.format((String)"%1$s_CODE3%2$s", (Object)((PSPFPubCode)entry.getValue()).getPSPFPubCodeName(), (Object)((PSPFPubCode)entry.getValue()).getCodeEXT()).toUpperCase())) != null) {
                                string20 = PSPFStyleService.readFile(((File)object).getAbsolutePath());
                            }
                            if ((object = (File)hashMap3.remove(StringHelper.format((String)"%1$s_CODE4%2$s", (Object)((PSPFPubCode)entry.getValue()).getPSPFPubCodeName(), (Object)((PSPFPubCode)entry.getValue()).getCodeEXT()).toUpperCase())) != null) {
                                arrayList2 = PSPFStyleService.readFile(((File)object).getAbsolutePath());
                            }
                            if (StringHelper.isNullOrEmpty((String)string18) && StringHelper.isNullOrEmpty((String)var30_115) && StringHelper.isNullOrEmpty((String)string20) && StringHelper.isNullOrEmpty((String)((Object)arrayList2))) continue;
                            entityBase = new PSPFEditorTempl();
                            entityBase.setPSPFId(pSPF.getPSPFId());
                            entityBase.setPSPFName(pSPF.getPSPFName());
                            entityBase.setPSPFPubCodeId(((PSPFPubCode)entry.getValue()).getPSPFPubCodeId());
                            entityBase.setPSPFPubCodeName(((PSPFPubCode)entry.getValue()).getPSPFPubCodeName());
                            entityBase.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
                            entityBase.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
                            entityBase.setContainerType(string17);
                            entityBase.setPSEditorTypeId(((PSEditorTypeBase)object4).getPSEditorTypeId());
                            entityBase.setPSEditorTypeName(((PSEditorTypeBase)object4).getPSEditorTypeName());
                            entityBase.set("PSDEVCENTERID", pSPFStyle.getPSDevCenterId());
                            entityBase.set("PSDEVCENTERNAME", pSPFStyle.getPSDevCenterName());
                            entityBase.setTemplCode(string18);
                            entityBase.setTemplCode2((String)var30_115);
                            entityBase.setTemplCode3(string20);
                            entityBase.setTemplCode4((String)((Object)arrayList2));
                            pSPFEditorTemplService.fillEntityKeyValue(entityBase, false);
                            boolean bl7 = false;
                            if (pSPFEditorTemplService.checkKey(entityBase) == 0) {
                                for (PSPFStyle pSPFStyle2 = pSPFStyle.getTemplPSPFStyle(); pSPFStyle2 != null; pSPFStyle2 = pSPFStyle2.getTemplPSPFStyle()) {
                                    PSPFEditorTempl pSPFEditorTempl = new PSPFEditorTempl();
                                    pSPFEditorTempl.setPSPFId(pSPF.getPSPFId());
                                    pSPFEditorTempl.setPSPFName(pSPF.getPSPFName());
                                    pSPFEditorTempl.setPSPFPubCodeId(((PSPFPubCode)entry.getValue()).getPSPFPubCodeId());
                                    pSPFEditorTempl.setPSPFPubCodeName(((PSPFPubCode)entry.getValue()).getPSPFPubCodeName());
                                    pSPFEditorTempl.setPSPFStyleId(pSPFStyle2.getPSPFStyleId());
                                    pSPFEditorTempl.setPSPFStyleName(pSPFStyle2.getPSPFStyleName());
                                    pSPFEditorTempl.setPSEditorTypeId(((PSEditorTypeBase)object4).getPSEditorTypeId());
                                    pSPFEditorTempl.setPSEditorTypeName(((PSEditorTypeBase)object4).getPSEditorTypeName());
                                    pSPFEditorTempl.setContainerType(string17);
                                    pSPFEditorTemplService.fillEntityKeyValue(pSPFEditorTempl, false);
                                    if (!pSPFEditorTemplService.get((IEntity)pSPFEditorTempl, true)) continue;
                                    entityBase.setPubObj(pSPFEditorTempl.getPubObj());
                                    entityBase.setLogicName(pSPFEditorTempl.getLogicName());
                                    break;
                                }
                                EntityBase.setIgnoreCheck((IEntity)entityBase, (boolean)false);
                                pSPFEditorTemplService.create(entityBase);
                                bl7 = true;
                            } else {
                                EntityBase.setIgnoreCheck((IEntity)entityBase, (boolean)false);
                                pSPFEditorTemplService.update(entityBase);
                            }
                            ((HashMap)object9).remove(entityBase.getPSPFEditorTemplId());
                        }
                    }
                }
                ++var17_46;
            }
            for (Map.Entry entry : ((HashMap)object9).entrySet()) {
                log.debug((Object)StringHelper.format((String)"\u79fb\u9664\u7f16\u8f91\u5668\u6a21\u677f[%1$s]", (Object)((PSPFEditorTempl)entry.getValue()).getPSPFEditorTemplName()));
                pSPFEditorTemplService.remove((IEntity)entry.getValue());
            }
            object12 = pSPFStyle.getPSPFStyleId();
            pSPFStyle.reset();
            pSPFStyle.setPSPFStyleId((String)object12);
            pSPFStyle.setLastImpTime(new Timestamp(System.currentTimeMillis()));
            pSPFStyle.setTemplState(30);
            pSPFStyle.setTemplInfo(null);
            this.mergeCode(pSPFStyle);
            this.update(pSPFStyle);
        }
        catch (Exception exception) {
            String string22 = pSPFStyle.getPSPFStyleId();
            pSPFStyle.reset();
            pSPFStyle.setPSPFStyleId(string22);
            pSPFStyle.setTemplInfo(exception.getMessage());
            pSPFStyle.setTemplState(40);
            this.update(pSPFStyle);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    protected void onExpStyle(PSPFStyle pSPFStyle) throws Exception {
        Object object2;
        String string = DataObject.getStringValue((Object)pSPFStyle.get(PARAM_PRJFOLDER));
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u5f53\u524d\u6ca1\u6709\u6307\u5b9a\u9879\u76ee\u76ee\u5f55");
        }
        this.get((IEntity)pSPFStyle);
        PSPF pSPF = pSPFStyle.getPSPF();
        ArrayList<PSPFPubCode> arrayList = pSPF.getPSPFPubCodes();
        HashMap<String, PSPFPubCode> hashMap = new HashMap<String, PSPFPubCode>();
        for (PSPFPubCode object22 : arrayList) {
            if (!DataObject.getBoolValue((Integer)object22.getValidFlag(), (boolean)true)) continue;
            hashMap.put(object22.getPSPFPubCodeId(), object22);
        }
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSPFID", (Object)pSPF.getPSPFId());
        PSPFCodeFolderService pSPFCodeFolderService = (PSPFCodeFolderService)ServiceGlobal.getService(PSPFCodeFolderService.class, (SessionFactory)this.getSessionFactory());
        ArrayList arrayList2 = pSPFCodeFolderService.select((ISelectCond)selectCond);
        HashMap<String, PSPFCodeFolder> hashMap2 = new HashMap<String, PSPFCodeFolder>();
        for (Object object2 : arrayList2) {
            hashMap2.put(((PSPFCodeFolderBase)object2).getPSPFCodeFolderId(), (PSPFCodeFolder)object2);
        }
        PSEditorTypeService pSEditorTypeService = (PSEditorTypeService)ServiceGlobal.getService(PSEditorTypeService.class, (SessionFactory)this.getSessionFactory());
        object2 = (PSCtrlTypeService)ServiceGlobal.getService(PSCtrlTypeService.class, (SessionFactory)this.getSessionFactory());
        PSViewTypeService pSViewTypeService = (PSViewTypeService)ServiceGlobal.getService(PSViewTypeService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        boolean bl = true;
        if (bl) {
            void var25_133;
            Object object3;
            void var23_86;
            Object object4;
            void var23_83;
            String string2;
            Object object5;
            void var23_78;
            HashMap<Object, String> arrayList3 = new HashMap<Object, String>();
            Object string15 = pSPFStyle.getPSPFStyleCodes();
            Object file = StringHelper.format((String)"%1$s%2$s@MACRO", (Object)string, (Object)File.separator);
            Object file2 = new File((String)file);
            if (!((File)file2).exists()) {
                ((File)file2).mkdirs();
            }
            Object fileArray = new File((String)file);
            Object hashMap4 = ((File)fileArray).listFiles();
            Serializable serializable = new HashMap<String, File>();
            File[] fileArray2 = hashMap4;
            int n = fileArray2.length;
            boolean bl2 = false;
            while (var23_78 < n) {
                object5 = fileArray2[var23_78];
                if (((File)object5).isFile()) {
                    ((HashMap)serializable).put(((File)object5).getName().toUpperCase(), object5);
                }
                ++var23_78;
            }
            HashMap<Object, String> pSPFStyleCode = new HashMap<Object, String>();
            Iterator<PSPFStyleCode> string17 = ((ArrayList)string15).iterator();
            while (string17.hasNext()) {
                PSPFStyleCode pSPFStyleCode2 = string17.next();
                object5 = StringHelper.format((String)"<#SRFINC(%1$s)>", (Object)pSPFStyleCode2.getPSPFStyleCodeName().toUpperCase());
                String string3 = StringHelper.format((String)"<#ibizinclude>../../@MACRO/%1$s.ftl</#ibizinclude>", (Object)pSPFStyleCode2.getPSPFStyleCodeName().toUpperCase());
                string2 = StringHelper.format((String)"<#ibizinclude>%1$s.ftl</#ibizinclude>", (Object)pSPFStyleCode2.getPSPFStyleCodeName().toUpperCase());
                arrayList3.put(object5, string3);
                pSPFStyleCode.put(object5, string2);
            }
            Iterator<PSPFStyleCode> iterator = ((ArrayList)string15).iterator();
            while (iterator.hasNext()) {
                PSPFStyleCode pSPFStyleCode3 = iterator.next();
                object5 = StringHelper.format((String)"%1$s.ftl", (Object)pSPFStyleCode3.getPSPFStyleCodeName().toUpperCase());
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)file, (Object)File.separator, (Object)object5);
                string2 = pSPFStyleCode3.getStyleCode();
                for (Map.Entry entry : pSPFStyleCode.entrySet()) {
                    string2 = string2.replace((CharSequence)entry.getKey(), (CharSequence)entry.getValue());
                }
                PSPFStyleService.writeFile(string4, string2);
                ((HashMap)serializable).remove(((String)object5).toUpperCase());
            }
            for (Map.Entry entry : ((HashMap)serializable).entrySet()) {
                log.debug((Object)StringHelper.format((String)"\u79fb\u9664\u6587\u4ef6[%1$s]", (Object)((File)entry.getValue()).getAbsolutePath()));
            }
            string15 = pSPFStyle.getPSPFViewTempls();
            file = StringHelper.format((String)"%1$s%2$s@VIEW", (Object)string, (Object)File.separator);
            file2 = new File((String)file);
            if (!((File)file2).exists()) {
                ((File)file2).mkdirs();
            }
            fileArray = new File((String)file);
            hashMap4 = ((File)fileArray).listFiles();
            serializable = new HashMap();
            File[] entry = hashMap4;
            int n2 = entry.length;
            boolean bl3 = false;
            while (var23_83 < n2) {
                object5 = entry[var23_83];
                if (((File)object5).isDirectory()) {
                    for (File file3 : ((File)object5).listFiles()) {
                        ((HashMap)serializable).put(StringHelper.format((String)"%1$s%2$s%3$s", (Object)((File)object5).getName(), (Object)File.separator, (Object)file3.getName().toUpperCase()), file3);
                    }
                }
                ++var23_83;
            }
            Iterator<EntityBase> iterator2 = ((ArrayList)string15).iterator();
            while (iterator2.hasNext()) {
                void var28_199;
                void var28_196;
                Object object6;
                PSPFViewTempl string21 = (PSPFViewTempl)iterator2.next();
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)file, (Object)File.separator, (Object)string21.getPSViewTypeName());
                file2 = new File(string5);
                if (!((File)file2).exists()) {
                    ((File)file2).mkdirs();
                }
                object5 = new StringBuilderEx();
                if (string21.getPSViewTypeId().indexOf("APP") == 0) {
                    object5.append("VIEWTYPE=%1$s", (Object)string21.getPSViewTypeId());
                } else {
                    object5.append("VIEWTYPE=APP%1$s", (Object)string21.getPSViewTypeId());
                }
                String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string5, (Object)File.separator, (Object)"template.properties");
                PSPFStyleService.writeFile(string6, object5.toString());
                object5 = (PSPFPubCode)hashMap.get(string21.getPSPFPubCodeId());
                if (object5 == null) continue;
                String string7 = ((PSPFPubCodeBase)object5).getCodeEXT();
                if (!StringHelper.isNullOrEmpty((String)string7)) {
                    object6 = string7.split("[.]");
                    String string8 = "." + object6[((String[])object6).length - 1];
                }
                String string9 = "";
                object6 = StringHelper.format((String)"%1$s%2$s.ftl", (Object)((PSPFPubCodeBase)object5).getPSPFPubCodeName(), (Object)string9);
                String string10 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string5, (Object)File.separator, (Object)object6);
                String string11 = string21.getTemplCode2();
                if (StringHelper.isNullOrEmpty((String)string11)) {
                    String string12 = "";
                }
                for (Map.Entry entry2 : arrayList3.entrySet()) {
                    String string13 = var28_196.replace((CharSequence)entry2.getKey(), (CharSequence)entry2.getValue());
                }
                if (!StringHelper.isNullOrEmpty((String)string21.getPubObj())) {
                    object4 = new StringBuilderEx();
                    String string18 = string21.getPubObj();
                    string18 = string18.replace("SA.SRFDA.PS.Core.Pub.", "");
                    string18 = string18.replace("PublisherImpl", "");
                    object4.append("<#ibiztemplate>\r\n");
                    object4.append("PUBOBJ=%1$s\r\n", (Object)string18);
                    object4.append("</#ibiztemplate>\r\n");
                    object4.append((String)var28_196);
                    String string19 = object4.toString();
                }
                PSPFStyleService.writeFile(string10, (String)var28_199);
                ((HashMap)serializable).remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string5, (Object)File.separator, (Object)((String)object6).toUpperCase()));
            }
            for (Map.Entry entry3 : ((HashMap)serializable).entrySet()) {
                log.debug((Object)StringHelper.format((String)"\u79fb\u9664\u6587\u4ef6[%1$s]", (Object)((File)entry3.getValue()).getAbsolutePath()));
            }
            string15 = pSPFStyle.getPSPFCtrlTempls();
            file = StringHelper.format((String)"%1$s%2$s@CONTROL", (Object)string, (Object)File.separator);
            file2 = new File((String)file);
            if (!((File)file2).exists()) {
                ((File)file2).mkdirs();
            }
            fileArray = new File((String)file);
            hashMap4 = ((File)fileArray).listFiles();
            serializable = new HashMap();
            entry = hashMap4;
            int n3 = entry.length;
            boolean bl4 = false;
            while (var23_86 < n3) {
                object5 = entry[var23_86];
                if (((File)object5).isDirectory()) {
                    for (File file4 : ((File)object5).listFiles()) {
                        ((HashMap)serializable).put(StringHelper.format((String)"%1$s%2$s%3$s", (Object)((File)object5).getName(), (Object)File.separator, (Object)file4.getName().toUpperCase()), file4);
                    }
                }
                ++var23_86;
            }
            Iterator<EntityBase> iterator3 = ((ArrayList)string15).iterator();
            while (iterator3.hasNext()) {
                void var28_209;
                void var28_206;
                Object object7;
                PSPFCtrlTempl pSPFCtrlTempl = (PSPFCtrlTempl)iterator3.next();
                String string20 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)file, (Object)File.separator, (Object)pSPFCtrlTempl.getPSCtrlTypeName());
                file2 = new File(string20);
                if (!((File)file2).exists()) {
                    ((File)file2).mkdirs();
                }
                object5 = new StringBuilderEx();
                object5.append("CTRLTYPE=%1$s", (Object)pSPFCtrlTempl.getPSCtrlTypeId());
                String string21 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string20, (Object)File.separator, (Object)"template.properties");
                PSPFStyleService.writeFile(string21, object5.toString());
                object5 = (PSPFPubCode)hashMap.get(pSPFCtrlTempl.getPSPFPubCodeId());
                if (object5 == null) continue;
                String string22 = ((PSPFPubCodeBase)object5).getCodeEXT();
                if (!StringHelper.isNullOrEmpty((String)string22)) {
                    object7 = string22.split("[.]");
                    String string23 = "." + object7[((String[])object7).length - 1];
                }
                String string24 = "";
                object7 = StringHelper.format((String)"%1$s%2$s.ftl", (Object)((PSPFPubCodeBase)object5).getPSPFPubCodeName(), (Object)string24);
                String string25 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string20, (Object)File.separator, (Object)object7);
                String string26 = pSPFCtrlTempl.getTemplCode();
                if (StringHelper.isNullOrEmpty((String)string26)) {
                    String string27 = "";
                }
                for (Map.Entry entry4 : arrayList3.entrySet()) {
                    String string28 = var28_206.replace((CharSequence)entry4.getKey(), (CharSequence)entry4.getValue());
                }
                if (!StringHelper.isNullOrEmpty((String)pSPFCtrlTempl.getPubObj())) {
                    object4 = new StringBuilderEx();
                    String string31 = pSPFCtrlTempl.getPubObj();
                    string31 = string31.replace("SA.SRFDA.PS.Core.Pub.", "");
                    string31 = string31.replace("PublisherImpl", "");
                    object4.append("<#ibiztemplate>\r\n");
                    object4.append("PUBOBJ=%1$s\r\n", (Object)string31);
                    object4.append("</#ibiztemplate>\r\n");
                    object4.append((String)var28_206);
                    String string32 = object4.toString();
                }
                PSPFStyleService.writeFile(string25, (String)var28_209);
                ((HashMap)serializable).remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string20, (Object)File.separator, (Object)((String)object7).toUpperCase()));
                if (!StringHelper.isNullOrEmpty((String)pSPFCtrlTempl.getTemplCode2())) {
                    void var28_211;
                    object7 = StringHelper.format((String)"%1$s%2$s#CODE2.ftl", (Object)((PSPFPubCodeBase)object5).getPSPFPubCodeName(), (Object)string24);
                    String string33 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string20, (Object)File.separator, (Object)object7);
                    String string34 = pSPFCtrlTempl.getTemplCode2();
                    for (Map.Entry entry5 : arrayList3.entrySet()) {
                        String string35 = var28_211.replace((CharSequence)entry5.getKey(), (CharSequence)entry5.getValue());
                    }
                    PSPFStyleService.writeFile(string33, (String)var28_211);
                    ((HashMap)serializable).remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string20, (Object)File.separator, (Object)((String)object7).toUpperCase()));
                }
                if (!StringHelper.isNullOrEmpty((String)pSPFCtrlTempl.getTemplCode3())) {
                    void var28_215;
                    object7 = StringHelper.format((String)"%1$s%2$s#CODE3.ftl", (Object)((PSPFPubCodeBase)object5).getPSPFPubCodeName(), (Object)string24);
                    String string36 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string20, (Object)File.separator, (Object)object7);
                    String string37 = pSPFCtrlTempl.getTemplCode3();
                    for (Map.Entry entry6 : arrayList3.entrySet()) {
                        String string38 = var28_215.replace((CharSequence)entry6.getKey(), (CharSequence)entry6.getValue());
                    }
                    PSPFStyleService.writeFile(string36, (String)var28_215);
                    ((HashMap)serializable).remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string20, (Object)File.separator, (Object)((String)object7).toUpperCase()));
                }
                if (!StringHelper.isNullOrEmpty((String)pSPFCtrlTempl.getTemplCode4())) {
                    void var28_219;
                    object7 = StringHelper.format((String)"%1$s%2$s#CODE4.ftl", (Object)((PSPFPubCodeBase)object5).getPSPFPubCodeName(), (Object)string24);
                    String string39 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string20, (Object)File.separator, (Object)object7);
                    String string40 = pSPFCtrlTempl.getTemplCode4();
                    for (Map.Entry entry7 : arrayList3.entrySet()) {
                        String string41 = var28_219.replace((CharSequence)entry7.getKey(), (CharSequence)entry7.getValue());
                    }
                    PSPFStyleService.writeFile(string39, (String)var28_219);
                    ((HashMap)serializable).remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string20, (Object)File.separator, (Object)((String)object7).toUpperCase()));
                }
                object7 = pSPFCtrlTempl.getPSPFCTDetails();
                Iterator iterator4 = ((ArrayList)object7).iterator();
                while (iterator4.hasNext()) {
                    PSPFCTDetail pSPFCTDetail = (PSPFCTDetail)iterator4.next();
                    if (!DataObject.getBoolValue((Integer)pSPFCTDetail.getValidFlag(), (boolean)true)) continue;
                    object4 = StringHelper.format((String)"%1$s%2$s#%3$s.ftl", (Object)((PSPFPubCodeBase)object5).getPSPFPubCodeName(), (Object)string24, (Object)pSPFCTDetail.getPSPFCTDetailName());
                    String string42 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string20, (Object)File.separator, (Object)object4);
                    object3 = pSPFCTDetail.getTemplCode();
                    if (StringHelper.isNullOrEmpty((String)object3)) {
                        object3 = "";
                    }
                    for (Map.Entry entry8 : arrayList3.entrySet()) {
                        object3 = ((String)object3).replace((CharSequence)entry8.getKey(), (CharSequence)entry8.getValue());
                    }
                    if (!StringHelper.isNullOrEmpty((String)pSPFCTDetail.getPubObj())) {
                        StringBuilderEx stringBuilderEx = new StringBuilderEx();
                        String string45 = pSPFCTDetail.getPubObj();
                        string45 = string45.replace("SA.SRFDA.PS.Core.Pub.", "");
                        string45 = string45.replace("PublisherImpl", "");
                        stringBuilderEx.append("<#ibiztemplate>\r\n");
                        stringBuilderEx.append("PUBOBJ=%1$s\r\n", (Object)string45);
                        stringBuilderEx.append("</#ibiztemplate>\r\n");
                        stringBuilderEx.append((String)object3);
                        object3 = stringBuilderEx.toString();
                    }
                    PSPFStyleService.writeFile(string42, (String)object3);
                    ((HashMap)serializable).remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string20, (Object)File.separator, (Object)((String)object4).toUpperCase()));
                    if (!StringHelper.isNullOrEmpty((String)pSPFCTDetail.getTemplCode2())) {
                        object4 = StringHelper.format((String)"%1$s%2$s#%3$s#CODE2.ftl", (Object)((PSPFPubCodeBase)object5).getPSPFPubCodeName(), (Object)string24, (Object)pSPFCTDetail.getPSPFCTDetailName());
                        String string46 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string20, (Object)File.separator, (Object)object4);
                        object3 = pSPFCTDetail.getTemplCode2();
                        if (StringHelper.isNullOrEmpty((String)object3)) {
                            object3 = "";
                        }
                        for (Map.Entry entry9 : arrayList3.entrySet()) {
                            object3 = ((String)object3).replace((CharSequence)entry9.getKey(), (CharSequence)entry9.getValue());
                        }
                        PSPFStyleService.writeFile(string46, (String)object3);
                        ((HashMap)serializable).remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string20, (Object)File.separator, (Object)((String)object4).toUpperCase()));
                    }
                    if (!StringHelper.isNullOrEmpty((String)pSPFCTDetail.getTemplCode3())) {
                        object4 = StringHelper.format((String)"%1$s%2$s#%3$s#CODE3.ftl", (Object)((PSPFPubCodeBase)object5).getPSPFPubCodeName(), (Object)string24, (Object)pSPFCTDetail.getPSPFCTDetailName());
                        String string47 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string20, (Object)File.separator, (Object)object4);
                        object3 = pSPFCTDetail.getTemplCode3();
                        if (StringHelper.isNullOrEmpty((String)object3)) {
                            object3 = "";
                        }
                        for (Map.Entry entry10 : arrayList3.entrySet()) {
                            object3 = ((String)object3).replace((CharSequence)entry10.getKey(), (CharSequence)entry10.getValue());
                        }
                        PSPFStyleService.writeFile(string47, (String)object3);
                        ((HashMap)serializable).remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string20, (Object)File.separator, (Object)((String)object4).toUpperCase()));
                    }
                    if (StringHelper.isNullOrEmpty((String)pSPFCTDetail.getTemplCode4())) continue;
                    object4 = StringHelper.format((String)"%1$s%2$s#%3$s#CODE4.ftl", (Object)((PSPFPubCodeBase)object5).getPSPFPubCodeName(), (Object)string24, (Object)pSPFCTDetail.getPSPFCTDetailName());
                    String string48 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string20, (Object)File.separator, (Object)object4);
                    object3 = pSPFCTDetail.getTemplCode4();
                    if (StringHelper.isNullOrEmpty((String)object3)) {
                        object3 = "";
                    }
                    for (Map.Entry entry11 : arrayList3.entrySet()) {
                        object3 = ((String)object3).replace((CharSequence)entry11.getKey(), (CharSequence)entry11.getValue());
                    }
                    PSPFStyleService.writeFile(string48, (String)object3);
                    ((HashMap)serializable).remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string20, (Object)File.separator, (Object)((String)object4).toUpperCase()));
                }
            }
            for (Map.Entry entry12 : ((HashMap)serializable).entrySet()) {
                log.debug((Object)StringHelper.format((String)"\u79fb\u9664\u6587\u4ef6[%1$s]", (Object)((File)entry12.getValue()).getAbsolutePath()));
            }
            selectCond.reset();
            selectCond.set("PSPFID", (Object)pSPFStyle.getPSPFId());
            selectCond.setIsNull("PSPFSTYLEID");
            string15 = (PSPFEditorTemplService)ServiceGlobal.getService(PSPFEditorTemplService.class, (SessionFactory)this.getSessionFactory());
            file = string15.select((ISelectCond)selectCond);
            file2 = pSPFStyle.getPSPFEditorTempls();
            ((ArrayList)file).addAll(file2);
            fileArray = StringHelper.format((String)"%1$s%2$s@EDITOR", (Object)string, (Object)File.separator);
            hashMap4 = new File((String)fileArray);
            if (!((File)hashMap4).exists()) {
                ((File)hashMap4).mkdirs();
            }
            serializable = new File((String)fileArray);
            entry = ((File)serializable).listFiles();
            HashMap<String, File> hashMap3 = new HashMap<String, File>();
            File[] fileArray3 = entry;
            int n4 = fileArray3.length;
            boolean bl5 = false;
            while (var25_133 < n4) {
                File file5 = fileArray3[var25_133];
                if (file5.isDirectory()) {
                    for (File file6 : file5.listFiles()) {
                        if (!file6.isDirectory()) continue;
                        for (File file7 : file6.listFiles()) {
                            if (!file7.isFile()) continue;
                            hashMap3.put(StringHelper.format((String)"%1$s%2$s%3$s%2$s%4$s", (Object)file5.getName(), (Object)File.separator, (Object)file6.getName(), (Object)file7.getName().toUpperCase()), file7);
                        }
                    }
                }
                ++var25_133;
            }
            EditorContainersCodeListModel editorContainersCodeListModel = (EditorContainersCodeListModel)CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.EditorContainersCodeListModel");
            Object object8 = ((ArrayList)file).iterator();
            while (object8.hasNext()) {
                void var33_299;
                void var35_318;
                void var33_287;
                PSPFEditorTempl pSPFEditorTempl = (PSPFEditorTempl)object8.next();
                String string49 = pSPFEditorTempl.getContainerType();
                String string50 = editorContainersCodeListModel.getCodeListText(string49, false);
                String string51 = StringHelper.format((String)"%1$s%2$s%3$s\uff08%4$s\uff09", (Object)fileArray, (Object)File.separator, (Object)pSPFEditorTempl.getPSEditorTypeName(), (Object)string50);
                hashMap4 = new File(string51);
                if (!((File)hashMap4).exists()) {
                    ((File)hashMap4).mkdirs();
                }
                Object object9 = new StringBuilderEx();
                object9.append("EDITORTYPE=%1$s", (Object)pSPFEditorTempl.getPSEditorTypeId());
                String string52 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string51, (Object)File.separator, (Object)"template.properties");
                PSPFStyleService.writeFile(string52, object9.toString());
                object9 = (PSPFPubCode)hashMap.get(pSPFEditorTempl.getPSPFPubCodeId());
                if (object9 == null) continue;
                String string53 = ((PSPFPubCodeBase)object9).getCodeEXT();
                if (!StringHelper.isNullOrEmpty((String)string53)) {
                    object3 = string53.split("[.]");
                    String string54 = "." + (String)((Object)object3[((File[])object3).length - 1]);
                }
                String string55 = "";
                object3 = StringHelper.format((String)"%1$s%2$s.ftl", (Object)((PSPFPubCodeBase)object9).getPSPFPubCodeName(), (Object)string55);
                String string56 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string51, (Object)File.separator, (Object)object3);
                String string57 = pSPFEditorTempl.getTemplCode();
                if (StringHelper.isNullOrEmpty((String)string57)) {
                    String string58 = "";
                }
                for (Map.Entry entry13 : arrayList3.entrySet()) {
                    String string59 = var33_287.replace((CharSequence)entry13.getKey(), (CharSequence)entry13.getValue());
                }
                StringBuilderEx stringBuilderEx = new StringBuilderEx();
                String string60 = pSPFEditorTempl.getPubObj();
                if (!StringHelper.isNullOrEmpty((String)string60)) {
                    String string62 = string60.replace("SA.SRFDA.PS.Core.Pub.", "");
                    string62 = string62.replace("PublisherImpl", "");
                }
                stringBuilderEx.append("<#ibiztemplate>\r\n");
                if (!StringHelper.isNullOrEmpty((String)var35_318)) {
                    stringBuilderEx.append("PUBOBJ=%1$s\r\n", (Object)var35_318);
                }
                stringBuilderEx.append("CONTAINER=%1$s\r\n", (Object)string49);
                stringBuilderEx.append("</#ibiztemplate>\r\n");
                stringBuilderEx.append((String)var33_287);
                String string63 = stringBuilderEx.toString();
                PSPFStyleService.writeFile(string56, string63);
                hashMap3.remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string51, (Object)File.separator, (Object)((String)object3).toUpperCase()));
                if (!StringHelper.isNullOrEmpty((String)pSPFEditorTempl.getTemplCode2())) {
                    void var33_291;
                    object3 = StringHelper.format((String)"%1$s%2$s#CODE2.ftl", (Object)((PSPFPubCodeBase)object9).getPSPFPubCodeName(), (Object)string55);
                    string56 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string51, (Object)File.separator, (Object)object3);
                    String string64 = pSPFEditorTempl.getTemplCode2();
                    for (Map.Entry entry14 : arrayList3.entrySet()) {
                        String string65 = var33_291.replace((CharSequence)entry14.getKey(), (CharSequence)entry14.getValue());
                    }
                    PSPFStyleService.writeFile(string56, (String)var33_291);
                    hashMap3.remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string51, (Object)File.separator, (Object)((String)object3).toUpperCase()));
                }
                if (!StringHelper.isNullOrEmpty((String)pSPFEditorTempl.getTemplCode3())) {
                    void var33_295;
                    object3 = StringHelper.format((String)"%1$s%2$s#CODE3.ftl", (Object)((PSPFPubCodeBase)object9).getPSPFPubCodeName(), (Object)string55);
                    string56 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string51, (Object)File.separator, (Object)object3);
                    String string66 = pSPFEditorTempl.getTemplCode3();
                    for (Map.Entry entry15 : arrayList3.entrySet()) {
                        String string67 = var33_295.replace((CharSequence)entry15.getKey(), (CharSequence)entry15.getValue());
                    }
                    PSPFStyleService.writeFile(string56, (String)var33_295);
                    hashMap3.remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string51, (Object)File.separator, (Object)((String)object3).toUpperCase()));
                }
                if (StringHelper.isNullOrEmpty((String)pSPFEditorTempl.getTemplCode4())) continue;
                object3 = StringHelper.format((String)"%1$s%2$s#CODE4.ftl", (Object)((PSPFPubCodeBase)object9).getPSPFPubCodeName(), (Object)string55);
                string56 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string51, (Object)File.separator, (Object)object3);
                String string68 = pSPFEditorTempl.getTemplCode4();
                for (Map.Entry entry16 : arrayList3.entrySet()) {
                    String string69 = var33_299.replace((CharSequence)entry16.getKey(), (CharSequence)entry16.getValue());
                }
                PSPFStyleService.writeFile(string56, (String)var33_299);
                hashMap3.remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string51, (Object)File.separator, (Object)((String)object3).toUpperCase()));
            }
            object8 = hashMap3.entrySet().iterator();
            while (object8.hasNext()) {
                Map.Entry entry17 = (Map.Entry)object8.next();
                log.debug((Object)StringHelper.format((String)"\u79fb\u9664\u6587\u4ef6[%1$s]", (Object)((File)entry17.getValue()).getAbsolutePath()));
            }
            string15 = (PSPFAppTemplService)ServiceGlobal.getService(PSPFAppTemplService.class, (SessionFactory)this.getSessionFactory());
            selectCond.reset();
            selectCond.set("PSPFSTYLEID", (Object)pSPFStyle.getPSPFStyleId());
            file = string15.select((ISelectCond)selectCond);
            file2 = ((ArrayList)file).iterator();
            while (file2.hasNext()) {
                void var27_177;
                void var23_93;
                String string70;
                fileArray = (PSPFAppTempl)file2.next();
                hashMap4 = (PSPFPubCode)hashMap.get(((PSPFAppTemplBase)fileArray).getPSPFPubCodeId());
                if (hashMap4 == null) continue;
                serializable = (PSPFCodeFolder)hashMap2.get(((PSPFPubCodeBase)hashMap4).getPSPFCodeFolderId());
                String pSPFEditorTempl = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string, (Object)File.separator, (Object)((PSPFCodeFolderBase)serializable).getFolderName());
                File file8 = new File(pSPFEditorTempl);
                if (!file8.exists()) {
                    file8.mkdirs();
                }
                if (StringHelper.isNullOrEmpty((String)(string70 = ((PSPFPubCodeBase)hashMap4).getPSPFPubCodeName()))) {
                    String string71 = "";
                }
                if (StringHelper.isNullOrEmpty((String)(object8 = ((PSPFPubCodeBase)hashMap4).getCodeEXT()))) {
                    object8 = "";
                }
                object8 = "";
                String string72 = StringHelper.format((String)"%1$s%2$s.ftl", (Object)var23_93, (Object)object8);
                String string73 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)pSPFEditorTempl, (Object)File.separator, (Object)string72);
                String string74 = ((PSPFAppTemplBase)fileArray).getTemplCode();
                if (StringHelper.isNullOrEmpty((String)string74)) {
                    String string75 = "";
                }
                StringBuilderEx stringBuilderEx = new StringBuilderEx();
                String string76 = ((PSPFAppTemplBase)fileArray).getPubObj();
                if (!StringHelper.isNullOrEmpty((String)((PSPFAppTemplBase)fileArray).getPubObj())) {
                    string76 = string76.replace("SA.SRFDA.PS.Core.Pub.", "");
                    string76 = string76.replace("PublisherImpl", "");
                }
                stringBuilderEx.append("<#ibiztemplate>\r\n");
                if (!StringHelper.isNullOrEmpty((String)string76)) {
                    stringBuilderEx.append("PUBOBJ=%1$s\r\n", (Object)string76);
                }
                stringBuilderEx.append("TARGET=%1$s\r\n", (Object)"PSSYSAPP");
                stringBuilderEx.append("</#ibiztemplate>\r\n");
                stringBuilderEx.append((String)var27_177);
                String string77 = stringBuilderEx.toString();
                PSPFStyleService.writeFile(string73, string77);
            }
        } else {
            void var22_75;
            void var22_72;
            Object object10;
            void var22_69;
            void var22_66;
            ArrayList<EntityBase> arrayList3 = pSPFStyle.getPSPFStyleCodes();
            String string78 = StringHelper.format((String)"%1$s%2$smacro", (Object)string, (Object)File.separator);
            File file = new File(string78);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file9 = new File(string78);
            File[] fileArray = file9.listFiles();
            HashMap<String, Object> hashMap4 = new HashMap<String, Object>();
            Object object11 = fileArray;
            int entry = ((File[])object11).length;
            boolean bl6 = false;
            while (var22_66 < entry) {
                File file10 = object11[var22_66];
                if (file10.isFile()) {
                    hashMap4.put(file10.getName().toUpperCase(), file10);
                }
                ++var22_66;
            }
            for (PSPFStyleCode pSPFStyleCode : arrayList3) {
                String string79 = StringHelper.format((String)"%1$s.txt", (Object)pSPFStyleCode.getPSPFStyleCodeName().toUpperCase());
                String string80 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string78, (Object)File.separator, (Object)string79);
                PSPFStyleService.writeFile(string80, pSPFStyleCode.getStyleCode());
                hashMap4.remove(string79.toUpperCase());
            }
            for (Map.Entry entry18 : hashMap4.entrySet()) {
                log.debug((Object)StringHelper.format((String)"\u79fb\u9664\u6587\u4ef6[%1$s]", (Object)((File)entry18.getValue()).getAbsolutePath()));
            }
            arrayList3 = pSPFStyle.getPSPFViewTempls();
            string78 = StringHelper.format((String)"%1$s%2$sview", (Object)string, (Object)File.separator);
            file = new File(string78);
            if (!file.exists()) {
                file.mkdirs();
            }
            file9 = new File(string78);
            fileArray = file9.listFiles();
            hashMap4 = new HashMap();
            object11 = fileArray;
            int n = ((Object)object11).length;
            boolean bl7 = false;
            while (var22_69 < n) {
                Object object12 = object11[var22_69];
                if (((File)object12).isDirectory()) {
                    for (File file11 : ((File)object12).listFiles()) {
                        hashMap4.put(StringHelper.format((String)"%1$s%2$s%3$s", (Object)((File)object12).getName(), (Object)File.separator, (Object)file11.getName().toUpperCase()), file11);
                    }
                }
                ++var22_69;
            }
            for (PSPFViewTempl pSPFViewTempl : arrayList3) {
                String string81 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string78, (Object)File.separator, (Object)pSPFViewTempl.getPSViewTypeId());
                file = new File(string81);
                if (!file.exists()) {
                    file.mkdirs();
                }
                PSPFPubCode pSPFPubCode = (PSPFPubCode)hashMap.get(pSPFViewTempl.getPSPFPubCodeId());
                object10 = StringHelper.format((String)"%1$s%2$s", (Object)pSPFPubCode.getPSPFPubCodeName(), (Object)pSPFPubCode.getCodeEXT());
                String string82 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string81, (Object)File.separator, (Object)object10);
                PSPFStyleService.writeFile(string82, pSPFViewTempl.getTemplCode2());
                hashMap4.remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string81, (Object)File.separator, (Object)((String)object10).toUpperCase()));
            }
            for (Map.Entry entry19 : hashMap4.entrySet()) {
                log.debug((Object)StringHelper.format((String)"\u79fb\u9664\u6587\u4ef6[%1$s]", (Object)((File)entry19.getValue()).getAbsolutePath()));
            }
            arrayList3 = pSPFStyle.getPSPFCtrlTempls();
            string78 = StringHelper.format((String)"%1$s%2$sctrl", (Object)string, (Object)File.separator);
            file = new File(string78);
            if (!file.exists()) {
                file.mkdirs();
            }
            file9 = new File(string78);
            fileArray = file9.listFiles();
            hashMap4 = new HashMap();
            object11 = fileArray;
            int n5 = ((Object)object11).length;
            boolean bl8 = false;
            while (var22_72 < n5) {
                Object object13 = object11[var22_72];
                if (((File)object13).isDirectory()) {
                    for (File file12 : ((File)object13).listFiles()) {
                        hashMap4.put(StringHelper.format((String)"%1$s%2$s%3$s", (Object)((File)object13).getName(), (Object)File.separator, (Object)file12.getName().toUpperCase()), file12);
                    }
                }
                ++var22_72;
            }
            for (PSPFCtrlTempl pSPFCtrlTempl : arrayList3) {
                String string83 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string78, (Object)File.separator, (Object)pSPFCtrlTempl.getPSCtrlTypeId());
                file = new File(string83);
                if (!file.exists()) {
                    file.mkdirs();
                }
                PSPFPubCode pSPFPubCode = (PSPFPubCode)hashMap.get(pSPFCtrlTempl.getPSPFPubCodeId());
                if (!StringHelper.isNullOrEmpty((String)pSPFCtrlTempl.getTemplCode())) {
                    object10 = StringHelper.format((String)"%1$s%2$s", (Object)pSPFPubCode.getPSPFPubCodeName(), (Object)pSPFPubCode.getCodeEXT());
                    String string84 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string83, (Object)File.separator, (Object)object10);
                    PSPFStyleService.writeFile(string84, pSPFCtrlTempl.getTemplCode());
                    hashMap4.remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string83, (Object)File.separator, (Object)((String)object10).toUpperCase()));
                }
                if (!StringHelper.isNullOrEmpty((String)pSPFCtrlTempl.getTemplCode2())) {
                    object10 = StringHelper.format((String)"%1$s_CODE2%2$s", (Object)pSPFPubCode.getPSPFPubCodeName(), (Object)pSPFPubCode.getCodeEXT());
                    String string85 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string83, (Object)File.separator, (Object)object10);
                    PSPFStyleService.writeFile(string85, pSPFCtrlTempl.getTemplCode2());
                    hashMap4.remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string83, (Object)File.separator, (Object)((String)object10).toUpperCase()));
                }
                if (!StringHelper.isNullOrEmpty((String)pSPFCtrlTempl.getTemplCode3())) {
                    object10 = StringHelper.format((String)"%1$s_CODE3%2$s", (Object)pSPFPubCode.getPSPFPubCodeName(), (Object)pSPFPubCode.getCodeEXT());
                    String string86 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string83, (Object)File.separator, (Object)object10);
                    PSPFStyleService.writeFile(string86, pSPFCtrlTempl.getTemplCode3());
                    hashMap4.remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string83, (Object)File.separator, (Object)((String)object10).toUpperCase()));
                }
                if (!StringHelper.isNullOrEmpty((String)pSPFCtrlTempl.getTemplCode4())) {
                    object10 = StringHelper.format((String)"%1$s_CODE4%2$s", (Object)pSPFPubCode.getPSPFPubCodeName(), (Object)pSPFPubCode.getCodeEXT());
                    String string87 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string83, (Object)File.separator, (Object)object10);
                    PSPFStyleService.writeFile(string87, pSPFCtrlTempl.getTemplCode4());
                    hashMap4.remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string83, (Object)File.separator, (Object)((String)object10).toUpperCase()));
                }
                object10 = pSPFCtrlTempl.getPSPFCTDetails();
                Iterator iterator = ((ArrayList)object10).iterator();
                while (iterator.hasNext()) {
                    PSPFCTDetail pSPFCTDetail = (PSPFCTDetail)iterator.next();
                    if (!DataObject.getBoolValue((Integer)pSPFCTDetail.getValidFlag(), (boolean)true)) continue;
                    if (!StringHelper.isNullOrEmpty((String)pSPFCTDetail.getTemplCode())) {
                        String string88 = StringHelper.format((String)"%1$s_%3$s%2$s", (Object)pSPFPubCode.getPSPFPubCodeName(), (Object)pSPFPubCode.getCodeEXT(), (Object)pSPFCTDetail.getPSPFCTDetailName());
                        String string89 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string83, (Object)File.separator, (Object)string88);
                        PSPFStyleService.writeFile(string89, pSPFCTDetail.getTemplCode());
                        hashMap4.remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string83, (Object)File.separator, (Object)string88.toUpperCase()));
                    }
                    if (!StringHelper.isNullOrEmpty((String)pSPFCTDetail.getTemplCode2())) {
                        String string90 = StringHelper.format((String)"%1$s_%3$s_CODE2%2$s", (Object)pSPFPubCode.getPSPFPubCodeName(), (Object)pSPFPubCode.getCodeEXT(), (Object)pSPFCTDetail.getPSPFCTDetailName());
                        String string91 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string83, (Object)File.separator, (Object)string90);
                        PSPFStyleService.writeFile(string91, pSPFCTDetail.getTemplCode2());
                        hashMap4.remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string83, (Object)File.separator, (Object)string90.toUpperCase()));
                    }
                    if (!StringHelper.isNullOrEmpty((String)pSPFCTDetail.getTemplCode3())) {
                        String string92 = StringHelper.format((String)"%1$s_%3$s_CODE3%2$s", (Object)pSPFPubCode.getPSPFPubCodeName(), (Object)pSPFPubCode.getCodeEXT(), (Object)pSPFCTDetail.getPSPFCTDetailName());
                        String string93 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string83, (Object)File.separator, (Object)string92);
                        PSPFStyleService.writeFile(string93, pSPFCTDetail.getTemplCode3());
                        hashMap4.remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string83, (Object)File.separator, (Object)string92.toUpperCase()));
                    }
                    if (StringHelper.isNullOrEmpty((String)pSPFCTDetail.getTemplCode4())) continue;
                    String string94 = StringHelper.format((String)"%1$s_%3$s_CODE4%2$s", (Object)pSPFPubCode.getPSPFPubCodeName(), (Object)pSPFPubCode.getCodeEXT(), (Object)pSPFCTDetail.getPSPFCTDetailName());
                    String string95 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string83, (Object)File.separator, (Object)string94);
                    PSPFStyleService.writeFile(string95, pSPFCTDetail.getTemplCode4());
                    hashMap4.remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string83, (Object)File.separator, (Object)string94.toUpperCase()));
                }
            }
            for (Map.Entry entry20 : hashMap4.entrySet()) {
                log.debug((Object)StringHelper.format((String)"\u79fb\u9664\u6587\u4ef6[%1$s]", (Object)((File)entry20.getValue()).getAbsolutePath()));
            }
            arrayList3 = pSPFStyle.getPSPFEditorTempls();
            string78 = StringHelper.format((String)"%1$s%2$seditor", (Object)string, (Object)File.separator);
            file = new File(string78);
            if (!file.exists()) {
                file.mkdirs();
            }
            file9 = new File(string78);
            fileArray = file9.listFiles();
            hashMap4 = new HashMap();
            object11 = fileArray;
            int n6 = ((Object)object11).length;
            boolean bl9 = false;
            while (var22_75 < n6) {
                Object object14 = object11[var22_75];
                if (((File)object14).isDirectory()) {
                    for (File file13 : ((File)object14).listFiles()) {
                        if (!file13.isDirectory()) continue;
                        for (File file14 : file13.listFiles()) {
                            if (!file14.isFile()) continue;
                            hashMap4.put(StringHelper.format((String)"%1$s%2$s%3$s%2$s%4$s", (Object)((File)object14).getName(), (Object)File.separator, (Object)file13.getName(), (Object)file14.getName().toUpperCase()), file14);
                        }
                    }
                }
                ++var22_75;
            }
            for (PSPFEditorTempl pSPFEditorTempl : arrayList3) {
                String string96 = StringHelper.format((String)"%1$s%2$s%3$s%2$s%4$s", (Object)string78, (Object)File.separator, (Object)pSPFEditorTempl.getPSEditorTypeId(), (Object)pSPFEditorTempl.getContainerType());
                file = new File(string96);
                if (!file.exists()) {
                    file.mkdirs();
                }
                PSPFPubCode pSPFPubCode = (PSPFPubCode)hashMap.get(pSPFEditorTempl.getPSPFPubCodeId());
                if (!StringHelper.isNullOrEmpty((String)pSPFEditorTempl.getTemplCode())) {
                    object10 = StringHelper.format((String)"%1$s%2$s", (Object)pSPFPubCode.getPSPFPubCodeName(), (Object)pSPFPubCode.getCodeEXT());
                    String string97 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string96, (Object)File.separator, (Object)object10);
                    PSPFStyleService.writeFile(string97, pSPFEditorTempl.getTemplCode());
                    hashMap4.remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string96, (Object)File.separator, (Object)((String)object10).toUpperCase()));
                }
                if (!StringHelper.isNullOrEmpty((String)pSPFEditorTempl.getTemplCode2())) {
                    object10 = StringHelper.format((String)"%1$s_CODE2%2$s", (Object)pSPFPubCode.getPSPFPubCodeName(), (Object)pSPFPubCode.getCodeEXT());
                    String string98 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string96, (Object)File.separator, (Object)object10);
                    PSPFStyleService.writeFile(string98, pSPFEditorTempl.getTemplCode2());
                    hashMap4.remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string96, (Object)File.separator, (Object)((String)object10).toUpperCase()));
                }
                if (!StringHelper.isNullOrEmpty((String)pSPFEditorTempl.getTemplCode3())) {
                    object10 = StringHelper.format((String)"%1$s_CODE3%2$s", (Object)pSPFPubCode.getPSPFPubCodeName(), (Object)pSPFPubCode.getCodeEXT());
                    String string99 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string96, (Object)File.separator, (Object)object10);
                    PSPFStyleService.writeFile(string99, pSPFEditorTempl.getTemplCode3());
                    hashMap4.remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string96, (Object)File.separator, (Object)((String)object10).toUpperCase()));
                }
                if (StringHelper.isNullOrEmpty((String)pSPFEditorTempl.getTemplCode4())) continue;
                object10 = StringHelper.format((String)"%1$s_CODE4%2$s", (Object)pSPFPubCode.getPSPFPubCodeName(), (Object)pSPFPubCode.getCodeEXT());
                String string100 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string96, (Object)File.separator, (Object)object10);
                PSPFStyleService.writeFile(string100, pSPFEditorTempl.getTemplCode4());
                hashMap4.remove(StringHelper.format((String)"%1$s%2$s%3$s", (Object)string96, (Object)File.separator, (Object)((String)object10).toUpperCase()));
            }
            for (Map.Entry entry21 : hashMap4.entrySet()) {
                log.debug((Object)StringHelper.format((String)"\u79fb\u9664\u6587\u4ef6[%1$s]", (Object)((File)entry21.getValue()).getAbsolutePath()));
            }
        }
    }

    public static void writeFile(String string, String string2) throws Exception {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream)new FileOutputStream(new File(string)), "UTF-8");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write(string2);
        bufferedWriter.close();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String readFile(String string) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        InputStreamReader inputStreamReader = null;
        try {
            int n;
            FileInputStream fileInputStream = new FileInputStream(string);
            inputStreamReader = new InputStreamReader((InputStream)fileInputStream, "UTF-8");
            char[] cArray = new char[4096];
            while ((n = inputStreamReader.read(cArray)) != -1) {
                stringBuffer.append(new String(cArray, 0, n));
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                }
                catch (IOException iOException) {}
            }
        }
        return stringBuffer.toString();
    }

    protected void mergeCode(PSPFStyle pSPFStyle) throws Exception {
        String string;
        boolean bl;
        int n;
        String string2;
        PSPFStyleCodeService pSPFStyleCodeService = (PSPFStyleCodeService)ServiceGlobal.getService(PSPFStyleCodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPFStyleCode> arrayList = pSPFStyleCodeService.selectByPSPFStyle(pSPFStyle);
        PSPFViewTemplService pSPFViewTemplService = (PSPFViewTemplService)ServiceGlobal.getService(PSPFViewTemplService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPFViewTempl> arrayList2 = pSPFViewTemplService.selectByPSPFStyle(pSPFStyle);
        PSPFAppTemplService pSPFAppTemplService = (PSPFAppTemplService)ServiceGlobal.getService(PSPFAppTemplService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPFAppTempl> arrayList3 = pSPFAppTemplService.selectByPSPFStyle(pSPFStyle);
        for (PSPFViewTempl entityBase : arrayList2) {
            string2 = entityBase.getTemplCode2();
            for (n = 0; n < 10; ++n) {
                bl = false;
                for (PSPFStyleCode pSPFStyleCode : arrayList) {
                    string = StringHelper.format((String)"<#SRFINC(%1$s)>", (Object)pSPFStyleCode.getPSPFStyleCodeName().toUpperCase());
                    if (string2.indexOf(string) == -1) continue;
                    string2 = string2.replace(string, pSPFStyleCode.getStyleCode());
                    bl = true;
                }
                if (!bl) break;
            }
            if (StringHelper.compare((String)string2, (String)entityBase.getTemplCode(), (boolean)false) == 0) continue;
            entityBase.setTemplCode(string2);
            pSPFViewTemplService.update(entityBase);
        }
        for (PSPFAppTempl pSPFAppTempl : arrayList3) {
            string2 = pSPFAppTempl.getTemplCode2();
            for (n = 0; n < 10; ++n) {
                bl = false;
                for (PSPFStyleCode pSPFStyleCode : arrayList) {
                    string = StringHelper.format((String)"<#SRFINC(%1$s)>", (Object)pSPFStyleCode.getPSPFStyleCodeName().toUpperCase());
                    if (string2.indexOf(string) == -1) continue;
                    string2 = string2.replace(string, pSPFStyleCode.getStyleCode());
                    bl = true;
                }
                if (!bl) break;
            }
            if (StringHelper.compare((String)string2, (String)pSPFAppTempl.getTemplCode(), (boolean)false) == 0) continue;
            pSPFAppTempl.setTemplCode(string2);
            pSPFAppTemplService.update(pSPFAppTempl);
        }
    }

    @Override
    protected void onFixStyle(PSPFStyle pSPFStyle) throws Exception {
        Object object;
        this.get((IEntity)pSPFStyle);
        if (pSPFStyle.getTemplPSPFStyle() == null) {
            return;
        }
        ArrayList<PSPFStyleCode> arrayList = pSPFStyle.getPSPFStyleCodes();
        HashMap<String, PSPFStyleCode> hashMap = new HashMap<String, PSPFStyleCode>();
        for (PSPFStyleCode object22 : arrayList) {
            hashMap.put(object22.getPSPFStyleCodeName(), object22);
        }
        PSPFViewTemplService pSPFViewTemplService = (PSPFViewTemplService)ServiceGlobal.getService(PSPFViewTemplService.class, (SessionFactory)this.getSessionFactory());
        PSPFCtrlTemplService pSPFCtrlTemplService = (PSPFCtrlTemplService)ServiceGlobal.getService(PSPFCtrlTemplService.class, (SessionFactory)this.getSessionFactory());
        PSPFAppTemplService pSPFAppTemplService = (PSPFAppTemplService)ServiceGlobal.getService(PSPFAppTemplService.class, (SessionFactory)this.getSessionFactory());
        PSPFEditorTemplService pSPFEditorTemplService = (PSPFEditorTemplService)ServiceGlobal.getService(PSPFEditorTemplService.class, (SessionFactory)this.getSessionFactory());
        for (PSPFStyle pSPFStyle2 = pSPFStyle.getTemplPSPFStyle(); pSPFStyle2 != null; pSPFStyle2 = pSPFStyle2.getTemplPSPFStyle()) {
            Object object2;
            arrayList = pSPFStyle2.getPSPFStyleCodes();
            for (PSPFStyleCode pSPFStyleCode : arrayList) {
                if (hashMap.containsKey(pSPFStyleCode.getPSPFStyleCodeName())) continue;
                pSPFStyleCode.resetPSPFStyleCodeId();
                pSPFStyleCode.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
                pSPFStyleCode.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
                try {
                    pSPFStyleCode.resetMemo();
                    pSPFStyleCode.create();
                    hashMap.put(pSPFStyleCode.getPSPFStyleCodeName(), pSPFStyleCode);
                }
                catch (Exception exception) {
                    throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u6837\u5f0f\u5b8f\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
                }
            }
            object = pSPFStyle2.getPSPFViewTempls();
            Iterator iterator = ((ArrayList)object).iterator();
            while (iterator.hasNext()) {
                object2 = (PSPFViewTempl)iterator.next();
                ((PSPFViewTemplBase)object2).resetPSPFViewTemplId();
                ((PSPFViewTemplBase)object2).resetPSPFViewTemplName();
                ((PSPFViewTemplBase)object2).setPSPFStyleId(pSPFStyle.getPSPFStyleId());
                ((PSPFViewTemplBase)object2).setPSPFStyleName(pSPFStyle.getPSPFStyleName());
                if (pSPFViewTemplService.checkKey(object2) != 0) continue;
                try {
                    ((PSPFViewTemplBase)object2).resetMemo();
                    pSPFViewTemplService.create(object2);
                }
                catch (Exception exception) {
                    throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u89c6\u56fe\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
                }
            }
            ArrayList<PSPFAppTempl> arrayList2 = pSPFStyle2.getPSPFAppTempls();
            for (PSPFAppTempl pSPFAppTempl : arrayList2) {
                pSPFAppTempl.resetPSPFAppTemplId();
                pSPFAppTempl.resetPSPFAppTemplName();
                pSPFAppTempl.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
                pSPFAppTempl.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
                if (pSPFAppTemplService.checkKey(pSPFAppTempl) != 0) continue;
                try {
                    pSPFAppTempl.resetMemo();
                    pSPFAppTemplService.create(pSPFAppTempl);
                }
                catch (Exception exception) {
                    throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5e94\u7528\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
                }
            }
            object2 = pSPFStyle2.getPSPFCtrlTempls();
            Iterator iterator2 = ((ArrayList)object2).iterator();
            while (iterator2.hasNext()) {
                PSPFCtrlTempl pSPFCtrlTempl = (PSPFCtrlTempl)iterator2.next();
                PSPFCtrlTempl pSPFCtrlTempl2 = new PSPFCtrlTempl();
                pSPFCtrlTempl.copyTo((IDataObject)pSPFCtrlTempl2, false);
                pSPFCtrlTempl2.resetPSPFCtrlTemplId();
                pSPFCtrlTempl2.resetPSPFCtrlTemplName();
                pSPFCtrlTempl2.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
                pSPFCtrlTempl2.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
                if (pSPFCtrlTemplService.checkKey(pSPFCtrlTempl2) != 0) continue;
                try {
                    pSPFCtrlTempl2.resetMemo();
                    pSPFCtrlTemplService.create(pSPFCtrlTempl2);
                    ArrayList<PSPFCTDetail> arrayList3 = pSPFCtrlTempl.getPSPFCTDetails();
                    for (PSPFCTDetail pSPFCTDetail : arrayList3) {
                        pSPFCTDetail.resetPSPFCTDetailId();
                        pSPFCTDetail.setPSPFCtrlTemplId(pSPFCtrlTempl2.getPSPFCtrlTemplId());
                        pSPFCTDetail.setPSPFCtrlTemplName(pSPFCtrlTempl2.getPSPFCtrlTemplName());
                        pSPFCTDetail.resetMemo();
                        pSPFCTDetail.create();
                    }
                }
                catch (Exception exception) {
                    throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u90e8\u4ef6\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
                }
            }
            ArrayList<PSPFEditorTempl> arrayList4 = pSPFStyle2.getPSPFEditorTempls();
            for (PSPFEditorTempl pSPFEditorTempl : arrayList4) {
                pSPFEditorTempl.resetPSPFEditorTemplId();
                pSPFEditorTempl.resetPSPFEditorTemplName();
                pSPFEditorTempl.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
                pSPFEditorTempl.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
                if (pSPFEditorTemplService.checkKey(pSPFEditorTempl) != 0) continue;
                try {
                    pSPFEditorTempl.resetMemo();
                    pSPFEditorTemplService.create(pSPFEditorTempl);
                }
                catch (Exception exception) {
                    throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u7f16\u8f91\u5668\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
                }
            }
        }
        object = new SelectCond();
        object.set("PSPFID", (Object)pSPFStyle.getPSPFId());
        object.set("PSPFSTYLEID", SelectCond.ISNULL);
        ArrayList arrayList5 = pSPFEditorTemplService.select((ISelectCond)object);
        for (PSPFEditorTempl pSPFEditorTempl : arrayList5) {
            pSPFEditorTempl.resetPSPFEditorTemplId();
            pSPFEditorTempl.resetPSPFEditorTemplName();
            pSPFEditorTempl.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
            pSPFEditorTempl.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
            if (pSPFEditorTemplService.checkKey(pSPFEditorTempl) != 0) continue;
            try {
                pSPFEditorTempl.resetMemo();
                pSPFEditorTemplService.create(pSPFEditorTempl);
            }
            catch (Exception exception) {
                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u7f16\u8f91\u5668\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
        }
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        return true;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    @Override
    public DBFetchResult fetchCurDCPF3(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSPFStyleService.fetchCurDCPF3(iDEDataSetFetchContext);
        }
        return super.fetchCurDCPF3(iDEDataSetFetchContext);
    }

    @Override
    public DBFetchResult fetchCurDCPF2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSPFStyleService.fetchCurDCPF2(iDEDataSetFetchContext);
        }
        return super.fetchCurDCPF2(iDEDataSetFetchContext);
    }

    @Override
    public DBFetchResult fetchCurDCPF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSPFStyleService.fetchCurDCPF(iDEDataSetFetchContext);
        }
        return super.fetchCurDCPF(iDEDataSetFetchContext);
    }

    @Override
    public DBFetchResult fetchCurDCPFAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSPFStyleService.fetchCurDCPFAll(iDEDataSetFetchContext);
        }
        return super.fetchCurDCPFAll(iDEDataSetFetchContext);
    }

    @Override
    public DBFetchResult fetchCurDCPFAll2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSPFStyleService.fetchCurDCPFAll2(iDEDataSetFetchContext);
        }
        return super.fetchCurDCPFAll2(iDEDataSetFetchContext);
    }

    @Override
    public DBFetchResult fetchCurPF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSPFStyleService.fetchCurDCPFAll(iDEDataSetFetchContext);
        }
        return super.fetchCurPF(iDEDataSetFetchContext);
    }
}

