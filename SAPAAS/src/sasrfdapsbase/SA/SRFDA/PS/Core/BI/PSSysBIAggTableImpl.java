/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIAggColumn;
import SA.SRFDA.PS.Core.BI.IPSBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBIAggColumn;
import SA.SRFDA.PS.Core.BI.IPSSysBIAggTable;
import SA.SRFDA.PS.Core.BI.IPSSysBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBIScheme;
import SA.SRFDA.PS.Core.BI.PSSysBIAggColumnImpl;
import SA.SRFDA.PS.Core.BI.PSSysBISchemeObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysBIAggColumn;
import SA.SRFDA.PS.Data.PSSysBIAggTable;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBIAggTableImpl
extends PSSysBISchemeObjectImpl
implements IPSSysBIAggTable {
    private static final Log log = LogFactory.getLog(PSSysBIAggTableImpl.class);
    protected PSSysBIAggTable psSysBIAggTable = null;
    private ArrayList<IPSSysBIAggColumn> psSysBIAggColumnList = new ArrayList();
    private Map<String, IPSSysBIAggColumn> psSysBIAggColumnMap = new LinkedHashMap<String, IPSSysBIAggColumn>();
    private IPSDataEntity iPSDataEntity = null;
    private IPSSysBICube iPSSysBICube = null;
    private IPSDEDataQuery iPSDEDataQuery = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysBIScheme iPSSysBIScheme, PSSysBIAggTable psSysBIAggTable) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysBIScheme(iPSSysBIScheme);
            this.psSysBIAggTable = psSysBIAggTable;
            this.setId(this.psSysBIAggTable.getPSSYSBIAGGTABLEID());
            this.setName(this.psSysBIAggTable.getPSSYSBIAGGTABLENAME());
            this.setPSObjectData(this.psSysBIAggTable);
            if (!StringHelper.isNullOrEmpty((String)this.psSysBIAggTable.getPSDEID())) {
                this.iPSDataEntity = this.getPSSysBIScheme().getPSSystem().getPSDataEntity2(this.psSysBIAggTable.getPSDEID());
            }
            if (this.getPSDataEntity() == null) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5bf9\u8c61");
            }
            if (this.getPSSysBICube() == null && !StringHelper.isNullOrEmpty((String)this.psSysBIAggTable.getPSSYSBICUBEID())) {
                this.iPSSysBICube = this.getPSSysBIScheme().getPSSysBICube(this.psSysBIAggTable.getPSSYSBICUBEID());
            }
            if (this.getPSSysBICube() == null) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53");
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysBIAggTable.getPSDEDATAQUERYID())) {
                this.iPSDEDataQuery = this.getPSDataEntity().getPSDEDataQuery(this.psSysBIAggTable.getPSDEDATAQUERYID());
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
        this.onPreparePSSysBIAggColumns();
        super.onInit();
    }

    protected void onPreparePSSysBIAggColumns() throws Exception {
        this.psSysBIAggColumnList.clear();
        Vector<PSSysBIAggColumn> psSysBIAggColumnList = new Vector<PSSysBIAggColumn>();
        CallResult callResult = this.getPSModelHelper().getPSSysBIAggColumns(this.getId(), psSysBIAggColumnList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u805a\u5408\u6570\u636e\u5217\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysBIAggColumn psSysBIAggColumn : psSysBIAggColumnList) {
            PSSysBIAggColumnImpl iPSSysBIAggColumn = new PSSysBIAggColumnImpl();
            iPSSysBIAggColumn.init(this.getDAGlobalHelper(), this, psSysBIAggColumn);
            this.psSysBIAggColumnList.add(iPSSysBIAggColumn);
            this.psSysBIAggColumnMap.put(iPSSysBIAggColumn.getId(), iPSSysBIAggColumn);
            this.psSysBIAggColumnMap.put(iPSSysBIAggColumn.getName(), iPSSysBIAggColumn);
        }
    }

    @Override
    public String getModelType() {
        return "PSSYSBIAGGTABLE";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysBIAggTable.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u6570\u636e\u5217\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysBIAggColumn> getAllPSSysBIAggColumns() throws Exception {
        if (this.psSysBIAggColumnList == null || this.psSysBIAggColumnList.size() == 0) {
            return null;
        }
        return this.psSysBIAggColumnList.iterator();
    }

    @Override
    public IPSSysBIAggColumn getPSSysBIAggColumn(String strPSSysBIAggColumnId) throws Exception {
        return this.getPSSysBIAggColumn(strPSSysBIAggColumnId, false);
    }

    @Override
    public IPSBIAggColumn getPSBIAggColumn(String strPSBIAggColumnId, boolean bTryMode) throws Exception {
        return this.getPSSysBIAggColumn(strPSBIAggColumnId, bTryMode);
    }

    @Override
    public IPSSysBIAggColumn getPSSysBIAggColumn(String strPSSysBIAggColumnId, boolean bTryMode) throws Exception {
        IPSSysBIAggColumn iPSSysBIAggColumn = null;
        if (this.psSysBIAggColumnMap != null) {
            iPSSysBIAggColumn = this.psSysBIAggColumnMap.get(strPSSysBIAggColumnId);
        }
        if (iPSSysBIAggColumn != null || bTryMode) {
            return iPSSysBIAggColumn;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u805a\u5408\u6570\u636e\u5217[%1$s]", (Object)strPSSysBIAggColumnId));
    }

    @Override
    public Iterator<? extends IPSBIAggColumn> getAllPSBIAggColumns() throws Exception {
        return this.getAllPSSysBIAggColumns();
    }

    @Override
    public IPSBIAggColumn getPSBIAggColumn(String strPSBIAggColumnId) throws Exception {
        return this.getPSSysBIAggColumn(strPSBIAggColumnId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53", dumpref=true)
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u6570\u636e\u8868\u6807\u8bb0", hideempty2=true)
    public String getTableTag() {
        return this.psSysBIAggTable.getBIAGGTABLETAG();
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u6570\u636e\u8868\u6807\u8bb02", hideempty2=true)
    public String getTableTag2() {
        return this.psSysBIAggTable.getBIAGGTABLETAG2();
    }

    @Override
    public IPSBICube getPSBICube() {
        return this.getPSSysBICube();
    }

    @Override
    @PSModelRTMeta(description="\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53", dumpref=true, from="IPSSysBIScheme", hideempty=true)
    public IPSSysBICube getPSSysBICube() {
        return this.iPSSysBICube;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u67e5\u8be2", dumpref=true, from="IPSDataEntity")
    public IPSDEDataQuery getPSDEDataQuery() {
        return this.iPSDEDataQuery;
    }
}

