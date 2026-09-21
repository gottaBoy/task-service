/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.ITabViewConfigPublisherContext;
import SA.SRFDA.Ctrl.Config.ITabViewPageConfigPublishContext;
import java.util.Properties;

public interface ITabViewPageConfigPublisher {
    public void setParams(Properties var1);

    public void Init(ITabViewConfigPublisherContext var1);

    public void Publish(ITabViewPageConfigPublishContext var1) throws Exception;
}

