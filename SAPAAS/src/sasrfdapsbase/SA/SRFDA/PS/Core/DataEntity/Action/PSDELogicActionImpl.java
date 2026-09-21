/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDELogicAction;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionImplBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDELogicActionImpl
extends PSDEActionImplBase
implements IPSDELogicAction {
    private static final Log log = LogFactory.getLog(PSDELogicActionImpl.class);
    protected IPSDELogic iPSDELogic = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (StringHelper.isNullOrEmpty((String)this.psDEAction.getPSDELOGICID())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u884c\u4e3a\u5904\u7406\u903b\u8f91");
        }
        this.iPSDELogic = this.getPSDataEntity().getPSDELogic(this.psDEAction.getPSDELOGICID());
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5904\u7406\u903b\u8f91", dumpref=true, from="IPSDataEntity", group="\u57fa\u672c", order=126, fields={"PSDELOGICID"})
    public IPSDELogic getPSDELogic() throws Exception {
        return this.iPSDELogic;
    }

    @Override
    public String getModelType() {
        return "PSDEACTION";
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6301\u6709\u8005", codelist="DELogicHolder", ignoredumpvalues="3", dynamodelmode=4, fields={"ACTIONHOLDER"}, doc="\u884c\u4e3a\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5904\u7406\u903b\u8f91{@link #getPSDELogic}\u7684\u903b\u8f91\u6301\u6709\u8005\u914d\u7f6e")
    public int getActionHolder() {
        try {
            if (!this.isCustomActionHolder()) {
                return this.getPSDELogic().getLogicHolder();
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return super.getActionHolder();
    }

    @Override
    protected String onCalcActionMode(String strPSDEActionName) throws Exception {
        String strActionMode = super.onCalcActionMode(strPSDEActionName);
        if (StringHelper.compare((String)strActionMode, (String)"UNKNOWN", (boolean)false) == 0) {
            return "CUSTOM";
        }
        return strActionMode;
    }

    @Override
    protected boolean onGetPrepareLast() {
        boolean bRet = super.onGetPrepareLast();
        if (!bRet) {
            try {
                return this.getPSDELogic().isPrepareLast();
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return bRet;
    }
}

