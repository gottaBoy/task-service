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

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateAction;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEMainStateAction;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEMainStateActionImpl
extends PSObjectImpl
implements IPSDEMainStateAction {
    private static final Log log = LogFactory.getLog(PSDEMainStateActionImpl.class);
    private IPSDEMainState iPSDEMainState = null;
    private PSDEMainStateAction psDEMainStateAction = null;
    private String strPSDEActionId = null;
    private IPSDEAction iPSDEAction = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEMainState iPSDEMainState, PSDEMainStateAction psDEMainStateAction) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEMainState(iPSDEMainState);
            this.setPSDEMainStateActionData(psDEMainStateAction);
            this.setId(this.psDEMainStateAction.getPSDEMSACTIONID());
            this.setName(this.psDEMainStateAction.getPSDEMSACTIONNAME());
            this.setPSObjectData(this.psDEMainStateAction);
            this.strPSDEActionId = psDEMainStateAction.getPSDEACTIONID();
            if (!StringHelper.isNullOrEmpty((String)this.strPSDEActionId)) {
                this.iPSDEAction = iPSDEMainState.getPSDataEntity().getPSDEAction(this.strPSDEActionId);
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

    public PSDEMainStateAction getPSDEMainStateActionData() {
        return this.psDEMainStateAction;
    }

    protected void setPSDEMainStateActionData(PSDEMainStateAction psDEMainStateAction) {
        this.psDEMainStateAction = psDEMainStateAction;
    }

    @Override
    public String getPSDEActionId() {
        return this.strPSDEActionId;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSDataEntity", fields={"PSDEACTIONID"})
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u5141\u8bb8\u6a21\u5f0f", doc="\u7531\u5b9e\u4f53\u4e3b\u72b6\u6001\u5b9a\u4e49{@link net.ibizsys.model.dataentity.mainstate.IPSDEMainState#isActionAllowMode}")
    public boolean isAllowMode() {
        return this.getPSDEMainState().isActionAllowMode();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEMainState.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEMSACTION";
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

