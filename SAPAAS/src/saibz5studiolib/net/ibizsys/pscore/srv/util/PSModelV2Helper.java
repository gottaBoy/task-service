/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.DoubleNode
 *  com.fasterxml.jackson.databind.node.IntNode
 *  com.fasterxml.jackson.databind.node.NullNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.ISelectFilter
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectFieldFilter
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDEFieldModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectFilter;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectFieldFilter;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEFieldModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.IPSCoreSysService;
import net.ibizsys.pscore.srv.IPSModelV2Service;
import net.ibizsys.pscore.srv.IPSRawSelectWork;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.PSCoreSysServiceBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemServiceBase;
import net.ibizsys.pscore.srv.util.IPSWorkspace;
import net.ibizsys.pscore.srv.util.Inflector;
import net.ibizsys.pscore.srv.util.PSStudioConsoleHelper;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFSetting;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFSettingBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcRole;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSSysWFSettingService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcRoleService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSModelV2Helper {
    private static ObjectMapper mapper = new ObjectMapper();
    private static Map<String, String> exportModelMap = new HashMap<String, String>();
    private static HashMap<String, String> modelLogicNameMap = new HashMap();
    private static final Pattern codeNamePattern = Pattern.compile("[a-zA-Z_$][a-zA-Z0-9_$]*");
    private static final Log log;
    private SessionFactory sessionFactory = null;
    private PSSysModelInst psSysModelInst = null;
    private String strPSDSConsoleId = null;
    private String strPSSystemId = "2C40DFCD-0DF5-47BF-91A5-C45F810B0001";
    private String strPSSysModelInstId = null;
    private String strPSSystemName = "Sys";
    private static ThreadLocal<Map<String, String>> modelV2UniqueTagMap;
    private static ThreadLocal<Map<String, String>> modelV2KeyMap;
    private static ThreadLocal<Map<String, String>> modelV2UniqueKeyMap;
    private static ThreadLocal<Map<String, Integer>> modelV2CounterMap;
    private static ThreadLocal<Map<String, Integer>> modelV2CounterMap2;
    private static ThreadLocal<Map<String, String>> modelV2UniqueFileMap;
    public static final String EXPORTMODELV2_INHERITDATA = "[SRFINHERIT]";
    public static final String EXPORTMODELV2_STAR = "[SRFSTAR]";
    public static final String EXPORTMODELV2_DOT = "[SRFDOT]";
    public static final String EXPORTMODELV2_LASTFILE = "SRFLASTFILE";
    private boolean bAppendMode = true;
    private IPSWorkspace iPSWorkspace;
    private static int nBatchSize;

    public void init(String string, String string2, String string3, String string4) throws Exception {
        this.sessionFactory = PSSysModelInstGlobal.getSessionFactory(string2);
        this.psSysModelInst = PSSysModelInstGlobal.getPSSysModelInst(string2);
        this.strPSSysModelInstId = string2;
        this.strPSDSConsoleId = string4;
        if (!StringHelper.isNullOrEmpty((String)string)) {
            this.strPSSystemId = string;
        }
        if (!StringHelper.isNullOrEmpty((String)string3)) {
            this.strPSSystemName = string3;
        }
    }

    public void init(String string, String string2, String string3) throws Exception {
        this.init(string, string2, null, null);
    }

    public void init(String string, String string2) throws Exception {
        this.init(string, string2, null);
    }

    public String getPSSystemId() {
        return this.strPSSystemId;
    }

    public String getPSSysModelInstId() {
        return this.strPSSysModelInstId;
    }

    public IPSWorkspace getPSWorkspace() {
        return this.iPSWorkspace;
    }

    public void setPSWorkspace(IPSWorkspace iPSWorkspace) {
        this.iPSWorkspace = iPSWorkspace;
    }

    public static int getBatchSize() {
        return nBatchSize;
    }

    public static void setBatchSize(int n) {
        if (n > 0 && n <= 2000) {
            nBatchSize = n;
        }
    }

    public void quit() {
    }

    public int export(String string, String string2) throws Exception {
        return this.export(string, string2, true);
    }

    /*
     * WARNING - void declaration
     */
    public int export(String string, String string2, boolean bl) throws Exception {
        int n;
        Iterator<Object> iterator;
        Object object;
        Object object2;
        ConcurrentHashMap<String, String> concurrentHashMap;
        Object object3;
        Object object4;
        Object object5;
        if (StringHelper.isNullOrEmpty((String)string) || StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5bfc\u51fa\u76ee\u5f55");
        }
        Map<String, String> map = this.getExportDataMap();
        map.remove("PSDCTASKLOG");
        map.remove("PSSTUDIOSERVERLOG");
        map.remove("PSBKTASKLOG");
        map.remove("PSTASKSERVERLOG");
        map.remove("PSDEVCENTERLOG");
        map.remove("PSDSBOOKINGLOG");
        map.remove("PSASBOOKINGLOG");
        map.remove("PSDCROBOTLOG");
        map.remove("PSSYSDBCHGLOG");
        map.remove("PSSYSDMITEMLOG");
        map.remove("PSSYSDEVBKTASK");
        map.remove("PSSYSRUNSESSION");
        map.remove("PSSYSRUNLOG");
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        arrayList.addAll(map.keySet());
        arrayList.remove("PSDEDQCODEEXP");
        arrayList.remove("PSSYSDMITEM");
        arrayList.remove("PSDEFDTCOL");
        arrayList.remove("PSDEFFORMITEM");
        arrayList.remove("PSDEFORMDETAIL");
        arrayList.remove("PSDEFIELD");
        arrayList.remove("PSDEVIEWCTRL");
        arrayList.remove("PSLANGUAGERES");
        arrayList.remove("PSDEFSFITEM");
        arrayList.remove("PSDEACTION");
        arrayList.remove("PSDEVIEWBASE");
        arrayList.remove("PSDEFINPUTTIP");
        arrayList.remove("PSCODEITEM");
        arrayList.remove("PSDEGRIDCOL");
        arrayList.add(0, "PSDEVIEWCTRL");
        arrayList.add(0, "PSLANGUAGERES");
        arrayList.add(0, "PSDEFSFITEM");
        arrayList.add(0, "PSDEACTION");
        arrayList.add(0, "PSDEVIEWBASE");
        arrayList.add(0, "PSDEFINPUTTIP");
        arrayList.add(0, "PSCODEITEM");
        arrayList.add(0, "PSDEGRIDCOL");
        arrayList.add(0, "PSDEDQCODEEXP");
        arrayList.add(0, "PSDEFFORMITEM");
        arrayList.add(0, "PSDEFORMDETAIL");
        arrayList.add(0, "PSDEFIELD");
        arrayList.add(0, "PSSYSDMITEM");
        arrayList.add(0, "PSDEFDTCOL");
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("PSSYSVIEWLOGIC", "CODENAME");
        hashMap.put("PSSYSSAHANDLER", "CODENAME");
        hashMap.put("PSSYSDYNAMODEL", "CODENAME");
        hashMap.put("PSSYSCOUNTER", "CODENAME");
        hashMap.put("PSSYSPDTVIEW", "CODENAME");
        hashMap.put("PSSYSIMAGE", "CODENAME");
        hashMap.put("PSSYSCSSCAT", "CODENAME");
        hashMap.put("PSSYSCSS", "CODENAME");
        hashMap.put("PSDETOOLBAR", "CODENAME");
        hashMap.put("PSACHANDLER", "CODENAME");
        hashMap.put("PSAPPFUNC", "CODENAME");
        hashMap.put("PSSYSPFPLUGIN", "CODENAME");
        hashMap.put("PSSUBVIEWTYPE", "CODENAME");
        hashMap.put("PSDEUAGROUP", "CODENAME");
        hashMap.put("PSCTRLMSG", "CODENAME");
        hashMap.put("PSSYSUNIT", "CODENAME");
        hashMap.put("PSSYSSFPLUGIN", "CODENAME");
        hashMap.put("PSDEDRGROUP", "CODENAME");
        hashMap.put("PSDEDRITEM", "CODENAME");
        hashMap.put("PSLANGUAGERES", "CODENAME");
        hashMap.put("PSSYSWFSETTING", "CODENAME");
        hashMap.put("PSDEFFORMITEM", "CODENAME");
        hashMap.put("PSSYSEDITORSTYLE", "CODENAME");
        hashMap.put("PSSYSVALUERULE", "CODENAME");
        hashMap.put("PSAPPTITLEBAR", "CODENAME");
        hashMap.put("PSMOBAPPPACK", "CODENAME");
        hashMap.put("PSMOBAPPPACKTD", "CODENAME");
        hashMap.put("PSSYSVIEWPANEL", "CODENAME");
        hashMap.put("PSSYSDBVF", "CODENAME");
        hashMap.put("PSSYSDELOGICNODE", "CODENAME");
        hashMap.put("PSDEACTIONLOGIC", "CODENAME");
        hashMap.put("PSSYSMSGTEMPL", "CODENAME");
        hashMap.put("PSSYSDICTCAT", "CODENAME");
        hashMap.put("PSSYSFILE", "CODENAME");
        hashMap.put("PSSYSMODELGROUP", "CODENAME");
        hashMap.put("PSSYSSEARCHBAR", "CODENAME");
        hashMap.put("PSWFWORKTIME", "CODENAME");
        hashMap.put("PSDEACTIONTEMPL", "CODENAME");
        hashMap.put("PSCODELIST", "CODENAME");
        hashMap.put("PSDESAMPLEDATA", "CODENAME");
        hashMap.put("PSWXMENU", "CODENAME");
        hashMap.put("PSWXMENUFUNC", "CODENAME");
        hashMap.put("PSDEACTIONWIZARD", "CODENAME");
        hashMap.put("PSSYSDATASYNCAGENT", "CODENAME");
        hashMap.put("PSSYSTESTCASE", "CODENAME");
        hashMap.put("PSSYSOPPRIV", "CODENAME");
        hashMap.put("PSSYSDBSCHEME", "CODENAME");
        hashMap.put("PSDEFINPUTTIP", "CODENAME");
        hashMap.put("PSDEFINPUTTIPSET", "CODENAME");
        hashMap.put("PSSYSSAMPLEVALUE", "CODENAME");
        hashMap.put("PSDEDTSQUEUE", "CODENAME");
        hashMap.put("PSSYSUSERMODE", "CODENAME");
        hashMap.put("PSSYSREQITEM", "CODENAME");
        hashMap.put("PSSYSREQMODULE", "CODENAME");
        hashMap.put("PSSYSCONTENTCAT", "CODENAME");
        hashMap.put("PSSYSCONTENT", "CODENAME");
        hashMap.put("PSSYSACTOR", "CODENAME");
        hashMap.put("PSSYSUSERCASE", "CODENAME");
        hashMap.put("PSSYSUSERCASERS", "CODENAME");
        hashMap.put("PSSYSUCMAP", "CODENAME");
        hashMap.put("PSSYSTESTDATA", "CODENAME");
        hashMap.put("PSHELPMODULE", "CODENAME");
        hashMap.put("PSHELPRESOURCE", "CODENAME");
        hashMap.put("PSHELPARTICLE", "CODENAME");
        hashMap.put("PSHELPSECTION", "CODENAME");
        hashMap.put("PSSYSTESTMODULE", "CODENAME");
        hashMap.put("PSHELPPRJ", "CODENAME");
        hashMap.put("PSCTRLLOGICGROUP", "CODENAME");
        hashMap.put("PSVIEWMSG", "CODENAME");
        hashMap.put("PSVIEWMSGGROUP", "CODENAME");
        hashMap.put("PSVIEWWIZARDGROUP", "CODENAME");
        hashMap.put("PSSYSTASK", "CODENAME");
        hashMap.put("PSSYSBDSCHEME", "CODENAME");
        hashMap.put("PSWFLINK", "CODENAME");
        hashMap.put("PSAPPUTILPAGE", "CODENAME");
        HashMap<String, String> hashMap2 = new HashMap<String, String>();
        hashMap2.put("PSWFLINK", "");
        hashMap2.put("PSDEUAGRPDETAIL", "");
        hashMap2.put("PSDELOGICLINK", "");
        hashMap2.put("PSDETREENODERS", "");
        hashMap2.put("PSDEFIUDETAIL", "");
        boolean bl2 = PSCoreSysServiceBase.isEnableMergeCount();
        try {
            Object object6;
            PSWorkflow pSWorkflow;
            Serializable serializable22;
            PSCoreSysServiceBase.setEnableMergeCount(false);
            object5 = PSSysModelInstGlobal.getSessionFactory(this.strPSSysModelInstId);
            if (!StringHelper.isNullOrEmpty((String)this.getPSSystemId())) {
                object4 = new PSSysWFSetting();
                ((PSSysWFSettingBase)object4).setPSSysWFSettingId(this.getPSSystemId());
                object3 = (PSSysWFSettingService)ServiceGlobal.getService(PSSysWFSettingService.class, (SessionFactory)object5);
                ((PSSysWFSettingService)object3).rebuildPSWFUtilActions((PSSysWFSetting)object4);
            }
            object4 = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)object5);
            object3 = new SelectCond();
            if (!StringHelper.isNullOrEmpty((String)this.getPSSystemId())) {
                object3.set("PSSYSTEMID", (Object)this.getPSSystemId());
            }
            ArrayList arrayList5 = object4.select((ISelectCond)object3);
            for (Serializable serializable22 : arrayList5) {
                ((PSWFVersionService)object4).rebuildPSDEUIActions((PSWFVersion)serializable22);
            }
            concurrentHashMap = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)object5);
            object3.reset();
            if (!StringHelper.isNullOrEmpty((String)this.getPSSystemId())) {
                object3.set("PSSYSTEMID", (Object)this.getPSSystemId());
            }
            serializable22 = concurrentHashMap.select((ISelectCond)object3);
            Object object7 = ((ArrayList)serializable22).iterator();
            while (object7.hasNext()) {
                pSWorkflow = (PSWorkflow)object7.next();
                ((PSWorkflowService)((Object)concurrentHashMap)).rebuildPSDEUIActions(pSWorkflow);
            }
            object7 = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)object5);
            pSWorkflow = new SelectCond();
            object2 = object7.select((ISelectCond)pSWorkflow);
            object = new HashMap<String, PSWFProcRole>();
            ArrayList<PSWFProcRole> arrayList6 = new ArrayList<PSWFProcRole>();
            iterator = ((ArrayList)object2).iterator();
            while (iterator.hasNext()) {
                PSWFProcRole object8 = (PSWFProcRole)iterator.next();
                String string3 = String.format("%1$s|%2$s", object8.getPSWFProcessId(), object8.getPSWFProcRoleName());
                if (((HashMap)object).containsKey(string3)) {
                    arrayList6.add(object8);
                    continue;
                }
                ((HashMap)object).put(string3, object8);
            }
            for (PSWFProcRole string7 : arrayList6) {
                int n2 = 1;
                while (((HashMap)object).containsKey(object6 = String.format("%1$s|%2$s(%3$s)", string7.getPSWFProcessId(), string7.getPSWFProcRoleName(), ++n2))) {
                }
                PSWFProcRole pSWFProcRole = new PSWFProcRole();
                pSWFProcRole.setPSWFProcRoleId(string7.getPSWFProcRoleId());
                pSWFProcRole.setPSWFProcRoleName(String.format("%1$s(%2$s)", string7.getPSWFProcRoleName(), n2));
                ((PSCoreSysServiceBaseBase)((Object)object7)).sysUpdate(pSWFProcRole, false);
                ((HashMap)object).put(object6, pSWFProcRole);
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                Object object82;
                IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)((String)entry.getKey()), (boolean)true);
                if (iDataEntityModel == null) continue;
                object6 = iDataEntityModel.getDEField((String)entry.getValue(), true);
                if (object6 == null) {
                    log.warn((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u4ee3\u7801\u540d\u79f0\u5c5e\u6027[%2$s]", entry.getKey(), entry.getValue()));
                    continue;
                }
                boolean bl3 = iDataEntityModel.getName().equals("PSDEFFORMITEM");
                PSSysModelInstGlobal.active(this.strPSSysModelInstId);
                HashMap<String, String> hashMap3 = new HashMap<String, String>();
                IService iService = iDataEntityModel.getService((SessionFactory)object5);
                SelectContext selectContext = new SelectContext();
                selectContext.addSelectField(object6.getName());
                SelectFieldFilter selectFieldFilter = new SelectFieldFilter();
                selectFieldFilter.setDEFName(object6.getName());
                selectFieldFilter.setCondOp("ISNOTNULL");
                selectContext.setSelectFilter((ISelectFilter)selectFieldFilter);
                ArrayList arrayList7 = iService.select((ISelectCond)selectContext);
                for (Object object82 : arrayList7) {
                    String string4 = DataObject.getStringValue((Object)((IEntity)object82).get(object6.getName()));
                    hashMap3.put(string4.toUpperCase(), "");
                }
                selectContext.reset();
                selectContext.addSelectField(iService.getDEModel().getKeyDEField().getName());
                if (bl3) {
                    selectContext.addSelectField("FTMODE");
                }
                selectFieldFilter.setCondOp("ISNULL");
                selectContext.setSelectFilter((ISelectFilter)selectFieldFilter);
                arrayList7 = iService.select((ISelectCond)selectContext);
                int n3 = 0;
                object82 = iService.getDEModel().getKeyDEField().getName();
                for (Object e : arrayList7) {
                    IEntity iEntity;
                    String string5;
                    String string6 = DataObject.getStringValue((Object)((IEntity)e).get(object82));
                    if (bl3) {
                        string5 = DataObject.getStringValue((Object)((IEntity)e).get("FTMODE"));
                        if ("DEFAULT".equals(string5)) {
                            iEntity = iService.getDEModel().createEntity();
                            iEntity.set(object82, (Object)string6);
                            iEntity.set("CODENAME", (Object)"Default");
                            EntityBase.setIgnoreCheck((IEntity)iEntity, (boolean)true);
                            iService.sysUpdate(iEntity, false);
                            continue;
                        }
                        if ("MOBILEDEFAULT".equals(string5)) {
                            iEntity = iService.getDEModel().createEntity();
                            iEntity.set(object82, (Object)string6);
                            iEntity.set("CODENAME", (Object)"MobileDefault");
                            EntityBase.setIgnoreCheck((IEntity)iEntity, (boolean)true);
                            iService.sysUpdate(iEntity, false);
                            continue;
                        }
                    }
                    if (!hashMap3.containsKey((string5 = StringHelper.format((String)"A%1$s", (Object)KeyValueHelper.genUniqueId((String)string6).substring(0, 18))).toUpperCase())) {
                        iEntity = iService.getDEModel().createEntity();
                        iEntity.set(object82, (Object)string6);
                        iEntity.set(object6.getName(), (Object)string5);
                        EntityBase.setIgnoreCheck((IEntity)iEntity, (boolean)true);
                        iService.sysUpdate(iEntity, false);
                        hashMap3.put(string5.toUpperCase(), "");
                        continue;
                    }
                    while (hashMap3.containsKey((string5 = StringHelper.format((String)"Auto%1$s", (Object)(++n3))).toUpperCase())) {
                    }
                    iEntity = iService.getDEModel().createEntity();
                    iEntity.set(object82, (Object)string6);
                    iEntity.set(object6.getName(), (Object)string5);
                    EntityBase.setIgnoreCheck((IEntity)iEntity, (boolean)true);
                    iService.sysUpdate(iEntity, false);
                    hashMap3.put(string5.toUpperCase(), "");
                }
            }
            PSCoreSysServiceBase.setEnableMergeCount(bl2);
        }
        catch (Exception exception) {
            PSCoreSysServiceBase.setEnableMergeCount(bl2);
            throw exception;
        }
        object5 = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.sessionFactory);
        object4 = new PSSystem();
        ((PSSystemBase)object4).setPSSystemId(this.strPSSystemId);
        if (!((PSSystemService)object5).get((PSSystem)object4, true) && ((ArrayList)(object3 = object5.select((ISelectCond)new SelectCond()))).size() > 0) {
            object4 = (PSSystem)((ArrayList)object3).get(0);
        }
        boolean bl4 = (1 & (n = DataObject.getIntegerValue((Object)((PSSystemBase)object4).getModelV2ExpMode(), (Integer)0).intValue())) == 1;
        concurrentHashMap = new ConcurrentHashMap<String, String>();
        this.sendStudioConsole(null, "DEBUG", "[\u5f00\u59cb\u6267\u884c] \u63d0\u53d6\u6a21\u578b\u6570\u636e");
        long l = System.currentTimeMillis();
        int n4 = arrayList.size();
        object2 = this.strPSSysModelInstId;
        object = Executors.newCachedThreadPool();
        for (int i = 0; i < 8; ++i) {
            object.execute(new Runnable((String)object2, arrayList3, arrayList, bl4, hashMap2, string2, concurrentHashMap, arrayList2, n4){
                final /* synthetic */ String val$strDstPSSysModelInstId;
                final /* synthetic */ ArrayList val$errorList;
                final /* synthetic */ ArrayList val$importModelList;
                final /* synthetic */ boolean val$bOPInfo;
                final /* synthetic */ Map val$viewDataMap;
                final /* synthetic */ String val$strResFolder;
                final /* synthetic */ Map val$modelLinkMap;
                final /* synthetic */ ArrayList val$importModelList2;
                final /* synthetic */ int val$nTotalModelCnt;
                {
                    this.val$strDstPSSysModelInstId = string;
                    this.val$errorList = arrayList;
                    this.val$importModelList = arrayList2;
                    this.val$bOPInfo = bl;
                    this.val$viewDataMap = map;
                    this.val$strResFolder = string2;
                    this.val$modelLinkMap = map2;
                    this.val$importModelList2 = arrayList3;
                    this.val$nTotalModelCnt = n;
                }

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 * Converted monitor instructions to comments
                 * Lifted jumps to return sites
                 */
                @Override
                public void run() {
                    String string = null;
                    try {
                        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory(this.val$strDstPSSysModelInstId);
                        while (this.val$errorList.size() == 0) {
                            IPSModelV2Service iPSModelV2Service;
                            Iterator iterator;
                            IService iService;
                            string = null;
                            ArrayList arrayList = this.val$importModelList;
                            // MONITORENTER : arrayList
                            if (this.val$importModelList.size() > 0) {
                                string = (String)this.val$importModelList.remove(0);
                            }
                            // MONITOREXIT : arrayList
                            if (StringHelper.isNullOrEmpty((String)string)) {
                                return;
                            }
                            PSSysModelInstGlobal.active(this.val$strDstPSSysModelInstId);
                            arrayList = DEModelGlobal.getDEModel((String)string, (boolean)true);
                            if (arrayList == null || !((iService = arrayList.getService(sessionFactory)) instanceof IPSModelV2Service)) continue;
                            ArrayList<String> arrayList2 = new ArrayList<String>();
                            if (!this.val$bOPInfo) {
                                arrayList2.add("CREATEMAN");
                                arrayList2.add("UPDATEDATE");
                                arrayList2.add("UPDATEMAN");
                            }
                            if ((iterator = arrayList.getDEFields()) != null) {
                                while (iterator.hasNext()) {
                                    iPSModelV2Service = (IDEFieldModel)iterator.next();
                                    if (StringHelper.isNullOrEmpty((String)iPSModelV2Service.getUserTag()) || StringHelper.compare((String)"IGNOREMODELV2", (String)iPSModelV2Service.getUserTag(), (boolean)true) != 0) continue;
                                    arrayList2.add(iPSModelV2Service.getName());
                                }
                            }
                            iPSModelV2Service = (IPSModelV2Service)iService;
                            String string2 = StringHelper.format((String)"select * from %1$s ", (Object)arrayList.getTableName());
                            if ((arrayList.getInheritDEModel() != null || this.val$viewDataMap.containsKey(arrayList.getName())) && !StringHelper.isNullOrEmpty((String)arrayList.getViewName())) {
                                string2 = StringHelper.format((String)"select * from %1$s ", (Object)arrayList.getViewName());
                            }
                            ((IPSCoreSysService)iService).selectRaw(string2, null, new ExportHelper(this.val$strResFolder, iPSModelV2Service, this.val$modelLinkMap, arrayList2));
                            ArrayList arrayList3 = this.val$importModelList2;
                            // MONITORENTER : arrayList3
                            this.val$importModelList2.add(string);
                            String string3 = StringHelper.format((String)"\u63d0\u53d6[%1$s]\uff0c\u5f53\u524d\u5df2\u5b8c\u6210 %2$s/%3$s", (Object)string, (Object)this.val$importModelList2.size(), (Object)this.val$nTotalModelCnt);
                            log.debug((Object)string3);
                            PSModelV2Helper.this.sendStudioConsole(null, "INFO", string3);
                            // MONITOREXIT : arrayList3
                        }
                        return;
                    }
                    catch (Exception exception) {
                        if (StringHelper.isNullOrEmpty(string)) {
                            string = "\u672a\u77e5\u6a21\u578b";
                        }
                        String string4 = StringHelper.format((String)"[%1$s] %2$s", (Object)string, (Object)exception.getMessage());
                        this.val$errorList.add(string4);
                        StringBuilderEx stringBuilderEx = new StringBuilderEx();
                        exception.printStackTrace(new PrintWriter(stringBuilderEx.getWriter()));
                        string4 = StringHelper.format((String)"\u63d0\u53d6[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)string, (Object)stringBuilderEx.toString());
                        PSModelV2Helper.this.sendStudioConsole(null, "ERROR", string4);
                        log.error((Object)exception);
                    }
                }
            });
        }
        long l2 = 0L;
        while (arrayList2.size() != n4 && arrayList3.size() == 0) {
            Thread.sleep(50L);
            if (System.currentTimeMillis() - l2 < 10000L) continue;
            PSSysModelInstGlobal.active(this.getPSSysModelInstId());
            l2 = System.currentTimeMillis();
        }
        object.shutdown();
        if (arrayList3.size() > 0) {
            throw new Exception("\u63d0\u53d6\u53d1\u751f\u9519\u8bef");
        }
        boolean bl5 = false;
        Object object9 = arrayList4.iterator();
        while (object9.hasNext()) {
            int n5 = (Integer)object9.next();
            var24_43 += n5;
        }
        object9 = StringHelper.format((String)"[\u7ed3\u675f\u6267\u884c] \u63d0\u53d6\u6a21\u578b\u6570\u636e\uff0c\u8017\u65f6[%1$s]ms", (Object)(System.currentTimeMillis() - l));
        log.debug(object9);
        this.sendStudioConsole(null, "INFO", (String)object9);
        ConcurrentHashMap<String, String> concurrentHashMap2 = new ConcurrentHashMap<String, String>();
        boolean bl52 = PSCoreSysServiceBase.isSimpleImportExportMode();
        try {
            void var24_48;
            Iterator iterator2;
            this.sendStudioConsole(null, "DEBUG", "[\u5f00\u59cb\u6267\u884c] \u5bfc\u51fa\u6a21\u578b\u6587\u4ef6");
            long l3 = System.currentTimeMillis();
            object = new ArrayList<String>();
            if (!bl4) {
                object.add("CREATEMAN");
                object.add("UPDATEDATE");
                object.add("UPDATEMAN");
            }
            if ((iterator2 = ((PSSystemServiceBase)object5).getDEModel().getDEFields()) != null) {
                while (iterator2.hasNext()) {
                    iterator = (IDEFieldModel)iterator2.next();
                    if (StringHelper.isNullOrEmpty((String)iterator.getUserTag()) || StringHelper.compare((String)"IGNOREMODELV2", (String)iterator.getUserTag(), (boolean)true) != 0) continue;
                    object.add(iterator.getName());
                }
            }
            iterator = object.iterator();
            while (iterator.hasNext()) {
                String string7 = (String)iterator.next();
                ((PSSystemBase)object4).remove(string7);
            }
            PSModelV2Helper.setUniqueFileMap(concurrentHashMap2);
            PSModelV2Helper.setUniqueTagMap(concurrentHashMap);
            PSCoreSysServiceBase.setSimpleImportExportMode(false);
            ((PSCoreSysServiceBase)object5).exportModelV2(object4, string, string2);
            PSCoreSysServiceBase.setSimpleImportExportMode(bl52);
            PSModelV2Helper.setUniqueTagMap(null);
            PSModelV2Helper.setUniqueFileMap(null);
            concurrentHashMap.clear();
            concurrentHashMap2.clear();
            int n7 = -1;
            if (bl) {
                n7 = this.compile(string + "2", string, true);
            }
            Object var24_45 = null;
            if (n7 == -1) {
                String string8 = StringHelper.format((String)"[\u7ed3\u675f\u6267\u884c] \u5bfc\u51fa\u6a21\u578b\u6587\u4ef6\uff0c\u8017\u65f6[%1$s]ms", (Object)(System.currentTimeMillis() - l3));
            } else {
                String string9 = StringHelper.format((String)"[\u7ed3\u675f\u6267\u884c] \u5bfc\u51fa\u6a21\u578b\u6587\u4ef6\uff0c\u6a21\u578b\u9879\u603b\u8ba1[%2$s]\uff0c\u8017\u65f6[%1$s]ms", (Object)(System.currentTimeMillis() - l3), (Object)n7);
            }
            log.debug((Object)var24_48);
            this.sendStudioConsole(null, "INFO", (String)var24_48);
            return n7;
        }
        catch (Exception exception) {
            PSCoreSysServiceBase.setSimpleImportExportMode(bl52);
            object2 = new StringBuilderEx();
            exception.printStackTrace(new PrintWriter(object2.getWriter()));
            object = StringHelper.format((String)"\u5bfc\u51fa\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)object2.toString());
            this.sendStudioConsole(null, "ERROR", (String)object);
            PSModelV2Helper.setUniqueTagMap(null);
            PSModelV2Helper.setUniqueFileMap(null);
            throw exception;
        }
    }

    /*
     * WARNING - void declaration
     */
    public int compile(String string, String string2, boolean bl) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string) || StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5bfc\u51fa\u76ee\u5f55");
        }
        PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.sessionFactory);
        PSSystem pSSystem = new PSSystem();
        pSSystem.setSessionFactory(this.sessionFactory);
        pSSystem.setPSSystemId(this.strPSSystemId);
        if (!StringHelper.isNullOrEmpty((String)this.strPSSystemName)) {
            pSSystem.setPSSystemName(this.strPSSystemName);
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();
        ConcurrentHashMap<String, Integer> concurrentHashMap2 = new ConcurrentHashMap<String, Integer>();
        ConcurrentHashMap<String, String> concurrentHashMap3 = new ConcurrentHashMap<String, String>();
        boolean bl2 = PSCoreSysServiceBase.isSimpleImportExportMode();
        try {
            this.sendStudioConsole(null, "DEBUG", "[\u5f00\u59cb\u6267\u884c] \u7f16\u8bd1\u6a21\u578b\u6587\u4ef6");
            PSCoreSysServiceBase.beginImpSysModel(pSSystem);
            PSModelV2Helper.setKeyMap(concurrentHashMap);
            PSModelV2Helper.setUniqueKeyMap(concurrentHashMap3);
            if (bl) {
                PSModelV2Helper.setCounterMap(concurrentHashMap2);
                PSModelV2Helper.setCounterMap2(null);
            } else {
                PSModelV2Helper.setCounterMap(null);
                PSModelV2Helper.setCounterMap2(concurrentHashMap2);
            }
            PSCoreSysServiceBase.setSimpleImportExportMode(false);
            pSSystemService.compileModelV2(pSSystem, null, string, string2, 1);
            pSSystemService.compileModelV2(pSSystem, null, string, string2, 2);
            PSCoreSysServiceBase.setSimpleImportExportMode(bl2);
            concurrentHashMap.clear();
            PSModelV2Helper.setCounterMap(null);
            PSModelV2Helper.setCounterMap2(null);
            PSModelV2Helper.setKeyMap(null);
            PSModelV2Helper.setUniqueKeyMap(null);
            PSCoreSysServiceBase.endImpSysModel(true);
            this.sendStudioConsole(null, "INFO", "[\u7ed3\u675f\u6267\u884c] \u7f16\u8bd1\u6a21\u578b\u6587\u4ef6");
        }
        catch (Exception exception) {
            PSCoreSysServiceBase.setSimpleImportExportMode(bl2);
            StringBuilderEx stringBuilderEx = new StringBuilderEx();
            exception.printStackTrace(new PrintWriter(stringBuilderEx.getWriter()));
            String string3 = StringHelper.format((String)"\u7f16\u8bd1\u6a21\u578b\u6587\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)stringBuilderEx.toString());
            this.sendStudioConsole(null, "ERROR", string3);
            String n5 = (String)concurrentHashMap.get(EXPORTMODELV2_LASTFILE);
            concurrentHashMap.clear();
            PSModelV2Helper.setCounterMap(null);
            PSModelV2Helper.setCounterMap2(null);
            PSModelV2Helper.setKeyMap(null);
            PSModelV2Helper.setUniqueKeyMap(null);
            PSCoreSysServiceBase.endImpSysModel(true);
            if (StringHelper.isNullOrEmpty((String)n5)) {
                throw exception;
            }
            File iterator = new File(n5);
            String string4 = iterator.getCanonicalPath().replace(new File(string2).getCanonicalPath(), "");
            string4 = string4.replace("\\", "/");
            throw new Exception(StringHelper.format((String)"%1$s\uff0c\u6587\u4ef6(%2$s)", (Object)exception.getMessage(), (Object)string4), exception);
        }
        int n = 0;
        if (bl) {
            void object;
            Map<String, String> map = this.getExportDataMap();
            map.remove("PSDCTASKLOG");
            map.remove("PSSTUDIOSERVERLOG");
            map.remove("PSBKTASKLOG");
            map.remove("PSTASKSERVERLOG");
            map.remove("PSDEVCENTERLOG");
            map.remove("PSDSBOOKINGLOG");
            map.remove("PSASBOOKINGLOG");
            map.remove("PSDCROBOTLOG");
            map.remove("PSSYSDBCHGLOG");
            map.remove("PSSYSDMITEMLOG");
            map.remove("PSSYSDEVBKTASK");
            map.remove("PSSYSRUNSESSION");
            map.remove("PSSYSRUNLOG");
            boolean n2 = false;
            for (Map.Entry entry : concurrentHashMap2.entrySet()) {
                ArrayList arrayList;
                int n3;
                int n4 = 0;
                if (entry.getValue() != null) {
                    n4 = (Integer)entry.getValue();
                }
                if ((n3 = DataObject.getIntegerValue((Object)((IEntity)(arrayList = pSSystemService.selectRaw(StringHelper.format((String)"SELECT COUNT(1) AS CNT FROM T_SRF%1$s", entry.getKey()), null)).get(0)).get("CNT"), (Integer)-1).intValue()) != n4) {
                    log.warn((Object)StringHelper.format((String)"\u6a21\u578b[%1$s]\u8ba1\u6570[%2$s][%3$s]\u4e0d\u4e00\u81f4", entry.getKey(), (Object)n3, (Object)n4));
                }
                object += n3;
                n += n4;
                map.remove(entry.getKey());
            }
            log.debug((Object)StringHelper.format((String)"\u67e5\u8be2\u5408\u8ba1[%1$s]\u6a21\u578b\u5408\u8ba1[%2$s]", (Object)((int)object), (Object)n));
            for (String string5 : map.keySet()) {
                ArrayList arrayList = pSSystemService.selectRaw(StringHelper.format((String)"SELECT COUNT(1) AS CNT FROM T_SRF%1$s", (Object)string5), null);
                if (DataObject.getIntegerValue((Object)((IEntity)arrayList.get(0)).get("CNT"), (Integer)-1) == 0) continue;
                log.warn((Object)StringHelper.format((String)"\u6a21\u578b[%1$s]\u8ba1\u6570\u4e0d\u4e3a0", (Object)string5));
            }
        } else {
            for (Map.Entry entry : concurrentHashMap2.entrySet()) {
                int n5 = 0;
                if (entry.getValue() != null) {
                    n5 = (Integer)entry.getValue();
                }
                n += n5;
            }
            if (this.getPSWorkspace() != null) {
                List<IEntity> list;
                int n6 = this.getPSWorkspace().getTotalPSModelLimit();
                if (n6 != -1 && n > n6) {
                    throw new Exception(StringHelper.format((String)"\u5bfc\u5165\u6a21\u578b\u9879\u6570\u91cf[%1$s]\u8d85\u51fa\u751f\u4ea7\u7ebf\u9650\u5236[%2$s]\uff0c\u65e0\u6cd5\u5bfc\u5165", (Object)n, (Object)n6));
                }
                n6 = this.getPSWorkspace().getPSModelLimit("PSDATAENTITY");
                if (n6 != -1 && (list = this.getPSModel(string + File.separator + "DATAS", "PSDATAENTITY")) != null && list.size() > 0) {
                    HashMap<String, String> hashMap = null;
                    Iterator<String> iterator = this.getPSWorkspace().getEntities();
                    if (iterator != null) {
                        hashMap = new HashMap<String, String>();
                        while (iterator.hasNext()) {
                            hashMap.put(iterator.next(), "");
                        }
                    }
                    int n7 = 0;
                    for (IEntity iEntity : list) {
                        String string6;
                        PSDataEntity pSDataEntity = (PSDataEntity)iEntity;
                        if (DataObject.getIntegerValue((Object)pSDataEntity.getValidFlag(), (Integer)1) != 1 || hashMap != null && !StringHelper.isNullOrEmpty((String)pSDataEntity.getPSDataEntityName()) && !StringHelper.isNullOrEmpty((String)(string6 = (String)hashMap.remove(pSDataEntity.getPSDataEntityName().toUpperCase())))) continue;
                        ++n7;
                    }
                    if (n7 > n6) {
                        throw new Exception(StringHelper.format((String)"\u5bfc\u5165\u6a21\u578b[PSDATAENTITY|\u5b9e\u4f53]\u6570\u91cf[%1$s]\u8d85\u51fa\u751f\u4ea7\u7ebf\u9650\u5236[%2$s]\uff0c\u65e0\u6cd5\u5bfc\u5165", (Object)n7, (Object)n6));
                    }
                }
            }
        }
        log.debug((Object)StringHelper.format((String)"\u7f16\u8bd1\u6a21\u578b\u9879\u6570\u91cf[%1$s]", (Object)n));
        return n;
    }

    protected List<IEntity> getPSModel(String string, String string2) throws Exception {
        ArrayList<IEntity> arrayList = new ArrayList<IEntity>();
        File file = new File(string + File.separator + string2 + File.separator + "ALL.txt");
        if (!file.exists()) {
            return arrayList;
        }
        IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)string2, (boolean)true);
        IService iService = iDataEntityModel.getService(this.sessionFactory);
        ArrayList<String> arrayList2 = PSModelV2Helper.readFile2(file);
        for (String string3 : arrayList2) {
            if (StringHelper.isNullOrEmpty((String)string3)) continue;
            ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string3);
            IEntity iEntity = iDataEntityModel.createEntity();
            PSModelV2Helper.fromJSONObject((IDataObject)iEntity, objectNode, true);
            arrayList.add(iEntity);
        }
        return arrayList;
    }

    public void import2(final String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5bfc\u5165\u76ee\u5f55");
        }
        long l = System.currentTimeMillis();
        Map<String, String> map = this.getExportDataMap();
        map.put("PSSYSTEM", "T_SRFPSSYSTEM");
        map.remove("PSDCTASKLOG");
        map.remove("PSSTUDIOSERVERLOG");
        map.remove("PSBKTASKLOG");
        map.remove("PSTASKSERVERLOG");
        map.remove("PSDEVCENTERLOG");
        map.remove("PSDSBOOKINGLOG");
        map.remove("PSASBOOKINGLOG");
        map.remove("PSDCROBOTLOG");
        map.remove("PSSYSDBCHGLOG");
        map.remove("PSSYSDMITEMLOG");
        map.remove("PSSYSDEVBKTASK");
        map.remove("PSSYSRUNSESSION");
        map.remove("PSSYSRUNLOG");
        final ArrayList<String> arrayList = new ArrayList<String>();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        final ArrayList arrayList4 = new ArrayList();
        arrayList.addAll(map.keySet());
        arrayList.remove("PSDEDQCODEEXP");
        arrayList.remove("PSSYSDMITEM");
        arrayList.remove("PSDEFDTCOL");
        arrayList.remove("PSDEFFORMITEM");
        arrayList.remove("PSDEFORMDETAIL");
        arrayList.remove("PSDEFIELD");
        arrayList.remove("PSDEVIEWCTRL");
        arrayList.remove("PSLANGUAGERES");
        arrayList.remove("PSDEFSFITEM");
        arrayList.remove("PSDEACTION");
        arrayList.remove("PSDEVIEWBASE");
        arrayList.remove("PSDEFINPUTTIP");
        arrayList.remove("PSCODEITEM");
        arrayList.remove("PSDEGRIDCOL");
        arrayList.add(0, "PSDEVIEWCTRL");
        arrayList.add(0, "PSLANGUAGERES");
        arrayList.add(0, "PSDEFSFITEM");
        arrayList.add(0, "PSDEACTION");
        arrayList.add(0, "PSDEVIEWBASE");
        arrayList.add(0, "PSDEFINPUTTIP");
        arrayList.add(0, "PSCODEITEM");
        arrayList.add(0, "PSDEGRIDCOL");
        arrayList.add(0, "PSDEDQCODEEXP");
        arrayList.add(0, "PSDEFFORMITEM");
        arrayList.add(0, "PSDEFORMDETAIL");
        arrayList.add(0, "PSDEFIELD");
        arrayList.add(0, "PSSYSDMITEM");
        arrayList.add(0, "PSDEFDTCOL");
        final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        final ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<String, Integer>();
        concurrentHashMap.put("DBVER", 1);
        concurrentHashMap.put("DBVERSION", 1);
        concurrentHashMap.put("MODELVER", 1);
        this.sendStudioConsole(null, "DEBUG", "[\u5f00\u59cb\u6267\u884c] \u5bfc\u5165\u6a21\u578b\u6587\u4ef6");
        final int n = arrayList.size();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 8; ++i) {
            executorService.execute(new Runnable(){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 * Unable to fully structure code
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                @Override
                public void run() {
                    block26: {
                        var1_1 = null;
                        try {
                            var2_2 = PSSysModelInstGlobal.getSessionFactory(PSModelV2Helper.this.getPSSysModelInstId());
                            block12: while (arrayList3.size() == 0) {
                                var1_1 = null;
                                var3_4 = arrayList;
                                synchronized (var3_4) {
                                    if (arrayList.size() > 0) {
                                        var1_1 = (String)arrayList.remove(0);
                                    }
                                    ** if (!StringHelper.isNullOrEmpty((String)var1_1)) goto lbl12
                                }
lbl11:
                                // 1 sources

                                return;
lbl12:
                                // 1 sources

                                var3_4 = DEModelGlobal.getDEModel((String)var1_1, (boolean)true);
                                if (var3_4 == null) {
                                    var4_6 = arrayList2;
                                    synchronized (var4_6) {
                                        arrayList2.add(var1_1);
                                        var5_8 = StringHelper.format((String)"\u5bfc\u5165[%1$s]\uff0c\u5f53\u524d\u5df2\u5b8c\u6210 %2$s/%3$s", (Object)var1_1, (Object)arrayList2.size(), (Object)n);
                                        PSModelV2Helper.access$000().debug(var5_8);
                                        PSModelV2Helper.this.sendStudioConsole(null, "INFO", (String)var5_8);
                                        continue;
                                    }
                                }
                                var4_6 = new File(string + File.separator + var1_1 + File.separator + "ALL.txt");
                                if (!var4_6.exists()) {
                                    var5_8 = arrayList2;
                                    synchronized (var5_8) {
                                        arrayList2.add(var1_1);
                                        var6_9 = StringHelper.format((String)"\u5bfc\u5165[%1$s]\uff0c\u5f53\u524d\u5df2\u5b8c\u6210 %2$s/%3$s", (Object)var1_1, (Object)arrayList2.size(), (Object)n);
                                        PSModelV2Helper.access$000().debug(var6_9);
                                        PSModelV2Helper.this.sendStudioConsole(null, "INFO", (String)var6_9);
                                        continue;
                                    }
                                }
                                var5_8 = var3_4.getService(var2_2);
                                var6_9 = new ArrayList<E>();
                                var7_10 = PSModelV2Helper.readFile2((File)var4_6);
                                var8_11 = var7_10.iterator();
lbl36:
                                // 2 sources

                                while (true) {
                                    if (var8_11.hasNext()) {
                                        var9_12 = var8_11.next();
                                        if (StringHelper.isNullOrEmpty((String)var9_12)) continue;
                                        var10_13 = (ObjectNode)JsonNodeHelper.fromString((String)var9_12);
                                        var11_14 = var3_4.createEntity();
                                        PSModelV2Helper.fromJSONObject((IDataObject)var11_14, var10_13, true);
                                        var12_15 = DataObject.getTimestampValue((IDataObject)var11_14, (String)"CREATEDATE", null);
                                        if (var12_15 == null) {
                                            var11_14.set("CREATEDATE", (Object)timestamp);
                                        }
                                        if ((var13_16 = DataObject.getTimestampValue((IDataObject)var11_14, (String)"UPDATEDATE", null)) == null) {
                                            var11_14.set("UPDATEDATE", (Object)timestamp);
                                        }
                                        if (StringHelper.isNullOrEmpty((String)(var14_17 = DataObject.getStringValue((IDataObject)var11_14, (String)"CREATEMAN", null)))) {
                                            var11_14.set("CREATEMAN", (Object)"SYSTEM");
                                        }
                                        if (StringHelper.isNullOrEmpty((String)(var15_18 = DataObject.getStringValue((IDataObject)var11_14, (String)"UPDATEMAN", null)))) {
                                            var11_14.set("UPDATEMAN", (Object)"SYSTEM");
                                        }
                                        var11_14.set("ENABLE", (Object)1);
                                        var16_19 = concurrentHashMap.entrySet().iterator();
                                        break block26;
                                    }
                                    PSSysModelInstGlobal.active(PSModelV2Helper.this.getPSSysModelInstId());
                                    ((IPSCoreSysService)var5_8).executeBatchCreate((ArrayList<IEntity>)var6_9, PSModelV2Helper.getBatchSize());
                                    var8_11 = arrayList4;
                                    synchronized (var8_11) {
                                        arrayList4.add(var6_9.size());
                                    }
                                    var6_9.clear();
                                    var8_11 = arrayList2;
                                    synchronized (var8_11) {
                                        arrayList2.add(var1_1);
                                        var9_12 = StringHelper.format((String)"\u5bfc\u5165[%1$s]\uff0c\u5f53\u524d\u5df2\u5b8c\u6210 %2$s/%3$s", (Object)var1_1, (Object)arrayList2.size(), (Object)n);
                                        PSModelV2Helper.access$000().debug((Object)var9_12);
                                        PSModelV2Helper.this.sendStudioConsole(null, "INFO", var9_12);
                                        continue block12;
                                    }
                                    break;
                                }
                            }
                            return;
                        }
                        catch (Exception var2_3) {
                            PSModelV2Helper.access$000().error((Object)var2_3);
                            if (StringHelper.isNullOrEmpty(var1_1)) {
                                var1_1 = "\u672a\u77e5\u6a21\u578b";
                            }
                            var3_5 = StringHelper.format((String)"[%1$s] %2$s", (Object)var1_1, (Object)var2_3.getMessage());
                            if (var2_3.getCause() != null) {
                                var3_5 = var3_5 + String.format("\r\n%1$s", new Object[]{var2_3.getCause().getMessage()});
                            }
                            arrayList3.add(var3_5);
                            var4_7 = new StringBuilderEx();
                            var2_3.printStackTrace(new PrintWriter(var4_7.getWriter()));
                            var3_5 = StringHelper.format((String)"\u5bfc\u5165[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)var1_1, (Object)var4_7.toString());
                            PSModelV2Helper.this.sendStudioConsole(null, "ERROR", var3_5);
                        }
                        return;
                    }
                    while (var16_19.hasNext()) {
                        var17_20 = var16_19.next();
                        var18_21 = var3_4.getDEField((String)var17_20.getKey(), true);
                        if (var18_21 == null || (var19_22 = var11_14.get(var18_21.getName())) != null) continue;
                        var11_14.set(var18_21.getName(), var17_20.getValue());
                    }
                    var6_9.add(var11_14);
                    ** while (true)
                }
            });
        }
        long l2 = 0L;
        while (arrayList2.size() != n && arrayList3.size() == 0) {
            Thread.sleep(50L);
            if (System.currentTimeMillis() - l2 < 10000L) continue;
            PSSysModelInstGlobal.active(this.getPSSysModelInstId());
            l2 = System.currentTimeMillis();
        }
        executorService.shutdown();
        if (arrayList3.size() > 0) {
            StringBuilderEx stringBuilderEx = new StringBuilderEx();
            stringBuilderEx.append("\u5bfc\u5165\u6a21\u578b\u53d1\u751f\u9519\u8bef\uff1a");
            boolean bl = true;
            for (String string2 : arrayList3) {
                if (bl) {
                    bl = false;
                } else {
                    stringBuilderEx.append("\r\n");
                }
                stringBuilderEx.append(string2);
            }
            throw new Exception(stringBuilderEx.toString());
        }
        int n2 = 0;
        Object object = arrayList4.iterator();
        while (object.hasNext()) {
            int n3 = (Integer)object.next();
            n2 += n3;
        }
        object = StringHelper.format((String)"[\u7ed3\u675f\u6267\u884c] \u5bfc\u5165\u6a21\u578b\u6587\u4ef6\uff0c\u6a21\u578b\u9879\u603b\u8ba1[%1$s]\uff0c\u8017\u65f6[%2$s]ms", (Object)n2, (Object)(System.currentTimeMillis() - l));
        log.debug(object);
        this.sendStudioConsole(null, "INFO", (String)object);
    }

    protected Map<String, String> getExportDataMap() throws Exception {
        String string = StringHelper.format((String)"select `TABLE_NAME`,`TABLE_ROWS` as `ROWCNT` from INFORMATION_SCHEMA.TABLES where TABLE_TYPE ='BASE TABLE' AND UPPER(TABLE_SCHEMA)='%1$s' ", (Object)this.psSysModelInst.getDBName().toUpperCase());
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.putAll(exportModelMap);
        return hashMap;
    }

    public static void writeFile(String string, String string2) throws Exception {
        PSModelV2Helper.writeFile(string, string2, false);
    }

    public static void writeFile(String string, String string2, boolean bl) throws Exception {
        File file = new File(string);
        if (file.exists()) {
            log.error((Object)StringHelper.format((String)"\u5bfc\u51fa\u6a21\u578b\u6587\u4ef6[%1$s]\u5df2\u7ecf\u5b58\u5728", (Object)string));
            if (bl) {
                throw new Exception("\u76ee\u6807\u6587\u4ef6\u5df2\u5b58\u5728");
            }
            return;
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream)new FileOutputStream(file), "UTF-8");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write(string2);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static void appendFile(String string, String string2) throws Exception {
        File file = new File(string);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream)new FileOutputStream(file, true), "UTF-8");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write(string2);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static String getModelV2TagFolderName(String string) {
        if (string.indexOf("*") != -1) {
            string = string.replace("*", EXPORTMODELV2_STAR);
        }
        if (string.indexOf("/") != -1) {
            string = string.replace("/", "-1-");
        }
        if (string.indexOf("\\") != -1) {
            string = string.replace("\\", "-2-");
        }
        if (string.indexOf("?") != -1) {
            string = string.replace("?", "-3-");
        }
        if (string.indexOf(":") != -1) {
            string = string.replace(":", "-4-");
        }
        if (string.indexOf("\"") != -1) {
            string = string.replace("\"", "-5-");
        }
        if (string.indexOf("<") != -1) {
            string = string.replace("<", "-6-");
        }
        if (string.indexOf(">") != -1) {
            string = string.replace(">", "-7-");
        }
        if (string.indexOf("|") != -1) {
            string = string.replace("|", "-8-");
        }
        return string;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ArrayList<String> readFile2(File file) throws Exception {
        ArrayList<String> arrayList = new ArrayList<String>();
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader((InputStream)fileInputStream, "UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String string = "";
            String string2 = "";
            while ((string = bufferedReader.readLine()) != null) {
                if (string.length() == 0) {
                    if (string2.length() == 0) continue;
                    arrayList.add(string2);
                    string2 = "";
                    continue;
                }
                if (string2.length() != 0) {
                    string2 = string2 + "\n";
                }
                string2 = string2 + string;
            }
            if (string2.length() != 0) {
                arrayList.add(string2);
                string2 = "";
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    protected boolean isAppendMode() {
        return this.bAppendMode;
    }

    public static void setUniqueTagMap(Map<String, String> map) {
        modelV2UniqueTagMap.set(map);
    }

    public static Map<String, String> getUniqueTagMap() {
        return modelV2UniqueTagMap.get();
    }

    public static void setKeyMap(Map<String, String> map) {
        modelV2KeyMap.set(map);
    }

    public static Map<String, String> getKeyMap() {
        return modelV2KeyMap.get();
    }

    public static void setUniqueKeyMap(Map<String, String> map) {
        modelV2UniqueKeyMap.set(map);
    }

    public static Map<String, String> getUniqueKeyMap() {
        return modelV2UniqueKeyMap.get();
    }

    public static void setCounterMap(Map<String, Integer> map) {
        modelV2CounterMap.set(map);
    }

    public static Map<String, Integer> getCounterMap() {
        return modelV2CounterMap.get();
    }

    public static void setCounterMap2(Map<String, Integer> map) {
        modelV2CounterMap2.set(map);
    }

    public static Map<String, Integer> getCounterMap2() {
        return modelV2CounterMap2.get();
    }

    public static void setUniqueFileMap(Map<String, String> map) {
        modelV2UniqueFileMap.set(map);
    }

    public static Map<String, String> getUniqueFileMap() {
        return modelV2UniqueFileMap.get();
    }

    public void backup(final String string) throws Exception {
        int n;
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5bfc\u51fa\u76ee\u5f55");
        }
        Map<String, String> map = this.getBackupDataMap();
        final ArrayList<String> arrayList = new ArrayList<String>();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        arrayList.addAll(map.keySet());
        arrayList.remove("PSDEDQCODEEXP");
        arrayList.remove("PSSYSDMITEM");
        arrayList.remove("PSDEFDTCOL");
        arrayList.remove("PSDEFFORMITEM");
        arrayList.remove("PSDEFORMDETAIL");
        arrayList.remove("PSDEFIELD");
        arrayList.remove("PSDEVIEWCTRL");
        arrayList.remove("PSLANGUAGERES");
        arrayList.remove("PSDEFSFITEM");
        arrayList.remove("PSDEACTION");
        arrayList.remove("PSDEVIEWBASE");
        arrayList.remove("PSDEFINPUTTIP");
        arrayList.remove("PSCODEITEM");
        arrayList.remove("PSDEGRIDCOL");
        arrayList.add(0, "PSDEVIEWCTRL");
        arrayList.add(0, "PSLANGUAGERES");
        arrayList.add(0, "PSDEFSFITEM");
        arrayList.add(0, "PSDEACTION");
        arrayList.add(0, "PSDEVIEWBASE");
        arrayList.add(0, "PSDEFINPUTTIP");
        arrayList.add(0, "PSCODEITEM");
        arrayList.add(0, "PSDEGRIDCOL");
        arrayList.add(0, "PSDEDQCODEEXP");
        arrayList.add(0, "PSDEFFORMITEM");
        arrayList.add(0, "PSDEFORMDETAIL");
        arrayList.add(0, "PSDEFIELD");
        arrayList.add(0, "PSSYSDMITEM");
        arrayList.add(0, "PSDEFDTCOL");
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory(this.strPSSysModelInstId);
        final PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)sessionFactory);
        long l = System.currentTimeMillis();
        final int n2 = arrayList.size();
        final String string2 = this.strPSSysModelInstId;
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (n = 0; n < 8; ++n) {
            executorService.execute(new Runnable(){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 * Converted monitor instructions to comments
                 * Lifted jumps to return sites
                 */
                @Override
                public void run() {
                    try {
                        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory(string2);
                        while (true) {
                            Object object;
                            ArrayList arrayList4;
                            String string3 = null;
                            ArrayList arrayList22 = arrayList;
                            // MONITORENTER : arrayList22
                            if (arrayList.size() > 0) {
                                string3 = (String)arrayList.remove(0);
                            }
                            // MONITOREXIT : arrayList22
                            if (StringHelper.isNullOrEmpty(string3)) {
                                return;
                            }
                            PSSysModelInstGlobal.active(string2);
                            arrayList22 = DEModelGlobal.getDEModel((String)string3, (boolean)true);
                            if (arrayList22 == null) {
                                arrayList4 = arrayList2;
                                // MONITORENTER : arrayList4
                                arrayList2.add(string3);
                                log.debug((Object)StringHelper.format((String)"\u5ffd\u7565\u5bfc\u51fa[%1$s]\uff0c\u5b9e\u4f53\u5bf9\u8c61\u4e0d\u5b58\u5728\uff0c\u5f53\u524d\u5df2\u5b8c\u6210 %2$s/%3$s", (Object)string3, (Object)arrayList2.size(), (Object)n2));
                                // MONITOREXIT : arrayList4
                                continue;
                            }
                            arrayList4 = arrayList22.getService(sessionFactory);
                            if (arrayList4.getSessionFactory() != sessionFactory) {
                                object = arrayList2;
                                // MONITORENTER : object
                                arrayList2.add(string3);
                                log.debug((Object)StringHelper.format((String)"\u5ffd\u7565\u5bfc\u51fa[%1$s]\uff0c\u6570\u636e\u6e90\u4e0d\u4e00\u81f4\uff0c\u5f53\u524d\u5df2\u5b8c\u6210 %2$s/%3$s", (Object)string3, (Object)arrayList2.size(), (Object)n2));
                                // MONITOREXIT : object
                                continue;
                            }
                            object = StringHelper.format((String)"select * from %1$s ", (Object)arrayList22.getTableName());
                            if (arrayList22.getInheritDEModel() != null && !StringHelper.isNullOrEmpty((String)arrayList22.getViewName())) {
                                object = StringHelper.format((String)"select * from %1$s ", (Object)arrayList22.getViewName());
                            }
                            if (arrayList4 instanceof IPSCoreSysService) {
                                ((IPSCoreSysService)((Object)arrayList4)).selectRaw((String)object, null, new BackupHelper(string, (IService)arrayList4, (IDataEntityModel)arrayList22));
                            } else {
                                pSSystemService.selectRaw((String)object, null, new BackupHelper(string, pSSystemService, (IDataEntityModel)arrayList22));
                            }
                            ArrayList arrayList32 = arrayList2;
                            // MONITORENTER : arrayList32
                            arrayList2.add(string3);
                            log.debug((Object)StringHelper.format((String)"\u5bfc\u51fa[%1$s]\uff0c\u5f53\u524d\u5df2\u5b8c\u6210 %2$s/%3$s", (Object)string3, (Object)arrayList2.size(), (Object)n2));
                            // MONITOREXIT : arrayList32
                        }
                    }
                    catch (Exception exception) {
                        log.error((Object)exception);
                        arrayList3.add(exception.getMessage());
                    }
                }
            });
        }
        while (arrayList2.size() != n2 && arrayList3.size() == 0) {
            Thread.sleep(50L);
        }
        executorService.shutdown();
        if (arrayList3.size() > 0) {
            throw new Exception("\u5bfc\u51fa\u53d1\u751f\u9519\u8bef");
        }
        n = 0;
        Iterator iterator = arrayList4.iterator();
        while (iterator.hasNext()) {
            int n3 = (Integer)iterator.next();
            n += n3;
        }
        log.debug((Object)StringHelper.format((String)"\u5bfc\u51fa\u8bb0\u5f55\u6570[%1$s]\uff0c\u8017\u65f6[%2$s]", (Object)n, (Object)(System.currentTimeMillis() - l)));
    }

    public void restore(final String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5bfc\u5165\u76ee\u5f55");
        }
        long l = System.currentTimeMillis();
        Map<String, String> map = this.getBackupDataMap();
        final ArrayList<String> arrayList = new ArrayList<String>();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        final ArrayList arrayList4 = new ArrayList();
        arrayList.addAll(map.keySet());
        arrayList.remove("PSDEDQCODEEXP");
        arrayList.remove("PSSYSDMITEM");
        arrayList.remove("PSDEFDTCOL");
        arrayList.remove("PSDEFFORMITEM");
        arrayList.remove("PSDEFORMDETAIL");
        arrayList.remove("PSDEFIELD");
        arrayList.remove("PSDEVIEWCTRL");
        arrayList.remove("PSLANGUAGERES");
        arrayList.remove("PSDEFSFITEM");
        arrayList.remove("PSDEACTION");
        arrayList.remove("PSDEVIEWBASE");
        arrayList.remove("PSDEFINPUTTIP");
        arrayList.remove("PSCODEITEM");
        arrayList.remove("PSDEGRIDCOL");
        arrayList.add(0, "PSDEVIEWCTRL");
        arrayList.add(0, "PSLANGUAGERES");
        arrayList.add(0, "PSDEFSFITEM");
        arrayList.add(0, "PSDEACTION");
        arrayList.add(0, "PSDEVIEWBASE");
        arrayList.add(0, "PSDEFINPUTTIP");
        arrayList.add(0, "PSCODEITEM");
        arrayList.add(0, "PSDEGRIDCOL");
        arrayList.add(0, "PSDEDQCODEEXP");
        arrayList.add(0, "PSDEFFORMITEM");
        arrayList.add(0, "PSDEFORMDETAIL");
        arrayList.add(0, "PSDEFIELD");
        arrayList.add(0, "PSSYSDMITEM");
        arrayList.add(0, "PSDEFDTCOL");
        arrayList.remove("PSSYSCONSOLE");
        final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory(this.getPSSysModelInstId());
        final PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)sessionFactory);
        final int n = arrayList.size();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 8; ++i) {
            executorService.execute(new Runnable(){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 * Converted monitor instructions to comments
                 * Lifted jumps to return sites
                 */
                @Override
                public void run() {
                    String string5 = null;
                    try {
                        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory(PSModelV2Helper.this.getPSSysModelInstId());
                        while (arrayList3.size() == 0) {
                            ArrayList<IEntity> arrayList5;
                            ArrayList arrayList22;
                            Serializable serializable;
                            string5 = null;
                            ArrayList arrayList32 = arrayList;
                            // MONITORENTER : arrayList32
                            if (arrayList.size() > 0) {
                                string5 = (String)arrayList.remove(0);
                            }
                            // MONITOREXIT : arrayList32
                            if (StringHelper.isNullOrEmpty(string5)) {
                                return;
                            }
                            arrayList32 = DEModelGlobal.getDEModel((String)string5, (boolean)true);
                            if (arrayList32 == null) {
                                serializable = arrayList2;
                                // MONITORENTER : serializable
                                arrayList2.add(string5);
                                log.debug((Object)StringHelper.format((String)"\u5bfc\u5165[%1$s]\uff0c\u5f53\u524d\u5df2\u5b8c\u6210 %2$s/%3$s", (Object)string5, (Object)arrayList2.size(), (Object)n));
                                // MONITOREXIT : serializable
                                continue;
                            }
                            serializable = new File(string + File.separator + string5 + File.separator + "ALL.txt");
                            if (!((File)serializable).exists()) {
                                arrayList22 = arrayList2;
                                // MONITORENTER : arrayList22
                                arrayList2.add(string5);
                                log.debug((Object)StringHelper.format((String)"\u5bfc\u5165[%1$s]\uff0c\u5f53\u524d\u5df2\u5b8c\u6210 %2$s/%3$s", (Object)string5, (Object)arrayList2.size(), (Object)n));
                                // MONITOREXIT : arrayList22
                                continue;
                            }
                            arrayList22 = arrayList32.getService(sessionFactory);
                            if (arrayList22.getSessionFactory() != sessionFactory) {
                                arrayList5 = arrayList2;
                                // MONITORENTER : arrayList5
                                arrayList2.add(string5);
                                log.debug((Object)StringHelper.format((String)"\u5ffd\u7565\u5bfc\u5165[%1$s]\uff0c\u6570\u636e\u6e90\u4e0d\u4e00\u81f4\uff0c\u5f53\u524d\u5df2\u5b8c\u6210 %2$s/%3$s", (Object)string5, (Object)arrayList2.size(), (Object)n));
                                // MONITOREXIT : arrayList5
                                continue;
                            }
                            arrayList5 = new ArrayList<IEntity>();
                            ArrayList<String> arrayList42 = PSModelV2Helper.readFile2((File)serializable);
                            for (String string2 : arrayList42) {
                                String string3;
                                String string4;
                                Timestamp timestamp3;
                                if (StringHelper.isNullOrEmpty((String)string2)) continue;
                                IEntity iEntity = arrayList32.createEntity();
                                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string2);
                                PSModelV2Helper.fromJSONObject((IDataObject)iEntity, objectNode, false);
                                Timestamp timestamp2 = DataObject.getTimestampValue((IDataObject)iEntity, (String)"CREATEDATE", null);
                                if (timestamp2 == null) {
                                    iEntity.set("CREATEDATE", (Object)timestamp);
                                }
                                if ((timestamp3 = DataObject.getTimestampValue((IDataObject)iEntity, (String)"UPDATEDATE", null)) == null) {
                                    iEntity.set("UPDATEDATE", (Object)timestamp);
                                }
                                if (StringHelper.isNullOrEmpty((String)(string4 = DataObject.getStringValue((IDataObject)iEntity, (String)"CREATEMAN", null)))) {
                                    iEntity.set("CREATEMAN", (Object)"SYSTEM");
                                }
                                if (StringHelper.isNullOrEmpty((String)(string3 = DataObject.getStringValue((IDataObject)iEntity, (String)"UPDATEMAN", null)))) {
                                    iEntity.set("UPDATEMAN", (Object)"SYSTEM");
                                }
                                iEntity.set("ENABLE", (Object)1);
                                arrayList5.add(iEntity);
                            }
                            log.debug((Object)StringHelper.format((String)"\u6a21\u578b\u6062\u590d[%1$s]\u6570\u91cf[%2$s]", (Object)string5, (Object)arrayList5.size()));
                            PSSysModelInstGlobal.active(PSModelV2Helper.this.getPSSysModelInstId());
                            if (arrayList22 instanceof IPSCoreSysService) {
                                ((IPSCoreSysService)((Object)arrayList22)).executeBatchCreate(arrayList5, 2000);
                            } else {
                                pSSystemService.executeBatchCreate(arrayList5, 2000, (IDataEntityModel)arrayList32);
                            }
                            Object object = arrayList4;
                            // MONITORENTER : object
                            arrayList4.add(arrayList5.size());
                            // MONITOREXIT : object
                            arrayList5.clear();
                            object = arrayList2;
                            // MONITORENTER : object
                            arrayList2.add(string5);
                            log.debug((Object)StringHelper.format((String)"\u5bfc\u5165[%1$s]\uff0c\u5f53\u524d\u5df2\u5b8c\u6210 %2$s/%3$s", (Object)string5, (Object)arrayList2.size(), (Object)n));
                            // MONITOREXIT : object
                        }
                        return;
                    }
                    catch (Exception exception) {
                        log.error((Object)exception);
                        if (StringHelper.isNullOrEmpty(string5)) {
                            arrayList3.add("\u672a\u77e5\u6a21\u578b");
                            return;
                        }
                        arrayList3.add(string5);
                    }
                }
            });
        }
        long l2 = 0L;
        while (arrayList2.size() != n && arrayList3.size() == 0) {
            Thread.sleep(50L);
            if (System.currentTimeMillis() - l2 < 10000L) continue;
            PSSysModelInstGlobal.active(this.getPSSysModelInstId());
            l2 = System.currentTimeMillis();
        }
        executorService.shutdown();
        if (arrayList3.size() > 0) {
            StringBuilderEx stringBuilderEx = new StringBuilderEx();
            stringBuilderEx.append("\u5bfc\u5165\u6a21\u578b\u53d1\u751f\u9519\u8bef\uff1a");
            boolean bl = true;
            for (String string2 : arrayList3) {
                if (bl) {
                    bl = false;
                } else {
                    stringBuilderEx.append(",");
                }
                stringBuilderEx.append(string2);
            }
            throw new Exception(stringBuilderEx.toString());
        }
        int n2 = 0;
        Iterator iterator = arrayList4.iterator();
        while (iterator.hasNext()) {
            int n3 = (Integer)iterator.next();
            n2 += n3;
        }
        log.debug((Object)StringHelper.format((String)"\u5bfc\u5165\u8bb0\u5f55\u6570[%1$s]\uff0c\u8017\u65f6[%2$s]", (Object)n2, (Object)(System.currentTimeMillis() - l)));
    }

    protected Map<String, String> getBackupDataMap() throws Exception {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("FILE", "");
        hashMap.put("PSACHANDLER", "");
        hashMap.put("PSACHANDLERACTION", "");
        hashMap.put("PSAMITEMTYPE", "");
        hashMap.put("PSAPPCTRLSTYLE", "");
        hashMap.put("PSAPPDERS", "");
        hashMap.put("PSAPPDERSVIEW", "");
        hashMap.put("PSAPPDEVIEW", "");
        hashMap.put("PSAPPDEVIEWREF", "");
        hashMap.put("PSAPPDYNADEVIEW", "");
        hashMap.put("PSAPPEDITORTEMPL", "");
        hashMap.put("PSAPPFUNC", "");
        hashMap.put("PSAPPFUNCTYPE", "");
        hashMap.put("PSAPPINDEXVIEW", "");
        hashMap.put("PSAPPLAN", "");
        hashMap.put("PSAPPLOCALDE", "");
        hashMap.put("PSAPPMENU", "");
        hashMap.put("PSAPPMENUITEM", "");
        hashMap.put("PSAPPMODULE", "");
        hashMap.put("PSAPPPANELVIEW", "");
        hashMap.put("PSAPPPDTVIEW", "");
        hashMap.put("PSAPPPKG", "");
        hashMap.put("PSAPPPORTALVIEW", "");
        hashMap.put("PSAPPPVPART", "");
        hashMap.put("PSAPPSERVER", "");
        hashMap.put("PSAPPSUBAPP", "");
        hashMap.put("PSAPPTITLEBAR", "");
        hashMap.put("PSAPPTYPE", "");
        hashMap.put("PSAPPUISTYLE", "");
        hashMap.put("PSAPPUITHEME", "");
        hashMap.put("PSAPPUSERMODE", "");
        hashMap.put("PSAPPUTIL", "");
        hashMap.put("PSAPPUTILPAGE", "");
        hashMap.put("PSAPPUTILVIEW", "");
        hashMap.put("PSAPPVIEWCODE", "");
        hashMap.put("PSAPPVIEWLOGIC", "");
        hashMap.put("PSAPPVIEWREF", "");
        hashMap.put("PSAPPVIEWSTYLE", "");
        hashMap.put("PSAPPVIEWTEMPL", "");
        hashMap.put("PSAPPWF", "");
        hashMap.put("PSAPPWFVER", "");
        hashMap.put("PSASBOOKING", "");
        hashMap.put("PSASBOOKINGLOG", "");
        hashMap.put("PSASGROUP", "");
        hashMap.put("PSASTYPE", "");
        hashMap.put("PSBACKSERVICE", "");
        hashMap.put("PSBDDEVINST", "");
        hashMap.put("PSBDSERVER", "");
        hashMap.put("PSBDTYPE", "");
        hashMap.put("PSBKTASKLOG", "");
        hashMap.put("PSBOOKINGRESTYPE", "");
        hashMap.put("PSCHARTTYPE", "");
        hashMap.put("PSCODEITEM", "");
        hashMap.put("PSCODELIST", "");
        hashMap.put("PSCODELISTTEMPL", "");
        hashMap.put("PSCODENAME", "");
        hashMap.put("PSCODEPREVIEWACTION", "");
        hashMap.put("PSCODESERVERACTION", "");
        hashMap.put("PSCODESNIPPETTYPE", "");
        hashMap.put("PSCONSOLESERVER", "");
        hashMap.put("PSCOREPRD", "");
        hashMap.put("PSCOREPRDCAT", "");
        hashMap.put("PSCOREPRDFUNC", "");
        hashMap.put("PSCOREPRDINSTLOG", "");
        hashMap.put("PSCOREPRDISSUE", "");
        hashMap.put("PSCOREPRDVER", "");
        hashMap.put("PSCOUNTER", "");
        hashMap.put("PSCOUNTERTYPE", "");
        hashMap.put("PSCOUNTERTYPESF", "");
        hashMap.put("PSCPVFUNC", "");
        hashMap.put("PSCPVISSUE", "");
        hashMap.put("PSCSSCATTEMPL", "");
        hashMap.put("PSCSSTEMPL", "");
        hashMap.put("PSCTRLACTION", "");
        hashMap.put("PSCTRLEVENT", "");
        hashMap.put("PSCTRLMODEL", "");
        hashMap.put("PSCTRLMSG", "");
        hashMap.put("PSCTRLMSGITEM", "");
        hashMap.put("PSCTRLMSGTAG", "");
        hashMap.put("PSCTRLTYPE", "");
        hashMap.put("PSCTRLTYPEACTION", "");
        hashMap.put("PSCTRLTYPEEVENT", "");
        hashMap.put("PSCTRLTYPEMODEL", "");
        hashMap.put("PSCTRLTYPEMSGTAG", "");
        hashMap.put("PSDATAENTITY", "");
        hashMap.put("PSDATASYNCAGENTTYPE", "");
        hashMap.put("PSDBDEVINST", "");
        hashMap.put("PSDBDEVINSTBK", "");
        hashMap.put("PSDBOBJTYPE", "");
        hashMap.put("PSDBPROCPARAM", "");
        hashMap.put("PSDBSERVER", "");
        hashMap.put("PSDBSPPARTTEMPL", "");
        hashMap.put("PSDBSYSPROCTEMPL", "");
        hashMap.put("PSDBSYSPROCTYPE", "");
        hashMap.put("PSDBTYPE", "");
        hashMap.put("PSDBVALUEFUNC", "");
        hashMap.put("PSDBVALUEMODE", "");
        hashMap.put("PSDBVALUEOP", "");
        hashMap.put("PSDBVFCODE", "");
        hashMap.put("PSDCABILITY", "");
        hashMap.put("PSDCASGROUP", "");
        hashMap.put("PSDCBDINST", "");
        hashMap.put("PSDCBKTASK", "");
        hashMap.put("PSDCBKTYPE", "");
        hashMap.put("PSDCBULLETIN", "");
        hashMap.put("PSDCCODESNIPPET", "");
        hashMap.put("PSDCCODESNIPPETREF", "");
        hashMap.put("PSDCCOREPRDISSUE", "");
        hashMap.put("PSDCDBFUNC", "");
        hashMap.put("PSDCDBINDEX", "");
        hashMap.put("PSDCDBINSTBK", "");
        hashMap.put("PSDCDBINSTREF", "");
        hashMap.put("PSDCDBOBJ", "");
        hashMap.put("PSDCDBPROC", "");
        hashMap.put("PSDCDBSEQU", "");
        hashMap.put("PSDCDBTABLE", "");
        hashMap.put("PSDCDBVIEW", "");
        hashMap.put("PSDCDEPLOYCENTER", "");
        hashMap.put("PSDCDEPLOYSERVER", "");
        hashMap.put("PSDCDETEMPL", "");
        hashMap.put("PSDCDETEMPLFIELD", "");
        hashMap.put("PSDCINST", "");
        hashMap.put("PSDCMAVENREPO", "");
        hashMap.put("PSDCMOBAPPTDREF", "");
        hashMap.put("PSDCMOBAPPTESTDEVICE", "");
        hashMap.put("PSDCMOBPACKCERT", "");
        hashMap.put("PSDCMODELTEMPL", "");
        hashMap.put("PSDCMSGACCOUNT", "");
        hashMap.put("PSDCMSPLATFORM", "");
        hashMap.put("PSDCMSPLATFORMFUNC", "");
        hashMap.put("PSDCMSPLATFORMNODE", "");
        hashMap.put("PSDCMTDECAT", "");
        hashMap.put("PSDCMTDEF", "");
        hashMap.put("PSDCNWFLOW", "");
        hashMap.put("PSDCORG", "");
        hashMap.put("PSDCORGSECTOR", "");
        hashMap.put("PSDCORGUSER", "");
        hashMap.put("PSDCPFPITEMPL", "");
        hashMap.put("PSDCPFPLUGIN", "");
        hashMap.put("PSDCPRODUCT", "");
        hashMap.put("PSDCRESHOURS", "");
        hashMap.put("PSDCRESHOURSLOG", "");
        hashMap.put("PSDCRESREP", "");
        hashMap.put("PSDCROBOT", "");
        hashMap.put("PSDCROBOTABILITY", "");
        hashMap.put("PSDCROBOTLOG", "");
        hashMap.put("PSDCRTMSG", "");
        hashMap.put("PSDCSERVER", "");
        hashMap.put("PSDCSERVERSTATE", "");
        hashMap.put("PSDCSFPKG", "");
        hashMap.put("PSDCSFPKGVER", "");
        hashMap.put("PSDCSVNBK", "");
        hashMap.put("PSDCSYNCAGENT", "");
        hashMap.put("PSDCSYNCDATA", "");
        hashMap.put("PSDCSYNCDATA2", "");
        hashMap.put("PSDCSYNCDATATYPE", "");
        hashMap.put("PSDCSYSINSTACTION", "");
        hashMap.put("PSDCSYSLIC", "");
        hashMap.put("PSDCSYSMODELINST", "");
        hashMap.put("PSDCSYSPRDVER", "");
        hashMap.put("PSDCSYSPRODUCT", "");
        hashMap.put("PSDCSYSRES", "");
        hashMap.put("PSDCTASKLOG", "");
        hashMap.put("PSDCWORKSHOPSERVER", "");
        hashMap.put("PSDCWORKSPACE", "");
        hashMap.put("PSDCWORKSPACEACTION", "");
        hashMap.put("PSDCWORKSPACELOG", "");
        hashMap.put("PSDCWORKSPACEUSER", "");
        hashMap.put("PSDEACMODE", "");
        hashMap.put("PSDEACMODEITEM", "");
        hashMap.put("PSDEACTION", "");
        hashMap.put("PSDEACTIONLOGIC", "");
        hashMap.put("PSDEACTIONPARAM", "");
        hashMap.put("PSDEACTIONTEMPL", "");
        hashMap.put("PSDEACTIONTYPE", "");
        hashMap.put("PSDEACTIONWIZARD", "");
        hashMap.put("PSDEAWGROUP", "");
        hashMap.put("PSDEAWGRPDETAIL", "");
        hashMap.put("PSDEAWITEM", "");
        hashMap.put("PSDECHART", "");
        hashMap.put("PSDECHARTAXES", "");
        hashMap.put("PSDECHARTPARAM", "");
        hashMap.put("PSDECTRL", "");
        hashMap.put("PSDEDATAEXP", "");
        hashMap.put("PSDEDATAIMP", "");
        hashMap.put("PSDEDATAIMPITEM", "");
        hashMap.put("PSDEDATAQUERY", "");
        hashMap.put("PSDEDATARELATION", "");
        hashMap.put("PSDEDATASET", "");
        hashMap.put("PSDEDATASYNC", "");
        hashMap.put("PSDEDATAVIEW", "");
        hashMap.put("PSDEDBCFG", "");
        hashMap.put("PSDEDBIDXFIELD", "");
        hashMap.put("PSDEDBINDEX", "");
        hashMap.put("PSDEDBOBJSQL", "");
        hashMap.put("PSDEDQCODE", "");
        hashMap.put("PSDEDQCODECOND", "");
        hashMap.put("PSDEDQCODEEXP", "");
        hashMap.put("PSDEDQCOND", "");
        hashMap.put("PSDEDQJOIN", "");
        hashMap.put("PSDEDQPDCOND", "");
        hashMap.put("PSDEDRDETAIL", "");
        hashMap.put("PSDEDRGROUP", "");
        hashMap.put("PSDEDRITEM", "");
        hashMap.put("PSDEDSCODE", "");
        hashMap.put("PSDEDSDQ", "");
        hashMap.put("PSDEDSGRPPARAM", "");
        hashMap.put("PSDEDSPARAM", "");
        hashMap.put("PSDEDTSQUEUE", "");
        hashMap.put("PSDEDUPRULE", "");
        hashMap.put("PSDEDUPRULEITEM", "");
        hashMap.put("PSDEFDATATYPE", "");
        hashMap.put("PSDEFDLOGIC", "");
        hashMap.put("PSDEFDTCOL", "");
        hashMap.put("PSDEFFORMITEM", "");
        hashMap.put("PSDEFGRIDCOL", "");
        hashMap.put("PSDEFGROUP", "");
        hashMap.put("PSDEFGROUPDETAIL", "");
        hashMap.put("PSDEFIELD", "");
        hashMap.put("PSDEFINPUTTIP", "");
        hashMap.put("PSDEFINPUTTIPSET", "");
        hashMap.put("PSDEFIUDETAIL", "");
        hashMap.put("PSDEFIUPDATE", "");
        hashMap.put("PSDEFIVR", "");
        hashMap.put("PSDEFORM", "");
        hashMap.put("PSDEFORMDETAIL", "");
        hashMap.put("PSDEFORMRF", "");
        hashMap.put("PSDEFSFITEM", "");
        hashMap.put("PSDEFTYPE", "");
        hashMap.put("PSDEFVALUERULE", "");
        hashMap.put("PSDEFVRCODETYPE", "");
        hashMap.put("PSDEFVRCOND", "");
        hashMap.put("PSDEFVRDSPARAM", "");
        hashMap.put("PSDEFVRTYPE", "");
        hashMap.put("PSDEFVRTYPEDETAIL", "");
        hashMap.put("PSDEGCTYPE", "");
        hashMap.put("PSDEGEIUDETAIL", "");
        hashMap.put("PSDEGEIUPDATE", "");
        hashMap.put("PSDEGRID", "");
        hashMap.put("PSDEGRIDCOL", "");
        hashMap.put("PSDEGROUP", "");
        hashMap.put("PSDEGROUPDETAIL", "");
        hashMap.put("PSDEINITCFG", "");
        hashMap.put("PSDEJOINTYPE", "");
        hashMap.put("PSDELIST", "");
        hashMap.put("PSDELISTITEM", "");
        hashMap.put("PSDELLCOND", "");
        hashMap.put("PSDELLCONDTYPE", "");
        hashMap.put("PSDELLTYPE", "");
        hashMap.put("PSDELNPARAM", "");
        hashMap.put("PSDELNTYPE", "");
        hashMap.put("PSDELOGIC", "");
        hashMap.put("PSDELOGICLINK", "");
        hashMap.put("PSDELOGICNODE", "");
        hashMap.put("PSDELOGICPARAM", "");
        hashMap.put("PSDEMAINSTATE", "");
        hashMap.put("PSDEMAINSTATERS", "");
        hashMap.put("PSDEMAP", "");
        hashMap.put("PSDEMAPACTION", "");
        hashMap.put("PSDEMAPDETAIL", "");
        hashMap.put("PSDEMAPDQ", "");
        hashMap.put("PSDEMAPDS", "");
        hashMap.put("PSDEMODEL", "");
        hashMap.put("PSDEMODELCNT", "");
        hashMap.put("PSDEMSACTION", "");
        hashMap.put("PSDEMSOPPRIV", "");
        hashMap.put("PSDEOPPRIV", "");
        hashMap.put("PSDEOPPRIVROLE", "");
        hashMap.put("PSDEPLOYCENTER", "");
        hashMap.put("PSDEPLOYSERVER", "");
        hashMap.put("PSDEPRINT", "");
        hashMap.put("PSDEPSAASSYS", "");
        hashMap.put("PSDEPSAASSYSAPP", "");
        hashMap.put("PSDEPSAASSYSVER", "");
        hashMap.put("PSDEPSLN", "");
        hashMap.put("PSDEPSLNAS", "");
        hashMap.put("PSDEPSLNASGRP", "");
        hashMap.put("PSDEPSLNASITEM", "");
        hashMap.put("PSDEPSLNDBINST", "");
        hashMap.put("PSDEPSLNDEPSESSION", "");
        hashMap.put("PSDEPSLNHOST", "");
        hashMap.put("PSDEPSLNLOG", "");
        hashMap.put("PSDEPSLNMODE", "");
        hashMap.put("PSDEPSLNMODEPRD", "");
        hashMap.put("PSDEPSLNMQINST", "");
        hashMap.put("PSDEPSLNPACK", "");
        hashMap.put("PSDEPSLNPRD", "");
        hashMap.put("PSDEPSLNRUNLOG", "");
        hashMap.put("PSDEPSLNSYS", "");
        hashMap.put("PSDEPSLNSYSAS", "");
        hashMap.put("PSDEPSLNSYSDB", "");
        hashMap.put("PSDEPSLNSYSDYNAINST", "");
        hashMap.put("PSDEPSLNSYSKEY", "");
        hashMap.put("PSDEPSLNSYSMQ", "");
        hashMap.put("PSDEPSLNTYPE", "");
        hashMap.put("PSDEPSLNUSER", "");
        hashMap.put("PSDEPSYS", "");
        hashMap.put("PSDEPSYSAPI", "");
        hashMap.put("PSDEPSYSAPP", "");
        hashMap.put("PSDEPSYSTYPE", "");
        hashMap.put("PSDEPSYSVER", "");
        hashMap.put("PSDEPTOOLTYPE", "");
        hashMap.put("PSDER", "");
        hashMap.put("PSDERDEFMAP", "");
        hashMap.put("PSDEREPITEM", "");
        hashMap.put("PSDEREPORT", "");
        hashMap.put("PSDERGROUP", "");
        hashMap.put("PSDERGROUPDETAIL", "");
        hashMap.put("PSDERTAW", "");
        hashMap.put("PSDERTAWI", "");
        hashMap.put("PSDERTYPE", "");
        hashMap.put("PSDESADETAIL", "");
        hashMap.put("PSDESAMPLEDATA", "");
        hashMap.put("PSDESAMPLEDATAREF", "");
        hashMap.put("PSDESARS", "");
        hashMap.put("PSDESERVICEAPI", "");
        hashMap.put("PSDESPCODE", "");
        hashMap.put("PSDESPCODEPART", "");
        hashMap.put("PSDESPFIELD", "");
        hashMap.put("PSDESYSPROC", "");
        hashMap.put("PSDETABLE", "");
        hashMap.put("PSDETBITEM", "");
        hashMap.put("PSDETOOLBAR", "");
        hashMap.put("PSDETREECOL", "");
        hashMap.put("PSDETREENODE", "");
        hashMap.put("PSDETREENODECOL", "");
        hashMap.put("PSDETREENODERS", "");
        hashMap.put("PSDETREENODERV", "");
        hashMap.put("PSDETREEVIEW", "");
        hashMap.put("PSDEUAGROUP", "");
        hashMap.put("PSDEUAGRPDETAIL", "");
        hashMap.put("PSDEUIACTION", "");
        hashMap.put("PSDEUIACTIONTYPE", "");
        hashMap.put("PSDEUSERROLE", "");
        hashMap.put("PSDEUTILDE", "");
        hashMap.put("PSDEUTILTYPE", "");
        hashMap.put("PSDEVCENTER", "");
        hashMap.put("PSDEVCENTERAS", "");
        hashMap.put("PSDEVCENTERDBINST", "");
        hashMap.put("PSDEVCENTERFILE", "");
        hashMap.put("PSDEVCENTERLOG", "");
        hashMap.put("PSDEVCENTERMQ", "");
        hashMap.put("PSDEVCENTERPF", "");
        hashMap.put("PSDEVCENTERRES", "");
        hashMap.put("PSDEVCENTERSERVER", "");
        hashMap.put("PSDEVCENTERSF", "");
        hashMap.put("PSDEVCENTERSRV", "");
        hashMap.put("PSDEVCENTERSVN", "");
        hashMap.put("PSDEVCENTERTS", "");
        hashMap.put("PSDEVENV", "");
        hashMap.put("PSDEVIEWBASE", "");
        hashMap.put("PSDEVIEWCTRL", "");
        hashMap.put("PSDEVIEWCTRLDS", "");
        hashMap.put("PSDEVIEWENGINE", "");
        hashMap.put("PSDEVIEWGROUP", "");
        hashMap.put("PSDEVIEWGRPDETAIL", "");
        hashMap.put("PSDEVIEWLOGIC", "");
        hashMap.put("PSDEVIEWRV", "");
        hashMap.put("PSDEVIEWSERVICE", "");
        hashMap.put("PSDEVPRD", "");
        hashMap.put("PSDEVPRDISSUE", "");
        hashMap.put("PSDEVPRDISSUEPLAN", "");
        hashMap.put("PSDEVPRDSEPCPLAN", "");
        hashMap.put("PSDEVPRDSPEC", "");
        hashMap.put("PSDEVPRDSPECPLAN", "");
        hashMap.put("PSDEVPRDSUBVER", "");
        hashMap.put("PSDEVPRDSYS", "");
        hashMap.put("PSDEVPRDSYSSYNC", "");
        hashMap.put("PSDEVPRDSYSSYNCITEM", "");
        hashMap.put("PSDEVPRDVER", "");
        hashMap.put("PSDEVRGROUP", "");
        hashMap.put("PSDEVRGRPDETAIL", "");
        hashMap.put("PSDEVSERVER", "");
        hashMap.put("PSDEVSERVERLEASE", "");
        hashMap.put("PSDEVSERVERTYPE", "");
        hashMap.put("PSDEVSLN", "");
        hashMap.put("PSDEVSLNCODESERVER", "");
        hashMap.put("PSDEVSLNCSSESSION", "");
        hashMap.put("PSDEVSLNLINK", "");
        hashMap.put("PSDEVSLNMSDEPAPI", "");
        hashMap.put("PSDEVSLNMSDEPAPP", "");
        hashMap.put("PSDEVSLNMSDEPFUNC", "");
        hashMap.put("PSDEVSLNMSDEPFUNCITEM", "");
        hashMap.put("PSDEVSLNMSDEPLOY", "");
        hashMap.put("PSDEVSLNRECENT", "");
        hashMap.put("PSDEVSLNSYS", "");
        hashMap.put("PSDEVSLNSYSAPI", "");
        hashMap.put("PSDEVSLNSYSAPP", "");
        hashMap.put("PSDEVSLNSYSBAK", "");
        hashMap.put("PSDEVSLNSYSBAKLINK", "");
        hashMap.put("PSDEVSLNSYSDEPINST", "");
        hashMap.put("PSDEVSLNSYSDYNAINST", "");
        hashMap.put("PSDEVSLNSYSGD", "");
        hashMap.put("PSDEVSLNSYSGROUP", "");
        hashMap.put("PSDEVSLNSYSKEY", "");
        hashMap.put("PSDEVSLNSYSLOCKLOG", "");
        hashMap.put("PSDEVSLNSYSMODEL", "");
        hashMap.put("PSDEVSLNSYSPATCH", "");
        hashMap.put("PSDEVSLNSYSPUBLOCK", "");
        hashMap.put("PSDEVSLNSYSREF", "");
        hashMap.put("PSDEVSLNSYSREFLINK", "");
        hashMap.put("PSDEVSLNSYSRES", "");
        hashMap.put("PSDEVSLNSYSSRC", "");
        hashMap.put("PSDEVSLNSYSSRV", "");
        hashMap.put("PSDEVSLNSYSTS", "");
        hashMap.put("PSDEVSLNSYSVER", "");
        hashMap.put("PSDEVSLNSYSWSGIT", "");
        hashMap.put("PSDEVSLNTEMPL", "");
        hashMap.put("PSDEVSLNUSER", "");
        hashMap.put("PSDEVSLNUSERCS", "");
        hashMap.put("PSDEVSYSDIFFITEM", "");
        hashMap.put("PSDEVSYSDIFFREP", "");
        hashMap.put("PSDEVUSER", "");
        hashMap.put("PSDEVUSERGROUP", "");
        hashMap.put("PSDEVUSERMODEL", "");
        hashMap.put("PSDEVUSEROBJ", "");
        hashMap.put("PSDEVUSERRECENT", "");
        hashMap.put("PSDEVUSERSQL", "");
        hashMap.put("PSDEWIZARD", "");
        hashMap.put("PSDEWIZARDFORM", "");
        hashMap.put("PSDEWIZARDSTEP", "");
        hashMap.put("PSDRITEMTYPE", "");
        hashMap.put("PSDSBOOKING", "");
        hashMap.put("PSDSBOOKINGLOG", "");
        hashMap.put("PSDSCONSOLE", "");
        hashMap.put("PSDSPANELTOOLBOX", "");
        hashMap.put("PSDSSYSAPPBAR", "");
        hashMap.put("PSDSSYSAPPBARFILTER", "");
        hashMap.put("PSDYNAAPP", "");
        hashMap.put("PSDYNAAPPVCINST", "");
        hashMap.put("PSDYNAAPPVIEW", "");
        hashMap.put("PSDYNAAPPVIEWCTRL", "");
        hashMap.put("PSDYNAAPPVIEWINST", "");
        hashMap.put("PSDYNACODELIST", "");
        hashMap.put("PSDYNACODELISTINST", "");
        hashMap.put("PSDYNADE", "");
        hashMap.put("PSDYNADEFORM", "");
        hashMap.put("PSDYNADEFORMINST", "");
        hashMap.put("PSDYNADEFORMTEMPL", "");
        hashMap.put("PSDYNADETEMPL", "");
        hashMap.put("PSDYNADEVIEWTEMPL", "");
        hashMap.put("PSDYNAINST", "");
        hashMap.put("PSDYNASYS", "");
        hashMap.put("PSDYNAWF", "");
        hashMap.put("PSDYNAWFVER", "");
        hashMap.put("PSDYNAWFVERINST", "");
        hashMap.put("PSDYNAWORKFLOW", "");
        hashMap.put("PSEDITORSTYLE", "");
        hashMap.put("PSEDITORTYPE", "");
        hashMap.put("PSFDLOGICTYPE", "");
        hashMap.put("PSFORMDETAILTYPE", "");
        hashMap.put("PSFORMTYPE", "");
        hashMap.put("PSGITUSER", "");
        hashMap.put("PSHELPARTICLE", "");
        hashMap.put("PSHELPARTICLECAT", "");
        hashMap.put("PSHELPARTICLETEMPL", "");
        hashMap.put("PSHELPARTICLETYPE", "");
        hashMap.put("PSHELPARTSEC", "");
        hashMap.put("PSHELPMODART", "");
        hashMap.put("PSHELPMODULE", "");
        hashMap.put("PSHELPPRJ", "");
        hashMap.put("PSHELPPRJTEMPL", "");
        hashMap.put("PSHELPPRJTYPE", "");
        hashMap.put("PSHELPRESOURCE", "");
        hashMap.put("PSHELPSECTION", "");
        hashMap.put("PSHELPSECTIONTEMPL", "");
        hashMap.put("PSHELPSECTIONTYPE", "");
        hashMap.put("PSIMAGETEMPL", "");
        hashMap.put("PSLANGUAGE", "");
        hashMap.put("PSLANGUAGEITEM", "");
        hashMap.put("PSLANGUAGERES", "");
        hashMap.put("PSLISTITEMTYPE", "");
        hashMap.put("PSMAVENREPO", "");
        hashMap.put("PSMAVENSERVER", "");
        hashMap.put("PSMAVENSERVERTYPE", "");
        hashMap.put("PSMIDETAIL", "");
        hashMap.put("PSMOBAPPPACK", "");
        hashMap.put("PSMOBAPPPACKSERVER", "");
        hashMap.put("PSMOBAPPPACKSESSION", "");
        hashMap.put("PSMOBAPPPACKTD", "");
        hashMap.put("PSMOBAPPSTARTPAGE", "");
        hashMap.put("PSMODEL", "");
        hashMap.put("PSMODELAPI", "");
        hashMap.put("PSMODELAPIINT", "");
        hashMap.put("PSMODELAPIMETHOD", "");
        hashMap.put("PSMODELAPIRS", "");
        hashMap.put("PSMODELBOOKMARK", "");
        hashMap.put("PSMODELERROR", "");
        hashMap.put("PSMODELEXAMPLE", "");
        hashMap.put("PSMODELEXAMPLECAT", "");
        hashMap.put("PSMODELEXAMPLESTEP", "");
        hashMap.put("PSMODELFIELD", "");
        hashMap.put("PSMODELFIELDVALUE", "");
        hashMap.put("PSMODELHOTCODE", "");
        hashMap.put("PSMODELIMPORT", "");
        hashMap.put("PSMODELINIT", "");
        hashMap.put("PSMODELMEMO", "");
        hashMap.put("PSMODELMODULE", "");
        hashMap.put("PSMODELOBJ", "");
        hashMap.put("PSMODELOBJREF", "");
        hashMap.put("PSMODELPFCODE", "");
        hashMap.put("PSMODELPLUGIN", "");
        hashMap.put("PSMODELREF", "");
        hashMap.put("PSMODELRESOURCE", "");
        hashMap.put("PSMODELRS", "");
        hashMap.put("PSMODELRT", "");
        hashMap.put("PSMODELRTMSG", "");
        hashMap.put("PSMODELSECTION", "");
        hashMap.put("PSMODELSEQ", "");
        hashMap.put("PSMODELSFCODE", "");
        hashMap.put("PSMODELSTATE", "");
        hashMap.put("PSMODELSTORAGE", "");
        hashMap.put("PSMODELSUBVIEW", "");
        hashMap.put("PSMODELSUMMARYTEMPL", "");
        hashMap.put("PSMODELUIACTION", "");
        hashMap.put("PSMODELVALUEGROUP", "");
        hashMap.put("PSMODELVIEW", "");
        hashMap.put("PSMODELVIEWUIACTION", "");
        hashMap.put("PSMODULE", "");
        hashMap.put("PSMQINST", "");
        hashMap.put("PSMQTYPE", "");
        hashMap.put("PSMSPLATFORM", "");
        hashMap.put("PSMSPLATFORMFUNC", "");
        hashMap.put("PSMSPLATFORMNODE", "");
        hashMap.put("PSNDFILE", "");
        hashMap.put("PSNDFILELINK", "");
        hashMap.put("PSPANELDETAILTYPE", "");
        hashMap.put("PSPANELENGINE", "");
        hashMap.put("PSPANELITEMLOGIC", "");
        hashMap.put("PSPANELLLCOND", "");
        hashMap.put("PSPANELLLCONDTYPE", "");
        hashMap.put("PSPANELLLTYPE", "");
        hashMap.put("PSPANELLNPARAM", "");
        hashMap.put("PSPANELLNTYPE", "");
        hashMap.put("PSPANELLOGICLINK", "");
        hashMap.put("PSPANELLOGICNODE", "");
        hashMap.put("PSPANELLOGICPARAM", "");
        hashMap.put("PSPDTAPPFUNC", "");
        hashMap.put("PSPDTVIEW", "");
        hashMap.put("PSPF", "");
        hashMap.put("PSPFAPPTEMPL", "");
        hashMap.put("PSPFCDN", "");
        hashMap.put("PSPFCODEFOLDER", "");
        hashMap.put("PSPFCTDETAIL", "");
        hashMap.put("PSPFCTRLTEMPL", "");
        hashMap.put("PSPFCTRLTYPE", "");
        hashMap.put("PSPFEDITORTEMPL", "");
        hashMap.put("PSPFEDITORTYPE", "");
        hashMap.put("PSPFPKG", "");
        hashMap.put("PSPFPKGCAT", "");
        hashMap.put("PSPFPKGVER", "");
        hashMap.put("PSPFPKGVERCDN", "");
        hashMap.put("PSPFPLUGIN", "");
        hashMap.put("PSPFPLUGINTEMPL", "");
        hashMap.put("PSPFPLUGINTYPE", "");
        hashMap.put("PSPFPREVIEWACTION", "");
        hashMap.put("PSPFPREVIEWNODE", "");
        hashMap.put("PSPFPUBCODE", "");
        hashMap.put("PSPFPUBOBJ", "");
        hashMap.put("PSPFPUBOBJPARAM", "");
        hashMap.put("PSPFQUICKTEMPL", "");
        hashMap.put("PSPFRESOURCE", "");
        hashMap.put("PSPFSTYLE", "");
        hashMap.put("PSPFSTYLECODE", "");
        hashMap.put("PSPFSTYLELOG", "");
        hashMap.put("PSPFSTYLEPKG", "");
        hashMap.put("PSPFSTYLEPRJ", "");
        hashMap.put("PSPFUATEMPL", "");
        hashMap.put("PSPFVIEWTEMPL", "");
        hashMap.put("PSPFVIEWTYPE", "");
        hashMap.put("PSPFVLTEMPL", "");
        hashMap.put("PSPILOGICTYPE", "");
        hashMap.put("PSPORTLET", "");
        hashMap.put("PSPORTLETTYPE", "");
        hashMap.put("PSPRODUCT", "");
        hashMap.put("PSPRODUCTTYPE", "");
        hashMap.put("PSROBOT", "");
        hashMap.put("PSROBOTABILITY", "");
        hashMap.put("PSROBOTTYPE", "");
        hashMap.put("PSROBOTTYPEABILITY", "");
        hashMap.put("PSROBOTWORK", "");
        hashMap.put("PSROBOTWORKTYPE", "");
        hashMap.put("PSROSSERVER", "");
        hashMap.put("PSRTWXACCOUNT", "");
        hashMap.put("PSSAASSYS", "");
        hashMap.put("PSSAASSYSAPI", "");
        hashMap.put("PSSAASSYSAPP", "");
        hashMap.put("PSSAASSYSDB", "");
        hashMap.put("PSSAASSYSVER", "");
        hashMap.put("PSSAHANDLER", "");
        hashMap.put("PSSAMPLEVALUE", "");
        hashMap.put("PSSF", "");
        hashMap.put("PSSFACHANDLER", "");
        hashMap.put("PSSFCODEFOLDER", "");
        hashMap.put("PSSFCODETEMPL", "");
        hashMap.put("PSSFCODETYPE", "");
        hashMap.put("PSSFCONFIG", "");
        hashMap.put("PSSFCTRLTYPE", "");
        hashMap.put("PSSFEXCEPTION", "");
        hashMap.put("PSSFPF", "");
        hashMap.put("PSSFPKG", "");
        hashMap.put("PSSFPKGCAT", "");
        hashMap.put("PSSFPKGVER", "");
        hashMap.put("PSSFPLUGIN", "");
        hashMap.put("PSSFPLUGINTEMPL", "");
        hashMap.put("PSSFPREVIEWACTION", "");
        hashMap.put("PSSFPUBOBJ", "");
        hashMap.put("PSSFPUBOBJPARAM", "");
        hashMap.put("PSSFSAHANDLER", "");
        hashMap.put("PSSFSTYLE", "");
        hashMap.put("PSSFSTYLECODE", "");
        hashMap.put("PSSFSTYLELOG", "");
        hashMap.put("PSSFSTYLEPARAM", "");
        hashMap.put("PSSFSTYLEPKG", "");
        hashMap.put("PSSFSTYLEPRJ", "");
        hashMap.put("PSSFSTYLEREF", "");
        hashMap.put("PSSFSTYLEVER", "");
        hashMap.put("PSSFVERCODE", "");
        hashMap.put("PSSFVERCODEITEM", "");
        hashMap.put("PSSFVIEWTYPE", "");
        hashMap.put("PSSTUDIOSERVER", "");
        hashMap.put("PSSTUDIOSERVERGRP", "");
        hashMap.put("PSSTUDIOSERVERLOG", "");
        hashMap.put("PSSTUDIOTHEME", "");
        hashMap.put("PSSUBAPP", "");
        hashMap.put("PSSUBAPPVIEW", "");
        hashMap.put("PSSUBDE", "");
        hashMap.put("PSSUBDEACTION", "");
        hashMap.put("PSSUBDEVIEW", "");
        hashMap.put("PSSUBSYS", "");
        hashMap.put("PSSUBSYSDM", "");
        hashMap.put("PSSUBSYSSADETAIL", "");
        hashMap.put("PSSUBSYSSERVICEAPI", "");
        hashMap.put("PSSUBSYSSF", "");
        hashMap.put("PSSUBSYSVER", "");
        hashMap.put("PSSUBSYSVERINST", "");
        hashMap.put("PSSUBVIEWTYPE", "");
        hashMap.put("PSSVNINSTREPO", "");
        hashMap.put("PSSVNSERVER", "");
        hashMap.put("PSSVRDOMAIN", "");
        hashMap.put("PSSVRPROVIDER", "");
        hashMap.put("PSSVRSERVER", "");
        hashMap.put("PSSYSACHANDLER", "");
        hashMap.put("PSSYSACTOR", "");
        hashMap.put("PSSYSAPP", "");
        hashMap.put("PSSYSBACKSERVICE", "");
        hashMap.put("PSSYSBDCOLSET", "");
        hashMap.put("PSSYSBDCOLUMN", "");
        hashMap.put("PSSYSBDINSTCFG", "");
        hashMap.put("PSSYSBDMODULE", "");
        hashMap.put("PSSYSBDPART", "");
        hashMap.put("PSSYSBDSCHEME", "");
        hashMap.put("PSSYSBDTABLE", "");
        hashMap.put("PSSYSBDTABLEDE", "");
        hashMap.put("PSSYSBDTABLEDER", "");
        hashMap.put("PSSYSBDTABLERS", "");
        hashMap.put("PSSYSCALENDAR", "");
        hashMap.put("PSSYSCALENDARITEM", "");
        hashMap.put("PSSYSCALENDARITEMRV", "");
        hashMap.put("PSSYSCODESNIPPET", "");
        hashMap.put("PSSYSCONSOLE", "");
        hashMap.put("PSSYSCOUNTER", "");
        hashMap.put("PSSYSCOUNTERITEM", "");
        hashMap.put("PSSYSCSS", "");
        hashMap.put("PSSYSCSSCAT", "");
        hashMap.put("PSSYSCTRLSTYLE", "");
        hashMap.put("PSSYSDASHBOARD", "");
        hashMap.put("PSSYSDATASYNCAGENT", "");
        hashMap.put("PSSYSDBCHGLOG", "");
        hashMap.put("PSSYSDBCOLUMN", "");
        hashMap.put("PSSYSDBDETAIL", "");
        hashMap.put("PSSYSDBPART", "");
        hashMap.put("PSSYSDBSCHEME", "");
        hashMap.put("PSSYSDBTABLE", "");
        hashMap.put("PSSYSDBVALUEOP", "");
        hashMap.put("PSSYSDBVF", "");
        hashMap.put("PSSYSDBVFCODE", "");
        hashMap.put("PSSYSDEFTYPE", "");
        hashMap.put("PSSYSDELOGICNODE", "");
        hashMap.put("PSSYSDEPLOY", "");
        hashMap.put("PSSYSDEPLOYAPP", "");
        hashMap.put("PSSYSDEPLOYAS", "");
        hashMap.put("PSSYSDEPLOYDB", "");
        hashMap.put("PSSYSDEVBKTASK", "");
        hashMap.put("PSSYSDEVBTTYPE", "");
        hashMap.put("PSSYSDEVINFO", "");
        hashMap.put("PSSYSDEVINFOTYPE", "");
        hashMap.put("PSSYSDEVSTUDIO", "");
        hashMap.put("PSSYSDICTCAT", "");
        hashMap.put("PSSYSDMITEM", "");
        hashMap.put("PSSYSDMITEMLOG", "");
        hashMap.put("PSSYSDMVER", "");
        hashMap.put("PSSYSDMVERITEM", "");
        hashMap.put("PSSYSDSACTION", "");
        hashMap.put("PSSYSDSACTIONTYPE", "");
        hashMap.put("PSSYSDYNAMODEL", "");
        hashMap.put("PSSYSDYNAMODELATTR", "");
        hashMap.put("PSSYSDYNAMODELCAT", "");
        hashMap.put("PSSYSEDITORSTYLE", "");
        hashMap.put("PSSYSENGINECFG", "");
        hashMap.put("PSSYSERMAP", "");
        hashMap.put("PSSYSERMAPNODE", "");
        hashMap.put("PSSYSFILE", "");
        hashMap.put("PSSYSIMAGE", "");
        hashMap.put("PSSYSISSUE", "");
        hashMap.put("PSSYSISSUEENGINE", "");
        hashMap.put("PSSYSISSUETYPE", "");
        hashMap.put("PSSYSLANITEM", "");
        hashMap.put("PSSYSLANRES", "");
        hashMap.put("PSSYSMODELACTION", "");
        hashMap.put("PSSYSMODELFOLDER", "");
        hashMap.put("PSSYSMODELFOLDERITEM", "");
        hashMap.put("PSSYSMODELFUNC", "");
        hashMap.put("PSSYSMODELFUNCCAT", "");
        hashMap.put("PSSYSMODELFUNCTEMPL", "");
        hashMap.put("PSSYSMODELGROUP", "");
        hashMap.put("PSSYSMODELINST", "");
        hashMap.put("PSSYSMODELINSTBK", "");
        hashMap.put("PSSYSMODELINSTSUM", "");
        hashMap.put("PSSYSMODELLOADLOG", "");
        hashMap.put("PSSYSMODELLOG", "");
        hashMap.put("PSSYSMODELMSG", "");
        hashMap.put("PSSYSMODELSYNC", "");
        hashMap.put("PSSYSMODELVER", "");
        hashMap.put("PSSYSMSGTEMPL", "");
        hashMap.put("PSSYSOPPRIV", "");
        hashMap.put("PSSYSORGTYPE", "");
        hashMap.put("PSSYSOUTYPE", "");
        hashMap.put("PSSYSOUTYPERS", "");
        hashMap.put("PSSYSPDTVIEW", "");
        hashMap.put("PSSYSPFPITEMPL", "");
        hashMap.put("PSSYSPFPLUGIN", "");
        hashMap.put("PSSYSPOLICY", "");
        hashMap.put("PSSYSPOLICYMODEL", "");
        hashMap.put("PSSYSPORTLET", "");
        hashMap.put("PSSYSPRDVER", "");
        hashMap.put("PSSYSPRODUCT", "");
        hashMap.put("PSSYSPROJECT", "");
        hashMap.put("PSSYSREF", "");
        hashMap.put("PSSYSREFDE", "");
        hashMap.put("PSSYSREPORT", "");
        hashMap.put("PSSYSREQITEM", "");
        hashMap.put("PSSYSREQITEMDATA", "");
        hashMap.put("PSSYSREQITEMHIS", "");
        hashMap.put("PSSYSREQMODULE", "");
        hashMap.put("PSSYSRTDEFINPUTTIP", "");
        hashMap.put("PSSYSRTMSG", "");
        hashMap.put("PSSYSRUNLOG", "");
        hashMap.put("PSSYSRUNSESSION", "");
        hashMap.put("PSSYSSAHANDLER", "");
        hashMap.put("PSSYSSAMPLEVALUE", "");
        hashMap.put("PSSYSSEARCHBAR", "");
        hashMap.put("PSSYSSEARCHBARITEM", "");
        hashMap.put("PSSYSSERVICEAPI", "");
        hashMap.put("PSSYSSFCODE", "");
        hashMap.put("PSSYSSFPITEMPL", "");
        hashMap.put("PSSYSSFPLUGIN", "");
        hashMap.put("PSSYSSFPUB", "");
        hashMap.put("PSSYSSFPUBPKG", "");
        hashMap.put("PSSYSSFPUBREF", "");
        hashMap.put("PSSYSSQLCMD", "");
        hashMap.put("PSSYSSQLCMDSQL", "");
        hashMap.put("PSSYSTASK", "");
        hashMap.put("PSSYSTASKDATA", "");
        hashMap.put("PSSYSTBITEM", "");
        hashMap.put("PSSYSTCASSERT", "");
        hashMap.put("PSSYSTCINPUT", "");
        hashMap.put("PSSYSTDITEM", "");
        hashMap.put("PSSYSTEM", "");
        hashMap.put("PSSYSTEMAS", "");
        hashMap.put("PSSYSTEMDBCFG", "");
        hashMap.put("PSSYSTEMMQ", "");
        hashMap.put("PSSYSTEMRUN", "");
        hashMap.put("PSSYSTEMSRC", "");
        hashMap.put("PSSYSTESTCASE", "");
        hashMap.put("PSSYSTESTDATA", "");
        hashMap.put("PSSYSTITLEBAR", "");
        hashMap.put("PSSYSTOOLBAR", "");
        hashMap.put("PSSYSUIACTION", "");
        hashMap.put("PSSYSUNIRES", "");
        hashMap.put("PSSYSUNISTATE", "");
        hashMap.put("PSSYSUNIT", "");
        hashMap.put("PSSYSUSERCASE", "");
        hashMap.put("PSSYSUSERCASERS", "");
        hashMap.put("PSSYSUSERDR", "");
        hashMap.put("PSSYSUSERMODE", "");
        hashMap.put("PSSYSUSERROLERES", "");
        hashMap.put("PSSYSUSERROLEDATA", "");
        hashMap.put("PSSYSUTILDE", "");
        hashMap.put("PSSYSUTILTYPE", "");
        hashMap.put("PSSYSVALUERULE", "");
        hashMap.put("PSSYSVIEWLOGIC", "");
        hashMap.put("PSSYSVIEWLOGICPARAM", "");
        hashMap.put("PSSYSVIEWPANEL", "");
        hashMap.put("PSSYSVIEWPANELITEM", "");
        hashMap.put("PSSYSVIEWPANELLOGIC", "");
        hashMap.put("PSSYSVIEWPANELMODEL", "");
        hashMap.put("PSSYSWFMODE", "");
        hashMap.put("PSSYSWFSETTING", "");
        hashMap.put("PSTASKSERVER", "");
        hashMap.put("PSTASKSERVERLOG", "");
        hashMap.put("PSTBITEMTYPE", "");
        hashMap.put("PSTREENODETYPE", "");
        hashMap.put("PSTSCMD", "");
        hashMap.put("PSUACAPPTYPE", "");
        hashMap.put("PSUAWIZARD", "");
        hashMap.put("PSUAWIZARD2", "");
        hashMap.put("PSUAWIZARD3", "");
        hashMap.put("PSUIENGINETYPE", "");
        hashMap.put("PSUIENGINETYPEPARAM", "");
        hashMap.put("PSUNIT", "");
        hashMap.put("PSUSDCAPPPOLICY", "");
        hashMap.put("PSUSDCMODULE", "");
        hashMap.put("PSUSDCMODULEINST", "");
        hashMap.put("PSUSDCMODULEINSTFUNC", "");
        hashMap.put("PSUSDCMODULEINSTREF", "");
        hashMap.put("PSUSMODULE", "");
        hashMap.put("PSUSMODULEINST", "");
        hashMap.put("PSUSMODULEINSTFUNC", "");
        hashMap.put("PSUSMODULEINSTREF", "");
        hashMap.put("PSUWAPPFUNC", "");
        hashMap.put("PSUWAPPVIEW", "");
        hashMap.put("PSUWCREATEDE", "");
        hashMap.put("PSUWCREATEDEDEF", "");
        hashMap.put("PSUWCREATEDEDER", "");
        hashMap.put("PSUWCREATEDEITEM", "");
        hashMap.put("PSUWCREATEMODEL", "");
        hashMap.put("PSUWDEDRITEM", "");
        hashMap.put("PSUWDEUNIONKEY", "");
        hashMap.put("PSUWPICKUPMODEL", "");
        hashMap.put("PSVALUERULE", "");
        hashMap.put("PSVARSAMPLEVALUE", "");
        hashMap.put("PSVARTYPE", "");
        hashMap.put("PSVIEWENGINE", "");
        hashMap.put("PSVIEWLOGICTYPE", "");
        hashMap.put("PSVIEWLOGICTYPEPARAM", "");
        hashMap.put("PSVIEWMSG", "");
        hashMap.put("PSVIEWMSGGROUP", "");
        hashMap.put("PSVIEWMSGGRPDETAIL", "");
        hashMap.put("PSVIEWRTMSG", "");
        hashMap.put("PSVIEWSTYLE", "");
        hashMap.put("PSVIEWTYPE", "");
        hashMap.put("PSVIEWTYPECAT", "");
        hashMap.put("PSVIEWTYPELOGIC", "");
        hashMap.put("PSVIEWWIZARDGROUP", "");
        hashMap.put("PSVTCATDETAIL", "");
        hashMap.put("PSVTCTRL", "");
        hashMap.put("PSVTRV", "");
        hashMap.put("PSVTSAMPLE", "");
        hashMap.put("PSVTSTYLE", "");
        hashMap.put("PSWFDE", "");
        hashMap.put("PSWFENGINETYPE", "");
        hashMap.put("PSWFLINK", "");
        hashMap.put("PSWFLINKCOND", "");
        hashMap.put("PSWFLINKCONDTYPE", "");
        hashMap.put("PSWFLINKROLE", "");
        hashMap.put("PSWFLINKTYPE", "");
        hashMap.put("PSWFPROCESS", "");
        hashMap.put("PSWFPROCESSTYPE", "");
        hashMap.put("PSWFPROCPARAM", "");
        hashMap.put("PSWFPROCROLE", "");
        hashMap.put("PSWFPROCSUBWF", "");
        hashMap.put("PSWFROLE", "");
        hashMap.put("PSWFSUBWF", "");
        hashMap.put("PSWFUTILUIACTION", "");
        hashMap.put("PSWFVERLOG", "");
        hashMap.put("PSWFVERSION", "");
        hashMap.put("PSWFWORKTIME", "");
        hashMap.put("PSWORKFLOW", "");
        hashMap.put("PSWORKSHOPSERVER", "");
        hashMap.put("PSWORKSPACE", "");
        hashMap.put("PSWORKSPACELOG", "");
        hashMap.put("PSWORKSPACETYPE", "");
        hashMap.put("PSWPAPP", "");
        hashMap.put("PSWPAPPENTITY", "");
        hashMap.put("PSWPAPPINST", "");
        hashMap.put("PSWPDCAPPENTITY", "");
        hashMap.put("PSWPDCAPPINST", "");
        hashMap.put("PSWPDCENGINEINST", "");
        hashMap.put("PSWPDCWFCAT", "");
        hashMap.put("PSWPDCWFINST", "");
        hashMap.put("PSWPDCWORKFLOW", "");
        hashMap.put("PSWPENGINE", "");
        hashMap.put("PSWPENGINEINST", "");
        hashMap.put("PSWXACCOUNT", "");
        hashMap.put("PSWXENTAPP", "");
        hashMap.put("PSWXLOGIC", "");
        hashMap.put("PSWXMENU", "");
        hashMap.put("PSWXMENUFUNC", "");
        hashMap.put("PSWXMENUITEM", "");
        hashMap.put("PSSUBSYSSADE", "");
        hashMap.put("PSSUBSYSSADEFIELD", "");
        hashMap.put("PSSUBSYSSADERS", "");
        hashMap.put("PSSYSDBPROC", "");
        hashMap.put("PSSYSDBPROCPARAM", "");
        hashMap.put("PSDESAVR", "");
        hashMap.put("PSSYSCONTENT", "");
        hashMap.put("PSSYSRESOURCE", "");
        hashMap.put("PSAPPSTORYBOARD", "");
        hashMap.put("PSAPPSBITEMRS", "");
        hashMap.put("PSAPPSBITEM", "");
        hashMap.put("PSAPPRESOURCE", "");
        hashMap.put("PSSYSCONTENTCAT", "");
        hashMap.put("PSSYSTESTMODULE", "");
        hashMap.put("PSSYSTESTPRJ", "");
        hashMap.put("PSSYSUCMAP", "");
        hashMap.put("PSSYSUCMAPNODE", "");
        hashMap.put("PSDEACTIONGROUP", "");
        hashMap.put("PSDEAGDETAIL", "");
        hashMap.put("PSCTRLLOGICGROUP", "");
        hashMap.put("PSCTRLLOGICGRPDETAIL", "");
        hashMap.put("PSSYSSEARCHSCHEME", "");
        hashMap.put("PSSYSSEARCHDOC", "");
        hashMap.put("PSSYSSEARCHFIELD", "");
        hashMap.put("PSSYSSEARCHDE", "");
        hashMap.put("PSSYSSEARCHDEFIELD", "");
        hashMap.put("PSSYSMAPVIEW", "");
        hashMap.put("PSSYSMAPITEM", "");
        hashMap.put("PSSYSPORTLETCAT", "");
        hashMap.put("PSAPPPORTLET", "");
        hashMap.put("PSSYSWFCAT", "");
        hashMap.put("PSAPPSTORYBOARD", "");
        hashMap.put("PSAPPSBITEM", "");
        hashMap.put("PSAPPSBITEMRS", "");
        hashMap.put("PSDEGEIVR", "");
        hashMap.put("PSDEACTIONVR", "");
        hashMap.put("PSDEMSFIELD", "");
        hashMap.put("PSSYSSEQUENCE", "");
        hashMap.put("PSSYSTRANSLATOR", "");
        hashMap.put("PSSYSMSGQUEUE", "");
        hashMap.put("PSSYSMSGTARGET", "");
        hashMap.put("PSDENOTIFY", "");
        hashMap.put("PSDENOTIFYTARGET", "");
        hashMap.put("PSSYSEAIDATATYPEITEM", "");
        hashMap.put("PSSYSEAIDER", "");
        hashMap.put("PSSYSEAIDEFIELD", "");
        hashMap.put("PSSYSEAIDE", "");
        hashMap.put("PSSYSEAIELEMENTRE", "");
        hashMap.put("PSSYSEAIELEMENTATTR", "");
        hashMap.put("PSSYSEAIELEMENT", "");
        hashMap.put("PSSYSEAIDATATYPE", "");
        hashMap.put("PSSYSEAISCHEME", "");
        hashMap.put("PSSYSBIAGGCOLUMN", "");
        hashMap.put("PSSYSBIAGGTABLE", "");
        hashMap.put("PSSYSBICUBELEVEL", "");
        hashMap.put("PSSYSBICUBEMEASURE", "");
        hashMap.put("PSSYSBICUBEDIMENSION", "");
        hashMap.put("PSSYSBILEVEL", "");
        hashMap.put("PSSYSBIHIERARCHY", "");
        hashMap.put("PSSYSBIDIMENSION", "");
        hashMap.put("PSSYSBICUBE", "");
        hashMap.put("PSSYSBISCHEME", "");
        hashMap.put("PSTHRESHOLD", "");
        hashMap.put("PSTHRESHOLDGROUP", "");
        hashMap.put("PSSYSCHARTTHEME", "");
        hashMap.put("PSSYSCANVAS", "");
        hashMap.put("PSSYSCANVASMODEL", "");
        hashMap.put("PSSYSDASHBOARDLOGIC", "");
        hashMap.put("PSAPPMENULOGIC", "");
        hashMap.put("PSDEFORMLOGIC", "");
        hashMap.put("PSSYSSEARCHBARLOGIC", "");
        hashMap.put("PSAPPLOGIC", "");
        hashMap.put("PSDETOOLBARLOGIC", "");
        hashMap.put("PSDEWIZARDLOGIC", "");
        hashMap.put("PSDELISTLOGIC", " ");
        hashMap.put("PSSYSMAPLOGIC", "");
        hashMap.put("PSDETREELOGIC", "");
        hashMap.put("PSDEDATAVIEWLOGIC", "");
        hashMap.put("PSSYSCALENDARLOGIC", "");
        hashMap.put("PSDEGRIDLOGIC", "");
        hashMap.put("PSDECHARTLOGIC", "");
        hashMap.put("PSDEDRLOGIC", "");
        hashMap.put("PSDETEIUDETAIL", "");
        hashMap.put("PSDETEIUPDATE", "");
        hashMap.put("PSSYSUSECASECAT", "");
        hashMap.put("PSDETEIUPDATE", "");
        hashMap.put("PSDETEIUDETAIL", "");
        hashMap.put("PSSYSBIREPORT", "");
        hashMap.put("PSSYSBIREPORTITEM", "");
        hashMap.put("PSAPPPFPLUGIN", "");
        hashMap.put("PSSYSAICHATAGENT", "");
        hashMap.put("PSSYSAIFACTORY", "");
        hashMap.put("PSSYSAIPIPELINEAGENT", "");
        hashMap.put("PSSYSAIPIPELINEJOB", "");
        hashMap.put("PSSYSAIPIPELINEWORKER", "");
        hashMap.put("PSSYSAIWORKERAGENT", "");
        return hashMap;
    }

    public Map<String, Integer> count() throws Exception {
        final ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<String, Integer>();
        long l = System.currentTimeMillis();
        Map<String, String> map = this.getBackupDataMap();
        map.remove("PSSYSCONSOLE");
        final ArrayList<String> arrayList = new ArrayList<String>();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        arrayList.addAll(map.keySet());
        arrayList.add("PSAPPVIEW");
        final int n = arrayList.size();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 8; ++i) {
            executorService.execute(new Runnable(){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 * Converted monitor instructions to comments
                 * Lifted jumps to return sites
                 */
                @Override
                public void run() {
                    String string = null;
                    try {
                        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory(PSModelV2Helper.this.getPSSysModelInstId());
                        while (arrayList3.size() == 0) {
                            Object object;
                            ArrayList arrayList4;
                            string = null;
                            ArrayList arrayList22 = arrayList;
                            // MONITORENTER : arrayList22
                            if (arrayList.size() > 0) {
                                string = (String)arrayList.remove(0);
                            }
                            // MONITOREXIT : arrayList22
                            if (StringHelper.isNullOrEmpty(string)) {
                                return;
                            }
                            arrayList22 = DEModelGlobal.getDEModel((String)string, (boolean)true);
                            if (arrayList22 == null) {
                                arrayList4 = arrayList2;
                                // MONITORENTER : arrayList4
                                arrayList2.add(string);
                                log.debug((Object)StringHelper.format((String)"\u8ba1\u6570[%1$s]\uff0c\u5f53\u524d\u5df2\u5b8c\u6210 %2$s/%3$s", (Object)string, (Object)arrayList2.size(), (Object)n));
                                // MONITOREXIT : arrayList4
                                continue;
                            }
                            arrayList4 = arrayList22.getService(sessionFactory);
                            if (arrayList4.getSessionFactory() != sessionFactory) {
                                object = arrayList2;
                                // MONITORENTER : object
                                arrayList2.add(string);
                                log.debug((Object)StringHelper.format((String)"\u5ffd\u7565\u8ba1\u6570[%1$s]\uff0c\u6570\u636e\u6e90\u4e0d\u4e00\u81f4\uff0c\u5f53\u524d\u5df2\u5b8c\u6210 %2$s/%3$s", (Object)string, (Object)arrayList2.size(), (Object)n));
                                // MONITOREXIT : object
                                continue;
                            }
                            try {
                                object = StringHelper.format((String)"SELECT COUNT(1) AS CNT FROM %1$s", (Object)arrayList22.getTableName());
                                ArrayList arrayList32 = arrayList4.selectRaw((String)object, null);
                                int n2 = DataObject.getIntegerValue((IDataObject)((IEntity)arrayList32.get(0)), (String)"CNT", (int)0);
                                concurrentHashMap.put(string, n2);
                            }
                            catch (Exception exception) {
                                log.error((Object)exception);
                                concurrentHashMap.put(string, 0);
                            }
                            object = arrayList2;
                            // MONITORENTER : object
                            arrayList2.add(string);
                            log.debug((Object)StringHelper.format((String)"\u8ba1\u6570[%1$s]\uff0c\u5f53\u524d\u5df2\u5b8c\u6210 %2$s/%3$s", (Object)string, (Object)arrayList2.size(), (Object)n));
                            // MONITOREXIT : object
                        }
                        return;
                    }
                    catch (Exception exception) {
                        log.error((Object)exception);
                        if (StringHelper.isNullOrEmpty(string)) {
                            arrayList3.add("\u672a\u77e5\u6a21\u578b");
                            return;
                        }
                        arrayList3.add(string);
                    }
                }
            });
        }
        while (arrayList2.size() != n && arrayList3.size() == 0) {
            Thread.sleep(50L);
        }
        executorService.shutdown();
        if (arrayList3.size() > 0) {
            StringBuilderEx stringBuilderEx = new StringBuilderEx();
            stringBuilderEx.append("\u6a21\u578b\u8ba1\u6570\u53d1\u751f\u9519\u8bef\uff1a");
            boolean bl = true;
            for (String string : arrayList3) {
                if (bl) {
                    bl = false;
                } else {
                    stringBuilderEx.append(",");
                }
                stringBuilderEx.append(string);
            }
            throw new Exception(stringBuilderEx.toString());
        }
        log.debug((Object)StringHelper.format((String)"\u6a21\u578b\u8ba1\u6570\u8017\u65f6[%1$s]", (Object)(System.currentTimeMillis() - l)));
        return concurrentHashMap;
    }

    protected void sendStudioConsoleRaw(String string, String string2) {
        this.sendStudioConsoleRaw(string, string2, null);
    }

    protected void sendStudioConsoleRaw(String string, String string2, String string3) {
        if (PSStudioConsoleHelper.getCurrent() != null) {
            if (StringHelper.isNullOrEmpty((String)string)) {
                string = this.getStudioConsoleId();
            }
            if (StringHelper.isNullOrEmpty((String)string)) {
                return;
            }
            PSStudioConsoleHelper.getCurrent().sendConsole(string, string2, string3);
        }
    }

    protected void sendStudioConsole(String string, String string2, String string3) {
        this.sendStudioConsole(string, string2, string3, null);
    }

    protected void sendStudioConsole(String string, String string2, String string3, String string4) {
        if (PSStudioConsoleHelper.getCurrent() != null) {
            if (StringHelper.isNullOrEmpty((String)string)) {
                string = this.getStudioConsoleId();
            }
            if (StringHelper.isNullOrEmpty((String)string)) {
                return;
            }
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                string3 = StringHelper.compare((String)string2, (String)"INFO", (boolean)false) == 0 ? PSStudioConsoleHelper.getContent(string3, 34, -1, 0) : (StringHelper.compare((String)string2, (String)"WARN", (boolean)false) == 0 ? PSStudioConsoleHelper.getContent(string3, 33, -1, 1) : (StringHelper.compare((String)string2, (String)"ERROR", (boolean)false) == 0 ? PSStudioConsoleHelper.getContent(string3, 31, -1, 1) : (StringHelper.compare((String)string2, (String)"DEBUG", (boolean)false) == 0 ? PSStudioConsoleHelper.getContent(string3, 37, -1, 0) : PSStudioConsoleHelper.getContent(string3, 32, -1, 0))));
            }
            PSStudioConsoleHelper.getCurrent().sendConsole(string, string3, string4);
        }
    }

    public String getStudioConsoleId() {
        return this.strPSDSConsoleId;
    }

    public static boolean testExportModel(String string) {
        return exportModelMap.containsKey(string);
    }

    public static IDataObject fromJSONObject(IDataObject iDataObject, ObjectNode objectNode, boolean bl) throws Exception {
        Iterator iterator = objectNode.fields();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            String string = (String)entry.getKey();
            JsonNode jsonNode = (JsonNode)entry.getValue();
            try {
                ObjectNode objectNode2;
                if (jsonNode instanceof NullNode) {
                    iDataObject.set(string, null);
                    continue;
                }
                if (jsonNode.isTextual()) {
                    iDataObject.set(string, (Object)jsonNode.asText());
                    continue;
                }
                if (jsonNode.isInt()) {
                    iDataObject.set(string, (Object)((IntNode)jsonNode).intValue());
                    continue;
                }
                if (jsonNode.isDouble()) {
                    iDataObject.set(string, (Object)((DoubleNode)jsonNode).asDouble());
                    continue;
                }
                if (jsonNode instanceof ObjectNode) {
                    objectNode2 = (ObjectNode)jsonNode;
                    if (objectNode2.has("time") || objectNode2.has("timestr")) {
                        long l = 0L;
                        l = objectNode2.has("timestr") ? Long.parseLong(objectNode2.get("timestr").asText()) : objectNode2.get("time").asLong();
                        Timestamp timestamp = new Timestamp(l);
                        iDataObject.set(string, (Object)timestamp);
                        continue;
                    }
                    iDataObject.set(string, (Object)objectNode2.toString());
                    continue;
                }
                if (jsonNode instanceof ArrayNode) {
                    objectNode2 = (ArrayNode)jsonNode;
                    iDataObject.set(string, (Object)objectNode2.toString());
                    continue;
                }
                iDataObject.set(string, (Object)jsonNode.asText());
            }
            catch (Exception exception) {
                if (bl) continue;
                throw exception;
            }
        }
        return iDataObject;
    }

    public static ObjectNode toJSONObject(IEntity iEntity, boolean bl) throws Exception {
        ObjectNode objectNode = JsonNodeHelper.createObjectNode();
        HashMap hashMap = new HashMap();
        iEntity.fillMap(hashMap, false);
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry.getValue() == null || entry.getValue() == DataObject.EMPTY) continue;
            if (entry.getValue() instanceof Timestamp) {
                Long l = ((Timestamp)entry.getValue()).getTime();
                ObjectNode objectNode2 = JsonNodeHelper.createObjectNode();
                if (l < 0L) {
                    objectNode2.put("timestr", Long.toString(l));
                } else {
                    objectNode2.put("time", l);
                }
                JsonNodeHelper.put((ObjectNode)objectNode, (String)((String)entry.getKey()).toLowerCase(), (Object)objectNode2);
                continue;
            }
            JsonNodeHelper.put((ObjectNode)objectNode, (String)((String)entry.getKey()).toLowerCase(), entry.getValue());
        }
        return objectNode;
    }

    public static String toJSONString(IEntity iEntity, boolean bl) throws Exception {
        ObjectNode objectNode = PSModelV2Helper.toJSONObject(iEntity, bl);
        return mapper.writeValueAsString((Object)objectNode);
    }

    public static Iterator<String> getExportModelV2s() {
        return exportModelMap.keySet().iterator();
    }

    public static boolean containsModelV2(String string) {
        return exportModelMap.containsKey(string);
    }

    public static String getModelV2Name(String string, boolean bl) {
        if (bl) {
            return string;
        }
        return Inflector.getInstance().pluralize(string).toUpperCase();
    }

    public static String getModelV2LogicName(String string) {
        String string2 = modelLogicNameMap.get(string);
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            return string2;
        }
        return string;
    }

    public static boolean isCodeName(String string) {
        Matcher matcher = codeNamePattern.matcher(string);
        boolean bl = matcher.matches();
        return bl;
    }

    static {
        modelLogicNameMap.put("PSDETREECOL", "\u6811\u89c6\u56fe\u8868\u683c\u5217");
        modelLogicNameMap.put("PSDETREENODECOL", "\u6811\u8282\u70b9\u6570\u636e\u9879");
        modelLogicNameMap.put("PSDEACTIONTEMPL", "\u7cfb\u7edf\u5b9e\u4f53\u884c\u4e3a\u6a21\u677f");
        modelLogicNameMap.put("PSDATAENTITY", "\u5b9e\u4f53");
        modelLogicNameMap.put("PSSYSTEM", "\u7cfb\u7edf");
        modelLogicNameMap.put("PSDEFIELD", "\u5b9e\u4f53\u5c5e\u6027");
        modelLogicNameMap.put("PSAPPVIEW", "\u5e94\u7528\u89c6\u56fe");
        modelLogicNameMap.put("PSCODELIST", "\u4ee3\u7801\u8868");
        modelLogicNameMap.put("PSDEACMODE", "\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f");
        modelLogicNameMap.put("PSWORKFLOW", "\u5de5\u4f5c\u6d41");
        modelLogicNameMap.put("PSWFVERSION", "\u5de5\u4f5c\u6d41\u7248\u672c");
        modelLogicNameMap.put("PSWFROLE", "\u5de5\u4f5c\u6d41\u89d2\u8272");
        modelLogicNameMap.put("PSDELOGIC", "\u5b9e\u4f53\u903b\u8f91");
        modelLogicNameMap.put("PSDEDATAQUERY", "\u5b9e\u4f53\u67e5\u8be2");
        modelLogicNameMap.put("PSDEDATASET", "\u5b9e\u4f53\u7ed3\u679c\u96c6\u5408");
        modelLogicNameMap.put("PSSYSAPP", "\u7cfb\u7edf\u5e94\u7528");
        modelLogicNameMap.put("PSDEPRINT", "\u5b9e\u4f53\u6253\u5370");
        modelLogicNameMap.put("PSDEREPORT", "\u5b9e\u4f53\u62a5\u8868");
        modelLogicNameMap.put("PSPFPKGCAT", "\u5e94\u7528\u6846\u67b6\u5305\u5206\u7c7b");
        modelLogicNameMap.put("PSCPVISSUE", "\u5e73\u53f0\u6838\u5fc3\u4ea7\u54c1\u7248\u672c\u4fee\u590d");
        modelLogicNameMap.put("PSAPPVIEWTEMPL", "\u5e94\u7528\u89c6\u56fe\u6a21\u7248");
        modelLogicNameMap.put("PSDCSFPKGVER", "\u4e2d\u5fc3\u670d\u52a1\u6846\u67b6\u7ec4\u4ef6\u7248\u672c");
        modelLogicNameMap.put("PSSYSUIACTION", "\u5e73\u53f0\u9884\u7f6e\u754c\u9762\u884c\u4e3a");
        modelLogicNameMap.put("PSMODELSFCODE", "\u6a21\u578b\u540e\u53f0\u4ee3\u7801");
        modelLogicNameMap.put("PSDEPSLN", "\u90e8\u7f72\u65b9\u6848");
        modelLogicNameMap.put("PSDELOGICLINK", "\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8fde\u63a5");
        modelLogicNameMap.put("PSDEVSLNSYSTS", "\u5f00\u53d1\u7cfb\u7edf\u4efb\u52a1\u52a0\u8f7d");
        modelLogicNameMap.put("PSPFCTRLTEMPL", "\u5e94\u7528\u90e8\u4ef6\u4ee3\u7801\u6a21\u7248");
        modelLogicNameMap.put("PSSYSCTRLSTYLE", "\u7cfb\u7edf\u90e8\u4ef6\u6837\u5f0f");
        modelLogicNameMap.put("PSSYSTEMAS", "\u7cfb\u7edf\u5e94\u7528\u670d\u52a1\u5668");
        modelLogicNameMap.put("PSDEDATARELATION", "\u5b9e\u4f53\u5173\u7cfb\u754c\u9762\u7ec4");
        modelLogicNameMap.put("PSSFCODETYPE", "\u540e\u53f0\u6280\u672f\u67b6\u6784\u6846\u67b6\u4ee3\u7801");
        modelLogicNameMap.put("PSSYSBACKSERVICE", "\u7cfb\u7edf\u540e\u53f0\u4efb\u52a1");
        modelLogicNameMap.put("PSMODELAPIMETHOD", "\u5e73\u53f0API\u63a5\u53e3\u65b9\u6cd5");
        modelLogicNameMap.put("PSPFSTYLELOG", "\u524d\u53f0\u6280\u672f\u67b6\u6784\u6846\u67b6\u53d8\u66f4");
        modelLogicNameMap.put("PSSYSRUNSESSION", "\u7cfb\u7edf\u8fd0\u884c\u4f1a\u8bdd");
        modelLogicNameMap.put("PSSFACHANDLER", "\u7cfb\u7edf\u670d\u52a1\u90e8\u4ef6\u5904\u7406\u5668");
        modelLogicNameMap.put("PSSYSDSACTION", "\u7cfb\u7edf\u5f00\u53d1\u64cd\u4f5c");
        modelLogicNameMap.put("PSDEFDTCOL", "\u5c5e\u6027\u6570\u636e\u5217");
        modelLogicNameMap.put("PSPORTLETTYPE", "\u5e73\u53f0\u95e8\u6237\u90e8\u4ef6\u7c7b\u578b");
        modelLogicNameMap.put("PSDEAWITEM", "\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u9879");
        modelLogicNameMap.put("PSDEFVRTYPEDETAIL", "\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u7c7b\u578b\u660e\u7ec6");
        modelLogicNameMap.put("PSDEVSYSDIFFITEM", "\u5e94\u7528\u7cfb\u7edf\u5dee\u5f02\u9879");
        modelLogicNameMap.put("PSDELOGICPARAM", "\u5b9e\u4f53\u903b\u8f91\u53c2\u6570");
        modelLogicNameMap.put("PSDEPSLNMODE", "\u90e8\u7f72\u65b9\u6848\u6a21\u5f0f");
        modelLogicNameMap.put("PSSYSTDITEM", "\u7cfb\u7edf\u6d4b\u8bd5\u6570\u636e\u9879");
        modelLogicNameMap.put("PSDEVSLNSYSVER", "\u5f00\u53d1\u7cfb\u7edf\u7248\u672c");
        modelLogicNameMap.put("PSSYSDATASYNCAGENT", "\u7cfb\u7edf\u6570\u636e\u540c\u6b65\u4ee3\u7406");
        modelLogicNameMap.put("PSSYSPOLICYMODEL", "\u5e73\u53f0\u7cfb\u7edf\u7b56\u7565\u6a21\u578b\u9879");
        modelLogicNameMap.put("PSDEMAINSTATE", "\u5b9e\u4f53\u4e3b\u72b6\u6001");
        modelLogicNameMap.put("PSDEMAINSTATERS", "\u5b9e\u4f53\u4e3b\u72b6\u6001\u5173\u7cfb");
        modelLogicNameMap.put("PSDEDBCFG", "\u5b9e\u4f53\u6570\u636e\u5e93\u914d\u7f6e");
        modelLogicNameMap.put("PSWFLINKROLE", "\u6d41\u7a0b\u5904\u7406\u8fde\u63a5\u89d2\u8272");
        modelLogicNameMap.put("PSSYSUSERCASE", "\u7cfb\u7edf\u7528\u4f8b");
        modelLogicNameMap.put("PSDEACTION", "\u5b9e\u4f53\u884c\u4e3a");
        modelLogicNameMap.put("PSDEPSLNDBINST", "\u90e8\u7f72\u65b9\u6848\u6570\u636e\u5e93\u5b9e\u4f8b");
        modelLogicNameMap.put("PSSUBDEVIEW", "\u5b50\u7cfb\u7edf\u5b9e\u4f53\u89c6\u56fe");
        modelLogicNameMap.put("PSAPPVIEWLOGIC", "\u89c6\u56fe\u903b\u8f91");
        modelLogicNameMap.put("PSSYSSFPUBPKG", "\u540e\u53f0\u670d\u52a1\u4f53\u7cfb\u7ec4\u4ef6");
        modelLogicNameMap.put("PSLANGUAGEITEM", "\u8bed\u8a00\u5b9a\u4e49\u9879");
        modelLogicNameMap.put("PSDEFVRTYPE", "\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u7c7b\u578b");
        modelLogicNameMap.put("PSSYSBDSCHEME", "\u7cfb\u7edf\u5927\u6570\u636e\u4f53\u7cfb");
        modelLogicNameMap.put("PSDEACMODEITEM", "\u5b9e\u4f53\u81ea\u586b\u6570\u636e\u9879");
        modelLogicNameMap.put("PSFORMDETAILTYPE", "\u5e73\u53f0\u8868\u5355\u6210\u5458\u7c7b\u578b");
        modelLogicNameMap.put("PSSYSWFSETTING", "\u7cfb\u7edf\u6d41\u7a0b\u914d\u7f6e");
        modelLogicNameMap.put("PSBDTYPE", "\u5927\u6570\u636e\u5e93\u7c7b\u578b");
        modelLogicNameMap.put("PSDEJOINTYPE", "\u5b9e\u4f53\u67e5\u8be2\u8fde\u63a5\u7c7b\u578b");
        modelLogicNameMap.put("PSMQINST", "\u5e73\u53f0MQ\u5b9e\u4f8b");
        modelLogicNameMap.put("PSDEVSLNUSER", "\u5f00\u53d1\u65b9\u6848\u7528\u6237");
        modelLogicNameMap.put("PSVALUERULE", "\u5e73\u53f0\u503c\u89c4\u5219");
        modelLogicNameMap.put("PSDEGCTYPE", "\u5b9e\u4f53\u8868\u683c\u5217\u7c7b\u578b");
        modelLogicNameMap.put("PSSYSOPPRIV", "\u7cfb\u7edf\u6743\u9650\u6807\u8bc6");
        modelLogicNameMap.put("PSPRODUCTTYPE", "\u5e73\u53f0\u4ea7\u54c1\u7c7b\u578b");
        modelLogicNameMap.put("PSSYSWFMODE", "\u7cfb\u7edf\u5de5\u4f5c\u6d41\u6a21\u5f0f");
        modelLogicNameMap.put("PSSYSSAMPLEVALUE", "\u7cfb\u7edf\u793a\u4f8b\u503c");
        modelLogicNameMap.put("PSDEDATAEXP", "\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa");
        modelLogicNameMap.put("PSVIEWENGINE", "\u89c6\u56fe\u5f15\u64ce");
        modelLogicNameMap.put("PSWXLOGIC", "\u5fae\u4fe1\u4ea4\u4e92\u903b\u8f91");
        modelLogicNameMap.put("PSSYSDBCHGLOG", "\u7cfb\u7edf\u6a21\u578b\u53d8\u66f4\u65e5\u5fd7");
        modelLogicNameMap.put("PSPFPKG", "\u5e94\u7528\u7ec4\u4ef6\u5305");
        modelLogicNameMap.put("PSPFPKGVER", "\u524d\u7aef\u5e94\u7528\u7ec4\u4ef6\u5305\u7248\u672c");
        modelLogicNameMap.put("PSSYSCOUNTERITEM", "\u7cfb\u7edf\u8ba1\u6570\u5668\u9879");
        modelLogicNameMap.put("PSDEUAGRPDETAIL", "\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u5458");
        modelLogicNameMap.put("PSAPPDEUAGRPDETAIL", "\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u5458");
        modelLogicNameMap.put("PSSYSAPPDEUAGRPDETAIL", "\u5168\u5c40\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u5458");
        modelLogicNameMap.put("PSHELPSECTIONTYPE", "\u5e2e\u52a9\u6587\u7ae0\u7ae0\u8282\u7c7b\u578b");
        modelLogicNameMap.put("PSDEACTIONLOGIC", "\u5b9e\u4f53\u884c\u4e3a\u903b\u8f91");
        modelLogicNameMap.put("PSPFSTYLE", "\u5e94\u7528\u6837\u5f0f");
        modelLogicNameMap.put("PSAPPEDITORTEMPL", "\u5e94\u7528\u7f16\u8f91\u5668\u6a21\u7248");
        modelLogicNameMap.put("PSMODELHOTCODE", "\u7cfb\u7edf\u6a21\u578b\u70ed\u4ee3\u7801");
        modelLogicNameMap.put("PSSYSBDTABLE", "\u5927\u6570\u636e\u5e93\u8868");
        modelLogicNameMap.put("PSHELPARTSEC", "\u5e2e\u52a9\u6587\u7ae0\u9884\u7f6e\u7ae0\u8282");
        modelLogicNameMap.put("PSVTCTRL", "\u5e73\u53f0\u89c6\u56fe\u7c7b\u578b\u90e8\u4ef6");
        modelLogicNameMap.put("PSDBVALUEMODE", "\u6570\u636e\u5e93\u503c\u6a21\u5f0f");
        modelLogicNameMap.put("PSAPPFUNC", "\u5e94\u7528\u529f\u80fd");
        modelLogicNameMap.put("PSVIEWSTYLE", "\u5e73\u53f0\u89c6\u56fe\u6837\u5f0f");
        modelLogicNameMap.put("PSDECHARTPARAM", "\u5b9e\u4f53\u56fe\u8868\u6570\u636e\u5e8f\u5217");
        modelLogicNameMap.put("PSDEREPITEM", "\u5b9e\u4f53\u62a5\u8868\u9879");
        modelLogicNameMap.put("PSTREENODETYPE", "\u5e73\u53f0\u6811\u8282\u70b9\u7c7b\u578b");
        modelLogicNameMap.put("PSCSSTEMPL", "\u5e73\u53f0\u754c\u9762\u6837\u5f0f\u8868\u6a21\u677f");
        modelLogicNameMap.put("PSDEFINPUTTIP", "\u5c5e\u6027\u8f93\u5165\u63d0\u793a");
        modelLogicNameMap.put("PSV3MIGRATEDE", "\u5e73\u53f0V3\u8fc1\u79fb\u5b9e\u4f53");
        modelLogicNameMap.put("PSPFSTYLEPRJ", "\u524d\u7aef\u5e94\u7528\u6837\u5f0f\u9879\u76ee");
        modelLogicNameMap.put("PSASBOOKINGLOG", "\u5e73\u53f0\u5e94\u7528\u5bb9\u5668\u9884\u7ea6\u65e5\u5fd7");
        modelLogicNameMap.put("PSSYSACHANDLER", "\u5e73\u53f0\u90e8\u4ef6\u5904\u7406\u5668");
        modelLogicNameMap.put("PSSYSMSGTEMPL", "\u7cfb\u7edf\u6d88\u606f\u6a21\u677f");
        modelLogicNameMap.put("PSCODEITEM", "\u7cfb\u7edf\u4ee3\u7801\u8868\u9879");
        modelLogicNameMap.put("PSFDLOGICTYPE", "\u5e73\u53f0\u8868\u5355\u6210\u5458\u903b\u8f91\u7c7b\u578b");
        modelLogicNameMap.put("PSWXENTAPP", "\u5fae\u4fe1\u4f01\u4e1a\u5e94\u7528");
        modelLogicNameMap.put("PSSUBDE", "\u5e73\u53f0\u5b50\u7cfb\u7edf\u5b9e\u4f53");
        modelLogicNameMap.put("PSDEUIACTIONTYPE", "\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7c7b\u578b");
        modelLogicNameMap.put("PSVIEWTYPECAT", "\u5e73\u53f0\u89c6\u56fe\u7c7b\u578b\u5206\u7c7b");
        modelLogicNameMap.put("PSSFCONFIG", "\u7cfb\u7edf\u670d\u52a1\u6846\u67b6\u914d\u7f6e");
        modelLogicNameMap.put("PSV3MGGRID", "\u5e73\u53f0V3\u8fc1\u79fb\u8868\u683c");
        modelLogicNameMap.put("PSCOREPRDFUNC", "\u5e73\u53f0\u6838\u5fc3\u4ea7\u54c1\u529f\u80fd");
        modelLogicNameMap.put("PSSYSUNIT", "\u7cfb\u7edf\u5355\u4f4d");
        modelLogicNameMap.put("PSPDTAPPFUNC", "\u5e73\u53f0\u9884\u7f6e\u5e94\u7528\u529f\u80fd");
        modelLogicNameMap.put("PSDEVIEWRV", "\u5b9e\u4f53\u89c6\u56fe\u5173\u8054\u89c6\u56fe");
        modelLogicNameMap.put("PSSYSDICTCAT", "\u7cfb\u7edf\u8f93\u5165\u8bcd\u6761\u7c7b\u522b");
        modelLogicNameMap.put("PSTASKSERVER", "\u5e73\u53f0\u4efb\u52a1\u670d\u52a1\u5668");
        modelLogicNameMap.put("PSVIEWTYPELOGIC", "\u89c6\u56fe\u7c7b\u578b\u5185\u7f6e\u903b\u8f91");
        modelLogicNameMap.put("PSAPPUITHEME", "\u5e94\u7528\u754c\u9762\u4e3b\u9898");
        modelLogicNameMap.put("PSAPPLAN", "\u5e94\u7528\u591a\u8bed\u8a00");
        modelLogicNameMap.put("PSDEFSFITEM", "\u5b9e\u4f53\u5c5e\u6027\u641c\u7d22\u9879");
        modelLogicNameMap.put("PSHELPMODART", "\u5e2e\u52a9\u6a21\u5757\u6587\u7ae0");
        modelLogicNameMap.put("PSDCBKTASK", "\u4e2d\u5fc3\u540e\u53f0\u4efb\u52a1");
        modelLogicNameMap.put("PSDCDBPROC", "\u4e2d\u5fc3\u6570\u636e\u5e93\u8fc7\u7a0b");
        modelLogicNameMap.put("PSV3MGVIEW", "\u5e73\u53f0V3\u9ed8\u8ba4\u89c6\u56fe");
        modelLogicNameMap.put("PSSVNINSTREPO", "\u5e73\u53f0SVN\u4ed3\u5e93");
        modelLogicNameMap.put("PSAPPPKG", "\u7cfb\u7edf\u5e94\u7528\u7ec4\u4ef6\u5305");
        modelLogicNameMap.put("PSASTYPE", "\u5e94\u7528\u670d\u52a1\u5668\u7c7b\u578b");
        modelLogicNameMap.put("PSDEDSDQ", "\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u67e5\u8be2");
        modelLogicNameMap.put("PSDBSPPARTTEMPL", "\u6570\u636e\u5e93\u7cfb\u7edf\u8fc7\u7a0b\u6210\u5458\u6a21\u7248");
        modelLogicNameMap.put("PSSYSDEVBKTASK", "\u7cfb\u7edf\u5f00\u53d1\u540e\u53f0\u4efb\u52a1");
        modelLogicNameMap.put("PSDETBITEM", "\u5b9e\u4f53\u5de5\u5177\u680f\u9879");
        modelLogicNameMap.put("PSDEPSLNMODEPRD", "\u90e8\u7f72\u65b9\u6848\u4ea7\u54c1\u90e8\u7f72");
        modelLogicNameMap.put("PSDEVSLNSYS", "\u5f00\u53d1\u7cfb\u7edf");
        modelLogicNameMap.put("PSSYSVALUERULE", "\u7cfb\u7edf\u503c\u89c4\u5219");
        modelLogicNameMap.put("PSSYSPFPITEMPL", "\u524d\u7aef\u63d2\u4ef6\u6a21\u677f");
        modelLogicNameMap.put("PSDEVRGRPDETAIL", "\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u7ec4\u6210\u5458");
        modelLogicNameMap.put("PSAPPCTRLSTYLE", "\u5e94\u7528\u90e8\u4ef6\u6837\u5f0f");
        modelLogicNameMap.put("PSROSSERVER", "ROS\u670d\u52a1\u5668");
        modelLogicNameMap.put("PSDEDRITEM", "\u5b9e\u4f53\u5173\u7cfb\u754c\u9762");
        modelLogicNameMap.put("PSDEACTIONTYPE", "\u5b9e\u4f53\u884c\u4e3a\u7c7b\u578b");
        modelLogicNameMap.put("PSCOREPRDVER", "\u5e73\u53f0\u6838\u5fc3\u4ea7\u54c1\u7248\u672c");
        modelLogicNameMap.put("PSPFVIEWTEMPL", "\u5e94\u7528\u89c6\u56fe\u4ee3\u7801\u6a21\u7248");
        modelLogicNameMap.put("PSSYSTASK", "TODO\u4efb\u52a1");
        modelLogicNameMap.put("PSVTSAMPLE", "\u89c6\u56fe\u7c7b\u578b\u793a\u4f8b");
        modelLogicNameMap.put("PSDBVFCODE", "\u6570\u636e\u5e93\u503c\u51fd\u6570\u4ee3\u7801");
        modelLogicNameMap.put("PSDELNPARAM", "\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8282\u70b9\u53c2\u6570");
        modelLogicNameMap.put("PSSVRSERVER", "\u5e73\u53f0\u7cfb\u7edf\u4e3b\u673a");
        modelLogicNameMap.put("PSDECHARTAXES", "\u5b9e\u4f53\u56fe\u50cf\u7ef4\u5ea6");
        modelLogicNameMap.put("PSUNKNOWN", "\u672a\u77e5\u6a21\u578b\u63a5\u53e3");
        modelLogicNameMap.put("PSTASKSERVERLOG", "\u4efb\u52a1\u670d\u52a1\u5668\u65e5\u5fd7");
        modelLogicNameMap.put("PSSUBSYSSADETAIL", "\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u6210\u5458");
        modelLogicNameMap.put("PSSVRDOMAIN", "\u5e73\u53f0\u670d\u52a1\u57df");
        modelLogicNameMap.put("PSHELPRESOURCE", "\u5e2e\u52a9\u8d44\u6e90");
        modelLogicNameMap.put("PSAPPUSERMODE", "\u5e94\u7528\u7528\u6237\u6a21\u5f0f");
        modelLogicNameMap.put("PSDERDEFMAP", "\u5b9e\u4f53\u5173\u7cfb\u5c5e\u6027\u6620\u5c04");
        modelLogicNameMap.put("PSCTRLMSGITEM", "\u90e8\u4ef6\u6d88\u606f\u9879");
        modelLogicNameMap.put("PSDEVCENTERDBINST", "\u4e2d\u5fc3\u6570\u636e\u5e93\u5b9e\u4f8b");
        modelLogicNameMap.put("PSHELPARTICLETEMPL", "\u5e2e\u52a9\u6587\u7ae0\u6a21\u677f");
        modelLogicNameMap.put("PSCODELISTTEMPL", "\u5e73\u53f0\u4ee3\u7801\u8868\u6a21\u7248");
        modelLogicNameMap.put("PSSFSTYLECODE", "\u7cfb\u7edf\u670d\u52a1\u6846\u67b6\u5b8f");
        modelLogicNameMap.put("PSPDTVIEW", "\u5e73\u53f0\u9884\u7f6e\u89c6\u56fe");
        modelLogicNameMap.put("PSDEFVRDSPARAM", "\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u53c2\u6570");
        modelLogicNameMap.put("PSDEVCENTERMQ", "\u4e2d\u5fc3MQ\u670d\u52a1");
        modelLogicNameMap.put("PSDESPCODEPART", "\u7cfb\u7edf\u5b58\u50a8\u8fc7\u7a0b\u4ee3\u7801\u5757");
        modelLogicNameMap.put("PSDEVCENTERTS", "\u4e2d\u5fc3\u4efb\u52a1\u670d\u52a1\u5668");
        modelLogicNameMap.put("PSSYSUSERDR", "\u7cfb\u7edf\u81ea\u5b9a\u4e49\u6570\u636e\u8303\u56f4");
        modelLogicNameMap.put("PSSYSOUTYPE", "\u7cfb\u7edf\u7ec4\u7ec7\u5355\u5143\u7c7b\u578b");
        modelLogicNameMap.put("PSV3MIGRATE", "\u5e73\u53f0V3\u8fc1\u79fb");
        modelLogicNameMap.put("PSSFSTYLE", "\u670d\u52a1\u6846\u67b6");
        modelLogicNameMap.put("PSSYSDEVINFOTYPE", "\u7cfb\u7edf\u5f00\u53d1\u4fe1\u606f\u7c7b\u578b");
        modelLogicNameMap.put("PSSYSTCINPUT", "\u6d4b\u8bd5\u7528\u4f8b\u8f93\u5165");
        modelLogicNameMap.put("PSSYSTCINPUT2", "\u6d4b\u8bd5\u7528\u4f8b\u8f93\u5165");
        modelLogicNameMap.put("PSDATASYNCAGENTTYPE", "\u6570\u636e\u540c\u6b65\u4ee3\u7406\u7c7b\u578b");
        modelLogicNameMap.put("PSSYSLANITEM", "\u5e73\u53f0\u8bed\u8a00\u9879");
        modelLogicNameMap.put("PSDEDSCODE", "\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u4ee3\u7801");
        modelLogicNameMap.put("PSDCPRODUCT", "\u4e2d\u5fc3\u4ea7\u54c1");
        modelLogicNameMap.put("PSDEDQPDCOND", "\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u9884\u7f6e\u6761\u4ef6");
        modelLogicNameMap.put("PSSYSISSUEENGINE", "\u7cfb\u7edf\u95ee\u9898\u5206\u6790\u5f15\u64ce");
        modelLogicNameMap.put("PSDCSFPKG", "\u4e2d\u5fc3\u670d\u52a1\u6846\u67b6\u7ec4\u4ef6\u5305");
        modelLogicNameMap.put("PSDEVUSER", "\u4e2d\u5fc3\u7528\u6237");
        modelLogicNameMap.put("PSMIDETAIL", "\u6a21\u578b\u521d\u59cb\u5316\u6b65\u9aa4");
        modelLogicNameMap.put("PSDEPSLNPRD", "\u90e8\u7f72\u65b9\u6848\u4ea7\u54c1");
        modelLogicNameMap.put("PSAPPFUNCTYPE", "\u5e94\u7528\u529f\u80fd\u7c7b\u578b");
        modelLogicNameMap.put("PSPFPLUGINTYPE", "\u5e94\u7528\u6846\u67b6\u63d2\u4ef6\u7c7b\u578b");
        modelLogicNameMap.put("PSEDITORTYPE", "\u5e73\u53f0\u7f16\u8f91\u5668\u7c7b\u578b");
        modelLogicNameMap.put("PSSVRPROVIDER", "\u670d\u52a1\u63d0\u4f9b\u5546");
        modelLogicNameMap.put("PSDCBKTYPE", "\u4e2d\u5fc3\u540e\u53f0\u4efb\u52a1\u7c7b\u578b");
        modelLogicNameMap.put("PSMODELRS", "\u7cfb\u7edf\u6a21\u578b\u5173\u7cfb");
        modelLogicNameMap.put("PSWFSUBWF", "\u6d41\u7a0b\u5b50\u6d41\u7a0b");
        modelLogicNameMap.put("PSDEFDATATYPE", "\u5b9e\u4f53\u5c5e\u6027\u6570\u636e\u7c7b\u578b");
        modelLogicNameMap.put("PSDEFVRCODETYPE", "\u5e73\u53f0\u5c5e\u6027\u89c4\u5219\u4ee3\u7801\u7c7b\u578b");
        modelLogicNameMap.put("PSSFSTYLELOG", "\u670d\u52a1\u6846\u67b6\u53d8\u66f4");
        modelLogicNameMap.put("PSDESPFIELD", "\u7cfb\u7edf\u5b58\u50a8\u8fc7\u7a0b\u5c5e\u6027");
        modelLogicNameMap.put("PSPFSTYLEPKG", "\u524d\u7aef\u5e94\u7528\u6837\u5f0f\u7ec4\u4ef6\u5305");
        modelLogicNameMap.put("PSMODELREF", "\u6a21\u578b\u5f15\u7528");
        modelLogicNameMap.put("PSHELPSECTIONTEMPL", "\u5e2e\u52a9\u7ae0\u8282\u6a21\u677f");
        modelLogicNameMap.put("PSDEFFORMITEM", "\u5c5e\u6027\u8868\u5355\u9879\u6a21\u5f0f");
        modelLogicNameMap.put("PSSYSREQMODULE", "\u7cfb\u7edf\u9700\u6c42\u6a21\u5757");
        modelLogicNameMap.put("PSDRITEMTYPE", "\u5e73\u53f0\u6570\u636e\u5173\u7cfb\u9879\u7c7b\u578b");
        modelLogicNameMap.put("PSSYSDEVBTTYPE", "\u7cfb\u7edf\u5f00\u53d1\u540e\u53f0\u4efb\u52a1\u7c7b\u578b");
        modelLogicNameMap.put("PSSUBSYSSERVICEAPI", "\u5916\u90e8\u670d\u52a1\u63a5\u53e3");
        modelLogicNameMap.put("PSDCSYSPRODUCT", "\u4e2d\u5fc3\u7cfb\u7edf\u4ea7\u54c1");
        modelLogicNameMap.put("PSDECTRL", "\u5b9e\u4f53\u90e8\u4ef6\u914d\u7f6e");
        modelLogicNameMap.put("PSDEPSLNRUNLOG", "\u90e8\u7f72\u65b9\u6848\u8fd0\u884c\u65e5\u5fd7");
        modelLogicNameMap.put("PSSYSBDPART", "\u5927\u6570\u636e\u5206\u533a");
        modelLogicNameMap.put("PSSYSTOOLBAR", "\u5e73\u53f0\u9884\u7f6e\u5de5\u5177\u680f");
        modelLogicNameMap.put("PSDEDRGROUP", "\u5b9e\u4f53\u5173\u7cfb\u754c\u9762\u5206\u7ec4");
        modelLogicNameMap.put("PSDEDQCOND", "\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u6761\u4ef6");
        modelLogicNameMap.put("PSCPVFUNC", "\u5e73\u53f0\u6838\u5fc3\u4ea7\u54c1\u7248\u672c\u529f\u80fd");
        modelLogicNameMap.put("PSDEFGRIDCOL", "\u5b9e\u4f53\u5c5e\u6027\u8868\u683c\u5217");
        modelLogicNameMap.put("PSDCDBFUNC", "\u4e2d\u5fc3\u6570\u636e\u5e93\u51fd\u6570");
        modelLogicNameMap.put("PSDEFIUDETAIL", "\u5b9e\u4f53\u8868\u5355\u9879\u66f4\u65b0\u660e\u7ec6");
        modelLogicNameMap.put("PSWXMENUITEM", "\u5fae\u4fe1\u83dc\u5355\u9879");
        modelLogicNameMap.put("PSDEVRGROUP", "\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u7ec4");
        modelLogicNameMap.put("PSDEVSLNSYSKEY", "\u5f00\u53d1\u7cfb\u7edf\u8bbf\u95ee\u6807\u8bc6");
        modelLogicNameMap.put("PSDEVCENTERRES", "\u4e2d\u5fc3\u8d44\u6e90");
        modelLogicNameMap.put("PSCTRLTYPEACTION", "\u5e73\u53f0\u90e8\u4ef6\u64cd\u4f5c");
        modelLogicNameMap.put("PSSUBSYSDM", "\u5b50\u7cfb\u7edf\u6570\u636e\u5e93\u7ed3\u6784");
        modelLogicNameMap.put("PSDEVUSERRECENT", "\u5e94\u7528\u7528\u6237\u6700\u8fd1\u8bbf\u95ee");
        modelLogicNameMap.put("PSSYSTEMDBCFG", "\u7cfb\u7edf\u6570\u636e\u5e93");
        modelLogicNameMap.put("PSSYSPRDVER", "\u7cfb\u7edf\u5546\u54c1\u7248\u672c");
        modelLogicNameMap.put("PSWXMENU", "\u5fae\u4fe1\u83dc\u5355");
        modelLogicNameMap.put("PSSAMPLEVALUE", "\u5e73\u53f0\u793a\u4f8b\u503c");
        modelLogicNameMap.put("PSBDSERVER", "\u5e73\u53f0\u5927\u6570\u636e\u670d\u52a1\u5668");
        modelLogicNameMap.put("PSWXACCOUNT", "\u5fae\u4fe1\u516c\u4f17\u53f7");
        modelLogicNameMap.put("PSSYSDMITEM", "\u7cfb\u7edf\u6570\u636e\u5e93\u6a21\u578b\u9879");
        modelLogicNameMap.put("PSSYSTASKDATA", "\u7cfb\u7edf\u5f00\u53d1\u4efb\u52a1\u8ba8\u8bba");
        modelLogicNameMap.put("PSWFPROCPARAM", "\u6d41\u7a0b\u5904\u7406\u53c2\u6570");
        modelLogicNameMap.put("PSWFPROCROLE", "\u6d41\u7a0b\u5904\u7406\u89d2\u8272");
        modelLogicNameMap.put("PSDEVENV", "\u5f00\u53d1\u73af\u5883");
        modelLogicNameMap.put("PSDELISTITEM", "\u5b9e\u4f53\u5217\u8868\u9879");
        modelLogicNameMap.put("PSSYSSFCODE", "\u7cfb\u7edf\u670d\u52a1\u81ea\u5b9a\u4e49\u4ee3\u7801");
        modelLogicNameMap.put("PSDESYSPROC", "\u5b9e\u4f53\u7cfb\u7edf\u5b58\u50a8\u8fc7\u7a0b");
        modelLogicNameMap.put("PSSYSMODELVER", "\u7cfb\u7edf\u6a21\u578b\u7248\u672c");
        modelLogicNameMap.put("PSSFPKGCAT", "\u670d\u52a1\u6846\u67b6\u5305\u5206\u7c7b");
        modelLogicNameMap.put("PSHELPPRJ", "\u7cfb\u7edf\u5e2e\u52a9\u9879\u76ee");
        modelLogicNameMap.put("PSSYSIMAGE", "\u7cfb\u7edf\u56fe\u7247\u8d44\u6e90");
        modelLogicNameMap.put("PSSUBAPP", "\u5e73\u53f0\u5b50\u7cfb\u7edf\u5e94\u7528");
        modelLogicNameMap.put("PSBACKSERVICE", "\u5e73\u53f0\u9884\u7f6e\u540e\u53f0\u4efb\u52a1");
        modelLogicNameMap.put("PSAPPVIEWSTYLE", "\u5e94\u7528\u89c6\u56fe\u6837\u5f0f\uff08\u5df2\u5e9f\u5f03\uff09");
        modelLogicNameMap.put("PSDEDBINDEX", "\u5b9e\u4f53\u6570\u636e\u5e93\u7d22\u5f15");
        modelLogicNameMap.put("PSCTRLTYPE", "\u5e73\u53f0\u90e8\u4ef6\u7c7b\u578b");
        modelLogicNameMap.put("PSAPPPORTALVIEW", "\u5e94\u7528\u95e8\u6237\u89c6\u56fe");
        modelLogicNameMap.put("PSSYSDEVINFO", "\u7cfb\u7edf\u5f00\u53d1\u4fe1\u606f");
        modelLogicNameMap.put("PSDCSYSPRDVER", "\u4e2d\u5fc3\u7cfb\u7edf\u4ea7\u54c1\u7248\u672c");
        modelLogicNameMap.put("PSSYSREQITEMDATA", "\u9700\u6c42\u9879\u8ba8\u8bba");
        modelLogicNameMap.put("PSAPPVIEWCODE", "\u7cfb\u7edf\u5e94\u7528\u81ea\u5b9a\u4e49\u4ee3\u7801");
        modelLogicNameMap.put("PSUNIT", "\u5e73\u53f0\u9884\u7f6e\u5355\u4f4d");
        modelLogicNameMap.put("PSSYSREFDE", "\u7cfb\u7edf\u5f15\u7528\u5b9e\u4f53");
        modelLogicNameMap.put("PSSYSBDTABLERS", "\u5927\u6570\u636e\u8868\u5173\u7cfb");
        modelLogicNameMap.put("PSDER_DER11", "\u5b9e\u4f53\u5173\u7cfb\uff081:1\uff09");
        modelLogicNameMap.put("PSSUBSYSVER", "\u5e73\u53f0\u5b50\u7cfb\u7edf\u7248\u672c");
        modelLogicNameMap.put("PSDEGEIUPDATE", "\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0\u6a21\u5f0f");
        modelLogicNameMap.put("PSMODELAPIRS", "\u7cfb\u7edf\u6a21\u578bAPI\u5173\u7cfb");
        modelLogicNameMap.put("PSSYSCSSCAT", "\u7cfb\u7edf\u6837\u5f0f\u8868\u5206\u7c7b");
        modelLogicNameMap.put("PSHELPSECTION", "\u5e2e\u52a9\u7ae0\u8282");
        modelLogicNameMap.put("PSDETREENODERV", "\u6811\u8282\u70b9\u5173\u8054\u89c6\u56fe");
        modelLogicNameMap.put("PSWFDE", "\u5de5\u4f5c\u6d41\u5b9e\u4f53");
        modelLogicNameMap.put("PSDEDUPRULE", "\u5b9e\u4f53\u6570\u636e\u91cd\u590d\u89c4\u5219");
        modelLogicNameMap.put("PSSYSMODELFUNCTEMPL", "\u7cfb\u7edf\u6a21\u578b\u529f\u80fd\u6a21\u677f\u5b9e\u73b0");
        modelLogicNameMap.put("PSPFPLUGINTEMPL", "\u5e73\u53f0\u9884\u7f6e\u5e94\u7528\u6846\u67b6\u63d2\u4ef6\u6a21\u677f");
        modelLogicNameMap.put("PSAPPUTILPAGE", "\u5e94\u7528\u529f\u80fd\u9875\u9762");
        modelLogicNameMap.put("PSSFSTYLEVER", "\u670d\u52a1\u6846\u67b6\u6269\u5c55");
        modelLogicNameMap.put("PSSUBDEACTION", "\u5e73\u53f0\u5b50\u5b9e\u4f53\u64cd\u4f5c");
        modelLogicNameMap.put("PSVTSTYLE", "\u5e73\u53f0\u89c6\u56fe\u7c7b\u578b\u6837\u5f0f");
        modelLogicNameMap.put("PSSYSEDITORSTYLE", "\u7cfb\u7edf\u7f16\u8f91\u5668\u6837\u5f0f");
        modelLogicNameMap.put("PSVIEWLOGICTYPE", "\u89c6\u56fe\u9884\u7f6e\u903b\u8f91");
        modelLogicNameMap.put("PSSFVERCODE", "\u7cfb\u7edf\u670d\u52a1\u6269\u5c55\u4ee3\u7801\u6a21\u677f");
        modelLogicNameMap.put("PSPFCTDETAIL", "\u5e94\u7528\u90e8\u4ef6\u4ee3\u7801\u6a21\u7248\u6210\u5458");
        modelLogicNameMap.put("PSSYSDEPLOYDB", "\u7cfb\u7edf\u90e8\u7f72\u6570\u636e\u5e93");
        modelLogicNameMap.put("PSDEVSERVER", "\u5e73\u53f0\u5f00\u53d1\u4e3b\u673a");
        modelLogicNameMap.put("PSSYSDBVFCODE", "\u7cfb\u7edf\u6570\u636e\u5e93\u503c\u51fd\u6570\u4ee3\u7801");
        modelLogicNameMap.put("PSDCCOREPRDISSUE", "\u4e2d\u5fc3\u6838\u5fc3\u4ea7\u54c1\u95ee\u9898");
        modelLogicNameMap.put("PSWFPROCESS", "\u6d41\u7a0b\u5904\u7406");
        modelLogicNameMap.put("PSSFVERCODEITEM", "\u7cfb\u7edf\u670d\u52a1\u6846\u67b6\u7248\u672c\u4ee3\u7801\u9879");
        modelLogicNameMap.put("PSDER_DERMULINH", "\u5b9e\u4f53\u5173\u7cfb\uff08\u591a\u7ee7\u627f\uff09");
        modelLogicNameMap.put("PSSYSSERVICEAPI", "\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3");
        modelLogicNameMap.put("PSSYSISSUE", "\u7cfb\u7edf\u95ee\u9898");
        modelLogicNameMap.put("PSDEVUSEROBJ", "\u4e2d\u5fc3\u7528\u6237\u5bf9\u8c61");
        modelLogicNameMap.put("PSSYSREQITEM", "\u7cfb\u7edf\u9700\u6c42\u9879");
        modelLogicNameMap.put("PSDEVCENTERSF", "\u4e2d\u5fc3\u670d\u52a1\u6846\u67b6");
        modelLogicNameMap.put("PSSYSPFPLUGIN", "\u7cfb\u7edf\u524d\u7aef\u63d2\u4ef6");
        modelLogicNameMap.put("PSCTRLMSG", "\u90e8\u4ef6\u6d88\u606f");
        modelLogicNameMap.put("PSDBVALUEOP", "\u6570\u636e\u5e93\u503c\u64cd\u4f5c\u7b26");
        modelLogicNameMap.put("PSDEPSLNASGRP", "\u90e8\u7f72\u65b9\u6848\u5e94\u7528\u670d\u52a1\u5668\u7ec4");
        modelLogicNameMap.put("PSAPPSERVER", "\u5e73\u53f0\u5e94\u7528\u670d\u52a1\u5668");
        modelLogicNameMap.put("PSSFSTYLEPRJ", "\u670d\u52a1\u6846\u67b6\u9879\u76ee");
        modelLogicNameMap.put("PSDEDQJOIN", "\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u8fde\u63a5");
        modelLogicNameMap.put("PSDEPSLNAS", "\u90e8\u7f72\u65b9\u6848\u5e94\u7528\u670d\u52a1\u5668");
        modelLogicNameMap.put("PSMODELINIT", "\u6a21\u578b\u521d\u59cb\u5316\u914d\u7f6e");
        modelLogicNameMap.put("PSDEFORM", "\u5b9e\u4f53\u8868\u5355");
        modelLogicNameMap.put("PSSYSISSUETYPE", "\u7cfb\u7edf\u95ee\u9898\u7c7b\u578b");
        modelLogicNameMap.put("PSCOUNTER", "\u5e73\u53f0\u9884\u7f6e\u8ba1\u6570\u5668");
        modelLogicNameMap.put("PSIMAGETEMPL", "\u5e73\u53f0\u56fe\u7247\u6a21\u7248");
        modelLogicNameMap.put("PSDEDBOBJSQL", "\u5b9e\u4f53\u6570\u636e\u5e93\u5bf9\u8c61\u4ee3\u7801");
        modelLogicNameMap.put("PSDECHART", "\u5b9e\u4f53\u56fe\u8868");
        modelLogicNameMap.put("PSSYSUSERMODE", "\u7cfb\u7edf\u7528\u6237\u6a21\u5f0f");
        modelLogicNameMap.put("PSSUBSYSSF", "\u5e73\u53f0\u5b50\u7cfb\u7edf\u670d\u52a1\u4f53\u7cfb");
        modelLogicNameMap.put("PSMODELAPI", "\u5e73\u53f0API");
        modelLogicNameMap.put("PSSFPKGVER", "\u670d\u52a1\u6846\u67b6\u7ec4\u4ef6\u7248\u672c");
        modelLogicNameMap.put("PSCOREPRDCAT", "\u5e73\u53f0\u6838\u5fc3\u4ea7\u54c1\u5206\u7c7b");
        modelLogicNameMap.put("PSDER_DER1N", "\u5b9e\u4f53\u5173\u7cfb\uff081:N\uff09");
        modelLogicNameMap.put("PSDESADETAIL", "\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u6210\u5458");
        modelLogicNameMap.put("PSSYSPRODUCT", "\u5e73\u53f0\u7cfb\u7edf\u4ea7\u54c1");
        modelLogicNameMap.put("PSSYSACTOR", "\u7cfb\u7edf\u89d2\u8272");
        modelLogicNameMap.put("PSACHANDLER", "\u90e8\u4ef6\u540e\u53f0\u5904\u7406");
        modelLogicNameMap.put("PSDEVCENTERLOG", "\u4e2d\u5fc3\u65e5\u5fd7");
        modelLogicNameMap.put("PSSYSRUNLOG", "\u7cfb\u7edf\u8fd0\u884c\u65e5\u5fd7");
        modelLogicNameMap.put("PSDEVUSERMODEL", "\u7528\u6237\u8bbf\u95ee\u6a21\u578b");
        modelLogicNameMap.put("PSAPPMENU", "\u5e94\u7528\u83dc\u5355");
        modelLogicNameMap.put("PSDEGRID", "\u5b9e\u4f53\u8868\u683c");
        modelLogicNameMap.put("PSVIEWTYPE", "\u5e73\u53f0\u89c6\u56fe\u7c7b\u578b");
        modelLogicNameMap.put("PSDBDEVINST", "\u5e73\u53f0\u6570\u636e\u5e93\u5f00\u53d1\u5b9e\u4f8b");
        modelLogicNameMap.put("PSHELPARTICLETYPE", "\u5e2e\u52a9\u6587\u7ae0\u7c7b\u578b");
        modelLogicNameMap.put("PSDEVCENTERSERVER", "\u4e2d\u5fc3\u4e3b\u673a");
        modelLogicNameMap.put("PSTSCMD", "\u4efb\u52a1\u670d\u52a1\u5668\u540e\u53f0\u547d\u4ee4");
        modelLogicNameMap.put("PSDEPSLNASITEM", "\u90e8\u7f72\u65b9\u6848\u5e94\u7528\u670d\u52a1\u5668\u7ec4\u6210\u5458");
        modelLogicNameMap.put("PSDEUAGROUP", "\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4");
        modelLogicNameMap.put("PSAPPDEUAGROUP", "\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4");
        modelLogicNameMap.put("PSSYSAPPDEUAGROUP", "\u5168\u5c40\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4");
        modelLogicNameMap.put("PSDCDBTABLE", "\u4e2d\u5fc3\u6570\u636e\u5e93\u8868");
        modelLogicNameMap.put("PSSFEXCEPTION", "\u7cfb\u7edf\u670d\u52a1\u4f53\u7cfb\u5f02\u5e38\u5bf9\u8c61");
        modelLogicNameMap.put("PSDELOGICNODE", "\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8282\u70b9");
        modelLogicNameMap.put("PSPFEDITORTEMPL", "\u524d\u53f0\u7f16\u8f91\u5668\u6a21\u7248");
        modelLogicNameMap.put("PSSYSUSERCASERS", "\u7cfb\u7edf\u7528\u4f8b\u5173\u7cfb");
        modelLogicNameMap.put("PSDEVSYSDIFFREP", "\u5f00\u53d1\u7cfb\u7edf\u5dee\u5f02\u5206\u6790");
        modelLogicNameMap.put("PSSVNSERVER", "SVN\u670d\u52a1\u5668");
        modelLogicNameMap.put("PSDELLCOND", "\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8fde\u63a5\u6761\u4ef6");
        modelLogicNameMap.put("PSCOUNTERTYPESF", "\u5e73\u53f0\u8ba1\u6570\u5668\u7c7b\u578b\u670d\u52a1\u6846\u67b6");
        modelLogicNameMap.put("PSDBSERVER", "\u5e73\u53f0\u6570\u636e\u5e93\u4e3b\u673a");
        modelLogicNameMap.put("PSSYSTESTDATA", "\u7cfb\u7edf\u6d4b\u8bd5\u6570\u636e");
        modelLogicNameMap.put("PSCSSCATTEMPL", "\u5e73\u53f0\u6837\u5f0f\u8868\u5206\u7c7b\u6a21\u677f");
        modelLogicNameMap.put("PSSYSUNIRES", "\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90");
        modelLogicNameMap.put("PSDEPSLNLOG", "\u90e8\u7f72\u65b9\u6848\u64cd\u4f5c\u65e5\u5fd7");
        modelLogicNameMap.put("PSDCDBSEQU", "\u4e2d\u5fc3\u6570\u636e\u5e93\u5e8f\u5217");
        modelLogicNameMap.put("PSSYSDEPLOY", "\u7cfb\u7edf\u90e8\u7f72");
        modelLogicNameMap.put("PSSYSDSACTIONTYPE", "\u7cfb\u7edf\u5f00\u53d1\u73af\u5883\u64cd\u4f5c\u7c7b\u578b");
        modelLogicNameMap.put("PSDEDQCODE", "\u6570\u636e\u6570\u636e\u67e5\u8be2\u4ee3\u7801");
        modelLogicNameMap.put("PSCOUNTERTYPE", "\u5e73\u53f0\u8ba1\u6570\u5668\u7c7b\u578b");
        modelLogicNameMap.put("PSCTRLEVENT", "\u63a7\u4ef6\u4e8b\u4ef6");
        modelLogicNameMap.put("PSDCBULLETIN", "\u4e2d\u5fc3\u516c\u544a");
        modelLogicNameMap.put("PSSFSTYLEPKG", "\u670d\u52a1\u6846\u67b6\u6837\u5f0f\u7ec4\u4ef6");
        modelLogicNameMap.put("PSVIEWWIZARDGROUP", "\u89c6\u56fe\u5411\u5bfc\u7ec4");
        modelLogicNameMap.put("PSCTRLTYPEEVENT", "\u5e73\u53f0\u90e8\u4ef6\u4e8b\u4ef6");
        modelLogicNameMap.put("PSDEVSERVERLEASE", "\u5f00\u53d1\u4e3b\u673a\u79df\u7ea6");
        modelLogicNameMap.put("PSDCMTDEF", "\u6a21\u578b\u6a21\u677f\u9884\u7f6e\u5c5e\u6027");
        modelLogicNameMap.put("PSDEUIACTION", "\u5b9e\u4f53\u754c\u9762\u884c\u4e3a");
        modelLogicNameMap.put("PSLANGUAGERES", "\u8bed\u8a00\u8d44\u6e90");
        modelLogicNameMap.put("PSDEMSACTION", "\u4e3b\u72b6\u6001\u64cd\u4f5c\u884c\u4e3a");
        modelLogicNameMap.put("PSSYSBDTABLEDE", "\u5927\u6570\u636e\u8868\u5b9e\u4f53\u5173\u7cfb");
        modelLogicNameMap.put("PSVIEWMSG", "\u89c6\u56fe\u6d88\u606f");
        modelLogicNameMap.put("PSDCTASKLOG", "\u4e2d\u5fc3\u540e\u53f0\u4f5c\u4e1a\u65e5\u5fd7");
        modelLogicNameMap.put("PSPFVLTEMPL", "\u89c6\u56fe\u903b\u8f91\u6a21\u7248");
        modelLogicNameMap.put("PSROBOT", "\u5e73\u53f0\u673a\u5668\u4eba");
        modelLogicNameMap.put("PSDESERVICEAPI", "\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3");
        modelLogicNameMap.put("PSSYSERMAP", "\u7cfb\u7edfER\u56fe");
        modelLogicNameMap.put("PSDEDQCODECOND", "\u5b9e\u4f53\u67e5\u8be2\u4ee3\u7801\u6761\u4ef6");
        modelLogicNameMap.put("PSHELPARTICLE", "\u5e2e\u52a9\u6587\u7ae0");
        modelLogicNameMap.put("PSPORTLET", "\u5e73\u53f0\u9884\u7f6e\u95e8\u6237\u90e8\u4ef6");
        modelLogicNameMap.put("PSSYSTEMRUN", "\u7cfb\u7edf\u8fd0\u884c");
        modelLogicNameMap.put("PSSYSPOLICY", "\u5e73\u53f0\u7cfb\u7edf\u7b56\u7565");
        modelLogicNameMap.put("PSWFLINK", "\u6d41\u7a0b\u5904\u7406\u8fde\u63a5");
        modelLogicNameMap.put("PSV3MGFORM", "\u5e73\u53f0V3\u8fc1\u79fb\u8868\u5355");
        modelLogicNameMap.put("PSSYSLANRES", "\u5e73\u53f0\u8bed\u8a00\u8d44\u6e90");
        modelLogicNameMap.put("PSAPPVIEWREF", "\u89c6\u56fe\u5f15\u7528");
        modelLogicNameMap.put("PSDEVSLN", "\u5f00\u53d1\u65b9\u6848");
        modelLogicNameMap.put("PSDCBDINST", "\u4e2d\u5fc3\u5927\u6570\u636e\u5e93\u5b9e\u4f8b");
        modelLogicNameMap.put("PSVTRV", "\u5e73\u53f0\u89c6\u56fe\u7c7b\u578b\u5173\u8054\u89c6\u56fe");
        modelLogicNameMap.put("PSDCSYSRES", "\u4e2d\u5fc3\u7cfb\u7edf\u8d44\u6e90");
        modelLogicNameMap.put("PSDEWIZARD", "\u5b9e\u4f53\u5411\u5bfc");
        modelLogicNameMap.put("PSSYSMODELFUNC", "\u7cfb\u7edf\u6a21\u578b\u529f\u80fd");
        modelLogicNameMap.put("PSSYSREQITEMHIS", "\u9700\u6c42\u9879\u5907\u4efd");
        modelLogicNameMap.put("PSMOBAPPPACK", "\u79fb\u52a8\u5e94\u7528\u6253\u5305");
        modelLogicNameMap.put("PSWFLINKCOND", "\u6d41\u7a0b\u5904\u7406\u8fde\u63a5\u6761\u4ef6");
        modelLogicNameMap.put("PSSYSTEMMQ", "\u7cfb\u7edfMQ");
        modelLogicNameMap.put("PSPFPLUGIN", "\u5e73\u53f0\u9884\u7f6e\u5e94\u7528\u6846\u67b6\u63d2\u4ef6");
        modelLogicNameMap.put("PSDEVCENTERSRV", "\u4e2d\u5fc3\u670d\u52a1");
        modelLogicNameMap.put("PSSYSDBDETAIL", "\u7cfb\u7edf\u6570\u636e\u5e93\u53d1\u5e03\u7248\u672c");
        modelLogicNameMap.put("PSDEMAPDETAIL", "\u5b9e\u4f53\u6620\u5c04\u660e\u7ec6");
        modelLogicNameMap.put("PSSTUDIOSERVER", "\u5f00\u53d1\u5de5\u5177\u670d\u52a1\u5668");
        modelLogicNameMap.put("PSSYSPDTVIEW", "\u7cfb\u7edf\u9884\u7f6e\u89c6\u56fe");
        modelLogicNameMap.put("PSVARTYPE", "\u5e73\u53f0\u53d8\u91cf\u7c7b\u578b");
        modelLogicNameMap.put("PSDEFIUPDATE", "\u5b9e\u4f53\u8868\u5355\u9879\u66f4\u65b0");
        modelLogicNameMap.put("PSWFPROCESSTYPE", "\u7cfb\u7edf\u6d41\u7a0b\u5904\u7406\u7c7b\u578b");
        modelLogicNameMap.put("PSWFWORKTIME", "\u6d41\u7a0b\u5de5\u4f5c\u65f6\u95f4");
        modelLogicNameMap.put("PSAPPMODULE", "\u5e94\u7528\u6a21\u5757");
        modelLogicNameMap.put("PSSUBAPPVIEW", "\u5e73\u53f0\u5b50\u7cfb\u7edf\u5e94\u7528\u89c6\u56fe");
        modelLogicNameMap.put("PSWFLINKTYPE", "\u7cfb\u7edf\u6d41\u7a0b\u8fde\u63a5\u7c7b\u578b");
        modelLogicNameMap.put("PSSUBVIEWTYPE", "\u7cfb\u7edf\u89c6\u56fe\u6837\u5f0f");
        modelLogicNameMap.put("PSUAWIZARD", "\u5b9e\u4f53\u754c\u9762\u64cd\u4f5c\u5411\u5bfc");
        modelLogicNameMap.put("PSVIEWMSGGRPDETAIL", "\u89c6\u56fe\u6d88\u606f\u6210\u5458");
        modelLogicNameMap.put("PSDEDSPARAM", "\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u53c2\u6570");
        modelLogicNameMap.put("PSSYSMODELINST", "\u7cfb\u7edf\u6a21\u578b\u5b9e\u4f8b");
        modelLogicNameMap.put("PSDEFORMDETAIL", "\u5b9e\u4f53\u8868\u5355\u6210\u5458");
        modelLogicNameMap.put("PSDBPROCPARAM", "\u7cfb\u7edf\u5b58\u50a8\u8fc7\u7a0b\u53c2\u6570");
        modelLogicNameMap.put("PSDCSERVER", "\u5e73\u53f0\u4e2d\u5fc3\u670d\u52a1\u5668");
        modelLogicNameMap.put("PSDEGRIDCOL", "\u5b9e\u4f53\u8868\u683c\u5217");
        modelLogicNameMap.put("PSSFCODETEMPL", "\u7cfb\u7edf\u670d\u52a1\u4ee3\u7801\u6a21\u7248");
        modelLogicNameMap.put("PSWFPROCSUBWF", "\u6d41\u7a0b\u5904\u7406\u5b50\u6d41\u7a0b");
        modelLogicNameMap.put("PSDEDATASYNC", "\u5b9e\u4f53\u6570\u636e\u540c\u6b65");
        modelLogicNameMap.put("PSPFAPPTEMPL", "\u5e94\u7528\u5e94\u7528\u4ee3\u7801\u6a21\u7248");
        modelLogicNameMap.put("PSDCDBOBJ", "\u4e2d\u5fc3\u5b9e\u4f8b\u547d\u4ee4\u8bb0\u5f55");
        modelLogicNameMap.put("PSDEDQCODEEXP", "\u5b9e\u4f53\u67e5\u8be2\u4ee3\u7801\u8868\u8fbe\u5f0f");
        modelLogicNameMap.put("PSHELPMODULE", "\u5e2e\u52a9\u6a21\u5757");
        modelLogicNameMap.put("PSDEVSERVERTYPE", "\u5f00\u53d1\u684c\u9762\u7c7b\u578b");
        modelLogicNameMap.put("PSDERGROUP", "\u5b9e\u4f53\u5173\u7cfb\u7ec4");
        modelLogicNameMap.put("PSMODELPFCODE", "\u6a21\u578b\u524d\u53f0\u4ee3\u7801");
        modelLogicNameMap.put("PSAPPPVPART", "\u5e94\u7528\u95e8\u6237\u89c6\u56fe\u90e8\u4ef6");
        modelLogicNameMap.put("PSDEGEIUDETAIL", "\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0\u6210\u5458");
        modelLogicNameMap.put("PSSFPKG", "\u670d\u52a1\u6846\u67b6\u7ec4\u4ef6\u5305");
        modelLogicNameMap.put("PSMODEL", "\u7cfb\u7edf\u6a21\u578b");
        modelLogicNameMap.put("PSFORMTYPE", "\u5e73\u53f0\u8868\u5355\u7c7b\u578b");
        modelLogicNameMap.put("PSCTRLACTION", "\u63a7\u4ef6\u884c\u4e3a");
        modelLogicNameMap.put("PSSYSBDCOLUMN", "\u5927\u6570\u636e\u5217");
        modelLogicNameMap.put("PSSYSTCASSERT", "\u6d4b\u8bd5\u7528\u4f8b\u65ad\u8a00");
        modelLogicNameMap.put("PSSYSTCASSERT2", "\u6d4b\u8bd5\u7528\u4f8b\u65ad\u8a00");
        modelLogicNameMap.put("PSDEFDLOGIC", "\u4f53\u8868\u5355\u6210\u5458\u903b\u8f91\u9879");
        modelLogicNameMap.put("PSSYSTESTCASE", "\u7cfb\u7edf\u6d4b\u8bd5\u7528\u4f8b");
        modelLogicNameMap.put("PSSYSTESTCASE2", "\u6d4b\u8bd5\u7528\u4f8b");
        modelLogicNameMap.put("PSDETREENODERS", "\u5b9e\u4f53\u6811\u8282\u70b9\u5173\u7cfb");
        modelLogicNameMap.put("PSSYSDEVSTUDIO", "\u7cfb\u7edf\u5f00\u53d1\u7528\u6237");
        modelLogicNameMap.put("PSDERTYPE", "\u5b9e\u4f53\u5173\u7cfb\u7c7b\u578b");
        modelLogicNameMap.put("PSSYSMODELLOG", "\u7cfb\u7edf\u6a21\u578b\u53d8\u66f4");
        modelLogicNameMap.put("PSSYSORGTYPE", "\u7cfb\u7edf\u7ec4\u7ec7\u7c7b\u578b");
        modelLogicNameMap.put("PSSYSCOUNTER", "\u7cfb\u7edf\u8ba1\u6570\u5668");
        modelLogicNameMap.put("PSSUBSYS", "\u5e73\u53f0\u5b50\u7cfb\u7edf");
        modelLogicNameMap.put("PSDEVIEWCTRL", "\u5b9e\u4f53\u89c6\u56fe\u90e8\u4ef6");
        modelLogicNameMap.put("PSDCMTDECAT", "\u6a21\u578b\u6a21\u677f\u5b9e\u4f53\u5206\u7c7b");
        modelLogicNameMap.put("PSDEVCENTERAS", "\u4e2d\u5fc3\u5e94\u7528\u670d\u52a1\u5668");
        modelLogicNameMap.put("PSAMITEMTYPE", "\u5e94\u7528\u83dc\u5355\u9879\u7c7b\u578b");
        modelLogicNameMap.put("PSDEVCENTER", "\u4e2d\u5fc3");
        modelLogicNameMap.put("PSEDITORSTYLE", "\u5e73\u53f0\u9884\u7f6e\u7f16\u8f91\u5668\u6837\u5f0f");
        modelLogicNameMap.put("PSBKTASKLOG", "\u5e73\u53f0\u540e\u53f0\u4efb\u52a1\u65e5\u5fd7");
        modelLogicNameMap.put("PSLISTITEMTYPE", "\u5e73\u53f0\u5217\u8868\u9879\u7c7b\u578b");
        modelLogicNameMap.put("PSSYSDEPLOYAS", "\u7cfb\u7edf\u90e8\u7f72\u5e94\u7528\u670d\u52a1\u5668");
        modelLogicNameMap.put("PSVIEWMSGGROUP", "\u89c6\u56fe\u6d88\u606f\u7ec4");
        modelLogicNameMap.put("PSDER", "\u5b9e\u4f53\u5173\u7cfb");
        modelLogicNameMap.put("PSDCDBINDEX", "\u4e2d\u5fc3\u6570\u636e\u5e93\u7d22\u5f15");
        modelLogicNameMap.put("PSDBOBJTYPE", "\u5e73\u53f0\u6570\u636e\u5e93\u5bf9\u8c61\u7c7b\u578b");
        modelLogicNameMap.put("PSAPPUISTYLE", "\u5e94\u7528\u754c\u9762\u6837\u5f0f");
        modelLogicNameMap.put("PSSYSREPORT", "\u7cfb\u7edf\u62a5\u8868");
        modelLogicNameMap.put("PSCOREPRD", "\u5e73\u53f0\u6838\u5fc3\u4ea7\u54c1");
        modelLogicNameMap.put("PSDEMODELCNT", "\u5b9e\u4f53\u6a21\u578b\u8ba1\u6570");
        modelLogicNameMap.put("PSPFPUBCODE", "\u5e94\u7528\u6846\u67b6\u53d1\u5e03\u4ee3\u7801");
        modelLogicNameMap.put("PSDEFTYPE", "\u5b9e\u4f53\u5c5e\u6027\u7c7b\u578b");
        modelLogicNameMap.put("PSSF", "\u540e\u53f0\u6280\u672f\u67b6\u6784");
        modelLogicNameMap.put("PSLANGUAGE", "\u5e73\u53f0\u8bed\u8a00");
        modelLogicNameMap.put("PSDEDATAIMP", "\u5b9e\u4f53\u6570\u636e\u5bfc\u5165");
        modelLogicNameMap.put("PSPRODUCT", "\u5e73\u53f0\u4ea7\u54c1");
        modelLogicNameMap.put("PSDEFIVR", "\u5b9e\u4f53\u8868\u5355\u9879\u503c\u89c4\u5219");
        modelLogicNameMap.put("PSMODELAPIINT", "\u5e73\u53f0API\u63a5\u53e3");
        modelLogicNameMap.put("PSSYSOUTYPERS", "\u7cfb\u7edf\u7ec4\u7ec7\u5355\u5143\u7c7b\u578b\u5173\u7cfb");
        modelLogicNameMap.put("PSAPPMENUITEM", "\u5e94\u7528\u83dc\u5355\u9879");
        modelLogicNameMap.put("PSDEVSLNSYSPATCH", "\u7cfb\u7edf\u6253\u5305\u7248\u672c\u8865\u4e01");
        modelLogicNameMap.put("PSDEACTIONWIZARD", "\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc");
        modelLogicNameMap.put("PSDEVIEWLOGIC", "\u5b9e\u4f53\u89c6\u56fe\u903b\u8f91");
        modelLogicNameMap.put("PSDEFORMRF", "\u5b9e\u4f53\u8868\u5355\u5f15\u7528");
        modelLogicNameMap.put("PSSYSVIEWPANEL", "\u7cfb\u7edf\u9762\u677f");
        modelLogicNameMap.put("PSWFLINKCONDTYPE", "\u6d41\u7a0b\u8fde\u63a5\u6761\u4ef6\u7c7b\u578b");
        modelLogicNameMap.put("PSSYSDEPLOYAPP", "\u7cfb\u7edf\u90e8\u7f72\u5e94\u7528");
        modelLogicNameMap.put("PSVTCATDETAIL", "\u89c6\u56fe\u7c7b\u578b\u5206\u7c7b\u6210\u5458");
        modelLogicNameMap.put("PSAPPTYPE", "\u5e94\u7528\u7c7b\u578b");
        modelLogicNameMap.put("PSSYSBDCOLSET", "\u5927\u6570\u636e\u8868\u5217\u65cf");
        modelLogicNameMap.put("PSPFSTYLECODE", "\u5e94\u7528\u6837\u5f0f\u5b8f\u4ee3\u7801");
        modelLogicNameMap.put("PSDEDSGRPPARAM", "\u5b9e\u4f53\u6570\u636e\u96c6\u5206\u7ec4\u53c2\u6570");
        modelLogicNameMap.put("PSDBSYSPROCTEMPL", "\u6570\u636e\u5e93\u7cfb\u7edf\u8fc7\u7a0b\u6a21\u7248");
        modelLogicNameMap.put("PSDETOOLBAR", "\u5b9e\u4f53\u5de5\u5177\u680f");
        modelLogicNameMap.put("PSDEDUPRULEITEM", "\u5b9e\u4f53\u6570\u636e\u91cd\u590d\u89c4\u5219\u9879");
        modelLogicNameMap.put("PSDETREENODE", "\u5b9e\u4f53\u6811\u8282\u70b9");
        modelLogicNameMap.put("PSSYSTBITEM", "\u5e73\u53f0\u9884\u7f6e\u5de5\u5177\u680f\u9879");
        modelLogicNameMap.put("PSDEWIZARDSTEP", "\u5b9e\u4f53\u5411\u5bfc\u6b65\u9aa4");
        modelLogicNameMap.put("PSSYSPORTLET", "\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6");
        modelLogicNameMap.put("PSDEDRDETAIL", "\u5b9e\u4f53\u754c\u9762\u7ec4\u6210\u5458");
        modelLogicNameMap.put("PSWXMENUFUNC", "\u5fae\u4fe1\u83dc\u5355\u529f\u80fd");
        modelLogicNameMap.put("PSDEVCENTERPF", "\u4e2d\u5fc3\u5e94\u7528\u6846\u67b6");
        modelLogicNameMap.put("PSDEDATAVIEW", "\u5b9e\u4f53\u5361\u7247\u89c6\u56fe");
        modelLogicNameMap.put("PSDELNTYPE", "\u5b9e\u4f53\u903b\u8f91\u5904\u7406\u8282\u70b9\u7c7b\u578b");
        modelLogicNameMap.put("PSPFCODEFOLDER", "\u5e94\u7528\u4ee3\u7801\u76ee\u5f55");
        modelLogicNameMap.put("PSSFCODEFOLDER", "\u7cfb\u7edf\u670d\u52a1\u4ee3\u7801\u76ee\u5f55");
        modelLogicNameMap.put("PSSYSMODELACTION", "\u7cfb\u7edf\u6a21\u5757\u5b9e\u4f8b\u64cd\u4f5c");
        modelLogicNameMap.put("PSCOREPRDISSUE", "\u5e73\u53f0\u6838\u5fc3\u4ea7\u54c1\u95ee\u9898");
        modelLogicNameMap.put("PSDEVIEWBASE", "\u5b9e\u4f53\u89c6\u56fe");
        modelLogicNameMap.put("PSSYSPROJECT", "\u7cfb\u7edf\u5de5\u7a0b\u9879\u76ee");
        modelLogicNameMap.put("PSDBTYPE", "\u6570\u636e\u5e93\u7c7b\u578b");
        modelLogicNameMap.put("PSDBSYSPROCTYPE", "\u6570\u636e\u5e93\u7cfb\u7edf\u8fc7\u7a0b\u7c7b\u578b");
        modelLogicNameMap.put("PSDEAWGRPDETAIL", "\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u7ec4\u6210\u5458");
        modelLogicNameMap.put("PSDEMAP", "\u5b9e\u4f53\u6620\u5c04");
        modelLogicNameMap.put("PSDELLTYPE", "\u5b9e\u4f53\u903b\u8f91\u5904\u7406\u8fde\u63a5\u7c7b\u578b");
        modelLogicNameMap.put("PSDEWIZARDFORM", "\u5b9e\u4f53\u5411\u5bfc\u8868\u5355");
        modelLogicNameMap.put("PSAPPSUBAPP", "\u5e94\u7528\u5b50\u5e94\u7528");
        modelLogicNameMap.put("PSDEDBIDXFIELD", "\u5b9e\u4f53\u6570\u636e\u5e93\u7d22\u5f15\u5c5e\u6027");
        modelLogicNameMap.put("PSSYSDMITEMLOG", "\u7cfb\u7edf\u6570\u636e\u5e93\u6a21\u578b\u5173\u952e\u53d8\u66f4");
        modelLogicNameMap.put("PSTBITEMTYPE", "\u5e73\u53f0\u5de5\u5177\u680f\u9879\u7c7b\u578b");
        modelLogicNameMap.put("PSDCMODELTEMPL", "\u4e2d\u5fc3\u6a21\u578b\u6a21\u677f");
        modelLogicNameMap.put("PSDESPCODE", "\u7cfb\u7edf\u5b58\u50a8\u8fc7\u7a0b\u4ee3\u7801");
        modelLogicNameMap.put("PSBDDEVINST", "\u5e73\u53f0\u5927\u6570\u636e\u5b9e\u4f8b");
        modelLogicNameMap.put("PSDBVALUEFUNC", "\u6570\u636e\u5e93\u503c\u51fd\u6570");
        modelLogicNameMap.put("PSPFUATEMPL", "\u5e94\u7528\u754c\u9762\u884c\u4e3a\u4ee3\u7801\u6a21\u7248");
        modelLogicNameMap.put("PSCODENAME", "\u4ee3\u7801\u540d\u79f0\u5e93");
        modelLogicNameMap.put("PSUAWIZARD2", "\u754c\u9762\u64cd\u4f5c\u5411\u5bfc2");
        modelLogicNameMap.put("PSDCSERVERSTATE", "\u4e2d\u5fc3\u4e3b\u673a\u72b6\u6001");
        modelLogicNameMap.put("PSSYSSFPUB", "\u7cfb\u7edf\u540e\u53f0\u670d\u52a1\u4f53\u7cfb");
        modelLogicNameMap.put("PSSYSDBVF", "\u7cfb\u7edf\u6570\u636e\u5e93\u503c\u51fd\u6570");
        modelLogicNameMap.put("PSDEVCENTERSVN", "\u4e2d\u5fc3\u4ee3\u7801\u5e93");
        modelLogicNameMap.put("PSHELPARTICLECAT", "\u5e2e\u52a9\u6587\u7ae0\u5206\u7c7b");
        modelLogicNameMap.put("PSDELIST", "\u5b9e\u4f53\u5217\u8868");
        modelLogicNameMap.put("PSDEFVRCOND", "\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u9879");
        modelLogicNameMap.put("PSSYSCSS", "\u7cfb\u7edf\u754c\u9762\u6837\u5f0f\u8868");
        modelLogicNameMap.put("PSDEVSLNSYSMODEL", "\u5f00\u53d1\u7cfb\u7edf\u6a21\u578b");
        modelLogicNameMap.put("PSDCINST", "\u4e2d\u5fc3\u5b9e\u4f8b");
        modelLogicNameMap.put("PSMODULE", "\u7cfb\u7edf\u6a21\u5757");
        modelLogicNameMap.put("PSSYSERMAPNODE", "\u7cfb\u7edfER\u56fe\u8282\u70b9");
        modelLogicNameMap.put("PSSYSREF", "\u7cfb\u7edf\u5f15\u7528");
        modelLogicNameMap.put("PSSYSVIEWLOGIC", "\u9884\u7f6e\u89c6\u56fe\u903b\u8f91");
        modelLogicNameMap.put("PSDCDBVIEW", "\u4e2d\u5fc3\u6570\u636e\u5e93\u89c6\u56fe");
        modelLogicNameMap.put("PSDEVUSERGROUP", "\u4e2d\u5fc3\u7528\u6237\u7ec4");
        modelLogicNameMap.put("PSDEFVALUERULE", "\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219");
        modelLogicNameMap.put("PSDELLCONDTYPE", "\u5b9e\u4f53\u903b\u8f91\u5904\u7406\u8fde\u63a5\u6761\u4ef6\u7c7b\u578b");
        modelLogicNameMap.put("PSSYSBDINSTCFG", "\u7cfb\u7edf\u5927\u6570\u636e\u5b9e\u4f8b\u914d\u7f6e");
        modelLogicNameMap.put("PSDEVUSERSQL", "\u5f00\u53d1\u7528\u6237\u6587\u4ef6");
        modelLogicNameMap.put("PSDETREEVIEW", "\u5b9e\u4f53\u6811\u89c6\u56fe");
        modelLogicNameMap.put("PSCHARTTYPE", "\u5e73\u53f0\u56fe\u8868\u7c7b\u578b");
        modelLogicNameMap.put("PSAPPDEVIEW", "\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe");
        modelLogicNameMap.put("PSDEAWGROUP", "\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u7ec4");
        modelLogicNameMap.put("PSAPPINDEXVIEW", "\u5e94\u7528\u9996\u9875\u89c6\u56fe");
        modelLogicNameMap.put("PSDEOPPRIV", "\u5b9e\u4f53\u64cd\u4f5c\u6743\u9650");
        modelLogicNameMap.put("PSPF", "\u524d\u53f0\u6280\u672f\u67b6\u6784");
        modelLogicNameMap.put("PSHELPPRJTYPE", "\u5e2e\u52a9\u9879\u76ee\u7c7b\u578b");
        modelLogicNameMap.put("PSHELPPRJTEMPL", "\u5e2e\u52a9\u9879\u76ee\u6a21\u677f");
        modelLogicNameMap.put("PSMODELPLUGIN", "\u5e73\u53f0\u6a21\u578b\u63d2\u4ef6");
        modelLogicNameMap.put("PSMODELMODULE", "\u7cfb\u7edf\u6a21\u578b\u6a21\u5757");
        modelLogicNameMap.put("PSVARSAMPLEVALUE", "\u5e73\u53f0\u53d8\u91cf\u793a\u4f8b\u503c");
        modelLogicNameMap.put("PSCOREPRDINSTLOG", "\u6838\u5fc3\u4ea7\u54c1\u5b89\u88c5\u65e5\u5fd7");
        modelLogicNameMap.put("PSMODELSECTION", "\u7cfb\u7edf\u6a21\u5757\u7ae0\u8282");
        modelLogicNameMap.put("PSMODELEXAMPLE", "\u7cfb\u7edf\u6a21\u578b\u4f8b\u5b50");
        modelLogicNameMap.put("PSMODELRESOURCE", "\u7cfb\u7edf\u6a21\u578b\u8d44\u6e90");
        modelLogicNameMap.put("PSRTWXACCOUNT", "\u5e73\u53f0\u8fd0\u884c\u5fae\u4fe1\u4f01\u4e1a\u53f7");
        modelLogicNameMap.put("PSDERGROUPDETAIL", "\u5b9e\u4f53\u5173\u7cfb\u7ec4\u6210\u5458");
        modelLogicNameMap.put("PSROBOTWORK", "\u673a\u5668\u4eba\u4f5c\u4e1a");
        modelLogicNameMap.put("PSDEMSOPPRIV", "\u4e3b\u72b6\u6001\u64cd\u4f5c\u6807\u8bc6");
        modelLogicNameMap.put("PSMODELOBJ", "\u6a21\u578b\u5bf9\u8c61");
        modelLogicNameMap.put("PSSYSVIEWPANELITEM", "\u7cfb\u7edf\u89c6\u56fe\u9762\u677f\u6210\u5458");
        modelLogicNameMap.put("PSDEFGROUPDETAIL", "\u5b9e\u4f53\u5c5e\u6027\u7ec4\u6210\u5458");
        modelLogicNameMap.put("PSDEFGROUP", "\u5b9e\u4f53\u5c5e\u6027\u7ec4");
        modelLogicNameMap.put("PSSYSSEARCHBAR", "\u641c\u7d22\u680f");
        modelLogicNameMap.put("PSSYSBDTABLEDER", "\u5927\u6570\u636e\u8868\u5173\u7cfb");
        modelLogicNameMap.put("PSSYSBDMODULE", "\u5927\u6570\u636e\u4f53\u7cfb\u6a21\u5757");
        modelLogicNameMap.put("PSDEPSLNSYSAS", "\u90e8\u7f72\u65b9\u6848\u7cfb\u7edf\u90e8\u7f72");
        modelLogicNameMap.put("PSDEPSLNSYSMQ", "\u90e8\u7f72\u65b9\u6848\u7cfb\u7edfMQ");
        modelLogicNameMap.put("PSDEPSLNSYSDB", "\u90e8\u7f72\u65b9\u6848\u7cfb\u7edf\u6570\u636e\u5e93");
        modelLogicNameMap.put("PSDEPSLNMQINST", "\u90e8\u7f72\u65b9\u6848MQ\u5b9e\u4f8b");
        modelLogicNameMap.put("PSDEPSLNSYS", "\u90e8\u7f72\u65b9\u6848\u7cfb\u7edf");
        modelLogicNameMap.put("PSSTUDIOSERVERGRP", "\u5e73\u53f0\u5f00\u53d1\u5de5\u5177\u670d\u52a1\u5668\u7ec4");
        modelLogicNameMap.put("PSDEPSAASSYSAPP", "\u90e8\u7f72SaaS\u7cfb\u7edf\u5e94\u7528\uff08\u6682\u65f6\u5e9f\u5f03\uff09");
        modelLogicNameMap.put("PSDEPSAASSYSVER", "\u90e8\u7f72SaaS\u7cfb\u7edf\u7248\u672c\uff08\u6682\u65f6\u5e9f\u5f03\uff09");
        modelLogicNameMap.put("PSDEPSAASSYS", "\u90e8\u7f72SaaS\u7cfb\u7edf\uff08\u6682\u65f6\u5e9f\u5f03\uff09");
        modelLogicNameMap.put("PSDEPSYSAPP", "\u90e8\u7f72\u7cfb\u7edf\u5e94\u7528");
        modelLogicNameMap.put("PSDEPSYS", "\u53ef\u90e8\u7f72\u7cfb\u7edf");
        modelLogicNameMap.put("PSDEPSYSVER", "\u53ef\u90e8\u7f72\u7cfb\u7edf\u7248\u672c");
        modelLogicNameMap.put("PSDEPSLNHOST", "\u90e8\u7f72\u65b9\u6848\u4e3b\u673a");
        modelLogicNameMap.put("PSSAASSYSDB", "SaaS\u7cfb\u7edf\u6570\u636e\u5e93");
        modelLogicNameMap.put("PSDEPSLNPACK", "\u90e8\u7f72\u65b9\u6848\u6253\u5305");
        modelLogicNameMap.put("PSDEPSLNDEPSESSION", "\u90e8\u7f72\u65b9\u6848\u90e8\u7f72\u64cd\u4f5c");
        modelLogicNameMap.put("PSGITUSER", "\u5e73\u53f0GIT\u7528\u6237");
        modelLogicNameMap.put("PSNDFILE", "\u5e73\u53f0\u7f51\u76d8\u6587\u4ef6");
        modelLogicNameMap.put("PSNDFILELINK", "\u5e73\u53f0\u7f51\u76d8\u6587\u4ef6\u94fe\u63a5");
        modelLogicNameMap.put("PSSYSENGINECFG", "\u7cfb\u7edf\u5f15\u64ce\u914d\u7f6e");
        modelLogicNameMap.put("PSDEVPRD", "\u5f00\u53d1\u4ea7\u54c1");
        modelLogicNameMap.put("PSDEVPRDVER", "\u5f00\u53d1\u4ea7\u54c1\u4e3b\u5e72");
        modelLogicNameMap.put("PSDEVPRDSUBVER", "\u5f00\u53d1\u4ea7\u54c1\u7248\u672c");
        modelLogicNameMap.put("PSDEVPRDSYS", "\u5f00\u53d1\u4ea7\u54c1\u7cfb\u7edf");
        modelLogicNameMap.put("PSDEVPRDSYSSYNC", "\u5f00\u53d1\u4ea7\u54c1\u7cfb\u7edf\u540c\u6b65");
        modelLogicNameMap.put("PSDSBOOKINGLOG", "\u5e73\u53f0\u5f00\u53d1\u4e3b\u673a\u9884\u7ea6\u65e5\u5fd7");
        modelLogicNameMap.put("PSDCDBINSTREF", "\u4e2d\u5fc3\u6570\u636e\u5e93\u5b9e\u4f8b\u5f15\u7528");
        modelLogicNameMap.put("PSDEVPRDSYSSYNCITEM", "\u5f00\u53d1\u4ea7\u54c1\u7cfb\u7edf\u540c\u6b65\u9879");
        modelLogicNameMap.put("PSDEVPRDSPEC", "\u5f00\u53d1\u4ea7\u54c1\u89c4\u683c");
        modelLogicNameMap.put("PSDEVPRDSEPCPLAN", "\u5f00\u53d1\u4ea7\u54c1\u89c4\u8303\u8ba1\u5212\uff08\u5e9f\u5f03\uff09");
        modelLogicNameMap.put("PSDEVPRDSPECPLAN", "\u5f00\u53d1\u4ea7\u54c1\u89c4\u8303\u8ba1\u5212");
        modelLogicNameMap.put("PSDEVSLNSYSRES", "\u5f00\u53d1\u7cfb\u7edf\u8d44\u6e90\u5305");
        modelLogicNameMap.put("PSPFCDN", "\u5e94\u7528\u6846\u67b6CDN");
        modelLogicNameMap.put("PSPFEDITORTYPE", "\u524d\u7aef\u7f16\u8f91\u5668\u53c2\u6570");
        modelLogicNameMap.put("PSMODELERROR", "\u7cfb\u7edf\u6a21\u578b\u9519\u8bef");
        modelLogicNameMap.put("PSPFPKGVERCDN", "\u524d\u7aef\u5e94\u7528\u7ec4\u4ef6\u5305\u7248\u672cCDN");
        modelLogicNameMap.put("PSSYSMODELFUNCCAT", "\u7cfb\u7edf\u6a21\u578b\u529f\u80fd\u5206\u7c7b");
        modelLogicNameMap.put("PSMODELSTATE", "\u6a21\u578b\u72b6\u6001");
        modelLogicNameMap.put("PSMODELVALUEGROUP", "\u7cfb\u7edf\u6a21\u578b\u503c\u7ec4");
        modelLogicNameMap.put("PSMODELFIELDVALUE", "\u7cfb\u7edf\u6a21\u578b\u5c5e\u6027\u53d6\u503c");
        modelLogicNameMap.put("PSMODELFIELD", "\u7cfb\u7edf\u6a21\u578b\u5c5e\u6027");
        modelLogicNameMap.put("PSSFVIEWTYPE", "\u540e\u53f0\u670d\u52a1\u89c6\u56fe\u53c2\u6570");
        modelLogicNameMap.put("PSSFCTRLTYPE", "\u540e\u53f0\u670d\u52a1\u90e8\u4ef6\u53c2\u6570");
        modelLogicNameMap.put("PSPFVIEWTYPE", "\u524d\u7aef\u89c6\u56fe\u53c2\u6570");
        modelLogicNameMap.put("PSPFCTRLTYPE", "\u524d\u7aef\u90e8\u4ef6\u53c2\u6570");
        modelLogicNameMap.put("PSMODELUIACTION", "\u7cfb\u7edf\u6a21\u578b\u754c\u9762\u884c\u4e3a");
        modelLogicNameMap.put("PSASBOOKING", "\u5e73\u53f0\u5e94\u7528\u5bb9\u5668\u9884\u7ea6");
        modelLogicNameMap.put("PSDEDTSQUEUE", "\u5b9e\u4f53\u5206\u5e03\u4e8b\u52a1\u961f\u5217");
        modelLogicNameMap.put("PSMODELEXAMPLESTEP", "\u6a21\u578b\u793a\u4f8b\u6b65\u9aa4");
        modelLogicNameMap.put("PSMODELEXAMPLECAT", "\u6a21\u578b\u5b9e\u4f8b\u5206\u7c7b");
        modelLogicNameMap.put("PSMODELSUBVIEW", "\u6a21\u578b\u5b50\u89c6\u56fe");
        modelLogicNameMap.put("PSMODELVIEW", "\u7cfb\u7edf\u6a21\u578b\u89c6\u56fe");
        modelLogicNameMap.put("PSDEPSYSTYPE", "\u90e8\u7f72\u7cfb\u7edf\u7c7b\u578b");
        modelLogicNameMap.put("PSMQTYPE", "\u5e73\u53f0MQ\u7c7b\u578b");
        modelLogicNameMap.put("PSDCASGROUP", "\u4e2d\u5fc3\u5e94\u7528\u5bb9\u5668\u7ec4");
        modelLogicNameMap.put("PSASGROUP", "\u5e94\u7528\u5bb9\u5668\u96c6\u7fa4");
        modelLogicNameMap.put("PSDEPSLNTYPE", "\u90e8\u7f72\u65b9\u6848\u7c7b\u578b");
        modelLogicNameMap.put("PSMODELVIEWUIACTION", "\u6a21\u578b\u89c6\u56fe\u754c\u9762\u884c\u4e3a");
        modelLogicNameMap.put("PSDCSYSLIC", "\u4e2d\u5fc3\u7cfb\u7edf\u6388\u6743");
        modelLogicNameMap.put("PSDCDBINSTBK", "\u4e2d\u5fc3\u6570\u636e\u5e93\u5907\u4efd");
        modelLogicNameMap.put("PSDCSVNBK", "\u4e2d\u5fc3SVN\u5907\u4efd");
        modelLogicNameMap.put("PSSAASSYSAPP", "SaaS\u7cfb\u7edf\u5e94\u7528");
        modelLogicNameMap.put("PSSAASSYSVER", "SaaS\u7cfb\u7edf\u7248\u672c");
        modelLogicNameMap.put("PSSAASSYS", "SaaS\u7cfb\u7edf");
        modelLogicNameMap.put("PSDEVCENTERFILE", "\u4e2d\u5fc3\u6587\u4ef6");
        modelLogicNameMap.put("PSSYSMODELMSG", "\u7cfb\u7edf\u6a21\u578b\u6d88\u606f");
        modelLogicNameMap.put("PSDER_DERINHERIT", "\u5b9e\u4f53\u5173\u7cfb\uff08\u7ee7\u627f\uff09");
        modelLogicNameMap.put("PSDSBOOKING", "\u5e73\u53f0\u5f00\u53d1\u4e3b\u673a\u9884\u7ea6");
        modelLogicNameMap.put("PSDEPLOYSERVER", "\u5e73\u53f0\u90e8\u7f72\u670d\u52a1\u5668");
        modelLogicNameMap.put("PSSTUDIOSERVERLOG", "\u5f00\u53d1\u5de5\u5177\u670d\u52a1\u5668\u65e5\u5fd7");
        modelLogicNameMap.put("PSDBDEVINSTBK", "\u6570\u636e\u5e93\u5f00\u53d1\u5b9e\u4f8b\u5907\u4efd");
        modelLogicNameMap.put("PSSYSMODELINSTBK", "\u7cfb\u7edf\u6a21\u578b\u5e93\u5907\u4efd");
        modelLogicNameMap.put("PSSYSUNISTATE", "\u7cfb\u7edf\u72b6\u6001\u534f\u540c");
        modelLogicNameMap.put("PSSYSRTMSG", "\u7cfb\u7edf\u6a21\u578b\u8fd0\u884c\u4fe1\u606f");
        modelLogicNameMap.put("PSSYSSQLCMD", "\u7cfb\u7edf\u6570\u636e\u5e93\u547d\u4ee4");
        modelLogicNameMap.put("PSSYSSQLCMDSQL", "\u7cfb\u7edf\u6570\u636e\u5e93\u547d\u4ee4\u4ee3\u7801");
        modelLogicNameMap.put("PSDERTAW", "\u5b9e\u4f53\u8fd0\u884c\u64cd\u4f5c\u5411\u5bfc\u5e93");
        modelLogicNameMap.put("PSDERTAWI", "\u5b9e\u4f53\u8fd0\u884c\u64cd\u4f5c\u5411\u5bfc\u9879");
        modelLogicNameMap.put("PSSYSRTDEFINPUTTIP", "\u7cfb\u7edf\u8fd0\u884c\u5c5e\u6027\u8f93\u5165\u63d0\u793a");
        modelLogicNameMap.put("PSMODELRTMSG", "\u6a21\u578b\u8fd0\u884c\u6d88\u606f");
        modelLogicNameMap.put("PSROBOTTYPE", "\u5e73\u53f0\u673a\u5668\u4eba\u7c7b\u578b");
        modelLogicNameMap.put("PSROBOTWORKTYPE", "\u5e73\u53f0\u673a\u5668\u4eba\u80fd\u529b\u7c7b\u578b");
        modelLogicNameMap.put("PSROBOTTYPEABILITY", "\u673a\u5668\u4eba\u7c7b\u578b\u80fd\u529b");
        modelLogicNameMap.put("PSSUBSYSVERINST", "\u5b50\u7cfb\u7edf\u7248\u672c\u5b9e\u4f8b");
        modelLogicNameMap.put("PSCTRLMSGTAG", "\u5e73\u53f0\u90e8\u4ef6\u6d88\u606f\u6807\u8bb0");
        modelLogicNameMap.put("PSBOOKINGRESTYPE", "\u5e73\u53f0\u9884\u7ea6\u8d44\u6e90\u7c7b\u578b");
        modelLogicNameMap.put("PSDEFINPUTTIPSET", "\u7cfb\u7edf\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u96c6\u5408");
        modelLogicNameMap.put("PSDCNWFLOW", "\u4e2d\u5fc3\u6d41\u91cf");
        modelLogicNameMap.put("PSDCROBOT", "\u4e2d\u5fc3\u673a\u5668\u4eba");
        modelLogicNameMap.put("PSDCROBOTABILITY", "\u4e2d\u5fc3\u673a\u5668\u4eba\u80fd\u529b");
        modelLogicNameMap.put("PSDCROBOTLOG", "\u4e2d\u5fc3\u673a\u5668\u4eba\u65e5\u5fd7");
        modelLogicNameMap.put("PSDCRTMSG", "\u4e2d\u5fc3\u8fd0\u884c\u4fe1\u606f");
        modelLogicNameMap.put("PSDCRESREP", "\u4e2d\u5fc3\u8d44\u6e90\u62a5\u544a");
        modelLogicNameMap.put("PSDCABILITY", "\u4e2d\u5fc3\u80fd\u529b");
        modelLogicNameMap.put("PSDCRESHOURSLOG", "\u4e2d\u5fc3\u8d44\u6e90\u65f6\u95f4\u65e5\u5fd7");
        modelLogicNameMap.put("PSDCRESHOURS", "\u4e2d\u5fc3\u8d44\u6e90\u65f6\u95f4");
        modelLogicNameMap.put("PSVIEWRTMSG", "\u89c6\u56fe\u8fd0\u884c\u6d88\u606f");
        modelLogicNameMap.put("PSSYSMODELINSTSUM", "\u7cfb\u7edf\u6a21\u578b\u5b9e\u4f8b\u6a21\u578b\u8ba1\u6570");
        modelLogicNameMap.put("PSDCDEPLOYSERVER", "\u4e2d\u5fc3\u90e8\u7f72\u670d\u52a1\u5668");
        modelLogicNameMap.put("PSSYSSEARCHBARITEM", "\u641c\u7d22\u680f\u9879");
        modelLogicNameMap.put("PSROBOTABILITY", "\u673a\u5668\u4eba\u80fd\u529b\u9879");
        modelLogicNameMap.put("PSDEUSERROLE", "\u5b9e\u4f53\u64cd\u4f5c\u80fd\u529b");
        modelLogicNameMap.put("PSDER_DERINDEX", "\u5b9e\u4f53\u5173\u7cfb\uff08\u7d22\u5f15\uff09");
        modelLogicNameMap.put("PSDEFORMDETAIL_BUTTON", "\u8868\u5355\u6210\u5458\uff08\u8868\u5355\u6309\u94ae\uff09");
        modelLogicNameMap.put("PSDEFORMDETAIL_FORMPART", "\u8868\u5355\u6210\u5458\uff08\u8868\u5355\u90e8\u4ef6\uff09");
        modelLogicNameMap.put("PSDEFORMDETAIL_FORMPAGE", "\u8868\u5355\u6210\u5458\uff08\u8868\u5355\u5206\u9875\uff09");
        modelLogicNameMap.put("PSDEFORMDETAIL_FORMITEM", "\u8868\u5355\u6210\u5458\uff08\u8868\u5355\u9879\uff09");
        modelLogicNameMap.put("PSDEFORMDETAIL_TABPANEL", "\u8868\u5355\u6210\u5458\uff08\u5206\u9875\u90e8\u4ef6\uff09");
        modelLogicNameMap.put("PSDEFORMDETAIL_TABPAGE", "\u8868\u5355\u6210\u5458\uff08\u5206\u9875\u9762\u677f\uff09");
        modelLogicNameMap.put("PSDEFORMDETAIL_GROUPPANEL", "\u8868\u5355\u6210\u5458\uff08\u5206\u7ec4\u9762\u677f\uff09");
        modelLogicNameMap.put("PSDEFORMDETAIL_DATAGRID", "\u8868\u5355\u6210\u5458\uff08\u6570\u636e\u8868\u683c\uff09");
        modelLogicNameMap.put("PSDEFORMDETAIL_DRUIPART", "\u8868\u5355\u6210\u5458\uff08\u6570\u636e\u5173\u7cfb\u754c\u9762\uff09");
        modelLogicNameMap.put("PSDEFORMDETAIL_USERCONTROL", "\u8868\u5355\u6210\u5458\uff08\u7528\u6237\u63a7\u4ef6\uff09");
        modelLogicNameMap.put("PSDEFORMDETAIL_RAWITEM", "\u8868\u5355\u6210\u5458\uff08\u76f4\u63a5\u5185\u5bb9\uff09");
        modelLogicNameMap.put("PSDEFORMDETAIL_IFRAME", "\u8868\u5355\u6210\u5458\uff08\u76f4\u63a5\u9875\u9762\u5d4c\u5165\uff09");
        modelLogicNameMap.put("PSDEFORMDETAIL_FORMITEMEX", "\u8868\u5355\u6210\u5458\uff08\u590d\u5408\u8868\u5355\u9879\uff09");
        modelLogicNameMap.put("PSDEFORMDETAIL_MDCTRL", "\u8868\u5355\u6210\u5458\uff08\u591a\u6570\u636e\u90e8\u4ef6\uff09");
        modelLogicNameMap.put("PSDEFORMDETAIL_BUTTONLIST", "\u8868\u5355\u6210\u5458\uff08\u8868\u5355\u6309\u94ae\u5217\u8868\uff09");
        modelLogicNameMap.put("PSDEFORM_EDITFORM", "\u5b9e\u4f53\u7f16\u8f91\u8868\u5355");
        modelLogicNameMap.put("PSDEFORM_SEARCHFORM", "\u5b9e\u4f53\u641c\u7d22\u8868\u5355");
        modelLogicNameMap.put("PSDCMOBAPPTESTDEVICE", "\u4e2d\u5fc3\u79fb\u52a8\u5e94\u7528\u6d4b\u8bd5\u7ec8\u7aef");
        modelLogicNameMap.put("PSDCMOBAPPTDREF", "\u4e2d\u5fc3\u6d4b\u8bd5\u8bbe\u5907\u5f15\u7528");
        modelLogicNameMap.put("PSMOBAPPSTARTPAGE", "\u79fb\u52a8\u5e94\u7528\u6b22\u8fce\u9875");
        modelLogicNameMap.put("PSMOBAPPPACKSESSION", "\u79fb\u52a8\u5e94\u7528\u6253\u5305\u4f1a\u8bdd");
        modelLogicNameMap.put("PSDCMOBPACKCERT", "\u4e2d\u5fc3\u79fb\u52a8\u7aef\u6253\u5305\u8bc1\u4e66");
        modelLogicNameMap.put("PSMODELRT", "\u6a21\u578b\u8fd0\u884c\u65f6");
        modelLogicNameMap.put("PSMOBAPPPACKTD", "\u79fb\u52a8\u5e94\u7528\u6253\u5305\u6d4b\u8bd5\u8bbe\u5907");
        modelLogicNameMap.put("PSSYSDEFTYPE", "\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u9ed8\u8ba4\u903b\u8f91");
        modelLogicNameMap.put("PSSYSDELOGICNODE", "\u7cfb\u7edf\u903b\u8f91\u5904\u7406\u8282\u70b9");
        modelLogicNameMap.put("PSDEVPRDISSUE", "\u5f00\u53d1\u4ea7\u54c1\u95ee\u9898");
        modelLogicNameMap.put("PSDEVPRDISSUEPLAN", "\u5f00\u53d1\u4ea7\u54c1\u95ee\u9898\u4fee\u590d\u8ba1\u5212");
        modelLogicNameMap.put("PSDCPFPITEMPL", "\u4e2d\u5fc3\u524d\u7aef\u63d2\u4ef6\u6a21\u677f");
        modelLogicNameMap.put("PSDCPFPLUGIN", "\u4e2d\u5fc3\u524d\u7aef\u5e94\u7528\u63d2\u4ef6");
        modelLogicNameMap.put("PSMOBAPPPACKSERVER", "\u79fb\u52a8\u5e94\u7528\u6253\u5305\u670d\u52a1\u5668");
        modelLogicNameMap.put("PSDCSYNCAGENT", "\u4e2d\u5fc3\u540c\u6b65\u4ee3\u7406");
        modelLogicNameMap.put("PSDCSYNCDATATYPE", "\u4e2d\u5fc3\u540c\u6b65\u6570\u636e\u7c7b\u578b");
        modelLogicNameMap.put("PSDCSYNCDATA", "\u4e2d\u5fc3\u540c\u6b65\u6570\u636e");
        modelLogicNameMap.put("PSDCSYNCDATA2", "\u4e2d\u5fc3\u540c\u6b65\u8f93\u5165\u6570\u636e");
        modelLogicNameMap.put("PSSFPUBOBJPARAM", "\u670d\u52a1\u6a21\u677f\u53d1\u5e03\u5bf9\u8c61\u53c2\u6570");
        modelLogicNameMap.put("PSSFPUBOBJ", "\u670d\u52a1\u6a21\u677f\u53d1\u5e03\u5bf9\u8c61");
        modelLogicNameMap.put("PSPFPUBOBJ", "\u5e94\u7528\u6a21\u677f\u53d1\u5e03\u5bf9\u8c61");
        modelLogicNameMap.put("PSPFPUBOBJPARAM", "\u5e94\u7528\u6a21\u677f\u53d1\u5e03\u5bf9\u8c61\u53c2\u6570");
        modelLogicNameMap.put("PSDEOPPRIVROLE", "\u5b9e\u4f53\u64cd\u4f5c\u80fd\u529b\u6807\u8bc6");
        modelLogicNameMap.put("PSDEVIEWCTRLDS", "\u89c6\u56fe\u90e8\u4ef6\u9644\u52a0\u6570\u636e\u96c6");
        modelLogicNameMap.put("PSDELOGIC_VIEWLOGIC", "\u89c6\u56fe\u903b\u8f91");
        modelLogicNameMap.put("PSSYSDBPART", "\u7cfb\u7edf\u6570\u636e\u770b\u677f");
        modelLogicNameMap.put("PSSYSMODELLOADLOG", "\u7cfb\u7edf\u6a21\u578b\u52a0\u8f7d\u65e5\u5fd7");
        modelLogicNameMap.put("PSSYSDASHBOARD", "\u7cfb\u7edf\u6570\u636e\u770b\u677f");
        modelLogicNameMap.put("PSSYSUTILDE", "\u7cfb\u7edf\u529f\u80fd\u914d\u7f6e");
        modelLogicNameMap.put("PSDEUTILDE", "\u5b9e\u4f53\u529f\u80fd\u914d\u7f6e");
        modelLogicNameMap.put("PSAPPLOCALDE", "\u5e94\u7528\u672c\u5730\u5b9e\u4f53");
        modelLogicNameMap.put("PSSYSUSERROLERES", "\u7cfb\u7edf\u89d2\u8272\u8d44\u6e90");
        modelLogicNameMap.put("PSSYSSFPITEMPL", "\u540e\u53f0\u63d2\u4ef6\u6a21\u677f");
        modelLogicNameMap.put("PSSYSSFPLUGIN", "\u7cfb\u7edf\u540e\u53f0\u6a21\u677f\u63d2\u4ef6");
        modelLogicNameMap.put("PSSFPLUGIN", "\u540e\u53f0\u670d\u52a1\u63d2\u4ef6");
        modelLogicNameMap.put("PSSFPLUGINTEMPL", "\u540e\u53f0\u670d\u52a1\u63d2\u4ef6\u6a21\u677f");
        modelLogicNameMap.put("PSDEUTILTYPE", "\u5b9e\u4f53\u529f\u80fd\u7c7b\u578b");
        modelLogicNameMap.put("PSDEMODEL", "\u5b9e\u4f53\u6a21\u578b\u914d\u7f6e");
        modelLogicNameMap.put("PSDEVIEWGRPDETAIL", "\u5b9e\u4f53\u89c6\u56fe\u7ec4\u6210\u5458");
        modelLogicNameMap.put("PSDEVIEWGROUP", "\u7cfb\u7edf\u5b9e\u4f53\u89c6\u56fe\u7ec4");
        modelLogicNameMap.put("PSAPPUTIL", "\u5e94\u7528\u529f\u80fd\u914d\u7f6e");
        modelLogicNameMap.put("PSSYSCONSOLE", "\u7cfb\u7edf\u63a7\u5236\u53f0\u4fe1\u606f");
        modelLogicNameMap.put("PSDCCODESNIPPETREF", "\u4e2d\u5fc3\u4ee3\u7801\u6a21\u677f\u5f15\u7528");
        modelLogicNameMap.put("PSDCCODESNIPPET", "\u4e2d\u5fc3\u4ee3\u7801\u7247\u6bb5");
        modelLogicNameMap.put("PSSYSCODESNIPPET", "\u7cfb\u7edf\u4ee3\u7801\u5757");
        modelLogicNameMap.put("PSDEVSLNMSDEPAPI", "\u5f00\u53d1\u65b9\u6848\u5fae\u670d\u52a1\u670d\u52a1\u90e8\u7f72");
        modelLogicNameMap.put("PSDEVSLNSYSAPI", "\u5f00\u53d1\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3");
        modelLogicNameMap.put("PSDEVSLNSYSAPP", "\u5f00\u53d1\u7cfb\u7edf\u5e94\u7528");
        modelLogicNameMap.put("PSDEVSLNMSDEPAPP", "\u5f00\u53d1\u65b9\u6848\u5fae\u670d\u52a1\u5e94\u7528\u90e8\u7f72");
        modelLogicNameMap.put("PSDEVSLNMSDEPLOY", "\u5f00\u53d1\u65b9\u6848\u5fae\u670d\u52a1\u90e8\u7f72");
        modelLogicNameMap.put("PSDCMSPLATFORMNODE", "\u4e2d\u5fc3\u5fae\u670d\u52a1\u5e73\u53f0\u8282\u70b9");
        modelLogicNameMap.put("PSDCMSPLATFORMFUNC", "\u4e2d\u5fc3\u5fae\u670d\u52a1\u5e73\u53f0\u529f\u80fd");
        modelLogicNameMap.put("PSDCMSPLATFORM", "\u4e2d\u5fc3\u5fae\u670d\u52a1\u5e73\u53f0");
        modelLogicNameMap.put("PSMSPLATFORMNODE", "\u5e73\u53f0\u5fae\u670d\u52a1\u5e73\u53f0\u8282\u70b9");
        modelLogicNameMap.put("PSMSPLATFORMFUNC", "\u5e73\u53f0\u5fae\u670d\u52a1\u5e73\u53f0\u529f\u80fd");
        modelLogicNameMap.put("PSMSPLATFORM", "\u5e73\u53f0\u5fae\u670d\u52a1\u5e73\u53f0");
        modelLogicNameMap.put("PSDEPLOYCENTER", "\u5e73\u53f0\u90e8\u7f72\u4e2d\u5fc3");
        modelLogicNameMap.put("PSCODESNIPPETTYPE", "\u5e73\u53f0\u4ee3\u7801\u7247\u6bb5\u7c7b\u578b");
        modelLogicNameMap.put("PSDCDEPLOYCENTER", "\u4e2d\u5fc3\u90e8\u7f72\u4e2d\u5fc3");
        modelLogicNameMap.put("PSWORKSHOPSERVER", "\u5e73\u53f0\u7cfb\u7edf\u5de5\u7a0b\u670d\u52a1\u5668");
        modelLogicNameMap.put("PSDCWORKSHOPSERVER", "\u4e2d\u5fc3\u5de5\u7a0b\u670d\u52a1\u5668");
        modelLogicNameMap.put("PSAPPDEVIEWREF", "\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe\u5f15\u7528");
        modelLogicNameMap.put("PSDEDATAIMPITEM", "\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u9879");
        modelLogicNameMap.put("PSDEVSLNSYSWSGIT", "\u5f00\u53d1\u7cfb\u7edf\u5de5\u7a0b\u670d\u52a1\u5668GIT\u5e93");
        modelLogicNameMap.put("PSSYSDYNAMODEL", "\u7cfb\u7edf\u52a8\u6001\u6a21\u578b\u5bf9\u8c61");
        modelLogicNameMap.put("PSSYSDYNAMODELATTR", "\u7cfb\u7edf\u52a8\u6001\u6a21\u578b\u5c5e\u6027");
        modelLogicNameMap.put("PSSYSTITLEBAR", "\u7cfb\u7edf\u6807\u9898\u680f");
        modelLogicNameMap.put("PSAPPTITLEBAR", "\u5e94\u7528\u6807\u9898\u680f");
        modelLogicNameMap.put("PSSYSVIEWLOGICPARAM", "\u89c6\u56fe\u903b\u8f91\u53c2\u6570");
        modelLogicNameMap.put("PSSYSTEM_SETTING", "\u7cfb\u7edf\u5168\u5c40\u8bbe\u7f6e");
        modelLogicNameMap.put("PSSYSAPP_UI", "\u5e94\u7528\u754c\u9762\u8bbe\u7f6e");
        modelLogicNameMap.put("PSSYSCOUNTERREF", "\u7cfb\u7edf\u8ba1\u6570\u5668\u5f15\u7528");
        modelLogicNameMap.put("PSDEGRIDEDITITEM", "\u5b9e\u4f53\u8868\u683c\u7f16\u8f91\u9879");
        modelLogicNameMap.put("PSDEGRIDDATAITEM", "\u5b9e\u4f53\u8868\u683c\u6570\u636e\u9879");
        modelLogicNameMap.put("PSACHANDLER_GRIDEDITITEM", "\u8868\u683c\u7f16\u8f91\u9879\u540e\u53f0\u5904\u7406\u5668");
        modelLogicNameMap.put("PSACHANDLER_FORMITEM", "\u8868\u5355\u9879\u540e\u53f0\u5904\u7406\u5668");
        modelLogicNameMap.put("PSCUSTOMCONTROL", "\u81ea\u5b9a\u4e49\u90e8\u4ef6");
        modelLogicNameMap.put("PSDELLCOND_GROUP", "\u5b9e\u4f53\u903b\u8f91\u7ec4\u5408\u6761\u4ef6");
        modelLogicNameMap.put("PSDELLCOND_SINGLE", "\u5b9e\u4f53\u903b\u8f91\u5355\u9879\u6761\u4ef6");
        modelLogicNameMap.put("PSDELLCOND_CUSTOM", "\u5b9e\u4f53\u903b\u8f91\u81ea\u5b9a\u4e49\u6761\u4ef6");
        modelLogicNameMap.put("PSACHANDLERACTION", "\u90e8\u4ef6\u540e\u53f0\u5904\u7406\u884c\u4e3a");
        modelLogicNameMap.put("PSDEDRBAR", "\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u680f");
        modelLogicNameMap.put("PSDEDRTAB", "\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u5206\u9875\u90e8\u4ef6");
        modelLogicNameMap.put("PSDEDRBARGROUP", "\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u680f\u5206\u7ec4");
        modelLogicNameMap.put("PSDEDRBARITEM", "\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u680f\u9879\u76ee");
        modelLogicNameMap.put("PSSYSDBPART", "\u6570\u636e\u770b\u677f\u90e8\u4ef6");
        modelLogicNameMap.put("PSCODEITEM", "\u4ee3\u7801\u8868\u9879");
        modelLogicNameMap.put("PSDEDATAEXPITEM", "\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u9879");
        modelLogicNameMap.put("PSDEDATAEXPGROUP", "\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u5206\u7ec4");
        modelLogicNameMap.put("PSDECHARTTITLE", "\u5b9e\u4f53\u56fe\u8868\u6807\u9898");
        modelLogicNameMap.put("PSDECHARTLEGEND", "\u5b9e\u4f53\u56fe\u8868\u56fe\u4f8b");
        modelLogicNameMap.put("PSDECHARTGRID", "\u5b9e\u4f53\u56fe\u8868\u76f4\u89d2\u5750\u6807\u8868\u683c");
        modelLogicNameMap.put("PSDECHARTRADAR", "\u5b9e\u4f53\u56fe\u8868\u96f7\u8fbe\u90e8\u4ef6");
        modelLogicNameMap.put("PSDECHARTPOLAR", "\u5b9e\u4f53\u56fe\u8868\u6781\u5750\u6807\u7cfb\u7ec4\u4ef6");
        modelLogicNameMap.put("PSDECHARTPARALLEL", "\u5b9e\u4f53\u56fe\u8868\u5e73\u884c\u5750\u6807\u7cfb\u7ec4\u4ef6");
        modelLogicNameMap.put("PSDECHARTSINGLE", "\u5b9e\u4f53\u56fe\u8868\u5355\u8f74\u5750\u6807\u7cfb\u7ec4\u4ef6");
        modelLogicNameMap.put("PSDECHARTGEO", "\u5b9e\u4f53\u5730\u7406\u5750\u6807\u7cfb\u7ec4\u4ef6");
        modelLogicNameMap.put("PSDECHARTCALENDAR", "\u5b9e\u4f53\u65e5\u5386\u5750\u6807\u7cfb\u7ec4\u4ef6");
        modelLogicNameMap.put("PSDECHARTDATASET", "\u5b9e\u4f53\u56fe\u8868\u6570\u636e\u96c6");
        modelLogicNameMap.put("PSDECHARTDATASETFIELD", "\u5b9e\u4f53\u56fe\u8868\u6570\u636e\u96c6\u5c5e\u6027");
        modelLogicNameMap.put("PSDECHARTDATASETGROUP", "\u5b9e\u4f53\u56fe\u8868\u6570\u636e\u96c6\u5206\u7ec4");
        modelLogicNameMap.put("PSDEUNISTATE", "\u5b9e\u4f53\u7edf\u4e00\u72b6\u6001");
        modelLogicNameMap.put("PSDEDATAVIEWDATAITEM", "\u5b9e\u4f53\u5361\u7247\u89c6\u56fe\u6570\u636e\u9879");
        modelLogicNameMap.put("PSEXPBAR", "\u5bfc\u822a\u680f");
        modelLogicNameMap.put("PSWFUIACTION", "\u5de5\u4f5c\u6d41\u754c\u9762\u884c\u4e3a");
        modelLogicNameMap.put("PSWFUAGROUP", "\u5de5\u4f5c\u6d41\u754c\u9762\u884c\u4e3a\u7ec4");
        modelLogicNameMap.put("PSWFUAGRPDETAIL", "\u5de5\u4f5c\u6d41\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u5458");
        modelLogicNameMap.put("PSVIEWPANEL", "\u89c6\u56fe\u9762\u677f");
        modelLogicNameMap.put("PSDEWIZARDPANEL", "\u5411\u5bfc\u9762\u677f");
        modelLogicNameMap.put("PSDECONTEXTMENU", "\u4e0a\u4e0b\u6587\u83dc\u5355");
        modelLogicNameMap.put("PSSYSDTSQUEUE", "\u7cfb\u7edf\u5206\u5e03\u4e8b\u52a1\u961f\u5217");
        modelLogicNameMap.put("PSDEOPPRIV", "\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6");
        modelLogicNameMap.put("PSDEREPORTPANEL", "\u5b9e\u4f53\u62a5\u8868\u9762\u677f");
        modelLogicNameMap.put("PSSYSDMVER", "\u7cfb\u7edf\u6570\u636e\u5e93\u6a21\u578b\u7248\u672c");
        modelLogicNameMap.put("PSDEACTIONPARAM", "\u5b9e\u4f53\u884c\u4e3a\u53c2\u6570");
        modelLogicNameMap.put("PSSYSCALENDAR", "\u65e5\u5386\u90e8\u4ef6");
        modelLogicNameMap.put("PSSYSCALENDARITEM", "\u65e5\u5386\u90e8\u4ef6\u9879");
        modelLogicNameMap.put("PSSYSCALENDARITEMRV", "\u65e5\u5386\u90e8\u4ef6\u9879\u89c6\u56fe");
        modelLogicNameMap.put("PSDESAMPLEDATA", "\u5b9e\u4f53\u793a\u4f8b\u6570\u636e");
        modelLogicNameMap.put("PSSYSVIEWPANELITEM_CONTAINER", "\u9762\u677f\u5bb9\u5668\u90e8\u4ef6");
        modelLogicNameMap.put("PSSYSVIEWPANELITEM_FIELD", "\u9762\u677f\u5c5e\u6027\u90e8\u4ef6");
        modelLogicNameMap.put("PSSYSVIEWPANELITEM_TABPANEL", "\u9762\u677f\u5206\u9875\u90e8\u4ef6");
        modelLogicNameMap.put("PSSYSVIEWPANELITEM_TABPAGE", "\u9762\u677f\u5206\u9875\u9762\u677f");
        modelLogicNameMap.put("PSSYSVIEWPANELITEM_CONTROL", "\u9762\u677f\u90e8\u4ef6");
        modelLogicNameMap.put("PSSYSVIEWPANELITEM_CTRLPOS", "\u9762\u677f\u90e8\u4ef6\u5360\u4f4d");
        modelLogicNameMap.put("PSSYSVIEWPANELITEM_USERCONTROL", "\u9762\u677f\u81ea\u5b9a\u4e49\u90e8\u4ef6");
        modelLogicNameMap.put("PSSYSVIEWPANELITEM_RAWITEM", "\u9762\u677f\u76f4\u63a5\u5185\u5bb9");
        modelLogicNameMap.put("PSSYSVIEWPANELITEM_BUTTON", "\u9762\u677f\u6309\u94ae");
        modelLogicNameMap.put("PSSYSVIEWPANELITEM_BUTTONLIST", "\u9762\u677f\u6309\u94ae\u5217\u8868");
        modelLogicNameMap.put("PSSYSVIEWPANELITEM_PARAM", "\u9762\u677f\u9879\u53c2\u6570");
        modelLogicNameMap.put("PSSYSVIEWPANELMODEL", "\u9762\u677f\u6a21\u578b");
        modelLogicNameMap.put("PSSYSVIEWPANELLOGIC", "\u9762\u677f\u903b\u8f91");
        modelLogicNameMap.put("PSPANELLOGICPARAM", "\u9762\u677f\u903b\u8f91\u53c2\u6570");
        modelLogicNameMap.put("PSPANELLOGICNODE", "\u9762\u677f\u903b\u8f91\u8282\u70b9");
        modelLogicNameMap.put("PSPANELLOGICLINK", "\u9762\u677f\u903b\u8f91\u8fde\u63a5");
        modelLogicNameMap.put("PSPANELLLCOND", "\u9762\u677f\u903b\u8f91\u8fde\u63a5\u6761\u4ef6");
        modelLogicNameMap.put("PSPANELLNPARAM", "\u9762\u677f\u903b\u8f91\u8282\u70b9\u53c2\u6570");
        modelLogicNameMap.put("PSPANELLLCOND_GROUP", "\u9762\u677f\u903b\u8f91\u7ec4\u5408\u6761\u4ef6");
        modelLogicNameMap.put("PSPANELLLCOND_SINGLE", "\u9762\u677f\u903b\u8f91\u5355\u9879\u6761\u4ef6");
        modelLogicNameMap.put("PSPANELLLCOND_CUSTOM", "\u9762\u677f\u903b\u8f91\u81ea\u5b9a\u4e49\u6761\u4ef6");
        modelLogicNameMap.put("PSDELISTDATAITEM", "\u5b9e\u4f53\u5217\u8868\u6570\u636e\u9879");
        modelLogicNameMap.put("PSAPPDYNADEVIEW", "\u5e94\u7528\u52a8\u6001\u5b9e\u4f53\u89c6\u56fe");
        modelLogicNameMap.put("PSAPPUTILVIEW", "\u5e94\u7528\u529f\u80fd\u89c6\u56fe");
        modelLogicNameMap.put("PSAPPPANELVIEW", "\u5e94\u7528\u9762\u677f\u89c6\u56fe");
        modelLogicNameMap.put("PSDEVSLNMSDEPFUNC", "\u5f00\u53d1\u65b9\u6848\u5fae\u670d\u52a1\u529f\u80fd\u90e8\u7f72");
        modelLogicNameMap.put("PSSYSVIEWLAYOUTPANEL", "\u89c6\u56fe\u5e03\u5c40\u9762\u677f");
        modelLogicNameMap.put("PSAPPVIEWLOGICREFVIEW", "\u89c6\u56fe\u903b\u8f91\u89c6\u56fe\u5f15\u7528");
        modelLogicNameMap.put("PSAPPVIEWENGINE", "\u89c6\u56fe\u754c\u9762\u5f15\u64ce");
        modelLogicNameMap.put("PSAPPVIEWENGINEPARAM", "\u89c6\u56fe\u754c\u9762\u5f15\u64ce\u53c2\u6570");
        modelLogicNameMap.put("PSAPPDATAENTITY", "\u5e94\u7528\u5b9e\u4f53");
        modelLogicNameMap.put("PSAPPVIEWPARAM", "\u89c6\u56fe\u53c2\u6570");
        modelLogicNameMap.put("PSAPPVIEWNAVCONTEXT", "\u89c6\u56fe\u5bfc\u822a\u4e0a\u4e0b\u6587");
        modelLogicNameMap.put("PSAPPVIEWNAVPARAM", "\u89c6\u56fe\u5bfc\u822a\u53c2\u6570");
        modelLogicNameMap.put("PSLAYOUT", "\u5e03\u5c40\u5bb9\u5668");
        modelLogicNameMap.put("PSLAYOUTPOS", "\u5e03\u5c40\u4f4d\u7f6e");
        modelLogicNameMap.put("PSAPPVIEWUIACTION", "\u5e94\u7528\u89c6\u56fe\u754c\u9762\u884c\u4e3a");
        modelLogicNameMap.put("PSCONTROLLOGIC", "\u90e8\u4ef6\u903b\u8f91");
        modelLogicNameMap.put("PSAPPUILOGIC", "\u9884\u7f6e\u89c6\u56fe\u903b\u8f91");
        modelLogicNameMap.put("PSAPPUILOGICBUILDIN", "\u9884\u7f6e\u89c6\u56fe\u903b\u8f91");
        modelLogicNameMap.put("PSDEMAPACTION", "\u5b9e\u4f53\u6620\u5c04\u884c\u4e3a");
        modelLogicNameMap.put("PSDEMAPDQ", "\u5b9e\u4f53\u6620\u5c04\u67e5\u8be2");
        modelLogicNameMap.put("PSDEMAPDS", "\u5b9e\u4f53\u6620\u5c04\u6570\u636e\u96c6\u5408");
        modelLogicNameMap.put("PSDEMAPDETAIL", "\u5b9e\u4f53\u6620\u5c04\u5c5e\u6027");
        modelLogicNameMap.put("PSTABEXPPANEL", "\u5206\u9875\u5bfc\u822a\u9762\u677f");
        modelLogicNameMap.put("PSDEDRTABPAGE", "\u5173\u7cfb\u5206\u9875\u90e8\u4ef6\u6210\u5458");
        modelLogicNameMap.put("PSPFXCODEOBJECT", "\u524d\u7aef\u6269\u5c55\u63d2\u4ef6");
        modelLogicNameMap.put("PSSFXCODEOBJECT", "\u540e\u7aef\u6269\u5c55\u63d2\u4ef6");
        modelLogicNameMap.put("PSAPPWF", "\u5e94\u7528\u5de5\u4f5c\u6d41");
        modelLogicNameMap.put("PSAPPWFVER", "\u5e94\u7528\u5de5\u4f5c\u6d41\u7248\u672c");
        modelLogicNameMap.put("PSDESERVICEAPIFIELD", "\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u5c5e\u6027");
        modelLogicNameMap.put("PSDESARS", "\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u5173\u7cfb");
        modelLogicNameMap.put("PSAPPDERS", "\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb");
        modelLogicNameMap.put("PSAPPDERSVIEW", "\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb\u89c6\u56fe");
        modelLogicNameMap.put("PSSUBSYSSADE", "\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53");
        modelLogicNameMap.put("PSSUBSYSSADERS", "\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53\u5173\u7cfb");
        modelLogicNameMap.put("PSSUBSYSSADEFIELD", "\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53\u5c5e\u6027");
        modelLogicNameMap.put("PSSYSDBSCHEME", "\u7cfb\u7edf\u6570\u636e\u5e93\u67b6\u6784");
        modelLogicNameMap.put("PSSYSDBTABLE", "\u6570\u636e\u5e93\u8868\u5bf9\u8c61");
        modelLogicNameMap.put("PSSYSDBCOLUMN", "\u6570\u636e\u5e93\u5217\u5bf9\u8c61");
        modelLogicNameMap.put("PSDESAVR", "\u5b9e\u4f53\u63a5\u53e3\u503c\u89c4\u5219");
        modelLogicNameMap.put("PSSYSRESOURCE", "\u7cfb\u7edf\u9884\u7f6e\u8d44\u6e90");
        modelLogicNameMap.put("PSSYSCONTENT", "\u7cfb\u7edf\u9884\u7f6e\u5185\u5bb9");
        modelLogicNameMap.put("PSSYSCONTENTCAT", "\u7cfb\u7edf\u5185\u5bb9\u5206\u7c7b");
        modelLogicNameMap.put("PSAPPRESOURCE", "\u5e94\u7528\u9884\u7f6e\u8d44\u6e90");
        modelLogicNameMap.put("PSAPPDEMETHOD", "\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5");
        modelLogicNameMap.put("PSAPPDEFIELD", "\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027");
        modelLogicNameMap.put("PSAPPDEUIACTION", "\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u884c\u4e3a");
        modelLogicNameMap.put("PSSYSAPPDEUIACTION", "\u5168\u5c40\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u884c\u4e3a");
        modelLogicNameMap.put("PSDEGROUPDETAIL", "\u5b9e\u4f53\u7ec4\u6210\u5458");
        modelLogicNameMap.put("PSDEGROUP", "\u5b9e\u4f53\u7ec4");
        modelLogicNameMap.put("PSDERGROUPDETAIL", "\u5b9e\u4f53\u5173\u7cfb\u7ec4\u6210\u5458");
        modelLogicNameMap.put("PSDERGROUP", "\u5b9e\u4f53\u5173\u7cfb\u7ec4");
        modelLogicNameMap.put("PSDEACTIONGROUP", "\u5b9e\u4f53\u884c\u4e3a\u7ec4");
        modelLogicNameMap.put("PSDEAGDETAIL", "\u5b9e\u4f53\u884c\u4e3a\u7ec4\u6210\u5458");
        modelLogicNameMap.put("PSSYSTESTPRJ", "\u7cfb\u7edf\u6d4b\u8bd5\u9879\u76ee");
        modelLogicNameMap.put("PSSYSTESTMODULE", "\u6d4b\u8bd5\u7528\u4f8b\u6a21\u5757");
        modelLogicNameMap.put("PSDERNN", "\u5b9e\u4f53\u591a\u5bf9\u591a\u5173\u7cfb");
        modelLogicNameMap.put("PSSYSSAHANDLER", "\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u5904\u7406");
        modelLogicNameMap.put("PSDETABLE", "\u5b9e\u4f53\u6570\u636e\u8868");
        modelLogicNameMap.put("PSSYSDEOPPRIV", "\u7cfb\u7edf\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6");
        modelLogicNameMap.put("PSAPPCOUNTER", "\u5e94\u7528\u8ba1\u6570\u5668");
        modelLogicNameMap.put("PSAPPCODELIST", "\u5e94\u7528\u4ee3\u7801\u8868");
        modelLogicNameMap.put("PSAPPMSGTEMPL", "\u5e94\u7528\u6d88\u606f\u6a21\u677f");
        modelLogicNameMap.put("PSAPPVIEWMSG", "\u5e94\u7528\u89c6\u56fe\u6d88\u606f");
        modelLogicNameMap.put("PSAPPVIEWMSGGROUP", "\u5e94\u7528\u89c6\u56fe\u6d88\u606f\u7ec4");
        modelLogicNameMap.put("PSAPPVIEWMSGGRPDETAIL", "\u5e94\u7528\u89c6\u56fe\u6d88\u606f\u7ec4\u6210\u5458");
        modelLogicNameMap.put("PSDEUILOGIC", "\u5b9e\u4f53\u754c\u9762\u903b\u8f91");
        modelLogicNameMap.put("PSAPPDELOGIC", "\u5e94\u7528\u5b9e\u4f53\u5904\u7406\u903b\u8f91");
        modelLogicNameMap.put("PSAPPDEUILOGIC", "\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u903b\u8f91");
        modelLogicNameMap.put("PSAPPDELOGICNODE", "\u5e94\u7528\u5b9e\u4f53\u903b\u8f91\u8282\u70b9");
        modelLogicNameMap.put("PSAPPDEUILOGICNODE", "\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u8282\u70b9");
        modelLogicNameMap.put("PSAPPDELOGICPARAM", "\u5e94\u7528\u5b9e\u4f53\u903b\u8f91\u53c2\u6570");
        modelLogicNameMap.put("PSAPPDELOGICLINK", "\u5e94\u7528\u5b9e\u4f53\u903b\u8f91\u8fde\u63a5");
        modelLogicNameMap.put("PSAPPDELLCOND", "\u5e94\u7528\u5b9e\u4f53\u903b\u8f91\u8fde\u63a5\u6761\u4ef6");
        modelLogicNameMap.put("PSAPPDELNPARAM", "\u5e94\u7528\u5b9e\u4f53\u903b\u8f91\u8282\u70b9\u53c2\u6570");
        modelLogicNameMap.put("PSCTRLLOGICGROUP", "\u754c\u9762\u903b\u8f91\u7ec4");
        modelLogicNameMap.put("PSCTRLLOGICGRPDETAIL", "\u754c\u9762\u903b\u8f91\u7ec4\u6210\u5458");
        modelLogicNameMap.put("PSSYSCTRLLOGICGROUP", "\u5168\u5c40\u754c\u9762\u903b\u8f91\u7ec4");
        modelLogicNameMap.put("PSSYSCTRLLOGICGRPDETAIL", "\u5168\u5c40\u754c\u9762\u903b\u8f91\u7ec4\u6210\u5458");
        modelLogicNameMap.put("PSPANELITEMLOGIC", "\u9762\u677f\u6210\u5458\u903b\u8f91\u9879");
        modelLogicNameMap.put("PSPANELENGINE", "\u9762\u677f\u754c\u9762\u5f15\u64ce");
        modelLogicNameMap.put("PSPANELENGINEPARAM", "\u9762\u677f\u754c\u9762\u5f15\u64ce\u53c2\u6570");
        modelLogicNameMap.put("PSDEUILOGIC", "\u5b9e\u4f53\u754c\u9762\u903b\u8f91");
        modelLogicNameMap.put("PSDEUILOGICPARAM", "\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u53c2\u6570");
        modelLogicNameMap.put("PSDEUILOGICNODE", "\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u8282\u70b9");
        modelLogicNameMap.put("PSDEUILOGICLINK", "\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u8fde\u63a5");
        modelLogicNameMap.put("PSDEUILNPARAM", "\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u8282\u70b9\u53c2\u6570");
        modelLogicNameMap.put("PSDEUILLCOND", "\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u8fde\u63a5\u6761\u4ef6");
        modelLogicNameMap.put("PSAPPDEUILOGIC", "\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u903b\u8f91");
        modelLogicNameMap.put("PSAPPDEUILOGICNODE", "\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u5904\u7406\u903b\u8f91\u8282\u70b9");
        modelLogicNameMap.put("PSAPPDEUILOGICPARAM", "\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u53c2\u6570");
        modelLogicNameMap.put("PSAPPDEUILOGICLINK", "\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u8fde\u63a5");
        modelLogicNameMap.put("PSAPPDEUILLCOND", "\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u8fde\u63a5\u6761\u4ef6");
        modelLogicNameMap.put("PSAPPDEUILNPARAM", "\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u8282\u70b9\u53c2\u6570");
        modelLogicNameMap.put("PSAPPDEACMODE", "\u5e94\u7528\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f");
        modelLogicNameMap.put("PSAPPDEACMODEITEM", "\u5e94\u7528\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f\u9879");
        modelLogicNameMap.put("PSEDITOR", "\u7f16\u8f91\u5668\u5bf9\u8c61");
        modelLogicNameMap.put("PSSYSMODELGROUP", "\u7cfb\u7edf\u6a21\u578b\u7ec4");
        modelLogicNameMap.put("PSSYSSEARCHSCHEME", "\u5168\u6587\u68c0\u7d22\u4f53\u7cfb");
        modelLogicNameMap.put("PSSYSSEARCHDOC", "\u5168\u6587\u68c0\u7d22\u6587\u6863");
        modelLogicNameMap.put("PSSYSSEARCHDE", "\u5168\u6587\u68c0\u7d22\u5b9e\u4f53");
        modelLogicNameMap.put("PSSYSSEARCHFIELD", "\u5168\u6587\u68c0\u7d22\u5c5e\u6027");
        modelLogicNameMap.put("PSSYSSEARCHDEFIELD", "\u5168\u6587\u68c0\u7d22\u5b9e\u4f53\u5c5e\u6027");
        modelLogicNameMap.put("PSDESEARCH", "\u5b9e\u4f53\u5168\u6587\u68c0\u7d22");
        modelLogicNameMap.put("PSDEFSEARCH", "\u5b9e\u4f53\u5c5e\u6027\u5168\u6587\u68c0\u7d22");
        modelLogicNameMap.put("PSDEBDTABLE", "\u5b9e\u4f53\u5927\u6570\u636e\u8868");
        modelLogicNameMap.put("PSSYSMAPVIEW", "\u7cfb\u7edf\u5730\u56fe\u90e8\u4ef6");
        modelLogicNameMap.put("PSSYSMAPITEM", "\u7cfb\u7edf\u5730\u56fe\u9879");
        modelLogicNameMap.put("PSAPPWFUIACTION", "\u5e94\u7528\u6d41\u7a0b\u754c\u9762\u884c\u4e3a");
        modelLogicNameMap.put("PSAPPWFVERUIACTION", "\u5e94\u7528\u6d41\u7a0b\u7248\u672c\u754c\u9762\u884c\u4e3a");
        modelLogicNameMap.put("PSAPPWFUAGROUP", "\u5e94\u7528\u6d41\u7a0b\u754c\u9762\u884c\u4e3a\u7ec4");
        modelLogicNameMap.put("PSAPPWFVERUAGROUP", "\u5e94\u7528\u6d41\u7a0b\u7248\u672c\u754c\u9762\u884c\u4e3a\u7ec4");
        modelLogicNameMap.put("PSAPPWFUAGRPDETAIL", "\u5e94\u7528\u6d41\u7a0b\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u5458");
        modelLogicNameMap.put("PSAPPWFVERUAGRPDETAIL", "\u5e94\u7528\u6d41\u7a0b\u7248\u672c\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u5458");
        modelLogicNameMap.put("PSSYSPORTLETCAT", "\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6\u5206\u7c7b");
        modelLogicNameMap.put("PSAPPPORTLET", "\u5e94\u7528\u95e8\u6237\u90e8\u4ef6");
        modelLogicNameMap.put("PSAPPPORTLETCAT", "\u5e94\u7528\u95e8\u6237\u90e8\u4ef6\u5206\u7c7b");
        modelLogicNameMap.put("PSAPPDEDRITEM", "\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb\u754c\u9762");
        modelLogicNameMap.put("PSAPPDEDRGROUP", "\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb\u754c\u9762\u5206\u7ec4");
        modelLogicNameMap.put("PSAPPDEPORTLET", "\u5e94\u7528\u5b9e\u4f53\u95e8\u6237\u90e8\u4ef6");
        modelLogicNameMap.put("PSSYSUSERROLEDATA", "\u7cfb\u7edf\u89d2\u8272\u6570\u636e\u80fd\u529b");
        modelLogicNameMap.put("PSAPPPDTVIEW", "\u5e94\u7528\u9884\u7f6e\u89c6\u56fe");
        modelLogicNameMap.put("PSDECHARTCOORDINATESYSTEM", "\u5b9e\u4f53\u56fe\u8868\u5750\u6807\u7cfb\u7edf");
        modelLogicNameMap.put("PSDECHARTGRIDXAXIS", "\u5b9e\u4f53\u56fe\u8868\u76f4\u89d2\u5750\u6807\u8868\u683cX\u8f74");
        modelLogicNameMap.put("PSDECHARTGRIDYAXIS", "\u5b9e\u4f53\u56fe\u8868\u76f4\u89d2\u5750\u6807\u8868\u683cY\u8f74");
        modelLogicNameMap.put("PSDECHARTPOLARANGLEAXIS", "\u5b9e\u4f53\u56fe\u8868\u6781\u5750\u6807\u89d2\u5ea6\u8f74");
        modelLogicNameMap.put("PSDECHARTPOLARRADIUSAXIS", "\u5b9e\u4f53\u56fe\u8868\u6781\u5750\u6807\u5f84\u5411\u8f74");
        modelLogicNameMap.put("PSDECHARTPARALLELAXIS", "\u5b9e\u4f53\u56fe\u8868\u5e73\u884c\u5750\u6807\u8f74");
        modelLogicNameMap.put("PSDECHARTSINGLEAXIS", "\u5b9e\u4f53\u56fe\u8868\u5355\u4e00\u5750\u6807\u8f74");
        modelLogicNameMap.put("PSDECHARTSERIESENCODE", "\u5b9e\u4f53\u56fe\u8868\u5e8f\u5217\u7f16\u7801");
        modelLogicNameMap.put("PSAPPDEDATAEXP", "\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa");
        modelLogicNameMap.put("PSAPPDEDATAEXPITEM", "\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u9879");
        modelLogicNameMap.put("PSAPPDEDATAEXPGROUP", "\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u5206\u7ec4");
        modelLogicNameMap.put("PSAPPDEDATAIMP", "\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u5bfc\u5165");
        modelLogicNameMap.put("PSAPPDEDATAIMPITEM", "\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u9879");
        modelLogicNameMap.put("PSAPPVALUERULE", "\u5e94\u7528\u503c\u89c4\u5219");
        modelLogicNameMap.put("PSDATAITEMPARAM", "\u6570\u636e\u9879\u53c2\u6570");
        modelLogicNameMap.put("PSDEFORMDATAITEM", "\u5b9e\u4f53\u8868\u5355\u6570\u636e\u9879");
        modelLogicNameMap.put("PSDEDATAVIEWITEM", "\u5b9e\u4f53\u5361\u7247\u89c6\u56fe\u9879");
        modelLogicNameMap.put("PSSYSPANELDATAITEM", "\u7cfb\u7edf\u9762\u677f\u6570\u636e\u9879");
        modelLogicNameMap.put("PSDEACMODEDATAITEM", "\u5b9e\u4f53\u81ea\u586b\u6570\u636e\u9879");
        modelLogicNameMap.put("PSAPPDEACMODEDATAITEM", "\u5e94\u7528\u5b9e\u4f53\u81ea\u586b\u6570\u636e\u9879");
        modelLogicNameMap.put("PSCONTROL", "\u754c\u9762\u90e8\u4ef6");
        modelLogicNameMap.put("PSDCWORKSPACE", "\u4e2d\u5fc3\u751f\u4ea7\u7ebf");
        modelLogicNameMap.put("PSDETREENODERSPARAM", "\u6811\u8282\u70b9\u5173\u7cfb\u53c2\u6570");
        modelLogicNameMap.put("PSDETREENODERSNAVCONTEXT", "\u6811\u8282\u70b9\u5173\u7cfb\u5bfc\u822a\u4e0a\u4e0b\u6587");
        modelLogicNameMap.put("PSDETREENODERSNAVPARAM", "\u6811\u8282\u70b9\u5173\u7cfb\u5bfc\u822a\u53c2\u6570");
        modelLogicNameMap.put("PSSFPUBHELP", "\u540e\u53f0\u53d1\u5e03\u76ee\u6807");
        modelLogicNameMap.put("PSPFPUBHELP", "\u524d\u7aef\u53d1\u5e03\u76ee\u6807");
        modelLogicNameMap.put("PSSFCODEPUBLISHERMACRO", "\u53d1\u5e03\u5668\u8def\u5f84\u53d8\u91cf");
        modelLogicNameMap.put("PSPFCODEPUBLISHERMACRO", "\u53d1\u5e03\u5668\u8def\u5f84\u53d8\u91cf");
        modelLogicNameMap.put("PSSFCODEPUBLISHERPARAM", "\u53d1\u5e03\u5668\u5185\u7f6e\u53d8\u91cf");
        modelLogicNameMap.put("PSPFCODEPUBLISHERPARAM", "\u53d1\u5e03\u5668\u5185\u7f6e\u53d8\u91cf");
        modelLogicNameMap.put("PSDETREEGRIDEX", "\u6811\u8868\u683c\u90e8\u4ef6");
        modelLogicNameMap.put("PSDEGANTT", "\u7518\u7279\u90e8\u4ef6");
        modelLogicNameMap.put("PSDESARSDETAIL", "\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u6210\u5458");
        modelLogicNameMap.put("PSDEGEIVR", "\u8868\u683c\u7f16\u8f91\u9879\u503c\u89c4\u5219");
        modelLogicNameMap.put("PSDEKANBAN", "\u770b\u677f\u90e8\u4ef6");
        modelLogicNameMap.put("PSSYSSEARCHBARFILTER", "\u641c\u7d22\u680f\u8fc7\u6ee4\u9879");
        modelLogicNameMap.put("PSSYSSEARCHBARQUICKSEARCH", "\u641c\u7d22\u680f\u5feb\u901f\u641c\u7d22\u9879");
        modelLogicNameMap.put("PSSYSSEARCHBARGROUP", "\u641c\u7d22\u680f\u5206\u7ec4\u9879");
        modelLogicNameMap.put("PSNAVIGATECONTEXT", "\u5bfc\u822a\u4e0a\u4e0b\u6587");
        modelLogicNameMap.put("PSNAVIGATEPARAM", "\u5bfc\u822a\u53c2\u6570");
        modelLogicNameMap.put("PSUIACTIONPARAM", "\u754c\u9762\u884c\u4e3a\u53c2\u6570");
        modelLogicNameMap.put("PSDER1NDEFMAP", "\u5b9e\u4f531:N\u5173\u7cfb\u5c5e\u6027\u6620\u5c04");
        modelLogicNameMap.put("PSDERINDEXDEFMAP", "\u5b9e\u4f53\u7d22\u5f15\u5173\u7cfb\u5c5e\u6027\u6620\u5c04");
        modelLogicNameMap.put("PSDEMETHOD", "\u5b9e\u4f53\u65b9\u6cd5");
        modelLogicNameMap.put("PSDEACTIONMETHOD", "\u5b9e\u4f53\u884c\u4e3a\u65b9\u6cd5");
        modelLogicNameMap.put("PSDEDATASETMETHOD", "\u5b9e\u4f53\u6570\u636e\u96c6\u65b9\u6cd5");
        modelLogicNameMap.put("PSDEACTIONVR", "\u5b9e\u4f53\u884c\u4e3a\u503c\u89c4\u5219");
        modelLogicNameMap.put("PSDESTATEWIZARDPANEL", "\u72b6\u6001\u5411\u5bfc\u9762\u677f");
        modelLogicNameMap.put("PSDEFLOGIC", "\u5b9e\u4f53\u5c5e\u6027\u903b\u8f91");
        modelLogicNameMap.put("PSAPPDEFLOGIC", "\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u903b\u8f91");
        modelLogicNameMap.put("PSDEFUIMODE", "\u5c5e\u6027\u754c\u9762\u6a21\u5f0f");
        modelLogicNameMap.put("PSDEFGRIDCOLUMN", "\u5c5e\u6027\u8868\u683c\u5217\u6a21\u5f0f");
        modelLogicNameMap.put("PSDEMSFIELD", "\u5b9e\u4f53\u4e3b\u72b6\u6001\u5c5e\u6027");
        modelLogicNameMap.put("PSDER_DERCUSTOM", "\u5b9e\u4f53\u5173\u7cfb\uff08\u81ea\u5b9a\u4e49\uff09");
        modelLogicNameMap.put("PSSYSSEQUENCE", "\u7cfb\u7edf\u503c\u5e8f\u5217");
        modelLogicNameMap.put("PSSYSTRANSLATOR", "\u7cfb\u7edf\u503c\u8f6c\u6362\u5668");
        modelLogicNameMap.put("PSSYSMSGQUEUE", "\u7cfb\u7edf\u6d88\u606f\u961f\u5217");
        modelLogicNameMap.put("PSSYSMSGTARGET", "\u7cfb\u7edf\u6d88\u606f\u76ee\u6807");
        modelLogicNameMap.put("PSDENOTIFY", "\u5b9e\u4f53\u901a\u77e5");
        modelLogicNameMap.put("PSDENOTIFYTARGET", "\u5b9e\u4f53\u901a\u77e5\u76ee\u6807");
        modelLogicNameMap.put("PSSYSEAIDATATYPEITEM", "\u96c6\u6210\u6570\u636e\u7c7b\u578b\u9879");
        modelLogicNameMap.put("PSSYSEAIDER", "\u96c6\u6210\u5b9e\u4f53\u5173\u7cfb\u6620\u5c04");
        modelLogicNameMap.put("PSSYSEAIDEFIELD", "\u96c6\u6210\u5b9e\u4f53\u5c5e\u6027\u6620\u5c04");
        modelLogicNameMap.put("PSSYSEAIDE", "\u96c6\u6210\u5b9e\u4f53\u6620\u5c04");
        modelLogicNameMap.put("PSSYSEAIELEMENTRE", "\u96c6\u6210\u5143\u7d20\u5143\u7d20");
        modelLogicNameMap.put("PSSYSEAIELEMENTATTR", "\u96c6\u6210\u5143\u7d20\u5c5e\u6027");
        modelLogicNameMap.put("PSSYSEAIELEMENT", "\u96c6\u6210\u5143\u7d20");
        modelLogicNameMap.put("PSSYSEAIDATATYPE", "\u96c6\u6210\u6570\u636e\u7c7b\u578b");
        modelLogicNameMap.put("PSSYSEAISCHEME", "\u5e94\u7528\u96c6\u6210\u4f53\u7cfb");
        modelLogicNameMap.put("PSSYSBIAGGCOLUMN", "\u667a\u80fd\u62a5\u8868\u805a\u5408\u6570\u636e\u5217");
        modelLogicNameMap.put("PSSYSBIAGGTABLE", "\u667a\u80fd\u62a5\u8868\u805a\u5408\u6570\u636e");
        modelLogicNameMap.put("PSSYSBICUBELEVEL", "\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53\u7ef4\u5ea6\u5c42\u7ea7");
        modelLogicNameMap.put("PSSYSBICUBEMEASURE", "\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53\u6307\u6807");
        modelLogicNameMap.put("PSSYSBICUBEDIMENSION", "\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53\u7ef4\u5ea6");
        modelLogicNameMap.put("PSSYSBILEVEL", "\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6\u5c42\u7ea7");
        modelLogicNameMap.put("PSSYSBIHIERARCHY", "\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6\u4f53\u7cfb");
        modelLogicNameMap.put("PSSYSBIDIMENSION", "\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6");
        modelLogicNameMap.put("PSSYSBICUBE", "\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53");
        modelLogicNameMap.put("PSSYSBISCHEME", "\u667a\u80fd\u62a5\u8868\u4f53\u7cfb");
        modelLogicNameMap.put("PSTHRESHOLD", "\u9608\u503c\u9879");
        modelLogicNameMap.put("PSTHRESHOLDGROUP", "\u9608\u503c\u7ec4");
        modelLogicNameMap.put("PSSYSCHARTTHEME", "\u7cfb\u7edf\u56fe\u8868\u4e3b\u9898");
        modelLogicNameMap.put("PSSYSCANVAS", "\u7cfb\u7edf\u753b\u5e03");
        modelLogicNameMap.put("PSSYSCANVASMODEL", "\u7cfb\u7edf\u753b\u5e03\u5f15\u7528\u6a21\u578b");
        modelLogicNameMap.put("PSSYSDASHBOARDLOGIC", "\u6570\u636e\u770b\u677f\u903b\u8f91");
        modelLogicNameMap.put("PSAPPMENULOGIC", "\u5e94\u7528\u83dc\u5355\u903b\u8f91");
        modelLogicNameMap.put("PSDEFORMLOGIC", "\u5b9e\u4f53\u8868\u5355\u903b\u8f91");
        modelLogicNameMap.put("PSSYSSEARCHBARLOGIC", "\u641c\u7d22\u680f\u903b\u8f91");
        modelLogicNameMap.put("PSAPPLOGIC", "\u524d\u7aef\u5e94\u7528\u903b\u8f91");
        modelLogicNameMap.put("PSDETOOLBARLOGIC", "\u5de5\u5177\u680f\u903b\u8f91");
        modelLogicNameMap.put("PSDEWIZARDLOGIC", "\u5b9e\u4f53\u5411\u5bfc\u903b\u8f91");
        modelLogicNameMap.put("PSDELISTLOGIC", "\u5b9e\u4f53\u5217\u8868\u903b\u8f91");
        modelLogicNameMap.put("PSSYSMAPLOGIC", "\u5730\u56fe\u90e8\u4ef6\u903b\u8f91");
        modelLogicNameMap.put("PSDETREELOGIC", "\u5b9e\u4f53\u6811\u89c6\u56fe\u903b\u8f91");
        modelLogicNameMap.put("PSDEDATAVIEWLOGIC", "\u5361\u7247\u89c6\u56fe\u90e8\u4ef6\u903b\u8f91");
        modelLogicNameMap.put("PSSYSCALENDARLOGIC", "\u65e5\u5386\u90e8\u4ef6\u903b\u8f91");
        modelLogicNameMap.put("PSDEGRIDLOGIC", "\u5b9e\u4f53\u8868\u683c\u903b\u8f91");
        modelLogicNameMap.put("PSDECHARTLOGIC", "\u5b9e\u4f53\u56fe\u8868\u903b\u8f91");
        modelLogicNameMap.put("PSDEDRLOGIC", "\u5b9e\u4f53\u5173\u7cfb\u90e8\u4ef6\u903b\u8f91");
        modelLogicNameMap.put("PSSYSUSECASECAT", "\u7cfb\u7edf\u7528\u4f8b\u5206\u7c7b");
        modelLogicNameMap.put("PSDETEIUPDATE", "\u6811\u8868\u7f16\u8f91\u9879\u66f4\u65b0\u6a21\u5f0f");
        modelLogicNameMap.put("PSDETEIUDETAIL", "\u6811\u8868\u7f16\u8f91\u9879\u66f4\u65b0\u6210\u5458");
        modelLogicNameMap.put("PSSYSBIREPORT", "\u667a\u80fd\u62a5\u8868");
        modelLogicNameMap.put("PSSYSBIREPORTITEM", "\u667a\u80fd\u62a5\u8868\u9879");
        modelLogicNameMap.put("PSAPPPFPLUGIN", "\u5e94\u7528\u524d\u7aef\u63d2\u4ef6");
        modelLogicNameMap.put("PSSYSAICHATAGENT", "\u7cfb\u7edfAI\u4ea4\u8c08\u4ee3\u7406");
        modelLogicNameMap.put("PSSYSAIFACTORY", "\u7cfb\u7edfAI\u5de5\u5382");
        modelLogicNameMap.put("PSSYSAIPIPELINEAGENT", "\u7cfb\u7edfAI\u751f\u4ea7\u7ebf\u4ee3\u7406");
        modelLogicNameMap.put("PSSYSAIPIPELINEJOB", "\u7cfb\u7edfAI\u751f\u4ea7\u7ebf\u4f5c\u4e1a");
        modelLogicNameMap.put("PSSYSAIPIPELINEWORKER", "\u7cfb\u7edfAI\u751f\u4ea7\u7ebf\u5de5\u4f5c\u8005");
        modelLogicNameMap.put("PSSYSAIWORKERAGENT", "\u7cfb\u7edfAI\u5de5\u4f5c\u8005\u4ee3\u7406");
        exportModelMap.put("PSSYSUNISTATE", "T_SRFPSSYSUNISTATE");
        exportModelMap.put("PSSYSERMAP", "T_SRFPSSYSERMAP");
        exportModelMap.put("PSSYSVIEWLOGIC", "T_SRFPSSYSVIEWLOGIC");
        exportModelMap.put("PSDEFIELD", "T_SRFPSDEFIELD");
        exportModelMap.put("PSPANELLOGICNODE", "T_SRFPSPANELLOGICNODE");
        exportModelMap.put("PSDELNPARAM", "T_SRFPSDELNPARAM");
        exportModelMap.put("PSAPPUTIL", "T_SRFPSAPPUTIL");
        exportModelMap.put("PSSYSDMITEM", "T_SRFPSSYSDMITEM");
        exportModelMap.put("PSSYSUSERMODE", "T_SRFPSSYSUSERMODE");
        exportModelMap.put("PSSYSTESTDATA", "T_SRFPSSYSTESTDATA");
        exportModelMap.put("PSSYSDBPART", "T_SRFPSSYSDBPART");
        exportModelMap.put("PSSYSSFCODE", "T_SRFPSSYSSFCODE");
        exportModelMap.put("PSCODELIST", "T_SRFPSCODELIST");
        exportModelMap.put("PSSUBSYSSERVICEAPI", "T_SRFPSSUBSYSSERVICEAPI");
        exportModelMap.put("PSDECHARTAXES", "T_SRFPSDECHARTAXES");
        exportModelMap.put("PSDEFDLOGIC", "T_SRFPSDEFDLOGIC");
        exportModelMap.put("PSSYSSERVICEAPI", "T_SRFPSSYSSERVICEAPI");
        exportModelMap.put("PSSYSWFMODE", "T_SRFPSSYSWFMODE");
        exportModelMap.put("PSSYSTEMMQ", "T_SRFPSSYSTEMMQ");
        exportModelMap.put("PSPANELITEMLOGIC", "T_SRFPSPANELITEMLOGIC");
        exportModelMap.put("PSDESAMPLEDATA", "T_SRFPSDESAMPLEDATA");
        exportModelMap.put("PSLANGUAGERES", "T_SRFPSLANGUAGERES");
        exportModelMap.put("PSDEUAGROUP", "T_SRFPSDEUAGROUP");
        exportModelMap.put("PSWXMENU", "T_SRFPSWXMENU");
        exportModelMap.put("PSSYSVALUERULE", "T_SRFPSSYSVALUERULE");
        exportModelMap.put("PSDEACTIONWIZARD", "T_SRFPSDEACTIONWIZARD");
        exportModelMap.put("PSDEACTIONLOGIC", "T_SRFPSDEACTIONLOGIC");
        exportModelMap.put("PSSYSPORTLET", "T_SRFPSSYSPORTLET");
        exportModelMap.put("PSDETOOLBAR", "T_SRFPSDETOOLBAR");
        exportModelMap.put("PSSYSTEMAS", "T_SRFPSSYSTEMAS");
        exportModelMap.put("PSDETOOLBAR", "T_SRFPSDETOOLBAR");
        exportModelMap.put("PSSYSBDTABLE", "T_SRFPSSYSBDTABLE");
        exportModelMap.put("PSDEACTION", "T_SRFPSDEACTION");
        exportModelMap.put("PSSYSBDCOLSET", "T_SRFPSSYSBDCOLSET");
        exportModelMap.put("PSSYSUTILDE", "T_SRFPSSYSUTILDE");
        exportModelMap.put("PSDEGEIUPDATE", "T_SRFPSDEGEIUPDATE");
        exportModelMap.put("PSDEACTIONPARAM", "T_SRFPSDEACTIONPARAM");
        exportModelMap.put("PSSYSMSGTEMPL", "T_SRFPSSYSMSGTEMPL");
        exportModelMap.put("PSDEWIZARD", "T_SRFPSDEWIZARD");
        exportModelMap.put("PSSYSDBTABLE", "T_SRFPSSYSDBTABLE");
        exportModelMap.put("PSDEMAPACTION", "T_SRFPSDEMAPACTION");
        exportModelMap.put("PSDELIST", "T_SRFPSDELIST");
        exportModelMap.put("PSDETREENODERV", "T_SRFPSDETREENODERV");
        exportModelMap.put("PSAPPFUNC", "T_SRFPSAPPFUNC");
        exportModelMap.put("PSSYSSEARCHBARITEM", "T_SRFPSSYSSEARCHBARITEM");
        exportModelMap.put("PSSYSVIEWPANELITEM", "T_SRFPSSYSVIEWPANELITEM");
        exportModelMap.put("PSSYSSFPLUGIN", "T_SRFPSSYSSFPLUGIN");
        exportModelMap.put("PSDETREENODERS", "T_SRFPSDETREENODERS");
        exportModelMap.put("PSDEFSFITEM", "T_SRFPSDEFSFITEM");
        exportModelMap.put("PSSYSUSERDR", "T_SRFPSSYSUSERDR");
        exportModelMap.put("PSSYSCOUNTER", "T_SRFPSSYSCOUNTER");
        exportModelMap.put("PSSYSWFMODE", "T_SRFPSSYSWFMODE");
        exportModelMap.put("PSSYSDATASYNCAGENT", "T_SRFPSSYSDATASYNCAGENT");
        exportModelMap.put("PSSYSCALENDARITEM", "T_SRFPSSYSCALENDARITEM");
        exportModelMap.put("PSAPPUISTYLE", "T_SRFPSAPPUISTYLE");
        exportModelMap.put("PSDEFDLOGIC", "T_SRFPSDEFDLOGIC");
        exportModelMap.put("PSSYSSQLCMD", "T_SRFPSSYSSQLCMD");
        exportModelMap.put("PSDEACTIONTEMPL", "T_SRFPSDEACTIONTEMPL");
        exportModelMap.put("PSAPPMENU", "T_SRFPSAPPMENU");
        exportModelMap.put("PSDEWIZARDFORM", "T_SRFPSDEWIZARDFORM");
        exportModelMap.put("PSAPPLOCALDE", "T_SRFPSAPPLOCALDE");
        exportModelMap.put("PSDEACMODEITEM", "T_SRFPSDEACMODEITEM");
        exportModelMap.put("PSWXMENUITEM", "T_SRFPSWXMENUITEM");
        exportModelMap.put("PSSYSBDPART", "T_SRFPSSYSBDPART");
        exportModelMap.put("PSWFLINKCOND", "T_SRFPSWFLINKCOND");
        exportModelMap.put("PSDEDRDETAIL", "T_SRFPSDEDRDETAIL");
        exportModelMap.put("PSDEFIUPDATE", "T_SRFPSDEFIUPDATE");
        exportModelMap.put("PSSYSDYNAMODEL", "T_SRFPSSYSDYNAMODEL");
        exportModelMap.put("PSDESADETAIL", "T_SRFPSDESADETAIL");
        exportModelMap.put("PSMOBAPPPACKTD", "T_SRFPSMOBAPPPACKTD");
        exportModelMap.put("PSDEDATAIMP", "T_SRFPSDEDATAIMP");
        exportModelMap.put("PSAPPWFVER", "T_SRFPSAPPWFVER");
        exportModelMap.put("PSDEMSOPPRIV", "T_SRFPSDEMSOPPRIV");
        exportModelMap.put("PSSYSBDINSTCFG", "T_SRFPSSYSBDINSTCFG");
        exportModelMap.put("PSDETREENODECOL", "T_SRFPSDETREENODECOL");
        exportModelMap.put("PSPANELENGINE", "T_SRFPSPANELENGINE");
        exportModelMap.put("PSSYSIMAGE", "T_SRFPSSYSIMAGE");
        exportModelMap.put("PSWFROLE", "T_SRFPSWFROLE");
        exportModelMap.put("PSDEFVALUERULE", "T_SRFPSDEFVALUERULE");
        exportModelMap.put("PSDERGROUP", "T_SRFPSDERGROUP");
        exportModelMap.put("PSDEDQJOIN", "T_SRFPSDEDQJOIN");
        exportModelMap.put("PSSYSCSS", "T_SRFPSSYSCSS");
        exportModelMap.put("PSDEFFORMITEM", "T_SRFPSDEFFORMITEM");
        exportModelMap.put("PSWFLINKCOND", "T_SRFPSWFLINKCOND");
        exportModelMap.put("PSWFLINK", "T_SRFPSWFLINK");
        exportModelMap.put("PSDEAWGRPDETAIL", "T_SRFPSDEAWGRPDETAIL");
        exportModelMap.put("PSWFROLE", "T_SRFPSWFROLE");
        exportModelMap.put("PSSYSCALENDAR", "T_SRFPSSYSCALENDAR");
        exportModelMap.put("PSWXMENUITEM", "T_SRFPSWXMENUITEM");
        exportModelMap.put("PSCTRLMSG", "T_SRFPSCTRLMSG");
        exportModelMap.put("PSSYSDICTCAT", "T_SRFPSSYSDICTCAT");
        exportModelMap.put("PSSYSVIEWLOGIC", "T_SRFPSSYSVIEWLOGIC");
        exportModelMap.put("PSSYSSFPLUGIN", "T_SRFPSSYSSFPLUGIN");
        exportModelMap.put("PSDECHART", "T_SRFPSDECHART");
        exportModelMap.put("PSAPPWF", "T_SRFPSAPPWF");
        exportModelMap.put("PSDEUIACTION", "T_SRFPSDEUIACTION");
        exportModelMap.put("PSWFWORKTIME", "T_SRFPSWFWORKTIME");
        exportModelMap.put("PSDEPRINT", "T_SRFPSDEPRINT");
        exportModelMap.put("PSSUBSYSSERVICEAPI", "T_SRFPSSUBSYSSERVICEAPI");
        exportModelMap.put("PSDEGEIUDETAIL", "T_SRFPSDEGEIUDETAIL");
        exportModelMap.put("PSAPPUITHEME", "T_SRFPSAPPUITHEME");
        exportModelMap.put("PSDEUIACTION", "T_SRFPSDEUIACTION");
        exportModelMap.put("PSSYSIMAGE", "T_SRFPSSYSIMAGE");
        exportModelMap.put("PSWORKFLOW", "T_SRFPSWORKFLOW");
        exportModelMap.put("PSSYSTITLEBAR", "T_SRFPSSYSTITLEBAR");
        exportModelMap.put("PSCTRLMSGITEM", "T_SRFPSCTRLMSGITEM");
        exportModelMap.put("PSSYSDMVER", "T_SRFPSSYSDMVER");
        exportModelMap.put("PSDELLCOND", "T_SRFPSDELLCOND");
        exportModelMap.put("PSWFVERSION", "T_SRFPSWFVERSION");
        exportModelMap.put("PSPANELLLCOND", "T_SRFPSPANELLLCOND");
        exportModelMap.put("PSDEDBCFG", "T_SRFPSDEDBCFG");
        exportModelMap.put("PSAPPMODULE", "T_SRFPSAPPMODULE");
        exportModelMap.put("PSDEVIEWLOGIC", "T_SRFPSDEVIEWLOGIC");
        exportModelMap.put("PSWXACCOUNT", "T_SRFPSWXACCOUNT");
        exportModelMap.put("PSDEOPPRIV", "T_SRFPSDEOPPRIV");
        exportModelMap.put("PSAPPUTILPAGE", "T_SRFPSAPPUTILPAGE");
        exportModelMap.put("PSDEOPPRIV", "T_SRFPSDEOPPRIV");
        exportModelMap.put("PSSYSCALENDARITEMRV", "T_SRFPSSYSCALENDARITEMRV");
        exportModelMap.put("PSSYSSQLCMDSQL", "T_SRFPSSYSSQLCMDSQL");
        exportModelMap.put("PSDEDATARELATION", "T_SRFPSDEDATARELATION");
        exportModelMap.put("PSDETABLE", "T_SRFPSDETABLE");
        exportModelMap.put("PSDESAMPLEDATAREF", "T_SRFPSDESAMPLEDATAREF");
        exportModelMap.put("PSSYSBDSCHEME", "T_SRFPSSYSBDSCHEME");
        exportModelMap.put("PSDEMAPDQ", "T_SRFPSDEMAPDQ");
        exportModelMap.put("PSSYSUNIT", "T_SRFPSSYSUNIT");
        exportModelMap.put("PSDEDRITEM", "T_SRFPSDEDRITEM");
        exportModelMap.put("PSSYSTCINPUT", "T_SRFPSSYSTCINPUT");
        exportModelMap.put("PSACHANDLERACTION", "T_SRFPSACHANDLERACTION");
        exportModelMap.put("PSSYSBACKSERVICE", "T_SRFPSSYSBACKSERVICE");
        exportModelMap.put("PSDEUAGRPDETAIL", "T_SRFPSDEUAGRPDETAIL");
        exportModelMap.put("PSLANGUAGE", "T_SRFPSLANGUAGE");
        exportModelMap.put("PSDETBITEM", "T_SRFPSDETBITEM");
        exportModelMap.put("PSDELOGIC", "T_SRFPSDELOGIC");
        exportModelMap.put("PSDECHARTPARAM", "T_SRFPSDECHARTPARAM");
        exportModelMap.put("PSDEVIEWRV", "T_SRFPSDEVIEWRV");
        exportModelMap.put("PSSYSUNIRES", "T_SRFPSSYSUNIRES");
        exportModelMap.put("PSDEDSCODE", "T_SRFPSDEDSCODE");
        exportModelMap.put("PSDETREEVIEW", "T_SRFPSDETREEVIEW");
        exportModelMap.put("PSSYSERMAPNODE", "T_SRFPSSYSERMAPNODE");
        exportModelMap.put("PSSYSDBVALUEOP", "T_SRFPSSYSDBVALUEOP");
        exportModelMap.put("PSDEGRIDCOL", "T_SRFPSDEGRIDCOL");
        exportModelMap.put("PSDEFDTCOL", "T_SRFPSDEFDTCOL");
        exportModelMap.put("PSSYSDELOGICNODE", "T_SRFPSSYSDELOGICNODE");
        exportModelMap.put("PSSYSUNIT", "T_SRFPSSYSUNIT");
        exportModelMap.put("PSSYSPORTLET", "T_SRFPSSYSPORTLET");
        exportModelMap.put("PSSYSBDMODULE", "T_SRFPSSYSBDMODULE");
        exportModelMap.put("PSDETREEVIEW", "T_SRFPSDETREEVIEW");
        exportModelMap.put("PSSYSTEMDBCFG", "T_SRFPSSYSTEMDBCFG");
        exportModelMap.put("PSSYSDYNAMODEL", "T_SRFPSSYSDYNAMODEL");
        exportModelMap.put("PSDEDQCODEEXP", "T_SRFPSDEDQCODEEXP");
        exportModelMap.put("PSSUBSYSSADETAIL", "T_SRFPSSUBSYSSADETAIL");
        exportModelMap.put("PSDEDSGRPPARAM", "T_SRFPSDEDSGRPPARAM");
        exportModelMap.put("PSDEREPORT", "T_SRFPSDEREPORT");
        exportModelMap.put("PSSYSCOUNTERITEM", "T_SRFPSSYSCOUNTERITEM");
        exportModelMap.put("PSSYSDBSCHEME", "T_SRFPSSYSDBSCHEME");
        exportModelMap.put("PSDEMAINSTATE", "T_SRFPSDEMAINSTATE");
        exportModelMap.put("PSDEMAINSTATERS", "T_SRFPSDEMAINSTATERS");
        exportModelMap.put("PSDEOPPRIV", "T_SRFPSDEOPPRIV");
        exportModelMap.put("PSWXACCOUNT", "T_SRFPSWXACCOUNT");
        exportModelMap.put("PSSYSPDTVIEW", "T_SRFPSSYSPDTVIEW");
        exportModelMap.put("PSSYSPFPLUGIN", "T_SRFPSSYSPFPLUGIN");
        exportModelMap.put("PSDEDTSQUEUE", "T_SRFPSDEDTSQUEUE");
        exportModelMap.put("PSWFLINKROLE", "T_SRFPSWFLINKROLE");
        exportModelMap.put("PSDEFORMDETAIL", "T_SRFPSDEFORMDETAIL");
        exportModelMap.put("PSSYSUSERDR", "T_SRFPSSYSUSERDR");
        exportModelMap.put("PSSYSCSSCAT", "T_SRFPSSYSCSSCAT");
        exportModelMap.put("PSSYSVIEWPANEL", "T_SRFPSSYSVIEWPANEL");
        exportModelMap.put("PSDETREECOL", "T_SRFPSDETREECOL");
        exportModelMap.put("PSAPPPVPART", "T_SRFPSAPPPVPART");
        exportModelMap.put("PSWFPROCSUBWF", "T_SRFPSWFPROCSUBWF");
        exportModelMap.put("PSSYSDICTCAT", "T_SRFPSSYSDICTCAT");
        exportModelMap.put("PSSYSVIEWPANELMODEL", "T_SRFPSSYSVIEWPANELMODEL");
        exportModelMap.put("PSDEMSACTION", "T_SRFPSDEMSACTION");
        exportModelMap.put("PSSYSSAHANDLER", "T_SRFPSSYSSAHANDLER");
        exportModelMap.put("PSSYSDBPART", "T_SRFPSSYSDBPART");
        exportModelMap.put("PSDEFVRCOND", "T_SRFPSDEFVRCOND");
        exportModelMap.put("PSDELOGICPARAM", "T_SRFPSDELOGICPARAM");
        exportModelMap.put("PSSYSWFSETTING", "T_SRFPSSYSWFSETTING");
        exportModelMap.put("PSAPPPVPART", "T_SRFPSAPPPVPART");
        exportModelMap.put("PSDEDATAEXP", "T_SRFPSDEDATAEXP");
        exportModelMap.put("PSSYSTDITEM", "T_SRFPSSYSTDITEM");
        exportModelMap.put("PSDEUAGROUP", "T_SRFPSDEUAGROUP");
        exportModelMap.put("PSSYSDBCOLUMN", "T_SRFPSSYSDBCOLUMN");
        exportModelMap.put("PSDATAENTITY", "T_SRFPSDATAENTITY");
        exportModelMap.put("PSMOBAPPPACK", "T_SRFPSMOBAPPPACK");
        exportModelMap.put("PSDERDEFMAP", "T_SRFPSDERDEFMAP");
        exportModelMap.put("PSDEUTILDE", "T_SRFPSDEUTILDE");
        exportModelMap.put("PSSYSPORTLET", "T_SRFPSSYSPORTLET");
        exportModelMap.put("PSWFDE", "T_SRFPSWFDE");
        exportModelMap.put("PSDEGRIDCOL", "T_SRFPSDEGRIDCOL");
        exportModelMap.put("PSSYSCODESNIPPET", "T_SRFPSSYSCODESNIPPET");
        exportModelMap.put("PSDEDSDQ", "T_SRFPSDEDSDQ");
        exportModelMap.put("PSSYSEDITORSTYLE", "T_SRFPSSYSEDITORSTYLE");
        exportModelMap.put("PSSYSSFPUB", "T_SRFPSSYSSFPUB");
        exportModelMap.put("PSDELISTITEM", "T_SRFPSDELISTITEM");
        exportModelMap.put("PSSYSSFPUBPKG", "T_SRFPSSYSSFPUBPKG");
        exportModelMap.put("PSWFPROCPARAM", "T_SRFPSWFPROCPARAM");
        exportModelMap.put("PSSYSDASHBOARD", "T_SRFPSSYSDASHBOARD");
        exportModelMap.put("PSSYSMODELGROUP", "T_SRFPSSYSMODELGROUP");
        exportModelMap.put("PSDEDBIDXFIELD", "T_SRFPSDEDBIDXFIELD");
        exportModelMap.put("PSSYSVIEWPANEL", "T_SRFPSSYSVIEWPANEL");
        exportModelMap.put("PSDEDBINDEX", "T_SRFPSDEDBINDEX");
        exportModelMap.put("PSDEMAPDETAIL", "T_SRFPSDEMAPDETAIL");
        exportModelMap.put("PSDEACTIONTEMPL", "T_SRFPSDEACTIONTEMPL");
        exportModelMap.put("PSDETBITEM", "T_SRFPSDETBITEM");
        exportModelMap.put("PSSYSDBVF", "T_SRFPSSYSDBVF");
        exportModelMap.put("PSSYSDBVFCODE", "T_SRFPSSYSDBVFCODE");
        exportModelMap.put("PSDEFIVR", "T_SRFPSDEFIVR");
        exportModelMap.put("PSSYSBDTABLEDE", "T_SRFPSSYSBDTABLEDE");
        exportModelMap.put("PSSYSCOUNTER", "T_SRFPSSYSCOUNTER");
        exportModelMap.put("PSLANGUAGEITEM", "T_SRFPSLANGUAGEITEM");
        exportModelMap.put("PSDESERVICEAPI", "T_SRFPSDESERVICEAPI");
        exportModelMap.put("PSCODEITEM", "T_SRFPSCODEITEM");
        exportModelMap.put("PSVIEWMSGGROUP", "T_SRFPSVIEWMSGGROUP");
        exportModelMap.put("PSWFSUBWF", "T_SRFPSWFSUBWF");
        exportModelMap.put("PSDEGRID", "T_SRFPSDEGRID");
        exportModelMap.put("PSACHANDLER", "T_SRFPSACHANDLER");
        exportModelMap.put("PSSYSBDCOLUMN", "T_SRFPSSYSBDCOLUMN");
        exportModelMap.put("PSWXMENUFUNC", "T_SRFPSWXMENUFUNC");
        exportModelMap.put("PSACHANDLER", "T_SRFPSACHANDLER");
        exportModelMap.put("PSMOBAPPSTARTPAGE", "T_SRFPSMOBAPPSTARTPAGE");
        exportModelMap.put("PSDEDATAIMPITEM", "T_SRFPSDEDATAIMPITEM");
        exportModelMap.put("PSSYSPFPITEMPL", "T_SRFPSSYSPFPITEMPL");
        exportModelMap.put("PSAPPTITLEBAR", "T_SRFPSAPPTITLEBAR");
        exportModelMap.put("PSDELOGICNODE", "T_SRFPSDELOGICNODE");
        exportModelMap.put("PSPANELLOGICPARAM", "T_SRFPSPANELLOGICPARAM");
        exportModelMap.put("PSSYSTESTCASE", "T_SRFPSSYSTESTCASE");
        exportModelMap.put("PSDEDATAVIEW", "T_SRFPSDEDATAVIEW");
        exportModelMap.put("PSVIEWMSG", "T_SRFPSVIEWMSG");
        exportModelMap.put("PSDEDATAQUERY", "T_SRFPSDEDATAQUERY");
        exportModelMap.put("PSDEFINPUTTIP", "T_SRFPSDEFINPUTTIP");
        exportModelMap.put("PSSYSPDTVIEW", "T_SRFPSSYSPDTVIEW");
        exportModelMap.put("PSSYSTESTDATA", "T_SRFPSSYSTESTDATA");
        exportModelMap.put("PSDETREENODE", "T_SRFPSDETREENODE");
        exportModelMap.put("PSAPPMENUITEM", "T_SRFPSAPPMENUITEM");
        exportModelMap.put("PSSYSBDTABLEDER", "T_SRFPSSYSBDTABLEDER");
        exportModelMap.put("PSSYSBDTABLERS", "T_SRFPSSYSBDTABLERS");
        exportModelMap.put("PSSYSREF", "T_SRFPSSYSREF");
        exportModelMap.put("PSCODEITEM", "T_SRFPSCODEITEM");
        exportModelMap.put("PSWFUTILUIACTION", "T_SRFPSWFUTILUIACTION");
        exportModelMap.put("PSAPPMENUITEM", "T_SRFPSAPPMENUITEM");
        exportModelMap.put("PSDEUIACTION", "T_SRFPSDEUIACTION");
        exportModelMap.put("PSLANGUAGERES", "T_SRFPSLANGUAGERES");
        exportModelMap.put("PSDEDQJOIN", "T_SRFPSDEDQJOIN");
        exportModelMap.put("PSSYSDASHBOARD", "T_SRFPSSYSDASHBOARD");
        exportModelMap.put("PSDEFVRCOND", "T_SRFPSDEFVRCOND");
        exportModelMap.put("PSSYSSFPITEMPL", "T_SRFPSSYSSFPITEMPL");
        exportModelMap.put("PSSYSCSS", "T_SRFPSSYSCSS");
        exportModelMap.put("PSWORKFLOW", "T_SRFPSWORKFLOW");
        exportModelMap.put("PSSYSTEMRUN", "T_SRFPSSYSTEMRUN");
        exportModelMap.put("PSPANELLOGICLINK", "T_SRFPSPANELLOGICLINK");
        exportModelMap.put("PSSYSSEARCHBAR", "T_SRFPSSYSSEARCHBAR");
        exportModelMap.put("PSDEDATASET", "T_SRFPSDEDATASET");
        exportModelMap.put("PSSYSMSGTEMPL", "T_SRFPSSYSMSGTEMPL");
        exportModelMap.put("PSDEFORMDETAIL", "T_SRFPSDEFORMDETAIL");
        exportModelMap.put("PSDEFORM", "T_SRFPSDEFORM");
        exportModelMap.put("PSWFUTILUIACTION", "T_SRFPSWFUTILUIACTION");
        exportModelMap.put("PSSYSDELOGICNODE", "T_SRFPSSYSDELOGICNODE");
        exportModelMap.put("PSDEREPITEM", "T_SRFPSDEREPITEM");
        exportModelMap.put("PSSYSDYNAMODELATTR", "T_SRFPSSYSDYNAMODELATTR");
        exportModelMap.put("PSSYSCSSCAT", "T_SRFPSSYSCSSCAT");
        exportModelMap.put("PSACHANDLER", "T_SRFPSACHANDLER");
        exportModelMap.put("PSSYSDASHBOARD", "T_SRFPSSYSDASHBOARD");
        exportModelMap.put("PSSYSBDSCHEME", "T_SRFPSSYSBDSCHEME");
        exportModelMap.put("PSAPPPKG", "T_SRFPSAPPPKG");
        exportModelMap.put("PSDELLCOND", "T_SRFPSDELLCOND");
        exportModelMap.put("PSMODULE", "T_SRFPSMODULE");
        exportModelMap.put("PSDEMAPDS", "T_SRFPSDEMAPDS");
        exportModelMap.put("PSDEAWGROUP", "T_SRFPSDEAWGROUP");
        exportModelMap.put("PSVIEWWIZARDGROUP", "T_SRFPSVIEWWIZARDGROUP");
        exportModelMap.put("PSPANELITEMLOGIC", "T_SRFPSPANELITEMLOGIC");
        exportModelMap.put("PSDEMAP", "T_SRFPSDEMAP");
        exportModelMap.put("PSDEGROUP", "T_SRFPSDEGROUP");
        exportModelMap.put("PSWXENTAPP", "T_SRFPSWXENTAPP");
        exportModelMap.put("PSDEDATASYNC", "T_SRFPSDEDATASYNC");
        exportModelMap.put("PSAPPLAN", "T_SRFPSAPPLAN");
        exportModelMap.put("PSSYSSAHANDLER", "T_SRFPSSYSSAHANDLER");
        exportModelMap.put("PSSYSERMAP", "T_SRFPSSYSERMAP");
        exportModelMap.put("PSDEAWITEM", "T_SRFPSDEAWITEM");
        exportModelMap.put("PSDEDRGROUP", "T_SRFPSDEDRGROUP");
        exportModelMap.put("PSPANELLLCOND", "T_SRFPSPANELLLCOND");
        exportModelMap.put("PSSYSUSERROLERES", "T_SRFPSSYSUSERROLERES");
        exportModelMap.put("PSSYSUSERROLEDATA", "T_SRFPSSYSUSERROLEDATA");
        exportModelMap.put("PSDEDQCOND", "T_SRFPSDEDQCOND");
        exportModelMap.put("PSDEVIEWBASE", "T_SRFPSDEVIEWBASE");
        exportModelMap.put("PSDETOOLBAR", "T_SRFPSDETOOLBAR");
        exportModelMap.put("PSSYSVIEWLOGICPARAM", "T_SRFPSSYSVIEWLOGICPARAM");
        exportModelMap.put("PSSYSUNISTATE", "T_SRFPSSYSUNISTATE");
        exportModelMap.put("PSDEFIUDETAIL", "T_SRFPSDEFIUDETAIL");
        exportModelMap.put("PSDEUSERROLE", "T_SRFPSDEUSERROLE");
        exportModelMap.put("PSDEDQCOND", "T_SRFPSDEDQCOND");
        exportModelMap.put("PSSYSAPP", "T_SRFPSSYSAPP");
        exportModelMap.put("PSSYSTCASSERT", "T_SRFPSSYSTCASSERT");
        exportModelMap.put("PSVIEWMSGGRPDETAIL", "T_SRFPSVIEWMSGGRPDETAIL");
        exportModelMap.put("PSDEDQCODE", "T_SRFPSDEDQCODE");
        exportModelMap.put("PSDELOGICLINK", "T_SRFPSDELOGICLINK");
        exportModelMap.put("PSWFPROCROLE", "T_SRFPSWFPROCROLE");
        exportModelMap.put("PSSYSVIEWPANELLOGIC", "T_SRFPSSYSVIEWPANELLOGIC");
        exportModelMap.put("PSSYSCALENDAR", "T_SRFPSSYSCALENDAR");
        exportModelMap.put("PSSYSVIEWPANELITEM", "T_SRFPSSYSVIEWPANELITEM");
        exportModelMap.put("PSAPPDEVIEW", "V_PSAPPDEVIEW");
        exportModelMap.put("PSAPPDYNADEVIEW", "V_PSAPPDYNADEVIEW");
        exportModelMap.put("PSAPPINDEXVIEW", "V_PSAPPINDEXVIEW");
        exportModelMap.put("PSAPPPANELVIEW", "V_PSAPPPANELVIEW");
        exportModelMap.put("PSAPPPORTALVIEW", "V_PSAPPPORTALVIEW");
        exportModelMap.put("PSAPPUTILVIEW", "V_PSAPPUTILVIEW");
        exportModelMap.put("PSDEUAGROUP", "T_SRFPSDEUAGROUP");
        exportModelMap.put("PSDEDQCODECOND", "T_SRFPSDEDQCODECOND");
        exportModelMap.put("PSSYSFILE", "T_SRFPSSYSFILE");
        exportModelMap.put("PSAPPPDTVIEW", "T_SRFPSAPPPDTVIEW");
        exportModelMap.put("PSWFPROCESS", "T_SRFPSWFPROCESS");
        exportModelMap.put("PSDEVIEWENGINE", "T_SRFPSDEVIEWENGINE");
        exportModelMap.put("PSPANELLNPARAM", "T_SRFPSPANELLNPARAM");
        exportModelMap.put("PSDEFORMRF", "T_SRFPSDEFORMRF");
        exportModelMap.put("PSDEOPPRIVROLE", "T_SRFPSDEOPPRIVROLE");
        exportModelMap.put("PSAPPUSERMODE", "T_SRFPSAPPUSERMODE");
        exportModelMap.put("PSSUBVIEWTYPE", "T_SRFPSSUBVIEWTYPE");
        exportModelMap.put("PSSYSSERVICEAPI", "T_SRFPSSYSSERVICEAPI");
        exportModelMap.put("PSDERGROUPDETAIL", "T_SRFPSDERGROUPDETAIL");
        exportModelMap.put("PSSYSCALENDAR", "T_SRFPSSYSCALENDAR");
        exportModelMap.put("PSWXLOGIC", "T_SRFPSWXLOGIC");
        exportModelMap.put("PSDEWIZARDSTEP", "T_SRFPSDEWIZARDSTEP");
        exportModelMap.put("PSDEACMODE", "T_SRFPSDEACMODE");
        exportModelMap.put("PSMODULE", "T_SRFPSMODULE");
        exportModelMap.put("PSDELISTITEM", "T_SRFPSDELISTITEM");
        exportModelMap.put("PSDEVIEWCTRL", "T_SRFPSDEVIEWCTRL");
        exportModelMap.put("PSDER", "T_SRFPSDER");
        exportModelMap.put("PSDEDSPARAM", "T_SRFPSDEDSPARAM");
        exportModelMap.put("PSDEFGROUP", "T_SRFPSDEFGROUP");
        exportModelMap.put("PSDEFGROUPDETAIL", "T_SRFPSDEFGROUPDETAIL");
        exportModelMap.put("PSDESARS", "T_SRFPSDESARS");
        exportModelMap.put("PSAPPDERS", "T_SRFPSAPPDERS");
        exportModelMap.put("PSAPPDERSVIEW", "T_SRFPSAPPDERSVIEW");
        exportModelMap.put("PSSUBSYSSADE", "T_SRFPSSUBSYSSADE");
        exportModelMap.put("PSSUBSYSSADEFIELD", "T_SRFPSSUBSYSSADEFIELD");
        exportModelMap.put("PSSUBSYSSADERS", "T_SRFPSSUBSYSSADERS");
        exportModelMap.put("PSSYSOPPRIV", "T_SRFPSSYSOPPRIV");
        exportModelMap.put("PSSYSDBPROC", "T_SRFPSSYSDBPROC");
        exportModelMap.put("PSSYSDBPROCPARAM", "T_SRFPSSYSDBPROCPARAM");
        exportModelMap.put("PSSYSSAMPLEVALUE", "T_SRFPSSYSSAMPLEVALUE");
        exportModelMap.put("PSDESAVR", "T_SRFPSDESAVR");
        exportModelMap.put("PSSYSCONTENT", "T_SRFPSSYSCONTENT");
        exportModelMap.put("PSSYSRESOURCE", "T_SRFPSSYSRESOURCE");
        exportModelMap.put("PSAPPSTORYBOARD", "T_SRFPSAPPSTORYBOARD");
        exportModelMap.put("PSAPPSBITEMRS", "T_SRFPSAPPSBITEMRS");
        exportModelMap.put("PSAPPSBITEM", "T_SRFPSAPPSBITEM");
        exportModelMap.put("PSAPPRESOURCE", "T_SRFPSAPPRESOURCE");
        exportModelMap.put("PSSYSREQITEM", "T_SRFPSSYSREQITEM");
        exportModelMap.put("PSSYSREQITEMDATA", "T_SRFPSSYSREQITEMDATA");
        exportModelMap.put("PSSYSREQITEMHIS", "T_SRFPSSYSREQITEMHIS");
        exportModelMap.put("PSSYSREQMODULE", "T_SRFPSSYSREQMODULE");
        exportModelMap.put("PSSYSCONTENTCAT", "T_SRFPSSYSCONTENTCAT");
        exportModelMap.put("PSSYSACTOR", "T_SRFPSSYSACTOR");
        exportModelMap.put("PSSYSUSERCASE", "T_SRFPSSYSUSERCASE");
        exportModelMap.put("PSSYSUSERCASERS", "T_SRFPSSYSUSERCASERS");
        exportModelMap.put("PSSYSUCMAP", "T_SRFPSSYSUCMAP");
        exportModelMap.put("PSSYSUCMAPNODE", "T_SRFPSSYSUCMAPNODE");
        exportModelMap.put("PSSYSTESTPRJ", "T_SRFPSSYSTESTPRJ");
        exportModelMap.put("PSSYSTESTMODULE", "T_SRFPSSYSTESTMODULE");
        exportModelMap.put("PSHELPPRJ", "T_SRFPSHELPPRJ");
        exportModelMap.put("PSHELPRESOURCE", "T_SRFPSHELPRESOURCE");
        exportModelMap.put("PSHELPMODULE", "T_SRFPSHELPMODULE");
        exportModelMap.put("PSHELPARTICLE", "T_SRFPSHELPARTICLE");
        exportModelMap.put("PSHELPSECTION", "T_SRFPSHELPSECTION");
        exportModelMap.put("PSCTRLLOGICGROUP", "T_SRFPSCTRLLOGICGROUP");
        exportModelMap.put("PSCTRLLOGICGRPDETAIL", "T_SRFPSCTRLLOGICGRPDETAIL");
        exportModelMap.put("PSSYSSEARCHSCHEME", "T_SRFPSSYSSEARCHSCHEME");
        exportModelMap.put("PSSYSSEARCHDOC", "T_SRFPSSYSSEARCHDOC");
        exportModelMap.put("PSSYSSEARCHFIELD", "T_SRFPSSYSSEARCHFIELD");
        exportModelMap.put("PSSYSSEARCHDE", "T_SRFPSSYSSEARCHDE");
        exportModelMap.put("PSSYSSEARCHDEFIELD", "T_SRFPSSYSSEARCHDEFIELD");
        exportModelMap.put("PSSYSMAPVIEW", "T_SRFPSSYSMAPVIEW");
        exportModelMap.put("PSSYSMAPITEM", "T_SRFPSSYSMAPITEM");
        exportModelMap.put("PSSYSPORTLETCAT", "T_SRFPSSYSPORTLETCAT");
        exportModelMap.put("PSAPPPORTLET", "T_SRFPSAPPPORTLET");
        exportModelMap.put("PSSYSDEFTYPE", "T_SRFPSSYSDEFTYPE");
        exportModelMap.put("PSSYSWFCAT", "T_SRFPSSYSWFCAT");
        exportModelMap.put("PSAPPSTORYBOARD", "T_SRFPSAPPSTORYBOARD");
        exportModelMap.put("PSAPPSBITEM", "T_SRFPSAPPSBITEM");
        exportModelMap.put("PSAPPSBITEMRS", "T_SRFPSAPPSBITEMRS");
        exportModelMap.put("PSDEGEIVR", "T_SRFPSDEGEIVR");
        exportModelMap.put("PSDEACTIONVR", "T_SRFPSDEACTIONVR");
        exportModelMap.put("PSDEGROUPDETAIL", "T_SRFPSDEGROUPDETAIL");
        exportModelMap.put("PSDEAGDETAIL", "T_SRFPSDEAGDETAIL");
        exportModelMap.put("PSDEACTIONGROUP", "T_SRFPSDEACTIONGROUP");
        exportModelMap.put("PSDEFINPUTTIPSET", "T_SRFPSDEFINPUTTIPSET");
        exportModelMap.put("PSSYSMODELFOLDER", "T_SRFPSSYSMODELFOLDER");
        exportModelMap.put("PSSYSMODELFOLDERITEM", "T_SRFPSSYSMODELFOLDERITEM");
        exportModelMap.put("PSDEMSFIELD", "T_SRFPSDEMSFIELD");
        exportModelMap.put("PSSYSSEQUENCE", "T_SRFPSSYSSEQUENCE");
        exportModelMap.put("PSSYSTRANSLATOR", "T_SRFPSSYSTRANSLATOR");
        exportModelMap.put("PSSYSMSGQUEUE", "T_SRFPSSYSMSGQUEUE");
        exportModelMap.put("PSSYSMSGTARGET", "T_SRFPSSYSMSGTARGET");
        exportModelMap.put("PSDENOTIFY", "T_SRFPSDENOTIFY");
        exportModelMap.put("PSDENOTIFYTARGET", "T_SRFPSDENOTIFYTARGET");
        exportModelMap.put("PSSYSEAIDATATYPEITEM", "T_SRFPSSYSEAIDATATYPEITEM");
        exportModelMap.put("PSSYSEAIDER", "T_SRFPSSYSEAIDER");
        exportModelMap.put("PSSYSEAIDEFIELD", "T_SRFPSSYSEAIDEFIELD");
        exportModelMap.put("PSSYSEAIDE", "T_SRFPSSYSEAIDE");
        exportModelMap.put("PSSYSEAIELEMENTRE", "T_SRFPSSYSEAIELEMENTRE");
        exportModelMap.put("PSSYSEAIELEMENTATTR", "T_SRFPSSYSEAIELEMENTATTR");
        exportModelMap.put("PSSYSEAIELEMENT", "T_SRFPSSYSEAIELEMENT");
        exportModelMap.put("PSSYSEAIDATATYPE", "T_SRFPSSYSEAIDATATYPE");
        exportModelMap.put("PSSYSEAISCHEME", "T_SRFPSSYSEAISCHEME");
        exportModelMap.put("PSSYSBIAGGCOLUMN", "T_SRFPSSYSBIAGGCOLUMN");
        exportModelMap.put("PSSYSBIAGGTABLE", "T_SRFPSSYSBIAGGTABLE");
        exportModelMap.put("PSSYSBICUBELEVEL", "T_SRFPSSYSBICUBELEVEL");
        exportModelMap.put("PSSYSBICUBEMEASURE", "T_SRFPSSYSBICUBEMEASURE");
        exportModelMap.put("PSSYSBICUBEDIMENSION", "T_SRFPSSYSBICUBEDIMENSION");
        exportModelMap.put("PSSYSBILEVEL", "T_SRFPSSYSBILEVEL");
        exportModelMap.put("PSSYSBIHIERARCHY", "T_SRFPSSYSBIHIERARCHY");
        exportModelMap.put("PSSYSBIDIMENSION", "T_SRFPSSYSBIDIMENSION");
        exportModelMap.put("PSSYSBICUBE", "T_SRFPSSYSBICUBE");
        exportModelMap.put("PSSYSBISCHEME", "T_SRFPSSYSBISCHEME");
        exportModelMap.put("PSTHRESHOLD", "T_SRFPSTHRESHOLD");
        exportModelMap.put("PSTHRESHOLDGROUP", "T_SRFPSTHRESHOLDGROUP");
        exportModelMap.put("PSSYSCHARTTHEME", "T_SRFPSSYSCHARTTHEME");
        exportModelMap.put("PSSYSCANVAS", "T_SRFPSSYSCANVAS");
        exportModelMap.put("PSSYSCANVASMODEL", "T_SRFPSSYSCANVASMODEL");
        exportModelMap.put("PSDEVRGROUP", "T_SRFPSDEVRGROUP");
        exportModelMap.put("PSDEVRGRPDETAIL", "T_SRFPSDEVRGRPDETAIL");
        exportModelMap.put("PSSYSDASHBOARDLOGIC", "T_SRFPSSYSDASHBOARDLOGIC");
        exportModelMap.put("PSAPPMENULOGIC", "T_SRFPSAPPMENULOGIC");
        exportModelMap.put("PSDEFORMLOGIC", "T_SRFPSDEFORMLOGIC");
        exportModelMap.put("PSSYSSEARCHBARLOGIC", "T_SRFPSSYSSEARCHBARLOGIC");
        exportModelMap.put("PSAPPLOGIC", "T_SRFPSAPPLOGIC");
        exportModelMap.put("PSDETOOLBARLOGIC", "T_SRFPSDETOOLBARLOGIC");
        exportModelMap.put("PSDEWIZARDLOGIC", "T_SRFPSDEWIZARDLOGIC");
        exportModelMap.put("PSDELISTLOGIC", "T_SRFPSDELISTLOGIC ");
        exportModelMap.put("PSSYSMAPLOGIC", "T_SRFPSSYSMAPLOGIC");
        exportModelMap.put("PSDETREELOGIC", "T_SRFPSDETREELOGIC");
        exportModelMap.put("PSDEDATAVIEWLOGIC", "T_SRFPSDEDATAVIEWLOGIC");
        exportModelMap.put("PSSYSCALENDARLOGIC", "T_SRFPSSYSCALENDARLOGIC");
        exportModelMap.put("PSDEGRIDLOGIC", "T_SRFPSDEGRIDLOGIC");
        exportModelMap.put("PSDECHARTLOGIC", "T_SRFPSDECHARTLOGIC");
        exportModelMap.put("PSDEDRLOGIC", "T_SRFPSDEDRLOGIC");
        exportModelMap.put("PSSYSUSECASECAT", "T_SRFPSSYSUSECASECAT");
        exportModelMap.put("PSDETEIUDETAIL", "T_SRFPSDETEIUDETAIL");
        exportModelMap.put("PSDETEIUPDATE", "T_SRFPSDETEIUPDATE");
        exportModelMap.put("PSSYSBIREPORT", "T_SRFPSSYSBIREPORT");
        exportModelMap.put("PSSYSBIREPORTITEM", "T_SRFPSSYSBIREPORTITEM");
        exportModelMap.put("PSAPPPFPLUGIN", "T_SRFPSAPPPFPLUGIN");
        exportModelMap.put("PSSYSAICHATAGENT", "T_SRFPSSYSAICHATAGENT");
        exportModelMap.put("PSSYSAIFACTORY", "T_SRFPSSYSAIFACTORY");
        exportModelMap.put("PSSYSAIPIPELINEAGENT", "T_SRFPSSYSAIPIPELINEAGENT");
        exportModelMap.put("PSSYSAIPIPELINEJOB", "T_SRFPSSYSAIPIPELINEJOB");
        exportModelMap.put("PSSYSAIPIPELINEWORKER", "T_SRFPSSYSAIPIPELINEWORKER");
        exportModelMap.put("PSSYSAIWORKERAGENT", "T_SRFPSSYSAIWORKERAGENT");
        log = LogFactory.getLog(PSModelV2Helper.class);
        modelV2UniqueTagMap = new ThreadLocal();
        modelV2KeyMap = new ThreadLocal();
        modelV2UniqueKeyMap = new ThreadLocal();
        modelV2CounterMap = new ThreadLocal();
        modelV2CounterMap2 = new ThreadLocal();
        modelV2UniqueFileMap = new ThreadLocal();
        nBatchSize = 2000;
    }

    protected class BackupHelper
    implements IPSRawSelectWork {
        private IDataEntityModel iDataEntityModel = null;
        private String strModelFolder = null;
        private IService iService = null;

        public BackupHelper(String string, IService iService, IDataEntityModel iDataEntityModel) throws Exception {
            this.iService = iService;
            this.iDataEntityModel = iDataEntityModel != null ? iDataEntityModel : this.iService.getDEModel();
            this.strModelFolder = string + File.separator + this.iDataEntityModel.getName();
            File file = new File(this.strModelFolder);
            if (!file.exists()) {
                file.mkdirs();
            }
        }

        @Override
        public void process(IDataTable iDataTable) throws Exception {
            int n;
            int n2 = 2000;
            do {
                n = iDataTable.cacheRows(n2);
                for (int i = 0; i < n; ++i) {
                    IDataRow iDataRow = iDataTable.getCachedRow(i);
                    IEntity iEntity = this.iDataEntityModel.createEntity();
                    DataObject.fromDataRow((IDataObject)iEntity, (IDataRow)iDataRow);
                    String string = this.strModelFolder + File.separator + "ALL.txt";
                    PSModelV2Helper.appendFile(string, PSModelV2Helper.toJSONString(iEntity, false) + "\n\n");
                }
            } while (n >= n2);
        }
    }

    protected class ExportHelper
    implements IPSRawSelectWork {
        private String strResFolder = null;
        private IDataEntityModel iDataEntityModel = null;
        private String strModelFolder = null;
        private IPSModelV2Service iPSModelV2Service = null;
        private boolean bHasPSSystemId = false;
        private Map<String, String> linkValueMap = null;
        private int nAutoCodeNameIndex = 0;
        private boolean bExportLink = false;
        private String strKeyFieldName = null;
        private List<String> ignoreFieldList = null;

        public ExportHelper(String string, IPSModelV2Service iPSModelV2Service, Map<String, String> map, List<String> list) throws Exception {
            Iterator iterator;
            this.strResFolder = string;
            this.iPSModelV2Service = iPSModelV2Service;
            this.iDataEntityModel = this.iPSModelV2Service.getDEModel();
            this.strKeyFieldName = this.iDataEntityModel.getKeyDEField().getName();
            this.linkValueMap = map;
            if (list != null && list.size() > 0) {
                this.ignoreFieldList = list;
            }
            this.strModelFolder = string + File.separator + this.iDataEntityModel.getName();
            File file = new File(this.strModelFolder);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (this.iDataEntityModel.getDEField("PSSYSTEMID", true) != null) {
                this.bHasPSSystemId = true;
            }
            if ((iterator = this.iDataEntityModel.getDERs(true)) != null && iterator.hasNext()) {
                this.bExportLink = true;
            }
            if (!this.bExportLink && this.iDataEntityModel.getInheritDEModel() != null) {
                this.bExportLink = true;
            }
        }

        @Override
        public void process(IDataTable iDataTable) throws Exception {
            int n;
            int n2 = 2000;
            do {
                n = iDataTable.cacheRows(n2);
                for (int i = 0; i < n; ++i) {
                    String string;
                    String string2;
                    String string32;
                    IDataRow iDataRow = iDataTable.getCachedRow(i);
                    IEntity iEntity = this.iDataEntityModel.createEntity();
                    DataObject.fromDataRow((IDataObject)iEntity, (IDataRow)iDataRow);
                    if (this.ignoreFieldList != null) {
                        for (String string32 : this.ignoreFieldList) {
                            iEntity.remove(string32);
                        }
                    }
                    String string4 = DataObject.getStringValue((Object)iEntity.get(this.strKeyFieldName));
                    if (this.bHasPSSystemId && StringHelper.isNullOrEmpty((String)(string32 = DataObject.getStringValue((Object)iEntity.get("PSSYSTEMID"))))) {
                        iEntity.set("PSSYSTEMID", (Object)PSModelV2Helper.this.getPSSystemId());
                    }
                    if (StringHelper.isNullOrEmpty((String)(string32 = this.iPSModelV2Service.getModelV2ResPath(iEntity, PSModelV2Helper.this.isAppendMode())))) continue;
                    string32 = this.strResFolder + File.separator + string32;
                    File file = new File(string32);
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    if (PSModelV2Helper.this.isAppendMode()) {
                        PSModelV2Helper.appendFile(string32, PSModelV2Helper.toJSONString(iEntity, false) + "\n\n");
                    } else {
                        PSModelV2Helper.writeFile(string32, PSModelV2Helper.toJSONString(iEntity, false));
                    }
                    if (!this.bExportLink) continue;
                    if (PSModelV2Helper.this.isAppendMode()) {
                        if (this.linkValueMap == null) continue;
                        string32 = StringHelper.format((String)"%1$s/%2$s", (Object)this.iDataEntityModel.getName(), (Object)string4).toLowerCase();
                        string2 = this.iPSModelV2Service.getModelV2ResScope(iEntity);
                        if (StringHelper.isNullOrEmpty((String)string2)) continue;
                        string = PSModelV2Helper.getModelV2TagFolderName(this.iPSModelV2Service.getModelV2Tag(iEntity));
                        if (string2.indexOf("PSSYSTEM#") == 0) {
                            this.linkValueMap.put(string32, string);
                        } else {
                            this.linkValueMap.put(string32, StringHelper.format((String)"%1$s/%2$s", (Object)string2, (Object)string));
                        }
                        if (this.iDataEntityModel.getInheritDEModel() == null) continue;
                        string32 = StringHelper.format((String)"%1$s/%2$s", (Object)this.iDataEntityModel.getInheritDEModel().getName(), (Object)string4).toLowerCase();
                        if (string2.indexOf("PSSYSTEM#") == 0) {
                            this.linkValueMap.put(string32, string);
                            continue;
                        }
                        this.linkValueMap.put(string32, StringHelper.format((String)"%1$s/%2$s", (Object)string2, (Object)string));
                        continue;
                    }
                    string32 = this.strResFolder + File.separator + StringHelper.format((String)"%1$s%2$s%3$s.txt", (Object)this.iDataEntityModel.getName(), (Object)File.separator, (Object)PSModelV2Helper.getModelV2TagFolderName(string4));
                    string2 = this.iPSModelV2Service.getModelV2ResScope(iEntity);
                    if (StringHelper.isNullOrEmpty((String)string2)) continue;
                    string = PSModelV2Helper.getModelV2TagFolderName(this.iPSModelV2Service.getModelV2Tag(iEntity));
                    if (string2.indexOf("PSSYSTEM#") == 0) {
                        PSModelV2Helper.writeFile(string32, string);
                    } else {
                        PSModelV2Helper.writeFile(string32, StringHelper.format((String)"%1$s/%2$s", (Object)string2, (Object)string));
                    }
                    if (this.iDataEntityModel.getInheritDEModel() == null) continue;
                    string32 = this.strResFolder + File.separator + StringHelper.format((String)"%1$s%2$s%3$s.txt", (Object)this.iDataEntityModel.getInheritDEModel().getName(), (Object)File.separator, (Object)PSModelV2Helper.getModelV2TagFolderName(string4));
                    file = new File(string32);
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    if (string2.indexOf("PSSYSTEM#") == 0) {
                        PSModelV2Helper.writeFile(string32, string);
                        continue;
                    }
                    PSModelV2Helper.writeFile(string32, StringHelper.format((String)"%1$s/%2$s", (Object)string2, (Object)string));
                }
            } while (n >= n2);
        }
    }
}

