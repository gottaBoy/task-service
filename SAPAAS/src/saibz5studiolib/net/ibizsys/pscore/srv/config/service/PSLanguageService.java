/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.config.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.config.entity.PSLanguage;
import net.ibizsys.pscore.srv.config.service.PSLanguageServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSLanguageService
extends PSLanguageServiceBase {
    private static final Log log = LogFactory.getLog(PSLanguageService.class);

    @Override
    public boolean fillModelV2Key(PSLanguage pSLanguage, ObjectNode objectNode, String string, String string2, boolean bl) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSLanguage.getPSLanguageId())) {
            File file = new File(string2);
            pSLanguage.setPSLanguageId(file.getName());
        }
        return super.fillModelV2Key(pSLanguage, objectNode, string, string2, bl);
    }
}

