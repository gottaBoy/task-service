/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.View.IPSViewMsg;
import SA.SRFDA.PS.Data.PSViewMsg;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSViewMsgImpl
extends PSSystemObjectImpl
implements IPSViewMsg {
    private static final Log log = LogFactory.getLog(PSViewMsgImpl.class);
    protected PSViewMsg psViewMsg = null;
    private int nDynamicMode = DYNAMICMODE_STATIC;
    private String strTitle = null;
    private String strMsgPos = null;
    private String strCodeName = null;
    private String strMsgType = null;
    private IPSSysMsgTempl iPSSysMsgTempl = null;
    private IPSLanguageRes titlePSLanguageRes = null;
    private IPSLanguageRes contentPSLanguageRes = null;
    private boolean bEnableRemove = false;
    private String strMessage = null;
    private IPSSystemModule iPSSystemModule = null;
    private int nRemoveMode = IPSViewMsg.REMOVEMODE_NONE;
    private String strEnableMode = "ALL";
    private IPSDataEntity iPSDataEntity = null;
    private IPSDEOPPriv testPSDEOPPriv = null;
    private IPSDELogic testPSDELogic = null;
    private String strTestScriptCode = null;
    private IPSSysImage iPSSysImage = null;
    private String strContentType = null;
    private IPSSysCss iPSSysCss = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSViewMsg psViewMsg) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psViewMsg = psViewMsg;
            this.setId(this.psViewMsg.getPSVIEWMSGID());
            this.setName(this.psViewMsg.getPSVIEWMSGNAME());
            this.setPSObjectData(this.psViewMsg);
            if (!this.psViewMsg.isDYNAMICMODENull()) {
                this.nDynamicMode = this.psViewMsg.GetParamIntValue("DYNAMICMODE", this.nDynamicMode);
            }
            this.strTitle = this.psViewMsg.getTITLE();
            this.strMsgPos = this.psViewMsg.getMSGPOS();
            this.strMsgType = this.psViewMsg.getMSGTYPE();
            this.strCodeName = this.psViewMsg.getCODENAME();
            this.strMessage = this.psViewMsg.getCONTENT();
            this.strContentType = this.psViewMsg.getCONTENTTYPE();
            if (!this.psViewMsg.isENABLEREMOVENull()) {
                this.nRemoveMode = this.psViewMsg.GetParamIntValue("ENABLEREMOVE", IPSViewMsg.REMOVEMODE_NONE);
                boolean bl = this.bEnableRemove = this.getRemoveMode() != IPSViewMsg.REMOVEMODE_NONE.intValue();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psViewMsg.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psViewMsg.getPSMODULEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psViewMsg.getPSDEID())) {
                this.iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psViewMsg.getPSDEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psViewMsg.getENABLEMODE())) {
                this.strEnableMode = this.psViewMsg.getENABLEMODE();
                if (StringHelper.compare((String)this.getEnableMode(), (String)"DELOGIC", (boolean)false) == 0 || StringHelper.compare((String)this.getEnableMode(), (String)"DEOPPRIV", (boolean)false) == 0) {
                    if (this.getPSDataEntity() == null) {
                        throw new Exception("\u6ca1\u6709\u6307\u5b9a\u89c6\u56fe\u6d88\u606f\u6240\u5f15\u7528\u7684\u5b9e\u4f53");
                    }
                    if (StringHelper.compare((String)this.getEnableMode(), (String)"DELOGIC", (boolean)false) == 0) {
                        if (StringHelper.isNullOrEmpty((String)this.psViewMsg.getTESTPSDELOGICID())) {
                            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u542f\u7528\u5224\u65ad\u7684\u5904\u7406\u903b\u8f91");
                        }
                        this.testPSDELogic = this.getPSDataEntity().getPSDELogic(this.psViewMsg.getTESTPSDELOGICID());
                    } else if (StringHelper.compare((String)this.getEnableMode(), (String)"DEOPPRIV", (boolean)false) == 0) {
                        if (StringHelper.isNullOrEmpty((String)this.psViewMsg.getPSDEOPPRIVID())) {
                            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u542f\u7528\u5224\u65ad\u7684\u64cd\u4f5c\u6807\u8bc6");
                        }
                        this.testPSDEOPPriv = this.getPSDataEntity().getPSDEOPPriv(this.psViewMsg.getPSDEOPPRIVID());
                    }
                } else if (StringHelper.compare((String)this.getEnableMode(), (String)"SCRIPT", (boolean)false) == 0) {
                    if (StringHelper.isNullOrEmpty((String)this.psViewMsg.getTESTCUSTOMCODE())) {
                        throw new Exception("\u6ca1\u6709\u6307\u5b9a\u542f\u7528\u5224\u65ad\u7684\u811a\u672c\u4ee3\u7801");
                    }
                    this.strTestScriptCode = this.psViewMsg.getTESTCUSTOMCODE();
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psViewMsg.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSSystem().getPSSysImage(this.psViewMsg.getPSSYSIMAGEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psViewMsg.getPSSYSCSSID())) {
                this.iPSSysCss = this.getPSSystem().getPSSysCss(this.psViewMsg.getPSSYSCSSID());
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
        if (!StringHelper.isNullOrEmpty((String)this.psViewMsg.getPSSYSMSGTEMPLID())) {
            this.iPSSysMsgTempl = this.getPSSystem().getPSSysMsgTempl(this.psViewMsg.getPSSYSMSGTEMPLID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psViewMsg.getTITLEPSLANRESID())) {
            this.titlePSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psViewMsg.getTITLEPSLANRESID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psViewMsg.getCONTENTPSLANRESID())) {
            this.contentPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psViewMsg.getCONTENTPSLANRESID());
        }
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSVIEWMSG";
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934", fields={"TITLE"})
    public String getTitle() {
        return this.strTitle;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        return this.strCodeName;
    }

    @Override
    public int getDynamicMode() {
        return this.nDynamicMode;
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u6a21\u677f\u5bf9\u8c61", fields={"PSSYSMSGTEMPLID"})
    public IPSSysMsgTempl getPSSysMsgTempl() {
        return this.iPSSysMsgTempl;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u4f4d\u7f6e", codelist="ViewMsgPos", fields={"MSGPOS"})
    public String getPosition() {
        return this.strMsgPos;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6d88\u606f", fields={"CONTENT"})
    public String getMessage() {
        return this.strMessage;
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u7c7b\u578b", codelist="ViewMsgType", fields={"MSGTYPE"})
    public String getMessageType() {
        return this.strMsgType;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u79fb\u9664", fields={"ENABLEREMOVE"})
    public boolean isEnableRemove() {
        return this.bEnableRemove;
    }

    @Override
    public String getMsgTemplateId() {
        if (this.getPSSysMsgTempl() != null) {
            return this.getPSSysMsgTempl().getId();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934\u8bed\u8a00\u8d44\u6e90\u6807\u8bb0")
    public String getTitleLanResTag() {
        if (this.getTitlePSLanguageRes() == null) {
            return null;
        }
        return this.getTitlePSLanguageRes().getLanResTag();
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getTitlePSLanguageRes() {
        return this.titlePSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", hideempty=true, dumpref=true)
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u5220\u9664\u6a21\u5f0f", codelist="ViewMsgRemoveMode", fields={"ENABLEREMOVE"})
    public int getRemoveMode() {
        return this.nRemoveMode;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getContentPSLanguageRes() {
        return this.contentPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6d88\u606f\u552f\u4e00\u6807\u8bb0")
    public String getUniqueTag() {
        if (this.getPSSystemModule() != null) {
            if (this.getPSSystemModule().getPSSysModelGroup() != null) {
                return String.format("%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysModelGroup().getCodeName(), this.getPSSystemModule().getCodeName(), this.getCodeName());
            }
            if (this.getPSSystemModule().getPSSysRef() != null) {
                return String.format("%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysRef().getSysRefTag(), this.getPSSystemModule().getCodeName(), this.getCodeName());
            }
            return String.format("%1$s__%2$s", this.getPSSystemModule().getCodeName(), this.getCodeName());
        }
        return this.getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6d88\u606f\u542f\u7528\u6a21\u5f0f", codelist="ViewMsgEnableMode", ignoredumpvalues="ALL", fields={"ENABLEMODE"})
    public String getEnableMode() {
        return this.strEnableMode;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u5b9e\u4f53", dumpref=true, ignorepf=true, fields={"PSDEID"})
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    protected void setPSDataEntity(IPSDataEntity iPSDataEntity) {
        this.iPSDataEntity = iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u5904\u7406\u903b\u8f91", dumpref=true, ignorepf=true, fields={"TESTPSDELOGICID"}, from="IPSDataEntity")
    public IPSDELogic getTestPSDELogic() {
        return this.testPSDELogic;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u64cd\u4f5c\u6807\u8bc6", ignorepf=true, fields={"PSDEOPPRIVID"})
    public IPSDEOPPriv getTestPSDEOPPriv() {
        return this.testPSDEOPPriv;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u811a\u672c", fields={"TESTCUSTOMCODE"})
    public String getTestScriptCode() {
        return this.strTestScriptCode;
    }

    @Override
    public String getPSLayoutPanelId() {
        return this.psViewMsg.getPSSYSVIEWPANELID();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u56fe\u7247", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u754c\u9762\u6837\u5f0f\u8868", fields={"PSSYSCSSID"})
    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u7c7b\u578b", codelist="ViewMsgContentType", fields={"CONTENTTYPE"})
    public String getContentType() {
        return this.strContentType;
    }
}

