package cn.chenzw.springboot.easy.excel;

import cn.chenzw.springboot.easy.excel.domain.entity.User;
import cn.chenzw.springboot.easy.excel.domain.entity.User2;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

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
        excelWriter.write(users, writeSheet);

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


}