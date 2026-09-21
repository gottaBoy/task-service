/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSAppResource;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSAppResource;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppResourceImpl
extends PSApplicationObjectImpl
implements IPSAppResource {
    protected PSAppResource psAppResource = null;
    private static final Log log = LogFactory.getLog(PSAppResourceImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppResource psAppResource) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.psAppResource = psAppResource;
            this.setId(this.psAppResource.getPSAPPRESOURCEID());
            this.setName(this.psAppResource.getPSAPPRESOURCENAME());
            this.setPSObjectData(this.psAppResource);
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
    public String getModelType() {
        return "PSAPPRESOURCE";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u8d44\u6e90\u7c7b\u578b", codelist="AppResourceType", group="\u57fa\u672c", order=125, fields={"RESOURCETYPE"})
    public String getResourceType() {
        return this.psAppResource.getRESOURCETYPE();
    }

    @Override
    @PSModelRTMeta(description="\u8d44\u6e90\u6807\u8bb0", group="\u57fa\u672c", order=105, fields={"RESTAG"})
    public String getResTag() {
        return this.psAppResource.getRESTAG();
    }

    @Override
    @PSModelRTMeta(description="\u8d44\u6e90\u5185\u5bb9", doctype="code", group="\u57fa\u672c", order=135, fields={"CONTENT"})
    public String getContent() {
        return this.psAppResource.getCONTENT();
    }

    @Override
    protected String onGetDynaModelTag() {
        return this.getResTag();
    }

    @Override
    protected String onGetMOSFileName() {
        return this.getResTag();
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }
}

