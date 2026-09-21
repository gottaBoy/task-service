/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 */
package SA.SRFDA.PS.Core.Util.CLI;

import SA.SRFDA.PS.Core.Util.CLI.IPSStudioCLIHelper;
import SA.SRFDA.PS.Core.Util.CLI.PSDevSlnCLIHelper;
import SA.SRFDA.PS.Core.Util.CLI.PSDevSysCLIHelper;
import SA.SRFDA.PS.Core.Util.CLI.PSDevTemplCLIHelper;
import SA.SRFDA.PS.Data.PSTaskServerCmd;
import SA.SRFramework.Utility.StringHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.JsonNodeHelper;

public class PSStudioCLIUtils {
    private static PSStudioCLIUtils instance = null;
    private Map<String, IPSStudioCLIHelper> dcPSStudioCLIHelperMap = new HashMap<String, IPSStudioCLIHelper>();
    private Map<String, IPSStudioCLIHelper> slnPSStudioCLIHelperMap = new HashMap<String, IPSStudioCLIHelper>();
    private Map<String, IPSStudioCLIHelper> sysPSStudioCLIHelperMap = new HashMap<String, IPSStudioCLIHelper>();
    private Map<String, IPSStudioCLIHelper> templPSStudioCLIHelperMap = new HashMap<String, IPSStudioCLIHelper>();

    public static PSStudioCLIUtils getInstance() {
        if (instance == null) {
            instance = new PSStudioCLIUtils();
        }
        return instance;
    }

    public static void setInstance(PSStudioCLIUtils instance) {
        PSStudioCLIUtils.instance = instance;
    }

    public PSStudioCLIUtils() {
        this.registerDefault();
    }

    protected void registerDefault() {
        this.registerPSStudioCLIHelper(new PSDevSysCLIHelper());
        this.registerPSStudioCLIHelper(new PSDevSlnCLIHelper());
        this.registerPSStudioCLIHelper(new PSDevTemplCLIHelper());
    }

    public void registerPSStudioCLIHelper(IPSStudioCLIHelper iPSStudioCLIHelper) {
        String strCmd;
        int n;
        int n2;
        String[] stringArray;
        String[] cmds = iPSStudioCLIHelper.getSupportedDCCmds();
        if (cmds != null) {
            stringArray = cmds;
            n2 = cmds.length;
            n = 0;
            while (n < n2) {
                strCmd = stringArray[n];
                this.dcPSStudioCLIHelperMap.put(strCmd, iPSStudioCLIHelper);
                ++n;
            }
        }
        if ((cmds = iPSStudioCLIHelper.getSupportedSlnCmds()) != null) {
            stringArray = cmds;
            n2 = cmds.length;
            n = 0;
            while (n < n2) {
                strCmd = stringArray[n];
                this.slnPSStudioCLIHelperMap.put(strCmd, iPSStudioCLIHelper);
                ++n;
            }
        }
        if ((cmds = iPSStudioCLIHelper.getSupportedSysCmds()) != null) {
            stringArray = cmds;
            n2 = cmds.length;
            n = 0;
            while (n < n2) {
                strCmd = stringArray[n];
                this.sysPSStudioCLIHelperMap.put(strCmd, iPSStudioCLIHelper);
                ++n;
            }
        }
        if ((cmds = iPSStudioCLIHelper.getSupportedTemplCmds()) != null) {
            stringArray = cmds;
            n2 = cmds.length;
            n = 0;
            while (n < n2) {
                strCmd = stringArray[n];
                this.templPSStudioCLIHelperMap.put(strCmd, iPSStudioCLIHelper);
                ++n;
            }
        }
    }

    public void executeCmd(PSTaskServerCmd psTaskServerCmd) throws Exception {
        String strTag = psTaskServerCmd.getPSTSCMDNAME();
        IPSStudioCLIHelper iPSStudioCLIHelper = this.dcPSStudioCLIHelperMap.get(strTag.toLowerCase());
        if (iPSStudioCLIHelper == null) {
            iPSStudioCLIHelper = this.slnPSStudioCLIHelperMap.get(strTag.toLowerCase());
        }
        if (iPSStudioCLIHelper == null) {
            iPSStudioCLIHelper = this.sysPSStudioCLIHelperMap.get(strTag.toLowerCase());
        }
        if (iPSStudioCLIHelper == null) {
            iPSStudioCLIHelper = this.templPSStudioCLIHelperMap.get(strTag.toLowerCase());
        }
        if (iPSStudioCLIHelper == null) {
            throw new Exception(String.format("\u547d\u4ee4[%1$s]\u4e0d\u88ab\u652f\u6301", strTag));
        }
        this.onExecute(strTag, iPSStudioCLIHelper, psTaskServerCmd);
    }

