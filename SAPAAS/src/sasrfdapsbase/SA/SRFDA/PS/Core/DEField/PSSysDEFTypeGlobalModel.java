/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSDEFieldType;
import SA.SRFDA.PS.Core.DEField.IPSSysDEFType;
import SA.SRFDA.PS.Core.DEField.PSSysDEFTypeImpl;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysDEFType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDEFTypeGlobalModel
extends PSSystemGlobalModelBase<String, PSSysDEFType, IPSSysDEFType> {
    private static final Log log = LogFactory.getLog(PSSysDEFTypeGlobalModel.class);

    @Override
    protected PSSysDEFType GetObject(String strPSSysDEFTypeId) {
        PSSysDEFType psSysDEFType = new PSSysDEFType();
        CallResult callResult = this.iPSModelHelper.getPSSysDEFType(strPSSysDEFTypeId, psSysDEFType);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysDEFTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysDEFType;
    }

    @Override
    protected IPSSysDEFType OnCreateModelHelper(PSSysDEFType vt) throws Exception {
        PSSysDEFTypeImpl iPSSysDEFType = null;
        iPSSysDEFType = new PSSysDEFTypeImpl();
        iPSSysDEFType.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysDEFType;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysDEFType obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysDEFType registerModel(PSSysDEFType vt) throws Exception {
        IPSSysDEFType iIPSSysDEFType = (IPSSysDEFType)this.InternalGetModelHelper(vt.getPSSYSDEFTYPEID());
        if (iIPSSysDEFType != null) {
            return iIPSSysDEFType;
        }
        this.setModel(vt.getPSSYSDEFTYPEID(), vt, null);
        return (IPSSysDEFType)this.FindModelHelper(vt.getPSSYSDEFTYPEID());
    }

    @Override
    protected Vector<PSSysDEFType> getAllModels() throws Exception {
        Vector<PSSysDEFType> list = new Vector<PSSysDEFType>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysDEFTypes(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysDEFType vt) {
        return vt.getPSSYSDEFTYPEID();
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

    public IPSDEFieldType getPSDEFieldTypeByTag(String strDEFieldTag) throws Exception {
        Iterator psSysDEFTypes = this.getAllModelHelpers();
        while (psSysDEFTypes.hasNext()) {
            IPSSysDEFType iPSSysDEFType = (IPSSysDEFType)psSysDEFTypes.next();
            if (!iPSSysDEFType.isSupportPSDEField(strDEFieldTag)) continue;
            return iPSSysDEFType;
        }
        return this.iPSModelStorage.getPSDEFieldTypeByTag(strDEFieldTag);
    }
}

