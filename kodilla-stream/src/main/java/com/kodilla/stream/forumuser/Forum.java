/*W tym samym pakiecie napisz klasę Forum, która będzie zawierała listę użytkowników, czyli listę obiektów ForumUser.
Klasa Forum powinna udostępniać metodę getUserList(), która będzie zwracała kolekcję z użytkownika forum*/

package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public class Forum {

    private List<ForumUser> forumUserList = new ArrayList<>();

    public List<ForumUser> getUserList() {
        return new ArrayList<>(forumUserList);
    }

    public void addUser(ForumUser forumUser) {
        forumUserList.add(forumUser);
    }
}


