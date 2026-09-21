/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.IIMModelHelper;
import SA.IM.Ctrl.IIMModelStorage;
import SA.IM.Ctrl.IIMObjectHelper;
import SA.IM.Ctrl.IMModelHelperFactory;
import SA.IM.Ctrl.IMModelStorageFactory;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class IMBaseObject
implements IIMObjectHelper {
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

    protected IIMModelHelper getIMModelHelper() throws Exception {
        return IMModelHelperFactory.Create(this.iDAGlobalHelper);
    }

    protected IIMModelStorage getIMModelStorage() throws Exception {
        return IMModelStorageFactory.Create(this.iDAGlobalHelper);
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

