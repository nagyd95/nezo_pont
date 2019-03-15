package com.nezopont.web.DTO;

import javax.validation.constraints.NotEmpty;

public class MessageDTO {

    @NotEmpty
    private String name;

    @NotEmpty
    private String msg;

    public MessageDTO(@NotEmpty String name, @NotEmpty String msg) {

        this.name = name;
        this.msg = msg;
    }

    public MessageDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
