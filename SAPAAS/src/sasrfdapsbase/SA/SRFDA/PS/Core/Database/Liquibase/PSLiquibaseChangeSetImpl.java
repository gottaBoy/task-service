/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseActions;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseChangeSet;
import SA.SRFDA.PS.Core.Database.Liquibase.PSLiquibaseActionsImpl;
import SA.SRFDA.PS.Core.Database.Liquibase.PSLiquibaseObjectImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Element;

@PSModelIgnoreMeta
public class PSLiquibaseChangeSetImpl
extends PSLiquibaseObjectImpl
implements IPSLiquibaseChangeSet {
    private static final Log log = LogFactory.getLog(PSLiquibaseChangeSetImpl.class);
    private IPSLiquibaseActions iPSLiquibaseActions = null;

    @Override
    protected void onInit() throws Exception {
        if (this.getXmlElement() != null) {
            this.setPSLiquibaseActions(this.getPSLiquibaseActions("actions", this.getXmlElement()));
        }
        super.onInit();
    }

    protected IPSLiquibaseActions getPSLiquibaseActions(String strName, Element xmlElement) throws Exception {
        PSLiquibaseActionsImpl psLiquibaseActionsImpl = new PSLiquibaseActionsImpl();
        psLiquibaseActionsImpl.init(this.getDAGlobalHelper(), this, strName, xmlElement);
        return psLiquibaseActionsImpl;
    }

    @Override
    @PSModelRTMeta(description="\u53d8\u66f4\u64cd\u4f5c\u96c6\u5408")
    public IPSLiquibaseActions getPSLiquibaseActions() {
        return this.iPSLiquibaseActions;
    }

    protected void setPSLiquibaseActions(IPSLiquibaseActions iPSLiquibaseActions) {
        this.iPSLiquibaseActions = iPSLiquibaseActions;
    }

    @Override
    public String getModelType() {
        return "PSLIQUIBASECHANGESET$" + this.getPSXmlNodeOwner().getModelType();
    }
}

