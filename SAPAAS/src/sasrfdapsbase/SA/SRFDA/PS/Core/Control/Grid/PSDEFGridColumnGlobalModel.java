/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.Control.Grid.IPSDEFGridColumn;
import SA.SRFDA.PS.Core.DEField.PSDEFieldGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEFGridColumn;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFGridColumnGlobalModel
extends PSDEFieldGlobalModelBase<String, PSDEFGridColumn, IPSDEFGridColumn> {
    private static final Log log = LogFactory.getLog(PSDEFGridColumnGlobalModel.class);

    @Override
    protected PSDEFGridColumn GetObject(String strPSDEFGridColumnId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u5c5e\u6027\u8868\u683c\u5217\u914d\u7f6e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEFGridColumnId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEFGridColumn OnCreateModelHelper(PSDEFGridColumn vt) throws Exception {
        throw new Exception("");
    }

    @Override
    protected Boolean TestObjectRenew(PSDEFGridColumn obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        Vector<PSDEFGridColumn> psDEFGridColumnList = new Vector<PSDEFGridColumn>();
        CallResult callResult = this.iPSModelHelper.getPSDEFGridColumns(this.getPSDEField().getId(), psDEFGridColumnList);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5c5e\u6027\u8868\u683c\u5217\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        for (PSDEFGridColumn psDEFGridColumn : psDEFGridColumnList) {
            this.setModel(psDEFGridColumn.getPSDEFGRIDCOLID(), psDEFGridColumn, null);
            if (StringHelper.Compare((String)psDEFGridColumn.getGCMODE(), (String)"DEFAULT", (boolean)true) != 0) continue;
            this.setModel(psDEFGridColumn.getGCMODE(), psDEFGridColumn, null);
        }
    }

    @Override
    protected String getObjectId(PSDEFGridColumn vt) {
        return vt.getPSDEFGRIDCOLID();
    }
}

