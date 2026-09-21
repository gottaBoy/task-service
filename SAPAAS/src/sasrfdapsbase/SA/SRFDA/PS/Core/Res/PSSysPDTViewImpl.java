/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysPDTView;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysPDTView;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysPDTViewImpl
extends PSSystemObjectImpl
implements IPSSysPDTView {
    private static final Log log = LogFactory.getLog(PSSysPDTViewImpl.class);
    protected PSSysPDTView psSysPDTView = null;
    private IPSSystemModule iPSSystemModule = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private boolean bFromDEViewToPDTView = false;
    private IPSDataEntity viewPSDataEntity = null;
    private IPSDataEntity mobViewPSDataEntity = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysPDTView psSysPDTView) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysPDTView = psSysPDTView;
            this.setId(this.psSysPDTView.getPSSYSPDTVIEWID());
            this.setName(this.psSysPDTView.getPSSYSPDTVIEWNAME());
            this.setPSObjectData(this.psSysPDTView);
            if (!this.psSysPDTView.isFROMDEVIEWFLAGNull()) {
                this.bFromDEViewToPDTView = this.psSysPDTView.getFROMDEVIEWFLAG();
            }
            if (this.isFromDEViewToPDTView() && StringHelper.isNullOrEmpty((String)this.getPSDEViewBaseId())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b9a\u5411\u7684\u5b9e\u4f53\u89c6\u56fe");
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysPDTView.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psSysPDTView.getCAPPSLANRESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysPDTView.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysPDTView.getPSMODULEID());
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
    public String getPSPDTViewId() {
        return this.psSysPDTView.getPSPDTVIEWID();
    }

    @Override
    public String getPSDEViewBaseId() {
        return this.psSysPDTView.getPSDEVIEWBASEID();
    }

    @Override
    public String getMobPSDEViewBaseId() {
        return this.psSysPDTView.getMOBPSDEVIEWID();
    }

    @Override
    public String getCaption(String strLanguage) {
        return this.getName();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        return this.getName();
    }

    @Override
    public String getModelType() {
        return "PSSYSPDTVIEW";
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
        return this.psSysPDTView.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, fields={"PSMODULEID"})
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"CAPPSLANRESID"})
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u4ece\u5b9e\u4f53\u89c6\u56fe\u5b9a\u5411\u9884\u7f6e\u89c6\u56fe", ignoredumpvalues="false", fields={"FROMDEVIEWFLAG"})
    public boolean isFromDEViewToPDTView() {
        return this.bFromDEViewToPDTView;
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
    @PSModelRTMeta(description="\u89c6\u56fe\u76f8\u5173\u5b9e\u4f53", dumpref=true, fields={"VIEWPSDEID"})
    public IPSDataEntity getViewPSDataEntity() throws Exception {
        if (this.viewPSDataEntity == null && !StringHelper.isNullOrEmpty((String)this.psSysPDTView.getVIEWPSDEID())) {
            this.viewPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psSysPDTView.getVIEWPSDEID());
        }
        return this.viewPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u4ee3\u7801\u6807\u8bc6", fields={"VIEWCODENAME"})
    public String getViewCodeName() {
        return this.psSysPDTView.getVIEWCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u89c6\u56fe\u76f8\u5173\u5b9e\u4f53", dumpref=true, fields={"MOBVIEWPSDEID"})
    public IPSDataEntity getMobViewPSDataEntity() throws Exception {
        if (this.mobViewPSDataEntity == null && !StringHelper.isNullOrEmpty((String)this.psSysPDTView.getMOBVIEWPSDEID())) {
            this.mobViewPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psSysPDTView.getMOBVIEWPSDEID());
        }
        return this.mobViewPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u89c6\u56fe\u4ee3\u7801\u6807\u8bc6", fields={"MOBVIEWCODENAME"})
    public String getMobViewCodeName() {
        return this.psSysPDTView.getMOBVIEWCODENAME();
    }
}

