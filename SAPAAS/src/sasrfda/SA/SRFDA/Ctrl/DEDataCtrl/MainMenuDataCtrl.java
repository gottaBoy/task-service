/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.Func;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.Vector;

public class MainMenuDataCtrl
extends BaseDEDataCtrl {
    @Override
    protected CallResult OnExport(BaseDataEntity baseDataEntity, Vector<XMLNode> list, boolean bFrameOnly) {
        CallResult callResult = super.OnExport(baseDataEntity, list, bFrameOnly);
        if (callResult.IsError()) {
            return callResult;
        }
        XMLNode rootNode = XMLNode.LoadFromXML((String)baseDataEntity.GetParamStringValue("MENUMODEL", ""));
        if (rootNode == null) {
            return callResult;
        }
        if (rootNode.getChildNodes() != null) {
            for (XMLNode mainMenuNode : rootNode.getChildNodes()) {
                callResult = this.ExportMenuItemFunc(mainMenuNode, list, null, bFrameOnly);
                if (!callResult.IsError()) continue;
                return callResult;
            }
        }
        return callResult;
    }

    protected CallResult ExportMenuItemFunc(XMLNode menuItemNode, Vector<XMLNode> list, IDEDataCtrl iFuncDataCtrl, boolean bFrameOnly) {
        CallResult callResult = new CallResult();
        String strFuncId = menuItemNode.GetExtValue("FUNC_ID", "");
        if (!StringHelper.IsNullOrEmpty((String)strFuncId)) {
            Func func = new Func();
            func.setFUNC_ID(strFuncId);
            if (iFuncDataCtrl == null && (iFuncDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrlEx("DE0013", this)) == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0013"));
                return callResult;
            }
            callResult = iFuncDataCtrl.Export(func, list, true, bFrameOnly);
            if (callResult.IsError()) {
                return callResult;
            }
        }
        if (menuItemNode.getChildNodes() == null) {
            return callResult;
        }
        for (XMLNode mainMenuNode : menuItemNode.getChildNodes()) {
            callResult = this.ExportMenuItemFunc(mainMenuNode, list, iFuncDataCtrl, bFrameOnly);
            if (!callResult.IsError()) continue;
            return callResult;
        }
        return callResult;
    }
}

