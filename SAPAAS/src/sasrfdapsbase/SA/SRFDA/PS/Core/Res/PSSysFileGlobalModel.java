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
import SA.SRFDA.PS.Core.Res.IPSSysFile;
import SA.SRFDA.PS.Core.Res.PSSysFileImpl;
import SA.SRFDA.PS.Data.PSSysFile;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysFileGlobalModel
extends PSSystemGlobalModelBase<String, PSSysFile, IPSSysFile> {
    private static final Log log = LogFactory.getLog(PSSysFileGlobalModel.class);

    @Override
    protected PSSysFile GetObject(String strPSSysFileId) {
        PSSysFile psSysFile = new PSSysFile();
        CallResult callResult = this.iPSModelHelper.getPSSysFile(strPSSysFileId, psSysFile);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u6587\u4ef6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysFileId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysFile;
    }

    @Override
    protected IPSSysFile OnCreateModelHelper(PSSysFile vt) throws Exception {
        PSSysFileImpl iPSSysFile = null;
        iPSSysFile = new PSSysFileImpl();
        iPSSysFile.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysFile;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysFile obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysFile registerModel(PSSysFile vt) throws Exception {
        IPSSysFile iIPSSysFile = (IPSSysFile)this.InternalGetModelHelper(vt.getPSSYSFILEID());
        if (iIPSSysFile != null) {
            return iIPSSysFile;
        }
        this.setModel(vt.getPSSYSFILEID(), vt, null);
        return (IPSSysFile)this.FindModelHelper(vt.getPSSYSFILEID());
    }

    @Override
    protected Vector<PSSysFile> getAllModels() throws Exception {
        Vector<PSSysFile> list = new Vector<PSSysFile>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysFiles(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u7cfb\u7edf\u6587\u4ef6\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysFile vt) {
        return vt.getPSSYSFILEID();
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
}

