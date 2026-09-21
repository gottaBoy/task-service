/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseChangeSet;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseChangeSets;
import SA.SRFDA.PS.Core.Database.Liquibase.PSLiquibaseChangeSetImpl;
import SA.SRFDA.PS.Core.DynaModel.PSXmlNodesImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import net.ibizsys.paas.util.StringHelper;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

@PSModelIgnoreMeta
public class PSLiquibaseChangeSetsImpl
extends PSXmlNodesImpl<IPSLiquibaseChangeSet>
implements IPSLiquibaseChangeSets {
    @Override
    protected IPSLiquibaseChangeSet getItem(String strName, Node xmlNode) throws Exception {
        if (!(xmlNode instanceof Element)) {
            return null;
        }
        Element xmlElement = (Element)xmlNode;
        if (StringHelper.compare((String)"changeSet", (String)xmlElement.getNodeName(), (boolean)false) != 0) {
            return null;
        }
        return this.getPSLiquibaseChangeSet(strName, xmlElement);
    }

    protected IPSLiquibaseChangeSet getPSLiquibaseChangeSet(String strName, Element xmlElement) throws Exception {
        PSLiquibaseChangeSetImpl psLiquibaseChangeSetImpl = new PSLiquibaseChangeSetImpl();
        psLiquibaseChangeSetImpl.init(this.getDAGlobalHelper(), this, strName, xmlElement);
        return psLiquibaseChangeSetImpl;
    }

    @Override
    protected String getItemNameFormat() {
        return "changeSet%1$s";
    }

    @Override
    public String getModelType() {
        return "PSLIQUIBASECHANGESETS$" + this.getPSXmlNodeOwner().getModelType();
    }
}

