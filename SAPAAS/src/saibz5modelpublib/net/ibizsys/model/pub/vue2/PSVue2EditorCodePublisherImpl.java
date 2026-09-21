/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.pub.PSPFEditorCodePublisherImpl
 */
package net.ibizsys.model.pub.vue2;

import java.util.HashMap;
import net.ibizsys.model.pub.PSPFEditorCodePublisherImpl;
import net.ibizsys.model.pub.vue2.PSVue2TemplHelper;

public class PSVue2EditorCodePublisherImpl
extends PSPFEditorCodePublisherImpl {
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        PSVue2TemplHelper.fillParams(params);
        super.onFillGenerateCodeParams(params);
    }
}

