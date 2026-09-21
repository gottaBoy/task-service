/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.ND.Ctrl.INDModelHelper;
import SA.SRFDA.ND.Ctrl.INDModelStorage;
import SA.SRFDA.ND.Ctrl.INDObjectHelper;
import SA.SRFDA.ND.Ctrl.NDModelHelperFactory;
import SA.SRFDA.ND.Ctrl.NDModelStorageFactory;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class NDBaseObject
implements INDObjectHelper {
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

    protected INDModelHelper getNDModelHelper() throws Exception {
        return NDModelHelperFactory.Create(this.iDAGlobalHelper);
    }

    protected INDModelStorage getNDModelStorage() throws Exception {
        return NDModelStorageFactory.Create(this.iDAGlobalHelper);
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

