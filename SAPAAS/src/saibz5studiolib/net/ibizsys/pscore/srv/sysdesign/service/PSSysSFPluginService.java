/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPITempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPITemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysSFPluginService
extends PSSysSFPluginServiceBase {
    private static final Log log = LogFactory.getLog(PSSysSFPluginService.class);

    protected boolean onFillEntityKeyValue(PSSysSFPlugin pSSysSFPlugin, boolean bl) throws Exception {
        if (!(bl || StringHelper.isNullOrEmpty((String)pSSysSFPlugin.getPSSystemId()) || StringHelper.isNullOrEmpty((String)pSSysSFPlugin.getPSSFPluginId()))) {
            pSSysSFPlugin.setPSSysSFPluginId(KeyValueHelper.genUniqueId((String)pSSysSFPlugin.getPSSystemId(), (String)pSSysSFPlugin.getPSSFPluginId()));
            return true;
        }
        return super.onFillEntityKeyValue(pSSysSFPlugin, bl);
    }

    @Override
    protected void onAfterCreate(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        String string = pSSysSFPlugin.getPSSFPluginId();
        super.onAfterCreate(pSSysSFPlugin);
    }

    @Override
    protected void onCalcPluginType(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        String string = pSSysSFPlugin.getPSSFPluginId();
        if (!StringHelper.isNullOrEmpty((String)string)) {
            PSSFPluginService pSSFPluginService = (PSSFPluginService)ServiceGlobal.getService(PSSFPluginService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSSFPlugin pSSFPlugin = new PSSFPlugin();
            pSSFPlugin.setPSSFPluginId(string);
            pSSFPluginService.get(pSSFPlugin);
            pSSysSFPlugin.setPluginType(pSSFPlugin.getPluginType());
            if (StringHelper.isNullOrEmpty((String)pSSysSFPlugin.getPSSysSFPluginName())) {
                pSSysSFPlugin.setPSSysSFPluginName(pSSFPlugin.getPSSFPluginName());
            }
            if (StringHelper.isNullOrEmpty((String)pSSysSFPlugin.getParamDesc())) {
                pSSysSFPlugin.setParamDesc(pSSFPlugin.getParamDesc());
            }
        }
    }

    @Override
    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSSFPITEMPL_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return super.isExportRelatedModelV2(string);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysSFPlugin pSSysSFPlugin, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (PSSysSFPluginService.isSimpleImportExportMode()) {
            PSSysSFPITemplService pSSysSFPITemplService = (PSSysSFPITemplService)ServiceGlobal.getService(PSSysSFPITemplService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSSysSFPITemplService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSSysSFPITempl pSSysSFPITempl = new PSSysSFPITempl();
                    pSSysSFPITempl.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
                    pSSysSFPITempl.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
                    pSSysSFPITemplService.compileModelV2(pSSysSFPITempl, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSSysSFPITempl pSSysSFPITempl = new PSSysSFPITempl();
                        pSSysSFPITempl.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
                        pSSysSFPITempl.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
                        pSSysSFPITemplService.compileModelV2(pSSysSFPITempl, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysSFPlugin, objectNode, string, string2, n);
    }
}

