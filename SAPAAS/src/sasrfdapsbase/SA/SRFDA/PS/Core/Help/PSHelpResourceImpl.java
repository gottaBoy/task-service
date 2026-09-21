/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpResource;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Data.PSHelpResource;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpResourceImpl
extends PSSystemObjectImpl
implements IPSHelpResource {
    private static final Log log = LogFactory.getLog(PSHelpResourceImpl.class);
    protected PSHelpResource psHelpResource = null;
    private String strResourceType = null;
    private String strResourceSN = null;
    private String strTitle = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSHelpResource psHelpResource) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psHelpResource = psHelpResource;
            this.setId(this.psHelpResource.getPSHELPRESOURCEID());
            this.setName(this.psHelpResource.getPSHELPRESOURCENAME());
            this.setPSObjectData(this.psHelpResource);
            this.strResourceType = this.psHelpResource.getRESOURCETYPE();
            this.strResourceSN = this.psHelpResource.getRESOURCESN();
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
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
    @PSModelRTMeta(description="\u8d44\u6e90\u7c7b\u578b", codelist="HelpResourceType")
    public String getResourceType() {
        return this.strResourceType;
    }

    @Override
    @PSModelRTMeta(description="\u8d44\u6e90\u5185\u5bb9")
    public String getContent() {
        return this.psHelpResource.getCONTENT();
    }

    @Override
    public String getModelType() {
        return "PSHELPRESOURCE";
    }

    @Override
    @PSModelRTMeta(description="\u8d44\u6e90\u62ac\u5934")
    public String getTitle() {
        if (StringHelper.IsNullOrEmpty((String)this.strTitle)) {
            return this.getName();
        }
        return this.strTitle;
    }

    @Override
    @PSModelRTMeta(description="\u8d44\u6e90\u7f16\u53f7")
    public String getResourceSN() {
        if (StringHelper.IsNullOrEmpty((String)this.strResourceSN)) {
            return this.getId();
        }
        return this.strResourceSN;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psHelpResource.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u8d44\u6e90\u6807\u8bb0")
    public String getResTag() {
        return this.psHelpResource.getRESPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u8d44\u6e90\u6807\u8bb02")
    public String getResTag2() {
        return this.psHelpResource.getRESPARAM2();
    }
}

