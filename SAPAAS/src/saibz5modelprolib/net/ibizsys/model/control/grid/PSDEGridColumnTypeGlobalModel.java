/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.grid;

import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.control.grid.IPSDEGridColumnType;
import net.ibizsys.model.control.grid.PSDEGridColumnTypeImpl;
import net.ibizsys.model.entity.PSDEGridColumnType;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEGridColumnTypeGlobalModel
extends PSGlobalModelBase<String, PSDEGridColumnType, IPSDEGridColumnType> {
    private static final Log log = LogFactory.getLog(PSDEGridColumnTypeGlobalModel.class);

    @Override
    protected PSDEGridColumnType getObject(String strPSDEGridColumnTypeId) {
        PSDEGridColumnType PSDEGridColumnType2 = new PSDEGridColumnType();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEGridColumnType(strPSDEGridColumnTypeId, PSDEGridColumnType2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5b9e\u4f53\u8868\u683c\u5217\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEGridColumnTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDEGridColumnType2;
    }

    @Override
    protected IPSDEGridColumnType onCreateModelHelper(PSDEGridColumnType vt) throws Exception {
        PSDEGridColumnTypeImpl iPSDEGridColumnType = new PSDEGridColumnTypeImpl();
        iPSDEGridColumnType.init(this.getPSModelStorageContext(), vt);
        return iPSDEGridColumnType;
    }

    @Override
    protected Boolean testObjectRenew(PSDEGridColumnType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDEGridColumnType vt) {
        return vt.getPSDEGCTYPEID();
    }
}

