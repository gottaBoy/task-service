/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapAction;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapActionServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEMapActionService
extends PSDEMapActionServiceBase {
    private static final Log log = LogFactory.getLog(PSDEMapActionService.class);

    @Override
    protected void onBeforeCreateTemp(PSDEMapAction pSDEMapAction) throws Exception {
        pSDEMapAction.setPSDEMapActionName(this.calcPSDEMapActionName(pSDEMapAction));
        super.onBeforeCreateTemp(pSDEMapAction);
    }

    @Override
    protected void onBeforeUpdateTemp(PSDEMapAction pSDEMapAction) throws Exception {
        pSDEMapAction.setPSDEMapActionName(this.calcPSDEMapActionName(pSDEMapAction));
        super.onBeforeUpdateTemp(pSDEMapAction);
    }

    protected String calcPSDEMapActionName(PSDEMapAction pSDEMapAction) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        stringBuilderEx.append("\u6e90\u884c\u4e3a[%1$s]", (Object)pSDEMapAction.getPSDEActionName());
        stringBuilderEx.append(" ==> \u76ee\u6807\u884c\u4e3a[%1$s]", (Object)pSDEMapAction.getDstPSDEActionName());
        return stringBuilderEx.toString();
    }

    @Override
    public Object getDataContextValue(PSDEMapAction pSDEMapAction, String string, IDataContextParam iDataContextParam) throws Exception {
        if (iDataContextParam != null && pSDEMapAction.getPSDEMap() != null && StringHelper.compare((String)string, (String)"psdeid", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"psdeaction", (boolean)true) == 0) {
            if (StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSDEACTIONNAME", (boolean)true) == 0) {
                return pSDEMapAction.getPSDEMap().getPSDEId();
            }
            if (StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEACTIONNAME", (boolean)true) == 0) {
                return pSDEMapAction.getPSDEMap().getDSTPSDEId();
            }
        }
        return super.getDataContextValue(pSDEMapAction, string, iDataContextParam);
    }
}

