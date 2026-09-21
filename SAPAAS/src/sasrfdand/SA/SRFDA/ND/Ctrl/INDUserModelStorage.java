/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.ORGTreeNode
 *  SA.SRFDA.Security.IUserRoleHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.Ctrl.Data.ORGTreeNode;
import SA.SRFDA.ND.Ctrl.INDActionContext;
import SA.SRFDA.ND.Data.NDDisk;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.ND.Data.NDShare;
import SA.SRFDA.Security.IUserRoleHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface INDUserModelStorage {
    public void Init(ISRFDAGlobalHelper var1, IUserRoleHelper var2) throws Exception;

    public NDDisk FindNDDisk(boolean var1) throws Exception;

    public NDDisk FindNDDisk(String var1, String var2, boolean var3) throws Exception;

    public NDDisk FindNDDisk(String var1, boolean var2) throws Exception;

    public NDShare FindNDShare(String var1, boolean var2) throws Exception;

    public NDFSObject FindNDFSObject(String var1, String var2, boolean var3, boolean var4) throws Exception;

    public NDFSObject FindNDFSObject(String var1, String var2, String var3, boolean var4) throws Exception;

    public Iterator<NDDisk> getDeptNDDisks() throws Exception;

    public void setNDORGTreeId(String var1);

    public String getNDORGTreeId();

    public Iterator<String> getParentORGTreeNodeIds(boolean var1) throws Exception;

    public Iterator<ORGTreeNode> getCurORGTreeNodes() throws Exception;

    public boolean TestFSOAction(INDActionContext var1, NDFSObject var2, int var3) throws Exception;
}

