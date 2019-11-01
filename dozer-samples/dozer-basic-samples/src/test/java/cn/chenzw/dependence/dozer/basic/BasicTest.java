package cn.chenzw.dependence.dozer.basic;

import cn.chenzw.dependence.dozer.basic.domain.Car;
import cn.chenzw.dependence.dozer.basic.domain.Staff;
import cn.chenzw.dependence.dozer.basic.domain.User;
import org.dozer.DozerBeanMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

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


}
