package cn.chenzw.dependence.dozer.basic;

import cn.chenzw.dependence.dozer.basic.domain.Car;
import cn.chenzw.dependence.dozer.basic.domain.Staff;
import cn.chenzw.dependence.dozer.basic.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.dozer.CustomFieldMapper;
import org.dozer.DozerBeanMapper;
import org.dozer.DozerConverter;
import org.dozer.classmap.ClassMap;
import org.dozer.fieldmap.FieldMap;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单的属性映射
 * 复杂类型映射
 * String -> Map
 * String -> Complex Type（复杂类型，必须包含String构造器）
 * 双向映射
 * List <=> List
 * List <=> Array
 * Array <=> Array
 * Set <=> Set
 * Set <=> Array
 * Set <=> List
 * 隐式显式的映射
 * 递归映射
 */
@Slf4j
@RunWith(JUnit4.class)
public class BasicTest {


    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    /**
     * 使用@Mapping注解映射字段
     */
    @Test
    public void testMapping() {

        User user = new User();
        user.setId(1L);
        user.setName("张三");

        List<Car> cars = new ArrayList<>();
        Car car = new Car();
        car.setBrand("法拉利");
        cars.add(car);
        user.setCars(cars);

        Staff staff = dozerBeanMapper.map(user, Staff.class);

        Assert.assertEquals(staff.toString(), "Staff{sId=1, sName='张三', cars2=[Car{brand='法拉利'}]}");

    }

    /**
     * 自定义字段转换
     */
    @Test
    public void testCustFieldMapper() {

        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.setCustomFieldMapper(new CustomFieldMapper() {
            @Override
            public boolean mapField(Object source, Object destination, Object sourceFieldValue, ClassMap classMap, FieldMap fieldMapping) {
                // name字段不进行映射
                if ("name".equals(fieldMapping.getSrcFieldName())) {
                    return true;
                }
                log.info("source => {}", source);
                log.info("destination => {}", destination);
                log.info("sourceFieldValue => {}", sourceFieldValue);
                log.info("fieldMapping => {}", fieldMapping);
                return false;
            }
        });

        User user = new User();
        user.setId(1L);
        user.setName("张三");
        Staff staff = dozerBeanMapper.map(user, Staff.class);

        log.info("结果==> {}", staff);
    }

    /**
     * 自定义类型映射转换器
     */
    @Test
    public void testDozerConverter() {
        // DozerConverter
    }


}
