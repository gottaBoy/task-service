/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.IBICubeHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPartPublishContext;

public interface IBIRepPartHelper {
    public String getId();

    public int getVersion();

    public String getCustomObject();

    public void Publish(IBIRepPartPublishContext var1) throws Exception;

    public IBICubeHelper getBICube() throws Exception;
}

