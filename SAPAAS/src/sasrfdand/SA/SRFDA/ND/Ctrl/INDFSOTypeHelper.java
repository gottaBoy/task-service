/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.ND.Ctrl.INDActionContext;
import SA.SRFDA.ND.Ctrl.INDObjectHelper;
import SA.SRFDA.ND.Data.NDFSOType;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public interface INDFSOTypeHelper
extends INDObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, NDFSOType var2) throws Exception;

    public CallResult MarkFSORemoveFlag(INDActionContext var1, NDFSObject var2, boolean var3) throws Exception;

    public CallResult RemoveFSO(INDActionContext var1, NDFSObject var2) throws Exception;

    public String getRealDEId();

    public String CalcFSOFullPath(INDActionContext var1, NDFSObject var2) throws Exception;

    public String CalcFSOUniqueName(INDActionContext var1, NDFSObject var2) throws Exception;

    public NDFSObject CalcFSObject(INDActionContext var1, NDFSObject var2) throws Exception;

    public void CopyFSO(INDActionContext var1, NDFSObject var2, NDFSObject var3) throws Exception;

    public NDFSObject CloneFSOItem(INDActionContext var1, NDFSObject var2, NDFSObject var3) throws Exception;

    public void MoveFSO(INDActionContext var1, NDFSObject var2, NDFSObject var3) throws Exception;

    public boolean isEnableCopy();

    public boolean isEnableMove();

    public boolean isLeafNode();
}

