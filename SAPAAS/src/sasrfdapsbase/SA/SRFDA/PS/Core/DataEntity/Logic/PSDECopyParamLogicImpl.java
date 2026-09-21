/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDECopyParamLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDECopyParamLogicImpl
extends PSDELogicNodeImpl
implements IPSDECopyParamLogic {
    private static final Log log = LogFactory.getLog(PSDECopyParamLogicImpl.class);
    private boolean bCopyIfNotExists = false;
    private List<String> copyFieldList = null;

    @Override
    protected void onInit() throws Exception {
        String[] fields;
        if (!this.psDELogicNode.isPARAM9Null()) {
            this.bCopyIfNotExists = this.psDELogicNode.getPARAM9();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPARAM4()) && (fields = StringHelper.splitEx((String)this.psDELogicNode.getPARAM4())) != null) {
            this.copyFieldList = new ArrayList<String>();
            String[] stringArray = fields;
            int n = fields.length;
            int n2 = 0;
            while (n2 < n) {
                String field = stringArray[n2];
                this.copyFieldList.add(field);
                ++n2;
            }
        }
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.assertSrcPSDELogicParam();
        this.assertDstPSDELogicParam();
        this.assertSrcDstPSDELogicParamNotSame();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"DSTPSDLPARAMID"})
    public IPSDELogicParam getDstPSDELogicParam() throws Exception {
        return super.getDstPSDELogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"SRCPSDLPARAMID"})
    public IPSDELogicParam getSrcPSDELogicParam() throws Exception {
        return super.getSrcPSDELogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u62f7\u8d1d\u5c5e\u6027\u96c6\u5408", child=true, fields={"PARAM4"})
    public Iterator<String> getCopyFields() {
        if (this.copyFieldList == null || this.copyFieldList.size() == 0) {
            return null;
        }
        return this.copyFieldList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ec5\u62f7\u8d1d\u4e0d\u5b58\u5728\u5c5e\u6027", ignoredumpvalues="false", fields={"PARAM9"})
    public boolean isCopyIfNotExists() {
        return this.bCopyIfNotExists;
    }
}

