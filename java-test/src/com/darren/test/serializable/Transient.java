package com.darren.test.serializable;

import java.io.Serializable;
//Java的serialization提供了一种持久化对象实例的机制。当持久化对象时，可能有一个特殊的对象数据成员，我们不想用serialization机制来保存它。
//为了在一个特定对象的一个域上关闭serialization，可以在这个域前加上关键字transient。   
//transient是Java语言的关键字，用来表示一个域不是该对象串行化的一部分。
//当一个对象被串行化的时候，transient型变量的值不包括在串行化的表示中，然而非transient型的变量是被包括进去的。

public class Transient implements Serializable {
    private static final long serialVersionUID = 8725475784100780639L;
    private String userName;
    private transient String password;
    private transient String description;

    public Transient(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.description = "I'm Darren!";
    }

    @Override
    public String toString() {
        if (this.password == null) {
            this.password = "NOT SET PASSWORD!";
        }
        if (this.description == null) {
            this.description = "NOT SET DESCRIPTION!";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("User:").append("[");
        builder.append("userName = ").append(this.userName).append(", ");
        builder.append("password = ").append(this.password).append(", ");
        builder.append("description = ").append(this.description);
        builder.append("]");

        return builder.toString();
    }
}
