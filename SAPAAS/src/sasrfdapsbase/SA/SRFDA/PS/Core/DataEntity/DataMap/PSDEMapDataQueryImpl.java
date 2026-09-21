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
package SA.SRFDA.PS.Core.DataEntity.DataMap;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMap;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DataMap.PSDEMapObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSDEMapDataQuery;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEMapDataQueryImpl
extends PSDEMapObjectImpl
implements IPSDEMapDataQuery {
    private static final Log log = LogFactory.getLog(PSDEMapDataQueryImpl.class);
    private PSDEMapDataQuery psDEMapDataQuery = null;
    private IPSDEDataQuery srcPSDEDataQuery = null;
    private IPSDEDataQuery dstPSDEDataQuery = null;
    private Properties mapParams = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEMap iPSDEMap, PSDEMapDataQuery psDEMapDataQuery) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEMap(iPSDEMap);
            this.psDEMapDataQuery = psDEMapDataQuery;
            this.setId(this.psDEMapDataQuery.getPSDEMAPDQID());
            this.setName(this.psDEMapDataQuery.getPSDEMAPDQNAME());
            this.setPSObjectData(this.psDEMapDataQuery);
            this.srcPSDEDataQuery = this.getPSDEMap().getPSDataEntity().getPSDEDataQuery(psDEMapDataQuery.getPSDEDATAQUERYID());
            this.dstPSDEDataQuery = this.getPSDEMap().getDstPSDE().getPSDEDataQuery(psDEMapDataQuery.getDSTPSDEDATAQUERYID());
            if (!StringHelper.isNullOrEmpty((String)this.psDEMapDataQuery.getPROPERTYMAP())) {
                this.mapParams = PropertiesHelper.load((String)this.psDEMapDataQuery.getPROPERTYMAP());
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
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u67e5\u8be2", dumpref=true, from="IPSDEMap", from_method="getDstPSDEMust().getPSDEDataQuery", fields={"DSTPSDEDATAQUERYID"})
    public IPSDEDataQuery getDstPSDEDataQuery() {
        return this.dstPSDEDataQuery;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u5b9e\u4f53\u67e5\u8be2", dumpref=true, from="IPSDataEntity", fields={"PSDEDATAQUERYID"})
    public IPSDEDataQuery getSrcPSDEDataQuery() {
        return this.srcPSDEDataQuery;
    }

    @Override
    public String getModelType() {
        return "PSDEMAPDQ";
    }

    @Override
    public String getModelRefId() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u52a8\u6001\u53c2\u6570", hideempty=true, ignorepf=true)
    public Properties getMapParams() {
        return this.mapParams;
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u6a21\u5f0f", hideempty=true, ignorepf=true, codelist="DEMapObjectMapMode", ignoredumpvalues="DEFAULT", fields={"MAPMODE"})
    public String getMapMode() {
        if (!StringHelper.isNullOrEmpty((String)this.psDEMapDataQuery.getMAPMODE())) {
            return this.psDEMapDataQuery.getMAPMODE();
        }
        return this.getPSDEMap().getMapMode();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u67e5\u8be2\u6761\u4ef6\u9644\u52a0", hideempty=true, ignorepf=true, ignoredumpvalues="false", fields={"ENABLEDQCOND"})
    public boolean isEnableDQCond() {
        return this.psDEMapDataQuery.getENABLEDQCOND();
    }
}

