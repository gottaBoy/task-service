/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.field;

import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.dataentity.field.IPSDEFieldType;
import net.ibizsys.model.dataentity.field.PSDEFieldTypeImpl;
import net.ibizsys.model.entity.PSDEFieldType;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFieldTypeGlobalModel
extends PSGlobalModelBase<String, PSDEFieldType, IPSDEFieldType> {
    private static final Log log = LogFactory.getLog(PSDEFieldTypeGlobalModel.class);

    @Override
    protected PSDEFieldType getObject(String strPSDEFieldTypeId) {
        log.error((Object)StringHelper.format((String)"\u4e0d\u652f\u6301\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u7c7b\u578b[%1$s]\uff0c\u9700\u8981\u91cd\u65b0\u5237\u65b0\u8fdb\u884c\u52a0\u8f7d", (Object)strPSDEFieldTypeId));
        return null;
    }

    @Override
    protected IPSDEFieldType onCreateModelHelper(PSDEFieldType vt) throws Exception {
        PSDEFieldTypeImpl iPSDEFieldType = null;
        iPSDEFieldType = new PSDEFieldTypeImpl();
        iPSDEFieldType.init(this.getPSModelStorageContext(), vt);
        return iPSDEFieldType;
    }

    @Override
    protected Boolean testObjectRenew(PSDEFieldType obj) {
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
        CallResult callResult = this.getPSModelQueryHelper().getAllPSDEFieldTypes(list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u5c5e\u6027\u7c7b\u578b\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
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
        IPSDEFieldType iPSDEFieldType = (IPSDEFieldType)this.internalGetModelHelper(vt.getPSDEFTYPEID());
        if (iPSDEFieldType != null) {
            return iPSDEFieldType;
        }
        this.setModel(vt.getPSDEFTYPEID(), vt, null);
        return (IPSDEFieldType)this.findModelHelper(vt.getPSDEFTYPEID());
    }
}

