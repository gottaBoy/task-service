/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.UI.BaseConfigStorageFactory
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.Web.UI;

import SA.SRFDA.Web.UI.BaseConfigStorageFactory;
import SA.SRFDA.Web.UI.DataFilterConfigStorage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class DataFilterConfigStorageFactory
extends BaseConfigStorageFactory<DataFilterConfigStorage> {
    private static DataFilterConfigStorageFactory dataFilterConfigStorageFactory = new DataFilterConfigStorageFactory();

    public static DataFilterConfigStorageFactory getCurrent() {
        return dataFilterConfigStorageFactory;
    }

    protected DataFilterConfigStorage CreateConfigStorage(ISRFDAGlobalHelper iGlobalHelper) throws Exception {
        DataFilterConfigStorage dataFilterConfigStorage = new DataFilterConfigStorage();
        dataFilterConfigStorage.setConfigPaths(this.GetConfigFolders(iGlobalHelper));
        return dataFilterConfigStorage;
    }
}

