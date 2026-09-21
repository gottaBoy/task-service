/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Theme;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.Theme.IPSAppUITheme;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSAppUITheme;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppUIThemeImpl
extends PSApplicationObjectImpl
implements IPSAppUITheme {
    private static final Log log = LogFactory.getLog(PSAppUIThemeImpl.class);
    protected PSAppUITheme psAppUITheme = null;
    private Properties themeParams = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppUITheme psAppUITheme) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.psAppUITheme = psAppUITheme;
            this.setId(this.psAppUITheme.getPSAPPUITHEMEID());
            this.setName(this.psAppUITheme.getPSAPPUITHEMENAME());
            this.setPSObjectData(psAppUITheme);
            this.themeParams = PropertiesHelper.load((String)this.psAppUITheme.getTHEMEPARAMS());
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
    @PSModelRTMeta(description="\u4e3b\u9898\u6807\u8bb0", fields={"THEMETAG"})
    public String getThemeTag() {
        return this.psAppUITheme.getTHEMETAG();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u9898\u8bf4\u660e", fields={"THEMEDESC"})
    public String getThemeDesc() {
        return this.psAppUITheme.getTHEMEDESC();
    }

    @Override
    public Object getThemeParam(String strKey) throws Exception {
        return PropertiesHelper.getProperty((Properties)this.themeParams, (String)strKey);
    }

    @Override
    public boolean getThemeParam(String strKey, boolean bDefault) throws Exception {
        return PropertiesHelper.getProperty((Properties)this.themeParams, (String)strKey, (boolean)bDefault);
    }

    @Override
    public String getThemeParam(String strKey, String strDefault) throws Exception {
        return PropertiesHelper.getProperty((Properties)this.themeParams, (String)strKey, (String)strDefault);
    }

    @Override
    public int getThemeParam(String strKey, int nDefault) throws Exception {
        return PropertiesHelper.getProperty((Properties)this.themeParams, (String)strKey, (int)nDefault);
    }

    @Override
    public double getThemeParam(String strKey, double fDefault) throws Exception {
        return PropertiesHelper.getProperty((Properties)this.themeParams, (String)strKey, (double)fDefault);
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u9898\u53c2\u6570\u96c6\u5408", fields={"THEMEPARAMS"})
    public Properties getThemeParams() {
        return this.themeParams;
    }

    @Override
    public String getModelType() {
        return "PSAPPUITHEME";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    protected String onGetDynaModelFolder() {
        return null;
    }

    @Override
    protected String onGetDynaModelTag() {
        return this.getThemeTag();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u9898\u6837\u5f0f", fields={"CSSSTYLE"})
    public String getCssStyle() {
        return this.psAppUITheme.getCSSSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u9898\u8fdc\u7a0b\u8def\u5f84", fields={"THEMEURL"})
    public String getThemeUrl() {
        return this.psAppUITheme.getTHEMEURL();
    }
}

