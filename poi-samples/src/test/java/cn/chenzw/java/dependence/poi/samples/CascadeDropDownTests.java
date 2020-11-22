package cn.chenzw.java.dependence.poi.samples;

import cn.chenzw.toolkit.commons.ProjectUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 级联下拉
 *
 * @author chenzw
 */
@RunWith(JUnit4.class)
public class CascadeDropDownTests {


    @Test
    public void testCreateStoreInExcelTemplate() throws IOException {
        List<String> headers = Arrays.asList("设备名称", "设类型", "数量", "存放库房", "存放货架", "存放层", "存放列");
        List<String> deviceTypes = Arrays.asList("type1", "type2", "type3", "type4");
        List<String> devices = Arrays.asList("设备1", "设备2", "设备3");
        List<String> warehouses = Arrays.asList("库房1", "库房2");
        Map<String, List<String>> warehousesAndShelves = new HashMap<>();
        warehousesAndShelves.put("库房1", Arrays.asList("货架1-1", "货架1-2", "货架1-3"));
        warehousesAndShelves.put("库房2", Arrays.asList("货架2-1", "货架2-2", "货架2-3"));

       ExcelTemplate.createStoreInExcelTemplate(ProjectUtils.getRootPath() + "/template.xlsx", headers, devices, deviceTypes, warehouses, warehousesAndShelves);

    }


    @Test
    public void test() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("sheet_1");
        //sheet.addValidationData();

        HSSFSheet dropDownDataSheet = workbook.createSheet("下拉数据Sheet");
        for (int i = 0; i < 5; i++) {
            HSSFRow row = dropDownDataSheet.createRow(i);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue("功能" + i);
        }

        workbook.write(new File(ProjectUtils.getRootPath() + "/t.xlsx"));

    }



}
