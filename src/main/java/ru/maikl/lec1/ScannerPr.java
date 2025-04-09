package ru.maikl.lec1;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScannerPr {
    public static void main(String[] args) {
        System.out.println("Hello Scanner");
        String fileName = "test.txt";
        File file = new File(fileName);
        System.out.println(file.exists());
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(file.exists());
        System.out.println("-----");

        try {
            Scanner sc = new Scanner(file);
            try {
                while (sc.hasNextLine()) {
                    System.out.println(sc.nextLine());
                }
            } catch (IllegalStateException | NoSuchElementException e) {
                System.out.println("Error opening file " + e.getMessage());
            } finally {
                sc.close();
            }
        } catch (IOException | NullPointerException e) {
            System.out.println("Error opening file " + e.getMessage());
        }

        System.out.println("-----File file-----");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.isAbsolute());
        System.out.println(file.length() + " bytes");
        System.out.println(file.canExecute());
        System.out.println(file.getParent());
        System.out.println("o----File file-----");

        System.out.println("-----File directory-----");
        File fileDir = new File("testDir");
        fileDir.mkdir();
        System.out.println(fileDir.isDirectory());
        System.out.println(fileDir.getAbsolutePath());
        System.out.println(file.getParent());
        System.out.println("o----File directory-----");

        System.out.println("-----File file and directory-----");
        File newFile = new File(fileDir, fileName);
//        File newFileSep = new File(fileDir + File.separator + fileName);
        try {
            boolean fileCreated = newFile.createNewFile();
            if (fileCreated) {
                System.out.println("Файл создан: " + newFile.getAbsolutePath());
            } else {
                System.out.println("Файл уже существует или не может быть создан");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        } catch (SecurityException e) {
            System.out.println("Нет прав на создание файла: " + e.getMessage());
        }
        System.out.println(newFile.getParentFile());

        try {
            System.out.println(newFile.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("o----File file and directory-----");

//        File file1 = new File("C:/test/file.txt");  // Абсолютный путь (Windows)
//        File file2 = new File("data/config.json");  // Относительный путь
//        File file3 = new File("C:/test", "file.txt"); // Эквивалентно new File("C:/test/file.txt")
//        File parentDir = new File("C:/test");
//        File file4 = new File(parentDir, "file.txt"); // Эквивалентно new File("C:/test/file.txt")
//        File file5 = new File("C:" + File.separator + "test" + File.separator + "file.txt");
//        //Относительные пути Отсчитываются от рабочей директории (System.getProperty("user.dir")).
//        Path path = Paths.get("C:/test/file.txt");  // или Path.of() (Java 11+)
        System.out.println(System.getProperty("user.dir"));
        System.out.println(file.toURI());
        System.out.println(file.toPath().toUri());

        String pathsName = "D:/040125/gitTest/georgK2022/testPaths.txt";
        String pathOfName = "D:/040125/gitTest/georgK2022/testPathOf.txt";
        String pathFileSysName = "D:/040125/gitTest/georgK2022/testFileSys.txt";
        Path path = Paths.get(pathsName);
        Path pathOf = Path.of(pathOfName);
        Path pathFileSys = FileSystems.getDefault().getPath(pathFileSysName);

        System.out.println(path);
        System.out.println(pathOf);
        System.out.println(pathFileSys);

        System.out.println(pathFileSys.getNameCount()); // =4 "D:/040125/gitTest/georgK2022/testFileSys.txt"
        System.out.println(pathFileSys.getName(0));
        System.out.println(pathFileSys.getName(1));
        System.out.println(pathFileSys.getName(2));
        System.out.println(pathFileSys.getName(3));
        System.out.println(pathFileSys.startsWith(Paths.get("D:/")));
        System.out.println(pathFileSys.startsWith("D:/"));
        System.out.println(pathFileSys.startsWith("/040125/"));
//        Path normalized = Path.of("/home/./user/../user/docs").normalize();

//        Path path = Path.of("/home/user/docs/letter.txt");
//
//        path.getFileName();    // letter.txt
//        path.getNameCount();   // 3 (user, docs, letter.txt)
//        path.getName(0);       // user
//        path.getParent();      // /home/user/docs
//        path.getRoot();        // /
        System.out.println("-----Path foreach-----");
        for (Path element : pathFileSys) {
            System.out.println(element);
        }

        Path base = Paths.get("D:/040125/gitTest/georgK2022");
        Path full = base.resolve("/src/basefull.txt");
        Path fullP = base.resolve(Paths.get("src", "basefull.txt"));
        System.out.println(full);
        System.out.println(fullP);


//        Files.createFile(Paths.get("newfile.txt"));
//        Files.createDirectory(Paths.get("newdir"));
//        Files.createDirectories(Paths.get("dir/subdir")); // Создаст все недостающие папки
//        Files.delete(path); // Кидает исключение, если файла нет
//        Files.deleteIfExists(path); // Удаляет, только если существует
//        Files.copy(sourcePath, targetPath);
//        Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
//        Files.move(sourcePath, targetPath, StandardCopyOption.ATOMIC_MOVE);
//        boolean exists = Files.exists(path);
//        boolean isDir = Files.isDirectory(path);
//        boolean isReadable = Files.isReadable(path);
//        boolean isHidden = Files.isHidden(path);
//        Path link = Paths.get("link");
//        Path target = Paths.get("target");
//        Files.createSymbolicLink(link, target);
//        Path tempFile = Files.createTempFile("prefix", ".txt"); // Временный файл
//        Path tempDir = Files.createTempDirectory("temp_");      // Временная папка
//
//        long size = Files.size(path); // Размер файла
//        FileTime lastModified = Files.getLastModifiedTime(path);
    }
}
