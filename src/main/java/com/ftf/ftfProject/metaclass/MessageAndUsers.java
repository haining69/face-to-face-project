package com.ftf.ftfProject.metaclass;

import com.ftf.ftfProject.entity.Message;
import com.ftf.ftfProject.entity.Users;

import java.io.Serializable;

public class MessageAndUsers implements Serializable {
    private Users users;
    private Message message;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageAndUsers{" +
                "users=" + users +
                ", message=" + message +
                '}';
    }
}
