package top.kjwang.boot.domain;

import lombok.Data;

/**
 * @author kjwang
 * @Date 2023/3/14 13:57
 */

@Data
public class Pet {
    private String type;
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
