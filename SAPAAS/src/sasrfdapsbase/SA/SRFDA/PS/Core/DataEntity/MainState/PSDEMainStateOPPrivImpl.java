/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.MainState;

import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEMainStateOPPriv;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEMainStateOPPrivImpl
extends PSObjectImpl
implements IPSDEMainStateOPPriv {
    private static final Log log = LogFactory.getLog(PSDEMainStateOPPrivImpl.class);
    private IPSDEMainState iPSDEMainState = null;
    private PSDEMainStateOPPriv psDEMainStateOPPriv = null;
    private String strPSDEOPPrivId = null;
    private IPSDEOPPriv iPSDEOPPriv = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEMainState iPSDEMainState, PSDEMainStateOPPriv psDEMainStateOPPriv) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEMainState(iPSDEMainState);
            this.setPSDEMainStateOPPrivData(psDEMainStateOPPriv);
            this.setId(this.psDEMainStateOPPriv.getPSDEMSOPPRIVID());
            this.setName(this.psDEMainStateOPPriv.getPSDEMSOPPRIVNAME());
            this.setPSObjectData(this.psDEMainStateOPPriv);
            this.strPSDEOPPrivId = psDEMainStateOPPriv.getPSDEOPPRIVID();
            if (!StringHelper.isNullOrEmpty((String)this.strPSDEOPPrivId)) {
                this.iPSDEOPPriv = iPSDEMainState.getPSDataEntity().getPSDEOPPriv(this.strPSDEOPPrivId);
                this.setName(this.iPSDEOPPriv.getName());
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
    @PSModelRTMeta(description="\u5b9e\u4f53\u4e3b\u72b6\u6001\u5bf9\u8c61", outputdoc="false")
    public IPSDEMainState getPSDEMainState() {
        return this.iPSDEMainState;
    }

    protected void setPSDEMainState(IPSDEMainState iPSDEMainState) {
        this.iPSDEMainState = iPSDEMainState;
    }

    public PSDEMainStateOPPriv getPSDEMainStateOPPrivData() {
        return this.psDEMainStateOPPriv;
    }

    protected void setPSDEMainStateOPPrivData(PSDEMainStateOPPriv psDEMainStateOPPriv) {
        this.psDEMainStateOPPriv = psDEMainStateOPPriv;
    }

    @Override
    public String getPSDEOPPrivId() {
        return this.strPSDEOPPrivId;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6", child=true, fields={"PSDEOPPRIVID"})
    public IPSDEOPPriv getPSDEOPPriv() {
        return this.iPSDEOPPriv;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEMainState.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEMSOPPRIV";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEMainState().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEMainState().getModelId(), (Object)super.getModelId());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEMainState().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

