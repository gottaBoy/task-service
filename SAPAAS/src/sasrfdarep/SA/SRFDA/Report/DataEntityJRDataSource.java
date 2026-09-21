/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  net.sf.jasperreports.engine.JRDataSource
 *  net.sf.jasperreports.engine.JRException
 *  net.sf.jasperreports.engine.JRField
 */
package SA.SRFDA.Report;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Vector;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class DataEntityJRDataSource
implements JRDataSource {
    private Vector<BaseDataEntity> dataEntities = null;
    private int nCurIndex = -1;
    private int nColumnCount = -1;
    private int nMaxRowCount = -1;

    public DataEntityJRDataSource(Vector<BaseDataEntity> dataEntities) {
        this.dataEntities = dataEntities;
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
                if (this.getColumnCount() <= 0) return this.dataEntities.get(this.nCurIndex).GetParamValue(arg0.getName());
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
                    int nRowCount = this.dataEntities.size() / this.getColumnCount();
                    if (this.dataEntities.size() % this.getColumnCount() != 0) {
                        ++nRowCount;
                    }
                    nRealIndex = nColumnIndex * nRowCount + this.nCurIndex;
                }
                if (nRealIndex < this.dataEntities.size()) break block7;
                return null;
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return this.dataEntities.get(nRealIndex).GetParamValue(strFieldName);
    }

    public boolean next() throws JRException {
        if (this.dataEntities == null) {
            return false;
        }
        ++this.nCurIndex;
        if (this.getColumnCount() > 0) {
            if (this.getMaxRowCount() > 0) {
                if (this.nCurIndex >= this.dataEntities.size()) {
                    return false;
                }
                return this.nCurIndex < this.getMaxRowCount();
            }
            int nRowCount = this.dataEntities.size() / this.getColumnCount();
            if (this.dataEntities.size() % this.getColumnCount() != 0) {
                ++nRowCount;
            }
            return this.nCurIndex < nRowCount;
        }
        return this.nCurIndex < this.dataEntities.size();
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

