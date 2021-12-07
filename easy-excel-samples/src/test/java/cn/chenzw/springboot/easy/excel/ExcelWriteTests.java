package cn.chenzw.springboot.easy.excel;

import cn.chenzw.springboot.easy.excel.domain.entity.ScoreSheet1Template;
import cn.chenzw.springboot.easy.excel.domain.entity.User;
import cn.chenzw.springboot.easy.excel.domain.entity.User2;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

@RunWith(JUnit4.class)
public class ExcelWriteTests {


    public List<User> createData() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("张三" + i);
            user.setAge(i);
            user.setBirth(Calendar.getInstance().getTime());
            users.add(user);
        }
        return users;
    }


    public List<User2> createData2() {
        List<User2> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User2 user = new User2();
            user.setName("张三" + i);
            user.setAge(i);
            user.setBirth(Calendar.getInstance().getTime());
            users.add(user);
        }
        return users;
    }

    /**
     * 基础写入
     * @throws FileNotFoundException
     */
    @Test
    public void testWrite() throws FileNotFoundException {
        List<User> users = createData();

        WriteSheet writeSheet = new ExcelWriterBuilder().sheet(0, "默认").head(User.class).build();
        ExcelWriter excelWriter = EasyExcel.write(new FileOutputStream("target/result.xlsx")).build();
        excelWriter.write(users, writeSheet);

        if (excelWriter != null) {
            excelWriter.finish();
        }
    }

    /**
     * 动态头部
     *
     * @throws FileNotFoundException
     */
    @Test
    public void testDynamicHead() throws FileNotFoundException {
        List<User2> users = createData2();

        List<List<String>> heads = Arrays.asList(
                // Arrays.asList("姓名", "年纪", "xxx")
                Arrays.asList("姓名"),
                Arrays.asList("年纪"),
                Arrays.asList("xxx")
        );
        WriteSheet writeSheet = new ExcelWriterBuilder().sheet(0, "默认").head(heads).build();
        ExcelWriter excelWriter = EasyExcel.write(new FileOutputStream("target/result.xlsx")).build();


        List<Map<String, String>> list = new ArrayList<>();
        list.add(new HashMap<String, String>(){
            {
                put("aaa", "tttt");
                put("xxx", "www");
            }
        });

        List<List<String>> collect = list.stream().map((map) -> {
            return map.entrySet().stream().map(entry -> {
                return entry.getValue();
            }).collect(Collectors.toList());
        }).collect(Collectors.toList());


        excelWriter.write(collect, writeSheet);

        if (excelWriter != null) {
            excelWriter.finish();
        }
    }

    @Test
    public void test() throws FileNotFoundException {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            User user = new User();
            user.setName("张三" + i);
            user.setAge(i);
            user.setBirth(Calendar.getInstance().getTime());
            users.add(user);
        }

        WriteSheet writeSheet = new ExcelWriterBuilder().sheet(0, "默认").head(User.class).build();
        ExcelWriter excelWriter = EasyExcel.write(new FileOutputStream("target/result.xlsx")).build();
        excelWriter.write(users, writeSheet);

        if (excelWriter != null) {
            excelWriter.finish();
        }
    }


    /**
     * 根据模版导出
     * @throws FileNotFoundException
     */
    @Test
    public void testExportByTemplate() throws FileNotFoundException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("data/complex2.xlsx");

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("张三");
            user.setAge(i);
            users.add(user);
        }

        // 多个sheet页
        FileOutputStream fos = new FileOutputStream(new File("result.xlsx"));
        WriteSheet writeSheet1 = EasyExcel.writerSheet(0).build();
        WriteSheet writeSheet2 = EasyExcel.writerSheet(1).build();
        ExcelWriter excelWriter = EasyExcel.write(fos).withTemplate(is).build();
        excelWriter.fill(users, writeSheet1);
        excelWriter.fill(users, writeSheet2);

        excelWriter.finish();
    }

    @Test
    public void test3() throws FileNotFoundException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("data/template_var_inp.xlsx");

        List<ScoreSheet1Template> scoreSheet1Templates = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ScoreSheet1Template scoreSheet1Template = new ScoreSheet1Template();
            scoreSheet1Template.setKpiScore1("2.4");
            scoreSheet1Template.setKpiScore2("3.4");
            scoreSheet1Template.setRegionName("四十");
            scoreSheet1Templates.add(scoreSheet1Template);
        }

        FileOutputStream fos = new FileOutputStream(new File("result.xlsx"));
        WriteSheet writeSheet1 = EasyExcel.writerSheet(0).build();
        ExcelWriter excelWriter = EasyExcel.write(fos).withTemplate(is).build();
        excelWriter.fill(scoreSheet1Templates, writeSheet1);

        excelWriter.finish();
    }


}
