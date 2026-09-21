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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapDQ;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapDQServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEMapDQService
extends PSDEMapDQServiceBase {
    private static final Log log = LogFactory.getLog(PSDEMapDQService.class);

    @Override
    protected void onBeforeCreateTemp(PSDEMapDQ pSDEMapDQ) throws Exception {
        pSDEMapDQ.setPSDEMapDQName(this.calcPSDEMapDQName(pSDEMapDQ));
        super.onBeforeCreateTemp(pSDEMapDQ);
    }

    @Override
    protected void onBeforeUpdateTemp(PSDEMapDQ pSDEMapDQ) throws Exception {
        pSDEMapDQ.setPSDEMapDQName(this.calcPSDEMapDQName(pSDEMapDQ));
        super.onBeforeUpdateTemp(pSDEMapDQ);
    }

    protected String calcPSDEMapDQName(PSDEMapDQ pSDEMapDQ) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        stringBuilderEx.append("\u6e90\u67e5\u8be2[%1$s]", (Object)pSDEMapDQ.getPSDEDataQueryName());
        stringBuilderEx.append(" ==> \u76ee\u6807\u67e5\u8be2[%1$s]", (Object)pSDEMapDQ.getDstPSDEDataQueryName());
        return stringBuilderEx.toString();
    }

    @Override
    public Object getDataContextValue(PSDEMapDQ pSDEMapDQ, String string, IDataContextParam iDataContextParam) throws Exception {
        if (iDataContextParam != null && pSDEMapDQ.getPSDEMap() != null && StringHelper.compare((String)string, (String)"psdeid", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"psdedataquery", (boolean)true) == 0) {
            if (StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSDEDATAQUERYNAME", (boolean)true) == 0) {
                return pSDEMapDQ.getPSDEMap().getPSDEId();
            }
            if (StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEDATAQUERYNAME", (boolean)true) == 0) {
                return pSDEMapDQ.getPSDEMap().getDSTPSDEId();
            }
        }
        return super.getDataContextValue(pSDEMapDQ, string, iDataContextParam);
    }
}

