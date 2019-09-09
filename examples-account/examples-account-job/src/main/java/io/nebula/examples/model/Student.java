package io.nebula.examples.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 徐步龙
 * @version V1.0
 * @date 2019/1/14
 */
@Data
public class Student implements Serializable {
    private String name;
    private long age;
}
