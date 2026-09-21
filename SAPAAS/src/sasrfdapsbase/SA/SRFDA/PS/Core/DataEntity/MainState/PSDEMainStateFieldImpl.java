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

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateField;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEMainStateField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEMainStateFieldImpl
extends PSObjectImpl
implements IPSDEMainStateField {
    private static final Log log = LogFactory.getLog(PSDEMainStateFieldImpl.class);
    private IPSDEMainState iPSDEMainState = null;
    private PSDEMainStateField psDEMainStateField = null;
    private String strPSDEFieldId = null;
    private IPSDEField iPSDEField = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEMainState iPSDEMainState, PSDEMainStateField psDEMainStateField) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEMainState(iPSDEMainState);
            this.setId(this.psDEMainStateField.getPSDEMSFIELDID());
            this.setName(this.psDEMainStateField.getPSDEMSFIELDNAME());
            this.setPSObjectData(this.psDEMainStateField);
            this.strPSDEFieldId = psDEMainStateField.getPSDEFID();
            if (!StringHelper.isNullOrEmpty((String)this.strPSDEFieldId)) {
                this.iPSDEField = iPSDEMainState.getPSDataEntity().getPSDEField(this.strPSDEFieldId);
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

    @Override
    public String getPSDEFieldId() {
        return this.strPSDEFieldId;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"PSDEFID"})
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u5141\u8bb8\u6a21\u5f0f", doc="\u7531\u5b9e\u4f53\u4e3b\u72b6\u6001\u63a7\u5236{@link net.ibizsys.model.dataentity.mainstate.IPSDEMainState#isFieldAllowMode}")
    public boolean isAllowMode() {
        return this.getPSDEMainState().isFieldAllowMode();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEMainState.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEMSFIELD";
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
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c\u7c7b\u578b", codelist="DEFDefaultValueType", fields={"DVT"})
    public String getDefaultValueType() {
        return this.psDEMainStateField.getDVT();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c", fields={"DEFAULTVALUE"})
    public String getDefaultValue() {
        return this.psDEMainStateField.getDEFAULTVALUE();
    }
}

