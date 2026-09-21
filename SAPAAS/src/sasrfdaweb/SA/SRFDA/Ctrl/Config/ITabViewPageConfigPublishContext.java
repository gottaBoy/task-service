/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDAConfigPublishContext
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.IDAConfigPublishContext;
import SA.SRFramework.XML.XMLNode;

public interface ITabViewPageConfigPublishContext
extends IDAConfigPublishContext {
    public Object getParam();

    public String getCaption();

    public String getGroupId();

    public String getTabViewPageId();

    public void RegisterTabViewPageGroup(String var1, XMLNode var2, int var3);

    public void AddTabViewPageNode(XMLNode var1, String var2, int var3);
}

