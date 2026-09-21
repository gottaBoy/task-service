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
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysMsgTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysMsgTemplImpl
extends PSSystemObjectImpl
implements IPSSysMsgTempl {
    private static final Log log = LogFactory.getLog(PSSysMsgTemplImpl.class);
    protected PSSysMsgTempl psSysMsgTempl = null;
    private IPSLanguageRes contentPSLanguageRes = null;
    private IPSLanguageRes subPSLanguageRes = null;
    private IPSLanguageRes imPSLanguageRes = null;
    private IPSLanguageRes smsPSLanguageRes = null;
    private IPSLanguageRes wxPSLanguageRes = null;
    private IPSLanguageRes ddPSLanguageRes = null;
    private IPSSystemModule iPSSystemModule = null;
    private int nScriptMode = 0;
    private String strMsgTemplType = "STATIC";
    private String strMsgTemplEngine = "FREEMARKER";
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSXCodeObject iPSXCodeObject = null;
    private Properties msgTemplParams = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSDEField contentPSDEField = null;
    private IPSDEField contentTypePSDEField = null;
    private IPSDEField subjectPSDEField = null;
    private IPSDEField templTagPSDEField = null;
    private IPSDEField userPSDEField = null;
    private IPSDEField user2PSDEField = null;
    private IPSDEField taskUrlPSDEField = null;
    private IPSDEField mobTaskUrlPSDEField = null;
    private IPSDEField lanPSDEField = null;
    private IPSDEField smsContentPSDEField = null;
    private IPSDEField imContentPSDEField = null;
    private IPSDEField wxContentPSDEField = null;
    private IPSDEField ddContentPSDEField = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysMsgTempl psSysMsgTempl) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysMsgTempl = psSysMsgTempl;
            this.setId(this.psSysMsgTempl.getPSSYSMSGTEMPLID());
            this.setName(this.psSysMsgTempl.getPSSYSMSGTEMPLNAME());
            this.setPSObjectData(this.psSysMsgTempl);
            if (!StringHelper.isNullOrEmpty((String)psSysMsgTempl.getMSGTEMPLTYPE())) {
                this.strMsgTemplType = psSysMsgTempl.getMSGTEMPLTYPE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getCONTENTPSLANRESID())) {
                this.contentPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psSysMsgTempl.getCONTENTPSLANRESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getSUBPSLANRESID())) {
                this.subPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psSysMsgTempl.getSUBPSLANRESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getIMPSLANRESID())) {
                this.imPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psSysMsgTempl.getIMPSLANRESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getSMSPSLANRESID())) {
                this.smsPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psSysMsgTempl.getSMSPSLANRESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getWXPSLANRESID())) {
                this.wxPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psSysMsgTempl.getWXPSLANRESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getDDPSLANRESID())) {
                this.ddPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psSysMsgTempl.getDDPSLANRESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysMsgTempl.getPSMODULEID());
            }
            if (!this.psSysMsgTempl.isCUSTOMMODENull()) {
                this.nScriptMode = this.psSysMsgTempl.getCUSTOMMODE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getTEMPLENGINE())) {
                this.strMsgTemplEngine = this.psSysMsgTempl.getTEMPLENGINE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getMSGTEMPLPARAMS())) {
                this.msgTemplParams = PropertiesHelper.load((String)this.psSysMsgTempl.getMSGTEMPLPARAMS());
            }
            if (StringHelper.compare((String)this.getMsgTemplType(), (String)"DE", (boolean)false) == 0) {
                if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getPSDEID())) {
                    this.iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psSysMsgTempl.getPSDEID());
                    if (this.getPSDataEntity() != null) {
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getPSDEDSID())) {
                            this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psSysMsgTempl.getPSDEDSID());
                        }
                        if (StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getTEMPLTAGPSDEFID())) {
                            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6a21\u677f\u6807\u8bb0\u503c\u5c5e\u6027");
                        }
                        this.templTagPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgTempl.getTEMPLTAGPSDEFID());
                        if (StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getCONTENTPSDEFID())) {
                            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5185\u5bb9\u503c\u5c5e\u6027");
                        }
                        this.contentPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgTempl.getCONTENTPSDEFID());
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getCONTENTTYPEPSDEFID())) {
                            this.contentTypePSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgTempl.getCONTENTTYPEPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getSUBJECTPSDEFID())) {
                            this.subjectPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgTempl.getSUBJECTPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getUSERPSDEFID())) {
                            this.userPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgTempl.getUSERPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getUSER2PSDEFID())) {
                            this.user2PSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgTempl.getUSER2PSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getTASKURLPSDEFID())) {
                            this.taskUrlPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgTempl.getTASKURLPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getMOBTASKURLPSDEFID())) {
                            this.mobTaskUrlPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgTempl.getMOBTASKURLPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getLANPSDEFID())) {
                            this.lanPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgTempl.getLANPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getSMSCONTENTPSDEFID())) {
                            this.smsContentPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgTempl.getSMSCONTENTPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getIMCONTENTPSDEFID())) {
                            this.imContentPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgTempl.getIMCONTENTPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getWCCONTENTPSDEFID())) {
                            this.wxContentPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgTempl.getWCCONTENTPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getDDCONTENTPSDEFID())) {
                            this.ddContentPSDEField = this.getPSDataEntity().getPSDEField(this.psSysMsgTempl.getDDCONTENTPSDEFID());
                        }
                    }
                } else {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6d88\u606f\u6a21\u677f\u6240\u5b58\u50a8\u7684\u5b9e\u4f53");
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getPSSYSSFPLUGINID())) {
                this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.psSysMsgTempl.getPSSYSSFPLUGINID());
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
    protected int onCheck() throws Exception {
        if (this.getScriptMode() != 0 && StringHelper.isNullOrEmpty((String)this.getScriptCode())) {
            throw new Exception("\u672a\u5b9a\u4e49\u811a\u672c\u4ee3\u7801");
        }
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9", group="\u57fa\u672c", order=230, doctype="md", fields={"CONTENT"})
    public String getContent() {
        return this.psSysMsgTempl.getCONTENT();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u7c7b\u578b", codelist="MsgContentType", group="\u57fa\u672c", order=125, fields={"CONTENTTYPE"})
    public String getContentType() {
        return this.psSysMsgTempl.getCONTENTTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u5373\u65f6\u6d88\u606f\u5185\u5bb9", group="\u57fa\u672c", order=236, doctype="md", fields={"IMCONTENT"})
    public String getIMContent() {
        return this.psSysMsgTempl.getIMCONTENT();
    }

    @Override
    @PSModelRTMeta(description="\u90ae\u4ef6\u7fa4\u7ec4\u53d1\u9001", fields={"MAILGROUPSEND"})
    public boolean isMailGroupSend() {
        return this.psSysMsgTempl.getMAILGROUPSEND();
    }

    @Override
    @PSModelRTMeta(description="\u77ed\u6d88\u606f\u5185\u5bb9", group="\u57fa\u672c", order=233, doctype="md", fields={"SMSCONTENT"})
    public String getSMSContent() {
        return this.psSysMsgTempl.getSMSCONTENT();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898", group="\u57fa\u672c", order=228, fields={"SUBJECT"})
    public String getSubject() {
        return this.psSysMsgTempl.getSUBJECT();
    }

    @Override
    @Deprecated
    public String getWCContent() {
        return this.psSysMsgTempl.getWCCONTENT();
    }

    @Override
    public String getModelType() {
        return "PSSYSMSGTEMPL";
    }

    @Override
    @PSModelRTMeta(description="\u5fae\u4fe1\u5185\u5bb9", group="\u57fa\u672c", order=232, doctype="md", fields={"WCCONTENT"})
    public String getWXContent() {
        return this.psSysMsgTempl.getWCCONTENT();
    }

    @Override
    @PSModelRTMeta(description="\u9489\u9489\u5185\u5bb9", group="\u57fa\u672c", order=234, doctype="md", fields={"DDCONTENT"})
    public String getDDContent() {
        return this.psSysMsgTempl.getDDCONTENT();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61", fields={"CONTENTPSLANRESID"})
    public IPSLanguageRes getContentPSLanguageRes() {
        return this.contentPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u5373\u65f6\u6d88\u606f\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61", fields={"IMPSLANRESID"})
    public IPSLanguageRes getIMPSLanguageRes() {
        return this.imPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u77ed\u6d88\u606f\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61", fields={"SMSPSLANRESID"})
    public IPSLanguageRes getSMSPSLanguageRes() {
        return this.smsPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61", fields={"SUBPSLANRESID"})
    public IPSLanguageRes getSubPSLanguageRes() {
        return this.subPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u5fae\u4fe1\u5185\u5bb9\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61", fields={"WXPSLANRESID"})
    public IPSLanguageRes getWXPSLanguageRes() {
        return this.wxPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u9489\u9489\u5185\u5bb9\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61", fields={"DDPSLANRESID"})
    public IPSLanguageRes getDDPSLanguageRes() {
        return this.ddPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysMsgTempl.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, hideempty=true, dynamodelmode=4, fields={"PSMODULEID"})
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
    @PSModelRTMeta(description="\u4efb\u52a1\u64cd\u4f5c\u8def\u5f84", hideempty2=true, fields={"TASKURL"})
    public String getTaskUrl() {
        return this.psSysMsgTempl.getTASKURL();
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u4efb\u52a1\u64cd\u4f5c\u8def\u5f84", hideempty2=true, fields={"MOBTASKURL"})
    public String getMobTaskUrl() {
        return this.psSysMsgTempl.getMOBTASKURL();
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u6a21\u5f0f", codelist="ScriptMode", ignorepf=true, ignoredumpvalues="0", fields={"CUSTOMMODE"})
    public int getScriptMode() {
        return this.nScriptMode;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", ignorepf=true, fields={"CUSTOMCODE"})
    public String getScriptCode() {
        if (this.getScriptMode() == 0) {
            return null;
        }
        if (StringHelper.isNullOrEmpty((String)this.psSysMsgTempl.getCUSTOMCODE())) {
            return null;
        }
        return this.psSysMsgTempl.getCUSTOMCODE();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u6a21\u677f\u7c7b\u578b", ignorepf=true, codelist="MsgTemplType", ignoredumpvalues="STATIC", fields={"MSGTEMPLTYPE"})
    public String getMsgTemplType() {
        return this.strMsgTemplType;
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u6a21\u677f\u5f15\u64ce", ignorepf=true, codelist="MsgTemplEngine", ignoredumpvalues="FREEMARKER", fields={"TEMPLENGINE"})
    public String getTemplEngine() {
        return this.strMsgTemplEngine;
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u6a21\u677f\u6807\u8bb0", ignorepf=true, fields={"MSGTEMPLTAG"})
    public String getMsgTemplTag() {
        return this.psSysMsgTempl.getMSGTEMPLTAG();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u6a21\u677f\u6807\u8bb02", ignorepf=true, fields={"MSGTEMPLTAG2"})
    public String getMsgTemplTag2() {
        return this.psSysMsgTempl.getMSGTEMPLTAG2();
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
    @PSModelRTMeta(description="\u52a8\u6001\u53c2\u6570", hideempty=true, ignorepf=true, fields={"MSGTEMPLPARAMS"})
    public Properties getMsgTemplParams() {
        return this.msgTemplParams;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", dumpref=true, ignorepf=true, fields={"PSDEID"})
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u6570\u636e\u96c6", dumpref=true, ignorepf=true, from="IPSDataEntity", fields={"PSDEDSID"})
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u677f\u5185\u5bb9\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, ignorepf=true, from="IPSDataEntity", fields={"CONTENTPSDEFID"})
    public IPSDEField getContentPSDEField() {
        return this.contentPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u677f\u6807\u8bb0\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, ignorepf=true, from="IPSDataEntity", fields={"TEMPLTAGPSDEFID"})
    public IPSDEField getTemplTagPSDEField() {
        return this.templTagPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u81ea\u5b9a\u4e49\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, ignorepf=true, from="IPSDataEntity", fields={"USERPSDEFID"})
    public IPSDEField getUserPSDEField() {
        return this.userPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u81ea\u5b9a\u4e492\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, ignorepf=true, from="IPSDataEntity", fields={"USER2PSDEFID"})
    public IPSDEField getUser2PSDEField() {
        return this.user2PSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, ignorepf=true, from="IPSDataEntity", fields={"SUBJECTPSDEFID"})
    public IPSDEField getSubjectPSDEField() {
        return this.subjectPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u7c7b\u578b\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, ignorepf=true, from="IPSDataEntity", fields={"CONTENTTYPEPSDEFID"})
    public IPSDEField getContentTypePSDEField() {
        return this.contentTypePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u4efb\u52a1\u8def\u5f84\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, ignorepf=true, from="IPSDataEntity", fields={"TASKURLPSDEFID"})
    public IPSDEField getTaskUrlPSDEField() {
        return this.taskUrlPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u4efb\u52a1\u8def\u5f84\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, ignorepf=true, from="IPSDataEntity", fields={"MOBTASKURLPSDEFID"})
    public IPSDEField getMobTaskUrlPSDEField() {
        return this.mobTaskUrlPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u8bed\u8a00\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, ignorepf=true, from="IPSDataEntity", fields={"LANPSDEFID"})
    public IPSDEField getLanPSDEField() {
        return this.lanPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u77ed\u6d88\u606f\u6a21\u677f\u5185\u5bb9\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, ignorepf=true, from="IPSDataEntity", fields={"SMSCONTENTPSDEFID"})
    public IPSDEField getSMSContentPSDEField() {
        return this.smsContentPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5373\u65f6\u6d88\u606f\u6a21\u677f\u5185\u5bb9\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, ignorepf=true, from="IPSDataEntity", fields={"IMCONTENTPSDEFID"})
    public IPSDEField getIMContentPSDEField() {
        return this.imContentPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5fae\u4fe1\u6d88\u606f\u6a21\u677f\u5185\u5bb9\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, ignorepf=true, from="IPSDataEntity", fields={"WCCONTENTPSDEFID"})
    public IPSDEField getWXContentPSDEField() {
        return this.wxContentPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9489\u9489\u6d88\u606f\u6a21\u677f\u5185\u5bb9\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, ignorepf=true, from="IPSDataEntity", fields={"DDCONTENTPSDEFID"})
    public IPSDEField getDDContentPSDEField() {
        return this.ddContentPSDEField;
    }
}

