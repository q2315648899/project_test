package cn.itcast.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private Integer id;
    private String title;
    private Double price;
    private Integer num;
    private Long categoryId;
    private String status;
    private String sellerId;
    private Date createTime;
    private Date updateTime;

}
