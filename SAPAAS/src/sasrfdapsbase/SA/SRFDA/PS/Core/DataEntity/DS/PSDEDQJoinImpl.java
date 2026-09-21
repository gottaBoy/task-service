/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQColumn;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQGroupCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQJoin;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDQColumnImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDQGroupConditionImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEDataQueryCond;
import SA.SRFDA.PS.Data.PSDEDataQueryJoin;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDQJoinImpl
extends PSObjectImpl
implements IPSDEDQJoin {
    private static final Log log = LogFactory.getLog(PSDEDQJoinImpl.class);
    protected ArrayList<IPSDEDQJoin> childPSDEDQJoinList = new ArrayList();
    protected IPSDEDataQuery iPSDEDataQuery = null;
    protected IPSDEDQJoin parentPSDEDQJoin = null;
    protected PSDEDataQueryJoin psDEDataQueryJoin = null;
    protected IPSDataEntity joinPSDataEntity = null;
    protected PSDEDQGroupConditionImpl psDEDQGroupConditionImpl = null;
    protected ArrayList<IPSDEDQColumn> psDEDQColumnList = new ArrayList();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataQuery iPSDEDataQuery, IPSDEDQJoin parentPSDEDQJoin, PSDEDataQueryJoin psDEDataQueryJoin) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEDataQuery = iPSDEDataQuery;
            this.parentPSDEDQJoin = parentPSDEDQJoin;
            this.psDEDataQueryJoin = psDEDataQueryJoin;
            this.setId(this.psDEDataQueryJoin.getPSDEDQJOINID());
            this.setName(this.psDEDataQueryJoin.getPSDEDQJOINNAME());
            this.setPSObjectData(this.psDEDataQueryJoin);
            this.joinPSDataEntity = iPSDEDataQuery.getPSDataEntity().getPSSystem().getPSDataEntity2(this.psDEDataQueryJoin.getJOINPSDEID());
            if (!StringHelper.isNullOrEmpty((String)psDEDataQueryJoin.getEXTCOLUMNS())) {
                Properties extPros = PropertiesHelper.Load(null, (String)psDEDataQueryJoin.getEXTCOLUMNS());
                for (Object objKey : extPros.keySet()) {
                    String strKey = objKey.toString();
                    String strKeyValue = PropertiesHelper.GetProperty((Properties)extPros, (String)strKey);
                    if (StringHelper.isNullOrEmpty((String)strKeyValue)) {
                        strKeyValue = objKey.toString();
                    }
                    PSDEDQColumnImpl psDEDQColumn = new PSDEDQColumnImpl();
                    psDEDQColumn.setAlias(strKey);
                    psDEDQColumn.setName(strKeyValue);
                    psDEDQColumn.setPSDEDQJoin(this);
                    this.psDEDQColumnList.add(psDEDQColumn);
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
    protected void onInit() throws Exception {
        super.onInit();
        this.onPrepareChildPSDEDQJoins();
        this.onPreparePSDEDQConds();
    }

    protected void onPrepareChildPSDEDQJoins() throws Exception {
        this.childPSDEDQJoinList.clear();
        ArrayList<PSDEDataQueryJoin> childPSDEDataQueryJoinList = this.psDEDataQueryJoin.getChildPSDEDataQueryJoins(false);
        if (childPSDEDataQueryJoinList == null) {
            return;
        }
        for (PSDEDataQueryJoin psDEDataQueryJoin : childPSDEDataQueryJoinList) {
            IPSDEDQJoin iPSDEDQJoin = this.createPSDEDQJoin(psDEDataQueryJoin);
            iPSDEDQJoin.init(this.getDAGlobalHelper(), this.iPSDEDataQuery, this, psDEDataQueryJoin);
            this.childPSDEDQJoinList.add(iPSDEDQJoin);
        }
    }

    protected void onPreparePSDEDQConds() throws Exception {
        this.psDEDQGroupConditionImpl = null;
        ArrayList<PSDEDataQueryCond> psDEDataQueryCondList = this.psDEDataQueryJoin.getPSDEDataQueryConds(false);
        if (psDEDataQueryCondList == null) {
            return;
        }
        PSDEDataQueryCond groupPSDEDataQueryCond = new PSDEDataQueryCond();
        groupPSDEDataQueryCond.setCONDTYPE("GROUP");
        groupPSDEDataQueryCond.setGROUPNOTFLAG(false);
        groupPSDEDataQueryCond.setGROUPOP("AND");
        groupPSDEDataQueryCond.setPSDEDQCONDID(this.psDEDataQueryJoin.getPSDEDQJOINID());
        groupPSDEDataQueryCond.setPSDEDQCONDNAME(StringHelper.format((String)"\u8fde\u63a5\u6761\u4ef6"));
        for (PSDEDataQueryCond psDEDataQueryCond : psDEDataQueryCondList) {
            groupPSDEDataQueryCond.getChildPSDEDataQueryConds(true).add(psDEDataQueryCond);
        }
        this.psDEDQGroupConditionImpl = new PSDEDQGroupConditionImpl();
        this.psDEDQGroupConditionImpl.init(this.getDAGlobalHelper(), this, null, groupPSDEDataQueryCond);
    }

    protected IPSDEDQJoin createPSDEDQJoin(PSDEDataQueryJoin psDEDataQueryJoin) throws Exception {
        return new PSDEDQJoinImpl();
    }

    @Override
    @PSModelRTMeta(description="\u8fde\u63a5\u7c7b\u578b", fields={"PSDEJOINTYPEID"})
    public String getJoinType() {
        return this.psDEDataQueryJoin.getPSDEJOINTYPEID();
    }

    @Override
    @PSModelRTMeta(description="\u8fde\u63a5\u5b9e\u4f53\u5bf9\u8c61", dumpref=true, fields={"JOINPSDEID"})
    public IPSDataEntity getJoinPSDataEntity() {
        return this.joinPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u522b\u540d", fields={"ALIASNAME"})
    public String getAlias() {
        return this.psDEDataQueryJoin.getALIASNAME();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u67e5\u8be2\u8fde\u63a5\u96c6\u5408", child=true)
    public Iterator<IPSDEDQJoin> getChildPSDEDQJoins() {
        if (this.childPSDEDQJoinList.size() == 0) {
            return null;
        }
        return this.childPSDEDQJoinList.iterator();
    }

    @Override
    public String getDERId() {
        return this.psDEDataQueryJoin.getPSDERID();
    }

    @Override
    @PSModelRTMeta(description="\u67e5\u8be2\u5217\u96c6\u5408", hideempty2=true, child=true)
    public Iterator<IPSDEDQColumn> getSelectedPSDEDQColumns() {
        if (this.psDEDQColumnList == null || this.psDEDQColumnList.size() == 0) {
            return null;
        }
        return this.psDEDQColumnList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u67e5\u8be2\u6761\u4ef6\u5bf9\u8c61", hideempty2=true, child=true)
    public IPSDEDQGroupCondition getPSDEDQGroupCondition() {
        if (this.psDEDQGroupConditionImpl == null || this.psDEDQGroupConditionImpl.getPSDEDQConditions() == null) {
            return null;
        }
        return this.psDEDQGroupConditionImpl;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDataQuery.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u5bf9\u8c61", from="__parent__")
    public IPSDEDataQuery getPSDEDataQuery() {
        return this.iPSDEDataQuery;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEDataQuery().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSDEDQJOIN";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEDataQuery().getModelId(), (Object)this.getId());
    }

    @Override
    public String getModelRefId() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8fde\u63a5\u5b9e\u4f53\u5173\u7cfb", hideempty=true, dumpref=true, from="__self__", from_method="getDERPSDataEntityMust().getMinorPSDERBase")
    public IPSDERBase getJoinPSDER() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getDERId())) {
            return null;
        }
        return this.getPSDEDataQuery().getPSDataEntity().getPSSystem().getPSDER(this.getDERId());
    }

    @Override
    @PSModelRTMeta(description="\u8fde\u63a5\u5173\u7cfb\u6240\u5728\u5b9e\u4f53", hideempty=true, dumpref=true)
    public IPSDataEntity getDERPSDataEntity() throws Exception {
        IPSDERBase iPSDERBase = this.getJoinPSDER();
        if (iPSDERBase == null) {
            return null;
        }
        return iPSDERBase.getMinorPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u8fde\u63a5\u6807\u8bb0", fields={"JOINTAG"})
    public String getJoinTag() {
        return this.psDEDataQueryJoin.getJOINTAG();
    }

    @Override
    @PSModelRTMeta(description="\u8fde\u63a5\u6807\u8bb02", fields={"JOINTAG2"})
    public String getJoinTag2() {
        return this.psDEDataQueryJoin.getJOINTAG2();
    }
}

