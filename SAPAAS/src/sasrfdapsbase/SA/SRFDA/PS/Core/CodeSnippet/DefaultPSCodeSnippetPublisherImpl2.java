/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Core.CodeSnippet;

import SA.SRFDA.PS.Core.CodeSnippet.DefaultPSCodeSnippetPublisherImpl;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSCodeSnippetRefMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSDCCodeSnippet;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.HashMap;

public class DefaultPSCodeSnippetPublisherImpl2
extends DefaultPSCodeSnippetPublisherImpl {
    private PSDCCodeSnippet codeEntity = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDCCodeSnippet codeEntity) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.codeEntity = codeEntity;
        this.onInit();
    }

    @Override
    protected IPSGenerateCodeResult onGenerateCode(IPSObject iPSObject) throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();
        if (this.getContext() != null && this.getContext().getPubParams() != null) {
            params.putAll(this.getContext().getPubParams());
        }
        params.put("publisher", this);
        params.put("item", iPSObject);
        PSCodeSnippetRefMethod psCodeSnippetRefMethod = new PSCodeSnippetRefMethod(this);
        params.put("srfrefcode", psCodeSnippetRefMethod);
        this.onFillGenerateCodeParams("", iPSObject, params);
        PSGenerateCodeResultImpl psGenerateCodeResultImpl = new PSGenerateCodeResultImpl();
        psGenerateCodeResultImpl.setObject(iPSObject);
        psGenerateCodeResultImpl.setCode(PSTemplHelper.generateCode((BaseDataEntity)this.codeEntity, "TEMPLCODE", params));
        psGenerateCodeResultImpl.setParams(params);
        return psGenerateCodeResultImpl;
    }
}

