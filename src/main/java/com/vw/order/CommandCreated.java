package com.vw.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

/**
 * @author firoz
 * @since 29/06/16
 */
@Getter
@AllArgsConstructor
public class CommandCreated {

    private Date created;

    public CommandCreated(){
        this(new Date());
    }
}
