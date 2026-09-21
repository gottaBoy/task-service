/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMergeParamLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEMergeParamLogicImpl
extends PSDELogicNodeImpl
implements IPSDEMergeParamLogic {
    private static final Log log = LogFactory.getLog(PSDEMergeParamLogicImpl.class);
    private String strMergeMode = null;
    private boolean bCopyIfNotExists = false;
    private List<String> copyFieldList = null;
    private boolean bMergeIntoField = false;
    private String strSrcParamMergeField = null;
    private String strDstParamMergeField = null;

    @Override
    protected void onInit() throws Exception {
        String[] fields;
        this.strMergeMode = this.psDELogicNode.getPARAM1();
        if (!this.psDELogicNode.isPARAM10Null()) {
            this.bMergeIntoField = this.psDELogicNode.getPARAM10();
        }
        if (this.isMergeIntoField()) {
            this.strSrcParamMergeField = this.psDELogicNode.getPARAM2();
            this.strDstParamMergeField = this.psDELogicNode.getPARAM3();
        } else if (!this.psDELogicNode.isPARAM9Null()) {
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
        int nRet = 0;
        this.assertSrcPSDELogicParam();
        this.assertDstPSDELogicParam();
        this.assertSrcDstPSDELogicParamNotSame();
        this.assertPSDELogicNodeParams("\u672a\u6307\u5b9a\u5408\u5e76\u5206\u7ec4\u53c2\u6570");
        if (this.isMergeIntoField() && StringHelper.isNullOrEmpty((String)this.getSrcParamMergeField())) {
            throw new Exception("\u672a\u6307\u5b9a\u6e90\u53c2\u6570\u5408\u5e76\u5c5e\u6027");
        }
        return nRet + super.onCheck();
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
    @PSModelRTMeta(description="\u8fd4\u56de\u503c\u7ed1\u5b9a\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"RETPSDLPARAMID"})
    public IPSDELogicParam getRetPSDELogicParam() throws Exception {
        return super.getRetPSDELogicParam();
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

    @Override
    @PSModelRTMeta(description="\u5408\u5e76\u5230\u6307\u5b9a\u5c5e\u6027", ignoredumpvalues="false", fields={"PARAM10"})
    public boolean isMergeIntoField() {
        return this.bMergeIntoField;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u53c2\u6570\u5408\u5e76\u5c5e\u6027", fields={"PARAM2"})
    public String getSrcParamMergeField() {
        return this.strSrcParamMergeField;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u53c2\u6570\u5408\u5e76\u5c5e\u6027", fields={"PARAM3"})
    public String getDstParamMergeField() {
        return this.strDstParamMergeField;
    }

    @Override
    @PSModelRTMeta(description="\u5408\u5e76\u6a21\u5f0f", codelist="DELNMergeParamMode", fields={"PARAM1"})
    public String getMergeMode() {
        return this.strMergeMode;
    }
}

