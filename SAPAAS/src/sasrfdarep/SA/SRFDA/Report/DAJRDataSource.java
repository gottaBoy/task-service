/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTable
 *  net.sf.jasperreports.engine.JRDataSource
 *  net.sf.jasperreports.engine.JRException
 *  net.sf.jasperreports.engine.JRField
 */
package SA.SRFDA.Report;

import SA.SRFramework.Data.DataTable;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class DAJRDataSource
implements JRDataSource {
    private DataTable dataTable = null;
    private int nCurIndex = -1;
    private int nColumnCount = -1;
    private int nMaxRowCount = -1;

    public DAJRDataSource(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Object getFieldValue(JRField arg0) throws JRException {
        int nRealIndex;
        String strFieldName;
        block7: {
            try {
                int nPos;
                if (this.getColumnCount() <= 0) return this.dataTable.GetRow(this.nCurIndex).Get(arg0.getName());
                int nColumnIndex = 0;
                strFieldName = arg0.getName();
                if (strFieldName.indexOf("_SRF") == 0 && (nPos = (strFieldName = strFieldName.substring(4)).indexOf("_")) != -1) {
                    String strIndex = strFieldName.substring(0, nPos);
                    strFieldName = strFieldName.substring(nPos + 1);
                    nColumnIndex = Integer.parseInt(strIndex);
                    --nColumnIndex;
                }
                nRealIndex = -1;
                if (this.getMaxRowCount() > 0) {
                    nRealIndex = nColumnIndex * this.getMaxRowCount() + this.nCurIndex;
                } else {
                    int nRowCount = this.dataTable.GetRowCount() / this.getColumnCount();
                    if (this.dataTable.GetRowCount() % this.getColumnCount() != 0) {
                        ++nRowCount;
                    }
                    nRealIndex = nColumnIndex * nRowCount + this.nCurIndex;
                }
                if (nRealIndex < this.dataTable.GetRowCount()) break block7;
                return null;
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return this.dataTable.GetRow(nRealIndex).Get(strFieldName);
    }

    public boolean next() throws JRException {
        if (this.dataTable == null) {
            return false;
        }
        ++this.nCurIndex;
        if (this.getColumnCount() > 0) {
            if (this.getMaxRowCount() > 0) {
                if (this.nCurIndex >= this.dataTable.GetRowCount()) {
                    return false;
                }
                return this.nCurIndex < this.getMaxRowCount();
            }
            int nRowCount = this.dataTable.GetRowCount() / this.getColumnCount();
            if (this.dataTable.GetRowCount() % this.getColumnCount() != 0) {
                ++nRowCount;
            }
            return this.nCurIndex < nRowCount;
        }
        return this.nCurIndex < this.dataTable.GetRowCount();
    }

    public int getColumnCount() {
        return this.nColumnCount;
    }

    public int getMaxRowCount() {
        return this.nMaxRowCount;
    }

    public void setColumnCount(int nColumnCount) {
        this.nColumnCount = nColumnCount;
    }

    public void setMaxRowCount(int nMaxRowCount) {
        this.nMaxRowCount = nMaxRowCount;
    }
}

