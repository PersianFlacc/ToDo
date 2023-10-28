import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Tasks> TasksList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Hello! It's your pocket To-Do!");

        loadListFile();

        System.out.println("Choose an action: ");

        boolean running = true;

        while (running) {

            System.out.println("1 - Create a new task");
            System.out.println("2 - Delete task");
            System.out.println("3 - Complete the task");
            System.out.println("4 - Return to task list");
            System.out.println("5 - Save program");

            byte Answer = sc.nextByte();

            switch (Answer) {
                case 1:
                    createTask(TasksList);
                    break;
                case 2:
                    System.out.println("Enter ID task: ");
                    int IdTask = sc.nextInt();
                    TasksList.remove(IdTask);
                    System.out.println("Task removed successfully!");
                    break;
                case 3:
                    System.out.println("Enter ID task: ");
                    int IdTask1 = sc.nextInt();
                    TasksList.remove(IdTask1);
                    System.out.println("Task completed successfully!");
                    break;
                case 4:
                    System.out.println("Your To-Do: ");
                    System.out.println(TasksList);
                    break;
                case 5:
                    saveListFile(TasksList);
                    break;
            }

            System.out.println("Would you like to continue? (y/n)");
            String answer = sc.next();

            if (answer.equalsIgnoreCase("n")) {
                running = false;
            }
        }

        sc.close();

        System.out.println("Thank you for taking advantage of my opportunities! " +
                "You can help the development of the project here:\n https://github.com/PersianFlacc/ToDo");
    }

    private static void saveListFile(ArrayList<Tasks> TasksList) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("tasks.txt", false))){
            String t = "";
            for (int i = 0; i < TasksList.size(); i++){
                t += TasksList.get(i);
            }
            writer.write(t);
            System.out.println("Your To-Do has been successfully saved!");
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    private static void loadListFile() {
        try(BufferedReader reader = new BufferedReader(new FileReader("tasks.txt"))) {
            String task;
            int i = 0;
            while (((task = reader.readLine()) != null)) {
                System.out.println(task);
                i++;
            }
        }catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static ArrayList<Tasks> createTask (ArrayList<Tasks> TasksList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID task: ");
        int IdTask = scanner.nextInt();
        System.out.println("Enter task text: ");
        String TextTask = scanner.next();
        Tasks newTask = new Tasks(IdTask, TextTask);
        TasksList.add(newTask);
        return TasksList;
    }
}