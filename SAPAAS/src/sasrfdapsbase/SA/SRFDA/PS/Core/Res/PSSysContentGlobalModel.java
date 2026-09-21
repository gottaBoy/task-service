/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Res.IPSSysContent;
import SA.SRFDA.PS.Core.Res.IPSSysContentCat;
import SA.SRFDA.PS.Core.Res.PSSysContentImpl;
import SA.SRFDA.PS.Data.PSSysContent;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysContentGlobalModel
extends PSSystemGlobalModelBase<String, PSSysContent, IPSSysContent> {
    private static final Log log = LogFactory.getLog(PSSysContentGlobalModel.class);
    private IPSSysContentCat iPSSysContentCat = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysContentCat iPSSysContentCat) {
        this.iPSSysContentCat = iPSSysContentCat;
        return super.Init(iDAGlobalHelper, this.iPSSysContentCat.getPSSystem());
    }

    public IPSSysContentCat getPSSysContentCat() {
        return this.iPSSysContentCat;
    }

    @Override
    protected PSSysContent GetObject(String strPSSysContentId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSSysContent psSysContent = new PSSysContent();
        CallResult callResult = this.iPSModelHelper.getPSSysContent(strPSSysContentId, psSysContent);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u9884\u7f6e\u5185\u5bb9[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysContentId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysContent;
    }

    @Override
    protected IPSSysContent OnCreateModelHelper(PSSysContent vt) throws Exception {
        PSSysContentImpl iPSSysContent = new PSSysContentImpl();
        iPSSysContent.init(this.iDAGlobalHelper, this.getPSSysContentCat(), vt);
        return iPSSysContent;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysContent obj) {
        return false;
    }

    @Override
    protected IPSSysContent registerModel(PSSysContent vt) throws Exception {
        IPSSysContent iPSSysContent = (IPSSysContent)this.InternalGetModelHelper(vt.getPSSYSCONTENTID());
        if (iPSSysContent != null) {
            return iPSSysContent;
        }
        this.setModel(vt.getPSSYSCONTENTID(), vt, null);
        iPSSysContent = (IPSSysContent)this.FindModelHelper(vt.getPSSYSCONTENTID());
        return iPSSysContent;
    }

    @Override
    protected void onPreloadModels() {
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected Vector<PSSysContent> getAllModels() throws Exception {
        Vector<PSSysContent> list = new Vector<PSSysContent>();
        CallResult callResult = this.iPSModelHelper.getPSSysContents(this.getPSSysContentCat().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5206\u7c7b\u5168\u90e8\u5185\u5bb9\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysContent vt) {
        return vt.getPSSYSCONTENTID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysContent vt) {
        if (!net.ibizsys.paas.util.StringHelper.isNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

