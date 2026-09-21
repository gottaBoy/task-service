/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Pub.PSCodePubSessionBase;
import java.io.File;
import java.io.IOException;

public class PSCodePubSession
extends PSCodePubSessionBase {
    private String strPubRootFolder = null;
    private String strPubRootFolderUpper = null;

    public PSCodePubSession(String strPubRootFolder) {
        File file = new File(strPubRootFolder);
        try {
            this.strPubRootFolder = file.getCanonicalPath();
            this.strPubRootFolderUpper = this.strPubRootFolder.toUpperCase();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getPubRootFolder() {
        return this.strPubRootFolder;
    }

    @Override
    protected String getPubRootFolderUpper() {
        return this.strPubRootFolderUpper;
    }
}

