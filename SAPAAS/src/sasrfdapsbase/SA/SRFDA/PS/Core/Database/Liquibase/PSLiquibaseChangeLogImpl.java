/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseChangeLog;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseChangeSets;
import SA.SRFDA.PS.Core.Database.Liquibase.PSLiquibaseChangeSetsImpl;
import SA.SRFDA.PS.Core.Database.Liquibase.PSLiquibaseObjectImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Element;

@PSModelIgnoreMeta
public class PSLiquibaseChangeLogImpl
extends PSLiquibaseObjectImpl
implements IPSLiquibaseChangeLog {
    private static final Log log = LogFactory.getLog(PSLiquibaseChangeLogImpl.class);
    private IPSLiquibaseChangeSets iPSLiquibaseChangeSets = null;

    @Override
    protected void onInit() throws Exception {
        if (this.getXmlElement() != null) {
            this.setPSLiquibaseChangeSets(this.getPSLiquibaseChangeSets("changeSets", this.getXmlElement()));
        }
        super.onInit();
    }

    protected IPSLiquibaseChangeSets getPSLiquibaseChangeSets(String strName, Element xmlElement) throws Exception {
        PSLiquibaseChangeSetsImpl psLiquibaseChangeSetsImpl = new PSLiquibaseChangeSetsImpl();
        psLiquibaseChangeSetsImpl.init(this.getDAGlobalHelper(), this, strName, xmlElement);
        return psLiquibaseChangeSetsImpl;
    }

    @Override
    @PSModelRTMeta(description="\u53d8\u66f4\u96c6\u96c6\u5408")
    public IPSLiquibaseChangeSets getPSLiquibaseChangeSets() {
        return this.iPSLiquibaseChangeSets;
    }

    protected void setPSLiquibaseChangeSets(IPSLiquibaseChangeSets iPSLiquibaseChangeSets) {
        this.iPSLiquibaseChangeSets = iPSLiquibaseChangeSets;
    }

    @Override
    public String getModelType() {
        return "PSLIQUIBASECHANGELOG$" + this.getPSXmlNodeOwner().getModelType();
    }

    @Override
    public String getModelId() {
        return this.getPSXmlNodeOwner().getModelId();
    }
}

