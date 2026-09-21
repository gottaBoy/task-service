/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IActionContext
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelrt.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.demodel.psmodelrt.logic.PSModelRTfillADViewRVsLogicModelBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSModelRTfillADViewRVsLogicModel
extends PSModelRTfillADViewRVsLogicModelBase {
    private static final Log log = LogFactory.getLog(PSModelRTfillADViewRVsLogicModel.class);

    @Override
    protected void onExecute(IActionContext iActionContext) throws Exception {
        IEntity iEntity = (IEntity)iActionContext.getParam("Default");
        String string = DataObject.getStringValue((Object)iEntity.get("nodeid2"));
        iEntity.set("nodeid", (Object)StringHelper.format((String)"METHOD@getPSAppViewRefs@PSAPPVIEW@%1$s", (Object)string));
    }
}

