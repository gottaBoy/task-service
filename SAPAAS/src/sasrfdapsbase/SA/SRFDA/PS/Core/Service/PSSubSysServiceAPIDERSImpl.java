/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDERS;
import SA.SRFDA.PS.Data.PSSubSysSADERS;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSSubSysServiceAPIDERSImpl
extends PSObjectImpl
implements IPSSubSysServiceAPIDERS {
    private static final Log log = LogFactory.getLog(PSSubSysServiceAPIDERSImpl.class);
    protected PSSubSysSADERS psSubSysSADERS = null;
    private String strParentFilter = null;
    private IPSSubSysServiceAPI iPSSubSysServiceAPI = null;
    private boolean bArray = true;
    private int nMasterOrder = -1;
    private int nOrderValue = 99999;
    private String strCodeName = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSubSysServiceAPI iPSSubSysServiceAPI, PSSubSysSADERS psSubSysSADERS) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSubSysServiceAPI(iPSSubSysServiceAPI);
            this.psSubSysSADERS = psSubSysSADERS;
            this.setId(this.psSubSysSADERS.getPSSUBSYSSADERSID());
            this.setName(this.psSubSysSADERS.getPSSUBSYSSADERSNAME());
            this.setPSObjectData(this.psSubSysSADERS);
            this.strCodeName = this.psSubSysSADERS.getCODENAME();
            if (this.isAutoModel()) {
                this.strCodeName = this.getPSSubSysServiceAPI().getAPICodeName(null, this.strCodeName, null);
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSubSysSADERS.getCHILDFILTER())) {
                this.strParentFilter = this.psSubSysSADERS.getCHILDFILTER();
            }
            if (!this.psSubSysSADERS.isARRAYFLAGNull()) {
                this.bArray = this.psSubSysSADERS.getARRAYFLAG();
            }
            if (!this.psSubSysSADERS.isORDERVALUENull()) {
                this.nMasterOrder = this.psSubSysSADERS.getORDERVALUE();
            }
            if (!this.psSubSysSADERS.isORDERVALUENull() && this.psSubSysSADERS.getORDERVALUE() >= 0) {
                this.nOrderValue = this.psSubSysSADERS.getORDERVALUE();
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

    protected void setPSSubSysServiceAPI(IPSSubSysServiceAPI iPSSubSysServiceAPI) {
        this.iPSSubSysServiceAPI = iPSSubSysServiceAPI;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3")
    public IPSSubSysServiceAPI getPSSubSysServiceAPI() {
        return this.iPSSubSysServiceAPI;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", dump=false, ignoredumpvalues="99999", fields={"ORDERVALUE"})
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u63a7\u6392\u5e8f", ignoredumpvalues="-1", fields={"ORDERVALUE"})
    public int getMasterOrder() {
        return this.nMasterOrder;
    }

    @Override
    public String getPPSSubSysSADEId() {
        return this.psSubSysSADERS.getPPSSUBSYSSADEID();
    }

    @Override
    public String getCPSSubSysSADEId() {
        return this.psSubSysSADERS.getCPSSUBSYSSADEID();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u63a5\u53e3\u5b9e\u4f53", dumpref=true, from="IPSSubSysServiceAPI", fields={"PPSSUBSYSSADEID"})
    public IPSSubSysServiceAPIDE getMajorPSSubSysServiceAPIDE() throws Exception {
        return this.getPSSubSysServiceAPI().getPSSubSysServiceAPIDE(this.getPPSSubSysSADEId(), false);
    }

    @Override
    @PSModelRTMeta(description="\u4ece\u63a5\u53e3\u5b9e\u4f53", dumpref=true, from="IPSSubSysServiceAPI", fields={"CPSSUBSYSSADEID"})
    public IPSSubSysServiceAPIDE getMinorPSSubSysServiceAPIDE() throws Exception {
        return this.getPSSubSysServiceAPI().getPSSubSysServiceAPIDE(this.getCPSSubSysSADEId(), false);
    }

    @Override
    public String getModelType() {
        return "PSSUBSYSSADERS";
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSubSysServiceAPI().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSubSysServiceAPI().getModelId(), (Object)super.getModelId());
    }

    @Override
    public String getModelName() {
        try {
            return StringHelper.format((String)"%1$s-%2$s", (Object)this.getMajorPSSubSysServiceAPIDE().getModelName(), (Object)this.getMinorPSSubSysServiceAPIDE().getModelName());
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return super.getModelName();
        }
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u9879", fields={"CHILDFILTER"})
    public String getParentFilter() {
        return this.strParentFilter;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSubSysServiceAPI().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", hideempty2=true)
    public String getCodeName2() {
        return this.psSubSysSADERS.getCODENAME2();
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u6807\u8bb0", hideempty2=true, fields={"RSTAG"})
    public String getRSTag() {
        return this.psSubSysSADERS.getRSTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u6807\u8bb0", hideempty2=true, fields={"RSTAG2"})
    public String getRSTag2() {
        return this.psSubSysSADERS.getRSTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u7ec4\u6a21\u5f0f", ignoredumpvalues="true", fields={"ARRAYFLAG"})
    public boolean isArray() {
        return this.bArray;
    }

    @Override
    protected String onGetDynaModelFolder() {
        return null;
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSubSysServiceAPI();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSSubSysServiceAPI();
    }
}

