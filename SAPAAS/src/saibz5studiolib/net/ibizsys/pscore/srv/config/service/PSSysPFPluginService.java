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
package net.ibizsys.pscore.srv.config.service;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPFPITempl;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPFPITemplService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysPFPluginService
extends PSSysPFPluginServiceBase {
    private static final Log log = LogFactory.getLog(PSSysPFPluginService.class);

    protected boolean onFillEntityKeyValue(PSSysPFPlugin pSSysPFPlugin, boolean bl) throws Exception {
        if (!(bl || StringHelper.isNullOrEmpty((String)pSSysPFPlugin.getPSSystemId()) || StringHelper.isNullOrEmpty((String)pSSysPFPlugin.getPSPFPluginId()))) {
            pSSysPFPlugin.setPSSysPFPluginId(KeyValueHelper.genUniqueId((String)pSSysPFPlugin.getPSSystemId(), (String)pSSysPFPlugin.getPSPFPluginId()));
            return true;
        }
        return super.onFillEntityKeyValue((IEntity)pSSysPFPlugin, bl);
    }

    @Override
    protected void onAfterCreate(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        String string = pSSysPFPlugin.getPSPFPluginId();
        super.onAfterCreate(pSSysPFPlugin);
    }

    @Override
    protected void onCalcPluginType(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        String string = pSSysPFPlugin.getPSPFPluginId();
        if (!StringHelper.isNullOrEmpty((String)string)) {
            PSPFPluginService pSPFPluginService = (PSPFPluginService)ServiceGlobal.getService(PSPFPluginService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSPFPlugin pSPFPlugin = new PSPFPlugin();
            pSPFPlugin.setPSPFPluginId(string);
            pSPFPluginService.get((IEntity)pSPFPlugin);
            pSSysPFPlugin.setPluginType(pSPFPlugin.getPluginType());
            if (StringHelper.isNullOrEmpty((String)pSSysPFPlugin.getPSSysPFPluginName())) {
                pSSysPFPlugin.setPSSysPFPluginName(pSPFPlugin.getPSPFPluginName());
            }
            if (StringHelper.isNullOrEmpty((String)pSSysPFPlugin.getPluginDesc())) {
                pSSysPFPlugin.setPluginDesc(pSPFPlugin.getPluginDesc());
            }
        }
    }

    @Override
    protected boolean isExportRelatedModelV2(String string) {
        if (PSSysPFPluginService.isSimpleImportExportMode() && StringHelper.compare((String)"DER1N_PSSYSPFPITEMPL_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return super.isExportRelatedModelV2(string);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysPFPlugin pSSysPFPlugin, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (PSSysPFPluginService.isSimpleImportExportMode()) {
            PSSysPFPITemplService pSSysPFPITemplService = (PSSysPFPITemplService)ServiceGlobal.getService(PSSysPFPITemplService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSSysPFPITemplService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSSysPFPITempl pSSysPFPITempl = new PSSysPFPITempl();
                    pSSysPFPITempl.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
                    pSSysPFPITempl.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
                    pSSysPFPITemplService.compileModelV2(pSSysPFPITempl, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSSysPFPITempl pSSysPFPITempl = new PSSysPFPITempl();
                        pSSysPFPITempl.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
                        pSSysPFPITempl.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
                        pSSysPFPITemplService.compileModelV2(pSSysPFPITempl, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysPFPlugin, objectNode, string, string2, n);
    }
}

