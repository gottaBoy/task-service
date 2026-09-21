/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.ITMModelHelper;
import SA.TM.Ctrl.ITMModelStorage;
import SA.TM.Ctrl.TMModelHelperFactory;
import SA.TM.Ctrl.TMModelStorageFactory;

public abstract class BaseTMObject {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected String strId = "";
    protected String strName = "";
    protected String strDBStorage = "";

    public String getId() {
        return this.strId;
    }

    public String getName() {
        return this.strName;
    }

    protected void setId(String strId) {
        this.strId = strId;
    }

    protected void setName(String strName) {
        this.strName = strName;
    }

    protected String getDBStorage() {
        return this.strDBStorage;
    }

    protected ITMModelHelper getTMModelHelper() throws Exception {
        return TMModelHelperFactory.Create(this.iDAGlobalHelper);
    }

    protected ITMModelStorage getTMModelStorage() throws Exception {
        return TMModelStorageFactory.Create(this.iDAGlobalHelper);
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

