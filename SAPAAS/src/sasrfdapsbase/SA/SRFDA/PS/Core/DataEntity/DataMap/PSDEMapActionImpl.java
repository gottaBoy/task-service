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

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMap;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMapAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMap;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapAction;
import SA.SRFDA.PS.Core.DataEntity.DataMap.PSDEMapObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSDEMapAction;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEMapActionImpl
extends PSDEMapObjectImpl
implements IPSDEMapAction,
IPSAppDEMapAction {
    private static final Log log = LogFactory.getLog(PSDEMapActionImpl.class);
    private PSDEMapAction psDEMapAction = null;
    private IPSDEAction srcPSDEAction = null;
    private IPSDEAction dstPSDEAction = null;
    private IPSAppDEAction srcPSAppDEAction = null;
    private IPSAppDEAction dstPSAppDEAction = null;
    private Properties mapParams = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEMap iPSDEMap, PSDEMapAction psDEMapAction) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEMap(iPSDEMap);
            this.psDEMapAction = psDEMapAction;
            this.setId(this.psDEMapAction.getPSDEMAPACTIONID());
            this.setName(this.psDEMapAction.getPSDEMAPACTIONNAME());
            this.setPSObjectData(this.psDEMapAction);
            this.srcPSDEAction = this.getPSDEMap().getPSDataEntity().getPSDEAction(psDEMapAction.getPSDEACTIONID());
            this.dstPSDEAction = this.getPSDEMap().getDstPSDE().getPSDEAction(psDEMapAction.getDSTPSDEACTIONID());
            if (iPSDEMap instanceof IPSAppDEMap) {
                IPSAppDEMap iPSAppDEMap = (IPSAppDEMap)iPSDEMap;
                if (iPSAppDEMap.getPSAppDataEntity() != null) {
                    this.srcPSAppDEAction = iPSAppDEMap.getPSAppDataEntity().getPSAppDEAction(this.srcPSDEAction, false);
                }
                if (iPSAppDEMap.getDstPSAppDataEntity() != null) {
                    this.dstPSAppDEAction = iPSAppDEMap.getDstPSAppDataEntity().getPSAppDEAction(this.dstPSDEAction, false);
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEMapAction.getPROPERTYMAP())) {
                this.mapParams = PropertiesHelper.load((String)this.psDEMapAction.getPROPERTYMAP());
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
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSDEMap", from_method="getDstPSDEMust().getPSDEAction", ignorepf=true, fields={"DSTPSDEACTIONID"})
    public IPSDEAction getDstPSDEAction() {
        return this.dstPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSDataEntity", ignorepf=true, fields={"PSDEACTIONID"})
    public IPSDEAction getSrcPSDEAction() {
        return this.srcPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSAppDEMap", from_method="getDstPSAppDataEntityMust().getPSAppDEAction")
    public IPSAppDEAction getDstPSAppDEAction() {
        return this.dstPSAppDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEAction getSrcPSAppDEAction() {
        return this.srcPSAppDEAction;
    }

    @Override
    public String getModelType() {
        if (StringHelper.compare((String)this.getPSDEMap().getModelType(), (String)"PSAPPDEMAP", (boolean)true) == 0) {
            return "PSAPPDEMAPACTION";
        }
        return "PSDEMAPACTION";
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
    @PSModelRTMeta(description="\u6620\u5c04\u6a21\u5f0f", hideempty=true, ignorepf=true, codelist="DEMapObjectMapMode", ignoredumpvalues="DEFAULT")
    public String getMapMode() {
        if (!StringHelper.isNullOrEmpty((String)this.psDEMapAction.getMAPMODE())) {
            return this.psDEMapAction.getMAPMODE();
        }
        return this.getPSDEMap().getMapMode();
    }
}

