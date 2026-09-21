/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.dataentity.uiaction.IPSDEUIAction
 *  net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup
 *  net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroupDetail
 *  net.ibizsys.model.view.IPSUIAction
 *  net.ibizsys.model.view.IPSUIActionGroup
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.uiaction;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Enumeration;
import java.util.Properties;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroupDetail;
import net.ibizsys.model.entity.PSDEUIActionGroupDetail;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.model.view.IPSUIActionGroup;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUIActionGroupDetailImpl
extends PSObjectImpl
implements IPSDEUIActionGroupDetail {
    private static final Log log = LogFactory.getLog(PSDEUIActionGroupDetailImpl.class);
    private IPSDEUIActionGroup iPSDEUIActionGroup = null;
    private PSDEUIActionGroupDetail psDEUIActionGroupDetail = null;
    private IPSDEUIAction iPSDEUIAction = null;
    private ObjectNode uiActionParamJO = null;
    private String strDetailType = "DEUIACTION";
    private boolean bAddSeparator = false;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEUIActionGroup iPSDEUIActionGroup, PSDEUIActionGroupDetail psDEUIActionGroupDetail) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSDEUIActionGroup = iPSDEUIActionGroup;
            this.psDEUIActionGroupDetail = psDEUIActionGroupDetail;
            this.setId(this.psDEUIActionGroupDetail.getPSDEUAGRPDETAILID());
            this.setName(this.psDEUIActionGroupDetail.getPSDEUAGRPDETAILNAME());
            if (!StringHelper.isNullOrEmpty((String)this.psDEUIActionGroupDetail.getDETAILTYPE())) {
                this.strDetailType = this.psDEUIActionGroupDetail.getDETAILTYPE();
            }
            if (!this.psDEUIActionGroupDetail.isADDSEPARATORNull()) {
                this.bAddSeparator = this.psDEUIActionGroupDetail.getADDSEPARATOR();
            }
            if (!StringHelper.isNullOrEmpty((String)psDEUIActionGroupDetail.getPSDEUIACTIONID())) {
                this.iPSDEUIAction = iPSDEUIActionGroup.getPSDataEntity() != null ? iPSDEUIActionGroup.getPSDataEntity().getPSDEUIAction(psDEUIActionGroupDetail.getPSDEUIACTIONID()) : iPSDEUIActionGroup.getPSSystem().getPSDEUIAction(psDEUIActionGroupDetail.getPSDEUIACTIONID(), false);
                String strUIActionParam = psDEUIActionGroupDetail.getUIACTIONPARAMS().trim();
                if (!StringHelper.isNullOrEmpty((String)strUIActionParam)) {
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

    public IPSDEUIActionGroup getPSDEUIActionGroup() {
        return this.iPSDEUIActionGroup;
    }

    public IPSDEUIAction getPSDEUIAction() {
        return this.iPSDEUIAction;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.getPSDEUIActionGroup()).getPSSysModelInstId();
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u9644\u52a0\u53c2\u6570")
    public ObjectNode getUIActionParamJO() {
        return this.uiActionParamJO;
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u5bf9\u8c61")
    public IPSUIActionGroup getPSUIActionGroup() {
        return this.getPSDEUIActionGroup();
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u5bf9\u8c61")
    public IPSUIAction getPSUIAction() {
        return this.getPSDEUIAction();
    }

    public String getUIActionParam() {
        return this.psDEUIActionGroupDetail.getUIACTIONPARAMS();
    }

    @PSModelRTMeta(description="\u6210\u5458\u7c7b\u578b", codelist="TBItemType2")
    public String getDetailType() {
        return this.strDetailType;
    }

    @PSModelRTMeta(description="\u6dfb\u52a0\u5206\u9694\u680f")
    public boolean isAddSeparator() {
        return this.bAddSeparator;
    }
}

