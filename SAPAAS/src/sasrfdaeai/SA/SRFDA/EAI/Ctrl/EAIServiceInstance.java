/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Ctrl.ISRFEAIDataCtrl;
import SA.SRFramework.Utility.StringHelper;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EAIServiceInstance
implements Runnable {
    protected String strServiceId = "";
    protected String strEAICommand = "";
    protected String strConfigPath = "";
    protected ISRFEAIDataCtrl eaiDataCtrl;

    @Override
    public void run() {
        try {
            String s;
            String strTotalCommand = StringHelper.Format((String)this.strEAICommand, (Object)this.strConfigPath, (Object)(String.valueOf(this.strServiceId.toLowerCase()) + ".xml"));
            Process process = null;
            String[] list = strTotalCommand.split("[ ]");
            process = Runtime.getRuntime().exec(list);
            if (process == null) {
                this.eaiDataCtrl.MarkServiceStop(this.strServiceId);
                return;
            }
            BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            while ((s = output.readLine()) != null) {
                System.out.println("[" + this.strServiceId + "] " + s);
            }
            this.eaiDataCtrl.MarkServiceStop(this.strServiceId);
        }
        catch (Exception ex) {
            this.eaiDataCtrl.MarkServiceStop(this.strServiceId);
            ex.printStackTrace();
        }
    }

    public String getServiceId() {
        return this.strServiceId;
    }

    public void setServiceId(String strServiceId) {
        this.strServiceId = strServiceId;
    }

    public String getEAICommand() {
        return this.strEAICommand;
    }

    public String getConfigPath() {
        return this.strConfigPath;
    }

    public void setEAICommand(String strEAICommand) {
        this.strEAICommand = strEAICommand;
    }

    public void setConfigPath(String strConfigPath) {
        this.strConfigPath = strConfigPath;
    }

    public ISRFEAIDataCtrl getEAIDataCtrl() {
        return this.eaiDataCtrl;
    }

    public void setEAIDataCtrl(ISRFEAIDataCtrl eaiDataCtrl) {
        this.eaiDataCtrl = eaiDataCtrl;
    }
}

