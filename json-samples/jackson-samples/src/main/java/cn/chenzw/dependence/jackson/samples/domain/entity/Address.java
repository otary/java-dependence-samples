package cn.chenzw.dependence.jackson.samples.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {

    private String province;

    private String city;

    private String street;

    /***
     * 门牌号
     */
    private String houseNo;

}
