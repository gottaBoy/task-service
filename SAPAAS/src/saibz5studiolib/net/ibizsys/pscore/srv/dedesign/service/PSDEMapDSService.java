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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapDS;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapDSServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEMapDSService
extends PSDEMapDSServiceBase {
    private static final Log log = LogFactory.getLog(PSDEMapDSService.class);

    @Override
    protected void onBeforeCreateTemp(PSDEMapDS pSDEMapDS) throws Exception {
        pSDEMapDS.setPSDEMapDSName(this.calcPSDEMapDSName(pSDEMapDS));
        super.onBeforeCreateTemp(pSDEMapDS);
    }

    @Override
    protected void onBeforeUpdateTemp(PSDEMapDS pSDEMapDS) throws Exception {
        pSDEMapDS.setPSDEMapDSName(this.calcPSDEMapDSName(pSDEMapDS));
        super.onBeforeUpdateTemp(pSDEMapDS);
    }

    protected String calcPSDEMapDSName(PSDEMapDS pSDEMapDS) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        stringBuilderEx.append("\u6e90\u6570\u636e\u96c6[%1$s]", (Object)pSDEMapDS.getPSDEDataSetName());
        stringBuilderEx.append(" ==> \u76ee\u6807\u6570\u636e\u96c6[%1$s]", (Object)pSDEMapDS.getDstPSDEDataSetName());
        return stringBuilderEx.toString();
    }

    @Override
    public Object getDataContextValue(PSDEMapDS pSDEMapDS, String string, IDataContextParam iDataContextParam) throws Exception {
        if (iDataContextParam != null && pSDEMapDS.getPSDEMap() != null && StringHelper.compare((String)string, (String)"psdeid", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"psdedataset", (boolean)true) == 0) {
            if (StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSDEDATASETNAME", (boolean)true) == 0) {
                return pSDEMapDS.getPSDEMap().getPSDEId();
            }
            if (StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEDATASETNAME", (boolean)true) == 0) {
                return pSDEMapDS.getPSDEMap().getDSTPSDEId();
            }
        }
        return super.getDataContextValue(pSDEMapDS, string, iDataContextParam);
    }
}

