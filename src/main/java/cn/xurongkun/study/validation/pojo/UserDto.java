package cn.xurongkun.study.validation.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * 用户信息传输对象
 * @author xurongkun
 * @version 1.0
 * @date 2019-10-20
 */
@Data
public class UserDto {
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Range(min = 1, max = 99)
    private Integer age;

    @Email(message = "邮箱格式不正确")
    @NotNull(message = "邮箱不能为空")
    private String email;
}
