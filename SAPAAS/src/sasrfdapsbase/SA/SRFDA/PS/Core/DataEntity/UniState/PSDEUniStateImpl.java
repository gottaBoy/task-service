/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.UniState;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.UniState.IPSDEUniState;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysUniState;
import SA.SRFDA.PS.Data.PSSysUniState;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUniStateImpl
extends PSDataEntityObjectImpl
implements IPSDEUniState {
    private static final Log log = LogFactory.getLog(PSDEUniStateImpl.class);
    protected PSSysUniState psSysUniState = null;
    private boolean bDefault = false;
    private IPSSysUniState iPSSysUniState = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSSysUniState psSysUniState) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.psSysUniState = psSysUniState;
            this.setId(this.psSysUniState.getPSSYSUNISTATEID());
            this.setName(this.psSysUniState.getPSSYSUNISTATENAME());
            this.setPSObjectData(this.psSysUniState);
            if (!psSysUniState.isDEDEFAULTFLAGNull()) {
                this.bDefault = psSysUniState.getDEDEFAULTFLAG();
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
        this.iPSSysUniState = this.getPSDataEntity().getPSSystem().getPSSysUniState(this.psSysUniState.getPSSYSUNISTATEID());
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u9ed8\u8ba4", ignoredumpvalues="false", fields={"DEDEFAULTFLAG"})
    public boolean isDefault() {
        return this.bDefault;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u72b6\u6001\u534f\u540c\u5bf9\u8c61", dumpref=true)
    public IPSSysUniState getPSSysUniState() {
        return this.iPSSysUniState;
    }

    public void init(IDataEntity iDataEntity) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getModelType() {
        return "PSDEUNISTATE";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDataEntity().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", fields={"UNIQUETAG"})
    public String getCodeName() {
        return this.psSysUniState.getUNIQUETAG();
    }
}

