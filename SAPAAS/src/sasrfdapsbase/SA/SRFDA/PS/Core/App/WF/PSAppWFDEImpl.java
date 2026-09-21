/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.WF;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFDE;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.WF.IPSWFDE;
import SA.SRFDA.PS.Data.PSAppWFVer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppWFDEImpl
extends PSObjectImpl
implements IPSAppWFDE {
    private static final Log log = LogFactory.getLog(PSAppWFDEImpl.class);
    protected PSAppWFVer psAppWFVer = null;
    private IPSAppWF iPSAppWF = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSWFDE iPSWFDE = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppWF iPSAppWF, IPSAppDataEntity iPSAppDataEntity, IPSWFDE iPSWFDE) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSAppWF = iPSAppWF;
            this.iPSAppDataEntity = iPSAppDataEntity;
            this.iPSWFDE = iPSWFDE;
            this.setId(this.iPSWFDE.getId());
            this.setName(this.iPSWFDE.getName());
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.Format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.Format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.Format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        return this.getPSWFDE();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppWF().getPSApplication().getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSAPPWFDE";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.Format((String)"%1$s|%2$s", (Object)this.getPSAppWF().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.iPSAppWF.getModelId(), (Object)this.getDynaModelTag());
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5de5\u4f5c\u6d41", dumpref=true, from="IPSApplication")
    public IPSAppWF getPSAppWF() {
        return this.iPSAppWF;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53", dumpref=true, from="IPSApplication")
    public IPSAppDataEntity getPSAppDataEntity() throws Exception {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u5de5\u4f5c\u6d41\u5b9e\u4f53")
    public IPSWFDE getPSWFDE() {
        return this.iPSWFDE;
    }

    @Override
    protected String onGetDynaModelTag() {
        return this.getPSWFDE().getDynaModelTag();
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u72b6\u6001\u503c")
    public String getEntityWFState() {
        return this.getPSWFDE().getEntityWFState();
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u72b6\u6001\u5e94\u7528\u5e94\u7528\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEField getWFStatePSAppDEField() throws Exception {
        if (this.getPSWFDE().getWFStatePSDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getPSWFDE().getWFStatePSDEField(), true);
        }
        return null;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppWF().getPSSysModelInstId();
    }
}

