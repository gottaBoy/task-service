/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Model;

import SA.SRFDA.Model.DGModelBaseQueryConfig;
import SA.SRFramework.Utility.StringHelper;

public class DGModelMainQueryConfig
extends DGModelBaseQueryConfig {
    public static final String TAG_DGMODELMAINQUERY = "SRFDADGMODELMAINQUERY";
    public static final String TAG_EXCLUDE = "EXCLUDE";
    public static final String TAG_DISTINCT = "DISTINCT";
    protected boolean bExclude = false;
    protected boolean bDistinct = false;
    private ThreadLocal<String> strExtSelect2 = new ThreadLocal();

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DISTINCT, (boolean)true) == 0) {
            this.setDistinct(DGModelMainQueryConfig.GetValue((String)strValue, (boolean)this.isDistinct()));
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public boolean isExclude() {
        return this.bExclude;
    }

    public void setExclude(boolean exclude) {
        this.bExclude = exclude;
    }

    public boolean isDistinct() {
        return this.bDistinct;
    }

    public void setDistinct(boolean bDistinct) {
        this.bDistinct = bDistinct;
    }

    public String getSelectedColumns() {
        return this.strExtSelect2.get();
    }

    public void setSelectedColumns(String strSelectedColumns) {
        this.strExtSelect2.set(strSelectedColumns);
    }

    @Override
    public String getExtSelect() {
        String strCur = this.getSelectedColumns();
        String strOri = super.getExtSelect();
        if (StringHelper.IsNullOrEmpty((String)strCur)) {
            return strOri;
        }
        if (StringHelper.IsNullOrEmpty((String)strOri)) {
            return strCur;
        }
        return StringHelper.Format((String)"%1$s;%2$s", (Object)strCur, (Object)strOri);
    }
}

