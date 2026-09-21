/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseColumn;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseConstraints;
import SA.SRFDA.PS.Core.Database.Liquibase.PSLiquibaseColumnAttributesImpl;
import SA.SRFDA.PS.Core.Database.Liquibase.PSLiquibaseConstraintsImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

@PSModelIgnoreMeta
public class PSLiquibaseColumnImpl
extends PSLiquibaseColumnAttributesImpl
implements IPSLiquibaseColumn {
    private static final Log log = LogFactory.getLog(PSLiquibaseColumnImpl.class);
    private IPSLiquibaseConstraints iPSLiquibaseConstraints = null;

    @Override
    protected void onInit() throws Exception {
        if (this.getXmlElement().getChildNodes() != null) {
            int i = 0;
            while (i < this.getXmlElement().getChildNodes().getLength()) {
                Node node = this.getXmlElement().getChildNodes().item(i);
                if (node instanceof Element && node.getNodeName().equals("constraints")) {
                    this.setPSLiquibaseConstraints(this.getPSLiquibaseConstraints("constraints", (Element)node));
                }
                ++i;
            }
        }
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSLIQUIBASECOLUMN$" + this.getPSXmlNodeOwner().getModelType();
    }

    @Override
    @PSModelRTMeta(description="\u7ea6\u675f")
    public IPSLiquibaseConstraints getPSLiquibaseConstraints() {
        return this.iPSLiquibaseConstraints;
    }

    protected void setPSLiquibaseConstraints(IPSLiquibaseConstraints iPSLiquibaseConstraints) {
        this.iPSLiquibaseConstraints = iPSLiquibaseConstraints;
    }

    protected IPSLiquibaseConstraints getPSLiquibaseConstraints(String strName, Element xmlElement) throws Exception {
        PSLiquibaseConstraintsImpl psLiquibaseConstraintsImpl = new PSLiquibaseConstraintsImpl();
        psLiquibaseConstraintsImpl.init(this.getDAGlobalHelper(), this, strName, xmlElement);
        return psLiquibaseConstraintsImpl;
    }
}

