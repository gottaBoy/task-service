/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.psrt.srv.common.service;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.OrgSecUser;
import net.ibizsys.psrt.srv.common.service.OrgSecUserServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class OrgSecUserService
extends OrgSecUserServiceBase {
    private static final Log log = LogFactory.getLog(OrgSecUserService.class);

    @Override
    protected void onBeforeRemove(OrgSecUser et) throws Exception {
        OrgSecUser orgSecUser;
        if (!et.isDefaultFlagDirty() && DataObject.getBoolValue((orgSecUser = (OrgSecUser)this.getLast(et)).getDefaultFlag(), false)) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u5220\u9664\u9ed8\u8ba4\u90e8\u95e8\u4eba\u5458\u5173\u7cfb"));
        }
        if (DataObject.getBoolValue(et.getDefaultFlag(), false)) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u5220\u9664\u9ed8\u8ba4\u90e8\u95e8\u4eba\u5458\u5173\u7cfb"));
        }
        super.onBeforeRemove(et);
    }

    @Override
    protected void onRemoveDefault(OrgSecUser orgSecUser) throws Exception {
        super.onRemoveDefault(orgSecUser);
    }
}

