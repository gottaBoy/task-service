import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Cross-platform preflight for the recovered SAPAAS source build.
 *
 * This class has no project dependencies so Ant can compile and run it before
 * compiling the recovered source tree.
 */
public final class BuildPreflight {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static final Pattern CONTROL_FLOW = Pattern.compile(
            "\\*\\*[\\t ]*(?:GOTO|goto|if|while|for|switch|break|continue"
                    + "|return|throw|else|do|case|default|try|catch|finally)\\b");
    private static final Pattern LABEL = Pattern.compile("^\\s*lbl-[A-Za-z0-9-]+:");
    private static final Pattern VOID_VARIABLE = Pattern.compile(
            "\\bvoid[\\t ]+[A-Za-z_$][A-Za-z0-9_$]*[\\t ]*[;=]");
    private static final String UNRESOLVED_PROBLEM = "Unresolved compilation problem:";
    private static final String UNRESOLVED_PROBLEMS = "Unresolved compilation problems:";
    private static final String DECOMPILER_STUB = "decompiler-stub";
    private static final int MAX_SOURCE_EXAMPLES = 40;

    private BuildPreflight() {
    }

    public static void main(String[] args) throws Exception {
        if ("--source".equals(args.length > 0 ? args[0] : null) && args.length == 2) {
            verifySource(Paths.get(args[1]));
            return;
        }
        if ("--inventory".equals(args.length > 0 ? args[0] : null) && args.length == 3) {
            writeInventory(Paths.get(args[1]), Paths.get(args[2]));
            return;
        }
        if ("--self-test".equals(args.length > 0 ? args[0] : null) && args.length == 1) {
            selfTest();
            return;
        }
        if ("--dependencies".equals(args.length > 0 ? args[0] : null)
                && args.length == 4) {
            verifyDependencies(
                    Paths.get(args[1]),
                    Paths.get(args[2]),
                    Integer.parseInt(args[3]));
            return;
        }

        System.err.println("Usage:");
        System.err.println("  BuildPreflight --source SOURCE_DIR");
        System.err.println("  BuildPreflight --inventory SOURCE_DIR OUTPUT_FILE");
        System.err.println("  BuildPreflight --self-test");
        System.err.println("  BuildPreflight --dependencies LIB_DIR SHA256SUMS EXPECTED_COUNT");
        System.exit(2);
    }

    private static void verifySource(final Path sourceDir) throws IOException {
        List<SourceMatch> matches = scanSource(sourceDir);
        if (!matches.isEmpty()) {
            Set<Path> matchingFiles = new HashSet<Path>();
            Map<Path, Integer> stubFiles = new java.util.TreeMap<Path, Integer>(PATH_COMPARATOR);
            int stubCount = 0;
            System.err.println("Recovered Java source contains unsupported decompiler syntax or compilation-error stubs.");
            for (SourceMatch match : matches) {
                matchingFiles.add(match.file);
                if (DECOMPILER_STUB.equals(match.type)) {
                    Integer previous = stubFiles.get(match.file);
                    stubFiles.put(match.file, previous == null ? 1 : previous + 1);
                    stubCount++;
                }
            }
            System.err.println("Files: " + matchingFiles.size() + "; matches: " + matches.size());
            System.err.println("Decompiler throw stubs: files=" + stubFiles.size()
                    + "; matches=" + stubCount);
            for (Map.Entry<Path, Integer> entry : stubFiles.entrySet()) {
                System.err.println("  " + entry.getKey() + " (" + entry.getValue() + ")");
            }
            for (int i = 0; i < Math.min(matches.size(), MAX_SOURCE_EXAMPLES); i++) {
                SourceMatch match = matches.get(i);
                System.err.println(match.file + ":" + match.lineNumber + ":" + match.source);
            }
            if (matches.size() > MAX_SOURCE_EXAMPLES) {
                System.err.println("... truncated; inspect " + sourceDir
                        + " for the complete set.");
            }
            System.exit(1);
        }
        System.out.println("Source build preflight passed: scanned "
                + countJavaFiles(sourceDir) + " Java files.");
    }

