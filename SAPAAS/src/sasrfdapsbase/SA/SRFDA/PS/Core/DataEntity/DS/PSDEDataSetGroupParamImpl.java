/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.IDEDataSet
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetGroupParam;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEDSGroupParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.core.IDEDataSet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataSetGroupParamImpl
extends PSObjectImpl
implements IPSDEDataSetGroupParam {
    private static final Log log = LogFactory.getLog(PSDEDataSetGroupParamImpl.class);
    protected IPSDEDataSet iPSDEDataSet;
    protected PSDEDSGroupParam psDEDSGroupParam;
    private String strGroupCode = null;
    private String strGroupField = null;
    private String strSortDir = null;
    private int nSortOrder = -1;
    private int nStdDataType = -1;
    private boolean bEnableGroup = false;
    private String[] groupFields = null;
    private IPSDEField iPSDEField = null;
    private String strAlias = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataSet iPSDEDataSet, PSDEDSGroupParam psDEDSGroupParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEDataSet = iPSDEDataSet;
            this.psDEDSGroupParam = psDEDSGroupParam;
            this.setId(this.psDEDSGroupParam.getPSDEDSGRPPARAMID());
            this.setName(this.psDEDSGroupParam.getPSDEDSGRPPARAMNAME());
            this.setPSObjectData(this.psDEDSGroupParam);
            if (!this.psDEDSGroupParam.isGROUPFLAGNull()) {
                this.bEnableGroup = this.psDEDSGroupParam.getGROUPFLAG();
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psDEDSGroupParam.getGROUPCODE())) {
                this.strGroupCode = this.psDEDSGroupParam.getGROUPCODE();
            }
            if (StringHelper.IsNullOrEmpty((String)this.getGroupJoinCode())) {
                if (!StringHelper.IsNullOrEmpty((String)this.psDEDSGroupParam.getCUSTOMDEFNAME())) {
                    this.strGroupField = this.psDEDSGroupParam.getCUSTOMDEFNAME();
                } else if (!StringHelper.IsNullOrEmpty((String)this.psDEDSGroupParam.getPSDEFNAME())) {
                    this.strGroupField = this.psDEDSGroupParam.getPSDEFNAME();
                }
                if (!StringHelper.IsNullOrEmpty((String)this.strGroupField)) {
                    this.strGroupField = this.strGroupField.trim();
                    if (!StringHelper.IsNullOrEmpty((String)this.strGroupField)) {
                        this.groupFields = this.strGroupField.split("[,]");
                    }
                }
                if (!StringHelper.IsNullOrEmpty((String)this.psDEDSGroupParam.getORDERDIR())) {
                    this.strSortDir = this.psDEDSGroupParam.getORDERDIR();
                }
                if (!this.psDEDSGroupParam.isSORTORDERVALUENull()) {
                    this.nSortOrder = this.psDEDSGroupParam.getSORTORDERVALUE();
                }
                this.iPSDEField = !StringHelper.IsNullOrEmpty((String)this.strGroupField) ? this.iPSDEDataSet.getPSDataEntity().getPSDEField(this.strGroupField, true) : this.iPSDEDataSet.getPSDataEntity().getPSDEField(this.getName(), true);
                this.nStdDataType = this.psDEDSGroupParam.getSTDDATATYPE();
                if (this.nStdDataType <= 0 && this.iPSDEField != null) {
                    this.nStdDataType = this.iPSDEField.getStdDataType();
                }
                this.strAlias = this.psDEDSGroupParam.getALIASNAME();
                if (StringHelper.IsNullOrEmpty((String)this.strAlias)) {
                    this.strAlias = this.psDEDSGroupParam.getUSERDATA();
                }
            }
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
    @PSModelRTMeta(description="\u5206\u7ec4\u4ee3\u7801", fields={"GROUPCODE"})
    public String getGroupCode() {
        return this.strGroupCode;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u65b9\u5411", codelist="SortDir", fields={"ORDERDIR"})
    public String getSortDir() {
        return this.strSortDir;
    }

    @Override
    public int getSortOrder() {
        return this.nSortOrder;
    }

    public IDEDataSet getDEDataSet() {
        return this.getPSDEDataSet();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u7ed3\u679c\u96c6")
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", fields={"STDDATATYPE"})
    public int getStdDataType() {
        return this.nStdDataType;
    }

    @Override
    public String[] getGroupFields() {
        return this.groupFields;
    }

    @Override
    public boolean isReCalc() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u9879", ignoredumpvalues="false", fields={"GROUPFLAG"})
    public boolean isEnableGroup() {
        return this.bEnableGroup;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDataSet.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEDSGRPPARAM";
    }

    @Override
    public String getModelId() {
        if (this.getPSDEDataSet() != null) {
            return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEDataSet().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEDataSet().getPSDataEntity().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5206\u7ec4\u6392\u5e8f", ignoredumpvalues="false")
    public boolean isEnableSort() {
        if (!this.isEnableGroup()) {
            return false;
        }
        return !StringHelper.IsNullOrEmpty((String)this.getSortDir());
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"CUSTOMDEFNAME", "PSDEFNAME"}, doc="\u4f7f\u7528\u6307\u5b9a\u5c5e\u6027\u540d\u79f0\u6216\u5206\u7ec4\u9879\u6807\u8bc6\u8fdb\u884c\u5c1d\u8bd5\u83b7\u53d6")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u6a21\u5f0f", codelist="AggMode", fields={"AGGMODE"})
    public String getAggMode() {
        if (this.isEnableGroup()) {
            return null;
        }
        return this.psDEDSGroupParam.getAGGMODE();
    }

    @Override
    @PSModelRTMeta(description="\u522b\u540d", fields={"ALIASNAME"})
    public String getAlias() {
        return this.strAlias;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u8fde\u63a5\u4ee3\u7801", fields={"GROUPJOINCODE"})
    public String getGroupJoinCode() {
        if (!this.isEnableGroup()) {
            return null;
        }
        return this.psDEDSGroupParam.getGROUPJOINCODE();
    }

    @Override
    @PSModelRTMeta(description="\u9009\u62e9\u4ee3\u7801")
    public String getSelectCode() {
        return null;
    }
}

