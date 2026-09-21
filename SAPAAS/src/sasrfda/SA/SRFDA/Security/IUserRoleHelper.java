/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Security;

import SA.SRFDA.Ctrl.Data.ORGTreeNode;
import SA.SRFDA.Ctrl.Data.ORGUnit;
import SA.SRFDA.Ctrl.Data.UserGroup;
import SA.SRFDA.Ctrl.Data.UserRole;
import SA.SRFDA.Ctrl.Data.UserRoleData;
import SA.SRFDA.Security.UserQueryModelStorage;
import SA.SRFramework.DataEx.CallResult;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public interface IUserRoleHelper {
    public String getCurUserId();

    public boolean isEnableOU();

    public ORGUnit getCurOU() throws Exception;

    public UserQueryModelStorage getUserQueryModelStorage();

    public void setUserQueryModelStorage(UserQueryModelStorage var1);

    public CallResult GetUserRoleData(String var1, String var2, Vector<UserRoleData> var3);

    public CallResult GetUserRoleRes(String var1, String var2);

    public CallResult TestUserRoleDataAction(String var1, String var2);

    public boolean GetUserRoles(Vector<UserRole> var1);

    public CallResult GetUserRoleDEField(String var1, String var2);

    public Enumeration<String> getAllUserObjects();

    public boolean ContainsUserGroup(String var1);

    public Iterator<UserGroup> getAllUserGroups();

    public Iterator<ORGTreeNode> getCurORGTreeNodes() throws Exception;

    public Iterator<ORGTreeNode> getParentORGTreeNodes(String var1) throws Exception;
}