    private static void writeInventory(Path sourceDir, Path outputFile) throws IOException {
        List<SourceMatch> matches = scanSource(sourceDir);
        Collections.sort(matches, new Comparator<SourceMatch>() {
            @Override
            public int compare(SourceMatch left, SourceMatch right) {
                int byFile = PATH_COMPARATOR.compare(left.file, right.file);
                if (byFile != 0) {
                    return byFile;
                }
                int byType = left.type.compareTo(right.type);
                return byType != 0 ? byType : left.lineNumber - right.lineNumber;
            }
        });
        Path parent = outputFile.toAbsolutePath().getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
        BufferedWriter writer = Files.newBufferedWriter(outputFile, UTF8);
        try {
            writer.write("# Task7 source issue inventory\n\n");
            writer.write("Generated from `SAPAAS/src`.\n\n");
            writer.write("Columns: `file`, `type`, `line`, `source`.\n\n");
            writer.write("```text\n");
            for (SourceMatch match : matches) {
                writer.write("SAPAAS/src/" + sourceDir.relativize(match.file).toString()
                        .replace('\\', '/') + "\t" + match.type + "\t"
                        + match.lineNumber + "\t" + match.source + "\n");
            }
            writer.write("```\n");
        } finally {
            writer.close();
        }
        System.out.println("Wrote " + outputFile + " (" + matches.size() + " matches).");
    }

