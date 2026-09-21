/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DERGroupFolder;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDERGroupFolderHelper
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, DERGroupFolder var2) throws Exception;

    public String getCaption(String var1);

    public String getSmallIcon();

    public boolean isCollapse();

    public String getMemo();

    public int getShowOrder();
}

