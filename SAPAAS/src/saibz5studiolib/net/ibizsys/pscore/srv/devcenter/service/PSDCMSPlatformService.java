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
package net.ibizsys.pscore.srv.devcenter.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatform;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformFunc;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInstBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformFuncService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformFuncServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.util.PSDevCenterHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDCMSPlatformService
extends PSDCMSPlatformServiceBase {
    private static final Log log = LogFactory.getLog(PSDCMSPlatformService.class);
    public static final String CONFIG_DBINST = "dbinst";
    public static final String CONFIG_DBINST_DBTYPE = "dbtype";
    public static final String CONFIG_DBINST_DBNAME = "dbname";
    public static final String CONFIG_DBINST_USERNAME = "username";
    public static final String CONFIG_DBINST_PASSWORD = "password";
    public static final String CONFIG_DBINST_URL = "url";
    public static final String CONFIG_CLOUDUTIL = "cloudutil";
    public static final String CONFIG_CLOUDCONF = "cloudconf";
    public static final String CONFIG_CLOUDNODE = "cloudnode";

    @Override
    protected void onBeforeCreate(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        if (this.isMajorSessionFactory()) {
            PSDevCenterHelper.testCreate(pSDCMSPlatform.getPSDevCenter(), "MSPCNT", false);
        }
        super.onBeforeCreate(pSDCMSPlatform);
    }

    @Override
    protected void onAfterCreate(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        if (this.isMajorSessionFactory()) {
            PSDevCenterHelper.updatetPSDCResRep(pSDCMSPlatform.getPSDevCenter(), "MSPCNT");
        }
        super.onAfterCreate(pSDCMSPlatform);
    }

    @Override
    protected void onAfterRemove(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        if (this.isMajorSessionFactory()) {
            PSDCMSPlatform pSDCMSPlatform2 = (PSDCMSPlatform)this.getLast((IEntity)pSDCMSPlatform);
            PSDevCenterHelper.updatetPSDCResRep(pSDCMSPlatform2.getPSDevCenter(), "MSPCNT");
        }
        super.onAfterRemove(pSDCMSPlatform);
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        if (this.isMajorSessionFactory()) {
            return true;
        }
        return super.isPrepareLastForRemove();
    }

    @Override
    protected void onPubConfigs(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        ObjectNode objectNode;
        Object object;
        Object object2;
        Object object3;
        this.get((IEntity)pSDCMSPlatform);
        if (StringHelper.isNullOrEmpty((String)pSDCMSPlatform.getPSDevSlnId())) {
            throw new Exception(String.format("\u5fae\u670d\u52a1\u5e73\u53f0\u672a\u7ed1\u5b9a\u5f00\u53d1\u65b9\u6848", new Object[0]));
        }
        PSDevSln pSDevSln = pSDCMSPlatform.getPSDevSln();
        if (DataTypeHelper.getIntegerValue((Object)pSDevSln.getEnableCallback(), (Integer)1) != 1) {
            throw new Exception(String.format("\u5f00\u53d1\u65b9\u6848\u672a\u542f\u7528\u56de\u8c03", new Object[0]));
        }
        String string = pSDevSln.getCallbackUrl();
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception(String.format("\u5f00\u53d1\u65b9\u6848\u672a\u5b9a\u4e49\u56de\u8c03\u8def\u5f84", new Object[0]));
        }
        PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
        ObjectNode objectNode2 = JsonNodeHelper.createObjectNode();
        ArrayList<PSDevCenterDBInst> arrayList = pSDevCenterDBInstService.selectByPSDevSln(pSDevSln);
        if (arrayList != null) {
            object3 = objectNode2.putObject(CONFIG_DBINST);
            object2 = arrayList.iterator();
            while (object2.hasNext()) {
                object = (PSDevCenterDBInst)object2.next();
                objectNode = object3.putObject(((PSDevCenterDBInstBase)object).getPSDevCenterDBInstName());
                objectNode.put(CONFIG_DBINST_DBTYPE, ((PSDevCenterDBInstBase)object).getDBType());
                if (!StringHelper.isNullOrEmpty((String)((PSDevCenterDBInstBase)object).getUserName())) {
                    objectNode.put(CONFIG_DBINST_USERNAME, ((PSDevCenterDBInstBase)object).getUserName());
                }
                if (!StringHelper.isNullOrEmpty((String)((PSDevCenterDBInstBase)object).getPasswd())) {
                    objectNode.put(CONFIG_DBINST_PASSWORD, ((PSDevCenterDBInstBase)object).getPasswd());
                }
                if (StringHelper.isNullOrEmpty((String)((PSDevCenterDBInstBase)object).getConnStr())) continue;
                objectNode.put(CONFIG_DBINST_URL, ((PSDevCenterDBInstBase)object).getConnStr());
            }
        }
        if ((object2 = ((PSDCMSPlatformFuncServiceBase)(object3 = (PSDCMSPlatformFuncService)ServiceGlobal.getService(PSDCMSPlatformFuncService.class, (SessionFactory)this.getSessionFactory()))).selectByPSDCMSPlatform(pSDCMSPlatform)) != null) {
            object = objectNode2.putObject(CONFIG_CLOUDUTIL);
            objectNode = objectNode2.putObject(CONFIG_CLOUDCONF);
            Iterator iterator = ((ArrayList)object2).iterator();
            while (iterator.hasNext()) {
                String string2;
                PSDCMSPlatformFunc pSDCMSPlatformFunc = (PSDCMSPlatformFunc)iterator.next();
                if (DataObject.getIntegerValue((Object)pSDCMSPlatformFunc.getValidFlag(), (Integer)1) != 1 || StringHelper.isNullOrEmpty((String)(string2 = pSDCMSPlatformFunc.getMSFuncType())) || string2.indexOf("CLOUD") != 0) continue;
                String string3 = pSDCMSPlatformFunc.getFuncParam9();
                if (!StringHelper.isNullOrEmpty((String)string3) && !StringHelper.isNullOrEmpty((String)pSDCMSPlatformFunc.getFuncParam10())) {
                    string3 = string3 + "\r\n";
                    string3 = string3 + pSDCMSPlatformFunc.getFuncParam10();
                }
                if (StringHelper.isNullOrEmpty((String)string3)) continue;
                if ("CLOUDCONFITEM".equals(string2)) {
                    if (StringHelper.isNullOrEmpty((String)pSDCMSPlatformFunc.getPSDCMSPlatformFuncName())) continue;
                    objectNode.put(pSDCMSPlatformFunc.getPSDCMSPlatformFuncName(), string3);
                    continue;
                }
                String string4 = string2.replace("CLOUD", "").replace("UTIL", "").toLowerCase();
                object.put(string4, string3);
            }
        }
        object = pSDevSln.getCallbackTag() == null ? "" : pSDevSln.getCallbackTag();
        this.executeCallback(this.getRealCallbackUrl(string, "", pSDevSln.getPSDevSlnId(), "PUBCONFIG", "srfcloudplatform", "", (String)object), objectNode2.toString());
    }
}

