/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.jasperreports.engine.JRDataSource
 *  net.sf.jasperreports.engine.JRException
 *  net.sf.jasperreports.engine.JRField
 */
package net.ibizsys.paas.report.jr;

import java.util.ArrayList;
import net.ibizsys.paas.entity.IEntity;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class EntitiesJRDataSource
implements JRDataSource {
    private ArrayList<IEntity> entityList = null;
    private int nCurIndex = -1;
    private int nColumnCount = -1;
    private int nMaxRowCount = -1;

    public EntitiesJRDataSource(ArrayList<IEntity> entityList) {
        this.entityList = entityList;
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
                if (this.getColumnCount() <= 0) return this.entityList.get(this.nCurIndex).get(arg0.getName());
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
                    int nRowCount = this.entityList.size() / this.getColumnCount();
                    if (this.entityList.size() % this.getColumnCount() != 0) {
                        ++nRowCount;
                    }
                    nRealIndex = nColumnIndex * nRowCount + this.nCurIndex;
                }
                if (nRealIndex < this.entityList.size()) break block7;
                return null;
            }
            catch (Exception e) {
                throw new JRException((Throwable)e);
            }
        }
        return this.entityList.get(nRealIndex).get(strFieldName);
    }

    public boolean next() throws JRException {
        if (this.entityList == null) {
            return false;
        }
        ++this.nCurIndex;
        if (this.getColumnCount() > 0) {
            if (this.getMaxRowCount() > 0) {
                if (this.nCurIndex >= this.entityList.size()) {
                    return false;
                }
                return this.nCurIndex < this.getMaxRowCount();
            }
            int nRowCount = this.entityList.size() / this.getColumnCount();
            if (this.entityList.size() % this.getColumnCount() != 0) {
                ++nRowCount;
            }
            return this.nCurIndex < nRowCount;
        }
        return this.nCurIndex < this.entityList.size();
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

