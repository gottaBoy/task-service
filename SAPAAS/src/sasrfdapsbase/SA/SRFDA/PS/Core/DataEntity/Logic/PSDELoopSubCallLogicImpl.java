/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELoopSubCallLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELoopSubCallLogicImpl
extends PSDELogicNodeImpl
implements IPSDELoopSubCallLogic {
    private static final Log log = LogFactory.getLog(PSDELoopSubCallLogicImpl.class);

    @Override
    protected int onCheck() throws Exception {
        this.assertSrcPSDELogicParam("\u672a\u6307\u5b9a\u5faa\u73af\u5217\u8868\u53c2\u6570\u5bf9\u8c61");
        this.assertDstPSDELogicParam("\u672a\u6307\u5b9a\u5faa\u73af\u9879\u7ed1\u5b9a\u903b\u8f91\u53c2\u6570\u5bf9\u8c61");
        boolean bHasSubCallLink = false;
        Iterator<IPSDELogicLink> psDELogicLinks = this.getPSDELogicLinks();
        if (psDELogicLinks != null) {
            while (psDELogicLinks.hasNext()) {
                IPSDELogicLink iPSDELogicLink = psDELogicLinks.next();
                if (!iPSDELogicLink.isSubCallLink()) continue;
                bHasSubCallLink = true;
            }
        }
        if (!bHasSubCallLink) {
            throw new Exception("\u672a\u6307\u5b9a\u5faa\u73af\u8c03\u7528\u903b\u8f91\u8fde\u63a5");
        }
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u5217\u8868\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"SRCPSDLPARAMID"})
    public IPSDELogicParam getSrcPSDELogicParam() throws Exception {
        return super.getSrcPSDELogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u586b\u5145\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"DSTPSDLPARAMID"})
    public IPSDELogicParam getDstPSDELogicParam() throws Exception {
        return super.getDstPSDELogicParam();
    }
}

