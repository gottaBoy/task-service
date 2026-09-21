/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.ND.Ctrl.INDActionContext;
import SA.SRFDA.ND.Ctrl.INDObjectHelper;
import SA.SRFDA.ND.Data.NDDisk;
import SA.SRFDA.ND.Data.NDDiskOwnerType;
import SA.SRFDA.ND.Security.INDAccHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface INDDiskOwnerTypeHelper
extends INDObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, NDDiskOwnerType var2) throws Exception;

    public void InitNDDisk(INDActionContext var1, NDDisk var2) throws Exception;

    public INDAccHelper getNDAccHelper() throws Exception;
}

