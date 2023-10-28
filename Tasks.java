public class Tasks {

    private String TextTask;
    private int IdTask;

    public Tasks(int idTask, String textTask) {
        IdTask = idTask;
        TextTask = textTask;
    }

    public Tasks() {
    }

    public String getTextTask() {
        return TextTask;
    }

    public void setTextTask(String textTask) {
        TextTask = textTask;
    }

    public int getIdTask() {
        return IdTask;
    }

    public void setIdTask(int idTask) {
        IdTask = idTask;
    }

    @Override
    public String toString() {
        return IdTask + ". " + TextTask + " (Not completed)" + "\n";
    }
}
