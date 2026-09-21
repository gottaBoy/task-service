/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseColumns;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseCreateTable;
import SA.SRFDA.PS.Core.Database.Liquibase.PSLiquibaseActionImpl;
import SA.SRFDA.PS.Core.Database.Liquibase.PSLiquibaseColumnsImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Element;

@PSModelIgnoreMeta
public class PSLiquibaseCreateTableImpl
extends PSLiquibaseActionImpl
implements IPSLiquibaseCreateTable {
    private static final Log log = LogFactory.getLog(PSLiquibaseCreateTableImpl.class);
    private IPSLiquibaseColumns iPSLiquibaseColumns = null;

    @Override
    protected void onInit() throws Exception {
        if (this.getXmlElement() != null) {
            this.setPSLiquibaseColumns(this.getPSLiquibaseColumns("columns", this.getXmlElement()));
        }
        super.onInit();
    }

    protected IPSLiquibaseColumns getPSLiquibaseColumns(String strName, Element xmlElement) throws Exception {
        PSLiquibaseColumnsImpl psLiquibaseColumnsImpl = new PSLiquibaseColumnsImpl();
        psLiquibaseColumnsImpl.init(this.getDAGlobalHelper(), this, strName, xmlElement);
        return psLiquibaseColumnsImpl;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5217\u96c6\u5408")
    public IPSLiquibaseColumns getPSLiquibaseColumns() {
        return this.iPSLiquibaseColumns;
    }

    protected void setPSLiquibaseColumns(IPSLiquibaseColumns iPSLiquibaseColumns) {
        this.iPSLiquibaseColumns = iPSLiquibaseColumns;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8868\u540d\u79f0")
    public String getTableName() {
        return this.getAttrStringValue("tableName", null);
    }

    @Override
    @PSModelRTMeta(description="\u63cf\u8ff0\u4fe1\u606f")
    public String getRemarks() {
        return this.getAttrStringValue("remarks", null);
    }

    @Override
    public String getModelType() {
        return "PSLIQUIBASECREATETABLE$" + this.getPSXmlNodeOwner().getModelType();
    }
}

