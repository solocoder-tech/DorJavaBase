import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * whw(what,how,why):
 * java.io.File: 文件和文件目录路径的抽象表示形式
 * File能 新建、删除、重命名文件和目录，但是File不能访问文件内容本身，需要IO来访问
 * <p>
 * 常见构造方法;
 * public File(String pathname); 可以是相对路径或者绝对路径
 * public File(String parent, String child);
 * public File(File parent,String child);
 */
public class FileDemo {
    /**
     * 构造器测试
     * 内存级别，不涉及到硬件
     */
    @Test
    public void testFile() {
        File file1 = new File("hello.txt");
        File file2 = new File("./src/test", "hi.txt");
        File file3 = new File("G:\\study\\DorJavaBase\\IODemo\\src\\hello.txt");
        File file4 = new File("G:\\study\\DorJavaBase\\IODemo\\src", "hello.txt");
        System.out.println(file1);
        System.out.println(file2);
        System.out.println(file3);
        System.out.println(file4);
        //默认相对路径位置
        Properties properties = System.getProperties();
        String property = properties.getProperty("user.dir");
        System.out.println(property);
    }

    /**
     * 获取方法测试：
     * public String getAbsolutePath()：获取绝对路径
     * public String getPath() ：获取路径
     * public String getName() ：获取名称
     * public String getParent()：获取上层文件目录路径。若无，返回null
     * public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
     * public long lastModified() ：获取最后一次的修改时间，毫秒值
     * public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
     * public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
     */
    @Test
    public void testFile2() {
        //此时还是内存层面的调用，没有涉及磁盘
        File file1 = new File("hello.txt");
        File file2 = new File("G:\\study\\DorJavaBase\\IODemo\\test2.txt");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());

        System.out.println();
        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(new Date(file2.lastModified()));

        File file = new File("./");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }

        File[] files = file.listFiles();
        for (File file3 : files) {
            System.out.println(file3.getAbsolutePath());
        }
    }

    /**
     * 1. 利用File构造器，new 一个文件目录file
     * 1)在其中创建多个文件和目录
     * 2)编写方法，实现删除file中指定文件的操作
     */
    @Test
    public void test1() throws IOException {
        File file = new File("aaa");
        if (!file.exists()) {
            file.mkdir();
        }
        //aaa中创建文件夹和文件
        File file1 = new File(file,"bbb");
        File file2 = new File(file,"hello.txt");


        if (!file1.exists()) {
            file1.mkdir();
        }

        if (!file2.exists()){
            file2.createNewFile();
        }

        File file3 = new File(file,"bbb/ccc/ddd");
        if (!file3.exists()){
            file3.mkdirs();
        }

        file2.delete();

        file3.delete();
    }
}

