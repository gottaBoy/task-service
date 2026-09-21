/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatform;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformFunc;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformFuncBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInstBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformFuncService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformFuncServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeploy;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnMSDeployService
extends PSDevSlnMSDeployServiceBase {
    private static final Log log = LogFactory.getLog(PSDevSlnMSDeployService.class);
    public static final String CONFIG_DBINST = "dbinst";
    public static final String CONFIG_DBINST_DBTYPE = "dbtype";
    public static final String CONFIG_DBINST_DBNAME = "dbname";
    public static final String CONFIG_DBINST_USERNAME = "username";
    public static final String CONFIG_DBINST_PASSWORD = "password";
    public static final String CONFIG_DBINST_URL = "url";
    public static final String CONFIG_CLOUDUTIL = "cloudutil";
    public static final String CONFIG_CLOUDCONF = "cloudconf";
    public static final String CONFIG_CLOUDNODE = "cloudnode";

    /*
     * WARNING - void declaration
     */
    @Override
    protected void onPubConfigs(PSDevSlnMSDeploy pSDevSlnMSDeploy) throws Exception {
        Object object;
        String string;
        Object object2;
        ObjectNode objectNode;
        Object object3;
        Serializable serializable;
        Object object4;
        Object object5;
        this.get((IEntity)pSDevSlnMSDeploy);
        if (StringHelper.isNullOrEmpty((String)pSDevSlnMSDeploy.getPSDevSlnId())) {
            throw new Exception(String.format("\u5fae\u670d\u52a1\u90e8\u7f72\u65b9\u6848\u672a\u6307\u5b9a\u5f00\u53d1\u65b9\u6848", new Object[0]));
        }
        if (StringHelper.isNullOrEmpty((String)pSDevSlnMSDeploy.getPSDCMSPlatformId())) {
            throw new Exception(String.format("\u5fae\u670d\u52a1\u90e8\u7f72\u65b9\u6848\u672a\u6307\u5b9a\u5fae\u670d\u52a1\u5e73\u53f0", new Object[0]));
        }
        PSDevSln pSDevSln = pSDevSlnMSDeploy.getPSDevSln();
        PSDCMSPlatform pSDCMSPlatform = pSDevSlnMSDeploy.getPSDCMSPlatform();
        if (DataTypeHelper.getIntegerValue((Object)pSDevSln.getEnableCallback(), (Integer)1) != 1) {
            throw new Exception(String.format("\u5f00\u53d1\u65b9\u6848\u672a\u542f\u7528\u56de\u8c03", new Object[0]));
        }
        String string2 = pSDevSln.getCallbackUrl();
        if (StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception(String.format("\u5f00\u53d1\u65b9\u6848\u672a\u5b9a\u4e49\u56de\u8c03\u8def\u5f84", new Object[0]));
        }
        PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
        ObjectNode objectNode2 = JsonNodeHelper.createObjectNode();
        ArrayList<PSDevCenterDBInst> arrayList = pSDevCenterDBInstService.selectByPSDevSln(pSDevSln);
        if (arrayList != null) {
            object5 = objectNode2.putObject(CONFIG_DBINST);
            object4 = arrayList.iterator();
            while (object4.hasNext()) {
                serializable = (PSDevCenterDBInst)object4.next();
                object3 = object5.putObject(((PSDevCenterDBInstBase)serializable).getPSDevCenterDBInstName());
                object3.put(CONFIG_DBINST_DBTYPE, ((PSDevCenterDBInstBase)serializable).getDBType());
                if (!StringHelper.isNullOrEmpty((String)((PSDevCenterDBInstBase)serializable).getUserName())) {
                    object3.put(CONFIG_DBINST_USERNAME, ((PSDevCenterDBInstBase)serializable).getUserName());
                }
                if (!StringHelper.isNullOrEmpty((String)((PSDevCenterDBInstBase)serializable).getPasswd())) {
                    object3.put(CONFIG_DBINST_PASSWORD, ((PSDevCenterDBInstBase)serializable).getPasswd());
                }
                if (StringHelper.isNullOrEmpty((String)((PSDevCenterDBInstBase)serializable).getConnStr())) continue;
                object3.put(CONFIG_DBINST_URL, ((PSDevCenterDBInstBase)serializable).getConnStr());
            }
        }
        if ((object4 = ((PSDCMSPlatformFuncServiceBase)(object5 = (PSDCMSPlatformFuncService)ServiceGlobal.getService(PSDCMSPlatformFuncService.class, (SessionFactory)this.getSessionFactory()))).selectByPSDCMSPlatform(pSDCMSPlatform)) != null) {
            serializable = objectNode2.putObject(CONFIG_CLOUDUTIL);
            object3 = objectNode2.putObject(CONFIG_CLOUDCONF);
            objectNode = ((ArrayList)object4).iterator();
            while (objectNode.hasNext()) {
                String list2;
                object2 = (PSDCMSPlatformFunc)objectNode.next();
                if (DataObject.getIntegerValue((Object)((PSDCMSPlatformFuncBase)object2).getValidFlag(), (Integer)1) != 1 || StringHelper.isNullOrEmpty((String)(list2 = ((PSDCMSPlatformFuncBase)object2).getMSFuncType())) || list2.indexOf("CLOUD") != 0) continue;
                string = ((PSDCMSPlatformFuncBase)object2).getFuncParam9();
                if (!StringHelper.isNullOrEmpty((String)string) && !StringHelper.isNullOrEmpty((String)((PSDCMSPlatformFuncBase)object2).getFuncParam10())) {
                    string = string + "\r\n";
                    string = string + ((PSDCMSPlatformFuncBase)object2).getFuncParam10();
                }
                if (StringHelper.isNullOrEmpty((String)string)) continue;
                if ("CLOUDCONFITEM".equals(list2)) {
                    if (StringHelper.isNullOrEmpty((String)((PSDCMSPlatformFuncBase)object2).getPSDCMSPlatformFuncName())) continue;
                    object3.put(((PSDCMSPlatformFuncBase)object2).getPSDCMSPlatformFuncName(), string);
                    continue;
                }
                object = list2.replace("CLOUD", "").replace("UTIL", "").toLowerCase();
                serializable.put((String)object, string);
            }
        }
        if ((serializable = pSDevSlnMSDeploy.getPSDevSlnMSDepAPIs()) != null) {
            object3 = new HashMap();
            objectNode = ((ArrayList)serializable).iterator();
            while (objectNode.hasNext()) {
                void var14_18;
                object2 = (PSDevSlnMSDepAPI)objectNode.next();
                if (DataObject.getIntegerValue((Object)((PSDevSlnMSDepAPIBase)object2).getValidFlag(), (Integer)1) != 1 || ((PSDevSlnMSDepAPIBase)object2).getPSDCMSPlatformNode() == null || ((PSDevSlnMSDepAPIBase)object2).getPSDevSlnSys() == null || ((PSDevSlnMSDepAPIBase)object2).getPSDevSlnSysAPI() == null) continue;
                if (StringHelper.isNullOrEmpty((String)((PSDevSlnMSDepAPIBase)object2).getPSDevSlnSys().getDeploySysId())) {
                    log.warn((Object)String.format("\u5f00\u53d1\u7cfb\u7edf[%1$s]\u672a\u6307\u5b9a\u90e8\u7f72\u7cfb\u7edf\u6807\u8bc6", ((PSDevSlnMSDepAPIBase)object2).getPSDevSlnSys().getPSDevSlnSysName()));
                    continue;
                }
                List list = (List)object3.get(((PSDevSlnMSDepAPIBase)object2).getPSDCMSPlatformNode().getPSDCMSPlatformNodeName());
                if (list == null) {
                    ArrayList arrayList2 = new ArrayList();
                    object3.put(((PSDevSlnMSDepAPIBase)object2).getPSDCMSPlatformNode().getPSDCMSPlatformNodeName(), arrayList2);
                }
                var14_18.add(object2);
            }
            if (object3.size() > 0) {
                objectNode = objectNode2.putObject(CONFIG_CLOUDNODE);
                for (Map.Entry entry : object3.entrySet()) {
                    string = objectNode.putArray((String)entry.getKey());
                    object = (List)entry.getValue();
                    Iterator iterator = object.iterator();
                    while (iterator.hasNext()) {
                        PSDevSlnMSDepAPI pSDevSlnMSDepAPI = (PSDevSlnMSDepAPI)iterator.next();
                        ObjectNode objectNode3 = string.addObject();
                        objectNode3.put("systemid", pSDevSlnMSDepAPI.getPSDevSlnSys().getDeploySysId());
                        objectNode3.put("apiname", pSDevSlnMSDepAPI.getPSDevSlnSysAPI().getPSDevSlnSysAPIName());
                    }
                }
            }
        }
        object3 = pSDevSln.getCallbackTag() == null ? "" : pSDevSln.getCallbackTag();
        this.executeCallback(this.getRealCallbackUrl(string2, "", pSDevSln.getPSDevSlnId(), "PUBCONFIG", "srfcloudplatform", "", (String)object3), objectNode2.toString());
    }
}

