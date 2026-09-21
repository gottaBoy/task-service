/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.ORGTreeNode
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.ND.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.ORGTreeNode;
import SA.SRFDA.ND.Ctrl.DataGrid.NDDataGridActionHelper;
import SA.SRFDA.ND.Ctrl.INDUserModelStorage;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AllNDShareDataGridActionHelper
extends NDDataGridActionHelper {
    private static final Log log = LogFactory.getLog(AllNDShareDataGridActionHelper.class);

    public AllNDShareDataGridActionHelper() {
        this.bRemoveFlagCondition = false;
        this.bRootFSObjectIdCondition = false;
        this.bPFSObjectIdCondition = false;
        this.bFSObjectTypeCondition = false;
    }

    @Override
    protected void FillDAQueryModelHelperCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        super.FillDAQueryModelHelperCondition(userConditions, daQueryModelHelper);
        String strCondition = this.OnGetDeptPrivilegeCondition(daQueryModelHelper);
        if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
            userConditions.add(strCondition);
        }
    }

    protected String OnGetDeptPrivilegeCondition(BaseDAQueryModelHelper daQueryModelHelper) {
        IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper("NDSHAREID");
        CallResult callResult = daQueryModelHelper.GetDEFieldExp(iDEFHelper);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5c5e\u6027[%1$s]SQL\u522b\u540d\u53d1\u751f\u9519\u8bef", (Object)iDEFHelper.getName()));
            return "1<>1";
        }
        StringBuilderEx sb = new StringBuilderEx();
        try {
            String strListIds = "";
            INDUserModelStorage iNDUserModelStorage = this.getNDUserModelStorage();
            Iterator<ORGTreeNode> curORGTreeNodes = iNDUserModelStorage.getCurORGTreeNodes();
            while (curORGTreeNodes.hasNext()) {
                ORGTreeNode orgTreeNode = curORGTreeNodes.next();
                if (!StringHelper.IsNullOrEmpty((String)strListIds)) {
                    strListIds = String.valueOf(strListIds) + ",";
                }
                strListIds = StringHelper.IsNullOrEmpty((String)orgTreeNode.getPORGTREENODEID()) ? String.valueOf(strListIds) + StringHelper.Format((String)"'%1$s'", (Object)orgTreeNode.getORGTREENODEID()) : String.valueOf(strListIds) + StringHelper.Format((String)"'%1$s','%2$s'", (Object)orgTreeNode.getORGTREENODEID(), (Object)orgTreeNode.getPORGTREENODEID());
            }
            if (StringHelper.IsNullOrEmpty((String)strListIds)) {
                sb.Append("exists(select * from t_srfndprivilege x1 where x1.NDSHAREID = %1$s and 1<>1)", callResult.getUserObject());
            } else {
                sb.Append("exists(select * from t_srfndprivilege x1 where x1.NDSHAREID = %1$s and x1.ORGTREENODEID in (%2$s))", callResult.getUserObject(), (Object)strListIds);
            }
            strListIds = "";
            Iterator<String> parentORGTreeNodeIds = iNDUserModelStorage.getParentORGTreeNodeIds(false);
            while (parentORGTreeNodeIds.hasNext()) {
                String strORGTreeNodeId = parentORGTreeNodeIds.next();
                if (!StringHelper.IsNullOrEmpty((String)strListIds)) {
                    strListIds = String.valueOf(strListIds) + ",";
                }
                strListIds = String.valueOf(strListIds) + StringHelper.Format((String)"'%1$s'", (Object)strORGTreeNodeId);
            }
            if (!StringHelper.IsNullOrEmpty((String)strListIds)) {
                sb.Append("OR exists (select * from t_srfndprivilege x1 where  x1.NDSHAREID = %1$s and ( x1.INCSUBDEPT is not null and x1.INCSUBDEPT = 1 ) and  x1.ORGTREENODEID in (%2$s))", callResult.getUserObject(), (Object)strListIds);
            }
            return sb.toString();
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u5916\u90e8\u5171\u4eab\u8d44\u6e90\u6743\u9650\u6761\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            return "1<>1";
        }
    }
}

