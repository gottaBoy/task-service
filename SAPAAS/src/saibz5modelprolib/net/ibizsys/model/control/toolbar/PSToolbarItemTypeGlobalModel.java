/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.toolbar;

import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.control.toolbar.IPSToolbarItemType;
import net.ibizsys.model.control.toolbar.PSToolbarItemTypeImpl;
import net.ibizsys.model.entity.PSToolbarItemType;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSToolbarItemTypeGlobalModel
extends PSGlobalModelBase<String, PSToolbarItemType, IPSToolbarItemType> {
    private static final Log log = LogFactory.getLog(PSToolbarItemTypeGlobalModel.class);

    @Override
    protected PSToolbarItemType getObject(String strPSToolbarItemTypeId) {
        PSToolbarItemType PSToolbarItemType2 = new PSToolbarItemType();
        CallResult callResult = this.getPSModelQueryHelper().getPSToolbarItemType(strPSToolbarItemTypeId, PSToolbarItemType2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5de5\u5177\u680f\u9879\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSToolbarItemTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSToolbarItemType2;
    }

    @Override
    protected IPSToolbarItemType onCreateModelHelper(PSToolbarItemType vt) throws Exception {
        PSToolbarItemTypeImpl iPSToolbarItemType = new PSToolbarItemTypeImpl();
        iPSToolbarItemType.init(this.getPSModelStorageContext(), vt);
        return iPSToolbarItemType;
    }

    @Override
    protected Boolean testObjectRenew(PSToolbarItemType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSToolbarItemType vt) {
        return vt.getPSTBITEMTYPEID();
    }
}

