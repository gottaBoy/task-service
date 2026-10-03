/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.ORGTreeNode
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Security.IUserRoleHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.Ctrl.Data.ORGTreeNode;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.ND.Ctrl.INDActionContext;
import SA.SRFDA.ND.Ctrl.INDDiskOwnerTypeHelper;
import SA.SRFDA.ND.Ctrl.INDUserModelStorage;
import SA.SRFDA.ND.Ctrl.NDBaseObject;
import SA.SRFDA.ND.Data.NDDisk;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.ND.Data.NDShare;
import SA.SRFDA.Security.IUserRoleHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class NDUserModelStorage
extends NDBaseObject
implements INDUserModelStorage {
    protected IUserRoleHelper iUserRoleHelper = null;
    protected String strPersonId = "";
    protected HashMap<String, NDDisk> ndDiskMap = new HashMap();
    protected HashMap<String, NDShare> ndShareMap = new HashMap();
    protected HashMap<String, NDFSObject> ndFSObjectMap = new HashMap();
    protected String strORGTreeId = null;
    protected ArrayList<NDDisk> deptNDDiskList = null;
    protected HashMap<String, ORGTreeNode> parentORGTreeNodeMap = new HashMap();
    protected HashMap<String, ORGTreeNode> parentORGTreeNodeMap2 = new HashMap();
    protected ArrayList<ORGTreeNode> curORGTreeNodeList = new ArrayList();

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IUserRoleHelper iUserRoleHelper) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iUserRoleHelper = iUserRoleHelper;
        this.strPersonId = this.iUserRoleHelper.getCurUserId();
        if (iUserRoleHelper.isEnableOU()) {
            Iterator curOrgTreeNodes = this.iUserRoleHelper.getCurORGTreeNodes();
            while (curOrgTreeNodes.hasNext()) {
                ORGTreeNode orgTreeNode = (ORGTreeNode)curOrgTreeNodes.next();
                if (StringHelper.Compare((String)orgTreeNode.getORGTREEID(), (String)this.getNDORGTreeId(), (boolean)false) != 0) continue;
                this.curORGTreeNodeList.add(orgTreeNode);
                Iterator parentOrgTreeNodes = this.iUserRoleHelper.getParentORGTreeNodes(orgTreeNode.getORGTREENODEID());
                while (parentOrgTreeNodes.hasNext()) {
                    ORGTreeNode parentORGTreeNode = (ORGTreeNode)parentOrgTreeNodes.next();
                    if (StringHelper.Compare((String)parentORGTreeNode.getORGTREENODEID(), (String)orgTreeNode.getPORGTREENODEID(), (boolean)false) == 0) {
                        this.parentORGTreeNodeMap2.put(parentORGTreeNode.getORGTREENODEID(), parentORGTreeNode);
                        continue;
                    }
                    this.parentORGTreeNodeMap2.put(parentORGTreeNode.getORGTREENODEID(), parentORGTreeNode);
                    this.parentORGTreeNodeMap.put(parentORGTreeNode.getORGTREENODEID(), parentORGTreeNode);
                }
            }
        }
        this.OnInit();
    }

    @Override
    public NDDisk FindNDDisk(boolean bReset) throws Exception {
        NDDisk ndDisk = null;
        String strKeyId = StringHelper.Format((String)"%1$s_%2$s", (Object)"PERSON", (Object)this.strPersonId);
        if (!bReset && (ndDisk = this.ndDiskMap.get(strKeyId)) != null) {
            return ndDisk;
        }
        ndDisk = new NDDisk();
        CallResult callResult = this.getNDModelHelper().GetNDDiskByOwner("PERSON", this.strPersonId, ndDisk);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u627e\u7f51\u76d8[%1$s][%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)"PERSON", (Object)this.strPersonId, (Object)callResult.getErrorInfo()));
        }
        this.ndDiskMap.put(strKeyId, ndDisk);
        return ndDisk;
    }

    @Override
    public NDDisk FindNDDisk(String strNDOwnerTypeId, String strNDOwnerId, boolean bReset) throws Exception {
        NDDisk ndDisk = null;
        String strKeyId = StringHelper.Format((String)"%1$s_%2$s", (Object)strNDOwnerTypeId, (Object)strNDOwnerId);
        if (!bReset && (ndDisk = this.ndDiskMap.get(strKeyId)) != null) {
            return ndDisk;
        }
        ndDisk = new NDDisk();
        CallResult callResult = this.getNDModelHelper().GetNDDiskByOwner(strNDOwnerTypeId, strNDOwnerId, ndDisk);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u627e\u7f51\u76d8[%1$s][%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)strNDOwnerTypeId, (Object)strNDOwnerId, (Object)callResult.getErrorInfo()));
        }
        this.ndDiskMap.put(strKeyId, ndDisk);
        return ndDisk;
    }

    @Override
    public NDDisk FindNDDisk(String strNDDiskId, boolean bReset) throws Exception {
        NDDisk ndDisk = null;
        String strKeyId = StringHelper.Format((String)"%1$s", (Object)strNDDiskId);
        if (!bReset && (ndDisk = this.ndDiskMap.get(strKeyId)) != null) {
            return ndDisk;
        }
        ndDisk = this.getNDModelStorage().FindNDDisk(strNDDiskId);
        this.ndDiskMap.put(strKeyId, ndDisk);
        return ndDisk;
    }

    @Override
    public NDShare FindNDShare(String strNDShareId, boolean bReset) throws Exception {
        NDShare ndShare = null;
        String strKeyId = strNDShareId;
        if (!bReset && (ndShare = this.ndShareMap.get(strKeyId)) != null) {
            return ndShare;
        }
        ndShare = new NDShare();
        CallResult callResult = this.getNDModelHelper().GetNDShare(strNDShareId, ndShare);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u627e\u5171\u4eab\u8d44\u6e90[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strNDShareId, (Object)callResult.getErrorInfo()));
        }
        this.ndShareMap.put(strKeyId, ndShare);
        return ndShare;
    }

    @Override
    public NDFSObject FindNDFSObject(String strRootNDFSObjectId, String strFullPath, boolean bFirstShare, boolean bReset) throws Exception {
        NDFSObject ndFSObject = null;
        if (StringHelper.IsNullOrEmpty((String)strFullPath)) {
            return null;
        }
        String strKeyId = StringHelper.Format((String)"%1$s_%2$s_%3$s", (Object)bFirstShare, (Object)strRootNDFSObjectId, (Object)strFullPath);
        if (!bReset && (ndFSObject = this.ndFSObjectMap.get(strKeyId)) != null) {
            return ndFSObject;
        }
        ndFSObject = this.getNDModelStorage().FindNDFSObject(strRootNDFSObjectId, strFullPath, bFirstShare);
        this.ndFSObjectMap.put(strKeyId, ndFSObject);
        return ndFSObject;
    }

    @Override
    public NDFSObject FindNDFSObject(String strRootNDFSObjectId, String strPNDFSObjectId, String strFullPath, boolean bReset) throws Exception {
        return this.getNDModelStorage().FindNDFSObject(strRootNDFSObjectId, strPNDFSObjectId, strFullPath);
    }

    @Override
    public Iterator<NDDisk> getDeptNDDisks() throws Exception {
        this.OnPrepareDeptNDDisks();
        return this.deptNDDiskList.iterator();
    }

    protected synchronized void OnPrepareDeptNDDisks() throws Exception {
        if (this.deptNDDiskList != null) {
            return;
        }
        this.deptNDDiskList = new ArrayList();
        Vector<ORGTreeNode> orgTreeNodes = new Vector();
        CallResult callResult = this.getDAGlobalHelper().getDAModelHelper().GetORGTreeNodes(this.getNDORGTreeId(), this.iUserRoleHelper.getCurOU().getORGUNITID(), orgTreeNodes);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6OU\u5bf9\u5e94\u7684\u7f51\u76d8\u7ec4\u7ec7\u6811\u8282\u70b9\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (ORGTreeNode orgTreeNode : orgTreeNodes) {
            this.FillDeptNDDiskList(orgTreeNode, this.deptNDDiskList);
        }
    }

    protected void FillDeptNDDiskList(ORGTreeNode orgTreeNode, ArrayList<NDDisk> deptNDDiskList) throws Exception {
        String strParentTreeNodeId = orgTreeNode.getPORGTREENODEID();
        if (StringHelper.IsNullOrEmpty((String)strParentTreeNodeId)) {
            return;
        }
        ORGTreeNode pOrgTreeNode = new ORGTreeNode();
        pOrgTreeNode.setORGTREENODEID(strParentTreeNodeId);
        CallResult callResult = this.getDAGlobalHelper().getDAModelHelper().GetORGTreeNode(strParentTreeNodeId, pOrgTreeNode);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7f51\u76d8\u7ec4\u7ec7\u6811\u8282\u70b9[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strParentTreeNodeId, (Object)callResult.getErrorInfo()));
        }
        if (!StringHelper.IsNullOrEmpty((String)pOrgTreeNode.getORGUNITID())) {
            NDDisk ndDisk = new NDDisk();
            callResult = this.getNDModelHelper().GetNDDiskByOwner("DEPT", pOrgTreeNode.getORGUNITID(), ndDisk);
            if (callResult.IsOk()) {
                deptNDDiskList.add(ndDisk);
                return;
            }
        }
        this.FillDeptNDDiskList(pOrgTreeNode, deptNDDiskList);
    }

    @Override
    public void setNDORGTreeId(String strORGTreeId) {
        this.strORGTreeId = strORGTreeId;
    }

    @Override
    public String getNDORGTreeId() {
        return this.strORGTreeId;
    }

    @Override
    public Iterator<String> getParentORGTreeNodeIds(boolean bParent) throws Exception {
        if (bParent) {
            return this.parentORGTreeNodeMap2.keySet().iterator();
        }
        return this.parentORGTreeNodeMap.keySet().iterator();
    }

    @Override
    public Iterator<ORGTreeNode> getCurORGTreeNodes() throws Exception {
        return this.curORGTreeNodeList.iterator();
    }

    @Override
    public boolean TestFSOAction(INDActionContext iNDActionContext, NDFSObject ndFSObject, int nAction) throws Exception {
        boolean bRootOnly = false;
        String strRootFSOId = ndFSObject.getROOTNDFSOBJECTID();
        if (StringHelper.IsNullOrEmpty((String)strRootFSOId)) {
            String strFSOType = ndFSObject.getNDFSOBJECTTYPE();
            strRootFSOId = ndFSObject.getNDFSOBJECTID();
            bRootOnly = true;
        }
        if (StringHelper.IsNullOrEmpty((String)strRootFSOId)) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u7f51\u76d8\u6839\u5bf9\u8c61");
        }
        NDDisk ndDisk = new NDDisk();
        ndDisk.setNDDISKID(strRootFSOId);
        IDEDataCtrl ndDiskDataCtrl = iNDActionContext.getDEDataCtrl("ND0011");
        CallResult callResult = ndDiskDataCtrl.Get((BaseDataEntity)ndDisk);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7f51\u76d8\u5bf9\u8c61[%1$s]\uff0c%2$s", (Object)ndDisk.getNDDISKID(), (Object)callResult.getErrorInfo()));
        }
        INDDiskOwnerTypeHelper iNDDiskOwnerTypeHelper = this.getNDModelStorage().FindNDDiskOwnerType(ndDisk.getOWNERTYPE());
        return iNDDiskOwnerTypeHelper.getNDAccHelper().Test(iNDActionContext, ndDisk, bRootOnly ? null : ndFSObject, nAction);
    }
}

