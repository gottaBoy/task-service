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
import SA.SRFDA.PS.Core.DEField.PSDEFieldTypeImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEFieldType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFieldTypeGlobalModel
extends PSGlobalModelBase<String, PSDEFieldType, IPSDEFieldType> {
    private static final Log log = LogFactory.getLog(PSDEFieldTypeGlobalModel.class);

    @Override
    protected PSDEFieldType GetObject(String strPSDEFieldTypeId) {
        log.error((Object)StringHelper.Format((String)"\u4e0d\u652f\u6301\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u7c7b\u578b[%1$s]\uff0c\u9700\u8981\u91cd\u65b0\u5237\u65b0\u8fdb\u884c\u52a0\u8f7d", (Object)strPSDEFieldTypeId));
        return null;
    }

    @Override
    protected IPSDEFieldType OnCreateModelHelper(PSDEFieldType vt) throws Exception {
        PSDEFieldTypeImpl iPSDEFieldType = null;
        iPSDEFieldType = new PSDEFieldTypeImpl();
        iPSDEFieldType.init(this.iDAGlobalHelper, vt);
        return iPSDEFieldType;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEFieldType obj) {
        return false;
    }

    public IPSDEFieldType getPSDEFieldTypeByTag(String strDEFieldTag) throws Exception {
        Iterator psDEFieldTypes = this.getAllModelHelpers();
        while (psDEFieldTypes.hasNext()) {
            IPSDEFieldType iPSDEFieldType = (IPSDEFieldType)psDEFieldTypes.next();
            if (!iPSDEFieldType.isSupportPSDEField(strDEFieldTag)) continue;
            return iPSDEFieldType;
        }
        return null;
    }

    @Override
    protected Vector<PSDEFieldType> getAllModels() throws Exception {
        Vector<PSDEFieldType> list = new Vector<PSDEFieldType>();
        CallResult callResult = this.iPSModelHelper.getAllPSDEFieldTypes(list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5c5e\u6027\u7c7b\u578b\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
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
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDEFieldType vt) {
        return vt.getPSDEFTYPEID();
    }

    @Override
    protected IPSDEFieldType registerModel(PSDEFieldType vt) throws Exception {
        IPSDEFieldType iPSDEFieldType = (IPSDEFieldType)this.InternalGetModelHelper(vt.getPSDEFTYPEID());
        if (iPSDEFieldType != null) {
            return iPSDEFieldType;
        }
        this.setModel(vt.getPSDEFTYPEID(), vt, null);
        return (IPSDEFieldType)this.FindModelHelper(vt.getPSDEFTYPEID());
    }
}

