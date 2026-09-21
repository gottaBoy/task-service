/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.Data.IMCatalogServer;
import SA.IM.Ctrl.IIMCatalogServerInstance;
import SA.IM.Ctrl.IIMCatalogServerStub;
import SA.IM.Ctrl.IIMServerInstance;
import SA.IM.Ctrl.IMServerStub;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class IMCatalogServerStub
extends IMServerStub
implements IIMCatalogServerStub {
    protected IIMCatalogServerInstance iIMCatalogServerInstance = null;
    protected IMCatalogServer imCatalogServer = null;

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
        this.imCatalogServer = new IMCatalogServer();
        CallResult callResult = this.getIMModelHelper().GetIMCatalogServer(this.getServerId(), this.imCatalogServer);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u76ee\u5f55\u670d\u52a1\u5668\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    @Override
    protected IIMServerInstance getLocalServerInstance() throws Exception {
        if (this.iIMCatalogServerInstance != null) {
            return this.iIMCatalogServerInstance;
        }
        Object objCatalogServerInstance = this.getGlobalHelper().GetGlobalValue("SAIMCATALOGSERVERKEY");
        if (objCatalogServerInstance == null) {
            throw new Exception("\u65e0\u6cd5\u4ece\u5168\u5c40\u5b58\u50a8\u4e2d\u83b7\u53d6\u7f16\u76ee\u670d\u52a1\u5668\u5b9e\u4f8b");
        }
        if (!(objCatalogServerInstance instanceof IIMCatalogServerInstance)) {
            throw new Exception("\u65e0\u6cd5\u4ece\u5168\u5c40\u5b58\u50a8\u4e2d\u83b7\u53d6\u7f16\u76ee\u670d\u52a1\u5668\u5b9e\u4f8b\uff0c\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        this.iIMCatalogServerInstance = (IIMCatalogServerInstance)objCatalogServerInstance;
        return this.iIMCatalogServerInstance;
    }
}

