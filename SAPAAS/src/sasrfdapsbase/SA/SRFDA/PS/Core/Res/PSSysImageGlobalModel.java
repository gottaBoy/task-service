/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.PSSysImageImpl;
import SA.SRFDA.PS.Data.PSSysImage;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysImageGlobalModel
extends PSSystemGlobalModelBase<String, PSSysImage, IPSSysImage> {
    private static final Log log = LogFactory.getLog(PSSysImageGlobalModel.class);

    @Override
    protected PSSysImage GetObject(String strPSSysImageId) {
        PSSysImage psSysImage = new PSSysImage();
        CallResult callResult = this.iPSModelHelper.getPSSysImage(strPSSysImageId, psSysImage);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u56fe\u7247\u8d44\u6e90[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysImageId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysImage;
    }

    @Override
    protected IPSSysImage OnCreateModelHelper(PSSysImage vt) throws Exception {
        PSSysImageImpl iPSSysImage = null;
        iPSSysImage = new PSSysImageImpl();
        iPSSysImage.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysImage;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysImage obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysImage registerModel(PSSysImage vt) throws Exception {
        IPSSysImage iIPSSysImage = (IPSSysImage)this.InternalGetModelHelper(vt.getPSSYSIMAGEID());
        if (iIPSSysImage != null) {
            return iIPSSysImage;
        }
        this.setModel(vt.getPSSYSIMAGEID(), vt, null);
        return (IPSSysImage)this.FindModelHelper(vt.getPSSYSIMAGEID());
    }

    @Override
    protected Vector<PSSysImage> getAllModels() throws Exception {
        Vector<PSSysImage> list = new Vector<PSSysImage>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysImages(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u56fe\u7247\u8d44\u6e90\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysImage vt) {
        return vt.getPSSYSIMAGEID();
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysImage vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

