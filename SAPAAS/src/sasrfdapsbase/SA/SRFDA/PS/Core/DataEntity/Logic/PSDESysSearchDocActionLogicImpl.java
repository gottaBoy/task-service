/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDESysSearchDocActionLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDoc;
import SA.SRFDA.PS.Core.Search.IPSSysSearchScheme;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public class PSDESysSearchDocActionLogicImpl
extends PSDELogicNodeImpl
implements IPSDESysSearchDocActionLogic {
    private IPSSysSearchScheme iPSSysSearchScheme = null;
    private IPSSysSearchDoc iPSSysSearchDoc = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getPSSysSearchScheme();
        this.getPSSysSearchDoc();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u5168\u6587\u68c0\u7d22\u4f53\u7cfb", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSYSSEARCHSCHEMEID"})
    public IPSSysSearchScheme getPSSysSearchScheme() throws Exception {
        if (this.iPSSysSearchScheme == null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSSYSSEARCHSCHEMEID())) {
                throw new Exception("\u672a\u6307\u5b9a\u5168\u6587\u68c0\u7d22\u4f53\u7cfb");
            }
            this.iPSSysSearchScheme = this.getPSDELogic().getPSDataEntity().getPSSystem().getPSSysSearchScheme(this.psDELogicNode.getPSSYSSEARCHSCHEMEID());
        }
        return this.iPSSysSearchScheme;
    }

    @Override
    @PSModelRTMeta(description="\u68c0\u7d22\u6587\u6863", hideempty=true, dumpref=true, ignorepf=true, from="IPSSysSearchScheme", fields={"PSSYSSEARCHDOCID"})
    public IPSSysSearchDoc getPSSysSearchDoc() throws Exception {
        if (this.iPSSysSearchDoc == null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSSYSSEARCHDOCID())) {
                throw new Exception("\u672a\u6307\u5b9a\u68c0\u7d22\u6587\u6863");
            }
            this.iPSSysSearchDoc = this.getPSSysSearchScheme().getPSSysSearchDoc(this.psDELogicNode.getPSSYSSEARCHDOCID(), false);
        }
        return this.iPSSysSearchDoc;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"DSTPSDLPARAMID"})
    public IPSDELogicParam getDstPSDELogicParam() throws Exception {
        return super.getDstPSDELogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u68c0\u7d22\u6587\u6863\u64cd\u4f5c", codelist="SysDBTableAction", fields={"PARAM1"})
    public String getSearchDocAction() {
        return this.psDELogicNode.getPARAM1();
    }
}

