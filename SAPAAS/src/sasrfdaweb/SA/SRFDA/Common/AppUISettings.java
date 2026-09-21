/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.Common;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class AppUISettings {
    private static AppUISettings instance = null;
    private EditView editView = new EditView();
    private GridView gridView = new GridView();

    public static AppUISettings getInstance() {
        return instance;
    }

    public static void Init(ISRFDAGlobalHelper iGlobalHelper) {
        AppUISettings instance = new AppUISettings();
        instance.getEditView().setDefaultPath("");
        AppUISettings.instance = instance;
    }

    public EditView getEditView() {
        return this.editView;
    }

    public GridView getGridView() {
        return this.gridView;
    }

    protected class BaseView {
        protected String strDefaultPath = "";

        protected BaseView() {
        }

        public String getDefaultPath() {
            return this.strDefaultPath;
        }

        protected void setDefaultPath(String strDefaultPath) {
            this.strDefaultPath = strDefaultPath;
        }
    }

    public class EditView
    extends BaseView {
    }

    public class GridView
    extends BaseView {
        protected String strDGActionHelper = "";

        public String getDGActionHelper() {
            return this.strDGActionHelper;
        }

        protected void setDGActionHelper(String strDGActionHelper) {
            this.strDGActionHelper = strDGActionHelper;
        }
    }
}

