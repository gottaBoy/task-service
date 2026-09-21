/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.WebEx.SRFExFileUploader;
import SA.SRFramework.WebEx.UI.PictureUploaderConfig;

public class SRFExPictureUploader
extends SRFExFileUploader {
    protected PictureUploaderConfig pictureUploaderConfig = null;

    @Override
    protected XMLConfig CreateConfig() {
        return new PictureUploaderConfig();
    }

    public PictureUploaderConfig getPictureUploaderConfig() {
        return this.pictureUploaderConfig;
    }
}

