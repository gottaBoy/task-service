/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Msg;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.Msg.IPSAppMsgTempl;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysMsgTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppMsgTemplImpl
extends PSApplicationObjectImpl
implements IPSAppMsgTempl {
    private static final Log log = LogFactory.getLog(PSAppMsgTemplImpl.class);
    private IPSSysMsgTempl iPSSysMsgTempl = null;
    private String strCodeName = null;

    @Override
    public IPSDEField getSMSContentPSDEField() {
        return null;
    }

    @Override
    public IPSDEField getIMContentPSDEField() {
        return null;
    }

    @Override
    public IPSDEField getWXContentPSDEField() {
        return null;
    }

    @Override
    public IPSDEField getDDContentPSDEField() {
        return null;
    }

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, IPSSysMsgTempl iPSSysMsgTempl) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.iPSSysMsgTempl = iPSSysMsgTempl;
            this.setId(iPSSysMsgTempl.getId());
            this.setName(iPSSysMsgTempl.getName());
            if (this.getContentPSLanguageRes() != null) {
                this.getPSApplication().getPSLanguageRes(this.getContentPSLanguageRes().getId());
            }
            if (this.getDDPSLanguageRes() != null) {
                this.getPSApplication().getPSLanguageRes(this.getDDPSLanguageRes().getId());
            }
            if (this.getIMPSLanguageRes() != null) {
                this.getPSApplication().getPSLanguageRes(this.getIMPSLanguageRes().getId());
            }
            if (this.getSMSPSLanguageRes() != null) {
                this.getPSApplication().getPSLanguageRes(this.getSMSPSLanguageRes().getId());
            }
            if (this.getSubPSLanguageRes() != null) {
                this.getPSApplication().getPSLanguageRes(this.getSubPSLanguageRes().getId());
            }
            if (this.getWXPSLanguageRes() != null) {
                this.getPSApplication().getPSLanguageRes(this.getWXPSLanguageRes().getId());
            }
            this.strCodeName = this.getPSSystemModule() != null ? String.format("%1$s__%2$s", this.getPSSystemModule().getCodeName(), iPSSysMsgTempl.getCodeName()) : iPSSysMsgTempl.getCodeName();
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
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysMsgTempl psSysMsgTempl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6d88\u606f\u6a21\u677f", dump=false)
    public IPSSysMsgTempl getPSSysMsgTempl() {
        return this.iPSSysMsgTempl;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9")
    public String getContent() {
        return this.getPSSysMsgTempl().getContent();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u7c7b\u578b", codelist="MsgContentType")
    public String getContentType() {
        return this.getPSSysMsgTempl().getContentType();
    }

    @Override
    @PSModelRTMeta(description="\u5373\u65f6\u6d88\u606f\u5185\u5bb9")
    public String getIMContent() {
        return this.getPSSysMsgTempl().getIMContent();
    }

    @Override
    @PSModelRTMeta(description="\u90ae\u4ef6\u7fa4\u7ec4\u53d1\u9001")
    public boolean isMailGroupSend() {
        return this.getPSSysMsgTempl().isMailGroupSend();
    }

    @Override
    @PSModelRTMeta(description="\u77ed\u6d88\u606f\u5185\u5bb9")
    public String getSMSContent() {
        return this.getPSSysMsgTempl().getSMSContent();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898")
    public String getSubject() {
        return this.getPSSysMsgTempl().getSubject();
    }

    @Override
    @Deprecated
    public String getWCContent() {
        return this.getPSSysMsgTempl().getWCContent();
    }

    @Override
    public String getModelType() {
        return "PSAPPMSGTEMPL";
    }

    @Override
    @PSModelRTMeta(description="\u5fae\u4fe1\u5185\u5bb9")
    public String getWXContent() {
        return this.getPSSysMsgTempl().getWXContent();
    }

    @Override
    @PSModelRTMeta(description="\u9489\u9489\u5185\u5bb9")
    public String getDDContent() {
        return this.getPSSysMsgTempl().getDDContent();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getContentPSLanguageRes() {
        return this.getPSSysMsgTempl().getContentPSLanguageRes();
    }

    @Override
    @PSModelRTMeta(description="\u5373\u65f6\u6d88\u606f\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getIMPSLanguageRes() {
        return this.getPSSysMsgTempl().getIMPSLanguageRes();
    }

    @Override
    @PSModelRTMeta(description="\u77ed\u6d88\u606f\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getSMSPSLanguageRes() {
        return this.getPSSysMsgTempl().getSMSPSLanguageRes();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getSubPSLanguageRes() {
        return this.getPSSysMsgTempl().getSubPSLanguageRes();
    }

    @Override
    @PSModelRTMeta(description="\u5fae\u4fe1\u5185\u5bb9\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getWXPSLanguageRes() {
        return this.getPSSysMsgTempl().getWXPSLanguageRes();
    }

    @Override
    @PSModelRTMeta(description="\u9489\u9489\u5185\u5bb9\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getDDPSLanguageRes() {
        return this.getPSSysMsgTempl().getDDPSLanguageRes();
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
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.getPSSysMsgTempl().getPSSystemModule();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        return this.getPSSysMsgTempl().getPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u4efb\u52a1\u64cd\u4f5c\u8def\u5f84", hideempty2=true)
    public String getTaskUrl() {
        return this.getPSSysMsgTempl().getTaskUrl();
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u4efb\u52a1\u64cd\u4f5c\u8def\u5f84", hideempty2=true)
    public String getMobTaskUrl() {
        return this.getPSSysMsgTempl().getMobTaskUrl();
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u6a21\u5f0f", codelist="ScriptMode", ignorepf=true, ignoredumpvalues="0")
    public int getScriptMode() {
        return this.getPSSysMsgTempl().getScriptMode();
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", ignorepf=true)
    public String getScriptCode() {
        return this.getPSSysMsgTempl().getScriptCode();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u6a21\u677f\u7c7b\u578b", ignorepf=true, codelist="MsgTemplType", ignoredumpvalues="STATIC")
    public String getMsgTemplType() {
        return this.getPSSysMsgTempl().getMsgTemplType();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u6a21\u677f\u5f15\u64ce", ignorepf=true, codelist="MsgTemplEngine", ignoredumpvalues="FREEMARKER")
    public String getTemplEngine() {
        return this.getPSSysMsgTempl().getTemplEngine();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u6a21\u677f\u6807\u8bb0", ignorepf=true)
    public String getMsgTemplTag() {
        return this.getPSSysMsgTempl().getMsgTemplTag();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u6a21\u677f\u6807\u8bb02", ignorepf=true)
    public String getMsgTemplTag2() {
        return this.getPSSysMsgTempl().getMsgTemplTag2();
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return null;
    }

    @Override
    public IPSXCodeObject getRender() {
        return null;
    }

    @Override
    public Properties getMsgTemplParams() {
        return null;
    }

    @Override
    public IPSDataEntity getPSDataEntity() {
        return null;
    }

    @Override
    public IPSDEDataSet getPSDEDataSet() {
        return null;
    }

    @Override
    public IPSDEField getTemplTagPSDEField() {
        return null;
    }

    @Override
    public IPSDEField getUserPSDEField() {
        return null;
    }

    @Override
    public IPSDEField getUser2PSDEField() {
        return null;
    }

    @Override
    public IPSDEField getSubjectPSDEField() {
        return null;
    }

    @Override
    public IPSDEField getContentPSDEField() {
        return null;
    }

    @Override
    public IPSDEField getContentTypePSDEField() {
        return null;
    }

    @Override
    public IPSDEField getTaskUrlPSDEField() {
        return null;
    }

    @Override
    public IPSDEField getMobTaskUrlPSDEField() {
        return null;
    }

    @Override
    public IPSDEField getLanPSDEField() {
        return null;
    }
}