    public void executeDCCmd(PSTaskServerCmd psTaskServerCmd) throws Exception {
        String strTag = psTaskServerCmd.getPSTSCMDNAME();
        IPSStudioCLIHelper iPSStudioCLIHelper = this.dcPSStudioCLIHelperMap.get(strTag.toLowerCase());
        if (iPSStudioCLIHelper == null) {
            throw new Exception(String.format("\u547d\u4ee4[%1$s]\u4e0d\u88ab\u652f\u6301", strTag));
        }
        this.onExecute(strTag, iPSStudioCLIHelper, psTaskServerCmd);
    }

    public void executeSlnCmd(PSTaskServerCmd psTaskServerCmd) throws Exception {
        String strTag = psTaskServerCmd.getPSTSCMDNAME();
        IPSStudioCLIHelper iPSStudioCLIHelper = this.slnPSStudioCLIHelperMap.get(strTag.toLowerCase());
        if (iPSStudioCLIHelper == null) {
            throw new Exception(String.format("\u547d\u4ee4[%1$s]\u4e0d\u88ab\u652f\u6301", strTag));
        }
        this.onExecute(strTag, iPSStudioCLIHelper, psTaskServerCmd);
    }

    public void executeSysCmd(PSTaskServerCmd psTaskServerCmd) throws Exception {
        String strTag = psTaskServerCmd.getPSTSCMDNAME();
        IPSStudioCLIHelper iPSStudioCLIHelper = this.sysPSStudioCLIHelperMap.get(strTag.toLowerCase());
        if (iPSStudioCLIHelper == null) {
            throw new Exception(String.format("\u547d\u4ee4[%1$s]\u4e0d\u88ab\u652f\u6301", strTag));
        }
        this.onExecute(strTag, iPSStudioCLIHelper, psTaskServerCmd);
    }

    public void executeTemplCmd(PSTaskServerCmd psTaskServerCmd) throws Exception {
        String strTag = psTaskServerCmd.getPSTSCMDNAME();
        IPSStudioCLIHelper iPSStudioCLIHelper = this.templPSStudioCLIHelperMap.get(strTag.toLowerCase());
        if (iPSStudioCLIHelper == null) {
            throw new Exception(String.format("\u547d\u4ee4[%1$s]\u4e0d\u88ab\u652f\u6301", strTag));
        }
        this.onExecute(strTag, iPSStudioCLIHelper, psTaskServerCmd);
    }

    protected void onExecute(String strCmd, IPSStudioCLIHelper iPSStudioCLIHelper, PSTaskServerCmd psTaskServerCmd) throws Exception {
        String strData = psTaskServerCmd.getDATA();
        if (StringHelper.IsNullOrEmpty((String)strData)) {
            strData = "{}";
        }
        JsonNode jsonNode = JsonNodeHelper.fromString((String)strData);
        ArrayList<ObjectNode> list = new ArrayList<ObjectNode>();
        if (jsonNode instanceof ObjectNode) {
            list.add((ObjectNode)jsonNode);
        } else if (jsonNode instanceof ArrayNode) {
            ArrayNode arrayNode = (ArrayNode)jsonNode;
            int i = 0;
            while (i < arrayNode.size()) {
                JsonNode obj = arrayNode.get(i);
                if (!(obj instanceof ObjectNode)) {
                    throw new Exception(String.format("\u547d\u4ee4\u53c2\u6570\u65e0\u6548", new Object[0]));
                }
                list.add((ObjectNode)obj);
                ++i;
            }
        } else {
            throw new Exception(String.format("\u547d\u4ee4\u53c2\u6570\u65e0\u6548", new Object[0]));
        }
        if (list.size() == 0) {
            throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u547d\u4ee4\u53c2\u6570", new Object[0]));
        }
        iPSStudioCLIHelper.execute(strCmd, list, psTaskServerCmd);
    }
}

