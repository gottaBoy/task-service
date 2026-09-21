/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.BaseLayoutItemPublisher;
import SA.SRFDA.Ctrl.Config.BaseLayoutPanelItemPublisher;

public class LayoutLabelPublisher
extends BaseLayoutPanelItemPublisher {
    protected void OnInit() throws Exception {
        super.OnInit();
        this.modelPropertyMap.put("x", new BaseLayoutItemPublisher.ModelProperty("X", null));
        this.modelPropertyMap.put("y", new BaseLayoutItemPublisher.ModelProperty("Y", null));
        this.modelPropertyMap.put("width", new BaseLayoutItemPublisher.ModelProperty("WIDTH", null));
        this.modelPropertyMap.put("height", new BaseLayoutItemPublisher.ModelProperty("HEIGHT", null));
        this.modelPropertyMap.put("axis", new BaseLayoutItemPublisher.ModelProperty("XYAXIS", null));
        this.modelPropertyMap.put("font", new BaseLayoutItemPublisher.ModelProperty("FONT", "LAYOUTFONTID", null));
        this.modelPropertyMap.put("padding", new BaseLayoutItemPublisher.ModelProperty("PADDING", null));
    }
}

