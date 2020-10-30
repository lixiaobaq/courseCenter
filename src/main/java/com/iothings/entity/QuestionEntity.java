package com.iothings.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @Package： com.iothings.entity
 * @author： ZDL
 * @date： 2020/10/30 11:06
 * @version： V1.0
 * @Description：
 */
@Entity
@Table(name = "question")
@Data
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 题目类型
    private String type;
    //题干
    private String subject;
    //难度
    private String degree;
    //选项数量
    private int itemCounts;

    private String item1;
    private String item2;
    private String item3;
    private String item4;
    private String item5;
    private String item6;
    private String item7;
    private String item8;
    //解析
    private String analyze1;
    //答案
    private String answer;
    //关联知识点
    private String qualificationFramelds;
    private Long createrld ;
    @Column(updatable = false)
    @CreationTimestamp
    private Date createTime;
    @UpdateTimestamp
    private Date modifyTime;

}
