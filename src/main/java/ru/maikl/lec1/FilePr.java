package ru.maikl.lec1;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilePr {

    List<Path> processInParallel(List<String> fileNames, final Path basePath) {
        return fileNames.parallelStream()
                .map(basePath::resolve)
                .filter(Files::exists)
                .map(Path::normalize)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String fileName = "file.txt";
        File file = new File(fileName);
        try {
            file.createNewFile();
            System.out.println("File created");
        } catch (IOException e) {
            System.out.println("File creation failed");
        }
        System.out.println(file.exists());
        System.out.println(file.toURI());
        System.out.println(file.toURI().getPath());
        System.out.println(file.toPath().toUri());

//        File parentFile = file.getParentFile();
//        System.out.println(parentFile.exists());

//        if (!file.delete()) {
//            System.out.println("Error deleting file");
//        }

        String fileNamePath = "D:/040125/gitTest/georgK2022/filePath.txt";
        String systemDependentPath = fileNamePath.replace('/', File.separatorChar);
        System.out.println(systemDependentPath);
        Path path = Paths.get(fileNamePath);
//        try {
//            Files.createFile(path);
//        } catch (FileAlreadyExistsException e) {
//            System.out.println("File already exists");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println(path.getParent());
        System.out.println(path.getRoot());

        try (OutputStream out = Files.newOutputStream(path, StandardOpenOption.CREATE_NEW)) {
            System.out.println("File created");
        } catch (FileAlreadyExistsException e) {
            System.out.println("File already exists");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        Path tempPath = Paths.get("prefix", ".tmp");
//        try {
//            Files.move(tempPath, path, StandardCopyOption.ATOMIC_MOVE);
//        } catch (FileAlreadyExistsException e) {
//            try {
//                Files.delete(tempPath);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        tempPath.getFileName();

//        List<Path> paths = IntStream.range(0,10)
//                .parallel()
//                .mapToObj(i -> Path.of("file_" + i + ".txt"))
//                .toList();
//
//        List<String> fileNames = List.of("a.txt", "b.txt", "c.txt");
//        Path basePath = Paths.get("D:/040125/gitTest/georgK2022/");
//        Path basePath1 = Path.of("D:/040125/gitTest/georgK2022/");
//        Path basePath2 = Path.of(URI.create("home/abc/123"));
//        Path basePath3 = Path.of(URI.create("file:///D:/040125/gitTest/georgK2022/file.txt"));


//        List<Path> paths1 = new FilePr().processInParallel(fileNames, basePath);


        FileSystem fs = FileSystems.getDefault();

        System.out.println("Разделитель: " + fs.getSeparator()); // "\" или "/"
        System.out.println("Корневые директории:");
        for (Path root : fs.getRootDirectories()) {
            System.out.println("  - " + root);
        }

        System.out.println("Хранилища:");
        for (FileStore store : fs.getFileStores()) {
            System.out.println("  - " + store.name() + " (" + store.type() + ")");
        }

        System.out.println("Только для чтения? " + fs.isReadOnly());

//        URL url = new URL("http://example.com/resource");
//        InputStream is = url.openStream();

        String name = "Анна";
        int age = 30;

        System.out.printf("Имя: %s, Возраст: %d лет%n", name, age);


    }
}
