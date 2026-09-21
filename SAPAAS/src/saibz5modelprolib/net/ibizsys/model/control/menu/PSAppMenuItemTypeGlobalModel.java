/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.menu;

import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.control.menu.IPSAppMenuItemType;
import net.ibizsys.model.control.menu.PSAppMenuItemTypeImpl;
import net.ibizsys.model.entity.PSAppMenuItemType;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppMenuItemTypeGlobalModel
extends PSGlobalModelBase<String, PSAppMenuItemType, IPSAppMenuItemType> {
    private static final Log log = LogFactory.getLog(PSAppMenuItemTypeGlobalModel.class);

    @Override
    protected PSAppMenuItemType getObject(String strPSAppMenuItemTypeId) {
        PSAppMenuItemType PSAppMenuItemType2 = new PSAppMenuItemType();
        CallResult callResult = this.getPSModelQueryHelper().getPSAppMenuItemType(strPSAppMenuItemTypeId, PSAppMenuItemType2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5e94\u7528\u83dc\u5355\u9879\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppMenuItemTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSAppMenuItemType2;
    }

    @Override
    protected IPSAppMenuItemType onCreateModelHelper(PSAppMenuItemType vt) throws Exception {
        PSAppMenuItemTypeImpl iPSAppMenuItemType = new PSAppMenuItemTypeImpl();
        iPSAppMenuItemType.init(this.getPSModelStorageContext(), vt);
        return iPSAppMenuItemType;
    }

    @Override
    protected Boolean testObjectRenew(PSAppMenuItemType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSAppMenuItemType vt) {
        return vt.getPSAMITEMTYPEID();
    }
}

