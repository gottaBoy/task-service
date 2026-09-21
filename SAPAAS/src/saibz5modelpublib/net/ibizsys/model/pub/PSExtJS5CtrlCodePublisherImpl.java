/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.pub.PSPFCtrlCodePublisherImpl
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.pub;

import java.util.HashMap;
import net.ibizsys.model.pub.PSExtJSTemplHelper;
import net.ibizsys.model.pub.PSPFCtrlCodePublisherImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSExtJS5CtrlCodePublisherImpl
extends PSPFCtrlCodePublisherImpl {
    private static final Log log = LogFactory.getLog(PSPFCtrlCodePublisherImpl.class);

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        PSExtJSTemplHelper.fillParams(params);
    }
}

