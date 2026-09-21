/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDAConfigHelperPlugin
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.IDPConfigPublishContext;
import SA.SRFDA.Ctrl.Config.IDPConfigPublisherContext;
import SA.SRFDA.Ctrl.IDAConfigHelperPlugin;
import SA.SRFramework.XML.XMLNode;

public interface IDPConfigPublisherPlugin
extends IDAConfigHelperPlugin {
    public void Publish(IDPConfigPublisherContext var1, IDPConfigPublishContext var2, String var3, XMLNode var4, XMLNode var5) throws Exception;
}

