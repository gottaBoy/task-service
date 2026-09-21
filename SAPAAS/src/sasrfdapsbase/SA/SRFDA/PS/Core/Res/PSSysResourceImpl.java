/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysContentCat;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysResource;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysResourceImpl
extends PSSystemObjectImpl
implements IPSSysResource {
    private static final Log log = LogFactory.getLog(PSSysResourceImpl.class);
    protected PSSysResource psSysResource = null;
    private IPSSystemModule iPSSystemModule = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private Properties resourceParams = null;
    private String strAuthMode = "NONE";
    private String strAuthClientId = null;
    private String strAuthClientSecret = null;
    private String strAuthAccessTokenUrl = null;
    private IPSSysContentCat iPSSysContentCat = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSDEField namePSDEField = null;
    private IPSDEField contentPSDEField = null;
    private IPSDEField pathPSDEField = null;
    private IPSDEField tagPSDEField = null;
    private IPSDEField userPSDEField = null;
    private IPSDEField user2PSDEField = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysResource psSysResource) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysResource = psSysResource;
            this.setId(this.psSysResource.getPSSYSRESOURCEID());
            this.setName(this.psSysResource.getPSSYSRESOURCENAME());
            this.setPSObjectData(this.psSysResource);
            if (!StringHelper.isNullOrEmpty((String)this.psSysResource.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysResource.getPSMODULEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysResource.getRESOURCEPARAMS())) {
                this.resourceParams = PropertiesHelper.load((String)this.psSysResource.getRESOURCEPARAMS());
            }
            this.strAuthMode = this.psSysResource.getAUTHMODE();
            this.strAuthAccessTokenUrl = this.psSysResource.getAUTHACCESSTOKENURI();
            this.strAuthClientId = this.psSysResource.getAUTHCLIENTID();
            this.strAuthClientSecret = this.psSysResource.getAUTHCLIENTSECRET();
            if (StringHelper.compare((String)this.getResourceType(), (String)"SYSCONTENTCAT", (boolean)false) == 0 && !StringHelper.isNullOrEmpty((String)this.psSysResource.getPSSYSCONTENTCATID())) {
                this.iPSSysContentCat = this.getPSSystem().getPSSysContentCat(this.psSysResource.getPSSYSCONTENTCATID());
            }
            if (StringHelper.compare((String)this.getResourceType(), (String)"DEFILE", (boolean)false) == 0) {
                if (StringHelper.isNullOrEmpty((String)this.psSysResource.getPSDEID())) {
                    throw new Exception("\u672a\u6307\u5b9a\u5b9e\u4f53\u5bf9\u8c61");
                }
                this.iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psSysResource.getPSDEID());
                this.iPSDEDataSet = !StringHelper.isNullOrEmpty((String)this.psSysResource.getPSDEDSID()) ? this.getPSDataEntity().getPSDEDataSet(this.psSysResource.getPSDEDSID()) : this.getPSDataEntity().getDefaultPSDEDataSet();
                if (StringHelper.isNullOrEmpty((String)this.psSysResource.getNAMEPSDEFID())) {
                    throw new Exception("\u672a\u6307\u5b9a\u540d\u79f0\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61");
                }
                this.namePSDEField = this.getPSDataEntity().getPSDEField(this.psSysResource.getNAMEPSDEFID());
                if (StringHelper.isNullOrEmpty((String)this.psSysResource.getCONTENTPSDEFID())) {
                    throw new Exception("\u672a\u6307\u5b9a\u5185\u5bb9\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61");
                }
                this.contentPSDEField = this.getPSDataEntity().getPSDEField(this.psSysResource.getCONTENTPSDEFID());
                if (!StringHelper.isNullOrEmpty((String)this.psSysResource.getPATHPSDEFID())) {
                    this.pathPSDEField = this.getPSDataEntity().getPSDEField(this.psSysResource.getPATHPSDEFID());
                }
                if (!StringHelper.isNullOrEmpty((String)this.psSysResource.getTAGPSDEFID())) {
                    this.tagPSDEField = this.getPSDataEntity().getPSDEField(this.psSysResource.getTAGPSDEFID());
                }
                if (!StringHelper.isNullOrEmpty((String)this.psSysResource.getUSERPSDEFID())) {
                    this.userPSDEField = this.getPSDataEntity().getPSDEField(this.psSysResource.getUSERPSDEFID());
                }
                if (!StringHelper.isNullOrEmpty((String)this.psSysResource.getUSER2PSDEFID())) {
                    this.user2PSDEField = this.getPSDataEntity().getPSDEField(this.psSysResource.getUSER2PSDEFID());
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        String strPSSysSFPluginId = this.psSysResource.getPSSYSSFPLUGINID();
        if (!StringHelper.isNullOrEmpty((String)strPSSysSFPluginId)) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u8d44\u6e90\u7c7b\u578b", codelist="ResourceType", group="\u57fa\u672c", order=125, fields={"RESOURCETYPE"})
    public String getResourceType() {
        return this.psSysResource.getRESOURCETYPE();
    }

    @Override
    @PSModelRTMeta(description="\u8d44\u6e90\u6807\u8bb0", group="\u57fa\u672c", order=105, fields={"RESTAG"})
    public String getResTag() {
        return this.psSysResource.getRESTAG();
    }

    @Override
    public String getModelType() {
        return "PSSYSRESOURCE";
    }

    @Override
    @PSModelRTMeta(description="\u8d44\u6e90\u5185\u5bb9", doctype="code", group="\u57fa\u672c", order=135, fields={"CONTENT"})
    public String getContent() {
        return this.psSysResource.getCONTENT();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4, fields={"PSMODULEID"})
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u6a21\u5f0f", codelist="APIAuthMode", fields={"AUTHMODE"})
    public String getAuthMode() {
        return this.strAuthMode;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1token\u8def\u5f84", fields={"AUTHACCESSTOKENURI"})
    public String getAuthAccessTokenUrl() {
        return this.strAuthAccessTokenUrl;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u5ba2\u6237\u7aef\u6807\u8bc6", fields={"AUTHCLIENTID"})
    public String getAuthClientId() {
        return this.strAuthClientId;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u5ba2\u6237\u7aef\u5bc6\u7801", fields={"AUTHCLIENTSECRET"})
    public String getAuthClientSecret() {
        return this.strAuthClientSecret;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u6570", fields={"AUTHPARAM"})
    public String getAuthParam() {
        return this.psSysResource.getAUTHPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u65702", fields={"AUTHPARAM2"})
    public String getAuthParam2() {
        return this.psSysResource.getAUTHPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u7ec4\u4ef6\u52a8\u6001\u53c2\u6570", hideempty=true, fields={"RESOURCEPARAMS"})
    public Properties getResourceParams() {
        return this.resourceParams;
    }

    @Override
    @PSModelRTMeta(description="\u8d44\u6e90\u8def\u5f84", hideempty=true, fields={"RESOURCEURI"})
    public String getResourceUri() {
        if ("GITPROJECT".equals(this.getResourceType()) || "ZIPFILE".equals(this.getResourceType())) {
            return this.psSysResource.getRESOURCEURI();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true, fields={"PSSYSSFPLUGINID"})
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }

    @Override
    protected String onGetDynaModelTag() {
        return this.getResTag();
    }

    @Override
    protected String onGetMOSFileName() {
        return this.getResTag();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u5185\u5bb9\u5206\u7c7b", dumpref=true, dynamodelmode=4, fields={"PSSYSCONTENTCATID"})
    public IPSSysContentCat getPSSysContentCat() {
        return this.iPSSysContentCat;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53", dumpref=true, dynamodelmode=4, fields={"PSDEID"})
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6", dumpref=true, dynamodelmode=4, from="IPSDataEntity", fields={"PSDEDSID"})
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u540d\u79f0\u503c\u5b9e\u4f53\u5c5e\u6027", dumpref=true, dynamodelmode=4, from="IPSDataEntity", fields={"NAMEPSDEFID"})
    public IPSDEField getNamePSDEField() {
        return this.namePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u503c\u5b9e\u4f53\u5c5e\u6027", dumpref=true, dynamodelmode=4, from="IPSDataEntity", fields={"CONTENTPSDEFID"})
    public IPSDEField getContentPSDEField() {
        return this.contentPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u8def\u5f84\u503c\u5b9e\u4f53\u5c5e\u6027", dumpref=true, dynamodelmode=4, from="IPSDataEntity", fields={"PATHPSDEFID"})
    public IPSDEField getPathPSDEField() {
        return this.pathPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u8bb0\u503c\u5b9e\u4f53\u5c5e\u6027", dumpref=true, dynamodelmode=4, from="IPSDataEntity", fields={"TAGPSDEFID"})
    public IPSDEField getTagPSDEField() {
        return this.tagPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u503c\u5b9e\u4f53\u5c5e\u6027", dumpref=true, dynamodelmode=4, from="IPSDataEntity", fields={"USERPSDEFID"})
    public IPSDEField getUserPSDEField() {
        return this.userPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e492\u503c\u5b9e\u4f53\u5c5e\u6027", dumpref=true, dynamodelmode=4, from="IPSDataEntity", fields={"USER2PSDEFID"})
    public IPSDEField getUser2PSDEField() {
        return this.user2PSDEField;
    }
}

