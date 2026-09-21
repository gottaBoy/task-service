/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.jasperreports.engine.JRDataSource
 *  net.sf.jasperreports.engine.JRException
 *  net.sf.jasperreports.engine.JRField
 */
package net.ibizsys.paas.report.jr;

import net.ibizsys.paas.db.IDataTable;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class DataTableJRDataSource
implements JRDataSource {
    private IDataTable dataTable = null;
    private int nCurIndex = -1;
    private int nColumnCount = -1;
    private int nMaxRowCount = -1;
    private int nRowIndex = -1;
    private boolean bRowCacheMode = false;

    public DataTableJRDataSource(IDataTable dataTable) {
        this.dataTable = dataTable;
        this.bRowCacheMode = this.dataTable.getCachedRowCount() != -1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object getFieldValue(JRField arg0) throws JRException {
        try {
            int nPos;
            if (this.bRowCacheMode) {
                int nPos2;
                if (this.getColumnCount() <= 0) {
                    return this.dataTable.getCachedRow(this.nCurIndex).get(arg0.getName());
                }
                int nColumnIndex = 0;
                String strFieldName = arg0.getName();
                if (strFieldName.indexOf("_SRF") == 0 && (nPos2 = (strFieldName = strFieldName.substring(4)).indexOf("_")) != -1) {
                    String strIndex = strFieldName.substring(0, nPos2);
                    strFieldName = strFieldName.substring(nPos2 + 1);
                    nColumnIndex = Integer.parseInt(strIndex);
                    --nColumnIndex;
                }
                int nRealIndex = -1;
                if (this.getMaxRowCount() > 0) {
                    nRealIndex = nColumnIndex * this.getMaxRowCount() + this.nCurIndex;
                } else {
                    int nRowCount = this.dataTable.getCachedRowCount() / this.getColumnCount();
                    if (this.dataTable.getCachedRowCount() % this.getColumnCount() != 0) {
                        ++nRowCount;
                    }
                    nRealIndex = nColumnIndex * nRowCount + this.nCurIndex;
                }
                if (nRealIndex >= this.dataTable.getCachedRowCount()) {
                    return null;
                }
                return this.dataTable.getCachedRow(nRealIndex).get(strFieldName);
            }
            if (this.getColumnCount() <= 0) {
                return this.dataTable.getCachedRow(0).get(arg0.getName());
            }
            int nColumnIndex = 0;
            String strFieldName = arg0.getName();
            if (strFieldName.indexOf("_SRF") == 0 && (nPos = (strFieldName = strFieldName.substring(4)).indexOf("_")) != -1) {
                String strIndex = strFieldName.substring(0, nPos);
                strFieldName = strFieldName.substring(nPos + 1);
                nColumnIndex = Integer.parseInt(strIndex);
                --nColumnIndex;
            }
            if (nColumnIndex >= this.dataTable.getCachedRowCount()) {
                return null;
            }
            return this.dataTable.getCachedRow(nColumnIndex).get(strFieldName);
        }
        catch (Exception e) {
            throw new JRException((Throwable)e);
        }
    }

    public boolean next() throws JRException {
        block14: {
            block10: {
                block11: {
                    block12: {
                        block13: {
                            if (this.dataTable == null) {
                                return false;
                            }
                            try {
                                if (!this.bRowCacheMode) break block10;
                                ++this.nCurIndex;
                                if (this.getColumnCount() <= 0) break block11;
                                if (this.getMaxRowCount() <= 0) break block12;
                                if (this.nCurIndex < this.dataTable.getCachedRowCount()) break block13;
                                return false;
                            }
                            catch (Exception e) {
                                throw new JRException((Throwable)e);
                            }
                        }
                        return this.nCurIndex < this.getMaxRowCount();
                    }
                    int nRowCount = this.dataTable.getCachedRowCount() / this.getColumnCount();
                    if (this.dataTable.getCachedRowCount() % this.getColumnCount() != 0) {
                        ++nRowCount;
                    }
                    return this.nCurIndex < nRowCount;
                }
                return this.nCurIndex < this.dataTable.getCachedRowCount();
            }
            ++this.nRowIndex;
            if (this.getMaxRowCount() <= 0 || this.nRowIndex < this.getMaxRowCount()) break block14;
            return false;
        }
        if (this.getColumnCount() > 0) {
            int nRowCacheCount = this.dataTable.cacheRows(this.getColumnCount());
            return nRowCacheCount > 0;
        }
        int nRowCacheCount = this.dataTable.cacheRows(1);
        return nRowCacheCount > 0;
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

