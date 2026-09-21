/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQColumn;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQGroupCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQJoin;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQMain;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEDataQueryJoin;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

@PSModelIgnoreMeta
public class SimplePSDEDQMainImpl
extends PSObjectImpl
implements IPSDEDQMain {
    private IPSDataEntity iPSDataEntity = null;
    private ArrayList<IPSDEDQColumn> psDEDQColumnList = null;
    private IPSDEDataQuery iPSDEDataQuery = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, ArrayList<IPSDEDQColumn> psDEDQColumnList) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSDataEntity = iPSDataEntity;
        this.psDEDQColumnList = psDEDQColumnList;
        if (this.iPSDataEntity.getDefaultPSDEDataQuery() != null) {
            this.iPSDEDataQuery = this.iPSDataEntity.getDefaultPSDEDataQuery();
        } else {
            Iterator<IPSDEDataQuery> psDEDataQueries;
            this.iPSDEDataQuery = this.iPSDataEntity.getPSDEDataQuery("VIEW", true);
            if (this.iPSDEDataQuery != null && (psDEDataQueries = this.iPSDataEntity.getAllPSDEDataQueries()) != null && psDEDataQueries.hasNext()) {
                this.iPSDEDataQuery = psDEDataQueries.next();
            }
        }
        if (this.getPSDEDataQuery() == null) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u6ca1\u6709\u5b9a\u4e49\u6570\u636e\u67e5\u8be2", (Object)this.iPSDataEntity.getName()));
        }
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataQuery iPSDEDataQuery, IPSDEDQJoin parentPSDEDQJoin, PSDEDataQueryJoin psDEDataQueryJoin) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IPSDEDataQuery getPSDEDataQuery() {
        return this.iPSDEDataQuery;
    }

    @Override
    public String getJoinType() {
        return "MAIN";
    }

    @Override
    public IPSDataEntity getJoinPSDataEntity() {
        return null;
    }

    @Override
    public String getAlias() {
        return null;
    }

    @Override
    public Iterator<IPSDEDQJoin> getChildPSDEDQJoins() {
        return null;
    }

    @Override
    public String getDERId() {
        return null;
    }

    @Override
    public IPSDEDQGroupCondition getPSDEDQGroupCondition() {
        return null;
    }

    @Override
    public Iterator<IPSDEDQColumn> getSelectedPSDEDQColumns() {
        if (this.psDEDQColumnList == null || this.psDEDQColumnList.size() == 0) {
            return null;
        }
        return this.psDEDQColumnList.iterator();
    }

    @Override
    public boolean isExcludeMode() {
        return false;
    }

    @Override
    public boolean isDistinctMode() {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDataEntity.getPSSysModelInstId();
    }

    @Override
    public IPSDERBase getJoinPSDER() throws Exception {
        return null;
    }

    @Override
    public IPSDataEntity getDERPSDataEntity() throws Exception {
        return null;
    }

    @Override
    public String getJoinTag() {
        return null;
    }

    @Override
    public String getJoinTag2() {
        return null;
    }
}

