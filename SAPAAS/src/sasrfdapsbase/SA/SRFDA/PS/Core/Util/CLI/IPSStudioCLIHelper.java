/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.Util.CLI;

import SA.SRFDA.PS.Data.PSTaskServerCmd;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;

public interface IPSStudioCLIHelper {
    public void execute(String var1, List<ObjectNode> var2, PSTaskServerCmd var3) throws Exception;

    public String[] getSupportedDCCmds();

    public String[] getSupportedSlnCmds();

    public String[] getSupportedSysCmds();

    public String[] getSupportedTemplCmds();
}

