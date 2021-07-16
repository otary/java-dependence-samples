package cn.chenzw.springboot.easy.excel;

import cn.chenzw.springboot.easy.excel.domain.entity.ScoreSheet1Listener;
import cn.chenzw.springboot.easy.excel.domain.entity.ScoreSheet1Template;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.InputStream;

@RunWith(JUnit4.class)
public class ExcelReadTests {


    @Test
    public void testSheetDoRead() {
        // 单sheet页异步读
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("data/template.xlsx");
        EasyExcel.read(is, ScoreSheet1Template.class, new ScoreSheet1Listener()).sheet(0).doRead();
    }

    /**
     * 多Sheet读
     */
    @Test
    public void testMultiRead() {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("data/template.xlsx");

        ExcelReader excelReader = null;
        try {
            excelReader = EasyExcel.read(is).build();

            ReadSheet sheet1 = EasyExcel.readSheet(0).head(ScoreSheet1Template.class)
                    .registerReadListener(
                            new ScoreSheet1Listener())
                    .build();

            ReadSheet sheet2 = EasyExcel.readSheet(1).head(ScoreSheet1Template.class)
                    .registerReadListener(
                            new ScoreSheet1Listener())
                    .build();

            excelReader.read(sheet1, sheet2);
        } finally {
            if (excelReader != null) {
                excelReader.finish();
            }
        }
    }

}
