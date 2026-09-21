/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.DataGridEditItemError;
import java.util.Vector;

public class DataGridEditItemErrors {
    protected Vector<DataGridEditItemError> dataGridEditItemErrors = null;

    public void Register(String strEditItemId, String strName, int nErrorType, String strErrorInfo) {
        if (this.dataGridEditItemErrors == null) {
            this.dataGridEditItemErrors = new Vector();
        }
        DataGridEditItemError dataGridEditItemError = new DataGridEditItemError();
        dataGridEditItemError.setName(strName);
        dataGridEditItemError.setErrorType(nErrorType);
        dataGridEditItemError.setErrorInfo(strErrorInfo);
        this.dataGridEditItemErrors.add(dataGridEditItemError);
    }

    public DataGridEditItemError FindDGEditItemError(String strDGEditItemId) {
        return this.FindDGEditItemError(strDGEditItemId, false);
    }

    protected DataGridEditItemError FindDGEditItemError(String strDGEditItemId, boolean bNew) {
        if (this.dataGridEditItemErrors != null) {
            int nCount = this.dataGridEditItemErrors.size();
            int i = 0;
            while (i < nCount) {
                DataGridEditItemError dataGridEditItemError = this.dataGridEditItemErrors.get(i);
                if (StringHelper.Compare((String)strDGEditItemId, (String)dataGridEditItemError.getDGEditItemId(), (boolean)true) == 0) {
                    return dataGridEditItemError;
                }
                ++i;
            }
        }
        if (!bNew) {
            return null;
        }
        DataGridEditItemError dataGridEditItemError = new DataGridEditItemError();
        dataGridEditItemError.setDGEditItemId(strDGEditItemId);
        return dataGridEditItemError;
    }

    public void Unregister(String strFormItemId) {
        if (this.dataGridEditItemErrors == null) {
            return;
        }
        int nCount = this.dataGridEditItemErrors.size();
        int i = 0;
        while (i < nCount) {
            DataGridEditItemError dataGridEditItemError = this.dataGridEditItemErrors.get(i);
            if (StringHelper.Compare((String)strFormItemId, (String)dataGridEditItemError.getDGEditItemId(), (boolean)true) == 0) {
                this.dataGridEditItemErrors.remove(i);
                return;
            }
            ++i;
        }
    }

    public void Reset() {
        if (this.dataGridEditItemErrors == null) {
            return;
        }
        this.dataGridEditItemErrors.clear();
    }

    public void FillJSONs(Vector items) {
        if (this.dataGridEditItemErrors == null) {
            return;
        }
        int nCount = this.dataGridEditItemErrors.size();
        int i = 0;
        while (i < nCount) {
            DataGridEditItemError dataGridEditItemError = this.dataGridEditItemErrors.get(i);
            dataGridEditItemError.FillJSONs(items);
            ++i;
        }
    }

    public String getTotalErrorMessage() {
        String strError = "";
        if (this.dataGridEditItemErrors == null) {
            return strError;
        }
        int nCount = this.dataGridEditItemErrors.size();
        int i = 0;
        while (i < nCount) {
            DataGridEditItemError dataGridEditItemError = this.dataGridEditItemErrors.get(i);
            if (StringHelper.Length((String)strError) > 0) {
                strError = String.valueOf(strError) + "\r\n";
            }
            strError = String.valueOf(strError) + StringHelper.Format((String)"\u9519\u8bef[%1$s]: %2$s", (Object)(i + 1), (Object)dataGridEditItemError.getErrorInfo());
            ++i;
        }
        return strError;
    }
}

