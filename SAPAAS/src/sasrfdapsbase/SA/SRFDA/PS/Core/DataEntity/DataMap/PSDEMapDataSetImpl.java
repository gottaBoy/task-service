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

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMap;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMapDataSet;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMap;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataMap.PSDEMapObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSDEMapDataSet;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEMapDataSetImpl
extends PSDEMapObjectImpl
implements IPSDEMapDataSet,
IPSAppDEMapDataSet {
    private static final Log log = LogFactory.getLog(PSDEMapDataSetImpl.class);
    private PSDEMapDataSet psDEMapDataSet = null;
    private IPSDEDataSet srcPSDEDataSet = null;
    private IPSDEDataSet dstPSDEDataSet = null;
    private IPSAppDEDataSet srcPSAppDEDataSet = null;
    private IPSAppDEDataSet dstPSAppDEDataSet = null;
    private Properties mapParams = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEMap iPSDEMap, PSDEMapDataSet psDEMapDataSet) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEMap(iPSDEMap);
            this.psDEMapDataSet = psDEMapDataSet;
            this.setId(this.psDEMapDataSet.getPSDEMAPDSID());
            this.setName(this.psDEMapDataSet.getPSDEMAPDSNAME());
            this.setPSObjectData(this.psDEMapDataSet);
            this.srcPSDEDataSet = this.getPSDEMap().getPSDataEntity().getPSDEDataSet(psDEMapDataSet.getPSDEDATASETID());
            this.dstPSDEDataSet = this.getPSDEMap().getDstPSDE().getPSDEDataSet(psDEMapDataSet.getDSTPSDEDATASETID());
            if (iPSDEMap instanceof IPSAppDEMap) {
                IPSAppDEMap iPSAppDEMap = (IPSAppDEMap)iPSDEMap;
                if (iPSAppDEMap.getPSAppDataEntity() != null) {
                    this.srcPSAppDEDataSet = iPSAppDEMap.getPSAppDataEntity().getPSAppDEDataSet(this.srcPSDEDataSet, false);
                }
                if (iPSAppDEMap.getDstPSAppDataEntity() != null) {
                    this.dstPSAppDEDataSet = iPSAppDEMap.getDstPSAppDataEntity().getPSAppDEDataSet(this.dstPSDEDataSet, false);
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEMapDataSet.getPROPERTYMAP())) {
                this.mapParams = PropertiesHelper.load((String)this.psDEMapDataSet.getPROPERTYMAP());
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
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u6570\u636e\u96c6\u5408", dumpref=true, from="IPSDEMap", from_method="getDstPSDEMust().getPSDEDataSet", ignorepf=true, fields={"DSTPSDEDATASETID"})
    public IPSDEDataSet getDstPSDEDataSet() {
        return this.dstPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u5b9e\u4f53\u6570\u636e\u96c6\u5408", dumpref=true, from="IPSDataEntity", ignorepf=true, fields={"PSDEDATASETID"})
    public IPSDEDataSet getSrcPSDEDataSet() {
        return this.srcPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6", dumpref=true, from="IPSAppDEMap", from_method="getDstPSAppDataEntityMust().getPSAppDEDataSet")
    public IPSAppDEDataSet getDstPSAppDEDataSet() {
        return this.dstPSAppDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6", dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEDataSet getSrcPSAppDEDataSet() {
        return this.srcPSAppDEDataSet;
    }

    @Override
    public String getModelType() {
        if (StringHelper.compare((String)this.getPSDEMap().getModelType(), (String)"PSAPPDEMAP", (boolean)true) == 0) {
            return "PSAPPDEMAPDS";
        }
        return "PSDEMAPDS";
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
        if (!StringHelper.isNullOrEmpty((String)this.psDEMapDataSet.getMAPMODE())) {
            return this.psDEMapDataSet.getMAPMODE();
        }
        return this.getPSDEMap().getMapMode();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u67e5\u8be2\u6761\u4ef6\u9644\u52a0", hideempty=true, ignorepf=true, ignoredumpvalues="false", fields={"ENABLEDQCOND"})
    public boolean isEnableDQCond() {
        return this.psDEMapDataSet.getENABLEDQCOND();
    }
}

