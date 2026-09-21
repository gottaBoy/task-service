/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSDEFInputTip;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.PSDEFieldObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSDEFInputTipSet;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSDEFInputTip;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFInputTipImpl
extends PSDEFieldObjectImpl
implements IPSDEFInputTip {
    private static final Log log = LogFactory.getLog(PSDEFInputTipImpl.class);
    protected PSDEFInputTip psDEFInputTip = null;
    private boolean bDefault = true;
    private String strContent = "";
    private String strMoreUrl = "";
    private boolean bEnableClose = false;
    private IPSLanguageRes contentPSLanguageRes = null;
    private IPSDEFInputTipSet iPSDEFInputTipSet = null;
    private String strUniqueTag = "";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEField iPSDEField, PSDEFInputTip psDEFInputTip) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEField(iPSDEField);
            this.psDEFInputTip = psDEFInputTip;
            this.setId(this.psDEFInputTip.getPSDEFINPUTTIPID());
            this.setName(this.psDEFInputTip.getPSDEFINPUTTIPNAME());
            this.setPSObjectData(this.psDEFInputTip);
            if (!this.psDEFInputTip.isDEFAULTFLAGNull()) {
                this.bDefault = this.psDEFInputTip.getDEFAULTFLAG();
            }
            this.strContent = this.getRawContent();
            if (StringHelper.isNullOrEmpty((String)this.strContent)) {
                this.strContent = this.getHtmlContent();
            }
            this.strMoreUrl = this.psDEFInputTip.getMOREURL();
            if (!this.psDEFInputTip.isENABLECLOSENull()) {
                this.bEnableClose = this.psDEFInputTip.getENABLECLOSE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEFInputTip.getCONTENTPSLANRESID())) {
                this.contentPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEFInputTip.getCONTENTPSLANRESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEFInputTip.getPSDEFINPUTTIPSETID())) {
                this.iPSDEFInputTipSet = this.getPSDataEntity().getPSSystem().getPSDEFInputTipSet(this.psDEFInputTip.getPSDEFINPUTTIPSETID());
                this.strUniqueTag = this.psDEFInputTip.getUNIQUETAG();
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
    @PSModelRTMeta(description="\u5c5e\u6027\u9ed8\u8ba4\u8f93\u5165\u63d0\u793a", fields={"DEFAULTFLAG"})
    public boolean isDefault() {
        return this.bDefault;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9")
    public String getContent() {
        return this.strContent;
    }

    @PSModelRTMeta(description="\u66f4\u591a\u5185\u5bb9\u94fe\u63a5", fields={"MOREURL"})
    public String getMoreUrl() {
        return this.strMoreUrl;
    }

    @PSModelRTMeta(description="\u652f\u6301\u5173\u95ed", fields={"ENABLECLOSE"})
    public boolean isEnableClose() {
        return this.bEnableClose;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u8bed\u8a00\u8d44\u6e90", fields={"CONTENTPSLANRESID"})
    public IPSLanguageRes getContentPSLanguageRes() {
        return this.contentPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u96c6\u5408")
    public IPSDEFInputTipSet getPSDEFInputTipSet() {
        return this.iPSDEFInputTipSet;
    }

    @Override
    @PSModelRTMeta(description="\u552f\u4e00\u6807\u8bb0", fields={"UNIQUETAG"})
    public String getUniqueTag() {
        return this.strUniqueTag;
    }

    @PSModelRTMeta(description="\u5185\u5bb9\u8bed\u8a00\u8d44\u6e90\u6807\u8bb0", doc="\u7b49\u540c\u8c03\u7528{@link #getContentPSLanguageRes}.getLanResTag()")
    public String getContentLanResTag() {
        if (this.getContentPSLanguageRes() == null) {
            return null;
        }
        return this.getContentPSLanguageRes().getLanResTag();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psDEFInputTip.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u6a21\u5f0f", fields={"TIPMODE"})
    public String getTipMode() {
        return this.psDEFInputTip.getTIPMODE();
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u5185\u5bb9", fields={"RAWCONTENT"})
    public String getRawContent() {
        return this.psDEFInputTip.getRAWCONTENT();
    }

    @Override
    @PSModelRTMeta(description="Html\u5185\u5bb9", fields={"CONTENT"})
    public String getHtmlContent() {
        return this.psDEFInputTip.getCONTENT();
    }

    @Override
    public String getModelType() {
        return "PSDEFINPUTTIP";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEField().getModelId(), (Object)super.getModelId());
    }
}

