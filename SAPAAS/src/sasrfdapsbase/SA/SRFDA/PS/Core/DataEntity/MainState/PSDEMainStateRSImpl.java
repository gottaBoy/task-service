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

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateRS;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSDEMainStateRS;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEMainStateRSImpl
extends PSDataEntityObjectImpl
implements IPSDEMainStateRS,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEMainStateRSImpl.class);
    protected PSDEMainStateRS psDEMainStateRS;
    protected String strCodeName = "";
    private int nOrderValue = 99999;
    private IPSDEMainState prevPSDEMainState = null;
    private IPSDEMainState nextPSDEMainState = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEMainStateRS psDEMainStateRS) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psDEMainStateRS = psDEMainStateRS;
            this.setId(psDEMainStateRS.getPSDEMAINSTATERSID());
            this.setName(psDEMainStateRS.getPSDEMAINSTATERSNAME());
            this.setPSObjectData(this.psDEMainStateRS);
            this.strCodeName = this.psDEMainStateRS.getCODENAME();
            if (!this.psDEMainStateRS.isORDERVALUENull() && this.psDEMainStateRS.getORDERVALUE() >= 0) {
                this.nOrderValue = this.psDEMainStateRS.getORDERVALUE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEMainStateRS.getPREVPSDEMSID())) {
                this.prevPSDEMainState = this.getPSDataEntity().getPSDEMainState(this.psDEMainStateRS.getPREVPSDEMSID());
            }
            if (this.getPrevPSDEMainState() == null) {
                throw new Exception("\u524d\u5e8f\u72b6\u6001\u65e0\u6548");
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEMainStateRS.getNEXTPSDEMSID())) {
                this.nextPSDEMainState = this.getPSDataEntity().getPSDEMainState(this.psDEMainStateRS.getNEXTPSDEMSID());
            }
            if (this.getNextPSDEMainState() == null) {
                throw new Exception("\u8fdb\u5165\u72b6\u6001\u65e0\u6548");
            }
            if (StringHelper.compare((String)this.getPrevPSDEMainState().getId(), (String)this.getNextPSDEMainState().getId(), (boolean)false) == 0) {
                throw new Exception("\u524d\u5e8f\u72b6\u6001\u4e0e\u8fdb\u5165\u72b6\u6001\u4e0d\u80fd\u76f8\u540c");
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
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getModelType() {
        return "PSDEMAINSTATERS";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDataEntity().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", ignoredumpvalues="99999")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u5e8f\u4e3b\u72b6\u6001", dumpref=true, from="IPSDataEntity", fields={"PREVPSDEMSID"})
    public IPSDEMainState getPrevPSDEMainState() {
        return this.prevPSDEMainState;
    }

    @Override
    @PSModelRTMeta(description="\u8fdb\u5165\u4e3b\u72b6\u6001", dumpref=true, from="IPSDataEntity", fields={"NEXTPSDEMSID"})
    public IPSDEMainState getNextPSDEMainState() {
        return this.nextPSDEMainState;
    }
}

