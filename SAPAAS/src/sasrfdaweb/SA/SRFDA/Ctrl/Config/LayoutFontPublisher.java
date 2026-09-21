/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.BaseLayoutItemPublisher;

public class LayoutFontPublisher
extends BaseLayoutItemPublisher {
    protected void OnInit() throws Exception {
        super.OnInit();
        this.modelPropertyMap.put("size", new BaseLayoutItemPublisher.ModelProperty("FONTSIZE", null));
        this.modelPropertyMap.put("name", new BaseLayoutItemPublisher.ModelProperty("FONTNAME", null));
    }
}

