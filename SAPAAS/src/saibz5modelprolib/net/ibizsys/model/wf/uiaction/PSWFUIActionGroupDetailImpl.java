/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.view.IPSUIAction
 *  net.ibizsys.model.view.IPSUIActionGroup
 *  net.ibizsys.model.wf.uiaction.IPSWFUIAction
 *  net.ibizsys.model.wf.uiaction.IPSWFUIActionGroup
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.wf.uiaction;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Enumeration;
import java.util.Properties;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSDEUIActionGroupDetail;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.model.view.IPSUIActionGroup;
import net.ibizsys.model.wf.uiaction.IPSWFUIAction;
import net.ibizsys.model.wf.uiaction.IPSWFUIActionGroup;
import net.ibizsys.model.wf.uiaction.IPSWFUIActionGroupDetailRuntime;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFUIActionGroupDetailImpl
extends PSObjectImpl
implements IPSWFUIActionGroupDetailRuntime {
    private static final Log log = LogFactory.getLog(PSWFUIActionGroupDetailImpl.class);
    private IPSWFUIActionGroup iPSWFUIActionGroup = null;
    private PSDEUIActionGroupDetail psDEUIActionGroupDetail = null;
    private IPSWFUIAction iPSWFUIAction = null;
    private ObjectNode uiActionParamJO = null;
    private boolean bAddSeparator = false;
    private IPSUIAction iPSUIAction = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSWFUIActionGroup iPSWFUIActionGroup, PSDEUIActionGroupDetail psDEUIActionGroupDetail) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSWFUIActionGroup = iPSWFUIActionGroup;
            this.psDEUIActionGroupDetail = psDEUIActionGroupDetail;
            this.setId(this.psDEUIActionGroupDetail.getPSDEUAGRPDETAILID());
            this.setName(this.psDEUIActionGroupDetail.getPSDEUAGRPDETAILNAME());
            if (!this.psDEUIActionGroupDetail.isADDSEPARATORNull()) {
                this.bAddSeparator = this.psDEUIActionGroupDetail.getADDSEPARATOR();
            }
            if (!StringHelper.isNullOrEmpty((String)psDEUIActionGroupDetail.getPSDEUIACTIONID())) {
                String strUIActionParam;
                if (iPSWFUIActionGroup.getPSWFVersion() != null) {
                    this.iPSWFUIAction = iPSWFUIActionGroup.getPSWFVersion().getPSWFUIAction(psDEUIActionGroupDetail.getPSDEUIACTIONID(), true);
                }
                if (this.iPSWFUIAction == null) {
                    this.iPSUIAction = iPSWFUIActionGroup.getPSWorkflow().getPSSystem().getPSDEUIAction(psDEUIActionGroupDetail.getPSDEUIACTIONID(), true);
                    if (this.iPSUIAction == null) {
                        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5de5\u4f5c\u6d41\u754c\u9762\u884c\u4e3a[%1$s]", (Object)psDEUIActionGroupDetail.getPSDEUIACTIONID()));
                    }
                } else {
                    this.iPSUIAction = this.iPSWFUIAction;
                }
                if (!StringHelper.isNullOrEmpty((String)(strUIActionParam = psDEUIActionGroupDetail.getUIACTIONPARAMS().trim()))) {
                    if (strUIActionParam.charAt(0) == '{') {
                        this.uiActionParamJO = (ObjectNode)JsonNodeHelper.fromString((String)strUIActionParam);
                    } else {
                        this.uiActionParamJO = JsonNodeHelper.createObjectNode();
                        Properties properties = PropertiesHelper.load((String)strUIActionParam);
                        Enumeration<Object> keys = properties.keys();
                        while (keys.hasMoreElements()) {
                            String strKey = keys.nextElement().toString();
                            String strValue = PropertiesHelper.getProperty((Properties)properties, (String)strKey);
                            this.uiActionParamJO.put(strKey, strValue);
                        }
                    }
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    public IPSWFUIActionGroup getPSWFUIActionGroup() {
        return this.iPSWFUIActionGroup;
    }

    public IPSWFUIAction getPSWFUIAction() {
        return this.iPSWFUIAction;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.getPSWFUIActionGroup());
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u9644\u52a0\u53c2\u6570")
    public ObjectNode getUIActionParamJO() {
        return this.uiActionParamJO;
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u5bf9\u8c61")
    public IPSUIActionGroup getPSUIActionGroup() {
        return this.getPSWFUIActionGroup();
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u5bf9\u8c61")
    public IPSUIAction getPSUIAction() {
        return this.iPSUIAction;
    }

    public String getUIActionParam() {
        return this.psDEUIActionGroupDetail.getUIACTIONPARAMS();
    }

    @PSModelRTMeta(description="\u6dfb\u52a0\u5206\u9694\u680f")
    public boolean isAddSeparator() {
        return this.bAddSeparator;
    }
}

