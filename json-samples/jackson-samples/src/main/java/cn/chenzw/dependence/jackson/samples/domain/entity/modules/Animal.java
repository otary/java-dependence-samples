package cn.chenzw.dependence.jackson.samples.domain.entity.modules;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

/**
 * 自动映射类（根据type字段值转换不同的类型）
 *
 * @author chenzw
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Cat.class, name = Animal.TYPE_CAT),
        @JsonSubTypes.Type(value = Dog.class, name = Animal.TYPE_DOG)
})
@Data
public abstract class Animal {

    public static final String TYPE_CAT = "cat";
    public static final String TYPE_DOG = "dog";

    private String name;

    private String type;

}
