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
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgQueue;
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
import SA.SRFDA.PS.Data.PSSysMsgQueue;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysMsgQueueImpl
extends PSSystemObjectImpl
implements IPSSysMsgQueue {
    private static final Log log = LogFactory.getLog(PSSysMsgQueueImpl.class);
    protected PSSysMsgQueue psSysMsgQueue = null;
    private IPSSystemModule iPSSystemModule = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSXCodeObject iPSXCodeObject = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSDEField targetPSDEField = null;
    private IPSDEField targetTypePSDEField = null;
    private IPSDEField tagPSDEField = null;
    private IPSDEField tag2PSDEField = null;
    private IPSDEField titlePSDEField = null;
    private IPSDEField contentPSDEField = null;
    private IPSDEField sendTimePSDEField = null;
    private IPSDEField statePSDEField = null;
    private IPSDEField msgTypePSDEField = null;
    private IPSDEField smsContentPSDEField = null;
    private IPSDEField imContentPSDEField = null;
    private IPSDEField wxContentPSDEField = null;
    private IPSDEField ddContentPSDEField = null;
    private IPSDEField taskUrlPSDEField = null;
    private IPSDEField mobTaskUrlPSDEField = null;
    private IPSDEField filePSDEField = null;
    private Properties msgQueueParams = null;
    private IPSSysUtil iPSSysUtil = null;
    private String strMsgQueueType = "RUNTIME";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysMsgQueue psSysMsgQueue) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysMsgQueue = psSysMsgQueue;
            this.setId(this.psSysMsgQueue.getPSSYSMSGQUEUEID());
            this.setName(this.psSysMsgQueue.getPSSYSMSGQUEUENAME());
            this.setPSObjectData(this.psSysMsgQueue);
            this.strMsgQueueType = this.psSysMsgQueue.getMSGQUEUETYPE();
            if (StringHelper.compare((String)this.getMsgQueueType(), (String)"DE", (boolean)false) == 0) {
                if (!StringHelper.isNullOrEmpty((String)this.psSysMsgQueue.getPSDEID())) {
                    this.iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psSysMsgQueue.getPSDEID());
                    if (this.getPSDataEntity() != null) {
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgQueue.getTARGETPSDEFID())) {
                            this.targetPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgQueue.getTARGETPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgQueue.getTARGETTYPEPSDEFID())) {
                            this.targetTypePSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgQueue.getTARGETTYPEPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgQueue.getCONTENTPSDEFID())) {
                            this.contentPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgQueue.getCONTENTPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgQueue.getMSGTYPEPSDEFID())) {
                            this.msgTypePSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgQueue.getMSGTYPEPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgQueue.getSENDTIMEPSDEFID())) {
                            this.sendTimePSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgQueue.getSENDTIMEPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgQueue.getSTATEPSDEFID())) {
                            this.statePSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgQueue.getSTATEPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgQueue.getTAGPSDEFID())) {
                            this.tagPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgQueue.getTAGPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgQueue.getTAG2PSDEFID())) {
                            this.tag2PSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgQueue.getTAG2PSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgQueue.getTITLEPSDEFID())) {
                            this.titlePSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgQueue.getTITLEPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgQueue.getSMSCONTENTPSDEFID())) {
                            this.smsContentPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgQueue.getSMSCONTENTPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgQueue.getIMCONTENTPSDEFID())) {
                            this.imContentPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgQueue.getIMCONTENTPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgQueue.getWXCONTENTPSDEFID())) {
                            this.wxContentPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgQueue.getWXCONTENTPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgQueue.getDDCONTENTPSDEFID())) {
                            this.ddContentPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgQueue.getDDCONTENTPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgQueue.getTASKURLPSDEFID())) {
                            this.taskUrlPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgQueue.getTASKURLPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgQueue.getMOBTASKURLPSDEFID())) {
                            this.mobTaskUrlPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgQueue.getMOBTASKURLPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgQueue.getFILEPSDEFID())) {
                            this.filePSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgQueue.getFILEPSDEFID());
                        }
                    }
                } else {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6d88\u606f\u961f\u5217\u6240\u5b58\u50a8\u7684\u5b9e\u4f53");
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMsgQueue.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysMsgQueue.getPSMODULEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMsgQueue.getMSGQUEUEPARAMS())) {
                this.msgQueueParams = PropertiesHelper.load((String)this.psSysMsgQueue.getMSGQUEUEPARAMS());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMsgQueue.getPSSYSUTILDEID())) {
                this.iPSSysUtil = this.getPSSystem().getPSSysUtil(this.psSysMsgQueue.getPSSYSUTILDEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMsgQueue.getPSSYSSFPLUGINID())) {
                this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.psSysMsgQueue.getPSSYSSFPLUGINID());
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
        return "PSSYSMSGQUEUE";
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u961f\u5217\u7c7b\u578b", codelist="SysMsgQueueType", group="\u57fa\u672c", order=125, fields={"MSGQUEUETYPE"})
    public String getMsgQueueType() {
        return this.strMsgQueueType;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysMsgQueue.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4, fields={"PSMODULEID"})
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u961f\u5217\u6807\u8bb0", fields={"MSGQUEUETAG"})
    public String getMsgQueueTag() {
        return this.psSysMsgQueue.getMSGQUEUETAG();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u961f\u5217\u6807\u8bb02", fields={"MSGQUEUETAG2"})
    public String getMsgQueueTag2() {
        return this.psSysMsgQueue.getMSGQUEUETAG2();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", dumpref=true, fields={"PSDEID"})
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
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
    @PSModelRTMeta(description="\u6d88\u606f\u6807\u8bb0\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"TAGPSDEFID"})
    public IPSDEField getTagPSDEField() {
        return this.tagPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u6807\u8bb02\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"TAG2PSDEFID"})
    public IPSDEField getTag2PSDEField() {
        return this.tag2PSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u6807\u9898\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"TITLEPSDEFID"})
    public IPSDEField getTitlePSDEField() {
        return this.titlePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u5185\u5bb9\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"CONTENTPSDEFID"})
    public IPSDEField getContentPSDEField() {
        return this.contentPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u7c7b\u578b\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"MSGTYPEPSDEFID"})
    public IPSDEField getMsgTypePSDEField() {
        return this.msgTypePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u53d1\u9001\u65f6\u95f4\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"SENDTIMEPSDEFID"})
    public IPSDEField getSendTimePSDEField() {
        return this.sendTimePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u72b6\u6001\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"STATEPSDEFID"})
    public IPSDEField getStatePSDEField() {
        return this.statePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u77ed\u6d88\u606f\u5185\u5bb9\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"SMSCONTENTPSDEFID"})
    public IPSDEField getSMSContentPSDEField() {
        return this.smsContentPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5373\u65f6\u6d88\u606f\u5185\u5bb9\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"IMCONTENTPSDEFID"})
    public IPSDEField getIMContentPSDEField() {
        return this.imContentPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5fae\u4fe1\u6d88\u606f\u5185\u5bb9\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"WXCONTENTPSDEFID"})
    public IPSDEField getWXContentPSDEField() {
        return this.wxContentPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9489\u9489\u6d88\u606f\u5185\u5bb9\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"DDCONTENTPSDEFID"})
    public IPSDEField getDDContentPSDEField() {
        return this.ddContentPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u4efb\u52a1\u64cd\u4f5c\u8def\u5f84\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"TASKURLPSDEFID"})
    public IPSDEField getTaskUrlPSDEField() {
        return this.taskUrlPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u4efb\u52a1\u64cd\u4f5c\u8def\u5f84\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"MOBTASKURLPSDEFID"})
    public IPSDEField getMobTaskUrlPSDEField() {
        return this.mobTaskUrlPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u4ef6\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"FILEPSDEFID"})
    public IPSDEField getFilePSDEField() {
        return this.filePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u53c2\u6570", hideempty=true, fields={"MSGQUEUEPARAMS"})
    public Properties getMsgQueueParams() {
        return this.msgQueueParams;
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u7cfb\u7edf\u529f\u80fd\u7ec4\u4ef6", hideempty=true, dumpref=true, fields={"PSSYSUTILDEID"})
    public IPSSysUtil getPSSysUtil() {
        return this.iPSSysUtil;
    }
}

