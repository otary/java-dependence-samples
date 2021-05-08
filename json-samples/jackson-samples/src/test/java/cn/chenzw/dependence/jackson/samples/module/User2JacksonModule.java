package cn.chenzw.dependence.jackson.samples.module;

import cn.chenzw.dependence.jackson.samples.domain.entity.Address;
import cn.chenzw.dependence.jackson.samples.domain.entity.Employee;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * User对象 => JSON字符串
 *
 * @author chenzw
 */
public class User2JacksonModule extends SimpleModule {


    public void registerModule(ObjectMapper objectMapper) {
        objectMapper.registerModule(this);
    }

    @Override
    public void setupModule(SetupContext context) {
        super.setupModule(context);

        /**
         * 屏蔽掉houseNo字段和空字段
         */
        context.setMixInAnnotations(Address.class, AddressSerializer.class);

        /**
         * 屏蔽salary字段
         */
        context.setMixInAnnotations(Employee.class, EmploySerializer.class);



    }

    @JsonAutoDetect
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    @JsonIgnoreProperties("houseNo")
    private class AddressSerializer {

    }

    @JsonAutoDetect
    @JsonIgnoreProperties("salary")
    private class EmploySerializer {

    }
}
