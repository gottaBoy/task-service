/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSXmlNodeOwner;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import org.w3c.dom.Node;

@PSModelPFIgnoreMeta
public interface IPSXmlNode
extends IPSXmlNodeOwner {
    public IPSXmlNodeOwner getPSXmlNodeOwner();

    public Node getXmlNode();

    public String getNodeName();

    public String getNodeValue();
}

