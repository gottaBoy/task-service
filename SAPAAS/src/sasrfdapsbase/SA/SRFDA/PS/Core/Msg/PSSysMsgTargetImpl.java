/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Msg;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTarget;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysUtil;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysMsgTarget;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysMsgTargetImpl
extends PSSystemObjectImpl
implements IPSSysMsgTarget {
    private static final Log log = LogFactory.getLog(PSSysMsgTargetImpl.class);
    protected PSSysMsgTarget psSysMsgTarget = null;
    private IPSSystemModule iPSSystemModule = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSXCodeObject iPSXCodeObject = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSDEField targetPSDEField = null;
    private IPSDEField targetTypePSDEField = null;
    private String strMsgTargetType = "RUNTIME";
    private Properties msgTargetParams = null;
    private IPSSysUtil iPSSysUtil = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysMsgTarget psSysMsgTarget) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysMsgTarget = psSysMsgTarget;
            this.setId(this.psSysMsgTarget.getPSSYSMSGTARGETID());
            this.setName(this.psSysMsgTarget.getPSSYSMSGTARGETNAME());
            this.setPSObjectData(this.psSysMsgTarget);
            this.strMsgTargetType = this.psSysMsgTarget.getMSGTARGETTYPE();
            if (StringHelper.compare((String)this.getMsgTargetType(), (String)"DE", (boolean)false) == 0) {
                if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTarget.getPSDEID())) {
                    this.iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psSysMsgTarget.getPSDEID());
                    if (this.getPSDataEntity() != null) {
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTarget.getPSDEDSID())) {
                            this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psSysMsgTarget.getPSDEDSID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTarget.getTARGETPSDEFID())) {
                            this.targetPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgTarget.getTARGETPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTarget.getTARGETTYPEPSDEFID())) {
                            this.targetTypePSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgTarget.getTARGETTYPEPSDEFID());
                        }
                    }
                } else {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6d88\u606f\u76ee\u6807\u6240\u5b58\u50a8\u7684\u5b9e\u4f53");
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTarget.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysMsgTarget.getPSMODULEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTarget.getMSGTARGETPARAMS())) {
                this.msgTargetParams = PropertiesHelper.load((String)this.psSysMsgTarget.getMSGTARGETPARAMS());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTarget.getPSSYSUTILDEID())) {
                this.iPSSysUtil = this.getPSSystem().getPSSysUtil(this.psSysMsgTarget.getPSSYSUTILDEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTarget.getPSSYSSFPLUGINID())) {
                this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.psSysMsgTarget.getPSSYSSFPLUGINID());
            }
            if (this.getPSSysSFPlugin() != null) {
                String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
                IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
                if (iPSSysSFPluginTempl != null) {
                    this.iPSXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
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
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSSYSMSGTARGET";
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u76ee\u6807\u7c7b\u578b", codelist="SysMsgTargetType", group="\u57fa\u672c", order=125, fields={"MSGTARGETTYPE"})
    public String getMsgTargetType() {
        return this.strMsgTargetType;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysMsgTarget.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4, fields={"PSMODULEID"})
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u76ee\u6807\u6807\u8bb0", fields={"MSGTARGETTAG"})
    public String getMsgTargetTag() {
        return this.psSysMsgTarget.getMSGTARGETTAG();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u76ee\u6807\u6807\u8bb02", fields={"MSGTARGETTAG2"})
    public String getMsgTargetTag2() {
        return this.psSysMsgTarget.getMSGTARGETTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", dumpref=true, fields={"PSDEID"})
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u6570\u636e\u96c6", dumpref=true, from="IPSDataEntity", fields={"PSDEDSID"})
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u6807\u8bc6\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"TARGETPSDEFID"})
    public IPSDEField getTargetPSDEField() {
        return this.targetPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u7c7b\u578b\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"TARGETTYPEPSDEFID"})
    public IPSDEField getTargetTypePSDEField() {
        return this.targetTypePSDEField;
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
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true, fields={"PSSYSSFPLUGINID"})
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSXCodeObject getRender() {
        return this.iPSXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u53c2\u6570", hideempty=true, fields={"MSGTARGETPARAMS"})
    public Properties getMsgTargetParams() {
        return this.msgTargetParams;
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u7cfb\u7edf\u529f\u80fd\u7ec4\u4ef6", hideempty=true, dumpref=true, fields={"PSSYSUTILDEID"})
    public IPSSysUtil getPSSysUtil() {
        return this.iPSSysUtil;
    }
}

