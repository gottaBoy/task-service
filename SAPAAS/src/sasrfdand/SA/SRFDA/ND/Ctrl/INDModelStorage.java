/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.ND.Ctrl.INDConfigTypeHelper;
import SA.SRFDA.ND.Ctrl.INDDiskOwnerTypeHelper;
import SA.SRFDA.ND.Ctrl.INDFSOTypeHelper;
import SA.SRFDA.ND.Data.NDDisk;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface INDModelStorage {
    public void Init(ISRFDAGlobalHelper var1) throws Exception;

    public INDDiskOwnerTypeHelper FindNDDiskOwnerType(String var1) throws Exception;

    public INDFSOTypeHelper FindNDFSOType(String var1) throws Exception;

    public NDFSObject FindNDFSObject(String var1, String var2, boolean var3) throws Exception;

    public NDFSObject FindNDFSObject(String var1, String var2, String var3) throws Exception;

    public NDDisk FindNDDisk(String var1) throws Exception;

    public INDConfigTypeHelper FindNDConfigType(String var1) throws Exception;
}

