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
import SA.SRFDA.Ctrl.Data.PageParamFolder;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.Vector;

public class PageTemplDataCtrl
extends BaseDEDataCtrl {
    @Override
    protected CallResult OnExport(BaseDataEntity baseDataEntity, Vector<XMLNode> list, boolean bFrameOnly) {
        CallResult callResult = super.OnExport(baseDataEntity, list, bFrameOnly);
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }

    protected static void SortPageParamFolders(String strPID, Vector<BaseDataEntity> src, Vector<BaseDataEntity> dst) {
        PageParamFolder pageParamFolder = new PageParamFolder();
        for (BaseDataEntity dataEntity : src) {
            pageParamFolder.Proxy(dataEntity);
            if (StringHelper.Compare((String)strPID, (String)pageParamFolder.getPPAGEPARAMFOLDERID(), (boolean)true) != 0) continue;
            dst.add(dataEntity);
            PageTemplDataCtrl.SortPageParamFolders(pageParamFolder.getPAGEPARAMFOLDERID(), src, dst);
        }
    }
}

