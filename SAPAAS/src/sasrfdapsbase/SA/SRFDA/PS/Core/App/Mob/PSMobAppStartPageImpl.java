/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Mob;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.Mob.IPSMobAppStartPage;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSMobAppStartPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMobAppStartPageImpl
extends PSApplicationObjectImpl
implements IPSMobAppStartPage {
    private static final Log log = LogFactory.getLog(PSMobAppStartPageImpl.class);
    protected PSMobAppStartPage psMobAppStartPage = null;
    private String strFilePath = null;
    private int nWidth = 0;
    private int nHeight = 0;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSMobAppStartPage psMobAppStartPage) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.psMobAppStartPage = psMobAppStartPage;
            this.setId(this.psMobAppStartPage.getPSMOBAPPSTARTPAGEID());
            this.setName(this.psMobAppStartPage.getPSMOBAPPSTARTPAGENAME());
            this.setPSObjectData(psMobAppStartPage);
            String[] items = this.psMobAppStartPage.getRESSPEC().split("[_]");
            if (items.length != 2) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5c4f\u5e55\u89e3\u6790[%1$s]", (Object)this.psMobAppStartPage.getRESSPEC()));
            }
            this.nWidth = Integer.parseInt(items[0]);
            this.nHeight = Integer.parseInt(items[1]);
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
    public String getFilePath() {
        return this.strFilePath;
    }

    @Override
    public String getModelType() {
        return "PSMOBAPPSTARTPAGE";
    }

    @Override
    public boolean isDefault() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5bbd\u5ea6", outputdoc="(%1$s.getWidth() gt 0)")
    public int getWidth() {
        return this.nWidth;
    }

    @Override
    @PSModelRTMeta(description="\u9ad8\u5ea6", outputdoc="(%1$s.getHeight() gt 0)")
    public int getHeight() {
        return this.nHeight;
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
    }
}

