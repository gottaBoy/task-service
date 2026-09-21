/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DERGroupDetail;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Ctrl.IDERGroupFolderHelper;
import SA.SRFDA.Ctrl.IDERGroupHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDERGroupDetailHelper
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, IDERGroupHelper var2, DERGroupDetail var3) throws Exception;

    public String getDetailType();

    public String getPagePath();

    public IDERGroupHelper getDERGroup();

    public String getPageId();

    public String getUrlParam();

    public int getShowOrder();

    public String getCaption(String var1);

    public String getSmallIcon();

    public String getDERGroupFolderId();

    public String getDER1NId();

    public String getDER11Id();

    public String getMemo();

    public String getDEId();

    public String getDERTypeId();

    public IDERGroupFolderHelper getDERGroupFolder();

    public String getResourceId();
}

