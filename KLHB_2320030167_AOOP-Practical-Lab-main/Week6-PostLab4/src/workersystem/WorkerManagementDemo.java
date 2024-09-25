package workersystem;

public class WorkerManagementDemo {
    public static void main(String[] args) {
        Worker robot = new Robot();
        Worker humanWorker = new Human();
        Eater humanEater = (Eater) humanWorker; // Casting to Eater to demonstrate eating

        demonstrateWorking(robot);
        demonstrateWorking(humanWorker);
        demonstrateEating(humanEater);
    }

    public static void demonstrateWorking(Worker worker) {
        worker.work();
    }

    public static void demonstrateEating(Eater eater) {
        eater.eat();
    }
}


// Casting ----> converting an object from one type to another
// casting humanWorker to Eater allows you to call the eat() method on the Human object, 
// -->demonstrating its ability to perform both working and eating actions.