package org.example;

import java.util.List;

public class RegisterSystem {
    public static void main(String[] args) {
        ConnectionFactory.connect();
        RegisterRepository repository = new RegisterRepository();
        Register register = new Register();

        List<Register> listRegister = repository.list();

        Register searchRegister = repository.search(1);
        if(searchRegister != null) {
            System.out.println("Id : " + searchRegister.getId());
            System.out.println("Name : " + searchRegister.getName());
            System.out.println("Age : " + searchRegister.getAge());
        } else {
            System.out.println("Nao foi possivel encontrar um registro com esse id");
        }


//        listRegister = repository.list();
//
//        for(Register registerItem : listRegister) {
//            System.out.println("Id : " + registerItem.getId());
//            System.out.println("Name : " + registerItem.getName());
//            System.out.println("Age : " + registerItem.getAge());
//        }

//
//        register.setName("Marcia Aparecida de araujo");
//        register.setAge(55);
//        register.setId(6);

//        repository.save(register);

//        repository.update(register);

//        repository.remove(5);


//        repository.search(6);

    }
}
