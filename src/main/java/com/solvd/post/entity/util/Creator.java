package com.solvd.post.entity.util;

import com.solvd.post.entity.Address;
import com.solvd.post.entity.Department;
import com.solvd.post.entity.Employee;
import com.solvd.post.entity.PostalChain;
import com.solvd.post.entity.enam.Post;
import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class Creator {

    public static PostalChain createPostSystem() {

        PostalChain postalChain = PostalChain.getINSTANCE();

        Employee ivan = new Employee("Ivan", "Ivanov", "MP1112233", Post.OFFICE_WORKER);
        Employee mikhail = new Employee("Mikhail", "Mikhailov", "MP1112234", Post.MANAGER);
        Employee sveta = new Employee("Sveta", "Svetikova", "MP1112235", Post.OFFICE_WORKER);
        Employee anastasia = new Employee("Anastasia", "Mikhailova", "MP1112236", Post.MANAGER);
        Employee alex = new Employee("Alex", "Alexov", "MP1112238", Post.OFFICE_WORKER);
        Employee petr = new Employee("Petr", "Petrov", "MP1112237", Post.MANAGER);
        Employee evgenii = new Employee("Evgenii", "Evgenov", "MP1112239", Post.OFFICE_WORKER);
        Employee sergei = new Employee("Sergei", "Sergeev", "MP1112240", Post.MANAGER);
        Employee anton = new Employee("Anton", "Antonov", "MP1112241", Post.OFFICE_WORKER);
        Employee vasilii = new Employee("Vasilii", "Vasilev", "MP1112242", Post.MANAGER);
        Employee denis = new Employee("Denis", "Denisov", "MP1112243", Post.OFFICE_WORKER);
        Employee karina = new Employee("Karina", "Karinova", "MP1112244", Post.MANAGER);
        Employee gena = new Employee("Gena", "Genov", "MP1112245", Post.OFFICE_WORKER);
        Employee vitala = new Employee("Vitala", "Vitalov", "MP1112246", Post.MANAGER);
        Employee valera = new Employee("Valera", "Valerov", "MP1112247", Post.OFFICE_WORKER);
        Employee marina = new Employee("Marina", "Marinova", "MP1112248", Post.MANAGER);
        Employee pavel = new Employee("Pavel", "Pavelov", "MP1112249", Post.OFFICE_WORKER);
        Employee grigorii = new Employee("Grigorii", "Grigorev", "MP1112250", Post.MANAGER);
        Employee daniil = new Employee("Daniil", "Daniilov", "MP1112251", Post.OFFICE_WORKER);
        Employee egor = new Employee("Egor", "Egorov", "MP1112252", Post.MANAGER);
        Employee igor = new Employee("Igor", "Igorev", "MP1112253", Post.OFFICE_WORKER);
        Employee zahar = new Employee("Zahar", "Zaharov", "MP1112254", Post.MANAGER);
        Employee kirril = new Employee("Kirril", "Kirrilov", "MP1112255", Post.OFFICE_WORKER);
        Employee lev = new Employee("Lev", "Levkov", "MP1112256", Post.MANAGER);

        postalChain.add(new Department(new Address("Belarus", "Minsk", "Lenina", 10, null),
                null, 1.1, Arrays.asList(ivan, mikhail)));
        postalChain.add(new Department(new Address("Belarus", "Borisov", "Ordzhonikidze", 11, null),
                null, 0.9, Arrays.asList(sveta, anastasia)));
        postalChain.add(new Department(new Address("Belarus", "Gomel", "Pravdi", 33, null),
                null, 1.05, Arrays.asList(alex, petr)));
        postalChain.add(new Department(new Address("Belarus", "Brest", "Maskovskaja", 9, null),
                null, 1.05, Arrays.asList(evgenii, sergei)));
        postalChain.add(new Department(new Address("Belarus", "Kobryn", "Lenina", 12, null),
                null, 0.9, Arrays.asList(anton, vasilii)));
        postalChain.add(new Department(new Address("Belarus", "Mazyr", "Haharyna", 15, null),
                null, 0.9, Arrays.asList(denis, karina)));
        postalChain.add(new Department(new Address("Belarus", "Mogilev", "Pijanierskaja", 22, null),
                null, 1.05, Arrays.asList(gena, vitala)));
        postalChain.add(new Department(new Address("Belarus", "Viciebsk", "Chkalava", 41, null),
                null, 1.05, Arrays.asList(valera, marina)));
        postalChain.add(new Department(new Address("Belarus", "Grodna", "Pieramohi", 3, null),
                null, 1.05, Arrays.asList(pavel, grigorii)));
        postalChain.add(new Department(new Address("Belarus", "Polatsk", "Skaryny", 9, null),
                null, 0.95, Arrays.asList(daniil, egor)));
        postalChain.add(new Department(new Address("Belarus", "Baranovichy", "Brestskaya", 37, null),
                null, 0.9, Arrays.asList(igor, zahar)));
        postalChain.add(new Department(new Address("Belarus", "Maladzyechna", "Vilenskaya", 7, null),
                null, 0.95, Arrays.asList(kirril, lev)));

        postalChain.getDepartment(1).getNeighboringBranches().put(postalChain.getDepartment(2), 98);
        postalChain.getDepartment(2).getNeighboringBranches().put(postalChain.getDepartment(1), 98);
        postalChain.getDepartment(1).getNeighboringBranches().put(postalChain.getDepartment(3), 283);
        postalChain.getDepartment(3).getNeighboringBranches().put(postalChain.getDepartment(1), 283);
        postalChain.getDepartment(1).getNeighboringBranches().put(postalChain.getDepartment(4), 343);
        postalChain.getDepartment(4).getNeighboringBranches().put(postalChain.getDepartment(1), 343);
        postalChain.getDepartment(1).getNeighboringBranches().put(postalChain.getDepartment(5), 290);
        postalChain.getDepartment(5).getNeighboringBranches().put(postalChain.getDepartment(1), 290);
        postalChain.getDepartment(1).getNeighboringBranches().put(postalChain.getDepartment(6), 331);
        postalChain.getDepartment(6).getNeighboringBranches().put(postalChain.getDepartment(1), 331);
        postalChain.getDepartment(1).getNeighboringBranches().put(postalChain.getDepartment(7), 184);
        postalChain.getDepartment(7).getNeighboringBranches().put(postalChain.getDepartment(1), 184);
        postalChain.getDepartment(1).getNeighboringBranches().put(postalChain.getDepartment(8), 225);
        postalChain.getDepartment(8).getNeighboringBranches().put(postalChain.getDepartment(1), 225);
        postalChain.getDepartment(1).getNeighboringBranches().put(postalChain.getDepartment(9), 246);
        postalChain.getDepartment(9).getNeighboringBranches().put(postalChain.getDepartment(1), 246);
        postalChain.getDepartment(1).getNeighboringBranches().put(postalChain.getDepartment(10), 335);
        postalChain.getDepartment(10).getNeighboringBranches().put(postalChain.getDepartment(1), 335);
        postalChain.getDepartment(1).getNeighboringBranches().put(postalChain.getDepartment(11), 136);
        postalChain.getDepartment(11).getNeighboringBranches().put(postalChain.getDepartment(1), 136);
        postalChain.getDepartment(1).getNeighboringBranches().put(postalChain.getDepartment(12), 66);
        postalChain.getDepartment(12).getNeighboringBranches().put(postalChain.getDepartment(1), 66);

        postalChain.getDepartment(2).getNeighboringBranches().put(postalChain.getDepartment(3), 381);
        postalChain.getDepartment(3).getNeighboringBranches().put(postalChain.getDepartment(2), 381);
        postalChain.getDepartment(2).getNeighboringBranches().put(postalChain.getDepartment(4), 441);
        postalChain.getDepartment(4).getNeighboringBranches().put(postalChain.getDepartment(2), 441);
        postalChain.getDepartment(2).getNeighboringBranches().put(postalChain.getDepartment(5), 388);
        postalChain.getDepartment(5).getNeighboringBranches().put(postalChain.getDepartment(2), 388);
        postalChain.getDepartment(2).getNeighboringBranches().put(postalChain.getDepartment(6), 429);
        postalChain.getDepartment(6).getNeighboringBranches().put(postalChain.getDepartment(2), 429);
        postalChain.getDepartment(2).getNeighboringBranches().put(postalChain.getDepartment(7), 282);
        postalChain.getDepartment(7).getNeighboringBranches().put(postalChain.getDepartment(2), 282);
        postalChain.getDepartment(2).getNeighboringBranches().put(postalChain.getDepartment(8), 127);
        postalChain.getDepartment(8).getNeighboringBranches().put(postalChain.getDepartment(2), 127);
        postalChain.getDepartment(2).getNeighboringBranches().put(postalChain.getDepartment(9), 344);
        postalChain.getDepartment(9).getNeighboringBranches().put(postalChain.getDepartment(2), 344);
        postalChain.getDepartment(2).getNeighboringBranches().put(postalChain.getDepartment(10), 237);
        postalChain.getDepartment(10).getNeighboringBranches().put(postalChain.getDepartment(2), 237);
        postalChain.getDepartment(2).getNeighboringBranches().put(postalChain.getDepartment(11), 234);
        postalChain.getDepartment(11).getNeighboringBranches().put(postalChain.getDepartment(2), 234);
        postalChain.getDepartment(2).getNeighboringBranches().put(postalChain.getDepartment(12), 164);
        postalChain.getDepartment(12).getNeighboringBranches().put(postalChain.getDepartment(2), 164);

        postalChain.getDepartment(3).getNeighboringBranches().put(postalChain.getDepartment(4), 539);
        postalChain.getDepartment(4).getNeighboringBranches().put(postalChain.getDepartment(3), 539);
        postalChain.getDepartment(3).getNeighboringBranches().put(postalChain.getDepartment(4), 487);
        postalChain.getDepartment(5).getNeighboringBranches().put(postalChain.getDepartment(3), 487);
        postalChain.getDepartment(3).getNeighboringBranches().put(postalChain.getDepartment(6), 141);
        postalChain.getDepartment(6).getNeighboringBranches().put(postalChain.getDepartment(3), 141);
        postalChain.getDepartment(3).getNeighboringBranches().put(postalChain.getDepartment(7), 175);
        postalChain.getDepartment(7).getNeighboringBranches().put(postalChain.getDepartment(3), 175);
        postalChain.getDepartment(3).getNeighboringBranches().put(postalChain.getDepartment(8), 330);
        postalChain.getDepartment(8).getNeighboringBranches().put(postalChain.getDepartment(3), 330);
        postalChain.getDepartment(3).getNeighboringBranches().put(postalChain.getDepartment(9), 594);
        postalChain.getDepartment(9).getNeighboringBranches().put(postalChain.getDepartment(3), 594);
        postalChain.getDepartment(3).getNeighboringBranches().put(postalChain.getDepartment(10), 439);
        postalChain.getDepartment(10).getNeighboringBranches().put(postalChain.getDepartment(3), 439);
        postalChain.getDepartment(3).getNeighboringBranches().put(postalChain.getDepartment(11), 446);
        postalChain.getDepartment(11).getNeighboringBranches().put(postalChain.getDepartment(3), 446);
        postalChain.getDepartment(3).getNeighboringBranches().put(postalChain.getDepartment(12), 396);
        postalChain.getDepartment(12).getNeighboringBranches().put(postalChain.getDepartment(3), 396);

        postalChain.getDepartment(4).getNeighboringBranches().put(postalChain.getDepartment(5), 53);
        postalChain.getDepartment(5).getNeighboringBranches().put(postalChain.getDepartment(4), 53);
        postalChain.getDepartment(4).getNeighboringBranches().put(postalChain.getDepartment(6), 420);
        postalChain.getDepartment(6).getNeighboringBranches().put(postalChain.getDepartment(4), 420);
        postalChain.getDepartment(4).getNeighboringBranches().put(postalChain.getDepartment(7), 540);
        postalChain.getDepartment(7).getNeighboringBranches().put(postalChain.getDepartment(4), 540);
        postalChain.getDepartment(4).getNeighboringBranches().put(postalChain.getDepartment(8), 621);
        postalChain.getDepartment(8).getNeighboringBranches().put(postalChain.getDepartment(4), 621);
        postalChain.getDepartment(4).getNeighboringBranches().put(postalChain.getDepartment(9), 239);
        postalChain.getDepartment(9).getNeighboringBranches().put(postalChain.getDepartment(4), 239);
        postalChain.getDepartment(4).getNeighboringBranches().put(postalChain.getDepartment(10), 592);
        postalChain.getDepartment(10).getNeighboringBranches().put(postalChain.getDepartment(4), 592);
        postalChain.getDepartment(4).getNeighboringBranches().put(postalChain.getDepartment(11), 215);
        postalChain.getDepartment(11).getNeighboringBranches().put(postalChain.getDepartment(4), 215);
        postalChain.getDepartment(4).getNeighboringBranches().put(postalChain.getDepartment(12), 387);
        postalChain.getDepartment(12).getNeighboringBranches().put(postalChain.getDepartment(4), 387);

        //
        postalChain.getDepartment(5).getNeighboringBranches().put(postalChain.getDepartment(6), 365);
        postalChain.getDepartment(6).getNeighboringBranches().put(postalChain.getDepartment(5), 365);
        postalChain.getDepartment(5).getNeighboringBranches().put(postalChain.getDepartment(7), 488);
        postalChain.getDepartment(7).getNeighboringBranches().put(postalChain.getDepartment(5), 488);
        postalChain.getDepartment(5).getNeighboringBranches().put(postalChain.getDepartment(8), 568);
        postalChain.getDepartment(8).getNeighboringBranches().put(postalChain.getDepartment(5), 568);
        postalChain.getDepartment(5).getNeighboringBranches().put(postalChain.getDepartment(9), 207);
        postalChain.getDepartment(9).getNeighboringBranches().put(postalChain.getDepartment(5), 207);
        postalChain.getDepartment(5).getNeighboringBranches().put(postalChain.getDepartment(10), 539);
        postalChain.getDepartment(10).getNeighboringBranches().put(postalChain.getDepartment(5), 539);
        postalChain.getDepartment(5).getNeighboringBranches().put(postalChain.getDepartment(11), 166);
        postalChain.getDepartment(11).getNeighboringBranches().put(postalChain.getDepartment(5), 166);
        postalChain.getDepartment(5).getNeighboringBranches().put(postalChain.getDepartment(12), 338);
        postalChain.getDepartment(12).getNeighboringBranches().put(postalChain.getDepartment(5), 338);

        postalChain.getDepartment(6).getNeighboringBranches().put(postalChain.getDepartment(7), 263);
        postalChain.getDepartment(7).getNeighboringBranches().put(postalChain.getDepartment(6), 263);
        postalChain.getDepartment(6).getNeighboringBranches().put(postalChain.getDepartment(8), 434);
        postalChain.getDepartment(8).getNeighboringBranches().put(postalChain.getDepartment(6), 434);
        postalChain.getDepartment(6).getNeighboringBranches().put(postalChain.getDepartment(9), 499);
        postalChain.getDepartment(9).getNeighboringBranches().put(postalChain.getDepartment(6), 499);
        postalChain.getDepartment(6).getNeighboringBranches().put(postalChain.getDepartment(10), 464);
        postalChain.getDepartment(10).getNeighboringBranches().put(postalChain.getDepartment(6), 464);
        postalChain.getDepartment(6).getNeighboringBranches().put(postalChain.getDepartment(11), 316);
        postalChain.getDepartment(11).getNeighboringBranches().put(postalChain.getDepartment(6), 316);
        postalChain.getDepartment(6).getNeighboringBranches().put(postalChain.getDepartment(12), 370);
        postalChain.getDepartment(12).getNeighboringBranches().put(postalChain.getDepartment(6), 370);

        postalChain.getDepartment(7).getNeighboringBranches().put(postalChain.getDepartment(8), 160);
        postalChain.getDepartment(8).getNeighboringBranches().put(postalChain.getDepartment(7), 160);
        postalChain.getDepartment(7).getNeighboringBranches().put(postalChain.getDepartment(9), 480);
        postalChain.getDepartment(9).getNeighboringBranches().put(postalChain.getDepartment(7), 480);
        postalChain.getDepartment(7).getNeighboringBranches().put(postalChain.getDepartment(10), 266);
        postalChain.getDepartment(10).getNeighboringBranches().put(postalChain.getDepartment(7), 266);
        postalChain.getDepartment(7).getNeighboringBranches().put(postalChain.getDepartment(11), 334);
        postalChain.getDepartment(11).getNeighboringBranches().put(postalChain.getDepartment(7), 334);
        postalChain.getDepartment(7).getNeighboringBranches().put(postalChain.getDepartment(12), 282);
        postalChain.getDepartment(12).getNeighboringBranches().put(postalChain.getDepartment(7), 282);

        postalChain.getDepartment(8).getNeighboringBranches().put(postalChain.getDepartment(9), 549);
        postalChain.getDepartment(9).getNeighboringBranches().put(postalChain.getDepartment(8), 549);
        postalChain.getDepartment(8).getNeighboringBranches().put(postalChain.getDepartment(10), 110);
        postalChain.getDepartment(10).getNeighboringBranches().put(postalChain.getDepartment(8), 110);
        postalChain.getDepartment(8).getNeighboringBranches().put(postalChain.getDepartment(11), 413);
        postalChain.getDepartment(11).getNeighboringBranches().put(postalChain.getDepartment(8), 413);
        postalChain.getDepartment(8).getNeighboringBranches().put(postalChain.getDepartment(12), 286);
        postalChain.getDepartment(11).getNeighboringBranches().put(postalChain.getDepartment(8), 286);

        postalChain.getDepartment(9).getNeighboringBranches().put(postalChain.getDepartment(10), 458);
        postalChain.getDepartment(10).getNeighboringBranches().put(postalChain.getDepartment(9), 458);
        postalChain.getDepartment(9).getNeighboringBranches().put(postalChain.getDepartment(11), 215);
        postalChain.getDepartment(11).getNeighboringBranches().put(postalChain.getDepartment(9), 215);
        postalChain.getDepartment(9).getNeighboringBranches().put(postalChain.getDepartment(12), 239);
        postalChain.getDepartment(12).getNeighboringBranches().put(postalChain.getDepartment(9), 239);

        postalChain.getDepartment(10).getNeighboringBranches().put(postalChain.getDepartment(11), 383);
        postalChain.getDepartment(11).getNeighboringBranches().put(postalChain.getDepartment(10), 383);
        postalChain.getDepartment(10).getNeighboringBranches().put(postalChain.getDepartment(12), 224);
        postalChain.getDepartment(12).getNeighboringBranches().put(postalChain.getDepartment(10), 224);

        postalChain.getDepartment(11).getNeighboringBranches().put(postalChain.getDepartment(11), 184);
        postalChain.getDepartment(12).getNeighboringBranches().put(postalChain.getDepartment(9), 184);

        return postalChain;
    }
}
