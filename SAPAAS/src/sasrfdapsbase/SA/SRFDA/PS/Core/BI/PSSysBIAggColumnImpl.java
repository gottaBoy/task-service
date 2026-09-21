/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.IPSModelObject
 *  net.ibizsys.pscore.srv.util.IPSRecursionWork
 *  net.ibizsys.pscore.srv.util.PSRecursionHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSBICubeMeasure;
import SA.SRFDA.PS.Core.BI.IPSSysBIAggColumn;
import SA.SRFDA.PS.Core.BI.IPSSysBIAggTable;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeMeasure;
import SA.SRFDA.PS.Core.BI.PSSysBIAggTableObjectImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysBIAggColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.IPSModelObject;
import net.ibizsys.pscore.srv.util.IPSRecursionWork;
import net.ibizsys.pscore.srv.util.PSRecursionHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBIAggColumnImpl
extends PSSysBIAggTableObjectImpl
implements IPSSysBIAggColumn {
    private static final Log log = LogFactory.getLog(PSSysBIAggColumnImpl.class);
    protected PSSysBIAggColumn psSysBIAggColumn = null;
    private String strAggColumnType = "MEASURE";
    private IPSDEField iPSDEField = null;
    private IPSSysBICubeDimension iPSSysBICubeDimension = null;
    private IPSSysBICubeMeasure iPSSysBICubeMeasure = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysBIAggTable iPSSysBIAggTable, PSSysBIAggColumn psSysBIAggColumn) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysBIAggTable(iPSSysBIAggTable);
            this.psSysBIAggColumn = psSysBIAggColumn;
            this.setId(this.psSysBIAggColumn.getPSSYSBIAGGCOLUMNID());
            this.setName(this.psSysBIAggColumn.getPSSYSBIAGGCOLUMNNAME());
            this.setPSObjectData(this.psSysBIAggColumn);
            if (!StringHelper.isNullOrEmpty((String)this.psSysBIAggColumn.getBIAGGCOLUMNTYPE())) {
                this.strAggColumnType = this.psSysBIAggColumn.getBIAGGCOLUMNTYPE();
            }
            if (this.getPSDEField() == null && !StringHelper.isNullOrEmpty((String)this.psSysBIAggColumn.getPSDEFID())) {
                this.iPSDEField = this.getPSSysBIAggTable().getPSDataEntity().getPSDEField(this.psSysBIAggColumn.getPSDEFID());
            }
            if (this.getPSDEField() == null) {
                throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027", new Object[0]));
            }
            if ("DIMENSION".equals(this.getColumnType())) {
                if (this.getPSSysBICubeDimension() == null && !StringHelper.isNullOrEmpty((String)this.psSysBIAggColumn.getPSSYSBICUBEDIMENSIONID())) {
                    this.iPSSysBICubeDimension = (IPSSysBICubeDimension)PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSSysBICubeDimension>(){

                        public IPSSysBICubeDimension execute(Object obj) throws Exception {
                            return PSSysBIAggColumnImpl.this.getPSSysBIAggTable().getPSSysBICube().getPSSysBICubeDimension((String)obj);
                        }
                    }, (IPSModelObject)iPSSysBIAggTable, (Object)this.psSysBIAggColumn.getPSSYSBICUBEDIMENSIONID());
                }
                if (this.getPSSysBICubeDimension() == null) {
                    throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u6620\u5c04\u7684\u7acb\u65b9\u4f53\u7ef4\u5ea6", new Object[0]));
                }
            } else if ("MEASURE".equals(this.getColumnType())) {
                if (this.getPSSysBICubeMeasure() == null && !StringHelper.isNullOrEmpty((String)this.psSysBIAggColumn.getPSSYSBICUBEMEASUREID())) {
                    this.iPSSysBICubeMeasure = (IPSSysBICubeMeasure)PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSSysBICubeMeasure>(){

                        public IPSSysBICubeMeasure execute(Object obj) throws Exception {
                            return PSSysBIAggColumnImpl.this.getPSSysBIAggTable().getPSSysBICube().getPSSysBICubeMeasure((String)obj);
                        }
                    }, (IPSModelObject)iPSSysBIAggTable, (Object)this.psSysBIAggColumn.getPSSYSBICUBEMEASUREID());
                }
                if (this.getPSSysBICubeMeasure() == null) {
                    throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u6620\u5c04\u7684\u7acb\u65b9\u4f53\u6307\u6807", new Object[0]));
                }
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
        return "PSSYSBIAGGCOLUMN";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysBIAggColumn.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u6570\u636e\u7c7b\u578b", codelist="BIAggColumnType")
    public String getColumnType() {
        return this.strAggColumnType;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSSysBIAggTable", from_method="getPSDataEntityMust().getPSDEField")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    public IPSBICubeDimension getPSBICubeDimension() {
        return this.getPSSysBICubeDimension();
    }

    @Override
    public IPSBICubeMeasure getPSBICubeMeasure() {
        return this.getPSSysBICubeMeasure();
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u6570\u636e\u5217\u6807\u8bb0", hideempty2=true)
    public String getColumnTag() {
        return this.psSysBIAggColumn.getBIAGGCOLUMNTAG();
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u6570\u636e\u5217\u6807\u8bb02", hideempty2=true)
    public String getColumnTag2() {
        return this.psSysBIAggColumn.getBIAGGCOLUMNTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u7acb\u65b9\u4f53\u7ef4\u5ea6", dumpref=true, from="IPSSysBIAggTable", from_method="getPSSysBICubeMust().getPSSysBICubeDimension", hideempty=true)
    public IPSSysBICubeDimension getPSSysBICubeDimension() {
        return this.iPSSysBICubeDimension;
    }

    @Override
    @PSModelRTMeta(description="\u7acb\u65b9\u4f53\u6307\u6807", dumpref=true, from="IPSSysBIAggTable", from_method="getPSSysBICubeMust().getPSSysBICubeMeasure", hideempty=true)
    public IPSSysBICubeMeasure getPSSysBICubeMeasure() {
        return this.iPSSysBICubeMeasure;
    }
}

