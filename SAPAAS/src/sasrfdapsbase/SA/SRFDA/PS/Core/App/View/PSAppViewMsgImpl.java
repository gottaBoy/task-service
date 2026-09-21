/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.Msg.IPSAppMsgTempl;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppViewMsg;
import SA.SRFDA.PS.Core.App.View.PSAppSysPanelPreviewViewImpl;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.View.IPSViewMsg;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.PS.Data.PSViewMsg;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppViewMsgImpl
extends PSApplicationObjectImpl
implements IPSAppViewMsg {
    private static final Log log = LogFactory.getLog(PSAppViewMsgImpl.class);
    private IPSViewMsg iPSViewMsg = null;
    private IPSAppMsgTempl iPSAppMsgTempl = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppDELogic testPSAppDELogic = null;
    private IPSLayoutPanel iPSLayoutPanel = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, IPSViewMsg iPSViewMsg) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.iPSViewMsg = iPSViewMsg;
            this.setId(iPSViewMsg.getId());
            this.setName(iPSViewMsg.getName());
            if (this.getContentPSLanguageRes() != null) {
                this.getPSApplication().getPSLanguageRes(this.getContentPSLanguageRes().getId());
            }
            if (this.getTitlePSLanguageRes() != null) {
                this.getPSApplication().getPSLanguageRes(this.getTitlePSLanguageRes().getId());
            }
            if (this.getPSViewMsg().getPSSysMsgTempl() != null) {
                this.iPSAppMsgTempl = this.getPSApplication().getPSAppMsgTempl(this.getPSViewMsg().getPSSysMsgTempl(), false);
            }
            if (StringHelper.compare((String)this.getEnableMode(), (String)"DELOGIC", (boolean)false) == 0 && this.getPSDataEntity() != null) {
                this.iPSAppDataEntity = this.getPSApplication().getPSAppDataEntity(this.getPSDataEntity(), false);
                if (this.iPSAppDataEntity != null && this.getTestPSDELogic() != null) {
                    this.testPSAppDELogic = this.iPSAppDataEntity.getPSAppDELogic(this.getTestPSDELogic().getId());
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
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
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSViewMsg psViewMsg) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getPSLayoutPanelId())) {
            try {
                PSAppView psAppView = new PSAppView();
                psAppView.setPSAPPVIEWID("PSAppViewMsgPanelView");
                psAppView.setPSAPPVIEWNAME("PSAppViewMsgPanelView");
                PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
                psDEViewCtrl.setPSDEVIEWCTRLNAME("panel");
                psDEViewCtrl.setPSDEVIEWCTRLTYPE("PANEL");
                psDEViewCtrl.setPSSYSVIEWPANELID(this.getPSLayoutPanelId());
                PSAppSysPanelPreviewViewImpl psAppSysPanelPreviewViewImpl = new PSAppSysPanelPreviewViewImpl();
                psAppSysPanelPreviewViewImpl.init(this.getDAGlobalHelper(), this.getPSAppDataEntity().getPSApplication(), psAppView, this.getPSDataEntity(), psDEViewCtrl);
                this.iPSLayoutPanel = (IPSLayoutPanel)psAppSysPanelPreviewViewImpl.getPSControl("panel");
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        if (this.getPSLayoutPanel() != null) {
            this.getPSLayoutPanel().check();
        }
        return super.onCheck();
    }

    @Override
    public IPSViewMsg getPSViewMsg() {
        return this.iPSViewMsg;
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        return this.getPSViewMsg();
    }

    @Override
    public String getModelType() {
        return "PSAPPVIEWMSG";
    }

    @Override
    public String getModelId() {
        if (this.getPSApplication() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSApplication().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934", fields={"TITLE"})
    public String getTitle() {
        return this.getPSViewMsg().getTitle();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getPSViewMsg().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u5f0f", ignoredumpvalues="0", codelist="ViewMsgDynamicMode", group="\u57fa\u672c", order=125, fields={"DYNAMICMODE"})
    public int getDynamicMode() {
        return this.getPSViewMsg().getDynamicMode();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u6a21\u677f\u5bf9\u8c61", outputdoc="false")
    public IPSSysMsgTempl getPSSysMsgTempl() {
        return this.getPSAppMsgTempl();
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u4f4d\u7f6e", codelist="ViewMsgPos", fields={"MSGPOS"})
    public String getPosition() {
        return this.getPSViewMsg().getPosition();
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6d88\u606f")
    public String getMessage() {
        return this.getPSViewMsg().getMessage();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u7c7b\u578b", codelist="ViewMsgType", group="\u57fa\u672c", order=130, fields={"MSGTYPE"})
    public String getMessageType() {
        return this.getPSViewMsg().getMessageType();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u7c7b\u578b", codelist="ViewMsgContentType", fields={"CONTENTTYPE"})
    public String getContentType() {
        return this.getPSViewMsg().getContentType();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5173\u95ed", fields={"ENABLEREMOVE"})
    public boolean isEnableRemove() {
        return this.getPSViewMsg().isEnableRemove();
    }

    @Override
    public String getMsgTemplateId() {
        return this.getPSViewMsg().getMsgTemplateId();
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934\u8bed\u8a00\u8d44\u6e90\u6807\u8bb0")
    public String getTitleLanResTag() {
        return this.getPSViewMsg().getTitleLanResTag();
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61", fields={"TITLEPSLANRESID"})
    public IPSLanguageRes getTitlePSLanguageRes() {
        return this.getPSViewMsg().getTitlePSLanguageRes();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61", fields={"CONTENTPSLANRESID"})
    public IPSLanguageRes getContentPSLanguageRes() {
        return this.getPSViewMsg().getContentPSLanguageRes();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", hideempty=true)
    public IPSSystemModule getPSSystemModule() {
        return this.getPSViewMsg().getPSSystemModule();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u5220\u9664\u6a21\u5f0f", codelist="ViewMsgRemoveMode", fields={"ENABLEREMOVE"})
    public int getRemoveMode() {
        return this.getPSViewMsg().getRemoveMode();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u552f\u4e00\u6807\u8bb0")
    public String getUniqueTag() {
        return this.getPSViewMsg().getUniqueTag();
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u6d88\u606f\u6a21\u677f", dumpref=true, from="IPSApplication", fields={"PSSYSMSGTEMPLID"})
    public IPSAppMsgTempl getPSAppMsgTempl() {
        return this.iPSAppMsgTempl;
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6d88\u606f\u542f\u7528\u6a21\u5f0f", codelist="ViewMsgEnableMode", ignoredumpvalues="ALL", fields={"ENABLEMODE"})
    public String getEnableMode() {
        return this.getPSViewMsg().getEnableMode();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u5b9e\u4f53", fields={"PSDEID"})
    public IPSDataEntity getPSDataEntity() {
        return this.getPSViewMsg().getPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u5904\u7406\u903b\u8f91")
    public IPSDELogic getTestPSDELogic() {
        return this.getPSViewMsg().getTestPSDELogic();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u64cd\u4f5c\u6807\u8bc6")
    public IPSDEOPPriv getTestPSDEOPPriv() {
        return this.getPSViewMsg().getTestPSDEOPPriv();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u811a\u672c", fields={"TESTCUSTOMCODE"})
    public String getTestScriptCode() {
        return this.getPSViewMsg().getTestScriptCode();
    }

    @Override
    public String getPSLayoutPanelId() {
        return this.getPSViewMsg().getPSLayoutPanelId();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u64cd\u4f5c\u6807\u8bc6")
    public String getDataAccessAction() {
        if (this.getTestPSDEOPPriv() != null) {
            return this.getTestPSDEOPPriv().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u5b9e\u4f53", dumpref=true, fields={"PSDEID"})
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u5b9e\u4f53\u903b\u8f91", dumpref=true, fields={"TESTPSDELOGICID"}, from="IPSAppDataEntity")
    public IPSAppDELogic getTestPSAppDELogic() {
        return this.testPSAppDELogic;
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u9762\u677f", child=true)
    public IPSLayoutPanel getPSLayoutPanel() {
        return this.iPSLayoutPanel;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u56fe\u7247", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        return this.getPSViewMsg().getPSSysImage();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u754c\u9762\u6837\u5f0f\u8868", fields={"PSSYSCSSID"})
    public IPSSysCss getPSSysCss() {
        return this.getPSViewMsg().getPSSysCss();
    }
}

