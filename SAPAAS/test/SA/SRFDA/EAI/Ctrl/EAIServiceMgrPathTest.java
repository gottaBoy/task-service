package SA.SRFDA.EAI.Ctrl;

import java.io.File;
import java.nio.file.Files;
import junit.framework.TestCase;

public class EAIServiceMgrPathTest extends TestCase {
    public void testMarkerInConfiguredDirectoryWithoutTrailingSeparator() throws Exception {
        File directory = Files.createTempDirectory("eai-legacy-").toFile();
        EAIServiceMgr manager = new EAIServiceMgr(null);
        manager.setConfigPath(directory.getAbsolutePath());
        File marker = new File(directory, "sample.run");
        try {
            assertFalse(manager.IsServiceStart("Sample"));
            assertTrue(marker.createNewFile());
            assertTrue(manager.IsServiceStart("SAMPLE"));
            assertFalse(manager.StopService("sample").IsError());
            assertFalse(marker.exists());
            assertFalse(manager.IsServiceStart("sample"));
        } finally {
            marker.delete();
            assertTrue(directory.delete());
        }
    }

    public void testExportCreatesDirectoryAndReportsUndeletableMarker() throws Exception {
        File directory = Files.createTempDirectory("eai-legacy-").toFile();
        File config = new File(new File(directory, "config"), "sample.xml");
        File marker = new File(directory, "sample.run");
        EAIServiceMgr manager = new EAIServiceMgr(null);
        manager.setConfigPath(directory.getAbsolutePath());
        try {
            assertTrue(EAIServiceMgr.ExportConfigFile(new StringBuilder("<mule/>"), config.getPath()));
            assertEquals("<mule/>", new String(Files.readAllBytes(config.toPath()), "UTF-8"));
            assertTrue(marker.mkdir());
            File child = new File(marker, "keep");
            assertTrue(child.createNewFile());
            assertTrue(manager.StopService("sample").IsError());
            assertFalse(manager.IsServiceStart("sample"));
            assertTrue(child.delete());
        } finally {
            marker.delete();
            config.delete();
            config.getParentFile().delete();
            assertTrue(directory.delete());
        }
    }
}