    private static int countJavaFiles(final Path sourceDir) throws IOException {
        final int[] count = {0};
        Files.walkFileTree(sourceDir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (attrs.isRegularFile() && file.toString().endsWith(".java")) {
                    count[0]++;
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return count[0];
    }

    private static List<SourceMatch> scanSource(final Path sourceDir) throws IOException {
        requireDirectory(sourceDir, "source directory");

        final List<Path> javaFiles = new ArrayList<Path>();
        Files.walkFileTree(sourceDir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (attrs.isRegularFile() && file.toString().endsWith(".java")) {
                    javaFiles.add(file);
                }
                return FileVisitResult.CONTINUE;
            }
        });
        Collections.sort(javaFiles, PATH_COMPARATOR);

        List<SourceMatch> matches = new ArrayList<SourceMatch>();
        for (Path javaFile : javaFiles) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(Files.newInputStream(javaFile), UTF8));
            try {
                int lineNumber = 0;
                String line;
                boolean[] inBlockComment = {false};
                boolean mayContainStub = false;
                while ((line = reader.readLine()) != null) {
                    lineNumber++;
                    if (line.contains("Unresolved compilation problem")) {
                        mayContainStub = true;
                    }
                    String type = classify(maskNonCode(line, inBlockComment));
                    if (type != null) {
                        matches.add(new SourceMatch(javaFile, lineNumber, type, line));
                    }
                }
                if (mayContainStub) {
                    scanDecompilerStubs(javaFile,
                            new String(Files.readAllBytes(javaFile), UTF8), matches);
                }
            } finally {
                reader.close();
            }
        }

        return matches;
    }

    private static void scanDecompilerStubs(
            Path file, String source, List<SourceMatch> matches) {
        int state = 0;
        int throwOffset = -1;
        for (int i = 0; i < source.length();) {
            char c = source.charAt(i);
            char next = i + 1 < source.length() ? source.charAt(i + 1) : '\0';
            if (Character.isWhitespace(c)) {
                i++;
            } else if (c == '/' && next == '/') {
                int end = source.indexOf('\n', i + 2);
                i = end < 0 ? source.length() : end;
            } else if (c == '/' && next == '*') {
                int end = source.indexOf("*/", i + 2);
                i = end < 0 ? source.length() : end + 2;
            } else if (c == '"' || c == '\'') {
                int start = i;
                char quote = c;
                if (c == '"' && source.startsWith("\"\"\"", i)) {
                    int end = source.indexOf("\"\"\"", i + 3);
                    i = end < 0 ? source.length() : end + 3;
                    state = 0;
                    continue;
                }
                i++;
                while (i < source.length()) {
                    if (source.charAt(i) == '\\') {
                        i += 2;
                    } else if (source.charAt(i++) == quote) {
                        break;
                    }
                }
                if (state == 4 && quote == '"'
                        && (source.startsWith(UNRESOLVED_PROBLEM, start + 1)
                            || source.startsWith(UNRESOLVED_PROBLEMS, start + 1))) {
                    int lineStart = source.lastIndexOf('\n', throwOffset - 1) + 1;
                    int lineEnd = source.indexOf('\n', throwOffset);
                    if (lineEnd < 0) {
                        lineEnd = source.length();
                    }
                    String snippet = source.substring(lineStart, lineEnd).trim();
                    if (snippet.length() > 160) {
                        snippet = snippet.substring(0, 160) + "...";
                    }
                    int lineNumber = 1;
                    for (int pos = 0; pos < throwOffset; pos++) {
                        if (source.charAt(pos) == '\n') {
                            lineNumber++;
                        }
                    }
                    matches.add(new SourceMatch(file, lineNumber, DECOMPILER_STUB, snippet));
                }
                state = 0;
            } else if (Character.isJavaIdentifierStart(c)) {
                int start = i++;
                while (i < source.length() && Character.isJavaIdentifierPart(source.charAt(i))) {
                    i++;
                }
                String word = source.substring(start, i);
                if ("throw".equals(word)) {
                    throwOffset = start;
                    state = 1;
                } else if (state == 1 && "new".equals(word)) {
                    state = 2;
                } else if (state == 2 && "Error".equals(word)) {
                    state = 3;
                } else {
                    state = 0;
                }
            } else {
                state = state == 3 && c == '(' ? 4 : 0;
                i++;
            }
        }
    }

    private static String classify(String code) {
        Matcher controlFlow = CONTROL_FLOW.matcher(code);
        if (controlFlow.find()) {
            return controlFlow.group().replaceFirst("^\\*\\*[\\t ]*", "");
        }
        if (LABEL.matcher(code).find()) {
            return "label";
        }
        if (VOID_VARIABLE.matcher(code).find()) {
            return "void-var";
        }
        return null;
    }

    private static String maskNonCode(String line, boolean[] inBlockComment) {
        char[] code = new char[line.length()];
        java.util.Arrays.fill(code, ' ');
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            char next = i + 1 < line.length() ? line.charAt(i + 1) : '\0';
            if (inBlockComment[0]) {
                if (c == '*' && next == '/') {
                    inBlockComment[0] = false;
                    i++;
                }
            } else if (c == '/' && next == '/') {
                break;
            } else if (c == '/' && next == '*') {
                inBlockComment[0] = true;
                i++;
            } else if (c == '"' || c == '\'') {
                char quote = c;
                while (++i < line.length()) {
                    if (line.charAt(i) == '\\') {
                        i++;
                    } else if (line.charAt(i) == quote) {
                        break;
                    }
                }
            } else {
                code[i] = c;
            }
        }
        return new String(code);
    }

    private static void selfTest() {
        boolean[] inBlockComment = {false};
        check(classify(maskNonCode("/** break; */", inBlockComment)) == null, "Javadoc");
        check(classify(maskNonCode("/**", inBlockComment)) == null, "Javadoc start");
        check(classify(maskNonCode(" * ** continue;", inBlockComment)) == null, "Javadoc body");
        check("break".equals(classify(maskNonCode(" */ if (ok) ** break;", inBlockComment))), "Javadoc end");
        check(classify(maskNonCode("writer.write(\"** break; // void entry;\");", inBlockComment)) == null, "string");
        check(classify(maskNonCode("// void entry; ** continue;", inBlockComment)) == null, "line comment");
        check("continue".equals(classify(maskNonCode("if (it.hasNext()) ** continue;", inBlockComment))), "continue");
        check("void-var".equals(classify(maskNonCode("void entry;", inBlockComment))), "void variable");
        check(classify(maskNonCode("void method();", inBlockComment)) == null, "method declaration");
        check("label".equals(classify(maskNonCode("lbl-1010:", inBlockComment))), "label");
        check("GOTO".equals(classify(maskNonCode("** GOTO lbl-1010", inBlockComment))), "GOTO");
        List<SourceMatch> stubs = new ArrayList<SourceMatch>();
        Path fixture = Paths.get("fixture.java");
        scanDecompilerStubs(fixture,
                "// throw new Error(\"Unresolved compilation problem: ignored\");\n"
                + "String sample = \"throw new Error(\\\"Unresolved compilation problem: ignored\\\")\";\n"
                + "/* throw new Error(\"Unresolved compilation problem: ignored\"); */\n"
                + "String message = \"Unresolved compilation problem: harmless\";\n"
                + "throw /* comment */ new Error(\n"
                + "  \"Unresolved compilation problems: real\");\n"
                + "throw new Error(\"Unresolved compilation problem: real\");\n",
                stubs);
        check(stubs.size() == 2, "executable compilation-error stubs");
        check(stubs.get(0).lineNumber == 5 && stubs.get(1).lineNumber == 7,
                "compilation-error stub line numbers");
        List<SourceMatch> clean = new ArrayList<SourceMatch>();
        scanDecompilerStubs(fixture,
                "/* throw new Error(\"Unresolved compilation problem: commented\");\n"
                + "   throw new Error(\"Unresolved compilation problems: commented\"); */\n"
                + "String example = \"say \\\"throw new Error(\\\\\\\"Unresolved compilation problem: sample\\\\\\\")\\\"\";\n"
                + "new Error(\"Unresolved compilation problem: not thrown\");\n"
                + "throw new Error(\"A different problem: Unresolved compilation problem: harmless\");\n",
                clean);
        check(clean.isEmpty(), "comment, string and non-stub fixture");
        System.out.println("Source scanner self-test passed.");
    }

    private static void check(boolean condition, String caseName) {
        if (!condition) {
            throw new AssertionError("Source scanner failed: " + caseName);
        }
    }

    private static final class SourceMatch {
        final Path file;
        final int lineNumber;
        final String type;
        final String source;

        SourceMatch(Path file, int lineNumber, String type, String source) {
            this.file = file;
            this.lineNumber = lineNumber;
            this.type = type;
            this.source = source;
        }
    }

    private static void verifyDependencies(
            Path libDir, Path sumsFile, int expectedCount) throws Exception {
        requireDirectory(libDir, "dependency directory");
        if (!Files.isRegularFile(sumsFile)) {
            throw new IOException("Missing checksum manifest: " + sumsFile);
        }

        List<Path> jars = new ArrayList<Path>();
        DirectoryStream<Path> stream = Files.newDirectoryStream(libDir, "*.jar");
        try {
            for (Path jar : stream) {
                if (Files.isRegularFile(jar)) {
                    jars.add(jar);
                }
            }
        } finally {
            stream.close();
        }
        Collections.sort(jars, PATH_COMPARATOR);

        if (jars.size() != expectedCount) {
            throw new IOException("Expected " + expectedCount
                    + " local JARs, found " + jars.size());
        }

        Map<String, String> expectedHashes = readChecksums(sumsFile);
        if (expectedHashes.size() != expectedCount) {
            throw new IOException("Expected " + expectedCount
                    + " checksum entries, found " + expectedHashes.size());
        }

        Set<String> actualNames = new TreeSet<String>();
        for (Path jar : jars) {
            actualNames.add(jar.getFileName().toString());
        }
        Set<String> manifestNames = new TreeSet<String>(expectedHashes.keySet());
        if (!actualNames.equals(manifestNames)) {
            Set<String> missing = new TreeSet<String>(manifestNames);
            missing.removeAll(actualNames);
            Set<String> unexpected = new TreeSet<String>(actualNames);
            unexpected.removeAll(manifestNames);
            throw new IOException("Checksum manifest does not match local JARs; missing="
                    + missing + ", unexpected=" + unexpected);
        }

        List<String> mismatches = new ArrayList<String>();
        for (Path jar : jars) {
            String name = jar.getFileName().toString();
            String actual = sha256(jar);
            if (!actual.equalsIgnoreCase(expectedHashes.get(name))) {
                mismatches.add(name + " expected=" + expectedHashes.get(name)
                        + " actual=" + actual);
            }
        }
        if (!mismatches.isEmpty()) {
            System.err.println("Dependency checksum verification failed:");
            for (String mismatch : mismatches) {
                System.err.println("  " + mismatch);
            }
            System.exit(1);
        }

        System.out.println("Dependency verification passed: " + jars.size()
                + " JARs, SHA-256 manifest " + sumsFile);
    }

    private static Map<String, String> readChecksums(Path sumsFile) throws IOException {
        Map<String, String> hashes = new HashMap<String, String>();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(Files.newInputStream(sumsFile), UTF8));
        try {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();
                if (line.length() == 0) {
                    continue;
                }
                String[] fields = line.split("\\s+", 2);
                if (fields.length != 2 || !fields[0].matches("[0-9a-fA-F]{64}")) {
                    throw new IOException("Invalid SHA-256 manifest line "
                            + lineNumber + " in " + sumsFile);
                }
                String fileName = fields[1];
                if (fileName.startsWith("*")) {
                    fileName = fileName.substring(1);
                }
                if (fileName.length() == 0 || !fileName.endsWith(".jar")) {
                    throw new IOException("Invalid dependency filename on manifest line "
                            + lineNumber + ": " + fields[1]);
                }
                if (hashes.put(fileName, fields[0].toLowerCase()) != null) {
                    throw new IOException("Duplicate checksum entry for " + fileName);
                }
            }
        } finally {
            reader.close();
        }
        return hashes;
    }

    private static String sha256(Path file) throws IOException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        InputStream input = new BufferedInputStream(Files.newInputStream(file));
        try {
            byte[] buffer = new byte[64 * 1024];
            int read;
            while ((read = input.read(buffer)) != -1) {
                digest.update(buffer, 0, read);
            }
        } finally {
            input.close();
        }

        byte[] bytes = digest.digest();
        StringBuilder result = new StringBuilder(bytes.length * 2);
        for (byte value : bytes) {
            result.append(String.format("%02x", value & 0xff));
        }
        return result.toString();
    }

    private static void requireDirectory(Path path, String label) throws IOException {
        if (!Files.isDirectory(path)) {
            throw new IOException("Missing " + label + ": " + path);
        }
    }

    private static final Comparator<Path> PATH_COMPARATOR = new Comparator<Path>() {
        @Override
        public int compare(Path left, Path right) {
            return left.toString().compareTo(right.toString());
        }
    };
}
