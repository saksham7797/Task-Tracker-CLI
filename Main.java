import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        TaskTracker tsk = new TaskTracker();

        try {
            switch (args[0].toLowerCase()) {
                case "update" -> tsk.update_desc(Integer.parseInt(args[1]), args[2]);
                case "delete" -> tsk.delete(Integer.parseInt(args[1]));
                case "mark" -> tsk.update_prog(Integer.parseInt(args[2]), args[1]);
                case "list" -> {
                    List<Task> arr = tsk.loadData();
                    try {
                        if(args.length == 2) {

                            switch(args[1].toLowerCase()) {
                                case "done" -> {
                                    for (int i = 0; i < arr.size(); i++) {
                                        if(!arr.get(i).progress.equals("done")) {
                                            arr.remove(i);
                                        }
                                    }
                                }
                                case "to-do" -> {
                                    for (int i = 0; i < arr.size(); i++) {
                                        if(!arr.get(i).progress.equals("to-do")) {
                                            arr.remove(i);
                                        }
                                    }
                                }
                                case "in-progress" -> {
                                    for (int i = 0; i < arr.size(); i++) {
                                        if(!arr.get(i).progress.equals("in-progress")) {
                                            arr.remove(i);
                                        }
                                    }
                                
                                }
                                default -> throw new Exception();
                            }
                        }
                    } finally {
                        for (int i = 0; i < arr.size(); i++) {
                            arr.get(i).show();
                        }
                    }
                }
                default -> throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("No/Wrong Input");
        }
    }
}
