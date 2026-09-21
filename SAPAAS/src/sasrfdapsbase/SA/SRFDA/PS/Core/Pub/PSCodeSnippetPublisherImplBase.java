/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.ext.beans.StringModel
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.CodeSnippet.IPSDCCodeSnippet;
import SA.SRFDA.PS.Core.CodeSnippet.IPSDCCodeSnippetRef;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSCodeSnippetPublisher;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSCodeSnippetRefMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import freemarker.ext.beans.StringModel;
import java.util.HashMap;

public abstract class PSCodeSnippetPublisherImplBase
extends PSObjectImpl
implements IPSCodeSnippetPublisher {
    private IPSDCCodeSnippet iPSDCCodeSnippet = null;
    private IPSPublisherContext iPSPublisherContext = null;
    private IPSObject iPSObject = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDCCodeSnippet iPSDCCodeSnippet) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSDCCodeSnippet = iPSDCCodeSnippet;
        this.onInit();
    }

    @Override
    public IPSPublisherContext getContext() {
        return this.iPSPublisherContext;
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSObject iPSObject) throws Exception {
        this.iPSPublisherContext = iPSPublisherContext;
        this.iPSObject = iPSObject;
        return this.onGenerateCode(iPSObject);
    }

    protected IPSGenerateCodeResult onGenerateCode(IPSObject iPSObject) throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();
        if (this.iPSPublisherContext != null && this.iPSPublisherContext.getPubParams() != null) {
            params.putAll(this.iPSPublisherContext.getPubParams());
        }
        params.put("publisher", this);
        params.put("item", iPSObject);
        PSCodeSnippetRefMethod psCodeSnippetRefMethod = new PSCodeSnippetRefMethod(this);
        params.put("srfrefcode", psCodeSnippetRefMethod);
        this.onFillGenerateCodeParams("", iPSObject, params);
        PSGenerateCodeResultImpl psGenerateCodeResultImpl = new PSGenerateCodeResultImpl();
        psGenerateCodeResultImpl.setObject(iPSObject);
        psGenerateCodeResultImpl.setCode(PSTemplHelper.generateCode((BaseDataEntity)this.iPSDCCodeSnippet.getPSDCCodeSnippetData(), "TEMPLCODE", params));
        psGenerateCodeResultImpl.setParams(params);
        return psGenerateCodeResultImpl;
    }

    @Override
    public void close() {
        this.onClose();
        if (this.iPSDCCodeSnippet != null) {
            this.iPSDCCodeSnippet.releasePSCodeSnippetPublisher(this);
        }
    }

    protected void onClose() {
        this.iPSPublisherContext = null;
        this.iPSObject = null;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    public IPSDCCodeSnippet getPSDCCodeSnippet() {
        return this.iPSDCCodeSnippet;
    }

    protected IPSObject getPSObject() {
        return this.iPSObject;
    }

    protected void onFillGenerateCodeParams(String strObjType, Object obj, HashMap<String, Object> params) throws Exception {
    }

    @Override
    public IPSGenerateCodeResult getRef(String strRefMode, Object obj) throws Exception {
        if (obj != null && obj instanceof StringModel) {
            obj = ((StringModel)obj).getWrappedObject();
        }
        if (obj == null || !(obj instanceof IPSObject)) {
            throw new Exception("\u4f20\u5165\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e\uff0c\u5fc5\u987b\u4e3a\u6a21\u578b\u5bf9\u8c61");
        }
        IPSDCCodeSnippetRef iPSDCCodeSnippetRef = this.getPSDCCodeSnippet().getPSDCCodeSnippetRef(strRefMode, true);
        if (iPSDCCodeSnippetRef == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u7247\u6bb5\u5f15\u7528[%1$s]", (Object)strRefMode));
        }
        IPSDCCodeSnippet iPSDCCodeSnippet = iPSDCCodeSnippetRef.getRefPSDCCodeSnippet();
        PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(), null);
        psPublishContextImpl.setPSSysModelInstId(this.getPSSysModelInstId());
        HashMap<String, Object> params = new HashMap<String, Object>();
        if (params.size() > 0) {
            psPublishContextImpl.setPubParams(params);
        }
        IPSCodeSnippetPublisher iPSCodeSnippetPublisher = iPSDCCodeSnippet.getPSCodeSnippetPublisher();
        IPSGenerateCodeResult iPSGenerateCodeResult = iPSCodeSnippetPublisher.generateCode(psPublishContextImpl, (IPSObject)obj);
        iPSCodeSnippetPublisher.close();
        return iPSGenerateCodeResult;
    }
}

