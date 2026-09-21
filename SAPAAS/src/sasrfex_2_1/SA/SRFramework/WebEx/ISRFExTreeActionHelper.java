/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.SRFExTreePanel;

public interface ISRFExTreeActionHelper {
    public static final String ACTION_LOAD = "load";
    public static final String ACTION_REFRESH = "refresh";
    public static final String ACTION_CREATE = "create";
    public static final String ACTION_REMOVE = "remove";
    public static final String ACTION_UPDATE = "update";

    public boolean Process(SRFExPage var1, String var2, String var3);

    public boolean Process(SRFExPage var1, String var2, String var3, String var4);

    public boolean ShowTreeNodeLevel(SRFExPage var1, SRFExTreePanel var2, int var3);

    public boolean ShowTreeNode(SRFExPage var1, SRFExTreePanel var2, String var3);
}

