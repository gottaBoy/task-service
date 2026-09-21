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
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSSysBIReport;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportItem;
import SA.SRFDA.PS.Core.BI.PSSysBIReportObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysBIReportItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSysBIReportItemImpl
extends PSSysBIReportObjectImpl
implements IPSSysBIReportItem {
    private static final Log log = LogFactory.getLog(PSSysBIReportItemImpl.class);
    protected PSSysBIReportItem psSysBIReportItem = null;
    private String strItemType = null;
    private Properties itemParams = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysBIReport iPSSysBIReport, PSSysBIReportItem psSysBIReportItem) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysBIReport(iPSSysBIReport);
            this.psSysBIReportItem = psSysBIReportItem;
            this.setId(this.psSysBIReportItem.getPSSYSBIREPORTITEMID());
            this.setName(this.psSysBIReportItem.getPSSYSBIREPORTITEMNAME());
            this.setPSObjectData(this.psSysBIReportItem);
            if (!StringHelper.isNullOrEmpty((String)this.psSysBIReportItem.getBIREPITEMTYPE())) {
                this.strItemType = this.psSysBIReportItem.getBIREPITEMTYPE();
            }
            if (StringHelper.isNullOrEmpty((String)this.getItemType())) {
                throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u62a5\u8868\u9879\u7c7b\u578b", new Object[0]));
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysBIReportItem.getBIREPITEMPARAMS())) {
                this.itemParams = PropertiesHelper.load((String)this.psSysBIReportItem.getBIREPITEMPARAMS());
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
    public String getModelType() {
        return "PSSYSBIREPORTITEM";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", fields={"CODENAME"})
    public String getCodeName() {
        return this.psSysBIReportItem.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u9879\u7c7b\u578b", codelist="BIReportItemType", fields={"BIREPITEMTYPE"})
    public String getItemType() {
        return this.strItemType;
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u9879\u6807\u8bb0", hideempty2=true, fields={"BIREPITEMTAG"})
    public String getItemTag() {
        return this.psSysBIReportItem.getBIREPITEMTAG();
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u9879\u6807\u8bb02", hideempty2=true, fields={"BIREPITEMTAG2"})
    public String getItemTag2() {
        return this.psSysBIReportItem.getBIREPITEMTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u9879\u52a8\u6001\u53c2\u6570", hideempty=true)
    public Properties getItemParams() {
        return this.itemParams;
    }
}

