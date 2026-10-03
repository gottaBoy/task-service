/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.devcenter.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMTDEF;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCModelTempl;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMTDEFService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCModelTemplServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDCModelTemplService
extends PSDCModelTemplServiceBase {
    private static final Log log = LogFactory.getLog(PSDCModelTemplService.class);

    @Override
    protected void onExportCurModelV2(PSDCModelTempl pSDCModelTempl, ObjectNode objectNode, String string, boolean bl) throws Exception {
        super.onExportCurModelV2(pSDCModelTempl, objectNode, string, true);
    }

    @Override
    protected void onEmptyModelV2(PSDCModelTempl pSDCModelTempl) throws Exception {
        PSDCMTDEFService pSDCMTDEFService = (PSDCMTDEFService)ServiceGlobal.getService(PSDCMTDEFService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDCMTDEF> arrayList = pSDCMTDEFService.selectByPSDCModelTempl(pSDCModelTempl);
        if (arrayList != null) {
            for (PSDCMTDEF pSDCMTDEF : arrayList) {
                pSDCMTDEFService.remove(pSDCMTDEF);
            }
        }
        super.onEmptyModelV2(pSDCModelTempl);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDCModelTempl pSDCModelTempl, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        boolean bl = PSDCModelTemplService.isSimpleImportExportMode();
        PSDCModelTemplService.setSimpleImportExportMode(false);
        super.onCompileRelatedModelV2(pSDCModelTempl, objectNode, string, string2, n);
        PSDCModelTemplService.setSimpleImportExportMode(bl);
    }

    @Override
    public boolean fillModelV2Key(PSDCModelTempl pSDCModelTempl, ObjectNode objectNode, String string, String string2, boolean bl) throws Exception {
        if (!bl) {
            if (StringHelper.isNullOrEmpty((String)pSDCModelTempl.getPSDCModelTemplId())) {
                pSDCModelTempl.setPSDCModelTemplId(KeyValueHelper.genGuidEx());
            }
            return true;
        }
        return super.fillModelV2Key(pSDCModelTempl, objectNode, string, string2, bl);
    }
}

