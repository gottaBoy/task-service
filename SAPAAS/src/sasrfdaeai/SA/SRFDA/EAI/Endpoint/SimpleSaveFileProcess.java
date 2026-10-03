package SA.SRFDA.EAI.Endpoint;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.LinkOption;
import java.nio.file.StandardOpenOption;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class SimpleSaveFileProcess extends BaseProcessEndpoint implements Callable {
    public Object onCall(MuleEventContext event) throws Exception {
        String directory = EndpointRuntime.setting(event, "DIRECTORY");
        String filename = EndpointRuntime.setting(event, "FILENAME");
        if (filename == null) {
            filename = EndpointRuntime.setting(event, "MULE_ORIGINAL_FILENAME");
        }
        if (directory == null || directory.length() == 0 || filename == null
                || filename.length() == 0 || !new File(filename).getName().equals(filename)
                || ".".equals(filename) || "..".equals(filename)) {
            throw new IllegalArgumentException("DIRECTORY and a plain FILENAME are required");
        }
        Object payload = EndpointRuntime.payload(event);
        if (!(payload instanceof byte[]) && !(payload instanceof File)
                && !(payload instanceof InputStream)) {
            throw new IllegalArgumentException("File payload must be bytes, a File or an InputStream");
        }
        Path destination = new File(directory, filename).toPath();
        Files.createDirectories(destination.getParent());
        if (payload instanceof byte[]) {
            OutputStream output = Files.newOutputStream(destination, StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE,
                    LinkOption.NOFOLLOW_LINKS);
            try {
                output.write((byte[]) payload);
            } finally {
                output.close();
            }
        } else {
            InputStream input = payload instanceof File
                    ? new FileInputStream((File) payload) : (InputStream) payload;
            try {
                OutputStream output = Files.newOutputStream(destination, StandardOpenOption.CREATE,
                        StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE,
                        LinkOption.NOFOLLOW_LINKS);
                try {
                    byte[] buffer = new byte[8192];
                    int size;
                    while ((size = input.read(buffer)) != -1) {
                        output.write(buffer, 0, size);
                    }
                } finally {
                    output.close();
                }
            } finally {
                input.close();
            }
        }
        return payload;
    }
}
