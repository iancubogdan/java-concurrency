package main.com.bogdaniancu.multithreading.learnit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

public class LivelockIssueDemo {

    public static void main(String[] args) {
        Spouse husband = new Spouse("Jack");
        Spouse wife = new Spouse("Jill");

        Spoon spoon = new Spoon(husband);

        new Thread(() -> husband.eatWith(spoon, wife)).start();
        new Thread(() -> wife.eatWith(spoon, husband)).start();

    }

    @AllArgsConstructor
    @Data
    static class Spoon {
        private Spouse owner;

        public synchronized void setOwner(Spouse spouse) {
            owner = spouse;
        }

        public synchronized void use() {
            System.out.printf("%s has eaten", owner.name);
        }
    }


    @Data
    static class Spouse {

        private String name;
        private boolean isHungry;

        public Spouse(String name) {
            this.name = name;
            this.isHungry = true;
        }

        public void eatWith(Spoon spoon, Spouse spouse) {
            while (isHungry) {
                //Don't have the spoon, so wait patiently for the spouse
                if (spoon.owner != this) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        continue;
                    }
                    continue;
                }

                //If spouse is hungry, insist upon passing the spoon
                if (spouse.isHungry) {
                    System.out.printf("%s: You eat first my darling %s!%n", name, spouse.getName());
                    spoon.setOwner(spouse);
                    continue;
                }

                spoon.use();
                isHungry = false;
                System.out.printf("%s: I have eaten", name);
                spoon.setOwner(spouse);
            }
        }
    }
}
