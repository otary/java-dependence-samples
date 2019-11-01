package cn.chenzw.dependence.dozer.basic.domain;

import org.dozer.Mapping;

import java.util.List;

public class Staff {

    /**
     * 自定义映射的字段
     */
    @Mapping("id")
    private Long sId;

    @Mapping("name")
    private String sName;

    @Mapping("cars")
    private List<Car> cars2;

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public List<Car> getCars2() {
        return cars2;
    }

    public void setCars2(List<Car> cars2) {
        this.cars2 = cars2;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", cars2=" + cars2 +
                '}';
    }
}
