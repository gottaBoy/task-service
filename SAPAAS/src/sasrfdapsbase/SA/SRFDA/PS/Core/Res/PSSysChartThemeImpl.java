/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysChartTheme;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysChartTheme;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysChartThemeImpl
extends PSSystemObjectImpl
implements IPSSysChartTheme {
    private static final Log log = LogFactory.getLog(PSSysChartThemeImpl.class);
    protected PSSysChartTheme psSysChartTheme = null;
    private String strThemeParams = null;
    private String strThemeDesc = null;
    private IPSSystemModule iPSSystemModule = null;
    private boolean bDefaultMode = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysChartTheme psSysChartTheme) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysChartTheme = psSysChartTheme;
            this.setId(this.psSysChartTheme.getPSSYSCHARTTHEMEID());
            this.setName(this.psSysChartTheme.getPSSYSCHARTTHEMENAME());
            this.setPSObjectData(this.psSysChartTheme);
            if (!this.psSysChartTheme.isDEFAULTFLAGNull()) {
                this.bDefaultMode = this.psSysChartTheme.getDEFAULTFLAG();
            }
            this.strThemeParams = this.psSysChartTheme.getTHEMEPARAMS();
            this.strThemeDesc = this.psSysChartTheme.getTHEMEDESC();
            if (!StringHelper.isNullOrEmpty((String)this.psSysChartTheme.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysChartTheme.getPSMODULEID());
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
        return "PSSYSCHARTTHEME";
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u9898\u53c2\u6570")
    public String getThemeParams() {
        return this.strThemeParams;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u9898\u8bf4\u660e")
    public String getThemeDesc() {
        return this.strThemeDesc;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysChartTheme.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u9898\u6807\u8bb0")
    public String getThemeTag() {
        return this.psSysChartTheme.getTHEMETAG();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u9898\u6807\u8bb02")
    public String getThemeTag2() {
        return this.psSysChartTheme.getTHEMETAG2();
    }

    @Override
    public ObjectNode toModel(String strType) {
        return super.toModel(strType);
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
    @PSModelRTMeta(description="\u9ed8\u8ba4\u4e3b\u9898", ignoredumpvalues="false")
    public boolean isDefaultMode() {
        return this.bDefaultMode;
    }
}

