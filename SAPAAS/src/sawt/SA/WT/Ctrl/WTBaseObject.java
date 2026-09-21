/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.WT.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.WT.Ctrl.IWTModelHelper;
import SA.WT.Ctrl.IWTModelStorage;
import SA.WT.Ctrl.IWTObjectHelper;
import SA.WT.Ctrl.WTModelHelperFactory;
import SA.WT.Ctrl.WTModelStorageFactory;

public class WTBaseObject
implements IWTObjectHelper {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    private String strId = "";
    private String strName = "";
    private String strDBStorage = "";
    private int nVersion = 0;

    @Override
    public final String getId() {
        return this.strId;
    }

    @Override
    public final String getName() {
        return this.strName;
    }

    @Override
    public int getVersion() {
        return this.nVersion;
    }

    protected void setId(String strId) {
        this.strId = strId;
    }

    protected void setName(String strName) {
        this.strName = strName;
    }

    protected void setVersion(int nVersion) {
        this.nVersion = nVersion;
    }

    protected String getDBStorage() {
        return this.strDBStorage;
    }

    protected IWTModelHelper getWTModelHelper() throws Exception {
        return WTModelHelperFactory.Create(this.iDAGlobalHelper);
    }

    protected IWTModelStorage getWTModelStorage() throws Exception {
        return WTModelStorageFactory.Create(this.iDAGlobalHelper);
    }

    protected void setDAGlobalHelper(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    protected ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    protected void OnInit() throws Exception {
    }
}

