/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.action.IPSDEAction
 *  net.ibizsys.model.dataentity.priv.IPSDEOPPriv
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.dr;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Properties;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.PSDataEntityObjectImpl;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.dr.IPSDEDRItemRuntime;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.model.entity.PSDEDRItem;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDRItemImpl
extends PSDataEntityObjectImpl
implements IPSDEDRItemRuntime {
    private static final Log log = LogFactory.getLog(PSDEDRItemImpl.class);
    private PSDEDRItem psDEDRItem = null;
    private String strCaption = "";
    private IPSSysImage iPSSysImage = null;
    private String strCounterId = null;
    private String strEnableMode = null;
    private IPSDEAction testPSDEAction = null;
    private IPSDEOPPriv iPSDEOPPriv = null;
    private ObjectNode viewParamJO = JsonNodeHelper.createObjectNode();
    private IPSLanguageRes capPSLanguageRes = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDataEntity iPSDataEntity, PSDEDRItem psDEDRItem) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSDEDRItemData(psDEDRItem);
            this.setPSDataEntity(iPSDataEntity);
            this.setId(this.psDEDRItem.getPSDEDRITEMID());
            this.setName(this.psDEDRItem.getPSDEDRITEMNAME());
            this.setPSObjectData(this.psDEDRItem);
            this.strCaption = this.psDEDRItem.getPSDEDRITEMNAME();
            if (!StringHelper.isNullOrEmpty((String)this.psDEDRItem.getCOUNTERID())) {
                this.strCounterId = this.psDEDRItem.getCOUNTERID();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDRItem.getENABLEMODE())) {
                this.strEnableMode = this.psDEDRItem.getENABLEMODE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDRItem.getTESTPSDEACTIONID())) {
                this.testPSDEAction = this.getPSDataEntity().getPSDEAction(this.psDEDRItem.getTESTPSDEACTIONID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDRItem.getPSDEOPPRIVID())) {
                this.iPSDEOPPriv = this.getPSDataEntity().getPSSystem().getPSDEOPPriv(this.psDEDRItem.getPSDEOPPRIVID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDRItem.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEDRItem.getCAPPSLANRESID());
            }
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDEDRItem.getPSSYSIMAGEID())) {
            this.iPSSysImage = this.getPSDataEntity().getPSSystem().getPSSysImage(this.psDEDRItem.getPSSYSIMAGEID());
        }
        this.onFillViewParamJO(this.viewParamJO);
        super.onInit();
    }

    protected void onFillViewParamJO(ObjectNode viewParamJO) throws Exception {
        Properties properties;
        String strViewParams = this.psDEDRItem.getVIEWPARAMS();
        if (!StringHelper.isNullOrEmpty((String)strViewParams) && (properties = PropertiesHelper.load((String)strViewParams)) != null) {
            for (Object objKey : properties.keySet()) {
                String strKey = (String)objKey;
                if (viewParamJO.has(strKey = strKey.toUpperCase())) continue;
                JsonNodeHelper.put((ObjectNode)viewParamJO, (String)strKey, (Object)PropertiesHelper.getProperty((Properties)properties, (String)((String)objKey), (String)""));
            }
        }
    }

    public String getCaption(String strLanguage) {
        if (StringHelper.isNullOrEmpty((String)this.strCaption)) {
            return this.onGetCaption();
        }
        return this.strCaption;
    }

    protected String onGetCaption() {
        return "";
    }

    public PSDEDRItem getPSDEDRItemData() {
        return this.psDEDRItem;
    }

    protected void setPSDEDRItemData(PSDEDRItem psDEDRItem) {
        this.psDEDRItem = psDEDRItem;
    }

    @PSModelRTMeta(description="\u5173\u7cfb\u9879\u7c7b\u578b", codelist="DEDRItemType")
    public String getItemType() {
        return this.getPSDEDRItemData().getDRITEMTYPE();
    }

    public String getPSDEDRGroupId() {
        return this.getPSDEDRItemData().getPSDEDRGROUPID();
    }

    public String getPSDEViewId() {
        return this.getPSDEDRItemData().getPSDEVIEWBASEID();
    }

    @PSModelRTMeta(description="\u9879\u56fe\u6807\u8d44\u6e90\u5bf9\u8c61")
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @PSModelRTMeta(description="\u542f\u7528\u6a21\u5f0f", codelist="DEDRDetailEnableMode")
    public String getEnableMode() {
        return this.strEnableMode;
    }

    @PSModelRTMeta(description="\u8ba1\u6570\u9879\u6807\u8bc6")
    public String getCounterId() {
        return this.strCounterId;
    }

    @PSModelRTMeta(description="\u5224\u65ad\u8f93\u51fa\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getTestPSDEAction() {
        return this.testPSDEAction;
    }

    @PSModelRTMeta(description="\u5224\u65ad\u8f93\u51fa\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6")
    public IPSDEOPPriv getTestPSDEOPPriv() {
        return this.iPSDEOPPriv;
    }

    @PSModelRTMeta(description="\u89c6\u56fe\u53c2\u6570\u5bf9\u8c61")
    public ObjectNode getViewParamJO() {
        return this.viewParamJO;
    }

    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }
}

