package cn.xurongkun.study.validation.web;

import cn.xurongkun.study.validation.pojo.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author xurongkun
 * @version 1.0
 * @date 2019-10-20
 */
@Slf4j
@RestController
public class UserController {

    /**
     * 如果参数无法通过校验将响应400并告知原因
     * @param userDto
     * @return
     */
    @PostMapping("/user")
    public String addUser(@Valid @RequestBody UserDto userDto) {
        log.info(userDto.toString());

        return "completed";
    }

    /**
     * 果参数无法通过校验需要自己手动处理
     * @param userDto
     * @param result
     * @return
     */
    @PostMapping("/user2")
    public String addUser(@Validated @RequestBody UserDto userDto, BindingResult result) {
        if(result.hasErrors()){
            return "error";
        }
        log.info(userDto.toString());

        return "completed";
    }
}
